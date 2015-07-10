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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractSmartColumn;
import org.eclipse.scout.rt.client.ui.basic.tree.ITreeNode;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.IValueField;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.radiobuttongroup.AbstractRadioButtonGroup;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;
import org.eclipse.scout.rt.client.ui.form.fields.treebox.AbstractTreeBox;
import org.eclipse.scout.rt.extension.client.ui.basic.table.AbstractExtensibleTable;
import org.eclipse.scout.rt.extension.client.ui.form.fields.button.AbstractExtensibleRadioButton;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.data.basic.FontSpec;
import org.eclipse.scout.rt.shared.services.common.code.CODES;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;
import org.eclipse.scout.rt.shared.services.lookup.ILookupRow;
import org.eclipsescout.demo.minicrm.client.services.lookup.ModelLookupCall;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CancelButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryField;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryField.OwnVehicleButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryField.PedestrianButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.CommuteBox.CategoryField.PublicTransportButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.DetailsBox;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.DetailsBox.AddToSelectionButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.DetailsBox.ModelField;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.MeansOfTransportBox;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.MeansOfTransportBox.TypeField;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.OkButton;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.SelectionBox;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.SelectionBox.SelectionTableField;
import org.eclipsescout.demo.minicrm.client.ui.desktop.form.MobilityForm.MainBox.SelectionBox.SelectionTableField.Table;
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

  public AddToSelectionButton getAddToSelectionButton() {
    return getFieldByClass(AddToSelectionButton.class);
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public CategoryField getCategoryField() {
    return getFieldByClass(CategoryField.class);
  }

  public CommuteBox getCommuteBox() {
    return getFieldByClass(CommuteBox.class);
  }

  public DetailsBox getDetailsBox() {
    return getFieldByClass(DetailsBox.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public MeansOfTransportBox getMeansOfTransportBox() {
    return getFieldByClass(MeansOfTransportBox.class);
  }

  public ModelField getModelField() {
    return getFieldByClass(ModelField.class);
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

  public SelectionBox getSelectionBox() {
    return getFieldByClass(SelectionBox.class);
  }

  public SelectionTableField getSelectionTableField() {
    return getFieldByClass(SelectionTableField.class);
  }

  public TypeField getTypeField() {
    return getFieldByClass(TypeField.class);
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
      public class CategoryField extends AbstractRadioButtonGroup<Long> {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Category");
        }

        @Override
        protected void execInitField() throws ProcessingException {
          super.execInitField();
          setValue(OwnVehicleCodeType.ID);
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

    @Order(2000.0)
    public class MeansOfTransportBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("MeansOfTransport");
      }

      @Order(1000.0)
      public class TypeField extends AbstractSmartField<Long> {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Type");
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return MobilityForm.MainBox.CommuteBox.CategoryField.class;
        }

        @Override
        protected boolean getConfiguredMasterRequired() {
          return true;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void execChangedMasterValue(Object newMasterValue) throws ProcessingException {
          super.execChangedMasterValue(newMasterValue);
          ICodeType<Object, ?> codeType = CODES.findCodeTypeById(newMasterValue);
          Class<? extends ICodeType<?, Long>> codeTypeClass = (Class<? extends ICodeType<?, Long>>) codeType.getClass();

          setValue(null);
          setCodeTypeClass(codeTypeClass);

          Table selectionTable = getSelectionTableField().getTable();
          selectionTable.deleteAllRows();
          selectionTable.getModelColumn().setCodeTypeClass(codeTypeClass);
        }

        @Override
        protected void execFilterLookupResult(ILookupCall<Long> call, List<ILookupRow<Long>> result) throws ProcessingException {
          super.execFilterLookupResult(call, result);

          Iterator<ILookupRow<Long>> iterator = result.iterator();
          while (iterator.hasNext()) {
            if (iterator.next().getParentKey() != null) {
              iterator.remove();
            }
          }
        }
      }
    }

    @Order(3000.0)
    public class DetailsBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Details");
      }

      @Override
      protected Class<? extends IValueField> getConfiguredMasterField() {
        return MobilityForm.MainBox.MeansOfTransportBox.TypeField.class;
      }

      @Override
      protected boolean getConfiguredMasterRequired() {
        return true;
      }

      @Order(1000.0)
      public class ModelField extends AbstractTreeBox<Long> {

        @Override
        protected boolean getConfiguredAutoExpandAll() {
          return true;
        }

        @Override
        protected int getConfiguredGridH() {
          return 7;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Model");
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return MobilityForm.MainBox.MeansOfTransportBox.TypeField.class;
        }

        @Override
        protected boolean getConfiguredMasterRequired() {
          return true;
        }

        @Override
        protected Class<? extends ILookupCall<Long>> getConfiguredLookupCall() {
          return ModelLookupCall.class;
        }

        @Override
        protected void execPrepareLookup(ILookupCall<Long> call, ITreeNode parent) throws ProcessingException {
          super.execPrepareLookup(call, parent);

          ModelLookupCall lookupCall = (ModelLookupCall) call;
          lookupCall.setCodeTypeClass(getTypeField().getCodeTypeClass());
          lookupCall.setRootCodeId(getTypeField().getValue());
        }

        @Override
        protected void execFilterNewNode(ITreeNode newNode, int treeLevel) throws ProcessingException {
          super.execFilterNewNode(newNode, treeLevel);

          switch (treeLevel) {
            case 0:
              newNode.getCellForUpdate().setFont(FontSpec.parse("BOLD"));
              newNode.setEnabled(false);
              break;
            case 1:
              newNode.getCellForUpdate().setFont(FontSpec.parse("ITALIC"));
              break;
            case 2:
              newNode.setVisible(false);
              break;
          }
        }
      }

      @Order(2000.0)
      public class AddToSelectionButton extends AbstractButton {

        @Override
        protected int getConfiguredDisplayStyle() {
          return DISPLAY_STYLE_LINK;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("AddToSelection");
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return MobilityForm.MainBox.DetailsBox.ModelField.class;
        }

        @Override
        protected boolean getConfiguredMasterRequired() {
          return true;
        }

        @Override
        protected void execClickAction() throws ProcessingException {
          super.execClickAction();

          Set<Long> selectedModels = getModelField().getValue();
          for (Long value : selectedModels) {
            Table table = getSelectionTableField().getTable();
            ITableRow row = table.createRow();
            table.getModelColumn().setValue(row, value);
            table.addRow(row);
          }
        }
      }
    }

    @Order(4000.0)
    public class SelectionBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Selection");
      }

      @Order(1000.0)
      public class SelectionTableField extends AbstractTableField<SelectionTableField.Table> {

        @Override
        protected int getConfiguredGridH() {
          return 7;
        }

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Order(1000.0)
        public class Table extends AbstractExtensibleTable {

          public SelectionColumn getSelectionColumn() {
            return getColumnSet().getColumnByClass(SelectionColumn.class);
          }

          public ModelColumn getModelColumn() {
            return getColumnSet().getColumnByClass(ModelColumn.class);
          }

          @Order(1000.0)
          public class ModelColumn extends AbstractSmartColumn<Long> {

            @Override
            protected String getConfiguredHeaderText() {
              return TEXTS.get("Model");
            }

            @Override
            protected int getConfiguredWidth() {
              return 180;
            }
          }

          @Order(2000.0)
          public class SelectionColumn extends AbstractSmartColumn<Long> {

            @Override
            protected boolean getConfiguredEditable() {
              return true;
            }

            @Override
            protected String getConfiguredHeaderText() {
              return TEXTS.get("Selection");
            }

            @Override
            protected int getConfiguredWidth() {
              return 180;
            }

            @Override
            protected Class<? extends ILookupCall<Long>> getConfiguredLookupCall() {
              return ModelLookupCall.class;
            }

            @Override
            protected void execPrepareLookup(ILookupCall<Long> call, ITableRow row) {
              super.execPrepareLookup(call, row);

              ModelLookupCall lookupCall = (ModelLookupCall) call;
              lookupCall.setCodeTypeClass(getModelColumn().getCodeTypeClass());
              lookupCall.setRootCodeId(getModelColumn().getValue(row));
            }
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
