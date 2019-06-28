package com.laiqian.sync.a;

import android.util.Log;
import com.alibaba.a.a.d.b;
import com.google.a.a.a.a.a.a;
import com.laiqian.network.a;

class b implements a.a {
  b(a parama) {}
  
  public void dS(String paramString) {
    String str = getClass().getSimpleName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("post upload file ");
    stringBuilder.append(paramString);
    Log.i(str, stringBuilder.toString());
    if (!paramString.toUpperCase().contains("OK"))
      try {
        throw new b("上传服务器失败");
      } catch (b paramString) {
        a.e(paramString);
      }  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */