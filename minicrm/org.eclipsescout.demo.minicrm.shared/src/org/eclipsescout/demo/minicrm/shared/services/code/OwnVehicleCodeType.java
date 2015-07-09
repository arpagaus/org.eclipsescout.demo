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

public class OwnVehicleCodeType extends AbstractCodeType<Long, Long> {

  private static final long serialVersionUID = 1L;
  /**
   *
   */
  public static final Long ID = 200L;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public OwnVehicleCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("OwnVehicle");
  }

  @Override
  public Long getId() {
    return ID;
  }

  @Order(10.0)
  public static class CarCode extends AbstractCode<Long> {
    private static final long serialVersionUID = 1L;
    public static final Long ID = 703601L;

    @Override
    public Long getId() {
      return ID;
    }

    @Override
    protected String getConfiguredText() {
      return "Auto";
    }

    @Order(10.0)
    public static class AudiCode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703667L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Audi";
      }

      @Order(10.0)
      public static class R8Code extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703669L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "R8";
        }

        @Order(10.0)
        public static class GrauCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703695L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "grau";
          }
        }

        @Order(20.0)
        public static class BlauCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703696L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "blau";
          }
        }

      }

      @Order(20.0)
      public static class RS4Code extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703670L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "RS4";
        }

        @Order(10.0)
        public static class SchwarzCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703697L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "schwarz";
          }
        }

        @Order(20.0)
        public static class RacingBlueCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703698L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "racing blue";
          }
        }
      }
    }

    @Order(20.0)
    public static class SeatCode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703668L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Seat";
      }

      @Order(10.0)
      public static class IbizaCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703671L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Ibiza";
        }

        @Order(10.0)
        public static class OrangeCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703707L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "orange";
          }
        }

        @Order(20.0)
        public static class GruenCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703708L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "grün";
          }
        }

      }

      @Order(20.0)
      public static class LeonCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703672L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Leon";
        }

        @Order(10.0)
        public static class WeissCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703709L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "weiss";
          }
        }

        @Order(20.0)
        public static class OrangeCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703710L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "orange";
          }
        }
      }
    }
  }

}
