/**
 *
 */
package org.eclipsescout.demo.minicrm.client.extension.ui.desktop.outlines.pages;

import java.util.Set;

import org.eclipse.scout.commons.CollectionUtility;
import org.eclipse.scout.commons.StringUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.extension.ui.basic.table.AbstractTableExtension;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.messagebox.MessageBox;
import org.eclipse.scout.rt.extension.client.ui.action.menu.AbstractExtensibleMenu;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.minicrm.client.ui.desktop.outlines.pages.PersonTablePage;
import org.eclipsescout.demo.minicrm.client.ui.desktop.outlines.pages.PersonTablePage.Table;

public class PersonTablePageTableExtension extends AbstractTableExtension<PersonTablePage.Table> {

  /**
   * @param owner
   */
  public PersonTablePageTableExtension(Table owner) {
    super(owner);
  }

  @Order(20.0)
  public class ShowPersonMenu extends AbstractExtensibleMenu {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("ShowPerson");
    }

    @Override
    protected Set<? extends IMenuType> getConfiguredMenuTypes() {
      return CollectionUtility.hashSet(TableMenuType.SingleSelection);
    }

    @Override
    protected void execAction() throws ProcessingException {
      String text = StringUtility.join(", ", getOwner().getFirstNameColumn().getSelectedDisplayText(), getOwner().getLastNameColumn().getSelectedDisplayText());
      MessageBox.showOkMessage("Person", null, text);
    }
  }
}
