package com.laiqian.opentable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.bh;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.print.b.e;
import com.laiqian.print.b.g;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.printtype.f;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.util.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class k implements j.f {
  k(h paramh) {}
  
  private List<PrintContent> a(b paramb, c paramc, j.i parami) {
    Context context = h.a(this.bYj);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramb.bXX.XY());
    stringBuilder1.append("");
    a a1 = b.o(context, stringBuilder1.toString());
    context = h.a(this.bYj);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramb.bXY.XY());
    stringBuilder2.append("");
    a a2 = b.o(context, stringBuilder2.toString());
    ArrayList arrayList = new ArrayList();
    g g = gu(paramc.getWidth());
    g.f(h.a(this.bYj).getString(2131630103), 3, 1);
    String str1 = new bh(h.a(this.bYj));
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramb.aEI);
    stringBuilder4.append("");
    String str2 = str1.iD(stringBuilder4.toString());
    str1.close();
    if (paramb.bXZ > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(".");
      stringBuilder.append(h.a(this.bYj).getString(2131626009));
      stringBuilder.append(paramb.bXZ);
      String str = stringBuilder.toString();
    } else {
      str1 = "";
    } 
    a(g, new Date(), str2);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(a1.XX());
    stringBuilder3.append(paramb.bXX.Vz());
    stringBuilder3.append(str1);
    stringBuilder3.append(h.a(this.bYj).getString(2131623988));
    stringBuilder3.append(a2.XX());
    stringBuilder3.append(paramb.bXY.Vz());
    a(g, stringBuilder3.toString(), 3);
    a(g, paramc.air());
    arrayList.add(g.afV());
    arrayList.add((new PrintContent.a()).agg().afV());
    return arrayList;
  }
  
  private List<PrintContent> a(b paramb, ReceiptPrintSettings paramReceiptPrintSettings, j.i parami) {
    Context context = h.a(this.bYj);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramb.bXX.XY());
    stringBuilder1.append("");
    a a1 = b.o(context, stringBuilder1.toString());
    context = h.a(this.bYj);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramb.bXY.XY());
    stringBuilder2.append("");
    a a2 = b.o(context, stringBuilder2.toString());
    paramReceiptPrintSettings.ais();
    g g = gu(paramReceiptPrintSettings.getWidth());
    String str2 = h.a(this.bYj).getString(2131630103);
    byte b2 = 3;
    g.f(str2, 3, 1);
    byte b1 = b2;
    switch (paramReceiptPrintSettings.ait()) {
      default:
        b1 = b2;
        break;
      case 1:
        b1 = 0;
        break;
      case 2:
        break;
    } 
    String str1 = new bh(h.a(this.bYj));
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramb.aEI);
    stringBuilder4.append("");
    String str3 = str1.iD(stringBuilder4.toString());
    str1.close();
    if (paramb.bXZ > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(".");
      stringBuilder.append(h.a(this.bYj).getString(2131626009));
      stringBuilder.append(paramb.bXZ);
      String str = stringBuilder.toString();
    } else {
      str1 = "";
    } 
    a(g, new Date(), str3);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(a1.XX());
    stringBuilder3.append(paramb.bXX.Vz());
    stringBuilder3.append(str1);
    stringBuilder3.append(h.a(this.bYj).getString(2131623988));
    stringBuilder3.append(a2.XX());
    stringBuilder3.append(paramb.bXY.Vz());
    a(g, stringBuilder3.toString(), b1);
    a(g, paramReceiptPrintSettings.air());
    g.afT().ih(parami.getCopies());
    return Collections.singletonList(g.afV());
  }
  
  private boolean a(e parame, int paramInt) {
    for (byte b = 0; b < paramInt; b++)
      parame.afT().ln(""); 
    return true;
  }
  
  private boolean a(e parame, String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    parame.l('-');
    parame.f(paramString, paramInt, 0);
    parame.l('-');
    return true;
  }
  
  private boolean a(e parame, Date paramDate, String paramString) {
    String str1;
    if (parame == null)
      return false; 
    if (paramDate == null)
      return false; 
    String str2 = Xn().format(paramDate);
    if (paramString != null) {
      str1 = iP(paramString);
    } else {
      str1 = "";
    } 
    parame.x(new String[] { str2, str1 });
    return true;
  }
  
  private g gu(int paramInt) {
    g g = new g();
    g.setWidth(paramInt);
    g.ic(CrashApplication.aIQ);
    g.n(new int[] { 17, 15 });
    return g;
  }
  
  private String iP(String paramString) {
    String str1 = "";
    bh bh = new bh(h.a(this.bYj));
    String str2 = bh.iC(paramString);
    bh.close();
    if (!TextUtils.isEmpty(str2))
      str1 = str2; 
    return !n.bL(h.a(this.bYj)) ? (str1.equals(paramString) ? paramString : str1) : (str1.equals(paramString) ? iQ(paramString) : m(str1, 1));
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
  
  public SimpleDateFormat Xn() { return new SimpleDateFormat(h.a(this.bYj).getString(2131627405)); }
  
  public List<PrintContent> a(Object paramObject, String paramString, j.i parami, f paramf) { // Byte code:
    //   0: aload_1
    //   1: checkcast com/laiqian/opentable/b
    //   4: astore_1
    //   5: aload_2
    //   6: invokevirtual hashCode : ()I
    //   9: istore #5
    //   11: iload #5
    //   13: ldc_w -271337091
    //   16: if_icmpeq -> 46
    //   19: iload #5
    //   21: ldc_w 944124393
    //   24: if_icmpeq -> 30
    //   27: goto -> 62
    //   30: aload_2
    //   31: ldc_w 'kitchen_not_specified'
    //   34: invokevirtual equals : (Ljava/lang/Object;)Z
    //   37: ifeq -> 62
    //   40: iconst_1
    //   41: istore #5
    //   43: goto -> 65
    //   46: aload_2
    //   47: ldc_w 'receipt_not_specified'
    //   50: invokevirtual equals : (Ljava/lang/Object;)Z
    //   53: ifeq -> 62
    //   56: iconst_0
    //   57: istore #5
    //   59: goto -> 65
    //   62: iconst_m1
    //   63: istore #5
    //   65: iload #5
    //   67: tableswitch default -> 88, 0 -> 111, 1 -> 99
    //   88: new java/lang/IllegalArgumentException
    //   91: dup
    //   92: ldc_w 'no match'
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: athrow
    //   99: aload_0
    //   100: aload_1
    //   101: aload #4
    //   103: checkcast com/laiqian/print/usage/kitchen/a/c
    //   106: aload_3
    //   107: invokespecial a : (Lcom/laiqian/opentable/b;Lcom/laiqian/print/usage/kitchen/a/c;Lcom/laiqian/print/j$i;)Ljava/util/List;
    //   110: areturn
    //   111: aload_0
    //   112: aload_1
    //   113: aload #4
    //   115: checkcast com/laiqian/print/usage/receipt/model/ReceiptPrintSettings
    //   118: aload_3
    //   119: invokespecial a : (Lcom/laiqian/opentable/b;Lcom/laiqian/print/usage/receipt/model/ReceiptPrintSettings;Lcom/laiqian/print/j$i;)Ljava/util/List;
    //   122: areturn }
  
  @NonNull
  public String iQ(String paramString) {
    int j = paramString.length();
    if (j <= 4)
      return paramString; 
    int m = j - 4;
    int n = Math.min(4, m);
    StringBuilder stringBuilder1 = new StringBuilder();
    int i;
    for (i = 0; i < n; i++)
      stringBuilder1.append('*'); 
    i = Math.max(0, m - n);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString.substring(0, i));
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder2.append(paramString.substring(m, j));
    return stringBuilder2.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */