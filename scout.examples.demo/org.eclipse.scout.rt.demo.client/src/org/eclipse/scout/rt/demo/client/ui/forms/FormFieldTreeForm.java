package org.eclipse.scout.rt.demo.client.ui.forms;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.basic.tree.ITreeNode;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractLinkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;
import org.eclipse.scout.rt.demo.client.Activator;
import org.eclipse.scout.rt.demo.client.ui.forms.FormFieldTreeForm.MainBox.FormFieldListField;
import org.eclipse.scout.rt.demo.client.ui.forms.FormFieldTreeForm.MainBox.FormFieldTreeField;
import org.eclipse.scout.rt.demo.client.ui.forms.FormFieldTreeForm.MainBox.ShowTableButton;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.svg.client.SVGUtility;
import org.eclipse.scout.svg.client.svgfield.AbstractSvgField;
import org.eclipse.scout.svg.client.svgfield.SvgFieldEvent;
import org.w3c.dom.svg.SVGDocument;

public class FormFieldTreeForm extends AbstractForm {
  IPage m_page;

  public FormFieldTreeForm(IPage page) throws ProcessingException {
    super();
    m_page = page;
  }

  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  public FormFieldListField getFormFieldListField() {
    return getFieldByClass(FormFieldListField.class);
  }

  public FormFieldTreeField getFormFieldTreeField() {
    return getFieldByClass(FormFieldTreeField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public ShowTableButton getShowTableButton() {
    return getFieldByClass(ShowTableButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class FormFieldTreeField extends AbstractSvgField {

      @Override
      protected void execInitField() throws ProcessingException {
        try {
          URL url = Activator.getDefault().getBundle().getResource("/resources/svg/formfieldtree.svg");
          InputStream is = url.openStream();
          SVGDocument svgDoc = SVGUtility.readSVGDocument(is);
          setSvgDocument(svgDoc);
        }
        catch (IOException e) {
          e.printStackTrace();
          throw new ProcessingException("Exception occured while reading svg file", e);
        }
      }

      @Override
      protected int getConfiguredGridH() {
        return 10;
      }

      @Override
      protected int getConfiguredGridW() {
        return 0;
      }

      @Override
      protected boolean getConfiguredLabelVisible() {
        return false;
      }

      @Override
      protected void execHyperlink(SvgFieldEvent e) throws ProcessingException {
        String url = e.getURL().toExternalForm();

        String url_form = url.split("/")[url.split("/").length - 1];

        for (ITreeNode node : m_page.getChildNodes()) {
          for (String fieldName : node.getCellForUpdate().getText().split(" ")) {
            if (fieldName.toLowerCase().contains(url_form)) {
              m_page.getTree().selectNode(node);
            }
          }
        }
      }
    }

    @Order(20.0)
    public class FormFieldListField extends AbstractTableField {

      @Override
      protected int getConfiguredGridH() {
        return 10;
      }

      @Override
      protected int getConfiguredGridW() {
        return 0;
      }

      @Override
      protected boolean getConfiguredLabelVisible() {
        return false;
      }

      @Override
      protected boolean getConfiguredVisible() {
        return false;
      }

      @Override
      protected void execReloadTableData() throws ProcessingException {
        getTable().deleteAllRows();
        Object[][] rows = new Object[m_page.getChildNodes().length][2];
        for (int index = 0; index < m_page.getChildNodes().length; index++) {
          rows[index][0] = m_page.getChildNodes()[index];
          rows[index][1] = m_page.getChildNodes()[index].getCellForUpdate().getText();
        }
        getTable().addRowsByMatrix(rows);
      }

      @Order(10.0)
      public class Table extends AbstractTable {

        @Override
        protected boolean getConfiguredAutoResizeColumns() {
          return true;
        }

        @Override
        protected String getConfiguredDefaultIconId() {
          return org.eclipse.scout.rt.demo.shared.Icons.Form;
        }

        @Override
        protected void execRowAction(ITableRow row) throws ProcessingException {
          m_page.getTree().selectNode(getTreeNodeColumn().getValue(row));
        }

        public FoldersColumn getFoldersColumn() {
          return getColumnSet().getColumnByClass(FoldersColumn.class);
        }

        public TreeNodeColumn getTreeNodeColumn() {
          return getColumnSet().getColumnByClass(TreeNodeColumn.class);
        }

        @Order(10.0)
        public class TreeNodeColumn extends AbstractColumn<ITreeNode> {

          @Override
          protected boolean getConfiguredDisplayable() {
            return false;
          }

          @Override
          protected boolean getConfiguredVisible() {
            return false;
          }
        }

        @Order(20.0)
        public class FoldersColumn extends AbstractStringColumn {

          @Override
          protected String getConfiguredHeaderText() {
            return TEXTS.get("Folders");
          }
        }

      }
    }

    @Order(30.0)
    public class ShowTableButton extends AbstractLinkButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("ShowTable");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        if (getFormFieldTreeField().isVisible()) {
          getFormFieldTreeField().setVisible(false);
          getFormFieldListField().setVisible(true);
          getFormFieldListField().reloadTableData();
          setLabel(TEXTS.get("ShowHierarchy"));
        }
        else {
          getFormFieldTreeField().setVisible(true);
          getFormFieldListField().setVisible(false);
          setLabel(TEXTS.get("ShowTable"));
        }
      }
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}