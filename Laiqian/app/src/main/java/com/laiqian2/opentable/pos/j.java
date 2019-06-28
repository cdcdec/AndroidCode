package com.laiqian.opentable.pos;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.laiqian.entity.s;
import com.laiqian.main.bb;
import com.laiqian.opentable.common.a.a;
import com.laiqian.opentable.common.a.ab;
import com.laiqian.opentable.common.ah;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.u;
import com.laiqian.ordertool.c.a;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.print.util.e;
import com.laiqian.util.by;
import com.laiqian.util.cg;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.n;
import java.lang.ref.WeakReference;
import java.util.Date;
import kotlin.f;
import org.json.JSONException;

public class j implements a {
  private final int aJe = 60000;
  
  private ah bMe = new ah();
  
  private a bYB;
  
  private b cbb;
  
  private i cbc;
  
  private WeakReference<b<Boolean>> cbd;
  
  private WeakReference<c<Boolean>> cbe;
  
  private Context context;
  
  private Handler handler;
  
  public j(Context paramContext, b paramb, a parama) {
    this.bYB = new ab(paramContext, parama);
    this.cbb = paramb;
    this.context = paramContext;
    this.handler = new q(this, paramContext.getMainLooper());
  }
  
  private void a(n<f<Boolean, PendingFullOrderDetail, TableEntity>> paramn) { paramn.f(a.aKh()).e(a.aJo()).a(new l(this), new m(this)); }
  
  private void b(n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> paramn) { paramn.f(a.aKh()).e(a.aJo()).a(new o(this), new p(this)); }
  
  private void g(bb parambb, boolean paramBoolean) { e.i(new t(this, parambb, paramBoolean)); }
  
  public void Yt() { eI(true); }
  
  public void Yu() {
    try {
      u.XP();
      this.bMe.a(this.handler, 60000);
      gA(2);
      this.bYB.a(new w(this));
      return;
    } catch (m m) {
      a(m);
      return;
    } 
  }
  
  public void a(b<Boolean> paramb) { this.cbd = new WeakReference(paramb); }
  
  public void a(c<Boolean> paramc) { this.cbe = new WeakReference(paramc); }
  
  public void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb, boolean paramBoolean) {
    try {
      gA(0);
      paramPendingFullOrderDetail.bXb.cpc = Double.valueOf(parambb.bbY);
      paramPendingFullOrderDetail.bXb.coM = paramTableEntity.Yg().Yl();
      if (parambb != null)
        try {
          if (b.XE()) {
            paramPendingFullOrderDetail.bXb.ceX = Double.valueOf(parambb.discount);
            paramPendingFullOrderDetail.bXb.cpa = parambb.GK();
            if (parambb.Lz() != null)
              paramPendingFullOrderDetail.bXb.cpe = b.B(parambb.Lz()); 
          } 
          this.bMe.a(this.handler, 60000, new ah(this, parambb, paramBoolean));
          this.bYB.a(paramTableEntity, paramPendingFullOrderDetail, parambb, new r(this, parambb, paramBoolean));
          return;
        } catch (JSONException paramTableEntity) {
          a.e(paramTableEntity);
          return;
        }  
      this.bMe.a(this.handler, 60000, new ah(this, parambb, paramBoolean));
      this.bYB.a(paramTableEntity, paramPendingFullOrderDetail, parambb, new r(this, parambb, paramBoolean));
      return;
    } catch (m paramTableEntity) {
      a(paramTableEntity);
      return;
    } 
  }
  
  public void a(a parama, TableEntity paramTableEntity, int paramInt) {
    try {
      gA(0);
      this.bMe.a(this.handler, 60000);
      this.bYB.a(paramTableEntity, paramInt, new z(this, paramInt, parama, paramTableEntity));
      return;
    } catch (m parama) {
      a(parama);
      return;
    } 
  }
  
  public void a(a parama, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) {
    try {
      gA(2);
      this.bMe.a(this.handler, 60000);
      this.bYB.a(paramTableEntity1, paramTableEntity2, paramInt, new ad(this, parama));
      return;
    } catch (m parama) {
      a(parama);
      return;
    } 
  }
  
  public void a(m paramm) {
    if (!by.isNull(paramm.XI())) {
      this.cbb.fa(paramm.XI());
      Log.d(paramm.XI(), paramm.XJ());
    } 
    zM();
    a.e(paramm);
  }
  
  public void b(TableEntity paramTableEntity, int paramInt) {
    try {
      this.bMe.a(this.handler, 60000);
      gA(2);
      String str = paramTableEntity.Yg().xq();
      a a1 = this.bYB;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("");
      a1.a(paramTableEntity, stringBuilder.toString(), paramInt, new af(this));
      return;
    } catch (m paramTableEntity) {
      a(paramTableEntity);
      return;
    } 
  }
  
  public void b(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2, PendingFullOrderDetail paramPendingFullOrderDetail3) {
    gA(1);
    paramPendingFullOrderDetail1.bXb.bZM = paramTableEntity.Yg().Ym();
    b(this.bYB.a(paramTableEntity, paramPendingFullOrderDetail1, paramPendingFullOrderDetail2, paramPendingFullOrderDetail3));
  }
  
  public void c(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong) {
    gA(0);
    paramTableEntity.Yg().da(String.valueOf(paramLong));
    paramTableEntity.Yg().cf(paramLong);
    paramTableEntity.Yg().gz(2);
    paramTableEntity.setState(2);
    PendingFullOrderDetail.a a1 = paramPendingFullOrderDetail.bXb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    a1.orderNo = stringBuilder.toString();
    paramPendingFullOrderDetail.bXb.coE = new Date(paramLong);
    a1 = paramPendingFullOrderDetail.bXb;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.getID());
    stringBuilder.append("");
    a1.coJ = stringBuilder.toString();
    paramPendingFullOrderDetail.bXb.coM = paramTableEntity.Yg().Yl();
    paramPendingFullOrderDetail.bXb.bZF = 2;
    paramPendingFullOrderDetail.bXb.bZM = paramTableEntity.Yg().Ym();
    a(this.bYB.a(paramTableEntity, paramPendingFullOrderDetail, paramLong));
  }
  
  public void eI(boolean paramBoolean) {
    if (paramBoolean)
      try {
        gA(0);
        this.bMe.a(this.handler, 60000);
        n.a(false, new u(this));
        return;
      } catch (m m) {
        a(m);
        return;
      }  
    this.bMe.a(this.handler, 60000);
    n.a(false, new u(this));
  }
  
  public void gA(int paramInt) {
    if (this.cbc == null) {
      this.cbc = new i(this.context);
      this.cbc.setCancelable(false);
    } 
    this.cbc.setPosition(paramInt);
    if (!((Activity)this.context).isFinishing()) {
      this.cbc.show();
      if (this.cbd != null) {
        b b1 = (b)this.cbd.get();
        if (b1 != null)
          b1.accept(Boolean.valueOf(true)); 
      } 
    } 
  }
  
  public void i(s params) { a(this.bYB.e(params).a(new k(this))); }
  
  public void j(s params) { b(this.bYB.f(params).a(new n(this))); }
  
  public void n(String paramString, int paramInt) {
    try {
      gA(1);
      this.bMe.a(this.handler, 60000);
      this.bYB.b(paramString, paramInt, new ab(this));
      return;
    } catch (m paramString) {
      a(paramString);
      return;
    } 
  }
  
  public void t(long paramLong1, long paramLong2) {
    try {
      this.bMe.a(this.handler, 60000);
      gA(2);
      this.bYB.a(paramLong1, paramLong2, new y(this));
      return;
    } catch (m m) {
      a(m);
      return;
    } 
  }
  
  public void zM() {
    if (this.cbc != null && !((Activity)this.context).isFinishing()) {
      this.cbc.dismiss();
      if (this.cbd != null) {
        b b1 = (b)this.cbd.get();
        if (b1 != null)
          b1.accept(Boolean.valueOf(false)); 
      } 
    } 
    this.bMe.XV();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */