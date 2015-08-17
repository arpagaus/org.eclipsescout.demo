/**
 *
 */
package org.eclipsescout.demo.minicrm.client.extension;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.extension.IExtensionRegistry;
import org.eclipse.scout.service.AbstractService;
import org.eclipse.scout.service.SERVICES;
import org.eclipsescout.demo.minicrm.client.IClientStartupService;
import org.eclipsescout.demo.minicrm.client.extension.ui.desktop.outlines.pages.PersonTablePageTableExtension;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.CompanyForm;

/**
 * @author rar
 */
public class ExtensionClientStartupService extends AbstractService implements IClientStartupService {

  @Override
  public void init() throws ProcessingException {
    SERVICES.getService(IExtensionRegistry.class).register(PersonTablePageTableExtension.class);
    SERVICES.getService(IExtensionRegistry.class).registerMove(CompanyForm.MainBox.ShortNameField.class, 5.0);
  }

}
