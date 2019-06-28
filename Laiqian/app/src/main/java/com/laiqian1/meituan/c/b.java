package com.laiqian.meituan.c;

import com.laiqian.meituan.d.a;
import com.laiqian.meituan.d.b;
import java.util.HashMap;
import java.util.Map;

public class b {
  public static Map<String, String> a(a parama) {
    HashMap hashMap = new HashMap();
    hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
    hashMap.put("app_id", parama.PL());
    hashMap.put("appSecret", parama.PM());
    hashMap.put("callback_url", parama.PK());
    return hashMap;
  }
  
  public static Map<String, String> a(b paramb) {
    HashMap hashMap = new HashMap();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramb.timestamp);
    stringBuilder.append("");
    hashMap.put("timestamp", stringBuilder.toString());
    hashMap.put("appAuthToken", paramb.bss);
    paramb.getClass();
    hashMap.put("version", "1");
    paramb.getClass();
    hashMap.put("charset", "UTF-8");
    return hashMap;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */