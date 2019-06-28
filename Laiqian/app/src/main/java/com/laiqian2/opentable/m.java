package com.laiqian.opentable;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.models.at;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.hold.ah;
import com.laiqian.pos.hold.e;
import com.laiqian.pos.model.orders.a;
import com.laiqian.print.c.d;
import com.laiqian.print.c.l;
import com.laiqian.print.j;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.util.by;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import java.util.ArrayList;
import java.util.List;

public class m {
  public static void a(Context paramContext, TableEntity paramTableEntity1, TableEntity paramTableEntity2, String paramString, int paramInt) {
    b b = new b(paramTableEntity1, paramTableEntity2, Long.parseLong(paramString), paramInt);
    l l = l.ahn();
    d d = d.bg(RootApplication.zv());
    boolean bool = a.AZ().Bl();
    g g = g.cGS;
    if (bool) {
      try {
        for (e e : j.cCx.a(b, new String[] { "receipt_not_specified" })) {
          e.a(new s(e, paramContext, l));
          g.print(e);
        } 
      } catch (Exception paramContext) {
        a.e(paramContext);
      } 
      try {
        List list = j.cCx.a(b, new String[] { "kitchen_not_specified" });
        l.p(list);
        d.p(list);
        g.cGS.o(list);
        return;
      } catch (Exception paramContext) {
        a.e(paramContext);
      } 
    } 
  }
  
  public static void a(Context paramContext, PendingFullOrderDetail paramPendingFullOrderDetail, PendingFullOrderDetail.c paramc, boolean paramBoolean) { a(paramContext, paramPendingFullOrderDetail, paramc, paramBoolean, true); }
  
  public static void a(Context paramContext, PendingFullOrderDetail paramPendingFullOrderDetail, PendingFullOrderDetail.c paramc, boolean paramBoolean1, boolean paramBoolean2) {
    PendingFullOrderDetail pendingFullOrderDetail = b.b(paramPendingFullOrderDetail, null);
    if (paramc.cpg.size() != 0)
      e.aU(paramContext).play(); 
    d d = d.bg(paramContext);
    l l = l.ahn();
    if (paramc.cpg.size() != 0) {
      g g = g.cGS;
      at at = new at(paramContext);
      boolean bool1 = at.em(false);
      at.close();
      boolean bool2 = a.AZ().Bi();
      boolean bool3 = a.AZ().Bl();
      ah ah = new ah(pendingFullOrderDetail.bXb, paramc);
      if (((bool2 && bool1) || (bool3 && paramBoolean1)) && by.isNull(pendingFullOrderDetail.bXb.coT) && paramBoolean2)
        try {
          for (e e : j.cCx.a(ah, new String[] { "dish" })) {
            e.a(new n(e, paramContext, l));
            g.print(e);
          } 
        } catch (Exception paramContext) {
          a.e(paramContext);
        }  
      if (pendingFullOrderDetail.bXb.aVN == 1L || !by.isNull(pendingFullOrderDetail.bXb.coT))
        try {
          List list = j.cCx.a(ah, new String[] { "delivery_not_specified" });
          g.cGS.o(list);
        } catch (Exception paramContext) {
          a.e(paramContext);
        }  
      try {
        List list = j.cCx.a(ah, new String[] { "kitchen_total", "kitchen_port" });
        d.p(list);
        g.cGS.o(list);
      } catch (Exception paramContext) {
        a.e(paramContext);
      } 
      if ((a.AZ().Bj() && bool1) || (bool3 && paramBoolean1))
        try {
          List list = j.cCx.a(ah, new String[] { "tag_not_specified" });
          l.p(list);
          g.cGS.o(list);
          return;
        } catch (Exception paramContext) {
          a.e(paramContext);
        }  
    } 
  }
  
  public static void a(Context paramContext, PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean) { a(paramContext, paramPendingFullOrderDetail, paramBoolean, true); }
  
  public static void a(Context paramContext, PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean1, boolean paramBoolean2) {
    PendingFullOrderDetail pendingFullOrderDetail = b.b(paramPendingFullOrderDetail, null);
    e.aU(paramContext).play();
    d = d.bg(paramContext);
    l l = l.ahn();
    null = new at(paramContext);
    boolean bool1 = null.em(false);
    null.close();
    boolean bool2 = a.AZ().Bi();
    boolean bool3 = a.AZ().Bl();
    g g = g.cGS;
    if (((bool2 && bool1) || (bool3 && paramBoolean1)) && paramBoolean2)
      try {
        for (e e : j.cCx.a(pendingFullOrderDetail, new String[] { "dish" })) {
          e.a(new p(e, paramContext, l));
          g.print(e);
        } 
      } catch (Exception paramContext) {
        a.e(paramContext);
      }  
    if (pendingFullOrderDetail.bXb.aVN == 1L)
      try {
        a = j.cCx.a(pendingFullOrderDetail, new String[] { "delivery_not_specified" });
        g.cGS.o(a);
      } catch (Exception paramContext) {
        a.e(paramContext);
      }  
    if (pendingFullOrderDetail.bXb.bZF == 3) {
      a = pendingFullOrderDetail.hc(1);
    } else {
      a = pendingFullOrderDetail.aaE();
    } 
    try {
      ArrayList arrayList = new ArrayList();
      List list1 = j.cCx.a(a, new String[] { "kitchen_total" });
      List list2 = j.cCx.a(a, new String[] { "kitchen_port" });
      arrayList.addAll(list1);
      arrayList.addAll(list2);
      d.p(arrayList);
      g.cGS.o(arrayList);
    } catch (Exception d) {
      h.a(new d(m.class.getName(), d.getStackTrace().toString()), h.a.dHw, h.b.dHI);
      a.e(d);
    } 
    if ((a.AZ().Bj() && bool1) || (bool3 && paramBoolean1)) {
      b.b(pendingFullOrderDetail, null);
      try {
        List list = j.cCx.a(a, new String[] { "tag_not_specified" });
        l.p(list);
        g.cGS.o(list);
        return;
      } catch (Exception a) {
        a.e(a);
      } 
    } 
  }
  
  public static void m(PendingFullOrderDetail paramPendingFullOrderDetail) {
    g = g.cGS;
    if (paramPendingFullOrderDetail == null)
      return; 
    paramPendingFullOrderDetail.bXb.aVN = 1L;
    l l = l.ahn();
    try {
      for (e e : j.cCx.a(paramPendingFullOrderDetail, new String[] { "dish" })) {
        e.a(new u(e, l));
        g.print(e);
      } 
    } catch (Exception g) {
      a.e(g);
    } 
    try {
      a a = paramPendingFullOrderDetail.aaE();
      ArrayList arrayList = new ArrayList();
      List list1 = j.cCx.a(a, new String[] { "kitchen_port" });
      List list2 = j.cCx.a(a, new String[] { "kitchen_total" });
      arrayList.addAll(list1);
      arrayList.addAll(list2);
      d.bg(RootApplication.zv()).p(arrayList);
      g.cGS.o(arrayList);
      return;
    } catch (Exception paramPendingFullOrderDetail) {
      a.e(paramPendingFullOrderDetail);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */