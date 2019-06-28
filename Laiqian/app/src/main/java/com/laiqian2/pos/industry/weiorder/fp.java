package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.av;
import com.laiqian.entity.aw;
import com.laiqian.models.an;
import com.laiqian.pos.hardware.q;
import com.laiqian.pos.industry.b;
import com.laiqian.pos.industry.weiorder.auth.a;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.ba;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.n;
import com.orhanobut.logger.d;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class fp {
  private static fp cwu;
  
  ba aNJ = new ba(true);
  
  private Context context;
  
  private fp(Context paramContext) { this.context = paramContext; }
  
  public static fp aX(Context paramContext) {
    if (cwu == null)
      cwu = new fp(RootApplication.zv()); 
    return cwu;
  }
  
  public boolean a(gp paramgp) {
    try {
      if (!this.context.getResources().getBoolean(2131034123)) {
        HashMap hashMap1 = new HashMap();
        av av = new av(this.context);
        JSONObject jSONObject1 = new JSONObject();
        jSONArray1 = new JSONArray();
        for (eh eh : paramgp.ach()) {
          JSONObject jSONObject3 = new JSONObject();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(eh.abM());
          stringBuilder2.append(",");
          stringBuilder2.append(eh.FI());
          jSONObject3.put("value", stringBuilder2.toString());
          jSONArray1.put(jSONObject3);
        } 
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("Discount", jSONArray1);
        jSONObject1.put("coupons", jSONObject2.toString());
        str2 = new StringBuilder();
        str2.append(paramgp.ack());
        str2.append("");
        jSONObject1.put("minimum_price", str2.toString());
        str2 = new StringBuilder();
        str2.append(paramgp.aci());
        str2.append("");
        jSONObject1.put("delivery_price", str2.toString());
        jSONObject1.put("deliver_tax", paramgp.acn());
        jSONObject1.put("dishware_tax", paramgp.acn());
        jSONObject2 = new JSONObject();
        if (paramgp.FH()) {
          String str2 = "1";
        } else {
          JSONArray jSONArray1;
          String str2;
          str2 = "0";
        } 
        jSONObject2.put("WeiXinPay", str2);
        if (paramgp.acl()) {
          str2 = "1";
        } else {
          str2 = "0";
        } 
        jSONObject2.put("CashPay", str2);
        if (paramgp.aco()) {
          str2 = "1";
        } else {
          str2 = "0";
        } 
        jSONObject2.put("VipPay", str2);
        jSONObject2.put("AliPay", "0");
        jSONObject1.put("payment_way", jSONObject2.toString());
        jSONObject1.put("delivery_time", paramgp.acm());
        null = new StringBuilder();
        null.append(paramgp.FI());
        null.append("");
        jSONObject1.put("discount", null.toString());
        String str1 = bd.a(av, paramgp.aSI, hashMap1, b.crE, jSONObject1, this.context);
        ba ba1 = this.aNJ;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getPaymentSettings post result: ");
        stringBuilder1.append(str1);
        ba1.lA(stringBuilder1.toString());
        if (!TextUtils.isEmpty(str1)) {
          if (TextUtils.isEmpty(au.f(str1, this.context)))
            return false; 
        } else {
          return false;
        } 
      } 
      new av(this.context);
      HashMap hashMap = new HashMap();
      hashMap.put("shopid", paramgp.aSI);
      JSONArray jSONArray = new JSONArray();
      new ArrayList();
      for (eh eh : paramgp.ach()) {
        JSONObject jSONObject1 = new JSONObject();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(eh.abM());
        stringBuilder1.append(",");
        stringBuilder1.append(eh.FI());
        jSONObject1.put("value", stringBuilder1.toString());
        jSONArray.put(jSONObject1);
      } 
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("Discount", jSONArray);
      hashMap.put("sAmountDiscount", jSONObject.toString());
      String str = new StringBuilder();
      str.append(paramgp.ack());
      str.append("");
      hashMap.put("fMinSellStartAmount", str.toString());
      str = new StringBuilder();
      str.append(paramgp.acj());
      str.append("");
      hashMap.put("fDishwareAmount", str.toString());
      str = new StringBuilder();
      str.append(paramgp.aci());
      str.append("");
      hashMap.put("fDeliverAmount", str.toString());
      if (paramgp.FA()) {
        String str1 = "1";
      } else {
        str = "0";
      } 
      hashMap.put("bIsLqkWechatAccount", str);
      jSONObject = new JSONObject();
      if (paramgp.FH()) {
        str = "1";
      } else {
        str = "0";
      } 
      jSONObject.put("WeiXinPay", str);
      if (paramgp.acl()) {
        str = "1";
      } else {
        str = "0";
      } 
      jSONObject.put("CashPay", str);
      jSONObject.put("AliPay", "0");
      if (paramgp.aco()) {
        str = "1";
      } else {
        str = "0";
      } 
      jSONObject.put("VipPay", str);
      hashMap.put("sPayType", jSONObject.toString());
      hashMap.put("sNotification", "");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramgp.FI());
      stringBuilder.append("");
      hashMap.put("fRebates", stringBuilder.toString());
      hashMap.put("deliver_tax", paramgp.acn());
      hashMap.put("dishware_tax", paramgp.acn());
      boolean bool = "success".equals(bd.d(b.crB, hashMap));
      return bool;
    } catch (Exception paramgp) {
      a.e(paramgp);
      return false;
    } 
  }
  
  public boolean a(k paramk) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(q.ckV);
    stringBuilder2.append("shop/updatepayment");
    String str3 = stringBuilder2.toString();
    av av = new av(this.context);
    String str2 = av.Ea();
    String str4 = av.atr();
    String str5 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("sUserPhone", str2);
    hashMap.put("sUserPassword", str4);
    hashMap.put("nShopID", str5);
    if (paramk.FG()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bKoubeiOrder", str2);
    if (paramk.FE()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bOfflineAliPay", str2);
    if (paramk.FF()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bOfflineWechatPay", str2);
    if (paramk.Fz()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bIsLqkAlipayAccount", str2);
    if (paramk.FA()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bIsLqkWechatAccount", str2);
    if (paramk.FH()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bWeixinOrder", str2);
    if (paramk.aba()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bSelfOrderVipPay", str2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramk.FI());
    stringBuilder1.append("");
    hashMap.put("rebates", stringBuilder1.toString());
    str1 = bh.a(str3, this.context, hashMap);
    if (!TextUtils.isEmpty(str1))
      try {
        boolean bool = (new JSONObject(str1)).getString("sResult").equals("success");
        return bool;
      } catch (Exception str1) {
        return false;
      }  
    return false;
  }
  
  public aw abV() {
    null = new an(this.context);
    aw aw2 = null.Vv();
    null.close();
    aw aw1 = aw2;
    if (aw2 == null) {
      aw2 = new aw();
      aw2.setEnabled(true);
      aw1 = aw2;
      if (CrashApplication.getLaiqianPreferenceManager().QV() == 1) {
        aw2.eH(1);
        aw1 = aw2;
      } 
    } 
    if (!n.bL(this.context)) {
      aw1.eH(2);
      av av = new av(this.context);
      String str = av.Tx();
      av.close();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(q.ckV);
      stringBuilder.append(str);
      stringBuilder.append("?en=1");
      aw1.setUrl(stringBuilder.toString());
    } 
    return aw1;
  }
  
  public av abW() { return (new an(this.context)).Vw(); }
  
  public gp abX() {
    av av = new av(this.context);
    str = av.Tx();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("shopid", str);
      String str1 = bd.d(b.crC, hashMap);
      ba ba1 = this.aNJ;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getPaymentSettings post result: ");
      stringBuilder.append(str1);
      ba1.lA(stringBuilder.toString());
      if (!TextUtils.isEmpty(str1)) {
        ba ba2 = gp.k(new JSONObject(str1));
        if (!this.context.getResources().getBoolean(2131034123)) {
          null = new JSONObject();
          String str2 = bd.a(av, str, hashMap, b.crD, null, this.context);
          ba2 = this.aNJ;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("getPaymentSettings post result: ");
          stringBuilder1.append(str2);
          ba2.lA(stringBuilder1.toString());
          if (!TextUtils.isEmpty(str2)) {
            str2 = au.f(str2, this.context);
            boolean bool = TextUtils.isEmpty(str2);
            if (!bool)
              try {
                return gp.f(new JSONObject(str2), str);
              } catch (Exception str) {
                return null;
              }  
          } else {
            return null;
          } 
        } else {
          return ba2;
        } 
      } 
      hashMap.put("flavor", LQKVersion.zi());
      return null;
    } catch (Exception str) {
      return null;
    } 
  }
  
  @DebugLog
  public a abY() {
    str1 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str2 = RootApplication.getLaiqianPreferenceManager().atr();
    String str3 = RootApplication.getLaiqianPreferenceManager().Tx();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "1");
      str1 = bh.a(b.crN, this.context, hashMap);
      ba ba1 = this.aNJ;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getPaymentSettings post result: ");
      stringBuilder.append(str1);
      ba1.lA(stringBuilder.toString());
      if (!TextUtils.isEmpty(str1)) {
        JSONObject jSONObject = new JSONObject(str1);
        return "true".equals(jSONObject.optString("result")) ? a.l(jSONObject) : null;
      } 
      return null;
    } catch (Exception str1) {
      return null;
    } 
  }
  
  public av abZ() {
    av av = new av(this.context);
    str1 = av.Tx();
    String str2 = av.Ea();
    String str3 = av.atr();
    av.close();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("nShopID", str1);
      hashMap.put("sUserPhone", str2);
      hashMap.put("sUserPassword", str3);
      str2 = bh.a(b.crH, this.context, hashMap, 10000);
      if (!TextUtils.isEmpty(str2)) {
        StringBuilder stringBuilder = av.d(new JSONObject(str2));
        if (!this.context.getResources().getBoolean(2131034123)) {
          null = new JSONObject();
          String str = bd.a(av, str1, hashMap, b.crF, null, this.context);
          ba ba1 = this.aNJ;
          stringBuilder = new StringBuilder();
          stringBuilder.append("getShopInfoSettings post result: ");
          stringBuilder.append(str);
          ba1.lA(stringBuilder.toString());
          if (!TextUtils.isEmpty(str)) {
            str = au.f(str, this.context);
            boolean bool = TextUtils.isEmpty(str);
            if (!bool)
              try {
                return av.b(new JSONObject(str), str1);
              } catch (Exception str1) {
                return null;
              }  
          } else {
            return null;
          } 
        } else {
          return stringBuilder;
        } 
      } 
      return null;
    } catch (Exception str1) {
      return null;
    } 
  }
  
  public k aca() { // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #13
    //   9: new com/laiqian/util/av
    //   12: dup
    //   13: aload_0
    //   14: getfield context : Landroid/content/Context;
    //   17: invokespecial <init> : (Landroid/content/Context;)V
    //   20: astore #14
    //   22: aload #14
    //   24: invokevirtual Ea : ()Ljava/lang/String;
    //   27: astore #15
    //   29: aload #14
    //   31: invokevirtual atr : ()Ljava/lang/String;
    //   34: astore #16
    //   36: aload #14
    //   38: invokevirtual Tx : ()Ljava/lang/String;
    //   41: astore #17
    //   43: aload #14
    //   45: invokevirtual close : ()V
    //   48: aload #13
    //   50: ldc_w 'sUserPhone'
    //   53: aload #15
    //   55: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: aload #13
    //   61: ldc_w 'sUserPassword'
    //   64: aload #16
    //   66: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: aload #13
    //   72: ldc_w 'nShopID'
    //   75: aload #17
    //   77: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: new com/laiqian/pos/industry/weiorder/k
    //   84: dup
    //   85: aload #17
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: astore #16
    //   92: new java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial <init> : ()V
    //   99: astore #14
    //   101: aload #14
    //   103: getstatic com/laiqian/pos/hardware/q.ckV : Ljava/lang/String;
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload #14
    //   112: ldc_w 'shop/getpayment'
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload #14
    //   121: invokevirtual toString : ()Ljava/lang/String;
    //   124: astore #14
    //   126: aload #14
    //   128: aload_0
    //   129: getfield context : Landroid/content/Context;
    //   132: aload #13
    //   134: invokestatic a : (Ljava/lang/String;Landroid/content/Context;Ljava/util/HashMap;)Ljava/lang/String;
    //   137: astore #15
    //   139: new com/laiqian/util/ba
    //   142: dup
    //   143: invokestatic zg : ()Z
    //   146: invokespecial <init> : (Z)V
    //   149: astore #17
    //   151: new java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial <init> : ()V
    //   158: astore #18
    //   160: aload #18
    //   162: ldc_w 'param is:'
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload #18
    //   171: aload #13
    //   173: invokevirtual toString : ()Ljava/lang/String;
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload #18
    //   182: ldc_w ', url is:'
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #18
    //   191: aload #14
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload #18
    //   199: ldc_w 'result is:'
    //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload #18
    //   208: aload #15
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload #17
    //   216: aload #18
    //   218: invokevirtual toString : ()Ljava/lang/String;
    //   221: invokevirtual d : (Ljava/lang/String;)V
    //   224: new org/json/JSONObject
    //   227: dup
    //   228: aload #15
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: astore #15
    //   235: aload #15
    //   237: ldc_w 'sResult'
    //   240: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   243: istore #11
    //   245: iload #11
    //   247: ifeq -> 619
    //   250: aload #15
    //   252: ldc_w 'bWeixinOrder'
    //   255: invokevirtual optInt : (Ljava/lang/String;)I
    //   258: istore_3
    //   259: aload #15
    //   261: ldc_w 'bKoubeiOrder'
    //   264: invokevirtual optInt : (Ljava/lang/String;)I
    //   267: istore #4
    //   269: aload #15
    //   271: ldc_w 'bSelfOrderVipPay'
    //   274: iconst_0
    //   275: invokevirtual optInt : (Ljava/lang/String;I)I
    //   278: istore #5
    //   280: aload #15
    //   282: ldc_w 'bOfflineAliPay'
    //   285: iconst_0
    //   286: invokevirtual optInt : (Ljava/lang/String;I)I
    //   289: istore #6
    //   291: aload #15
    //   293: ldc_w 'bOfflineWechatPay'
    //   296: iconst_0
    //   297: invokevirtual optInt : (Ljava/lang/String;I)I
    //   300: istore #7
    //   302: aload #15
    //   304: ldc_w 'bIsLqkAlipayAccount'
    //   307: iconst_0
    //   308: invokevirtual optInt : (Ljava/lang/String;I)I
    //   311: istore #8
    //   313: aload #15
    //   315: ldc 'bIsLqkWechatAccount'
    //   317: iconst_0
    //   318: invokevirtual optInt : (Ljava/lang/String;I)I
    //   321: istore #9
    //   323: aload #15
    //   325: ldc_w 'bIsSignAlipayWap'
    //   328: invokevirtual getInt : (Ljava/lang/String;)I
    //   331: istore #10
    //   333: aload #15
    //   335: ldc_w 'rebates'
    //   338: invokevirtual getDouble : (Ljava/lang/String;)D
    //   341: dstore_1
    //   342: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   345: invokevirtual FC : ()Ljava/lang/String;
    //   348: astore #14
    //   350: aload #14
    //   352: astore #13
    //   354: aload #14
    //   356: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   359: ifeq -> 366
    //   362: ldc ''
    //   364: astore #13
    //   366: aload #15
    //   368: ldc_w 'sWechatPayAccount'
    //   371: ldc ''
    //   373: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   376: astore #15
    //   378: aload #15
    //   380: ifnull -> 630
    //   383: aload #15
    //   385: astore #14
    //   387: ldc ''
    //   389: aload #15
    //   391: invokevirtual equals : (Ljava/lang/Object;)Z
    //   394: ifeq -> 400
    //   397: goto -> 630
    //   400: new java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial <init> : ()V
    //   407: astore #15
    //   409: aload #15
    //   411: ldc_w 'wechatPayAccount is:'
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload #15
    //   420: aload #14
    //   422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload #17
    //   428: aload #15
    //   430: invokevirtual toString : ()Ljava/lang/String;
    //   433: invokevirtual d : (Ljava/lang/String;)V
    //   436: aload #16
    //   438: aload #13
    //   440: invokevirtual dh : (Ljava/lang/String;)V
    //   443: aload #16
    //   445: aload #14
    //   447: invokevirtual di : (Ljava/lang/String;)V
    //   450: iconst_1
    //   451: istore #12
    //   453: iload #4
    //   455: iconst_1
    //   456: if_icmpne -> 637
    //   459: iconst_1
    //   460: istore #11
    //   462: goto -> 465
    //   465: aload #16
    //   467: iload #11
    //   469: invokevirtual cI : (Z)V
    //   472: iload_3
    //   473: iconst_1
    //   474: if_icmpne -> 643
    //   477: iconst_1
    //   478: istore #11
    //   480: goto -> 483
    //   483: aload #16
    //   485: iload #11
    //   487: invokevirtual cJ : (Z)V
    //   490: iload #6
    //   492: iconst_1
    //   493: if_icmpne -> 649
    //   496: iconst_1
    //   497: istore #11
    //   499: goto -> 502
    //   502: aload #16
    //   504: iload #11
    //   506: invokevirtual cF : (Z)V
    //   509: iload #7
    //   511: iconst_1
    //   512: if_icmpne -> 655
    //   515: iconst_1
    //   516: istore #11
    //   518: goto -> 521
    //   521: aload #16
    //   523: iload #11
    //   525: invokevirtual cG : (Z)V
    //   528: iload #10
    //   530: iconst_1
    //   531: if_icmpne -> 661
    //   534: iconst_1
    //   535: istore #11
    //   537: goto -> 540
    //   540: aload #16
    //   542: iload #11
    //   544: invokevirtual cH : (Z)V
    //   547: aload #16
    //   549: dload_1
    //   550: invokevirtual p : (D)V
    //   553: iload #8
    //   555: iconst_1
    //   556: if_icmpne -> 667
    //   559: iconst_1
    //   560: istore #11
    //   562: goto -> 565
    //   565: aload #16
    //   567: iload #11
    //   569: invokevirtual cC : (Z)V
    //   572: iload #9
    //   574: iconst_1
    //   575: if_icmpne -> 673
    //   578: iconst_1
    //   579: istore #11
    //   581: goto -> 584
    //   584: aload #16
    //   586: iload #11
    //   588: invokevirtual cD : (Z)V
    //   591: iload #5
    //   593: iconst_1
    //   594: if_icmpne -> 679
    //   597: iload #12
    //   599: istore #11
    //   601: goto -> 604
    //   604: aload #16
    //   606: iload #11
    //   608: invokevirtual eY : (Z)V
    //   611: aload #16
    //   613: areturn
    //   614: astore #13
    //   616: goto -> 623
    //   619: aconst_null
    //   620: areturn
    //   621: astore #13
    //   623: aload #13
    //   625: invokestatic e : (Ljava/lang/Throwable;)V
    //   628: aconst_null
    //   629: areturn
    //   630: ldc ''
    //   632: astore #14
    //   634: goto -> 400
    //   637: iconst_0
    //   638: istore #11
    //   640: goto -> 465
    //   643: iconst_0
    //   644: istore #11
    //   646: goto -> 483
    //   649: iconst_0
    //   650: istore #11
    //   652: goto -> 502
    //   655: iconst_0
    //   656: istore #11
    //   658: goto -> 521
    //   661: iconst_0
    //   662: istore #11
    //   664: goto -> 540
    //   667: iconst_0
    //   668: istore #11
    //   670: goto -> 565
    //   673: iconst_0
    //   674: istore #11
    //   676: goto -> 584
    //   679: iconst_0
    //   680: istore #11
    //   682: goto -> 604
    // Exception table:
    //   from	to	target	type
    //   224	245	621	java/lang/Exception
    //   250	350	614	java/lang/Exception
    //   354	362	614	java/lang/Exception
    //   366	378	614	java/lang/Exception
    //   387	397	614	java/lang/Exception
    //   400	450	614	java/lang/Exception
    //   465	472	614	java/lang/Exception
    //   483	490	614	java/lang/Exception
    //   502	509	614	java/lang/Exception
    //   521	528	614	java/lang/Exception
    //   540	553	614	java/lang/Exception
    //   565	572	614	java/lang/Exception
    //   584	591	614	java/lang/Exception
    //   604	611	614	java/lang/Exception }
  
  public String ag(ArrayList<eh> paramArrayList) {
    try {
      HashMap hashMap = new HashMap();
      null = new av(this.context);
      String str = null.Tx();
      null.close();
      hashMap.put("shopid", str);
      JSONArray jSONArray = new JSONArray();
      for (eh eh : paramArrayList) {
        JSONObject jSONObject1 = new JSONObject();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(eh.abM());
        stringBuilder.append(",");
        stringBuilder.append(eh.FI());
        jSONObject1.put("value", stringBuilder.toString());
        jSONArray.put(jSONObject1);
      } 
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("Discount", jSONArray);
      hashMap.put("sAmountDiscount", jSONObject.toString());
      return bd.d(b.crB, hashMap);
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return null;
    } 
  }
  
  public Boolean b(a parama) {
    String str2 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str3 = RootApplication.getLaiqianPreferenceManager().atr();
    String str1 = "";
    if (CrashApplication.getLaiqianPreferenceManager().QV() == 1) {
      str1 = CrashApplication.getLaiqianPreferenceManager().avt();
    } else if (CrashApplication.getLaiqianPreferenceManager().QV() == 0) {
      str1 = CrashApplication.getLaiqianPreferenceManager().Tx();
    } 
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str2);
      hashMap.put("password", str3);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str1);
      hashMap.put("version", "1");
      if (parama.cxY.booleanValue()) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      hashMap.put("bIsManage", str1);
      if (parama.cxV.booleanValue()) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      hashMap.put("bMenuTakeaway", str1);
      if (parama.cxW.booleanValue()) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      hashMap.put("bMenuVip", str1);
      if (parama.cxX.booleanValue()) {
        str = "1";
      } else {
        str = "0";
      } 
      hashMap.put("bMenuShops", str);
      String str = bh.a(b.crO, this.context, hashMap);
      ba ba1 = this.aNJ;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("saveOfficialAccount result: ");
      stringBuilder.append(str);
      ba1.lA(stringBuilder.toString());
      return !TextUtils.isEmpty(str) ? ("true".equals((new JSONObject(str)).optString("result")) ? Boolean.valueOf(true) : Boolean.valueOf(false)) : Boolean.valueOf(false);
    } catch (Exception parama) {
      return Boolean.valueOf(false);
    } 
  }
  
  public boolean b(av paramav) { return (new an(this.context)).a(paramav); }
  
  public boolean b(aw paramaw) { return (new an(this.context)).a(paramaw); }
  
  public boolean c(av paramav) {
    if (!this.context.getResources().getBoolean(2131034123)) {
      av av2 = new av(this.context);
      HashMap hashMap1 = new HashMap();
      String str6 = av2.Tx();
      JSONObject jSONObject = paramav.Jp();
      try {
        String str = new StringBuilder();
        str.append(paramav.Ip());
        str.append("");
        jSONObject.put("shop_name", str.toString());
        str = new StringBuilder();
        str.append(paramav.Jl());
        str.append("");
        jSONObject.put("shop_description", str.toString());
        if (paramav.Jm()) {
          String str7 = "open";
        } else {
          str = "closed";
        } 
        jSONObject.put("shop_status", str);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramav.Jn());
        stringBuilder2.append("");
        jSONObject.put("cover_figure_url", stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramav.Jj());
        stringBuilder2.append("");
        jSONObject.put("contact", stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramav.Jk());
        stringBuilder2.append("");
        jSONObject.put("address", stringBuilder2.toString());
      } catch (Exception exception) {}
      String str5 = bd.a(av2, str6, hashMap1, b.crG, jSONObject, this.context);
      ba ba1 = this.aNJ;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("getPaymentSettings post result: ");
      stringBuilder1.append(str5);
      ba1.lA(stringBuilder1.toString());
      if (!TextUtils.isEmpty(str5)) {
        if (TextUtils.isEmpty(au.f(str5, this.context)))
          return false; 
      } else {
        return false;
      } 
    } 
    av av1 = new av(this.context);
    HashMap hashMap = new HashMap();
    String str2 = av1.Tx();
    String str3 = av1.Ea();
    String str4 = av1.atr();
    av1.close();
    hashMap.put("sUserPhone", str3);
    hashMap.put("sUserPassword", str4);
    hashMap.put("nShopID", str2);
    hashMap.put("sShopBusinessInfo", paramav.xy().toString());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramav.Ip());
    stringBuilder.append("");
    hashMap.put("sShopName", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramav.Jj());
    stringBuilder.append("");
    hashMap.put("sShopContact", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramav.Jk());
    stringBuilder.append("");
    hashMap.put("sShopAddress", stringBuilder.toString());
    str1 = bh.a(b.crI, this.context, hashMap);
    if (!TextUtils.isEmpty(str1))
      try {
        boolean bool = (new JSONObject(str1)).getString("sResult").equals("success");
        return bool;
      } catch (Exception str1) {
        return false;
      }  
    return false;
  }
  
  public String kb(String paramString) {
    HashMap hashMap = new HashMap();
    hashMap.put("shop_id", paramString);
    try {
      paramString = bd.d(b.crK, hashMap);
      d.sQ(paramString);
      if (TextUtils.isEmpty(paramString))
        return null; 
      if (paramString.equals("failure"))
        return null; 
      HashMap hashMap1 = au.qB(paramString);
      return (hashMap1 != null && hashMap1.containsKey("url")) ? hashMap1.get("url").toString() : null;
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */