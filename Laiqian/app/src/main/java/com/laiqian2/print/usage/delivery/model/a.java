package com.laiqian.print.usage.delivery.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.main.fg;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.industry.weiorder.eh;
import com.laiqian.pos.model.orders.WeiOrderDetail;
import com.laiqian.pos.model.orders.a;
import com.laiqian.print.b.a;
import com.laiqian.print.b.d;
import com.laiqian.print.b.e;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.c;
import com.laiqian.product.models.o;
import com.laiqian.product.models.p;
import com.laiqian.util.am;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
public class a {
  private static a cMA;
  
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
  
  private void a(e parame, PendingFullOrderDetail.d paramd) {
    double d1 = Math.abs(paramd.cpo);
    if (paramd.cpo < 0.0D)
      paramd.cpn = 0.0D; 
    String str4 = n.a(Double.valueOf(d1), false, false, parame.afU());
    String str2 = n.a(Double.valueOf(paramd.cpn * paramd.cpo), true, false);
    if (paramd.cpt != null)
      str2 = n.a(Double.valueOf(d1 * paramd.cpt.doubleValue()), true, false); 
    String str3 = paramd.name;
    String str1 = str3;
    if (paramd.cpx == 3L) {
      str1 = str3;
      if (!str3.startsWith("|-")) {
        null = new StringBuilder();
        null.append("|-");
        null.append(str3);
        str1 = null.toString();
      } 
    } 
    str3 = str1;
    if (a.AZ().BV()) {
      ArrayList arrayList = new ArrayList();
      for (o o : paramd.aTR) {
        if (o.alc() == 1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(o.akZ());
          stringBuilder.append("*");
          arrayList.add(stringBuilder.toString());
          continue;
        } 
        arrayList.add(o.akZ());
      } 
      str3 = str1;
      if (arrayList.size() > 0) {
        null = new StringBuilder();
        null.append(str1);
        null.append("(");
        null.append(by.a("/", arrayList));
        null.append(")");
        str3 = null.toString();
      } 
    } 
    if (paramd.cpo < 0.0D) {
      parame.x(new String[] { str3, str4, this.context.getString(2131628116) });
    } else {
      parame.x(new String[] { str3, str4, str2 });
    } 
    if (!TextUtils.isEmpty(paramd.cpm)) {
      if (paramd.cpx == 3L && !paramd.cpm.startsWith("|-")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(paramd.cpm);
        parame.ll(stringBuilder.toString());
        return;
      } 
      parame.ll(paramd.cpm);
    } 
  }
  
  private boolean a(a parama, Date paramDate, String paramString) {
    String str1;
    if (parama == null)
      return false; 
    if (paramDate == null)
      return false; 
    g g1 = new g(parama);
    g1.n(new int[] { 3, 2 });
    if (a.zR().Ab()) {
      str1 = Xn().format(paramDate);
      if (paramString == null)
        paramString = ""; 
      g1.x(new String[] { str1, paramString });
      return true;
    } 
    String str2 = Xn().format(paramDate);
    if (paramString != null) {
      str1 = by.bu(paramString, "****");
    } else {
      str1 = "";
    } 
    g1.x(new String[] { str2, str1 });
    return true;
  }
  
  private boolean a(e parame) {
    parame.x(new String[] { this.context.getString(2131628769), this.context.getString(2131628771), this.context.getString(2131628783) });
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
  
  private boolean a(e parame, eh parameh) {
    if (parameh != null) {
      parame.x(new String[] { String.format(this.context.getString(2131630537), new Object[] { n.a(Double.valueOf(parameh.abM()), true, false, parame.afU()), n.a(Double.valueOf(parameh.FI()), true, false, parame.afU()) }), n.a(Double.valueOf(-parameh.FI()), true, false, parame.afU()) });
      return true;
    } 
    return false;
  }
  
  private boolean a(e parame, Double paramDouble) { return a(parame, paramDouble, false); }
  
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
  
  private boolean a(e parame, String paramString) {
    parame.lk(String.format("%s %s", new Object[] { this.context.getString(2131628305), paramString }));
    return true;
  }
  
  private boolean a(e parame, String paramString, Number paramNumber) {
    if (paramNumber == null)
      return false; 
    if (paramNumber instanceof Double) {
      parame.x(new String[] { paramString, n.a((Double)paramNumber, true, false) });
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
  
  private boolean a(e parame, ArrayList<HashMap<String, Object>> paramArrayList, boolean paramBoolean, int paramInt) { return a(parame, paramArrayList, paramBoolean, paramInt, false); }
  
  private boolean a(e parame, @NonNull ArrayList<HashMap<String, Object>> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    String str = "";
    if (paramBoolean1)
      str = "-"; 
    parame.x(new String[] { this.context.getString(2131628769), this.context.getString(2131628771), this.context.getString(2131628783) });
    parame.l('-');
    int i = parame.getSize();
    parame.setSize(paramInt);
    int j = paramArrayList.size();
    for (paramInt = 0; paramInt < j * 2; paramInt++) {
      int k;
      if (paramInt >= j) {
        k = paramInt - j;
      } else {
        k = paramInt;
      } 
      HashMap hashMap = (HashMap)paramArrayList.get(k);
      double d = Double.valueOf(hashMap.get("nProductQty").toString()).doubleValue();
      if ((paramInt < j) ? (d < 0.0D) : (d > 0.0D)) {
        String str3 = null;
        if (hashMap.containsKey("taste"))
          str3 = (String)hashMap.get("taste"); 
        String str2 = (String)hashMap.get("sProductName");
        String str1 = str2;
        if (hashMap.containsKey("nFoodCategory")) {
          str1 = str2;
          if (hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
            str1 = str2;
            if (!str2.startsWith("|-")) {
              String str5;
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
                null = new StringBuilder();
                null.append(str2);
                null.append("<");
                null.append(this.context.getString(2131628754));
                null.append(">");
                str1 = null.toString();
              }  
          } 
        } 
        String str4 = n.a(Double.valueOf(Math.abs(d)), false, false, parame.afU());
        str2 = n.a((String)hashMap.get("fAmount"), true, false);
        if (hashMap.containsKey("fOriginalPrice")) {
          double d2;
          double d3 = Double.parseDouble((String)hashMap.get("nProductQty"));
          double d1 = Double.parseDouble((String)hashMap.get("fOriginalPrice"));
          if (hashMap.containsKey("fDBOriginalPrice"))
            d1 = Double.parseDouble((String)hashMap.get("fDBOriginalPrice")); 
          if (hashMap.containsKey("selectTastesPrice")) {
            d2 = ((Double)hashMap.get("selectTastesPrice")).doubleValue();
          } else {
            d2 = 0.0D;
          } 
          str2 = n.a(Double.valueOf(d3 * (d1 + d2)), true, false);
        } 
        str3 = str1;
        if (a.AZ().BV()) {
          str3 = str1;
          if (hashMap.containsKey("taxList")) {
            str3 = str1;
            if (hashMap.get("taxList") != null) {
              null = (ArrayList)hashMap.get("taxList");
              ArrayList arrayList = new ArrayList();
              for (o o : null) {
                if (o.alc() == 1) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(o.akZ());
                  stringBuilder.append("*");
                  arrayList.add(stringBuilder.toString());
                  continue;
                } 
                arrayList.add(o.akZ());
              } 
              str3 = str1;
              if (arrayList.size() > 0) {
                null = new StringBuilder();
                null.append(str1);
                null.append("(");
                null.append(by.a("/", arrayList));
                null.append(")");
                str3 = null.toString();
              } 
            } 
          } 
        } 
        if (hashMap.containsKey("nProductTransacType") && ((Long)hashMap.get("nProductTransacType")).longValue() == 100015L) {
          k = 1;
        } else {
          k = 0;
        } 
        if (d < 0.0D) {
          parame.x(new String[] { str3, str4, this.context.getString(2131628116) });
        } else if (!paramBoolean1 && k != 0) {
          parame.x(new String[] { str3, str4, this.context.getString(2131628745) });
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append(str2);
          parame.x(new String[] { str3, str4, stringBuilder.toString() });
        } 
        if (hashMap.containsKey("sSpareField5") && !TextUtils.isEmpty((String)hashMap.get("sSpareField5")))
          if (hashMap.containsKey("nFoodCategory") && hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("|-");
            stringBuilder.append(hashMap.get("sSpareField5"));
            parame.ll(stringBuilder.toString());
          } else {
            parame.ll((String)hashMap.get("sSpareField5"));
          }  
      } 
    } 
    parame.setSize(i);
    return true;
  }
  
  private boolean a(e parame, Collection<PendingFullOrderDetail.d> paramCollection, int paramInt, boolean paramBoolean) {
    Iterator iterator;
    int i = parame.getSize();
    parame.setSize(paramInt);
    if (paramBoolean) {
      iterator = paramCollection.iterator();
      while (iterator.hasNext())
        a(parame, (PendingFullOrderDetail.d)iterator.next()); 
    } else {
      iterator = iterator.iterator();
      while (iterator.hasNext())
        b(parame, (PendingFullOrderDetail.d)iterator.next()); 
    } 
    parame.setSize(i);
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
  
  private void b(e parame, PendingFullOrderDetail.d paramd) {
    double d1 = paramd.cpo;
    String str4 = n.a(Double.valueOf(d1), false, false, parame.afU());
    String str2 = n.a(Double.valueOf(paramd.cpn * paramd.cpo), true, false);
    if (paramd.cpt != null)
      str2 = n.a(Double.valueOf(d1 * paramd.cpt.doubleValue()), true, false); 
    String str3 = paramd.name;
    String str1 = str3;
    if (paramd.cpx == 3L) {
      str1 = str3;
      if (!str3.startsWith("|-")) {
        null = new StringBuilder();
        null.append("|-");
        null.append(str3);
        str1 = null.toString();
      } 
    } 
    str3 = str1;
    if (a.AZ().BV()) {
      ArrayList arrayList = new ArrayList();
      for (o o : paramd.aTR) {
        if (o.alc() == 1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(o.akZ());
          stringBuilder.append("*");
          arrayList.add(stringBuilder.toString());
          continue;
        } 
        arrayList.add(o.akZ());
      } 
      str3 = str1;
      if (arrayList.size() > 0) {
        null = new StringBuilder();
        null.append(str1);
        null.append("(");
        null.append(by.a("/", arrayList));
        null.append(")");
        str3 = null.toString();
      } 
    } 
    parame.x(new String[] { str3, str4, str2 });
    if (!TextUtils.isEmpty(paramd.cpm)) {
      if (paramd.cpx == 3L && paramd.cpm.startsWith("|-")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(paramd.cpm);
        parame.ll(stringBuilder.toString());
        return;
      } 
      parame.ll(paramd.cpm);
    } 
  }
  
  private boolean b(e parame, int paramInt, String paramString) {
    if (paramString == null)
      return false; 
    parame.x(new String[] { this.context.getString(paramInt), paramString });
    return true;
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
  
  private boolean b(e parame, Date paramDate) {
    g g1 = new g(parame.afT());
    g1.setWidth(parame.getWidth());
    g1.ic(parame.afU());
    g1.n(new int[] { 10, 22 });
    g1.x(new String[] { this.context.getString(2131628762), Xn().format(paramDate) });
    return true;
  }
  
  public static a bk(Context paramContext) {
    if (cMA == null)
      cMA = new a(paramContext.getApplicationContext()); 
    return cMA;
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
  
  private boolean c(e parame, String paramString) {
    if (parame == null)
      return false; 
    parame.x(new String[] { this.context.getString(2131625916), paramString });
    return true;
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
  
  private boolean d(e parame, String paramString) {
    if (paramString == null)
      return false; 
    parame.lk(String.format("%s : %s", new Object[] { this.context.getString(2131628760), paramString }));
    return true;
  }
  
  private boolean e(e parame, String paramString) {
    parame.f(by.G(paramString, 100), 3, 0);
    return true;
  }
  
  private boolean f(e parame, String paramString) { return c(parame, paramString, -1); }
  
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
  
  private boolean l(e parame, String paramString) {
    parame.ll(paramString);
    return true;
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
  
  public e a(s params, PrintContent paramPrintContent, DeliveryPrintSettings paramDeliveryPrintSettings) {
    e e = g.cGS.f(params).a(paramPrintContent);
    e.cx(TimeUnit.SECONDS.toMillis(paramDeliveryPrintSettings.aiy()));
    return e;
  }
  
  public ArrayList<PrintContent> a(PendingFullOrderDetail paramPendingFullOrderDetail, DeliveryPrintSettings paramDeliveryPrintSettings, boolean paramBoolean) {
    byte b1;
    if (paramDeliveryPrintSettings.ais() == 1) {
      b1 = 0;
    } else {
      b1 = 1;
    } 
    StringBuilder stringBuilder = paramPendingFullOrderDetail.bXb.coJ;
    int i = paramPendingFullOrderDetail.bXb.bZF;
    null = new b.a();
    a2 = null;
    if (i == 2) {
      a2 = null;
      if (stringBuilder != null) {
        b.a a2;
        null = this.context;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramPendingFullOrderDetail.bXb.aEI);
        stringBuilder1.append("");
        a2 = b.a(null, stringBuilder1.toString(), Long.valueOf(Long.parseLong(paramPendingFullOrderDetail.bXb.coJ)), true);
        paramPendingFullOrderDetail.bXb.ceV = a2.bfo;
      } 
    } 
    g g1 = gu(paramDeliveryPrintSettings.getWidth());
    if (paramBoolean)
      g1.lk(this.context.getString(2131628774)); 
    if (paramPendingFullOrderDetail.bXb.bZF == 1)
      g1.lk("Phone Order"); 
    byte b3 = 3;
    if (i == 2) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a2.bZc);
      stringBuilder.append("-");
      stringBuilder.append(a2.bTe);
      a(g1, stringBuilder.toString());
      paramPendingFullOrderDetail.bXb.coE = new Date();
    } else if (stringBuilder != null) {
      b(g1, stringBuilder);
      g1.f(this.context.getString(2131628766), 3, 1);
    } 
    if (i == 1)
      d(g1, paramPendingFullOrderDetail.bXb.coS); 
    byte b2 = b3;
    switch (paramDeliveryPrintSettings.ait()) {
      default:
        b2 = b3;
        break;
      case 1:
        b2 = 0;
        break;
      case 2:
        break;
    } 
    b(g1, paramDeliveryPrintSettings.getTitle(), b2);
    a(g1, paramPendingFullOrderDetail.bXb.coE, paramPendingFullOrderDetail.bXb.ceV);
    if (i == 2)
      c(g1, a2.bZd); 
    if (!TextUtils.isEmpty(paramPendingFullOrderDetail.bXb.coK))
      g1.x(new String[] { this.context.getString(2131628739), by.bu(paramPendingFullOrderDetail.bXb.coK, "****") }); 
    if (paramPendingFullOrderDetail.bXb.bZF == 1) {
      g1.l('-');
      e(g1, paramPendingFullOrderDetail.bXb.coQ);
      f(g1, paramPendingFullOrderDetail.bXb.coP);
      String[] arrayOfString = paramPendingFullOrderDetail.bXb.headerText.split("`");
      if (arrayOfString.length > 0)
        g(g1, arrayOfString[0]); 
      if (arrayOfString.length > 1)
        h(g1, arrayOfString[1]); 
      if (arrayOfString.length > 2)
        i(g1, arrayOfString[2]); 
    } 
    g1.l('-');
    a(g1);
    g1.l('-');
    a(g1, paramPendingFullOrderDetail.coy, b1, true);
    for (PendingFullOrderDetail.c c1 : paramPendingFullOrderDetail.coz) {
      g1.l('-');
      a(g1, c1.cpg, b1, true);
    } 
    g1.l('-');
    null = paramPendingFullOrderDetail.aaE();
    double d = null.acP();
    a.a a1 = null.acQ();
    d += a1.aTG;
    if (!n.bc(a1.cyF)) {
      a(g1, "Sales amount", Double.valueOf(d - a1.cyF));
      a(g1, "Total tax", Double.valueOf(a1.cyF));
    } 
    a(g1, Double.valueOf(d));
    if (!TextUtils.isEmpty(paramDeliveryPrintSettings.aiq()))
      g1.l('-'); 
    g1.ll(paramDeliveryPrintSettings.aiq());
    a(g1, paramDeliveryPrintSettings.air());
    return b(g1.afV(), paramDeliveryPrintSettings.getCopies());
  }
  
  public ArrayList<PrintContent> a(WeiOrderDetail paramWeiOrderDetail, DeliveryPrintSettings paramDeliveryPrintSettings) {
    g g1 = gu(paramDeliveryPrintSettings.getWidth());
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
    } else if (paramWeiOrderDetail.type == 5) {
      String str;
      if (paramWeiOrderDetail.czk == 0L) {
        str = this.context.getString(2131628755);
      } else {
        str = this.context.getString(2131628780);
      } 
      g1.f(String.format("%s-%s", new Object[] { "Phone Order", str }), 1, 1);
    } 
    if (paramWeiOrderDetail.type == 2 || paramWeiOrderDetail.type == 3) {
      b(g1, paramWeiOrderDetail.number.toString());
    } else {
      d(g1, paramWeiOrderDetail.number);
    } 
    a(g1, paramDeliveryPrintSettings.aiu(), paramDeliveryPrintSettings.aiv());
    switch (paramDeliveryPrintSettings.ait()) {
      default:
        i = 3;
        break;
      case 1:
        i = 0;
        break;
    } 
    b(g1, paramDeliveryPrintSettings.getTitle(), i);
    if (paramWeiOrderDetail.czh.size() > 0)
      g1.lk("Tax Invoice"); 
    if (!TextUtils.isEmpty(paramWeiOrderDetail.czl))
      b(g1, 2131628731, paramWeiOrderDetail.czl); 
    b(g1, paramWeiOrderDetail.cza);
    if (paramWeiOrderDetail.type == 1)
      c(g1, paramWeiOrderDetail.czb); 
    if (!TextUtils.isEmpty(paramWeiOrderDetail.czi)) {
      o(g1, paramWeiOrderDetail.czi);
      p(g1, paramWeiOrderDetail.czj);
    } 
    n(g1, paramWeiOrderDetail.ceV);
    if (paramWeiOrderDetail.type == 4 && paramWeiOrderDetail.orderNo != null)
      m(g1, paramWeiOrderDetail.orderNo); 
    if (!TextUtils.isEmpty(paramWeiOrderDetail.text))
      g1.f(String.format("%s:%s", new Object[] { this.context.getString(2131628756), paramWeiOrderDetail.text }), 3, 0); 
    g1.l('-');
    e(g1, paramWeiOrderDetail.czc);
    if (paramWeiOrderDetail.type == 1 || paramWeiOrderDetail.type == 4 || paramWeiOrderDetail.type == 5) {
      c(g1, paramWeiOrderDetail.aVX, paramWeiOrderDetail.aVY);
      g(g1, paramWeiOrderDetail.aRu);
      h(g1, paramWeiOrderDetail.address);
      i(g1, paramWeiOrderDetail.aTq);
    } 
    g1.l('-');
    a(g1, paramWeiOrderDetail.bJf, paramWeiOrderDetail.aWa, iH(paramDeliveryPrintSettings.ais()));
    int i = g1.getSize();
    g1.setSize(iH(paramDeliveryPrintSettings.ais()));
    a(g1, paramWeiOrderDetail.cvD);
    if (paramWeiOrderDetail.discountAmount != 0.0D)
      c(g1, Double.valueOf(paramWeiOrderDetail.discountAmount)); 
    g1.setSize(i);
    if (paramWeiOrderDetail.type == 4) {
      g1.l('-');
      if (paramWeiOrderDetail.czf != null)
        a(g1, this.context.getString(2131630539), paramWeiOrderDetail.czf); 
      if (paramWeiOrderDetail.cze != null)
        a(g1, this.context.getString(2131630540), paramWeiOrderDetail.cze); 
      for (Map.Entry entry : paramWeiOrderDetail.czg.entrySet()) {
        if (n.bc(((Double)entry.getValue()).doubleValue())) {
          g1.ll((String)entry.getKey());
          continue;
        } 
        a(g1, (String)entry.getKey(), (Number)entry.getValue());
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
    a(g1, paramWeiOrderDetail.cpc);
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
    if (paramWeiOrderDetail.type == 5) {
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
    i = paramDeliveryPrintSettings.aiw();
    if (paramWeiOrderDetail.type == 1 && i == 1) {
      g1.l('-');
      a(g1, 1, null, this.context.getString(2131628777));
    } 
    if (!TextUtils.isEmpty(paramDeliveryPrintSettings.aiq())) {
      g1.l('-');
      l(g1, paramDeliveryPrintSettings.aiq());
    } 
    a(g1, paramDeliveryPrintSettings.air());
    return b(g1.afV(), paramDeliveryPrintSettings.getCopies());
  }
  
  public ArrayList<e> a(ArrayList<PrintContent> paramArrayList, DeliveryPrintSettings paramDeliveryPrintSettings) {
    ArrayList arrayList = new ArrayList();
    if (paramArrayList.size() <= 1) {
      for (s s : b.bl(this.context).getPrinters()) {
        Iterator iterator = paramArrayList.iterator();
        while (iterator.hasNext())
          arrayList.add(a(s, (PrintContent)iterator.next(), paramDeliveryPrintSettings)); 
      } 
    } else {
      Iterator iterator = paramArrayList.iterator();
      while (iterator.hasNext())
        arrayList.addAll(d((PrintContent)iterator.next())); 
    } 
    return arrayList;
  }
  
  public ArrayList<e> al(ArrayList<PrintContent> paramArrayList) { return a(paramArrayList, b.bl(this.context).aiz()); }
  
  public void am(ArrayList<PrintContent> paramArrayList) {
    paramArrayList = al(paramArrayList);
    this.cDD.o(paramArrayList);
  }
  
  public ArrayList<PrintContent> b(DeliveryPrintSettings paramDeliveryPrintSettings) { return a(WeiOrderDetail.cyX, paramDeliveryPrintSettings); }
  
  public ArrayList<e> d(PrintContent paramPrintContent) {
    ArrayList arrayList = new ArrayList();
    null = b.bl(this.context).getPrinters();
    DeliveryPrintSettings deliveryPrintSettings = b.bl(this.context).aiz();
    Iterator iterator = null.iterator();
    while (iterator.hasNext())
      arrayList.add(a((s)iterator.next(), paramPrintContent, deliveryPrintSettings)); 
    return arrayList;
  }
  
  public ArrayList<PrintContent> r(PendingFullOrderDetail paramPendingFullOrderDetail) { return a(paramPendingFullOrderDetail, b.bl(this.context).aiz(), false); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\delivery\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */