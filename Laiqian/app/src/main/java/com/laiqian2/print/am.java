package com.laiqian.print;

import com.laiqian.print.model.q;

class am implements Runnable {
  am(PrinterSettingsActivity paramPrinterSettingsActivity, q paramq) {}
  
  public void run() {
    PrinterSettingsActivity.b b = new PrinterSettingsActivity.b(this.cDq, PrinterSettingsActivity.e(this.cDq));
    b.cDy.setText(this.cDr.agE().getName());
    b.cDz.setText(PrinterSettingsActivity.a(this.cDq, this.cDr.getType()));
    PrinterSettingsActivity.a(this.cDq, b.getView());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */