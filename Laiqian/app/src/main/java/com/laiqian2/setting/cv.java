package com.laiqian.setting;

import com.laiqian.models.bf;
import com.laiqian.pos.industry.weiorder.a;

class cv implements a.a {
  cv(UnitWeightActivity paramUnitWeightActivity) {}
  
  public void a(a parama) { parama.dismiss(); }
  
  public void a(a parama, double paramDouble, String paramString) {
    bf bf = parama.aaY();
    if (bf == null) {
      (new UnitWeightActivity.b(this.dnz, parama, bf, paramString, paramDouble)).execute(new Void[0]);
      return;
    } 
    (new UnitWeightActivity.d(this.dnz, parama, bf, paramString, paramDouble)).execute(new Void[0]);
  }
  
  public void b(a parama) {
    bf bf = parama.aaY();
    if (bf != null)
      (new UnitWeightActivity.c(this.dnz, parama, bf)).execute(new Void[0]); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */