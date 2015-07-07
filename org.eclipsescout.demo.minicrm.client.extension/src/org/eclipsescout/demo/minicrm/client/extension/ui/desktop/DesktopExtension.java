package org.eclipsescout.demo.minicrm.client.extension.ui.desktop;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktopExtension;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipsescout.demo.minicrm.client.extension.ui.desktop.outlines.ExtensionOutline;

public class DesktopExtension extends AbstractDesktopExtension {
  public DesktopExtension() {
  }

  @Override
  protected List<Class<? extends IOutline>> getConfiguredOutlines() {
    List<Class<? extends IOutline>> outlines = new ArrayList<Class<? extends IOutline>>();
    outlines.add(ExtensionOutline.class);
    return outlines;
  }

  @Order(1000.0)
  public class ExtensionOutlineViewButton extends AbstractOutlineViewButton {

    /**
     * 
     */
    public ExtensionOutlineViewButton() {
      super(getCoreDesktop(), ExtensionOutline.class);
    }
  }
}
