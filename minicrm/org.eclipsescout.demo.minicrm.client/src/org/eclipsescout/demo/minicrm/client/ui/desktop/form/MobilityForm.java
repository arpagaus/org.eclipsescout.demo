/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.minicrm.client.ui.desktop.form;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.radiobuttongroup.AbstractRadioButtonGroup;
import org.eclipse.scout.rt.extension.client.ui.form.fields.button.AbstractExtensibleRadioButton;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CancelButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryGroup;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryGroup.OwnVehicleButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryGroup.PedestrianButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryGroup.PublicTransportButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.OkButton;
import org.eclipsescout.demo.minicrm.shared.services.code.OwnVehicleCodeType;
import org.eclipsescout.demo.minicrm.shared.services.code.PedestrianCodeType;
import org.eclipsescout.demo.minicrm.shared.services.code.PublicTransportCodeType;

/**
 *
 */
public class MobilityForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public MobilityForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Mobility");
  }

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public void startModify() throws ProcessingException {
    startInternal(new ModifyHandler());
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public CategoryGroup getCategoryGroup() {
    return getFieldByClass(CategoryGroup.class);
  }

  public CommuteBox getCommuteBox() {
    return getFieldByClass(CommuteBox.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  public OwnVehicleButton getOwnVehicleButton() {
    return getFieldByClass(OwnVehicleButton.class);
  }

  public PedestrianButton getPedestrianButton() {
    return getFieldByClass(PedestrianButton.class);
  }

  public PublicTransportButton getPublicTransportButton() {
    return getFieldByClass(PublicTransportButton.class);
  }

  @Order(1000.0)
  public class MainBox extends AbstractGroupBox {

    @Order(1000.0)
    public class CommuteBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Commute");
      }

      @Order(1000.0)
      public class CategoryGroup extends AbstractRadioButtonGroup<Long> {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Category");
        }

        @Order(10.0)
        public class PedestrianButton extends AbstractExtensibleRadioButton<Long> {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Pedestrian");
          }

          @Override
          protected Long getConfiguredRadioValue() {
            return PedestrianCodeType.ID;
          }
        }

        @Order(20.0)
        public class OwnVehicleButton extends AbstractExtensibleRadioButton<Long> {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("OwnVehicle");
          }

          @Override
          protected Long getConfiguredRadioValue() {
            return OwnVehicleCodeType.ID;
          }
        }

        @Order(30.0)
        public class PublicTransportButton extends AbstractExtensibleRadioButton<Long> {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("PublicTransport");
          }

          @Override
          protected Long getConfiguredRadioValue() {
            return PublicTransportCodeType.ID;
          }
        }
      }
    }

    @Order(100000.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(101000.0)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {
  }
}
