package com.laiqian;

import android.content.Context;
import android.text.TextUtils;
import com.a.a.b.e;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.network.k;
import com.laiqian.util.ai;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class f {
  public static void a(Context paramContext, a parama) {
    try {
      if (a.zR().Aj()) {
        b(paramContext, parama);
        return;
      } 
      c(paramContext, parama);
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
  
  private static void b(Context paramContext, a parama) {
    if (TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awi()) || TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awh())) {
      HashMap hashMap = new HashMap();
      hashMap.put("client", "sabao");
      String str2 = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
      hashMap.put("timeStr", str2);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(System.currentTimeMillis() % 100000000L);
      stringBuilder1.append("");
      String str3 = stringBuilder1.toString();
      hashMap.put("nonceStr", str3);
      String str1 = (ai.bU(paramContext.getApplicationContext())).aYL;
      hashMap.put("deviceCode", str1);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("client=sabao&deviceCode=");
      stringBuilder2.append(str1);
      stringBuilder2.append("&nonceStr=");
      stringBuilder2.append(str3);
      stringBuilder2.append("&timeStr=");
      stringBuilder2.append(str2);
      hashMap.put("sign", e.g(stringBuilder2.toString().getBytes()).toLowerCase());
      k.a(hashMap, "https://device.wuzhenpay.com/device/active", new g(parama));
    } 
  }
  
  private static void c(Context paramContext, a parama) {
    if (TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awi()) || TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awh())) {
      HashMap hashMap = new HashMap();
      hashMap.put("client", "fast");
      hashMap.put("appid", "CD7832D56SD6723");
      String str = (ai.bU(paramContext.getApplicationContext())).aYL;
      hashMap.put("code", str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("appid=");
      stringBuilder.append("CD7832D56SD6723");
      stringBuilder.append("&client=fast&code=");
      stringBuilder.append(str);
      stringBuilder.append("&appid=");
      stringBuilder.append("CD7832D56SD6723");
      hashMap.put("sign", e.g(stringBuilder.toString().getBytes()).toLowerCase());
      k.a(hashMap, "https://chuanbei-api.wuzhenpay.com/storev3/?service=Login.activation", new h(parama));
    } 
  }
  
  public static void e(HashMap<String, String> paramHashMap) {
    if (a.zR().Aj()) {
      paramHashMap.put("token", RootApplication.getLaiqianPreferenceManager().awh());
      paramHashMap.put("merchant_id", RootApplication.getLaiqianPreferenceManager().awi());
      paramHashMap.put("device_code", (ai.bU(RootApplication.zv())).aYL);
    } 
    if (a.zR().Al()) {
      paramHashMap.put("token", RootApplication.getLaiqianPreferenceManager().awh());
      paramHashMap.put("branch_id", RootApplication.getLaiqianPreferenceManager().awi());
      paramHashMap.put("client_version", "2");
    } 
  }
  
  public static interface a {
    void wS();
    
    void wT();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */