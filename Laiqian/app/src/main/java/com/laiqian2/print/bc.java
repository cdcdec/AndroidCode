package com.laiqian.print;

import android.content.Intent;
import com.laiqian.print.type.PrinterEditActivity;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class bc implements w.a {
  bc(PrinterSettingsActivity paramPrinterSettingsActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    new Intent();
    switch (paramInt) {
      default:
        return;
      case 2:
        PrinterSettingsActivity.e(this.cDq, -1);
        this.cDq.startActivityForResult(PrinterEditActivity.u(this.cDq.getActivity(), 2), 2);
        return;
      case 1:
        PrinterSettingsActivity.a(this.cDq).hF(1);
        return;
      case 0:
        break;
    } 
    PrinterSettingsActivity.e(this.cDq, -1);
    this.cDq.startActivityForResult(PrinterEditActivity.u(this.cDq.getActivity(), 4), 2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */