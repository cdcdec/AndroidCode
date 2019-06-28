package com.laiqian.network.service;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.a.a.b;
import io.reactivex.g.a;

public class i {
  public static i bVW;
  
  static  {
  
  }
  
  private i(Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt, Context paramContext) { a.aKh().r(new j(paramContext, paramHandler, paramString1, paramString2, paramString3, paramInt)); }
  
  public static i c(Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt, Context paramContext) {
    if (bVW == null)
      bVW = new i(paramHandler, paramString1, paramString2, paramString3, paramInt, paramContext); 
    return bVW;
  }
  
  public static void close() { bVW = null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */