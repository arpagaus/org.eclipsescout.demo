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
package org.eclipsescout.demo.minicrm.client.services.lookup;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.common.code.CODES;
import org.eclipse.scout.rt.shared.services.common.code.ICode;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.lookup.ILookupRow;
import org.eclipse.scout.rt.shared.services.lookup.LocalLookupCall;
import org.eclipse.scout.rt.shared.services.lookup.LookupRow;

/**
 *
 */
public class ModelLookupCall extends LocalLookupCall<Long> {

  private static final long serialVersionUID = 1L;

  private Class<? extends ICodeType> codeTypeClass;
  private Long rootCodeId;

  public Class<? extends ICodeType> getCodeTypeClass() {
    return codeTypeClass;
  }

  public void setCodeTypeClass(Class<? extends ICodeType> codeTypeClass) {
    this.codeTypeClass = codeTypeClass;
  }

  public Long getRootCodeId() {
    return rootCodeId;
  }

  public void setRootCodeId(Long rootCodeId) {
    this.rootCodeId = rootCodeId;
  }

  @Override
  protected List<? extends ILookupRow<Long>> execCreateLookupRows() throws ProcessingException {
    List<ILookupRow<Long>> rows = new ArrayList<ILookupRow<Long>>();

    if (codeTypeClass != null && rootCodeId != null) {
      @SuppressWarnings("unchecked")
      ICodeType<?, Long> codeType = CODES.getCodeType(codeTypeClass);
      if (codeType != null) {
        ICode<Long> rootCode = codeType.getCode(rootCodeId);
        addChildCodes(rows, rootCode.getChildCodes());
      }
    }
    return rows;
  }

  private void addChildCodes(List<ILookupRow<Long>> rows, List<? extends ICode<Long>> childCodes) {
    for (ICode<Long> code : childCodes) {
      @SuppressWarnings("unchecked")
      ILookupRow<Long> row = new LookupRow(code.getId(), code.getText());
      if (code.getParentCode() != null) {
        row.setParentKey((Long) code.getParentCode().getId());
      }
      rows.add(row);
      addChildCodes(rows, code.getChildCodes());
    }
  }
}
