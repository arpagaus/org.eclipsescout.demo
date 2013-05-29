package org.eclipsescout.demo.minicrm.ui.swt.views;

import org.eclipse.scout.rt.ui.swt.ISwtEnvironment;
import org.eclipse.scout.rt.ui.swt.window.desktop.view.AbstractScoutView;
import org.eclipsescout.demo.minicrm.ui.swt.Activator;

public class CenterView extends AbstractScoutView {

  public CenterView() {
  }

  @Override
  protected ISwtEnvironment getSwtEnvironment() {
    return Activator.getDefault().getEnvironment();
  }
}
