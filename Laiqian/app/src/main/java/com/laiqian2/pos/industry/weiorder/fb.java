package com.laiqian.pos.industry.weiorder;

import android.text.Editable;
import android.widget.EditText;
import com.laiqian.ui.r;

class fb extends r {
  fb(WeshopInfoFragment paramWeshopInfoFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str2 = paramEditable.toString();
    String str1 = str2;
    if (str2.contains(".")) {
      str1 = str2.replace(".", "");
      ((EditText)this.cwf.cvZ.cvV.dwQ.getView()).setText(str1);
    } 
    this.cwf.cvS.jV(str1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */