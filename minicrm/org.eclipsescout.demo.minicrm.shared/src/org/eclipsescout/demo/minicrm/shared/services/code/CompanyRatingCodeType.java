/*******************************************************************************
 * Copyright (c) 2013 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.minicrm.shared.services.code;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeTypeWithGeneric;
import org.eclipse.scout.rt.shared.services.common.code.CodeRow;
import org.eclipse.scout.rt.shared.services.common.code.ICode;
import org.eclipse.scout.rt.shared.services.common.code.ICodeRow;
import org.eclipsescout.demo.minicrm.shared.Icons;

public class CompanyRatingCodeType extends AbstractCodeTypeWithGeneric<Long, Long, ICode<Long>> {

  private static final long serialVersionUID = 1L;
  public static final Long ID = 10100L;

  public CompanyRatingCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("CompanyRating");
  }

  @Override
  public Long getId() {
    return ID;
  }

  @Override
  protected List<? extends ICodeRow<Long>> execLoadCodes(Class<? extends ICodeRow<Long>> codeRowType) throws ProcessingException {
    List<CodeRow<Long>> list = new ArrayList<CodeRow<Long>>();

    for (int i = 0; i < 4; i++) {
      String text = String.valueOf((char) (87 + i));
      list.add(new CodeRow<Long>(10101L + i, text));
    }

    return list;
  }

  @Override
  protected void execOverwriteCode(ICodeRow<Long> oldCode, ICodeRow<Long> newCode) throws ProcessingException {
    super.execOverwriteCode(oldCode, newCode);
    newCode.setText(newCode.getText() + " (old: " + oldCode.getText() + ")");
  }

  @Order(10.0)
  public static class ACode extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 10101L;

    @Override
    protected String getConfiguredIconId() {
      return Icons.Star;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("A");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class BCode extends AbstractCode<Long> {

    @Override
    protected String getConfiguredIconId() {
      return Icons.Star;
    }

    private static final long serialVersionUID = 1L;
    public static final Long ID = 10102L;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("B");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class CCode extends AbstractCode<Long> {

    @Override
    protected String getConfiguredIconId() {
      return Icons.Star;
    }

    private static final long serialVersionUID = 1L;
    public static final Long ID = 10103L;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("C");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }

  @Order(40.0)
  public static class DCode extends AbstractCode<Long> {

    private static final long serialVersionUID = 1L;
    public static final Long ID = 10104L;

    @Override
    protected String getConfiguredIconId() {
      return Icons.Star;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("D");
    }

    @Override
    public Long getId() {
      return ID;
    }
  }
}
