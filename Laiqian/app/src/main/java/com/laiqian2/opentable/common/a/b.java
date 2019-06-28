package com.laiqian.opentable.common.a;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.s;
import com.laiqian.main.bb;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.connect.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.cg;
import io.reactivex.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import kotlin.f;
import org.json.JSONException;

public class b implements a {
  private boolean bZQ = true;
  
  private boolean bZR = true;
  
  private Context context;
  
  public b(Context paramContext) { this.context = paramContext; }
  
  private void Yp() {
    Timer timer = new Timer();
    timer.schedule(new f(this, timer), 30000L);
  }
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong) { return null; }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2, PendingFullOrderDetail paramPendingFullOrderDetail3) { return null; }
  
  public void a(long paramLong1, long paramLong2, t.i parami) throws m { // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload #6
    //   11: lload_1
    //   12: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload #6
    //   18: ldc ''
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #6
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokestatic jg : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: invokevirtual iterator : ()Ljava/util/Iterator;
    //   35: astore #7
    //   37: aload #7
    //   39: invokeinterface hasNext : ()Z
    //   44: ifeq -> 72
    //   47: aload #7
    //   49: invokeinterface next : ()Ljava/lang/Object;
    //   54: checkcast com/laiqian/opentable/common/entity/TableEntity
    //   57: astore #6
    //   59: aload #6
    //   61: invokevirtual getID : ()J
    //   64: lload_3
    //   65: lcmp
    //   66: ifne -> 37
    //   69: goto -> 75
    //   72: aconst_null
    //   73: astore #6
    //   75: aload #5
    //   77: aload #6
    //   79: invokeinterface g : (Lcom/laiqian/opentable/common/entity/TableEntity;)V
    //   84: return }
  
  public void a(long paramLong1, long paramLong2, t.j paramj) throws m {
    null = new StringBuilder();
    null.append(paramLong1);
    null.append("");
    ArrayList arrayList = n.jg(null.toString());
    if (arrayList != null) {
      byte b1;
      for (b1 = 0; b1 < arrayList.size(); b1++) {
        boolean bool = true;
        if (paramLong2 > 0L && ((TableEntity)arrayList.get(b1)).getID() == paramLong2) {
          ((TableEntity)arrayList.get(b1)).eE(true);
          break;
        } 
        TableEntity tableEntity = (TableEntity)arrayList.get(b1);
        if (b.cc(((TableEntity)arrayList.get(b1)).getID()) == null)
          bool = false; 
        tableEntity.eG(bool);
      } 
    } 
    paramj.U(arrayList);
  }
  
  public void a(long paramLong, t.f paramf) throws m {}
  
  public void a(TableEntity paramTableEntity, int paramInt, t.f paramf) throws m { b.a(this.context, paramTableEntity, new c(this, paramf)); }
  
  public void a(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, t.k paramk) throws m {
    paramTableEntity1.Yc();
    null = new av(this.context);
    String str1 = null.atm();
    String str2 = null.Tx();
    null.close();
    PendingFullOrderDetail pendingFullOrderDetail = new PendingFullOrderDetail();
    pendingFullOrderDetail.bXb.bZF = 2;
    pendingFullOrderDetail.bXb.aEI = by.parseLong(str1);
    pendingFullOrderDetail.bXb.bJc = by.parseLong(str2);
    try {
      str1 = b.a(paramTableEntity2, pendingFullOrderDetail, null, "1");
      if (this.bZR) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("移桌桌号,开始桌号ID+");
        stringBuilder.append(paramTableEntity1.getID());
        stringBuilder.append("，编号");
        stringBuilder.append(paramInt);
        stringBuilder.append(",结束桌号ID+");
        stringBuilder.append(paramTableEntity2.getID());
        b.je(stringBuilder.toString());
        b.a(this.context, str1, paramTableEntity2, paramTableEntity1, paramInt, new d(this, paramk));
        return;
      } 
      b.a(this.context, str1, paramTableEntity2, paramTableEntity1, paramInt, null);
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
        paramTableEntity1.Yc();
      } else {
        c c = b.b(paramTableEntity1.Yh(), paramInt);
        if (c != null) {
          c.gx(0);
          paramTableEntity2.c(c);
          paramTableEntity2.Yh().add(c);
          paramTableEntity2.setState(c.Yn());
          paramTableEntity2.cf(c.DP());
        } 
        b.c(paramTableEntity1.Yh(), paramInt);
        if (paramTableEntity1.Yh().size() == 0) {
          paramTableEntity1.Yc();
        } else {
          Collections.sort(paramTableEntity1.Yh());
          paramTableEntity1.c((c)paramTableEntity1.Yh().get(0));
          paramTableEntity1.cf(paramTableEntity1.Yg().DP());
        } 
      } 
      n.k(paramTableEntity1.Yc());
      n.k(paramTableEntity2);
      paramk.a(true, paramTableEntity1, paramTableEntity2, paramInt);
      return;
    } catch (JSONException paramTableEntity1) {
      a.e(paramTableEntity1);
      return;
    } 
  }
  
  public void a(TableEntity paramTableEntity, t.f paramf) throws m {}
  
  public void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb, t.f paramf) throws m, JSONException {
    try {
      paramTableEntity.setState(0);
      paramPendingFullOrderDetail.bXb.aEI = by.parseLong(RootApplication.getLaiqianPreferenceManager().atm());
      String str = b.a(paramTableEntity, paramPendingFullOrderDetail, "2");
      if (this.bZR) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请求结算,桌号ID+");
        stringBuilder.append(paramTableEntity.getID());
        stringBuilder.append("，编号");
        stringBuilder.append(paramTableEntity.Yg().Yl());
        stringBuilder.append("订单号");
        stringBuilder.append(paramTableEntity.Yg().xq());
        b.je(stringBuilder.toString());
        b.a(this.context, str, paramTableEntity, paramPendingFullOrderDetail, new e(this, paramTableEntity, paramPendingFullOrderDetail, paramf));
        return;
      } 
      b.a(this.context, str, paramTableEntity, paramPendingFullOrderDetail, null);
      if (b.c(paramTableEntity.Yh(), paramPendingFullOrderDetail.bXb.coM)) {
        if (paramTableEntity.Yh().size() == 0) {
          paramTableEntity.Yc();
        } else {
          paramTableEntity.setState(2);
          Collections.sort(paramTableEntity.Yh());
          paramTableEntity.c((c)paramTableEntity.Yh().get(0));
        } 
      } else {
        paramTableEntity.Yc();
      } 
      n.k(paramTableEntity);
      paramf.dp(true);
      Yp();
      return;
    } catch (Exception paramTableEntity) {
      a.e(paramTableEntity);
      return;
    } 
  }
  
  public void a(TableEntity paramTableEntity, String paramString, int paramInt, t.c paramc) throws m {}
  
  public void a(a parama, t.f paramf) throws m {}
  
  public void a(t.d paramd) throws m { paramd.T(n.Xo()); }
  
  public void a(String paramString, t.e parame) throws m {}
  
  public void b(long paramLong, t.f paramf) throws m {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    ArrayList arrayList = n.jg(stringBuilder.toString());
    if (arrayList != null && arrayList.size() > 0) {
      paramf.dp(true);
      return;
    } 
    paramf.dp(false);
  }
  
  public void b(TableEntity paramTableEntity, t.f paramf) throws m {}
  
  public void b(String paramString, int paramInt, t.g paramg) throws m { b.a(this.context, paramString, paramg); }
  
  public void c(long paramLong, t.f paramf) throws m {}
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> e(s params) { return null; }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> f(s params) { return null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */