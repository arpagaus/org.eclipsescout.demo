package org.eclipse.scout.rt.demo.client.ui.forms;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.demo.client.ui.forms.LabelWizardForegroundColorForm.MainBox.GroupBox;
import org.eclipse.scout.rt.demo.client.ui.forms.LabelWizardForegroundColorForm.MainBox.GroupBox.ForegroundColorField;
import org.eclipse.scout.rt.shared.TEXTS;

public class LabelWizardForegroundColorForm extends AbstractForm {

  public LabelWizardForegroundColorForm() throws ProcessingException {
    super();
  }

  public void startWizard() throws ProcessingException {
    startInternal(new WizardHandler());
  }

  public ForegroundColorField getForegroundColorField() {
    return getFieldByClass(ForegroundColorField.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class GroupBox extends AbstractGroupBox {

      @Override
      protected boolean getConfiguredGridUseUiWidth() {
        return true;
      }

      @Order(10.0)
      public class ForegroundColorField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ForegroundColor");
        }

        @Override
        protected String execValidateValue(String rawValue) throws ProcessingException {
          clearErrorStatus();
          if (!rawValue.matches("[0-9A-Fa-f]{6}")) {
            this.setErrorStatus("\"" + rawValue + "\" " + TEXTS.get("NoColor"));
          }
          return rawValue;
        }
      }
    }
  }

  public class WizardHandler extends AbstractFormHandler {
  }
}
