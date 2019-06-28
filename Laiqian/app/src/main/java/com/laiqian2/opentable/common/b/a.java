package com.laiqian.opentable.common.b;

import android.os.AsyncTask;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a extends AsyncTask<String, Integer, Boolean> {
  private t.f bMK;
  
  public a(t.f paramf) { this.bMK = paramf; }
  
  public void b(Boolean paramBoolean) {
    try {
      this.bMK.dp(paramBoolean.booleanValue());
      return;
    } catch (m paramBoolean) {
      try {
        this.bMK.dp(false);
      } catch (m m) {
        a.e(m);
      } 
      a.e(paramBoolean);
      return;
    } 
  }
  
  public Boolean e(String... paramVarArgs) {
    boolean bool = false;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("开始解析");
      stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
      Log.d("openTable", stringBuilder.toString());
      boolean bool1 = b.iV(paramVarArgs[0]);
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("结束解析");
        stringBuilder1.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
        Log.d("openTable", stringBuilder1.toString());
      } catch (Exception paramVarArgs) {}
    } catch (Exception paramVarArgs) {
      boolean bool1 = bool;
    } 
    a.e(paramVarArgs);
  }
  
  public void onPreExecute() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */