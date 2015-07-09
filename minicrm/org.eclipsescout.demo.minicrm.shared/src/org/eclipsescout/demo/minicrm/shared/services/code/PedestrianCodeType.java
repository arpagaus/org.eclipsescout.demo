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

public class PedestrianCodeType extends AbstractCodeType<Long, Long> {

  private static final long serialVersionUID = 1L;
  /**
   *
   */
  public static final Long ID = 100L;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public PedestrianCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("Pedestrian");
  }

  @Override
  public Long getId() {
    return ID;
  }

  @Order(10.0)
  public static class TurnschuheCode extends AbstractCode<Long> {
    private static final long serialVersionUID = 1L;
    public static final Long ID = 703653L;

    @Override
    public Long getId() {
      return ID;
    }

    @Override
    protected String getConfiguredText() {
      return "Turnschuhe";
    }

    @Order(10.0)
    public static class AdidasCode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703655L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Adidas";
      }

      @Order(10.0)
      public static class SoccerCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703657L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Soccer";
        }

        @Order(10.0)
        public static class SchwarzCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703679L;

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
        public static class WeissCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703680L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "weiss";
          }
        }

      }

      @Order(20.0)
      public static class StabilCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703658L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Stabil";
        }

        @Order(10.0)
        public static class GelbCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703681L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "gelb";
          }
        }

        @Order(20.0)
        public static class BlauCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703682L;

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

    }

    @Order(20.0)
    public static class NikeCode extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703656L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Nike";
      }

      @Order(10.0)
      public static class GazelleCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703659L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Gazelle";
        }

        @Order(10.0)
        public static class GrauCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703683L;

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
        public static class PinkCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703684L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "pink";
          }
        }

      }

      @Order(20.0)
      public static class NomadeCode extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703660L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Nomade";
        }

        @Order(10.0)
        public static class BraunCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703685L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "braun";
          }
        }

        @Order(20.0)
        public static class GruenCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703686L;

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
    }
  }

  @Order(20.0)
  public static class HighHeelsCode extends AbstractCode<Long> {
    private static final long serialVersionUID = 1L;
    public static final Long ID = 703654L;

    @Override
    public Long getId() {
      return ID;
    }

    @Override
    protected String getConfiguredText() {
      return "High Heels";
    }

    @Order(10.0)
    public static class Marke1Code extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703661L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Marke1";
      }

      @Order(10.0)
      public static class Modell1Marke1Code extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703663L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Modell1 der Marke1";
        }

        @Order(10.0)
        public static class HochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703687L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "hoch";
          }
        }

        @Order(20.0)
        public static class ExtraHochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703688L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "extra hoch";
          }
        }

      }

      @Order(20.0)
      public static class Modell2Marke1Code extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703664L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Modell2 der Marke1";
        }

        @Order(10.0)
        public static class HochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703689L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "hoch";
          }
        }

        @Order(20.0)
        public static class ExtraHochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703690L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "extra hoch";
          }
        }

      }

    }

    @Order(20.0)
    public static class Marke2Code extends AbstractCode<Long> {
      private static final long serialVersionUID = 1L;
      public static final Long ID = 703662L;

      @Override
      public Long getId() {
        return ID;
      }

      @Override
      protected String getConfiguredText() {
        return "Marke2";
      }

      @Order(10.0)
      public static class Modell1Marke2Code extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703665L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Modell1 der Marke2";
        }

        @Order(10.0)
        public static class HochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703691L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "hoch";
          }
        }

        @Order(20.0)
        public static class ExtraHochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703692L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "extra hoch";
          }
        }

      }

      @Order(20.0)
      public static class Modell2Marke2Code extends AbstractCode<Long> {
        private static final long serialVersionUID = 1L;
        public static final Long ID = 703666L;

        @Override
        public Long getId() {
          return ID;
        }

        @Override
        protected String getConfiguredText() {
          return "Modell2 der Marke2";
        }

        @Order(10.0)
        public static class HochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703693L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "hoch";
          }
        }

        @Order(20.0)
        public static class ExtraHochCode extends AbstractCode<Long> {
          private static final long serialVersionUID = 1L;
          public static final Long ID = 703694L;

          @Override
          public Long getId() {
            return ID;
          }

          @Override
          protected String getConfiguredText() {
            return "extra hoch";
          }
        }

      }

    }

  }
}
