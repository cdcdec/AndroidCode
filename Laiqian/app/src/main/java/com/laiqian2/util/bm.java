package com.laiqian.util;

import android.text.TextUtils;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.t;
import com.laiqian.pos.hardware.RootUrlParameter;
import java.util.HashMap;
import org.json.JSONObject;

public class bm {
  public boolean a(t paramt) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(RootUrlParameter.ckV);
    stringBuilder2.append("shop/updatepayment");
    String str3 = stringBuilder2.toString();
    av av = RootApplication.getLaiqianPreferenceManager();
    String str2 = av.Ea();
    String str4 = av.atr();
    String str5 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("sUserPhone", str2);
    hashMap.put("sUserPassword", str4);
    hashMap.put("nShopID", str5);
    if (paramt.FG()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bKoubeiOrder", str2);
    if (paramt.FE()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bOfflineAliPay", str2);
    if (paramt.FF()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bOfflineWechatPay", str2);
    if (paramt.Fz()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bIsLqkAlipayAccount", str2);
    if (paramt.FA()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bIsLqkWechatAccount", str2);
    if (paramt.FH()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bWeixinOrder", str2);
    if (paramt.FB()) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    hashMap.put("bVipPay", str2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramt.FI());
    stringBuilder1.append("");
    hashMap.put("rebates", stringBuilder1.toString());
    str1 = bh.a(str3, RootApplication.zv(), hashMap);
    if (!TextUtils.isEmpty(str1))
      try {
        boolean bool = (new JSONObject(str1)).getString("sResult").equals("success");
        return bool;
      } catch (Exception str1) {
        return false;
      }  
    return false;
  }
  
  public t awr() { // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #13
    //   9: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   12: astore #14
    //   14: aload #14
    //   16: invokevirtual Ea : ()Ljava/lang/String;
    //   19: astore #15
    //   21: aload #14
    //   23: invokevirtual atr : ()Ljava/lang/String;
    //   26: astore #16
    //   28: aload #14
    //   30: invokevirtual Tx : ()Ljava/lang/String;
    //   33: astore #17
    //   35: aload #14
    //   37: invokevirtual close : ()V
    //   40: aload #13
    //   42: ldc 'sUserPhone'
    //   44: aload #15
    //   46: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: aload #13
    //   52: ldc 'sUserPassword'
    //   54: aload #16
    //   56: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: aload #13
    //   62: ldc 'nShopID'
    //   64: aload #17
    //   66: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: new com/laiqian/entity/t
    //   73: dup
    //   74: aload #17
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: astore #16
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #14
    //   90: aload #14
    //   92: getstatic com/laiqian/pos/hardware/RootUrlParameter.ckV : Ljava/lang/String;
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #14
    //   101: ldc 'shop/getpayment'
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload #14
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   115: aload #13
    //   117: invokestatic a : (Ljava/lang/String;Landroid/content/Context;Ljava/util/HashMap;)Ljava/lang/String;
    //   120: astore #13
    //   122: new org/json/JSONObject
    //   125: dup
    //   126: aload #13
    //   128: invokespecial <init> : (Ljava/lang/String;)V
    //   131: astore #15
    //   133: aload #15
    //   135: ldc 'sResult'
    //   137: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   140: istore #11
    //   142: iload #11
    //   144: ifeq -> 470
    //   147: aload #15
    //   149: ldc 'bVipPay'
    //   151: invokevirtual optInt : (Ljava/lang/String;)I
    //   154: istore_3
    //   155: aload #15
    //   157: ldc 'bWeixinOrder'
    //   159: invokevirtual optInt : (Ljava/lang/String;)I
    //   162: istore #4
    //   164: aload #15
    //   166: ldc 'bKoubeiOrder'
    //   168: invokevirtual optInt : (Ljava/lang/String;)I
    //   171: istore #5
    //   173: aload #15
    //   175: ldc 'bOfflineAliPay'
    //   177: iconst_0
    //   178: invokevirtual optInt : (Ljava/lang/String;I)I
    //   181: istore #6
    //   183: aload #15
    //   185: ldc 'bOfflineWechatPay'
    //   187: iconst_0
    //   188: invokevirtual optInt : (Ljava/lang/String;I)I
    //   191: istore #7
    //   193: aload #15
    //   195: ldc 'bIsLqkAlipayAccount'
    //   197: iconst_0
    //   198: invokevirtual optInt : (Ljava/lang/String;I)I
    //   201: istore #8
    //   203: aload #15
    //   205: ldc 'bIsLqkWechatAccount'
    //   207: iconst_0
    //   208: invokevirtual optInt : (Ljava/lang/String;I)I
    //   211: istore #9
    //   213: aload #15
    //   215: ldc 'bIsSignAlipayWap'
    //   217: invokevirtual getInt : (Ljava/lang/String;)I
    //   220: istore #10
    //   222: aload #15
    //   224: ldc 'rebates'
    //   226: invokevirtual getDouble : (Ljava/lang/String;)D
    //   229: dstore_1
    //   230: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   233: invokevirtual FC : ()Ljava/lang/String;
    //   236: astore #14
    //   238: aload #14
    //   240: astore #13
    //   242: aload #14
    //   244: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   247: ifeq -> 254
    //   250: ldc ''
    //   252: astore #13
    //   254: aload #15
    //   256: ldc 'sWechatPayAccount'
    //   258: ldc ''
    //   260: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   263: astore #15
    //   265: aload #15
    //   267: ifnull -> 481
    //   270: aload #15
    //   272: astore #14
    //   274: ldc ''
    //   276: aload #15
    //   278: invokevirtual equals : (Ljava/lang/Object;)Z
    //   281: ifeq -> 287
    //   284: goto -> 481
    //   287: aload #16
    //   289: aload #13
    //   291: invokevirtual dh : (Ljava/lang/String;)V
    //   294: aload #16
    //   296: aload #14
    //   298: invokevirtual di : (Ljava/lang/String;)V
    //   301: iconst_1
    //   302: istore #12
    //   304: iload #5
    //   306: iconst_1
    //   307: if_icmpne -> 488
    //   310: iconst_1
    //   311: istore #11
    //   313: goto -> 316
    //   316: aload #16
    //   318: iload #11
    //   320: invokevirtual cI : (Z)V
    //   323: iload #4
    //   325: iconst_1
    //   326: if_icmpne -> 494
    //   329: iconst_1
    //   330: istore #11
    //   332: goto -> 335
    //   335: aload #16
    //   337: iload #11
    //   339: invokevirtual cJ : (Z)V
    //   342: iload_3
    //   343: iconst_1
    //   344: if_icmpne -> 500
    //   347: iconst_1
    //   348: istore #11
    //   350: goto -> 353
    //   353: aload #16
    //   355: iload #11
    //   357: invokevirtual cE : (Z)V
    //   360: iload #6
    //   362: iconst_1
    //   363: if_icmpne -> 506
    //   366: iconst_1
    //   367: istore #11
    //   369: goto -> 372
    //   372: aload #16
    //   374: iload #11
    //   376: invokevirtual cF : (Z)V
    //   379: iload #7
    //   381: iconst_1
    //   382: if_icmpne -> 512
    //   385: iconst_1
    //   386: istore #11
    //   388: goto -> 391
    //   391: aload #16
    //   393: iload #11
    //   395: invokevirtual cG : (Z)V
    //   398: iload #10
    //   400: iconst_1
    //   401: if_icmpne -> 518
    //   404: iconst_1
    //   405: istore #11
    //   407: goto -> 410
    //   410: aload #16
    //   412: iload #11
    //   414: invokevirtual cH : (Z)V
    //   417: aload #16
    //   419: dload_1
    //   420: invokevirtual p : (D)V
    //   423: iload #8
    //   425: iconst_1
    //   426: if_icmpne -> 524
    //   429: iconst_1
    //   430: istore #11
    //   432: goto -> 435
    //   435: aload #16
    //   437: iload #11
    //   439: invokevirtual cC : (Z)V
    //   442: iload #9
    //   444: iconst_1
    //   445: if_icmpne -> 530
    //   448: iload #12
    //   450: istore #11
    //   452: goto -> 455
    //   455: aload #16
    //   457: iload #11
    //   459: invokevirtual cD : (Z)V
    //   462: aload #16
    //   464: areturn
    //   465: astore #13
    //   467: goto -> 474
    //   470: aconst_null
    //   471: areturn
    //   472: astore #13
    //   474: aload #13
    //   476: invokestatic e : (Ljava/lang/Throwable;)V
    //   479: aconst_null
    //   480: areturn
    //   481: ldc ''
    //   483: astore #14
    //   485: goto -> 287
    //   488: iconst_0
    //   489: istore #11
    //   491: goto -> 316
    //   494: iconst_0
    //   495: istore #11
    //   497: goto -> 335
    //   500: iconst_0
    //   501: istore #11
    //   503: goto -> 353
    //   506: iconst_0
    //   507: istore #11
    //   509: goto -> 372
    //   512: iconst_0
    //   513: istore #11
    //   515: goto -> 391
    //   518: iconst_0
    //   519: istore #11
    //   521: goto -> 410
    //   524: iconst_0
    //   525: istore #11
    //   527: goto -> 435
    //   530: iconst_0
    //   531: istore #11
    //   533: goto -> 455
    // Exception table:
    //   from	to	target	type
    //   122	142	472	java/lang/Exception
    //   147	238	465	java/lang/Exception
    //   242	250	465	java/lang/Exception
    //   254	265	465	java/lang/Exception
    //   274	284	465	java/lang/Exception
    //   287	301	465	java/lang/Exception
    //   316	323	465	java/lang/Exception
    //   335	342	465	java/lang/Exception
    //   353	360	465	java/lang/Exception
    //   372	379	465	java/lang/Exception
    //   391	398	465	java/lang/Exception
    //   410	423	465	java/lang/Exception
    //   435	442	465	java/lang/Exception
    //   455	462	465	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */