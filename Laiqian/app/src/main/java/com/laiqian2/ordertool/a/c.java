package com.laiqian.ordertool.a;

import android.content.Context;
import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.dcb.api.b.g;
import com.laiqian.l.a;
import com.laiqian.ordertool.ServerGet;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.hold.ah;
import com.laiqian.pos.hold.e;
import com.laiqian.pos.model.a;
import com.laiqian.pos.model.orders.a;
import com.laiqian.print.c.d;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.product.a.d;
import com.laiqian.product.models.c;
import com.laiqian.product.models.f;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements a {
  private ServerGet cdv;
  
  private Context mContext;
  
  public c(Context paramContext, ServerGet paramServerGet) {
    this.mContext = paramContext;
    this.cdv = paramServerGet;
  }
  
  static double a(Context paramContext, double paramDouble, String paramString) {
    (new d()).a(new d.a()).akm();
    return c.a(paramDouble, p(paramContext, paramString), (new d()).a(new d.a()).akm());
  }
  
  private PendingFullOrderDetail.c a(long paramLong, JSONArray paramJSONArray) {
    PendingFullOrderDetail.c c1 = new PendingFullOrderDetail.c();
    c1.cpi = new Date(System.currentTimeMillis());
    c1.cpg.addAll(c(paramLong, paramJSONArray));
    return c1;
  }
  
  private static void a(Context paramContext, PendingFullOrderDetail paramPendingFullOrderDetail) {
    try {
      double[] arrayOfDouble = ab(paramPendingFullOrderDetail.coy);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(arrayOfDouble[0]);
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(arrayOfDouble[1]);
      stringBuilder2.append("");
      a.j(paramContext, str, stringBuilder2.toString());
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
  
  private static double[] ab(ArrayList<PendingFullOrderDetail.d> paramArrayList) {
    double[] arrayOfDouble = new double[2];
    for (PendingFullOrderDetail.d d : paramArrayList) {
      arrayOfDouble[0] = arrayOfDouble[0] + d.cpn * d.cpo;
      arrayOfDouble[1] = arrayOfDouble[1] + d.cpo;
    } 
    return arrayOfDouble;
  }
  
  private PendingFullOrderDetail b(long paramLong, JSONArray paramJSONArray) {
    PendingFullOrderDetail pendingFullOrderDetail = new PendingFullOrderDetail();
    pendingFullOrderDetail.bXb.coH = Long.valueOf("100001").longValue();
    pendingFullOrderDetail.bXb.coE = new Date(System.currentTimeMillis());
    pendingFullOrderDetail.bXb.coI = 300002L;
    pendingFullOrderDetail.coy.addAll(c(paramLong, paramJSONArray));
    return pendingFullOrderDetail;
  }
  
  private ArrayList<PendingFullOrderDetail.d> c(long paramLong, JSONArray paramJSONArray) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #28
    //   9: new com/laiqian/models/ab
    //   12: dup
    //   13: aload_0
    //   14: getfield mContext : Landroid/content/Context;
    //   17: invokespecial <init> : (Landroid/content/Context;)V
    //   20: astore #25
    //   22: iconst_0
    //   23: istore #10
    //   25: iload #10
    //   27: aload_3
    //   28: invokevirtual length : ()I
    //   31: if_icmpge -> 843
    //   34: aload_3
    //   35: iload #10
    //   37: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   40: astore #24
    //   42: aload #24
    //   44: ldc '_id'
    //   46: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   49: invokestatic parseLong : (Ljava/lang/String;)J
    //   52: lstore #18
    //   54: aload #24
    //   56: ldc 'nBuyNumber'
    //   58: invokevirtual getDouble : (Ljava/lang/String;)D
    //   61: dstore #8
    //   63: aload #24
    //   65: ldc 'fSalePrice'
    //   67: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   70: invokestatic parseDouble : (Ljava/lang/String;)D
    //   73: dstore #6
    //   75: dload #8
    //   77: dconst_0
    //   78: dcmpg
    //   79: ifge -> 851
    //   82: aload #24
    //   84: ldc 'itemNo'
    //   86: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   92: invokevirtual longValue : ()J
    //   95: lstore #12
    //   97: aload #24
    //   99: ldc 'oid'
    //   101: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   104: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   107: invokevirtual longValue : ()J
    //   110: lstore #14
    //   112: aload #24
    //   114: ldc 'dateTime'
    //   116: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   122: invokevirtual longValue : ()J
    //   125: lstore #16
    //   127: aload #24
    //   129: ldc 'isDeleteAll'
    //   131: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   137: invokevirtual booleanValue : ()Z
    //   140: istore #22
    //   142: goto -> 145
    //   145: aload #24
    //   147: ldc 'sTaste'
    //   149: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   152: astore #29
    //   154: aload #24
    //   156: ldc 'nFoodCategory'
    //   158: invokevirtual has : (Ljava/lang/String;)Z
    //   161: ifeq -> 868
    //   164: aload #24
    //   166: ldc 'nFoodCategory'
    //   168: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   171: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   174: astore #24
    //   176: goto -> 179
    //   179: aload #25
    //   181: lload #18
    //   183: invokevirtual bp : (J)Landroid/database/Cursor;
    //   186: astore #30
    //   188: iload #10
    //   190: istore #11
    //   192: new com/laiqian/models/ba
    //   195: dup
    //   196: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   199: invokespecial <init> : (Landroid/content/Context;)V
    //   202: astore #26
    //   204: iload #10
    //   206: istore #11
    //   208: aload #30
    //   210: invokeinterface moveToNext : ()Z
    //   215: ifeq -> 786
    //   218: iload #10
    //   220: istore #11
    //   222: new com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   225: dup
    //   226: invokespecial <init> : ()V
    //   229: astore #31
    //   231: iload #10
    //   233: istore #11
    //   235: aload #31
    //   237: lload #18
    //   239: putfield id : J
    //   242: iload #10
    //   244: istore #11
    //   246: aload #31
    //   248: lload_1
    //   249: invokestatic valueOf : (J)Ljava/lang/Long;
    //   252: putfield cpr : Ljava/lang/Long;
    //   255: aload #31
    //   257: aload #30
    //   259: aload #30
    //   261: ldc_w 'sProductName'
    //   264: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   269: invokeinterface getString : (I)Ljava/lang/String;
    //   274: putfield name : Ljava/lang/String;
    //   277: aload #31
    //   279: aload #30
    //   281: aload #30
    //   283: ldc_w 'sSpareField5'
    //   286: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   291: invokeinterface getString : (I)Ljava/lang/String;
    //   296: putfield cpm : Ljava/lang/String;
    //   299: aload #31
    //   301: aload #26
    //   303: lload #18
    //   305: ldc_w '86003'
    //   308: invokevirtual s : (JLjava/lang/String;)Ljava/util/ArrayList;
    //   311: putfield aTR : Ljava/util/ArrayList;
    //   314: aload #29
    //   316: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   319: istore #23
    //   321: iload #23
    //   323: ifne -> 427
    //   326: aload_0
    //   327: getfield mContext : Landroid/content/Context;
    //   330: aload #29
    //   332: invokestatic p : (Landroid/content/Context;Ljava/lang/String;)Ljava/util/ArrayList;
    //   335: astore #32
    //   337: aload #31
    //   339: getfield name : Ljava/lang/String;
    //   342: astore #27
    //   344: aload #32
    //   346: invokevirtual size : ()I
    //   349: ifeq -> 874
    //   352: new java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial <init> : ()V
    //   359: astore #33
    //   361: aload #33
    //   363: aload #27
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload #33
    //   371: ldc_w '['
    //   374: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload #33
    //   380: aconst_null
    //   381: aload #32
    //   383: invokestatic a : (Ljava/lang/StringBuilder;Ljava/util/ArrayList;)Ljava/lang/StringBuilder;
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #33
    //   395: ldc_w ']'
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload #33
    //   404: invokevirtual toString : ()Ljava/lang/String;
    //   407: astore #27
    //   409: goto -> 412
    //   412: aload #31
    //   414: aload #27
    //   416: putfield name : Ljava/lang/String;
    //   419: goto -> 427
    //   422: astore #24
    //   424: goto -> 829
    //   427: aload #31
    //   429: dload #8
    //   431: putfield cpo : D
    //   434: aload #31
    //   436: getfield cpo : D
    //   439: dstore #4
    //   441: dload #4
    //   443: dconst_0
    //   444: dcmpg
    //   445: ifge -> 493
    //   448: lload #14
    //   450: lstore #20
    //   452: lload #20
    //   454: lconst_0
    //   455: lcmp
    //   456: ifle -> 490
    //   459: aload #31
    //   461: lload #20
    //   463: putfield aTO : J
    //   466: aload #31
    //   468: lload #12
    //   470: invokevirtual cs : (J)V
    //   473: aload #31
    //   475: lload #16
    //   477: putfield bbX : J
    //   480: aload #31
    //   482: iload #22
    //   484: putfield aTP : Z
    //   487: goto -> 493
    //   490: goto -> 493
    //   493: aload #31
    //   495: aload #30
    //   497: aload #30
    //   499: ldc_w 'nProductType'
    //   502: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   507: invokeinterface getLong : (I)J
    //   512: putfield cpq : J
    //   515: aload #30
    //   517: aload #30
    //   519: ldc 'fSalePrice'
    //   521: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   526: invokeinterface getDouble : (I)D
    //   531: dstore #4
    //   533: dload #4
    //   535: dload #6
    //   537: dsub
    //   538: invokestatic bc : (D)Z
    //   541: istore #23
    //   543: iload #23
    //   545: ifeq -> 557
    //   548: aload #31
    //   550: iconst_0
    //   551: putfield cpp : Z
    //   554: goto -> 563
    //   557: aload #31
    //   559: iconst_1
    //   560: putfield cpp : Z
    //   563: aload #31
    //   565: dload #4
    //   567: invokestatic valueOf : (D)Ljava/lang/Double;
    //   570: putfield cps : Ljava/lang/Double;
    //   573: aload #29
    //   575: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   578: ifne -> 877
    //   581: aload_0
    //   582: getfield mContext : Landroid/content/Context;
    //   585: dload #6
    //   587: aload #29
    //   589: invokestatic a : (Landroid/content/Context;DLjava/lang/String;)D
    //   592: dload #6
    //   594: dadd
    //   595: dstore #4
    //   597: goto -> 600
    //   600: aload #31
    //   602: dload #4
    //   604: invokestatic valueOf : (D)Ljava/lang/Double;
    //   607: putfield cpt : Ljava/lang/Double;
    //   610: aload #31
    //   612: dload #4
    //   614: putfield cpn : D
    //   617: aload #30
    //   619: aload #30
    //   621: ldc_w 'fDiscountSalePrice'
    //   624: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   629: invokeinterface getString : (I)Ljava/lang/String;
    //   634: ifnull -> 659
    //   637: aload #31
    //   639: aload #30
    //   641: aload #30
    //   643: ldc_w 'fDiscountSalePrice'
    //   646: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   651: invokeinterface getDouble : (I)D
    //   656: putfield cpu : D
    //   659: aload #24
    //   661: ifnull -> 884
    //   664: aload #31
    //   666: aload #24
    //   668: invokevirtual intValue : ()I
    //   671: i2l
    //   672: putfield cpx : J
    //   675: aload #31
    //   677: getfield cpx : J
    //   680: ldc2_w 3
    //   683: lcmp
    //   684: ifne -> 884
    //   687: aload #31
    //   689: dconst_0
    //   690: putfield cpn : D
    //   693: aload #31
    //   695: dconst_0
    //   696: invokestatic valueOf : (D)Ljava/lang/Double;
    //   699: putfield cpt : Ljava/lang/Double;
    //   702: aload #31
    //   704: dconst_0
    //   705: putfield cpu : D
    //   708: aload #31
    //   710: getfield name : Ljava/lang/String;
    //   713: ldc_w '|-'
    //   716: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   719: ifne -> 764
    //   722: new java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial <init> : ()V
    //   729: astore #27
    //   731: aload #27
    //   733: ldc_w '|-'
    //   736: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload #27
    //   742: aload #31
    //   744: getfield name : Ljava/lang/String;
    //   747: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload #31
    //   753: aload #27
    //   755: invokevirtual toString : ()Ljava/lang/String;
    //   758: putfield name : Ljava/lang/String;
    //   761: goto -> 764
    //   764: aload #31
    //   766: getfield cpo : D
    //   769: invokestatic bc : (D)Z
    //   772: ifne -> 887
    //   775: aload #28
    //   777: aload #31
    //   779: invokevirtual add : (Ljava/lang/Object;)Z
    //   782: pop
    //   783: goto -> 887
    //   786: iload #10
    //   788: istore #11
    //   790: aload #30
    //   792: invokeinterface close : ()V
    //   797: aload #26
    //   799: invokevirtual close : ()V
    //   802: goto -> 834
    //   805: astore #24
    //   807: iload #10
    //   809: istore #11
    //   811: goto -> 829
    //   814: astore #24
    //   816: iload #11
    //   818: istore #10
    //   820: goto -> 825
    //   823: astore #24
    //   825: iload #10
    //   827: istore #11
    //   829: aload #24
    //   831: invokestatic e : (Ljava/lang/Throwable;)V
    //   834: iload #11
    //   836: iconst_1
    //   837: iadd
    //   838: istore #10
    //   840: goto -> 25
    //   843: aload #25
    //   845: invokevirtual close : ()V
    //   848: aload #28
    //   850: areturn
    //   851: lconst_0
    //   852: lstore #12
    //   854: lload #12
    //   856: lstore #14
    //   858: lload #14
    //   860: lstore #16
    //   862: iconst_0
    //   863: istore #22
    //   865: goto -> 145
    //   868: aconst_null
    //   869: astore #24
    //   871: goto -> 179
    //   874: goto -> 412
    //   877: dload #6
    //   879: dstore #4
    //   881: goto -> 600
    //   884: goto -> 764
    //   887: iload #11
    //   889: istore #10
    //   891: goto -> 204
    //   894: astore #24
    //   896: goto -> 829
    // Exception table:
    //   from	to	target	type
    //   34	75	823	org/json/JSONException
    //   82	142	823	org/json/JSONException
    //   145	176	823	org/json/JSONException
    //   179	188	823	org/json/JSONException
    //   192	204	814	org/json/JSONException
    //   208	218	814	org/json/JSONException
    //   222	231	814	org/json/JSONException
    //   235	242	814	org/json/JSONException
    //   246	321	894	org/json/JSONException
    //   326	409	422	org/json/JSONException
    //   412	419	422	org/json/JSONException
    //   427	441	894	org/json/JSONException
    //   459	487	422	org/json/JSONException
    //   493	543	894	org/json/JSONException
    //   548	554	805	org/json/JSONException
    //   557	563	805	org/json/JSONException
    //   563	597	805	org/json/JSONException
    //   600	659	805	org/json/JSONException
    //   664	761	805	org/json/JSONException
    //   764	783	805	org/json/JSONException
    //   790	802	805	org/json/JSONException }
  
  public static ArrayList<c> p(Context paramContext, String paramString) {
    ArrayList arrayList = new ArrayList();
    String[] arrayOfString = paramString.split("/");
    null = new g(paramContext);
    long l = null.DZ();
    null.close();
    f f = new f(paramContext);
    for (byte b = 0;; b++) {
      if (b < arrayOfString.length) {
        int i;
        if (arrayOfString[b].lastIndexOf("X") != -1) {
          i = arrayOfString[b].lastIndexOf("X");
        } else if (arrayOfString[b].lastIndexOf("x") != -1) {
          i = arrayOfString[b].lastIndexOf("x");
        } else {
          i = 0;
        } 
        if (arrayOfString[b].lastIndexOf("X") == -1 && arrayOfString[b].lastIndexOf("x") == -1) {
          String str = arrayOfString[b].trim();
        } else {
          try {
            String str = arrayOfString[b].substring(0, i).trim();
            i = Integer.parseInt(arrayOfString[b].substring(i + 1, arrayOfString[b].length()).trim());
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("nShopID = ");
            stringBuilder1.append(l);
            stringBuilder1.append(" and sFieldName='");
            stringBuilder1.append(str);
            stringBuilder1.append("' and nfieldtype='44' and sIsActive='Y'");
            HashMap hashMap1 = f.y("t_string", "_id,sFieldName,nSpareField1,sFieldValue", stringBuilder1.toString());
            arrayList.add(new c(Long.parseLong((String)hashMap1.get("_id")), str, i, Integer.parseInt((String)hashMap1.get("nSpareField1")), Double.parseDouble((String)hashMap1.get("sFieldValue")), ""));
            b++;
            continue;
          } catch (Exception paramContext) {}
        } 
      } else {
        f.close();
        return arrayList;
      } 
      byte b1 = 1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("nShopID = ");
      stringBuilder.append(l);
      stringBuilder.append(" and sFieldName='");
      stringBuilder.append(paramContext);
      stringBuilder.append("' and nfieldtype='44' and sIsActive='Y'");
      HashMap hashMap = f.y("t_string", "_id,sFieldName,nSpareField1,sFieldValue", stringBuilder.toString());
      arrayList.add(new c(Long.parseLong((String)hashMap.get("_id")), paramContext, b1, Integer.parseInt((String)hashMap.get("nSpareField1")), Double.parseDouble((String)hashMap.get("sFieldValue")), ""));
    } 
  }
  
  public int jv(String paramString) {
    try {
      av av = new av(this.mContext);
      a.AZ().bF(true);
      long l2 = av.atN();
      av.close();
      null = new JSONObject(paramString);
      String str1 = (String)null.get("sUserPhone");
      String str2 = (String)null.get("sTableID");
      long l1 = 0L;
      if (null.has("sPack")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Integer)null.get("sPack"));
        stringBuilder.append("");
        l1 = by.parseLong(stringBuilder.toString());
      } 
      paramString = "";
      if (null.has("messageToChef"))
        paramString = (String)null.get("messageToChef"); 
      null = (JSONArray)null.get("data");
      int i = null.length();
      null = this.cdv.getMessage();
      null.append("Client request item is:");
      null.append(null.toString());
      null.append("\n");
      null = new a(this.mContext);
      boolean bool = null.ku(str2);
      null.close();
      if (bool) {
        this.cdv.getMessage().append("Table No exists already\n");
        bb.e("dcbe", "existGradesWay -3");
        return -3;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      HashMap hashMap2 = new HashMap();
      HashMap hashMap1 = new HashMap();
      for (byte b = 0; b < i; b++) {
        JSONObject jSONObject = (JSONObject)null.get(b);
        stringBuilder1.append(jSONObject.get("_id"));
        stringBuilder1.append(",");
        if (!jSONObject.has("sTaste")) {
          hashMap1.put((String)jSONObject.get("_id"), "");
        } else {
          hashMap1.put((String)jSONObject.get("_id"), (String)jSONObject.get("sTaste"));
        } 
        hashMap2.put((String)jSONObject.get("_id"), jSONObject.getString("nBuyNumber"));
      } 
      StringBuffer stringBuffer2 = this.cdv.getMessage();
      stringBuffer2.append("Client Products is:");
      stringBuffer2.append(hashMap2.toString());
      stringBuffer2.append("\n");
      StringBuffer stringBuffer1 = this.cdv.getMessage();
      stringBuffer1.append("Client Tastes is:");
      stringBuffer1.append(hashMap1.toString());
      stringBuffer1.append("\n");
      stringBuilder1.deleteCharAt(stringBuilder1.length() - 1);
      PendingFullOrderDetail pendingFullOrderDetail = b(l2, null);
      l2 = System.currentTimeMillis();
      PendingFullOrderDetail.a a2 = pendingFullOrderDetail.bXb;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(System.currentTimeMillis());
      stringBuilder2.append("");
      a2.orderNo = stringBuilder2.toString();
      pendingFullOrderDetail.bXb.bJc = Long.valueOf(av.Tx()).longValue();
      pendingFullOrderDetail.bXb.aEI = Long.valueOf(av.atm()).longValue();
      pendingFullOrderDetail.bXb.coJ = str2;
      pendingFullOrderDetail.bXb.coK = str1;
      pendingFullOrderDetail.bXb.coN = paramString;
      pendingFullOrderDetail.bXb.aVN = l1;
      null = new a(this.mContext);
      bool = null.a(pendingFullOrderDetail, l2);
      null.close();
      if (!bool)
        return -2; 
      e.aU(this.mContext).play();
      this.mContext.sendBroadcast(new Intent("pos_activity_change_data_takeorderscount"));
      null = g.cGS;
      bool = a.AZ().Bi();
      a a1 = pendingFullOrderDetail.aaE();
      if (bool) {
        List list1 = j.cCx.a(pendingFullOrderDetail, new String[] { "dish" });
        g.cGS.o(list1);
      } 
      if (a.AZ().Bj()) {
        List list1 = j.cCx.a(a1, new String[] { "tag_not_specified" });
        g.cGS.o(list1);
      } 
      List list = j.cCx.a(a1, new String[] { "kitchen_total", "kitchen_port" });
      d.bg(this.mContext).p(list);
      g.cGS.o(list);
      a(this.mContext, pendingFullOrderDetail);
      return -1;
    } catch (JSONException paramString) {
      bb.e("dcbe", paramString.toString());
      a.e(paramString);
      return -5;
    } catch (Exception paramString) {
      StringBuffer stringBuffer = this.cdv.getMessage();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception is: ");
      stringBuilder.append(paramString.toString());
      stringBuilder.append("\n");
      stringBuffer.append(stringBuilder.toString());
      bb.e("dcbe", paramString.toString());
      a.e(paramString);
      return -2;
    } 
  }
  
  public int jw(String paramString) {
    try {
      boolean bool;
      JSONObject jSONObject = new JSONObject(paramString);
      null = (String)jSONObject.get("sOrderID");
      String str3 = (String)jSONObject.get("sUserPhone");
      String str4 = (String)jSONObject.get("sTableID");
      long l1 = 0L;
      if (jSONObject.has("sPack")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Integer)jSONObject.get("sPack"));
        stringBuilder.append("");
        l1 = by.parseLong(stringBuilder.toString());
      } 
      String str2 = "";
      if (jSONObject.has("messageToChef"))
        str2 = (String)jSONObject.get("messageToChef"); 
      if (paramString.indexOf("sGUIID", 0) > 0)
        paramString = (String)jSONObject.get("sGUIID"); 
      JSONArray jSONArray = (JSONArray)jSONObject.get("data");
      stringBuffer2 = this.cdv.getMessage();
      stringBuffer2.append("Client request item is:");
      stringBuffer2.append(jSONArray.toString());
      stringBuffer2.append("\n");
      av av2 = new av(this.mContext);
      a a1 = new a(this.mContext);
      stringBuffer1 = a1.kw(null);
      long l2 = av2.atN();
      if (stringBuffer1 == null || stringBuffer1.size() == 0) {
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer1;
        stringBuffer1 = this.cdv.getMessage();
        stringBuffer1.append("Could not find Order by OrderNo.Current Order NO is: ");
        stringBuffer1.append(null);
        stringBuffer1.append("\n");
        a1.close();
        return -2;
      } 
      null = this.cdv.getMessage();
      null.append("Find Order by OrderNo.Current Order NO is: ");
      null.append(null);
      null.append("\n");
      null = (String)((HashMap)stringBuffer1.get(0)).get("nPhysicalInventoryID");
      long l3 = by.parseLong((String)((HashMap)stringBuffer1.get(0)).get("sPack"));
      if (!str4.equals(null) || l1 != l3) {
        bool = true;
      } else {
        bool = false;
      } 
      if (!str4.equals(null) && a1.aF(str4, null)) {
        this.cdv.getMessage().append("Table No exists already\n");
        return -3;
      } 
      HashMap hashMap2 = new HashMap();
      HashMap hashMap1 = new HashMap();
      int i = jSONArray.length();
      byte b = 0;
      String str1 = null;
      av av1 = av2;
      while (true) {
        if (b < i) {
          JSONObject jSONObject1 = (JSONObject)jSONArray.get(b);
          double d = jSONObject1.getDouble("nBuyNumber");
          if (Math.abs(d - 0.0D) >= 1.0E-5D)
            hashMap2.put((String)jSONObject1.get("_id"), Double.valueOf(d)); 
          if (jSONObject1.toString().indexOf("sTaste", 0) > 0)
            hashMap1.put((String)jSONObject1.get("_id"), jSONObject1.get("sTaste")); 
        } else {
          StringBuffer stringBuffer = this.cdv.getMessage();
          stringBuffer.append("Client Products is:");
          stringBuffer.append(hashMap2.toString());
          stringBuffer.append("\n");
          stringBuffer = this.cdv.getMessage();
          stringBuffer.append("Client Tastes is:");
          stringBuffer.append(hashMap1.toString());
          stringBuffer.append("\n");
          if (bool)
            a1.c(str1, str4, l1); 
          a1.close();
          PendingFullOrderDetail.c c1 = a(l2, jSONArray);
          PendingFullOrderDetail.a a3 = new PendingFullOrderDetail.a();
          a3.coI = 300002L;
          a3.coE = new Date(System.currentTimeMillis());
          a3.coH = Long.valueOf("100001").longValue();
          a3.orderNo = str1;
          a3.bJc = Long.valueOf(av1.Tx()).longValue();
          a3.aEI = Long.valueOf(av1.atm()).longValue();
          a3.coJ = str4;
          a3.coK = str3;
          a3.coN = str2;
          a3.aVN = l1;
          null = (new a(this.mContext)).a(c1);
          if (null.cpg.size() == 0)
            return -1; 
          a a2 = new a(this.mContext);
          if (!a2.b(null, a3)) {
            this.cdv.getMessage().append("Update order create new item failed in method pm.saveModifyEntry\n");
            a2.close();
            return -2;
          } 
          if (null.cpg.size() != 0 || bool)
            e.aU(this.mContext).play(); 
          this.mContext.sendBroadcast(new Intent("pos_activity_change_data_takeorderscount"));
          g g = g.cGS;
          ah ah = new ah(a3, null);
          if (a.AZ().Bi()) {
            List list1 = j.cCx.a(ah, new String[] { "dish" });
            g.cGS.o(list1);
          } 
          if (a.AZ().Bj()) {
            List list1 = j.cCx.a(ah, new String[] { "tag_not_specified" });
            g.cGS.o(list1);
          } 
          List list = j.cCx.a(ah, new String[] { "kitchen_total", "kitchen_port" });
          d.bg(this.mContext).p(list);
          g.cGS.o(list);
          return -1;
        } 
        b++;
      } 
    } catch (Exception paramString) {
      a.e(paramString);
      StringBuffer stringBuffer = this.cdv.getMessage();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("\n");
      stringBuffer.append(stringBuilder.toString());
      return -2;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */