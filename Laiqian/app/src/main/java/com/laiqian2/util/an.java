package com.laiqian.util;

import android.content.res.AssetManager;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.e;
import com.orhanobut.logger.d;
import hugo.weaving.DebugLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class an {
  private static int Y(HashMap<String, e> paramHashMap) {
    Iterator iterator = paramHashMap.entrySet().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += e.EF() + Y(e.EI()))
      e e = (e)((Map.Entry)iterator.next()).getValue(); 
    return i;
  }
  
  private static JSONArray Z(HashMap<String, e> paramHashMap) throws JSONException {
    null = paramHashMap.entrySet();
    JSONArray jSONArray = new JSONArray();
    Iterator iterator = null.iterator();
    while (iterator.hasNext())
      jSONArray.put(b((e)((Map.Entry)iterator.next()).getValue())); 
    return jSONArray;
  }
  
  private static e a(String paramString, JSONArray paramJSONArray, e parame) throws JSONException {
    HashMap hashMap = new HashMap();
    e e1 = null;
    for (byte b = 0; b < paramJSONArray.length(); b++) {
      JSONObject jSONObject = paramJSONArray.getJSONObject(b);
      String str = jSONObject.getString("id");
      e1 = new e(by.parseLong(str), by.parseInt(jSONObject.getString("clickTimes")), by.parseLong(paramString));
      e1.cV(jSONObject.getString("name"));
      hashMap.put(str, e1);
      a(str, jSONObject.getJSONArray("subset"), e1);
    } 
    if (parame != null)
      parame.k(hashMap); 
    return e1;
  }
  
  private static JSONArray a(e parame) throws JSONException {
    JSONArray jSONArray = new JSONArray();
    jSONArray.put(b(parame));
    return jSONArray;
  }
  
  public static void a(String paramString, a parama) {
    boolean bool2 = by.isNull(paramString);
    boolean bool1 = false;
    if (bool2) {
      if (parama != null) {
        parama.dr(false);
        return;
      } 
    } else {
      try {
        e e = asU();
        if (e == null && parama != null) {
          parama.dr(false);
          return;
        } 
        if (paramString.equals("100001")) {
          if (Y(e.EI()) > 0)
            bool1 = true; 
          parama.dr(bool1);
          return;
        } 
        a(paramString, e.EI(), parama);
        return;
      } catch (JSONException paramString) {
        a.e(paramString);
      } 
    } 
  }
  
  private static void a(String paramString, HashMap<String, e> paramHashMap, int paramInt) {
    Iterator iterator = paramHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      e e = (e)((Map.Entry)iterator.next()).getValue();
      if (by.parseLong(paramString) == e.EG()) {
        e.eq(e.EF() - paramInt);
        return;
      } 
      a(paramString, e.EI(), paramInt);
    } 
  }
  
  private static void a(String paramString, HashMap<String, e> paramHashMap, a parama) {
    Iterator iterator = paramHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      e e = (e)((Map.Entry)iterator.next()).getValue();
      if (by.parseLong(paramString) == e.EG()) {
        if (parama != null) {
          boolean bool;
          if (e.EF() + Y(e.EI()) > 0) {
            bool = true;
          } else {
            bool = false;
          } 
          parama.dr(bool);
        } 
        return;
      } 
      a(paramString, e.EI(), parama);
    } 
  }
  
  @DebugLog
  public static void asT() {
    av av = new av(RootApplication.zv());
    double d = ch.cf(RootApplication.zv());
    if (d > Double.valueOf(av.atn()).doubleValue()) {
      boolean bool = av.rL(qv("FunctionHint"));
      av.bi(d);
      d.b("初始化完成", new Object[] { Boolean.valueOf(bool) });
    } 
    av.close();
  }
  
  private static e asU() throws JSONException {
    av av = new av(RootApplication.zv());
    String str2 = av.awl();
    String str1 = str2;
    if (by.isNull(str2)) {
      str1 = qv("FunctionHint");
      new JSONArray();
      av.rL(str1);
    } 
    av.close();
    return a("0", new JSONArray(str1), null);
  }
  
  private static JSONObject b(e parame) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("id", parame.EG());
    jSONObject.put("name", parame.EH());
    jSONObject.put("clickTimes", parame.EF());
    jSONObject.put("subset", Z(parame.EI()));
    return jSONObject;
  }
  
  public static void qt(String paramString) {
    if (by.isNull(paramString))
      return; 
    try {
      e e = asU();
      if (e == null)
        return; 
      a(paramString, e.EI(), 1);
      qw(a(e).toString());
      return;
    } catch (Exception paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  public static void qu(String paramString) {
    if (by.isNull(paramString))
      return; 
    try {
      e e = asU();
      if (e == null)
        return; 
      a(paramString, e.EI(), -1);
      qw(a(e).toString());
      return;
    } catch (Exception paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  private static String qv(String paramString) {
    try {
      AssetManager assetManager = RootApplication.zv().getAssets();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(".json");
      InputStream inputStream = assetManager.open(stringBuilder.toString());
      byte[] arrayOfByte = new byte[inputStream.available()];
      inputStream.read(arrayOfByte);
      inputStream.close();
      return new String(arrayOfByte, "utf-8");
    } catch (IOException paramString) {
      a.e(paramString);
      return "{}";
    } 
  }
  
  private static void qw(String paramString) {
    av av = new av(RootApplication.zv());
    av.rL(paramString);
    av.close();
  }
  
  public static interface a {
    void dr(boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */