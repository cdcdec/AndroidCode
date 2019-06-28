package com.laiqian.util;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.f.b;
import com.laiqian.h.a;
import com.laiqian.infrastructure.R;
import com.laiqian.network.k;
import com.laiqian.network.t;
import com.laiqian.pos.industry.a;
import com.laiqian.sync.c.a;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.a.a;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.d;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class bh extends bd {
  @Deprecated
  public static String a(String paramString1, Context paramContext, int paramInt, String paramString2, Object paramObject) { return a(paramString1, paramContext, paramInt, paramString2, paramObject, null); }
  
  @Deprecated
  public static String a(String paramString1, Context paramContext, int paramInt, String paramString2, Object paramObject, JSONObject paramJSONObject) {
    new HashMap();
    List list = b(paramContext, paramInt, paramString2, paramObject, paramJSONObject);
    if (list == null)
      return null; 
    String str = a(paramString1, paramContext, list);
    a(paramContext, paramInt, paramString2, paramObject, paramJSONObject).toString();
    new k();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("url=");
    stringBuilder.append(paramString1);
    stringBuilder.append(",sServiceType=");
    stringBuilder.append(paramInt);
    paramString1 = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("resultString=");
    stringBuilder.append(str);
    stringBuilder.append(",解密");
    stringBuilder.append(b.decode(str));
    bb.e(paramString1, stringBuilder.toString());
    return "".equals(str) ? "" : (("-1".equals(str) || "-2".equals(str) || "-3".equals(str)) ? "-1" : str);
  }
  
  @Deprecated
  @WorkerThread
  public static String a(String paramString, Context paramContext, HashMap<String, String> paramHashMap) {
    if (paramHashMap != null) {
      ArrayList arrayList = new ArrayList();
    } else {
      paramContext = null;
    } 
    Iterator iterator = paramHashMap.entrySet().iterator();
    JSONObject jSONObject = new JSONObject();
    try {
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry)iterator.next();
        String str1 = (String)entry.getKey();
        String str2 = (String)entry.getValue();
        jSONObject.put(str1, str2);
        PrintStream printStream = System.out;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("key=");
        stringBuilder1.append(str1);
        stringBuilder1.append(",val=");
        stringBuilder1.append(str2);
        printStream.println(stringBuilder1.toString());
      } 
      k k = new k();
      paramContext.add(new BasicNameValuePair("laiqian_encrypt", b.cL(jSONObject.toString())));
      paramContext.add(new BasicNameValuePair("industry", a.crh));
      String str = k.d(paramContext, paramString);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendRequestToServer在线搜索会员 url=");
      stringBuilder.append(paramString);
      stringBuilder.append("--params=");
      stringBuilder.append(jSONObject.toString());
      Log.i("OnlineSearchUtil", stringBuilder.toString());
      paramString = str;
      if (!str.equals(Integer.valueOf(-1)))
        paramString = b.cM(str); 
      if ("".equals(paramString))
        return ""; 
      if ("-1".equals(paramString) || "-2".equals(paramString) || "-3".equals(paramString))
        return "-1"; 
      str = paramString;
      if (!paramString.matches("\\{(.*?)\\}")) {
        null = new StringBuilder();
        null.append("3.");
        null.append(paramString);
        Log.e("nStatus", null.toString());
        str = "";
      } 
      return str;
    } catch (Exception paramString) {
      a.e(paramString);
      return "";
    } 
  }
  
  @Deprecated
  public static String a(String paramString, Context paramContext, HashMap<String, String> paramHashMap, int paramInt) {
    if (paramHashMap != null) {
      ArrayList arrayList = new ArrayList();
    } else {
      paramContext = null;
    } 
    Iterator iterator = paramHashMap.entrySet().iterator();
    JSONObject jSONObject = new JSONObject();
    try {
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry)iterator.next();
        String str4 = (String)entry.getKey();
        String str5 = (String)entry.getValue();
        jSONObject.put(str4, str5);
        PrintStream printStream1 = System.out;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("key=");
        stringBuilder1.append(str4);
        stringBuilder1.append(",val=");
        stringBuilder1.append(str5);
        printStream1.println(stringBuilder1.toString());
      } 
      String str3 = b.cL(jSONObject.toString());
      paramContext.add(new BasicNameValuePair(a.dpG, a.crh));
      paramContext.add(new BasicNameValuePair("laiqian_encrypt", str3));
      if (paramContext == null)
        return null; 
      paramString = (new k()).d(paramContext, paramString);
      null = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("返回json");
      stringBuilder.append(paramString);
      null.println(stringBuilder.toString());
      String str2 = b.cM(paramString);
      PrintStream printStream = System.out;
      stringBuilder = new StringBuilder();
      stringBuilder.append("resultString=");
      stringBuilder.append(str2);
      printStream.println(stringBuilder.toString());
      if ("".equals(str2))
        return ""; 
      if ("-1".equals(str2) || "-2".equals(str2) || "-3".equals(str2))
        return "-1"; 
      String str1 = str2;
      if (!str2.matches("\\{(.*?)\\}")) {
        null = new StringBuilder();
        null.append("3.");
        null.append(str2);
        Log.e("nStatus", null.toString());
        str1 = "";
      } 
      return str1;
    } catch (Exception paramString) {
      return null;
    } 
  }
  
  @Deprecated
  public static String a(String paramString, Context paramContext, List<NameValuePair> paramList) { return a(paramString, paramContext, paramList, 30000); }
  
  @Deprecated
  public static String a(String paramString, Context paramContext, List<NameValuePair> paramList, int paramInt) {
    HttpPost httpPost1 = new HttpPost(paramString);
    HttpPost httpPost2 = httpPost1;
    HttpPost httpPost3 = httpPost1;
    HttpPost httpPost4 = httpPost1;
    try {
      d d;
      null = a.aVS().sd(5000).sc(5000).js(true).aVT();
      httpPost2 = httpPost1;
      httpPost3 = httpPost1;
      httpPost4 = httpPost1;
      CloseableHttpClient closeableHttpClient = HttpClients.aXC().d(null).aXB();
      null = null;
      String str2 = null;
      if (httpPost1 != null) {
        str2 = null;
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        if (httpPost1.getURI() != null) {
          str2 = null;
          httpPost2 = httpPost1;
          httpPost3 = httpPost1;
          httpPost4 = httpPost1;
          if (httpPost1.getURI().getHost() != null) {
            str2 = null;
            httpPost2 = httpPost1;
            httpPost3 = httpPost1;
            httpPost4 = httpPost1;
            if (!k.iI(paramString)) {
              httpPost2 = httpPost1;
              httpPost3 = httpPost1;
              httpPost4 = httpPost1;
              str2 = a.Js().I(httpPost1.getURI().getHost());
            } 
          } 
        } 
      } 
      HttpPost httpPost = httpPost1;
      if (str2 != null) {
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        String str = httpPost1.getURI().getHost();
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null = new StringBuilder();
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append("Get IP: ");
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(str2);
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(" for host: ");
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(str);
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(" for url:");
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(paramString);
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(" from HTTPDNS successfully!");
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        Log.d("com.laiqian.util.OnlineSearchUtil", null.toString());
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        httpPost = new HttpPost(paramString.replaceFirst(str, str2));
        try {
          httpPost.setHeader("Host", str);
        } catch (ConnectTimeoutException paramString) {
          httpPost4 = httpPost;
        } catch (ClientProtocolException paramString) {
          httpPost3 = httpPost;
        } catch (IllegalArgumentException paramString) {
          httpPost2 = httpPost;
        } 
      } 
      if (paramList != null) {
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        httpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
      } 
      httpPost2 = httpPost;
      httpPost3 = httpPost;
      httpPost4 = httpPost;
      if (paramString.contains("https")) {
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        System.setProperty("jsse.enableSNIExtension", "false");
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        d = bd.awp().c(httpPost);
      } else {
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        d = closeableHttpClient.c(httpPost);
      } 
      httpPost2 = httpPost;
      httpPost3 = httpPost;
      httpPost4 = httpPost;
      bb.ao(Integer.valueOf(d.getStatusLine().getStatusCode()));
      if (d != null) {
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        if (d.getStatusLine().getStatusCode() != 200) {
          httpPost2 = httpPost;
          httpPost3 = httpPost;
          httpPost4 = httpPost;
          if (d.getStatusLine().getStatusCode() != 400) {
            httpPost2 = httpPost;
            httpPost3 = httpPost;
            httpPost4 = httpPost;
            StringBuilder stringBuilder = new StringBuilder();
            httpPost2 = httpPost;
            httpPost3 = httpPost;
            httpPost4 = httpPost;
            stringBuilder.append("url：");
            httpPost2 = httpPost;
            httpPost3 = httpPost;
            httpPost4 = httpPost;
            stringBuilder.append(httpPost.getURI().toString());
            httpPost2 = httpPost;
            httpPost3 = httpPost;
            httpPost4 = httpPost;
            stringBuilder.append("详情：");
            httpPost2 = httpPost;
            httpPost3 = httpPost;
            httpPost4 = httpPost;
            stringBuilder.append(d.getStatusLine().getStatusCode());
            httpPost2 = httpPost;
            httpPost3 = httpPost;
            httpPost4 = httpPost;
            stringBuilder.append("");
            httpPost2 = httpPost;
            httpPost3 = httpPost;
            httpPost4 = httpPost;
            h.a(new d("com.laiqian.util.OnlineSearchUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
            return "-1";
          } 
        } 
      } 
      httpPost2 = httpPost;
      httpPost3 = httpPost;
      httpPost4 = httpPost;
      String str1 = EntityUtils.toString(d.getEntity(), "UTF-8").trim().replace("\r", "").replace("\n", "");
      httpPost2 = httpPost;
      httpPost3 = httpPost;
      httpPost4 = httpPost;
      bb.ao(str1);
      return str1;
    } catch (ConnectTimeoutException paramString) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url：");
      stringBuilder.append(httpPost4.getURI().toString());
      stringBuilder.append("详情：");
      stringBuilder.append(paramString.toString());
      h.a(new d("com.laiqian.util.OnlineSearchUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
      a.e(paramString);
      return "-1";
    } catch (ClientProtocolException paramString) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url：");
      stringBuilder.append(httpPost3.getURI().toString());
      stringBuilder.append("详情：");
      stringBuilder.append(paramString.toString());
      h.a(new d("com.laiqian.util.OnlineSearchUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
      a.e(paramString);
      return "-2";
    } catch (IOException paramString) {
      a.e(paramString);
      return "-3";
    } catch (IllegalArgumentException paramString) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url：");
      stringBuilder.append(httpPost2.getURI().toString());
      stringBuilder.append("详情：");
      stringBuilder.append(paramString.toString());
      h.a(new d("com.laiqian.util.OnlineSearchUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
      a.e(paramString);
      return "-3";
    } 
  }
  
  public static JSONObject a(Context paramContext, int paramInt, String paramString, Object paramObject, JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      av av = new av(paramContext);
      if (paramObject != null)
        jSONObject.put(t.bVs, paramObject); 
      jSONObject.put(t.bUC, "YES");
      jSONObject.put(t.bUD, paramInt);
      paramObject = t.bUD;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("");
      stringBuilder2.append(paramInt);
      jSONObject.put(paramObject, stringBuilder2.toString());
      jSONObject.put(t.bUH, av.Tx());
      jSONObject.put(t.bUy, av.atm());
      jSONObject.put(t.bJz, av.getVersion());
      long l = Long.parseLong(av.atm());
      av.close();
      String str2 = l.dj(l);
      paramObject = paramContext.getSharedPreferences("settings", 0);
      jSONObject.put(t.bUx, str2);
      jSONObject.put(t.bUY, paramObject.getString(t.bUY, ""));
      jSONObject.put(t.bUZ, t.bKc);
      jSONObject.put(t.bVa, "-1");
      str2 = t.bVb;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(System.currentTimeMillis());
      stringBuilder2.append("");
      jSONObject.put(str2, stringBuilder2.toString());
      jSONObject.put(t.bUz, paramObject.getString(t.bUz, ""));
      jSONObject.put(t.bVh, a.crg);
      jSONObject.put(t.bVe, paramObject.getString(t.bVe, ""));
      jSONObject.put(t.bVd, paramObject.getString(t.bVd, ""));
      jSONObject.put(t.bVf, paramContext.getString(R.string.r_channelID));
      jSONObject.put(t.bUA, t.bVj);
      jSONObject.put(t.bVg, paramContext.getString(R.string.pad_language));
      if (paramJSONObject != null)
        try {
          Iterator iterator = paramJSONObject.keys();
          while (iterator.hasNext()) {
            paramObject = (String)iterator.next();
            jSONObject.put(paramObject, paramJSONObject.getString(paramObject));
          } 
        } catch (Exception paramContext) {} 
      String str1 = paramString;
      if (paramString == null)
        str1 = ""; 
      jSONObject.put(t.bVc, str1);
      str1 = t.bVm;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(LQKVersion.zj());
      stringBuilder1.append("");
      jSONObject.put(str1, stringBuilder1.toString());
      return jSONObject;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return jSONObject;
    } 
  }
  
  public static String aa(HashMap<String, String> paramHashMap) {
    iterator = paramHashMap.entrySet().iterator();
    JSONObject jSONObject = new JSONObject();
    try {
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry)iterator.next();
        jSONObject.put((String)entry.getKey(), (String)entry.getValue());
      } 
      null = b.cL(jSONObject.toString());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("laiqian_encrypt=");
      stringBuilder.append(null);
      Log.e("sEncrypted", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("laiqian_encrypt=");
      stringBuilder.append(URLEncoder.encode(null, "UTF-8"));
      return stringBuilder.toString();
    } catch (Exception iterator) {
      return null;
    } 
  }
  
  @Deprecated
  public static String b(String paramString, Context paramContext, HashMap<String, String> paramHashMap) {
    if (paramHashMap != null) {
      ArrayList arrayList = new ArrayList();
    } else {
      paramContext = null;
    } 
    Iterator iterator = paramHashMap.entrySet().iterator();
    JSONObject jSONObject = new JSONObject();
    try {
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry)iterator.next();
        String str1 = (String)entry.getKey();
        String str2 = (String)entry.getValue();
        PrintStream printStream1 = System.out;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("key=");
        stringBuilder1.append(str1);
        stringBuilder1.append(",val=");
        stringBuilder1.append(str2);
        printStream1.println(stringBuilder1.toString());
        paramContext.add(new BasicNameValuePair(str1, str2));
      } 
      paramString = (new k()).d(jSONObject.toString(), paramString, 1);
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("返回json");
      stringBuilder.append(paramString);
      printStream.println(stringBuilder.toString());
      printStream = System.out;
      stringBuilder = new StringBuilder();
      stringBuilder.append("resultString=");
      stringBuilder.append(paramString);
      printStream.println(stringBuilder.toString());
      return "".equals(paramString) ? "" : (("-1".equals(paramString) || "-2".equals(paramString) || "-3".equals(paramString)) ? "-1" : paramString);
    } catch (Exception paramString) {
      return null;
    } 
  }
  
  public static List<NameValuePair> b(Context paramContext, int paramInt, String paramString, Object paramObject, JSONObject paramJSONObject) {
    ArrayList arrayList = new ArrayList();
    try {
      String str = a(paramContext, paramInt, paramString, paramObject, paramJSONObject).toString();
      paramString = b.encode(str);
      paramObject = new StringBuilder();
      paramObject.append("sServiceType");
      paramObject.append(paramInt);
      paramObject = paramObject.toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(" 加密后：");
      stringBuilder.append(paramString);
      bb.e(paramObject, stringBuilder.toString());
      arrayList.add(new BasicNameValuePair(t.bVt, paramString));
      if (t.afi)
        arrayList.add(new BasicNameValuePair(t.bVu, t.iF())); 
      return arrayList;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  @Deprecated
  public static String bt(String paramString1, String paramString2) {
    if (by.isNull(paramString2))
      return null; 
    try {
      paramString2 = b.cL(paramString2);
      ArrayList arrayList = new ArrayList();
      PrintStream printStream2 = System.out;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("url=");
      stringBuilder2.append(paramString1);
      printStream2.println(stringBuilder2.toString());
      arrayList.add(new BasicNameValuePair("laiqian_encrypt", paramString2));
      arrayList.add(new BasicNameValuePair(a.dpG, a.crh));
      paramString1 = (new k()).d(arrayList, paramString1);
      PrintStream printStream1 = System.out;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("返回json");
      stringBuilder1.append(paramString1);
      printStream1.println(stringBuilder1.toString());
      paramString1 = b.cM(paramString1);
      printStream1 = System.out;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("resultString=");
      stringBuilder1.append(paramString1);
      printStream1.println(stringBuilder1.toString());
      if ("".equals(paramString1))
        return ""; 
      if ("-1".equals(paramString1) || "-2".equals(paramString1) || "-3".equals(paramString1))
        return "-1"; 
      if (!paramString1.matches("\\{(.*?)\\}")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("3.");
        stringBuilder.append(paramString1);
        Log.e("nStatus", stringBuilder.toString());
        return "";
      } 
    } catch (Exception paramString1) {
      a.e(paramString1);
      return null;
    } 
    return paramString1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */