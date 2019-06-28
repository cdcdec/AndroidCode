package com.laiqian.sync.a;

import android.util.Log;
import com.laiqian.network.a;

class c implements a.a {
  c(a parama) {}
  
  public void dS(String paramString) {
    String str = a.apm();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResponse 下载文件");
    stringBuilder.append(paramString);
    Log.i(str, stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */