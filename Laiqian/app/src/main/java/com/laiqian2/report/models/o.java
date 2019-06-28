package com.laiqian.report.models;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.format.Time;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.product.models.h;
import com.laiqian.product.models.p;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class o {
  public final ArrayList<p> aTR = new ArrayList();
  
  private double amountRounding;
  
  public String bch;
  
  public final String billNumber;
  
  public final int cTp;
  
  @Nullable
  public final String coJ;
  
  public double cpa;
  
  public final ArrayList<a> daR = new ArrayList();
  
  private HashMap<Integer, a> daS = new HashMap();
  
  public double daT;
  
  private double daU;
  
  private double daV;
  
  public final long daW;
  
  public final String daX;
  
  private double daY;
  
  private double daZ;
  
  private boolean dba = true;
  
  public String dbb;
  
  public double dbc;
  
  public double dbd;
  
  public final String dbe;
  
  public int numDecimal;
  
  public String openTableName;
  
  public final String orderNo;
  
  public final int orderSource;
  
  public o(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.orderNo = paramString1;
    this.cTp = paramInt1;
    this.daW = paramLong;
    this.orderSource = paramInt2;
    this.daX = paramString2;
    Time time = new Time();
    time.set(paramLong);
    this.dbe = time.format("%Y.%m.%d  %H:%M:%S");
    if (paramString3 != null) {
      this.coJ = paramString3;
    } else {
      this.coJ = null;
    } 
    this.amountRounding = 0.0D;
    this.daY = 0.0D;
    this.daZ = 0.0D;
    this.billNumber = paramString4;
    this.openTableName = paramString5;
  }
  
  public void a(int paramInt1, boolean paramBoolean, long paramLong1, String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt2, long paramLong2, int paramInt3, double paramDouble5, double paramDouble6, int paramInt4) { // Byte code:
    //   0: aload_0
    //   1: iload #23
    //   3: putfield numDecimal : I
    //   6: iconst_1
    //   7: istore #28
    //   9: dload #9
    //   11: invokestatic valueOf : (D)Ljava/lang/Double;
    //   14: iconst_1
    //   15: iconst_0
    //   16: iload #23
    //   18: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   21: invokestatic parseDouble : (Ljava/lang/String;)D
    //   24: dstore #9
    //   26: iload_2
    //   27: ifeq -> 33
    //   30: goto -> 36
    //   33: iconst_m1
    //   34: istore #28
    //   36: iload #28
    //   38: i2d
    //   39: dstore #24
    //   41: dload #9
    //   43: dload #24
    //   45: dmul
    //   46: dstore #26
    //   48: aload_0
    //   49: aload_0
    //   50: getfield daU : D
    //   53: dload #24
    //   55: dload #19
    //   57: dmul
    //   58: dadd
    //   59: putfield daU : D
    //   62: iload_1
    //   63: ldc 100068
    //   65: if_icmpne -> 91
    //   68: aload_0
    //   69: aload_0
    //   70: getfield cpa : D
    //   73: dload #24
    //   75: dload #11
    //   77: dmul
    //   78: dadd
    //   79: putfield cpa : D
    //   82: aload_0
    //   83: aload #5
    //   85: putfield dbb : Ljava/lang/String;
    //   88: goto -> 91
    //   91: iload_1
    //   92: ldc 100045
    //   94: if_icmpne -> 234
    //   97: new java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial <init> : ()V
    //   104: astore #29
    //   106: aload #29
    //   108: dload #13
    //   110: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload #29
    //   116: ldc ''
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload #29
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: invokestatic parseDouble : (Ljava/lang/String;)D
    //   130: dconst_0
    //   131: dcmpl
    //   132: ifne -> 141
    //   135: dconst_0
    //   136: dstore #9
    //   138: goto -> 241
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore #29
    //   150: aload #29
    //   152: dload #13
    //   154: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #29
    //   160: ldc ''
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #29
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: invokestatic parseDouble : (Ljava/lang/String;)D
    //   174: ldc2_w 2.0
    //   177: dcmpl
    //   178: ifne -> 189
    //   181: dload #11
    //   183: dneg
    //   184: dstore #9
    //   186: goto -> 241
    //   189: new java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial <init> : ()V
    //   196: astore #29
    //   198: aload #29
    //   200: dload #13
    //   202: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload #29
    //   208: ldc ''
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload #29
    //   216: invokevirtual toString : ()Ljava/lang/String;
    //   219: invokestatic parseDouble : (Ljava/lang/String;)D
    //   222: dconst_1
    //   223: dcmpl
    //   224: ifne -> 135
    //   227: dload #11
    //   229: dstore #9
    //   231: goto -> 241
    //   234: dload #7
    //   236: dload #26
    //   238: dmul
    //   239: dstore #9
    //   241: iload_1
    //   242: ldc 100001
    //   244: if_icmpeq -> 265
    //   247: iload_1
    //   248: ldc 100015
    //   250: if_icmpne -> 256
    //   253: goto -> 265
    //   256: aload_0
    //   257: dload #9
    //   259: putfield dbc : D
    //   262: goto -> 294
    //   265: aload_0
    //   266: dload #24
    //   268: dload #11
    //   270: dmul
    //   271: ldc2_w 100.0
    //   274: dload #21
    //   276: dsub
    //   277: dmul
    //   278: dload #21
    //   280: ddiv
    //   281: dload #9
    //   283: dload #21
    //   285: dmul
    //   286: ldc2_w 100.0
    //   289: ddiv
    //   290: dadd
    //   291: putfield dbc : D
    //   294: aload_0
    //   295: getfield dbc : D
    //   298: invokestatic isNaN : (D)Z
    //   301: ifeq -> 309
    //   304: aload_0
    //   305: dconst_0
    //   306: putfield dbc : D
    //   309: aload_0
    //   310: aload_0
    //   311: getfield daT : D
    //   314: aload_0
    //   315: getfield dbc : D
    //   318: dadd
    //   319: putfield daT : D
    //   322: dload #24
    //   324: dload #11
    //   326: dmul
    //   327: dstore #11
    //   329: aload_0
    //   330: getfield dba : Z
    //   333: ifeq -> 368
    //   336: dload #21
    //   338: ldc2_w 100.0
    //   341: dcmpl
    //   342: ifne -> 363
    //   345: iload_1
    //   346: ldc 100044
    //   348: if_icmpeq -> 363
    //   351: iload_1
    //   352: ldc 100045
    //   354: if_icmpeq -> 363
    //   357: iload_1
    //   358: ldc 100060
    //   360: if_icmpne -> 368
    //   363: aload_0
    //   364: iconst_0
    //   365: putfield dba : Z
    //   368: iload_1
    //   369: ldc 100060
    //   371: if_icmpne -> 407
    //   374: new com/laiqian/product/models/p
    //   377: dup
    //   378: lconst_0
    //   379: aload #5
    //   381: dconst_0
    //   382: dload #11
    //   384: dload #24
    //   386: dload #13
    //   388: dmul
    //   389: dload #9
    //   391: invokespecial <init> : (JLjava/lang/String;DDDD)V
    //   394: astore #5
    //   396: aload_0
    //   397: getfield aTR : Ljava/util/ArrayList;
    //   400: aload #5
    //   402: invokevirtual add : (Ljava/lang/Object;)Z
    //   405: pop
    //   406: return
    //   407: iload_1
    //   408: ldc 100045
    //   410: if_icmpne -> 468
    //   413: lload_3
    //   414: ldc2_w 101
    //   417: lcmp
    //   418: ifne -> 435
    //   421: aload_0
    //   422: aload_0
    //   423: getfield amountRounding : D
    //   426: dload #11
    //   428: dadd
    //   429: putfield amountRounding : D
    //   432: goto -> 468
    //   435: lload_3
    //   436: ldc2_w 7
    //   439: lcmp
    //   440: ifne -> 457
    //   443: aload_0
    //   444: aload_0
    //   445: getfield daV : D
    //   448: dload #11
    //   450: dadd
    //   451: putfield daV : D
    //   454: goto -> 468
    //   457: aload_0
    //   458: aload_0
    //   459: getfield dbd : D
    //   462: dload #11
    //   464: dadd
    //   465: putfield dbd : D
    //   468: new com/laiqian/report/models/o$a
    //   471: dup
    //   472: aload_0
    //   473: iload_1
    //   474: iload #15
    //   476: lload_3
    //   477: aload #5
    //   479: aload #6
    //   481: dload #7
    //   483: dload #26
    //   485: lload #16
    //   487: iload #18
    //   489: aconst_null
    //   490: invokespecial <init> : (Lcom/laiqian/report/models/o;IIJLjava/lang/String;Ljava/lang/String;DDJILcom/laiqian/report/models/p;)V
    //   493: astore #5
    //   495: aload #5
    //   497: iload #23
    //   499: putfield cUJ : I
    //   502: aload_0
    //   503: getfield cTp : I
    //   506: ldc 100001
    //   508: if_icmpne -> 650
    //   511: iload_1
    //   512: ldc 100001
    //   514: if_icmpeq -> 526
    //   517: iload_1
    //   518: ldc 100015
    //   520: if_icmpne -> 650
    //   523: goto -> 526
    //   526: aload_0
    //   527: getfield daS : Ljava/util/HashMap;
    //   530: iload #15
    //   532: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   535: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   538: checkcast com/laiqian/report/models/o$a
    //   541: astore #6
    //   543: aload #6
    //   545: ifnonnull -> 572
    //   548: iload_1
    //   549: ldc 100001
    //   551: if_icmpne -> 594
    //   554: aload_0
    //   555: getfield daS : Ljava/util/HashMap;
    //   558: iload #15
    //   560: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   563: aload #5
    //   565: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   568: pop
    //   569: goto -> 594
    //   572: iload_1
    //   573: ldc 100015
    //   575: if_icmpne -> 594
    //   578: aload #6
    //   580: aload #6
    //   582: getfield bTj : D
    //   585: aload #5
    //   587: getfield bTj : D
    //   590: dsub
    //   591: putfield bTj : D
    //   594: iload_1
    //   595: ldc 100001
    //   597: if_icmpne -> 610
    //   600: aload #5
    //   602: getfield bTj : D
    //   605: dstore #7
    //   607: goto -> 618
    //   610: aload #5
    //   612: getfield bTj : D
    //   615: dneg
    //   616: dstore #7
    //   618: dload #7
    //   620: dconst_0
    //   621: dcmpl
    //   622: ifle -> 639
    //   625: aload_0
    //   626: aload_0
    //   627: getfield daY : D
    //   630: dload #7
    //   632: dadd
    //   633: putfield daY : D
    //   636: goto -> 650
    //   639: aload_0
    //   640: aload_0
    //   641: getfield daZ : D
    //   644: dload #7
    //   646: dsub
    //   647: putfield daZ : D
    //   650: aload #5
    //   652: getfield cTp : I
    //   655: ldc 100068
    //   657: if_icmpeq -> 670
    //   660: aload_0
    //   661: getfield daR : Ljava/util/ArrayList;
    //   664: aload #5
    //   666: invokevirtual add : (Ljava/lang/Object;)Z
    //   669: pop
    //   670: return }
  
  public String amK() {
    if (!TextUtils.isEmpty(this.orderNo)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(RootApplication.zv().getString(R.string.pos_report_transaction_details_orderNo));
      stringBuilder1.append(this.orderNo);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zv().getString(R.string.pos_report_transaction_details_billnumber));
    stringBuilder.append(this.billNumber);
    return stringBuilder.toString();
  }
  
  public boolean amL() { return this.dba; }
  
  public String amM() { return n.d(Double.valueOf(this.daT)); }
  
  public double amN() { return this.daU; }
  
  public String amO() { return n.d(Double.valueOf(this.daU)); }
  
  public String amP() {
    double d = this.daT - this.daU;
    return n.bd(d) ? null : n.d(Double.valueOf(d));
  }
  
  public double amQ() { return this.cpa; }
  
  public String amR() { return this.dbb; }
  
  public double amS() { return this.amountRounding; }
  
  public double amT() { return this.dbd; }
  
  public Boolean amU() { return n.bc(this.daZ) ? Boolean.valueOf(true) : (n.bc(this.daY - this.daZ) ? Boolean.valueOf(false) : null); }
  
  public boolean amV() { return n.bc(this.daZ); }
  
  public void nl(String paramString) { this.bch = paramString; }
  
  public class a extends h {
    public final int aTS;
    
    public final int cTp;
    
    public final long dbf;
    
    private final double dbg;
    
    private a(o this$0, int param1Int1, int param1Int2, long param1Long1, String param1String1, String param1String2, double param1Double1, double param1Double2, long param1Long2, int param1Int3) { this(this$0, param1Int1, param1Int2, param1Long1, param1String1, param1String2, param1Double1, param1Double2, param1Long2, param1Int3, 0L); }
    
    private a(o this$0, int param1Int1, int param1Int2, long param1Long1, String param1String1, String param1String2, double param1Double1, double param1Double2, long param1Long2, int param1Int3, long param1Long3) {
      super(param1Long1, param1String1, param1String2, param1Double2, param1Double1, 600001, param1Long2, null, param1Double2, "", param1Int3, 0.0D);
      this.cTp = param1Int1;
      this.aTS = param1Int2;
      this.dbg = param1Double1;
      this.dbf = param1Long3;
    }
    
    public String aT(double param1Double) { return String.valueOf(n.f(new Object[] { Double.valueOf(param1Double), Double.valueOf(akI()) })); }
    
    public String amW() {
      double d;
      if (n.bc(this.bTj)) {
        d = this.dbg;
      } else {
        d = this.bTj;
      } 
      int i = this.cTp;
      if (i != 100045) {
        if (i != 100066) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("X");
          stringBuilder1.append(n.d(Double.valueOf(d)));
          return stringBuilder1.toString();
        } 
        if (d < 0.0D) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("X");
          stringBuilder1.append(n.d(Double.valueOf(-d)));
          return stringBuilder1.toString();
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X");
        stringBuilder.append(n.d(Double.valueOf(d)));
        return stringBuilder.toString();
      } 
      return "";
    }
    
    public String amX() { return (this.cTp == 100066) ? RootApplication.zv().getString(R.string.pos_retreat_food) : (amY() ? RootApplication.zv().getString(R.string.pos_return_finish) : n.d(Double.valueOf(akI() * this.bTj))); }
    
    public boolean amY() { return ((this.cTp == 100015 && this.dbh.cTp == 100001) || (n.bc(this.bTj) && !n.bc(this.dbg))); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */