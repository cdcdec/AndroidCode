package com.laiqian.meituan;

import android.content.Context;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.industry.a;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class g {
  public static String[] C(ArrayList<i> paramArrayList) {
    if (paramArrayList == null || paramArrayList.size() == 0)
      return null; 
    String[] arrayOfString = new String[paramArrayList.size()];
    for (byte b = 0; b < paramArrayList.size(); b++)
      arrayOfString[b] = ((i)paramArrayList.get(b)).bpR; 
    return arrayOfString;
  }
  
  public static Boolean a(String paramString1, String paramString2, Context paramContext) {
    try {
      HashMap hashMap = new HashMap();
      av av = RootApplication.getLaiqianPreferenceManager();
      String str1 = av.Ea();
      String str2 = av.atr();
      String str3 = av.auU();
      String str4 = av.Tx();
      av.close();
      hashMap.put("meituan_shop_ids", paramString1);
      hashMap.put("clientId", str3);
      if (paramString2 != null)
        hashMap.put("token", paramString2); 
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str4);
      hashMap.put("version", "1");
      paramString1 = bh.a(a.cqU, paramContext, hashMap);
      return !TextUtils.isEmpty(paramString1) ? Boolean.valueOf((new JSONObject(paramString1)).optBoolean("result")) : Boolean.valueOf(false);
    } catch (Exception paramString1) {
      a.e(paramString1);
      return Boolean.valueOf(false);
    } 
  }
  
  public static HashMap<String, Object> a(String paramString, boolean paramBoolean, Context paramContext) {
    try {
      HashMap hashMap = new HashMap();
      av av = RootApplication.getLaiqianPreferenceManager();
      String str2 = av.Ea();
      String str3 = av.atr();
      av.auU();
      String str4 = av.Tx();
      av.close();
      hashMap.put("app_poi_code", paramString);
      null = new StringBuilder();
      null.append(paramBoolean);
      null.append("");
      hashMap.put("is_open", null.toString());
      hashMap.put("user_name", str2);
      hashMap.put("password", str3);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str4);
      hashMap.put("version", "1");
      String str1 = bh.a(a.cqX, paramContext, hashMap);
      return !TextUtils.isEmpty(str1) ? au.qB(str1) : null;
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
  
  public static HashMap<String, Object> aA(Context paramContext) {
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
      String str1 = bh.a(a.cqY, paramContext, hashMap);
      return !TextUtils.isEmpty(str1) ? au.qB(str1) : null;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public static HashMap<String, Object> az(Context paramContext) {
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
        if (hashMap1 != null) {
          boolean bool = "true".equals(String.valueOf(hashMap1.get("result")));
          if (bool)
            return hashMap1; 
        } 
        return null;
      } 
      return null;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public static String b(String paramString, Context paramContext) {
    try {
      HashMap hashMap = new HashMap();
      av av = RootApplication.getLaiqianPreferenceManager();
      String str1 = av.Ea();
      String str2 = av.atr();
      String str3 = av.Tx();
      av.close();
      hashMap.put("token", paramString);
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "1");
      return bh.a(a.cqT, paramContext, hashMap);
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */