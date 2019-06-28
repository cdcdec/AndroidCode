package com.laiqian.setting;

import com.laiqian.models.bf;
import java.util.Comparator;

class cz extends Object implements Comparator<bf> {
  cz(UnitWeightActivity.a parama) {}
  
  public int a(bf parambf1, bf parambf2) { return (parambf1.Ww() > parambf2.Ww()) ? 1 : ((parambf1.Wx() < parambf2.Wx()) ? -1 : 0); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */