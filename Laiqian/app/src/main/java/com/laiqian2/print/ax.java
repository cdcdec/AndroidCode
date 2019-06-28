package com.laiqian.print;

import android.view.View;

class ax implements View.OnClickListener {
  ax(PrinterSettingsActivity paramPrinterSettingsActivity) {}
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag(2131297320)).intValue();
    PrinterSettingsActivity.d(this.cDq, i);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */