package com.laiqian.print.printtype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.main.fj;
import com.laiqian.models.bh;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.orders.a;
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
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.print.usage.tag.a.c;
import com.laiqian.print.util.e;
import com.laiqian.product.models.o;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class g implements j.h {
  private Map<Pair<Class, String>, j.k> cJo = new HashMap();
  
  private SimpleDateFormat cJp;
  
  private Context context;
  
  public g(Context paramContext) {
    this.context = paramContext;
    this.cJo.put(new Pair(PendingFullOrderDetail.class, "dish"), ad.kU("dish"));
    this.cJo.put(new Pair(PendingFullOrderDetail.class, "dish_reprint"), ad.kU("dish_reprint"));
    this.cJo.put(new Pair(com.laiqian.pos.hold.ah.class, "dish"), ad.kU("dish"));
    this.cJo.put(new Pair(com.laiqian.pos.hold.ah.class, "tag_not_specified"), ad.c(bm.cEg));
    this.cJo.put(new Pair(a.class, "tag_not_specified"), ad.c(bm.cEg));
    this.cJo.put(new Pair(a.class, "tag_not_specified_reprint"), ad.c(bm.cEg));
    this.cJo.put(new Pair(com.laiqian.pos.hold.ah.class, "kitchen_total"), ad.kU("kitchen_total"));
    this.cJo.put(new Pair(com.laiqian.pos.hold.ah.class, "kitchen_port"), ad.kU("kitchen_port"));
    this.cJo.put(new Pair(a.class, "kitchen_total"), ad.kU("kitchen_total"));
    this.cJo.put(new Pair(a.class, "kitchen_port"), ad.kU("kitchen_port"));
    this.cJo.put(new Pair(a.class, "kitchen_total_reprint"), ad.kU("kitchen_total_reprint"));
    this.cJo.put(new Pair(a.class, "kitchen_port_reprint"), ad.kU("kitchen_port_reprint"));
    this.cJo.put(new Pair(PendingFullOrderDetail.class, "delivery_not_specified"), ad.kU("delivery_not_specified"));
    this.cJo.put(new Pair(com.laiqian.pos.hold.ah.class, "delivery_not_specified"), ad.kU("delivery_not_specified"));
  }
  
  private void a(PendingFullOrderDetail.c paramc, c paramc1, ArrayList<PrintContent> paramArrayList, List<Long> paramList, int paramInt, PendingFullOrderDetail.a parama) {
    Date date = new Date();
    int j = paramc1.getWidth();
    int i = paramc1.getHeight();
    String str2 = paramc1.aiW();
    null = new av(this.context);
    null = null.atY();
    null.aub();
    null.close();
    iterator2 = paramc.cpg.iterator();
    boolean bool = true;
    String str1 = null;
    Iterator iterator1 = iterator2;
    while (iterator1.hasNext()) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator1.next();
      if (d.id == 6L)
        continue; 
      try {
        long l = d.cpq;
        try {
          boolean bool1 = paramList.contains(Long.valueOf(l));
          if (bool1)
            continue; 
        } catch (ClassCastException iterator2) {}
      } catch (ClassCastException iterator2) {}
      a.e(iterator2);
    } 
  }
  
  private void a(PendingFullOrderDetail.c paramc, c paramc1, ArrayList<PrintContent> paramArrayList, List<Long> paramList, PendingFullOrderDetail.a parama) {
    Date date = new Date();
    int m = paramc1.getWidth();
    int k = paramc1.getHeight();
    str3 = paramc1.aiW();
    String str2 = (new av(this.context)).atY();
    int j = paramc.cpg.size();
    int i = parama.bZF;
    Iterator iterator = paramc.cpg.iterator();
    boolean bool = true;
    String str1 = str3;
    while (iterator.hasNext()) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
      if (d.id == 6L || (i == 3 && d.aTU != 0) || d.cpx == 4L)
        continue; 
      try {
        long l = d.cpq;
        try {
          boolean bool1 = paramList.contains(Long.valueOf(l));
          if (bool1)
            continue; 
        } catch (ClassCastException str3) {}
      } catch (ClassCastException str3) {}
      a.e(str3);
    } 
  }
  
  private void a(a parama, c paramc, ArrayList<PrintContent> paramArrayList, List<Long> paramList) {
    Date date = new Date();
    int k = paramc.getWidth();
    int i = paramc.getHeight();
    String str1 = paramc.aiW();
    String str2 = (new av(this.context)).atY();
    int m = parama.cpg.size();
    int j = parama.bXb.bZF;
    Iterator iterator = parama.cpg.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
      if ((j == 3 && d.aTU != 0) || d.cpx == 4L)
        continue; 
      try {
        long l = d.cpq;
        try {
          boolean bool1 = paramList.contains(Long.valueOf(l));
          if (bool1)
            continue; 
        } catch (ClassCastException null) {}
      } catch (ClassCastException classCastException) {}
      a.e(classCastException);
    } 
  }
  
  private void a(a parama, c paramc, ArrayList<PrintContent> paramArrayList, List<Long> paramList, int paramInt) {
    Date date = new Date();
    int j = paramc.getWidth();
    int i = paramc.getHeight();
    String str1 = paramc.aiW();
    av = new av(this.context);
    String str2 = av.atY();
    av.aub();
    av.close();
    Iterator iterator = parama.cpg.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
      try {
        long l = d.cpq;
        try {
          boolean bool1 = paramList.contains(Long.valueOf(l));
          if (bool1)
            continue; 
        } catch (ClassCastException av) {}
      } catch (ClassCastException av) {}
      a.e(av);
    } 
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
  
  private void a(e parame, PendingFullOrderDetail.d paramd, c paramc, boolean paramBoolean, PendingFullOrderDetail.a parama) {
    byte b;
    g g1 = new g((a)parame);
    int i = g1.getSize();
    switch (paramc.aiG()) {
      default:
        b = 3;
        break;
      case 1:
        b = 1;
        break;
    } 
    g1.setSize(b);
    String str2 = paramd.name;
    if (parama.aVN == 1L) {
      b = 1;
    } else {
      b = 0;
    } 
    if (b == 0 && paramd.aTZ) {
      b = 1;
    } else {
      b = 0;
    } 
    String str1 = str2;
    if (b != 0) {
      StringBuilder stringBuilder;
      str1 = this.context.getString(2131626345);
      if (str2.indexOf("|-") >= 0) {
        String str = str2.replace("|-", "");
        stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(str1);
        stringBuilder.append("]");
        stringBuilder.append(str);
        str1 = stringBuilder.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("|-");
        stringBuilder1.append(str1);
        str1 = stringBuilder1.toString();
      } else {
        str1 = String.format("[%s]%s", new Object[] { str1, stringBuilder });
      } 
    } 
    if (paramc.aiD()) {
      double d1;
      g1.n(new int[] { 1, 1, 1 });
      if (paramBoolean) {
        d1 = paramd.cpo * -1.0D;
      } else {
        d1 = paramd.cpo;
      } 
      g1.x(new String[] { str1, n.a(Double.valueOf(d1), false, false, CrashApplication.aIQ), n.a(Double.valueOf(paramd.cpn), true, false, CrashApplication.aIQ) });
    } else {
      double d1;
      if (paramBoolean) {
        d1 = paramd.cpo * -1.0D;
      } else {
        d1 = paramd.cpo;
      } 
      g1.x(new String[] { str1, n.a(Double.valueOf(d1), false, false, CrashApplication.aIQ) });
    } 
    if (!TextUtils.isEmpty(paramd.cpm))
      if (paramd.cpx == 3L) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(paramd.cpm);
        g1.ll(stringBuilder.toString());
      } else {
        g1.ll(paramd.cpm);
      }  
    g1.setSize(i);
    g1.afT().aJ("name", str1);
  }
  
  private void a(e parame, PendingFullOrderDetail.d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    double d1;
    b b = new b((a)parame);
    b.afW();
    if (paramBoolean1) {
      d2 = Math.abs(paramd.cpo);
      d1 = d2;
      if (paramd.cpo < 0.0D) {
        paramd.cpn = 0.0D;
        d1 = d2;
      } 
    } else {
      d1 = paramd.cpo;
    } 
    if (paramBoolean3) {
      d2 = -d1;
    } else {
      d2 = d1;
    } 
    String str4 = n.a(Double.valueOf(d2), false, false, b.afU());
    if (paramBoolean3) {
      d2 = -(paramd.cpn * paramd.cpo);
    } else {
      d2 = paramd.cpn * paramd.cpo;
    } 
    String str1 = n.a(Double.valueOf(d2), true, false);
    double d2 = paramd.cpn;
    if (paramd.cpt != null) {
      double d3 = paramd.cpt.doubleValue();
      d2 = paramd.cpt.doubleValue();
      d3 = d1 * d3;
      d1 = d3;
      if (paramBoolean3)
        d1 = -d3; 
      str1 = n.a(Double.valueOf(d1), true, false);
    } 
    String str3 = paramd.name;
    String str2 = str3;
    if (paramd.cpx == 3L) {
      str2 = str3;
      if (!str3.startsWith("|-")) {
        null = new StringBuilder();
        null.append("|-");
        null.append(str3);
        str2 = null.toString();
      } 
    } 
    str3 = str2;
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
      str3 = str2;
      if (arrayList.size() > 0) {
        null = new StringBuilder();
        null.append(str2);
        null.append("(");
        null.append(by.a("/", arrayList));
        null.append(")");
        str3 = null.toString();
      } 
    } 
    if (paramd.cpo < 0.0D && paramBoolean1) {
      str2 = this.context.getString(2131628116);
    } else {
      str2 = str1;
    } 
    str1 = null;
    if (!TextUtils.isEmpty(paramd.cpm))
      if (paramd.cpx == 3L && paramd.cpm.startsWith("|-")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(paramd.cpm);
        String str = stringBuilder.toString();
      } else {
        str1 = paramd.cpm;
      }  
    if (!paramBoolean2) {
      b.x(new String[] { str3, str4, str2 });
      if (str1 != null) {
        if (e.mm(str1)) {
          b.f(str1, 3, 0);
          return;
        } 
        b.ll(str1);
        return;
      } 
    } else {
      b.x(new String[] { str3, str4, n.a(Double.valueOf(d2), true, false), str2 });
      if (str1 != null) {
        if (e.mm(str1)) {
          b.f(str1, 3, 0);
          return;
        } 
        b.ll(str1);
      } 
    } 
  }
  
  private void a(e parame, PendingFullOrderDetail.d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PendingFullOrderDetail.a parama) {
    boolean bool;
    double d1;
    b b = new b((a)parame);
    b.afW();
    if (paramd.id == 6L)
      paramd.cpo = (new fj()).a(new Date(paramd.bbX), paramd.cpq); 
    if (paramBoolean1) {
      d2 = Math.abs(paramd.cpo);
      d1 = d2;
      if (paramd.cpo < 0.0D) {
        paramd.cpn = 0.0D;
        d1 = d2;
      } 
    } else {
      d1 = paramd.cpo;
    } 
    if (paramBoolean3) {
      d2 = -d1;
    } else {
      d2 = d1;
    } 
    String str5 = n.d(Double.valueOf(d2));
    if (paramBoolean3) {
      d2 = -(paramd.cpn * paramd.cpo);
    } else {
      d2 = paramd.cpn * paramd.cpo;
    } 
    String str1 = n.a(Double.valueOf(d2), true, false);
    double d2 = paramd.cpn;
    if (paramd.cpt != null) {
      double d3 = paramd.cpt.doubleValue();
      d2 = paramd.cpt.doubleValue();
      d3 = d1 * d3;
      d1 = d3;
      if (paramBoolean3)
        d1 = -d3; 
      str1 = n.a(Double.valueOf(d1), true, false);
    } 
    String str4 = paramd.name;
    String str3 = str4;
    if (paramd.cpx == 3L) {
      str3 = str4;
      if (!str4.startsWith("|-")) {
        null = new StringBuilder();
        null.append("|-");
        null.append(str4);
        str3 = null.toString();
      } 
    } 
    str4 = str3;
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
      str4 = str3;
      if (arrayList.size() > 0) {
        null = new StringBuilder();
        null.append(str3);
        null.append("(");
        null.append(by.a("/", arrayList));
        null.append(")");
        str4 = null.toString();
      } 
    } 
    if (parama.aVN == 1L) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool && paramd.aTZ) {
      bool = true;
    } else {
      bool = false;
    } 
    String str2 = str4;
    if (bool) {
      StringBuilder stringBuilder;
      str2 = this.context.getString(2131626345);
      if (str4.indexOf("|-") >= 0) {
        str3 = str4.replace("|-", "");
        stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(str2);
        stringBuilder.append("]");
        stringBuilder.append(str3);
        str2 = stringBuilder.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("|-");
        stringBuilder1.append(str2);
        str2 = stringBuilder1.toString();
      } else {
        str2 = String.format("[%s]%s", new Object[] { str2, stringBuilder });
      } 
    } 
    str3 = str1;
    if (paramd.cpo < 0.0D) {
      str3 = str1;
      if (paramBoolean1)
        str3 = this.context.getString(2131628116); 
    } 
    str1 = null;
    if (!TextUtils.isEmpty(paramd.cpm))
      if (paramd.cpx == 3L && paramd.cpm.startsWith("|-")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(paramd.cpm);
        String str = stringBuilder.toString();
      } else {
        str1 = paramd.cpm;
      }  
    if (!paramBoolean2) {
      b.x(new String[] { str2, str5, str3 });
      if (str1 != null) {
        if (e.mm(str1)) {
          b.f(str1, 3, 0);
          return;
        } 
        b.ll(str1);
        return;
      } 
    } else {
      b.x(new String[] { str2, str5, n.a(Double.valueOf(d2), true, false), str3 });
      if (str1 != null) {
        if (e.mm(str1)) {
          b.f(str1, 3, 0);
          return;
        } 
        b.ll(str1);
      } 
    } 
  }
  
  private void a(PrintContent.a parama, PendingFullOrderDetail.d paramd, c paramc, PendingFullOrderDetail.a parama1) {
    String str5 = paramd.name;
    String str4 = str5;
    if (paramd.aTZ) {
      str4 = str5;
      if (parama1.aVN != 1L) {
        StringBuilder stringBuilder;
        String str = this.context.getString(2131626345);
        if (paramd.cpx == 3L) {
          str4 = str5.replace("|-", "");
          stringBuilder = new StringBuilder();
          stringBuilder.append("[");
          stringBuilder.append(str);
          stringBuilder.append("]");
          stringBuilder.append(str4);
          str = stringBuilder.toString();
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("|-");
          stringBuilder3.append(str);
          String str6 = stringBuilder3.toString();
        } else {
          null = new StringBuilder();
          null.append("[");
          null.append(str);
          null.append("]");
          null.append(stringBuilder);
          str4 = null.toString();
        } 
      } 
    } 
    double d3 = paramd.cpo;
    double d2 = paramd.cpn;
    int i = e.ml(str4);
    int j = e.jg(paramc.getWidth());
    null = new g(parama);
    null.setWidth(paramc.getWidth());
    null.ic(CrashApplication.aIQ);
    if (i <= j / 2) {
      null.f(str4, 3, 0);
    } else if (i <= j) {
      null.f(str4, 1, 0);
    } else {
      null.ll(str4);
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
  
  private void a(PrintContent.a parama, PendingFullOrderDetail.d paramd, c paramc, a parama1) {
    String str5 = paramd.name;
    String str4 = str5;
    if (paramd.aTZ) {
      StringBuilder stringBuilder;
      str4 = this.context.getString(2131626345);
      if (paramd.cpx == 3L) {
        str5 = str5.replace("|-", "");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("[");
        stringBuilder3.append(str4);
        stringBuilder3.append("]");
        stringBuilder3.append(str5);
        str4 = stringBuilder3.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("|-");
        stringBuilder.append(str4);
        str4 = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("[");
        stringBuilder3.append(str4);
        stringBuilder3.append("]");
        stringBuilder3.append(stringBuilder);
        str4 = stringBuilder3.toString();
      } 
    } 
    double d3 = paramd.cpo;
    double d2 = paramd.cpn;
    int i = e.ml(str4);
    int j = e.jg(paramc.getWidth());
    null = new g(parama);
    null.setWidth(paramc.getWidth());
    null.ic(CrashApplication.aIQ);
    if (i <= j / 2) {
      null.f(str4, 3, 0);
    } else if (i <= j) {
      null.f(str4, 1, 0);
    } else {
      null.ll(str4);
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
  
  private boolean a(e parame) { return a(parame, false); }
  
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
  
  private boolean a(e parame, Double paramDouble) { return a(parame, paramDouble, false); }
  
  private boolean a(e parame, Double paramDouble, boolean paramBoolean) {
    double d;
    if (paramDouble == null)
      return false; 
    g g1 = new g(parame.afT());
    g1.setWidth(parame.getWidth());
    g1.ic(parame.afU());
    g1.setSize(3);
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
        g1.x(new String[] { this.context.getString(2131628730) });
      } else {
        g1.x(new String[] { this.context.getString(2131628729) });
      } 
      g1.o(new int[] { 2 });
      g1.x(new String[] { str });
      return true;
    } 
    if (paramBoolean)
      i = 2131628730; 
    if (paramBoolean) {
      d = -paramDouble.doubleValue();
    } else {
      d = paramDouble.doubleValue();
    } 
    return a(g1, i, Double.valueOf(d));
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
  
  private boolean a(e parame, String paramString, Date paramDate) {
    g g1 = new g(parame.afT());
    g1.setWidth(parame.getWidth());
    g1.ic(parame.afU());
    g1.n(new int[] { 10, 22 });
    g1.x(new String[] { paramString, Xn().format(paramDate) });
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
  
  private boolean a(e parame, Collection<PendingFullOrderDetail.d> paramCollection, int paramInt, boolean paramBoolean1, boolean paramBoolean2, PendingFullOrderDetail.a parama) { return a(parame, paramCollection, paramInt, paramBoolean1, paramBoolean2, false, parama); }
  
  private boolean a(e parame, Collection<PendingFullOrderDetail.d> paramCollection, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) { return a(parame, paramCollection, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, 0); }
  
  private boolean a(e parame, Collection<PendingFullOrderDetail.d> paramCollection, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2) {
    int i = parame.getSize();
    parame.setSize(paramInt1);
    Iterator iterator = paramCollection.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
      if ((paramInt2 == 1 && d.aTU != 0) || (paramInt2 != 1 && d.aTU == 0) || d.cpx == 4L)
        continue; 
      if (!bool) {
        parame.setSize(i);
        parame.l('-');
        parame.setSize(paramInt1);
        bool = true;
      } 
      a(parame, d, paramBoolean1, paramBoolean2, paramBoolean3);
    } 
    parame.setSize(i);
    return true;
  }
  
  private boolean a(e parame, Collection<PendingFullOrderDetail.d> paramCollection, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PendingFullOrderDetail.a parama) {
    int i = parame.getSize();
    parame.setSize(paramInt);
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      a(parame, (PendingFullOrderDetail.d)iterator.next(), paramBoolean1, paramBoolean2, paramBoolean3, parama); 
    parame.setSize(i);
    return true;
  }
  
  private boolean a(e parame, Date paramDate) {
    if (paramDate == null)
      return false; 
    parame.f(Xn().format(paramDate), 0, 1);
    return true;
  }
  
  private boolean a(e parame, boolean paramBoolean) {
    if (!paramBoolean) {
      parame.x(new String[] { this.context.getString(2131628769), this.context.getString(2131628771), this.context.getString(2131628783) });
      return true;
    } 
    parame.x(new String[] { this.context.getString(2131628769), this.context.getString(2131628771), this.context.getString(2131629243), this.context.getString(2131628783) });
    return true;
  }
  
  private void aj(ArrayList<PendingFullOrderDetail.d> paramArrayList) {
    HashMap hashMap = new HashMap();
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size()) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramArrayList.get(i);
      if (d.cpx == 3L) {
        ArrayList arrayList2 = (ArrayList)hashMap.get(Integer.valueOf(j));
        ArrayList arrayList1 = arrayList2;
        if (arrayList2 == null) {
          arrayList1 = new ArrayList();
          hashMap.put(Integer.valueOf(j), arrayList1);
        } 
        arrayList1.add(d);
        paramArrayList.remove(i);
        i--;
      } else {
        j = System.identityHashCode(d);
      } 
      i++;
    } 
    int k = paramArrayList.size();
    for (i = 0; i < k - 1; i = b + 1) {
      byte b;
      j = i + 1;
      while (true) {
        b = i;
        if (j < k) {
          String str1 = ((PendingFullOrderDetail.d)paramArrayList.get(i)).name;
          String str2 = ((PendingFullOrderDetail.d)paramArrayList.get(j)).name;
          if (str1.compareToIgnoreCase(str2) > 0 && n.pp(str2)) {
            paramArrayList.add(i, paramArrayList.remove(j));
            b = i - 1;
            break;
          } 
          j++;
          continue;
        } 
        break;
      } 
    } 
    if (hashMap.size() > 0)
      for (i = 0; i < paramArrayList.size(); i = j + 1) {
        PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramArrayList.get(i);
        ArrayList arrayList = (ArrayList)hashMap.get(Integer.valueOf(System.identityHashCode(d)));
        j = i;
        if (arrayList != null) {
          arrayList = new ArrayList(arrayList);
          if (d.aTO > 0L) {
            boolean bool = true;
          } else {
            boolean bool = false;
          } 
          j = 0;
          while (true);
          paramArrayList.addAll(i + 1, arrayList);
          j = i + arrayList.size();
        } 
      }  
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
  
  private boolean b(a parama) { return (parama.bXb.aVN > 0L); }
  
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
  
  private g br(int paramInt1, int paramInt2) {
    g g1 = new g();
    g1.setWidth(paramInt1);
    if (paramInt1 == 80) {
      g1.n(new int[] { 7, 2, 3 });
    } else {
      g1.n(new int[] { 2, 1, 1 });
    } 
    g1.ic(paramInt2);
    PrintContent.a a = g1.afT();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    a.aJ("width", stringBuilder.toString());
    g1.n(new int[] { 17, 15 });
    return g1;
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
  
  private boolean j(e parame, String paramString) {
    parame.f(String.format("%s-%s", new Object[] { "Phone Order", this.context.getString(2131628755) }), 1, 1);
    parame.f(String.format("%s : %s", new Object[] { "Order", paramString }), 1, 1);
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
  
  public SimpleDateFormat Xn() {
    if (this.cJp == null)
      this.cJp = new SimpleDateFormat(this.context.getString(2131627405)); 
    return this.cJp;
  }
  
  public boolean a(PendingFullOrderDetail.a parama, c paramc, boolean paramBoolean) {
    int i = paramc.aja();
    int j = c.cOo;
    boolean bool = true;
    if (i == j || paramc.aja() == 2 || parama.aVN == 1L) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i == 0) {
      if (paramBoolean)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public boolean a(a parama) {
    if (parama.bXb.cpb == 1) {
      for (PendingFullOrderDetail.d d : parama.cpg) {
        if (d.aTU == 1 || d.aTU == 2)
          return true; 
      } 
      return false;
    } 
    return false;
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
  
  public boolean q(PendingFullOrderDetail paramPendingFullOrderDetail) {
    if (paramPendingFullOrderDetail.bXb.cpb == 1) {
      for (PendingFullOrderDetail.d d : paramPendingFullOrderDetail.coy) {
        if (d.aTU == 1 || d.aTU == 2)
          return true; 
      } 
      Iterator iterator = paramPendingFullOrderDetail.coz.iterator();
      while (iterator.hasNext()) {
        for (PendingFullOrderDetail.d d : ((PendingFullOrderDetail.c)iterator.next()).cpg) {
          if (d.aTU == 1 || d.aTU == 2)
            return true; 
        } 
      } 
      return false;
    } 
    return false;
  }
  
  public j.f yA() { return new i(this); }
  
  @NonNull
  public j.k yB() { return new h(this); }
  
  public j.b yy() { return p.aev(); }
  
  public j.a yz() { return h.aY(this.context); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\printtype\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */