package com.laiqian.pos.features;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class s implements w.a {
  s(ScanOrderExportFragment paramScanOrderExportFragment) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (paramInt > -1) {
      ScanOrderExportFragment.a(this.cjQ, (String)ScanOrderExportFragment.i(this.cjQ).get(paramInt));
      ScanOrderExportFragment.c(this.cjQ, paramInt);
      ScanOrderExportFragment.a(this.cjQ, 1);
      return;
    } 
    ScanOrderExportFragment.a(this.cjQ, 0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */