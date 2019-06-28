package com.laiqian.takeaway;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.aa;
import com.laiqian.entity.ao;
import com.laiqian.main.fg;
import com.laiqian.print.b.a;
import com.laiqian.print.b.b;
import com.laiqian.print.b.e;
import com.laiqian.print.b.g;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.printtype.f;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings.Size;
import com.laiqian.print.usage.tag.a.c;
import com.laiqian.print.util.e;
import com.laiqian.product.models.h;
import com.laiqian.product.models.o;
import com.laiqian.product.models.p;
import com.laiqian.takeaway.a.d;
import com.laiqian.util.am;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.util.z;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ba implements j.f {
  ba(az paramaz) {}
  
  private int a(PrintContent.a parama, ao paramao, int paramInt, c paramc) {
    String str4;
    if (paramInt == 0) {
      String str6 = paramao.IS();
      String str5 = paramao.getName();
      str4 = str5;
      if (str6 != null) {
        str4 = str5;
        if (!str6.trim().isEmpty())
          str4 = String.format("%s%s", new Object[] { str5, str6 }); 
      } 
    } else if (paramInt == 1) {
      str4 = paramao.getName();
    } else {
      str4 = null;
    } 
    int k = Integer.parseInt((new DecimalFormat("0")).format(paramao.akF()));
    double d3 = paramao.akF();
    double d2 = paramao.akI();
    paramInt = e.ml(str4);
    int i = str4.length();
    int j = e.jg(paramc.getWidth()) / 2 - 2;
    if (paramInt <= j) {
      parama.b(str4, true, false, 0, true, true);
    } else {
      paramInt = j;
      if (i < j)
        paramInt = i; 
      parama.b(str4.substring(0, paramInt), true, false, 0, false, false);
      if (paramInt < i)
        parama.b(str4.substring(paramInt, str4.length()), true, false, 0, false, false); 
    } 
    double d1 = d2;
    if (paramc.aiV() == paramc.cOm)
      d1 = d2 * d3; 
    null = new StringBuilder();
    null.append(RootApplication.zA());
    null.append(n.a(az.a(this.dtN), Double.valueOf(d1), true, true));
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
      return k; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str3);
    stringBuilder1.append(str2);
    parama.ln(stringBuilder1.toString());
    return k;
  }
  
  private List<PrintContent> a(TakeOrderEntity paramTakeOrderEntity, c paramc, j.c paramc1, boolean paramBoolean1, boolean paramBoolean2) {
    String str;
    List list = paramc1.aep();
    Iterator iterator = new ArrayList();
    iterator.addAll(paramTakeOrderEntity.bbT);
    if (paramc.getOrder() == 2)
      b(iterator, list); 
    ArrayList arrayList = new ArrayList();
    if (paramBoolean1) {
      if (paramTakeOrderEntity.aWa) {
        str = "-";
      } else {
        str = "";
      } 
      Iterator iterator1 = iterator.iterator();
      byte b1 = 0;
      label126: while (iterator1.hasNext()) {
        aa aa = (aa)iterator1.next();
        if (list.contains(Long.valueOf(aa.AL())))
          continue; 
        byte b = b1 + true;
        b1 = b;
        if (aa instanceof ao) {
          ao ao = (ao)aa;
          b1 = b;
          if (ao.akM() == 2) {
            b1 = b;
            if (!by.isNull(ao.IR())) {
              Iterator iterator2 = ao.IU().akq().iterator();
              while (true) {
                b1 = b;
                if (iterator2.hasNext()) {
                  if (!list.contains(Long.valueOf(((h)iterator2.next()).aJx)))
                    b++; 
                  continue;
                } 
                continue label126;
              } 
            } 
          } 
        } 
      } 
      iterator1 = iterator.iterator();
      byte b2 = 1;
      label125: while (iterator1.hasNext()) {
        aa aa = (aa)iterator1.next();
        String str1 = d(aa);
        null = new StringBuilder();
        null.append(aa.akF());
        null.append("");
        String str2 = null.toString();
        null = new StringBuilder();
        null.append(aa.Gz());
        null.append("");
        String str4 = null.toString();
        str2 = n.b(az.a(this.dtN), str2, false);
        String str3 = aa.akC();
        if (list.contains(Long.valueOf(aa.AL())))
          continue; 
        a(paramTakeOrderEntity, paramc, b2, b1, arrayList, str1, str4, str2, str, str3);
        byte b = b2 + 1;
        b2 = b;
        if (aa.akM() == 2) {
          b2 = b;
          if (aa instanceof ao) {
            iterator = ((ao)aa).IU().akq().iterator();
            while (true) {
              b2 = b;
              if (iterator.hasNext()) {
                h h = (h)iterator.next();
                if (!list.contains(Long.valueOf(h.aJx))) {
                  a(paramTakeOrderEntity, paramc, b, b1, arrayList, h.name, h.akJ(), str2, str, str3);
                  b++;
                } 
                continue;
              } 
              continue label125;
            } 
          } 
        } 
      } 
    } else {
      g g = gu(paramc.getWidth());
      paramBoolean1 = paramTakeOrderEntity.Iu().equals("COD");
      if (paramBoolean2)
        g.lk(az.a(this.dtN).getString(2131628774)); 
      if ("weixin".equals(paramTakeOrderEntity.getType())) {
        String str1;
        if (paramBoolean1) {
          str1 = az.a(this.dtN).getString(2131628755);
        } else {
          str1 = az.a(this.dtN).getString(2131628788);
        } 
        g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628786), str1 }), 1, 1);
      } else if ("koubei".equals(paramTakeOrderEntity.getType())) {
        String str1;
        if (paramBoolean1) {
          str1 = az.a(this.dtN).getString(2131628765);
        } else {
          str1 = az.a(this.dtN).getString(2131628727);
        } 
        g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628770), str1 }), 1, 1);
      } else if ("weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
        String str1;
        if (paramBoolean1) {
          str1 = az.a(this.dtN).getString(2131628765);
        } else {
          str1 = az.a(this.dtN).getString(2131628788);
        } 
        g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628770), str1 }), 1, 1);
      } else if ("meituan".equals(paramTakeOrderEntity.getType())) {
        String str1;
        if (paramBoolean1) {
          str1 = az.a(this.dtN).getString(2131628755);
        } else {
          str1 = az.a(this.dtN).getString(2131628757);
        } 
        g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628747), str1 }), 1, 1);
      } else if ("phone_order".equals(paramTakeOrderEntity.getType())) {
        g.f(az.a(this.dtN).getString(2131628767), 1, 1);
      } else if ("eleme".equals(paramTakeOrderEntity.getType())) {
        String str1;
        if ("COD".equals(paramTakeOrderEntity.Iu())) {
          str1 = az.a(this.dtN).getString(2131628755);
        } else {
          str1 = az.a(this.dtN).getString(2131628757);
        } 
        g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131629967), str1 }), 1, 1);
      } 
      if (paramTakeOrderEntity.aWa)
        g.lk(az.a(this.dtN).getString(2131628775)); 
      if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
        g.lk(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628760), paramTakeOrderEntity.getAddress() }));
        PrintContent.a a = g.afT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramTakeOrderEntity.getAddress());
        stringBuilder.append("");
        a.aJ("number", stringBuilder.toString());
      } else if (paramTakeOrderEntity.getSerialNumber() != null) {
        if (("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWc == 1) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(az.a(this.dtN).getString(2131624447));
          stringBuilder1.append(" ");
          stringBuilder1.append(az.a(this.dtN).getString(2131628760));
          g.lk(String.format("%s %s", new Object[] { stringBuilder1.toString(), paramTakeOrderEntity.getSerialNumber() }));
        } else {
          g.lk(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628760), paramTakeOrderEntity.getSerialNumber() }));
        } 
        PrintContent.a a = g.afT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramTakeOrderEntity.getSerialNumber());
        stringBuilder.append("");
        a.aJ("number", stringBuilder.toString());
      } 
      g.l('-');
      a(g, z.bg(paramTakeOrderEntity.In(), "yyyy-MM-dd HH:mm:ss"), paramTakeOrderEntity);
      if (("weixin".equals(paramTakeOrderEntity.getType()) || "meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWe == 0)
        c(g, z.bg(paramTakeOrderEntity.Ir(), "yyyy-MM-dd HH:mm:ss")); 
      if (!TextUtils.isEmpty(paramTakeOrderEntity.getNote()))
        q(g, paramTakeOrderEntity.getNote()); 
      if (!TextUtils.isEmpty(paramTakeOrderEntity.Im())) {
        g.l('-');
        e(g, paramTakeOrderEntity.Im());
      } 
      if (paramTakeOrderEntity.aWe == 1) {
        q(g, az.a(this.dtN).getString(2131626275));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(az.a(this.dtN).getString(2131625140));
        stringBuilder.append(paramTakeOrderEntity.Ir());
        q(g, stringBuilder.toString());
      } 
      g.l('-');
      paramBoolean1 = a(g, list, "nProductQty", iterator, paramc, paramTakeOrderEntity);
      byte b;
      for (b = 0; b < paramc.air(); b++)
        g.ll(""); 
      g.afT().aJ("log_number", paramTakeOrderEntity.getNumber());
      g.afT().aJ("log_serial_number", paramTakeOrderEntity.getSerialNumber());
      g.afT().ih(str.getCopies());
      if (paramBoolean1)
        arrayList.add(g.afV()); 
    } 
    arrayList.add((new PrintContent.a()).agg().afV());
    return arrayList;
  }
  
  private List<PrintContent> a(TakeOrderEntity paramTakeOrderEntity, ReceiptPrintSettings paramReceiptPrintSettings, j.i parami, boolean paramBoolean) {
    g g = gu(paramReceiptPrintSettings.getWidth());
    g.ic(2);
    if (paramBoolean)
      g.lk(az.a(this.dtN).getString(2131628774)); 
    if ("weixin".equals(paramTakeOrderEntity.getType())) {
      String str;
      if ("COD".equals(paramTakeOrderEntity.Iu())) {
        str = az.a(this.dtN).getString(2131628755);
      } else {
        str = az.a(this.dtN).getString(2131628788);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628786), str }), 1, 1);
    } else if ("koubei".equals(paramTakeOrderEntity.getType())) {
      String str;
      if ("COD".equals(paramTakeOrderEntity.Iu())) {
        str = az.a(this.dtN).getString(2131628765);
      } else {
        str = az.a(this.dtN).getString(2131628727);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628770), str }), 1, 1);
    } else if ("weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
      String str;
      if ("COD".equals(paramTakeOrderEntity.Iu())) {
        str = az.a(this.dtN).getString(2131628765);
      } else {
        str = az.a(this.dtN).getString(2131628788);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628770), str }), 1, 1);
    } else if ("meituan".equals(paramTakeOrderEntity.getType())) {
      String str;
      if ("COD".equals(paramTakeOrderEntity.Iu())) {
        str = az.a(this.dtN).getString(2131628755);
      } else {
        str = az.a(this.dtN).getString(2131628757);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628747), str }), 1, 1);
    } else if ("eleme".equals(paramTakeOrderEntity.getType())) {
      String str;
      if ("COD".equals(paramTakeOrderEntity.Iu())) {
        str = az.a(this.dtN).getString(2131628755);
      } else {
        str = az.a(this.dtN).getString(2131628757);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131629967), str }), 1, 1);
    } else if ("phone_order".equals(paramTakeOrderEntity.getType())) {
      String str;
      if (paramTakeOrderEntity.IF() == 0L) {
        str = az.a(this.dtN).getString(2131628755);
      } else {
        str = az.a(this.dtN).getString(2131630031);
      } 
      if (!"COD".equals(paramTakeOrderEntity.Iu()))
        str = az.a(this.dtN).getString(2131628757); 
      g.f(String.format("%s-%s", new Object[] { "Phone Order", str }), 1, 1);
    } 
    if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
      b(g, paramTakeOrderEntity.getAddress());
    } else {
      if (("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWc == 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(az.a(this.dtN).getString(2131624447));
        stringBuilder.append(" ");
        stringBuilder.append(az.a(this.dtN).getString(2131628760));
        b(g, stringBuilder.toString(), paramTakeOrderEntity.getSerialNumber());
      } else {
        b(g, az.a(this.dtN).getString(2131628760), paramTakeOrderEntity.getSerialNumber());
      } 
      g.afT().aJ("number", paramTakeOrderEntity.getSerialNumber());
    } 
    a(g, paramReceiptPrintSettings.aiu(), paramReceiptPrintSettings.aiv());
    switch (paramReceiptPrintSettings.ait()) {
      default:
        j = 3;
        break;
      case 1:
        j = 0;
        break;
    } 
    b(g, paramReceiptPrintSettings.getTitle(), j);
    if (paramTakeOrderEntity.Lz() != null && paramTakeOrderEntity.Lz().size() > 0)
      g.lk("Tax Invoice"); 
    if (!TextUtils.isEmpty(paramTakeOrderEntity.II()))
      b(g, 2131628731, paramTakeOrderEntity.II()); 
    b(g, z.bg(paramTakeOrderEntity.In(), "yyyy-MM-dd HH:mm:ss"));
    if (("weixin".equals(paramTakeOrderEntity.getType()) || "meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWe == 0)
      c(g, z.bg(paramTakeOrderEntity.Ir(), "yyyy-MM-dd HH:mm:ss")); 
    if (!TextUtils.isEmpty(paramTakeOrderEntity.IG())) {
      o(g, paramTakeOrderEntity.IG());
      p(g, paramTakeOrderEntity.IH());
    } 
    if ("phone_order".equals(paramTakeOrderEntity.getType()))
      n(g, RootApplication.getLaiqianPreferenceManager().Ea()); 
    if (("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.number != null)
      m(g, paramTakeOrderEntity.getNumber()); 
    if (!TextUtils.isEmpty(paramTakeOrderEntity.getNote()))
      g.f(String.format("%s:%s", new Object[] { az.a(this.dtN).getString(2131628756), paramTakeOrderEntity.getNote() }), 3, 0); 
    if (!TextUtils.isEmpty(paramTakeOrderEntity.Im())) {
      g.l('-');
      if (!TextUtils.isEmpty(paramTakeOrderEntity.Im()))
        e(g, paramTakeOrderEntity.Im()); 
      if (paramTakeOrderEntity.aWe == 1) {
        g.f(az.a(this.dtN).getString(2131626275), 3, 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(az.a(this.dtN).getString(2131625140));
        stringBuilder.append(paramTakeOrderEntity.Ir());
        g.f(stringBuilder.toString(), 3, 0);
      } 
      if ("weixin".equals(paramTakeOrderEntity.getType()) || "meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType()) || "phone_order".equals(paramTakeOrderEntity.getType())) {
        if ("phone_order".equals(paramTakeOrderEntity.getType())) {
          c(g, paramTakeOrderEntity.aVX, paramTakeOrderEntity.aVY);
        } else if (!"weixin".equals(paramTakeOrderEntity.getType()) && paramTakeOrderEntity.aWe == 0) {
          g.f(paramTakeOrderEntity.getName(), 1, 0);
        } 
        if (!by.isNull(paramTakeOrderEntity.getAddress()))
          if ("phone_order".equals(paramTakeOrderEntity.getType())) {
            String[] arrayOfString = paramTakeOrderEntity.getAddress().split("'");
            if (arrayOfString.length == 3) {
              g(g, arrayOfString[0]);
              h(g, arrayOfString[1]);
              i(g, arrayOfString[2]);
            } 
          } else if (paramTakeOrderEntity.aWe == 0) {
            h(g, paramTakeOrderEntity.getAddress());
          }  
      } 
    } 
    g.l('-');
    a(g, paramTakeOrderEntity.bbT, iH(paramReceiptPrintSettings.ais()), false, paramReceiptPrintSettings.aiN(), paramTakeOrderEntity.Is().equals("refunding"));
    null = new ArrayList();
    Iterator iterator = paramTakeOrderEntity.bbT.iterator();
    while (iterator.hasNext())
      null.add(((aa)iterator.next()).name); 
    g.afT().aJ("name", by.a("/", null));
    int j = g.getSize();
    g.setSize(iH(paramReceiptPrintSettings.ais()));
    try {
      String str = paramTakeOrderEntity.Ix();
      if (!by.isNull(str)) {
        String[] arrayOfString = str.split(",");
        if (arrayOfString != null && arrayOfString.length > 1)
          a(g, new d(by.parseDouble(arrayOfString[0]), by.parseDouble(arrayOfString[1]))); 
      } 
    } catch (Exception null) {
      a.e(null);
    } 
    if (paramTakeOrderEntity.Iw() > 0.0D)
      c(g, Double.valueOf(paramTakeOrderEntity.Iw())); 
    g.setSize(j);
    b = new b(g);
    b.afW();
    if ("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType()) || "weixin".equals(paramTakeOrderEntity.getType()) || "phone_order".equals(paramTakeOrderEntity.getType())) {
      g.l('-');
      if (paramTakeOrderEntity.IB() > 0.0D) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(az.a(this.dtN).getString(2131630539));
        stringBuilder.append("]");
        a(b, stringBuilder.toString(), Double.valueOf(paramTakeOrderEntity.IB()));
      } 
      if (paramTakeOrderEntity.IA() > 0.0D) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(az.a(this.dtN).getString(2131630540));
        stringBuilder.append("]");
        a(b, stringBuilder.toString(), Double.valueOf(paramTakeOrderEntity.IA()));
      } 
    } 
    if (!"phone_order".equals(paramTakeOrderEntity.getType()) && !"weixin_eat_in".equals(paramTakeOrderEntity.getType()) && !"weixin".equals(paramTakeOrderEntity.getType())) {
      ArrayList arrayList1 = am.oG(paramTakeOrderEntity.Iy());
      ArrayList arrayList2 = am.oI(paramTakeOrderEntity.Iz());
      try {
        if (arrayList1.size() == arrayList2.size() && arrayList1.size() > 0)
          for (j = 0; j < arrayList1.size(); j++) {
            String str = (String)arrayList2.get(j);
            double d = by.parseDouble((String)arrayList1.get(j));
            if (!n.bc(d)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("[");
              stringBuilder.append(str);
              stringBuilder.append("]");
              a(b, stringBuilder.toString(), Double.valueOf(-d));
            } 
          }  
      } catch (Exception b) {
        a.e(b);
      } 
    } 
    g.l('-');
    if (!n.bc(paramTakeOrderEntity.IP())) {
      double d;
      if (paramTakeOrderEntity.aWa) {
        d = -(paramTakeOrderEntity.Iv() - paramTakeOrderEntity.IP() - by.parseDouble(paramTakeOrderEntity.IJ()));
      } else {
        d = paramTakeOrderEntity.Iv() - paramTakeOrderEntity.IP() - by.parseDouble(paramTakeOrderEntity.IJ());
      } 
      a(g, "Sales amount", Double.valueOf(d));
      if (paramTakeOrderEntity.aWa) {
        d = -paramTakeOrderEntity.IP();
      } else {
        d = paramTakeOrderEntity.IP();
      } 
      a(g, "Total tax", Double.valueOf(d));
    } 
    if (!n.bc(by.parseDouble(paramTakeOrderEntity.IJ())))
      a(g, "Rounding", Double.valueOf(by.parseDouble(paramTakeOrderEntity.IJ()))); 
    if ("phone_order".equals(paramTakeOrderEntity.getType())) {
      a(g, "Total", Double.valueOf(paramTakeOrderEntity.Iv()));
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("print firstPayType is:");
      stringBuilder.append(paramTakeOrderEntity.aVS);
      stringBuilder.append("，firstPayValue is:");
      stringBuilder.append(paramTakeOrderEntity.aVT);
      printStream.println(stringBuilder.toString());
      printStream = System.out;
      stringBuilder = new StringBuilder();
      stringBuilder.append("print secondPayType is:");
      stringBuilder.append(paramTakeOrderEntity.aVU);
      stringBuilder.append(",secondPayValue is:");
      stringBuilder.append(paramTakeOrderEntity.aVV);
      printStream.println(stringBuilder.toString());
      a(paramTakeOrderEntity, g);
      c(paramTakeOrderEntity, g);
    } else {
      a(g, Double.valueOf(paramTakeOrderEntity.Iv()));
      if (paramTakeOrderEntity.getVipEntity() != null && (paramTakeOrderEntity.getVipEntity()).aSW > 0L)
        b(paramTakeOrderEntity, g); 
    } 
    if (paramTakeOrderEntity.Lz() != null && paramTakeOrderEntity.Lz().size() != 0) {
      g.l('-');
      g.n(new int[] { 12, 10, 10 });
      g.x(new String[] { "GST", "Amount", "Tax" });
      g.l('-');
      Iterator iterator1 = paramTakeOrderEntity.Lz().entrySet().iterator();
      while (iterator1.hasNext()) {
        p p = (p)((Map.Entry)iterator1.next()).getValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.IT());
        stringBuilder.append("=");
        stringBuilder.append(p.alg());
        stringBuilder.append("%");
        g.x(new String[] { stringBuilder.toString(), n.a(Double.valueOf(p.ali()), true, false), n.a(Double.valueOf(p.alh()), true, false) });
      } 
    } 
    if (paramTakeOrderEntity.getVipEntity() != null && (paramTakeOrderEntity.getVipEntity()).aSW > 0L) {
      g.l('-');
      if (!TextUtils.isEmpty((paramTakeOrderEntity.getVipEntity()).name)) {
        if (!a.zR().Ab()) {
          String str = by.bv((paramTakeOrderEntity.getVipEntity()).name, "*");
        } else {
          String str = (paramTakeOrderEntity.getVipEntity()).name;
        } 
      } else if (!TextUtils.isEmpty((paramTakeOrderEntity.getVipEntity()).aTp)) {
        String str = (paramTakeOrderEntity.getVipEntity()).aTp;
        if (a.zR().Ab()) {
          str = (paramTakeOrderEntity.getVipEntity()).aTp;
        } else {
          str = by.bu((paramTakeOrderEntity.getVipEntity()).aTp, "****");
        } 
      } else if (!TextUtils.isEmpty((paramTakeOrderEntity.getVipEntity()).aWn)) {
        String str = (paramTakeOrderEntity.getVipEntity()).aWn;
      } else {
        b = null;
      } 
      if (!TextUtils.isEmpty(b))
        k(g, b); 
      if ((paramTakeOrderEntity.getVipEntity()).aWo > 0.0D)
        b(g, Double.valueOf((paramTakeOrderEntity.getVipEntity()).aWo)); 
      if (a.AZ().Cd()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((paramTakeOrderEntity.getVipEntity()).aWp);
        stringBuilder.append("");
        b(g, 2131628751, stringBuilder.toString());
      } 
    } 
    j = paramReceiptPrintSettings.aiw();
    if ("weixin".equals(paramTakeOrderEntity.getType()) && j == 1)
      a(g, 1, null, az.a(this.dtN).getString(2131628777)); 
    if (!TextUtils.isEmpty(paramReceiptPrintSettings.aiq())) {
      g.l('-');
      l(g, paramReceiptPrintSettings.aiq());
    } 
    a(g, paramReceiptPrintSettings.air());
    g.afT().aJ("log_number", paramTakeOrderEntity.getNumber());
    g.afT().aJ("log_serial_number", paramTakeOrderEntity.getSerialNumber());
    g.afT().ih(parami.getCopies());
    return Collections.singletonList(g.afV());
  }
  
  private List<PrintContent> a(TakeOrderEntity paramTakeOrderEntity, c paramc, j.m paramm) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #10
    //   9: aload_2
    //   10: invokevirtual aja : ()I
    //   13: iconst_2
    //   14: if_icmpne -> 59
    //   17: ldc_w 'eleme'
    //   20: aload_1
    //   21: invokevirtual getType : ()Ljava/lang/String;
    //   24: invokevirtual equals : (Ljava/lang/Object;)Z
    //   27: ifne -> 56
    //   30: ldc_w 'meituan'
    //   33: aload_1
    //   34: invokevirtual getType : ()Ljava/lang/String;
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifne -> 56
    //   43: ldc_w 'weixin'
    //   46: aload_1
    //   47: invokevirtual getType : ()Ljava/lang/String;
    //   50: invokevirtual equals : (Ljava/lang/Object;)Z
    //   53: ifeq -> 59
    //   56: aload #10
    //   58: areturn
    //   59: aload_3
    //   60: invokevirtual aep : ()Ljava/util/List;
    //   63: astore_3
    //   64: aload_2
    //   65: invokevirtual getWidth : ()I
    //   68: pop
    //   69: aload_2
    //   70: invokevirtual getHeight : ()I
    //   73: pop
    //   74: aload_2
    //   75: invokevirtual aiW : ()Ljava/lang/String;
    //   78: pop
    //   79: new com/laiqian/util/av
    //   82: dup
    //   83: aload_0
    //   84: getfield dtN : Lcom/laiqian/takeaway/az;
    //   87: invokestatic a : (Lcom/laiqian/takeaway/az;)Landroid/content/Context;
    //   90: invokespecial <init> : (Landroid/content/Context;)V
    //   93: astore #11
    //   95: aload #11
    //   97: invokevirtual atY : ()Ljava/lang/String;
    //   100: pop
    //   101: aload #11
    //   103: invokevirtual aub : ()I
    //   106: pop
    //   107: aload #11
    //   109: invokevirtual close : ()V
    //   112: new java/util/Date
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: pop
    //   120: aload_1
    //   121: getfield bbT : Ljava/util/ArrayList;
    //   124: invokevirtual size : ()I
    //   127: istore #7
    //   129: iconst_0
    //   130: istore #6
    //   132: iconst_0
    //   133: istore #4
    //   135: iload #6
    //   137: iload #7
    //   139: if_icmpge -> 352
    //   142: aload_1
    //   143: getfield bbT : Ljava/util/ArrayList;
    //   146: iload #6
    //   148: invokevirtual get : (I)Ljava/lang/Object;
    //   151: checkcast com/laiqian/entity/aa
    //   154: astore #11
    //   156: new java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore #12
    //   165: aload #12
    //   167: aload #11
    //   169: getfield aJx : J
    //   172: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #12
    //   178: ldc ''
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: aload #12
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: invokeinterface contains : (Ljava/lang/Object;)Z
    //   195: istore #9
    //   197: iload #9
    //   199: ifeq -> 205
    //   202: goto -> 343
    //   205: new java/text/DecimalFormat
    //   208: dup
    //   209: ldc '0'
    //   211: invokespecial <init> : (Ljava/lang/String;)V
    //   214: aload #11
    //   216: invokevirtual akF : ()D
    //   219: invokevirtual format : (D)Ljava/lang/String;
    //   222: invokestatic parseInt : (Ljava/lang/String;)I
    //   225: istore #8
    //   227: iload #4
    //   229: iload #8
    //   231: iadd
    //   232: istore #5
    //   234: iload #5
    //   236: istore #4
    //   238: aload #11
    //   240: instanceof com/laiqian/entity/ao
    //   243: ifeq -> 343
    //   246: aload #11
    //   248: checkcast com/laiqian/entity/ao
    //   251: astore #11
    //   253: iload #5
    //   255: istore #4
    //   257: aload #11
    //   259: invokevirtual akM : ()I
    //   262: iconst_2
    //   263: if_icmpne -> 343
    //   266: iload #5
    //   268: istore #4
    //   270: aload #11
    //   272: invokevirtual IR : ()Ljava/lang/String;
    //   275: invokestatic isNull : (Ljava/lang/String;)Z
    //   278: ifne -> 343
    //   281: aload #11
    //   283: invokevirtual IU : ()Lcom/laiqian/product/models/a;
    //   286: invokevirtual akq : ()Ljava/util/ArrayList;
    //   289: invokevirtual iterator : ()Ljava/util/Iterator;
    //   292: astore #11
    //   294: iload #5
    //   296: istore #4
    //   298: aload #11
    //   300: invokeinterface hasNext : ()Z
    //   305: ifeq -> 343
    //   308: aload_3
    //   309: aload #11
    //   311: invokeinterface next : ()Ljava/lang/Object;
    //   316: checkcast com/laiqian/product/models/h
    //   319: getfield aJx : J
    //   322: invokestatic valueOf : (J)Ljava/lang/Long;
    //   325: invokeinterface contains : (Ljava/lang/Object;)Z
    //   330: ifne -> 294
    //   333: iload #5
    //   335: iload #8
    //   337: iadd
    //   338: istore #5
    //   340: goto -> 294
    //   343: iload #6
    //   345: iconst_1
    //   346: iadd
    //   347: istore #6
    //   349: goto -> 135
    //   352: iload #4
    //   354: sipush #1000
    //   357: if_icmple -> 362
    //   360: aconst_null
    //   361: areturn
    //   362: aload_2
    //   363: invokevirtual aiV : ()I
    //   366: getstatic com/laiqian/print/usage/tag/a/c.cOl : I
    //   369: if_icmpne -> 386
    //   372: aload_0
    //   373: aload_1
    //   374: aload_2
    //   375: aload #10
    //   377: aload_3
    //   378: iload #4
    //   380: invokespecial a : (Lcom/laiqian/entity/TakeOrderEntity;Lcom/laiqian/print/usage/tag/a/c;Ljava/util/ArrayList;Ljava/util/List;I)V
    //   383: goto -> 395
    //   386: aload_0
    //   387: aload_1
    //   388: aload_2
    //   389: aload #10
    //   391: aload_3
    //   392: invokespecial a : (Lcom/laiqian/entity/TakeOrderEntity;Lcom/laiqian/print/usage/tag/a/c;Ljava/util/List;Ljava/util/List;)V
    //   395: aload #10
    //   397: invokevirtual size : ()I
    //   400: ifle -> 483
    //   403: aload #10
    //   405: iconst_0
    //   406: invokevirtual get : (I)Ljava/lang/Object;
    //   409: checkcast com/laiqian/print/model/PrintContent
    //   412: astore_2
    //   413: aload_2
    //   414: ldc_w 'number'
    //   417: aload_1
    //   418: invokevirtual getSerialNumber : ()Ljava/lang/String;
    //   421: invokevirtual aI : (Ljava/lang/String;Ljava/lang/String;)V
    //   424: new java/util/ArrayList
    //   427: dup
    //   428: invokespecial <init> : ()V
    //   431: astore_3
    //   432: aload_1
    //   433: getfield bbT : Ljava/util/ArrayList;
    //   436: invokevirtual iterator : ()Ljava/util/Iterator;
    //   439: astore_1
    //   440: aload_1
    //   441: invokeinterface hasNext : ()Z
    //   446: ifeq -> 469
    //   449: aload_3
    //   450: aload_1
    //   451: invokeinterface next : ()Ljava/lang/Object;
    //   456: checkcast com/laiqian/entity/aa
    //   459: getfield name : Ljava/lang/String;
    //   462: invokevirtual add : (Ljava/lang/Object;)Z
    //   465: pop
    //   466: goto -> 440
    //   469: aload_2
    //   470: ldc_w 'name'
    //   473: ldc_w '/'
    //   476: aload_3
    //   477: invokestatic a : (Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/lang/String;
    //   480: invokevirtual aI : (Ljava/lang/String;Ljava/lang/String;)V
    //   483: aload #10
    //   485: areturn
    //   486: astore #12
    //   488: goto -> 205
    // Exception table:
    //   from	to	target	type
    //   156	197	486	java/lang/ClassCastException }
  
  private void a(TakeOrderEntity paramTakeOrderEntity, g paramg) {
    int i = paramg.getSize();
    if (paramTakeOrderEntity.aVS == 10001L) {
      System.out.println("print firstPayType is PAYTYPE_CASH");
      paramg.setSize(3);
    } 
    if (paramTakeOrderEntity.aVS != az.b(this.dtN))
      a(paramg, fg.ao(paramTakeOrderEntity.aVS), paramTakeOrderEntity.aVT); 
    paramg.setSize(i);
  }
  
  private void a(TakeOrderEntity paramTakeOrderEntity, c paramc, int paramInt1, int paramInt2, ArrayList<PrintContent> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    g g = gu(paramc.getWidth());
    boolean bool = paramTakeOrderEntity.Iu().equals("COD");
    String str = az.a(this.dtN).getString(2131629622);
    int i = 0;
    g.x(new String[] { String.format(str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
    g.x(new String[] { "" });
    if ("weixin".equals(paramTakeOrderEntity.getType())) {
      if (bool) {
        str = az.a(this.dtN).getString(2131628755);
      } else {
        str = az.a(this.dtN).getString(2131628788);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628786), str }), 1, 1);
    } else if ("koubei".equals(paramTakeOrderEntity.getType())) {
      if (bool) {
        str = az.a(this.dtN).getString(2131628765);
      } else {
        str = az.a(this.dtN).getString(2131628727);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628770), str }), 1, 1);
    } else if ("weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
      if (bool) {
        str = az.a(this.dtN).getString(2131628765);
      } else {
        str = az.a(this.dtN).getString(2131628788);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628770), str }), 1, 1);
    } else if ("meituan".equals(paramTakeOrderEntity.getType())) {
      if (bool) {
        str = az.a(this.dtN).getString(2131628755);
      } else {
        str = az.a(this.dtN).getString(2131628757);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131628747), str }), 1, 1);
    } else if ("phone_order".equals(paramTakeOrderEntity.getType())) {
      g.f(az.a(this.dtN).getString(2131628767), 1, 1);
    } else if ("eleme".equals(paramTakeOrderEntity.getType())) {
      if ("COD".equals(paramTakeOrderEntity.Iu())) {
        str = az.a(this.dtN).getString(2131628755);
      } else {
        str = az.a(this.dtN).getString(2131628757);
      } 
      g.f(String.format("%s-%s", new Object[] { az.a(this.dtN).getString(2131629967), str }), 1, 1);
    } 
    if (paramTakeOrderEntity.aWa)
      g.lk(az.a(this.dtN).getString(2131628775)); 
    if (paramInt2 == 1) {
      if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
        g.lk(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628760), paramTakeOrderEntity.getAddress() }));
        PrintContent.a a = g.afT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramTakeOrderEntity.getAddress());
        stringBuilder.append("");
        a.aJ("number", stringBuilder.toString());
      } else if (paramTakeOrderEntity.getSerialNumber() != null) {
        if (("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWc == 1) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(az.a(this.dtN).getString(2131624447));
          stringBuilder1.append(" ");
          stringBuilder1.append(az.a(this.dtN).getString(2131628760));
          g.lk(String.format("%s %s", new Object[] { stringBuilder1.toString(), paramTakeOrderEntity.getSerialNumber() }));
        } else {
          g.lk(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628760), paramTakeOrderEntity.getSerialNumber() }));
        } 
        PrintContent.a a = g.afT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramTakeOrderEntity.getSerialNumber());
        stringBuilder.append("");
        a.aJ("number", stringBuilder.toString());
      } 
    } else {
      if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
        str = paramTakeOrderEntity.getAddress();
      } else {
        str = paramTakeOrderEntity.getSerialNumber();
      } 
      a(g, str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTakeOrderEntity);
    } 
    g.l('-');
    a(g, z.bg(paramTakeOrderEntity.In(), "yyyy-MM-dd HH:mm:ss"), paramTakeOrderEntity);
    if (("weixin".equals(paramTakeOrderEntity.getType()) || "meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWe == 0)
      c(g, z.bg(paramTakeOrderEntity.Ir(), "yyyy-MM-dd HH:mm:ss")); 
    if (!TextUtils.isEmpty(paramTakeOrderEntity.getNote()))
      q(g, paramTakeOrderEntity.getNote()); 
    if (!TextUtils.isEmpty(paramTakeOrderEntity.Im())) {
      g.l('-');
      e(g, paramTakeOrderEntity.Im());
    } 
    g.l('-');
    g.setSize(ip(paramc.aiG()));
    if (!TextUtils.isEmpty(paramString5))
      g.ll(paramString5); 
    if (paramc.aiD()) {
      g.n(new int[] { 1, 1, 1 });
      g.x(new String[] { paramString1, paramString2, paramString3 });
      paramInt1 = i;
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString4);
      stringBuilder.append(paramString3);
      g.x(new String[] { paramString1, stringBuilder.toString() });
      g.afT().aJ("name", paramString1);
      paramInt1 = i;
    } 
    while (paramInt1 < paramc.air()) {
      g.ll("");
      paramInt1++;
    } 
    g.afT().aJ("log_number", paramTakeOrderEntity.getNumber());
    g.afT().aJ("log_serial_number", paramTakeOrderEntity.getSerialNumber());
    paramArrayList.add(g.afV());
  }
  
  private void a(TakeOrderEntity paramTakeOrderEntity, c paramc, ArrayList<PrintContent> paramArrayList, List<Long> paramList, int paramInt) {
    ArrayList<PrintContent> arrayList = paramArrayList;
    Date date = new Date();
    int k = paramc.getWidth();
    int m = paramc.getHeight();
    String str1 = paramc.aiW();
    null = new av(az.a(this.dtN));
    String str2 = null.atY();
    int i = null.aub();
    null.close();
    Iterator iterator = paramTakeOrderEntity.bbT.iterator();
    int j = 1;
    while (iterator.hasNext()) {
      String str4;
      ArrayList<PrintContent> arrayList1;
      aa aa = (aa)iterator.next();
      ao ao = (ao)aa;
      try {
        boolean bool = paramList.contains(Long.valueOf(ao.aJx));
        if (bool)
          continue; 
      } catch (ClassCastException classCastException) {
        a.e(classCastException);
      } 
      int n = (int)ao.akF();
      if (n <= 0)
        continue; 
      int i1 = 0;
      ArrayList<PrintContent> arrayList3 = arrayList;
      while (i1 < n) {
        String str7;
        PrintContent.a a = new PrintContent.a();
        g g = new g(a);
        g.n(new int[] { 19, 5 });
        g.setSize(3);
        g.setWidth(k);
        null = "";
        if (!by.isNull(paramTakeOrderEntity.getSerialNumber())) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(paramTakeOrderEntity.getSerialNumber());
          str7 = stringBuilder.toString();
        } else {
          str7 = null;
          if (str2 != null) {
            str7 = null;
            if (!str2.trim().isEmpty())
              str7 = str2; 
          } 
        } 
        if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
          null = paramTakeOrderEntity.getAddress();
        } else {
          null = str7;
        } 
        String str8 = "";
        if (paramInt != 1)
          str8 = String.format("%d-%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) }); 
        if (!null.isEmpty() || !str8.isEmpty()) {
          g.setSize(1);
          if ("weixin_eat_in".equals(paramTakeOrderEntity.It())) {
            str7 = az.a(this.dtN).getString(2131627171);
          } else if ("koubei".equals(paramTakeOrderEntity.It())) {
            str7 = az.a(this.dtN).getString(2131628770);
          } else if ("meituan".equals(paramTakeOrderEntity.It())) {
            str7 = az.a(this.dtN).getString(2131629986);
          } else if ("eleme".equals(paramTakeOrderEntity.It())) {
            str7 = az.a(this.dtN).getString(2131629967);
          } else if ("weixin".equals(paramTakeOrderEntity.It())) {
            str7 = az.a(this.dtN).getString(2131628786);
          } else {
            str7 = "";
          } 
          if (!TextUtils.isEmpty(null) && !TextUtils.isEmpty(str8)) {
            g.setSize(0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str7);
            stringBuilder.append(null);
            stringBuilder.append(" ");
            stringBuilder.append(aa.akC());
            g.x(new String[] { stringBuilder.toString(), str8 });
          } else {
            PrintContent.a a1;
            if (!TextUtils.isEmpty(null)) {
              a1 = g.afT();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(str7);
              stringBuilder.append(null);
              stringBuilder.append(" ");
              stringBuilder.append(aa.akC());
              a1.r(stringBuilder.toString(), 1);
            } else if (!TextUtils.isEmpty(a1)) {
              g.afT().h(a1, 1, 2);
            } 
          } 
          g.setSize(3);
          a.ln("--------------------");
        } 
        a(a, ao, i, paramc);
        a.ln(String.format("%s", new Object[] { (new SimpleDateFormat(az.a(this.dtN).getString(2131627405))).format(date) }));
        a.ln(str1);
        a.setWidth(k);
        a.setHeight(m);
        a.s(paramc.aiX(), true);
        paramArrayList.add(a.afV());
        j++;
        i1++;
        arrayList3 = paramArrayList;
      } 
      i1 = n;
      String str3 = str2;
      Iterator iterator2 = arrayList3;
      n = i;
      if (ao.akM() == 2 && !by.isNull(ao.IR())) {
        Iterator iterator3;
        ArrayList<PrintContent> arrayList4;
        String str;
        Iterator iterator4 = ao.IU().akq().iterator();
        i = j;
        j = n;
        while (iterator4.hasNext()) {
          String str7;
          Iterator iterator5;
          ArrayList<PrintContent> arrayList5;
          h h = (h)iterator4.next();
          if (paramList.contains(Long.valueOf(h.aJx)))
            continue; 
          int i2 = i;
          i = i1;
          i1 = 0;
          Iterator iterator6 = iterator;
          ArrayList<PrintContent> arrayList6 = iterator2;
          null = h;
          null = str1;
          null = iterator4;
          n = j;
          j = i2;
          while (i1 < i) {
            null = new PrintContent.a();
            g g = new g(null);
            g.n(new int[] { 19, 5 });
            g.setSize(3);
            g.setWidth(k);
            String str8 = "";
            if (paramInt != 1)
              str8 = String.format("%d-%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) }); 
            if (!TextUtils.isEmpty(str8)) {
              g.setSize(1);
              g.afT().h(str8, 1, 2);
            } 
            g.setSize(3);
            null.ln("--------------------");
            a(null, null.name, paramc, i, 0.0D);
            null.ln(String.format("%s", new Object[] { (new SimpleDateFormat(az.a(this.dtN).getString(2131627405))).format(date) }));
            null.ln(null);
            null.setWidth(k);
            null.setHeight(m);
            null.s(paramc.aiX(), true);
            paramArrayList.add(null.afV());
            j++;
            arrayList6 = paramArrayList;
            i1++;
          } 
          i1 = j;
          i2 = i;
          j = n;
          iterator4 = null;
          str7 = null;
          arrayList5 = arrayList6;
          iterator5 = iterator6;
          i = i1;
          i1 = i2;
        } 
        n = j;
        arrayList3 = arrayList5;
        iterator4 = iterator5;
        iterator2 = str7;
        str4 = arrayList3;
        j = i;
        arrayList1 = iterator4;
        i = n;
      } else {
        i = n;
        Iterator iterator3 = arrayList1;
        arrayList1 = str4;
        str4 = iterator2;
        iterator2 = iterator3;
      } 
      String str6 = str4;
      ArrayList<PrintContent> arrayList2 = arrayList1;
      Iterator iterator1 = iterator2;
      String str5 = str3;
      str3 = str6;
    } 
  }
  
  private void a(TakeOrderEntity paramTakeOrderEntity, c paramc, List<PrintContent> paramList1, List<Long> paramList2) {
    Date date = new Date();
    int m = paramc.getWidth();
    int n = paramc.getHeight();
    String str1 = paramc.aiW();
    av = new av(az.a(this.dtN));
    String str2 = av.atY();
    int i = av.aub();
    int j = paramTakeOrderEntity.bbT.size();
    Iterator iterator = paramTakeOrderEntity.bbT.iterator();
    int k = 1;
    while (iterator.hasNext()) {
      null = (aa)iterator.next();
      ao ao = (ao)null;
      try {
        boolean bool = paramList2.contains(Long.valueOf(ao.aJx));
        if (bool)
          continue; 
      } catch (ClassCastException av) {
        a.e(av);
      } 
      int i1 = (int)ao.akF();
      if (i1 <= 0)
        continue; 
      PrintContent.a a = new PrintContent.a();
      g g = new g(a);
      g.n(new int[] { 19, 5 });
      g.setSize(3);
      g.setWidth(m);
      if (!by.isNull(paramTakeOrderEntity.getSerialNumber())) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(paramTakeOrderEntity.getSerialNumber());
        str3 = stringBuilder.toString();
      } else if (str2 != null && !str2.trim().isEmpty()) {
        str3 = str2;
      } else {
        str3 = "";
      } 
      if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType()))
        str3 = paramTakeOrderEntity.getAddress(); 
      String str4 = "";
      if (j != 1)
        str4 = String.format("%d-%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }); 
      if (!str3.isEmpty() || !str4.isEmpty()) {
        g.setSize(1);
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(az.a(this.dtN).getString(2131628779));
          stringBuilder.append(str3);
          stringBuilder.append(" ");
          stringBuilder.append(null.akC());
          g.x(new String[] { stringBuilder.toString(), str4 });
        } else {
          PrintContent.a a1;
          if (!TextUtils.isEmpty(str3)) {
            a1 = g.afT();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(az.a(this.dtN).getString(2131628779));
            stringBuilder.append(str3);
            stringBuilder.append(" ");
            stringBuilder.append(null.akC());
            a1.r(stringBuilder.toString(), 1);
          } else if (!TextUtils.isEmpty(a1)) {
            g.afT().h(a1, 1, 2);
          } 
        } 
        g.setSize(3);
        a.ln("--------------------");
      } 
      c c1 = paramc;
      a(a, ao, i, c1);
      a.ln(String.format("%s", new Object[] { (new SimpleDateFormat(az.a(this.dtN).getString(2131627405))).format(date) }));
      a.ln(str1);
      a.setHeight(n);
      a.setWidth(m);
      a.s(paramc.aiX(), true);
      paramList1.add(a.afV());
      int i2 = k + 1;
      if (ao.akM() == 2 && !by.isNull(ao.IR())) {
        Iterator iterator1 = ao.IU().akq().iterator();
        k = j;
        for (j = i2; iterator1.hasNext(); j++) {
          h h = (h)iterator1.next();
          if (paramList2.contains(Long.valueOf(h.aJx)))
            continue; 
          a = new PrintContent.a();
          g = new g(a);
          g.n(new int[] { 19, 5 });
          g.setSize(3);
          g.setWidth(m);
          if (k != 1) {
            str4 = String.format("%d-%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
          } else {
            str4 = "";
          } 
          if (!TextUtils.isEmpty(str4)) {
            g.setSize(1);
            g.afT().h(str4, 1, 2);
          } 
          g.setSize(3);
          a.ln("--------------------");
          a(a, h.name, c1, i1, 0.0D);
          a.ln(String.format("%s", new Object[] { (new SimpleDateFormat(az.a(this.dtN).getString(2131627405))).format(date) }));
          a.ln(str1);
          a.setWidth(m);
          a.setHeight(n);
          a.s(paramc.aiX(), true);
          paramList1.add(a.afV());
        } 
        i1 = i;
        String str = str2;
        i = j;
        str2 = str1;
        str1 = str;
        j = i1;
      } else {
        str3 = str1;
        str1 = str2;
        k = j;
        j = i;
        str2 = str3;
        i = i2;
      } 
      i1 = k;
      String str3 = str1;
      k = i;
      i = j;
      j = i1;
      str1 = str2;
      str2 = str3;
    } 
  }
  
  private void a(e parame, ao paramao, double paramDouble, String paramString1, String paramString2, boolean paramBoolean, int paramInt) {
    try {
      if (paramao.akM() == 2 && !by.isNull(paramao.IR())) {
        String[] arrayOfString = paramao.IR().split(",");
        paramInt = 0;
        while (true) {
          if (paramInt < arrayOfString.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("|-");
            stringBuilder.append(arrayOfString[paramInt]);
            String str = stringBuilder.toString();
            if (!paramBoolean) {
              String str1;
              if (paramDouble > 0.0D) {
                str1 = "0.00";
              } else {
                str1 = paramString2;
              } 
              parame.x(new String[] { str, paramString1, str1 });
            } else {
              String str1;
              String str2 = n.a("0.00", true, false);
              if (paramDouble > 0.0D) {
                str1 = "0.00";
              } else {
                str1 = paramString2;
              } 
              parame.x(new String[] { str, paramString1, str2, str1 });
            } 
            paramInt++;
            continue;
          } 
          return;
        } 
      } 
    } catch (Exception parame) {
      a.e(parame);
    } 
  }
  
  private void a(PrintContent.a parama, String paramString, c paramc, double paramDouble1, double paramDouble2) {
    int i = e.ml(paramString);
    int j = paramString.length();
    if (i <= 12) {
      parama.b(paramString, true, false, 0, true, true);
    } else {
      if (j < 10) {
        i = j;
      } else {
        i = 10;
      } 
      parama.b(paramString.substring(0, i), true, false, 0, false, false);
      if (i < j)
        parama.b(paramString.substring(10, paramString.length()), true, false, 0, false, false); 
    } 
    if (paramc.aiV() == paramc.cOm)
      paramDouble2 *= paramDouble1; 
    null = new StringBuilder();
    null.append(RootApplication.zA());
    null.append(n.a(az.a(this.dtN), Double.valueOf(paramDouble2), true, true));
    String str1 = null.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("x");
    stringBuilder2.append(paramDouble1);
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
  
  private boolean a(e parame, int paramInt) {
    for (byte b = 0; b < paramInt; b++)
      parame.afT().ln(""); 
    return true;
  }
  
  private boolean a(e parame, int paramInt, Double paramDouble) {
    if (paramDouble == null)
      return false; 
    parame.x(new String[] { az.a(this.dtN).getString(paramInt), n.a(paramDouble, true, false) });
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
    //   22: if_icmpne -> 87
    //   25: aload_0
    //   26: getfield dtN : Lcom/laiqian/takeaway/az;
    //   29: invokestatic a : (Lcom/laiqian/takeaway/az;)Landroid/content/Context;
    //   32: invokestatic aR : (Landroid/content/Context;)Ljava/lang/String;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull -> 87
    //   40: new java/io/File
    //   43: dup
    //   44: aload_3
    //   45: invokespecial <init> : (Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual exists : ()Z
    //   53: ifeq -> 87
    //   56: new java/io/FileInputStream
    //   59: dup
    //   60: aload_3
    //   61: invokespecial <init> : (Ljava/io/File;)V
    //   64: astore #5
    //   66: aload #5
    //   68: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   71: astore_3
    //   72: aload #5
    //   74: invokevirtual close : ()V
    //   77: goto -> 89
    //   80: astore_1
    //   81: aload_1
    //   82: invokestatic e : (Ljava/lang/Throwable;)V
    //   85: iconst_0
    //   86: ireturn
    //   87: aconst_null
    //   88: astore_3
    //   89: aload_3
    //   90: ifnonnull -> 95
    //   93: iconst_0
    //   94: ireturn
    //   95: aload_1
    //   96: invokeinterface afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   101: aload_3
    //   102: iconst_1
    //   103: invokevirtual a : (Landroid/graphics/Bitmap;I)Lcom/laiqian/print/model/PrintContent$a;
    //   106: pop
    //   107: aload #4
    //   109: ifnull -> 122
    //   112: aload_1
    //   113: aload #4
    //   115: iconst_0
    //   116: iconst_1
    //   117: invokeinterface f : (Ljava/lang/String;II)V
    //   122: iconst_1
    //   123: ireturn
    // Exception table:
    //   from	to	target	type
    //   56	77	80	java/io/IOException }
  
  private boolean a(e parame, d paramd) {
    if (paramd != null) {
      parame.x(new String[] { String.format(az.a(this.dtN).getString(2131630537), new Object[] { n.a(Double.valueOf(paramd.abM()), true, false, parame.afU()), n.a(Double.valueOf(paramd.FI()), true, false, parame.afU()) }), n.a(Double.valueOf(-paramd.FI()), true, false, parame.afU()) });
      return true;
    } 
    return false;
  }
  
  private boolean a(e parame, Double paramDouble) { return a(parame, paramDouble, false); }
  
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
        g.x(new String[] { az.a(this.dtN).getString(2131628730) });
      } else {
        g.x(new String[] { az.a(this.dtN).getString(2131628729) });
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
  
  private boolean a(e parame, String paramString, Integer paramInteger1, Integer paramInteger2, TakeOrderEntity paramTakeOrderEntity) {
    StringBuilder stringBuilder2;
    StringBuilder stringBuilder1;
    PrintContent.a a;
    if (paramInteger1 == null)
      return false; 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(az.a(this.dtN).getString(2131628779));
    stringBuilder3.append(" :");
    stringBuilder3.toString();
    if ("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType()))
      if (paramTakeOrderEntity.aWc == 1) {
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(az.a(this.dtN).getString(2131624447));
        stringBuilder3.append(" :");
        stringBuilder3.toString();
      } else {
        az.a(this.dtN).getString(2131628760);
      }  
    if (paramInteger2 != null) {
      if (paramString == null) {
        parame.f(String.format("%d/%d", new Object[] { paramInteger1, paramInteger2 }), 3, 1);
        return true;
      } 
      if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
        parame.f(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628779), paramString }), 3, 1);
        a = parame.afT();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramString);
        stringBuilder2.append("");
        a.aJ("number", stringBuilder2.toString());
        return true;
      } 
      if (paramTakeOrderEntity.getSerialNumber() != null) {
        if (("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWc == 1) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(az.a(this.dtN).getString(2131624447));
          stringBuilder2.append(" ");
          stringBuilder2.append(az.a(this.dtN).getString(2131628760));
          a.f(String.format("%s  %s", new Object[] { stringBuilder2.toString(), paramString }), 3, 1);
        } else {
          a.f(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628760), paramString }), 3, 1);
        } 
        a = a.afT();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramTakeOrderEntity.getSerialNumber());
        stringBuilder1.append("");
        a.aJ("number", stringBuilder1.toString());
        return true;
      } 
    } else {
      if (stringBuilder1 == null)
        a.f(String.format("%d", new Object[] { stringBuilder2 }), 3, 1); 
      if ("koubei".equals(paramTakeOrderEntity.getType()) || "weixin_eat_in".equals(paramTakeOrderEntity.getType())) {
        a.f(String.format("%s : %s-%d", new Object[] { az.a(this.dtN).getString(2131628779), stringBuilder1 }), 3, 1);
      } else if (paramTakeOrderEntity.getSerialNumber() != null) {
        if (("meituan".equals(paramTakeOrderEntity.getType()) || "eleme".equals(paramTakeOrderEntity.getType())) && paramTakeOrderEntity.aWc == 1) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(az.a(this.dtN).getString(2131628779));
          stringBuilder2.append(" ");
          stringBuilder2.append(az.a(this.dtN).getString(2131628760));
          a.f(String.format("%s %s", new Object[] { stringBuilder2.toString(), stringBuilder1 }), 3, 1);
        } else {
          a.f(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628760), stringBuilder1 }), 3, 1);
        } 
      } 
      a = a.afT();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(stringBuilder1);
      stringBuilder2.append("");
      a.aJ("number", stringBuilder2.toString());
    } 
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
  
  private boolean a(e parame, Date paramDate, TakeOrderEntity paramTakeOrderEntity) {
    g g = new g(parame.afT());
    g.setWidth(parame.getWidth());
    g.ic(parame.afU());
    g.n(new int[] { 10, 22 });
    g.x(new String[] { az.a(this.dtN).getString(2131628762), Xn().format(paramDate) });
    return true;
  }
  
  private boolean a(e parame, @NonNull List<aa> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    b b = new b((a)parame);
    b.afW();
    String str2 = "";
    if (paramBoolean3)
      str2 = "-"; 
    if (!paramBoolean2) {
      b.x(new String[] { az.a(this.dtN).getString(2131628769), az.a(this.dtN).getString(2131628771), az.a(this.dtN).getString(2131628783) });
    } else {
      b.x(new String[] { az.a(this.dtN).getString(2131628769), az.a(this.dtN).getString(2131628771), az.a(this.dtN).getString(2131629243), az.a(this.dtN).getString(2131628783) });
    } 
    b.l('-');
    int j = b.getSize();
    b.setSize(paramInt);
    int k = paramList.size();
    String str1 = "";
    int i;
    for (i = 0; i < k * 2; i = m) {
      int m;
      if (i >= k) {
        m = i - k;
      } else {
        m = i;
      } 
      ao ao = (ao)paramList.get(m);
      double d = n.g(Double.valueOf(ao.akF()));
      if ((i < k) ? (d < 0.0D) : (d > 0.0D)) {
        m = i;
        i = j;
      } else {
        String str3 = new StringBuilder();
        str3.append(i);
        str3.append("");
        Log.e("appendProducts", str3.toString());
        Log.e("appendProducts", str1);
        Log.e("appendProducts", ao.akC());
        if (!TextUtils.isEmpty(ao.akC()) && !str1.equals(ao.akC())) {
          if (i != 0)
            b.l('-'); 
          b.setSize(0);
          b.ll(ao.akC());
          b.setSize(paramInt);
          str1 = ao.akC();
        } 
        if (!by.isNull(ao.IS())) {
          String str = ao.IS();
        } else {
          str3 = null;
        } 
        String str4 = ao.getName();
        if (str3 != null && !str3.trim().isEmpty()) {
          String str = String.format("%s%s", new Object[] { str4, str3 });
        } else {
          str3 = str4;
        } 
        String str6 = n.a(Double.valueOf(Math.abs(d)), false, false, b.afU());
        String str5 = n.a(Double.valueOf(Math.abs(d) * ao.AO()), true, false);
        double d1 = ao.akI();
        if (a.AZ().BV() && ao.GP() != null && ao.GP().size() > 0) {
          ArrayList arrayList = new ArrayList();
          for (o o : ao.GP()) {
            if (o.alc() == 1) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(o.akZ());
              stringBuilder.append("*");
              arrayList.add(stringBuilder.toString());
              continue;
            } 
            arrayList.add(o.akZ());
          } 
          str4 = str3;
          if (arrayList.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append("(");
            stringBuilder.append(by.a("/", arrayList));
            stringBuilder.append(")");
            String str = stringBuilder.toString();
          } 
        } else {
          str4 = str3;
        } 
        if (d < 0.0D) {
          str5 = az.a(this.dtN).getString(2131628116);
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append(str5);
          str5 = stringBuilder.toString();
        } 
        if (!TextUtils.isEmpty(ao.akG())) {
          if (ao.akM() == 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("|-");
            stringBuilder.append(ao.akG());
            String str = stringBuilder.toString();
          } else {
            str3 = ao.akG();
          } 
        } else {
          str3 = null;
        } 
        if (!paramBoolean2) {
          b.x(new String[] { str4, str6, str5 });
          if (str3 != null)
            if (e.mm(str3)) {
              b.f(str3, 3, 0);
            } else {
              b.ll(str3);
            }  
        } else {
          b.x(new String[] { str4, str6, n.a(Double.valueOf(d1), true, false), str5 });
          if (str3 != null)
            if (e.mm(str3)) {
              b.f(str3, 3, 0);
            } else {
              b.ll(str3);
            }  
        } 
        a(b, ao, d, str6, str5, paramBoolean2, paramInt);
        m = i;
        i = j;
      } 
      m++;
      j = i;
    } 
    parame.setSize(j);
    return true;
  }
  
  private boolean a(e parame, List<Long> paramList, String paramString, ArrayList<aa> paramArrayList, c paramc, TakeOrderEntity paramTakeOrderEntity) {
    String str2;
    StringBuilder stringBuilder = new StringBuilder();
    if (paramTakeOrderEntity.aWa) {
      str2 = "-";
    } else {
      str2 = "";
    } 
    int i = parame.getSize();
    parame.setSize(ip(paramc.aiG()));
    Iterator iterator = paramArrayList.iterator();
    String str1 = "";
    boolean bool = false;
    byte b1 = 1;
    byte b2 = 0;
    while (iterator.hasNext()) {
      StringBuilder stringBuilder1;
      aa aa = (aa)iterator.next();
      String str4 = d(aa);
      paramString = aa.akD();
      null = new StringBuilder();
      null.append(aa.Gz());
      null.append("");
      String str5 = null.toString();
      String str3 = n.b(az.a(this.dtN), paramString, false);
      if (!paramList.contains(Long.valueOf(aa.AL()))) {
        byte b = b1;
        if (str4 != null)
          if (b1) {
            stringBuilder.append(str4);
            b = 0;
          } else {
            stringBuilder.append("/");
            stringBuilder.append(str4);
            b = b1;
          }  
        paramString = str1;
        if (!TextUtils.isEmpty(aa.akC())) {
          paramString = str1;
          if (!str1.equals(aa.akC())) {
            if (b2)
              parame.l('-'); 
            parame.ll(aa.akC());
            paramString = aa.akC();
          } 
        } 
        if (paramc.aiD()) {
          ((g)parame).n(new int[] { 1, 1, 1 });
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str2);
          stringBuilder2.append(str3);
          parame.x(new String[] { str4, str5, stringBuilder2.toString() });
        } else {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str2);
          stringBuilder2.append(str3);
          parame.x(new String[] { str4, stringBuilder2.toString() });
        } 
        if (aa.akM() == 2 && aa instanceof ao) {
          stringBuilder2 = (ao)aa;
          if (stringBuilder2.IU() != null)
            for (h h : stringBuilder2.IU().akq()) {
              if (!paramList.contains(Long.valueOf(h.aJx))) {
                str5 = h.name;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str2);
                stringBuilder3.append(str3);
                parame.x(new String[] { str5, stringBuilder3.toString() });
                parame.afT().aJ("name", h.name);
              } 
            }  
        } 
        if (!TextUtils.isEmpty(aa.akG()))
          if (aa.akE() == 3) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("|-");
            stringBuilder2.append(aa.akG());
            parame.ll(stringBuilder2.toString());
          } else {
            parame.ll(aa.akG());
          }  
        b1 = b;
        bool = true;
      } else {
        stringBuilder1 = stringBuilder2;
      } 
      b2++;
      StringBuilder stringBuilder2 = stringBuilder1;
    } 
    parame.setSize(i);
    parame.afT().aJ("name", stringBuilder.toString());
    return bool;
  }
  
  private void b(TakeOrderEntity paramTakeOrderEntity, g paramg) {
    int i = paramg.getSize();
    b(paramg, 2131630383, n.a(Double.valueOf(paramTakeOrderEntity.Iv()), true, false));
    paramg.setSize(i);
  }
  
  private void b(ArrayList<aa> paramArrayList, @NonNull List<Long> paramList) {
    for (aa aa : paramArrayList) {
      long l = aa.AL();
      if (aa.AL() != 0L && paramList.contains(Long.valueOf(l)))
        null.remove(); 
    } 
    int i = paramArrayList.size();
    for (byte b = 0; b < i - 1; b = b1) {
      byte b1 = b + true;
      byte b2;
      for (b2 = b1; b2 < i; b2++) {
        aa aa1 = (aa)paramArrayList.get(b);
        String str1 = aa1.getName();
        aa aa2 = (aa)paramArrayList.get(b2);
        String str2 = aa2.getName();
        if (n.pp(str1) && n.pp(str2) && str1.compareToIgnoreCase(str2) > 0) {
          paramArrayList.set(b2, aa1);
          paramArrayList.set(b, aa2);
        } 
      } 
    } 
  }
  
  private boolean b(e parame, int paramInt, String paramString) {
    if (paramString == null)
      return false; 
    parame.x(new String[] { az.a(this.dtN).getString(paramInt), paramString });
    return true;
  }
  
  private boolean b(e parame, Double paramDouble) { return a(parame, 2131628738, paramDouble); }
  
  private boolean b(e parame, String paramString) {
    parame.lk(String.format("%s %s", new Object[] { az.a(this.dtN).getString(2131628779), paramString }));
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
  
  private boolean b(e parame, Date paramDate) {
    g g = new g(parame.afT());
    g.setWidth(parame.getWidth());
    g.ic(parame.afU());
    g.n(new int[] { 10, 22 });
    g.x(new String[] { az.a(this.dtN).getString(2131628762), Xn().format(paramDate) });
    return true;
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
    g.setWidth(paramInt1);
    g.n(new int[] { 17, 15 });
    return g;
  }
  
  private void c(TakeOrderEntity paramTakeOrderEntity, g paramg) {
    int i = paramg.getSize();
    if (paramTakeOrderEntity.aVU == 10001L) {
      System.out.println("print secondPayType is PAYTYPE_CASH");
      paramg.setSize(3);
    } 
    if (paramTakeOrderEntity.aVU != az.b(this.dtN))
      a(paramg, fg.ao(paramTakeOrderEntity.aVU), paramTakeOrderEntity.aVV); 
    paramg.setSize(i);
  }
  
  private boolean c(e parame, Double paramDouble) {
    if (paramDouble != null) {
      parame.x(new String[] { az.a(this.dtN).getString(2131628781), n.a(Double.valueOf(-paramDouble.doubleValue()), true, false, parame.afU()) });
      return true;
    } 
    return false;
  }
  
  private boolean c(e parame, String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt != -1) {
        String str = "";
        if (paramInt == 0) {
          str = az.a(this.dtN).getString(2131630024);
        } else if (paramInt == 1) {
          str = az.a(this.dtN).getString(2131630023);
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
    g g = new g(parame.afT());
    g.setWidth(parame.getWidth());
    g.ic(parame.afU());
    g.n(new int[] { 10, 22 });
    g.x(new String[] { az.a(this.dtN).getString(2131628772), Xn().format(paramDate) });
    return true;
  }
  
  private String d(aa paramaa) {
    String str1 = null;
    if (paramaa == null)
      return null; 
    String str2 = paramaa.getName();
    if (paramaa instanceof ao)
      str1 = ((ao)paramaa).IS(); 
    return (str1 != null) ? (str1.trim().isEmpty() ? str2 : String.format("%s%s", new Object[] { str2, str1 })) : str2;
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
      if (n.bL(az.a(this.dtN))) {
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
  
  private boolean m(e parame, String paramString) {
    g g = new g(parame.afT());
    g.setWidth(parame.getWidth());
    g.ic(parame.afU());
    g.n(new int[] { 10, 21 });
    g.x(new String[] { az.a(this.dtN).getString(2131628759), paramString });
    return true;
  }
  
  private boolean n(e parame, @Nullable String paramString) { return b(parame, 2131628737, paramString); }
  
  private boolean o(e parame, @Nullable String paramString) { return b(parame, 2131628740, paramString); }
  
  private boolean p(e parame, @Nullable String paramString) { return b(parame, 2131628741, paramString); }
  
  private boolean q(e parame, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    parame.f(paramString, 3, 0);
    return true;
  }
  
  public SimpleDateFormat Xn() { return new SimpleDateFormat(az.a(this.dtN).getString(2131627405)); }
  
  public List<PrintContent> a(Object paramObject, String paramString, j.i parami, f paramf) {
    byte b;
    paramObject = (TakeOrderEntity)paramObject;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 2006648068:
        if (paramString.equals("kitchen_total_reprint")) {
          b = 5;
          break;
        } 
      case 1676462825:
        if (paramString.equals("kitchen_total")) {
          b = 4;
          break;
        } 
      case 937112962:
        if (paramString.equals("takeout_reprint")) {
          b = 1;
          break;
        } 
      case 608149564:
        if (paramString.equals("kitchen_port")) {
          b = 2;
          break;
        } 
      case -931604649:
        if (paramString.equals("kitchen_port_reprint")) {
          b = 3;
          break;
        } 
      case -1544791705:
        if (paramString.equals("takeout")) {
          b = 0;
          break;
        } 
      case -1979255969:
        if (paramString.equals("tag_not_specified")) {
          b = 6;
          break;
        } 
    } 
    switch (b) {
      default:
        throw new IllegalArgumentException();
      case 6:
        return a(paramObject, (c)paramf, (j.m)parami);
      case 5:
        return a(paramObject, (c)paramf, (j.c)parami, false, true);
      case 4:
        return a(paramObject, (c)paramf, (j.c)parami, false, false);
      case 3:
        return a(paramObject, (c)paramf, (j.c)parami, true, true);
      case 2:
        return a(paramObject, (c)paramf, (j.c)parami, true, false);
      case 1:
        return a(paramObject, (ReceiptPrintSettings)paramf, parami, true);
      case 0:
        break;
    } 
    return a(paramObject, (ReceiptPrintSettings)paramf, parami, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */