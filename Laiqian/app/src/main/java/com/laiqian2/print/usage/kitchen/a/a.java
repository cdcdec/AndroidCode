package com.laiqian.print.usage.kitchen.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.pos.model.orders.WeiOrderDetail;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.b.a;
import com.laiqian.print.b.b;
import com.laiqian.print.b.d;
import com.laiqian.print.b.e;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.b;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Deprecated
public final class a {
  private static a cNd;
  
  private g cDD;
  
  private c cDE;
  
  private SimpleDateFormat cJp;
  
  private Context context;
  
  static  {
  
  }
  
  private a(Context paramContext) {
    this.context = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.context);
  }
  
  private String J(HashMap<String, Object> paramHashMap) {
    String str1;
    String str2 = null;
    if (paramHashMap == null)
      return null; 
    if (paramHashMap.containsKey("sProductName")) {
      str1 = (String)paramHashMap.get("sProductName");
    } else {
      str1 = null;
    } 
    if (paramHashMap.containsKey("taste"))
      str2 = (String)paramHashMap.get("taste"); 
    return (str2 != null) ? (str2.trim().isEmpty() ? str1 : String.format("%s[%s]", new Object[] { str1, str2.replace("[", "").replace("]", "") })) : str1;
  }
  
  private void a(e parame, HashMap<String, Object> paramHashMap, int paramInt, b paramb) {
    String str2;
    b b1 = new b((a)parame);
    b1.afW();
    int i = b1.getSize();
    switch (paramInt) {
      default:
        paramInt = 3;
        break;
      case 1:
        paramInt = 1;
        break;
    } 
    b1.setSize(paramInt);
    if (paramb.aWa) {
      str2 = "-";
    } else {
      str2 = "";
    } 
    String str3 = J(paramHashMap);
    null = new StringBuilder();
    null.append(paramHashMap.get("isProductPack"));
    null.append("");
    boolean bool = by.se(null.toString());
    if (!paramb.aTZ && bool) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    String str1 = str3;
    if (paramInt != 0) {
      StringBuilder stringBuilder1;
      str1 = this.context.getString(2131626345);
      if (str3.indexOf("|-") >= 0) {
        str3 = str3.replace("|-", "");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[");
        stringBuilder2.append(str1);
        stringBuilder2.append("]");
        stringBuilder2.append(str3);
        str1 = stringBuilder2.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("|-");
        stringBuilder1.append(str1);
        str1 = stringBuilder1.toString();
      } else {
        str1 = String.format("[%s]%s", new Object[] { str1, stringBuilder1 });
      } 
    } 
    str3 = (String)paramHashMap.get("nProductQty");
    str3 = n.b(this.context, str3, false);
    null = new StringBuilder();
    null.append(paramHashMap.get("nProductTransacType"));
    null.append("");
    String str5 = null.toString();
    String str4 = n.b(this.context, str3, false);
    str3 = str4;
    if (str5.equals("100015")) {
      str3 = str4;
      if (paramb.aWg) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("-");
        stringBuilder1.append(str4);
        str3 = stringBuilder1.toString();
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(str3);
    b1.x(new String[] { str1, stringBuilder.toString() });
    if (paramHashMap.containsKey("sSpareField5") && !TextUtils.isEmpty((String)paramHashMap.get("sSpareField5")))
      if (paramHashMap.containsKey("nFoodCategory") && paramHashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(paramHashMap.get("sSpareField5"));
        b1.ll(stringBuilder.toString());
      } else {
        b1.ll((String)paramHashMap.get("sSpareField5"));
      }  
    b1.setSize(i);
    b1.afT().aJ("name", str1);
  }
  
  private boolean a(e parame, int paramInt) {
    for (byte b = 0; b < paramInt; b++)
      parame.afT().ln(""); 
    return true;
  }
  
  private boolean a(e parame, String paramString, Integer paramInteger1, Integer paramInteger2) {
    if (paramInteger1 == null)
      return false; 
    if (paramInteger2 != null) {
      if (paramString == null) {
        parame.f(String.format("%d/%d", new Object[] { paramInteger1, paramInteger2 }), 3, 1);
        return true;
      } 
      parame.f(String.format("%s : %s-%d/%d", new Object[] { this.context.getString(2131628779), paramString, paramInteger1, paramInteger2 }), 3, 1);
      a1 = parame.afT();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("");
      a1.aJ("number", stringBuilder.toString());
      return true;
    } 
    if (paramString == null)
      a1.f(String.format("%d", new Object[] { stringBuilder }), 3, 1); 
    a1.f(String.format("%s : %s-%d", new Object[] { this.context.getString(2131628779), paramString, stringBuilder }), 3, 1);
    PrintContent.a a1 = a1.afT();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    a1.aJ("number", stringBuilder.toString());
    return true;
  }
  
  private boolean a(e parame, String paramString1, String paramString2, ArrayList<HashMap<String, Object>> paramArrayList, c paramc, boolean paramBoolean) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (paramBoolean) {
      str = "-";
    } else {
      str = "";
    } 
    ArrayList arrayList = null;
    if (paramString1 != null) {
      ArrayList arrayList1 = paramc.lX(paramString1);
    } else {
      paramString1 = arrayList;
    } 
    arrayList = paramString1;
    if (paramString1 == null)
      arrayList = new ArrayList(); 
    b b = new b((a)parame);
    int i = b.getSize();
    b.setSize(ip(paramc.aiG()));
    b.afW();
    Iterator iterator = paramArrayList.iterator();
    paramBoolean = false;
    byte b1 = 1;
    while (iterator.hasNext()) {
      HashMap hashMap = (HashMap)iterator.next();
      String str2 = (String)hashMap.get("nProductType");
      String str1 = J(hashMap);
      String str3 = (String)hashMap.get(paramString2);
      str3 = n.b(this.context, str3, false);
      if (!arrayList.contains(str2)) {
        byte b2 = b1;
        if (str1 != null)
          if (b1) {
            stringBuilder.append(str1);
            b2 = 0;
          } else {
            stringBuilder.append("/");
            stringBuilder.append(str1);
            b2 = b1;
          }  
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append(str3);
        b.x(new String[] { str1, stringBuilder1.toString() });
        if (hashMap.containsKey("sSpareField5") && !TextUtils.isEmpty((String)hashMap.get("sSpareField5")))
          if (hashMap.containsKey("nFoodCategory") && hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("|-");
            stringBuilder2.append(hashMap.get("sSpareField5"));
            b.ll(stringBuilder2.toString());
          } else {
            b.ll((String)hashMap.get("sSpareField5"));
          }  
        paramBoolean = true;
        b1 = b2;
      } 
    } 
    b.setSize(i);
    b.afT().aJ("name", stringBuilder.toString());
    return paramBoolean;
  }
  
  private boolean a(e parame, String paramString1, String paramString2, ArrayList<HashMap<String, Object>> paramArrayList, c paramc, boolean paramBoolean, b paramb) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (paramBoolean) {
      str = "-";
    } else {
      str = "";
    } 
    ArrayList arrayList = null;
    if (paramString1 != null) {
      ArrayList arrayList1 = paramc.lX(paramString1);
    } else {
      paramString1 = arrayList;
    } 
    arrayList = paramString1;
    if (paramString1 == null)
      arrayList = new ArrayList(); 
    b b2 = new b((a)parame);
    int i = b2.getSize();
    b2.setSize(ip(paramc.aiG()));
    b2.afW();
    Iterator iterator = paramArrayList.iterator();
    paramBoolean = false;
    byte b1;
    for (b1 = 1; iterator.hasNext(); b1 = b3) {
      byte b3;
      HashMap hashMap = (HashMap)iterator.next();
      String str5 = (String)hashMap.get("nProductType");
      String str3 = J(hashMap);
      String str1 = (String)hashMap.get(paramString2);
      String str4 = (String)hashMap.get("fPrice");
      null = new StringBuilder();
      null.append(hashMap.get("nProductTransacType"));
      null.append("");
      String str6 = null.toString();
      str1 = n.b(this.context, str1, false);
      String str2 = str1;
      if (str6.equals("100015")) {
        str2 = str1;
        if (paramb.aWg) {
          null = new StringBuilder();
          null.append("-");
          null.append(str1);
          str2 = null.toString();
        } 
      } 
      if (!arrayList.contains(str5)) {
        b3 = b1;
        if (str3 != null)
          if (b1) {
            stringBuilder.append(str3);
            b3 = 0;
          } else {
            stringBuilder.append("/");
            stringBuilder.append(str3);
            b3 = b1;
          }  
        null = new StringBuilder();
        null.append(hashMap.get("isProductPack"));
        null.append("");
        paramBoolean = by.se(null.toString());
        if (!paramb.aTZ && paramBoolean) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        String str7 = str3;
        if (b1 != 0) {
          StringBuilder stringBuilder1;
          str7 = this.context.getString(2131626345);
          if (str3.indexOf("|-") >= 0) {
            str3 = str3.replace("|-", "");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("[");
            stringBuilder2.append(str7);
            stringBuilder2.append("]");
            stringBuilder2.append(str3);
            str7 = stringBuilder2.toString();
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("|-");
            stringBuilder1.append(str7);
            str7 = stringBuilder1.toString();
          } else {
            str7 = String.format("[%s]%s", new Object[] { str7, stringBuilder1 });
          } 
        } 
        if (paramc.aiD()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          stringBuilder1.append(str2);
          b2.x(new String[] { str7, stringBuilder1.toString(), str4 });
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          stringBuilder1.append(str2);
          b2.x(new String[] { str7, stringBuilder1.toString() });
        } 
        if (hashMap.containsKey("sSpareField5") && !TextUtils.isEmpty((String)hashMap.get("sSpareField5")))
          if (hashMap.containsKey("nFoodCategory") && hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("|-");
            stringBuilder1.append(hashMap.get("sSpareField5"));
            b2.ll(stringBuilder1.toString());
          } else {
            b2.ll((String)hashMap.get("sSpareField5"));
          }  
        paramBoolean = true;
      } else {
        b3 = b1;
      } 
    } 
    b2.setSize(i);
    b2.afT().aJ("name", stringBuilder.toString());
    return paramBoolean;
  }
  
  private boolean a(e parame, Date paramDate) {
    if (paramDate == null)
      return false; 
    parame.f(Xn().format(paramDate), 0, 1);
    return true;
  }
  
  private boolean a(String paramString, e parame, Integer paramInteger1, Integer paramInteger2) {
    if (paramInteger1 == null)
      return false; 
    if (paramInteger2 != null) {
      parame.f(String.format("%s %d/%d", new Object[] { paramString, paramInteger1, paramInteger2 }), 3, 1);
      parame.afT().aJ("number", paramString);
      return true;
    } 
    parame.f(String.format("%d", new Object[] { paramInteger1 }), 3, 1);
    parame.f(String.format("%s %d", new Object[] { paramString, paramInteger1 }), 3, 1);
    parame.afT().aJ("number", paramString);
    return true;
  }
  
  private boolean a(String paramString1, e parame, String paramString2, Integer paramInteger1, Integer paramInteger2) {
    if (paramInteger1 == null)
      return false; 
    if (paramInteger2 != null) {
      if (paramString2 == null) {
        parame.f(String.format("%d/%d", new Object[] { paramInteger1, paramInteger2 }), 3, 1);
        return true;
      } 
      parame.f(String.format("%s %s-%d/%d", new Object[] { paramString1, paramString2, paramInteger1, paramInteger2 }), 3, 1);
      a1 = parame.afT();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("");
      a1.aJ("number", stringBuilder.toString());
      return true;
    } 
    if (paramString2 == null)
      stringBuilder.f(String.format("%d", new Object[] { paramInteger1 }), 3, 1); 
    stringBuilder.f(String.format("%s %s-%d", new Object[] { a1, paramString2, paramInteger1 }), 3, 1);
    PrintContent.a a1 = stringBuilder.afT();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("");
    a1.aJ("number", stringBuilder.toString());
    return true;
  }
  
  private void b(ArrayList<HashMap<String, Object>> paramArrayList1, @NonNull ArrayList<String> paramArrayList2) {
    boolean bool = paramArrayList1.toString().contains("|-");
    byte b = 0;
    if (bool) {
      HashMap hashMap = null;
      for (byte b1 = 0; b1 < paramArrayList1.size(); b1++) {
        HashMap hashMap1 = (HashMap)paramArrayList1.get(b1);
        if (((String)hashMap1.get("sProductName")).startsWith("|-") && hashMap != null) {
          ArrayList arrayList2 = (ArrayList)hashMap.get("linshiProductList");
          ArrayList arrayList1 = arrayList2;
          if (arrayList2 == null) {
            arrayList1 = new ArrayList();
            hashMap.put("linshiProductList", arrayList1);
          } 
          arrayList1.add(hashMap1);
          paramArrayList1.remove(b1);
          b1--;
        } else {
          hashMap = hashMap1;
        } 
      } 
    } 
    for (HashMap hashMap : paramArrayList1) {
      if (hashMap.containsKey("nProductType") && hashMap.get("nProductType") != null && paramArrayList2.contains((String)hashMap.get("nProductType"))) {
        null.remove();
        continue;
      } 
      if (hashMap.containsKey("linshiProductList")) {
        ArrayList arrayList = (ArrayList)hashMap.get("linshiProductList");
        for (HashMap hashMap1 : arrayList) {
          if (hashMap1.containsKey("nProductType") && hashMap1.get("nProductType") != null && paramArrayList2.contains((String)hashMap1.get("nProductType")))
            null.remove(); 
        } 
        if (arrayList.size() == 0)
          null.remove(); 
      } 
    } 
    int j = paramArrayList1.size();
    int i;
    for (i = 0; i < j - 1; i = b1) {
      byte b1 = i + true;
      byte b2;
      for (b2 = b1; b2 < j; b2++) {
        HashMap hashMap1 = (HashMap)paramArrayList1.get(i);
        String str1 = (String)hashMap1.get("sProductName");
        HashMap hashMap2 = (HashMap)paramArrayList1.get(b2);
        String str2 = (String)hashMap2.get("sProductName");
        if (n.pp(str1) && n.pp(str2) && str1.compareToIgnoreCase(str2) > 0) {
          paramArrayList1.set(b2, hashMap1);
          paramArrayList1.set(i, hashMap2);
        } 
      } 
    } 
    if (bool)
      for (i = b; i < paramArrayList1.size(); i = k + 1) {
        HashMap hashMap = (HashMap)paramArrayList1.get(i);
        ArrayList arrayList = (ArrayList)hashMap.get("linshiProductList");
        int k = i;
        if (arrayList != null) {
          paramArrayList1.addAll(i + 1, arrayList);
          k = i + arrayList.size();
          hashMap.remove("linshiProductList");
        } 
      }  
  }
  
  private boolean b(e parame, Date paramDate) {
    d d = new d(parame.afT());
    int i = parame.getWidth();
    d.setWidth(i);
    d.ic(parame.afU());
    if (i == 58) {
      d.n(new int[] { 10, 21 });
    } else {
      d.n(new int[] { 15, 28 });
    } 
    d.x(new String[] { this.context.getString(2131628762), Xn().format(paramDate) });
    return true;
  }
  
  public static a bm(Context paramContext) { // Byte code:
    //   0: getstatic com/laiqian/print/usage/kitchen/a/a.cNd : Lcom/laiqian/print/usage/kitchen/a/a;
    //   3: ifnonnull -> 41
    //   6: ldc com/laiqian/print/usage/kitchen/a/a
    //   8: monitorenter
    //   9: getstatic com/laiqian/print/usage/kitchen/a/a.cNd : Lcom/laiqian/print/usage/kitchen/a/a;
    //   12: ifnonnull -> 29
    //   15: new com/laiqian/print/usage/kitchen/a/a
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: putstatic com/laiqian/print/usage/kitchen/a/a.cNd : Lcom/laiqian/print/usage/kitchen/a/a;
    //   29: ldc com/laiqian/print/usage/kitchen/a/a
    //   31: monitorexit
    //   32: goto -> 41
    //   35: astore_0
    //   36: ldc com/laiqian/print/usage/kitchen/a/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    //   41: getstatic com/laiqian/print/usage/kitchen/a/a.cNd : Lcom/laiqian/print/usage/kitchen/a/a;
    //   44: areturn
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   29	32	35	finally
    //   36	39	35	finally }
  
  private boolean e(e parame, String paramString) {
    parame.f(by.G(paramString, 100), 3, 0);
    return true;
  }
  
  private g gu(int paramInt) {
    g g1 = new g();
    g1.setWidth(paramInt);
    g1.ic(CrashApplication.aIQ);
    g1.n(new int[] { 17, 15 });
    return g1;
  }
  
  private int ip(int paramInt) {
    switch (paramInt) {
      default:
        return 1;
      case 2:
        return 3;
      case 1:
        break;
    } 
    return 1;
  }
  
  private boolean q(e parame, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    parame.f(paramString, 3, 0);
    return true;
  }
  
  public SimpleDateFormat Xn() {
    if (this.cJp == null)
      this.cJp = new SimpleDateFormat(this.context.getString(2131627405)); 
    return this.cJp;
  }
  
  @Nullable
  public ArrayList<PrintContent> a(WeiOrderDetail paramWeiOrderDetail, String paramString) { return a(paramWeiOrderDetail, paramString, aiC()); }
  
  @Nullable
  public ArrayList<PrintContent> a(WeiOrderDetail paramWeiOrderDetail, String paramString, c paramc) {
    if (paramString != null) {
      iterator = paramc.lX(paramString);
    } else {
      ArrayList arrayList;
      iterator = null;
    } 
    ArrayList arrayList1 = iterator;
    if (iterator == null)
      arrayList1 = new ArrayList(); 
    Iterator iterator = new ArrayList(paramWeiOrderDetail.bJf);
    if (paramc.getOrder() == 2)
      b(iterator, arrayList1); 
    ArrayList arrayList2 = new ArrayList();
    if (paramc.aiH()) {
      if (paramWeiOrderDetail.aWa) {
        paramString = "-";
      } else {
        paramString = "";
      } 
      Iterator iterator1 = iterator.iterator();
      byte b1;
      for (b1 = 0; iterator1.hasNext(); b1++) {
        if (arrayList1.contains((String)((HashMap)iterator1.next()).get("nProductType")))
          continue; 
      } 
      iterator = iterator.iterator();
      byte b2;
      for (b2 = 1; iterator.hasNext(); b2++) {
        HashMap hashMap = (HashMap)iterator.next();
        null = (String)hashMap.get("nProductType");
        String str1 = J(hashMap);
        String str2 = (String)hashMap.get("nProductQty");
        str2 = n.b(this.context, str2, false);
        if (arrayList1.contains(null))
          continue; 
        g g2 = gu(paramc.getWidth());
        if (paramWeiOrderDetail.type == 1) {
          if (paramWeiOrderDetail.paytype == 3) {
            null = this.context.getString(2131628755);
          } else {
            null = this.context.getString(2131628788);
          } 
          g2.f(String.format("%s-%s", new Object[] { this.context.getString(2131628786), null }), 1, 1);
        } else if (paramWeiOrderDetail.type == 2) {
          if (paramWeiOrderDetail.paytype == 3) {
            null = this.context.getString(2131628765);
          } else {
            null = this.context.getString(2131628727);
          } 
          g2.f(String.format("%s-%s", new Object[] { this.context.getString(2131628770), null }), 1, 1);
        } else if (paramWeiOrderDetail.type == 3) {
          if (paramWeiOrderDetail.paytype == 3) {
            null = this.context.getString(2131628765);
          } else {
            null = this.context.getString(2131628788);
          } 
          g2.f(String.format("%s-%s", new Object[] { this.context.getString(2131628770), null }), 1, 1);
        } else if (paramWeiOrderDetail.type == 4) {
          if (paramWeiOrderDetail.paytype == 3) {
            null = this.context.getString(2131628755);
          } else {
            null = this.context.getString(2131628757);
          } 
          g2.f(String.format("%s-%s", new Object[] { this.context.getString(2131628747), null }), 1, 1);
        } else if (paramWeiOrderDetail.type == 5) {
          g2.f(this.context.getString(2131628767), 1, 1);
        } else if (paramWeiOrderDetail.type == 6) {
          if (paramWeiOrderDetail.paytype == 3) {
            null = this.context.getString(2131628755);
          } else {
            null = this.context.getString(2131628757);
          } 
          g2.f(String.format("%s-%s", new Object[] { this.context.getString(2131629967), null }), 1, 1);
        } 
        if (paramWeiOrderDetail.aWa)
          g2.lk(this.context.getString(2131628775)); 
        if (b1 == 1) {
          if (paramWeiOrderDetail.number != null)
            if ((paramWeiOrderDetail.type == 6 || paramWeiOrderDetail.type == 4) && paramWeiOrderDetail.aWc == 1) {
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append(this.context.getString(2131624447));
              stringBuilder2.append(" ");
              stringBuilder2.append(this.context.getString(2131628760));
              g2.lk(String.format("%s %s", new Object[] { stringBuilder2.toString(), paramWeiOrderDetail.number }));
            } else {
              g2.lk(String.format("%s %s", new Object[] { this.context.getString(2131628760), paramWeiOrderDetail.number }));
            }  
          PrintContent.a a1 = g2.afT();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramWeiOrderDetail.number);
          stringBuilder1.append("");
          a1.aJ("number", stringBuilder1.toString());
        } else {
          a(g2, paramWeiOrderDetail.number, Integer.valueOf(b2), Integer.valueOf(b1));
        } 
        g2.l('-');
        b(g2, paramWeiOrderDetail.cza);
        if (!TextUtils.isEmpty(paramWeiOrderDetail.text))
          q(g2, paramWeiOrderDetail.text); 
        g2.l('-');
        e(g2, paramWeiOrderDetail.czc);
        g2.l('-');
        g2.setSize(ip(paramc.aiG()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(str2);
        g2.x(new String[] { str1, stringBuilder.toString() });
        if (hashMap.containsKey("sSpareField5") && !TextUtils.isEmpty("sSpareField5"))
          if (hashMap.containsKey("nFoodCategory") && hashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("|-");
            stringBuilder.append(hashMap.get("sSpareField5"));
            g2.ll(stringBuilder.toString());
          } else {
            g2.ll((String)hashMap.get("sSpareField5"));
          }  
        g2.afT().aJ("name", str1);
        byte b3;
        for (b3 = 0; b3 < paramc.air(); b3++)
          g2.ll(""); 
        arrayList2.add(g2.afV());
      } 
      arrayList2.add((new PrintContent.a()).agg().afV());
      return arrayList2;
    } 
    g g1 = gu(paramc.getWidth());
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
      g1.f(this.context.getString(2131628767), 1, 1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramWeiOrderDetail.czm);
      stringBuilder.append("");
      g1.f(String.format("%s : %s", new Object[] { "Order", stringBuilder.toString() }), 1, 1);
    } 
    if (paramWeiOrderDetail.aWa)
      g1.lk(this.context.getString(2131628775)); 
    if (paramWeiOrderDetail.number != null) {
      if ((paramWeiOrderDetail.type == 6 || paramWeiOrderDetail.type == 4) && paramWeiOrderDetail.aWc == 1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.context.getString(2131624447));
        stringBuilder1.append(" ");
        stringBuilder1.append(this.context.getString(2131628760));
        g1.lk(String.format("%s %s", new Object[] { stringBuilder1.toString(), paramWeiOrderDetail.number }));
      } else {
        g1.lk(String.format("%s %s", new Object[] { this.context.getString(2131628760), paramWeiOrderDetail.number }));
      } 
      PrintContent.a a1 = g1.afT();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramWeiOrderDetail.number);
      stringBuilder.append("");
      a1.aJ("number", stringBuilder.toString());
    } 
    byte b = 0;
    g1.l('-');
    b(g1, paramWeiOrderDetail.cza);
    if (!TextUtils.isEmpty(paramWeiOrderDetail.text))
      q(g1, paramWeiOrderDetail.text); 
    g1.l('-');
    e(g1, paramWeiOrderDetail.czc);
    g1.l('-');
    boolean bool = a(g1, paramString, "nProductQty", iterator, paramc, paramWeiOrderDetail.aWa);
    while (b < paramc.air()) {
      g1.ll("");
      b++;
    } 
    if (bool)
      arrayList2.add(g1.afV()); 
    return arrayList2;
  }
  
  @Nullable
  public ArrayList<PrintContent> a(b paramb, String paramString, c paramc) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #9
    //   9: aload_2
    //   10: ifnull -> 23
    //   13: aload_3
    //   14: aload_2
    //   15: invokevirtual lX : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   18: astore #7
    //   20: goto -> 26
    //   23: aconst_null
    //   24: astore #7
    //   26: aload #7
    //   28: astore #8
    //   30: aload #7
    //   32: ifnonnull -> 44
    //   35: new java/util/ArrayList
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: astore #8
    //   44: new java/util/ArrayList
    //   47: dup
    //   48: aload_1
    //   49: getfield bJf : Ljava/util/ArrayList;
    //   52: invokespecial <init> : (Ljava/util/Collection;)V
    //   55: astore #7
    //   57: aload_3
    //   58: invokevirtual getOrder : ()I
    //   61: iconst_2
    //   62: if_icmpne -> 83
    //   65: aload_0
    //   66: aload #7
    //   68: aload #8
    //   70: invokespecial b : (Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   73: goto -> 83
    //   76: astore #10
    //   78: aload #10
    //   80: invokestatic e : (Ljava/lang/Throwable;)V
    //   83: aload_3
    //   84: invokevirtual aiH : ()Z
    //   87: ifne -> 516
    //   90: aload_0
    //   91: aload_3
    //   92: invokevirtual getWidth : ()I
    //   95: invokespecial gu : (I)Lcom/laiqian/print/b/g;
    //   98: astore #8
    //   100: aload_1
    //   101: getfield bcf : J
    //   104: ldc2_w 7
    //   107: lcmp
    //   108: ifne -> 296
    //   111: aload_1
    //   112: getfield openTableName : Ljava/lang/String;
    //   115: ldc_w '.'
    //   118: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   121: ifne -> 190
    //   124: aload #8
    //   126: ldc_w '%s %s'
    //   129: iconst_2
    //   130: anewarray java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: getfield context : Landroid/content/Context;
    //   139: ldc_w 2131628305
    //   142: invokevirtual getString : (I)Ljava/lang/String;
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload_1
    //   149: getfield openTableName : Ljava/lang/String;
    //   152: aastore
    //   153: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual lk : (Ljava/lang/String;)V
    //   159: aload #8
    //   161: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   164: ldc 'number'
    //   166: ldc_w '%s'
    //   169: iconst_1
    //   170: anewarray java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_1
    //   176: getfield openTableName : Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   183: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   186: pop
    //   187: goto -> 403
    //   190: aload_1
    //   191: getfield openTableName : Ljava/lang/String;
    //   194: ldc_w '.'
    //   197: invokevirtual indexOf : (Ljava/lang/String;)I
    //   200: istore #4
    //   202: aload #8
    //   204: ldc_w '%s'
    //   207: iconst_1
    //   208: anewarray java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_1
    //   214: getfield openTableName : Ljava/lang/String;
    //   217: iconst_0
    //   218: iload #4
    //   220: invokevirtual substring : (II)Ljava/lang/String;
    //   223: aastore
    //   224: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   227: invokevirtual lk : (Ljava/lang/String;)V
    //   230: aload #8
    //   232: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   235: ldc 'number'
    //   237: ldc_w '%s'
    //   240: iconst_1
    //   241: anewarray java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload_1
    //   247: getfield openTableName : Ljava/lang/String;
    //   250: iconst_0
    //   251: iload #4
    //   253: invokevirtual substring : (II)Ljava/lang/String;
    //   256: aastore
    //   257: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   260: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   263: pop
    //   264: aload #8
    //   266: ldc_w '%s'
    //   269: iconst_1
    //   270: anewarray java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload_1
    //   276: getfield openTableName : Ljava/lang/String;
    //   279: iload #4
    //   281: iconst_1
    //   282: iadd
    //   283: invokevirtual substring : (I)Ljava/lang/String;
    //   286: aastore
    //   287: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   290: invokevirtual lk : (Ljava/lang/String;)V
    //   293: goto -> 403
    //   296: aload_1
    //   297: getfield coJ : Ljava/lang/String;
    //   300: ifnull -> 386
    //   303: aload #8
    //   305: ldc_w '%s %s'
    //   308: iconst_2
    //   309: anewarray java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload_0
    //   315: aload_1
    //   316: getfield aTZ : Z
    //   319: invokevirtual fU : (Z)Ljava/lang/String;
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: aload_1
    //   326: getfield coJ : Ljava/lang/String;
    //   329: aastore
    //   330: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   333: invokevirtual lk : (Ljava/lang/String;)V
    //   336: aload #8
    //   338: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   341: astore #10
    //   343: new java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial <init> : ()V
    //   350: astore #11
    //   352: aload #11
    //   354: aload_1
    //   355: getfield coJ : Ljava/lang/String;
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload #11
    //   364: ldc ''
    //   366: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload #10
    //   372: ldc 'number'
    //   374: aload #11
    //   376: invokevirtual toString : ()Ljava/lang/String;
    //   379: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   382: pop
    //   383: goto -> 403
    //   386: aload_1
    //   387: getfield aTZ : Z
    //   390: ifeq -> 403
    //   393: aload #8
    //   395: aload_0
    //   396: iconst_1
    //   397: invokevirtual fU : (Z)Ljava/lang/String;
    //   400: invokevirtual lk : (Ljava/lang/String;)V
    //   403: aload_0
    //   404: aload #8
    //   406: aload_1
    //   407: getfield bkf : Ljava/util/Date;
    //   410: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/Date;)Z
    //   413: pop
    //   414: aload #8
    //   416: bipush #45
    //   418: invokevirtual l : (C)V
    //   421: aload_1
    //   422: getfield aWa : Z
    //   425: ifeq -> 443
    //   428: aload #8
    //   430: aload_0
    //   431: getfield context : Landroid/content/Context;
    //   434: ldc_w 2131628775
    //   437: invokevirtual getString : (I)Ljava/lang/String;
    //   440: invokevirtual lk : (Ljava/lang/String;)V
    //   443: aload #8
    //   445: aload_0
    //   446: aload_3
    //   447: invokevirtual aiG : ()I
    //   450: invokespecial ip : (I)I
    //   453: invokevirtual setSize : (I)V
    //   456: aload_0
    //   457: aload #8
    //   459: aload_2
    //   460: ldc 'nProductQty'
    //   462: aload #7
    //   464: aload_3
    //   465: aload_1
    //   466: getfield aWa : Z
    //   469: aload_1
    //   470: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/laiqian/print/usage/kitchen/a/c;ZLcom/laiqian/pos/model/orders/b;)Z
    //   473: ifne -> 478
    //   476: aconst_null
    //   477: areturn
    //   478: aload_0
    //   479: aload #8
    //   481: aload_3
    //   482: invokevirtual air : ()I
    //   485: invokespecial a : (Lcom/laiqian/print/b/e;I)Z
    //   488: pop
    //   489: aload #8
    //   491: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   494: aload_3
    //   495: invokevirtual getCopies : ()I
    //   498: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   501: pop
    //   502: aload #9
    //   504: aload #8
    //   506: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   509: invokevirtual add : (Ljava/lang/Object;)Z
    //   512: pop
    //   513: goto -> 1105
    //   516: aload #7
    //   518: invokevirtual iterator : ()Ljava/util/Iterator;
    //   521: astore_2
    //   522: iconst_0
    //   523: istore #6
    //   525: aload_2
    //   526: invokeinterface hasNext : ()Z
    //   531: ifeq -> 581
    //   534: aload_2
    //   535: invokeinterface next : ()Ljava/lang/Object;
    //   540: checkcast java/util/HashMap
    //   543: ldc_w 'nProductType'
    //   546: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   549: checkcast java/lang/String
    //   552: astore #10
    //   554: aload #8
    //   556: ifnull -> 572
    //   559: aload #8
    //   561: aload #10
    //   563: invokevirtual contains : (Ljava/lang/Object;)Z
    //   566: ifeq -> 572
    //   569: goto -> 525
    //   572: iload #6
    //   574: iconst_1
    //   575: iadd
    //   576: istore #6
    //   578: goto -> 525
    //   581: aload #7
    //   583: invokevirtual iterator : ()Ljava/util/Iterator;
    //   586: astore #10
    //   588: iconst_1
    //   589: istore #4
    //   591: aload #10
    //   593: invokeinterface hasNext : ()Z
    //   598: ifeq -> 1105
    //   601: aload #10
    //   603: invokeinterface next : ()Ljava/lang/Object;
    //   608: checkcast java/util/HashMap
    //   611: astore #11
    //   613: aload #11
    //   615: ldc_w 'nProductType'
    //   618: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast java/lang/String
    //   624: astore_2
    //   625: aload #8
    //   627: ifnull -> 642
    //   630: aload #8
    //   632: aload_2
    //   633: invokevirtual contains : (Ljava/lang/Object;)Z
    //   636: ifeq -> 642
    //   639: goto -> 591
    //   642: aload_0
    //   643: aload_3
    //   644: invokevirtual getWidth : ()I
    //   647: invokespecial gu : (I)Lcom/laiqian/print/b/g;
    //   650: astore #7
    //   652: aload #7
    //   654: astore_2
    //   655: iload #6
    //   657: iconst_1
    //   658: if_icmpne -> 816
    //   661: aload_1
    //   662: getfield coJ : Ljava/lang/String;
    //   665: ifnull -> 797
    //   668: aload_1
    //   669: getfield bcf : J
    //   672: ldc2_w 7
    //   675: lcmp
    //   676: ifne -> 716
    //   679: aload_2
    //   680: ldc_w '%s %s'
    //   683: iconst_2
    //   684: anewarray java/lang/Object
    //   687: dup
    //   688: iconst_0
    //   689: aload_0
    //   690: getfield context : Landroid/content/Context;
    //   693: ldc_w 2131628305
    //   696: invokevirtual getString : (I)Ljava/lang/String;
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: aload_1
    //   703: getfield openTableName : Ljava/lang/String;
    //   706: aastore
    //   707: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   710: invokevirtual lk : (Ljava/lang/String;)V
    //   713: goto -> 748
    //   716: aload_2
    //   717: ldc_w '%s %s'
    //   720: iconst_2
    //   721: anewarray java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: aload_0
    //   727: aload_1
    //   728: getfield aTZ : Z
    //   731: invokevirtual fU : (Z)Ljava/lang/String;
    //   734: aastore
    //   735: dup
    //   736: iconst_1
    //   737: aload_1
    //   738: getfield coJ : Ljava/lang/String;
    //   741: aastore
    //   742: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   745: invokevirtual lk : (Ljava/lang/String;)V
    //   748: aload_2
    //   749: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   752: astore #7
    //   754: new java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial <init> : ()V
    //   761: astore #12
    //   763: aload #12
    //   765: aload_1
    //   766: getfield coJ : Ljava/lang/String;
    //   769: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload #12
    //   775: ldc ''
    //   777: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload #7
    //   783: ldc 'number'
    //   785: aload #12
    //   787: invokevirtual toString : ()Ljava/lang/String;
    //   790: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   793: pop
    //   794: goto -> 813
    //   797: aload_1
    //   798: getfield aTZ : Z
    //   801: ifeq -> 813
    //   804: aload_2
    //   805: aload_0
    //   806: iconst_1
    //   807: invokevirtual fU : (Z)Ljava/lang/String;
    //   810: invokevirtual lk : (Ljava/lang/String;)V
    //   813: goto -> 1018
    //   816: aload_1
    //   817: getfield coJ : Ljava/lang/String;
    //   820: ifnull -> 973
    //   823: aload_1
    //   824: getfield bcf : J
    //   827: ldc2_w 7
    //   830: lcmp
    //   831: ifne -> 896
    //   834: aload_0
    //   835: getfield context : Landroid/content/Context;
    //   838: ldc_w 2131628305
    //   841: invokevirtual getString : (I)Ljava/lang/String;
    //   844: astore #12
    //   846: aload_1
    //   847: getfield openTableName : Ljava/lang/String;
    //   850: astore #13
    //   852: iload #4
    //   854: iconst_1
    //   855: iadd
    //   856: istore #5
    //   858: aload_0
    //   859: aload #12
    //   861: aload_2
    //   862: aload #13
    //   864: iload #4
    //   866: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   869: iload #6
    //   871: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   874: invokespecial a : (Ljava/lang/String;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Z
    //   877: pop
    //   878: iload #5
    //   880: istore #4
    //   882: iload #4
    //   884: istore #5
    //   886: aload #7
    //   888: astore_2
    //   889: iload #5
    //   891: istore #4
    //   893: goto -> 1018
    //   896: aload_0
    //   897: aload_1
    //   898: getfield aTZ : Z
    //   901: invokevirtual fU : (Z)Ljava/lang/String;
    //   904: astore #12
    //   906: new java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial <init> : ()V
    //   913: astore #13
    //   915: aload #13
    //   917: aload_1
    //   918: getfield coJ : Ljava/lang/String;
    //   921: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: aload #13
    //   927: ldc ''
    //   929: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload #13
    //   935: invokevirtual toString : ()Ljava/lang/String;
    //   938: astore #13
    //   940: iload #4
    //   942: iconst_1
    //   943: iadd
    //   944: istore #5
    //   946: aload_0
    //   947: aload #12
    //   949: aload_2
    //   950: aload #13
    //   952: iload #4
    //   954: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   957: iload #6
    //   959: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   962: invokespecial a : (Ljava/lang/String;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Z
    //   965: pop
    //   966: iload #5
    //   968: istore #4
    //   970: goto -> 882
    //   973: iload #4
    //   975: istore #5
    //   977: aload_1
    //   978: getfield aTZ : Z
    //   981: ifeq -> 886
    //   984: aload_0
    //   985: aload_1
    //   986: getfield aTZ : Z
    //   989: invokevirtual fU : (Z)Ljava/lang/String;
    //   992: astore #7
    //   994: aload_0
    //   995: aload #7
    //   997: aload_2
    //   998: iload #4
    //   1000: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1003: iload #6
    //   1005: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1008: invokespecial a : (Ljava/lang/String;Lcom/laiqian/print/b/e;Ljava/lang/Integer;Ljava/lang/Integer;)Z
    //   1011: pop
    //   1012: iload #4
    //   1014: iconst_1
    //   1015: iadd
    //   1016: istore #4
    //   1018: aload_0
    //   1019: aload_2
    //   1020: aload_1
    //   1021: getfield bkf : Ljava/util/Date;
    //   1024: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/Date;)Z
    //   1027: pop
    //   1028: aload_2
    //   1029: bipush #45
    //   1031: invokevirtual l : (C)V
    //   1034: aload_1
    //   1035: getfield aWa : Z
    //   1038: ifeq -> 1058
    //   1041: aload_2
    //   1042: aload_0
    //   1043: getfield context : Landroid/content/Context;
    //   1046: ldc_w 2131628775
    //   1049: invokevirtual getString : (I)Ljava/lang/String;
    //   1052: invokevirtual lk : (Ljava/lang/String;)V
    //   1055: goto -> 1058
    //   1058: aload_0
    //   1059: aload_2
    //   1060: aload #11
    //   1062: aload_3
    //   1063: invokevirtual aiG : ()I
    //   1066: aload_1
    //   1067: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/HashMap;ILcom/laiqian/pos/model/orders/b;)V
    //   1070: aload_0
    //   1071: aload_2
    //   1072: aload_3
    //   1073: invokevirtual air : ()I
    //   1076: invokespecial a : (Lcom/laiqian/print/b/e;I)Z
    //   1079: pop
    //   1080: aload_2
    //   1081: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1084: aload_3
    //   1085: invokevirtual getCopies : ()I
    //   1088: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1091: pop
    //   1092: aload #9
    //   1094: aload_2
    //   1095: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1098: invokevirtual add : (Ljava/lang/Object;)Z
    //   1101: pop
    //   1102: goto -> 591
    //   1105: aload #9
    //   1107: new com/laiqian/print/model/PrintContent$a
    //   1110: dup
    //   1111: invokespecial <init> : ()V
    //   1114: invokevirtual agg : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1117: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1120: invokevirtual add : (Ljava/lang/Object;)Z
    //   1123: pop
    //   1124: aload #9
    //   1126: areturn
    // Exception table:
    //   from	to	target	type
    //   65	73	76	java/lang/Exception }
  
  public void a(b paramb) {
    if (paramb instanceof c)
      d.bj(this.context).a((c)paramb); 
  }
  
  public ArrayList<PrintContent> aiB() { return b(aiC()); }
  
  public c aiC() { return d.bj(this.context).aeg(); }
  
  public ArrayList<PrintContent> b(c paramc) {
    ArrayList arrayList = a(b.cyT, null, paramc);
    return (arrayList != null && arrayList.size() > 0) ? arrayList : null;
  }
  
  public String fU(boolean paramBoolean) { return paramBoolean ? this.context.getString(2131626345) : this.context.getString(2131628779); }
  
  public List<s> getPrinters() { return this.cDE.ahX(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\kitchen\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */