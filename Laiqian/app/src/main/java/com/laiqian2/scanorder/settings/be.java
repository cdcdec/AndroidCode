package com.laiqian.scanorder.settings;

import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class be implements w.a {
  be(TableCodeExportFragment paramTableCodeExportFragment) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (paramInt > -1) {
      TableCodeExportFragment tableCodeExportFragment = this.djJ;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)TableCodeExportFragment.k(this.djJ).get(paramInt));
      stringBuilder.append("/");
      stringBuilder.append(this.djJ.getString(R.string.scanorder_table_code));
      TableCodeExportFragment.a(tableCodeExportFragment, stringBuilder.toString());
      TableCodeExportFragment.b(this.djJ, paramInt);
      TableCodeExportFragment.a(this.djJ, 1);
      return;
    } 
    TableCodeExportFragment.a(this.djJ, 0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */