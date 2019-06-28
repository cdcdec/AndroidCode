package com.laiqian.meituan.test;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import com.laiqian.meituan.R;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
  long aST = System.currentTimeMillis();
  
  public TextView bqW;
  
  public TextView brY;
  
  public int bsd = 0;
  
  public String bse = "http://pos-pre-wallet-hch.91laiqian.com/order/pending";
  
  public String bsf = "http://pos-pre-wallet-hch.91laiqian.com/order/all";
  
  public String bsg = "http://pos-pre-wallet-hch.91laiqian.com/mt/push";
  
  public long bsh;
  
  public long bsi;
  
  public int bsj;
  
  public Context context;
  
  int count = 0;
  
  Handler handler = new l(this);
  
  public h(Context paramContext, TextView paramTextView1, TextView paramTextView2) {
    this.context = paramContext;
    this.bqW = paramTextView1;
    this.brY = paramTextView2;
  }
  
  public static String c(Context paramContext, boolean paramBoolean) {
    av = new av(paramContext);
    str1 = av.Ea();
    String str2 = av.atr();
    if ("".equals(str1))
      return null; 
    JSONObject jSONObject = new JSONObject();
    if (!paramBoolean)
      try {
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("sName", str1);
        jSONObject1.put("sPwd", str2);
        jSONObject.put("weixin", jSONObject1);
        if (av.auW()) {
          jSONObject1 = new JSONObject();
          jSONObject1.put("sName", str1);
          jSONObject1.put("sPwd", str2);
          jSONObject.put("koubei", jSONObject1);
        } 
        jSONObject1 = new JSONObject();
        jSONObject1.put("sName", str1);
        jSONObject1.put("sPwd", str2);
        jSONObject.put("weixin_eat_in", jSONObject1);
        jSONObject1 = new JSONObject();
        jSONObject1.put("sName", str1);
        jSONObject1.put("sPwd", str2);
        jSONObject.put("meituan", jSONObject1);
      } catch (JSONException str1) {
        a.e(str1);
      }  
    av.close();
    try {
      if (jSONObject.length() > 0)
        return b.encode(jSONObject.toString()); 
    } catch (Exception av) {
      a.e(av);
    } 
    return "";
  }
  
  public void PG() {
    this.bsh = 0L;
    byte b = 0;
    this.count = 0;
    while (b < this.bsd) {
      a.aKh().r(new i(this));
      b++;
    } 
  }
  
  public void PH() {
    this.bsh = 0L;
    this.count = 0;
    for (byte b = 0; b < this.bsd; b++) {
      HashMap hashMap = new HashMap();
      hashMap.put("c", c(this.context, false));
      hashMap.put("shopid", RootApplication.getLaiqianPreferenceManager().Tx());
      hashMap.put("page", "no");
      hashMap.put("language", (this.context.getResources().getConfiguration()).locale.toString());
      hashMap.put("client_type", this.context.getString(R.string.version_name));
      a.aKh().r(new j(this, hashMap));
    } 
  }
  
  public void PI() {
    this.bsh = 0L;
    this.count = 0;
    for (byte b = 0; b < this.bsd; b++) {
      HashMap hashMap = new HashMap();
      hashMap.put("c", c(this.context, false));
      hashMap.put("shopid", RootApplication.getLaiqianPreferenceManager().Tx());
      hashMap.put("page", "no");
      hashMap.put("language", (this.context.getResources().getConfiguration()).locale.toString());
      hashMap.put("client_type", this.context.getString(R.string.version_name));
      a.aKh().r(new k(this, hashMap));
    } 
  }
  
  public void fg(int paramInt) { this.bsd = paramInt; }
  
  public void fh(int paramInt) { this.bsj = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\test\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */