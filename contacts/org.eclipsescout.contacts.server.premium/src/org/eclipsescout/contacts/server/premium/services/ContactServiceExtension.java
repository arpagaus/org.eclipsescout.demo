/**
 *
 */
package org.eclipsescout.contacts.server.premium.services;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.contacts.server.services.ContactService;
import org.eclipsescout.contacts.shared.ContactFormData;
import org.eclipsescout.contacts.shared.premium.ui.forms.ContactFormTabExtensionData;
import org.eclipsescout.contacts.shared.services.IContactService;

/**
 * @author mzi
 */
public class ContactServiceExtension extends ContactService implements IContactService {

  @Override
  public ContactFormData load(ContactFormData formData) throws ProcessingException {
    formData = super.load(formData);

    ContactFormTabExtensionData extensionData = formData.getContribution(ContactFormTabExtensionData.class);
    SQL.selectInto(TEXTS.get("SqlContactEventsSelect"), extensionData, formData);

    return formData;
  }

}
