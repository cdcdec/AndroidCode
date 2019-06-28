package com.laiqian.scanorder.settings;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.scan_order_module.R;
import com.laiqian.util.n;

class bb implements View.OnClickListener {
  bb(TableCodeExportFragment paramTableCodeExportFragment) {}
  
  public void onClick(View paramView) {
    try {
      if (TableCodeExportFragment.a(this.djJ) == null || TableCodeExportFragment.a(this.djJ).size() == 0) {
        n.eP(R.string.please_create_table_no);
        return;
      } 
      if (TableCodeExportFragment.a(this.djJ).size() > 30) {
        TableCodeExportFragment.b(this.djJ);
        return;
      } 
      TableCodeExportFragment.c(this.djJ);
      return;
    } catch (NumberFormatException paramView) {
      a.e(paramView);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */