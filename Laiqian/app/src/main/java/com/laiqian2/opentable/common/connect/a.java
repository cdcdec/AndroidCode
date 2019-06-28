package com.laiqian.opentable.common.connect;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.p;

public class a {
  public static int NO;
  
  static  {
  
  }
  
  public static void d(Context paramContext, long paramLong) {
    try {
      p p = new p(paramContext);
    } catch (Exception paramContext) {
      a.e(paramContext);
      paramContext = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    paramContext.hv(stringBuilder.toString());
    paramContext.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\connect\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */