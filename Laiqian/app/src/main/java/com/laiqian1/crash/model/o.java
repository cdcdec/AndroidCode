package com.laiqian.crash.model;

import android.content.Context;
import com.a.a.b;
import com.laiqian.util.bb;

public class o {
  Context context;
  
  public o(Context paramContext) { this.context = paramContext; }
  
  public boolean a(String[] paramArrayOfString1, String paramString1, String paramString2, String[] paramArrayOfString2) {
    l l = new l();
    b b = new b(this.context);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l.V(this.context));
    stringBuilder.append("/");
    stringBuilder.append(l.ck("yyyyMMdd"));
    stringBuilder.append("/");
    stringBuilder.append(l.ck("HHmmssSSS"));
    stringBuilder.append("/sql.log");
    String str = stringBuilder.toString();
    bb.e("sServerObjectName", str);
    bb.e("sReturn", b.e("91laiqian-error-log", str, paramArrayOfString2[0]));
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */