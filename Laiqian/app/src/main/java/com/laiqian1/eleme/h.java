package com.laiqian.eleme;

import android.content.Context;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.industry.a;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.HashMap;
import org.json.JSONObject;

public class h {
  public static Boolean a(String paramString, Context paramContext) {
    try {
      HashMap hashMap = new HashMap();
      av av = RootApplication.getLaiqianPreferenceManager();
      String str1 = av.Ea();
      String str2 = av.atr();
      String str3 = av.auU();
      String str4 = av.Tx();
      av.close();
      hashMap.put("eleme_shop_ids", paramString);
      hashMap.put("clientId", str3);
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str4);
      hashMap.put("version", "1");
      paramString = bh.a(a.cre, paramContext, hashMap);
      return !TextUtils.isEmpty(paramString) ? Boolean.valueOf((new JSONObject(paramString)).optBoolean("result")) : Boolean.valueOf(false);
    } catch (Exception paramString) {
      a.e(paramString);
      return Boolean.valueOf(false);
    } 
  }
  
  public static HashMap<String, Object> af(Context paramContext) {
    try {
      HashMap hashMap = new HashMap();
      av av = new av(paramContext);
      String str2 = av.Ea();
      String str3 = av.atr();
      String str4 = av.Tx();
      av.close();
      hashMap.put("user_name", str2);
      hashMap.put("password", str3);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str4);
      hashMap.put("version", "1");
      String str1 = bh.a(a.crb, paramContext, hashMap);
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
  
  public static String ag(Context paramContext) {
    HashMap hashMap = new HashMap();
    av av = RootApplication.getLaiqianPreferenceManager();
    av.Ea();
    av.atr();
    String str = av.Tx();
    av.close();
    hashMap.put("shop_id", str);
    return bh.a(a.crd, paramContext, hashMap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\eleme\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */