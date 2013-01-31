package org.eclipse.scout.rt.demo.client.ui.desktop.outlines.pages;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.demo.client.ui.forms.DetailForm;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class PageWithADetailformTablePage extends AbstractPageWithTable<PageWithADetailformTablePage.Table> {

  private DetailForm m_detailForm;

  public PageWithADetailformTablePage() throws ProcessingException {
    super(true, DetailForm.class.getName());
    m_detailForm = new DetailForm();
    setDetailForm(m_detailForm);
    m_detailForm.startNew();
  }

  @Override
  protected String getConfiguredIconId() {
    return org.eclipse.scout.rt.shared.AbstractIcons.TreeNodeOpen;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("PageWithADetailform");
  }

  @Override
  protected Object[][] execLoadTableData(SearchFilter filter) throws ProcessingException {
    return new Object[][]{
        {1, "Exxon Mobil Corporation", "XOM"},
        {2, "IBM", "IBM"},
        {3, "UBS", "UBS"},
        {4, "Coca-Cola Company", "KO"}};
  }

  @Order(10.0)
  public class Table extends AbstractTable {

    public NameColumn getNameColumn() {
      return getColumnSet().getColumnByClass(NameColumn.class);
    }

    public SymbolColumn getSymbolColumn() {
      return getColumnSet().getColumnByClass(SymbolColumn.class);
    }

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    @Override
    protected boolean getConfiguredMultiSelect() {
      return false;
    }

    public CompanyNrColumn getCompanyNrColumn() {
      return getColumnSet().getColumnByClass(CompanyNrColumn.class);
    }

    @Order(10.0)
    public class CompanyNrColumn extends AbstractLongColumn {

      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }
    }

    @Order(20.0)
    public class NameColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Name");
      }
    }

    @Order(30.0)
    public class SymbolColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Symbol");
      }
    }
  }
}
