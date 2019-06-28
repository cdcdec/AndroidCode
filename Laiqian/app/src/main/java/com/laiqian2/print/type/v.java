package com.laiqian.print.type;

import android.text.Editable;
import android.text.TextUtils;
import com.laiqian.print.model.s;
import com.laiqian.ui.r;

class v extends r {
  v(PrinterEditActivity paramPrinterEditActivity, s params) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = paramEditable.toString();
    if (!TextUtils.isEmpty(str))
      this.cHh.setName(str); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */