package com.laiqian.pos;

import com.laiqian.models.n;
import com.laiqian.util.k;

final class cw extends Object implements k.b<n, Double> {
  public Double a(n paramn) {
    byte b1;
    double d = paramn.getValue();
    if (paramn.UZ()) {
      b1 = 1;
    } else {
      b1 = -1;
    } 
    return Double.valueOf(d * b1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */