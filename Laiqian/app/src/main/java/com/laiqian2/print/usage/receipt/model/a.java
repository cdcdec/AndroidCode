package com.laiqian.print.usage.receipt.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.z;
import com.laiqian.main.fg;
import com.laiqian.models.an;
import com.laiqian.models.bh;
import com.laiqian.models.n;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.AliPayPreorderDetail;
import com.laiqian.pos.bm;
import com.laiqian.pos.industry.weiorder.eh;
import com.laiqian.pos.model.orders.WeiOrderDetail;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.b.a;
import com.laiqian.print.b.b;
import com.laiqian.print.b.d;
import com.laiqian.print.b.e;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.b;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;
import com.laiqian.print.util.e;
import com.laiqian.product.models.o;
import com.laiqian.product.models.p;
import com.laiqian.util.am;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
public class a {
  private static a cND;
  
  private g cDD;
  
  private c cDE;
  
  private SimpleDateFormat cJp;
  
  private int cMB = 0;
  
  private Context context;
  
  private a(Context paramContext) {
    this.context = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.context);
  }
  
  private void a(WeiOrderDetail paramWeiOrderDetail, g paramg) {
    int i = paramg.getSize();
    if (paramWeiOrderDetail.aVU == 10001L) {
      System.out.println("print secondPayType is PAYTYPE_CASH");
      paramg.setSize(3);
    } 
    if (paramWeiOrderDetail.aVU != this.cMB)
      a(paramg, fg.ao(paramWeiOrderDetail.aVU), paramWeiOrderDetail.aVV); 
    paramg.setSize(i);
  }
  
  private boolean a(a parama, Date paramDate, String paramString) {
    String str1;
    if (parama == null)
      return false; 
    if (paramDate == null)
      return false; 
    g g1 = new g(parama);
    g1.n(new int[] { 3, 2 });
    if (!n.bL(this.context)) {
      str2 = Xn().format(paramDate);
      if (paramString != null) {
        str1 = iP(paramString);
      } else {
        String str;
        str1 = "";
      } 
      g1.x(new String[] { str2, str1 });
      return true;
    } 
    String str2 = Xn().format(str2);
    if (paramString != null) {
      str1 = iP(paramString);
    } else {
      str1 = "";
    } 
    g1.x(new String[] { str2, str1 });
    return true;
  }
  
  private boolean a(e parame, double paramDouble) {
    parame.x(new String[] { this.context.getString(2131628784), n.a(Double.valueOf(paramDouble), false, false) });
    return true;
  }
  
  private boolean a(e parame, int paramInt) {
    for (byte b = 0; b < paramInt; b++)
      parame.afT().ln(""); 
    return true;
  }
  
  private boolean a(e parame, int paramInt, Double paramDouble) {
    if (paramDouble == null)
      return false; 
    parame.x(new String[] { this.context.getString(paramInt), n.a(paramDouble, true, false) });
    return true;
  }
  
  private boolean a(e parame, int paramInt, String paramString) { return a(parame, paramInt, paramString, null); }
  
  private boolean a(e parame, int paramInt, String paramString1, String paramString2) { // Byte code:
    //   0: iload_2
    //   1: ifne -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: iload_2
    //   7: iconst_2
    //   8: if_icmpne -> 20
    //   11: aload_0
    //   12: aload_1
    //   13: aload_3
    //   14: aload #4
    //   16: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/String;)Z
    //   19: ireturn
    //   20: iload_2
    //   21: iconst_1
    //   22: if_icmpne -> 84
    //   25: aload_0
    //   26: getfield context : Landroid/content/Context;
    //   29: invokestatic aR : (Landroid/content/Context;)Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull -> 84
    //   37: new java/io/File
    //   40: dup
    //   41: aload_3
    //   42: invokespecial <init> : (Ljava/lang/String;)V
    //   45: astore_3
    //   46: aload_3
    //   47: invokevirtual exists : ()Z
    //   50: ifeq -> 84
    //   53: new java/io/FileInputStream
    //   56: dup
    //   57: aload_3
    //   58: invokespecial <init> : (Ljava/io/File;)V
    //   61: astore #5
    //   63: aload #5
    //   65: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   68: astore_3
    //   69: aload #5
    //   71: invokevirtual close : ()V
    //   74: goto -> 86
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic e : (Ljava/lang/Throwable;)V
    //   82: iconst_0
    //   83: ireturn
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_3
    //   87: ifnonnull -> 92
    //   90: iconst_0
    //   91: ireturn
    //   92: aload_1
    //   93: invokeinterface afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   98: aload_3
    //   99: iconst_1
    //   100: invokevirtual a : (Landroid/graphics/Bitmap;I)Lcom/laiqian/print/model/PrintContent$a;
    //   103: pop
    //   104: aload #4
    //   106: ifnull -> 119
    //   109: aload_1
    //   110: aload #4
    //   112: iconst_0
    //   113: iconst_1
    //   114: invokeinterface f : (Ljava/lang/String;II)V
    //   119: iconst_1
    //   120: ireturn
    // Exception table:
    //   from	to	target	type
    //   53	74	77	java/io/IOException }
  
  private boolean a(e parame, Bitmap paramBitmap, String paramString) {
    if (paramBitmap == null)
      return false; 
    parame.afT().a(paramBitmap, 1);
    if (paramString != null)
      parame.f(paramString, 0, 1); 
    return true;
  }
  
  private boolean a(e parame, eh parameh) {
    if (parameh != null) {
      parame.x(new String[] { String.format(this.context.getString(2131630537), new Object[] { n.a(Double.valueOf(parameh.abM()), true, false, parame.afU()), n.a(Double.valueOf(parameh.FI()), true, false, parame.afU()) }), n.a(Double.valueOf(-parameh.FI()), true, false, parame.afU()) });
      return true;
    } 
    return false;
  }
  
  private boolean a(e parame, Double paramDouble) { return a(parame, paramDouble, false); }
  
  private boolean a(e parame, Double paramDouble1, Double paramDouble2, boolean paramBoolean, ArrayList<HashMap<String, Object>> paramArrayList) {
    String str;
    boolean bool = bm.a(paramDouble1.doubleValue(), 0.0D, 6);
    byte b = 0;
    if (bool)
      return false; 
    paramDouble2.doubleValue();
    paramDouble1.doubleValue();
    while (b < paramArrayList.size()) {
      HashMap hashMap = (HashMap)paramArrayList.get(b);
      if (hashMap.containsKey("noDiscount") && ((Boolean)hashMap.get("noDiscount")).booleanValue()) {
        Double.parseDouble((String)hashMap.get("fPrice"));
        Double.parseDouble((String)hashMap.get("nProductQty"));
        if (hashMap.containsKey("fOriginalPrice"))
          Double.parseDouble((String)hashMap.get("fOriginalPrice")); 
        if (hashMap.containsKey("selectTastesPrice"))
          ((Double)hashMap.get("selectTastesPrice")).doubleValue(); 
      } 
      b++;
    } 
    if (this.context.getResources().getBoolean(2131034121)) {
      if (a.zR().Ab()) {
        double d;
        str = this.context.getString(2131628743);
        if (paramBoolean) {
          d = paramDouble2.doubleValue();
        } else {
          d = -paramDouble2.doubleValue();
        } 
        a(parame, str, Double.valueOf(d));
      } else {
        double d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.context.getString(2131628743));
        stringBuilder.append((int)(100L - Math.round(str.doubleValue())));
        stringBuilder.append("%");
        str = stringBuilder.toString();
        if (paramBoolean) {
          d = paramDouble2.doubleValue();
        } else {
          d = -paramDouble2.doubleValue();
        } 
        a(parame, str, Double.valueOf(d));
      } 
    } else {
      double d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.context.getString(2131628743));
      stringBuilder.append((int)Math.round(str.doubleValue()));
      stringBuilder.append("%");
      str = stringBuilder.toString();
      if (paramBoolean) {
        d = paramDouble2.doubleValue();
      } else {
        d = -paramDouble2.doubleValue();
      } 
      a(parame, str, Double.valueOf(d));
    } 
    return true;
  }
  
  private boolean a(e parame, Double paramDouble, boolean paramBoolean) {
    double d;
    if (paramDouble == null)
      return false; 
    d d1 = new d(parame.afT());
    d1.setWidth(parame.getWidth());
    d1.ic(parame.afU());
    d1.setSize(3);
    if (paramBoolean) {
      d = -paramDouble.doubleValue();
    } else {
      d = paramDouble.doubleValue();
    } 
    String str = n.a(Double.valueOf(d), true, false);
    int j = str.length();
    int i = 2131628729;
    if (j >= 7) {
      if (paramBoolean) {
        d1.x(new String[] { this.context.getString(2131628730) });
      } else {
        d1.x(new String[] { this.context.getString(2131628729) });
      } 
      d1.o(new int[] { 2 });
      d1.x(new String[] { str });
      return true;
    } 
    if (paramBoolean)
      i = 2131628730; 
    if (paramBoolean) {
      d = -paramDouble.doubleValue();
    } else {
      d = paramDouble.doubleValue();
    } 
    return a(d1, i, Double.valueOf(d));
  }
  
  private boolean a(e parame, Double paramDouble, boolean paramBoolean, ArrayList<HashMap<String, Object>> paramArrayList) {
    Double double;
    if (paramDouble == null)
      return false; 
    byte b = 0;
    double d3 = 0.0D;
    double d1 = 0.0D;
    while (b < paramArrayList.size()) {
      double d5;
      HashMap hashMap = (HashMap)paramArrayList.get(b);
      double d6 = Double.parseDouble((String)hashMap.get("fPrice"));
      double d7 = Double.parseDouble((String)hashMap.get("nProductQty"));
      if (hashMap.containsKey("fOriginalPrice")) {
        d5 = Double.parseDouble((String)hashMap.get("fOriginalPrice"));
      } else {
        d5 = d6;
      } 
      double d4 = d3;
      if (!n.bc(d5 - d6))
        d4 = d3 + d7 * d5; 
      d3 = d5;
      if (hashMap.containsKey("selectTastesPrice"))
        d3 = d5 + ((Double)hashMap.get("selectTastesPrice")).doubleValue(); 
      if (hashMap.containsKey("taxList") && hashMap.get("taxList") != null) {
        Iterator iterator = ((ArrayList)hashMap.get("taxList")).iterator();
        d5 = 0.0D;
        while (iterator.hasNext()) {
          o o = (o)iterator.next();
          if (o.alc() == 1) {
            d5 += o.ala();
            continue;
          } 
          o.ala();
        } 
        d3 = d7 * d3 / (d5 / 100.0D + 1.0D);
        d1 += d3;
      } else {
        d3 = d7 * d3;
        d1 = Double.parseDouble(n.a(Double.valueOf(d1 + d3), true, false));
      } 
      if (!hashMap.containsKey("noDiscount") || !((Boolean)hashMap.get("noDiscount")).booleanValue())
        d4 += d3; 
      b++;
      d3 = d4;
    } 
    if (this.context.getResources().getBoolean(2131034121)) {
      double = Double.valueOf(100.0D - paramDouble.doubleValue());
    } else {
      double = paramDouble;
    } 
    double d2 = Double.parseDouble(n.a(Double.valueOf(d3 * (100.0D - paramDouble.doubleValue()) / 100.0D), true, false));
    if (!n.bc(d2)) {
      String str2 = this.context.getString(2131628403);
      d3 = d1;
      if (paramBoolean)
        d3 = -d1; 
      a(parame, str2, Double.valueOf(d3));
      if (a.zR().Ab()) {
        str2 = this.context.getString(2131628743);
        if (!paramBoolean)
          d2 = -d2; 
        a(parame, str2, Double.valueOf(d2));
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.context.getString(2131628743));
      stringBuilder.append((int)Math.round(double.doubleValue()));
      stringBuilder.append("%");
      String str1 = stringBuilder.toString();
      if (!paramBoolean)
        d2 = -d2; 
      a(parame, str1, Double.valueOf(d2));
      return true;
    } 
    return false;
  }
  
  private boolean a(e parame, Long paramLong) {
    parame.lk(String.format("%s %d", new Object[] { this.context.getString(2131628779), paramLong }));
    return true;
  }
  
  private boolean a(e parame, String paramString) {
    parame.lk(String.format("%s %s", new Object[] { this.context.getString(2131628305), paramString }));
    return true;
  }
  
  private boolean a(e parame, String paramString, Number paramNumber) {
    if (paramNumber == null)
      return false; 
    if (paramNumber instanceof Double) {
      parame.x(new String[] { paramString, n.a(paramNumber, true, false) });
      return true;
    } 
    parame.x(new String[] { paramString, paramNumber.toString() });
    return true;
  }
  
  private boolean a(e parame, String paramString1, String paramString2) {
    if (paramString1 == null)
      return false; 
    PrintContent.a a1 = parame.afT();
    try {
      Bitmap bitmap = am.qs(paramString1);
    } catch (Exception paramString1) {
      try {
        a.e(paramString1);
        paramString1 = null;
      } catch (Exception parame) {
        a.e(parame);
        return false;
      } 
    } 
    if (paramString1 == null)
      return false; 
    a1.a(paramString1, 1);
    if (!TextUtils.isEmpty(paramString2))
      parame.f(paramString2, 0, 1); 
    return true;
  }
  
  private boolean a(e parame, String paramString, Date paramDate) {
    g g1 = new g(parame.afT());
    g1.setWidth(parame.getWidth());
    g1.ic(parame.afU());
    g1.n(new int[] { 10, 22 });
    g1.x(new String[] { paramString, Xn().format(paramDate) });
    return true;
  }
  
  private boolean a(e parame, ArrayList<HashMap<String, Object>> paramArrayList) {
    Iterator iterator = paramArrayList.iterator();
    double d = 0.0D;
    while (iterator.hasNext()) {
      HashMap hashMap = (HashMap)iterator.next();
      if (hashMap.containsKey("fMemberPriceDiscount") && hashMap.get("fMemberPriceDiscount") != null)
        d += ((Double)hashMap.get("fMemberPriceDiscount")).doubleValue() * Double.parseDouble(hashMap.get("nProductQty").toString()); 
    } 
    return !n.bc(d) ? a(parame, this.context.getString(2131628748), Double.valueOf(d)) : 0;
  }
  
  private boolean a(e parame, @NonNull ArrayList<HashMap<String, Object>> paramArrayList, b paramb, int paramInt, boolean paramBoolean, ReceiptPrintSettings paramReceiptPrintSettings) { // Byte code:
    //   0: new com/laiqian/print/b/b
    //   3: dup
    //   4: aload_1
    //   5: checkcast com/laiqian/print/b/a
    //   8: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   11: astore #23
    //   13: aload #23
    //   15: invokevirtual afW : ()V
    //   18: aload_0
    //   19: getfield context : Landroid/content/Context;
    //   22: ldc_w 2131628771
    //   25: invokevirtual getString : (I)Ljava/lang/String;
    //   28: astore_1
    //   29: aload #6
    //   31: getfield cNJ : I
    //   34: aload #6
    //   36: invokevirtual aiM : ()I
    //   39: if_icmpne -> 53
    //   42: aload_0
    //   43: getfield context : Landroid/content/Context;
    //   46: ldc_w 2131629532
    //   49: invokevirtual getString : (I)Ljava/lang/String;
    //   52: astore_1
    //   53: aload #6
    //   55: invokevirtual aiN : ()Z
    //   58: ifne -> 103
    //   61: aload #23
    //   63: iconst_3
    //   64: anewarray java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield context : Landroid/content/Context;
    //   73: ldc_w 2131628769
    //   76: invokevirtual getString : (I)Ljava/lang/String;
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_1
    //   83: aastore
    //   84: dup
    //   85: iconst_2
    //   86: aload_0
    //   87: getfield context : Landroid/content/Context;
    //   90: ldc_w 2131628783
    //   93: invokevirtual getString : (I)Ljava/lang/String;
    //   96: aastore
    //   97: invokevirtual x : ([Ljava/lang/String;)V
    //   100: goto -> 155
    //   103: aload #23
    //   105: iconst_4
    //   106: anewarray java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: aload_0
    //   112: getfield context : Landroid/content/Context;
    //   115: ldc_w 2131628769
    //   118: invokevirtual getString : (I)Ljava/lang/String;
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload_1
    //   125: aastore
    //   126: dup
    //   127: iconst_2
    //   128: aload_0
    //   129: getfield context : Landroid/content/Context;
    //   132: ldc_w 2131629243
    //   135: invokevirtual getString : (I)Ljava/lang/String;
    //   138: aastore
    //   139: dup
    //   140: iconst_3
    //   141: aload_0
    //   142: getfield context : Landroid/content/Context;
    //   145: ldc_w 2131628783
    //   148: invokevirtual getString : (I)Ljava/lang/String;
    //   151: aastore
    //   152: invokevirtual x : ([Ljava/lang/String;)V
    //   155: aload #23
    //   157: bipush #45
    //   159: invokevirtual l : (C)V
    //   162: aload #23
    //   164: invokevirtual getSize : ()I
    //   167: istore #16
    //   169: aload #23
    //   171: iload #4
    //   173: invokevirtual setSize : (I)V
    //   176: ldc ''
    //   178: astore #20
    //   180: aload_3
    //   181: getfield aWa : Z
    //   184: ifeq -> 192
    //   187: ldc_w '-'
    //   190: astore #20
    //   192: aload_2
    //   193: invokevirtual size : ()I
    //   196: istore #17
    //   198: iconst_0
    //   199: istore #15
    //   201: iload #16
    //   203: istore #4
    //   205: iload #15
    //   207: iload #17
    //   209: iconst_2
    //   210: imul
    //   211: if_icmpge -> 1608
    //   214: iload #15
    //   216: iload #17
    //   218: if_icmplt -> 231
    //   221: iload #15
    //   223: iload #17
    //   225: isub
    //   226: istore #16
    //   228: goto -> 235
    //   231: iload #15
    //   233: istore #16
    //   235: aload_2
    //   236: iload #16
    //   238: invokevirtual get : (I)Ljava/lang/Object;
    //   241: checkcast java/util/HashMap
    //   244: astore #24
    //   246: aload #24
    //   248: ldc_w 'nProductQty'
    //   251: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   254: invokevirtual toString : ()Ljava/lang/String;
    //   257: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   260: invokevirtual doubleValue : ()D
    //   263: dstore #11
    //   265: iload #15
    //   267: iload #17
    //   269: if_icmpge -> 286
    //   272: dload #11
    //   274: dconst_0
    //   275: dcmpg
    //   276: ifge -> 296
    //   279: iload #4
    //   281: istore #16
    //   283: goto -> 1595
    //   286: dload #11
    //   288: dconst_0
    //   289: dcmpl
    //   290: ifle -> 296
    //   293: goto -> 279
    //   296: aload #24
    //   298: ldc_w 'taste'
    //   301: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   304: istore #18
    //   306: aconst_null
    //   307: astore #22
    //   309: iload #18
    //   311: ifeq -> 330
    //   314: aload #24
    //   316: ldc_w 'taste'
    //   319: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast java/lang/String
    //   325: astore #21
    //   327: goto -> 333
    //   330: aconst_null
    //   331: astore #21
    //   333: aload #24
    //   335: ldc_w 'sProductName'
    //   338: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   341: checkcast java/lang/String
    //   344: astore #19
    //   346: aload #24
    //   348: ldc_w 'nFoodCategory'
    //   351: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   354: ifeq -> 423
    //   357: aload #19
    //   359: astore_1
    //   360: aload #24
    //   362: ldc_w 'nFoodCategory'
    //   365: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   368: iconst_3
    //   369: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   372: invokevirtual equals : (Ljava/lang/Object;)Z
    //   375: ifeq -> 426
    //   378: aload #19
    //   380: astore_1
    //   381: aload #19
    //   383: ldc_w '|-'
    //   386: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   389: ifne -> 426
    //   392: new java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial <init> : ()V
    //   399: astore_1
    //   400: aload_1
    //   401: ldc_w '|-'
    //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_1
    //   409: aload #19
    //   411: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_1
    //   416: invokevirtual toString : ()Ljava/lang/String;
    //   419: astore_1
    //   420: goto -> 426
    //   423: aload #19
    //   425: astore_1
    //   426: aload_1
    //   427: astore #19
    //   429: aload #21
    //   431: ifnull -> 469
    //   434: aload_1
    //   435: astore #19
    //   437: aload #21
    //   439: invokevirtual trim : ()Ljava/lang/String;
    //   442: invokevirtual isEmpty : ()Z
    //   445: ifne -> 469
    //   448: ldc_w '%s[%s]'
    //   451: iconst_2
    //   452: anewarray java/lang/Object
    //   455: dup
    //   456: iconst_0
    //   457: aload_1
    //   458: aastore
    //   459: dup
    //   460: iconst_1
    //   461: aload #21
    //   463: aastore
    //   464: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   467: astore #19
    //   469: aload #19
    //   471: astore_1
    //   472: iload #5
    //   474: ifeq -> 595
    //   477: aload #19
    //   479: astore_1
    //   480: aload #24
    //   482: ldc 'noDiscount'
    //   484: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   487: ifeq -> 595
    //   490: aload #19
    //   492: astore_1
    //   493: aload #24
    //   495: ldc 'noDiscount'
    //   497: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   500: checkcast java/lang/Boolean
    //   503: invokevirtual booleanValue : ()Z
    //   506: ifeq -> 595
    //   509: aload #24
    //   511: ldc_w 'nFoodCategory'
    //   514: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   517: ifeq -> 544
    //   520: aload #24
    //   522: ldc_w 'nFoodCategory'
    //   525: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   528: iconst_3
    //   529: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   532: invokevirtual equals : (Ljava/lang/Object;)Z
    //   535: ifeq -> 544
    //   538: aload #19
    //   540: astore_1
    //   541: goto -> 595
    //   544: new java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial <init> : ()V
    //   551: astore_1
    //   552: aload_1
    //   553: aload #19
    //   555: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload_1
    //   560: ldc_w '<'
    //   563: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload_1
    //   568: aload_0
    //   569: getfield context : Landroid/content/Context;
    //   572: ldc_w 2131628754
    //   575: invokevirtual getString : (I)Ljava/lang/String;
    //   578: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload_1
    //   583: ldc_w '>'
    //   586: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload_1
    //   591: invokevirtual toString : ()Ljava/lang/String;
    //   594: astore_1
    //   595: new java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial <init> : ()V
    //   602: astore #19
    //   604: aload #19
    //   606: aload #24
    //   608: ldc_w 'isProductPack'
    //   611: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   614: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload #19
    //   620: ldc ''
    //   622: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload #19
    //   628: invokevirtual toString : ()Ljava/lang/String;
    //   631: invokestatic se : (Ljava/lang/String;)Z
    //   634: istore #18
    //   636: aload_3
    //   637: getfield aTZ : Z
    //   640: ifne -> 654
    //   643: iload #18
    //   645: ifeq -> 654
    //   648: iconst_1
    //   649: istore #16
    //   651: goto -> 657
    //   654: iconst_0
    //   655: istore #16
    //   657: aload_1
    //   658: astore #19
    //   660: iload #16
    //   662: ifeq -> 803
    //   665: aload_0
    //   666: getfield context : Landroid/content/Context;
    //   669: ldc_w 2131626345
    //   672: invokevirtual getString : (I)Ljava/lang/String;
    //   675: astore #19
    //   677: aload_1
    //   678: ldc_w '|-'
    //   681: invokevirtual indexOf : (Ljava/lang/String;)I
    //   684: iflt -> 780
    //   687: aload_1
    //   688: ldc_w '|-'
    //   691: ldc ''
    //   693: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   696: astore_1
    //   697: new java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial <init> : ()V
    //   704: astore #21
    //   706: aload #21
    //   708: ldc_w '['
    //   711: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload #21
    //   717: aload #19
    //   719: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload #21
    //   725: ldc_w ']'
    //   728: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload #21
    //   734: aload_1
    //   735: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload #21
    //   741: invokevirtual toString : ()Ljava/lang/String;
    //   744: astore_1
    //   745: new java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial <init> : ()V
    //   752: astore #19
    //   754: aload #19
    //   756: ldc_w '|-'
    //   759: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload #19
    //   765: aload_1
    //   766: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload #19
    //   772: invokevirtual toString : ()Ljava/lang/String;
    //   775: astore #19
    //   777: goto -> 803
    //   780: ldc_w '[%s]%s'
    //   783: iconst_2
    //   784: anewarray java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload #19
    //   791: aastore
    //   792: dup
    //   793: iconst_1
    //   794: aload_1
    //   795: aastore
    //   796: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   799: astore_1
    //   800: goto -> 806
    //   803: aload #19
    //   805: astore_1
    //   806: dload #11
    //   808: invokestatic abs : (D)D
    //   811: invokestatic valueOf : (D)Ljava/lang/Double;
    //   814: iconst_0
    //   815: iconst_0
    //   816: aload #23
    //   818: invokevirtual afU : ()I
    //   821: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   824: astore #25
    //   826: aload #24
    //   828: ldc_w 'fAmount'
    //   831: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   834: iconst_1
    //   835: iconst_0
    //   836: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   839: astore #19
    //   841: aload #24
    //   843: ldc_w 'fPrice'
    //   846: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   849: invokevirtual toString : ()Ljava/lang/String;
    //   852: invokestatic parseDouble : (Ljava/lang/String;)D
    //   855: dstore #7
    //   857: aload #24
    //   859: ldc_w 'fOriginalPrice'
    //   862: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   865: ifeq -> 982
    //   868: aload #24
    //   870: ldc_w 'nProductQty'
    //   873: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   876: checkcast java/lang/String
    //   879: invokestatic parseDouble : (Ljava/lang/String;)D
    //   882: dstore #13
    //   884: aload #24
    //   886: ldc_w 'fOriginalPrice'
    //   889: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   892: checkcast java/lang/String
    //   895: invokestatic parseDouble : (Ljava/lang/String;)D
    //   898: dstore #7
    //   900: aload #24
    //   902: ldc_w 'fDBOriginalPrice'
    //   905: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   908: ifeq -> 927
    //   911: aload #24
    //   913: ldc_w 'fDBOriginalPrice'
    //   916: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   919: checkcast java/lang/String
    //   922: invokestatic parseDouble : (Ljava/lang/String;)D
    //   925: dstore #7
    //   927: aload #24
    //   929: ldc_w 'selectTastesPrice'
    //   932: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   935: ifeq -> 957
    //   938: aload #24
    //   940: ldc_w 'selectTastesPrice'
    //   943: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   946: checkcast java/lang/Double
    //   949: invokevirtual doubleValue : ()D
    //   952: dstore #9
    //   954: goto -> 960
    //   957: dconst_0
    //   958: dstore #9
    //   960: dload #7
    //   962: dload #9
    //   964: dadd
    //   965: dstore #7
    //   967: dload #13
    //   969: dload #7
    //   971: dmul
    //   972: invokestatic valueOf : (D)Ljava/lang/Double;
    //   975: iconst_1
    //   976: iconst_0
    //   977: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   980: astore #19
    //   982: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   985: invokevirtual BV : ()Z
    //   988: ifeq -> 1211
    //   991: aload #24
    //   993: ldc_w 'taxList'
    //   996: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   999: ifeq -> 1211
    //   1002: aload #24
    //   1004: ldc_w 'taxList'
    //   1007: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1010: ifnull -> 1211
    //   1013: aload #24
    //   1015: ldc_w 'taxList'
    //   1018: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1021: checkcast java/util/ArrayList
    //   1024: astore #21
    //   1026: new java/util/ArrayList
    //   1029: dup
    //   1030: invokespecial <init> : ()V
    //   1033: astore #26
    //   1035: aload #21
    //   1037: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1040: astore #21
    //   1042: aload #21
    //   1044: invokeinterface hasNext : ()Z
    //   1049: ifeq -> 1130
    //   1052: aload #21
    //   1054: invokeinterface next : ()Ljava/lang/Object;
    //   1059: checkcast com/laiqian/product/models/o
    //   1062: astore #27
    //   1064: aload #27
    //   1066: invokevirtual alc : ()I
    //   1069: iconst_1
    //   1070: if_icmpne -> 1116
    //   1073: new java/lang/StringBuilder
    //   1076: dup
    //   1077: invokespecial <init> : ()V
    //   1080: astore #28
    //   1082: aload #28
    //   1084: aload #27
    //   1086: invokevirtual akZ : ()Ljava/lang/String;
    //   1089: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: pop
    //   1093: aload #28
    //   1095: ldc_w '*'
    //   1098: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload #26
    //   1104: aload #28
    //   1106: invokevirtual toString : ()Ljava/lang/String;
    //   1109: invokevirtual add : (Ljava/lang/Object;)Z
    //   1112: pop
    //   1113: goto -> 1127
    //   1116: aload #26
    //   1118: aload #27
    //   1120: invokevirtual akZ : ()Ljava/lang/String;
    //   1123: invokevirtual add : (Ljava/lang/Object;)Z
    //   1126: pop
    //   1127: goto -> 1042
    //   1130: iload #4
    //   1132: istore #16
    //   1134: aload_1
    //   1135: astore #21
    //   1137: iload #16
    //   1139: istore #4
    //   1141: aload #26
    //   1143: invokevirtual size : ()I
    //   1146: ifle -> 1214
    //   1149: new java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial <init> : ()V
    //   1156: astore #21
    //   1158: aload #21
    //   1160: aload_1
    //   1161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: aload #21
    //   1167: ldc_w '('
    //   1170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload #21
    //   1176: ldc_w '/'
    //   1179: aload #26
    //   1181: invokestatic a : (Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/lang/String;
    //   1184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: aload #21
    //   1190: ldc_w ')'
    //   1193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload #21
    //   1199: invokevirtual toString : ()Ljava/lang/String;
    //   1202: astore #21
    //   1204: iload #16
    //   1206: istore #4
    //   1208: goto -> 1214
    //   1211: aload_1
    //   1212: astore #21
    //   1214: aload #24
    //   1216: ldc_w 'nProductTransacType'
    //   1219: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   1222: ifeq -> 1252
    //   1225: aload #24
    //   1227: ldc_w 'nProductTransacType'
    //   1230: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1233: checkcast java/lang/Long
    //   1236: invokevirtual longValue : ()J
    //   1239: ldc2_w 100015
    //   1242: lcmp
    //   1243: ifne -> 1252
    //   1246: iconst_1
    //   1247: istore #16
    //   1249: goto -> 1255
    //   1252: iconst_0
    //   1253: istore #16
    //   1255: dload #11
    //   1257: dconst_0
    //   1258: dcmpg
    //   1259: ifge -> 1276
    //   1262: aload_0
    //   1263: getfield context : Landroid/content/Context;
    //   1266: ldc_w 2131628116
    //   1269: invokevirtual getString : (I)Ljava/lang/String;
    //   1272: astore_1
    //   1273: goto -> 1329
    //   1276: aload_3
    //   1277: getfield aWa : Z
    //   1280: ifne -> 1302
    //   1283: iload #16
    //   1285: ifeq -> 1302
    //   1288: aload_0
    //   1289: getfield context : Landroid/content/Context;
    //   1292: ldc_w 2131628745
    //   1295: invokevirtual getString : (I)Ljava/lang/String;
    //   1298: astore_1
    //   1299: goto -> 1329
    //   1302: new java/lang/StringBuilder
    //   1305: dup
    //   1306: invokespecial <init> : ()V
    //   1309: astore_1
    //   1310: aload_1
    //   1311: aload #20
    //   1313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload_1
    //   1318: aload #19
    //   1320: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload_1
    //   1325: invokevirtual toString : ()Ljava/lang/String;
    //   1328: astore_1
    //   1329: aload #22
    //   1331: astore #19
    //   1333: aload #24
    //   1335: ldc_w 'sSpareField5'
    //   1338: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   1341: ifeq -> 1449
    //   1344: aload #22
    //   1346: astore #19
    //   1348: aload #24
    //   1350: ldc_w 'sSpareField5'
    //   1353: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1356: checkcast java/lang/String
    //   1359: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1362: ifne -> 1449
    //   1365: aload #24
    //   1367: ldc_w 'nFoodCategory'
    //   1370: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   1373: ifeq -> 1436
    //   1376: aload #24
    //   1378: ldc_w 'nFoodCategory'
    //   1381: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1384: iconst_3
    //   1385: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1388: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1391: ifeq -> 1436
    //   1394: new java/lang/StringBuilder
    //   1397: dup
    //   1398: invokespecial <init> : ()V
    //   1401: astore #19
    //   1403: aload #19
    //   1405: ldc_w '|-'
    //   1408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: pop
    //   1412: aload #19
    //   1414: aload #24
    //   1416: ldc_w 'sSpareField5'
    //   1419: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1422: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: aload #19
    //   1428: invokevirtual toString : ()Ljava/lang/String;
    //   1431: astore #19
    //   1433: goto -> 1449
    //   1436: aload #24
    //   1438: ldc_w 'sSpareField5'
    //   1441: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1444: checkcast java/lang/String
    //   1447: astore #19
    //   1449: aload #6
    //   1451: invokevirtual aiN : ()Z
    //   1454: ifne -> 1515
    //   1457: aload #23
    //   1459: iconst_3
    //   1460: anewarray java/lang/String
    //   1463: dup
    //   1464: iconst_0
    //   1465: aload #21
    //   1467: aastore
    //   1468: dup
    //   1469: iconst_1
    //   1470: aload #25
    //   1472: aastore
    //   1473: dup
    //   1474: iconst_2
    //   1475: aload_1
    //   1476: aastore
    //   1477: invokevirtual x : ([Ljava/lang/String;)V
    //   1480: aload #19
    //   1482: ifnull -> 1512
    //   1485: aload #19
    //   1487: invokestatic mm : (Ljava/lang/String;)Z
    //   1490: ifeq -> 1505
    //   1493: aload #23
    //   1495: aload #19
    //   1497: iconst_3
    //   1498: iconst_0
    //   1499: invokevirtual f : (Ljava/lang/String;II)V
    //   1502: goto -> 1512
    //   1505: aload #23
    //   1507: aload #19
    //   1509: invokevirtual ll : (Ljava/lang/String;)V
    //   1512: goto -> 279
    //   1515: aload #23
    //   1517: iconst_4
    //   1518: anewarray java/lang/String
    //   1521: dup
    //   1522: iconst_0
    //   1523: aload #21
    //   1525: aastore
    //   1526: dup
    //   1527: iconst_1
    //   1528: aload #25
    //   1530: aastore
    //   1531: dup
    //   1532: iconst_2
    //   1533: dload #7
    //   1535: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1538: iconst_1
    //   1539: iconst_0
    //   1540: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   1543: aastore
    //   1544: dup
    //   1545: iconst_3
    //   1546: aload_1
    //   1547: aastore
    //   1548: invokevirtual x : ([Ljava/lang/String;)V
    //   1551: iload #4
    //   1553: istore #16
    //   1555: aload #19
    //   1557: ifnull -> 1595
    //   1560: aload #19
    //   1562: invokestatic mm : (Ljava/lang/String;)Z
    //   1565: ifeq -> 1584
    //   1568: aload #23
    //   1570: aload #19
    //   1572: iconst_3
    //   1573: iconst_0
    //   1574: invokevirtual f : (Ljava/lang/String;II)V
    //   1577: iload #4
    //   1579: istore #16
    //   1581: goto -> 1595
    //   1584: aload #23
    //   1586: aload #19
    //   1588: invokevirtual ll : (Ljava/lang/String;)V
    //   1591: iload #4
    //   1593: istore #16
    //   1595: iload #15
    //   1597: iconst_1
    //   1598: iadd
    //   1599: istore #15
    //   1601: iload #16
    //   1603: istore #4
    //   1605: goto -> 205
    //   1608: aload #23
    //   1610: iload #4
    //   1612: invokevirtual setSize : (I)V
    //   1615: iconst_1
    //   1616: ireturn }
  
  private boolean a(e parame, @NonNull List<HashMap<String, Object>> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3) {
    b b = new b((a)parame);
    b.afW();
    if (!paramBoolean3) {
      b.x(new String[] { this.context.getString(2131628769), this.context.getString(2131628771), this.context.getString(2131628783) });
    } else {
      b.x(new String[] { this.context.getString(2131628769), this.context.getString(2131628771), this.context.getString(2131629243), this.context.getString(2131628783) });
    } 
    b.l('-');
    int j = b.getSize();
    b.setSize(paramInt);
    String str = "";
    if (paramBoolean1)
      str = "-"; 
    int i = paramList.size();
    for (paramInt = 0; paramInt < i * 2; paramInt++) {
      int k;
      if (paramInt >= i) {
        k = paramInt - i;
      } else {
        k = paramInt;
      } 
      HashMap hashMap = (HashMap)paramList.get(k);
      double d = Double.valueOf(hashMap.get("nProductQty").toString()).doubleValue();
      if ((paramInt < i) ? (d < 0.0D) : (d > 0.0D)) {
        String str3;
        double d2;
        boolean bool = hashMap.containsKey("taste");
        String str4 = null;
        if (bool) {
          str3 = (String)hashMap.get("taste");
        } else {
          ArrayList arrayList;
          str3 = null;
        } 
        String str2 = (String)hashMap.get("sProductName");
        String str1 = str2;
        if (hashMap.containsKey("nFoodCategory")) {
          str1 = str2;
          if (hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
            str1 = str2;
            if (!str2.startsWith("|-")) {
              String str6;
              null = new StringBuilder();
              null.append("|-");
              null.append(str2);
              str1 = null.toString();
            } 
          } 
        } 
        str2 = str1;
        if (str3 != null) {
          str2 = str1;
          if (!str3.trim().isEmpty())
            str2 = String.format("%s[%s]", new Object[] { str1, str3 }); 
        } 
        str1 = str2;
        if (paramBoolean2) {
          str1 = str2;
          if (hashMap.containsKey("noDiscount")) {
            str1 = str2;
            if (((Boolean)hashMap.get("noDiscount")).booleanValue())
              if (hashMap.containsKey("nFoodCategory") && hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
                str1 = str2;
              } else {
                String str6;
                null = new StringBuilder();
                null.append(str2);
                null.append("<");
                null.append(this.context.getString(2131628754));
                null.append(">");
                str1 = null.toString();
              }  
          } 
        } 
        String str5 = n.a(Double.valueOf(Math.abs(d)), false, false, b.afU());
        str2 = n.a(hashMap.get("fAmount"), true, false);
        double d1 = Double.parseDouble(hashMap.get("fPrice").toString());
        if (hashMap.containsKey("fOriginalPrice")) {
          double d3 = Double.parseDouble((String)hashMap.get("nProductQty"));
          d1 = Double.parseDouble((String)hashMap.get("fOriginalPrice"));
          if (hashMap.containsKey("fDBOriginalPrice"))
            d1 = Double.parseDouble((String)hashMap.get("fDBOriginalPrice")); 
          if (hashMap.containsKey("selectTastesPrice")) {
            d2 = ((Double)hashMap.get("selectTastesPrice")).doubleValue();
          } else {
            double d4;
            d2 = 0.0D;
          } 
          d1 += d2;
          str2 = n.a(Double.valueOf(d3 * d1), true, false);
        } 
        if (a.AZ().BV() && hashMap.containsKey("taxList") && hashMap.get("taxList") != null) {
          str3 = (ArrayList)hashMap.get("taxList");
          ArrayList arrayList = new ArrayList();
          for (o o : str3) {
            if (o.alc() == 1) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(o.akZ());
              stringBuilder.append("*");
              arrayList.add(stringBuilder.toString());
              continue;
            } 
            arrayList.add(o.akZ());
          } 
          String str6 = str1;
          d2 = d1;
          if (arrayList.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str1);
            stringBuilder.append("(");
            stringBuilder.append(by.a("/", arrayList));
            stringBuilder.append(")");
            String str7 = stringBuilder.toString();
            d2 = d1;
          } 
        } else {
          d2 = d1;
          str3 = str1;
        } 
        if (hashMap.containsKey("nProductTransacType") && ((Long)hashMap.get("nProductTransacType")).longValue() == 100015L) {
          k = 1;
        } else {
          k = 0;
        } 
        if (d < 0.0D) {
          str1 = this.context.getString(2131628116);
        } else if (!paramBoolean1 && k != 0) {
          str1 = this.context.getString(2131628745);
        } else {
          null = new StringBuilder();
          null.append(str);
          null.append(str2);
          str1 = null.toString();
        } 
        str2 = str4;
        if (hashMap.containsKey("sSpareField5")) {
          str2 = str4;
          if (!TextUtils.isEmpty((String)hashMap.get("sSpareField5")))
            if (hashMap.containsKey("nFoodCategory") && hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("|-");
              stringBuilder.append(hashMap.get("sSpareField5"));
              String str6 = stringBuilder.toString();
            } else {
              str2 = (String)hashMap.get("sSpareField5");
            }  
        } 
        if (!paramBoolean3) {
          b.x(new String[] { str3, str5, str1 });
          if (str2 != null)
            if (e.mm(str2)) {
              b.f(str2, 3, 0);
            } else {
              b.ll(str2);
            }  
        } else {
          b.x(new String[] { str3, str5, n.a(Double.valueOf(d2), true, false), str1 });
          if (str2 != null)
            if (e.mm(str2)) {
              b.f(str2, 3, 0);
            } else {
              b.ll(str2);
            }  
        } 
      } 
    } 
    b.setSize(j);
    return true;
  }
  
  private ArrayList<PrintContent> b(PrintContent paramPrintContent, int paramInt) {
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < paramInt; b++)
      arrayList.add(paramPrintContent); 
    return arrayList;
  }
  
  private void b(WeiOrderDetail paramWeiOrderDetail, g paramg) {
    int i = paramg.getSize();
    if (paramWeiOrderDetail.aVS == 10001L) {
      System.out.println("print firstPayType is PAYTYPE_CASH");
      paramg.setSize(3);
    } 
    if (paramWeiOrderDetail.aVS != this.cMB)
      a(paramg, fg.ao(paramWeiOrderDetail.aVS), paramWeiOrderDetail.aVT); 
    paramg.setSize(i);
  }
  
  private boolean b(e parame, int paramInt, String paramString) {
    if (paramString == null)
      return false; 
    parame.x(new String[] { this.context.getString(paramInt), paramString });
    return true;
  }
  
  private boolean b(e parame, Double paramDouble) { return a(parame, 2131628738, paramDouble); }
  
  private boolean b(e parame, Double paramDouble, boolean paramBoolean) {
    int i;
    double d;
    if (paramBoolean) {
      i = 2131628725;
    } else {
      i = 2131628724;
    } 
    if (paramBoolean) {
      d = -paramDouble.doubleValue();
    } else {
      d = paramDouble.doubleValue();
    } 
    return a(parame, i, Double.valueOf(d));
  }
  
  private boolean b(e parame, String paramString) {
    parame.lk(String.format("%s %s", new Object[] { this.context.getString(2131628779), paramString }));
    return true;
  }
  
  private boolean b(e parame, String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    parame.l('-');
    parame.f(paramString, paramInt, 1);
    parame.l('-');
    return true;
  }
  
  private boolean b(e parame, String paramString1, String paramString2) {
    if (paramString2 == null)
      return false; 
    parame.lk(String.format("%s%s", new Object[] { paramString1, paramString2 }));
    return true;
  }
  
  private boolean b(e parame, ArrayList<n> paramArrayList) {
    Iterator iterator = paramArrayList.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      n n = (n)iterator.next();
      if (!bm.a(n.getValue(), 0.0D, 6)) {
        byte b;
        String str = n.getName();
        double d = n.getValue();
        if (n.UZ()) {
          b = 1;
        } else {
          b = -1;
        } 
        a(parame, str, Double.valueOf(d * b));
        bool = true;
      } 
    } 
    return bool;
  }
  
  private boolean b(e parame, Date paramDate) {
    g g1 = new g(parame.afT());
    g1.setWidth(parame.getWidth());
    g1.ic(parame.afU());
    g1.n(new int[] { 10, 22 });
    g1.x(new String[] { this.context.getString(2131628762), Xn().format(paramDate) });
    return true;
  }
  
  public static a bo(Context paramContext) {
    if (cND == null)
      cND = new a(paramContext.getApplicationContext()); 
    return cND;
  }
  
  private g br(int paramInt1, int paramInt2) {
    g g1 = new g();
    g1.setWidth(paramInt1);
    if (paramInt1 == 80) {
      g1.n(new int[] { 7, 2, 3 });
    } else {
      g1.n(new int[] { 2, 1, 1 });
    } 
    g1.ic(paramInt2);
    PrintContent.a a1 = g1.afT();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    a1.aJ("width", stringBuilder.toString());
    g1.n(new int[] { 17, 15 });
    return g1;
  }
  
  private boolean c(e parame, Double paramDouble) {
    if (paramDouble != null) {
      parame.x(new String[] { this.context.getString(2131628781), n.a(Double.valueOf(-paramDouble.doubleValue()), true, false, parame.afU()) });
      return true;
    } 
    return false;
  }
  
  private boolean c(e parame, Double paramDouble, boolean paramBoolean) {
    double d;
    if (paramBoolean) {
      d = -paramDouble.doubleValue();
    } else {
      d = paramDouble.doubleValue();
    } 
    return a(parame, 2131628734, Double.valueOf(d));
  }
  
  private boolean c(e parame, String paramString) {
    if (parame != null) {
      if (by.isNull(paramString))
        return false; 
      parame.x(new String[] { this.context.getString(2131625916), paramString });
      return true;
    } 
    return false;
  }
  
  private boolean c(e parame, String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt != -1) {
        String str = "";
        if (paramInt == 0) {
          str = this.context.getString(2131630024);
        } else if (paramInt == 1) {
          str = this.context.getString(2131630023);
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("-");
        stringBuilder.append(str);
        parame.f(stringBuilder.toString(), 1, 0);
        return true;
      } 
      parame.f(paramString, 1, 0);
      return true;
    } 
    return false;
  }
  
  private boolean c(e parame, Date paramDate) {
    g g1 = new g(parame.afT());
    g1.setWidth(parame.getWidth());
    g1.ic(parame.afU());
    g1.n(new int[] { 10, 22 });
    g1.x(new String[] { this.context.getString(2131628772), Xn().format(paramDate) });
    return true;
  }
  
  private boolean d(e parame, Double paramDouble) { return d(parame, paramDouble, false); }
  
  private boolean d(e parame, Double paramDouble, boolean paramBoolean) {
    double d;
    if (paramBoolean) {
      d = paramDouble.doubleValue();
    } else {
      d = -paramDouble.doubleValue();
    } 
    return a(parame, 2131628743, Double.valueOf(d));
  }
  
  private boolean e(e parame, String paramString) {
    parame.f(by.G(paramString, 100), 3, 0);
    return true;
  }
  
  private boolean g(e parame, @Nullable String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      parame.f(paramString, 3, 0);
      return true;
    } 
    return false;
  }
  
  private g gu(int paramInt) { return br(paramInt, CrashApplication.aIQ); }
  
  private boolean h(e parame, @Nullable String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (n.bL(this.context)) {
        parame.f(paramString, 1, 0);
        return true;
      } 
      parame.ll(paramString);
      return true;
    } 
    return false;
  }
  
  private boolean i(e parame, @Nullable String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      parame.ll(paramString);
      return true;
    } 
    return false;
  }
  
  private int iH(@Size int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("size not valid:");
        stringBuilder.append(paramInt);
        throw new IllegalStateException(stringBuilder.toString());
      case 2:
        return 1;
      case 1:
        break;
    } 
    return 0;
  }
  
  private String iP(String paramString) {
    String str1 = "";
    bh bh = new bh(this.context);
    String str2 = bh.iC(paramString);
    bh.close();
    if (!TextUtils.isEmpty(str2))
      str1 = str2; 
    return !n.bL(this.context) ? (str1.equals(paramString) ? paramString : str1) : (str1.equals(paramString) ? iQ(paramString) : m(str1, 1));
  }
  
  private boolean k(e parame, String paramString) { return b(parame, 2131628749, paramString); }
  
  private boolean l(e parame, String paramString) {
    parame.f(paramString, 0, 1);
    return true;
  }
  
  @NonNull
  private String m(String paramString, int paramInt) {
    String str = paramString;
    if (paramString.length() > paramInt) {
      null = new StringBuffer();
      for (byte b = 0; b < paramInt; b++)
        null.append("*"); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null.toString());
      stringBuilder.append(paramString.substring(paramInt, paramString.length()).toString());
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  private boolean m(e parame, String paramString) {
    g g1 = new g(parame.afT());
    g1.setWidth(parame.getWidth());
    g1.ic(parame.afU());
    g1.n(new int[] { 10, 21 });
    g1.x(new String[] { this.context.getString(2131628759), paramString });
    return true;
  }
  
  private boolean n(e parame, @Nullable String paramString) { return b(parame, 2131628737, paramString); }
  
  private boolean o(e parame, @Nullable String paramString) { return b(parame, 2131628740, paramString); }
  
  private boolean p(e parame, @Nullable String paramString) { return b(parame, 2131628741, paramString); }
  
  public SimpleDateFormat Xn() {
    if (this.cJp == null)
      this.cJp = new SimpleDateFormat(this.context.getString(2131627405)); 
    return this.cJp;
  }
  
  public e a(s params, PrintContent paramPrintContent, ReceiptPrintSettings paramReceiptPrintSettings) {
    e e = g.cGS.f(params).a(paramPrintContent);
    e.cx(TimeUnit.SECONDS.toMillis(paramReceiptPrintSettings.aiy()));
    return e;
  }
  
  public ArrayList<PrintContent> a(AliPayPreorderDetail paramAliPayPreorderDetail, ReceiptPrintSettings paramReceiptPrintSettings) {
    g g1 = gu(paramReceiptPrintSettings.getWidth());
    if (paramAliPayPreorderDetail.ceW != null) {
      null = new StringBuilder();
      null.append(paramAliPayPreorderDetail.ceW);
      null.append("");
      if (null.toString().length() == 13) {
        b.a a1 = b.a(this.context, "", paramAliPayPreorderDetail.ceW, true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a1.bZc);
        stringBuilder.append("-");
        stringBuilder.append(a1.bTe);
        a(g1, stringBuilder.toString());
        String str = a1.bZd;
      } else {
        a(g1, paramAliPayPreorderDetail.ceW);
        null = null;
      } 
      int i = paramReceiptPrintSettings.ait();
      byte b2 = 3;
      byte b1 = b2;
      switch (i) {
        default:
          b1 = b2;
          break;
        case 1:
          b1 = 0;
          break;
        case 2:
          break;
      } 
      b(g1, paramReceiptPrintSettings.getTitle(), b1);
      a(g1, paramAliPayPreorderDetail.bkf, paramAliPayPreorderDetail.ceV);
      if (!by.isNull(null))
        c(g1, null); 
      g1.l('-');
      a(g1, paramAliPayPreorderDetail.bJf, false, iH(paramReceiptPrintSettings.ais()), false, paramReceiptPrintSettings.aiN());
      g1.l('-');
      if (paramAliPayPreorderDetail.ceX != null && !bm.a(paramAliPayPreorderDetail.ceX.doubleValue(), 0.0D, 6))
        d(g1, paramAliPayPreorderDetail.ceX); 
      a(g1, Double.valueOf(paramAliPayPreorderDetail.aJW));
      for (z z : paramAliPayPreorderDetail.bbS)
        a(g1, z.name, Double.valueOf(z.aJW)); 
      g1.l('-');
      boolean bool = a(g1, paramAliPayPreorderDetail.ceY, this.context.getString(2131628728));
      if (!TextUtils.isEmpty(paramReceiptPrintSettings.aiq()) && bool)
        g1.l('-'); 
      l(g1, paramReceiptPrintSettings.aiq());
      a(g1, paramReceiptPrintSettings.air());
      ArrayList arrayList = new ArrayList();
      arrayList.add(g1.afV());
      return arrayList;
    } 
    Object object = null;
  }
  
  public ArrayList<PrintContent> a(WeiOrderDetail paramWeiOrderDetail, ReceiptPrintSettings paramReceiptPrintSettings) {
    g g1 = gu(paramReceiptPrintSettings.getWidth());
    g1.ic(2);
    if (paramWeiOrderDetail.type == 1) {
      String str;
      if (paramWeiOrderDetail.paytype == 3) {
        str = this.context.getString(2131628755);
      } else {
        str = this.context.getString(2131628788);
      } 
      g1.f(String.format("%s-%s", new Object[] { this.context.getString(2131628786), str }), 1, 1);
    } else if (paramWeiOrderDetail.type == 2) {
      String str;
      if (paramWeiOrderDetail.paytype == 3) {
        str = this.context.getString(2131628765);
      } else {
        str = this.context.getString(2131628727);
      } 
      g1.f(String.format("%s-%s", new Object[] { this.context.getString(2131628770), str }), 1, 1);
    } else if (paramWeiOrderDetail.type == 3) {
      String str;
      if (paramWeiOrderDetail.paytype == 3) {
        str = this.context.getString(2131628765);
      } else {
        str = this.context.getString(2131628788);
      } 
      g1.f(String.format("%s-%s", new Object[] { this.context.getString(2131628770), str }), 1, 1);
    } else if (paramWeiOrderDetail.type == 4) {
      String str;
      if (paramWeiOrderDetail.paytype == 3) {
        str = this.context.getString(2131628755);
      } else {
        str = this.context.getString(2131628757);
      } 
      g1.f(String.format("%s-%s", new Object[] { this.context.getString(2131628747), str }), 1, 1);
    } else if (paramWeiOrderDetail.type == 6) {
      String str;
      if (paramWeiOrderDetail.paytype == 3) {
        str = this.context.getString(2131628755);
      } else {
        str = this.context.getString(2131628757);
      } 
      g1.f(String.format("%s-%s", new Object[] { this.context.getString(2131629967), str }), 1, 1);
    } else if (paramWeiOrderDetail.type == 5) {
      String str;
      if (paramWeiOrderDetail.czd == 0) {
        str = this.context.getString(2131628755);
      } else {
        str = this.context.getString(2131630031);
      } 
      if (paramWeiOrderDetail.paytype != 3)
        str = this.context.getString(2131628757); 
      g1.f(String.format("%s-%s", new Object[] { "Phone Order", str }), 1, 1);
    } 
    if (paramWeiOrderDetail.type == 2 || paramWeiOrderDetail.type == 3) {
      b(g1, paramWeiOrderDetail.number);
    } else if ((paramWeiOrderDetail.type == 4 || paramWeiOrderDetail.type == 6) && paramWeiOrderDetail.aWc == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.context.getString(2131624447));
      stringBuilder.append(" ");
      stringBuilder.append(this.context.getString(2131628760));
      b(g1, stringBuilder.toString(), paramWeiOrderDetail.number);
    } else {
      b(g1, this.context.getString(2131628760), paramWeiOrderDetail.number);
    } 
    g1.afT().aJ("number", paramWeiOrderDetail.number);
    a(g1, paramReceiptPrintSettings.aiu(), paramReceiptPrintSettings.aiv());
    switch (paramReceiptPrintSettings.ait()) {
      default:
        i = 3;
        break;
      case 1:
        i = 0;
        break;
    } 
    b(g1, paramReceiptPrintSettings.getTitle(), i);
    if (paramWeiOrderDetail.czh.size() > 0)
      g1.lk("Tax Invoice"); 
    if (!TextUtils.isEmpty(paramWeiOrderDetail.czl))
      b(g1, 2131628731, paramWeiOrderDetail.czl); 
    b(g1, paramWeiOrderDetail.cza);
    if (paramWeiOrderDetail.type == 1 || paramWeiOrderDetail.type == 4 || paramWeiOrderDetail.type == 6)
      c(g1, paramWeiOrderDetail.czb); 
    if (!TextUtils.isEmpty(paramWeiOrderDetail.czi)) {
      o(g1, paramWeiOrderDetail.czi);
      p(g1, paramWeiOrderDetail.czj);
    } 
    n(g1, paramWeiOrderDetail.ceV);
    if ((paramWeiOrderDetail.type == 4 || paramWeiOrderDetail.type == 6) && paramWeiOrderDetail.orderNo != null)
      m(g1, paramWeiOrderDetail.orderNo); 
    if (!TextUtils.isEmpty(paramWeiOrderDetail.text))
      g1.f(String.format("%s:%s", new Object[] { this.context.getString(2131628756), paramWeiOrderDetail.text }), 3, 0); 
    g1.l('-');
    e(g1, paramWeiOrderDetail.czc);
    if (paramWeiOrderDetail.type == 1 || paramWeiOrderDetail.type == 4 || paramWeiOrderDetail.type == 6 || paramWeiOrderDetail.type == 5) {
      c(g1, paramWeiOrderDetail.aVX, paramWeiOrderDetail.aVY);
      g(g1, paramWeiOrderDetail.aRu);
      h(g1, paramWeiOrderDetail.address);
      i(g1, paramWeiOrderDetail.aTq);
    } 
    g1.l('-');
    a(g1, paramWeiOrderDetail.bJf, paramWeiOrderDetail.aWa, iH(paramReceiptPrintSettings.ais()), false, paramReceiptPrintSettings.aiN());
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramWeiOrderDetail.bJf.iterator();
    while (iterator.hasNext())
      arrayList.add(((HashMap)iterator.next()).get("sProductName").toString()); 
    g1.afT().aJ("name", by.a("/", arrayList));
    int i = g1.getSize();
    g1.setSize(iH(paramReceiptPrintSettings.ais()));
    a(g1, paramWeiOrderDetail.cvD);
    if (paramWeiOrderDetail.discountAmount != 0.0D)
      c(g1, Double.valueOf(paramWeiOrderDetail.discountAmount)); 
    g1.setSize(i);
    if (paramWeiOrderDetail.type == 4 || paramWeiOrderDetail.type == 6) {
      if (paramWeiOrderDetail.czf != null || paramWeiOrderDetail.cze != null)
        g1.l('-'); 
      if (paramWeiOrderDetail.czf != null)
        a(g1, this.context.getString(2131630539), paramWeiOrderDetail.czf); 
      if (paramWeiOrderDetail.cze != null)
        a(g1, this.context.getString(2131630540), paramWeiOrderDetail.cze); 
      if (paramWeiOrderDetail.type != 5)
        for (Map.Entry entry : paramWeiOrderDetail.czg.entrySet()) {
          if (n.bc(((Double)entry.getValue()).doubleValue())) {
            g1.ll((String)entry.getKey());
            continue;
          } 
          if (paramWeiOrderDetail.type != 5)
            a(g1, (String)entry.getKey(), Double.valueOf(-((Double)entry.getValue()).doubleValue())); 
        }  
    } 
    g1.l('-');
    if (!n.bc(paramWeiOrderDetail.aVZ)) {
      double d;
      if (paramWeiOrderDetail.aWa) {
        d = -(paramWeiOrderDetail.cyH.doubleValue() - paramWeiOrderDetail.aVZ - paramWeiOrderDetail.cyL);
      } else {
        d = paramWeiOrderDetail.cyH.doubleValue() - paramWeiOrderDetail.aVZ - paramWeiOrderDetail.cyL;
      } 
      a(g1, "Sales amount", Double.valueOf(d));
      if (paramWeiOrderDetail.aWa) {
        d = -paramWeiOrderDetail.aVZ;
      } else {
        d = paramWeiOrderDetail.aVZ;
      } 
      a(g1, "Total tax", Double.valueOf(d));
    } 
    if (!n.bc(paramWeiOrderDetail.cyL))
      a(g1, "Rounding", Double.valueOf(paramWeiOrderDetail.cyL)); 
    if (paramWeiOrderDetail.type == 5) {
      a(g1, "Total", paramWeiOrderDetail.cpc);
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("print firstPayType is:");
      stringBuilder.append(paramWeiOrderDetail.aVS);
      stringBuilder.append("，firstPayValue is:");
      stringBuilder.append(paramWeiOrderDetail.aVT);
      printStream.println(stringBuilder.toString());
      printStream = System.out;
      stringBuilder = new StringBuilder();
      stringBuilder.append("print secondPayType is:");
      stringBuilder.append(paramWeiOrderDetail.aVU);
      stringBuilder.append(",secondPayValue is:");
      stringBuilder.append(paramWeiOrderDetail.aVV);
      printStream.println(stringBuilder.toString());
      b(paramWeiOrderDetail, g1);
      a(paramWeiOrderDetail, g1);
    } else {
      a(g1, paramWeiOrderDetail.cyH);
    } 
    if (paramWeiOrderDetail.czh.size() != 0) {
      g1.l('-');
      g1.n(new int[] { 12, 10, 10 });
      g1.x(new String[] { "GST", "Amount", "Tax" });
      g1.l('-');
      for (p p : paramWeiOrderDetail.czh) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.IT());
        stringBuilder.append("=");
        stringBuilder.append(p.alg());
        stringBuilder.append("%");
        g1.x(new String[] { stringBuilder.toString(), n.a(Double.valueOf(p.ali()), true, false), n.a(Double.valueOf(p.alh()), true, false) });
      } 
    } 
    i = paramReceiptPrintSettings.aiw();
    if (paramWeiOrderDetail.type == 1 && i == 1) {
      g1.l('-');
      a(g1, 1, null, this.context.getString(2131628777));
    } 
    if (!TextUtils.isEmpty(paramReceiptPrintSettings.aiq())) {
      g1.l('-');
      l(g1, paramReceiptPrintSettings.aiq());
    } 
    a(g1, paramReceiptPrintSettings.air());
    return b(g1.afV(), paramReceiptPrintSettings.getCopies());
  }
  
  public ArrayList<PrintContent> a(b paramb) { return a(paramb, aiL(), false); }
  
  public ArrayList<PrintContent> a(b paramb, ReceiptPrintSettings paramReceiptPrintSettings) { return a(paramb, paramReceiptPrintSettings, false); }
  
  public ArrayList<PrintContent> a(b paramb, ReceiptPrintSettings paramReceiptPrintSettings, boolean paramBoolean) { // Byte code:
    //   0: new com/laiqian/models/an
    //   3: dup
    //   4: aload_0
    //   5: getfield context : Landroid/content/Context;
    //   8: invokespecial <init> : (Landroid/content/Context;)V
    //   11: astore #15
    //   13: aload #15
    //   15: invokevirtual Vu : ()Lcom/laiqian/models/an$c;
    //   18: astore #14
    //   20: aload #15
    //   22: invokevirtual close : ()V
    //   25: aload_0
    //   26: aload_2
    //   27: invokevirtual getWidth : ()I
    //   30: invokespecial gu : (I)Lcom/laiqian/print/b/g;
    //   33: astore #17
    //   35: aload_2
    //   36: invokevirtual ais : ()I
    //   39: istore #11
    //   41: aload_1
    //   42: ifnull -> 67
    //   45: aload_1
    //   46: getfield aWg : Z
    //   49: ifeq -> 67
    //   52: aload #17
    //   54: aload_0
    //   55: getfield context : Landroid/content/Context;
    //   58: ldc_w 2131628774
    //   61: invokevirtual getString : (I)Ljava/lang/String;
    //   64: invokevirtual lk : (Ljava/lang/String;)V
    //   67: aload_1
    //   68: ifnull -> 82
    //   71: aload_1
    //   72: getfield bcf : J
    //   75: ldc2_w 7
    //   78: lcmp
    //   79: ifeq -> 93
    //   82: aload_1
    //   83: getfield bcf : J
    //   86: ldc2_w 14
    //   89: lcmp
    //   90: ifne -> 207
    //   93: aload_1
    //   94: getfield openTableName : Ljava/lang/String;
    //   97: ldc_w '.'
    //   100: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   103: ifne -> 121
    //   106: aload_0
    //   107: aload #17
    //   109: aload_1
    //   110: getfield openTableName : Ljava/lang/String;
    //   113: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   116: istore #13
    //   118: goto -> 193
    //   121: aload_1
    //   122: getfield openTableName : Ljava/lang/String;
    //   125: ldc_w '.'
    //   128: invokevirtual indexOf : (Ljava/lang/String;)I
    //   131: istore #10
    //   133: aload #17
    //   135: ldc_w '%s'
    //   138: iconst_1
    //   139: anewarray java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: getfield openTableName : Ljava/lang/String;
    //   148: iconst_0
    //   149: iload #10
    //   151: invokevirtual substring : (II)Ljava/lang/String;
    //   154: aastore
    //   155: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual lk : (Ljava/lang/String;)V
    //   161: aload #17
    //   163: ldc_w '%s'
    //   166: iconst_1
    //   167: anewarray java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: getfield openTableName : Ljava/lang/String;
    //   176: iload #10
    //   178: iconst_1
    //   179: iadd
    //   180: invokevirtual substring : (I)Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokevirtual lk : (Ljava/lang/String;)V
    //   190: iconst_0
    //   191: istore #13
    //   193: aload_1
    //   194: new java/util/Date
    //   197: dup
    //   198: invokespecial <init> : ()V
    //   201: putfield bkf : Ljava/util/Date;
    //   204: goto -> 337
    //   207: aload_1
    //   208: getfield coJ : Ljava/lang/String;
    //   211: ifnull -> 277
    //   214: aload_1
    //   215: getfield aTZ : Z
    //   218: ifeq -> 262
    //   221: aload #17
    //   223: ldc_w '%s %s'
    //   226: iconst_2
    //   227: anewarray java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_0
    //   233: getfield context : Landroid/content/Context;
    //   236: ldc_w 2131626345
    //   239: invokevirtual getString : (I)Ljava/lang/String;
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: aload_1
    //   246: getfield coJ : Ljava/lang/String;
    //   249: aastore
    //   250: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   253: invokevirtual lk : (Ljava/lang/String;)V
    //   256: iconst_1
    //   257: istore #13
    //   259: goto -> 302
    //   262: aload_0
    //   263: aload #17
    //   265: aload_1
    //   266: getfield coJ : Ljava/lang/String;
    //   269: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   272: istore #13
    //   274: goto -> 302
    //   277: aload_1
    //   278: getfield aTZ : Z
    //   281: ifeq -> 299
    //   284: aload #17
    //   286: aload_0
    //   287: getfield context : Landroid/content/Context;
    //   290: ldc_w 2131628763
    //   293: invokevirtual getString : (I)Ljava/lang/String;
    //   296: invokevirtual lk : (Ljava/lang/String;)V
    //   299: iconst_0
    //   300: istore #13
    //   302: iload_3
    //   303: ifeq -> 337
    //   306: aload #17
    //   308: ldc_w '%s'
    //   311: iconst_1
    //   312: anewarray java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload_0
    //   318: getfield context : Landroid/content/Context;
    //   321: ldc_w 2131626897
    //   324: invokevirtual getString : (I)Ljava/lang/String;
    //   327: aastore
    //   328: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   331: invokevirtual lk : (Ljava/lang/String;)V
    //   334: iconst_1
    //   335: istore #13
    //   337: aload_1
    //   338: getfield cyV : Z
    //   341: ifeq -> 420
    //   344: aload_1
    //   345: getfield bcf : J
    //   348: ldc2_w 7
    //   351: lcmp
    //   352: ifeq -> 366
    //   355: aload_1
    //   356: getfield bcf : J
    //   359: ldc2_w 14
    //   362: lcmp
    //   363: ifne -> 401
    //   366: iload_3
    //   367: ifeq -> 401
    //   370: aload #17
    //   372: ldc_w '%s'
    //   375: iconst_1
    //   376: anewarray java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload_0
    //   382: getfield context : Landroid/content/Context;
    //   385: ldc_w 2131626897
    //   388: invokevirtual getString : (I)Ljava/lang/String;
    //   391: aastore
    //   392: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   395: invokevirtual lk : (Ljava/lang/String;)V
    //   398: goto -> 420
    //   401: iload_3
    //   402: ifne -> 420
    //   405: aload #17
    //   407: aload_0
    //   408: getfield context : Landroid/content/Context;
    //   411: ldc_w 2131628732
    //   414: invokevirtual getString : (I)Ljava/lang/String;
    //   417: invokevirtual lk : (Ljava/lang/String;)V
    //   420: aload_0
    //   421: aload #17
    //   423: aload_2
    //   424: invokevirtual aiu : ()I
    //   427: aload_2
    //   428: invokevirtual aiv : ()Ljava/lang/String;
    //   431: invokespecial a : (Lcom/laiqian/print/b/e;ILjava/lang/String;)Z
    //   434: istore_3
    //   435: aload_1
    //   436: getfield aWa : Z
    //   439: ifeq -> 457
    //   442: aload #17
    //   444: aload_0
    //   445: getfield context : Landroid/content/Context;
    //   448: ldc_w 2131628775
    //   451: invokevirtual getString : (I)Ljava/lang/String;
    //   454: invokevirtual lk : (Ljava/lang/String;)V
    //   457: aload_2
    //   458: invokevirtual ait : ()I
    //   461: tableswitch default -> 484, 1 -> 484, 2 -> 484
    //   484: aload_2
    //   485: invokevirtual getTitle : ()Ljava/lang/String;
    //   488: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   491: iconst_1
    //   492: ixor
    //   493: istore #12
    //   495: iload #12
    //   497: ifeq -> 1041
    //   500: aload #17
    //   502: bipush #45
    //   504: invokevirtual l : (C)V
    //   507: aload_2
    //   508: invokevirtual ait : ()I
    //   511: tableswitch default -> 532, 1 -> 532, 2 -> 538
    //   532: iconst_0
    //   533: istore #10
    //   535: goto -> 541
    //   538: iconst_3
    //   539: istore #10
    //   541: aload #17
    //   543: aload_2
    //   544: invokevirtual getTitle : ()Ljava/lang/String;
    //   547: iload #10
    //   549: iconst_1
    //   550: invokevirtual f : (Ljava/lang/String;II)V
    //   553: invokestatic zR : ()Lcom/laiqian/c/a;
    //   556: invokevirtual Ad : ()Z
    //   559: ifeq -> 1013
    //   562: aload #14
    //   564: getfield bSs : Ljava/lang/String;
    //   567: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   570: ifne -> 617
    //   573: new java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial <init> : ()V
    //   580: astore #15
    //   582: aload #15
    //   584: ldc_w 'ROC No. '
    //   587: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload #15
    //   593: aload #14
    //   595: getfield bSs : Ljava/lang/String;
    //   598: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload #17
    //   604: aload #15
    //   606: invokevirtual toString : ()Ljava/lang/String;
    //   609: iconst_0
    //   610: iconst_1
    //   611: invokevirtual f : (Ljava/lang/String;II)V
    //   614: goto -> 617
    //   617: aload #14
    //   619: getfield aWV : Ljava/lang/String;
    //   622: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   625: ifne -> 640
    //   628: aload #17
    //   630: aload #14
    //   632: getfield aWV : Ljava/lang/String;
    //   635: iconst_0
    //   636: iconst_1
    //   637: invokevirtual f : (Ljava/lang/String;II)V
    //   640: aload #14
    //   642: getfield aWU : Ljava/lang/String;
    //   645: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   648: ifne -> 692
    //   651: new java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial <init> : ()V
    //   658: astore #15
    //   660: aload #15
    //   662: ldc_w 'Tel '
    //   665: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload #15
    //   671: aload #14
    //   673: getfield aWU : Ljava/lang/String;
    //   676: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload #17
    //   682: aload #15
    //   684: invokevirtual toString : ()Ljava/lang/String;
    //   687: iconst_0
    //   688: iconst_1
    //   689: invokevirtual f : (Ljava/lang/String;II)V
    //   692: aload #14
    //   694: getfield bSr : Ljava/lang/String;
    //   697: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   700: ifne -> 744
    //   703: new java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial <init> : ()V
    //   710: astore #15
    //   712: aload #15
    //   714: ldc_w 'Email '
    //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload #15
    //   723: aload #14
    //   725: getfield bSr : Ljava/lang/String;
    //   728: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload #17
    //   734: aload #15
    //   736: invokevirtual toString : ()Ljava/lang/String;
    //   739: iconst_0
    //   740: iconst_1
    //   741: invokevirtual f : (Ljava/lang/String;II)V
    //   744: aload #14
    //   746: getfield bSt : Ljava/lang/String;
    //   749: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   752: ifne -> 796
    //   755: new java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial <init> : ()V
    //   762: astore #15
    //   764: aload #15
    //   766: ldc_w 'GST Reg No. '
    //   769: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload #15
    //   775: aload #14
    //   777: getfield bSt : Ljava/lang/String;
    //   780: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload #17
    //   786: aload #15
    //   788: invokevirtual toString : ()Ljava/lang/String;
    //   791: iconst_0
    //   792: iconst_1
    //   793: invokevirtual f : (Ljava/lang/String;II)V
    //   796: aload_1
    //   797: getfield cyS : Ljava/lang/String;
    //   800: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   803: ifne -> 846
    //   806: new java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial <init> : ()V
    //   813: astore #14
    //   815: aload #14
    //   817: ldc_w 'Invoice No. '
    //   820: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload #14
    //   826: aload_1
    //   827: getfield cyS : Ljava/lang/String;
    //   830: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload #17
    //   836: aload #14
    //   838: invokevirtual toString : ()Ljava/lang/String;
    //   841: iconst_0
    //   842: iconst_1
    //   843: invokevirtual f : (Ljava/lang/String;II)V
    //   846: aload_1
    //   847: getfield ciN : Lcom/laiqian/pos/dc;
    //   850: ifnull -> 1013
    //   853: aload #17
    //   855: bipush #45
    //   857: invokevirtual l : (C)V
    //   860: aload_1
    //   861: getfield ciN : Lcom/laiqian/pos/dc;
    //   864: getfield ciI : Ljava/lang/String;
    //   867: ifnull -> 911
    //   870: new java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial <init> : ()V
    //   877: astore #14
    //   879: aload #14
    //   881: ldc_w 'Bill to '
    //   884: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload #14
    //   890: aload_1
    //   891: getfield ciN : Lcom/laiqian/pos/dc;
    //   894: getfield ciI : Ljava/lang/String;
    //   897: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload #17
    //   903: aload #14
    //   905: invokevirtual toString : ()Ljava/lang/String;
    //   908: invokevirtual ll : (Ljava/lang/String;)V
    //   911: aload_1
    //   912: getfield ciN : Lcom/laiqian/pos/dc;
    //   915: getfield address : Ljava/lang/String;
    //   918: ifnull -> 962
    //   921: new java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial <init> : ()V
    //   928: astore #14
    //   930: aload #14
    //   932: ldc_w 'Address '
    //   935: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload #14
    //   941: aload_1
    //   942: getfield ciN : Lcom/laiqian/pos/dc;
    //   945: getfield address : Ljava/lang/String;
    //   948: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload #17
    //   954: aload #14
    //   956: invokevirtual toString : ()Ljava/lang/String;
    //   959: invokevirtual ll : (Ljava/lang/String;)V
    //   962: aload_1
    //   963: getfield ciN : Lcom/laiqian/pos/dc;
    //   966: getfield ciJ : Ljava/lang/String;
    //   969: ifnull -> 1013
    //   972: new java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial <init> : ()V
    //   979: astore #14
    //   981: aload #14
    //   983: ldc_w 'Reg No. '
    //   986: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload #14
    //   992: aload_1
    //   993: getfield ciN : Lcom/laiqian/pos/dc;
    //   996: getfield ciJ : Ljava/lang/String;
    //   999: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload #17
    //   1005: aload #14
    //   1007: invokevirtual toString : ()Ljava/lang/String;
    //   1010: invokevirtual ll : (Ljava/lang/String;)V
    //   1013: aload_1
    //   1014: getfield cyR : Ljava/util/ArrayList;
    //   1017: invokevirtual size : ()I
    //   1020: ifle -> 1031
    //   1023: aload #17
    //   1025: ldc_w 'Tax Invoice'
    //   1028: invokevirtual lk : (Ljava/lang/String;)V
    //   1031: aload #17
    //   1033: bipush #45
    //   1035: invokevirtual l : (C)V
    //   1038: goto -> 1059
    //   1041: aload_1
    //   1042: getfield cyR : Ljava/util/ArrayList;
    //   1045: invokevirtual size : ()I
    //   1048: ifle -> 1059
    //   1051: aload #17
    //   1053: ldc_w 'Tax Invoice'
    //   1056: invokevirtual lk : (Ljava/lang/String;)V
    //   1059: iload #13
    //   1061: ifeq -> 1080
    //   1064: iload_3
    //   1065: ifne -> 1080
    //   1068: iload #12
    //   1070: ifne -> 1080
    //   1073: aload #17
    //   1075: bipush #45
    //   1077: invokevirtual l : (C)V
    //   1080: aload_1
    //   1081: getfield billNumber : Ljava/lang/String;
    //   1084: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1087: ifne -> 1104
    //   1090: aload_0
    //   1091: aload #17
    //   1093: ldc_w 2131628731
    //   1096: aload_1
    //   1097: getfield billNumber : Ljava/lang/String;
    //   1100: invokespecial b : (Lcom/laiqian/print/b/e;ILjava/lang/String;)Z
    //   1103: pop
    //   1104: aload_0
    //   1105: aload #17
    //   1107: aload_0
    //   1108: getfield context : Landroid/content/Context;
    //   1111: ldc_w 2131628778
    //   1114: invokevirtual getString : (I)Ljava/lang/String;
    //   1117: aload_1
    //   1118: getfield bkf : Ljava/util/Date;
    //   1121: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/util/Date;)Z
    //   1124: pop
    //   1125: aload_1
    //   1126: getfield bcf : J
    //   1129: ldc2_w 7
    //   1132: lcmp
    //   1133: ifeq -> 1147
    //   1136: aload_1
    //   1137: getfield bcf : J
    //   1140: ldc2_w 14
    //   1143: lcmp
    //   1144: ifne -> 1204
    //   1147: aload_1
    //   1148: getfield bch : Ljava/lang/String;
    //   1151: invokestatic isNull : (Ljava/lang/String;)Z
    //   1154: ifne -> 1204
    //   1157: ldc_w '0'
    //   1160: astore #14
    //   1162: new org/json/JSONObject
    //   1165: dup
    //   1166: aload_1
    //   1167: getfield bch : Ljava/lang/String;
    //   1170: invokespecial <init> : (Ljava/lang/String;)V
    //   1173: ldc_w 'actual_person'
    //   1176: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1179: astore #15
    //   1181: aload #15
    //   1183: astore #14
    //   1185: goto -> 1195
    //   1188: astore #15
    //   1190: aload #15
    //   1192: invokestatic e : (Ljava/lang/Throwable;)V
    //   1195: aload_0
    //   1196: aload #17
    //   1198: aload #14
    //   1200: invokespecial c : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   1203: pop
    //   1204: aload_1
    //   1205: getfield bcf : J
    //   1208: ldc2_w 7
    //   1211: lcmp
    //   1212: ifne -> 1221
    //   1215: iconst_1
    //   1216: istore #10
    //   1218: goto -> 1224
    //   1221: iconst_0
    //   1222: istore #10
    //   1224: iload #10
    //   1226: ifeq -> 1401
    //   1229: aload_1
    //   1230: getfield coU : Ljava/lang/String;
    //   1233: ifnull -> 1401
    //   1236: ldc ''
    //   1238: astore #14
    //   1240: aload_1
    //   1241: getfield coU : Ljava/lang/String;
    //   1244: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1247: ifeq -> 1368
    //   1250: aload #14
    //   1252: astore #15
    //   1254: new org/json/JSONObject
    //   1257: dup
    //   1258: aload_1
    //   1259: getfield bch : Ljava/lang/String;
    //   1262: invokespecial <init> : (Ljava/lang/String;)V
    //   1265: astore #18
    //   1267: aload #14
    //   1269: astore #15
    //   1271: new com/laiqian/models/bh
    //   1274: dup
    //   1275: aload_0
    //   1276: getfield context : Landroid/content/Context;
    //   1279: invokespecial <init> : (Landroid/content/Context;)V
    //   1282: astore #16
    //   1284: aload #14
    //   1286: astore #15
    //   1288: aload #16
    //   1290: aload #18
    //   1292: ldc_w 'drawerID'
    //   1295: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1298: invokevirtual iB : (Ljava/lang/String;)Ljava/lang/String;
    //   1301: astore #14
    //   1303: aload #14
    //   1305: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1308: ifeq -> 1333
    //   1311: aload #16
    //   1313: aload #18
    //   1315: ldc_w 'drawerID'
    //   1318: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1321: invokevirtual iD : (Ljava/lang/String;)Ljava/lang/String;
    //   1324: astore #15
    //   1326: aload #15
    //   1328: astore #14
    //   1330: goto -> 1333
    //   1333: aload #14
    //   1335: astore #15
    //   1337: aload #16
    //   1339: invokevirtual close : ()V
    //   1342: goto -> 1374
    //   1345: astore #15
    //   1347: goto -> 1360
    //   1350: astore #16
    //   1352: aload #15
    //   1354: astore #14
    //   1356: aload #16
    //   1358: astore #15
    //   1360: aload #15
    //   1362: invokestatic e : (Ljava/lang/Throwable;)V
    //   1365: goto -> 1374
    //   1368: aload_1
    //   1369: getfield coU : Ljava/lang/String;
    //   1372: astore #14
    //   1374: aload #17
    //   1376: iconst_2
    //   1377: anewarray java/lang/String
    //   1380: dup
    //   1381: iconst_0
    //   1382: aload_0
    //   1383: getfield context : Landroid/content/Context;
    //   1386: ldc_w 2131628744
    //   1389: invokevirtual getString : (I)Ljava/lang/String;
    //   1392: aastore
    //   1393: dup
    //   1394: iconst_1
    //   1395: aload #14
    //   1397: aastore
    //   1398: invokevirtual x : ([Ljava/lang/String;)V
    //   1401: aload_1
    //   1402: getfield coV : Ljava/lang/String;
    //   1405: ifnull -> 1576
    //   1408: ldc ''
    //   1410: astore #14
    //   1412: aload_1
    //   1413: getfield coU : Ljava/lang/String;
    //   1416: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1419: ifeq -> 1540
    //   1422: aload #14
    //   1424: astore #15
    //   1426: new org/json/JSONObject
    //   1429: dup
    //   1430: aload_1
    //   1431: getfield bch : Ljava/lang/String;
    //   1434: invokespecial <init> : (Ljava/lang/String;)V
    //   1437: astore #18
    //   1439: aload #14
    //   1441: astore #15
    //   1443: new com/laiqian/models/bh
    //   1446: dup
    //   1447: aload_0
    //   1448: getfield context : Landroid/content/Context;
    //   1451: invokespecial <init> : (Landroid/content/Context;)V
    //   1454: astore #16
    //   1456: aload #14
    //   1458: astore #15
    //   1460: aload #16
    //   1462: aload #18
    //   1464: ldc_w 'settlementID'
    //   1467: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1470: invokevirtual iB : (Ljava/lang/String;)Ljava/lang/String;
    //   1473: astore #14
    //   1475: aload #14
    //   1477: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1480: ifeq -> 1505
    //   1483: aload #16
    //   1485: aload #18
    //   1487: ldc_w 'settlementID'
    //   1490: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1493: invokevirtual iD : (Ljava/lang/String;)Ljava/lang/String;
    //   1496: astore #15
    //   1498: aload #15
    //   1500: astore #14
    //   1502: goto -> 1505
    //   1505: aload #14
    //   1507: astore #15
    //   1509: aload #16
    //   1511: invokevirtual close : ()V
    //   1514: goto -> 1546
    //   1517: astore #15
    //   1519: goto -> 1532
    //   1522: astore #16
    //   1524: aload #15
    //   1526: astore #14
    //   1528: aload #16
    //   1530: astore #15
    //   1532: aload #15
    //   1534: invokestatic e : (Ljava/lang/Throwable;)V
    //   1537: goto -> 1546
    //   1540: aload_1
    //   1541: getfield coV : Ljava/lang/String;
    //   1544: astore #14
    //   1546: aload #17
    //   1548: iconst_2
    //   1549: anewarray java/lang/String
    //   1552: dup
    //   1553: iconst_0
    //   1554: aload_0
    //   1555: getfield context : Landroid/content/Context;
    //   1558: ldc_w 2131628737
    //   1561: invokevirtual getString : (I)Ljava/lang/String;
    //   1564: aastore
    //   1565: dup
    //   1566: iconst_1
    //   1567: aload #14
    //   1569: aastore
    //   1570: invokevirtual x : ([Ljava/lang/String;)V
    //   1573: goto -> 1576
    //   1576: aload #17
    //   1578: bipush #45
    //   1580: invokevirtual l : (C)V
    //   1583: iload #11
    //   1585: iconst_1
    //   1586: if_icmpne -> 1595
    //   1589: iconst_0
    //   1590: istore #10
    //   1592: goto -> 1598
    //   1595: iconst_1
    //   1596: istore #10
    //   1598: aload_1
    //   1599: getfield cyI : Ljava/lang/Double;
    //   1602: iconst_1
    //   1603: iconst_0
    //   1604: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   1607: invokestatic parseDouble : (Ljava/lang/String;)D
    //   1610: dstore #4
    //   1612: dload #4
    //   1614: invokestatic bc : (D)Z
    //   1617: ifeq -> 1639
    //   1620: aload_0
    //   1621: aload #17
    //   1623: aload_1
    //   1624: getfield bJf : Ljava/util/ArrayList;
    //   1627: aload_1
    //   1628: iload #10
    //   1630: iconst_0
    //   1631: aload_2
    //   1632: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;Lcom/laiqian/pos/model/orders/b;IZLcom/laiqian/print/usage/receipt/model/ReceiptPrintSettings;)Z
    //   1635: pop
    //   1636: goto -> 1655
    //   1639: aload_0
    //   1640: aload #17
    //   1642: aload_1
    //   1643: getfield bJf : Ljava/util/ArrayList;
    //   1646: aload_1
    //   1647: iload #10
    //   1649: iconst_0
    //   1650: aload_2
    //   1651: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;Lcom/laiqian/pos/model/orders/b;IZLcom/laiqian/print/usage/receipt/model/ReceiptPrintSettings;)Z
    //   1654: pop
    //   1655: aload #17
    //   1657: bipush #45
    //   1659: invokevirtual l : (C)V
    //   1662: aload_1
    //   1663: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   1666: ifnull -> 1680
    //   1669: aload_0
    //   1670: aload #17
    //   1672: aload_1
    //   1673: getfield bJf : Ljava/util/ArrayList;
    //   1676: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;)Z
    //   1679: pop
    //   1680: aload_1
    //   1681: getfield cyI : Ljava/lang/Double;
    //   1684: ifnull -> 1750
    //   1687: dload #4
    //   1689: invokestatic bc : (D)Z
    //   1692: ifne -> 1750
    //   1695: aload_1
    //   1696: getfield aWg : Z
    //   1699: ifne -> 1724
    //   1702: aload_0
    //   1703: aload #17
    //   1705: aload_1
    //   1706: getfield ceX : Ljava/lang/Double;
    //   1709: aload_1
    //   1710: getfield aWa : Z
    //   1713: aload_1
    //   1714: getfield bJf : Ljava/util/ArrayList;
    //   1717: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/Double;ZLjava/util/ArrayList;)Z
    //   1720: istore_3
    //   1721: goto -> 1752
    //   1724: aload_0
    //   1725: aload #17
    //   1727: aload_1
    //   1728: getfield ceX : Ljava/lang/Double;
    //   1731: aload_1
    //   1732: getfield cyI : Ljava/lang/Double;
    //   1735: aload_1
    //   1736: getfield aWa : Z
    //   1739: aload_1
    //   1740: getfield bJf : Ljava/util/ArrayList;
    //   1743: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Ljava/lang/Double;ZLjava/util/ArrayList;)Z
    //   1746: istore_3
    //   1747: goto -> 1752
    //   1750: iconst_0
    //   1751: istore_3
    //   1752: aload_1
    //   1753: getfield cyQ : Ljava/lang/Double;
    //   1756: ifnull -> 1778
    //   1759: aload_1
    //   1760: getfield cyQ : Ljava/lang/Double;
    //   1763: invokevirtual doubleValue : ()D
    //   1766: invokestatic bc : (D)Z
    //   1769: ifne -> 1778
    //   1772: iconst_1
    //   1773: istore #10
    //   1775: goto -> 1781
    //   1778: iconst_0
    //   1779: istore #10
    //   1781: aload_1
    //   1782: getfield cpa : D
    //   1785: dconst_0
    //   1786: bipush #6
    //   1788: invokestatic a : (DDI)Z
    //   1791: iconst_1
    //   1792: ixor
    //   1793: istore #11
    //   1795: iload #10
    //   1797: ifne -> 2049
    //   1800: iload #11
    //   1802: ifeq -> 2035
    //   1805: aload #17
    //   1807: bipush #45
    //   1809: invokevirtual l : (C)V
    //   1812: ldc ''
    //   1814: astore #14
    //   1816: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1819: invokevirtual BV : ()Z
    //   1822: ifeq -> 1833
    //   1825: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1828: invokevirtual BY : ()Ljava/lang/String;
    //   1831: astore #14
    //   1833: new java/lang/StringBuilder
    //   1836: dup
    //   1837: invokespecial <init> : ()V
    //   1840: astore #15
    //   1842: aload #15
    //   1844: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1847: invokevirtual BW : ()D
    //   1850: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1853: pop
    //   1854: aload #15
    //   1856: ldc ''
    //   1858: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: aload #15
    //   1864: invokevirtual toString : ()Ljava/lang/String;
    //   1867: astore #15
    //   1869: new com/laiqian/print/b/g
    //   1872: dup
    //   1873: aload #17
    //   1875: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   1878: astore #16
    //   1880: aload #16
    //   1882: iconst_2
    //   1883: newarray int
    //   1885: dup
    //   1886: iconst_0
    //   1887: iconst_3
    //   1888: iastore
    //   1889: dup
    //   1890: iconst_1
    //   1891: iconst_1
    //   1892: iastore
    //   1893: invokevirtual n : ([I)V
    //   1896: aload #14
    //   1898: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1901: ifne -> 1978
    //   1904: new java/lang/StringBuilder
    //   1907: dup
    //   1908: invokespecial <init> : ()V
    //   1911: astore #18
    //   1913: aload #18
    //   1915: ldc_w 'Serv. charge('
    //   1918: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: pop
    //   1922: aload #18
    //   1924: aload #15
    //   1926: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: pop
    //   1930: aload #18
    //   1932: ldc_w '%)('
    //   1935: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: pop
    //   1939: aload #18
    //   1941: aload #14
    //   1943: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: pop
    //   1947: aload #18
    //   1949: ldc_w ')'
    //   1952: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: pop
    //   1956: aload_0
    //   1957: aload #16
    //   1959: aload #18
    //   1961: invokevirtual toString : ()Ljava/lang/String;
    //   1964: aload_1
    //   1965: getfield cpa : D
    //   1968: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1971: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   1974: pop
    //   1975: goto -> 2403
    //   1978: new java/lang/StringBuilder
    //   1981: dup
    //   1982: invokespecial <init> : ()V
    //   1985: astore #14
    //   1987: aload #14
    //   1989: ldc_w 'Serv. charge('
    //   1992: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: pop
    //   1996: aload #14
    //   1998: aload #15
    //   2000: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2003: pop
    //   2004: aload #14
    //   2006: ldc_w '%)'
    //   2009: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: pop
    //   2013: aload_0
    //   2014: aload #16
    //   2016: aload #14
    //   2018: invokevirtual toString : ()Ljava/lang/String;
    //   2021: aload_1
    //   2022: getfield cpa : D
    //   2025: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2028: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2031: pop
    //   2032: goto -> 2403
    //   2035: aload_0
    //   2036: aload #17
    //   2038: aload_1
    //   2039: getfield cyN : Ljava/util/ArrayList;
    //   2042: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;)Z
    //   2045: pop
    //   2046: goto -> 2403
    //   2049: iload_3
    //   2050: ifeq -> 2060
    //   2053: aload #17
    //   2055: bipush #45
    //   2057: invokevirtual l : (C)V
    //   2060: aload_1
    //   2061: getfield cyO : Ljava/lang/Double;
    //   2064: invokevirtual doubleValue : ()D
    //   2067: aload_1
    //   2068: getfield cyQ : Ljava/lang/Double;
    //   2071: invokevirtual doubleValue : ()D
    //   2074: dsub
    //   2075: aload_1
    //   2076: getfield cyL : D
    //   2079: dsub
    //   2080: aload_1
    //   2081: getfield cpa : D
    //   2084: dsub
    //   2085: aload_1
    //   2086: getfield cyN : Ljava/util/ArrayList;
    //   2089: new com/laiqian/print/usage/receipt/model/b
    //   2092: dup
    //   2093: aload_0
    //   2094: invokespecial <init> : (Lcom/laiqian/print/usage/receipt/model/a;)V
    //   2097: invokestatic a : (Ljava/util/Collection;Lcom/laiqian/util/k$b;)D
    //   2100: dadd
    //   2101: dstore #6
    //   2103: dload #6
    //   2105: dstore #4
    //   2107: aload_1
    //   2108: getfield aWa : Z
    //   2111: ifeq -> 2119
    //   2114: dload #6
    //   2116: dneg
    //   2117: dstore #4
    //   2119: aload_0
    //   2120: aload #17
    //   2122: ldc_w 'Sales amount'
    //   2125: dload #4
    //   2127: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2130: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2133: pop
    //   2134: iload #11
    //   2136: ifeq -> 2359
    //   2139: ldc ''
    //   2141: astore #14
    //   2143: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2146: invokevirtual BV : ()Z
    //   2149: ifeq -> 2160
    //   2152: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2155: invokevirtual BY : ()Ljava/lang/String;
    //   2158: astore #14
    //   2160: new java/lang/StringBuilder
    //   2163: dup
    //   2164: invokespecial <init> : ()V
    //   2167: astore #15
    //   2169: aload #15
    //   2171: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2174: invokevirtual BW : ()D
    //   2177: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2180: pop
    //   2181: aload #15
    //   2183: ldc ''
    //   2185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: pop
    //   2189: aload #15
    //   2191: invokevirtual toString : ()Ljava/lang/String;
    //   2194: astore #15
    //   2196: new com/laiqian/print/b/g
    //   2199: dup
    //   2200: aload #17
    //   2202: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   2205: astore #16
    //   2207: aload #16
    //   2209: iconst_2
    //   2210: newarray int
    //   2212: dup
    //   2213: iconst_0
    //   2214: iconst_3
    //   2215: iastore
    //   2216: dup
    //   2217: iconst_1
    //   2218: iconst_1
    //   2219: iastore
    //   2220: invokevirtual n : ([I)V
    //   2223: aload #14
    //   2225: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   2228: ifne -> 2305
    //   2231: new java/lang/StringBuilder
    //   2234: dup
    //   2235: invokespecial <init> : ()V
    //   2238: astore #18
    //   2240: aload #18
    //   2242: ldc_w 'Serv. charge('
    //   2245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: pop
    //   2249: aload #18
    //   2251: aload #15
    //   2253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: pop
    //   2257: aload #18
    //   2259: ldc_w '%)('
    //   2262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: pop
    //   2266: aload #18
    //   2268: aload #14
    //   2270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2273: pop
    //   2274: aload #18
    //   2276: ldc_w ')'
    //   2279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2282: pop
    //   2283: aload_0
    //   2284: aload #16
    //   2286: aload #18
    //   2288: invokevirtual toString : ()Ljava/lang/String;
    //   2291: aload_1
    //   2292: getfield cpa : D
    //   2295: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2298: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2301: pop
    //   2302: goto -> 2359
    //   2305: new java/lang/StringBuilder
    //   2308: dup
    //   2309: invokespecial <init> : ()V
    //   2312: astore #14
    //   2314: aload #14
    //   2316: ldc_w 'Serv. charge('
    //   2319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2322: pop
    //   2323: aload #14
    //   2325: aload #15
    //   2327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: pop
    //   2331: aload #14
    //   2333: ldc_w '%)'
    //   2336: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: pop
    //   2340: aload_0
    //   2341: aload #16
    //   2343: aload #14
    //   2345: invokevirtual toString : ()Ljava/lang/String;
    //   2348: aload_1
    //   2349: getfield cpa : D
    //   2352: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2355: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2358: pop
    //   2359: aload_1
    //   2360: getfield aWa : Z
    //   2363: ifeq -> 2379
    //   2366: aload_1
    //   2367: getfield cyQ : Ljava/lang/Double;
    //   2370: invokevirtual doubleValue : ()D
    //   2373: dneg
    //   2374: dstore #4
    //   2376: goto -> 2388
    //   2379: aload_1
    //   2380: getfield cyQ : Ljava/lang/Double;
    //   2383: invokevirtual doubleValue : ()D
    //   2386: dstore #4
    //   2388: aload_0
    //   2389: aload #17
    //   2391: ldc_w 'Total tax'
    //   2394: dload #4
    //   2396: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2399: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2402: pop
    //   2403: iload #11
    //   2405: ifne -> 2413
    //   2408: iload #10
    //   2410: ifeq -> 2431
    //   2413: aload_1
    //   2414: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   2417: ifnull -> 2431
    //   2420: aload_0
    //   2421: aload #17
    //   2423: aload_1
    //   2424: getfield cyN : Ljava/util/ArrayList;
    //   2427: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;)Z
    //   2430: pop
    //   2431: aload_1
    //   2432: getfield cyL : D
    //   2435: invokestatic bc : (D)Z
    //   2438: ifne -> 2458
    //   2441: aload_0
    //   2442: aload #17
    //   2444: ldc_w 'Rounding'
    //   2447: aload_1
    //   2448: getfield cyL : D
    //   2451: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2454: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2457: pop
    //   2458: aload_1
    //   2459: getfield bJf : Ljava/util/ArrayList;
    //   2462: invokevirtual iterator : ()Ljava/util/Iterator;
    //   2465: astore #14
    //   2467: dconst_0
    //   2468: dstore #6
    //   2470: aload #14
    //   2472: invokeinterface hasNext : ()Z
    //   2477: ifeq -> 2672
    //   2480: aload #14
    //   2482: invokeinterface next : ()Ljava/lang/Object;
    //   2487: checkcast java/util/HashMap
    //   2490: astore #15
    //   2492: aload #15
    //   2494: ldc_w 'nProductQty'
    //   2497: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2500: invokevirtual toString : ()Ljava/lang/String;
    //   2503: invokestatic parseDouble : (Ljava/lang/String;)D
    //   2506: dstore #8
    //   2508: aload_1
    //   2509: getfield aWa : Z
    //   2512: ifeq -> 2561
    //   2515: aload #15
    //   2517: ldc_w 'nFoodCategory'
    //   2520: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   2523: ifeq -> 2551
    //   2526: aload #15
    //   2528: ldc_w 'nFoodCategory'
    //   2531: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2534: iconst_2
    //   2535: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2538: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2541: ifeq -> 2551
    //   2544: dload #6
    //   2546: dstore #4
    //   2548: goto -> 2635
    //   2551: dload #6
    //   2553: dload #8
    //   2555: dadd
    //   2556: dstore #4
    //   2558: goto -> 2635
    //   2561: aload #15
    //   2563: ldc_w 'nProductTransacType'
    //   2566: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   2569: ifeq -> 2599
    //   2572: aload #15
    //   2574: ldc_w 'nProductTransacType'
    //   2577: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2580: checkcast java/lang/Long
    //   2583: invokevirtual longValue : ()J
    //   2586: ldc2_w 100015
    //   2589: lcmp
    //   2590: ifne -> 2599
    //   2593: iconst_1
    //   2594: istore #10
    //   2596: goto -> 2602
    //   2599: iconst_0
    //   2600: istore #10
    //   2602: aload #15
    //   2604: ldc_w 'nFoodCategory'
    //   2607: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   2610: ifeq -> 2642
    //   2613: aload #15
    //   2615: ldc_w 'nFoodCategory'
    //   2618: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2621: iconst_2
    //   2622: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2625: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2628: ifeq -> 2642
    //   2631: dload #6
    //   2633: dstore #4
    //   2635: dload #4
    //   2637: dstore #6
    //   2639: goto -> 2470
    //   2642: dload #6
    //   2644: dstore #4
    //   2646: dload #8
    //   2648: dconst_0
    //   2649: dcmpl
    //   2650: ifle -> 2635
    //   2653: dload #6
    //   2655: dstore #4
    //   2657: iload #10
    //   2659: ifne -> 2635
    //   2662: dload #6
    //   2664: dload #8
    //   2666: dadd
    //   2667: dstore #4
    //   2669: goto -> 2635
    //   2672: aload_0
    //   2673: aload #17
    //   2675: dload #6
    //   2677: invokespecial a : (Lcom/laiqian/print/b/e;D)Z
    //   2680: pop
    //   2681: aload_0
    //   2682: aload #17
    //   2684: aload_1
    //   2685: getfield cyO : Ljava/lang/Double;
    //   2688: aload_1
    //   2689: getfield aWa : Z
    //   2692: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Z)Z
    //   2695: pop
    //   2696: aload_1
    //   2697: getfield bbS : Ljava/util/ArrayList;
    //   2700: invokevirtual size : ()I
    //   2703: iconst_1
    //   2704: if_icmpne -> 2794
    //   2707: aload_1
    //   2708: getfield bbS : Ljava/util/ArrayList;
    //   2711: iconst_0
    //   2712: invokevirtual get : (I)Ljava/lang/Object;
    //   2715: checkcast com/laiqian/entity/z
    //   2718: getfield aTv : I
    //   2721: sipush #10001
    //   2724: if_icmpne -> 2794
    //   2727: aload_1
    //   2728: getfield bbS : Ljava/util/ArrayList;
    //   2731: iconst_0
    //   2732: invokevirtual get : (I)Ljava/lang/Object;
    //   2735: checkcast com/laiqian/entity/z
    //   2738: getfield aTw : D
    //   2741: dstore #4
    //   2743: dload #4
    //   2745: invokestatic bc : (D)Z
    //   2748: ifne -> 2939
    //   2751: aload_0
    //   2752: aload #17
    //   2754: aload_1
    //   2755: getfield cyO : Ljava/lang/Double;
    //   2758: invokevirtual doubleValue : ()D
    //   2761: dload #4
    //   2763: dadd
    //   2764: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2767: aload_1
    //   2768: getfield aWa : Z
    //   2771: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Z)Z
    //   2774: pop
    //   2775: aload_0
    //   2776: aload #17
    //   2778: dload #4
    //   2780: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2783: aload_1
    //   2784: getfield aWa : Z
    //   2787: invokespecial c : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Z)Z
    //   2790: pop
    //   2791: goto -> 2939
    //   2794: aload_1
    //   2795: getfield bbS : Ljava/util/ArrayList;
    //   2798: invokevirtual iterator : ()Ljava/util/Iterator;
    //   2801: astore #14
    //   2803: aload #14
    //   2805: invokeinterface hasNext : ()Z
    //   2810: ifeq -> 2939
    //   2813: aload #14
    //   2815: invokeinterface next : ()Ljava/lang/Object;
    //   2820: checkcast com/laiqian/entity/z
    //   2823: astore #15
    //   2825: aload #15
    //   2827: getfield aJW : D
    //   2830: dconst_0
    //   2831: dcmpg
    //   2832: ifge -> 2894
    //   2835: new java/lang/StringBuilder
    //   2838: dup
    //   2839: invokespecial <init> : ()V
    //   2842: astore #16
    //   2844: aload #16
    //   2846: aload #15
    //   2848: getfield name : Ljava/lang/String;
    //   2851: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2854: pop
    //   2855: aload #16
    //   2857: aload_0
    //   2858: getfield context : Landroid/content/Context;
    //   2861: ldc_w 2131628776
    //   2864: invokevirtual getString : (I)Ljava/lang/String;
    //   2867: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2870: pop
    //   2871: aload_0
    //   2872: aload #17
    //   2874: aload #16
    //   2876: invokevirtual toString : ()Ljava/lang/String;
    //   2879: aload #15
    //   2881: getfield aJW : D
    //   2884: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2887: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2890: pop
    //   2891: goto -> 2803
    //   2894: aload_1
    //   2895: getfield aWa : Z
    //   2898: ifeq -> 2912
    //   2901: aload #15
    //   2903: getfield aJW : D
    //   2906: dneg
    //   2907: dstore #4
    //   2909: goto -> 2919
    //   2912: aload #15
    //   2914: getfield aJW : D
    //   2917: dstore #4
    //   2919: aload_0
    //   2920: aload #17
    //   2922: aload #15
    //   2924: getfield name : Ljava/lang/String;
    //   2927: dload #4
    //   2929: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2932: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2935: pop
    //   2936: goto -> 2803
    //   2939: aload_1
    //   2940: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   2943: astore #14
    //   2945: aconst_null
    //   2946: astore #15
    //   2948: aload #14
    //   2950: ifnull -> 3201
    //   2953: aload #17
    //   2955: bipush #45
    //   2957: invokevirtual l : (C)V
    //   2960: aload_1
    //   2961: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   2964: getfield name : Ljava/lang/String;
    //   2967: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   2970: ifne -> 3012
    //   2973: invokestatic zR : ()Lcom/laiqian/c/a;
    //   2976: invokevirtual Ab : ()Z
    //   2979: ifne -> 3000
    //   2982: aload_1
    //   2983: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   2986: getfield name : Ljava/lang/String;
    //   2989: ldc_w '*'
    //   2992: invokestatic bv : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2995: astore #14
    //   2997: goto -> 3101
    //   3000: aload_1
    //   3001: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3004: getfield name : Ljava/lang/String;
    //   3007: astore #14
    //   3009: goto -> 3101
    //   3012: aload_1
    //   3013: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3016: getfield aTp : Ljava/lang/String;
    //   3019: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3022: ifne -> 3073
    //   3025: aload_1
    //   3026: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3029: getfield aTp : Ljava/lang/String;
    //   3032: astore #14
    //   3034: invokestatic zR : ()Lcom/laiqian/c/a;
    //   3037: invokevirtual Ab : ()Z
    //   3040: ifeq -> 3055
    //   3043: aload_1
    //   3044: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3047: getfield aTp : Ljava/lang/String;
    //   3050: astore #14
    //   3052: goto -> 3101
    //   3055: aload_1
    //   3056: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3059: getfield aTp : Ljava/lang/String;
    //   3062: ldc_w '****'
    //   3065: invokestatic bu : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3068: astore #14
    //   3070: goto -> 3101
    //   3073: aload_1
    //   3074: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3077: getfield aWn : Ljava/lang/String;
    //   3080: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3083: ifne -> 3098
    //   3086: aload_1
    //   3087: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3090: getfield aWn : Ljava/lang/String;
    //   3093: astore #14
    //   3095: goto -> 3101
    //   3098: aconst_null
    //   3099: astore #14
    //   3101: aload #14
    //   3103: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3106: ifne -> 3118
    //   3109: aload_0
    //   3110: aload #17
    //   3112: aload #14
    //   3114: invokespecial k : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   3117: pop
    //   3118: aload_1
    //   3119: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3122: getfield aWo : D
    //   3125: dconst_0
    //   3126: dcmpl
    //   3127: ifle -> 3147
    //   3130: aload_0
    //   3131: aload #17
    //   3133: aload_1
    //   3134: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3137: getfield aWo : D
    //   3140: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3143: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/lang/Double;)Z
    //   3146: pop
    //   3147: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3150: invokevirtual Cd : ()Z
    //   3153: ifeq -> 3201
    //   3156: new java/lang/StringBuilder
    //   3159: dup
    //   3160: invokespecial <init> : ()V
    //   3163: astore #14
    //   3165: aload #14
    //   3167: aload_1
    //   3168: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3171: getfield aWp : J
    //   3174: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   3177: pop
    //   3178: aload #14
    //   3180: ldc ''
    //   3182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3185: pop
    //   3186: aload_0
    //   3187: aload #17
    //   3189: ldc_w 2131628751
    //   3192: aload #14
    //   3194: invokevirtual toString : ()Ljava/lang/String;
    //   3197: invokespecial b : (Lcom/laiqian/print/b/e;ILjava/lang/String;)Z
    //   3200: pop
    //   3201: aload_1
    //   3202: getfield cyR : Ljava/util/ArrayList;
    //   3205: invokevirtual size : ()I
    //   3208: ifeq -> 3404
    //   3211: aload #17
    //   3213: bipush #45
    //   3215: invokevirtual l : (C)V
    //   3218: aload #17
    //   3220: iconst_3
    //   3221: newarray int
    //   3223: dup
    //   3224: iconst_0
    //   3225: bipush #12
    //   3227: iastore
    //   3228: dup
    //   3229: iconst_1
    //   3230: bipush #10
    //   3232: iastore
    //   3233: dup
    //   3234: iconst_2
    //   3235: bipush #10
    //   3237: iastore
    //   3238: invokevirtual n : ([I)V
    //   3241: aload #17
    //   3243: iconst_3
    //   3244: anewarray java/lang/String
    //   3247: dup
    //   3248: iconst_0
    //   3249: ldc_w 'GST'
    //   3252: aastore
    //   3253: dup
    //   3254: iconst_1
    //   3255: ldc_w 'Amount'
    //   3258: aastore
    //   3259: dup
    //   3260: iconst_2
    //   3261: ldc_w 'Tax'
    //   3264: aastore
    //   3265: invokevirtual x : ([Ljava/lang/String;)V
    //   3268: aload #17
    //   3270: bipush #45
    //   3272: invokevirtual l : (C)V
    //   3275: aload_1
    //   3276: getfield cyR : Ljava/util/ArrayList;
    //   3279: invokevirtual iterator : ()Ljava/util/Iterator;
    //   3282: astore_1
    //   3283: aload_1
    //   3284: invokeinterface hasNext : ()Z
    //   3289: ifeq -> 3404
    //   3292: aload_1
    //   3293: invokeinterface next : ()Ljava/lang/Object;
    //   3298: checkcast com/laiqian/product/models/p
    //   3301: astore #14
    //   3303: new java/lang/StringBuilder
    //   3306: dup
    //   3307: invokespecial <init> : ()V
    //   3310: astore #16
    //   3312: aload #16
    //   3314: aload #14
    //   3316: invokevirtual IT : ()Ljava/lang/String;
    //   3319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3322: pop
    //   3323: aload #16
    //   3325: ldc_w '='
    //   3328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: pop
    //   3332: aload #16
    //   3334: aload #14
    //   3336: invokevirtual alg : ()D
    //   3339: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   3342: pop
    //   3343: aload #16
    //   3345: ldc_w '%'
    //   3348: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3351: pop
    //   3352: aload #17
    //   3354: iconst_3
    //   3355: anewarray java/lang/String
    //   3358: dup
    //   3359: iconst_0
    //   3360: aload #16
    //   3362: invokevirtual toString : ()Ljava/lang/String;
    //   3365: aastore
    //   3366: dup
    //   3367: iconst_1
    //   3368: aload #14
    //   3370: invokevirtual ali : ()D
    //   3373: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3376: iconst_1
    //   3377: iconst_0
    //   3378: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   3381: aastore
    //   3382: dup
    //   3383: iconst_2
    //   3384: aload #14
    //   3386: invokevirtual alh : ()D
    //   3389: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3392: iconst_1
    //   3393: iconst_0
    //   3394: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   3397: aastore
    //   3398: invokevirtual x : ([Ljava/lang/String;)V
    //   3401: goto -> 3283
    //   3404: aload_2
    //   3405: invokevirtual aiw : ()I
    //   3408: ifne -> 3421
    //   3411: aload_2
    //   3412: invokevirtual aiq : ()Ljava/lang/String;
    //   3415: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3418: ifne -> 3428
    //   3421: aload #17
    //   3423: bipush #45
    //   3425: invokevirtual l : (C)V
    //   3428: aload_2
    //   3429: invokevirtual aiw : ()I
    //   3432: istore #10
    //   3434: aload_2
    //   3435: invokevirtual aix : ()Ljava/lang/String;
    //   3438: astore #14
    //   3440: aload #15
    //   3442: astore_1
    //   3443: aload_2
    //   3444: invokevirtual aiw : ()I
    //   3447: iconst_1
    //   3448: if_icmpne -> 3462
    //   3451: aload_0
    //   3452: getfield context : Landroid/content/Context;
    //   3455: ldc_w 2131628777
    //   3458: invokevirtual getString : (I)Ljava/lang/String;
    //   3461: astore_1
    //   3462: aload_0
    //   3463: aload #17
    //   3465: iload #10
    //   3467: aload #14
    //   3469: aload_1
    //   3470: invokespecial a : (Lcom/laiqian/print/b/e;ILjava/lang/String;Ljava/lang/String;)Z
    //   3473: istore_3
    //   3474: aload_2
    //   3475: invokevirtual aiq : ()Ljava/lang/String;
    //   3478: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3481: ifne -> 3495
    //   3484: iload_3
    //   3485: ifeq -> 3495
    //   3488: aload #17
    //   3490: bipush #45
    //   3492: invokevirtual l : (C)V
    //   3495: aload_0
    //   3496: aload #17
    //   3498: aload_2
    //   3499: invokevirtual aiq : ()Ljava/lang/String;
    //   3502: invokespecial l : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   3505: pop
    //   3506: aload_0
    //   3507: aload #17
    //   3509: aload_2
    //   3510: invokevirtual air : ()I
    //   3513: invokespecial a : (Lcom/laiqian/print/b/e;I)Z
    //   3516: pop
    //   3517: aload_0
    //   3518: aload #17
    //   3520: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   3523: aload_2
    //   3524: invokevirtual getCopies : ()I
    //   3527: invokespecial b : (Lcom/laiqian/print/model/PrintContent;I)Ljava/util/ArrayList;
    //   3530: areturn
    // Exception table:
    //   from	to	target	type
    //   1162	1181	1188	org/json/JSONException
    //   1254	1267	1350	org/json/JSONException
    //   1271	1284	1350	org/json/JSONException
    //   1288	1303	1350	org/json/JSONException
    //   1303	1326	1345	org/json/JSONException
    //   1337	1342	1350	org/json/JSONException
    //   1426	1439	1522	org/json/JSONException
    //   1426	1439	1522	java/lang/NullPointerException
    //   1443	1456	1522	org/json/JSONException
    //   1443	1456	1522	java/lang/NullPointerException
    //   1460	1475	1522	org/json/JSONException
    //   1460	1475	1522	java/lang/NullPointerException
    //   1475	1498	1517	org/json/JSONException
    //   1475	1498	1517	java/lang/NullPointerException
    //   1509	1514	1522	org/json/JSONException
    //   1509	1514	1522	java/lang/NullPointerException }
  
  public ArrayList<PrintContent> a(ReceiptPrintSettings paramReceiptPrintSettings, b paramb) { return a(paramb, paramReceiptPrintSettings); }
  
  public ArrayList<PrintContent> a(String paramString, ReceiptPrintSettings paramReceiptPrintSettings) {
    g g1 = gu(paramReceiptPrintSettings.getWidth());
    g1.f(paramString, 1, 1);
    a(g1, paramReceiptPrintSettings.air());
    return b(g1.afV(), paramReceiptPrintSettings.getCopies());
  }
  
  public ArrayList<e> a(ArrayList<PrintContent> paramArrayList, ReceiptPrintSettings paramReceiptPrintSettings) {
    ArrayList arrayList = new ArrayList();
    if (paramArrayList.size() <= 1) {
      for (s s : getPrinters()) {
        Iterator iterator = paramArrayList.iterator();
        while (iterator.hasNext())
          arrayList.add(a(s, (PrintContent)iterator.next(), paramReceiptPrintSettings)); 
      } 
    } else {
      Iterator iterator = paramArrayList.iterator();
      while (iterator.hasNext())
        arrayList.addAll(d((PrintContent)iterator.next())); 
    } 
    return arrayList;
  }
  
  public void a(b paramb) {
    if (paramb instanceof ReceiptPrintSettings)
      d.bj(this.context).b((ReceiptPrintSettings)paramb); 
  }
  
  public ArrayList<PrintContent> aiB() { return c(aiL()); }
  
  public ReceiptPrintSettings aiL() {
    ReceiptPrintSettings receiptPrintSettings = d.bj(this.context).aef();
    if (receiptPrintSettings.getTitle() == null)
      receiptPrintSettings.setTitle(((new an(this.context)).Vu()).aVs); 
    return receiptPrintSettings;
  }
  
  public ArrayList<e> al(ArrayList<PrintContent> paramArrayList) { return a(paramArrayList, aiL()); }
  
  public void am(ArrayList<PrintContent> paramArrayList) {
    for (s s : this.cDE.ahV()) {
      e e = g.cGS.f(s).D(paramArrayList);
      this.cDD.print(e);
    } 
  }
  
  public ArrayList<PrintContent> b(AliPayPreorderDetail paramAliPayPreorderDetail) { return a(paramAliPayPreorderDetail, aiL()); }
  
  public ArrayList<PrintContent> c(ReceiptPrintSettings paramReceiptPrintSettings) { return a(b.cyT, paramReceiptPrintSettings); }
  
  public ArrayList<e> d(PrintContent paramPrintContent) {
    ArrayList arrayList = new ArrayList();
    null = getPrinters();
    ReceiptPrintSettings receiptPrintSettings = aiL();
    Iterator iterator = null.iterator();
    while (iterator.hasNext())
      arrayList.add(a((s)iterator.next(), paramPrintContent, receiptPrintSettings)); 
    return arrayList;
  }
  
  public void e(PrintContent paramPrintContent) {
    for (s s : this.cDE.ahV()) {
      e e = g.cGS.f(s).a(paramPrintContent);
      this.cDD.print(e);
    } 
  }
  
  public List<s> getPrinters() { return this.cDE.ahV(); }
  
  @NonNull
  public String iQ(String paramString) {
    int j = paramString.length();
    if (j <= 4)
      return paramString; 
    int k = j - 4;
    int m = Math.min(4, k);
    StringBuilder stringBuilder1 = new StringBuilder();
    int i;
    for (i = 0; i < m; i++)
      stringBuilder1.append('*'); 
    i = Math.max(0, k - m);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString.substring(0, i));
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder2.append(paramString.substring(k, j));
    return stringBuilder2.toString();
  }
  
  public ArrayList<PrintContent> lZ(String paramString) { return a(paramString, aiL()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\receipt\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */