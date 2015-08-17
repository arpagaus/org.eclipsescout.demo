package org.eclipsescout.demo.minicrm.client.extension;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.scout.rt.shared.extension.IExtensionRegistry;
import org.eclipse.scout.service.SERVICES;
import org.eclipsescout.demo.minicrm.client.extension.ui.desktop.outlines.pages.PersonTablePageTableExtension;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.CompanyForm;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.eclipsescout.demo.minicrm.client.extension";

  // The shared instance
  private static Activator plugin;

  /**
   * The constructor
   */
  public Activator() {
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;

    SERVICES.getService(IExtensionRegistry.class).register(PersonTablePageTableExtension.class);
    SERVICES.getService(IExtensionRegistry.class).registerMove(CompanyForm.MainBox.ShortNameField.class, 5.0);
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

}
