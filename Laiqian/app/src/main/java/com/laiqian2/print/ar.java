package com.laiqian.print;

import android.view.View;

class ar implements View.OnClickListener {
  ar(PrinterSettingsActivity paramPrinterSettingsActivity) {}
  
  public void onClick(View paramView) {
    boolean bool;
    int i = ((Integer)paramView.getTag(2131297320)).intValue();
    if (i == 0) {
      PrinterSettingsActivity.b(this.cDq);
      return;
    } 
    if (i == 1) {
      PrinterSettingsActivity.c(this.cDq);
      return;
    } 
    Object object = paramView.getTag(2131297290);
    if (object != null) {
      bool = ((Boolean)object).booleanValue();
    } else {
      bool = false;
    } 
    if (bool) {
      PrinterSettingsActivity.b(this.cDq, i - 2);
      return;
    } 
    PrinterSettingsActivity.c(this.cDq, i - 2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */