package com.laiqian.main;

import android.text.Editable;
import com.laiqian.ui.r;
import com.laiqian.util.by;

class dd extends r {
  dd(cs paramcs) {}
  
  public void afterTextChanged(Editable paramEditable) { cs.f(this.bde).setActivated(by.isNull(cs.e(this.bde).getText().toString().trim()) ^ true); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */