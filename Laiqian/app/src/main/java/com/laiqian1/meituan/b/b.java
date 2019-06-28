package com.laiqian.meituan.b;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.meituan.c.a;
import com.laiqian.meituan.c.b;
import com.laiqian.meituan.c.d;
import com.laiqian.meituan.c.e;
import com.laiqian.meituan.d.a;
import com.laiqian.meituan.d.b;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.industry.a;
import com.laiqian.util.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class b {
  private static String brP = "";
  
  static  {
  
  }
  
  public static String PF() {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(a.cqW);
    stringBuilder2.append("/");
    stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().Tx());
    String str1 = stringBuilder2.toString();
    null = new StringBuilder();
    null.append(RootUrlParameter.cln);
    null.append("/erp/login?code=");
    String str2 = null.toString();
    null = new a("276", "a7276865d6fb23e41a99783962185010", str1);
    String str3 = b(b.a(null), null);
    StringBuilder stringBuilder3 = e.fq(str3);
    null = str3.replaceAll(null.PM(), "");
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append(null);
    stringBuilder5.append("&sig=");
    stringBuilder5.append(stringBuilder3);
    stringBuilder3 = stringBuilder5.toString();
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("app_id=244&callback_url=");
    stringBuilder4.append(str1);
    stringBuilder4.append("&timestamp=1462935671&sig=25facd70e9e605d1b11ef0dc29c98305");
    stringBuilder4.toString();
    stringBuilder3 = fo(stringBuilder3);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("encryptStr1=");
    stringBuilder1.append(stringBuilder3);
    Log.e("sUrl", stringBuilder1.toString());
    try {
      String str = URLEncoder.encode(stringBuilder3, "UTF-8");
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("encryptStr2=");
        stringBuilder.append(str);
        Log.e("sUrl", stringBuilder.toString());
      } catch (UnsupportedEncodingException null) {}
    } catch (UnsupportedEncodingException stringBuilder4) {
      String str = stringBuilder3;
      stringBuilder3 = stringBuilder4;
    } 
    a.e(stringBuilder3);
  }
  
  public static String a(b paramb, Map<String, String> paramMap) {
    str = c(b.a(paramb), paramMap);
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.clc);
      stringBuilder.append(str.replaceAll("&", "").replaceAll("=", ""));
      return d.fp(stringBuilder.toString()).toLowerCase();
    } catch (Exception str) {
      a.e(str);
      return null;
    } 
  }
  
  public static String b(String paramString1, String paramString2, Map<String, String> paramMap) {
    b b1 = new b(paramString2, System.currentTimeMillis() / 1000L);
    paramString2 = c(b.a(b1), paramMap);
    String str = a(b1, paramMap);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString2);
    stringBuilder2.append("&sign=");
    stringBuilder2.append(str.toLowerCase());
    paramString2 = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString1);
    stringBuilder1.append("?");
    stringBuilder1.append(paramString2);
    return stringBuilder1.toString();
  }
  
  public static String b(Map<String, String> paramMap1, Map<String, String> paramMap2) {
    HashMap hashMap = new HashMap();
    hashMap.putAll(paramMap1);
    if (paramMap2 != null)
      hashMap.putAll(paramMap2); 
    String str = q(hashMap);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("concatParams:");
    stringBuilder.append(str);
    Log.e("sUrl", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append((String)paramMap1.get("appSecret"));
    return stringBuilder.toString();
  }
  
  public static String c(Map<String, String> paramMap1, Map<String, String> paramMap2) {
    HashMap hashMap = new HashMap();
    hashMap.putAll(paramMap1);
    if (paramMap2 != null)
      hashMap.putAll(paramMap2); 
    String str = r(hashMap);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("concatParams:");
    stringBuilder.append(str);
    Log.e("sUrl", stringBuilder.toString());
    return str;
  }
  
  public static String ff(int paramInt) {
    String str2;
    switch (paramInt) {
      case 2:
        str2 = a.brO;
        break;
      case 1:
        str2 = a.brN;
        break;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("businessId=");
    stringBuilder1.append(paramInt);
    stringBuilder1.append("&developerId=");
    stringBuilder1.append(RootUrlParameter.clb);
    stringBuilder1.append("&ePoiId=");
    stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().Tx());
    stringBuilder1.append("&timestamp=");
    stringBuilder1.append(System.currentTimeMillis());
    String str3 = stringBuilder1.toString();
    String str1 = "";
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.clc);
      stringBuilder.append(str3.replaceAll("&", "").replaceAll("=", ""));
      String str = d.fp(stringBuilder.toString()).toLowerCase();
      str1 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("https://open-erp.meituan.com/storemap?");
    stringBuilder2.append(str3);
    stringBuilder2.append("&sign=");
    stringBuilder2.append(str1);
    return stringBuilder2.toString();
  }
  
  private static String fo(String paramString) {
    byte[] arrayOfByte = a.b(paramString, "626f696ea35ed669".getBytes());
    return (arrayOfByte != null) ? a.e(arrayOfByte) : null;
  }
  
  private static String q(Map<String, String> paramMap) {
    Object[] arrayOfObject = paramMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    String str = "";
    int i = arrayOfObject.length;
    for (byte b1 = 0; b1 < i; b1++) {
      Object object = arrayOfObject[b1];
      if (!object.equals("appSecret")) {
        String str1 = (String)paramMap.get(object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&");
        stringBuilder.append(object);
        stringBuilder.append("=");
        stringBuilder.append(str1);
        str = stringBuilder.toString();
      } 
    } 
    return str.replaceFirst("&", "");
  }
  
  private static String r(Map<String, String> paramMap) {
    Object[] arrayOfObject = paramMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    String str = "";
    int i = arrayOfObject.length;
    for (byte b1 = 0; b1 < i; b1++) {
      Object object = arrayOfObject[b1];
      String str1 = (String)paramMap.get(object);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("&");
      stringBuilder.append(object);
      stringBuilder.append("=");
      stringBuilder.append(str1);
      str = stringBuilder.toString();
    } 
    return str.replaceFirst("&", "");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */