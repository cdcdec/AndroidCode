package com.laiqian.network.service;

import android.content.Context;
import android.os.Handler;
import com.a.a.b;
import io.reactivex.g.a;

public class e {
  public static e bVR;
  
  static  {
  
  }
  
  private e(Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt, Context paramContext) { a.aKh().r(new f(paramContext, paramHandler, paramString1, paramString2, paramString3, paramInt)); }
  
  public static e b(Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt, Context paramContext) {
    if (bVR == null)
      bVR = new e(paramHandler, paramString1, paramString2, paramString3, paramInt, paramContext); 
    return bVR;
  }
  
  public static void close() { bVR = null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */