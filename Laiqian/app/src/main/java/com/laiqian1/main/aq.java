package com.laiqian.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.models.n;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.hold.ah;
import com.laiqian.pos.model.a;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.c.d;
import com.laiqian.print.c.l;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.product.a.d;
import com.laiqian.product.models.c;
import com.laiqian.product.models.p;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aq extends Thread {
  private boolean bbj = false;
  
  private boolean bbk = false;
  
  private PendingFullOrderDetail bbl = null;
  
  private PendingFullOrderDetail bbm = null;
  
  private b bbn = null;
  
  boolean bbo = true;
  
  boolean bbp = true;
  
  private Context mContext = null;
  
  public aq(Context paramContext, bb parambb) { this(paramContext, parambb, false); }
  
  public aq(Context paramContext, bb parambb, @Nullable PendingFullOrderDetail paramPendingFullOrderDetail) { this(paramContext, parambb, paramPendingFullOrderDetail, false); }
  
  public aq(Context paramContext, bb parambb, @Nullable PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean) {
    this.mContext = paramContext;
    this.bbj = true;
    this.bbm = paramPendingFullOrderDetail;
    this.bbk = paramBoolean;
    this.bbn = e(parambb);
    this.bbn.cyV = true;
    this.bbl = d(parambb);
  }
  
  public aq(Context paramContext, bb parambb, boolean paramBoolean) {
    this.mContext = paramContext;
    this.bbk = paramBoolean;
    this.bbn = e(parambb);
    this.bbj = false;
  }
  
  private PendingFullOrderDetail d(bb parambb) {
    long l;
    PendingFullOrderDetail pendingFullOrderDetail = new PendingFullOrderDetail();
    pendingFullOrderDetail.bXb.coE = new Date(System.currentTimeMillis());
    av av = new av(this.mContext);
    null = av.Tx();
    String str = av.atm();
    av.close();
    pendingFullOrderDetail.bXb.aEI = Long.valueOf(str).longValue();
    pendingFullOrderDetail.bXb.bJc = Long.valueOf(null).longValue();
    pendingFullOrderDetail.bXb.coH = 100001L;
    pendingFullOrderDetail.bXb.coI = 300002L;
    pendingFullOrderDetail.bXb.orderNo = parambb.orderNo;
    pendingFullOrderDetail.bXb.coJ = parambb.bbQ;
    PendingFullOrderDetail.a a = pendingFullOrderDetail.bXb;
    if (parambb.aTZ) {
      l = 1L;
    } else {
      l = 0L;
    } 
    a.aVN = l;
    (new d()).a(new d.a()).akm();
    for (aa aa : parambb.bbT) {
      PendingFullOrderDetail.d d = new PendingFullOrderDetail.d();
      d.id = aa.aSW;
      d.cpo = aa.Gw();
      String str2 = aa.name;
      ArrayList arrayList = aa.GL();
      String str1 = str2;
      if (arrayList.size() != 0) {
        null = new StringBuilder();
        null.append(str2);
        null.append("[");
        null.append(c.a(null, arrayList));
        null.append("]");
        str1 = null.toString();
      } 
      d.name = str1;
      d.cpm = aa.cpm;
      d.cpn = aa.Gz();
      d.cpn += c.a(aa.Gz(), arrayList, aa.Gq());
      d.cpq = aa.aJx;
      d.cpx = aa.akM();
      d.aTO = aa.Gs();
      d.aTZ = aa.Gp();
      pendingFullOrderDetail.coy.add(d);
    } 
    return pendingFullOrderDetail;
  }
  
  private b e(bb parambb) {
    b b2 = new b();
    if (this.bbk && parambb.Ly() == 0L) {
      date = new Date();
    } else {
      Date date;
      date = new Date(parambb.Ly());
    } 
    parambb.Lz();
    ArrayList arrayList = new ArrayList();
    for (aa aa : parambb.bbT) {
      HashMap hashMap = new HashMap();
      String str2 = aa.name;
      ArrayList arrayList1 = aa.GL();
      String str1 = str2;
      if (arrayList1.size() != 0) {
        null = new StringBuilder();
        null.append(str2);
        null.append("[");
        null.append(c.a(null, arrayList1));
        null.append("]");
        str1 = null.toString();
      } 
      hashMap.put("sProductName", str1);
      hashMap.put("sSpareField5", aa.cpm);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(aa.Gw());
      stringBuilder.append("");
      hashMap.put("nProductQty", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(aa.GA());
      stringBuilder.append("");
      hashMap.put("fPrice", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(aa.AO());
      stringBuilder.append("");
      hashMap.put("fAmount", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(aa.GA());
      stringBuilder.append("");
      hashMap.put("fOriginalPrice", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(aa.aJx);
      hashMap.put("nProductType", stringBuilder.toString());
      if (parambb.bbQ != null)
        hashMap.put("tableNo", parambb.bbQ); 
      hashMap.put("fMemberPrice", Double.valueOf(aa.akK()));
      if (parambb.vipEntity != null && !a.AZ().Bx() && n.bc(aa.Gz() - aa.akK()))
        hashMap.put("fMemberPriceDiscount", Double.valueOf(aa.akI() - aa.akK())); 
      hashMap.put("fDbOrigPrice", Double.valueOf(aa.akI()));
      hashMap.put("taxList", aa.GP());
      hashMap.put("noDiscount", Boolean.valueOf(aa.Gv()));
      hashMap.put("nFoodCategory", Integer.valueOf(aa.akM()));
      hashMap.put("isProductPack", Boolean.valueOf(aa.Gp()));
      arrayList.add(hashMap);
    } 
    b2.orderNo = parambb.orderNo;
    b2.cyL = parambb.amountRounding;
    b2.cyM = parambb.bcb;
    b2.aWa = parambb.isSaleOrder ^ true;
    b2.bkf = date;
    b2.bbP = parambb.bbP;
    b2.coJ = parambb.bbQ;
    b2.vipEntity = parambb.vipEntity;
    b2.aTZ = parambb.aTZ;
    b2.cpa = parambb.GK();
    b2.ceX = Double.valueOf(parambb.discount);
    this.bbo = parambb.bcm;
    this.bbp = parambb.bcn;
    if (parambb.vipEntity != null) {
      if (!TextUtils.isEmpty(parambb.vipEntity.name)) {
        b2.cyJ = parambb.vipEntity.name;
      } else if (!TextUtils.isEmpty(parambb.vipEntity.aTp)) {
        b2.cyJ = parambb.vipEntity.aTp;
      } else {
        b2.cyJ = parambb.vipEntity.aWn;
      } 
      b2.cyK = parambb.vipEntity.aWp;
      b2.bbZ = parambb.bbZ;
    } 
    b2.cyN.add(new n(this.mContext.getString(2131628768), -parambb.bca));
    b2.cyN.add(new n(this.mContext.getString(2131627335), -parambb.bcb));
    b2.cyN.add(new n(this.mContext.getString(2131625864), parambb.getNeglectSmallChanges()));
    b2.bbS.addAll(parambb.bbS);
    b2.cyO = (b2.cyP = (b2.cyI = (b2.cyH = Double.valueOf(parambb.bbW)).valueOf(n.bb(parambb.bbW) - parambb.bbY - parambb.bca + parambb.amountRounding - parambb.bcb)).valueOf(parambb.bbW)).valueOf(parambb.bbY);
    b2.billNumber = parambb.billNumber;
    b2.bJf.addAll(arrayList);
    b2.bcf = parambb.bcf;
    b2.bch = parambb.bch;
    b b1 = b.a(b2, parambb.bch);
    b1.openTableName = parambb.openTableName;
    if (parambb.Lz() != null) {
      b1.cyR.addAll(parambb.Lz().values());
      double d = 0.0D;
      Iterator iterator = parambb.Lz().values().iterator();
      while (iterator.hasNext())
        d += n.bb(((p)iterator.next()).alh()); 
      b1.cyQ = Double.valueOf(d);
    } 
    String str = b.jb(RootApplication.getLaiqianPreferenceManager().atm());
    b1.coV = str;
    b1.coU = str;
    b1.ceV = RootApplication.getLaiqianPreferenceManager().Ea();
    return b1;
  }
  
  public aq df(boolean paramBoolean) {
    this.bbk = paramBoolean;
    return this;
  }
  
  public void run() {
    d d = d.bg(this.mContext);
    l = l.ahn();
    ArrayList arrayList = new ArrayList();
    if (this.bbj) {
      a a = new a(this.mContext);
      if (this.bbl.bXb.coJ == null)
        return; 
      boolean bool = a.AZ().Bj();
      if (this.bbm != null) {
        if (this.bbo || !a.zR().Ab())
          try {
            List list;
            if (this.bbk) {
              list = j.cCx.a(this.bbn, new String[] { "pre" });
            } else {
              list = j.cCx.a(this.bbn, new String[] { "settle_receipt" });
            } 
            l.p(list);
            arrayList.addAll(list);
          } catch (Exception exception) {
            a.e(exception);
          }  
        if (this.bbk) {
          g.cGS.o(arrayList);
          return;
        } 
        PendingFullOrderDetail.c c = a.a(a.a(this.bbl, this.bbm));
        ah = new ah(this.bbl.bXb, c);
        if (c.cpg.size() > 0) {
          if (bool) {
            try {
              List list = j.cCx.a(ah, new String[] { "tag_not_specified" });
              l.p(list);
              arrayList.addAll(list);
            } catch (Exception l) {
              a.e(l);
            } 
          } else {
            try {
              List list = j.cCx.a(this.bbn, new String[] { "tag_not_specified" });
              l.p(list);
              arrayList.addAll(list);
            } catch (Exception l) {
              a.e(l);
            } 
          } 
          if (this.bbp || !a.zR().Ab())
            try {
              List list = j.cCx.a(ah, new String[] { "kitchen_total", "kitchen_port" });
              d.p(list);
              arrayList.addAll(list);
            } catch (Exception ah) {
              a.e(ah);
            }  
        } 
      } else if (this.bbo || !a.zR().Ab()) {
        try {
          List list;
          if (this.bbk) {
            list = j.cCx.a(this.bbn, new String[] { "pre" });
          } else {
            list = j.cCx.a(this.bbn, new String[] { "settle_receipt" });
          } 
          l.p(list);
          arrayList.addAll(list);
        } catch (Exception exception) {
          a.e(exception);
        } 
      } 
    } else {
      if (this.bbo || !a.zR().Ab())
        try {
          List list;
          if (this.bbk) {
            list = j.cCx.a(this.bbn, new String[] { "pre" });
          } else {
            list = j.cCx.a(this.bbn, new String[] { "settle_receipt" });
          } 
          l.p(list);
          arrayList.addAll(list);
        } catch (Exception exception) {
          a.e(exception);
        }  
      if (this.bbk) {
        g.cGS.o(arrayList);
        return;
      } 
      if (!this.bbn.aWa)
        try {
          List list = j.cCx.a(this.bbn, new String[] { "tag_not_specified" });
          l.p(list);
          arrayList.addAll(list);
        } catch (Exception exception) {
          a.e(exception);
        }  
      if (this.bbn.aTZ)
        try {
          arrayList.addAll(j.cCx.a(this.bbn, new String[] { "delivery_not_specified" }));
        } catch (Exception exception) {
          a.e(exception);
        }  
      if (this.bbp || !a.zR().Ab()) {
        try {
          List list = j.cCx.a(this.bbn, new String[] { "kitchen_total" });
          d.p(list);
          arrayList.addAll(list);
        } catch (Exception exception) {
          a.e(exception);
        } 
        try {
          List list = j.cCx.a(this.bbn, new String[] { "kitchen_port" });
          d.p(list);
          arrayList.addAll(list);
        } catch (Exception exception) {
          a.e(exception);
        } 
      } 
    } 
    g.cGS.o(arrayList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */