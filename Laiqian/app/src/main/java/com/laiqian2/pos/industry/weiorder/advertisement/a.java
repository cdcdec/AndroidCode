package com.laiqian.pos.industry.weiorder.advertisement;

import android.util.Log;
import com.a.a.b.e;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.i;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.n;
import kotlin.e.d;
import kotlin.h;
import kotlin.jvm.b.f;
import kotlin.k;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class a {
  private final void a(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap) {
    paramStringBuilder.delete(0, paramStringBuilder.length());
    Map map1 = (Map)paramHashMap;
    Map map2 = (Map)new LinkedHashMap(n.rk(map1.size()));
    Iterator iterator = ((Iterable)map1.entrySet()).iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      StringBuilder stringBuilder;
      Map.Entry entry = (Map.Entry)iterator.next();
      if (bool) {
        paramStringBuilder.append("?");
        paramStringBuilder.append((String)entry.getKey());
        paramStringBuilder.append("=");
        paramStringBuilder.append((String)entry.getValue());
        stringBuilder = k.faa;
        bool = false;
      } else {
        paramStringBuilder.append("&");
        paramStringBuilder.append((String)entry.getKey());
        paramStringBuilder.append("=");
        paramStringBuilder.append((String)entry.getValue());
        stringBuilder = paramStringBuilder;
      } 
      map2.put(stringBuilder, entry.getValue());
    } 
  }
  
  private final i kf(String paramString) {
    HashMap hashMap = au.qC(paramString);
    boolean bool2 = hashMap.containsKey("msg");
    boolean bool1 = false;
    if (bool2 && hashMap.containsKey("error")) {
      int i = by.parseInt((String)hashMap.get("error"));
      if (i == 0)
        bool1 = true; 
      return new i(bool1, i, (String)hashMap.get("msg"));
    } 
    return new i(false, false, "");
  }
  
  @NotNull
  public i act() {
    try {
      LinkedHashMap linkedHashMap = new LinkedHashMap();
      null = (Map)linkedHashMap;
      null = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date(System.currentTimeMillis()));
      f.l(null, "SimpleDateFormat(\"yyyyMM…tem.currentTimeMillis()))");
      null.put("time", null);
      ((Map)linkedHashMap).put("version", "1");
      null = (Map)linkedHashMap;
      null = RootApplication.getLaiqianPreferenceManager();
      f.l(null, "RootApplication.getLaiqianPreferenceManager()");
      null = null.Tx();
      f.l(null, "RootApplication.getLaiqi…referenceManager().shopId");
      null.put("xpj_shop_id", null);
      StringBuilder stringBuilder2 = new StringBuilder();
      null = (Map)linkedHashMap;
      Map map = (Map)new LinkedHashMap(n.rk(null.size()));
      for (Object object : (Iterable)null.entrySet()) {
        Map.Entry entry = (Map.Entry)object;
        stringBuilder2.append((String)entry.getKey());
        stringBuilder2.append((String)entry.getValue());
        map.put(stringBuilder2, ((Map.Entry)object).getValue());
      } 
      stringBuilder2.append("cjgohnuoeCziiWSz");
      map = (Map)linkedHashMap;
      String str3 = stringBuilder2.toString();
      f.l(str3, "sign.toString()");
      Charset charset = d.UTF_8;
      if (str3 == null)
        throw new h("null cannot be cast to non-null type java.lang.String"); 
      byte[] arrayOfByte = str3.getBytes(charset);
      f.l(arrayOfByte, "(this as java.lang.String).getBytes(charset)");
      String str2 = e.g(arrayOfByte);
      if (str2 == null)
        f.aQI(); 
      if (str2 == null)
        throw new h("null cannot be cast to non-null type java.lang.String"); 
      str2 = str2.toLowerCase();
      f.l(str2, "(this as java.lang.String).toLowerCase()");
      map.put("sign", str2);
      a(stringBuilder2, (HashMap)linkedHashMap);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("https://xiao-oauth.buslive.cn/xpj/shop/status");
      stringBuilder1.append(stringBuilder2.toString());
      String str1 = bd.rV(stringBuilder1.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("https://xiao-oauth.buslive.cn/xpj/shop/status 返回结果： ");
      stringBuilder2.append(str1);
      Log.e("AdvertisementResult", stringBuilder2.toString());
      f.l(str1, "result");
      return kf(str1);
    } catch (Exception exception) {
      a.e(exception);
      return new i(false, false, "");
    } 
  }
  
  @NotNull
  public i kd(@NotNull String paramString) {
    f.m(paramString, "userPhone");
    try {
      null = new LinkedHashMap();
      ((Map)null).put("origin_manager_phone", paramString);
      Map map1 = (Map)null;
      null = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date(System.currentTimeMillis()));
      f.l(null, "SimpleDateFormat(\"yyyyMM…tem.currentTimeMillis()))");
      map1.put("time", null);
      ((Map)null).put("version", "1");
      StringBuilder stringBuilder2 = new StringBuilder();
      null = (Map)null;
      map1 = (Map)new LinkedHashMap(n.rk(null.size()));
      for (Object object : (Iterable)null.entrySet()) {
        Map.Entry entry = (Map.Entry)object;
        stringBuilder2.append((String)entry.getKey());
        stringBuilder2.append((String)entry.getValue());
        map1.put(stringBuilder2, ((Map.Entry)object).getValue());
      } 
      stringBuilder2.append("cjgohnuoeCziiWSz");
      map1 = (Map)null;
      null = stringBuilder2.toString();
      f.l(null, "sign.toString()");
      Charset charset = d.UTF_8;
      if (null == null)
        throw new h("null cannot be cast to non-null type java.lang.String"); 
      null = null.getBytes(charset);
      f.l(null, "(this as java.lang.String).getBytes(charset)");
      null = e.g(null);
      if (null == null)
        f.aQI(); 
      if (null == null)
        throw new h("null cannot be cast to non-null type java.lang.String"); 
      null = null.toLowerCase();
      f.l(null, "(this as java.lang.String).toLowerCase()");
      map1.put("sign", null);
      stringBuilder2.delete(0, stringBuilder2.length());
      boolean bool = true;
      map1 = (Map)null;
      Map map2 = (Map)new LinkedHashMap(n.rk(map1.size()));
      for (Object object : (Iterable)map1.entrySet()) {
        StringBuilder stringBuilder = (Map.Entry)object;
        if (bool) {
          k k;
          stringBuilder2.append("?");
          stringBuilder2.append((String)stringBuilder.getKey());
          stringBuilder2.append("=");
          stringBuilder2.append((String)stringBuilder.getValue());
          stringBuilder = k.faa;
          bool = false;
        } else {
          stringBuilder2.append("&");
          stringBuilder2.append((String)stringBuilder.getKey());
          stringBuilder2.append("=");
          stringBuilder2.append((String)stringBuilder.getValue());
          stringBuilder = stringBuilder2;
        } 
        map2.put(stringBuilder, ((Map.Entry)object).getValue());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("https://xiao-oauth.buslive.cn/xpj/check");
      stringBuilder1.append(stringBuilder2.toString());
      String str = bd.rV(stringBuilder1.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("https://xiao-oauth.buslive.cn/xpj/check 返回结果： ");
      stringBuilder2.append(str);
      Log.e("AdvertisementResult", stringBuilder2.toString());
      f.l(str, "result");
      return kf(str);
    } catch (Exception paramString) {
      a.e(paramString);
      return new i(false, false, "");
    } 
  }
  
  @NotNull
  public i ke(@NotNull String paramString) {
    f.m(paramString, "userPhone");
    try {
      LinkedHashMap linkedHashMap = new LinkedHashMap();
      ((Map)linkedHashMap).put("origin_manager_phone", paramString);
      null = (Map)linkedHashMap;
      null = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date(System.currentTimeMillis()));
      f.l(null, "SimpleDateFormat(\"yyyyMM…tem.currentTimeMillis()))");
      null.put("time", null);
      ((Map)linkedHashMap).put("version", "1");
      null = (Map)linkedHashMap;
      null = RootApplication.getLaiqianPreferenceManager();
      f.l(null, "RootApplication.getLaiqianPreferenceManager()");
      null = null.Tx();
      f.l(null, "RootApplication.getLaiqi…referenceManager().shopId");
      null.put("xpj_shop_id", null);
      StringBuilder stringBuilder1 = new StringBuilder();
      null = (Map)linkedHashMap;
      Map map = (Map)new LinkedHashMap(n.rk(null.size()));
      for (Object object : (Iterable)null.entrySet()) {
        Map.Entry entry = (Map.Entry)object;
        stringBuilder1.append((String)entry.getKey());
        stringBuilder1.append((String)entry.getValue());
        map.put(stringBuilder1, ((Map.Entry)object).getValue());
      } 
      stringBuilder1.append("cjgohnuoeCziiWSz");
      map = (Map)linkedHashMap;
      String str2 = stringBuilder1.toString();
      f.l(str2, "sign.toString()");
      Charset charset = d.UTF_8;
      if (str2 == null)
        throw new h("null cannot be cast to non-null type java.lang.String"); 
      byte[] arrayOfByte = str2.getBytes(charset);
      f.l(arrayOfByte, "(this as java.lang.String).getBytes(charset)");
      String str1 = e.g(arrayOfByte);
      if (str1 == null)
        f.aQI(); 
      if (str1 == null)
        throw new h("null cannot be cast to non-null type java.lang.String"); 
      str1 = str1.toLowerCase();
      f.l(str1, "(this as java.lang.String).toLowerCase()");
      map.put("sign", str1);
      str1 = bd.d("https://xiao-oauth.buslive.cn/xpj/bind", (HashMap)linkedHashMap);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("https://xiao-oauth.buslive.cn/xpj/bind 返回结果： ");
      stringBuilder2.append(str1);
      Log.e("AdvertisementResult", stringBuilder2.toString());
      f.l(str1, "result");
      return kf(str1);
    } catch (Exception paramString) {
      a.e(paramString);
      return new i(false, false, "");
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisement\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */