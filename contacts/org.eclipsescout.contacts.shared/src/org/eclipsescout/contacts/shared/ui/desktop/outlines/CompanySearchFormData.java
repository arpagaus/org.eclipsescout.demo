/**
 * 
 */
package org.eclipsescout.contacts.shared.ui.desktop.outlines;

import java.util.Map;

import javax.annotation.Generated;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 * 
 * @generated
 */
@Generated(value = "org.eclipse.scout.sdk.workspace.dto.formdata.FormDataDtoUpdateOperation", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class CompanySearchFormData extends AbstractFormData {

  private static final long serialVersionUID = 1L;

  public CompanySearchFormData() {
  }

  public City getCity() {
    return getFieldByClass(City.class);
  }

  public Country getCountry() {
    return getFieldByClass(Country.class);
  }

  public Homepage getHomepage() {
    return getFieldByClass(Homepage.class);
  }

  public Name getName() {
    return getFieldByClass(Name.class);
  }

  public static class City extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public City() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class Country extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public Country() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class Homepage extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public Homepage() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class Name extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public Name() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }
}