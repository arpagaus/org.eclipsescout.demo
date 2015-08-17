/**
 *
 */
package org.eclipsescout.demo.minicrm.client.extension.ui.desktop.outlines;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.extension.client.ui.desktop.outline.AbstractExtensibleOutline;
import org.eclipse.scout.rt.shared.TEXTS;

/**
 * @author rar
 */

@Order(200)
public class ExtensionOutline extends AbstractExtensibleOutline {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Extension");
  }
}
