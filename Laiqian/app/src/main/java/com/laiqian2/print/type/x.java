package com.laiqian.print.type;

import android.text.Editable;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.type.b.c;
import com.laiqian.ui.r;

class x extends r {
  x(PrinterEditActivity paramPrinterEditActivity, c paramc) {}
  
  public void afterTextChanged(Editable paramEditable) {
    str = paramEditable.toString();
    try {
      int i = Integer.parseInt(str);
      this.cKp.setPort(i);
      return;
    } catch (NumberFormatException str) {
      a.e(str);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */