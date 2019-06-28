package com.laiqian.opentable.common.a;

import android.content.Context;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.entity.s;
import com.laiqian.main.bb;
import com.laiqian.opentable.R;
import com.laiqian.opentable.a.a;
import com.laiqian.opentable.b.q;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.ordertool.c.a;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.util.by;
import com.laiqian.util.cg;
import io.reactivex.n;
import io.reactivex.p;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.f;

public class g implements a {
  private ac bZU;
  
  private a bZV;
  
  private Context context;
  
  public g(Context paramContext, a parama) {
    this.context = paramContext;
    this.bZV = parama;
    this.bZU = new ac(paramContext, parama);
  }
  
  private boolean n(TableEntity paramTableEntity) {
    if (a.AZ().Cv()) {
      a a1 = new a(this.context);
      boolean bool = a1.a(String.valueOf(paramTableEntity.Yg().xq()), 6L, paramTableEntity.Yg().Yk());
      a1.close();
      return bool;
    } 
    return true;
  }
  
  protected Pair<Boolean, ArrayList<PendingFullOrderDetail>> a(TableEntity paramTableEntity, String paramString, int paramInt) {
    ArrayList arrayList = new ArrayList();
    try {
      exception1 = new q(this.context);
    } catch (Exception exception1) {
      a.e(exception1);
      exception1 = null;
    } 
    try {
      exception2 = new a(this.context);
    } catch (Exception exception2) {
      a.e(exception2);
      exception2 = null;
    } 
    try {
      exception1.beginTransaction();
      TableEntity tableEntity = exception1.ck(paramTableEntity.getID());
      if (tableEntity != null) {
        boolean bool;
        Pair pair1;
        if (tableEntity.getState() != 0) {
          if (tableEntity.Yh().size() == 0)
            paramInt = -1; 
          if (paramInt < 0) {
            paramTableEntity.Yc();
            if (tableEntity.Yh().size() > 0) {
              byte b = 0;
              bool = false;
              while (b < tableEntity.Yh().size()) {
                c c = (c)tableEntity.Yh().get(b);
                null = new StringBuilder();
                null.append(c.xq());
                null.append("");
                PendingFullOrderDetail pendingFullOrderDetail = exception2.kz(null.toString());
                bool = exception1.a(paramTableEntity, 3, "");
                if (bool && pendingFullOrderDetail != null) {
                  pendingFullOrderDetail.bXb.bZM = c.Ym();
                  pendingFullOrderDetail.bXb.coM = c.Yl();
                  arrayList.add(pendingFullOrderDetail);
                  bool = exception2.kj(paramString);
                } 
                if (!bool) {
                  pair1 = new Pair(Boolean.valueOf(false), null);
                  exception1.endTransaction();
                  exception2.close();
                  exception1.close();
                  return pair1;
                } 
                b++;
              } 
            } else {
              bool = exception1.a(pair1, 3, "");
            } 
          } else {
            c c = b.b(tableEntity.Yh(), paramInt);
            String str = b.d(pair1.getID(), paramInt);
            ArrayList arrayList1 = b.jd(str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tableEntity.Yg().xq());
            stringBuilder.append("");
            PendingFullOrderDetail pendingFullOrderDetail = exception2.kz(stringBuilder.toString());
            pendingFullOrderDetail.bXb.bZM = pair1.Yg().Ym();
            pendingFullOrderDetail.bXb.coM = paramInt;
            if (arrayList1.size() > 0) {
              c c1 = (c)arrayList1.get(0);
              pair1.c(c1);
              pair1.W(arrayList1);
              pair1.cf(c1.DP());
              pair1.setState(2);
            } else {
              pair1.Yc();
              str = "";
            } 
            bool = exception1.a(pair1, 3, str);
            if (bool && pendingFullOrderDetail != null) {
              pendingFullOrderDetail.bXb.bZM = c.Ym();
              arrayList.add(pendingFullOrderDetail);
              bool = exception2.kj(paramString);
            } 
          } 
        } else {
          bool = false;
        } 
        if (bool) {
          exception1.setTransactionSuccessful();
          if (b.XC()) {
            this.bZU.b(pair1, paramInt);
            if (paramInt != -1 && pair1.getState() == 2)
              b.bb(a.AZ().Ca(), 1); 
          } 
        } 
        exception1.endTransaction();
        exception2.close();
        exception1.close();
        return new Pair(Boolean.valueOf(true), arrayList);
      } 
      Pair pair = new Pair(Boolean.valueOf(false), null);
      exception1.endTransaction();
      exception2.close();
      exception1.close();
      return pair;
    } catch (Exception paramTableEntity) {
      a.e(paramTableEntity);
      Pair pair = new Pair(Boolean.valueOf(false), null);
      exception1.endTransaction();
      exception2.close();
      exception1.close();
      return pair;
    } finally {}
    exception1.endTransaction();
    exception2.close();
    exception1.close();
    throw paramTableEntity;
  }
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong) { return b(paramTableEntity, paramPendingFullOrderDetail, paramLong, this.bZU).g(new i(paramTableEntity, paramPendingFullOrderDetail)); }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2, PendingFullOrderDetail paramPendingFullOrderDetail3) { return a(paramPendingFullOrderDetail1, paramPendingFullOrderDetail2, paramPendingFullOrderDetail3).f(new k(paramTableEntity, paramPendingFullOrderDetail1)); }
  
  protected n<Pair<Boolean, PendingFullOrderDetail.c>> a(PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2, PendingFullOrderDetail paramPendingFullOrderDetail3) { return n.e(new j(this, paramPendingFullOrderDetail1, paramPendingFullOrderDetail2, paramPendingFullOrderDetail3)); }
  
  public void a(long paramLong1, long paramLong2, t.i parami) throws m {
    TableEntity tableEntity = b.a(paramLong2, this.context);
    if (tableEntity == null)
      throw new m("用id查询桌号信息失败", this.context.getString(R.string.pos_open_table_station_number)); 
    parami.g(tableEntity);
  }
  
  public void a(long paramLong1, long paramLong2, t.j paramj) throws m {
    try {
      exception = new q(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    ArrayList arrayList = exception.x(paramLong1, paramLong2);
    exception.close();
    paramj.U(arrayList);
  }
  
  public void a(long paramLong, t.f paramf) throws m {
    try {
      exception = new a(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.O(paramLong);
    String str = exception.Vn();
    exception.close();
    paramf.dp(bool);
    if (!bool)
      throw new m(str, str); 
  }
  
  public void a(TableEntity paramTableEntity, int paramInt, t.f paramf) throws m {
    try {
      exception = new q(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool2 = b.a(paramTableEntity.Yh(), paramTableEntity.Yg().Yl(), paramTableEntity.Yg());
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = exception.a(paramTableEntity, paramInt, b.Q(paramTableEntity.Yh()));
      bool2 = n(paramTableEntity);
      if (bool1 && bool2) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
    } 
    String str = exception.Vn();
    exception.close();
    if (bool1 && b.XC())
      (new ac(this.context, this.bZV)).b(paramTableEntity.getID(), paramTableEntity.Yg().Yl(), paramTableEntity.Yg().Ym(), paramTableEntity.Yb(), paramTableEntity.getState()); 
    paramf.dp(bool1);
    if (!bool1)
      throw new m(str, str); 
  }
  
  public void a(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, t.k paramk) throws m {
    if (b.a(paramTableEntity2.getID(), this.context).getState() == 2) {
      paramk.a(false, paramTableEntity1, paramTableEntity2, paramInt);
      return;
    } 
    boolean bool = c(paramTableEntity1, paramTableEntity2, paramInt);
    String str1 = new StringBuilder();
    str1.append("开始桌号ID+");
    str1.append(paramTableEntity1.getID());
    str1.append("，编号");
    str1.append(paramInt);
    str1.append(",结束桌号ID+");
    str1.append(paramTableEntity2.getID());
    String str2 = str1.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("移桌桌号");
    if (bool) {
      String str = "成功";
    } else {
      str1 = "失败";
    } 
    stringBuilder.append(str1);
    b.au(str2, stringBuilder.toString());
    paramk.a(bool, paramTableEntity1, paramTableEntity2, paramInt);
  }
  
  public void a(TableEntity paramTableEntity, t.f paramf) throws m {
    try {
      exception = new q(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.p(paramTableEntity);
    String str = exception.Vn();
    exception.close();
    paramf.dp(bool);
    if (!bool)
      throw new m(str, str); 
  }
  
  public void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb, t.f paramf) throws m {
    String str1;
    boolean bool = a(paramTableEntity, paramPendingFullOrderDetail, parambb);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("桌号ID+");
    stringBuilder1.append(paramTableEntity.getID());
    stringBuilder1.append("，编号");
    stringBuilder1.append(paramTableEntity.Yg().Yl());
    stringBuilder1.append("订单号");
    stringBuilder1.append(paramTableEntity.Yg().xq());
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("请求结算");
    if (paramPendingFullOrderDetail != null) {
      str1 = "成功";
    } else {
      str1 = "失败";
    } 
    stringBuilder2.append(str1);
    b.au(str2, stringBuilder2.toString());
    paramf.dp(bool);
  }
  
  public void a(TableEntity paramTableEntity, String paramString, int paramInt, t.c paramc) throws m {
    Pair pair = a(paramTableEntity, paramString, paramInt);
    Boolean bool = (Boolean)pair.first;
    ArrayList arrayList = (ArrayList)pair.second;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("桌号ID+");
    stringBuilder1.append(paramTableEntity.getID());
    stringBuilder1.append("，编号");
    stringBuilder1.append(paramInt);
    stringBuilder1.append("订单号");
    stringBuilder1.append(paramString);
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("请求清空桌号");
    if (bool.booleanValue()) {
      paramString = "成功";
    } else {
      paramString = "失败";
    } 
    stringBuilder2.append(paramString);
    b.au(str, stringBuilder2.toString());
    paramc.a(arrayList, paramTableEntity, bool.booleanValue());
  }
  
  public void a(a parama, t.f paramf) throws m {
    try {
      exception = new a(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.t(parama.getId(), parama.XX());
    String str = exception.Vn();
    exception.close();
    paramf.dp(bool);
    if (!bool)
      throw new m(str, str); 
  }
  
  public void a(t.d paramd) {
    try {
      exception = new a(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    ArrayList arrayList = exception.Xo();
    exception.close();
    paramd.T(arrayList);
  }
  
  public void a(String paramString, t.e parame) throws m {
    try {
      exception = new a(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.iS(paramString);
    paramString = exception.hQ("_id");
    String str = exception.Vn();
    exception.close();
    parame.d(bool, paramString);
    if (!bool)
      throw new m(str, str); 
  }
  
  protected boolean a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb) {
    TableEntity tableEntity = new TableEntity(paramTableEntity);
    try {
      a a1 = new a(this.context);
    } catch (Exception parambb) {
      a.e(parambb);
      parambb = null;
    } 
    try {
      exception = new q(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    try {
      parambb.beginTransaction();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.Yg().xq());
      stringBuilder.append("");
      if (parambb.kz(stringBuilder.toString()) != null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      boolean bool1 = bool2;
      if (bool2) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramTableEntity.Yg().xq());
        stringBuilder.append("");
        bool1 = parambb.kj(stringBuilder.toString());
      } 
      boolean bool2 = bool1;
      if (bool1) {
        String str = b.d(paramTableEntity.getID(), paramTableEntity.Yg().Yl());
        ArrayList arrayList = b.jd(str);
        if (arrayList.size() > 0) {
          c c = (c)arrayList.get(0);
          paramTableEntity.c(c);
          paramTableEntity.W(arrayList);
          paramTableEntity.cf(c.DP());
          paramTableEntity.setState(2);
        } else {
          paramTableEntity.Yc();
          tableEntity.Yc();
          str = "";
        } 
        bool2 = exception.a(paramTableEntity, 3, str);
      } 
      if (bool2) {
        parambb.setTransactionSuccessful();
        if (b.XC()) {
          this.bZU.jp(b.a(tableEntity, paramPendingFullOrderDetail, null, "3"));
          b.bb(a.AZ().Ca(), 1);
        } 
      } 
      exception.endTransaction();
      parambb.close();
      exception.close();
      return bool2;
    } catch (Exception paramTableEntity) {
      a.e(paramTableEntity);
      exception.endTransaction();
      parambb.close();
      exception.close();
      return false;
    } finally {}
    exception.endTransaction();
    parambb.close();
    exception.close();
    throw paramTableEntity;
  }
  
  protected n<f<Boolean, PendingFullOrderDetail, TableEntity>> b(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong, ac paramac) { return n.e(new h(paramTableEntity, paramPendingFullOrderDetail, paramLong, paramac)); }
  
  public void b(long paramLong, t.f paramf) throws m {
    try {
      exception = new q(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    null = new StringBuilder();
    null.append(paramLong);
    null.append("");
    boolean bool = exception.js(null.toString());
    String str = exception.Vn();
    exception.close();
    paramf.dp(bool);
    if (!bool)
      throw new m(str, str); 
  }
  
  public void b(TableEntity paramTableEntity, t.f paramf) throws m {
    try {
      exception = new q(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.q(paramTableEntity);
    String str = exception.Vn();
    exception.close();
    paramf.dp(bool);
    if (!bool)
      throw new m(str, str); 
  }
  
  public void b(String paramString, int paramInt, t.g paramg) {
    try {
      str = new a(this.context);
    } catch (Exception exception) {
      a.e(str);
      str = null;
    } 
    null = new StringBuilder();
    null.append(paramString);
    null.append("");
    PendingFullOrderDetail pendingFullOrderDetail = str.kz(null.toString());
    if (pendingFullOrderDetail != null) {
      TableEntity tableEntity = b.a(by.parseLong(pendingFullOrderDetail.bXb.bTe), this.context);
      if (tableEntity != null) {
        c c = b.b(tableEntity.Yh(), paramInt);
        if (c != null)
          pendingFullOrderDetail.bXb.bZM = c.Ym(); 
        pendingFullOrderDetail.bXb.cpd = tableEntity.getState();
      } 
      int i = pendingFullOrderDetail.bXb.bZF;
    } 
    str.close();
    StringBuilder stringBuilder = new StringBuilder();
    if (pendingFullOrderDetail != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("桌号ID+");
      stringBuilder1.append(paramString);
      String str1 = stringBuilder1.toString();
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    stringBuilder.append("，编号");
    stringBuilder.append(paramInt);
    stringBuilder.append("订单号");
    stringBuilder.append(paramString);
    String str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("请求桌号");
    if (pendingFullOrderDetail != null) {
      paramString = "成功";
    } else {
      paramString = "失败";
    } 
    stringBuilder.append(paramString);
    b.au(str, stringBuilder.toString());
    paramg.a(pendingFullOrderDetail, null, -1);
  }
  
  public void c(long paramLong, t.f paramf) throws m {
    try {
      exception = new q(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.g(new long[] { paramLong });
    exception.close();
    paramf.dp(bool);
  }
  
  protected boolean c(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) {
    String str2;
    String str1;
    String str3 = "";
    if (paramInt == -1) {
      for (c c : paramTableEntity1.Yh()) {
        if (b.XB())
          c.da(String.valueOf(paramTableEntity2.getID())); 
        c.ch(paramTableEntity2.getID());
        paramTableEntity2.Yh().add(c);
      } 
      Collections.sort(paramTableEntity2.Yh());
      if (paramTableEntity2.Yh().size() > 0)
        paramTableEntity2.c((c)paramTableEntity2.Yh().get(0)); 
      paramTableEntity2.Yg().da(paramTableEntity1.Yg().xq());
      paramTableEntity2.setState(paramTableEntity1.getState());
      paramTableEntity2.cf(paramTableEntity1.DP());
      str2 = b.Q(paramTableEntity2.Yh());
      paramTableEntity1.Yc();
      str1 = str3;
    } else {
      str1 = b.b(paramTableEntity1.Yh(), paramInt);
      paramTableEntity1.Yh().remove(str1);
      str1.gx(0);
      str1.ch(paramTableEntity2.getID());
      paramTableEntity2.setState(2);
      paramTableEntity2.cf(str1.DP());
      paramTableEntity2.Yg().da(paramTableEntity1.Yg().xq());
      paramTableEntity2.c(str1);
      paramTableEntity2.Yh().add(str1);
      String str = b.b(str1);
      if (paramTableEntity1.Yh().size() > 0) {
        String str4 = b.Q(paramTableEntity1.Yh());
        str2 = str;
      } else {
        str1 = str3;
        str2 = str;
        if (paramTableEntity1.Yh().size() == 0) {
          paramTableEntity1.Yc();
          str1 = str3;
          str2 = str;
        } 
      } 
    } 
    return b.a(paramTableEntity1, paramTableEntity2, this.context, this.bZV, str1, str2, paramInt);
  }
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> e(s params) { return null; }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> f(s params) { return null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */