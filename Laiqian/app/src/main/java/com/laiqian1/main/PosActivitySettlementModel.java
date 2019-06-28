package com.laiqian.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.AsyncTaskLoader;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.aq;
import com.laiqian.entity.z;
import com.laiqian.member.setting.bc;
import com.laiqian.member.setting.sms.h;
import com.laiqian.member.setting.sms.i;
import com.laiqian.models.ab;
import com.laiqian.models.b;
import com.laiqian.models.d;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.models.m;
import com.laiqian.models.v;
import com.laiqian.models.x;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.online.h;
import com.laiqian.product.models.g;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class PosActivitySettlementModel extends v {
  public PosActivitySettlementModel(Context paramContext) { super(paramContext); }
  
  private Pair<Integer, Integer> a(boolean paramBoolean, double paramDouble1, double paramDouble2) {
    int i;
    Pair pair = a.AZ().Ce();
    int j = 0;
    if (paramBoolean) {
      paramDouble1 *= ((Double)pair.first).doubleValue() * 1.0D / ((Double)pair.second).doubleValue();
      i = bc.RH().am(paramDouble2);
    } else {
      paramDouble1 = -paramDouble1 * ((Double)pair.first).doubleValue() * 1.0D / ((Double)pair.second).doubleValue();
      i = 0;
    } 
    paramDouble1 = n.aZ(paramDouble1);
    if (a.AZ().Cd())
      j = (int)paramDouble1 - i; 
    return new Pair(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  private String a(bb parambb, z paramz, j paramj) {
    if (parambb.vipEntity != null) {
      byte b;
      double d2;
      double d1;
      pair = a.AZ().Ce();
      j.a a = new j.a();
      if (paramz.aTv == 10006) {
        if (parambb.isSaleOrder) {
          d1 = -paramz.aJW;
          b = (int)(paramz.aJW * ((Double)pair.first).doubleValue() * 1.0D / ((Double)pair.second).doubleValue());
        } else {
          double d;
          d1 = paramz.aJW;
          b = (int)(-paramz.aJW * ((Double)pair.first).doubleValue() * 1.0D / ((Double)pair.second).doubleValue());
        } 
        parambb.bce = d1;
        d2 = 0.0D;
      } else {
        if (parambb.isSaleOrder) {
          d1 = paramz.aJW;
          b = (int)(paramz.aJW * ((Double)pair.first).doubleValue() * 1.0D / ((Double)pair.second).doubleValue());
        } else {
          d1 = -paramz.aJW;
          b = (int)(-paramz.aJW * ((Double)pair.first).doubleValue() * 1.0D / ((Double)pair.second).doubleValue());
        } 
        d2 = d1;
        d1 = 0.0D;
      } 
      if (!a.AZ().Cd())
        b = 0; 
      try {
        String str1 = (new JSONObject(parambb.bch)).getString("settlementID");
      } catch (JSONException|NullPointerException pair) {
        a.e(pair);
        pair = null;
      } 
      long l = parambb.vipEntity.aSW;
      String str = parambb.orderNo;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(parambb.Lx());
      stringBuilder.append("");
      if (!paramj.a(l, d1, 370005L, d2, str, stringBuilder.toString(), b, paramz.aTv, paramz.aTx, parambb.vipEntity, a, pair))
        return this.mContext.getString(2131626354); 
      aq aq = parambb.vipEntity;
      aq.aWp += ((Integer)(a(parambb.isSaleOrder, parambb.bbY, parambb.bca)).first).intValue();
    } 
    return null;
  }
  
  private String a(bb parambb, b paramb, j paramj) {
    byte b1;
    for (b1 = 0; b1 < parambb.bbS.size(); b1++) {
      z z = (z)parambb.bbS.get(b1);
      try {
        jSONException = (new JSONObject(parambb.bch)).getString("settlementID");
      } catch (JSONException|NullPointerException jSONException) {
        a.e(jSONException);
        jSONException = null;
      } 
      boolean bool = parambb.isSaleOrder;
      long l = parambb.Lx();
      int i = z.aTv;
      String str = z.name;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(z.aJW);
      stringBuilder.append("");
      if (!paramb.a(bool, l, i, str, stringBuilder.toString(), parambb.orderNo, parambb.Ly(), z.aTx, parambb.bcf, z.aTy, jSONException, parambb.bcu))
        return this.mContext.getString(2131626360); 
      if (parambb.bbV) {
        String str1 = a(parambb, z, paramj);
        if (str1 != null)
          return str1; 
      } 
    } 
    return null;
  }
  
  private String a(bb parambb, j paramj) {
    if (parambb.vipEntity != null) {
      pair = a(parambb.isSaleOrder, parambb.bbY, parambb.bca);
      parambb.bbZ = ((Integer)pair.first).intValue();
      boolean bool = parambb.isSaleOrder;
      if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
        double d1;
        l l1 = new l(this.mContext);
        long l = parambb.vipEntity.aSW;
        double d2 = parambb.bce;
        int k = i(parambb);
        if (bool) {
          d1 = parambb.bbY;
        } else {
          d1 = -parambb.bbY;
        } 
        bool = l1.a(l, d2, k, d1, parambb.bbZ);
        l1.close();
        if (!bool)
          return this.mContext.getString(2131626353); 
      } 
      aq aq = parambb.vipEntity;
      aq.aWo += parambb.bce;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("会员余额：");
      stringBuilder.append(parambb.vipEntity.aWo);
      n.println(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("会员积分：");
      stringBuilder.append(parambb.vipEntity.aWp);
      n.println(stringBuilder.toString());
      int i = ((Integer)pair.second).intValue();
      if (i != 0) {
        if (paramj == null)
          return "插入积分抵扣记录时，类为null。这里不应该进来"; 
        try {
          String str1 = (new JSONObject(parambb.bch)).getString("settlementID");
        } catch (JSONException|NullPointerException pair) {
          a.e(pair);
          pair = null;
        } 
        long l = parambb.vipEntity.aSW;
        String str = parambb.orderNo;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(parambb.Lx());
        stringBuilder1.append("");
        if (!paramj.a(l, 0.0D, 370008L, 0.0D, str, stringBuilder1.toString(), -i, 0L, 0L, parambb.vipEntity, pair))
          return this.mContext.getString(2131626355); 
      } 
    } 
    return null;
  }
  
  private String a(bb parambb, g paramg) { // Byte code:
    //   0: aload_0
    //   1: astore #21
    //   3: aload_1
    //   4: astore #19
    //   6: aload_2
    //   7: astore #18
    //   9: dconst_0
    //   10: dstore_3
    //   11: aload #19
    //   13: dconst_0
    //   14: putfield bco : D
    //   17: aload #19
    //   19: getfield isSaleOrder : Z
    //   22: ifeq -> 36
    //   25: ldc_w '100001'
    //   28: astore #20
    //   30: iconst_m1
    //   31: istore #9
    //   33: goto -> 44
    //   36: ldc_w '100015'
    //   39: astore #20
    //   41: iconst_1
    //   42: istore #9
    //   44: new java/util/ArrayList
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #22
    //   53: aload #19
    //   55: getfield bca : D
    //   58: invokestatic bc : (D)Z
    //   61: ifne -> 95
    //   64: aload #22
    //   66: new com/laiqian/entity/aa
    //   69: dup
    //   70: lconst_0
    //   71: aload #21
    //   73: getfield mContext : Landroid/content/Context;
    //   76: ldc_w 2131626367
    //   79: invokevirtual getString : (I)Ljava/lang/String;
    //   82: aload #19
    //   84: getfield bca : D
    //   87: dneg
    //   88: invokespecial <init> : (JLjava/lang/String;D)V
    //   91: invokevirtual add : (Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload #19
    //   97: getfield bcb : D
    //   100: invokestatic bc : (D)Z
    //   103: ifne -> 137
    //   106: aload #22
    //   108: new com/laiqian/entity/aa
    //   111: dup
    //   112: lconst_0
    //   113: aload #21
    //   115: getfield mContext : Landroid/content/Context;
    //   118: ldc_w 2131627335
    //   121: invokevirtual getString : (I)Ljava/lang/String;
    //   124: aload #19
    //   126: getfield bcb : D
    //   129: dneg
    //   130: invokespecial <init> : (JLjava/lang/String;D)V
    //   133: invokevirtual add : (Ljava/lang/Object;)Z
    //   136: pop
    //   137: aload #19
    //   139: getfield amountRounding : D
    //   142: invokestatic bc : (D)Z
    //   145: ifne -> 172
    //   148: aload #22
    //   150: new com/laiqian/entity/aa
    //   153: dup
    //   154: ldc2_w 101
    //   157: ldc_w 'Rounding'
    //   160: aload #19
    //   162: getfield amountRounding : D
    //   165: invokespecial <init> : (JLjava/lang/String;D)V
    //   168: invokevirtual add : (Ljava/lang/Object;)Z
    //   171: pop
    //   172: aload #19
    //   174: getfield bbT : Ljava/util/ArrayList;
    //   177: invokevirtual size : ()I
    //   180: aload #22
    //   182: invokevirtual size : ()I
    //   185: iadd
    //   186: istore #11
    //   188: iconst_0
    //   189: istore #10
    //   191: iconst_0
    //   192: istore #12
    //   194: iconst_1
    //   195: istore #13
    //   197: aload_0
    //   198: astore #24
    //   200: iload #10
    //   202: iload #11
    //   204: if_icmpge -> 2473
    //   207: iload #10
    //   209: aload #19
    //   211: getfield bbT : Ljava/util/ArrayList;
    //   214: invokevirtual size : ()I
    //   217: isub
    //   218: istore #14
    //   220: iload #14
    //   222: ifge -> 268
    //   225: aload #19
    //   227: getfield bbT : Ljava/util/ArrayList;
    //   230: iload #10
    //   232: invokevirtual get : (I)Ljava/lang/Object;
    //   235: checkcast com/laiqian/entity/aa
    //   238: astore #21
    //   240: aload #21
    //   242: invokevirtual Gv : ()Z
    //   245: ifeq -> 255
    //   248: ldc2_w 100.0
    //   251: dstore_3
    //   252: goto -> 261
    //   255: aload #19
    //   257: getfield discount : D
    //   260: dstore_3
    //   261: aload #20
    //   263: astore #18
    //   265: goto -> 289
    //   268: aload #22
    //   270: iload #14
    //   272: invokevirtual get : (I)Ljava/lang/Object;
    //   275: checkcast com/laiqian/entity/aa
    //   278: astore #21
    //   280: ldc_w '100045'
    //   283: astore #18
    //   285: ldc2_w 100.0
    //   288: dstore_3
    //   289: new java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial <init> : ()V
    //   296: astore #23
    //   298: aload #23
    //   300: aload #21
    //   302: getfield aSW : J
    //   305: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload #23
    //   311: ldc ''
    //   313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload #24
    //   319: ldc_w 'nProductID'
    //   322: aload #23
    //   324: invokevirtual toString : ()Ljava/lang/String;
    //   327: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   330: pop
    //   331: new java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial <init> : ()V
    //   338: astore #23
    //   340: aload #23
    //   342: aload #21
    //   344: invokevirtual Gw : ()D
    //   347: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload #23
    //   353: ldc ''
    //   355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload #24
    //   361: ldc_w 'nProductQty'
    //   364: aload #23
    //   366: invokevirtual toString : ()Ljava/lang/String;
    //   369: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   372: pop
    //   373: new java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial <init> : ()V
    //   380: astore #23
    //   382: aload #23
    //   384: dload_3
    //   385: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload #23
    //   391: ldc ''
    //   393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload #24
    //   399: ldc_w 'fDiscount'
    //   402: aload #23
    //   404: invokevirtual toString : ()Ljava/lang/String;
    //   407: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   410: pop
    //   411: aload #19
    //   413: getfield isSaleOrder : Z
    //   416: ifeq -> 435
    //   419: aload #21
    //   421: invokevirtual Gw : ()D
    //   424: dconst_0
    //   425: dcmpg
    //   426: ifge -> 435
    //   429: dconst_0
    //   430: dstore #5
    //   432: goto -> 453
    //   435: aload #21
    //   437: aload #21
    //   439: invokevirtual GB : ()D
    //   442: invokevirtual s : (D)D
    //   445: ldc2_w 100.0
    //   448: ddiv
    //   449: dload_3
    //   450: dmul
    //   451: dstore #5
    //   453: new java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial <init> : ()V
    //   460: astore #23
    //   462: aload #23
    //   464: dload #5
    //   466: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload #23
    //   472: ldc ''
    //   474: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload #24
    //   480: ldc_w 'fPrice'
    //   483: aload #23
    //   485: invokevirtual toString : ()Ljava/lang/String;
    //   488: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   491: pop
    //   492: dload #5
    //   494: aload #21
    //   496: invokevirtual Gw : ()D
    //   499: dmul
    //   500: dstore #7
    //   502: new java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial <init> : ()V
    //   509: astore #23
    //   511: aload #23
    //   513: dload #7
    //   515: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload #23
    //   521: ldc ''
    //   523: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload #24
    //   529: ldc_w 'fAmount'
    //   532: aload #23
    //   534: invokevirtual toString : ()Ljava/lang/String;
    //   537: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   540: pop
    //   541: aload #19
    //   543: getfield isSaleOrder : Z
    //   546: ifeq -> 567
    //   549: aload #21
    //   551: invokevirtual Gw : ()D
    //   554: dconst_0
    //   555: dcmpg
    //   556: ifge -> 567
    //   559: ldc_w '0'
    //   562: astore #23
    //   564: goto -> 602
    //   567: new java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial <init> : ()V
    //   574: astore #23
    //   576: aload #23
    //   578: aload #21
    //   580: invokevirtual GB : ()D
    //   583: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload #23
    //   589: ldc ''
    //   591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload #23
    //   597: invokevirtual toString : ()Ljava/lang/String;
    //   600: astore #23
    //   602: aload #24
    //   604: ldc_w 'fSpareField1'
    //   607: aload #23
    //   609: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   612: pop
    //   613: new java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial <init> : ()V
    //   620: astore #23
    //   622: aload #23
    //   624: aload #19
    //   626: getfield bcf : J
    //   629: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload #23
    //   635: ldc ''
    //   637: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload #24
    //   643: ldc_w 'nSpareField2'
    //   646: aload #23
    //   648: invokevirtual toString : ()Ljava/lang/String;
    //   651: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   654: pop
    //   655: aload #21
    //   657: invokevirtual GM : ()Ljava/lang/StringBuilder;
    //   660: astore #24
    //   662: new java/lang/StringBuilder
    //   665: dup
    //   666: aload #21
    //   668: getfield cUM : Ljava/lang/String;
    //   671: invokespecial <init> : (Ljava/lang/String;)V
    //   674: astore #23
    //   676: aload #24
    //   678: invokevirtual length : ()I
    //   681: ifle -> 710
    //   684: aload #23
    //   686: ldc_w '['
    //   689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload #23
    //   695: aload #24
    //   697: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload #23
    //   703: ldc_w ']'
    //   706: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload #21
    //   712: invokevirtual GP : ()Ljava/util/ArrayList;
    //   715: astore #24
    //   717: aload #24
    //   719: ifnull -> 1110
    //   722: aload #24
    //   724: invokevirtual size : ()I
    //   727: ifle -> 1110
    //   730: aload #23
    //   732: ldc_w '('
    //   735: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload #24
    //   741: invokevirtual iterator : ()Ljava/util/Iterator;
    //   744: astore #25
    //   746: aload #19
    //   748: astore #24
    //   750: dload_3
    //   751: dstore #5
    //   753: aload #23
    //   755: astore #19
    //   757: aload #25
    //   759: astore #23
    //   761: dload #7
    //   763: dstore_3
    //   764: aload #23
    //   766: invokeinterface hasNext : ()Z
    //   771: ifeq -> 912
    //   774: aload #23
    //   776: invokeinterface next : ()Ljava/lang/Object;
    //   781: checkcast com/laiqian/product/models/o
    //   784: astore #25
    //   786: aload #25
    //   788: invokevirtual alc : ()I
    //   791: ifne -> 821
    //   794: aload #21
    //   796: invokevirtual GH : ()D
    //   799: aload #25
    //   801: invokevirtual ala : ()D
    //   804: dmul
    //   805: ldc2_w 100.0
    //   808: ddiv
    //   809: dload #5
    //   811: dmul
    //   812: ldc2_w 100.0
    //   815: ddiv
    //   816: dstore #7
    //   818: goto -> 824
    //   821: dconst_0
    //   822: dstore #7
    //   824: aload_1
    //   825: invokevirtual LA : ()Ljava/util/HashMap;
    //   828: ifnonnull -> 868
    //   831: aload #24
    //   833: aload #25
    //   835: invokevirtual getId : ()J
    //   838: aload #25
    //   840: invokevirtual akZ : ()Ljava/lang/String;
    //   843: aload #25
    //   845: invokevirtual ala : ()D
    //   848: aload #25
    //   850: invokevirtual ala : ()D
    //   853: dload_3
    //   854: dmul
    //   855: ldc2_w 100.0
    //   858: ddiv
    //   859: dload_3
    //   860: dload #7
    //   862: invokevirtual a : (JLjava/lang/String;DDDD)V
    //   865: goto -> 868
    //   868: aload #19
    //   870: aload #25
    //   872: invokevirtual akZ : ()Ljava/lang/String;
    //   875: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload #25
    //   881: invokevirtual alc : ()I
    //   884: iconst_1
    //   885: if_icmpne -> 897
    //   888: aload #19
    //   890: ldc_w '*'
    //   893: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload #19
    //   899: ldc_w '/'
    //   902: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload_1
    //   907: astore #24
    //   909: goto -> 764
    //   912: aload #21
    //   914: astore #23
    //   916: aload #19
    //   918: aload #19
    //   920: invokevirtual length : ()I
    //   923: iconst_1
    //   924: isub
    //   925: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload #19
    //   931: ldc_w ')'
    //   934: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: aload #23
    //   940: invokevirtual GQ : ()Ljava/util/ArrayList;
    //   943: astore #21
    //   945: aload #21
    //   947: ifnull -> 1098
    //   950: aload #21
    //   952: invokevirtual size : ()I
    //   955: ifle -> 1098
    //   958: aload #21
    //   960: invokevirtual iterator : ()Ljava/util/Iterator;
    //   963: astore #21
    //   965: aload #21
    //   967: invokeinterface hasNext : ()Z
    //   972: ifeq -> 1098
    //   975: aload #21
    //   977: invokeinterface next : ()Ljava/lang/Object;
    //   982: checkcast com/laiqian/product/models/o
    //   985: astore #24
    //   987: new java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial <init> : ()V
    //   994: astore #25
    //   996: aload #25
    //   998: aload #24
    //   1000: invokevirtual getId : ()J
    //   1003: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1006: pop
    //   1007: aload #25
    //   1009: ldc ''
    //   1011: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload #24
    //   1017: aload #25
    //   1019: invokevirtual toString : ()Ljava/lang/String;
    //   1022: invokevirtual mM : (Ljava/lang/String;)Z
    //   1025: ifeq -> 1055
    //   1028: dload_3
    //   1029: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1032: invokevirtual BW : ()D
    //   1035: dmul
    //   1036: ldc2_w 100.0
    //   1039: ddiv
    //   1040: aload #24
    //   1042: invokevirtual ala : ()D
    //   1045: dmul
    //   1046: ldc2_w 100.0
    //   1049: ddiv
    //   1050: dstore #7
    //   1052: goto -> 1058
    //   1055: dconst_0
    //   1056: dstore #7
    //   1058: aload_1
    //   1059: aload #24
    //   1061: invokevirtual getId : ()J
    //   1064: aload #24
    //   1066: invokevirtual akZ : ()Ljava/lang/String;
    //   1069: aload #24
    //   1071: invokevirtual ala : ()D
    //   1074: dload #7
    //   1076: aload #23
    //   1078: invokevirtual GK : ()D
    //   1081: aload_1
    //   1082: getfield discount : D
    //   1085: dmul
    //   1086: ldc2_w 100.0
    //   1089: ddiv
    //   1090: dload #7
    //   1092: invokevirtual a : (JLjava/lang/String;DDDD)V
    //   1095: goto -> 965
    //   1098: aload_1
    //   1099: astore #21
    //   1101: dload_3
    //   1102: dstore #7
    //   1104: dload #5
    //   1106: dstore_3
    //   1107: goto -> 1126
    //   1110: aload #23
    //   1112: astore #24
    //   1114: aload #21
    //   1116: astore #23
    //   1118: aload #19
    //   1120: astore #21
    //   1122: aload #24
    //   1124: astore #19
    //   1126: aload_1
    //   1127: invokevirtual LA : ()Ljava/util/HashMap;
    //   1130: ifnull -> 1152
    //   1133: aload_1
    //   1134: invokevirtual LA : ()Ljava/util/HashMap;
    //   1137: invokevirtual size : ()I
    //   1140: ifle -> 1152
    //   1143: aload #21
    //   1145: aload_1
    //   1146: invokevirtual LA : ()Ljava/util/HashMap;
    //   1149: invokevirtual l : (Ljava/util/HashMap;)V
    //   1152: aload #19
    //   1154: invokevirtual toString : ()Ljava/lang/String;
    //   1157: astore #19
    //   1159: aload_0
    //   1160: astore #24
    //   1162: aload #24
    //   1164: ldc_w 'sProductName'
    //   1167: aload #19
    //   1169: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1172: pop
    //   1173: ldc_w '100045'
    //   1176: aload #18
    //   1178: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1181: ifeq -> 1200
    //   1184: aload #23
    //   1186: invokevirtual GJ : ()D
    //   1189: dneg
    //   1190: dstore #5
    //   1192: ldc_w '0'
    //   1195: astore #19
    //   1197: goto -> 1280
    //   1200: aload #23
    //   1202: invokevirtual GL : ()Ljava/util/ArrayList;
    //   1205: invokestatic as : (Ljava/util/ArrayList;)D
    //   1208: dstore #5
    //   1210: aload #23
    //   1212: invokevirtual GE : ()[D
    //   1215: astore #19
    //   1217: aload #23
    //   1219: aload #23
    //   1221: invokevirtual akI : ()D
    //   1224: dload #5
    //   1226: dadd
    //   1227: invokevirtual s : (D)D
    //   1230: aload #23
    //   1232: invokevirtual Gw : ()D
    //   1235: dmul
    //   1236: dload #7
    //   1238: dsub
    //   1239: aload #19
    //   1241: iconst_0
    //   1242: daload
    //   1243: dconst_1
    //   1244: dadd
    //   1245: dconst_0
    //   1246: dadd
    //   1247: dmul
    //   1248: dstore #5
    //   1250: aload #23
    //   1252: invokevirtual akI : ()D
    //   1255: aload #23
    //   1257: invokevirtual Gz : ()D
    //   1260: dsub
    //   1261: invokestatic bc : (D)Z
    //   1264: ifeq -> 1275
    //   1267: ldc_w '0'
    //   1270: astore #19
    //   1272: goto -> 1280
    //   1275: ldc_w '1'
    //   1278: astore #19
    //   1280: aload #21
    //   1282: aload #21
    //   1284: getfield bco : D
    //   1287: dload #5
    //   1289: dadd
    //   1290: putfield bco : D
    //   1293: new java/lang/StringBuilder
    //   1296: dup
    //   1297: invokespecial <init> : ()V
    //   1300: astore #25
    //   1302: aload #25
    //   1304: dload #5
    //   1306: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1309: pop
    //   1310: aload #25
    //   1312: ldc ''
    //   1314: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: aload #24
    //   1320: ldc_w 'fSpareField3'
    //   1323: aload #25
    //   1325: invokevirtual toString : ()Ljava/lang/String;
    //   1328: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1331: pop
    //   1332: aload #24
    //   1334: ldc_w 'nSpareField4'
    //   1337: aload #19
    //   1339: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1342: pop
    //   1343: aload #24
    //   1345: ldc_w 'nProductUnit'
    //   1348: ldc_w '400001'
    //   1351: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1354: pop
    //   1355: aload #23
    //   1357: getfield aTS : I
    //   1360: ifle -> 1408
    //   1363: new java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial <init> : ()V
    //   1370: astore #19
    //   1372: aload #19
    //   1374: aload #23
    //   1376: getfield aTS : I
    //   1379: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1382: pop
    //   1383: aload #19
    //   1385: ldc ''
    //   1387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload #24
    //   1393: ldc_w 'sItemNo'
    //   1396: aload #19
    //   1398: invokevirtual toString : ()Ljava/lang/String;
    //   1401: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1404: pop
    //   1405: goto -> 1452
    //   1408: new java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial <init> : ()V
    //   1415: astore #19
    //   1417: aload #19
    //   1419: iload #10
    //   1421: iconst_1
    //   1422: iadd
    //   1423: bipush #10
    //   1425: imul
    //   1426: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: aload #19
    //   1432: ldc ''
    //   1434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload #24
    //   1440: ldc_w 'sItemNo'
    //   1443: aload #19
    //   1445: invokevirtual toString : ()Ljava/lang/String;
    //   1448: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1451: pop
    //   1452: new java/lang/StringBuilder
    //   1455: dup
    //   1456: invokespecial <init> : ()V
    //   1459: astore #19
    //   1461: aload #19
    //   1463: aload_1
    //   1464: invokevirtual Lx : ()J
    //   1467: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1470: pop
    //   1471: aload #19
    //   1473: ldc ''
    //   1475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: pop
    //   1479: aload #24
    //   1481: ldc_w '_id'
    //   1484: aload #19
    //   1486: invokevirtual toString : ()Ljava/lang/String;
    //   1489: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1492: pop
    //   1493: aload #23
    //   1495: invokevirtual Gw : ()D
    //   1498: dconst_0
    //   1499: dcmpg
    //   1500: ifge -> 1522
    //   1503: aload #18
    //   1505: ldc_w '100001'
    //   1508: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1511: ifeq -> 1522
    //   1514: ldc_w '100066'
    //   1517: astore #19
    //   1519: goto -> 1526
    //   1522: aload #18
    //   1524: astore #19
    //   1526: aload #24
    //   1528: ldc_w 'nProductTransacType'
    //   1531: aload #19
    //   1533: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1536: pop
    //   1537: new java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial <init> : ()V
    //   1544: astore #19
    //   1546: aload #19
    //   1548: aload #23
    //   1550: invokevirtual akM : ()I
    //   1553: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload #19
    //   1559: ldc ''
    //   1561: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: pop
    //   1565: aload #24
    //   1567: ldc_w 'nSpareField3'
    //   1570: aload #19
    //   1572: invokevirtual toString : ()Ljava/lang/String;
    //   1575: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1578: pop
    //   1579: ldc_w '100001'
    //   1582: aload #18
    //   1584: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1587: ifne -> 1607
    //   1590: ldc_w '100015'
    //   1593: aload #18
    //   1595: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1598: ifeq -> 1604
    //   1601: goto -> 1607
    //   1604: goto -> 1629
    //   1607: aload #23
    //   1609: invokevirtual akN : ()Z
    //   1612: ifne -> 1604
    //   1615: aload_2
    //   1616: aload #23
    //   1618: getfield aSW : J
    //   1621: invokevirtual bq : (J)D
    //   1624: dstore #5
    //   1626: goto -> 1632
    //   1629: dconst_0
    //   1630: dstore #5
    //   1632: new java/lang/StringBuilder
    //   1635: dup
    //   1636: invokespecial <init> : ()V
    //   1639: astore #19
    //   1641: aload #19
    //   1643: dload #5
    //   1645: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1648: pop
    //   1649: aload #19
    //   1651: ldc ''
    //   1653: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: pop
    //   1657: aload #24
    //   1659: ldc_w 'nStockQty'
    //   1662: aload #19
    //   1664: invokevirtual toString : ()Ljava/lang/String;
    //   1667: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1670: pop
    //   1671: iload #13
    //   1673: istore #14
    //   1675: iload #13
    //   1677: ifeq -> 1808
    //   1680: iload #13
    //   1682: istore #14
    //   1684: aload #23
    //   1686: invokevirtual Gw : ()D
    //   1689: dconst_0
    //   1690: dcmpl
    //   1691: ifle -> 1808
    //   1694: aload #21
    //   1696: getfield bbW : D
    //   1699: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1702: iconst_1
    //   1703: iconst_0
    //   1704: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   1707: invokestatic aU : (Ljava/lang/Object;)D
    //   1710: dstore #5
    //   1712: new java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial <init> : ()V
    //   1719: astore #19
    //   1721: aload #19
    //   1723: dload #5
    //   1725: aload #21
    //   1727: getfield bbY : D
    //   1730: dsub
    //   1731: aload #21
    //   1733: getfield bca : D
    //   1736: dsub
    //   1737: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1740: pop
    //   1741: aload #19
    //   1743: ldc ''
    //   1745: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: pop
    //   1749: aload #24
    //   1751: ldc_w 'fSpareField2'
    //   1754: aload #19
    //   1756: invokevirtual toString : ()Ljava/lang/String;
    //   1759: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1762: pop
    //   1763: new java/lang/StringBuilder
    //   1766: dup
    //   1767: invokespecial <init> : ()V
    //   1770: astore #19
    //   1772: aload #19
    //   1774: aload #21
    //   1776: getfield bbY : D
    //   1779: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1782: pop
    //   1783: aload #19
    //   1785: ldc ''
    //   1787: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: aload #24
    //   1793: ldc_w 'fReceived'
    //   1796: aload #19
    //   1798: invokevirtual toString : ()Ljava/lang/String;
    //   1801: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1804: pop
    //   1805: iconst_0
    //   1806: istore #14
    //   1808: aload_0
    //   1809: invokevirtual QL : ()Z
    //   1812: ifne -> 1827
    //   1815: aload #24
    //   1817: getfield mContext : Landroid/content/Context;
    //   1820: ldc_w 2131626362
    //   1823: invokevirtual getString : (I)Ljava/lang/String;
    //   1826: areturn
    //   1827: aload #24
    //   1829: ldc_w 'fSpareField2'
    //   1832: ldc_w '0'
    //   1835: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1838: pop
    //   1839: aload #24
    //   1841: ldc_w 'fSpareField3'
    //   1844: ldc_w '0'
    //   1847: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1850: pop
    //   1851: aload #24
    //   1853: ldc_w 'nSpareField4'
    //   1856: ldc_w '0'
    //   1859: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1862: pop
    //   1863: aload #24
    //   1865: ldc_w 'nStockQty'
    //   1868: ldc_w '0'
    //   1871: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1874: pop
    //   1875: aload #24
    //   1877: ldc_w 'fReceived'
    //   1880: ldc_w '0'
    //   1883: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1886: pop
    //   1887: aload #23
    //   1889: invokevirtual akM : ()I
    //   1892: iconst_2
    //   1893: if_icmpeq -> 1953
    //   1896: aload #23
    //   1898: getfield aSW : J
    //   1901: lstore #16
    //   1903: aload #23
    //   1905: invokevirtual Gw : ()D
    //   1908: dconst_0
    //   1909: dcmpg
    //   1910: ifge -> 1919
    //   1913: dconst_0
    //   1914: dstore #5
    //   1916: goto -> 1929
    //   1919: aload #23
    //   1921: invokevirtual Gw : ()D
    //   1924: dstore #5
    //   1926: goto -> 1916
    //   1929: aload #24
    //   1931: aload_2
    //   1932: lload #16
    //   1934: dload #5
    //   1936: iload #9
    //   1938: i2d
    //   1939: dmul
    //   1940: invokespecial a : (Lcom/laiqian/models/ab;JD)Ljava/lang/String;
    //   1943: astore #19
    //   1945: aload #19
    //   1947: ifnull -> 1953
    //   1950: aload #19
    //   1952: areturn
    //   1953: iload #9
    //   1955: istore #13
    //   1957: iconst_0
    //   1958: istore #9
    //   1960: iload #9
    //   1962: aload #23
    //   1964: invokevirtual GL : ()Ljava/util/ArrayList;
    //   1967: invokevirtual size : ()I
    //   1970: if_icmpge -> 2319
    //   1973: aload #23
    //   1975: invokevirtual GL : ()Ljava/util/ArrayList;
    //   1978: iload #9
    //   1980: invokevirtual get : (I)Ljava/lang/Object;
    //   1983: checkcast com/laiqian/product/models/c
    //   1986: astore #19
    //   1988: aload #24
    //   1990: ldc_w 'nProductTransacType'
    //   1993: ldc_w '100044'
    //   1996: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1999: pop
    //   2000: aload #23
    //   2002: invokevirtual Gw : ()D
    //   2005: dstore #5
    //   2007: new java/lang/StringBuilder
    //   2010: dup
    //   2011: invokespecial <init> : ()V
    //   2014: astore #25
    //   2016: aload #25
    //   2018: aload_1
    //   2019: invokevirtual Lx : ()J
    //   2022: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2025: pop
    //   2026: aload #25
    //   2028: ldc ''
    //   2030: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: pop
    //   2034: aload #24
    //   2036: ldc_w '_id'
    //   2039: aload #25
    //   2041: invokevirtual toString : ()Ljava/lang/String;
    //   2044: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2047: pop
    //   2048: new java/lang/StringBuilder
    //   2051: dup
    //   2052: invokespecial <init> : ()V
    //   2055: astore #25
    //   2057: aload #25
    //   2059: aload #19
    //   2061: getfield id : J
    //   2064: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2067: pop
    //   2068: aload #25
    //   2070: ldc ''
    //   2072: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload #24
    //   2078: ldc_w 'nProductID'
    //   2081: aload #25
    //   2083: invokevirtual toString : ()Ljava/lang/String;
    //   2086: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2089: pop
    //   2090: aload #24
    //   2092: ldc_w 'sProductName'
    //   2095: aload #19
    //   2097: getfield name : Ljava/lang/String;
    //   2100: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2103: pop
    //   2104: new java/lang/StringBuilder
    //   2107: dup
    //   2108: invokespecial <init> : ()V
    //   2111: astore #25
    //   2113: aload #25
    //   2115: aload #19
    //   2117: getfield qty : I
    //   2120: i2d
    //   2121: dload #5
    //   2123: dmul
    //   2124: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2127: pop
    //   2128: aload #25
    //   2130: ldc ''
    //   2132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: pop
    //   2136: aload #24
    //   2138: ldc_w 'nProductQty'
    //   2141: aload #25
    //   2143: invokevirtual toString : ()Ljava/lang/String;
    //   2146: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2149: pop
    //   2150: new java/lang/StringBuilder
    //   2153: dup
    //   2154: invokespecial <init> : ()V
    //   2157: astore #25
    //   2159: aload #25
    //   2161: aload #19
    //   2163: dload_3
    //   2164: invokevirtual aI : (D)D
    //   2167: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2170: pop
    //   2171: aload #25
    //   2173: ldc ''
    //   2175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: pop
    //   2179: aload #24
    //   2181: ldc_w 'fPrice'
    //   2184: aload #25
    //   2186: invokevirtual toString : ()Ljava/lang/String;
    //   2189: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2192: pop
    //   2193: new java/lang/StringBuilder
    //   2196: dup
    //   2197: invokespecial <init> : ()V
    //   2200: astore #25
    //   2202: aload #25
    //   2204: aload #19
    //   2206: dload_3
    //   2207: invokevirtual aJ : (D)D
    //   2210: dload #5
    //   2212: dmul
    //   2213: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2216: pop
    //   2217: aload #25
    //   2219: ldc ''
    //   2221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: pop
    //   2225: aload #24
    //   2227: ldc_w 'fAmount'
    //   2230: aload #25
    //   2232: invokevirtual toString : ()Ljava/lang/String;
    //   2235: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2238: pop
    //   2239: new java/lang/StringBuilder
    //   2242: dup
    //   2243: invokespecial <init> : ()V
    //   2246: astore #25
    //   2248: aload #25
    //   2250: aload #19
    //   2252: getfield value : D
    //   2255: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2258: pop
    //   2259: aload #25
    //   2261: ldc ''
    //   2263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: pop
    //   2267: aload #24
    //   2269: ldc_w 'fSpareField1'
    //   2272: aload #25
    //   2274: invokevirtual toString : ()Ljava/lang/String;
    //   2277: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2280: pop
    //   2281: aload #24
    //   2283: ldc_w 'nProductUnit'
    //   2286: aconst_null
    //   2287: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2290: pop
    //   2291: aload_0
    //   2292: invokevirtual QL : ()Z
    //   2295: ifne -> 2310
    //   2298: aload #24
    //   2300: getfield mContext : Landroid/content/Context;
    //   2303: ldc_w 2131626352
    //   2306: invokevirtual getString : (I)Ljava/lang/String;
    //   2309: areturn
    //   2310: iload #9
    //   2312: iconst_1
    //   2313: iadd
    //   2314: istore #9
    //   2316: goto -> 1960
    //   2319: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2322: invokevirtual BO : ()Z
    //   2325: ifeq -> 2439
    //   2328: ldc_w '100001'
    //   2331: aload #18
    //   2333: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2336: ifeq -> 2345
    //   2339: iconst_1
    //   2340: istore #9
    //   2342: goto -> 2365
    //   2345: ldc_w '100015'
    //   2348: aload #18
    //   2350: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2353: ifeq -> 2362
    //   2356: iconst_m1
    //   2357: istore #9
    //   2359: goto -> 2365
    //   2362: iconst_0
    //   2363: istore #9
    //   2365: iload #9
    //   2367: ifeq -> 2439
    //   2370: aload_2
    //   2371: aload #23
    //   2373: getfield aSW : J
    //   2376: invokevirtual cP : (J)Ljava/util/ArrayList;
    //   2379: astore #18
    //   2381: aload #24
    //   2383: aload #18
    //   2385: aload #23
    //   2387: invokevirtual Gw : ()D
    //   2390: iload #9
    //   2392: i2d
    //   2393: dmul
    //   2394: ldc_w 100051
    //   2397: aload #21
    //   2399: invokevirtual a : (Ljava/util/ArrayList;DILcom/laiqian/main/bb;)Ljava/lang/String;
    //   2402: astore #19
    //   2404: aload #19
    //   2406: ifnull -> 2412
    //   2409: aload #19
    //   2411: areturn
    //   2412: iload #12
    //   2414: istore #15
    //   2416: aload #18
    //   2418: ifnull -> 2443
    //   2421: iload #12
    //   2423: istore #15
    //   2425: aload #18
    //   2427: invokevirtual size : ()I
    //   2430: ifle -> 2443
    //   2433: iconst_1
    //   2434: istore #15
    //   2436: goto -> 2443
    //   2439: iload #12
    //   2441: istore #15
    //   2443: iload #10
    //   2445: iconst_1
    //   2446: iadd
    //   2447: istore #10
    //   2449: aload_2
    //   2450: astore #18
    //   2452: dconst_0
    //   2453: dstore_3
    //   2454: iload #13
    //   2456: istore #9
    //   2458: aload #21
    //   2460: astore #19
    //   2462: iload #15
    //   2464: istore #12
    //   2466: iload #14
    //   2468: istore #13
    //   2470: goto -> 197
    //   2473: iload #12
    //   2475: ifeq -> 2486
    //   2478: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2481: aload #18
    //   2483: invokevirtual a : (Lcom/laiqian/models/ab;)V
    //   2486: aload_1
    //   2487: invokevirtual Lz : ()Ljava/util/HashMap;
    //   2490: ifnull -> 2957
    //   2493: aload_1
    //   2494: invokevirtual Lz : ()Ljava/util/HashMap;
    //   2497: invokevirtual values : ()Ljava/util/Collection;
    //   2500: invokeinterface iterator : ()Ljava/util/Iterator;
    //   2505: astore_2
    //   2506: iconst_0
    //   2507: istore #9
    //   2509: aload_2
    //   2510: invokeinterface hasNext : ()Z
    //   2515: ifeq -> 2945
    //   2518: aload_2
    //   2519: invokeinterface next : ()Ljava/lang/Object;
    //   2524: checkcast com/laiqian/product/models/p
    //   2527: astore #18
    //   2529: new java/lang/StringBuilder
    //   2532: dup
    //   2533: invokespecial <init> : ()V
    //   2536: astore #20
    //   2538: aload #20
    //   2540: aload #18
    //   2542: invokevirtual alf : ()J
    //   2545: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2548: pop
    //   2549: aload #20
    //   2551: ldc ''
    //   2553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: pop
    //   2557: aload #24
    //   2559: ldc_w 'nProductID'
    //   2562: aload #20
    //   2564: invokevirtual toString : ()Ljava/lang/String;
    //   2567: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2570: pop
    //   2571: new java/lang/StringBuilder
    //   2574: dup
    //   2575: invokespecial <init> : ()V
    //   2578: astore #20
    //   2580: aload #20
    //   2582: aload #18
    //   2584: invokevirtual IT : ()Ljava/lang/String;
    //   2587: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2590: pop
    //   2591: aload #20
    //   2593: ldc_w '='
    //   2596: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2599: pop
    //   2600: aload #20
    //   2602: aload #18
    //   2604: invokevirtual alg : ()D
    //   2607: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2610: pop
    //   2611: aload #20
    //   2613: ldc_w '%'
    //   2616: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2619: pop
    //   2620: aload #24
    //   2622: ldc_w 'sProductName'
    //   2625: aload #20
    //   2627: invokevirtual toString : ()Ljava/lang/String;
    //   2630: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2633: pop
    //   2634: aload #24
    //   2636: ldc_w 'nProductQty'
    //   2639: ldc_w '1'
    //   2642: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2645: pop
    //   2646: aload #24
    //   2648: ldc_w 'fDiscount'
    //   2651: ldc_w '100'
    //   2654: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2657: pop
    //   2658: new java/lang/StringBuilder
    //   2661: dup
    //   2662: invokespecial <init> : ()V
    //   2665: astore #20
    //   2667: aload #20
    //   2669: aload #18
    //   2671: invokevirtual alh : ()D
    //   2674: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2677: pop
    //   2678: aload #20
    //   2680: ldc ''
    //   2682: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2685: pop
    //   2686: aload #24
    //   2688: ldc_w 'fPrice'
    //   2691: aload #20
    //   2693: invokevirtual toString : ()Ljava/lang/String;
    //   2696: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2699: pop
    //   2700: aload #24
    //   2702: ldc_w 'fAmount'
    //   2705: aload #18
    //   2707: invokevirtual alh : ()D
    //   2710: invokestatic ba : (D)Ljava/lang/String;
    //   2713: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2716: pop
    //   2717: new java/lang/StringBuilder
    //   2720: dup
    //   2721: invokespecial <init> : ()V
    //   2724: astore #20
    //   2726: aload #20
    //   2728: aload #18
    //   2730: invokevirtual alj : ()D
    //   2733: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2736: pop
    //   2737: aload #20
    //   2739: ldc ''
    //   2741: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: pop
    //   2745: aload #24
    //   2747: ldc_w 'fSpareField1'
    //   2750: aload #20
    //   2752: invokevirtual toString : ()Ljava/lang/String;
    //   2755: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2758: pop
    //   2759: new java/lang/StringBuilder
    //   2762: dup
    //   2763: invokespecial <init> : ()V
    //   2766: astore #20
    //   2768: aload #20
    //   2770: aload #18
    //   2772: invokevirtual ali : ()D
    //   2775: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2778: pop
    //   2779: aload #20
    //   2781: ldc ''
    //   2783: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: pop
    //   2787: aload #24
    //   2789: ldc_w 'fSpareField4'
    //   2792: aload #20
    //   2794: invokevirtual toString : ()Ljava/lang/String;
    //   2797: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2800: pop
    //   2801: aload #24
    //   2803: ldc_w 'nProductUnit'
    //   2806: ldc_w '400001'
    //   2809: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2812: pop
    //   2813: new java/lang/StringBuilder
    //   2816: dup
    //   2817: invokespecial <init> : ()V
    //   2820: astore #18
    //   2822: iload #9
    //   2824: iconst_1
    //   2825: iadd
    //   2826: istore #9
    //   2828: aload #18
    //   2830: iload #9
    //   2832: bipush #10
    //   2834: imul
    //   2835: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2838: pop
    //   2839: aload #18
    //   2841: ldc ''
    //   2843: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2846: pop
    //   2847: aload #24
    //   2849: ldc_w 'sItemNo'
    //   2852: aload #18
    //   2854: invokevirtual toString : ()Ljava/lang/String;
    //   2857: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2860: pop
    //   2861: new java/lang/StringBuilder
    //   2864: dup
    //   2865: invokespecial <init> : ()V
    //   2868: astore #18
    //   2870: aload #18
    //   2872: aload_1
    //   2873: invokevirtual Lx : ()J
    //   2876: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2879: pop
    //   2880: aload #18
    //   2882: ldc ''
    //   2884: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2887: pop
    //   2888: aload #24
    //   2890: ldc_w '_id'
    //   2893: aload #18
    //   2895: invokevirtual toString : ()Ljava/lang/String;
    //   2898: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2901: pop
    //   2902: aload #24
    //   2904: ldc_w 'nProductTransacType'
    //   2907: ldc_w '100060'
    //   2910: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2913: pop
    //   2914: aload #24
    //   2916: ldc_w 'nSpareField3'
    //   2919: ldc_w '0'
    //   2922: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2925: pop
    //   2926: aload_0
    //   2927: invokevirtual QL : ()Z
    //   2930: ifne -> 2509
    //   2933: aload #24
    //   2935: getfield mContext : Landroid/content/Context;
    //   2938: ldc_w 2131626364
    //   2941: invokevirtual getString : (I)Ljava/lang/String;
    //   2944: areturn
    //   2945: aload #24
    //   2947: ldc_w 'fSpareField4'
    //   2950: ldc_w '0'
    //   2953: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   2956: pop
    //   2957: aload #19
    //   2959: getfield discountAmount : D
    //   2962: dload_3
    //   2963: dcmpl
    //   2964: ifle -> 3014
    //   2967: aload #24
    //   2969: aload #19
    //   2971: getfield discountMessage : Ljava/lang/String;
    //   2974: aload #19
    //   2976: getfield discountAmount : D
    //   2979: dneg
    //   2980: aload #19
    //   2982: getfield discountAmount : D
    //   2985: dneg
    //   2986: aload_1
    //   2987: invokevirtual Lx : ()J
    //   2990: ldc_w '100045'
    //   2993: iconst_1
    //   2994: iconst_0
    //   2995: iconst_0
    //   2996: invokespecial a : (Ljava/lang/String;DDJLjava/lang/String;ZII)Z
    //   2999: ifne -> 3014
    //   3002: aload #24
    //   3004: getfield mContext : Landroid/content/Context;
    //   3007: ldc_w 2131626357
    //   3010: invokevirtual getString : (I)Ljava/lang/String;
    //   3013: areturn
    //   3014: aload #19
    //   3016: getfield deliverAmount : D
    //   3019: dload_3
    //   3020: dcmpl
    //   3021: ifle -> 3102
    //   3024: new java/lang/StringBuilder
    //   3027: dup
    //   3028: invokespecial <init> : ()V
    //   3031: astore_2
    //   3032: aload_2
    //   3033: aload #24
    //   3035: getfield mContext : Landroid/content/Context;
    //   3038: ldc_w 2131624986
    //   3041: invokevirtual getString : (I)Ljava/lang/String;
    //   3044: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3047: pop
    //   3048: aload_2
    //   3049: aload #19
    //   3051: getfield deliverTaxName : Ljava/lang/String;
    //   3054: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3057: pop
    //   3058: aload #24
    //   3060: aload_2
    //   3061: invokevirtual toString : ()Ljava/lang/String;
    //   3064: aload #19
    //   3066: getfield deliverBaseAmount : D
    //   3069: aload #19
    //   3071: getfield deliverAmount : D
    //   3074: aload_1
    //   3075: invokevirtual Lx : ()J
    //   3078: ldc_w '100045'
    //   3081: iconst_1
    //   3082: iconst_1
    //   3083: iconst_0
    //   3084: invokespecial a : (Ljava/lang/String;DDJLjava/lang/String;ZII)Z
    //   3087: ifne -> 3102
    //   3090: aload #24
    //   3092: getfield mContext : Landroid/content/Context;
    //   3095: ldc_w 2131626356
    //   3098: invokevirtual getString : (I)Ljava/lang/String;
    //   3101: areturn
    //   3102: aload #19
    //   3104: getfield dishwareAmount : D
    //   3107: dload_3
    //   3108: dcmpl
    //   3109: ifle -> 3190
    //   3112: new java/lang/StringBuilder
    //   3115: dup
    //   3116: invokespecial <init> : ()V
    //   3119: astore_2
    //   3120: aload_2
    //   3121: aload #24
    //   3123: getfield mContext : Landroid/content/Context;
    //   3126: ldc_w 2131630540
    //   3129: invokevirtual getString : (I)Ljava/lang/String;
    //   3132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3135: pop
    //   3136: aload_2
    //   3137: aload #19
    //   3139: getfield dishwareTaxName : Ljava/lang/String;
    //   3142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: pop
    //   3146: aload #24
    //   3148: aload_2
    //   3149: invokevirtual toString : ()Ljava/lang/String;
    //   3152: aload #19
    //   3154: getfield dishwareBaseAmount : D
    //   3157: aload #19
    //   3159: getfield dishwareAmount : D
    //   3162: aload_1
    //   3163: invokevirtual Lx : ()J
    //   3166: ldc_w '100045'
    //   3169: iconst_1
    //   3170: iconst_0
    //   3171: iconst_0
    //   3172: invokespecial a : (Ljava/lang/String;DDJLjava/lang/String;ZII)Z
    //   3175: ifne -> 3190
    //   3178: aload #24
    //   3180: getfield mContext : Landroid/content/Context;
    //   3183: ldc_w 2131626358
    //   3186: invokevirtual getString : (I)Ljava/lang/String;
    //   3189: areturn
    //   3190: aload_1
    //   3191: invokevirtual GK : ()D
    //   3194: dload_3
    //   3195: dcmpl
    //   3196: ifle -> 3274
    //   3199: new java/lang/StringBuilder
    //   3202: dup
    //   3203: invokespecial <init> : ()V
    //   3206: astore_2
    //   3207: aload_2
    //   3208: aload #24
    //   3210: getfield mContext : Landroid/content/Context;
    //   3213: ldc_w 2131627603
    //   3216: invokevirtual getString : (I)Ljava/lang/String;
    //   3219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3222: pop
    //   3223: aload_2
    //   3224: aload_1
    //   3225: invokevirtual BY : ()Ljava/lang/String;
    //   3228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3231: pop
    //   3232: aload #24
    //   3234: aload_2
    //   3235: invokevirtual toString : ()Ljava/lang/String;
    //   3238: aload_1
    //   3239: invokevirtual GK : ()D
    //   3242: aload_1
    //   3243: invokevirtual GK : ()D
    //   3246: aload_1
    //   3247: invokevirtual Lx : ()J
    //   3250: ldc_w '100068'
    //   3253: iconst_0
    //   3254: iconst_0
    //   3255: iconst_0
    //   3256: invokespecial a : (Ljava/lang/String;DDJLjava/lang/String;ZII)Z
    //   3259: ifne -> 3274
    //   3262: aload #24
    //   3264: getfield mContext : Landroid/content/Context;
    //   3267: ldc_w 2131626363
    //   3270: invokevirtual getString : (I)Ljava/lang/String;
    //   3273: areturn
    //   3274: aload_1
    //   3275: invokevirtual getNeglectSmallChanges : ()D
    //   3278: dload_3
    //   3279: dcmpl
    //   3280: ifeq -> 3333
    //   3283: aload #24
    //   3285: aload #24
    //   3287: getfield mContext : Landroid/content/Context;
    //   3290: ldc_w 2131625864
    //   3293: invokevirtual getString : (I)Ljava/lang/String;
    //   3296: aload_1
    //   3297: invokevirtual getNeglectSmallChanges : ()D
    //   3300: aload_1
    //   3301: invokevirtual getNeglectSmallChanges : ()D
    //   3304: aload_1
    //   3305: invokevirtual Lx : ()J
    //   3308: ldc_w '100045'
    //   3311: iconst_1
    //   3312: iconst_0
    //   3313: bipush #7
    //   3315: invokespecial a : (Ljava/lang/String;DDJLjava/lang/String;ZII)Z
    //   3318: ifne -> 3333
    //   3321: aload #24
    //   3323: getfield mContext : Landroid/content/Context;
    //   3326: ldc_w 2131625160
    //   3329: invokevirtual getString : (I)Ljava/lang/String;
    //   3332: areturn
    //   3333: aconst_null
    //   3334: areturn }
  
  private String a(ab paramab, long paramLong, double paramDouble) { return !paramab.c(paramLong, paramDouble) ? this.mContext.getString(2131626361) : null; }
  
  public static String a(boolean paramBoolean, Date paramDate) { return n.a(paramBoolean, paramDate); }
  
  private boolean a(String paramString1, double paramDouble1, double paramDouble2, long paramLong, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    am("nProductID", stringBuilder2.toString());
    am("sProductName", paramString1);
    am("nProductQty", "1");
    am("fDiscount", "100");
    am("fPrice", n.ba(paramDouble1));
    am("fAmount", n.ba(paramDouble1));
    am("fSpareField1", n.ba(paramDouble2));
    am("fSpareField3", n.ba(0.0D));
    if (!paramBoolean)
      am("fSpareField4", n.ba(paramDouble2)); 
    am("nProductUnit", "400001");
    am("sItemNo", "0");
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong);
    stringBuilder1.append("");
    am("_id", stringBuilder1.toString());
    am("nProductTransacType", paramString2);
    am("nSpareField3", "0");
    if (paramBoolean) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt1);
      stringBuilder1.append("");
      am("fSpareField4", stringBuilder1.toString());
    } 
    return !!QL();
  }
  
  public static h eQ(String paramString) {
    OnlineSyncRequest.a a = new OnlineSyncRequest.a();
    null = new x(CrashApplication.zv());
    ArrayList arrayList = null.gV(paramString);
    long l = null.hF(paramString);
    a.a(arrayList, 1);
    a.a((new d(CrashApplication.zv())).gV(paramString), 1);
    a.a((new j(CrashApplication.zv())).gV(paramString), 1);
    null = new av(CrashApplication.zv());
    a.iM(null.Ea());
    a.iN(null.atr());
    a.bV(Long.parseLong(null.Tx()));
    null.close();
    f f = f.bXQ;
    try {
      null = a.Xj();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("结算后同步");
      stringBuilder2.append(null.IX());
      b.ct(stringBuilder2.toString());
      h h = f.b(null);
      if (h.bXV) {
        d.b("结算后--实时同步成功(如果是空数据也可能成功）", new Object[0]);
        x x = new x(RootApplication.zv());
        x.h(l, paramString);
        x.close();
        d d = new d(RootApplication.zv());
        d.h(l, paramString);
        d.close();
        j j = new j(RootApplication.zv());
        j.h(l, paramString);
        j.close();
        return h;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("实时同步失败");
      stringBuilder1.append(h.message);
      d.b(stringBuilder1.toString(), new Object[0]);
      return h;
    } catch (Exception paramString) {
      h.a(new d(PosActivitySettlementModel.class.getSimpleName(), "onlineSync", "请求实时同步失败--", paramString.getMessage()), h.a.dHw, h.b.dHD);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("请求实时同步失败");
      stringBuilder.append(paramString.getMessage());
      d.b(stringBuilder.toString(), new Object[0]);
      a.e(paramString);
      return null;
    } 
  }
  
  private boolean g(bb parambb) {
    for (z z : parambb.bbS) {
      if (z.aTv == 10007 || z.aTv == 10009)
        return true; 
    } 
    return false;
  }
  
  private void h(bb parambb) {
    String str3 = parambb.headerText;
    String str2 = parambb.bbQ;
    am("sOrderNo", parambb.orderNo);
    if (parambb.isSaleOrder) {
      str = "300002";
    } else {
      str = "300001";
    } 
    am("nStcokDirection", str);
    try {
      str = (new JSONObject(parambb.bch)).getString("settlementID");
      if (!TextUtils.isEmpty(str))
        am("nUserID", str); 
    } catch (JSONException|NullPointerException str) {
      a.e(str);
    } 
    if (!by.isNull(str3))
      am("sHeaderText", str3); 
    if (str2 != null)
      if (parambb.bcf == 7L || parambb.bcf == 14L) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(parambb.bbR);
        stringBuilder1.append("");
        am("nSpareField5", stringBuilder1.toString());
        am("sSpareField3", parambb.openTableName);
      } else {
        am("nPhysicalInventoryID", str2);
        am("sSpareField5", str2);
      }  
    if (parambb.bcf == 5L)
      am("sSpareField4", parambb.bci); 
    if (parambb.bcf == 1L) {
      am("nPhysicalInventoryID", str2);
      am("sRefNo", parambb.sRefNo);
    } 
    String str1 = new StringBuilder();
    str1.append(parambb.Ly());
    str1.append("");
    am("nDateTime", str1.toString());
    str1 = new StringBuilder();
    str1.append(VC());
    str1.append("");
    am("nWarehouseID", str1.toString());
    if (parambb.vipEntity == null) {
      str1 = new StringBuilder();
      str1.append(parambb.bcg);
      str1.append("");
      String str = str1.toString();
      str2 = "";
      str3 = "";
    } else {
      str1 = new StringBuilder();
      str1.append(parambb.vipEntity.aSW);
      str1.append("");
      str1 = str1.toString();
      str2 = parambb.vipEntity.name;
      str3 = parambb.vipEntity.aTp;
    } 
    am("nBPartnerID", str1);
    am("sBPartnerContact", str2);
    am("sBPartnerMobile", str3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parambb.bch);
    stringBuilder.append("");
    am("sSpareField2", stringBuilder.toString());
    if (parambb.billNumber == null)
      parambb.billNumber = m.II(); 
    int i = a.AZ().Be();
    parambb.numDecimal = i;
    am("sSpareField1", parambb.billNumber);
    am("fSpareField5", String.valueOf(i));
  }
  
  private int i(bb parambb) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parambb.bcp);
    stringBuilder.append("");
    Log.e("getVipConsumeCounts", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    if (parambb.bce > 0.0D) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    stringBuilder.append("");
    Log.e("getVipConsumeCounts", stringBuilder.toString());
    if (parambb.bce > 0.0D) {
      switch (parambb.bcp) {
        default:
          return -1;
        case 3:
          return 0;
        case 2:
          return 0;
        case 1:
          break;
      } 
      return -1;
    } 
    return 1;
  }
  
  public String f(bb parambb) { // Byte code:
    //   0: aload_1
    //   1: getfield bbT : Ljava/util/ArrayList;
    //   4: invokevirtual isEmpty : ()Z
    //   7: ifeq -> 21
    //   10: aload_0
    //   11: getfield mContext : Landroid/content/Context;
    //   14: ldc_w 2131629455
    //   17: invokevirtual getString : (I)Ljava/lang/String;
    //   20: areturn
    //   21: aload_1
    //   22: invokevirtual Lc : ()V
    //   25: aload_1
    //   26: invokevirtual Ly : ()J
    //   29: lstore #4
    //   31: aload_1
    //   32: getfield orderNo : Ljava/lang/String;
    //   35: ifnonnull -> 60
    //   38: aload_1
    //   39: aload_1
    //   40: getfield isSaleOrder : Z
    //   43: new java/util/Date
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual Ly : ()J
    //   51: invokespecial <init> : (J)V
    //   54: invokestatic a : (ZLjava/util/Date;)Ljava/lang/String;
    //   57: putfield orderNo : Ljava/lang/String;
    //   60: new com/laiqian/product/models/g
    //   63: dup
    //   64: aload_0
    //   65: getfield mContext : Landroid/content/Context;
    //   68: invokespecial <init> : (Landroid/content/Context;)V
    //   71: astore #13
    //   73: new com/laiqian/models/b
    //   76: dup
    //   77: aload_0
    //   78: getfield mContext : Landroid/content/Context;
    //   81: invokespecial <init> : (Landroid/content/Context;)V
    //   84: astore #14
    //   86: new com/laiqian/models/bd
    //   89: dup
    //   90: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   93: invokespecial <init> : (Landroid/content/Context;)V
    //   96: astore #15
    //   98: aload_1
    //   99: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   102: ifnull -> 121
    //   105: new com/laiqian/models/j
    //   108: dup
    //   109: aload_0
    //   110: getfield mContext : Landroid/content/Context;
    //   113: invokespecial <init> : (Landroid/content/Context;)V
    //   116: astore #11
    //   118: goto -> 124
    //   121: aconst_null
    //   122: astore #11
    //   124: aload_0
    //   125: aload_1
    //   126: invokespecial g : (Lcom/laiqian/main/bb;)Z
    //   129: istore #10
    //   131: iload #10
    //   133: ifeq -> 192
    //   136: aload_1
    //   137: getfield orderNo : Ljava/lang/String;
    //   140: astore #12
    //   142: aload_1
    //   143: invokevirtual Ly : ()J
    //   146: lstore #6
    //   148: invokestatic currentTimeMillis : ()J
    //   151: lstore #8
    //   153: aload_1
    //   154: aload #15
    //   156: aload #12
    //   158: lload #6
    //   160: ldc2_w 86400000
    //   163: lsub
    //   164: lload #8
    //   166: iconst_1
    //   167: invokevirtual a : (Ljava/lang/String;JJI)Ljava/lang/String;
    //   170: putfield bcu : Ljava/lang/String;
    //   173: goto -> 192
    //   176: astore_1
    //   177: goto -> 185
    //   180: astore_1
    //   181: goto -> 189
    //   184: astore_1
    //   185: goto -> 751
    //   188: astore_1
    //   189: goto -> 634
    //   192: aload #11
    //   194: astore #12
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial h : (Lcom/laiqian/main/bb;)V
    //   201: aload_0
    //   202: aload_1
    //   203: aload #13
    //   205: invokespecial a : (Lcom/laiqian/main/bb;Lcom/laiqian/product/models/g;)Ljava/lang/String;
    //   208: astore #16
    //   210: aload #16
    //   212: ifnull -> 281
    //   215: aload #13
    //   217: invokevirtual close : ()V
    //   220: aload #14
    //   222: invokevirtual close : ()V
    //   225: aload #15
    //   227: invokevirtual close : ()V
    //   230: aload #12
    //   232: ifnull -> 240
    //   235: aload #12
    //   237: invokevirtual close : ()V
    //   240: invokestatic currentTimeMillis : ()J
    //   243: lstore #6
    //   245: new java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial <init> : ()V
    //   252: astore_1
    //   253: aload_1
    //   254: ldc_w '结算处理，一共耗时：'
    //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_1
    //   262: lload #6
    //   264: lload #4
    //   266: lsub
    //   267: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_1
    //   272: invokevirtual toString : ()Ljava/lang/String;
    //   275: invokestatic println : (Ljava/lang/Object;)V
    //   278: aload #16
    //   280: areturn
    //   281: aload_0
    //   282: aload_1
    //   283: aload #14
    //   285: aload #12
    //   287: invokespecial a : (Lcom/laiqian/main/bb;Lcom/laiqian/models/b;Lcom/laiqian/models/j;)Ljava/lang/String;
    //   290: astore #16
    //   292: aload #16
    //   294: ifnull -> 363
    //   297: aload #13
    //   299: invokevirtual close : ()V
    //   302: aload #14
    //   304: invokevirtual close : ()V
    //   307: aload #15
    //   309: invokevirtual close : ()V
    //   312: aload #12
    //   314: ifnull -> 322
    //   317: aload #12
    //   319: invokevirtual close : ()V
    //   322: invokestatic currentTimeMillis : ()J
    //   325: lstore #6
    //   327: new java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial <init> : ()V
    //   334: astore_1
    //   335: aload_1
    //   336: ldc_w '结算处理，一共耗时：'
    //   339: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_1
    //   344: lload #6
    //   346: lload #4
    //   348: lsub
    //   349: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_1
    //   354: invokevirtual toString : ()Ljava/lang/String;
    //   357: invokestatic println : (Ljava/lang/Object;)V
    //   360: aload #16
    //   362: areturn
    //   363: aload_1
    //   364: getfield bbV : Z
    //   367: istore #10
    //   369: iload #10
    //   371: ifeq -> 454
    //   374: aload_0
    //   375: aload_1
    //   376: aload #12
    //   378: invokespecial a : (Lcom/laiqian/main/bb;Lcom/laiqian/models/j;)Ljava/lang/String;
    //   381: astore #16
    //   383: aload #16
    //   385: ifnull -> 454
    //   388: aload #13
    //   390: invokevirtual close : ()V
    //   393: aload #14
    //   395: invokevirtual close : ()V
    //   398: aload #15
    //   400: invokevirtual close : ()V
    //   403: aload #12
    //   405: ifnull -> 413
    //   408: aload #12
    //   410: invokevirtual close : ()V
    //   413: invokestatic currentTimeMillis : ()J
    //   416: lstore #6
    //   418: new java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial <init> : ()V
    //   425: astore_1
    //   426: aload_1
    //   427: ldc_w '结算处理，一共耗时：'
    //   430: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload_1
    //   435: lload #6
    //   437: lload #4
    //   439: lsub
    //   440: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_1
    //   445: invokevirtual toString : ()Ljava/lang/String;
    //   448: invokestatic println : (Ljava/lang/Object;)V
    //   451: aload #16
    //   453: areturn
    //   454: aload_0
    //   455: aload_1
    //   456: invokespecial g : (Lcom/laiqian/main/bb;)Z
    //   459: istore #10
    //   461: iload #10
    //   463: ifeq -> 503
    //   466: new com/laiqian/models/be
    //   469: dup
    //   470: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   473: invokespecial <init> : (Landroid/content/Context;)V
    //   476: astore #16
    //   478: aload #16
    //   480: aload_1
    //   481: getfield orderNo : Ljava/lang/String;
    //   484: aload_1
    //   485: invokevirtual Ly : ()J
    //   488: ldc2_w 86400000
    //   491: lsub
    //   492: invokestatic currentTimeMillis : ()J
    //   495: invokevirtual c : (Ljava/lang/String;JJ)V
    //   498: aload #16
    //   500: invokevirtual close : ()V
    //   503: aload_0
    //   504: getfield mContext : Landroid/content/Context;
    //   507: astore #16
    //   509: aload_1
    //   510: getfield bbT : Ljava/util/ArrayList;
    //   513: astore #17
    //   515: aload_1
    //   516: getfield bbS : Ljava/util/ArrayList;
    //   519: astore #18
    //   521: aload_1
    //   522: getfield isSaleOrder : Z
    //   525: istore #10
    //   527: aload_1
    //   528: getfield bbY : D
    //   531: dstore_2
    //   532: aload #16
    //   534: aload #17
    //   536: aload #18
    //   538: iload #10
    //   540: dload_2
    //   541: aload_1
    //   542: getfield discount : D
    //   545: aload_1
    //   546: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   549: invokestatic a : (Landroid/content/Context;Ljava/util/List;Ljava/util/ArrayList;ZDDLcom/laiqian/entity/aq;)V
    //   552: aload #13
    //   554: invokevirtual close : ()V
    //   557: aload #14
    //   559: invokevirtual close : ()V
    //   562: aload #15
    //   564: invokevirtual close : ()V
    //   567: aload #12
    //   569: ifnull -> 577
    //   572: aload #12
    //   574: invokevirtual close : ()V
    //   577: invokestatic currentTimeMillis : ()J
    //   580: lstore #6
    //   582: new java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial <init> : ()V
    //   589: astore_1
    //   590: aload_1
    //   591: ldc_w '结算处理，一共耗时：'
    //   594: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_1
    //   599: lload #6
    //   601: lload #4
    //   603: lsub
    //   604: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_1
    //   609: invokevirtual toString : ()Ljava/lang/String;
    //   612: invokestatic println : (Ljava/lang/Object;)V
    //   615: aconst_null
    //   616: areturn
    //   617: astore_1
    //   618: goto -> 634
    //   621: astore_1
    //   622: goto -> 630
    //   625: astore_1
    //   626: goto -> 634
    //   629: astore_1
    //   630: goto -> 751
    //   633: astore_1
    //   634: aload #11
    //   636: astore #12
    //   638: aload_1
    //   639: invokestatic e : (Ljava/lang/Throwable;)V
    //   642: new com/laiqian/main/fi
    //   645: dup
    //   646: aload_1
    //   647: new com/laiqian/util/av
    //   650: dup
    //   651: aload_0
    //   652: getfield mContext : Landroid/content/Context;
    //   655: invokespecial <init> : (Landroid/content/Context;)V
    //   658: invokevirtual Ea : ()Ljava/lang/String;
    //   661: invokespecial <init> : (Ljava/lang/Exception;Ljava/lang/String;)V
    //   664: invokevirtual start : ()V
    //   667: aload_0
    //   668: getfield mContext : Landroid/content/Context;
    //   671: ldc_w 2131626359
    //   674: invokevirtual getString : (I)Ljava/lang/String;
    //   677: astore_1
    //   678: aload #13
    //   680: invokevirtual close : ()V
    //   683: aload #14
    //   685: invokevirtual close : ()V
    //   688: aload #15
    //   690: invokevirtual close : ()V
    //   693: aload #12
    //   695: ifnull -> 703
    //   698: aload #12
    //   700: invokevirtual close : ()V
    //   703: invokestatic currentTimeMillis : ()J
    //   706: lstore #6
    //   708: new java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial <init> : ()V
    //   715: astore #11
    //   717: aload #11
    //   719: ldc_w '结算处理，一共耗时：'
    //   722: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload #11
    //   728: lload #6
    //   730: lload #4
    //   732: lsub
    //   733: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload #11
    //   739: invokevirtual toString : ()Ljava/lang/String;
    //   742: invokestatic println : (Ljava/lang/Object;)V
    //   745: aload_1
    //   746: areturn
    //   747: astore_1
    //   748: goto -> 630
    //   751: aload #13
    //   753: invokevirtual close : ()V
    //   756: aload #14
    //   758: invokevirtual close : ()V
    //   761: aload #15
    //   763: invokevirtual close : ()V
    //   766: aload #11
    //   768: ifnull -> 776
    //   771: aload #11
    //   773: invokevirtual close : ()V
    //   776: invokestatic currentTimeMillis : ()J
    //   779: lstore #6
    //   781: new java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial <init> : ()V
    //   788: astore #11
    //   790: aload #11
    //   792: ldc_w '结算处理，一共耗时：'
    //   795: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload #11
    //   801: lload #6
    //   803: lload #4
    //   805: lsub
    //   806: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload #11
    //   812: invokevirtual toString : ()Ljava/lang/String;
    //   815: invokestatic println : (Ljava/lang/Object;)V
    //   818: aload_1
    //   819: athrow
    // Exception table:
    //   from	to	target	type
    //   124	131	633	java/lang/Exception
    //   124	131	629	finally
    //   136	153	188	java/lang/Exception
    //   136	153	184	finally
    //   153	173	180	java/lang/Exception
    //   153	173	176	finally
    //   196	210	625	java/lang/Exception
    //   196	210	621	finally
    //   281	292	625	java/lang/Exception
    //   281	292	621	finally
    //   363	369	625	java/lang/Exception
    //   363	369	621	finally
    //   374	383	180	java/lang/Exception
    //   374	383	176	finally
    //   454	461	625	java/lang/Exception
    //   454	461	621	finally
    //   466	503	180	java/lang/Exception
    //   466	503	176	finally
    //   503	532	625	java/lang/Exception
    //   503	532	621	finally
    //   532	552	617	java/lang/Exception
    //   532	552	747	finally
    //   638	678	747	finally }
  
  public static class SendSmsTask extends AsyncTaskLoader<Boolean> {
    private double bce;
    
    private Context context;
    
    private String orderNo;
    
    private aq vipEntity;
    
    public SendSmsTask(Context param1Context, bb param1bb) {
      super(param1Context);
      this.orderNo = param1bb.orderNo;
      this.vipEntity = param1bb.vipEntity;
      this.context = param1Context;
      this.bce = param1bb.bce;
    }
    
    public Boolean LN() {
      int i;
      i i1 = new i(this.context);
      h h = new h();
      h.bGF = (h.aTt = (h.aTp = this.vipEntity.aTp).valueOf(this.vipEntity.aWo)).valueOf(Math.abs(this.bce));
      if (this.bce < 0.0D) {
        str = "SMS_12310166";
      } else {
        str = "SMS_11925087";
      } 
      h.bGE = str;
      str = i1.a(this.context, h);
      if (str != null) {
        try {
          JSONObject jSONObject = new JSONObject(str);
          i = jSONObject.optInt("nSMSQuantityLeft");
          if (!jSONObject.optBoolean("result"))
            return Boolean.valueOf(false); 
        } catch (JSONException str) {
          a.e(str);
          return Boolean.valueOf(false);
        } 
      } else {
        return Boolean.valueOf(false);
      } 
      if (i == 100 || i == 50 || i == 0) {
        Intent intent = new Intent();
        intent.putExtra("SMS_QUANTITY_LEFT", i);
        intent.setAction("SMS_QUANTITY_LEFT_RECEIVER");
        this.context.sendBroadcast(intent);
      } 
      return Boolean.valueOf(true);
    }
    
    public void g(Boolean param1Boolean) { super.deliverResult(param1Boolean); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\PosActivitySettlementModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */