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
package org.eclipsescout.demo.minicrm.shared.services.code;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

public class PublicTransportCodeType extends AbstractCodeType<Long, Long> {

  private static final long serialVersionUID = 1L;
  /**
   *
   */
  public static final Long ID = 300L;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public PublicTransportCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("PublicTransport");
  }

  @Override
  public Long getId() {
    return ID;
  }

  @Order(10.0)
  public static class ZugCode extends AbstractCode<Long> {
    private static final long serialVersionUID = 1L;
    public static final Long ID = 703673L;

    @Override
    public Long getId() {
      return ID;
    }

    @Override
    protected String getConfiguredText() {
      return "Zug";
    }

    @Order(10.0)
    public static class ICECode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703675L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "ICE";
      }

      @Order(10.0)
      public static class FirstClassCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703699L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "1.Klasse";
        }
      }

      @Order(20.0)
      public static class SecondClassCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703700L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "2.Klasse";
        }
      }

    }

    @Order(20.0)
    public static class TGVCode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703676L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "TGV";
      }

      @Order(10.0)
      public static class FirstClassCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703701L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "1re classe";
        }
      }

      @Order(20.0)
      public static class SeconClassCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703702L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "2e classe";
        }
      }

    }

  }

  @Order(20.0)
  public static class BusCode extends AbstractCode<Long> {
    private static final long serialVersionUID = 1L;
    public static final Long ID = 703674L;

    @Override
    public Long getId() {
      return ID;
    }

    @Override
    protected String getConfiguredText() {
      return "Bus";
    }

    @Order(10.0)
    public static class PostautoCode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703677L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Postauto";
      }

      @Order(10.0)
      public static class EinstoeckigCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703703L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "einstöckig";
        }
      }

      @Order(20.0)
      public static class DoppelstoeckigCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703704L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "doppelstöckig";
        }
      }

    }

    @Order(20.0)
    public static class TrolleybusCode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703678L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Trolleybus";
      }

      @Order(10.0)
      public static class ZVVCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703705L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "ZVV";
        }
      }

      @Order(20.0)
      public static class VBZCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703706L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "VBZ";
        }
      }

    }
  }

}
