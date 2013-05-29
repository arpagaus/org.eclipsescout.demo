package org.eclipsescout.demo.minicrm.server.services.lookup;

import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;
import org.eclipsescout.demo.minicrm.shared.services.lookup.ICompanyLookupService;

public class CompanyLookupService extends AbstractSqlLookupService implements ICompanyLookupService {

  @Override
  public String getConfiguredSqlSelect() {
    return "SELECT  C.COMPANY_NR, " +
        "        C.NAME " +
        "FROM    COMPANY C " +
        "WHERE   1=1 " +
        "  AND (C.TYPE_UID = :master OR :master IS NULL) " +
        "<key>   AND     C.COMPANY_NR = :key </key> " +
        "<text>  AND     UPPER(C.NAME) LIKE UPPER(:text||'%') </text> " +
        "<all> </all> ";
  }
}
