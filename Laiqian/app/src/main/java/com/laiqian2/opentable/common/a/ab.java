package com.laiqian.opentable.common.a;

import android.content.Context;
import com.laiqian.entity.s;
import com.laiqian.main.bb;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.ordertool.c.a;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.bd;
import com.laiqian.util.cg;
import io.reactivex.n;
import kotlin.f;
import org.json.JSONException;

public class ab implements a {
  private a bZV;
  
  private a cav;
  
  private a caw;
  
  private a cax;
  
  private Context context;
  
  public ab(Context paramContext, a parama) {
    this.context = paramContext;
    this.bZV = parama;
  }
  
  private a Ys() {
    if (this.cav == null)
      this.cav = new g(this.context, this.bZV); 
    return this.cav;
  }
  
  public a Yr() {
    if (bd.bH(this.context) && b.XB()) {
      if (this.cax == null)
        this.cax = new l(this.context, new g(this.context, this.bZV)); 
      return this.cax;
    } 
    if (b.XD()) {
      if (this.cav == null)
        this.cav = new g(this.context, this.bZV); 
      return this.cav;
    } 
    if (this.caw == null)
      this.caw = new b(this.context); 
    return this.caw;
  }
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong) { return Yr().a(paramTableEntity, paramPendingFullOrderDetail, paramLong); }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2, PendingFullOrderDetail paramPendingFullOrderDetail3) { return Yr().a(paramTableEntity, paramPendingFullOrderDetail1, paramPendingFullOrderDetail2, paramPendingFullOrderDetail3); }
  
  public void a(long paramLong1, long paramLong2, t.i parami) throws m { Yr().a(paramLong1, paramLong2, parami); }
  
  public void a(long paramLong1, long paramLong2, t.j paramj) throws m { Yr().a(paramLong1, paramLong2, paramj); }
  
  public void a(long paramLong, t.f paramf) throws m { Ys().a(paramLong, paramf); }
  
  public void a(TableEntity paramTableEntity, int paramInt, t.f paramf) throws m { Yr().a(paramTableEntity, paramInt, paramf); }
  
  public void a(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, t.k paramk) throws m { Yr().a(paramTableEntity1, paramTableEntity2, paramInt, paramk); }
  
  public void a(TableEntity paramTableEntity, t.f paramf) throws m { Ys().a(paramTableEntity, paramf); }
  
  public void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb, t.f paramf) throws m, JSONException { Yr().a(paramTableEntity, paramPendingFullOrderDetail, parambb, paramf); }
  
  public void a(TableEntity paramTableEntity, String paramString, int paramInt, t.c paramc) throws m { Yr().a(paramTableEntity, paramString, paramInt, paramc); }
  
  public void a(a parama, t.f paramf) throws m { Ys().a(parama, paramf); }
  
  public void a(t.d paramd) throws m { Yr().a(paramd); }
  
  public void a(String paramString, t.e parame) throws m { Ys().a(paramString, parame); }
  
  public void b(long paramLong, t.f paramf) throws m { Yr().b(paramLong, paramf); }
  
  public void b(TableEntity paramTableEntity, t.f paramf) throws m { Ys().b(paramTableEntity, paramf); }
  
  public void b(String paramString, int paramInt, t.g paramg) throws m { Yr().b(paramString, paramInt, paramg); }
  
  public void c(long paramLong, t.f paramf) throws m { Ys().c(paramLong, paramf); }
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> e(s params) { return Yr().e(params); }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> f(s params) { return Yr().f(params); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */