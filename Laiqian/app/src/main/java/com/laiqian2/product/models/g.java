package com.laiqian.product.models;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.al;
import com.laiqian.models.ab;
import com.laiqian.models.x;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.ao;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends ab {
  av aIP;
  
  private final String bRb = "600003";
  
  private final String cUz = "default";
  
  public g(Context paramContext) {
    super(paramContext);
    this.aIP = new av(paramContext);
  }
  
  private ArrayList<h> a(String paramString1, String[] paramArrayOfString, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select T_PRODUCT._id _id,\nT_PRODUCT.sProductName,\nT_PRODUCT.fSalePrice,\nT_PRODUCT.nStockQty,\nT_PRODUCT.nProductStatus,\nT_PRODUCT.nProductType,\nT_PRODUCT.sProductNumber,\nT_PRODUCT.fDiscountSalePrice,\nT_PRODUCT.nFoodCategory,\nT_PRODUCT.sSpareField3,\nT_PRODUCT.sSpareField5,\nT_PRODUCT.fStockPrice,T_PRODUCT.nSpareField4 nSpareField4,ifnull(T_PRODUCT_EXT1.nSpareField3,0) weight_switch from T_PRODUCT left join T_PRODUCT_EXT1 on T_PRODUCT_EXT1._id = T_PRODUCT._id where ");
    stringBuilder.append(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" order by ");
      stringBuilder1.append(paramString2);
      String str = stringBuilder1.toString();
    } else {
      paramString1 = "";
    } 
    stringBuilder.append(paramString1);
    paramString1 = stringBuilder.toString();
    Cursor cursor = Vq().rawQuery(paramString1, paramArrayOfString);
    ArrayList arrayList = new ArrayList();
    while (cursor != null && cursor.moveToNext()) {
      h h;
      int i = cursor.getInt(8);
      boolean bool = true;
      if (i == 2) {
        paramString1 = cursor.getString(9);
        if (paramString1 == null || paramString1.length() < 3)
          continue; 
        h = new a(cursor.getLong(0), cursor.getString(1), cursor.getString(10), cursor.getDouble(2), cursor.getInt(4), cursor.getLong(5), cursor.getDouble(7), paramString1);
      } else {
        h = new h(cursor.getLong(0), cursor.getString(1), cursor.getString(10), cursor.getDouble(2), cursor.getDouble(3), cursor.getInt(4), cursor.getLong(5), cursor.getString(6), cursor.getDouble(7), "", cursor.getDouble(11));
        if (cursor.getInt(13) == 0)
          bool = false; 
        h.gs(bool);
      } 
      arrayList.add(h);
    } 
    if (cursor != null)
      cursor.close(); 
    return arrayList;
  }
  
  private boolean aK(double paramDouble) {
    String str = hQ("nStockQty");
    if (str == null) {
      n.println("这里是批量移动进来的，并且是否支持库存没有改变");
      return true;
    } 
    double d = Double.parseDouble(str) - paramDouble;
    String[] arrayOfString = aL(d);
    if (arrayOfString != null) {
      x x = new x(this.mContext);
      x.am("nProductTransacType", arrayOfString[0]);
      x.am("nStcokDirection", arrayOfString[1]);
      double d1 = d;
      if (d < 0.0D)
        d1 = d * -1.0D; 
      String str1 = hQ("_id");
      String str2 = hQ("sProductName");
      if (str1 == null) {
        n.println("你好像没有设置商品ID");
        return false;
      } 
      long l = System.currentTimeMillis();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(l);
      stringBuilder2.append("");
      x.am("_id", stringBuilder2.toString());
      x.am("nProductID", str1);
      x.am("sProductName", str2);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d1);
      stringBuilder1.append("");
      x.am("nProductQty", stringBuilder1.toString());
      x.am("fPrice", "0");
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramDouble);
      stringBuilder1.append("");
      x.am("nStockQty", stringBuilder1.toString());
      x.am("nProductUnit", "400001");
      x.am("fAmount", "0");
      x.am("fStockAmount", "0");
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.aIP.atN());
      stringBuilder1.append("");
      x.am("nWarehouseID", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(System.currentTimeMillis());
      stringBuilder1.append("");
      x.am("nDateTime", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(l);
      stringBuilder1.append("");
      x.am("sOrderNo", stringBuilder1.toString());
      x.am("fStockPrice", "0");
      boolean bool = x.Vc();
      x.close();
      return bool;
    } 
    return true;
  }
  
  private String[] aL(double paramDouble) { return (paramDouble > 1.0E-6D) ? new String[] { "100004", "300001" } : ((paramDouble < -1.0E-6D) ? new String[] { "100005", "300002" } : null); }
  
  private boolean b(String paramString, double paramDouble) {
    x x = new x(this.mContext);
    x.am("nProductTransacType", "100048");
    x.am("nStcokDirection", "300002");
    String str1 = hQ("_id");
    String str2 = hQ("sProductName");
    if (str1 == null) {
      n.println("你好像没有设置商品ID");
      return false;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis());
    stringBuilder2.append("");
    String str3 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str3);
    stringBuilder3.append("");
    x.am("_id", stringBuilder3.toString());
    x.am("nProductID", str1);
    x.am("sProductName", str2);
    x.am("nProductQty", hQ("nProductQty"));
    x.am("fPrice", hQ("fPrice"));
    x.am("nStockQty", n.a(Double.valueOf(paramDouble), true, false, 3));
    x.am("nProductUnit", "400001");
    x.am("fAmount", hQ("fAmount"));
    x.am("fStockAmount", hQ("fStockAmount"));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.aIP.atN());
    stringBuilder1.append("");
    x.am("nWarehouseID", stringBuilder1.toString());
    x.am("nDateTime", str3);
    x.am("nPhysicalInventoryID", "8");
    x.am("sOrderNo", paramString);
    x.am("fStockPrice", hQ("fStockPrice"));
    boolean bool = x.Vc();
    x.close();
    return bool;
  }
  
  private boolean cJ(long paramLong) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual UC : ()Z
    //   4: ifne -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new com/laiqian/models/ab
    //   12: dup
    //   13: aload_0
    //   14: getfield mContext : Landroid/content/Context;
    //   17: invokespecial <init> : (Landroid/content/Context;)V
    //   20: astore #12
    //   22: aload #12
    //   24: lload_1
    //   25: invokevirtual bp : (J)Landroid/database/Cursor;
    //   28: astore #13
    //   30: aload #13
    //   32: invokeinterface moveToFirst : ()Z
    //   37: ifeq -> 739
    //   40: aload #13
    //   42: aload #13
    //   44: ldc 'sProductName'
    //   46: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   51: invokeinterface getString : (I)Ljava/lang/String;
    //   56: astore #17
    //   58: aload #13
    //   60: aload #13
    //   62: ldc 'nStockQty'
    //   64: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   69: invokeinterface getDouble : (I)D
    //   74: dstore #5
    //   76: aload #13
    //   78: aload #13
    //   80: ldc 'nProductUnit'
    //   82: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   87: invokeinterface getLong : (I)J
    //   92: lstore #9
    //   94: aload #13
    //   96: aload #13
    //   98: ldc 'fStockPrice'
    //   100: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   105: invokeinterface getDouble : (I)D
    //   110: dstore_3
    //   111: new com/laiqian/models/x
    //   114: dup
    //   115: aload_0
    //   116: getfield mContext : Landroid/content/Context;
    //   119: invokespecial <init> : (Landroid/content/Context;)V
    //   122: astore #14
    //   124: dload #5
    //   126: dconst_0
    //   127: dcmpg
    //   128: ifge -> 225
    //   131: aload #14
    //   133: ldc 'nProductTransacType'
    //   135: ldc '100004'
    //   137: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   140: pop
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore #15
    //   150: dload #5
    //   152: dneg
    //   153: dstore #7
    //   155: aload #15
    //   157: dload #7
    //   159: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload #15
    //   165: ldc ''
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #14
    //   173: ldc 'nProductQty'
    //   175: aload #15
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   183: pop
    //   184: aload #14
    //   186: ldc 'nStcokDirection'
    //   188: ldc '300001'
    //   190: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   193: pop
    //   194: goto -> 283
    //   197: astore #15
    //   199: goto -> 209
    //   202: astore #15
    //   204: goto -> 222
    //   207: astore #15
    //   209: aload #12
    //   211: astore #16
    //   213: aload #15
    //   215: astore #12
    //   217: goto -> 978
    //   220: astore #15
    //   222: goto -> 917
    //   225: aload #14
    //   227: ldc 'nProductTransacType'
    //   229: ldc '100005'
    //   231: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   234: pop
    //   235: new java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial <init> : ()V
    //   242: astore #15
    //   244: aload #15
    //   246: dload #5
    //   248: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #15
    //   254: ldc ''
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload #14
    //   262: ldc 'nProductQty'
    //   264: aload #15
    //   266: invokevirtual toString : ()Ljava/lang/String;
    //   269: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   272: pop
    //   273: aload #14
    //   275: ldc 'nStcokDirection'
    //   277: ldc '300002'
    //   279: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   282: pop
    //   283: aload #13
    //   285: astore #15
    //   287: aload #12
    //   289: astore #16
    //   291: new java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial <init> : ()V
    //   298: astore #18
    //   300: aload #18
    //   302: lload_1
    //   303: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload #18
    //   309: ldc ''
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload #14
    //   317: ldc 'nProductID'
    //   319: aload #18
    //   321: invokevirtual toString : ()Ljava/lang/String;
    //   324: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   327: pop
    //   328: aload #14
    //   330: ldc 'sProductName'
    //   332: aload #17
    //   334: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   337: pop
    //   338: new java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial <init> : ()V
    //   345: astore #17
    //   347: aload #17
    //   349: dload_3
    //   350: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload #17
    //   356: ldc ''
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload #14
    //   364: ldc 'fPrice'
    //   366: aload #17
    //   368: invokevirtual toString : ()Ljava/lang/String;
    //   371: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   374: pop
    //   375: new java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial <init> : ()V
    //   382: astore #17
    //   384: aload #17
    //   386: dload #5
    //   388: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload #17
    //   394: ldc ''
    //   396: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload #14
    //   402: ldc 'nStockQty'
    //   404: aload #17
    //   406: invokevirtual toString : ()Ljava/lang/String;
    //   409: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   412: pop
    //   413: new java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial <init> : ()V
    //   420: astore #17
    //   422: aload #17
    //   424: lload #9
    //   426: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload #17
    //   432: ldc ''
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload #14
    //   440: ldc 'nProductUnit'
    //   442: aload #17
    //   444: invokevirtual toString : ()Ljava/lang/String;
    //   447: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   450: pop
    //   451: new java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial <init> : ()V
    //   458: astore #17
    //   460: dload #5
    //   462: dload_3
    //   463: dmul
    //   464: dstore #5
    //   466: aload #17
    //   468: dload #5
    //   470: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload #17
    //   476: ldc ''
    //   478: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload #14
    //   484: ldc 'fAmount'
    //   486: aload #17
    //   488: invokevirtual toString : ()Ljava/lang/String;
    //   491: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   494: pop
    //   495: new java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial <init> : ()V
    //   502: astore #17
    //   504: aload #17
    //   506: dload #5
    //   508: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload #17
    //   514: ldc ''
    //   516: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload #14
    //   522: ldc 'fStockAmount'
    //   524: aload #17
    //   526: invokevirtual toString : ()Ljava/lang/String;
    //   529: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   532: pop
    //   533: aload #14
    //   535: ldc 'nWarehouseID'
    //   537: aload_0
    //   538: invokevirtual VC : ()Ljava/lang/String;
    //   541: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   544: pop
    //   545: new java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial <init> : ()V
    //   552: astore #17
    //   554: aload #17
    //   556: invokestatic currentTimeMillis : ()J
    //   559: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload #17
    //   565: ldc ''
    //   567: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload #14
    //   573: ldc 'nDateTime'
    //   575: aload #17
    //   577: invokevirtual toString : ()Ljava/lang/String;
    //   580: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   583: pop
    //   584: new java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial <init> : ()V
    //   591: astore #17
    //   593: aload #17
    //   595: invokestatic currentTimeMillis : ()J
    //   598: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload #17
    //   604: ldc ''
    //   606: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload #14
    //   612: ldc 'sOrderNo'
    //   614: aload #17
    //   616: invokevirtual toString : ()Ljava/lang/String;
    //   619: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   622: pop
    //   623: new java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial <init> : ()V
    //   630: astore #17
    //   632: aload #17
    //   634: dload_3
    //   635: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload #17
    //   641: ldc ''
    //   643: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload #14
    //   649: ldc 'fStockPrice'
    //   651: aload #17
    //   653: invokevirtual toString : ()Ljava/lang/String;
    //   656: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   659: pop
    //   660: aload #14
    //   662: invokevirtual Vc : ()Z
    //   665: istore #11
    //   667: iload #11
    //   669: ifne -> 706
    //   672: aload #16
    //   674: ifnull -> 682
    //   677: aload #16
    //   679: invokevirtual close : ()V
    //   682: aload #15
    //   684: ifnull -> 694
    //   687: aload #15
    //   689: invokeinterface close : ()V
    //   694: aload #14
    //   696: ifnull -> 704
    //   699: aload #14
    //   701: invokevirtual close : ()V
    //   704: iconst_0
    //   705: ireturn
    //   706: aload #16
    //   708: astore #12
    //   710: aload #15
    //   712: astore #13
    //   714: goto -> 742
    //   717: astore #15
    //   719: aload #12
    //   721: astore #16
    //   723: aload #15
    //   725: astore #12
    //   727: aload #13
    //   729: astore #17
    //   731: goto -> 974
    //   734: astore #15
    //   736: goto -> 853
    //   739: aconst_null
    //   740: astore #14
    //   742: aload #12
    //   744: astore #16
    //   746: aload #13
    //   748: astore #17
    //   750: aload #14
    //   752: astore #18
    //   754: aload_0
    //   755: lload_1
    //   756: invokevirtual bo : (J)Z
    //   759: pop
    //   760: aload #12
    //   762: astore #16
    //   764: aload #13
    //   766: astore #17
    //   768: aload #14
    //   770: astore #18
    //   772: aload_0
    //   773: ldc_w 'nProductStatus'
    //   776: ldc '600003'
    //   778: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   781: pop
    //   782: aload #12
    //   784: astore #16
    //   786: aload #13
    //   788: astore #17
    //   790: aload #14
    //   792: astore #18
    //   794: aload_0
    //   795: invokevirtual VS : ()V
    //   798: aload #12
    //   800: astore #16
    //   802: aload #13
    //   804: astore #17
    //   806: aload #14
    //   808: astore #18
    //   810: aload_0
    //   811: invokespecial update : ()Z
    //   814: istore #11
    //   816: aload #12
    //   818: ifnull -> 826
    //   821: aload #12
    //   823: invokevirtual close : ()V
    //   826: aload #13
    //   828: ifnull -> 838
    //   831: aload #13
    //   833: invokeinterface close : ()V
    //   838: aload #14
    //   840: ifnull -> 848
    //   843: aload #14
    //   845: invokevirtual close : ()V
    //   848: iload #11
    //   850: ireturn
    //   851: astore #15
    //   853: goto -> 917
    //   856: astore #14
    //   858: aload #12
    //   860: astore #16
    //   862: aload #14
    //   864: astore #12
    //   866: goto -> 900
    //   869: astore #15
    //   871: goto -> 914
    //   874: astore #13
    //   876: aload #12
    //   878: astore #16
    //   880: aload #13
    //   882: astore #12
    //   884: goto -> 897
    //   887: astore #15
    //   889: goto -> 911
    //   892: astore #12
    //   894: aconst_null
    //   895: astore #16
    //   897: aconst_null
    //   898: astore #13
    //   900: aconst_null
    //   901: astore #14
    //   903: goto -> 978
    //   906: astore #15
    //   908: aconst_null
    //   909: astore #12
    //   911: aconst_null
    //   912: astore #13
    //   914: aconst_null
    //   915: astore #14
    //   917: aload #12
    //   919: astore #16
    //   921: aload #13
    //   923: astore #17
    //   925: aload #14
    //   927: astore #18
    //   929: aload #15
    //   931: invokestatic e : (Ljava/lang/Throwable;)V
    //   934: aload #12
    //   936: ifnull -> 944
    //   939: aload #12
    //   941: invokevirtual close : ()V
    //   944: aload #13
    //   946: ifnull -> 956
    //   949: aload #13
    //   951: invokeinterface close : ()V
    //   956: aload #14
    //   958: ifnull -> 966
    //   961: aload #14
    //   963: invokevirtual close : ()V
    //   966: iconst_0
    //   967: ireturn
    //   968: astore #12
    //   970: aload #18
    //   972: astore #14
    //   974: aload #17
    //   976: astore #13
    //   978: aload #16
    //   980: ifnull -> 988
    //   983: aload #16
    //   985: invokevirtual close : ()V
    //   988: aload #13
    //   990: ifnull -> 1000
    //   993: aload #13
    //   995: invokeinterface close : ()V
    //   1000: aload #14
    //   1002: ifnull -> 1010
    //   1005: aload #14
    //   1007: invokevirtual close : ()V
    //   1010: aload #12
    //   1012: athrow
    // Exception table:
    //   from	to	target	type
    //   9	22	906	java/lang/Exception
    //   9	22	892	finally
    //   22	30	887	java/lang/Exception
    //   22	30	874	finally
    //   30	124	869	java/lang/Exception
    //   30	124	856	finally
    //   131	150	220	java/lang/Exception
    //   131	150	207	finally
    //   155	194	202	java/lang/Exception
    //   155	194	197	finally
    //   225	283	734	java/lang/Exception
    //   225	283	717	finally
    //   291	460	734	java/lang/Exception
    //   291	460	717	finally
    //   466	667	734	java/lang/Exception
    //   466	667	717	finally
    //   754	760	851	java/lang/Exception
    //   754	760	968	finally
    //   772	782	851	java/lang/Exception
    //   772	782	968	finally
    //   794	798	851	java/lang/Exception
    //   794	798	968	finally
    //   810	816	851	java/lang/Exception
    //   810	816	968	finally
    //   929	934	968	finally }
  
  private String cQ(long paramLong) {
    hY("sSpareField3");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    c("_id=? and nShopID=? and nFoodCategory=0 ", new String[] { stringBuilder.toString(), VC() });
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      String str = cursor.getString(0);
    } else {
      stringBuilder = null;
    } 
    cursor.close();
    return stringBuilder;
  }
  
  private boolean e(long paramLong, double paramDouble) {
    beginTransaction();
    boolean bool = f(paramLong, paramDouble);
    if (bool)
      setTransactionSuccessful(); 
    endTransaction();
    return bool;
  }
  
  private boolean f(long paramLong, double paramDouble) {
    byte b = 0;
    try {
      if (!UB())
        return false; 
      bo(paramLong);
      int i = b;
      if (update()) {
        boolean bool = aK(paramDouble);
        i = b;
        if (bool)
          i = 1; 
      } 
      return i;
    } catch (Exception exception) {
      a.e(exception);
      return false;
    } 
  }
  
  private void mH(String paramString) {
    ao.a a = ao.asV().qy(paramString);
    am("sText", a.dFu);
    am("sSpareField2", a.dFv);
    am("sSpareField4", a.dFw);
  }
  
  public boolean A(long paramLong, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    am("sProductDescription", paramString);
    return cK(paramLong);
  }
  
  public ArrayList<h> B(long paramLong, String paramString) {
    String str2 = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    String str3 = stringBuilder.toString();
    String str1 = paramString;
    if (paramString.contains("LOWER(T_PRODUCT.sText)")) {
      str1 = paramString;
      if (RootApplication.getLaiqianPreferenceManager().avx())
        str1 = paramString.replace("LOWER(T_PRODUCT.sText)", "LOWER(T_PRODUCT.sSpareField5)"); 
    } 
    return a("T_PRODUCT.nShopID=? and T_PRODUCT.nProductType=? and (T_PRODUCT.nProductStatus=600001 or T_PRODUCT.nProductStatus=600002) and (T_PRODUCT.nFoodCategory=0 or T_PRODUCT.nFoodCategory=2)", new String[] { str2, str3 }, str1);
  }
  
  public String[] C(long paramLong, String paramString) {
    null = new StringBuilder();
    null.append("sSpareField3 is not null and sSpareField3 like '%");
    null.append(paramLong);
    null.append("%' and (nProductStatus =600001 or nProductStatus =600002) and nShopID=");
    null.append(VC());
    null.append(" and nProductType=");
    null.append(VC());
    null.append("50001");
    hZ(null.toString());
    hY("sProductName");
    Cursor cursor = VM();
    String[] arrayOfString = new String[cursor.getCount()];
    byte b;
    for (b = 0; cursor.moveToNext(); b++)
      arrayOfString[b] = cursor.getString(0); 
    cursor.close();
    return arrayOfString;
  }
  
  public ArrayList<HashMap<String, String>> a(String paramString1, String paramString2, String paramString3, HashMap<Long, HashMap<String, String>> paramHashMap, boolean paramBoolean) {
    String str;
    ArrayList arrayList = new ArrayList();
    hY("T_PRODUCT._id _id,T_PRODUCT.sProductName,T_PRODUCT.fSalePrice,T_PRODUCT.nProductType,T_PRODUCT.nStockQty,T_PRODUCT.nSpareField1,T_PRODUCT.sSpareField1,T_PRODUCT.sProductNumber,T_PRODUCT.fDiscountSalePrice,T_PRODUCT.sSpareField5,T_PRODUCT.sProductDescription,T_PRODUCT.fBuyPrice,T_PRODUCT.nSpareField3,T_PRODUCT.fStockPrice,ifnull(T_PRODUCT_EXT1.nSpareField3,0) weight_switch");
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i == 1 || i == 2) {
      av av1 = new av(this.mContext);
      str = av1.Bh();
      av1.close();
    } else if (a.AZ().Bh().contains("sText")) {
      str = a.AZ().Bh().replace("sText", "T_PRODUCT.sText");
    } else {
      null = new StringBuilder();
      null.append("T_PRODUCT.");
      null.append(a.AZ().Bh());
      str = null.toString();
    } 
    ia(str);
    Cursor cursor = c(paramString1, paramString2, paramBoolean);
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      long l = cursor.getLong(0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("");
      hashMap.put("id", stringBuilder.toString());
      hashMap.put("name", cursor.getString(1));
      hashMap.put("name2", cursor.getString(9));
      hashMap.put("price", n.b(this.mContext, Double.valueOf(cursor.getDouble(2)), true));
      hashMap.put("typeID", cursor.getString(3));
      hashMap.put("qty", n.b(this.mContext, Double.valueOf(cursor.getDouble(4)), false));
      hashMap.put("nSpareField1", cursor.getString(5));
      hashMap.put("sSpareField1", cursor.getString(6));
      hashMap.put("sProductNumber", cursor.getString(7));
      hashMap.put("memberPrice", n.b(this.mContext, Double.valueOf(cursor.getDouble(8)), true));
      hashMap.put("sProductDescription", cursor.getString(10));
      hashMap.put("fBuyPrice", cursor.getString(11));
      hashMap.put("scaleCode", cursor.getString(12));
      hashMap.put("fStockPrice", cursor.getString(13));
      hashMap.put("weight_switch", cursor.getString(14));
      if (paramHashMap != null && paramHashMap.containsKey(Long.valueOf(l))) {
        hashMap.put(paramString3, "true");
        paramHashMap.put(Long.valueOf(l), hashMap);
      } 
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
  
  public void a(ArrayList<m> paramArrayList, long paramLong, b paramb) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select t_product._id,t_product.sProductName,t_product.nStockQty,t_product.fSpareField1,t_product.nProductUnit,t_string.sFieldName");
    stringBuilder.append(" from t_product ");
    stringBuilder.append(" left join t_string on t_string.nFieldType=4 and t_string._id=t_product.nProductUnit ");
    stringBuilder.append(" where t_product.nFoodCategory=1 and t_product.nProductStatus=600001 ");
    if (paramLong > 0L) {
      stringBuilder.append(" and nProductType=");
      stringBuilder.append(paramLong);
    } 
    stringBuilder.append(" and t_product.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" order by ");
    stringBuilder.append("t_product.nStockQty>t_product.fSpareField1");
    stringBuilder.append(",t_product.");
    stringBuilder.append(b.a(paramb));
    Cursor cursor = Vq().rawQuery(stringBuilder.toString(), null);
    while (cursor.moveToNext())
      paramArrayList.add(new m(cursor.getLong(0), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3), cursor.getLong(4), cursor.getString(5))); 
    cursor.close();
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4) {
    am("sProductName", paramString1);
    if (!UA())
      return false; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    am("nProductType", VE());
    am("fSalePrice", paramString2);
    am("fDiscountSalePrice", paramString3);
    am("nFoodCategory", "2");
    am("sSpareField5", paramString4);
    mH(paramString1);
    boolean bool = QL();
    if (bool && bd.bH(this.mContext)) {
      Context context = this.mContext;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLong);
      stringBuilder1.append("");
      (new a(context, stringBuilder1.toString())).start();
    } 
    return bool;
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return false; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    am("sSpareField1", paramJSONObject.toString());
    return cK(paramLong);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, double paramDouble, String paramString6, String paramString7, String paramString8) {
    am("_id", paramString1);
    am("sProductName", paramString2);
    am("nProductType", paramString3);
    am("fSalePrice", paramString4);
    mH(paramString2);
    am("nStockQty", paramString5);
    if (paramString6 != null)
      am("sProductNumber", paramString6); 
    am("fDiscountSalePrice", paramString7);
    am("sSpareField5", paramString8);
    return e(Long.parseLong(paramString1), paramDouble);
  }
  
  public boolean a(long[] paramArrayOfLong, double paramDouble) {
    null = new StringBuilder();
    null.append(paramArrayOfLong[0]);
    null.append("");
    null = new StringBuilder(null.toString());
    int i = 1;
    byte b2 = 1;
    byte b1;
    for (b1 = 1; b1 < paramArrayOfLong.length; b1++) {
      null.append(",");
      null.append(paramArrayOfLong[b1]);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_id in(");
    stringBuilder.append(null.toString());
    stringBuilder.append(") and fSalePrice >? and nShopID=?");
    null = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    c(null, new String[] { stringBuilder.toString(), VC() });
    Cursor cursor = VM();
    if (cursor != null) {
      if (cursor.getCount() == paramArrayOfLong.length) {
        i = b2;
      } else {
        i = 0;
      } 
      cursor.close();
    } 
    return i;
  }
  
  public boolean a(long[] paramArrayOfLong, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean[] paramArrayOfBoolean, String paramString, boolean paramBoolean) {
    beginTransaction();
    boolean bool = true;
    byte b;
    for (b = 0; b < paramArrayOfLong.length; b++) {
      double d;
      am("nProductType", paramString);
      if (paramArrayOfBoolean[b] != paramBoolean) {
        String str = new StringBuilder();
        str.append(paramArrayOfLong[b]);
        str.append("");
        am("_id", str.toString());
        am("sProductName", paramArrayOfString1[b]);
        if (paramBoolean) {
          String str1 = "9999";
        } else {
          str = "0";
        } 
        am("nStockQty", str);
        d = Double.parseDouble(paramArrayOfString2[b]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("商品");
        stringBuilder.append(paramArrayOfString1[b]);
        stringBuilder.append("更改了库存数量");
        n.println(stringBuilder.toString());
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramArrayOfLong[b]);
        stringBuilder.append("");
        am("_id", stringBuilder.toString());
        am("sProductName", paramArrayOfString1[b]);
        am("nStockQty", null);
        d = 0.0D;
      } 
      bool = f(paramArrayOfLong[b], d);
      if (!bool)
        break; 
    } 
    if (bool)
      setTransactionSuccessful(); 
    endTransaction();
    return bool;
  }
  
  public ArrayList<HashMap<String, String>> aN(String paramString1, String paramString2) { return a(paramString1, paramString2, null, null, false); }
  
  public long[] akA() {
    Cursor cursor = Vq().rawQuery("SELECT T_PRODUCT._id as id FROM   T_PRODUCT  left join  T_PRODUCT_EXT1  WHERE T_PRODUCT._id=T_PRODUCT_EXT1._id and T_PRODUCT.nProductStatus=600001  AND  T_PRODUCT_EXT1.nSpareField1 = 1 AND T_PRODUCT_EXT1.nExtendType = 1 and T_PRODUCT.nShopID = ? and T_PRODUCT_EXT1.nShopID = ?", new String[] { VC(), VC() });
    long[] arrayOfLong = new long[cursor.getCount()];
    for (byte b = 0; cursor.moveToNext(); b++)
      arrayOfLong[b] = cursor.getLong(0); 
    cursor.close();
    return arrayOfLong;
  }
  
  public boolean b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4) {
    am("sProductName", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    if (!UB())
      return false; 
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("_id=? and nSHopID=?", new String[] { stringBuilder.toString(), VC() });
    am("fSalePrice", paramString2);
    am("fDiscountSalePrice", paramString3);
    am("sSpareField5", paramString4);
    mH(paramString1);
    return update();
  }
  
  public boolean b(al paramal) {
    Log.d("ProductBusinessModel", "rechargeGiftUpdateQty: ");
    null = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramal.aVi.aSW);
    stringBuilder2.append("");
    d("nShopID=? and _id = ? and (nProductStatus=600001 or nProductStatus=600002)", new String[] { null, stringBuilder2.toString() });
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramal.aVi.aSW);
    stringBuilder1.append("");
    am("_id", stringBuilder1.toString());
    am("nStockQty", n.a(Double.valueOf(paramal.aVi.akF() - paramal.aUz), true, false, 3));
    boolean bool2 = update();
    boolean bool1 = bool2;
    if (bool2) {
      am("sProductName", paramal.aVi.getName());
      am("nProductQty", n.a(Double.valueOf(paramal.aUz), true, false, 3));
      am("fPrice", String.valueOf(paramal.aVi.akI()));
      am("fAmount", "0");
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramal.aVi.akH());
      stringBuilder1.append("");
      am("fStockPrice", stringBuilder1.toString());
      am("fStockAmount", n.b(this.mContext, Double.valueOf(paramal.aUz * paramal.aVi.akH()), true, false));
      bool1 = b(n.a("CZZS", new Date()), paramal.aVi.akF());
      this.mContext.sendBroadcast(new Intent("pos_activity_change_data_product"));
    } 
    return bool1;
  }
  
  public boolean c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
    if (paramString6 != null)
      am("sProductNumber", paramString6); 
    am("_id", paramString1);
    am("sProductName", paramString2);
    am("nProductType", paramString3);
    am("nProductStatus", "600001");
    am("nStockQty", paramString5);
    am("nProductUnit", "400001");
    am("fStockPrice", "0");
    am("fBuyPrice", "0");
    am("fSalePrice", paramString4);
    am("nCurrency", "200001");
    mH(paramString2);
    am("nFoodCategory", "0");
    am("fDiscountSalePrice", paramString7);
    am("sSpareField5", paramString8);
    boolean bool = xH();
    if (bool && bd.bH(this.mContext))
      (new a(this.mContext, paramString1)).start(); 
    return bool;
  }
  
  public boolean cK(long paramLong) {
    try {
      if (!UB())
        return false; 
      bo(paramLong);
      return update();
    } catch (Exception exception) {
      a.e(exception);
      return false;
    } 
  }
  
  public String cL(long paramLong) {
    String str2 = br(paramLong);
    str1 = null;
    try {
      JSONObject jSONObject = new JSONObject(str2);
      if (jSONObject.has("default"))
        str1 = jSONObject.getString("default"); 
      return str1;
    } catch (JSONException|Exception str1) {
      return null;
    } 
  }
  
  public boolean cM(long paramLong) {
    str = br(paramLong);
    try {
      JSONObject jSONObject = new JSONObject(str);
      if (jSONObject.has("default"))
        jSONObject.remove("default"); 
      return a(paramLong, jSONObject);
    } catch (JSONException str) {
      return true;
    } catch (Exception str) {
      return true;
    } 
  }
  
  public boolean cN(long paramLong) {
    sQLiteDatabase = Vq();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    stringBuilder1 = sQLiteDatabase.rawQuery("SELECT sSpareField1 FROM T_PRODUCT WHERE _id = ? and nShopID = ?", new String[] { stringBuilder.toString(), VC() });
    if (!stringBuilder1.moveToFirst()) {
      SQLiteDatabase sQLiteDatabase;
      StringBuilder stringBuilder1;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("product with id ");
      stringBuilder1.append(paramLong);
      stringBuilder1.append(" not found");
      throw new RuntimeException(stringBuilder1.toString());
    } 
    str = stringBuilder1.getString(0);
    if (TextUtils.isEmpty(str))
      return false; 
    try {
      return (new JSONObject(str)).optBoolean("isShowingAttributeForCustomer", false);
    } catch (JSONException str) {
      throw new RuntimeException(str);
    } 
  }
  
  public int cO(long paramLong) {
    hY("max(nSpareField4)");
    null = VC();
    int i = 0;
    byte b = 0;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    c("nShopID=? and nProductType=? and (nProductStatus=600001 or nProductStatus=600002) and (nFoodCategory=0 or nFoodCategory=2)", new String[] { null, stringBuilder.toString() });
    Cursor cursor = VM();
    if (cursor != null) {
      i = b;
      if (cursor.moveToNext())
        i = cursor.getInt(0); 
      cursor.close();
    } 
    return i;
  }
  
  public ArrayList<m> cP(long paramLong) {
    str = cQ(paramLong);
    if (str != null) {
      if (str.length() == 0)
        return null; 
      try {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (byte b = 0; b < jSONArray.length(); b++) {
          JSONObject jSONObject = (JSONObject)jSONArray.get(b);
          arrayList.add(new m(jSONObject.optLong("nProductID"), jSONObject.optString("sProductName"), 0.0D, 0.0D, jSONObject.optLong("nProductUnit"), jSONObject.optString("sProductUnitName"), jSONObject.optDouble("fQuantity")));
        } 
        return arrayList;
      } catch (Throwable str) {
        a.e(str);
        return null;
      } 
    } 
    return null;
  }
  
  public boolean cR(long paramLong) {
    am("nProductStatus", "600003");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("_id=? and nShopID=?", new String[] { stringBuilder.toString(), VC() });
    VS();
    return update();
  }
  
  public void f(long paramLong, boolean paramBoolean) throws RuntimeException { // Byte code:
    //   0: aload_0
    //   1: invokevirtual Vq : ()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore #4
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #5
    //   15: aload #5
    //   17: lload_1
    //   18: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload #5
    //   24: ldc ''
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #4
    //   32: ldc_w 'SELECT sSpareField1 FROM T_PRODUCT WHERE _id = ? and nShopID = ?'
    //   35: iconst_2
    //   36: anewarray java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload #5
    //   43: invokevirtual toString : ()Ljava/lang/String;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: invokevirtual VC : ()Ljava/lang/String;
    //   53: aastore
    //   54: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore #4
    //   59: aload #4
    //   61: invokeinterface moveToFirst : ()Z
    //   66: ifne -> 116
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore #4
    //   78: aload #4
    //   80: ldc_w 'product with id '
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #4
    //   89: lload_1
    //   90: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload #4
    //   96: ldc_w ' not found'
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new java/lang/RuntimeException
    //   106: dup
    //   107: aload #4
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokespecial <init> : (Ljava/lang/String;)V
    //   115: athrow
    //   116: aload #4
    //   118: iconst_0
    //   119: invokeinterface getString : (I)Ljava/lang/String;
    //   124: astore #4
    //   126: aload #4
    //   128: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   131: ifeq -> 146
    //   134: new org/json/JSONObject
    //   137: dup
    //   138: invokespecial <init> : ()V
    //   141: astore #4
    //   143: goto -> 157
    //   146: new org/json/JSONObject
    //   149: dup
    //   150: aload #4
    //   152: invokespecial <init> : (Ljava/lang/String;)V
    //   155: astore #4
    //   157: aload #4
    //   159: ldc_w 'isShowingAttributeForCustomer'
    //   162: iload_3
    //   163: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_0
    //   168: ldc_w 'sSpareField1'
    //   171: aload #4
    //   173: invokevirtual toString : ()Ljava/lang/String;
    //   176: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   179: pop
    //   180: aload_0
    //   181: lload_1
    //   182: invokevirtual cK : (J)Z
    //   185: ifne -> 199
    //   188: new java/lang/RuntimeException
    //   191: dup
    //   192: ldc_w 'update failed'
    //   195: invokespecial <init> : (Ljava/lang/String;)V
    //   198: athrow
    //   199: return
    //   200: astore #4
    //   202: new java/lang/RuntimeException
    //   205: dup
    //   206: aload #4
    //   208: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   211: athrow
    //   212: astore #4
    //   214: new java/lang/RuntimeException
    //   217: dup
    //   218: aload #4
    //   220: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   223: athrow
    // Exception table:
    //   from	to	target	type
    //   146	157	212	org/json/JSONException
    //   157	199	200	org/json/JSONException }
  
  public boolean g(long paramLong, double paramDouble) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    am("fSpareField1", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("_id=? and nShopID=?", new String[] { stringBuilder.toString(), VC() });
    return update();
  }
  
  public boolean g(h paramh) {
    paramh.akL();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramh.status);
    stringBuilder1.append("");
    am("nProductStatus", stringBuilder1.toString());
    String str = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramh.aSW);
    stringBuilder2.append("");
    d("nShopID=? and _id=?", new String[] { str, stringBuilder2.toString() });
    boolean bool = update();
    if (!bool)
      paramh.akL(); 
    return bool;
  }
  
  public ArrayList<a> gr(boolean paramBoolean) {
    ArrayList arrayList = new ArrayList();
    hY("_id,sProductName,fSalePrice,nProductStatus,nProductType,fDiscountSalePrice,sSpareField3,sSpareField5");
    null = new StringBuilder();
    null.append("nFoodCategory=2 and (nProductStatus=600001 or nProductStatus=600002) and nShopID=");
    null.append(VC());
    hZ(null.toString());
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(new a(cursor.getLong(0), cursor.getString(1), cursor.getString(7), cursor.getDouble(2), cursor.getInt(3), cursor.getInt(4), cursor.getDouble(5), cursor.getString(6))); 
    cursor.close();
    return arrayList;
  }
  
  public boolean j(long... paramVarArgs) {
    beginTransaction();
    boolean bool = true;
    for (byte b = 0; b < paramVarArgs.length; b++) {
      bool = cJ(paramVarArgs[b]);
      if (!bool)
        break; 
    } 
    if (bool)
      setTransactionSuccessful(); 
    endTransaction();
    return bool;
  }
  
  public boolean mC(String paramString) {
    hY("count(*)");
    Cursor cursor = hL(paramString);
    cursor.moveToFirst();
    boolean bool = false;
    if (cursor.getInt(0) > 0)
      bool = true; 
    cursor.close();
    return bool;
  }
  
  public String mD(String paramString) { return cL(Long.parseLong(paramString)); }
  
  public h mE(String paramString) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    ArrayList arrayList = a("T_PRODUCT.nShopID=? and T_PRODUCT._id=? and (T_PRODUCT.nProductStatus=600001 or T_PRODUCT.nProductStatus=600002) and (T_PRODUCT.nFoodCategory=0 or T_PRODUCT.nFoodCategory=2)", new String[] { str, stringBuilder.toString() }, null);
    return (arrayList != null && arrayList.size() > 0) ? (h)arrayList.get(0) : null;
  }
  
  public h mF(String paramString) {
    hY("_id,sProductName,fSalePrice,nStockQty,nProductStatus,nProductType,sProductNumber,fDiscountSalePrice,sSpareField5");
    c("nShopID=? and sProductNumber=? and nProductStatus=600001 and nFoodCategory=0 ", new String[] { VC(), paramString });
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      h h = new h(cursor.getLong(0), cursor.getString(1), cursor.getString(8), cursor.getDouble(2), cursor.getDouble(3), cursor.getInt(4), cursor.getLong(5), cursor.getString(6), cursor.getDouble(7), "", 0.0D);
    } else {
      paramString = null;
    } 
    cursor.close();
    return paramString;
  }
  
  public m mG(String paramString) {
    null = new StringBuilder();
    null.append("select t_product._id,t_product.sProductName,t_product.nStockQty,t_product.fSpareField1");
    null.append(",t_product.nProductUnit,t_string.sFieldName");
    null.append(" from t_product ");
    null.append(" left join t_string on t_string.nFieldType=4 and t_string._id=t_product.nProductUnit ");
    null.append(" where t_product._id=");
    null.append(paramString);
    null.append(" and t_product.nFoodCategory=1 and t_product.nProductStatus=600001 ");
    null.append(" and t_product.nShopID=");
    null.append(VC());
    Cursor cursor = Vq().rawQuery(null.toString(), null);
    if (cursor.moveToFirst()) {
      m m = new m(cursor.getLong(0), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3), cursor.getLong(4), cursor.getString(5));
    } else {
      paramString = null;
    } 
    cursor.close();
    return paramString;
  }
  
  public boolean r(int paramInt, String paramString) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("");
    d(" (nFoodCategory=0 or nFoodCategory=2) and (nProductStatus=600001 or nProductStatus=600002) and _id=? and nShopID=?", new String[] { stringBuilder2.toString(), VC() });
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    am("nSpareField4", stringBuilder1.toString());
    am("nIsUpdated", "0");
    return update();
  }
  
  public ArrayList<HashMap<String, String>> v(String paramString, boolean paramBoolean) {
    String str;
    ArrayList arrayList = new ArrayList();
    hY("_id,sProductName,fSalePrice,nProductType,nStockQty,nSpareField1,sSpareField1,sProductNumber,fDiscountSalePrice,sSpareField5,sProductDescription,fBuyPrice,nSpareField3,fStockPrice");
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i == 1 || i == 2) {
      av av1 = new av(this.mContext);
      str = av1.Bh();
      av1.close();
    } else {
      str = a.AZ().Bh();
    } 
    ia(str);
    Cursor cursor = k(paramString, paramBoolean);
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      long l = cursor.getLong(0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("");
      hashMap.put("id", stringBuilder.toString());
      hashMap.put("name", cursor.getString(1));
      hashMap.put("name2", cursor.getString(9));
      hashMap.put("price", n.b(this.mContext, Double.valueOf(cursor.getDouble(2)), true));
      hashMap.put("typeID", cursor.getString(3));
      hashMap.put("qty", n.b(this.mContext, Double.valueOf(cursor.getDouble(4)), false));
      hashMap.put("nSpareField1", cursor.getString(5));
      hashMap.put("sSpareField1", cursor.getString(6));
      hashMap.put("sProductNumber", cursor.getString(7));
      hashMap.put("memberPrice", n.b(this.mContext, Double.valueOf(cursor.getDouble(8)), true));
      hashMap.put("sProductDescription", cursor.getString(10));
      hashMap.put("fBuyPrice", cursor.getString(11));
      hashMap.put("scaleCode", cursor.getString(12));
      hashMap.put("fStockPrice", cursor.getString(13));
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
  
  public boolean w(String paramString, boolean paramBoolean) {
    null = VC();
    hY("_id,sProductName,nStockQty");
    c("nShopID=? and nProductType = ? and (nProductStatus=600001 or nProductStatus=600002)", new String[] { null, paramString });
    Cursor cursor = VM();
    boolean bool = true;
    while (cursor.moveToNext()) {
      long l = cursor.getLong(0);
      paramString = cursor.getString(1);
      double d = cursor.getDouble(2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("");
      am("_id", stringBuilder.toString());
      am("sProductName", paramString);
      if (paramBoolean) {
        paramString = "9999";
      } else {
        paramString = "0";
      } 
      am("nStockQty", paramString);
      boolean bool1 = f(l, d);
      bool = bool1;
      if (!bool1) {
        bool = bool1;
        break;
      } 
    } 
    cursor.close();
    return bool;
  }
  
  @NonNull
  public ArrayList<h> x(@NonNull String paramString, boolean paramBoolean) {
    String[] arrayOfString;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(nProductStatus=600001 or nProductStatus=600002) ");
    stringBuilder.append(" and (nFoodCategory=0 or nFoodCategory=2) and T_PRODUCT.nShopID= ");
    stringBuilder.append(VC());
    if (paramString.length() > 0) {
      stringBuilder.append(" and (T_PRODUCT.sSpareField2 like ? or T_PRODUCT.sSpareField4 like ? ");
      arrayOfString = new StringBuilder();
      arrayOfString.append("%");
      arrayOfString.append(paramString);
      arrayOfString.append("%");
      String str = arrayOfString.toString();
      if (paramBoolean) {
        stringBuilder.append(" or T_PRODUCT.sProductNumber like ?");
        paramString = "(T_PRODUCT.sProductNumber like ?)/(length(T_PRODUCT.sProductNumber)+1.0) desc,(T_PRODUCT.sSpareField2 like ?)/(length(T_PRODUCT.sSpareField2)+1.0) desc,(T_PRODUCT.sSpareField4 like ?)/(length(T_PRODUCT.sSpareField4)+1.0) desc";
        String[] arrayOfString1 = new String[6];
        arrayOfString1[0] = str;
        arrayOfString1[1] = str;
        arrayOfString1[2] = str;
        arrayOfString1[3] = str;
        arrayOfString1[4] = str;
        arrayOfString1[5] = str;
      } else {
        paramString = "(T_PRODUCT.sSpareField2 like ?)/(length(T_PRODUCT.sSpareField2)+1.0) desc,(T_PRODUCT.sSpareField4 like ?)/(length(T_PRODUCT.sSpareField4)+1.0) desc";
        String[] arrayOfString1 = new String[4];
        arrayOfString1[0] = str;
        arrayOfString1[1] = str;
        arrayOfString1[2] = str;
        arrayOfString1[3] = str;
      } 
      stringBuilder.append(")");
    } else {
      arrayOfString = null;
      paramString = "T_PRODUCT.nUpdateFlag desc,T_PRODUCT.sText";
    } 
    return a(stringBuilder.toString(), arrayOfString, paramString);
  }
  
  public boolean xH() {
    StringBuilder stringBuilder;
    try {
      beginTransaction();
      boolean bool = QL();
      if (!bool) {
        endTransaction();
        return false;
      } 
      bool = aK(0.0D);
      if (!bool) {
        endTransaction();
        return false;
      } 
      setTransactionSuccessful();
      endTransaction();
      return true;
    } catch (Exception null) {
      a.e(stringBuilder);
      endTransaction();
      return false;
    } finally {}
    endTransaction();
    throw stringBuilder;
  }
  
  public boolean y(long paramLong, String paramString) {
    str = br(paramLong);
    try {
      JSONObject jSONObject1 = new JSONObject(str);
      try {
        if (jSONObject1.has("default"))
          jSONObject1.remove("default"); 
        jSONObject1.put("default", paramString);
      } catch (JSONException|Exception jSONException) {}
    } catch (JSONException|Exception str) {
      str = null;
    } 
    JSONObject jSONObject = str;
    if (str == null) {
      jSONObject = new JSONObject();
      try {
        jSONObject.put("default", paramString);
      } catch (JSONException paramString) {}
    } 
    return a(paramLong, jSONObject);
  }
  
  public boolean z(long paramLong, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    am("nSpareField1", paramString);
    return cK(paramLong);
  }
  
  public static class a extends Thread {
    private Context mContext;
    
    private String productID;
    
    public a(Context param1Context, String param1String) {
      this.mContext = param1Context;
      this.productID = param1String;
    }
    
    public void run() {
      super.run();
      a1 = new OnlineSyncRequest.a();
      null = new ab(this.mContext);
      ArrayList arrayList = null.gZ(this.productID);
      Iterator iterator = arrayList.iterator();
      while (iterator.hasNext())
        ((ab.a)iterator.next()).a(ab.bQa).setValue(Double.valueOf(0.0D)); 
      a1.a(arrayList, 1);
      x x = new x(this.mContext);
      a1.a(x.hE(this.productID), 1);
      a1.iM(RootApplication.getLaiqianPreferenceManager().Ea());
      a1.iN(RootApplication.getLaiqianPreferenceManager().atr());
      a1.bV(Long.parseLong(RootApplication.getLaiqianPreferenceManager().Tx()));
      null.close();
      x.close();
      f f = f.bXQ;
      try {
        f.a(a1.Xj());
        return;
      } catch (Exception a1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请求实时同步失败");
        stringBuilder.append(a1.getMessage());
        n.println(stringBuilder.toString());
        a.e(a1);
        return;
      } 
    }
  }
  
  public enum b {
    cUA("sText"),
    cUB("sText desc"),
    cUC("nStockQty"),
    cUD("nStockQty desc"),
    cUE("fSpareField1"),
    cUF("fSpareField1 desc"),
    cUG("nProductUnit"),
    cUH("nProductUnit desc");
    
    private final String bwe;
    
    b(String param1String1) { this.bwe = param1String1; }
    
    private String akB() { return this.bwe; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */