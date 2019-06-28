package com.laiqian.print.type;

import android.text.Editable;
import com.laiqian.print.model.type.b.c;
import com.laiqian.ui.r;

class w extends r {
  w(PrinterEditActivity paramPrinterEditActivity, c paramc) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = paramEditable.toString();
    if (c.lu(str)) {
      this.cKp.setAddress(str);
      this.cKp.setName(str);
      this.cKp.lq(str);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */