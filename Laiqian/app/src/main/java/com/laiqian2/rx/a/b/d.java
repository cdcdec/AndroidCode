package com.laiqian.rx.a.b;

import android.content.Context;
import com.laiqian.util.n;
import io.reactivex.annotations.NonNull;
import io.reactivex.c.h;

final class d extends Object implements h<Double, String> {
  d(Context paramContext) {}
  
  public String f(@NonNull Double paramDouble) throws Exception {
    if (paramDouble.isInfinite() || paramDouble.isNaN()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(paramDouble);
      return stringBuilder.toString();
    } 
    return n.a(context, paramDouble, this.dhH);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\rx\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */