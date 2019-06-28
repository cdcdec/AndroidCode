package com.laiqian.report.models;

import com.laiqian.models.n;
import com.laiqian.util.k;

class w extends Object implements k.b<n, Double> {
  w(v paramv) {}
  
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */