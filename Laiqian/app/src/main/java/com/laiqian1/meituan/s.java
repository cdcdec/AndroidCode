package com.laiqian.meituan;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import b.aa;
import b.ae;
import b.aj;
import b.t;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.meituan.b.a;
import com.laiqian.meituan.b.b;
import com.laiqian.meituan.d.b;
import com.laiqian.models.an;
import com.laiqian.network.j;
import com.laiqian.pos.industry.a;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class s {
  public static HashMap<String, Object> a(String paramString1, int paramInt, String paramString2) {
    try {
      if (a.AZ().BI() == null)
        return null; 
      new b(a.AZ().BI(), System.currentTimeMillis() / 1000L);
      String str3 = new an(RootApplication.zv());
      an.c c = str3.Vu();
      str3.close();
      if (c.aVs.length() > 32) {
        String str = c.aVs.substring(0, 32);
      } else {
        str3 = c.aVs;
      } 
      HashMap hashMap = new HashMap();
      hashMap.put("couponCode", paramString1);
      hashMap.put("eId", RootApplication.getLaiqianPreferenceManager().Tx());
      hashMap.put("eName", str3);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramInt);
      stringBuilder2.append("");
      hashMap.put("count", stringBuilder2.toString());
      hashMap.put("eOrderId", paramString2);
      String str1 = b.b(a.brL, a.AZ().BI(), hashMap);
      aa aa = j.adg.aSL().k(10L, TimeUnit.SECONDS).l(10L, TimeUnit.SECONDS).aSM();
      t t = (new t.a()).aRU();
      String str2 = aa.a((new ae.a()).uS(str1).a(t).aSZ()).aRI().aTc().aTk();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("requestUrl=====");
      stringBuilder3.append(str1);
      Log.d("url", stringBuilder3.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("response=====");
      stringBuilder1.append(str2);
      Log.d("response", stringBuilder1.toString());
      return au.qB(str2);
    } catch (Exception paramString1) {
      a.e(paramString1);
      return null;
    } 
  }
  
  public static HashMap<String, Object> a(String paramString, boolean paramBoolean, Context paramContext) {
    try {
      if (a.AZ().BI() == null)
        return null; 
      String str = new b(paramString, System.currentTimeMillis() / 1000L);
      aa aa = j.adg.aSL().k(10L, TimeUnit.SECONDS).l(10L, TimeUnit.SECONDS).aSM();
      t.a a = (new t.a()).bO("appAuthToken", str.bss);
      str.getClass();
      a = a.bO("charset", "UTF-8");
      str.getClass();
      a = a.bO("version", "1");
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str.timestamp);
      stringBuilder2.append("");
      t t = a.bO("timestamp", stringBuilder2.toString()).bO("sign", b.a(str, null)).aRU();
      ae.a a1 = new ae.a();
      if (paramBoolean) {
        String str1 = a.brC;
      } else {
        str = a.brB;
      } 
      str = aa.a(a1.uS(str).a(t).aSZ()).aRI().aTc().aTk();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("response=====");
      stringBuilder1.append(str);
      Log.d("response", stringBuilder1.toString());
      return au.qB(str);
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
  
  public static HashMap<String, Object> aB(Context paramContext) {
    try {
      HashMap hashMap = new HashMap();
      av av = RootApplication.getLaiqianPreferenceManager();
      String str2 = av.Ea();
      String str3 = av.atr();
      String str4 = av.Tx();
      av.close();
      hashMap.put("user_name", str2);
      hashMap.put("password", str3);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str4);
      hashMap.put("version", "1");
      String str1 = bh.a(a.cqV, paramContext, hashMap);
      if (!TextUtils.isEmpty(str1)) {
        HashMap hashMap1 = au.qB(str1);
        return (hashMap1 != null) ? hashMap1 : null;
      } 
      return null;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public static String b(String paramString, Context paramContext) {
    if (paramString == null)
      return null; 
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("ePoiIds", RootApplication.getLaiqianPreferenceManager().Tx());
      paramString = b.b(a.brA, paramString, hashMap);
      Log.e("requestUrl", paramString);
      aj aj = j.adg.a((new ae.a()).uS(paramString).bY("User-Agent", "OkHttp Example").aSZ()).aRI();
      String str = aj.aTc().aTk();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("response=====");
      stringBuilder.append(str);
      Log.d("response", stringBuilder.toString());
      aj.aTc().close();
      return str;
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
  
  public static HashMap<String, Object> fl(String paramString) {
    try {
      if (a.AZ().BI() == null)
        return null; 
      new b(a.AZ().BI(), System.currentTimeMillis() / 1000L);
      String str = new an(RootApplication.zv());
      an.c c = str.Vu();
      str.close();
      if (c.aVs.length() > 32) {
        String str1 = c.aVs.substring(0, 32);
      } else {
        str = c.aVs;
      } 
      HashMap hashMap = new HashMap();
      hashMap.put("couponCode", paramString);
      hashMap.put("type", "1");
      hashMap.put("eId", RootApplication.getLaiqianPreferenceManager().Tx());
      hashMap.put("eName", str);
      paramString = b.b(a.brJ, a.AZ().BI(), hashMap);
      aa aa = j.adg.aSL().k(10L, TimeUnit.SECONDS).l(10L, TimeUnit.SECONDS).aSM();
      t t = (new t.a()).aRU();
      paramString = aa.a((new ae.a()).uS(paramString).a(t).aSZ()).aRI().aTc().aTk();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("response=====");
      stringBuilder.append(paramString);
      Log.d("response", stringBuilder.toString());
      return au.qB(paramString);
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
  
  public static HashMap<String, Object> fm(String paramString) {
    try {
      if (a.AZ().BI() == null)
        return null; 
      new b(a.AZ().BI(), System.currentTimeMillis() / 1000L);
      HashMap hashMap = new HashMap();
      hashMap.put("couponCode", paramString);
      paramString = b.b(a.brK, a.AZ().BI(), hashMap);
      aa aa = j.adg.aSL().k(10L, TimeUnit.SECONDS).l(10L, TimeUnit.SECONDS).aSM();
      t t = (new t.a()).aRU();
      String str = aa.a((new ae.a()).uS(paramString).a(t).aSZ()).aRI().aTc().aTk();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("response=====");
      stringBuilder.append(str);
      Log.d("response", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("requestUrl=====");
      stringBuilder.append(paramString);
      Log.d("url", stringBuilder.toString());
      return au.qB(str);
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */