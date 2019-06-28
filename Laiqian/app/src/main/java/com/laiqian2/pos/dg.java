package com.laiqian.pos;

import android.text.Editable;
import com.laiqian.ui.r;

class dg extends r {
  dg(dd paramdd) {}
  
  public void afterTextChanged(Editable paramEditable) {
    this.ciO.ciN.ciI = paramEditable.toString();
    dd.b(this.ciO);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */