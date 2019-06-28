package com.laiqian.opentable.common.a;

import com.laiqian.entity.s;
import com.laiqian.main.bb;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.cg;
import io.reactivex.n;
import kotlin.f;
import org.json.JSONException;

public interface a {
  n<f<Boolean, PendingFullOrderDetail, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong);
  
  n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2, PendingFullOrderDetail paramPendingFullOrderDetail3);
  
  void a(long paramLong1, long paramLong2, t.i parami) throws m;
  
  void a(long paramLong1, long paramLong2, t.j paramj) throws m;
  
  void a(long paramLong, t.f paramf) throws m;
  
  void a(TableEntity paramTableEntity, int paramInt, t.f paramf) throws m;
  
  void a(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, t.k paramk) throws m;
  
  void a(TableEntity paramTableEntity, t.f paramf) throws m;
  
  void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb, t.f paramf) throws m, JSONException;
  
  void a(TableEntity paramTableEntity, String paramString, int paramInt, t.c paramc) throws m;
  
  void a(a parama, t.f paramf) throws m;
  
  void a(t.d paramd) throws m;
  
  void a(String paramString, t.e parame) throws m;
  
  void b(long paramLong, t.f paramf) throws m;
  
  void b(TableEntity paramTableEntity, t.f paramf) throws m;
  
  void b(String paramString, int paramInt, t.g paramg) throws m;
  
  void c(long paramLong, t.f paramf) throws m;
  
  n<f<Boolean, PendingFullOrderDetail, TableEntity>> e(s params);
  
  n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> f(s params);
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */