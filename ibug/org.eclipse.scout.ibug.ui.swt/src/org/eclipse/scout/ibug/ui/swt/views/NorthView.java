package org.eclipse.scout.ibug.ui.swt.views;

import org.eclipse.scout.ibug.ui.swt.Activator;
import org.eclipse.scout.rt.ui.swt.ISwtEnvironment;
import org.eclipse.scout.rt.ui.swt.window.desktop.view.AbstractScoutView;

public class NorthView extends AbstractScoutView {

  public NorthView() {
  }

  @Override
  protected ISwtEnvironment getSwtEnvironment() {
    return Activator.getDefault().getEnvironment();
  }
}