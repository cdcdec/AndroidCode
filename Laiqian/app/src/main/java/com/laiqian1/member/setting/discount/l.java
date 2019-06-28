package com.laiqian.member.setting.discount;

import com.laiqian.util.by;
import com.laiqian.util.e;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class l extends Object implements e.a<String> {
  l(c paramc) {}
  
  public void fG(String paramString) {
    this.bDF.dV(true);
    n.eP(R.string.create_success);
    this.bDF.Sd();
    this.bDF.dismiss();
  }
  
  public void fH(String paramString) {
    this.bDF.dV(true);
    if (!by.isNull(paramString))
      n.o(paramString); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */