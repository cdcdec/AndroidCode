package com.laiqian.util;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import c.n;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.f.b;
import com.laiqian.h.a;
import com.laiqian.infrastructure.R;
import com.laiqian.milestone.h;
import com.laiqian.network.k;
import com.laiqian.network.t;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.industry.a;
import com.laiqian.print.model.type.usb.b.d;
import com.laiqian.print.util.d;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import io.reactivex.g.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.b.e;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.a.a;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.d;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.a.c;
import org.apache.http.conn.ssl.e;
import org.apache.http.conn.ssl.g;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.p;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class bd {
  public static String bVt = "laiqian_encrypt";
  
  public static String bVu = "debug";
  
  public static final int dGg = (int)TimeUnit.MINUTES.toMillis(1L);
  
  public static final int dGh = (int)TimeUnit.SECONDS.toMillis(15L);
  
  public static boolean F(String paramString, int paramInt) {
    try {
      paramInt = Runtime.getRuntime().exec(String.format("ping -c 1 -w %d %s", new Object[] { Integer.valueOf(paramInt), paramString })).waitFor();
      return (paramInt == 0);
    } catch (IOException|InterruptedException paramString) {
      return false;
    } 
  }
  
  public static String a(av paramav, String paramString1, HashMap<String, String> paramHashMap, String paramString2, JSONObject paramJSONObject, Context paramContext) {
    av av2 = null;
    av av1 = null;
    try {
      HashMap<String, String> hashMap;
      long l = System.currentTimeMillis();
      if (!by.isNull(paramav.avj()) && !paramString1.equals(paramav.avj()))
        paramav.avg(); 
      String str2 = paramav.avi();
      String str3 = paramav.Ea();
      String str4 = paramav.atr();
      if (by.isNull(str2)) {
        hashMap = a(paramHashMap, paramString1, str3, str4);
        a(paramString1, b.decode(d(a.cqB, hashMap)), paramav, paramContext);
      } else {
        hashMap = paramHashMap;
        if (Long.parseLong(str2) <= l) {
          hashMap = a(paramHashMap, paramString1, str3, str4);
          a(paramString1, b.decode(d(a.cqB, hashMap)), paramav, paramContext);
        } 
      } 
      String str1 = paramav.avh();
      paramav = av2;
      if (!by.isNull(str1)) {
        String str = b.decode(d(paramString2, a(hashMap, paramString1, str1, paramJSONObject)));
        try {
          boolean bool = by.isNull(str);
          if (bool)
            return null; 
        } catch (Exception paramString1) {
          a.e(paramString1);
        } 
      } 
    } catch (Exception paramString1) {
      paramav = av1;
      a.e(paramString1);
    } 
    return paramav;
  }
  
  public static String a(HttpUriRequest paramHttpUriRequest) throws Exception {
    try {
      DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
      HttpConnectionParams.setConnectionTimeout(defaultHttpClient.getParams(), dGg);
      HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), dGg);
      HttpResponse httpResponse = defaultHttpClient.execute(paramHttpUriRequest);
      if (httpResponse.getStatusLine().getStatusCode() != 200) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(httpResponse.getStatusLine().getStatusCode());
        Log.e("访问失败:", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(httpResponse.getStatusLine().getStatusCode());
        stringBuilder.append("\n");
        return stringBuilder.toString();
      } 
      Log.e("strResult", n.c(n.v(httpResponse.getEntity().getContent())).e(Charset.defaultCharset()).trim().replace("\r", "").replace("\n", ""));
      return "";
    } catch (ConnectTimeoutException|java.net.SocketTimeoutException paramHttpUriRequest) {
      throw new RuntimeException("网络超时");
    } catch (Exception paramHttpUriRequest) {
      a.e(paramHttpUriRequest);
      RuntimeException runtimeException = new RuntimeException("网络错误");
      runtimeException.initCause(paramHttpUriRequest);
      throw runtimeException;
    } 
  }
  
  private static HashMap<String, String> a(HashMap<String, String> paramHashMap, String paramString1, String paramString2, String paramString3) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("shop_id", paramString1);
    jSONObject.put("user_name", paramString2);
    jSONObject.put("password", paramString3);
    jSONObject.put("version", "1");
    List list = u(jSONObject);
    paramHashMap.clear();
    paramHashMap.put(((NameValuePair)list.get(0)).getName(), ((NameValuePair)list.get(0)).getValue());
    return paramHashMap;
  }
  
  private static HashMap<String, String> a(HashMap<String, String> paramHashMap, String paramString1, String paramString2, JSONObject paramJSONObject) {
    try {
      paramJSONObject.put("shop_id", paramString1);
      paramJSONObject.put("token", paramString2);
      paramJSONObject.put("version", "1");
      List list = u(paramJSONObject);
      paramHashMap.clear();
      paramHashMap.put(((NameValuePair)list.get(0)).getName(), ((NameValuePair)list.get(0)).getValue());
      return paramHashMap;
    } catch (Exception paramString1) {
      return paramHashMap;
    } 
  }
  
  public static List<NameValuePair> a(Context paramContext, String paramString1, String paramString2, Object paramObject, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2) {
    ArrayList arrayList = new ArrayList();
    av av = new av(paramContext);
    JSONObject jSONObject = new JSONObject();
    String str2 = "";
    String str1 = "";
    try {
      jSONObject.put(t.bVs, paramObject);
      jSONObject.put(t.bUD, paramString1);
      if (paramString1 == null) {
        paramObject = t.bUD;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(paramString1);
        jSONObject.put(paramObject, stringBuilder.toString());
      } 
      jSONObject.put(t.bUH, av.Tx());
      jSONObject.put(t.bUy, av.atm());
      if (paramString3 != null && paramString4 != null)
        jSONObject.put(paramString3, paramString4); 
      jSONObject.put(t.bJz, av.getVersion());
      if (paramBoolean1)
        jSONObject.put(t.bUI, "TRUE"); 
      long l = Long.parseLong(av.atm());
      paramObject = str2;
      paramString3 = str1;
      if (paramBoolean2) {
        h h = new h(paramContext);
        Cursor cursor = h.aK(l);
        if (cursor.getCount() == 0)
          return null; 
        cursor.moveToFirst();
        paramObject = cursor.getString(cursor.getColumnIndex("sMail"));
        paramString3 = cursor.getString(cursor.getColumnIndex("sUserName"));
        cursor.close();
        h.close();
      } 
      paramString4 = l.dj(l);
      jSONObject.put(t.bUx, paramString4);
      jSONObject.put(t.bUY, av.atr());
      jSONObject.put(t.bUZ, t.bKc);
      jSONObject.put(t.bVa, "-1");
      paramString4 = t.bVb;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(System.currentTimeMillis());
      stringBuilder2.append("");
      jSONObject.put(paramString4, stringBuilder2.toString());
      jSONObject.put(t.bUz, av.Ea());
      jSONObject.put(t.bVh, a.crg);
      jSONObject.put(t.bVe, paramObject);
      jSONObject.put(t.bVd, paramString3);
      jSONObject.put(t.bVf, paramContext.getString(R.string.r_channelID));
      jSONObject.put(t.bUA, t.bVj);
      String str = paramString2;
      if (paramString2 == null)
        str = ""; 
      jSONObject.put(t.bVc, str);
      str = t.bVm;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(LQKVersion.zj());
      stringBuilder1.append("");
      jSONObject.put(str, stringBuilder1.toString());
      jSONObject.put(t.bVn, RootUrlParameter.ckA);
      str = b.encode(jSONObject.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("sServiceType");
      stringBuilder1.append(paramString1);
      stringBuilder1.append("->");
      stringBuilder1.append(jSONObject.toString());
      stringBuilder1.append(" 加密后->");
      stringBuilder1.append(str);
      bb.e("jsons", stringBuilder1.toString());
      arrayList.add(new BasicNameValuePair(t.bVt, str));
      if (t.afi)
        arrayList.add(new BasicNameValuePair(t.bVu, t.iF())); 
      return arrayList;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public static List<NameValuePair> a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2) { return a(paramContext, paramString1, null, null, paramString2, paramString3, paramBoolean1, paramBoolean2); }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, String paramString) { a("_upload", paramContext, paramLong1, paramLong2, paramString); }
  
  private static void a(Object paramObject, String paramString1, String paramString2) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Field field = paramObject.getClass().getField(paramString2);
    field.set(paramObject, Enum.valueOf(field.getType(), paramString1));
  }
  
  private static void a(String paramString1, Context paramContext, long paramLong1, long paramLong2, String paramString2) {}
  
  public static void a(String paramString, WifiConfiguration paramWifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    if (Build.VERSION.SDK_INT >= 21) {
      a(paramWifiConfiguration.getClass().getMethod("getIpConfiguration", new Class[0]).invoke(paramWifiConfiguration, new Object[0]), paramString, "ipAssignment");
      return;
    } 
    a(paramWifiConfiguration, paramString, "ipAssignment");
  }
  
  private static void a(String paramString1, String paramString2, av paramav, Context paramContext) {
    try {
      paramString2 = au.f(paramString2, paramContext);
      if (!by.isNull(paramString2)) {
        JSONObject jSONObject = new JSONObject(paramString2);
        paramav.K(jSONObject.getString("token"), jSONObject.getString("expire_time"), paramString1);
        paramav.close();
      } 
      return;
    } catch (Exception paramString1) {
      return;
    } 
  }
  
  public static void a(InetAddress paramInetAddress, int paramInt, WifiConfiguration paramWifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InstantiationException, InvocationTargetException, UnknownHostException {
    if (Build.VERSION.SDK_INT >= 21) {
      Object object4 = paramWifiConfiguration.getClass().getMethod("getStaticIpConfiguration", new Class[0]).invoke(paramWifiConfiguration, new Object[0]);
      Class clazz = Class.forName("android.net.StaticIpConfiguration");
      Object object3 = object4;
      if (object4 == null)
        object3 = clazz.getConstructor(new Class[0]).newInstance(new Object[0]); 
      f(object3, "ipAddress", Class.forName("android.net.LinkAddress").getConstructor(new Class[] { InetAddress.class, int.class }).newInstance(new Object[] { paramInetAddress, Integer.valueOf(paramInt) }));
      paramWifiConfiguration.getClass().getMethod("setStaticIpConfiguration", new Class[] { clazz }).invoke(paramWifiConfiguration, new Object[] { object3 });
      return;
    } 
    Object object2 = g(paramWifiConfiguration, "linkProperties");
    if (object2 == null)
      return; 
    Object object1 = Class.forName("android.net.LinkAddress").getConstructor(new Class[] { InetAddress.class, int.class }).newInstance(new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
    object2 = (ArrayList)h(object2, "mLinkAddresses");
    object2.clear();
    object2.add(object1);
  }
  
  public static void a(InetAddress paramInetAddress, WifiConfiguration paramWifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
    if (Build.VERSION.SDK_INT >= 21) {
      Object object = paramWifiConfiguration.getClass().getMethod("getStaticIpConfiguration", new Class[0]).invoke(paramWifiConfiguration, new Object[0]);
      Class clazz = Class.forName("android.net.StaticIpConfiguration");
      object2 = object;
      if (object == null)
        object2 = clazz.getConstructor(new Class[0]).newInstance(new Object[0]); 
      f(object2, "gateway", paramInetAddress);
      return;
    } 
    Object object2 = g(object2, "linkProperties");
    if (object2 == null)
      return; 
    Object object1 = Class.forName("android.net.RouteInfo").getConstructor(new Class[] { InetAddress.class }).newInstance(new Object[] { paramInetAddress });
    object2 = (ArrayList)h(object2, "mRoutes");
    object2.clear();
    object2.add(object1);
  }
  
  public static void a(InetAddress paramInetAddress1, InetAddress paramInetAddress2, WifiConfiguration paramWifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException {
    Object object;
    if (Build.VERSION.SDK_INT >= 21) {
      Object object1 = paramWifiConfiguration.getClass().getMethod("getStaticIpConfiguration", new Class[0]).invoke(paramWifiConfiguration, new Object[0]);
      Class clazz = Class.forName("android.net.StaticIpConfiguration");
      object = object1;
      if (object1 == null)
        object = clazz.getConstructor(new Class[0]).newInstance(new Object[0]); 
      object = (ArrayList)g(object, "dnsServers");
      object.clear();
      object.add(paramInetAddress1);
      if (paramInetAddress2 != null) {
        object.add(paramInetAddress2);
        return;
      } 
    } else {
      object = g(object, "linkProperties");
      if (object == null)
        return; 
      object = (ArrayList)h(object, "mDnses");
      object.clear();
      object.add(paramInetAddress1);
      if (paramInetAddress2 != null)
        object.add(paramInetAddress2); 
    } 
  }
  
  public static ArrayList<a> ajf() { // Byte code:
    //   0: invokestatic ajg : ()Ljava/lang/String;
    //   3: astore_3
    //   4: new java/util/ArrayList
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore_2
    //   12: aload_3
    //   13: ldc_w 'line.separator'
    //   16: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: arraylength
    //   25: istore_1
    //   26: iconst_0
    //   27: istore_0
    //   28: iload_0
    //   29: iload_1
    //   30: if_icmpge -> 51
    //   33: aload_2
    //   34: aload_3
    //   35: iload_0
    //   36: aaload
    //   37: invokestatic rW : (Ljava/lang/String;)Lcom/laiqian/util/bd$a;
    //   40: invokevirtual add : (Ljava/lang/Object;)Z
    //   43: pop
    //   44: iload_0
    //   45: iconst_1
    //   46: iadd
    //   47: istore_0
    //   48: goto -> 28
    //   51: aload_2
    //   52: areturn }
  
  private static String ajg() throws IllegalStateException {
    String str = (new d()).lC("netcfg");
    if (TextUtils.isEmpty(str))
      throw new IllegalStateException("netcfg not avaliable"); 
    return str;
  }
  
  public static String awo() throws IllegalStateException {
    try {
      Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        Enumeration enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = (InetAddress)enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress())
            return inetAddress.getHostAddress().toString(); 
        } 
      } 
    } catch (SocketException socketException) {
      bb.e("WifiPreference IpAddress", socketException.toString());
    } 
    return "";
  }
  
  public static CloseableHttpClient awp() {
    e = e.aWz();
    e.z("http", new c());
    try {
      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      bf bf = new bf();
      e.z("https", new e(g.aWJ().aWH().a(keyStore, bf).aWI(), e.ALLOW_ALL_HOSTNAME_VERIFIER));
      p p = new p(e.aWA());
      return HttpClientBuilder.aXA().a(p).aXB();
    } catch (KeyStoreException e) {
      throw new RuntimeException(e);
    } catch (KeyManagementException e) {
      throw new RuntimeException(e);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    } 
  }
  
  public static String b(String paramString, JSONObject paramJSONObject) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("?laiqian_encrypt=");
      stringBuilder.append(URLEncoder.encode(b.cL(paramJSONObject.toString()), "UTF-8"));
      return stringBuilder.toString();
    } catch (Exception paramJSONObject) {
      a.e(paramJSONObject);
      return paramString;
    } 
  }
  
  public static void b(Context paramContext, long paramLong1, long paramLong2, String paramString) { a("_SealData", paramContext, paramLong1, paramLong2, paramString); }
  
  public static void b(Handler paramHandler, String paramString) { a.aKh().r(new be(paramHandler, paramString)); }
  
  public static boolean bH(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isConnected())
        return true; 
    } 
    return false;
  }
  
  public static boolean bX(Context paramContext) {
    WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
    if (!wifiManager.isWifiEnabled())
      wifiManager.setWifiEnabled(true); 
    return true;
  }
  
  public static String bY(Context paramContext) {
    DhcpInfo dhcpInfo = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
    return (dhcpInfo == null) ? null : d.je(dhcpInfo.gateway).getHostAddress();
  }
  
  @Nullable
  public static WifiConfiguration bZ(Context paramContext) {
    null = (WifiManager)paramContext.getSystemService("wifi");
    List list = null.getConfiguredNetworks();
    WifiInfo wifiInfo = null.getConnectionInfo();
    if (wifiInfo == null)
      return null; 
    if (list != null)
      for (WifiConfiguration wifiConfiguration : list) {
        if (wifiConfiguration.networkId == wifiInfo.getNetworkId())
          return wifiConfiguration; 
      }  
    return null;
  }
  
  @Deprecated
  @WorkerThread
  public static String c(String paramString, List<NameValuePair> paramList) {
    if (paramList == null)
      return ""; 
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
      String str = null;
      httpPost2 = httpPost1;
      httpPost3 = httpPost1;
      httpPost4 = httpPost1;
      if (!k.iI(paramString)) {
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        str = a.Js().I(httpPost1.getURI().getHost());
      } 
      HttpPost httpPost = httpPost1;
      if (str != null) {
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        String str1 = httpPost1.getURI().getHost();
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
        null.append(str);
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(" for host: ");
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        null.append(str1);
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
        Log.d("NetworkUtil", null.toString());
        httpPost2 = httpPost1;
        httpPost3 = httpPost1;
        httpPost4 = httpPost1;
        httpPost = new HttpPost(paramString.replaceFirst(str1, str));
        try {
          httpPost.setHeader("Host", str1);
        } catch (ConnectTimeoutException paramString) {
          httpPost4 = httpPost;
        } catch (ClientProtocolException paramString) {
          httpPost3 = httpPost;
        } catch (Throwable paramString) {
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
      if (paramString.startsWith("https")) {
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        System.setProperty("jsse.enableSNIExtension", "false");
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        d = awp().c(httpPost);
      } else {
        httpPost2 = httpPost;
        httpPost3 = httpPost;
        httpPost4 = httpPost;
        d = closeableHttpClient.c(httpPost);
      } 
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
          h.a(new d("NetworkUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
          return "-1";
        } 
      } 
      httpPost2 = httpPost;
      httpPost3 = httpPost;
      httpPost4 = httpPost;
      return EntityUtils.toString(d.getEntity()).trim().replace("\r", "").replace("\n", "");
    } catch (ConnectTimeoutException paramString) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url：");
      stringBuilder.append(httpPost4.getURI().toString());
      stringBuilder.append("详情：");
      stringBuilder.append(paramString.toString());
      h.a(new d("NetworkUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
      a.e(paramString);
      return "-1";
    } catch (ClientProtocolException paramString) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url：");
      stringBuilder.append(httpPost3.getURI().toString());
      stringBuilder.append("详情：");
      stringBuilder.append(paramString.toString());
      h.a(new d("NetworkUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
      a.e(paramString);
      return "-1";
    } catch (Throwable paramString) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url：");
      stringBuilder.append(httpPost2.getURI().toString());
      stringBuilder.append("详情：");
      stringBuilder.append(paramString.toString());
      h.a(new d("NetworkUtil", "sendRequestToServer", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ);
      a.e(paramString);
      return "-1";
    } 
  }
  
  public static String cC(long paramLong) {
    String str = "";
    for (byte b = 3; b > -1; b--) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(paramLong >> b * 8 & 0xFFL);
      stringBuilder.append(".");
      str = stringBuilder.toString();
    } 
    return str.substring(0, str.length() - 1);
  }
  
  @Deprecated
  public static String d(String paramString, HashMap<String, String> paramHashMap) throws Exception {
    List list;
    if (paramHashMap != null) {
      ArrayList arrayList = new ArrayList();
      Iterator iterator = paramHashMap.keySet().iterator();
      while (true) {
        list = arrayList;
        if (iterator.hasNext()) {
          String str = (String)iterator.next();
          arrayList.add(new BasicNameValuePair(str, (String)paramHashMap.get(str)));
          continue;
        } 
        break;
      } 
    } else {
      list = null;
    } 
    return d(paramString, list);
  }
  
  @Deprecated
  public static String d(String paramString, List<NameValuePair> paramList) { return (new k()).d(paramList, paramString); }
  
  public static String e(String paramString, List<NameValuePair> paramList) {
    HttpPost httpPost = new HttpPost(paramString);
    httpPost.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));
    return a(httpPost);
  }
  
  public static LinkedHashSet<Long> f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    LinkedHashSet linkedHashSet = new LinkedHashSet();
    while (paramInt1 <= paramInt2) {
      linkedHashSet.add(Long.valueOf(mg(String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt1) }))));
      paramInt1++;
    } 
    return linkedHashSet;
  }
  
  private static void f(Object paramObject1, String paramString, Object paramObject2) throws IllegalAccessException, NoSuchFieldException { paramObject1.getClass().getDeclaredField(paramString).set(paramObject1, paramObject2); }
  
  private static Object g(Object paramObject, String paramString) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException { return paramObject.getClass().getField(paramString).get(paramObject); }
  
  @Nullable
  public static String getLocalIp() throws IllegalStateException {
    d.a a = d.ajh();
    return (a == null) ? null : a.getAddress().getHostAddress();
  }
  
  private static Object h(Object paramObject, String paramString) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Field field = paramObject.getClass().getDeclaredField(paramString);
    field.setAccessible(true);
    return field.get(paramObject);
  }
  
  public static long mg(String paramString) {
    String[] arrayOfString = paramString.split("\\.");
    return Long.parseLong(arrayOfString[0]) * 16777216L + Long.parseLong(arrayOfString[1]) * 65536L + Long.parseLong(arrayOfString[2]) * 256L + Long.parseLong(arrayOfString[3]);
  }
  
  public static byte[] mh(String paramString) {
    int[] arrayOfInt = mi(paramString);
    return new byte[] { (byte)arrayOfInt[0], (byte)arrayOfInt[1], (byte)arrayOfInt[2], (byte)arrayOfInt[3] };
  }
  
  public static int[] mi(String paramString) {
    String[] arrayOfString = paramString.split("\\.");
    int[] arrayOfInt = new int[arrayOfString.length];
    for (byte b = 0; b < 4; b++)
      arrayOfInt[b] = Integer.parseInt(arrayOfString[b]); 
    return arrayOfInt;
  }
  
  public static String r(int[] paramArrayOfInt) {
    if (paramArrayOfInt.length != 4)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramArrayOfInt[0]);
    stringBuilder.append(".");
    stringBuilder.append(paramArrayOfInt[1]);
    stringBuilder.append(".");
    stringBuilder.append(paramArrayOfInt[2]);
    stringBuilder.append(".");
    stringBuilder.append(paramArrayOfInt[3]);
    return stringBuilder.toString();
  }
  
  public static List<NameValuePair> rN(String paramString) {
    if (paramString == null)
      return null; 
    ArrayList arrayList = new ArrayList();
    arrayList.add(new BasicNameValuePair(bVt, paramString));
    if (t.afi)
      arrayList.add(new BasicNameValuePair(bVu, t.iF())); 
    return arrayList;
  }
  
  public static Message rO(String paramString) {
    message = new Message();
    str = "";
    bufferedReader3 = null;
    bufferedReader1 = null;
    bufferedReader5 = null;
    try {
      null = (HttpURLConnection)(new URL(paramString)).openConnection();
      null.setReadTimeout(5000);
      str1 = new InputStreamReader(null.getInputStream());
    } catch (IOException null) {
      bufferedReader1 = "";
    } catch (Exception exception) {
      bufferedReader1 = "";
      bufferedReader3 = null;
    } finally {
      paramString = null;
      bufferedReader3 = null;
      BufferedReader bufferedReader = bufferedReader1;
    } 
    BufferedReader bufferedReader4 = bufferedReader3;
    bufferedReader2 = bufferedReader5;
    a.e(exception);
    if (bufferedReader5 != null)
      try {
        bufferedReader5.close();
      } catch (IOException bufferedReader2) {
        a.e(bufferedReader2);
      }  
    bufferedReader2 = bufferedReader1;
    if (bufferedReader3 != null) {
      bufferedReader2 = bufferedReader1;
      bufferedReader3.close();
      bufferedReader2 = bufferedReader1;
    } 
  }
  
  public static boolean rP(String paramString) {
    int[] arrayOfInt2 = mi(getLocalIp());
    int[] arrayOfInt1 = mi(paramString);
    byte b = 0;
    int i = b;
    if (arrayOfInt2[0] == arrayOfInt1[0]) {
      i = b;
      if (arrayOfInt2[1] == arrayOfInt1[1]) {
        i = b;
        if (arrayOfInt2[2] == arrayOfInt1[2])
          i = 1; 
      } 
    } 
    return i;
  }
  
  public static boolean rQ(String paramString) {
    try {
      int[] arrayOfInt = mi(paramString);
      if (arrayOfInt.length != 4)
        return false; 
    } catch (Exception paramString) {
      return false;
    } 
    byte b = 0;
    while (b < 4) {
      if (paramString[b] >= null) {
        String str = paramString[3];
        if (str > 'ÿ')
          return false; 
        b++;
        continue;
      } 
      return false;
    } 
    return true;
  }
  
  public static boolean rR(String paramString) { return !rQ(paramString) ? false : (!(!rS(paramString) && !rT(paramString) && !rU(paramString))); }
  
  public static boolean rS(String paramString) {
    try {
      if (!rQ(paramString))
        return false; 
      int[] arrayOfInt = mi(paramString);
      if (arrayOfInt[0] != 10)
        return false; 
    } catch (Exception paramString) {
      a.e(paramString);
      return false;
    } 
    byte b = 1;
    while (b < 4) {
      if (paramString[b] >= null) {
        String str = paramString[b];
        if (str > 'ÿ')
          return false; 
        b++;
        continue;
      } 
      return false;
    } 
    return true;
  }
  
  public static boolean rT(String paramString) {
    try {
      if (!rQ(paramString))
        return false; 
      int[] arrayOfInt = mi(paramString);
      if (arrayOfInt[0] != 172)
        return false; 
    } catch (Exception paramString) {
      a.e(paramString);
      return false;
    } 
    if (paramString[1] >= '\020') {
      if (paramString[1] > '\037')
        return false; 
      byte b = 2;
      while (b < 4) {
        if (paramString[b] >= null) {
          String str = paramString[b];
          if (str > 'ÿ')
            return false; 
          b++;
          continue;
        } 
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  public static boolean rU(String paramString) {
    try {
      if (!rQ(paramString))
        return false; 
      int[] arrayOfInt = mi(paramString);
      if (arrayOfInt[0] != 192)
        return false; 
    } catch (Exception paramString) {
      a.e(paramString);
      return false;
    } 
    if (paramString[1] != '¨')
      return false; 
    byte b = 2;
    while (b < 4) {
      if (paramString[b] >= null) {
        String str = paramString[b];
        if (str > 'ÿ')
          return false; 
        b++;
        continue;
      } 
      return false;
    } 
    return true;
  }
  
  @Deprecated
  public static String rV(String paramString) throws Exception { return (new k()).iJ(paramString); }
  
  public static List<NameValuePair> u(JSONObject paramJSONObject) {
    ArrayList arrayList = new ArrayList();
    try {
      arrayList.add(new BasicNameValuePair("laiqian_encrypt", b.cL(paramJSONObject.toString())));
      return arrayList;
    } catch (Exception paramJSONObject) {
      a.e(paramJSONObject);
      return null;
    } 
  }
  
  public static class a {
    private InetAddress address;
    
    private int cOx;
    
    private int[] dGj;
    
    private String name;
    
    public a(@NonNull String param1String, @NonNull byte[] param1ArrayOfByte, int param1Int, int[] param1ArrayOfInt) {
      this.name = param1String;
      try {
        this.address = InetAddress.getByAddress(param1ArrayOfByte);
        this.cOx = param1Int;
        this.dGj = param1ArrayOfInt;
        return;
      } catch (UnknownHostException param1String) {
        a.e(param1String);
        throw new NullPointerException("addressInBytes");
      } 
    }
    
    public static a rW(@NonNull String param1String) {
      String[] arrayOfString1 = param1String.split("\\s+");
      int i = arrayOfString1[2].indexOf("/");
      String str1 = arrayOfString1[2].substring(0, i);
      String str2 = arrayOfString1[2].substring(i + 1);
      String[] arrayOfString2 = arrayOfString1[4].split(":");
      return new a(arrayOfString1[0], bd.mh(str1), Integer.valueOf(str2).intValue(), new int[] { Integer.valueOf(arrayOfString2[0], 16).intValue(), Integer.valueOf(arrayOfString2[1], 16).intValue(), Integer.valueOf(arrayOfString2[2], 16).intValue(), Integer.valueOf(arrayOfString2[3], 16).intValue(), Integer.valueOf(arrayOfString2[4], 16).intValue(), Integer.valueOf(arrayOfString2[5], 16).intValue() });
    }
    
    public InetAddress getAddress() { return this.address; }
    
    @NonNull
    public String getName() throws IllegalStateException { return this.name; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */