package com.laiqian.product;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.main.d;
import com.laiqian.models.aw;
import com.laiqian.product.models.b;
import com.laiqian.product.models.o;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;

public class dq {
  private o cSc;
  
  private aw cSd;
  
  private ArrayList<d> cSe;
  
  private Context mContext;
  
  private String orderTypeID;
  
  public dq(Context paramContext) { this.mContext = paramContext; }
  
  private void a(ee paramee) {
    if (this.cSc != null) {
      paramee.setName(this.cSc.akZ());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.cSc.ala());
      stringBuilder.append("");
      paramee.my(stringBuilder.toString());
      paramee.jm(this.cSc.ald());
      paramee.gq(this.cSc.alb());
      paramee.jn(this.cSc.alc());
      paramee.mz(ajW());
    } 
  }
  
  public void a(long paramLong, ee paramee) {
    this.cSc = ajS().bO(paramLong);
    a(paramee);
  }
  
  public boolean a(long paramLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2, ee paramee) {
    boolean bool;
    try {
      aw aw1 = ajS();
      String str = paramee.getName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramee.akc());
      stringBuilder.append("");
      bool = aw1.a(paramLong, str, stringBuilder.toString(), paramee.akd(), paramee.akb(), paramArrayOfLong1, paramArrayOfLong2);
    } catch (Exception paramArrayOfLong1) {
      a.e(paramArrayOfLong1);
      bool = false;
    } 
    if (bool) {
      n.o(this.mContext.getResources().getString(2131628424));
      return bool;
    } 
    n.o(this.mContext.getResources().getString(2131628422));
    return bool;
  }
  
  public boolean a(long[] paramArrayOfLong, String paramString, ee paramee) {
    String str1 = String.valueOf(System.currentTimeMillis());
    aw aw1 = ajS();
    String str2 = paramee.getName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramee.akc());
    stringBuilder.append("");
    boolean bool = aw1.a(str1, str2, stringBuilder.toString(), paramee.akd(), paramee.akb(), paramArrayOfLong);
    if (bool) {
      f(paramString, str1, false);
      n.o(this.mContext.getResources().getString(2131628424));
      return bool;
    } 
    n.o(this.mContext.getResources().getString(2131628422));
    return bool;
  }
  
  public aw ajS() {
    if (this.cSd == null)
      this.cSd = new aw(this.mContext); 
    return this.cSd;
  }
  
  public ArrayList<o> ajT() { return gp(false); }
  
  public int ajU() { return ajS().Wv(); }
  
  public ArrayList<d> ajV() {
    b b = new b(this.mContext);
    this.cSe = b.akv();
    if (this.cSe == null)
      this.cSe = new ArrayList(); 
    b.close();
    return this.cSe;
  }
  
  public String ajW() {
    StringBuilder stringBuilder = new StringBuilder();
    if (by.isNull(this.orderTypeID) || this.cSe.size() == this.orderTypeID.split(",").length)
      return this.mContext.getResources().getString(2131627613); 
    for (byte b = 0; b < this.cSe.size(); b++) {
      d d = (d)this.cSe.get(b);
      String str = this.orderTypeID;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d.getId());
      stringBuilder1.append("");
      if (str.contains(stringBuilder1.toString())) {
        stringBuilder1 = new StringBuilder();
        if (by.isNull(stringBuilder.toString())) {
          str = "";
        } else {
          str = ",";
        } 
        stringBuilder1.append(str);
        stringBuilder1.append(d.KI());
        stringBuilder.append(stringBuilder1.toString());
      } 
    } 
    return stringBuilder.toString();
  }
  
  public boolean bP(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    f("", stringBuilder.toString(), true);
    return ajS().bP(paramLong);
  }
  
  public long[] bQ(long paramLong) { return ajS().bQ(paramLong); }
  
  public boolean f(String paramString1, String paramString2, boolean paramBoolean) { // Byte code:
    //   0: new com/laiqian/product/models/b
    //   3: dup
    //   4: aload_0
    //   5: getfield mContext : Landroid/content/Context;
    //   8: invokespecial <init> : (Landroid/content/Context;)V
    //   11: astore #9
    //   13: aload #9
    //   15: invokevirtual beginTransaction : ()V
    //   18: iconst_0
    //   19: istore #4
    //   21: iload #4
    //   23: aload_0
    //   24: getfield cSe : Ljava/util/ArrayList;
    //   27: invokevirtual size : ()I
    //   30: if_icmpge -> 349
    //   33: aload_0
    //   34: getfield cSe : Ljava/util/ArrayList;
    //   37: iload #4
    //   39: invokevirtual get : (I)Ljava/lang/Object;
    //   42: checkcast com/laiqian/main/d
    //   45: astore #10
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #8
    //   56: aload #8
    //   58: aload #10
    //   60: invokevirtual getId : ()J
    //   63: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload #8
    //   69: ldc ''
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: aload #8
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   84: ifne -> 94
    //   87: aload_1
    //   88: invokestatic isNull : (Ljava/lang/String;)Z
    //   91: ifeq -> 194
    //   94: iload_3
    //   95: ifne -> 194
    //   98: aload #10
    //   100: invokevirtual KG : ()Ljava/lang/String;
    //   103: invokestatic isNull : (Ljava/lang/String;)Z
    //   106: ifeq -> 124
    //   109: aload #9
    //   111: aload #10
    //   113: invokevirtual getId : ()J
    //   116: aload_2
    //   117: invokevirtual x : (JLjava/lang/String;)Z
    //   120: pop
    //   121: goto -> 340
    //   124: aload #10
    //   126: invokevirtual KG : ()Ljava/lang/String;
    //   129: aload_2
    //   130: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   133: ifne -> 340
    //   136: aload #10
    //   138: invokevirtual getId : ()J
    //   141: lstore #6
    //   143: new java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore #8
    //   152: aload #8
    //   154: aload #10
    //   156: invokevirtual KG : ()Ljava/lang/String;
    //   159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload #8
    //   165: ldc ','
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #8
    //   173: aload_2
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #9
    //   180: lload #6
    //   182: aload #8
    //   184: invokevirtual toString : ()Ljava/lang/String;
    //   187: invokevirtual x : (JLjava/lang/String;)Z
    //   190: pop
    //   191: goto -> 340
    //   194: aload #10
    //   196: invokevirtual KG : ()Ljava/lang/String;
    //   199: astore #11
    //   201: aload #11
    //   203: invokestatic isNull : (Ljava/lang/String;)Z
    //   206: ifne -> 340
    //   209: aload #11
    //   211: aload_2
    //   212: invokevirtual indexOf : (Ljava/lang/String;)I
    //   215: istore #5
    //   217: aload #11
    //   219: ldc ','
    //   221: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   224: ifeq -> 234
    //   227: ldc ','
    //   229: astore #8
    //   231: goto -> 238
    //   234: ldc ''
    //   236: astore #8
    //   238: iload #5
    //   240: ifle -> 284
    //   243: new java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial <init> : ()V
    //   250: astore #12
    //   252: aload #12
    //   254: aload #8
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload #12
    //   262: aload_2
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload #11
    //   269: aload #12
    //   271: invokevirtual toString : ()Ljava/lang/String;
    //   274: ldc ''
    //   276: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   279: astore #8
    //   281: goto -> 327
    //   284: iload #5
    //   286: ifne -> 340
    //   289: new java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial <init> : ()V
    //   296: astore #12
    //   298: aload #12
    //   300: aload_2
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #12
    //   307: aload #8
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #11
    //   315: aload #12
    //   317: invokevirtual toString : ()Ljava/lang/String;
    //   320: ldc ''
    //   322: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   325: astore #8
    //   327: aload #9
    //   329: aload #10
    //   331: invokevirtual getId : ()J
    //   334: aload #8
    //   336: invokevirtual x : (JLjava/lang/String;)Z
    //   339: pop
    //   340: iload #4
    //   342: iconst_1
    //   343: iadd
    //   344: istore #4
    //   346: goto -> 21
    //   349: aload #9
    //   351: invokevirtual setTransactionSuccessful : ()V
    //   354: aload #9
    //   356: invokevirtual endTransaction : ()V
    //   359: iconst_1
    //   360: ireturn }
  
  public ArrayList<o> gp(boolean paramBoolean) {
    ArrayList arrayList = ajS().eq(paramBoolean);
    return (arrayList != null) ? arrayList : new ArrayList();
  }
  
  public long[] mv(String paramString) {
    long[] arrayOfLong;
    boolean bool = by.isNull(paramString);
    byte b2 = 0;
    byte b1 = 0;
    if (bool) {
      long[] arrayOfLong1 = new long[this.cSe.size()];
      while (true) {
        arrayOfLong = arrayOfLong1;
        if (b1 < this.cSe.size()) {
          arrayOfLong1[b1] = ((d)this.cSe.get(b1)).getId();
          b1++;
          continue;
        } 
        break;
      } 
    } else {
      String[] arrayOfString = arrayOfLong.split(",");
      arrayOfLong = new long[arrayOfString.length];
      for (b1 = b2; b1 < arrayOfString.length; b1++)
        arrayOfLong[b1] = Long.valueOf(arrayOfString[b1]).longValue(); 
    } 
    return arrayOfLong;
  }
  
  public String mw(String paramString) {
    b b = new b(this.mContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    this.orderTypeID = b.mA(stringBuilder.toString());
    b.close();
    return this.orderTypeID;
  }
  
  public boolean mx(String paramString) { return ajS().iw(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */