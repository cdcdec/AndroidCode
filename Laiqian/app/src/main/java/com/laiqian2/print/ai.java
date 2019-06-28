package com.laiqian.print;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ai implements w.a {
  ai(PrinterSettingsActivity paramPrinterSettingsActivity, int paramInt) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 2:
        PrinterSettingsActivity.a(this.cDq, this.qI, bm.cEh);
        return;
      case 1:
        PrinterSettingsActivity.a(this.cDq, this.qI, bm.cEg);
        return;
      case 0:
        break;
    } 
    PrinterSettingsActivity.a(this.cDq, this.qI, bm.cEf);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */