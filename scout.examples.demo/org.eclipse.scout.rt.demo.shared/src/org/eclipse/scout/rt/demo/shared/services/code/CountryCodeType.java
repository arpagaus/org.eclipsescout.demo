package org.eclipse.scout.rt.demo.shared.services.code;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

public class CountryCodeType extends AbstractCodeType<Long> {

  private static final long serialVersionUID = 1L;
  public static final Long ID = 20000L;

  public CountryCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("Country");
  }

  @Override
  public Long getId() {
    return ID;
  }

  @Order(10.0)
  public static class USACode extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 20001L;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("USA");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class GreatBritainCode extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 20002L;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("GreatBritain");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class GermanyCode extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 20003L;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Germany");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }

  @Order(40.0)
  public static class FranceCode extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 20004L;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("France");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }

  @Order(50.0)
  public static class SwitzerlandCode extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 20005L;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Switzerland");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }
}
