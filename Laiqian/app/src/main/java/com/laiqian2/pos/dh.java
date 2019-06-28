package com.laiqian.pos;

import android.text.Editable;
import com.laiqian.ui.r;

class dh extends r {
  dh(dd paramdd) {}
  
  public void afterTextChanged(Editable paramEditable) {
    this.ciO.ciN.address = paramEditable.toString();
    dd.b(this.ciO);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */