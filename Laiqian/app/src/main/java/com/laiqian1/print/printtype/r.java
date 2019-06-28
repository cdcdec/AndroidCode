package com.laiqian.print.printtype;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.z;
import com.laiqian.models.an;
import com.laiqian.models.bh;
import com.laiqian.models.n;
import com.laiqian.pos.bm;
import com.laiqian.pos.industry.weiorder.advertisement.u;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.ac;
import com.laiqian.print.ad;
import com.laiqian.print.b.a;
import com.laiqian.print.b.b;
import com.laiqian.print.b.e;
import com.laiqian.print.b.g;
import com.laiqian.print.bm;
import com.laiqian.print.h;
import com.laiqian.print.j;
import com.laiqian.print.k;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.p;
import com.laiqian.print.usage.delivery.model.DeliveryPrintSettings;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.tag.a.c;
import com.laiqian.print.util.e;
import com.laiqian.product.models.o;
import com.laiqian.product.models.p;
import com.laiqian.util.am;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class r implements j.h {
  private Map<Pair<Class, String>, j.k> cJo = new HashMap();
  
  private SimpleDateFormat cJp;
  
  private Context context;
  
  static  {
  
  }
  
  public r(Context paramContext) {
    this.context = paramContext;
    this.cJo.put(new Pair(b.class, "delivery_not_specified"), ad.kU("delivery_not_specified"));
    this.cJo.put(new Pair(b.class, "pre"), ad.kU("pre"));
    this.cJo.put(new Pair(b.class, "settle_receipt"), ad.kU("settle_receipt"));
    this.cJo.put(new Pair(b.class, "kitchen_port"), s.cJL);
    this.cJo.put(new Pair(b.class, "kitchen_total"), t.cJL);
    this.cJo.put(new Pair(b.class, "tag_not_specified"), u.cJL);
    this.cJo.put(new Pair(b.class, "tag_not_specified_reprint"), v.cJL);
    this.cJo.put(new Pair(b.class, "kitchen_port_reprint"), w.cJL);
    this.cJo.put(new Pair(b.class, "kitchen_total_reprint"), x.cJL);
    this.cJo.put(new Pair(b.class, "settle_receipt_reprint"), y.cJL);
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
  
  private List<PrintContent> a(b paramb, j.c paramc, c paramc1, boolean paramBoolean1, boolean paramBoolean2) {
    ArrayList arrayList1 = new ArrayList();
    g g = paramc.aep();
    ArrayList arrayList2 = new ArrayList(paramb.bJf);
    if (paramc1.getOrder() == 2)
      try {
        a(arrayList2, g);
      } catch (Exception exception) {
        a.e(exception);
      }  
    if (paramBoolean1) {
      g = gu(paramc1.getWidth());
      if (paramBoolean2)
        g.lk(this.context.getString(2131628774)); 
      if (paramb.bcf == 7L) {
        if (!paramb.openTableName.contains(".")) {
          g.lk(String.format("%s %s", new Object[] { this.context.getString(2131628305), paramb.openTableName }));
          g.afT().aJ("number", String.format("%s", new Object[] { paramb.openTableName }));
        } else {
          int i = paramb.openTableName.indexOf(".");
          g.lk(String.format("%s", new Object[] { paramb.openTableName.substring(0, i) }));
          g.afT().aJ("number", String.format("%s", new Object[] { paramb.openTableName.substring(0, i) }));
          g.lk(String.format("%s", new Object[] { paramb.openTableName.substring(i + 1) }));
        } 
      } else if (paramb.coJ != null) {
        g.lk(String.format("%s %s", new Object[] { fU(paramb.aTZ), paramb.coJ }));
        PrintContent.a a = g.afT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramb.coJ);
        stringBuilder.append("");
        a.aJ("number", stringBuilder.toString());
      } else if (paramb.aTZ) {
        g.lk(fU(true));
      } 
      a(g, paramb.bkf);
      g.l('-');
      if (paramb.aWa)
        g.lk(this.context.getString(2131628775)); 
      g.setSize(ip(paramc1.aiG()));
      if (!a(g, "nProductQty", arrayList2, paramc1, paramb.aWa, paramb, paramc.aep()))
        return null; 
      a(g, paramc1.air());
      g.afT().ih(paramc.getCopies());
      arrayList1.add(g.afV());
    } else {
      Iterator iterator = arrayList2.iterator();
      byte b1;
      for (b1 = 0; iterator.hasNext(); b1++) {
        String str = (String)((HashMap)iterator.next()).get("nProductType");
        if (g != null && g.contains(Long.valueOf(Long.parseLong(str))))
          continue; 
      } 
      byte b4 = 1;
      byte b3 = 0;
      byte b2 = b1;
      b1 = b4;
      while (b3 < arrayList2.size()) {
        HashMap hashMap = (HashMap)arrayList2.get(b3);
        String str = (String)hashMap.get("nProductType");
        if (g == null || !g.contains(Long.valueOf(Long.parseLong(str)))) {
          g g1 = gu(paramc1.getWidth());
          if (b3 == 0 && paramBoolean2) {
            g1.lk(this.context.getString(2131628774));
            g1.x(new String[] { "" });
          } 
          if (b2 == 1) {
            if (paramb.coJ != null) {
              if (paramb.bcf == 7L) {
                g1.lk(String.format("%s %s", new Object[] { this.context.getString(2131628305), paramb.openTableName }));
              } else {
                g1.lk(String.format("%s %s", new Object[] { fU(paramb.aTZ), paramb.coJ }));
              } 
              PrintContent.a a = g1.afT();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(paramb.coJ);
              stringBuilder.append("");
              a.aJ("number", stringBuilder.toString());
            } else if (paramb.aTZ) {
              g1.lk(fU(true));
            } 
          } else if (paramb.coJ != null) {
            if (paramb.bcf == 7L) {
              String str1 = this.context.getString(2131628305);
              String str2 = paramb.openTableName;
              b4 = b1 + 1;
              a(str1, g1, str2, Integer.valueOf(b1), Integer.valueOf(b2));
              b1 = b4;
            } else {
              String str1 = String.format(this.context.getString(2131629622), new Object[] { Integer.valueOf(b1), Integer.valueOf(b2) });
              g g2 = g1;
              g2.x(new String[] { str1 });
              g2.x(new String[] { "" });
              g2.lk(String.format("%s %s", new Object[] { fU(paramb.aTZ), paramb.coJ }));
              g2.x(new String[] { "" });
              PrintContent.a a = g2.afT();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(paramb.coJ);
              stringBuilder.append("");
              a.aJ("number", stringBuilder.toString());
              b1++;
            } 
          } else if (paramb.aTZ) {
            a(fU(paramb.aTZ), g1, Integer.valueOf(b1), Integer.valueOf(b2));
            b1++;
          } 
          a(g1, paramb.bkf);
          g1.l('-');
          if (paramb.aWa)
            g1.lk(this.context.getString(2131628775)); 
          a(g1, hashMap, paramc1, paramb);
          a(g1, paramc1.air());
          g1.afT().ih(paramc.getCopies());
          arrayList1.add(g1.afV());
        } 
        b3++;
      } 
    } 
    arrayList1.add((new PrintContent.a()).agg().afV());
    return arrayList1;
  }
  
  private List<PrintContent> a(b paramb, j.i parami, DeliveryPrintSettings paramDeliveryPrintSettings) {
    String str1;
    an = new an(this.context);
    null = an.Vu();
    an.close();
    g g = gu(paramDeliveryPrintSettings.getWidth());
    int j = paramDeliveryPrintSettings.ais();
    if (paramb.aWg)
      g.lk(this.context.getString(2131628774)); 
    if (paramb.bcf == 7L) {
      bool2 = a(g, paramb.openTableName);
      paramb.bkf = new Date();
    } else if (paramb.coJ != null) {
      bool2 = b(g, paramb.coJ);
    } else {
      bool2 = false;
    } 
    boolean bool3 = a(g, paramDeliveryPrintSettings.aiu(), paramDeliveryPrintSettings.aiv());
    if (paramb.aWa)
      g.lk(this.context.getString(2131628775)); 
    boolean bool1 = TextUtils.isEmpty(paramDeliveryPrintSettings.getTitle()) ^ true;
    if (bool1) {
      g.l('-');
      switch (paramDeliveryPrintSettings.ait()) {
        default:
          b1 = 0;
          break;
        case 2:
          b1 = 3;
          break;
      } 
      g.f(paramDeliveryPrintSettings.getTitle(), b1, 1);
      if (a.zR().Ad()) {
        if (!TextUtils.isEmpty(null.bSs)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ROC No. ");
          stringBuilder.append(null.bSs);
          g.f(stringBuilder.toString(), 0, 1);
        } 
        if (!TextUtils.isEmpty(null.aWV))
          g.f(null.aWV, 0, 1); 
        if (!TextUtils.isEmpty(null.aWU)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Tel ");
          stringBuilder.append(null.aWU);
          g.f(stringBuilder.toString(), 0, 1);
        } 
        if (!TextUtils.isEmpty(null.bSr)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Email ");
          stringBuilder.append(null.bSr);
          g.f(stringBuilder.toString(), 0, 1);
        } 
        if (!TextUtils.isEmpty(null.bSt)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("GST Reg No. ");
          stringBuilder.append(null.bSt);
          g.f(stringBuilder.toString(), 0, 1);
        } 
        if (!TextUtils.isEmpty(paramb.cyS)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invoice No. ");
          stringBuilder.append(paramb.cyS);
          g.f(stringBuilder.toString(), 0, 1);
        } 
        if (paramb.ciN != null) {
          g.l('-');
          if (paramb.ciN.ciI != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bill to ");
            stringBuilder.append(paramb.ciN.ciI);
            g.ll(stringBuilder.toString());
          } 
          if (paramb.ciN.address != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Address ");
            stringBuilder.append(paramb.ciN.address);
            g.ll(stringBuilder.toString());
          } 
          if (paramb.ciN.ciJ != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reg No. ");
            stringBuilder.append(paramb.ciN.ciJ);
            g.ll(stringBuilder.toString());
          } 
        } 
      } 
      g.l('-');
    } 
    if (paramb.cyR.size() > 0)
      g.lk("Tax Invoice"); 
    if (bool2 && !bool3 && !bool1)
      g.l('-'); 
    if (!TextUtils.isEmpty(paramb.billNumber))
      b(g, 2131628731, paramb.billNumber); 
    a(g, paramb.bkf, paramb.ceV);
    if (paramb.bcf == 7L && !by.isNull(paramb.bch)) {
      String str = "0";
      try {
        String str3 = (new JSONObject(paramb.bch)).getString("actual_person");
        str = str3;
      } catch (JSONException an) {
        a.e(an);
      } 
      c(g, str);
    } 
    g.l('-');
    if (j == 1) {
      b1 = 0;
    } else {
      b1 = 1;
    } 
    double d = Double.parseDouble(n.a(paramb.cyI, true, false));
    if (n.bc(d)) {
      a(g, paramb.bJf, paramb.aWa, b1, false);
    } else {
      a(g, paramb.bJf, paramb.aWa, b1, true);
    } 
    g.l('-');
    if (paramb.vipEntity != null)
      a(g, paramb.bJf); 
    if (paramb.cyI != null && !n.bc(d)) {
      if (paramb.ceX != null) {
        bool2 = a(g, paramb.ceX, paramb.cyI, paramb.cyP, paramb.aWa);
      } else {
        bool2 = a(g, paramb.cyI, paramb.cyP, paramb.aWa, paramb.bJf);
      } 
    } else {
      bool2 = false;
    } 
    if (paramb.vipEntity != null)
      b(g, paramb.cyN); 
    if (paramb.cyQ != null && !n.bc(paramb.cyQ.doubleValue())) {
      if (bool2)
        g.l('-'); 
      double d1 = paramb.cyO.doubleValue() - paramb.cyQ.doubleValue() - paramb.cyL;
      d = d1;
      if (paramb.aWa)
        d = -d1; 
      a(g, "Sales amount", Double.valueOf(d));
      if (paramb.aWa) {
        d = -paramb.cyQ.doubleValue();
      } else {
        d = paramb.cyQ.doubleValue();
      } 
      a(g, "Total tax", Double.valueOf(d));
    } 
    if (!n.bc(paramb.cyL))
      a(g, "Rounding", Double.valueOf(paramb.cyL)); 
    a(g, paramb.cyO, paramb.aWa);
    if (paramb.bbS.size() == 1 && ((z)paramb.bbS.get(0)).aTv == 10001) {
      d = ((z)paramb.bbS.get(0)).aTw;
      if (!n.bc(d)) {
        b(g, Double.valueOf(paramb.cyO.doubleValue() + d), paramb.aWa);
        c(g, Double.valueOf(d), paramb.aWa);
      } 
    } else {
      for (z z : paramb.bbS) {
        if (z.aJW < 0.0D) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(z.name);
          stringBuilder.append(this.context.getString(2131628776));
          a(g, stringBuilder.toString(), Double.valueOf(z.aJW));
          continue;
        } 
        a(g, z.name, Double.valueOf(z.aJW));
      } 
    } 
    aq aq = paramb.vipEntity;
    an = null;
    if (aq != null) {
      g.l('-');
      if (!TextUtils.isEmpty(paramb.vipEntity.name)) {
        if (a.zR().Ab()) {
          String str = paramb.vipEntity.name;
        } else {
          String str = by.bv(paramb.vipEntity.name, "*");
        } 
      } else if (!TextUtils.isEmpty(paramb.vipEntity.aTp)) {
        if (a.zR().Ab()) {
          String str = paramb.vipEntity.aTp;
        } else {
          String str = by.bu(paramb.vipEntity.aTp, "****");
        } 
      } else if (!TextUtils.isEmpty(paramb.vipEntity.aWn)) {
        String str = paramb.vipEntity.aWn;
      } else {
        aq = null;
      } 
      if (!TextUtils.isEmpty(aq))
        k(g, aq); 
      b(g, Double.valueOf(paramb.vipEntity.aWo));
      if (a.AZ().Cd()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramb.vipEntity.aWp);
        stringBuilder.append("");
        b(g, 2131628751, stringBuilder.toString());
      } 
    } 
    if (paramb.cyR.size() != 0) {
      g.l('-');
      g.n(new int[] { 12, 10, 10 });
      g.x(new String[] { "GST", "Amount", "Tax" });
      g.l('-');
      for (p p : paramb.cyR) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.IT());
        stringBuilder.append("=");
        stringBuilder.append(p.alg());
        stringBuilder.append("%");
        g.x(new String[] { stringBuilder.toString(), n.a(Double.valueOf(p.ali()), true, false), n.a(Double.valueOf(p.alh()), true, false) });
      } 
    } 
    byte b1 = 0;
    if (paramDeliveryPrintSettings.aiw() != 0 || !TextUtils.isEmpty(paramDeliveryPrintSettings.aiq()))
      g.l('-'); 
    if (paramDeliveryPrintSettings.aiw() == 3)
      b1 = 1; 
    j = paramDeliveryPrintSettings.aiw();
    if (b1 != 0) {
      str1 = u.cxS.b(paramb.cyO.doubleValue(), paramb.orderNo);
    } else {
      str1 = paramDeliveryPrintSettings.aix();
    } 
    String str2 = an;
    if (paramDeliveryPrintSettings.aiw() == 1)
      str2 = this.context.getString(2131628777); 
    boolean bool2 = a(g, j, str1, str2);
    if (!TextUtils.isEmpty(paramDeliveryPrintSettings.aiq()) && bool2)
      g.l('-'); 
    l(g, paramDeliveryPrintSettings.aiq());
    a(g, paramDeliveryPrintSettings.air());
    g.afT().ih(parami.getCopies());
    return Collections.singletonList(g.afV());
  }
  
  private List<PrintContent> a(b paramb, j.i parami, ReceiptPrintSettings paramReceiptPrintSettings, boolean paramBoolean1, boolean paramBoolean2) { // Byte code:
    //   0: new com/laiqian/models/an
    //   3: dup
    //   4: aload_0
    //   5: getfield context : Landroid/content/Context;
    //   8: invokespecial <init> : (Landroid/content/Context;)V
    //   11: astore #22
    //   13: aload #22
    //   15: invokevirtual Vu : ()Lcom/laiqian/models/an$c;
    //   18: astore #21
    //   20: aload #22
    //   22: invokevirtual close : ()V
    //   25: aload_0
    //   26: aload_3
    //   27: invokevirtual getWidth : ()I
    //   30: invokespecial gu : (I)Lcom/laiqian/print/b/g;
    //   33: astore #24
    //   35: aload_3
    //   36: invokevirtual ais : ()I
    //   39: istore #15
    //   41: iload #5
    //   43: ifeq -> 60
    //   46: aload #24
    //   48: aload_0
    //   49: getfield context : Landroid/content/Context;
    //   52: ldc 2131628774
    //   54: invokevirtual getString : (I)Ljava/lang/String;
    //   57: invokevirtual lk : (Ljava/lang/String;)V
    //   60: aload_1
    //   61: getfield bcf : J
    //   64: ldc2_w 7
    //   67: lcmp
    //   68: ifeq -> 217
    //   71: aload_1
    //   72: getfield bcf : J
    //   75: ldc2_w 14
    //   78: lcmp
    //   79: ifne -> 85
    //   82: goto -> 217
    //   85: aload_1
    //   86: getfield coJ : Ljava/lang/String;
    //   89: ifnull -> 154
    //   92: aload_1
    //   93: getfield aTZ : Z
    //   96: ifeq -> 139
    //   99: aload #24
    //   101: ldc '%s %s'
    //   103: iconst_2
    //   104: anewarray java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_0
    //   110: getfield context : Landroid/content/Context;
    //   113: ldc_w 2131626345
    //   116: invokevirtual getString : (I)Ljava/lang/String;
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload_1
    //   123: getfield coJ : Ljava/lang/String;
    //   126: aastore
    //   127: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   130: invokevirtual lk : (Ljava/lang/String;)V
    //   133: iconst_1
    //   134: istore #5
    //   136: goto -> 179
    //   139: aload_0
    //   140: aload #24
    //   142: aload_1
    //   143: getfield coJ : Ljava/lang/String;
    //   146: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   149: istore #5
    //   151: goto -> 179
    //   154: aload_1
    //   155: getfield aTZ : Z
    //   158: ifeq -> 176
    //   161: aload #24
    //   163: aload_0
    //   164: getfield context : Landroid/content/Context;
    //   167: ldc_w 2131628763
    //   170: invokevirtual getString : (I)Ljava/lang/String;
    //   173: invokevirtual lk : (Ljava/lang/String;)V
    //   176: iconst_0
    //   177: istore #5
    //   179: iload #4
    //   181: ifeq -> 313
    //   184: aload #24
    //   186: ldc '%s'
    //   188: iconst_1
    //   189: anewarray java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_0
    //   195: getfield context : Landroid/content/Context;
    //   198: ldc_w 2131626897
    //   201: invokevirtual getString : (I)Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokevirtual lk : (Ljava/lang/String;)V
    //   211: iconst_1
    //   212: istore #5
    //   214: goto -> 313
    //   217: aload_1
    //   218: getfield openTableName : Ljava/lang/String;
    //   221: ldc '.'
    //   223: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   226: ifne -> 244
    //   229: aload_0
    //   230: aload #24
    //   232: aload_1
    //   233: getfield openTableName : Ljava/lang/String;
    //   236: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   239: istore #5
    //   241: goto -> 313
    //   244: aload_1
    //   245: getfield openTableName : Ljava/lang/String;
    //   248: ldc '.'
    //   250: invokevirtual indexOf : (Ljava/lang/String;)I
    //   253: istore #14
    //   255: aload #24
    //   257: ldc '%s'
    //   259: iconst_1
    //   260: anewarray java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload_1
    //   266: getfield openTableName : Ljava/lang/String;
    //   269: iconst_0
    //   270: iload #14
    //   272: invokevirtual substring : (II)Ljava/lang/String;
    //   275: aastore
    //   276: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokevirtual lk : (Ljava/lang/String;)V
    //   282: aload #24
    //   284: ldc '%s'
    //   286: iconst_1
    //   287: anewarray java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload_1
    //   293: getfield openTableName : Ljava/lang/String;
    //   296: iload #14
    //   298: iconst_1
    //   299: iadd
    //   300: invokevirtual substring : (I)Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   307: invokevirtual lk : (Ljava/lang/String;)V
    //   310: iconst_0
    //   311: istore #5
    //   313: aload_1
    //   314: getfield cyV : Z
    //   317: ifeq -> 397
    //   320: aload_1
    //   321: getfield bcf : J
    //   324: ldc2_w 7
    //   327: lcmp
    //   328: ifeq -> 342
    //   331: aload_1
    //   332: getfield bcf : J
    //   335: ldc2_w 14
    //   338: lcmp
    //   339: ifne -> 377
    //   342: iload #4
    //   344: ifeq -> 377
    //   347: aload #24
    //   349: ldc '%s'
    //   351: iconst_1
    //   352: anewarray java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: aload_0
    //   358: getfield context : Landroid/content/Context;
    //   361: ldc_w 2131626897
    //   364: invokevirtual getString : (I)Ljava/lang/String;
    //   367: aastore
    //   368: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   371: invokevirtual lk : (Ljava/lang/String;)V
    //   374: goto -> 397
    //   377: iload #4
    //   379: ifne -> 397
    //   382: aload #24
    //   384: aload_0
    //   385: getfield context : Landroid/content/Context;
    //   388: ldc_w 2131628732
    //   391: invokevirtual getString : (I)Ljava/lang/String;
    //   394: invokevirtual lk : (Ljava/lang/String;)V
    //   397: aload_0
    //   398: aload #24
    //   400: aload_3
    //   401: invokevirtual aiu : ()I
    //   404: aload_3
    //   405: invokevirtual aiv : ()Ljava/lang/String;
    //   408: invokespecial a : (Lcom/laiqian/print/b/e;ILjava/lang/String;)Z
    //   411: istore #4
    //   413: aload_1
    //   414: getfield aWa : Z
    //   417: ifeq -> 435
    //   420: aload #24
    //   422: aload_0
    //   423: getfield context : Landroid/content/Context;
    //   426: ldc_w 2131628775
    //   429: invokevirtual getString : (I)Ljava/lang/String;
    //   432: invokevirtual lk : (Ljava/lang/String;)V
    //   435: aload_3
    //   436: invokevirtual ait : ()I
    //   439: pop
    //   440: aload_3
    //   441: invokevirtual getTitle : ()Ljava/lang/String;
    //   444: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   447: iconst_1
    //   448: ixor
    //   449: istore #16
    //   451: iload #16
    //   453: ifeq -> 997
    //   456: aload #24
    //   458: bipush #45
    //   460: invokevirtual l : (C)V
    //   463: aload_3
    //   464: invokevirtual ait : ()I
    //   467: tableswitch default -> 488, 1 -> 488, 2 -> 494
    //   488: iconst_0
    //   489: istore #14
    //   491: goto -> 497
    //   494: iconst_3
    //   495: istore #14
    //   497: aload #24
    //   499: aload_3
    //   500: invokevirtual getTitle : ()Ljava/lang/String;
    //   503: iload #14
    //   505: iconst_1
    //   506: invokevirtual f : (Ljava/lang/String;II)V
    //   509: invokestatic zR : ()Lcom/laiqian/c/a;
    //   512: invokevirtual Ad : ()Z
    //   515: ifeq -> 969
    //   518: aload #21
    //   520: getfield bSs : Ljava/lang/String;
    //   523: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   526: ifne -> 573
    //   529: new java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial <init> : ()V
    //   536: astore #22
    //   538: aload #22
    //   540: ldc_w 'ROC No. '
    //   543: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload #22
    //   549: aload #21
    //   551: getfield bSs : Ljava/lang/String;
    //   554: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload #24
    //   560: aload #22
    //   562: invokevirtual toString : ()Ljava/lang/String;
    //   565: iconst_0
    //   566: iconst_1
    //   567: invokevirtual f : (Ljava/lang/String;II)V
    //   570: goto -> 573
    //   573: aload #21
    //   575: getfield aWV : Ljava/lang/String;
    //   578: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   581: ifne -> 596
    //   584: aload #24
    //   586: aload #21
    //   588: getfield aWV : Ljava/lang/String;
    //   591: iconst_0
    //   592: iconst_1
    //   593: invokevirtual f : (Ljava/lang/String;II)V
    //   596: aload #21
    //   598: getfield aWU : Ljava/lang/String;
    //   601: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   604: ifne -> 648
    //   607: new java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial <init> : ()V
    //   614: astore #22
    //   616: aload #22
    //   618: ldc_w 'Tel '
    //   621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload #22
    //   627: aload #21
    //   629: getfield aWU : Ljava/lang/String;
    //   632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload #24
    //   638: aload #22
    //   640: invokevirtual toString : ()Ljava/lang/String;
    //   643: iconst_0
    //   644: iconst_1
    //   645: invokevirtual f : (Ljava/lang/String;II)V
    //   648: aload #21
    //   650: getfield bSr : Ljava/lang/String;
    //   653: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   656: ifne -> 700
    //   659: new java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial <init> : ()V
    //   666: astore #22
    //   668: aload #22
    //   670: ldc_w 'Email '
    //   673: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload #22
    //   679: aload #21
    //   681: getfield bSr : Ljava/lang/String;
    //   684: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload #24
    //   690: aload #22
    //   692: invokevirtual toString : ()Ljava/lang/String;
    //   695: iconst_0
    //   696: iconst_1
    //   697: invokevirtual f : (Ljava/lang/String;II)V
    //   700: aload #21
    //   702: getfield bSt : Ljava/lang/String;
    //   705: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   708: ifne -> 752
    //   711: new java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial <init> : ()V
    //   718: astore #22
    //   720: aload #22
    //   722: ldc_w 'GST Reg No. '
    //   725: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload #22
    //   731: aload #21
    //   733: getfield bSt : Ljava/lang/String;
    //   736: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload #24
    //   742: aload #22
    //   744: invokevirtual toString : ()Ljava/lang/String;
    //   747: iconst_0
    //   748: iconst_1
    //   749: invokevirtual f : (Ljava/lang/String;II)V
    //   752: aload_1
    //   753: getfield cyS : Ljava/lang/String;
    //   756: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   759: ifne -> 802
    //   762: new java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial <init> : ()V
    //   769: astore #21
    //   771: aload #21
    //   773: ldc_w 'Invoice No. '
    //   776: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload #21
    //   782: aload_1
    //   783: getfield cyS : Ljava/lang/String;
    //   786: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload #24
    //   792: aload #21
    //   794: invokevirtual toString : ()Ljava/lang/String;
    //   797: iconst_0
    //   798: iconst_1
    //   799: invokevirtual f : (Ljava/lang/String;II)V
    //   802: aload_1
    //   803: getfield ciN : Lcom/laiqian/pos/dc;
    //   806: ifnull -> 969
    //   809: aload #24
    //   811: bipush #45
    //   813: invokevirtual l : (C)V
    //   816: aload_1
    //   817: getfield ciN : Lcom/laiqian/pos/dc;
    //   820: getfield ciI : Ljava/lang/String;
    //   823: ifnull -> 867
    //   826: new java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial <init> : ()V
    //   833: astore #21
    //   835: aload #21
    //   837: ldc_w 'Bill to '
    //   840: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload #21
    //   846: aload_1
    //   847: getfield ciN : Lcom/laiqian/pos/dc;
    //   850: getfield ciI : Ljava/lang/String;
    //   853: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload #24
    //   859: aload #21
    //   861: invokevirtual toString : ()Ljava/lang/String;
    //   864: invokevirtual ll : (Ljava/lang/String;)V
    //   867: aload_1
    //   868: getfield ciN : Lcom/laiqian/pos/dc;
    //   871: getfield address : Ljava/lang/String;
    //   874: ifnull -> 918
    //   877: new java/lang/StringBuilder
    //   880: dup
    //   881: invokespecial <init> : ()V
    //   884: astore #21
    //   886: aload #21
    //   888: ldc_w 'Address '
    //   891: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload #21
    //   897: aload_1
    //   898: getfield ciN : Lcom/laiqian/pos/dc;
    //   901: getfield address : Ljava/lang/String;
    //   904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload #24
    //   910: aload #21
    //   912: invokevirtual toString : ()Ljava/lang/String;
    //   915: invokevirtual ll : (Ljava/lang/String;)V
    //   918: aload_1
    //   919: getfield ciN : Lcom/laiqian/pos/dc;
    //   922: getfield ciJ : Ljava/lang/String;
    //   925: ifnull -> 969
    //   928: new java/lang/StringBuilder
    //   931: dup
    //   932: invokespecial <init> : ()V
    //   935: astore #21
    //   937: aload #21
    //   939: ldc_w 'Reg No. '
    //   942: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload #21
    //   948: aload_1
    //   949: getfield ciN : Lcom/laiqian/pos/dc;
    //   952: getfield ciJ : Ljava/lang/String;
    //   955: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload #24
    //   961: aload #21
    //   963: invokevirtual toString : ()Ljava/lang/String;
    //   966: invokevirtual ll : (Ljava/lang/String;)V
    //   969: aload_1
    //   970: getfield cyR : Ljava/util/ArrayList;
    //   973: invokevirtual size : ()I
    //   976: ifle -> 987
    //   979: aload #24
    //   981: ldc_w 'Tax Invoice'
    //   984: invokevirtual lk : (Ljava/lang/String;)V
    //   987: aload #24
    //   989: bipush #45
    //   991: invokevirtual l : (C)V
    //   994: goto -> 1015
    //   997: aload_1
    //   998: getfield cyR : Ljava/util/ArrayList;
    //   1001: invokevirtual size : ()I
    //   1004: ifle -> 1015
    //   1007: aload #24
    //   1009: ldc_w 'Tax Invoice'
    //   1012: invokevirtual lk : (Ljava/lang/String;)V
    //   1015: iload #5
    //   1017: ifeq -> 1037
    //   1020: iload #4
    //   1022: ifne -> 1037
    //   1025: iload #16
    //   1027: ifne -> 1037
    //   1030: aload #24
    //   1032: bipush #45
    //   1034: invokevirtual l : (C)V
    //   1037: aload_1
    //   1038: getfield billNumber : Ljava/lang/String;
    //   1041: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1044: ifne -> 1061
    //   1047: aload_0
    //   1048: aload #24
    //   1050: ldc_w 2131628731
    //   1053: aload_1
    //   1054: getfield billNumber : Ljava/lang/String;
    //   1057: invokespecial b : (Lcom/laiqian/print/b/e;ILjava/lang/String;)Z
    //   1060: pop
    //   1061: aload_0
    //   1062: aload #24
    //   1064: ldc_w '结算时间'
    //   1067: aload_1
    //   1068: getfield bkf : Ljava/util/Date;
    //   1071: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/util/Date;)Z
    //   1074: pop
    //   1075: aload_1
    //   1076: getfield bcf : J
    //   1079: ldc2_w 7
    //   1082: lcmp
    //   1083: ifeq -> 1097
    //   1086: aload_1
    //   1087: getfield bcf : J
    //   1090: ldc2_w 14
    //   1093: lcmp
    //   1094: ifne -> 1174
    //   1097: aload_1
    //   1098: getfield bch : Ljava/lang/String;
    //   1101: invokestatic isNull : (Ljava/lang/String;)Z
    //   1104: ifne -> 1174
    //   1107: new org/json/JSONObject
    //   1110: dup
    //   1111: aload_1
    //   1112: getfield bch : Ljava/lang/String;
    //   1115: invokespecial <init> : (Ljava/lang/String;)V
    //   1118: astore #22
    //   1120: aload #22
    //   1122: ldc_w 'actual_person'
    //   1125: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1128: astore #21
    //   1130: aload_1
    //   1131: aload #22
    //   1133: ldc_w 'createTime'
    //   1136: invokestatic currentTimeMillis : ()J
    //   1139: invokevirtual optLong : (Ljava/lang/String;J)J
    //   1142: putfield bbP : J
    //   1145: goto -> 1165
    //   1148: astore #22
    //   1150: goto -> 1160
    //   1153: astore #22
    //   1155: ldc_w '0'
    //   1158: astore #21
    //   1160: aload #22
    //   1162: invokestatic e : (Ljava/lang/Throwable;)V
    //   1165: aload_0
    //   1166: aload #24
    //   1168: aload #21
    //   1170: invokespecial c : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   1173: pop
    //   1174: aload_1
    //   1175: getfield bcf : J
    //   1178: ldc2_w 7
    //   1181: lcmp
    //   1182: ifne -> 1191
    //   1185: iconst_1
    //   1186: istore #14
    //   1188: goto -> 1194
    //   1191: iconst_0
    //   1192: istore #14
    //   1194: iload #14
    //   1196: ifeq -> 1371
    //   1199: aload_1
    //   1200: getfield coU : Ljava/lang/String;
    //   1203: ifnull -> 1371
    //   1206: ldc ''
    //   1208: astore #21
    //   1210: aload_1
    //   1211: getfield coU : Ljava/lang/String;
    //   1214: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1217: ifeq -> 1338
    //   1220: aload #21
    //   1222: astore #22
    //   1224: new org/json/JSONObject
    //   1227: dup
    //   1228: aload_1
    //   1229: getfield bch : Ljava/lang/String;
    //   1232: invokespecial <init> : (Ljava/lang/String;)V
    //   1235: astore #25
    //   1237: aload #21
    //   1239: astore #22
    //   1241: new com/laiqian/models/bh
    //   1244: dup
    //   1245: aload_0
    //   1246: getfield context : Landroid/content/Context;
    //   1249: invokespecial <init> : (Landroid/content/Context;)V
    //   1252: astore #23
    //   1254: aload #21
    //   1256: astore #22
    //   1258: aload #23
    //   1260: aload #25
    //   1262: ldc_w 'drawerID'
    //   1265: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1268: invokevirtual iB : (Ljava/lang/String;)Ljava/lang/String;
    //   1271: astore #21
    //   1273: aload #21
    //   1275: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1278: ifeq -> 1303
    //   1281: aload #23
    //   1283: aload #25
    //   1285: ldc_w 'drawerID'
    //   1288: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1291: invokevirtual iD : (Ljava/lang/String;)Ljava/lang/String;
    //   1294: astore #22
    //   1296: aload #22
    //   1298: astore #21
    //   1300: goto -> 1303
    //   1303: aload #21
    //   1305: astore #22
    //   1307: aload #23
    //   1309: invokevirtual close : ()V
    //   1312: goto -> 1344
    //   1315: astore #22
    //   1317: goto -> 1330
    //   1320: astore #23
    //   1322: aload #22
    //   1324: astore #21
    //   1326: aload #23
    //   1328: astore #22
    //   1330: aload #22
    //   1332: invokestatic e : (Ljava/lang/Throwable;)V
    //   1335: goto -> 1344
    //   1338: aload_1
    //   1339: getfield coU : Ljava/lang/String;
    //   1342: astore #21
    //   1344: aload #24
    //   1346: iconst_2
    //   1347: anewarray java/lang/String
    //   1350: dup
    //   1351: iconst_0
    //   1352: aload_0
    //   1353: getfield context : Landroid/content/Context;
    //   1356: ldc_w 2131628744
    //   1359: invokevirtual getString : (I)Ljava/lang/String;
    //   1362: aastore
    //   1363: dup
    //   1364: iconst_1
    //   1365: aload #21
    //   1367: aastore
    //   1368: invokevirtual x : ([Ljava/lang/String;)V
    //   1371: aload_1
    //   1372: getfield coV : Ljava/lang/String;
    //   1375: ifnull -> 1672
    //   1378: ldc ''
    //   1380: astore #21
    //   1382: aload_1
    //   1383: getfield coU : Ljava/lang/String;
    //   1386: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1389: ifeq -> 1510
    //   1392: aload #21
    //   1394: astore #22
    //   1396: new org/json/JSONObject
    //   1399: dup
    //   1400: aload_1
    //   1401: getfield bch : Ljava/lang/String;
    //   1404: invokespecial <init> : (Ljava/lang/String;)V
    //   1407: astore #25
    //   1409: aload #21
    //   1411: astore #22
    //   1413: new com/laiqian/models/bh
    //   1416: dup
    //   1417: aload_0
    //   1418: getfield context : Landroid/content/Context;
    //   1421: invokespecial <init> : (Landroid/content/Context;)V
    //   1424: astore #23
    //   1426: aload #21
    //   1428: astore #22
    //   1430: aload #23
    //   1432: aload #25
    //   1434: ldc_w 'settlementID'
    //   1437: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1440: invokevirtual iB : (Ljava/lang/String;)Ljava/lang/String;
    //   1443: astore #21
    //   1445: aload #21
    //   1447: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1450: ifeq -> 1475
    //   1453: aload #23
    //   1455: aload #25
    //   1457: ldc_w 'settlementID'
    //   1460: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1463: invokevirtual iD : (Ljava/lang/String;)Ljava/lang/String;
    //   1466: astore #22
    //   1468: aload #22
    //   1470: astore #21
    //   1472: goto -> 1475
    //   1475: aload #21
    //   1477: astore #22
    //   1479: aload #23
    //   1481: invokevirtual close : ()V
    //   1484: goto -> 1516
    //   1487: astore #22
    //   1489: goto -> 1502
    //   1492: astore #23
    //   1494: aload #22
    //   1496: astore #21
    //   1498: aload #23
    //   1500: astore #22
    //   1502: aload #22
    //   1504: invokestatic e : (Ljava/lang/Throwable;)V
    //   1507: goto -> 1516
    //   1510: aload_1
    //   1511: getfield coV : Ljava/lang/String;
    //   1514: astore #21
    //   1516: aload #24
    //   1518: iconst_2
    //   1519: anewarray java/lang/String
    //   1522: dup
    //   1523: iconst_0
    //   1524: aload_0
    //   1525: getfield context : Landroid/content/Context;
    //   1528: ldc_w 2131628737
    //   1531: invokevirtual getString : (I)Ljava/lang/String;
    //   1534: aastore
    //   1535: dup
    //   1536: iconst_1
    //   1537: aload #21
    //   1539: aastore
    //   1540: invokevirtual x : ([Ljava/lang/String;)V
    //   1543: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1546: invokevirtual Bk : ()Z
    //   1549: ifeq -> 1672
    //   1552: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1555: invokevirtual Cv : ()Z
    //   1558: ifeq -> 1672
    //   1561: aload_1
    //   1562: getfield bbP : J
    //   1565: lstore #19
    //   1567: aload_1
    //   1568: getfield bkf : Ljava/util/Date;
    //   1571: ifnonnull -> 1582
    //   1574: invokestatic currentTimeMillis : ()J
    //   1577: lstore #17
    //   1579: goto -> 1591
    //   1582: aload_1
    //   1583: getfield bkf : Ljava/util/Date;
    //   1586: invokevirtual getTime : ()J
    //   1589: lstore #17
    //   1591: lload #19
    //   1593: lload #17
    //   1595: invokestatic C : (JJ)[I
    //   1598: astore #21
    //   1600: aload #24
    //   1602: iconst_2
    //   1603: anewarray java/lang/String
    //   1606: dup
    //   1607: iconst_0
    //   1608: aload_0
    //   1609: getfield context : Landroid/content/Context;
    //   1612: ldc_w 2131629939
    //   1615: invokevirtual getString : (I)Ljava/lang/String;
    //   1618: aastore
    //   1619: dup
    //   1620: iconst_1
    //   1621: aload_0
    //   1622: getfield context : Landroid/content/Context;
    //   1625: ldc_w 2131626042
    //   1628: iconst_3
    //   1629: anewarray java/lang/Object
    //   1632: dup
    //   1633: iconst_0
    //   1634: aload #21
    //   1636: iconst_0
    //   1637: iaload
    //   1638: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1641: aastore
    //   1642: dup
    //   1643: iconst_1
    //   1644: aload #21
    //   1646: iconst_1
    //   1647: iaload
    //   1648: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1651: aastore
    //   1652: dup
    //   1653: iconst_2
    //   1654: aload #21
    //   1656: iconst_2
    //   1657: iaload
    //   1658: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1661: aastore
    //   1662: invokevirtual getString : (I[Ljava/lang/Object;)Ljava/lang/String;
    //   1665: aastore
    //   1666: invokevirtual x : ([Ljava/lang/String;)V
    //   1669: goto -> 1672
    //   1672: aload #24
    //   1674: bipush #45
    //   1676: invokevirtual l : (C)V
    //   1679: iload #15
    //   1681: iconst_1
    //   1682: if_icmpne -> 1691
    //   1685: iconst_0
    //   1686: istore #14
    //   1688: goto -> 1694
    //   1691: iconst_1
    //   1692: istore #14
    //   1694: aload_1
    //   1695: getfield cyI : Ljava/lang/Double;
    //   1698: iconst_1
    //   1699: iconst_0
    //   1700: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   1703: invokestatic parseDouble : (Ljava/lang/String;)D
    //   1706: dstore #6
    //   1708: dload #6
    //   1710: invokestatic bc : (D)Z
    //   1713: ifeq -> 1735
    //   1716: aload_0
    //   1717: aload #24
    //   1719: aload_1
    //   1720: getfield bJf : Ljava/util/ArrayList;
    //   1723: aload_1
    //   1724: iload #14
    //   1726: iconst_0
    //   1727: aload_3
    //   1728: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;Lcom/laiqian/pos/model/orders/b;IZLcom/laiqian/print/usage/receipt/model/ReceiptPrintSettings;)Z
    //   1731: pop
    //   1732: goto -> 1751
    //   1735: aload_0
    //   1736: aload #24
    //   1738: aload_1
    //   1739: getfield bJf : Ljava/util/ArrayList;
    //   1742: aload_1
    //   1743: iload #14
    //   1745: iconst_0
    //   1746: aload_3
    //   1747: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;Lcom/laiqian/pos/model/orders/b;IZLcom/laiqian/print/usage/receipt/model/ReceiptPrintSettings;)Z
    //   1750: pop
    //   1751: aload #24
    //   1753: bipush #45
    //   1755: invokevirtual l : (C)V
    //   1758: aload_1
    //   1759: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   1762: ifnull -> 1776
    //   1765: aload_0
    //   1766: aload #24
    //   1768: aload_1
    //   1769: getfield bJf : Ljava/util/ArrayList;
    //   1772: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;)Z
    //   1775: pop
    //   1776: aload_1
    //   1777: getfield cyI : Ljava/lang/Double;
    //   1780: ifnull -> 1848
    //   1783: dload #6
    //   1785: invokestatic bc : (D)Z
    //   1788: ifne -> 1848
    //   1791: aload_1
    //   1792: getfield aWg : Z
    //   1795: ifne -> 1821
    //   1798: aload_0
    //   1799: aload #24
    //   1801: aload_1
    //   1802: getfield ceX : Ljava/lang/Double;
    //   1805: aload_1
    //   1806: getfield aWa : Z
    //   1809: aload_1
    //   1810: getfield bJf : Ljava/util/ArrayList;
    //   1813: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/Double;ZLjava/util/ArrayList;)Z
    //   1816: istore #4
    //   1818: goto -> 1851
    //   1821: aload_0
    //   1822: aload #24
    //   1824: aload_1
    //   1825: getfield ceX : Ljava/lang/Double;
    //   1828: aload_1
    //   1829: getfield cyI : Ljava/lang/Double;
    //   1832: aload_1
    //   1833: getfield aWa : Z
    //   1836: aload_1
    //   1837: getfield bJf : Ljava/util/ArrayList;
    //   1840: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Ljava/lang/Double;ZLjava/util/ArrayList;)Z
    //   1843: istore #4
    //   1845: goto -> 1851
    //   1848: iconst_0
    //   1849: istore #4
    //   1851: aload_1
    //   1852: getfield cyQ : Ljava/lang/Double;
    //   1855: ifnull -> 1877
    //   1858: aload_1
    //   1859: getfield cyQ : Ljava/lang/Double;
    //   1862: invokevirtual doubleValue : ()D
    //   1865: invokestatic bc : (D)Z
    //   1868: ifne -> 1877
    //   1871: iconst_1
    //   1872: istore #14
    //   1874: goto -> 1880
    //   1877: iconst_0
    //   1878: istore #14
    //   1880: aload_1
    //   1881: getfield cpa : D
    //   1884: dconst_0
    //   1885: bipush #6
    //   1887: invokestatic a : (DDI)Z
    //   1890: iconst_1
    //   1891: ixor
    //   1892: istore #15
    //   1894: iload #14
    //   1896: ifne -> 2148
    //   1899: iload #15
    //   1901: ifeq -> 2134
    //   1904: aload #24
    //   1906: bipush #45
    //   1908: invokevirtual l : (C)V
    //   1911: ldc ''
    //   1913: astore #21
    //   1915: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1918: invokevirtual BV : ()Z
    //   1921: ifeq -> 1932
    //   1924: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1927: invokevirtual BY : ()Ljava/lang/String;
    //   1930: astore #21
    //   1932: new java/lang/StringBuilder
    //   1935: dup
    //   1936: invokespecial <init> : ()V
    //   1939: astore #22
    //   1941: aload #22
    //   1943: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   1946: invokevirtual BW : ()D
    //   1949: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1952: pop
    //   1953: aload #22
    //   1955: ldc ''
    //   1957: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: pop
    //   1961: aload #22
    //   1963: invokevirtual toString : ()Ljava/lang/String;
    //   1966: astore #22
    //   1968: new com/laiqian/print/b/g
    //   1971: dup
    //   1972: aload #24
    //   1974: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   1977: astore #23
    //   1979: aload #23
    //   1981: iconst_2
    //   1982: newarray int
    //   1984: dup
    //   1985: iconst_0
    //   1986: iconst_3
    //   1987: iastore
    //   1988: dup
    //   1989: iconst_1
    //   1990: iconst_1
    //   1991: iastore
    //   1992: invokevirtual n : ([I)V
    //   1995: aload #21
    //   1997: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   2000: ifne -> 2077
    //   2003: new java/lang/StringBuilder
    //   2006: dup
    //   2007: invokespecial <init> : ()V
    //   2010: astore #25
    //   2012: aload #25
    //   2014: ldc_w 'Serv. charge('
    //   2017: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2020: pop
    //   2021: aload #25
    //   2023: aload #22
    //   2025: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: pop
    //   2029: aload #25
    //   2031: ldc_w '%)('
    //   2034: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2037: pop
    //   2038: aload #25
    //   2040: aload #21
    //   2042: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: pop
    //   2046: aload #25
    //   2048: ldc_w ')'
    //   2051: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: pop
    //   2055: aload_0
    //   2056: aload #23
    //   2058: aload #25
    //   2060: invokevirtual toString : ()Ljava/lang/String;
    //   2063: aload_1
    //   2064: getfield cpa : D
    //   2067: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2070: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2073: pop
    //   2074: goto -> 2498
    //   2077: new java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial <init> : ()V
    //   2084: astore #21
    //   2086: aload #21
    //   2088: ldc_w 'Serv. charge('
    //   2091: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: pop
    //   2095: aload #21
    //   2097: aload #22
    //   2099: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2102: pop
    //   2103: aload #21
    //   2105: ldc_w '%)'
    //   2108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: pop
    //   2112: aload_0
    //   2113: aload #23
    //   2115: aload #21
    //   2117: invokevirtual toString : ()Ljava/lang/String;
    //   2120: aload_1
    //   2121: getfield cpa : D
    //   2124: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2127: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2130: pop
    //   2131: goto -> 2498
    //   2134: aload_0
    //   2135: aload #24
    //   2137: aload_1
    //   2138: getfield cyN : Ljava/util/ArrayList;
    //   2141: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;)Z
    //   2144: pop
    //   2145: goto -> 2498
    //   2148: iload #4
    //   2150: ifeq -> 2160
    //   2153: aload #24
    //   2155: bipush #45
    //   2157: invokevirtual l : (C)V
    //   2160: aload_1
    //   2161: getfield cyO : Ljava/lang/Double;
    //   2164: invokevirtual doubleValue : ()D
    //   2167: aload_1
    //   2168: getfield cyQ : Ljava/lang/Double;
    //   2171: invokevirtual doubleValue : ()D
    //   2174: dsub
    //   2175: aload_1
    //   2176: getfield cyL : D
    //   2179: dsub
    //   2180: aload_1
    //   2181: getfield cpa : D
    //   2184: dsub
    //   2185: aload_1
    //   2186: getfield cyN : Ljava/util/ArrayList;
    //   2189: getstatic com/laiqian/print/printtype/ab.cJN : Lcom/laiqian/util/k$b;
    //   2192: invokestatic a : (Ljava/util/Collection;Lcom/laiqian/util/k$b;)D
    //   2195: dadd
    //   2196: dstore #8
    //   2198: dload #8
    //   2200: dstore #6
    //   2202: aload_1
    //   2203: getfield aWa : Z
    //   2206: ifeq -> 2214
    //   2209: dload #8
    //   2211: dneg
    //   2212: dstore #6
    //   2214: aload_0
    //   2215: aload #24
    //   2217: ldc_w 'Sales amount'
    //   2220: dload #6
    //   2222: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2225: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2228: pop
    //   2229: iload #15
    //   2231: ifeq -> 2454
    //   2234: ldc ''
    //   2236: astore #21
    //   2238: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2241: invokevirtual BV : ()Z
    //   2244: ifeq -> 2255
    //   2247: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2250: invokevirtual BY : ()Ljava/lang/String;
    //   2253: astore #21
    //   2255: new java/lang/StringBuilder
    //   2258: dup
    //   2259: invokespecial <init> : ()V
    //   2262: astore #22
    //   2264: aload #22
    //   2266: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   2269: invokevirtual BW : ()D
    //   2272: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2275: pop
    //   2276: aload #22
    //   2278: ldc ''
    //   2280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: pop
    //   2284: aload #22
    //   2286: invokevirtual toString : ()Ljava/lang/String;
    //   2289: astore #22
    //   2291: new com/laiqian/print/b/g
    //   2294: dup
    //   2295: aload #24
    //   2297: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   2300: astore #23
    //   2302: aload #23
    //   2304: iconst_2
    //   2305: newarray int
    //   2307: dup
    //   2308: iconst_0
    //   2309: iconst_3
    //   2310: iastore
    //   2311: dup
    //   2312: iconst_1
    //   2313: iconst_1
    //   2314: iastore
    //   2315: invokevirtual n : ([I)V
    //   2318: aload #21
    //   2320: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   2323: ifne -> 2400
    //   2326: new java/lang/StringBuilder
    //   2329: dup
    //   2330: invokespecial <init> : ()V
    //   2333: astore #25
    //   2335: aload #25
    //   2337: ldc_w 'Serv. charge('
    //   2340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: pop
    //   2344: aload #25
    //   2346: aload #22
    //   2348: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2351: pop
    //   2352: aload #25
    //   2354: ldc_w '%)('
    //   2357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: pop
    //   2361: aload #25
    //   2363: aload #21
    //   2365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2368: pop
    //   2369: aload #25
    //   2371: ldc_w ')'
    //   2374: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: pop
    //   2378: aload_0
    //   2379: aload #23
    //   2381: aload #25
    //   2383: invokevirtual toString : ()Ljava/lang/String;
    //   2386: aload_1
    //   2387: getfield cpa : D
    //   2390: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2393: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2396: pop
    //   2397: goto -> 2454
    //   2400: new java/lang/StringBuilder
    //   2403: dup
    //   2404: invokespecial <init> : ()V
    //   2407: astore #21
    //   2409: aload #21
    //   2411: ldc_w 'Serv. charge('
    //   2414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2417: pop
    //   2418: aload #21
    //   2420: aload #22
    //   2422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2425: pop
    //   2426: aload #21
    //   2428: ldc_w '%)'
    //   2431: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2434: pop
    //   2435: aload_0
    //   2436: aload #23
    //   2438: aload #21
    //   2440: invokevirtual toString : ()Ljava/lang/String;
    //   2443: aload_1
    //   2444: getfield cpa : D
    //   2447: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2450: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2453: pop
    //   2454: aload_1
    //   2455: getfield aWa : Z
    //   2458: ifeq -> 2474
    //   2461: aload_1
    //   2462: getfield cyQ : Ljava/lang/Double;
    //   2465: invokevirtual doubleValue : ()D
    //   2468: dneg
    //   2469: dstore #6
    //   2471: goto -> 2483
    //   2474: aload_1
    //   2475: getfield cyQ : Ljava/lang/Double;
    //   2478: invokevirtual doubleValue : ()D
    //   2481: dstore #6
    //   2483: aload_0
    //   2484: aload #24
    //   2486: ldc_w 'Total tax'
    //   2489: dload #6
    //   2491: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2494: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2497: pop
    //   2498: iload #15
    //   2500: ifne -> 2508
    //   2503: iload #14
    //   2505: ifeq -> 2526
    //   2508: aload_1
    //   2509: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   2512: ifnull -> 2526
    //   2515: aload_0
    //   2516: aload #24
    //   2518: aload_1
    //   2519: getfield cyN : Ljava/util/ArrayList;
    //   2522: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/util/ArrayList;)Z
    //   2525: pop
    //   2526: aload_1
    //   2527: getfield cyL : D
    //   2530: invokestatic bc : (D)Z
    //   2533: ifne -> 2553
    //   2536: aload_0
    //   2537: aload #24
    //   2539: ldc_w 'Rounding'
    //   2542: aload_1
    //   2543: getfield cyL : D
    //   2546: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2549: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   2552: pop
    //   2553: aload_1
    //   2554: getfield bJf : Ljava/util/ArrayList;
    //   2557: invokevirtual iterator : ()Ljava/util/Iterator;
    //   2560: astore #21
    //   2562: dconst_0
    //   2563: dstore #6
    //   2565: dload #6
    //   2567: dstore #8
    //   2569: aload #21
    //   2571: invokeinterface hasNext : ()Z
    //   2576: ifeq -> 2823
    //   2579: aload #21
    //   2581: invokeinterface next : ()Ljava/lang/Object;
    //   2586: checkcast java/util/HashMap
    //   2589: astore #22
    //   2591: aload #22
    //   2593: ldc_w 'nProductQty'
    //   2596: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2599: invokevirtual toString : ()Ljava/lang/String;
    //   2602: invokestatic parseDouble : (Ljava/lang/String;)D
    //   2605: dstore #10
    //   2607: aload_1
    //   2608: getfield aWa : Z
    //   2611: ifeq -> 2664
    //   2614: aload #22
    //   2616: ldc_w 'nFoodCategory'
    //   2619: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   2622: ifeq -> 2650
    //   2625: aload #22
    //   2627: ldc_w 'nFoodCategory'
    //   2630: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2633: iconst_2
    //   2634: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2637: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2640: ifeq -> 2650
    //   2643: dload #8
    //   2645: dstore #10
    //   2647: goto -> 2738
    //   2650: dload #6
    //   2652: dload #10
    //   2654: dadd
    //   2655: dstore #6
    //   2657: dload #8
    //   2659: dstore #10
    //   2661: goto -> 2738
    //   2664: aload #22
    //   2666: ldc_w 'nProductTransacType'
    //   2669: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   2672: ifeq -> 2702
    //   2675: aload #22
    //   2677: ldc_w 'nProductTransacType'
    //   2680: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2683: checkcast java/lang/Long
    //   2686: invokevirtual longValue : ()J
    //   2689: ldc2_w 100015
    //   2692: lcmp
    //   2693: ifne -> 2702
    //   2696: iconst_1
    //   2697: istore #14
    //   2699: goto -> 2705
    //   2702: iconst_0
    //   2703: istore #14
    //   2705: aload #22
    //   2707: ldc_w 'nFoodCategory'
    //   2710: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   2713: ifeq -> 2745
    //   2716: aload #22
    //   2718: ldc_w 'nFoodCategory'
    //   2721: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2724: iconst_2
    //   2725: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2728: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2731: ifeq -> 2745
    //   2734: dload #8
    //   2736: dstore #10
    //   2738: dload #10
    //   2740: dstore #8
    //   2742: goto -> 2569
    //   2745: dload #10
    //   2747: dconst_0
    //   2748: dcmpl
    //   2749: ifle -> 2771
    //   2752: iload #14
    //   2754: ifne -> 2771
    //   2757: dload #6
    //   2759: dload #10
    //   2761: dadd
    //   2762: dstore #6
    //   2764: dload #8
    //   2766: dstore #10
    //   2768: goto -> 2738
    //   2771: dload #6
    //   2773: dload #10
    //   2775: dsub
    //   2776: dstore #12
    //   2778: dload #12
    //   2780: dstore #6
    //   2782: dload #8
    //   2784: dstore #10
    //   2786: aload #22
    //   2788: ldc_w 'fAmount'
    //   2791: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   2794: ifeq -> 2738
    //   2797: dload #8
    //   2799: aload #22
    //   2801: ldc_w 'fAmount'
    //   2804: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2807: invokevirtual toString : ()Ljava/lang/String;
    //   2810: invokestatic parseDouble : (Ljava/lang/String;)D
    //   2813: dadd
    //   2814: dstore #10
    //   2816: dload #12
    //   2818: dstore #6
    //   2820: goto -> 2738
    //   2823: aload_0
    //   2824: aload #24
    //   2826: dload #6
    //   2828: invokespecial a : (Lcom/laiqian/print/b/e;D)Z
    //   2831: pop
    //   2832: aload_0
    //   2833: aload #24
    //   2835: aload_1
    //   2836: getfield cyO : Ljava/lang/Double;
    //   2839: invokevirtual doubleValue : ()D
    //   2842: dload #8
    //   2844: dsub
    //   2845: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2848: aload_1
    //   2849: getfield aWa : Z
    //   2852: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Z)Z
    //   2855: pop
    //   2856: aload_1
    //   2857: getfield bbS : Ljava/util/ArrayList;
    //   2860: invokevirtual size : ()I
    //   2863: iconst_1
    //   2864: if_icmpne -> 2954
    //   2867: aload_1
    //   2868: getfield bbS : Ljava/util/ArrayList;
    //   2871: iconst_0
    //   2872: invokevirtual get : (I)Ljava/lang/Object;
    //   2875: checkcast com/laiqian/entity/z
    //   2878: getfield aTv : I
    //   2881: sipush #10001
    //   2884: if_icmpne -> 2954
    //   2887: aload_1
    //   2888: getfield bbS : Ljava/util/ArrayList;
    //   2891: iconst_0
    //   2892: invokevirtual get : (I)Ljava/lang/Object;
    //   2895: checkcast com/laiqian/entity/z
    //   2898: getfield aTw : D
    //   2901: dstore #6
    //   2903: dload #6
    //   2905: invokestatic bc : (D)Z
    //   2908: ifne -> 3099
    //   2911: aload_0
    //   2912: aload #24
    //   2914: aload_1
    //   2915: getfield cyO : Ljava/lang/Double;
    //   2918: invokevirtual doubleValue : ()D
    //   2921: dload #6
    //   2923: dadd
    //   2924: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2927: aload_1
    //   2928: getfield aWa : Z
    //   2931: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Z)Z
    //   2934: pop
    //   2935: aload_0
    //   2936: aload #24
    //   2938: dload #6
    //   2940: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2943: aload_1
    //   2944: getfield aWa : Z
    //   2947: invokespecial c : (Lcom/laiqian/print/b/e;Ljava/lang/Double;Z)Z
    //   2950: pop
    //   2951: goto -> 3099
    //   2954: aload_1
    //   2955: getfield bbS : Ljava/util/ArrayList;
    //   2958: invokevirtual iterator : ()Ljava/util/Iterator;
    //   2961: astore #21
    //   2963: aload #21
    //   2965: invokeinterface hasNext : ()Z
    //   2970: ifeq -> 3099
    //   2973: aload #21
    //   2975: invokeinterface next : ()Ljava/lang/Object;
    //   2980: checkcast com/laiqian/entity/z
    //   2983: astore #22
    //   2985: aload #22
    //   2987: getfield aJW : D
    //   2990: dconst_0
    //   2991: dcmpg
    //   2992: ifge -> 3054
    //   2995: new java/lang/StringBuilder
    //   2998: dup
    //   2999: invokespecial <init> : ()V
    //   3002: astore #23
    //   3004: aload #23
    //   3006: aload #22
    //   3008: getfield name : Ljava/lang/String;
    //   3011: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3014: pop
    //   3015: aload #23
    //   3017: aload_0
    //   3018: getfield context : Landroid/content/Context;
    //   3021: ldc_w 2131628776
    //   3024: invokevirtual getString : (I)Ljava/lang/String;
    //   3027: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3030: pop
    //   3031: aload_0
    //   3032: aload #24
    //   3034: aload #23
    //   3036: invokevirtual toString : ()Ljava/lang/String;
    //   3039: aload #22
    //   3041: getfield aJW : D
    //   3044: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3047: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   3050: pop
    //   3051: goto -> 2963
    //   3054: aload_1
    //   3055: getfield aWa : Z
    //   3058: ifeq -> 3072
    //   3061: aload #22
    //   3063: getfield aJW : D
    //   3066: dneg
    //   3067: dstore #6
    //   3069: goto -> 3079
    //   3072: aload #22
    //   3074: getfield aJW : D
    //   3077: dstore #6
    //   3079: aload_0
    //   3080: aload #24
    //   3082: aload #22
    //   3084: getfield name : Ljava/lang/String;
    //   3087: dload #6
    //   3089: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3092: invokespecial a : (Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   3095: pop
    //   3096: goto -> 2963
    //   3099: aload_1
    //   3100: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3103: astore #21
    //   3105: aconst_null
    //   3106: astore #22
    //   3108: aload #21
    //   3110: ifnull -> 3352
    //   3113: aload #24
    //   3115: bipush #45
    //   3117: invokevirtual l : (C)V
    //   3120: aload_1
    //   3121: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3124: getfield name : Ljava/lang/String;
    //   3127: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3130: ifne -> 3172
    //   3133: invokestatic zR : ()Lcom/laiqian/c/a;
    //   3136: invokevirtual Ab : ()Z
    //   3139: ifne -> 3160
    //   3142: aload_1
    //   3143: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3146: getfield name : Ljava/lang/String;
    //   3149: ldc_w '*'
    //   3152: invokestatic bv : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3155: astore #21
    //   3157: goto -> 3252
    //   3160: aload_1
    //   3161: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3164: getfield name : Ljava/lang/String;
    //   3167: astore #21
    //   3169: goto -> 3252
    //   3172: aload_1
    //   3173: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3176: getfield aTp : Ljava/lang/String;
    //   3179: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3182: ifne -> 3224
    //   3185: invokestatic zR : ()Lcom/laiqian/c/a;
    //   3188: invokevirtual Ab : ()Z
    //   3191: ifeq -> 3206
    //   3194: aload_1
    //   3195: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3198: getfield aTp : Ljava/lang/String;
    //   3201: astore #21
    //   3203: goto -> 3252
    //   3206: aload_1
    //   3207: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3210: getfield aTp : Ljava/lang/String;
    //   3213: ldc_w '****'
    //   3216: invokestatic bu : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3219: astore #21
    //   3221: goto -> 3252
    //   3224: aload_1
    //   3225: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3228: getfield aWn : Ljava/lang/String;
    //   3231: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3234: ifne -> 3249
    //   3237: aload_1
    //   3238: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3241: getfield aWn : Ljava/lang/String;
    //   3244: astore #21
    //   3246: goto -> 3252
    //   3249: aconst_null
    //   3250: astore #21
    //   3252: aload #21
    //   3254: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3257: ifne -> 3269
    //   3260: aload_0
    //   3261: aload #24
    //   3263: aload #21
    //   3265: invokespecial k : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   3268: pop
    //   3269: aload_1
    //   3270: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3273: getfield aWo : D
    //   3276: dconst_0
    //   3277: dcmpl
    //   3278: ifle -> 3298
    //   3281: aload_0
    //   3282: aload #24
    //   3284: aload_1
    //   3285: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3288: getfield aWo : D
    //   3291: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3294: invokespecial b : (Lcom/laiqian/print/b/e;Ljava/lang/Double;)Z
    //   3297: pop
    //   3298: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3301: invokevirtual Cd : ()Z
    //   3304: ifeq -> 3352
    //   3307: new java/lang/StringBuilder
    //   3310: dup
    //   3311: invokespecial <init> : ()V
    //   3314: astore #21
    //   3316: aload #21
    //   3318: aload_1
    //   3319: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   3322: getfield aWp : J
    //   3325: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   3328: pop
    //   3329: aload #21
    //   3331: ldc ''
    //   3333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: pop
    //   3337: aload_0
    //   3338: aload #24
    //   3340: ldc_w 2131628751
    //   3343: aload #21
    //   3345: invokevirtual toString : ()Ljava/lang/String;
    //   3348: invokespecial b : (Lcom/laiqian/print/b/e;ILjava/lang/String;)Z
    //   3351: pop
    //   3352: aload_1
    //   3353: getfield cyR : Ljava/util/ArrayList;
    //   3356: invokevirtual size : ()I
    //   3359: ifeq -> 3558
    //   3362: aload #24
    //   3364: bipush #45
    //   3366: invokevirtual l : (C)V
    //   3369: aload #24
    //   3371: iconst_3
    //   3372: newarray int
    //   3374: dup
    //   3375: iconst_0
    //   3376: bipush #12
    //   3378: iastore
    //   3379: dup
    //   3380: iconst_1
    //   3381: bipush #10
    //   3383: iastore
    //   3384: dup
    //   3385: iconst_2
    //   3386: bipush #10
    //   3388: iastore
    //   3389: invokevirtual n : ([I)V
    //   3392: aload #24
    //   3394: iconst_3
    //   3395: anewarray java/lang/String
    //   3398: dup
    //   3399: iconst_0
    //   3400: ldc_w 'GST'
    //   3403: aastore
    //   3404: dup
    //   3405: iconst_1
    //   3406: ldc_w 'Amount'
    //   3409: aastore
    //   3410: dup
    //   3411: iconst_2
    //   3412: ldc_w 'Tax'
    //   3415: aastore
    //   3416: invokevirtual x : ([Ljava/lang/String;)V
    //   3419: aload #24
    //   3421: bipush #45
    //   3423: invokevirtual l : (C)V
    //   3426: aload_1
    //   3427: getfield cyR : Ljava/util/ArrayList;
    //   3430: invokevirtual iterator : ()Ljava/util/Iterator;
    //   3433: astore #21
    //   3435: aload #21
    //   3437: invokeinterface hasNext : ()Z
    //   3442: ifeq -> 3558
    //   3445: aload #21
    //   3447: invokeinterface next : ()Ljava/lang/Object;
    //   3452: checkcast com/laiqian/product/models/p
    //   3455: astore #23
    //   3457: new java/lang/StringBuilder
    //   3460: dup
    //   3461: invokespecial <init> : ()V
    //   3464: astore #25
    //   3466: aload #25
    //   3468: aload #23
    //   3470: invokevirtual IT : ()Ljava/lang/String;
    //   3473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3476: pop
    //   3477: aload #25
    //   3479: ldc_w '='
    //   3482: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3485: pop
    //   3486: aload #25
    //   3488: aload #23
    //   3490: invokevirtual alg : ()D
    //   3493: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   3496: pop
    //   3497: aload #25
    //   3499: ldc_w '%'
    //   3502: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3505: pop
    //   3506: aload #24
    //   3508: iconst_3
    //   3509: anewarray java/lang/String
    //   3512: dup
    //   3513: iconst_0
    //   3514: aload #25
    //   3516: invokevirtual toString : ()Ljava/lang/String;
    //   3519: aastore
    //   3520: dup
    //   3521: iconst_1
    //   3522: aload #23
    //   3524: invokevirtual ali : ()D
    //   3527: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3530: iconst_1
    //   3531: iconst_0
    //   3532: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   3535: aastore
    //   3536: dup
    //   3537: iconst_2
    //   3538: aload #23
    //   3540: invokevirtual alh : ()D
    //   3543: invokestatic valueOf : (D)Ljava/lang/Double;
    //   3546: iconst_1
    //   3547: iconst_0
    //   3548: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   3551: aastore
    //   3552: invokevirtual x : ([Ljava/lang/String;)V
    //   3555: goto -> 3435
    //   3558: iconst_0
    //   3559: istore #14
    //   3561: aload_3
    //   3562: invokevirtual aiw : ()I
    //   3565: ifne -> 3578
    //   3568: aload_3
    //   3569: invokevirtual aiq : ()Ljava/lang/String;
    //   3572: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3575: ifne -> 3585
    //   3578: aload #24
    //   3580: bipush #45
    //   3582: invokevirtual l : (C)V
    //   3585: aload_3
    //   3586: invokevirtual aiw : ()I
    //   3589: iconst_3
    //   3590: if_icmpne -> 3596
    //   3593: iconst_1
    //   3594: istore #14
    //   3596: aload_3
    //   3597: invokevirtual aiw : ()I
    //   3600: istore #15
    //   3602: iload #14
    //   3604: ifeq -> 3628
    //   3607: getstatic com/laiqian/pos/industry/weiorder/advertisement/u.cxS : Lcom/laiqian/pos/industry/weiorder/advertisement/u;
    //   3610: aload_1
    //   3611: getfield cyO : Ljava/lang/Double;
    //   3614: invokevirtual doubleValue : ()D
    //   3617: aload_1
    //   3618: getfield orderNo : Ljava/lang/String;
    //   3621: invokevirtual b : (DLjava/lang/String;)Ljava/lang/String;
    //   3624: astore_1
    //   3625: goto -> 3633
    //   3628: aload_3
    //   3629: invokevirtual aix : ()Ljava/lang/String;
    //   3632: astore_1
    //   3633: aload #22
    //   3635: astore #21
    //   3637: aload_3
    //   3638: invokevirtual aiw : ()I
    //   3641: iconst_1
    //   3642: if_icmpne -> 3657
    //   3645: aload_0
    //   3646: getfield context : Landroid/content/Context;
    //   3649: ldc_w 2131628777
    //   3652: invokevirtual getString : (I)Ljava/lang/String;
    //   3655: astore #21
    //   3657: aload_0
    //   3658: aload #24
    //   3660: iload #15
    //   3662: aload_1
    //   3663: aload #21
    //   3665: invokespecial a : (Lcom/laiqian/print/b/e;ILjava/lang/String;Ljava/lang/String;)Z
    //   3668: istore #4
    //   3670: aload_3
    //   3671: invokevirtual aiq : ()Ljava/lang/String;
    //   3674: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3677: ifne -> 3692
    //   3680: iload #4
    //   3682: ifeq -> 3692
    //   3685: aload #24
    //   3687: bipush #45
    //   3689: invokevirtual l : (C)V
    //   3692: aload_0
    //   3693: aload #24
    //   3695: aload_3
    //   3696: invokevirtual aiq : ()Ljava/lang/String;
    //   3699: invokespecial l : (Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   3702: pop
    //   3703: aload_0
    //   3704: aload #24
    //   3706: aload_3
    //   3707: invokevirtual air : ()I
    //   3710: invokespecial a : (Lcom/laiqian/print/b/e;I)Z
    //   3713: pop
    //   3714: aload #24
    //   3716: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   3719: aload_2
    //   3720: invokeinterface getCopies : ()I
    //   3725: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   3728: pop
    //   3729: aload #24
    //   3731: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   3734: invokestatic singletonList : (Ljava/lang/Object;)Ljava/util/List;
    //   3737: areturn
    // Exception table:
    //   from	to	target	type
    //   1107	1130	1153	org/json/JSONException
    //   1130	1145	1148	org/json/JSONException
    //   1224	1237	1320	org/json/JSONException
    //   1241	1254	1320	org/json/JSONException
    //   1258	1273	1320	org/json/JSONException
    //   1273	1296	1315	org/json/JSONException
    //   1307	1312	1320	org/json/JSONException
    //   1396	1409	1492	org/json/JSONException
    //   1396	1409	1492	java/lang/NullPointerException
    //   1413	1426	1492	org/json/JSONException
    //   1413	1426	1492	java/lang/NullPointerException
    //   1430	1445	1492	org/json/JSONException
    //   1430	1445	1492	java/lang/NullPointerException
    //   1445	1468	1487	org/json/JSONException
    //   1445	1468	1487	java/lang/NullPointerException
    //   1479	1484	1492	org/json/JSONException
    //   1479	1484	1492	java/lang/NullPointerException }
  
  private List<PrintContent> a(b paramb, j.m paramm, c paramc, boolean paramBoolean) {
    ArrayList arrayList = new ArrayList();
    if (paramc.aja() == 2 && paramb.bcf == 1L)
      return arrayList; 
    List list = paramm.aep();
    Iterator iterator2 = paramb.bJf.iterator();
    int i;
    for (i = 0; iterator2.hasNext(); i += j) {
      HashMap hashMap = (HashMap)iterator2.next();
      try {
        String str = (String)hashMap.get("nProductType");
        if (str != null) {
          paramBoolean = paramm.aep().contains(Long.valueOf(Long.parseLong(str)));
          if (paramBoolean)
            continue; 
        } 
      } catch (ClassCastException classCastException) {
        a.e(classCastException);
      } 
      if (hashMap.containsKey("nFoodCategory"))
        try {
          int k = ((Integer)hashMap.get("nFoodCategory")).intValue();
          if (k == 2)
            continue; 
        } catch (ClassCastException classCastException) {
          a.e(classCastException);
        }  
      if (!a(paramb, paramc, hashMap))
        continue; 
      int j = (int)Double.parseDouble((String)hashMap.get("nProductQty"));
      if (j <= 0)
        continue; 
    } 
    if (i > 100)
      return null; 
    if (paramc.aiV() == c.cOl) {
      a(paramb, paramc, arrayList, paramm.aep(), i);
    } else {
      a(paramb, paramc, arrayList, list);
    } 
    Iterator iterator1 = arrayList.iterator();
    while (iterator1.hasNext())
      ((PrintContent)iterator1.next()).setCopies(paramm.getCopies()); 
    return arrayList;
  }
  
  private void a(b paramb, c paramc, ArrayList<PrintContent> paramArrayList, List<Long> paramList) {
    int i = paramb.bJf.size();
    Iterator iterator = paramb.bJf.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      HashMap hashMap = (HashMap)iterator.next();
      try {
        long l = Long.parseLong((String)hashMap.get("nProductType"));
        try {
          boolean bool1 = paramList.contains(Long.valueOf(l));
          if (bool1)
            continue; 
        } catch (Exception null) {}
      } catch (Exception exception) {}
      a.e(exception);
    } 
  }
  
  private void a(b paramb, c paramc, ArrayList<PrintContent> paramArrayList, List<Long> paramList, int paramInt) {
    Iterator iterator = paramb.bJf.iterator();
    boolean bool = true;
    byte b1 = 1;
    while (iterator.hasNext()) {
      HashMap hashMap = (HashMap)iterator.next();
      try {
        str1 = (String)hashMap.get("nProductType");
        if (str1 != null) {
          long l = Long.parseLong(str1);
          try {
            boolean bool1 = paramList.contains(Long.valueOf(l));
            if (bool1)
              continue; 
          } catch (ClassCastException str1) {
            a.e(str1);
          } 
        } 
      } catch (ClassCastException classCastException) {
        a.e(classCastException);
      } 
      if (hashMap.containsKey("nFoodCategory"))
        try {
          int j = ((Integer)hashMap.get("nFoodCategory")).intValue();
          if (j == 2)
            continue; 
        } catch (ClassCastException classCastException) {
          a.e(classCastException);
        }  
      if (!a(paramb, paramc, hashMap))
        continue; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(hashMap.get("nProductQty"));
      stringBuilder.append("");
      int i = (int)by.parseDouble(stringBuilder.toString());
      if (i <= 0)
        continue; 
      String str = this.context.getString(2131626345);
      byte b2 = 0;
      while (b2 < i) {
        String str1;
        g g = new g();
        g.setWidth(paramc.getWidth());
        g.n(new int[] { 18, 6 });
        g.setSize(3);
        if (paramb.bcf == 7L) {
          str1 = paramb.openTableName;
        } else if (hashMap.containsKey("tableNo") && hashMap.get("tableNo") != null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(CrashApplication.zv().getString(2131627286));
          stringBuilder.append(hashMap.get("tableNo"));
          str1 = stringBuilder.toString();
        } else if (paramb.coJ != null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(paramb.coJ);
          str1 = stringBuilder.toString();
        } else {
          str1 = "";
        } 
        String str2 = "";
        if (paramInt != bool)
          str2 = String.format("%d-%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(b1) }); 
        g.setSize(1);
        if (!str1.isEmpty() || !str2.isEmpty()) {
          String str3;
          if (paramb.aTZ) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(" ");
            str3 = stringBuilder2.toString();
          } else {
            str3 = " ";
          } 
          if (!str1.isEmpty() && !str2.isEmpty()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str3);
            stringBuilder2.append(str1);
            g.x(new String[] { stringBuilder2.toString(), str2 });
          } else {
            StringBuilder stringBuilder2;
            if (!str1.isEmpty()) {
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append(str3);
              stringBuilder2.append(str1);
              g.ll(stringBuilder2.toString());
            } else if (paramb.aTZ) {
              g.x(new String[] { str3, stringBuilder2 });
            } else {
              g.f(stringBuilder2, 1, 2);
            } 
          } 
          g.setSize(3);
          g.l('-');
        } else {
          g.setSize(1);
          if (paramb.aTZ)
            g.x(new String[] { str }); 
          g.setSize(3);
          g.l('-');
        } 
        a(g.afT(), hashMap, 0, paramc, paramb);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        g.afT().ln(String.format("%s", new Object[] { simpleDateFormat.format(paramb.bkf) }));
        g.afT().ln(paramc.aiW());
        g.afT().setWidth(paramc.getWidth());
        g.afT().setHeight(paramc.getHeight());
        PrintContent.a a = g.afT();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramc.getWidth());
        stringBuilder1.append("");
        a.aJ("width", stringBuilder1.toString());
        a = g.afT();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramc.getHeight());
        stringBuilder1.append("");
        a.aJ("height", stringBuilder1.toString());
        g.afT().s(paramc.aiX(), true);
        paramArrayList.add(g.afV());
        b1++;
        b2++;
        bool = true;
      } 
    } 
  }
  
  private void a(e parame, HashMap<String, Object> paramHashMap, c paramc, b paramb) {
    String str2;
    byte b1;
    b b2 = new b((a)parame);
    b2.afW();
    int i = b2.getSize();
    switch (paramc.aiG()) {
      default:
        b1 = 3;
        break;
      case 1:
        b1 = 1;
        break;
    } 
    b2.setSize(b1);
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
      b1 = 1;
    } else {
      b1 = 0;
    } 
    String str1 = str3;
    if (b1 != 0) {
      StringBuilder stringBuilder;
      str1 = this.context.getString(2131626345);
      if (str3.contains("|-")) {
        str3 = str3.replace("|-", "");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[");
        stringBuilder1.append(str1);
        stringBuilder1.append("]");
        stringBuilder1.append(str3);
        str1 = stringBuilder1.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(str1);
        str1 = stringBuilder.toString();
      } else {
        str1 = String.format("[%s]%s", new Object[] { str1, stringBuilder });
      } 
    } 
    String str5 = (String)paramHashMap.get("fPrice");
    str3 = (String)paramHashMap.get("nProductQty");
    str3 = n.b(this.context, str3, false);
    null = new StringBuilder();
    null.append(paramHashMap.get("nProductTransacType"));
    null.append("");
    String str6 = null.toString();
    String str4 = n.b(this.context, str3, false);
    str3 = str4;
    if (str6.equals("100015")) {
      str3 = str4;
      if (paramb.aWg) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-");
        stringBuilder.append(str4);
        str3 = stringBuilder.toString();
      } 
    } 
    if (paramc.aiD()) {
      b2.n(new int[] { 0, 16, 32 });
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(str3);
      b2.x(new String[] { str1, stringBuilder.toString(), str5 });
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(str3);
      b2.x(new String[] { str1, stringBuilder.toString() });
    } 
    if (paramHashMap.containsKey("sSpareField5") && !TextUtils.isEmpty((String)paramHashMap.get("sSpareField5")))
      if (paramHashMap.containsKey("nFoodCategory") && paramHashMap.get("nFoodCategory").equals(Integer.valueOf(3))) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(paramHashMap.get("sSpareField5"));
        b2.ll(stringBuilder.toString());
      } else {
        b2.ll((String)paramHashMap.get("sSpareField5"));
      }  
    b2.setSize(i);
    b2.afT().aJ("name", str1);
  }
  
  private void a(PrintContent.a parama, HashMap<String, Object> paramHashMap, int paramInt, c paramc, b paramb) {
    String str4;
    if (paramInt == 0) {
      String str7 = (String)paramHashMap.get("taste");
      String str6 = (String)paramHashMap.get("sProductName");
      str4 = str6;
      if (str7 != null) {
        str4 = str6;
        if (!str7.trim().isEmpty()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str6);
          stringBuilder.append("[");
          stringBuilder.append(str7);
          stringBuilder.append("]");
          String str = stringBuilder.toString();
        } 
      } 
    } else if (paramInt == 1) {
      str4 = (String)paramHashMap.get("sProductName");
    } else {
      str4 = null;
    } 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramHashMap.get("isProductPack"));
    stringBuilder3.append("");
    String str5 = str4;
    if (by.se(stringBuilder3.toString())) {
      str5 = str4;
      if (!paramb.aTZ) {
        StringBuilder stringBuilder;
        null = new StringBuilder();
        null.append(paramHashMap.get("nFoodCategory"));
        null.append("");
        paramInt = by.parseInt(null.toString());
        String str = this.context.getString(2131626345);
        if (paramInt == 3) {
          str4 = str4.replace("|-", "");
          str5 = new StringBuilder();
          str5.append("[");
          str5.append(str);
          str5.append("]");
          str5.append(str4);
          str = str5.toString();
          stringBuilder = new StringBuilder();
          stringBuilder.append("|-");
          stringBuilder.append(str);
          String str6 = stringBuilder.toString();
        } else {
          str5 = new StringBuilder();
          str5.append("[");
          str5.append(str);
          str5.append("]");
          str5.append(stringBuilder);
          str5 = str5.toString();
        } 
      } 
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramHashMap.get("nProductQty"));
    stringBuilder2.append("");
    double d3 = by.parseDouble(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramHashMap.get("fPrice"));
    stringBuilder2.append("");
    double d2 = by.parseDouble(stringBuilder2.toString());
    paramInt = e.ml(str5);
    int i = e.jg(paramc.getWidth());
    null = new g(parama);
    null.setWidth(paramc.getWidth());
    null.ic(CrashApplication.aIQ);
    if (paramInt <= i / 2) {
      null.f(str5, 3, 0);
    } else if (paramInt <= i) {
      null.f(str5, 1, 0);
    } else {
      null.ll(str5);
    } 
    double d1 = d2;
    if (paramc.aiV() == paramc.cOm)
      d1 = d2 * d3; 
    null = new StringBuilder();
    null.append(CrashApplication.zA());
    null.append(n.b(this.context, Double.valueOf(d1), true));
    String str1 = null.toString();
    stringBuilder2 = new StringBuilder();
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
  
  private void a(ArrayList<HashMap<String, Object>> paramArrayList, @NonNull List<Long> paramList) {
    boolean bool = paramArrayList.toString().contains("|-");
    byte b = 0;
    if (bool) {
      HashMap hashMap = null;
      for (byte b1 = 0; b1 < paramArrayList.size(); b1++) {
        HashMap hashMap1 = (HashMap)paramArrayList.get(b1);
        if (((String)hashMap1.get("sProductName")).startsWith("|-") && hashMap != null) {
          ArrayList arrayList2 = (ArrayList)hashMap.get("linshiProductList");
          ArrayList arrayList1 = arrayList2;
          if (arrayList2 == null) {
            arrayList1 = new ArrayList();
            hashMap.put("linshiProductList", arrayList1);
          } 
          arrayList1.add(hashMap1);
          paramArrayList.remove(b1);
          b1--;
        } else {
          hashMap = hashMap1;
        } 
      } 
    } 
    for (HashMap hashMap : paramArrayList) {
      if (hashMap.containsKey("nProductType") && hashMap.get("nProductType") != null && paramList.contains(Long.valueOf(Long.parseLong((String)hashMap.get("nProductType"))))) {
        null.remove();
        continue;
      } 
      if (hashMap.containsKey("linshiProductList")) {
        ArrayList arrayList = (ArrayList)hashMap.get("linshiProductList");
        for (HashMap hashMap1 : arrayList) {
          if (hashMap1.containsKey("nProductType") && hashMap1.get("nProductType") != null && paramList.contains(Long.valueOf(Long.parseLong((String)hashMap1.get("nProductType")))))
            null.remove(); 
        } 
        if (arrayList.size() == 0)
          null.remove(); 
      } 
    } 
    int j = paramArrayList.size();
    int i;
    for (i = 0; i < j - 1; i = b1) {
      byte b1 = i + true;
      byte b2;
      for (b2 = b1; b2 < j; b2++) {
        HashMap hashMap1 = (HashMap)paramArrayList.get(i);
        String str1 = (String)hashMap1.get("sProductName");
        HashMap hashMap2 = (HashMap)paramArrayList.get(b2);
        String str2 = (String)hashMap2.get("sProductName");
        if (n.pp(str1) && n.pp(str2) && str1.compareToIgnoreCase(str2) > 0) {
          paramArrayList.set(b2, hashMap1);
          paramArrayList.set(i, hashMap2);
        } 
      } 
    } 
    if (bool)
      for (i = b; i < paramArrayList.size(); i = k + 1) {
        HashMap hashMap = (HashMap)paramArrayList.get(i);
        ArrayList arrayList = (ArrayList)hashMap.get("linshiProductList");
        int k = i;
        if (arrayList != null) {
          paramArrayList.addAll(i + 1, arrayList);
          k = i + arrayList.size();
          hashMap.remove("linshiProductList");
        } 
      }  
  }
  
  private boolean a(b paramb, c paramc, HashMap<String, Object> paramHashMap) {
    int i = paramc.aja();
    int j = c.cOo;
    boolean bool = true;
    if (i == j || paramc.aja() == 2 || paramb.aTZ) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramHashMap.get("isProductPack"));
      stringBuilder.append("");
      bool = by.se(stringBuilder.toString());
    } 
    return bool;
  }
  
  private boolean a(a parama, Date paramDate, String paramString) {
    String str1;
    if (parama == null)
      return false; 
    if (paramDate == null)
      return false; 
    g g = new g(parama);
    g.n(new int[] { 3, 2 });
    if (!n.bL(this.context)) {
      str2 = Xn().format(paramDate);
      if (paramString != null) {
        str1 = iP(paramString);
      } else {
        String str;
        str1 = "";
      } 
      g.x(new String[] { str2, str1 });
      return true;
    } 
    String str2 = Xn().format(str2);
    if (paramString != null) {
      str1 = iP(paramString);
    } else {
      str1 = "";
    } 
    g.x(new String[] { str2, str1 });
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
    //   21: iconst_3
    //   22: if_icmpne -> 44
    //   25: aload_3
    //   26: sipush #250
    //   29: invokestatic B : (Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   32: astore_3
    //   33: goto -> 110
    //   36: astore_3
    //   37: aload_3
    //   38: invokestatic e : (Ljava/lang/Throwable;)V
    //   41: goto -> 108
    //   44: iload_2
    //   45: iconst_1
    //   46: if_icmpne -> 108
    //   49: aload_0
    //   50: getfield context : Landroid/content/Context;
    //   53: invokestatic aR : (Landroid/content/Context;)Ljava/lang/String;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull -> 108
    //   61: new java/io/File
    //   64: dup
    //   65: aload_3
    //   66: invokespecial <init> : (Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual exists : ()Z
    //   74: ifeq -> 108
    //   77: new java/io/FileInputStream
    //   80: dup
    //   81: aload_3
    //   82: invokespecial <init> : (Ljava/io/File;)V
    //   85: astore #5
    //   87: aload #5
    //   89: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   92: astore_3
    //   93: aload #5
    //   95: invokevirtual close : ()V
    //   98: goto -> 110
    //   101: astore_1
    //   102: aload_1
    //   103: invokestatic e : (Ljava/lang/Throwable;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aconst_null
    //   109: astore_3
    //   110: aload_3
    //   111: ifnonnull -> 116
    //   114: iconst_0
    //   115: ireturn
    //   116: aload_1
    //   117: invokeinterface afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   122: aload_3
    //   123: iconst_1
    //   124: invokevirtual a : (Landroid/graphics/Bitmap;I)Lcom/laiqian/print/model/PrintContent$a;
    //   127: pop
    //   128: aload #4
    //   130: ifnull -> 143
    //   133: aload_1
    //   134: aload #4
    //   136: iconst_0
    //   137: iconst_1
    //   138: invokeinterface f : (Ljava/lang/String;II)V
    //   143: iconst_1
    //   144: ireturn
    // Exception table:
    //   from	to	target	type
    //   25	33	36	com/google/zxing/WriterException
    //   77	98	101	java/io/IOException }
  
  private boolean a(e parame, Double paramDouble1, Double paramDouble2, Double paramDouble3, boolean paramBoolean) {
    double d;
    String str1;
    String str2 = this.context.getString(2131628403);
    if (paramBoolean) {
      d = -paramDouble3.doubleValue();
    } else {
      d = paramDouble3.doubleValue();
    } 
    a(parame, str2, Double.valueOf(d));
    if (this.context.getResources().getBoolean(2131034121)) {
      if ("evako".equals("lqkProd")) {
        str1 = this.context.getString(2131628743);
        if (paramBoolean) {
          d = paramDouble2.doubleValue();
        } else {
          d = -paramDouble2.doubleValue();
        } 
        a(parame, str1, Double.valueOf(d));
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.context.getString(2131628743));
        stringBuilder.append((int)(100L - Math.round(str1.doubleValue())));
        stringBuilder.append("%");
        str1 = stringBuilder.toString();
        if (paramBoolean) {
          d = paramDouble2.doubleValue();
        } else {
          d = -paramDouble2.doubleValue();
        } 
        a(parame, str1, Double.valueOf(d));
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.context.getString(2131628743));
      stringBuilder.append((int)Math.round(str1.doubleValue()));
      stringBuilder.append("%");
      str1 = stringBuilder.toString();
      if (paramBoolean) {
        d = paramDouble2.doubleValue();
      } else {
        d = -paramDouble2.doubleValue();
      } 
      a(parame, str1, Double.valueOf(d));
    } 
    return true;
  }
  
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
      if ("evako".equals("lqkProd")) {
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
    g g = new g(parame.afT());
    g.setWidth(parame.getWidth());
    g.ic(parame.afU());
    g.setSize(3);
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
        g.x(new String[] { this.context.getString(2131628730) });
      } else {
        g.x(new String[] { this.context.getString(2131628729) });
      } 
      g.o(new int[] { 2 });
      g.x(new String[] { str });
      return true;
    } 
    if (paramBoolean)
      i = 2131628730; 
    if (paramBoolean) {
      d = -paramDouble.doubleValue();
    } else {
      d = paramDouble.doubleValue();
    } 
    return a(g, i, Double.valueOf(d));
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
      if (hashMap.containsKey("selectTastesPrice")) {
        d3 = d5 + ((Double)hashMap.get("selectTastesPrice")).doubleValue();
      } else {
        d3 = d5;
      } 
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
        d5 = d7 * d3 / (d5 / 100.0D + 1.0D);
        d1 += d5;
      } else {
        if (!paramBoolean || d3 != d5) {
          d5 = d7 * d3;
        } else {
          d5 = 0.0D;
        } 
        d1 += d7 * d3;
      } 
      if (!hashMap.containsKey("noDiscount") || !((Boolean)hashMap.get("noDiscount")).booleanValue())
        d4 += d5; 
      b++;
      d3 = d4;
    } 
    if (this.context.getResources().getBoolean(2131034121)) {
      double = Double.valueOf(100.0D - paramDouble.doubleValue());
    } else {
      double = paramDouble;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("appendDiscount =");
    stringBuilder.append(d3);
    Log.i("discount", stringBuilder.toString());
    double d2 = Double.parseDouble(n.a(Double.valueOf(d3 * (100.0D - paramDouble.doubleValue()) / 100.0D), true, false));
    if (!n.bc(d2)) {
      String str2 = this.context.getString(2131628403);
      double d = d1;
      if (paramBoolean)
        d = -d1; 
      a(parame, str2, Double.valueOf(d));
      if ("evako".equals("lqkProd")) {
        str2 = this.context.getString(2131628743);
        if (!paramBoolean)
          d2 = -d2; 
        a(parame, str2, Double.valueOf(d2));
        return true;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.context.getString(2131628743));
      stringBuilder1.append((int)Math.round(double.doubleValue()));
      stringBuilder1.append("%");
      String str1 = stringBuilder1.toString();
      if (!paramBoolean)
        d2 = -d2; 
      a(parame, str1, Double.valueOf(d2));
      return true;
    } 
    return false;
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
    PrintContent.a a = parame.afT();
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
    a.a(paramString1, 1);
    if (!TextUtils.isEmpty(paramString2))
      parame.f(paramString2, 0, 1); 
    return true;
  }
  
  private boolean a(e parame, String paramString, ArrayList<HashMap<String, Object>> paramArrayList, c paramc, boolean paramBoolean, b paramb, List<Long> paramList) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (paramBoolean) {
      str = "-";
    } else {
      str = "";
    } 
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
      String str1 = (String)hashMap.get(paramString);
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
      if (str5 == null || !paramList.contains(Long.valueOf(Long.parseLong(str5)))) {
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
          if (str3.contains("|-")) {
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
          b2.n(new int[] { 0, 16, 32 });
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
  
  private boolean a(e parame, String paramString, Date paramDate) {
    g g = new g(parame.afT());
    g.setWidth(parame.getWidth());
    g.ic(parame.afU());
    g.n(new int[] { 10, 22 });
    g.x(new String[] { paramString, Xn().format(paramDate) });
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
    return (!n.bc(d) && a(parame, this.context.getString(2131628748), Double.valueOf(d)));
  }
  
  private boolean a(e parame, @NonNull ArrayList<HashMap<String, Object>> paramArrayList, b paramb, int paramInt, boolean paramBoolean, ReceiptPrintSettings paramReceiptPrintSettings) { // Byte code:
    //   0: new com/laiqian/print/b/b
    //   3: dup
    //   4: aload_1
    //   5: checkcast com/laiqian/print/b/a
    //   8: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   11: astore #24
    //   13: aload #24
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
    //   61: aload #24
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
    //   103: aload #24
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
    //   155: aload #24
    //   157: bipush #45
    //   159: invokevirtual l : (C)V
    //   162: aload #24
    //   164: invokevirtual getSize : ()I
    //   167: istore #15
    //   169: aload #24
    //   171: iload #4
    //   173: invokevirtual setSize : (I)V
    //   176: ldc ''
    //   178: astore #21
    //   180: aload_3
    //   181: getfield aWa : Z
    //   184: ifeq -> 192
    //   187: ldc_w '-'
    //   190: astore #21
    //   192: aload_2
    //   193: invokevirtual size : ()I
    //   196: istore #17
    //   198: iconst_0
    //   199: istore #4
    //   201: iload #4
    //   203: iload #17
    //   205: iconst_2
    //   206: imul
    //   207: if_icmpge -> 1639
    //   210: iload #4
    //   212: iload #17
    //   214: if_icmplt -> 227
    //   217: iload #4
    //   219: iload #17
    //   221: isub
    //   222: istore #16
    //   224: goto -> 231
    //   227: iload #4
    //   229: istore #16
    //   231: aload_2
    //   232: iload #16
    //   234: invokevirtual get : (I)Ljava/lang/Object;
    //   237: checkcast java/util/HashMap
    //   240: astore #25
    //   242: aload #25
    //   244: ldc_w 'nProductQty'
    //   247: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   250: invokevirtual toString : ()Ljava/lang/String;
    //   253: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   256: invokevirtual doubleValue : ()D
    //   259: dstore #11
    //   261: iload #4
    //   263: iload #17
    //   265: if_icmpge -> 286
    //   268: dload #11
    //   270: dconst_0
    //   271: dcmpg
    //   272: ifge -> 296
    //   275: iload #15
    //   277: istore #16
    //   279: iload #4
    //   281: istore #18
    //   283: goto -> 1626
    //   286: dload #11
    //   288: dconst_0
    //   289: dcmpl
    //   290: ifle -> 296
    //   293: goto -> 275
    //   296: aload #25
    //   298: ldc 'taste'
    //   300: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   303: istore #19
    //   305: aconst_null
    //   306: astore #23
    //   308: iload #19
    //   310: ifeq -> 328
    //   313: aload #25
    //   315: ldc 'taste'
    //   317: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   320: checkcast java/lang/String
    //   323: astore #22
    //   325: goto -> 331
    //   328: aconst_null
    //   329: astore #22
    //   331: aload #25
    //   333: ldc 'sProductName'
    //   335: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   338: checkcast java/lang/String
    //   341: astore #20
    //   343: aload #25
    //   345: ldc_w 'nFoodCategory'
    //   348: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   351: ifeq -> 420
    //   354: aload #20
    //   356: astore_1
    //   357: aload #25
    //   359: ldc_w 'nFoodCategory'
    //   362: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   365: iconst_3
    //   366: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   369: invokevirtual equals : (Ljava/lang/Object;)Z
    //   372: ifeq -> 423
    //   375: aload #20
    //   377: astore_1
    //   378: aload #20
    //   380: ldc_w '|-'
    //   383: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   386: ifne -> 423
    //   389: new java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial <init> : ()V
    //   396: astore_1
    //   397: aload_1
    //   398: ldc_w '|-'
    //   401: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: aload #20
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_1
    //   413: invokevirtual toString : ()Ljava/lang/String;
    //   416: astore_1
    //   417: goto -> 423
    //   420: aload #20
    //   422: astore_1
    //   423: aload_1
    //   424: astore #20
    //   426: aload #22
    //   428: ifnull -> 465
    //   431: aload_1
    //   432: astore #20
    //   434: aload #22
    //   436: invokevirtual trim : ()Ljava/lang/String;
    //   439: invokevirtual isEmpty : ()Z
    //   442: ifne -> 465
    //   445: ldc '%s[%s]'
    //   447: iconst_2
    //   448: anewarray java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: aload_1
    //   454: aastore
    //   455: dup
    //   456: iconst_1
    //   457: aload #22
    //   459: aastore
    //   460: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   463: astore #20
    //   465: aload #20
    //   467: astore_1
    //   468: iload #5
    //   470: ifeq -> 593
    //   473: aload #20
    //   475: astore_1
    //   476: aload #25
    //   478: ldc_w 'noDiscount'
    //   481: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   484: ifeq -> 593
    //   487: aload #20
    //   489: astore_1
    //   490: aload #25
    //   492: ldc_w 'noDiscount'
    //   495: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   498: checkcast java/lang/Boolean
    //   501: invokevirtual booleanValue : ()Z
    //   504: ifeq -> 593
    //   507: aload #25
    //   509: ldc_w 'nFoodCategory'
    //   512: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   515: ifeq -> 542
    //   518: aload #25
    //   520: ldc_w 'nFoodCategory'
    //   523: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   526: iconst_3
    //   527: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   530: invokevirtual equals : (Ljava/lang/Object;)Z
    //   533: ifeq -> 542
    //   536: aload #20
    //   538: astore_1
    //   539: goto -> 593
    //   542: new java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial <init> : ()V
    //   549: astore_1
    //   550: aload_1
    //   551: aload #20
    //   553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload_1
    //   558: ldc_w '<'
    //   561: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_1
    //   566: aload_0
    //   567: getfield context : Landroid/content/Context;
    //   570: ldc_w 2131628754
    //   573: invokevirtual getString : (I)Ljava/lang/String;
    //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload_1
    //   581: ldc_w '>'
    //   584: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_1
    //   589: invokevirtual toString : ()Ljava/lang/String;
    //   592: astore_1
    //   593: new java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial <init> : ()V
    //   600: astore #20
    //   602: aload #20
    //   604: aload #25
    //   606: ldc_w 'isProductPack'
    //   609: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   612: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload #20
    //   618: ldc ''
    //   620: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload #20
    //   626: invokevirtual toString : ()Ljava/lang/String;
    //   629: invokestatic se : (Ljava/lang/String;)Z
    //   632: istore #19
    //   634: aload_3
    //   635: getfield aTZ : Z
    //   638: ifne -> 652
    //   641: iload #19
    //   643: ifeq -> 652
    //   646: iconst_1
    //   647: istore #16
    //   649: goto -> 655
    //   652: iconst_0
    //   653: istore #16
    //   655: aload_1
    //   656: astore #20
    //   658: iload #16
    //   660: ifeq -> 799
    //   663: aload_0
    //   664: getfield context : Landroid/content/Context;
    //   667: ldc_w 2131626345
    //   670: invokevirtual getString : (I)Ljava/lang/String;
    //   673: astore #20
    //   675: aload_1
    //   676: ldc_w '|-'
    //   679: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   682: ifeq -> 776
    //   685: aload_1
    //   686: ldc_w '|-'
    //   689: ldc ''
    //   691: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   694: astore_1
    //   695: new java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial <init> : ()V
    //   702: astore #22
    //   704: aload #22
    //   706: ldc '['
    //   708: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload #22
    //   714: aload #20
    //   716: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload #22
    //   722: ldc ']'
    //   724: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload #22
    //   730: aload_1
    //   731: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload #22
    //   737: invokevirtual toString : ()Ljava/lang/String;
    //   740: astore_1
    //   741: new java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial <init> : ()V
    //   748: astore #20
    //   750: aload #20
    //   752: ldc_w '|-'
    //   755: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload #20
    //   761: aload_1
    //   762: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload #20
    //   768: invokevirtual toString : ()Ljava/lang/String;
    //   771: astore #20
    //   773: goto -> 799
    //   776: ldc_w '[%s]%s'
    //   779: iconst_2
    //   780: anewarray java/lang/Object
    //   783: dup
    //   784: iconst_0
    //   785: aload #20
    //   787: aastore
    //   788: dup
    //   789: iconst_1
    //   790: aload_1
    //   791: aastore
    //   792: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   795: astore_1
    //   796: goto -> 802
    //   799: aload #20
    //   801: astore_1
    //   802: aload #25
    //   804: ldc_w 'fAmount'
    //   807: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   810: iconst_1
    //   811: iconst_0
    //   812: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   815: astore #20
    //   817: aload #25
    //   819: ldc_w 'fPrice'
    //   822: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   825: invokevirtual toString : ()Ljava/lang/String;
    //   828: invokestatic parseDouble : (Ljava/lang/String;)D
    //   831: dstore #7
    //   833: aload #25
    //   835: ldc_w 'fOriginalPrice'
    //   838: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   841: ifeq -> 958
    //   844: aload #25
    //   846: ldc_w 'nProductQty'
    //   849: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   852: checkcast java/lang/String
    //   855: invokestatic parseDouble : (Ljava/lang/String;)D
    //   858: dstore #13
    //   860: aload #25
    //   862: ldc_w 'fOriginalPrice'
    //   865: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   868: checkcast java/lang/String
    //   871: invokestatic parseDouble : (Ljava/lang/String;)D
    //   874: dstore #7
    //   876: aload #25
    //   878: ldc_w 'fDBOriginalPrice'
    //   881: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   884: ifeq -> 903
    //   887: aload #25
    //   889: ldc_w 'fDBOriginalPrice'
    //   892: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   895: checkcast java/lang/String
    //   898: invokestatic parseDouble : (Ljava/lang/String;)D
    //   901: dstore #7
    //   903: aload #25
    //   905: ldc_w 'selectTastesPrice'
    //   908: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   911: ifeq -> 933
    //   914: aload #25
    //   916: ldc_w 'selectTastesPrice'
    //   919: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   922: checkcast java/lang/Double
    //   925: invokevirtual doubleValue : ()D
    //   928: dstore #9
    //   930: goto -> 936
    //   933: dconst_0
    //   934: dstore #9
    //   936: dload #7
    //   938: dload #9
    //   940: dadd
    //   941: dstore #7
    //   943: dload #13
    //   945: dload #7
    //   947: dmul
    //   948: invokestatic valueOf : (D)Ljava/lang/Double;
    //   951: iconst_1
    //   952: iconst_0
    //   953: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   956: astore #20
    //   958: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   961: invokevirtual BV : ()Z
    //   964: ifeq -> 1199
    //   967: aload #25
    //   969: ldc_w 'taxList'
    //   972: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   975: ifeq -> 1199
    //   978: aload #25
    //   980: ldc_w 'taxList'
    //   983: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   986: ifnull -> 1199
    //   989: aload #25
    //   991: ldc_w 'taxList'
    //   994: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   997: checkcast java/util/ArrayList
    //   1000: astore #22
    //   1002: new java/util/ArrayList
    //   1005: dup
    //   1006: invokespecial <init> : ()V
    //   1009: astore #26
    //   1011: aload #22
    //   1013: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1016: astore #22
    //   1018: aload #22
    //   1020: invokeinterface hasNext : ()Z
    //   1025: ifeq -> 1106
    //   1028: aload #22
    //   1030: invokeinterface next : ()Ljava/lang/Object;
    //   1035: checkcast com/laiqian/product/models/o
    //   1038: astore #27
    //   1040: aload #27
    //   1042: invokevirtual alc : ()I
    //   1045: iconst_1
    //   1046: if_icmpne -> 1092
    //   1049: new java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial <init> : ()V
    //   1056: astore #28
    //   1058: aload #28
    //   1060: aload #27
    //   1062: invokevirtual akZ : ()Ljava/lang/String;
    //   1065: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload #28
    //   1071: ldc_w '*'
    //   1074: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload #26
    //   1080: aload #28
    //   1082: invokevirtual toString : ()Ljava/lang/String;
    //   1085: invokevirtual add : (Ljava/lang/Object;)Z
    //   1088: pop
    //   1089: goto -> 1103
    //   1092: aload #26
    //   1094: aload #27
    //   1096: invokevirtual akZ : ()Ljava/lang/String;
    //   1099: invokevirtual add : (Ljava/lang/Object;)Z
    //   1102: pop
    //   1103: goto -> 1018
    //   1106: iload #15
    //   1108: istore #16
    //   1110: iload #4
    //   1112: istore #18
    //   1114: aload_1
    //   1115: astore #22
    //   1117: iload #16
    //   1119: istore #15
    //   1121: iload #18
    //   1123: istore #4
    //   1125: aload #26
    //   1127: invokevirtual size : ()I
    //   1130: ifle -> 1202
    //   1133: new java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial <init> : ()V
    //   1140: astore #22
    //   1142: aload #22
    //   1144: aload_1
    //   1145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: pop
    //   1149: aload #22
    //   1151: ldc_w '('
    //   1154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: pop
    //   1158: aload #22
    //   1160: ldc_w '/'
    //   1163: aload #26
    //   1165: invokestatic a : (Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/lang/String;
    //   1168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: pop
    //   1172: aload #22
    //   1174: ldc_w ')'
    //   1177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: aload #22
    //   1183: invokevirtual toString : ()Ljava/lang/String;
    //   1186: astore #22
    //   1188: iload #16
    //   1190: istore #15
    //   1192: iload #18
    //   1194: istore #4
    //   1196: goto -> 1202
    //   1199: aload_1
    //   1200: astore #22
    //   1202: aload #25
    //   1204: ldc_w 'nProductTransacType'
    //   1207: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   1210: ifeq -> 1240
    //   1213: aload #25
    //   1215: ldc_w 'nProductTransacType'
    //   1218: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1221: checkcast java/lang/Long
    //   1224: invokevirtual longValue : ()J
    //   1227: ldc2_w 100015
    //   1230: lcmp
    //   1231: ifne -> 1240
    //   1234: iconst_1
    //   1235: istore #16
    //   1237: goto -> 1243
    //   1240: iconst_0
    //   1241: istore #16
    //   1243: dload #11
    //   1245: dconst_0
    //   1246: dcmpg
    //   1247: ifge -> 1264
    //   1250: aload_0
    //   1251: getfield context : Landroid/content/Context;
    //   1254: ldc_w 2131628116
    //   1257: invokevirtual getString : (I)Ljava/lang/String;
    //   1260: astore_1
    //   1261: goto -> 1317
    //   1264: aload_3
    //   1265: getfield aWa : Z
    //   1268: ifne -> 1290
    //   1271: iload #16
    //   1273: ifeq -> 1290
    //   1276: aload_0
    //   1277: getfield context : Landroid/content/Context;
    //   1280: ldc_w 2131628745
    //   1283: invokevirtual getString : (I)Ljava/lang/String;
    //   1286: astore_1
    //   1287: goto -> 1317
    //   1290: new java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial <init> : ()V
    //   1297: astore_1
    //   1298: aload_1
    //   1299: aload #21
    //   1301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload_1
    //   1306: aload #20
    //   1308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: pop
    //   1312: aload_1
    //   1313: invokevirtual toString : ()Ljava/lang/String;
    //   1316: astore_1
    //   1317: aload #23
    //   1319: astore #20
    //   1321: aload #25
    //   1323: ldc_w 'sSpareField5'
    //   1326: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   1329: ifeq -> 1437
    //   1332: aload #23
    //   1334: astore #20
    //   1336: aload #25
    //   1338: ldc_w 'sSpareField5'
    //   1341: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1344: checkcast java/lang/String
    //   1347: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1350: ifne -> 1437
    //   1353: aload #25
    //   1355: ldc_w 'nFoodCategory'
    //   1358: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   1361: ifeq -> 1424
    //   1364: aload #25
    //   1366: ldc_w 'nFoodCategory'
    //   1369: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1372: iconst_3
    //   1373: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1376: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1379: ifeq -> 1424
    //   1382: new java/lang/StringBuilder
    //   1385: dup
    //   1386: invokespecial <init> : ()V
    //   1389: astore #20
    //   1391: aload #20
    //   1393: ldc_w '|-'
    //   1396: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: aload #20
    //   1402: aload #25
    //   1404: ldc_w 'sSpareField5'
    //   1407: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1410: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1413: pop
    //   1414: aload #20
    //   1416: invokevirtual toString : ()Ljava/lang/String;
    //   1419: astore #20
    //   1421: goto -> 1437
    //   1424: aload #25
    //   1426: ldc_w 'sSpareField5'
    //   1429: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1432: checkcast java/lang/String
    //   1435: astore #20
    //   1437: dload #11
    //   1439: dstore #9
    //   1441: iload #16
    //   1443: ifeq -> 1451
    //   1446: dload #11
    //   1448: dneg
    //   1449: dstore #9
    //   1451: dload #9
    //   1453: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1456: iconst_0
    //   1457: iconst_0
    //   1458: aload #24
    //   1460: invokevirtual afU : ()I
    //   1463: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   1466: astore #23
    //   1468: aload #6
    //   1470: invokevirtual aiN : ()Z
    //   1473: ifne -> 1534
    //   1476: aload #24
    //   1478: iconst_3
    //   1479: anewarray java/lang/String
    //   1482: dup
    //   1483: iconst_0
    //   1484: aload #22
    //   1486: aastore
    //   1487: dup
    //   1488: iconst_1
    //   1489: aload #23
    //   1491: aastore
    //   1492: dup
    //   1493: iconst_2
    //   1494: aload_1
    //   1495: aastore
    //   1496: invokevirtual x : ([Ljava/lang/String;)V
    //   1499: aload #20
    //   1501: ifnull -> 1531
    //   1504: aload #20
    //   1506: invokestatic mm : (Ljava/lang/String;)Z
    //   1509: ifeq -> 1524
    //   1512: aload #24
    //   1514: aload #20
    //   1516: iconst_3
    //   1517: iconst_0
    //   1518: invokevirtual f : (Ljava/lang/String;II)V
    //   1521: goto -> 1531
    //   1524: aload #24
    //   1526: aload #20
    //   1528: invokevirtual ll : (Ljava/lang/String;)V
    //   1531: goto -> 275
    //   1534: aload #24
    //   1536: iconst_4
    //   1537: anewarray java/lang/String
    //   1540: dup
    //   1541: iconst_0
    //   1542: aload #22
    //   1544: aastore
    //   1545: dup
    //   1546: iconst_1
    //   1547: aload #23
    //   1549: aastore
    //   1550: dup
    //   1551: iconst_2
    //   1552: dload #7
    //   1554: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1557: iconst_1
    //   1558: iconst_0
    //   1559: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   1562: aastore
    //   1563: dup
    //   1564: iconst_3
    //   1565: aload_1
    //   1566: aastore
    //   1567: invokevirtual x : ([Ljava/lang/String;)V
    //   1570: iload #15
    //   1572: istore #16
    //   1574: iload #4
    //   1576: istore #18
    //   1578: aload #20
    //   1580: ifnull -> 1626
    //   1583: aload #20
    //   1585: invokestatic mm : (Ljava/lang/String;)Z
    //   1588: ifeq -> 1611
    //   1591: aload #24
    //   1593: aload #20
    //   1595: iconst_3
    //   1596: iconst_0
    //   1597: invokevirtual f : (Ljava/lang/String;II)V
    //   1600: iload #15
    //   1602: istore #16
    //   1604: iload #4
    //   1606: istore #18
    //   1608: goto -> 1626
    //   1611: aload #24
    //   1613: aload #20
    //   1615: invokevirtual ll : (Ljava/lang/String;)V
    //   1618: iload #4
    //   1620: istore #18
    //   1622: iload #15
    //   1624: istore #16
    //   1626: iload #18
    //   1628: iconst_1
    //   1629: iadd
    //   1630: istore #4
    //   1632: iload #16
    //   1634: istore #15
    //   1636: goto -> 201
    //   1639: aload #24
    //   1641: iload #15
    //   1643: invokevirtual setSize : (I)V
    //   1646: iconst_1
    //   1647: ireturn }
  
  private boolean a(e parame, @NonNull ArrayList<HashMap<String, Object>> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2) { return a(parame, paramArrayList, paramBoolean1, paramInt, paramBoolean2, false); }
  
  private boolean a(e parame, @NonNull ArrayList<HashMap<String, Object>> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3) {
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
    int i = paramArrayList.size();
    for (paramInt = 0; paramInt < i * 2; paramInt++) {
      int k;
      if (paramInt >= i) {
        k = paramInt - i;
      } else {
        k = paramInt;
      } 
      HashMap hashMap = (HashMap)paramArrayList.get(k);
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
      a = parame.afT();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("");
      a.aJ("number", stringBuilder.toString());
      return true;
    } 
    if (paramString2 == null)
      stringBuilder.f(String.format("%d", new Object[] { paramInteger1 }), 3, 1); 
    stringBuilder.f(String.format("%s %s-%d", new Object[] { a, paramString2, paramInteger1 }), 3, 1);
    PrintContent.a a = stringBuilder.afT();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("");
    a.aJ("number", stringBuilder.toString());
    return true;
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
  
  private g br(int paramInt1, int paramInt2) {
    g g = new g();
    g.setWidth(paramInt1);
    if (paramInt1 == 80) {
      g.n(new int[] { 7, 2, 3 });
    } else {
      g.n(new int[] { 2, 1, 1 });
    } 
    g.ic(paramInt2);
    PrintContent.a a = g.afT();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    a.aJ("width", stringBuilder.toString());
    g.n(new int[] { 17, 15 });
    return g;
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
  
  private g gu(int paramInt) { return br(paramInt, RootApplication.aIQ); }
  
  private String iP(String paramString) {
    String str1 = "";
    bh bh = new bh(this.context);
    String str2 = bh.iC(paramString);
    bh.close();
    if (!TextUtils.isEmpty(str2))
      str1 = str2; 
    return !n.bL(this.context) ? (str1.equals(paramString) ? paramString : str1) : (str1.equals(paramString) ? iQ(paramString) : m(str1, 1));
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
  
  private boolean k(e parame, String paramString) { return b(parame, 2131628749, paramString); }
  
  private boolean l(e parame, String paramString) {
    parame.f(paramString, 0, 1);
    return true;
  }
  
  @NonNull
  private String m(String paramString, int paramInt) {
    String str = paramString;
    if (paramString.length() > paramInt) {
      null = new StringBuilder();
      for (byte b = 0; b < paramInt; b++)
        null.append("*"); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null.toString());
      stringBuilder.append(paramString.substring(paramInt, paramString.length()));
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public SimpleDateFormat Xn() {
    if (this.cJp == null)
      this.cJp = new SimpleDateFormat(this.context.getString(2131627405)); 
    return this.cJp;
  }
  
  public boolean a(Class paramClass, String paramString) {
    Pair pair = new Pair(paramClass, paramString);
    return this.cJo.containsKey(pair);
  }
  
  @Nullable
  public j.h.a b(Class paramClass, String paramString) { return p.cJH.contains(paramString) ? k.aer() : null; }
  
  public String fU(boolean paramBoolean) { return paramBoolean ? this.context.getString(2131626345) : this.context.getString(2131628779); }
  
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
  
  @NonNull
  public j.f yA() { return new aa(this); }
  
  @NonNull
  public j.k yB() { return new z(this); }
  
  public j.b yy() { return p.aev(); }
  
  public j.a yz() { return h.aY(this.context); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\printtype\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */