package com.laiqian.print;

import com.laiqian.print.model.q;
import com.laiqian.print.usage.g;
import java.util.Collection;

class an implements Runnable {
  an(PrinterSettingsActivity paramPrinterSettingsActivity, q paramq, Collection paramCollection) {}
  
  public void run() {
    if (PrinterSettingsActivity.f(this.cDq).getVisibility() != 0)
      PrinterSettingsActivity.f(this.cDq).setVisibility(0); 
    PrinterSettingsActivity.a a = new PrinterSettingsActivity.a(this.cDq, false);
    a.S(PrinterSettingsActivity.e(this.cDq).inflate(2131427693, null));
    a.d(new ac(this.cDr.agE(), g.v(this.cDs)));
    PrinterSettingsActivity.b(this.cDq, a.getView());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */