package com.laiqian.main.module.productcart;

import com.laiqian.rx.b.a;

final class ap extends Object implements a.d<am.a> {
  public int a(a<am.a> parama, int paramInt) {
    am.a a1 = (am.a)parama.getItem(paramInt);
    if (a1 instanceof am.a.a)
      return 0; 
    if (a1 instanceof am.a.b)
      return 1; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unknown item type at position ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */