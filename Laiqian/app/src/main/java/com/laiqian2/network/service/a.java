package com.laiqian.network.service;

import android.content.Context;
import android.os.Handler;
import com.a.a.b;
import io.reactivex.g.a;

public class a {
  public static a bVB;
  
  static  {
  
  }
  
  private a(Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt, Context paramContext) { a.aKh().r(new b(paramContext, paramHandler, paramString1, paramString2, paramString3, paramInt)); }
  
  public static a a(Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt, Context paramContext) {
    if (bVB == null)
      bVB = new a(paramHandler, paramString1, paramString2, paramString3, paramInt, paramContext); 
    return bVB;
  }
  
  public static void close() { bVB = null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */