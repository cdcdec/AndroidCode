package com.laiqian.main.module.productpool;

import com.laiqian.rx.b.a;

final class w extends Object implements a.d<v.a> {
  public int a(a<v.a> parama, int paramInt) {
    v.a a1 = (v.a)parama.getItem(paramInt);
    if (a1 instanceof v.a.a)
      return 1; 
    if (a1 instanceof v.a.b)
      return 0; 
    if (a1 instanceof v.a.c)
      return 3; 
    if (a1 instanceof v.a.d)
      return 2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unknown item type at position ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productpool\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */