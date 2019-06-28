package com.laiqian.network;

import android.os.Build;
import android.util.Log;
import b.aa;
import b.ae;
import b.aj;
import b.an;
import b.g;
import b.k;
import b.m;
import b.t;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import com.laiqian.h.a;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import io.reactivex.annotations.NonNull;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
  private static aa adg;
  
  private static final Charset bUk = Charset.forName("UTF-8");
  
  public k() {
    if (adg == null)
      adg = a(RootApplication.zv().zE().aSL().jl(false).b(new k(false, 1L, TimeUnit.SECONDS)).k(60L, TimeUnit.SECONDS).l(60L, TimeUnit.SECONDS).a(new l(this))).aSM(); 
  }
  
  public static aa.a a(aa.a parama) {
    if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("VERSION:");
      stringBuilder.append(Build.VERSION.SDK_INT);
      Log.e("OkHttpTLSCompat", stringBuilder.toString());
      try {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
        sSLContext.init(null, null, null);
        parama.a(new r(sSLContext.getSocketFactory()));
        m m = (new m.a(m.feG)).a(new an[] { an.fgN }).aRQ();
        ArrayList arrayList = new ArrayList();
        arrayList.add(m);
        arrayList.add(m.feH);
        arrayList.add(m.feI);
        parama.aa(arrayList);
        return parama;
      } catch (Exception stringBuilder) {
        Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", stringBuilder);
      } 
    } 
    return parama;
  }
  
  public static void a(@NonNull Map<String, String> paramMap, @NonNull String paramString, @NonNull g paramg) {
    t.a a1 = new t.a();
    for (Map.Entry entry : paramMap.entrySet())
      a1.bO((String)entry.getKey(), (String)entry.getValue()); 
    ae.a a = (new ae.a()).uS(paramString).a(a1.aRU());
    adg.a(a.aSZ()).a(paramg);
  }
  
  private i i(String paramString, int paramInt) {
    if (paramString == null || "".equals(paramString)) {
      PrintStream printStream = System.err;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Okhttp parse isSuccess failed. the isSuccess is:");
      stringBuilder.append(paramString);
      printStream.println(stringBuilder.toString());
      return new i(false, false, "");
    } 
    try {
      String str = l(paramString, paramInt);
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unencryptedResult value is:");
      stringBuilder.append(str);
      printStream.println(stringBuilder.toString());
      JSONObject jSONObject = new JSONObject(str);
      return new i(jSONObject.getBoolean("result"), jSONObject.getInt("msg_no"), jSONObject.getString("message"));
    } catch (JSONException jSONException) {
      PrintStream printStream = System.err;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Okhttp parse isSuccess failed. the isSuccess is:");
      stringBuilder.append(paramString);
      printStream.println(stringBuilder.toString());
      a.e(jSONException);
    } catch (Exception exception) {
      PrintStream printStream = System.err;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Okhttp parse isSuccess failed. the isSuccess is:");
      stringBuilder.append(paramString);
      printStream.println(stringBuilder.toString());
      a.e(exception);
    } 
    return new i(false, false, "");
  }
  
  public static boolean iI(String paramString) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(RootUrlParameter.ckS);
    arrayList.add(RootUrlParameter.ckV);
    arrayList.add(RootUrlParameter.ckW);
    for (byte b = 0; b < arrayList.size(); b++) {
      if (paramString.contains((CharSequence)arrayList.get(b)))
        return true; 
    } 
    return false;
  }
  
  private String j(String paramString, int paramInt) throws Exception { return (paramString == null || "".equals(paramString)) ? "" : l(paramString, paramInt); }
  
  public i a(Map<String, String> paramMap, String paramString, int paramInt) throws Exception {
    JSONObject jSONObject = new JSONObject();
    for (Map.Entry entry : paramMap.entrySet())
      jSONObject.put((String)entry.getKey(), entry.getValue()); 
    return i(d(jSONObject.toString(), paramString, paramInt), paramInt);
  }
  
  public String b(Map<String, String> paramMap, String paramString, int paramInt) throws Exception {
    JSONObject jSONObject = new JSONObject();
    for (Map.Entry entry : paramMap.entrySet())
      jSONObject.put((String)entry.getKey(), entry.getValue()); 
    return j(d(jSONObject.toString(), paramString, paramInt), paramInt);
  }
  
  public i c(String paramString1, String paramString2, int paramInt) throws Exception { return i(d(paramString1, paramString2, paramInt), paramInt); }
  
  public String d(String paramString1, String paramString2, int paramInt) throws Exception {
    String str4 = "";
    URL uRL = new URL(paramString2);
    Object object2 = null;
    Object object1 = null;
    String str2 = "";
    String str3 = "";
    stringBuilder = object1;
    ae = object2;
    str1 = str4;
    try {
      String str = String.valueOf(System.currentTimeMillis() / 1000L);
      stringBuilder = object1;
      ae = object2;
      str1 = str4;
      if (!iI(paramString2)) {
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        ae1 = a.Js().I(uRL.getHost());
      } else {
        String str5;
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        Log.e("url", "不需要解析ip");
        ae1 = null;
      } 
      if (ae1 != null) {
        String str5;
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        str3 = uRL.getHost();
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null = new StringBuilder();
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null.append("Get IP: ");
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null.append(ae1);
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null.append(" for host: ");
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null.append(str3);
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null.append(" for url:");
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null.append(paramString2);
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        null.append(" from HTTPDNS successfully!");
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        Log.d("OkHttpUtil", null.toString());
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        str5 = paramString2.replaceFirst(str3, ae1);
      } 
      stringBuilder = object1;
      ae = object2;
      str1 = str4;
      null = new StringBuilder();
      stringBuilder = object1;
      ae = object2;
      str1 = str4;
      null.append("网络请求：postRequestWithoutParse conent-->");
      stringBuilder = object1;
      ae = object2;
      str1 = str4;
      null.append(paramString1);
      stringBuilder = object1;
      ae = object2;
      str1 = str4;
      Log.i("OkHttpUtil", null.toString());
      stringBuilder = object1;
      ae = object2;
      str1 = str4;
      t t = (new t.a()).bO("laiqian_encrypt", k(paramString1, paramInt)).aRU();
      if (ae1 != null) {
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        ae ae2 = (new ae.a()).uS(str5).bY("Host", str3).bY("id", RootApplication.getLaiqianPreferenceManager().Tx()).bY("time", str).bY("sb-encrypt", b.c(n.parseLong(str), n.parseInt(RootApplication.getLaiqianPreferenceManager().Tx()))).bY("client-version", LQKVersion.zq()).bY("client-brand", LQKVersion.zi()).a(t).aSZ();
      } else {
        stringBuilder = object1;
        ae = object2;
        str1 = str4;
        ae1 = (new ae.a()).uS(paramString2).bY("id", RootApplication.getLaiqianPreferenceManager().Tx()).bY("time", str).bY("sb-encrypt", b.c(n.parseLong(str), n.parseInt(RootApplication.getLaiqianPreferenceManager().Tx()))).bY("client-version", LQKVersion.zq()).bY("client-brand", LQKVersion.zi()).a(t).aSZ();
      } 
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      null = new StringBuilder();
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      null.append("url：");
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      null.append(ae1.aRk().aSa().toString());
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      null.append(" 未加密:");
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      null.append(paramString1);
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      null.append(" 加密：");
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      null.append(k(paramString1, paramInt));
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      h.a(new d("OkHttpUtil", "postRequestWithoutParse", "请求信息", null.toString()), h.a.dHx, h.b.dHJ, paramString2);
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      aj = adg.a(ae1).aRI();
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      if (aj.aGo() != 200) {
        stringBuilder = ae1;
        ae = ae1;
        str1 = str4;
        null = new StringBuilder();
        stringBuilder = ae1;
        ae = ae1;
        str1 = str4;
        null.append("url：");
        stringBuilder = ae1;
        ae = ae1;
        str1 = str4;
        null.append(ae1.aRk().aSa().toString());
        stringBuilder = ae1;
        ae = ae1;
        str1 = str4;
        null.append("详情：");
        stringBuilder = ae1;
        ae = ae1;
        str1 = str4;
        null.append(aj.aGo());
        stringBuilder = ae1;
        ae = ae1;
        str1 = str4;
        null.append("");
        stringBuilder = ae1;
        ae = ae1;
        str1 = str4;
        h.a(new d("OkHttpUtil", "postRequestWithoutParse", "请求异常", null.toString()), h.a.dHx, h.b.dHJ, paramString2);
      } 
      stringBuilder = ae1;
      ae = ae1;
      str1 = str4;
      return aj.aTc().aTk();
    } catch (IOException paramString1) {
      ae ae1 = ae;
      stringBuilder = new StringBuilder();
      stringBuilder.append("url：");
      stringBuilder.append(ae1.aRk().aSa().toString());
      stringBuilder.append("详情：");
      stringBuilder.append(paramString1.toString());
      h.a(new d("OkHttpUtil", "postRequestWithoutParse", "请求异常", stringBuilder.toString()), h.a.dHx, h.b.dHJ, paramString2);
      throw new IOException("OKHTTP newCall failed.");
    } catch (Exception paramString1) {
      stringBuilder1 = stringBuilder;
    } finally {
      paramString1 = null;
    } 
  }
  
  public String d(List<NameValuePair> paramList, String paramString) throws Exception {
    str1 = "";
    URL uRL = new URL(paramString);
    jSONObject = new JSONObject();
    String str2 = "";
    str3 = "";
    stringBuilder = str1;
    try {
      str6 = String.valueOf(System.currentTimeMillis() / 1000L);
      stringBuilder = str1;
      if (!iI(paramString)) {
        stringBuilder = str1;
        str4 = a.Js().I(uRL.getHost());
      } else {
        stringBuilder = str1;
        Log.e("url", "不需要解析ip");
        str4 = null;
      } 
      if (str4 != null) {
        stringBuilder = str1;
        str3 = uRL.getHost();
        stringBuilder = str1;
        null = new StringBuilder();
        stringBuilder = str1;
        null.append("Get IP: ");
        stringBuilder = str1;
        null.append(str4);
        stringBuilder = str1;
        null.append(" for host: ");
        stringBuilder = str1;
        null.append(str3);
        stringBuilder = str1;
        null.append(" for url:");
        stringBuilder = str1;
        null.append(paramString);
        stringBuilder = str1;
        null.append(" from HTTPDNS successfully!");
        stringBuilder = str1;
        Log.d("OkHttpUtil", null.toString());
        stringBuilder = str1;
        str5 = paramString.replaceFirst(str3, str4);
      } 
      stringBuilder = str1;
      a = new t.a();
    } catch (IOException str1) {
      paramList = null;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("url：");
      stringBuilder1.append(paramList.aRk().aSa().toString());
      stringBuilder1.append("详情：");
      stringBuilder1.append(str1.toString());
      h.a(new d("OkHttpUtil", "postRequestWithoutParse", "请求异常", stringBuilder1.toString()), h.a.dHx, h.b.dHJ, paramString);
      throw new IOException("OKHTTP newCall failed.");
    } catch (Exception str1) {
      paramList = null;
    } finally {
      paramList = null;
    } 
  }
  
  public String iJ(String paramString) throws Exception { return n(paramString, false); }
  
  public String k(String paramString, int paramInt) throws Exception {
    switch (paramInt) {
      default:
        return b.encode(paramString);
      case 1:
        return b.cL(paramString);
      case 0:
        break;
    } 
    return b.encode(paramString);
  }
  
  public String l(String paramString, int paramInt) throws Exception {
    switch (paramInt) {
      default:
        return b.decode(paramString);
      case 1:
        return b.cM(paramString);
      case 0:
        break;
    } 
    return b.decode(paramString);
  }
  
  public String n(String paramString, boolean paramBoolean) throws Exception { // Byte code:
    //   0: ldc_w ''
    //   3: astore #9
    //   5: new java/net/URL
    //   8: dup
    //   9: aload_1
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: astore #13
    //   15: aconst_null
    //   16: astore #11
    //   18: aconst_null
    //   19: astore #10
    //   21: ldc_w ''
    //   24: astore #6
    //   26: ldc_w ''
    //   29: astore #8
    //   31: aload #10
    //   33: astore #4
    //   35: aload #11
    //   37: astore #5
    //   39: aload #9
    //   41: astore #7
    //   43: invokestatic currentTimeMillis : ()J
    //   46: ldc2_w 1000
    //   49: ldiv
    //   50: invokestatic valueOf : (J)Ljava/lang/String;
    //   53: astore #12
    //   55: aload #10
    //   57: astore #4
    //   59: aload #11
    //   61: astore #5
    //   63: aload #9
    //   65: astore #7
    //   67: aload_1
    //   68: invokestatic iI : (Ljava/lang/String;)Z
    //   71: ifne -> 103
    //   74: aload #10
    //   76: astore #4
    //   78: aload #11
    //   80: astore #5
    //   82: aload #9
    //   84: astore #7
    //   86: invokestatic Js : ()Lcom/alibaba/a/a/b/c;
    //   89: aload #13
    //   91: invokevirtual getHost : ()Ljava/lang/String;
    //   94: invokeinterface I : (Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_3
    //   100: goto -> 127
    //   103: aload #10
    //   105: astore #4
    //   107: aload #11
    //   109: astore #5
    //   111: aload #9
    //   113: astore #7
    //   115: ldc_w 'url'
    //   118: ldc_w '不需要解析ip'
    //   121: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   124: pop
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull -> 358
    //   131: aload #10
    //   133: astore #4
    //   135: aload #11
    //   137: astore #5
    //   139: aload #9
    //   141: astore #7
    //   143: aload #13
    //   145: invokevirtual getHost : ()Ljava/lang/String;
    //   148: astore #8
    //   150: aload #10
    //   152: astore #4
    //   154: aload #11
    //   156: astore #5
    //   158: aload #9
    //   160: astore #7
    //   162: new java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial <init> : ()V
    //   169: astore #6
    //   171: aload #10
    //   173: astore #4
    //   175: aload #11
    //   177: astore #5
    //   179: aload #9
    //   181: astore #7
    //   183: aload #6
    //   185: ldc_w 'Get IP: '
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #10
    //   194: astore #4
    //   196: aload #11
    //   198: astore #5
    //   200: aload #9
    //   202: astore #7
    //   204: aload #6
    //   206: aload_3
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #10
    //   213: astore #4
    //   215: aload #11
    //   217: astore #5
    //   219: aload #9
    //   221: astore #7
    //   223: aload #6
    //   225: ldc_w ' for host: '
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #10
    //   234: astore #4
    //   236: aload #11
    //   238: astore #5
    //   240: aload #9
    //   242: astore #7
    //   244: aload #6
    //   246: aload #8
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #10
    //   254: astore #4
    //   256: aload #11
    //   258: astore #5
    //   260: aload #9
    //   262: astore #7
    //   264: aload #6
    //   266: ldc_w ' for url:'
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload #10
    //   275: astore #4
    //   277: aload #11
    //   279: astore #5
    //   281: aload #9
    //   283: astore #7
    //   285: aload #6
    //   287: aload_1
    //   288: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload #10
    //   294: astore #4
    //   296: aload #11
    //   298: astore #5
    //   300: aload #9
    //   302: astore #7
    //   304: aload #6
    //   306: ldc_w ' from HTTPDNS successfully!'
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #10
    //   315: astore #4
    //   317: aload #11
    //   319: astore #5
    //   321: aload #9
    //   323: astore #7
    //   325: ldc_w 'OkHttpUtil'
    //   328: aload #6
    //   330: invokevirtual toString : ()Ljava/lang/String;
    //   333: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: aload #10
    //   339: astore #4
    //   341: aload #11
    //   343: astore #5
    //   345: aload #9
    //   347: astore #7
    //   349: aload_1
    //   350: aload #8
    //   352: aload_3
    //   353: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   356: astore #6
    //   358: aload_3
    //   359: ifnull -> 462
    //   362: aload #10
    //   364: astore #4
    //   366: aload #11
    //   368: astore #5
    //   370: aload #9
    //   372: astore #7
    //   374: new b/ae$a
    //   377: dup
    //   378: invokespecial <init> : ()V
    //   381: aload #6
    //   383: invokevirtual uS : (Ljava/lang/String;)Lb/ae$a;
    //   386: ldc_w 'Host'
    //   389: aload #8
    //   391: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   394: ldc_w 'id'
    //   397: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   400: invokevirtual Tx : ()Ljava/lang/String;
    //   403: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   406: ldc_w 'time'
    //   409: aload #12
    //   411: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   414: ldc_w 'sb-encrypt'
    //   417: aload #12
    //   419: invokestatic parseLong : (Ljava/lang/String;)J
    //   422: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   425: invokevirtual Tx : ()Ljava/lang/String;
    //   428: invokestatic parseInt : (Ljava/lang/String;)I
    //   431: invokestatic c : (JI)Ljava/lang/String;
    //   434: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   437: ldc_w 'client-version'
    //   440: invokestatic zq : ()Ljava/lang/String;
    //   443: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   446: ldc_w 'client-brand'
    //   449: invokestatic zi : ()Ljava/lang/String;
    //   452: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   455: invokevirtual aSZ : ()Lb/ae;
    //   458: astore_3
    //   459: goto -> 550
    //   462: aload #10
    //   464: astore #4
    //   466: aload #11
    //   468: astore #5
    //   470: aload #9
    //   472: astore #7
    //   474: new b/ae$a
    //   477: dup
    //   478: invokespecial <init> : ()V
    //   481: aload_1
    //   482: invokevirtual uS : (Ljava/lang/String;)Lb/ae$a;
    //   485: ldc_w 'id'
    //   488: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   491: invokevirtual Tx : ()Ljava/lang/String;
    //   494: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   497: ldc_w 'time'
    //   500: aload #12
    //   502: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   505: ldc_w 'sb-encrypt'
    //   508: aload #12
    //   510: invokestatic parseLong : (Ljava/lang/String;)J
    //   513: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   516: invokevirtual Tx : ()Ljava/lang/String;
    //   519: invokestatic parseInt : (Ljava/lang/String;)I
    //   522: invokestatic c : (JI)Ljava/lang/String;
    //   525: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   528: ldc_w 'client-version'
    //   531: invokestatic zq : ()Ljava/lang/String;
    //   534: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   537: ldc_w 'client-brand'
    //   540: invokestatic zi : ()Ljava/lang/String;
    //   543: invokevirtual bY : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   546: invokevirtual aSZ : ()Lb/ae;
    //   549: astore_3
    //   550: aload_3
    //   551: astore #4
    //   553: aload_3
    //   554: astore #5
    //   556: aload #9
    //   558: astore #7
    //   560: new java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial <init> : ()V
    //   567: astore #6
    //   569: aload_3
    //   570: astore #4
    //   572: aload_3
    //   573: astore #5
    //   575: aload #9
    //   577: astore #7
    //   579: aload #6
    //   581: ldc_w '详情： url：'
    //   584: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_3
    //   589: astore #4
    //   591: aload_3
    //   592: astore #5
    //   594: aload #9
    //   596: astore #7
    //   598: aload #6
    //   600: aload_3
    //   601: invokevirtual aRk : ()Lb/w;
    //   604: invokevirtual aSa : ()Ljava/net/URI;
    //   607: invokevirtual toString : ()Ljava/lang/String;
    //   610: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_3
    //   615: astore #4
    //   617: aload_3
    //   618: astore #5
    //   620: aload #9
    //   622: astore #7
    //   624: new com/laiqian/util/logger/d
    //   627: dup
    //   628: ldc_w 'OkHttpUtil'
    //   631: ldc_w 'getRequestWithoutParse'
    //   634: ldc_w '请求信息'
    //   637: aload #6
    //   639: invokevirtual toString : ()Ljava/lang/String;
    //   642: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   645: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   648: getstatic com/laiqian/util/logger/h$b.dHJ : Lcom/laiqian/util/logger/h$b;
    //   651: aload_1
    //   652: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;Ljava/lang/String;)V
    //   655: aload_3
    //   656: astore #4
    //   658: aload_3
    //   659: astore #5
    //   661: aload #9
    //   663: astore #7
    //   665: getstatic com/laiqian/network/k.adg : Lb/aa;
    //   668: aload_3
    //   669: invokevirtual a : (Lb/ae;)Lb/f;
    //   672: invokeinterface aRI : ()Lb/aj;
    //   677: astore #6
    //   679: aload_3
    //   680: astore #4
    //   682: aload_3
    //   683: astore #5
    //   685: aload #9
    //   687: astore #7
    //   689: aload #6
    //   691: invokevirtual aGo : ()I
    //   694: sipush #200
    //   697: if_icmpeq -> 864
    //   700: aload_3
    //   701: astore #4
    //   703: aload_3
    //   704: astore #5
    //   706: aload #9
    //   708: astore #7
    //   710: new java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial <init> : ()V
    //   717: astore #8
    //   719: aload_3
    //   720: astore #4
    //   722: aload_3
    //   723: astore #5
    //   725: aload #9
    //   727: astore #7
    //   729: aload #8
    //   731: ldc_w ' url：'
    //   734: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_3
    //   739: astore #4
    //   741: aload_3
    //   742: astore #5
    //   744: aload #9
    //   746: astore #7
    //   748: aload #8
    //   750: aload_3
    //   751: invokevirtual aRk : ()Lb/w;
    //   754: invokevirtual aSa : ()Ljava/net/URI;
    //   757: invokevirtual toString : ()Ljava/lang/String;
    //   760: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload_3
    //   765: astore #4
    //   767: aload_3
    //   768: astore #5
    //   770: aload #9
    //   772: astore #7
    //   774: aload #8
    //   776: ldc_w '详情：'
    //   779: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload_3
    //   784: astore #4
    //   786: aload_3
    //   787: astore #5
    //   789: aload #9
    //   791: astore #7
    //   793: aload #8
    //   795: aload #6
    //   797: invokevirtual aGo : ()I
    //   800: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload_3
    //   805: astore #4
    //   807: aload_3
    //   808: astore #5
    //   810: aload #9
    //   812: astore #7
    //   814: aload #8
    //   816: ldc_w ''
    //   819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload_3
    //   824: astore #4
    //   826: aload_3
    //   827: astore #5
    //   829: aload #9
    //   831: astore #7
    //   833: new com/laiqian/util/logger/d
    //   836: dup
    //   837: ldc_w 'OkHttpUtil'
    //   840: ldc_w 'getRequestWithoutParse'
    //   843: ldc_w '请求异常'
    //   846: aload #8
    //   848: invokevirtual toString : ()Ljava/lang/String;
    //   851: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   854: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   857: getstatic com/laiqian/util/logger/h$b.dHJ : Lcom/laiqian/util/logger/h$b;
    //   860: aload_1
    //   861: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;Ljava/lang/String;)V
    //   864: iload_2
    //   865: ifeq -> 891
    //   868: aload_3
    //   869: astore #4
    //   871: aload_3
    //   872: astore #5
    //   874: aload #9
    //   876: astore #7
    //   878: aload #6
    //   880: invokevirtual aGo : ()I
    //   883: invokestatic valueOf : (I)Ljava/lang/String;
    //   886: astore #6
    //   888: goto -> 936
    //   891: aload_3
    //   892: astore #4
    //   894: aload_3
    //   895: astore #5
    //   897: aload #9
    //   899: astore #7
    //   901: aload #6
    //   903: invokevirtual aTc : ()Lb/ak;
    //   906: invokevirtual aTk : ()Ljava/lang/String;
    //   909: astore #8
    //   911: aload #8
    //   913: invokevirtual trim : ()Ljava/lang/String;
    //   916: ldc_w '\\r'
    //   919: ldc_w ''
    //   922: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   925: ldc_w '\\n'
    //   928: ldc_w ''
    //   931: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   934: astore #6
    //   936: aload_3
    //   937: astore #4
    //   939: aload_3
    //   940: astore #5
    //   942: aload #6
    //   944: astore #7
    //   946: new java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial <init> : ()V
    //   953: astore #8
    //   955: aload_3
    //   956: astore #4
    //   958: aload_3
    //   959: astore #5
    //   961: aload #6
    //   963: astore #7
    //   965: aload #8
    //   967: ldc_w ' url：'
    //   970: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload_3
    //   975: astore #4
    //   977: aload_3
    //   978: astore #5
    //   980: aload #6
    //   982: astore #7
    //   984: aload #8
    //   986: aload_3
    //   987: invokevirtual aRk : ()Lb/w;
    //   990: invokevirtual aSa : ()Ljava/net/URI;
    //   993: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload_3
    //   998: astore #4
    //   1000: aload_3
    //   1001: astore #5
    //   1003: aload #6
    //   1005: astore #7
    //   1007: aload #8
    //   1009: ldc_w '详情：'
    //   1012: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload_3
    //   1017: astore #4
    //   1019: aload_3
    //   1020: astore #5
    //   1022: aload #6
    //   1024: astore #7
    //   1026: aload #8
    //   1028: aload #6
    //   1030: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload_3
    //   1035: astore #4
    //   1037: aload_3
    //   1038: astore #5
    //   1040: aload #6
    //   1042: astore #7
    //   1044: new com/laiqian/util/logger/d
    //   1047: dup
    //   1048: ldc_w 'OkHttpUtil'
    //   1051: ldc_w 'getRequestWithoutParse'
    //   1054: ldc_w '返回信息'
    //   1057: aload #8
    //   1059: invokevirtual toString : ()Ljava/lang/String;
    //   1062: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1065: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   1068: getstatic com/laiqian/util/logger/h$b.dHJ : Lcom/laiqian/util/logger/h$b;
    //   1071: aload_1
    //   1072: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;Ljava/lang/String;)V
    //   1075: aload #6
    //   1077: areturn
    //   1078: aload #8
    //   1080: areturn
    //   1081: astore #5
    //   1083: goto -> 1096
    //   1086: astore #4
    //   1088: goto -> 1197
    //   1091: astore #5
    //   1093: aload #4
    //   1095: astore_3
    //   1096: new java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial <init> : ()V
    //   1103: astore #4
    //   1105: aload #4
    //   1107: ldc_w 'url：'
    //   1110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: aload #4
    //   1116: aload_3
    //   1117: invokevirtual aRk : ()Lb/w;
    //   1120: invokevirtual aSa : ()Ljava/net/URI;
    //   1123: invokevirtual toString : ()Ljava/lang/String;
    //   1126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: aload #4
    //   1132: ldc_w '详情：'
    //   1135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: pop
    //   1139: aload #4
    //   1141: aload #5
    //   1143: invokevirtual toString : ()Ljava/lang/String;
    //   1146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: new com/laiqian/util/logger/d
    //   1153: dup
    //   1154: ldc_w 'OkHttpUtil'
    //   1157: ldc_w 'sendRequestToServer'
    //   1160: ldc_w '请求异常'
    //   1163: aload #4
    //   1165: invokevirtual toString : ()Ljava/lang/String;
    //   1168: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1171: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   1174: getstatic com/laiqian/util/logger/h$b.dHJ : Lcom/laiqian/util/logger/h$b;
    //   1177: aload_1
    //   1178: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;Ljava/lang/String;)V
    //   1181: new java/lang/Exception
    //   1184: dup
    //   1185: ldc_w 'encrypt content failed.'
    //   1188: invokespecial <init> : (Ljava/lang/String;)V
    //   1191: athrow
    //   1192: astore #4
    //   1194: aload #5
    //   1196: astore_3
    //   1197: new java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial <init> : ()V
    //   1204: astore #5
    //   1206: aload #5
    //   1208: ldc_w ' url：'
    //   1211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: pop
    //   1215: aload #5
    //   1217: aload_3
    //   1218: invokevirtual aRk : ()Lb/w;
    //   1221: invokevirtual aSa : ()Ljava/net/URI;
    //   1224: invokevirtual toString : ()Ljava/lang/String;
    //   1227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload #5
    //   1233: ldc_w '详情：'
    //   1236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: pop
    //   1240: aload #5
    //   1242: aload #4
    //   1244: invokevirtual toString : ()Ljava/lang/String;
    //   1247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: pop
    //   1251: new com/laiqian/util/logger/d
    //   1254: dup
    //   1255: ldc_w 'OkHttpUtil'
    //   1258: ldc_w 'getRequestWithoutParse'
    //   1261: ldc_w '请求异常'
    //   1264: aload #5
    //   1266: invokevirtual toString : ()Ljava/lang/String;
    //   1269: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1272: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   1275: getstatic com/laiqian/util/logger/h$b.dHJ : Lcom/laiqian/util/logger/h$b;
    //   1278: aload_1
    //   1279: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;Ljava/lang/String;)V
    //   1282: new java/io/IOException
    //   1285: dup
    //   1286: ldc_w 'OKHTTP newCall failed.'
    //   1289: invokespecial <init> : (Ljava/lang/String;)V
    //   1292: athrow
    //   1293: ldc_w '-1'
    //   1296: areturn
    //   1297: astore_1
    //   1298: aload #7
    //   1300: areturn
    //   1301: astore_1
    //   1302: goto -> 1078
    //   1305: astore_1
    //   1306: goto -> 1293
    // Exception table:
    //   from	to	target	type
    //   43	55	1192	java/io/IOException
    //   43	55	1091	java/lang/Exception
    //   43	55	1297	finally
    //   67	74	1192	java/io/IOException
    //   67	74	1091	java/lang/Exception
    //   67	74	1297	finally
    //   86	100	1192	java/io/IOException
    //   86	100	1091	java/lang/Exception
    //   86	100	1297	finally
    //   115	125	1192	java/io/IOException
    //   115	125	1091	java/lang/Exception
    //   115	125	1297	finally
    //   143	150	1192	java/io/IOException
    //   143	150	1091	java/lang/Exception
    //   143	150	1297	finally
    //   162	171	1192	java/io/IOException
    //   162	171	1091	java/lang/Exception
    //   162	171	1297	finally
    //   183	192	1192	java/io/IOException
    //   183	192	1091	java/lang/Exception
    //   183	192	1297	finally
    //   204	211	1192	java/io/IOException
    //   204	211	1091	java/lang/Exception
    //   204	211	1297	finally
    //   223	232	1192	java/io/IOException
    //   223	232	1091	java/lang/Exception
    //   223	232	1297	finally
    //   244	252	1192	java/io/IOException
    //   244	252	1091	java/lang/Exception
    //   244	252	1297	finally
    //   264	273	1192	java/io/IOException
    //   264	273	1091	java/lang/Exception
    //   264	273	1297	finally
    //   285	292	1192	java/io/IOException
    //   285	292	1091	java/lang/Exception
    //   285	292	1297	finally
    //   304	313	1192	java/io/IOException
    //   304	313	1091	java/lang/Exception
    //   304	313	1297	finally
    //   325	337	1192	java/io/IOException
    //   325	337	1091	java/lang/Exception
    //   325	337	1297	finally
    //   349	358	1192	java/io/IOException
    //   349	358	1091	java/lang/Exception
    //   349	358	1297	finally
    //   374	459	1192	java/io/IOException
    //   374	459	1091	java/lang/Exception
    //   374	459	1297	finally
    //   474	550	1192	java/io/IOException
    //   474	550	1091	java/lang/Exception
    //   474	550	1297	finally
    //   560	569	1192	java/io/IOException
    //   560	569	1091	java/lang/Exception
    //   560	569	1297	finally
    //   579	588	1192	java/io/IOException
    //   579	588	1091	java/lang/Exception
    //   579	588	1297	finally
    //   598	614	1192	java/io/IOException
    //   598	614	1091	java/lang/Exception
    //   598	614	1297	finally
    //   624	655	1192	java/io/IOException
    //   624	655	1091	java/lang/Exception
    //   624	655	1297	finally
    //   665	679	1192	java/io/IOException
    //   665	679	1091	java/lang/Exception
    //   665	679	1297	finally
    //   689	700	1192	java/io/IOException
    //   689	700	1091	java/lang/Exception
    //   689	700	1297	finally
    //   710	719	1192	java/io/IOException
    //   710	719	1091	java/lang/Exception
    //   710	719	1297	finally
    //   729	738	1192	java/io/IOException
    //   729	738	1091	java/lang/Exception
    //   729	738	1297	finally
    //   748	764	1192	java/io/IOException
    //   748	764	1091	java/lang/Exception
    //   748	764	1297	finally
    //   774	783	1192	java/io/IOException
    //   774	783	1091	java/lang/Exception
    //   774	783	1297	finally
    //   793	804	1192	java/io/IOException
    //   793	804	1091	java/lang/Exception
    //   793	804	1297	finally
    //   814	823	1192	java/io/IOException
    //   814	823	1091	java/lang/Exception
    //   814	823	1297	finally
    //   833	864	1192	java/io/IOException
    //   833	864	1091	java/lang/Exception
    //   833	864	1297	finally
    //   878	888	1192	java/io/IOException
    //   878	888	1091	java/lang/Exception
    //   878	888	1297	finally
    //   901	911	1192	java/io/IOException
    //   901	911	1091	java/lang/Exception
    //   901	911	1297	finally
    //   911	936	1086	java/io/IOException
    //   911	936	1081	java/lang/Exception
    //   911	936	1301	finally
    //   946	955	1192	java/io/IOException
    //   946	955	1091	java/lang/Exception
    //   946	955	1297	finally
    //   965	974	1192	java/io/IOException
    //   965	974	1091	java/lang/Exception
    //   965	974	1297	finally
    //   984	997	1192	java/io/IOException
    //   984	997	1091	java/lang/Exception
    //   984	997	1297	finally
    //   1007	1016	1192	java/io/IOException
    //   1007	1016	1091	java/lang/Exception
    //   1007	1016	1297	finally
    //   1026	1034	1192	java/io/IOException
    //   1026	1034	1091	java/lang/Exception
    //   1026	1034	1297	finally
    //   1044	1075	1192	java/io/IOException
    //   1044	1075	1091	java/lang/Exception
    //   1044	1075	1297	finally
    //   1096	1192	1305	finally
    //   1197	1293	1305	finally }
  
  public String z(HashMap<String, Object> paramHashMap) throws JSONException {
    av av = new av(RootApplication.zv());
    String str1 = av.Ea();
    String str2 = av.auN();
    String str3 = av.Tx();
    av.close();
    return (new LqkRequest.a()).iG(str1).iH(str2).bU(by.parseLong(str3)).A(paramHashMap).WO().IX();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */