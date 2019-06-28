package com.laiqian.news;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.main.bb;
import com.laiqian.main.di;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.product.a.a;
import com.laiqian.product.models.a;
import com.laiqian.product.models.h;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class q {
  private u bWP;
  
  private y bWQ;
  
  private ActivityRoot mActivity;
  
  private Context mContext;
  
  di settlementRunnable;
  
  public q(Context paramContext, u paramu, ActivityRoot paramActivityRoot) {
    this.bWP = paramu;
    this.mContext = paramContext;
    this.mActivity = paramActivityRoot;
    this.bWQ = new y();
  }
  
  private aa convert(PendingFullOrderDetail.d paramd) {
    aa aa = new aa(new h(paramd.id, paramd.name, paramd.cpm, paramd.cpn, 0.0D, 600001, paramd.cpq, "", paramd.cpu, "", (int)paramd.cpx, 0.0D), new a(a.AZ().Cp()));
    if (paramd.cpl != null)
      aa.aq(paramd.cpl.longValue()); 
    aa.az(paramd.bbX);
    aa.ar(paramd.aTO);
    aa.cS(paramd.aTP);
    aa.q(paramd.cpo);
    aa.cV(true);
    aa.cW(false);
    aa.GD();
    aa.as(paramd.cpz);
    return aa;
  }
  
  private bb h(PendingFullOrderDetail paramPendingFullOrderDetail) {
    ArrayList arrayList2 = new ArrayList();
    ArrayList arrayList1 = g(paramPendingFullOrderDetail);
    bb bb = new bb(true, arrayList1, paramPendingFullOrderDetail.bXb.btX, 100.0D);
    bb.orderNo = paramPendingFullOrderDetail.bXb.orderNo;
    bb.bcg = paramPendingFullOrderDetail.bXb.coO;
    bb.bcf = 7L;
    if (paramPendingFullOrderDetail.bXb.coE.getTime() > 0L)
      bb.az(paramPendingFullOrderDetail.bXb.coE.getTime()); 
    try {
      exception = new StringBuilder();
      exception.append(paramPendingFullOrderDetail.bXb.coJ);
      exception.append("");
      bb.bbQ = exception.toString();
      bb.bbR = Long.valueOf(n.parseLong(paramPendingFullOrderDetail.bXb.coJ));
      bb.bch = b.a(paramPendingFullOrderDetail.bXb.bZM, RootApplication.getLaiqianPreferenceManager().atm(), RootApplication.getLaiqianPreferenceManager().atm(), paramPendingFullOrderDetail.bXb.coE.getTime());
      try {
        b.a a = b.a(this.mContext, null, Long.valueOf(n.parseLong(paramPendingFullOrderDetail.bXb.coJ)), true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.bZc);
        stringBuilder.append("-");
        stringBuilder.append(a.bTe);
        bb.openTableName = stringBuilder.toString();
      } catch (Exception null) {}
    } catch (Exception exception) {}
    a.e(exception);
  }
  
  public String a(LinkedHashMap<Integer, Long> paramLinkedHashMap) { return this.bWQ.a(paramLinkedHashMap); }
  
  public void a(HashMap<String, Object> paramHashMap, boolean paramBoolean) {
    y.a a = new y.a();
    a.bXn = paramBoolean;
    a.a(new s(this, paramHashMap, paramBoolean));
    a.execute(new HashMap[] { paramHashMap });
  }
  
  public ArrayList<aa> f(h paramh) {
    aa aa;
    ArrayList arrayList = new ArrayList();
    if (paramh instanceof aa) {
      aa = (aa)paramh;
    } else {
      aa = new aa(paramh, new a(a.AZ().Cp()));
    } 
    arrayList.add(aa);
    aa.GJ();
    aa.GI();
    if (paramh instanceof a) {
      ArrayList arrayList1 = ((a)paramh).akq();
      if (arrayList1 != null) {
        Iterator iterator = arrayList1.iterator();
        while (iterator.hasNext())
          arrayList.add(new aa((h)iterator.next(), new a(a.AZ().Cp()))); 
      } 
    } 
    return arrayList;
  }
  
  public ArrayList<aa> g(PendingFullOrderDetail paramPendingFullOrderDetail) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator2 = paramPendingFullOrderDetail.coy.iterator();
    while (iterator2.hasNext())
      arrayList.addAll(f(convert((PendingFullOrderDetail.d)iterator2.next()))); 
    Iterator iterator1 = paramPendingFullOrderDetail.coz.iterator();
    while (iterator1.hasNext()) {
      iterator2 = ((PendingFullOrderDetail.c)iterator1.next()).cpg.iterator();
      while (iterator2.hasNext())
        arrayList.addAll(f(convert((PendingFullOrderDetail.d)iterator2.next()))); 
    } 
    return arrayList;
  }
  
  public void gr(int paramInt) {
    this.bWP.zL();
    y y1;
    (y1 = this.bWQ).a(paramInt, new r(this));
  }
  
  public void i(PendingFullOrderDetail paramPendingFullOrderDetail) {
    this.settlementRunnable = new di(this.mActivity, h(paramPendingFullOrderDetail), false, new t(this));
    this.settlementRunnable.k(h(paramPendingFullOrderDetail));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */