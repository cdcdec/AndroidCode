package com.laiqian.print.usage.tag.a;

import android.content.Context;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.b;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;
import com.laiqian.print.util.e;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Deprecated
public class a {
  private static a cOd;
  
  private g cDD;
  
  private c cDE;
  
  private Context context;
  
  private a(Context paramContext) {
    this.context = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.context);
  }
  
  private void a(PrintContent.a parama, HashMap<String, Object> paramHashMap, int paramInt, c paramc) {
    String str4;
    if (paramInt == 0) {
      String str6 = (String)paramHashMap.get("taste");
      String str5 = (String)paramHashMap.get("sProductName");
      str4 = str5;
      if (str6 != null) {
        str4 = str5;
        if (!str6.trim().isEmpty()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str5);
          stringBuilder.append("[");
          stringBuilder.append(str6);
          stringBuilder.append("]");
          String str = stringBuilder.toString();
        } 
      } 
    } else {
      str4 = (String)paramHashMap.get("sProductName");
    } 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramHashMap.get("nProductQty"));
    stringBuilder3.append("");
    double d3 = by.parseDouble(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramHashMap.get("fPrice"));
    stringBuilder3.append("");
    double d2 = by.parseDouble(stringBuilder3.toString());
    paramInt = e.ml(str4);
    int i = str4.length();
    if (paramInt <= 12) {
      parama.b(str4, true, false, 0, true, true);
    } else if (paramInt <= 24) {
      parama.b(str4.substring(0, i), true, false, 0, false, true);
    } else {
      parama.b(str4.substring(0, 10), true, false, 0, false, false);
      parama.b(str4.substring(10, str4.length()), true, false, 0, false, false);
    } 
    double d1 = d2;
    if (paramc.aiV() == paramc.cOm)
      d1 = d2 * d3; 
    null = new StringBuilder();
    null.append(CrashApplication.zA());
    null.append(n.b(this.context, Double.valueOf(d1), true));
    String str1 = null.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("x");
    stringBuilder2.append(d3);
    String str3 = stringBuilder2.toString();
    if (!paramc.cOi || paramc.aiV() == c.cOl)
      str3 = ""; 
    if (!paramc.cOj)
      str1 = ""; 
    String str2 = str1;
    if (!by.isNull(str3)) {
      null = new StringBuilder();
      null.append(" ");
      null.append(str1);
      str2 = null.toString();
    } 
    if (by.isNull(str3) && by.isNull(str2))
      return; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str3);
    stringBuilder1.append(str2);
    parama.ln(stringBuilder1.toString());
  }
  
  public static a bq(Context paramContext) {
    if (cOd == null)
      cOd = new a(paramContext.getApplicationContext()); 
    return cOd;
  }
  
  public ArrayList<PrintContent> a(s params, ArrayList<HashMap<String, Object>> paramArrayList, c paramc) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #21
    //   9: aload_1
    //   10: ifnull -> 25
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual getIdentifier : ()Ljava/lang/String;
    //   18: invokevirtual lX : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   21: astore_1
    //   22: goto -> 27
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_1
    //   28: astore #19
    //   30: aload_1
    //   31: ifnonnull -> 43
    //   34: new java/util/ArrayList
    //   37: dup
    //   38: invokespecial <init> : ()V
    //   41: astore #19
    //   43: aload_3
    //   44: invokevirtual getWidth : ()I
    //   47: istore #8
    //   49: aload_3
    //   50: invokevirtual getHeight : ()I
    //   53: istore #6
    //   55: aload_3
    //   56: invokevirtual aiW : ()Ljava/lang/String;
    //   59: astore #23
    //   61: new com/laiqian/util/av
    //   64: dup
    //   65: aload_0
    //   66: getfield context : Landroid/content/Context;
    //   69: invokespecial <init> : (Landroid/content/Context;)V
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual atY : ()Ljava/lang/String;
    //   77: astore #20
    //   79: aload_1
    //   80: invokevirtual aub : ()I
    //   83: istore #17
    //   85: aload_1
    //   86: invokevirtual close : ()V
    //   89: new java/util/Date
    //   92: dup
    //   93: invokespecial <init> : ()V
    //   96: astore #24
    //   98: aload_2
    //   99: invokevirtual size : ()I
    //   102: istore #10
    //   104: iconst_0
    //   105: istore #7
    //   107: iconst_0
    //   108: istore #9
    //   110: aload #21
    //   112: astore_1
    //   113: iload #9
    //   115: iload #10
    //   117: if_icmpge -> 205
    //   120: aload_2
    //   121: iload #9
    //   123: invokevirtual get : (I)Ljava/lang/Object;
    //   126: checkcast java/util/HashMap
    //   129: astore #21
    //   131: aload #19
    //   133: aload #21
    //   135: ldc 'nProductType'
    //   137: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast java/lang/String
    //   143: invokevirtual contains : (Ljava/lang/Object;)Z
    //   146: istore #18
    //   148: iload #18
    //   150: ifeq -> 156
    //   153: goto -> 196
    //   156: aload #21
    //   158: ldc 'nProductQty'
    //   160: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   163: checkcast java/lang/String
    //   166: invokestatic parseDouble : (Ljava/lang/String;)D
    //   169: dstore #4
    //   171: iload #7
    //   173: new java/text/DecimalFormat
    //   176: dup
    //   177: ldc '0'
    //   179: invokespecial <init> : (Ljava/lang/String;)V
    //   182: dload #4
    //   184: invokevirtual format : (D)Ljava/lang/String;
    //   187: invokestatic kF : (Ljava/lang/String;)Ljava/lang/String;
    //   190: invokestatic parseInt : (Ljava/lang/String;)I
    //   193: iadd
    //   194: istore #7
    //   196: iload #9
    //   198: iconst_1
    //   199: iadd
    //   200: istore #9
    //   202: goto -> 113
    //   205: iload #7
    //   207: sipush #1000
    //   210: if_icmple -> 215
    //   213: aconst_null
    //   214: areturn
    //   215: iconst_0
    //   216: istore #13
    //   218: iconst_1
    //   219: istore #9
    //   221: iload #8
    //   223: istore #12
    //   225: iload #6
    //   227: istore #11
    //   229: aload_1
    //   230: astore #22
    //   232: iload #10
    //   234: istore #6
    //   236: aload #20
    //   238: astore_1
    //   239: iload #9
    //   241: istore #8
    //   243: iload #13
    //   245: iload #6
    //   247: if_icmpge -> 968
    //   250: aload_2
    //   251: iload #13
    //   253: invokevirtual get : (I)Ljava/lang/Object;
    //   256: checkcast java/util/HashMap
    //   259: astore #25
    //   261: aload #19
    //   263: aload #25
    //   265: ldc 'nProductType'
    //   267: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   270: checkcast java/lang/String
    //   273: invokevirtual contains : (Ljava/lang/Object;)Z
    //   276: istore #18
    //   278: iload #18
    //   280: ifeq -> 312
    //   283: aload #19
    //   285: astore #20
    //   287: iload #8
    //   289: istore #14
    //   291: aload_1
    //   292: astore #21
    //   294: iload #6
    //   296: istore #9
    //   298: iload #7
    //   300: istore #10
    //   302: goto -> 940
    //   305: astore #20
    //   307: aload #20
    //   309: invokestatic e : (Ljava/lang/Throwable;)V
    //   312: aload #25
    //   314: ldc 'nProductQty'
    //   316: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   319: checkcast java/lang/String
    //   322: invokestatic parseDouble : (Ljava/lang/String;)D
    //   325: dstore #4
    //   327: new java/text/DecimalFormat
    //   330: dup
    //   331: ldc '0'
    //   333: invokespecial <init> : (Ljava/lang/String;)V
    //   336: dload #4
    //   338: invokevirtual format : (D)Ljava/lang/String;
    //   341: invokestatic parseInt : (Ljava/lang/String;)I
    //   344: istore #15
    //   346: iconst_0
    //   347: istore #16
    //   349: aload #19
    //   351: astore #20
    //   353: iload #8
    //   355: istore #14
    //   357: aload_1
    //   358: astore #21
    //   360: iload #6
    //   362: istore #9
    //   364: iload #7
    //   366: istore #10
    //   368: iload #16
    //   370: iload #15
    //   372: if_icmpge -> 940
    //   375: new com/laiqian/print/model/PrintContent$a
    //   378: dup
    //   379: invokespecial <init> : ()V
    //   382: astore #26
    //   384: new com/laiqian/print/b/d
    //   387: dup
    //   388: aload #26
    //   390: invokespecial <init> : (Lcom/laiqian/print/model/PrintContent$a;)V
    //   393: astore #27
    //   395: aload #27
    //   397: iconst_2
    //   398: newarray int
    //   400: dup
    //   401: iconst_0
    //   402: bipush #18
    //   404: iastore
    //   405: dup
    //   406: iconst_1
    //   407: bipush #6
    //   409: iastore
    //   410: invokevirtual n : ([I)V
    //   413: aload #27
    //   415: iconst_3
    //   416: invokevirtual setSize : (I)V
    //   419: aload #25
    //   421: ldc_w 'tableNo'
    //   424: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   427: ifeq -> 482
    //   430: aload #25
    //   432: ldc_w 'tableNo'
    //   435: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   438: ifnull -> 482
    //   441: new java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial <init> : ()V
    //   448: astore #20
    //   450: aload #20
    //   452: ldc ''
    //   454: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload #20
    //   460: aload #25
    //   462: ldc_w 'tableNo'
    //   465: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   468: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload #20
    //   474: invokevirtual toString : ()Ljava/lang/String;
    //   477: astore #20
    //   479: goto -> 506
    //   482: aload_1
    //   483: ifnull -> 502
    //   486: aload_1
    //   487: invokevirtual trim : ()Ljava/lang/String;
    //   490: invokevirtual isEmpty : ()Z
    //   493: ifne -> 502
    //   496: aload_1
    //   497: astore #20
    //   499: goto -> 506
    //   502: ldc ''
    //   504: astore #20
    //   506: iload #7
    //   508: iconst_1
    //   509: if_icmpeq -> 543
    //   512: ldc_w '%d-%d'
    //   515: iconst_2
    //   516: anewarray java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: iload #7
    //   523: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   526: aastore
    //   527: dup
    //   528: iconst_1
    //   529: iload #8
    //   531: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   534: aastore
    //   535: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   538: astore #21
    //   540: goto -> 547
    //   543: ldc ''
    //   545: astore #21
    //   547: aload #20
    //   549: invokevirtual isEmpty : ()Z
    //   552: ifeq -> 569
    //   555: aload #21
    //   557: invokevirtual isEmpty : ()Z
    //   560: ifne -> 566
    //   563: goto -> 569
    //   566: goto -> 751
    //   569: aload #27
    //   571: iconst_1
    //   572: invokevirtual setSize : (I)V
    //   575: aload #20
    //   577: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   580: ifne -> 649
    //   583: aload #21
    //   585: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   588: ifne -> 649
    //   591: new java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial <init> : ()V
    //   598: astore #28
    //   600: aload #28
    //   602: aload_0
    //   603: getfield context : Landroid/content/Context;
    //   606: ldc_w 2131628779
    //   609: invokevirtual getString : (I)Ljava/lang/String;
    //   612: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload #28
    //   618: aload #20
    //   620: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload #27
    //   626: iconst_2
    //   627: anewarray java/lang/String
    //   630: dup
    //   631: iconst_0
    //   632: aload #28
    //   634: invokevirtual toString : ()Ljava/lang/String;
    //   637: aastore
    //   638: dup
    //   639: iconst_1
    //   640: aload #21
    //   642: aastore
    //   643: invokevirtual x : ([Ljava/lang/String;)V
    //   646: goto -> 736
    //   649: aload #20
    //   651: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   654: ifne -> 712
    //   657: aload #27
    //   659: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   662: astore #21
    //   664: new java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial <init> : ()V
    //   671: astore #28
    //   673: aload #28
    //   675: aload_0
    //   676: getfield context : Landroid/content/Context;
    //   679: ldc_w 2131628779
    //   682: invokevirtual getString : (I)Ljava/lang/String;
    //   685: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload #28
    //   691: aload #20
    //   693: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload #21
    //   699: aload #28
    //   701: invokevirtual toString : ()Ljava/lang/String;
    //   704: iconst_1
    //   705: invokevirtual r : (Ljava/lang/String;I)Lcom/laiqian/print/model/PrintContent$a;
    //   708: pop
    //   709: goto -> 646
    //   712: aload #21
    //   714: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   717: ifne -> 646
    //   720: aload #27
    //   722: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   725: aload #21
    //   727: iconst_1
    //   728: iconst_2
    //   729: invokevirtual h : (Ljava/lang/String;II)Lcom/laiqian/print/model/PrintContent$a;
    //   732: pop
    //   733: goto -> 646
    //   736: aload #27
    //   738: iconst_3
    //   739: invokevirtual setSize : (I)V
    //   742: aload #26
    //   744: ldc_w '--------------------'
    //   747: invokevirtual ln : (Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   750: pop
    //   751: aload_0
    //   752: aload #26
    //   754: aload #25
    //   756: iload #17
    //   758: aload_3
    //   759: invokespecial a : (Lcom/laiqian/print/model/PrintContent$a;Ljava/util/HashMap;ILcom/laiqian/print/usage/tag/a/c;)V
    //   762: aload #26
    //   764: ldc_w '%s'
    //   767: iconst_1
    //   768: anewarray java/lang/Object
    //   771: dup
    //   772: iconst_0
    //   773: new java/text/SimpleDateFormat
    //   776: dup
    //   777: aload_0
    //   778: getfield context : Landroid/content/Context;
    //   781: ldc_w 2131627405
    //   784: invokevirtual getString : (I)Ljava/lang/String;
    //   787: invokespecial <init> : (Ljava/lang/String;)V
    //   790: aload #24
    //   792: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   795: aastore
    //   796: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   799: invokevirtual ln : (Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   802: pop
    //   803: aload #26
    //   805: aload #23
    //   807: invokevirtual ln : (Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   810: pop
    //   811: aload #26
    //   813: iload #12
    //   815: invokevirtual setWidth : (I)V
    //   818: aload #26
    //   820: iload #11
    //   822: invokevirtual setHeight : (I)V
    //   825: new java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial <init> : ()V
    //   832: astore #20
    //   834: aload #20
    //   836: iload #12
    //   838: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload #20
    //   844: ldc ''
    //   846: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload #26
    //   852: ldc_w 'width'
    //   855: aload #20
    //   857: invokevirtual toString : ()Ljava/lang/String;
    //   860: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   863: pop
    //   864: new java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial <init> : ()V
    //   871: astore #20
    //   873: aload #20
    //   875: iload #11
    //   877: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload #20
    //   883: ldc ''
    //   885: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload #26
    //   891: ldc_w 'height'
    //   894: aload #20
    //   896: invokevirtual toString : ()Ljava/lang/String;
    //   899: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   902: pop
    //   903: aload #26
    //   905: aload_3
    //   906: invokevirtual aiX : ()Z
    //   909: iconst_1
    //   910: invokevirtual s : (ZZ)Lcom/laiqian/print/model/PrintContent$a;
    //   913: pop
    //   914: aload #22
    //   916: aload #26
    //   918: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   921: invokevirtual add : (Ljava/lang/Object;)Z
    //   924: pop
    //   925: iload #8
    //   927: iconst_1
    //   928: iadd
    //   929: istore #8
    //   931: iload #16
    //   933: iconst_1
    //   934: iadd
    //   935: istore #16
    //   937: goto -> 349
    //   940: iload #13
    //   942: iconst_1
    //   943: iadd
    //   944: istore #13
    //   946: aload #20
    //   948: astore #19
    //   950: aload #21
    //   952: astore_1
    //   953: iload #9
    //   955: istore #6
    //   957: iload #10
    //   959: istore #7
    //   961: iload #14
    //   963: istore #8
    //   965: goto -> 243
    //   968: aload #22
    //   970: areturn
    //   971: astore #22
    //   973: goto -> 156
    // Exception table:
    //   from	to	target	type
    //   131	148	971	java/lang/ClassCastException
    //   261	278	305	java/lang/ClassCastException }
  
  public void a(b paramb) {
    if (paramb instanceof c)
      d.bj(this.context).a((c)paramb); 
  }
  
  public ArrayList<PrintContent> aiB() { return b(aiS()); }
  
  public c aiS() { return d.bj(this.context).aee(); }
  
  public ArrayList<PrintContent> b(c paramc) {
    ArrayList arrayList2 = new ArrayList();
    HashMap hashMap = new HashMap();
    String str1 = this.context.getString(2131628158);
    String str2 = this.context.getString(2131628157);
    hashMap.put("sProductName", str1);
    hashMap.put("taste", str2);
    hashMap.put("nProductQty", "1");
    hashMap.put("fPrice", "20.05");
    hashMap.put("fAmount", "100");
    hashMap.put("fOriginalPrice", "20");
    hashMap.put("tableNo", Integer.valueOf(123));
    arrayList2.add(hashMap);
    ArrayList arrayList1 = a(null, arrayList2, paramc);
    return (arrayList1 != null && arrayList1.size() > 0) ? arrayList1 : null;
  }
  
  public void e(PrintContent paramPrintContent) {
    for (s s : this.cDE.ahW()) {
      e e = g.cGS.f(s).a(paramPrintContent);
      this.cDD.print(e);
    } 
  }
  
  public List<s> getPrinters() { return this.cDE.ahW(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\tag\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */