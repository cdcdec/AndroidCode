package com.laiqian.main.a;

import android.content.Context;
import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.cj;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.print.usage.tag.a.a;
import com.laiqian.util.av;
import java.io.IOException;

public class a {
  boolean bpp = false;
  
  Context context;
  
  public a(Context paramContext) {
    this.context = paramContext;
    av av = new av(paramContext);
    String str = av.atp();
    av.close();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(cj.aGx);
    stringBuilder.append("");
    this.bpp = stringBuilder.toString().equals(str);
  }
  
  void Li() {
    null = new PrintContent.a();
    null.age();
    null = null.afV();
    a.bo(this.context).e(null);
    a.bq(this.context).e(null);
    this.context.sendBroadcast(new Intent("android.intent.money_test.action"));
    runtime = Runtime.getRuntime();
    try {
      runtime.exec("echo 0 > /sys/devices/platform/att_test/test");
      return;
    } catch (IOException runtime) {
      a.e(runtime);
      return;
    } 
  }
  
  public boolean dC(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.bpp) {
        Li();
        return true;
      } 
      return false;
    } 
    Li();
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */