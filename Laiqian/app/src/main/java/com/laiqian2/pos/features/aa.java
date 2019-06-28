package com.laiqian.pos.features;

import com.google.a.a.a.a.a.a;
import com.laiqian.ui.a.r;

class aa implements r.a {
  aa(ScanOrderExportFragment paramScanOrderExportFragment) {}
  
  public void xD() {
    try {
      String str1 = ScanOrderExportFragment.a(this.cjQ).getText().toString().trim();
      String str2 = ScanOrderExportFragment.b(this.cjQ).getText().toString().trim();
      int i = Integer.parseInt(str1);
      int j = Integer.parseInt(str2);
      ScanOrderExportFragment.a(this.cjQ, i, j);
      return;
    } catch (NumberFormatException numberFormatException) {
      a.e(numberFormatException);
      return;
    } 
  }
  
  public void xE() { ScanOrderExportFragment.e(this.cjQ).setClickable(true); }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */