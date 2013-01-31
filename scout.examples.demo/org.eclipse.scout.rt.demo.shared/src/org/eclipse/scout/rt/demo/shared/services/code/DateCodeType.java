package org.eclipse.scout.rt.demo.shared.services.code;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

public class DateCodeType extends AbstractCodeType<Long> {

  private static final long serialVersionUID = 1L;
  public static final Long ID = 10000L;

  public DateCodeType() throws ProcessingException {
    super();
  }

  @Override
  public Long getId() {
    return ID;
  }

  @Order(10.0)
  public static class Year2012Code extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 10001L;

    @Override
    protected boolean getConfiguredEnabled() {
      return false;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("year2012");
    }

    @Override
    public Long getId() {
      return ID;
    }

    @Order(10.0)
    public static class JanuaryCode extends AbstractCode<Long> {

      private static final long serialVersionUID = 1L;
      public static final Long ID = 10002L;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("January");
      }

      @Override
      public Long getId() {
        return ID;
      }
    }

    @Order(20.0)
    public static class SeptemberCode extends AbstractCode<Long> {

      private static final long serialVersionUID = 1L;
      public static final Long ID = 10003L;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("September");
      }

      @Override
      public Long getId() {
        return ID;
      }
    }

    @Order(30.0)
    public static class DecemberCode extends AbstractCode<Long> {

      private static final long serialVersionUID = 1L;
      public static final Long ID = 10003L;

      @Override
      protected boolean getConfiguredActive() {
        return false;
      }

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("December");
      }

      @Override
      public Long getId() {
        return ID;
      }
    }
  }

  @Order(20.0)
  public static class Year2013Code extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 10010L;

    @Override
    protected boolean getConfiguredEnabled() {
      return false;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("year2013");
    }

    @Override
    public Long getId() {
      return ID;
    }

    @Order(10.0)
    public static class OctoberCode extends AbstractCode<Long> {

      private static final long serialVersionUID = 1L;
      public static final Long ID = 10011L;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("October");
      }

      @Override
      public Long getId() {
        return ID;
      }
    }
  }

  @Order(30.0)
  public static class Year2011Code extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 10030L;

    @Override
    protected boolean getConfiguredActive() {
      return false;
    }

    @Override
    protected boolean getConfiguredEnabled() {
      return false;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("year2011");
    }

    @Override
    public Long getId() {
      return ID;
    }

    @Order(10.0)
    public static class JanuaryCode extends AbstractCode<Long> {

      private static final long serialVersionUID = 1L;
      public static final Long ID = 10031L;

      @Override
      protected boolean getConfiguredActive() {
        return false;
      }

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("January");
      }

      @Override
      public Long getId() {
        return ID;
      }
    }
  }
}
