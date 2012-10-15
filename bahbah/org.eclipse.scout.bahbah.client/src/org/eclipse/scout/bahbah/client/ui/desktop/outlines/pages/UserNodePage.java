package org.eclipse.scout.bahbah.client.ui.desktop.outlines.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.scout.bahbah.client.ClientSession;
import org.eclipse.scout.bahbah.client.services.BuddyIconProviderService;
import org.eclipse.scout.bahbah.client.ui.forms.ChatForm;
import org.eclipse.scout.bahbah.shared.services.outline.IStandardOutlineService;
import org.eclipse.scout.bahbah.shared.services.process.IIconProcessService;
import org.eclipse.scout.commons.IOUtility;
import org.eclipse.scout.commons.StringUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.basic.cell.Cell;
import org.eclipse.scout.rt.client.ui.basic.filechooser.FileChooser;
import org.eclipse.scout.rt.client.ui.basic.tree.ITreeNode;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.service.SERVICES;

public class UserNodePage extends AbstractPageWithNodes {

  @Override
  protected boolean getConfiguredExpanded() {
    return true;
  }

  @Override
  protected String getConfiguredIconId() {
    return BuddyIconProviderService.BUDDY_ICON_PREFIX + ClientSession.get().getUserId();
  }

  @Override
  protected boolean getConfiguredTableVisible() {
    return false;
  }

  @Override
  protected String getConfiguredTitle() {
    return ClientSession.get().getUserId();
  }

  @Override
  protected void execDecorateCell(Cell cell) {
    cell.setIconId(getConfiguredIconId());
  }

  public ChatForm getChatForm(String buddy) throws ProcessingException {
    if (StringUtility.isNullOrEmpty(buddy)) {
      return null;
    }

    for (ITreeNode node : getChildNodes()) {
      BuddyNodePage buddyNode = (BuddyNodePage) node;
      if (buddyNode.getName().equals(buddy)) {
        return buddyNode.getChatForm();
      }
    }
    return null;
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
    String[] buddies = SERVICES.getService(IStandardOutlineService.class).getOnlineUsers();
    for (String buddy : buddies) {
      BuddyNodePage buddyPage = new BuddyNodePage();
      buddyPage.setName(buddy);
      pageList.add(buddyPage);
    }
  }

  @SuppressWarnings("unchecked")
  public void updateBuddyPages() throws ProcessingException {
    HashSet<String> newBuddy = new HashSet();
    ArrayList<String> updatedList = new ArrayList();
    String[] buddies = SERVICES.getService(IStandardOutlineService.class).getOnlineUsers();

    for (String buddy : buddies) {
      newBuddy.add(buddy);
    }

    // keep track of known buddies and remove buddies that are no longer here
    for (IPage page : getChildPages()) {
      BuddyNodePage buddyPage = (BuddyNodePage) page;

      if (newBuddy.contains(buddyPage.getName())) {
        updatedList.add(buddyPage.getName());
      }
      else {
        getTree().removeChildNode(this, buddyPage);
      }
    }

    // add new buddies
    for (String buddy : newBuddy) {
      if (!updatedList.contains(buddy)) {
        BuddyNodePage buddyPage = new BuddyNodePage();
        buddyPage.setName(buddy);
        getTree().addChildNode(this, buddyPage);
      }
    }
  }

  @Order(10.0)
  public class ChangeIconMenu extends AbstractMenu {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("ChangeIcon");
    }

    @Override
    protected void execAction() throws ProcessingException {
      FileChooser chooser = new FileChooser(null, null, true);
      File[] files = chooser.startChooser();

      if (files.length > 0) {
        try {
          byte[] content = IOUtility.getContent(new FileInputStream(files[0]), true);
          SERVICES.getService(IIconProcessService.class).saveIcon(ClientSession.get().getUserId(), content);
          getParentPage().reloadPage();
        }
        catch (Throwable e) {
          // nop
        }
      }
    }
  }
}
