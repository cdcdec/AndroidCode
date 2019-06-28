package com.laiqian.pos.features;

import android.view.View;
import com.google.a.a.a.a.a.a;

class p implements View.OnClickListener {
  p(ScanOrderExportFragment paramScanOrderExportFragment) {}
  
  public void onClick(View paramView) {
    try {
      String str1 = ScanOrderExportFragment.a(this.cjQ).getText().toString().trim();
      String str2 = ScanOrderExportFragment.b(this.cjQ).getText().toString().trim();
      int i = Integer.parseInt(str1);
      int j = Integer.parseInt(str2);
      if (j - i > 30) {
        ScanOrderExportFragment.c(this.cjQ);
        return;
      } 
      ScanOrderExportFragment.a(this.cjQ, i, j);
      return;
    } catch (NumberFormatException paramView) {
      a.e(paramView);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */