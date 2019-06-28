package com.laiqian.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.laiqian.backup.ag;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.entity.c;
import com.laiqian.entity.u;
import com.laiqian.f;
import com.laiqian.main.module.hardware.weight.c;
import com.laiqian.main.module.hardware.weight.h;
import com.laiqian.main.module.productcart.am;
import com.laiqian.member.setting.bc;
import com.laiqian.message.d;
import com.laiqian.message.m;
import com.laiqian.models.ba;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.m;
import com.laiqian.pos.hardware.b;
import com.laiqian.pos.hardware.c;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.hold.e;
import com.laiqian.pos.model.a;
import com.laiqian.pos.model.orders.WeiOrderDetail;
import com.laiqian.print.c.a;
import com.laiqian.print.c.d;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.delivery.model.a;
import com.laiqian.print.usage.kitchen.a.a;
import com.laiqian.product.a.a;
import com.laiqian.product.a.b;
import com.laiqian.product.a.d;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.a;
import com.laiqian.product.models.c;
import com.laiqian.product.models.f;
import com.laiqian.product.models.h;
import com.laiqian.report.onlinepay.u;
import com.laiqian.rx.a.a.a;
import com.laiqian.rx.a.b.a;
import com.laiqian.rx.util.a;
import com.laiqian.util.bd;
import com.laiqian.util.k;
import com.laiqian.util.n;
import com.laiqian.wallet.k;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressLint({"CheckResult"})
public class dl {
  private static final String TAG = "dl";
  
  public static final PendingFullOrderDetail.a ben = new PendingFullOrderDetail.a();
  
  public static final ProductTypeEntity beo = new ProductTypeEntity(0L, "", "", false);
  
  @NonNull
  private final Resources anu;
  
  public final a<ProductTypeEntity> bdH = a.R(new ArrayList());
  
  public final b<ProductTypeEntity> bdI = b.wJ();
  
  public final a<Long> bdJ = a.R(new ArrayList());
  
  public final b<fh.b> bdK;
  
  public final b<c> bdL;
  
  public final b<aq> bdM;
  
  public final b<Boolean> bdN;
  
  public final b<Boolean> bdO;
  
  public final b<Boolean> bdP;
  
  public final b<PendingFullOrderDetail.a> bdQ;
  
  public final b<c> bdR;
  
  public final b<Integer> bdS;
  
  public final b<Boolean> bdT;
  
  public final b<Boolean> bdU;
  
  public final b<Boolean> bdV;
  
  public final b<Boolean> bdW;
  
  public final b<Boolean> bdX;
  
  @NonNull
  private final a bdY;
  
  @NonNull
  private final f bdZ;
  
  public final e bea;
  
  public final b<Integer> beb;
  
  public final b<b> bec;
  
  public final b<Integer> bed;
  
  public final b<Boolean> bee;
  
  public final b<Boolean> bef;
  
  public final b<TableEntity> beg;
  
  public final b<String> beh;
  
  public final b<Boolean> bei;
  
  public b<PendingFullOrderDetail> bej;
  
  public final b<String> bek = (this.bej = (this.bei = (this.beh = (this.beg = (this.bef = (this.bee = (this.bed = (this.bec = (this.beb = (this.bdX = (this.bdW = (this.bdV = (this.bdU = (this.bdT = (this.bdS = (this.bdR = (this.bdQ = (this.bdP = (this.bdO = (this.bdN = (this.bdM = (this.bdL = (this.bdK = b.wJ()).wJ()).ak(aq.aWG)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).wJ()).ak(ben)).wJ()).ak(Integer.valueOf(1))).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Integer.valueOf(0))).ak(b.beE)).ak(Integer.valueOf(a.AZ().Ca()))).ak(Boolean.valueOf(a.AZ().Bk()))).ak(Boolean.valueOf(false))).ak(TableEntity.bZK)).ak("")).ak(Boolean.FALSE)).wJ()).ak("");
  
  public final c bel = new c();
  
  public final a bem = new a();
  
  @NonNull
  private final Context context;
  
  dl(@NonNull Context paramContext) {
    this.context = paramContext;
    this.bdY = new a(paramContext);
    this.bdZ = new f(paramContext);
    this.anu = paramContext.getResources();
    this.bea = new e(this, this.bdZ);
    this.bea.beZ.b(new dm(this));
    this.bdS.b(new dn(this));
    h.a(this.bdS, this.bdO, this.bdM, dy.bes).b(new ea(this));
    this.bdN.b(new eb(this));
    this.bdR.b(ec.aEp);
    this.bea.beU.j(100L, TimeUnit.MILLISECONDS).b(ed.aEp);
    LS();
    LR();
    LQ();
    LP();
  }
  
  private void LP() { h.a(ee.bet).d(a.aKh()).d(a.aJo()).aJk(); }
  
  private void LQ() {
    if (a.zR().Ak()) {
      f.a(RootApplication.zv(), new eh(this));
      return;
    } 
    a.aKh().r(ef.baQ);
  }
  
  private void LR() { // Byte code:
    //   0: new com/laiqian/models/be
    //   3: dup
    //   4: aload_0
    //   5: getfield context : Landroid/content/Context;
    //   8: invokespecial <init> : (Landroid/content/Context;)V
    //   11: astore_1
    //   12: aload_1
    //   13: astore_2
    //   14: aload_1
    //   15: invokestatic currentTimeMillis : ()J
    //   18: ldc2_w 86400000
    //   21: lsub
    //   22: invokestatic currentTimeMillis : ()J
    //   25: invokevirtual r : (JJ)Landroid/database/sqlite/SQLiteDatabase;
    //   28: pop
    //   29: aload_1
    //   30: ifnull -> 63
    //   33: goto -> 59
    //   36: astore_3
    //   37: goto -> 49
    //   40: astore_1
    //   41: aconst_null
    //   42: astore_2
    //   43: goto -> 121
    //   46: astore_3
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_3
    //   52: invokestatic e : (Ljava/lang/Throwable;)V
    //   55: aload_1
    //   56: ifnull -> 63
    //   59: aload_1
    //   60: invokevirtual close : ()V
    //   63: ldc2_w 2
    //   66: getstatic java/util/concurrent/TimeUnit.HOURS : Ljava/util/concurrent/TimeUnit;
    //   69: invokestatic e : (JLjava/util/concurrent/TimeUnit;)Lio/reactivex/h;
    //   72: new com/laiqian/main/eg
    //   75: dup
    //   76: aload_0
    //   77: invokespecial <init> : (Lcom/laiqian/main/dl;)V
    //   80: invokevirtual a : (Lio/reactivex/c/o;)Lio/reactivex/h;
    //   83: new com/laiqian/main/do
    //   86: dup
    //   87: aload_0
    //   88: invokespecial <init> : (Lcom/laiqian/main/dl;)V
    //   91: invokevirtual d : (Lio/reactivex/c/h;)Lio/reactivex/h;
    //   94: invokestatic aKh : ()Lio/reactivex/m;
    //   97: invokevirtual d : (Lio/reactivex/m;)Lio/reactivex/h;
    //   100: invokestatic aJo : ()Lio/reactivex/m;
    //   103: invokevirtual c : (Lio/reactivex/m;)Lio/reactivex/h;
    //   106: getstatic com/laiqian/main/dp.aEo : Lio/reactivex/c/o;
    //   109: invokevirtual a : (Lio/reactivex/c/o;)Lio/reactivex/h;
    //   112: getstatic com/laiqian/main/dq.aEp : Lio/reactivex/c/g;
    //   115: invokevirtual b : (Lio/reactivex/c/g;)Lio/reactivex/a/b;
    //   118: pop
    //   119: return
    //   120: astore_1
    //   121: aload_2
    //   122: ifnull -> 129
    //   125: aload_2
    //   126: invokevirtual close : ()V
    //   129: aload_1
    //   130: athrow
    // Exception table:
    //   from	to	target	type
    //   0	12	46	java/lang/Exception
    //   0	12	40	finally
    //   14	29	36	java/lang/Exception
    //   14	29	120	finally
    //   51	55	120	finally }
  
  private void LS() {
    boolean bool;
    String str = RootApplication.getLaiqianPreferenceManager().Tx();
    if (!TextUtils.isEmpty(str)) {
      bool = Integer.parseInt(str) % 3600;
    } else {
      bool = false;
    } 
    long l1 = System.currentTimeMillis();
    l1 = TimeUnit.MILLISECONDS.toSeconds(l1);
    long l2 = 'ฐ';
    l1 %= l2;
    long l3 = bool;
    if (l1 > l3) {
      l1 = l2 - l1 + l3;
    } else {
      l1 = l3 - l1;
    } 
    h.b(l1, l2, TimeUnit.SECONDS).a(new dr(this)).d(new ds(this)).d(a.aKh()).c(a.aJo()).a(dt.aEo).b(this.bek);
    h.b(l1, l2, TimeUnit.SECONDS).d(du.beq).d(a.aKh()).c(a.aJo()).a(dv.aEo).aJk();
    m.h(a.bap);
    a.bap.a(new dw(this));
    m.d(a.bap);
  }
  
  private ArrayList<aa> g(Collection<aa> paramCollection) {
    ArrayList arrayList = new ArrayList();
    if (((Boolean)this.bdN.getValue()).booleanValue()) {
      for (aa aa : paramCollection) {
        aa.r(aa.akI());
        arrayList.add(aa);
      } 
    } else {
      arrayList.addAll(paramCollection);
    } 
    return arrayList;
  }
  
  public void LT() {
    if (a.AZ().Bk()) {
      this.bea.beM.accept("86003");
      return;
    } 
    this.bea.beM.accept(u.an(a.AZ().Co()));
  }
  
  void LU() {
    boolean bool = a.AZ().Bx() ^ true;
    if (!((Boolean)this.bdO.getValue()).equals(Boolean.valueOf(bool)))
      this.bdO.accept(Boolean.valueOf(bool)); 
  }
  
  public void LV() { LY(); }
  
  public void LW() {
    if (this.bdI.getValue() != null)
      this.bdI.accept(this.bdI.getValue()); 
  }
  
  public void LX() {
    if (((Integer)this.bdS.getValue()).intValue() != 2)
      this.bdS.accept(Integer.valueOf(2)); 
  }
  
  public void LY() {
    if (((Integer)this.bdS.getValue()).intValue() != 1)
      this.bdS.accept(Integer.valueOf(1)); 
  }
  
  public void LZ() {
    if (((Integer)this.bdS.getValue()).intValue() != 4)
      this.bdS.accept(Integer.valueOf(4)); 
  }
  
  public void Ma() {
    if (((Integer)this.bdS.getValue()).intValue() != 5)
      this.bdS.accept(Integer.valueOf(5)); 
  }
  
  public void Mb() {
    if (((Integer)this.bdS.getValue()).equals(Integer.valueOf(4))) {
      if (((Boolean)this.bee.getValue()).booleanValue()) {
        Ma();
        return;
      } 
      LY();
      return;
    } 
    LZ();
  }
  
  void a(fh.b paramb) {
    if (!paramb.equals(this.bdK.getValue()))
      this.bdK.accept(paramb); 
  }
  
  public void a(@NonNull PendingFullOrderDetail.a parama) {
    if (!parama.equals(this.bdQ.getValue()))
      this.bdQ.accept(parama); 
  }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail) {
    boolean bool;
    int i;
    null = new ArrayList(this.bea.beP.aoL());
    if (this.bdQ.getValue() == ben) {
      i = -1;
    } else {
      i = ((PendingFullOrderDetail.a)this.bdQ.getValue()).bZF;
    } 
    null = PendingFullOrderDetail.d(null, i);
    a a1 = new a(this.context);
    PendingFullOrderDetail pendingFullOrderDetail = a1.ky(paramPendingFullOrderDetail.bXb.orderNo);
    if (pendingFullOrderDetail == null) {
      this.bel.beK.accept(this.context.getString(2131626779));
      return;
    } 
    PendingFullOrderDetail.c c1 = a1.a(a1.a(paramPendingFullOrderDetail, null));
    if (!c1.cpg.isEmpty()) {
      bool = a1.b(c1, pendingFullOrderDetail.bXb);
    } else {
      bool = true;
    } 
    a1.close();
    LT();
    if (!bool) {
      if (paramPendingFullOrderDetail.bXb.bZF == 0) {
        this.bel.beK.accept(this.context.getString(2131626779));
        return;
      } 
    } else {
      this.bdM.accept(aq.aWG);
      if (paramPendingFullOrderDetail.bXb.bZF == 0 && (this.bdQ.getValue() == null || ((PendingFullOrderDetail.a)this.bdQ.getValue()).bZF != 1)) {
        this.bel.beK.accept(this.context.getString(2131626783));
      } else if (paramPendingFullOrderDetail.bXb.bZF == 1) {
        n.eP(2131626270);
      } else if (paramPendingFullOrderDetail.bXb.bZF != 2 && paramPendingFullOrderDetail.bXb.bZF == 0 && this.bdQ.getValue() != null && ((PendingFullOrderDetail.a)this.bdQ.getValue()).bZF == 1) {
        this.bel.beK.accept(this.context.getString(2131626739));
      } 
      this.bea.Mi();
      LY();
      if (this.bdQ.getValue() != null)
        i = ((PendingFullOrderDetail.a)this.bdQ.getValue()).bZF; 
      m.a(this.context, paramPendingFullOrderDetail, c1, a.AZ().Bk());
    } 
  }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, ArrayList<aa> paramArrayList, long paramLong) {
    a a1 = new a(this.context);
    boolean bool = a1.a(paramPendingFullOrderDetail, paramLong);
    a1.close();
    LT();
    if (!bool) {
      this.bel.beK.accept(this.context.getString(2131626779));
      return;
    } 
    if (paramPendingFullOrderDetail.bXb.bZF == 0) {
      this.bel.beK.accept(this.context.getString(2131626783));
    } else {
      if (paramPendingFullOrderDetail.bXb.bZF == 1) {
        e.aU(this.context).play();
        this.bdM.accept(aq.aWG);
        n.eP(2131626270);
        WeiOrderDetail weiOrderDetail = e(paramArrayList, paramPendingFullOrderDetail.bXb.coS);
        a a2 = a.bm(this.context);
        for (s s : a2.getPrinters()) {
          ArrayList arrayList = a2.a(weiOrderDetail, s.getIdentifier());
          if (arrayList != null) {
            e e1 = g.cGS.f(s).D(arrayList);
            e1.a(new dx(this, e1));
            g.cGS.print(e1);
          } 
        } 
        a.bk(this.context).am(a.bk(this.context).r(paramPendingFullOrderDetail));
        this.bea.Mi();
        LY();
        return;
      } 
      if (paramPendingFullOrderDetail.bXb.bZF == 2)
        n.eP(2131626884); 
    } 
    this.bea.Mi();
    LY();
    this.bdM.accept(aq.aWG);
    m.a(this.context, paramPendingFullOrderDetail, ((Boolean)this.bee.getValue()).booleanValue());
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2) {
    int i;
    if (!"86003".equals(this.bea.beM.getValue()))
      this.bea.beM.accept("86003"); 
    ArrayList arrayList = g(this.bea.beO.aoL());
    if (this.bdQ.getValue() == ben) {
      i = -1;
    } else {
      i = ((PendingFullOrderDetail.a)this.bdQ.getValue()).bZF;
    } 
    PendingFullOrderDetail pendingFullOrderDetail = PendingFullOrderDetail.d(arrayList, i);
    PendingFullOrderDetail.a a1 = pendingFullOrderDetail.bXb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    a1.orderNo = stringBuilder.toString();
    pendingFullOrderDetail.bXb.bZF = 0;
    a1 = pendingFullOrderDetail.bXb;
    if (paramBoolean) {
      l = 1L;
    } else {
      l = 0L;
    } 
    a1.aVN = l;
    pendingFullOrderDetail.bXb.coN = paramString2;
    long l = System.currentTimeMillis();
    pendingFullOrderDetail.bXb.coJ = paramString1;
    a(pendingFullOrderDetail, null, l);
  }
  
  public void ab(double paramDouble) {
    if (c.MD().ME() == null) {
      this.bel.beK.accept(this.context.getString(2131626284));
      return;
    } 
    Double double = c.MD().MK();
    if (double != null && double.doubleValue() > 0.0D) {
      if (paramDouble <= 0.0D) {
        this.bea.af(double.doubleValue());
        return;
      } 
      this.bea.af(Math.ceil(double.doubleValue() / paramDouble));
    } 
  }
  
  public void aw(Context paramContext) {
    aa aa = this.bea.Me();
    if (aa != null && (a.AZ().BF() || a.AZ().BE()) && a.AZ().Cs()) {
      h h = new h(paramContext);
      h.a(new dz(this));
      if (h.MN() < 0.0D) {
        h.cm(aa.getName());
        return;
      } 
      ab(h.MN());
      return;
    } 
    ab(-1.0D);
  }
  
  public void b(h paramh) {
    long l;
    if (paramh.cUN) {
      l = 600002L;
    } else {
      l = 600001L;
    } 
    h h1 = h.c(new ei(this, paramh)).d(a.aKh()).aJj();
    h1.d(new ej(this, paramh, l)).a(a.aJv(), a.dhG);
    h1.a(new ek(this), new el(this));
    h1.c(new en(this)).c(a.aJo()).a(this.bel.beK, new em(this));
  }
  
  public void c(aq paramaq) {
    if (!((aq)this.bdM.getValue()).equals(paramaq))
      this.bdM.accept(paramaq); 
  }
  
  public void c(ProductTypeEntity paramProductTypeEntity) {
    if (!paramProductTypeEntity.equals(this.bdI.getValue()))
      this.bdI.accept(paramProductTypeEntity); 
  }
  
  public WeiOrderDetail e(ArrayList<aa> paramArrayList, String paramString) {
    WeiOrderDetail weiOrderDetail = new WeiOrderDetail();
    weiOrderDetail.type = 5;
    weiOrderDetail.cyZ = false;
    weiOrderDetail.czm = paramString;
    weiOrderDetail.cza = new Date();
    weiOrderDetail.czc = ((c)this.bdL.getValue()).aTp;
    String str = new StringBuilder();
    str.append(((c)this.bdL.getValue()).aRu);
    str.append(" ");
    str.append(((c)this.bdL.getValue()).address);
    str.append(" ");
    str.append(((c)this.bdL.getValue()).aRv);
    weiOrderDetail.address = str.toString();
    weiOrderDetail.cyH = (Double)this.bea.beU.getValue();
    weiOrderDetail.aWa = false;
    weiOrderDetail.paytype = 3;
    weiOrderDetail.discountAmount = 0.0D;
    if (n.bc(((c)this.bdL.getValue()).aRw)) {
      str = new StringBuilder();
      str.append(((c)this.bdL.getValue()).name);
      str.append(" ");
      str.append(this.context.getString(2131630024));
      String str1 = str.toString();
    } else {
      str = new StringBuilder();
      str.append(((c)this.bdL.getValue()).name);
      str.append(" ");
      str.append(this.context.getString(2131630023));
      str = str.toString();
    } 
    weiOrderDetail.aVX = str;
    for (aa aa : paramArrayList) {
      HashMap hashMap = new HashMap();
      hashMap.put("sProductName", aa.name);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(aa.Gw());
      stringBuilder.append("");
      hashMap.put("nProductQty", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(aa.Gz());
      stringBuilder.append("");
      hashMap.put("fPrice", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(aa.GA());
      stringBuilder.append("");
      hashMap.put("fAmount", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(aa.akI());
      stringBuilder.append("");
      hashMap.put("fOriginalPrice", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(aa.AL());
      stringBuilder.append("");
      hashMap.put("nProductType", stringBuilder.toString());
      hashMap.put("taste", aa.GM().toString());
      weiOrderDetail.bJf.add(hashMap);
    } 
    return weiOrderDetail;
  }
  
  public void n(List<Long> paramList) { this.bdJ.r(paramList); }
  
  public static class a {
    public final c<Object> beA;
    
    public final c<Object> beB;
    
    public final c<Object> beC;
    
    public final c<Object> beD = (this.beC = (this.beB = (this.beA = (this.bez = (this.bey = (this.bex = c.wO()).wO()).wO()).wO()).wO()).wO()).wO();
    
    public final c<Object> bex;
    
    public final c<Object> bey;
    
    public final c<Object> bez;
  }
  
  public enum b {
    beE, beF;
  }
  
  public static class c {
    public final c<Object> beH;
    
    public final c<dl.d> beI;
    
    public final c<KeyEvent> beJ;
    
    public final c<String> beK = (this.beJ = (this.beI = (this.beH = c.wO()).wO()).wO()).wO();
  }
  
  public static class d {
    public boolean bdu;
    
    public bb beL;
    
    public d(bb param1bb, boolean param1Boolean) {
      this.beL = param1bb;
      this.bdu = param1Boolean;
    }
  }
  
  public class e {
    private final f bdZ;
    
    public final b<String> beM = b.ak("");
    
    public final a<am.a> beN;
    
    public final a<aa> beO;
    
    public final a<aa> beP = (this.beO = (this.beN = a.R(new ArrayList())).R(new ArrayList())).R(new ArrayList());
    
    public final b<a> beQ;
    
    public final b<Boolean> beR;
    
    public b<Double> beS;
    
    public b<Double> beT;
    
    public b<Double> beU;
    
    public b<Double> beV;
    
    public final b<Integer> beW;
    
    public final b<Integer> beX;
    
    public final b<Integer> beY;
    
    public final b<Boolean> beZ;
    
    public final b<Boolean> bfa = (this.beZ = (this.beY = (this.beX = (this.beW = (this.beV = (this.beU = (this.beT = (this.beS = (this.beR = (this.beQ = b.wJ()).ak(Boolean.FALSE)).wJ()).ak(Double.valueOf(100.0D))).wJ()).ak(Double.valueOf(0.0D))).ak(Integer.valueOf(-1))).ak(Integer.valueOf(-1))).ak(Integer.valueOf(0))).ak(Boolean.TRUE)).ak(Boolean.FALSE);
    
    public e(dl this$0, f param1f) {
      this.bdZ = param1f;
      this.beN.d(new et(this, this$0)).b(this.beO);
      this.beN.b(new ey(this, this$0));
      this.beQ.b(new ez(this, this$0));
      this.beY.b(new fa(this, this$0));
      this.beO.d(a.aoE()).b(this.beS);
      h.a(this.beS, this.beT, new fb(this, this$0)).aJh().b(this.beU);
      this.beO.d(a.aoG()).aJh().b(this.beZ);
      h h = this.beZ.a(new fc(this, this$0));
      h.b(new fd(this, this$0));
      h.b(new fe(this, this$0));
      Mf();
    }
    
    private void a(List<aa> param1List, int param1Int, double param1Double) {
      aa aa = (aa)param1List.get(param1Int);
      aa.q(param1Double);
      aa.GD();
      if (aa.akN())
        while (true) {
          if (++param1Int < param1List.size()) {
            aa = (aa)param1List.get(param1Int);
            if (aa.akO()) {
              aa.q(param1Double);
              aa.GD();
              continue;
            } 
          } 
          break;
        }  
    }
    
    private void a(List<am.a> param1List, int param1Int, double param1Double, boolean param1Boolean) {
      am.a a1 = (am.a)param1List.get(param1Int);
      if (a1 instanceof am.a.a) {
        aa aa = ((am.a.a)a1).bjo;
        aa.q(param1Double);
        aa.cR(param1Boolean);
        aa.GD();
        if (aa.akN())
          while (true) {
            if (++param1Int < param1List.size()) {
              am.a a2 = (am.a)param1List.get(param1Int);
              if (a2 instanceof am.a.a) {
                am.a.a a3 = (am.a.a)a2;
                if (a3.bjo.akO()) {
                  aa aa1 = a3.bjo;
                  aa1.q(param1Double);
                  aa1.cR(param1Boolean);
                  aa1.GD();
                  continue;
                } 
              } 
            } 
            break;
          }  
      } 
    }
    
    private void a(List<aa> param1List, aa param1aa, boolean param1Boolean) {
      for (aa aa1 : param1List) {
        if (param1aa.Ly() > 0L && aa1.Ly() == param1aa.Ly() && aa1.getID() == param1aa.getID() && aa1.Gr() == param1aa.Gr())
          aa1.cS(param1Boolean); 
      } 
    }
    
    private void a(List<am.a> param1List, h param1h) {
      aa aa;
      if (param1h instanceof aa) {
        aa = (aa)param1h;
      } else {
        aa = new aa(param1h, (a)this.beQ.getValue());
      } 
      if (((Boolean)this.beu.bdN.getValue()).booleanValue())
        aa.r(aa.akK()); 
      if (aa.aSW == 6L) {
        aa.cT(false);
      } else {
        aa.cT(this.beu.bdJ.aoL().contains(Long.valueOf(param1h.AL())));
      } 
      if (dl.b(this.beu).getBoolean(2131034127) && !aa.GN()) {
        ba ba = new ba(dl.a(this.beu));
        aa.o(ba.s(aa.aSW, (String)this.beM.getValue()));
        ba.close();
      } 
      aa.GD();
      am.a.a a1 = new am.a.a(aa);
      if (((Boolean)this.beR.getValue()).booleanValue()) {
        am.a.a a2 = (am.a.a)k.a(param1List, a1, new ew(this));
        if (a2 != null) {
          a2.bjo.q(a2.bjo.Gw() + aa.Gw());
          a2.bjo.GD();
          return;
        } 
        param1List.add(a1);
        return;
      } 
      param1List.add(a1);
    }
    
    private void b(List<am.a> param1List, int param1Int, double param1Double) {
      am.a a1 = (am.a)param1List.get(param1Int);
      if (a1 instanceof am.a.a) {
        aa aa = ((am.a.a)a1).bjo;
        aa.q(param1Double);
        aa.GD();
        if (aa.akN())
          while (true) {
            if (++param1Int < param1List.size()) {
              am.a a2 = (am.a)param1List.get(param1Int);
              if (a2 instanceof am.a.a) {
                am.a.a a3 = (am.a.a)a2;
                if (a3.bjo.akO()) {
                  aa aa1 = a3.bjo;
                  aa1.q(param1Double);
                  aa1.GD();
                  continue;
                } 
              } 
            } 
            break;
          }  
      } 
    }
    
    private void c(List<am.a> param1List, int param1Int) { // Byte code:
      //   0: aload_1
      //   1: invokeinterface iterator : ()Ljava/util/Iterator;
      //   6: astore #6
      //   8: iconst_0
      //   9: istore #5
      //   11: iconst_0
      //   12: istore #4
      //   14: iload #5
      //   16: istore_3
      //   17: aload #6
      //   19: invokeinterface hasNext : ()Z
      //   24: ifeq -> 150
      //   27: iload #4
      //   29: iload_2
      //   30: if_icmpge -> 44
      //   33: aload #6
      //   35: invokeinterface next : ()Ljava/lang/Object;
      //   40: pop
      //   41: goto -> 141
      //   44: iload #4
      //   46: iload_2
      //   47: if_icmpne -> 97
      //   50: aload #6
      //   52: invokeinterface next : ()Ljava/lang/Object;
      //   57: checkcast com/laiqian/main/module/productcart/am$a
      //   60: astore #7
      //   62: aload #7
      //   64: instanceof com/laiqian/main/module/productcart/am$a$a
      //   67: ifeq -> 141
      //   70: aload #6
      //   72: invokeinterface remove : ()V
      //   77: aload #7
      //   79: checkcast com/laiqian/main/module/productcart/am$a$a
      //   82: getfield bjo : Lcom/laiqian/entity/aa;
      //   85: invokevirtual akN : ()Z
      //   88: ifne -> 141
      //   91: iload #5
      //   93: istore_3
      //   94: goto -> 150
      //   97: aload #6
      //   99: invokeinterface next : ()Ljava/lang/Object;
      //   104: checkcast com/laiqian/main/module/productcart/am$a
      //   107: astore #7
      //   109: aload #7
      //   111: instanceof com/laiqian/main/module/productcart/am$a$a
      //   114: ifeq -> 141
      //   117: iload #5
      //   119: istore_3
      //   120: aload #7
      //   122: checkcast com/laiqian/main/module/productcart/am$a$a
      //   125: getfield bjo : Lcom/laiqian/entity/aa;
      //   128: invokevirtual akO : ()Z
      //   131: ifeq -> 150
      //   134: aload #6
      //   136: invokeinterface remove : ()V
      //   141: iload #4
      //   143: iconst_1
      //   144: iadd
      //   145: istore #4
      //   147: goto -> 14
      //   150: iload_3
      //   151: aload_1
      //   152: invokeinterface size : ()I
      //   157: if_icmpge -> 229
      //   160: iload_3
      //   161: istore_2
      //   162: aload_1
      //   163: iload_3
      //   164: invokeinterface get : (I)Ljava/lang/Object;
      //   169: checkcast com/laiqian/main/module/productcart/am$a
      //   172: instanceof com/laiqian/main/module/productcart/am$a$b
      //   175: ifeq -> 222
      //   178: iload_3
      //   179: iconst_1
      //   180: iadd
      //   181: istore #4
      //   183: iload #4
      //   185: aload_1
      //   186: invokeinterface size : ()I
      //   191: if_icmpge -> 210
      //   194: iload_3
      //   195: istore_2
      //   196: aload_1
      //   197: iload #4
      //   199: invokeinterface get : (I)Ljava/lang/Object;
      //   204: instanceof com/laiqian/main/module/productcart/am$a$a
      //   207: ifne -> 222
      //   210: aload_1
      //   211: iload_3
      //   212: invokeinterface remove : (I)Ljava/lang/Object;
      //   217: pop
      //   218: iload_3
      //   219: iconst_1
      //   220: isub
      //   221: istore_2
      //   222: iload_2
      //   223: iconst_1
      //   224: iadd
      //   225: istore_3
      //   226: goto -> 150
      //   229: return }
    
    @Nullable
    public aa Me() {
      Integer integer = (Integer)this.beW.getValue();
      List list = this.beN.aoL();
      if (integer.intValue() >= 0 && integer.intValue() < list.size()) {
        am.a a1 = (am.a)list.get(integer.intValue());
        if (a1 instanceof am.a.a)
          return ((am.a.a)a1).bjo; 
      } 
      return null;
    }
    
    public void Mf() { (new d()).a(new d.a()).g(new ff(this)).b(this.beQ); }
    
    public void Mg() {
      boolean bool = a.AZ().Cq();
      if (((Boolean)this.beR.getValue()).booleanValue() != bool)
        this.beR.accept(Boolean.valueOf(bool)); 
    }
    
    public void Mh() { eR(((Integer)this.beW.getValue()).intValue()); }
    
    public void Mi() {
      if (this.beN.aoL().size() != 0)
        this.beN.r(Collections.emptyList()); 
    }
    
    public void Mj() {
      if (this.beP.aoL().size() > 0)
        this.beP.r(new ArrayList()); 
    }
    
    public void Mk() { this.beN.r(this.beN.aoL()); }
    
    public void a(aa param1aa, int param1Int) {
      ArrayList arrayList = new ArrayList(this.beN.aoL());
      if (param1Int >= 0 && param1Int < arrayList.size()) {
        a(arrayList, param1Int, param1aa.Gw(), param1aa.Gp());
        arrayList.set(param1Int, new am.a.a(param1aa));
      } 
      this.beN.r(Collections.unmodifiableList(arrayList));
    }
    
    public void ae(double param1Double) {
      if (this.beV.getValue() == null || ((Double)this.beV.getValue()).doubleValue() != param1Double)
        this.beV.accept(Double.valueOf(param1Double)); 
    }
    
    public void af(double param1Double) {
      Integer integer = (Integer)this.beW.getValue();
      ArrayList arrayList = new ArrayList(this.beN.aoL());
      if (integer.intValue() >= 0 && integer.intValue() < arrayList.size()) {
        b(arrayList, integer.intValue(), param1Double);
        this.beN.r(Collections.unmodifiableList(arrayList));
      } 
    }
    
    public void c(h param1h) {
      ArrayList arrayList = new ArrayList(this.beN.aoL());
      a(arrayList, param1h);
      if (param1h instanceof a) {
        ArrayList arrayList1 = ((a)param1h).akq();
        if (arrayList1 != null) {
          Iterator iterator = arrayList1.iterator();
          while (iterator.hasNext())
            arrayList.add(new am.a.a(new aa((h)iterator.next(), (a)this.beQ.getValue()))); 
        } 
      } 
      this.beN.r(Collections.unmodifiableList(arrayList));
      eT(this.beN.aoL().size() - 1);
      this.beX.accept(Integer.valueOf(2147483647));
    }
    
    public void eR(int param1Int) {
      ArrayList arrayList = new ArrayList(this.beN.aoL());
      if (param1Int < 0 || param1Int >= arrayList.size()) {
        this.beu.bel.beK.accept(dl.b(this.beu).getString(2131628174));
        return;
      } 
      null = (am.a)arrayList.get(param1Int);
      if (!(null instanceof am.a.a))
        return; 
      aa aa = ((am.a.a)null).bjo;
      if (aa.aSW == 6L) {
        this.beu.bel.beK.accept(dl.b(this.beu).getString(2131630089));
        return;
      } 
      if (aa.Gw() < 0.0D) {
        this.beu.bel.beK.accept(dl.b(this.beu).getString(2131627556));
        return;
      } 
      if (aa.akO()) {
        this.beu.bel.beK.accept(dl.b(this.beu).getString(2131627541));
        return;
      } 
      List list = this.beP.aoL();
      if (aa.GN()) {
        aa aa1 = (aa)k.a(list, aa, new ex(this));
        if (aa1 != null) {
          int i = list.indexOf(aa1);
          if (i != -1)
            a(list, i, aa1.Gw() - 1.0D); 
        } else {
          eS(param1Int);
        } 
        if (aa.Gw() > 1.0D) {
          b(arrayList, param1Int, aa.Gw() - 1.0D);
          this.beN.r(Collections.unmodifiableList(arrayList));
          return;
        } 
        c(arrayList, param1Int);
        a(list, aa, true);
      } else {
        c(arrayList, param1Int);
      } 
      this.beP.r(list);
      this.beN.r(Collections.unmodifiableList(arrayList));
      eT(param1Int - 1);
    }
    
    public void eS(int param1Int) {
      List list1 = this.beN.aoL();
      null = (am.a)list1.get(param1Int);
      if (!(null instanceof am.a.a))
        return; 
      aa aa1 = ((am.a.a)null).bjo;
      List list2 = this.beP.aoL();
      aa aa2 = new aa(aa1, (a)this.beQ.getValue());
      aa2.q(-1.0D);
      aa2.az(aa1.Ly());
      aa2.aq(aa1.Gr());
      aa2.ar(aa1.Gs());
      aa2.as(aa1.GS());
      list2.add(aa2);
      if (aa1.akN())
        while (true) {
          if (++param1Int < list1.size()) {
            am.a a1 = (am.a)list1.get(param1Int);
            if (a1 instanceof am.a.a) {
              am.a.a a2 = (am.a.a)a1;
              if (a2.bjo.akO()) {
                aa aa = a2.bjo;
                aa2 = new aa(aa, (a)this.beQ.getValue());
                aa2.q(-1.0D);
                aa2.az(aa.Ly());
                aa2.aq(aa.Gr());
                aa2.ar(aa.Gs());
                aa2.as(aa.GS());
                list2.add(aa2);
                continue;
              } 
            } 
          } 
          break;
        }  
      this.beP.r(list2);
    }
    
    public void eT(int param1Int) { // Byte code:
      //   0: aload_0
      //   1: getfield beN : Lcom/laiqian/rx/util/a;
      //   4: invokevirtual aoL : ()Ljava/util/List;
      //   7: astore #6
      //   9: aload #6
      //   11: invokeinterface size : ()I
      //   16: ifeq -> 229
      //   19: iload_1
      //   20: aload #6
      //   22: invokeinterface size : ()I
      //   27: iconst_1
      //   28: isub
      //   29: invokestatic min : (II)I
      //   32: istore_2
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_2
      //   36: istore_1
      //   37: iload_2
      //   38: ifge -> 43
      //   41: iconst_0
      //   42: istore_1
      //   43: aload #6
      //   45: iload_1
      //   46: invokeinterface get : (I)Ljava/lang/Object;
      //   51: checkcast com/laiqian/main/module/productcart/am$a
      //   54: astore #5
      //   56: aload #5
      //   58: instanceof com/laiqian/main/module/productcart/am$a$a
      //   61: istore #4
      //   63: iload #4
      //   65: ifeq -> 91
      //   68: iload_1
      //   69: istore_2
      //   70: iload #4
      //   72: ifeq -> 101
      //   75: iload_1
      //   76: istore_2
      //   77: aload #5
      //   79: checkcast com/laiqian/main/module/productcart/am$a$a
      //   82: getfield bjo : Lcom/laiqian/entity/aa;
      //   85: invokevirtual akO : ()Z
      //   88: ifeq -> 101
      //   91: iload_1
      //   92: iconst_1
      //   93: isub
      //   94: istore_1
      //   95: iload_1
      //   96: ifge -> 213
      //   99: iload_1
      //   100: istore_2
      //   101: iload_2
      //   102: ifge -> 184
      //   105: aload #6
      //   107: iconst_0
      //   108: invokeinterface get : (I)Ljava/lang/Object;
      //   113: checkcast com/laiqian/main/module/productcart/am$a
      //   116: astore #5
      //   118: iload_3
      //   119: istore_1
      //   120: aload #5
      //   122: instanceof com/laiqian/main/module/productcart/am$a$a
      //   125: istore #4
      //   127: iload #4
      //   129: ifeq -> 155
      //   132: iload_1
      //   133: istore_2
      //   134: iload #4
      //   136: ifeq -> 184
      //   139: iload_1
      //   140: istore_2
      //   141: aload #5
      //   143: checkcast com/laiqian/main/module/productcart/am$a$a
      //   146: getfield bjo : Lcom/laiqian/entity/aa;
      //   149: invokevirtual akO : ()Z
      //   152: ifeq -> 184
      //   155: iload_1
      //   156: iconst_1
      //   157: iadd
      //   158: istore_1
      //   159: iload_1
      //   160: ifge -> 168
      //   163: iload_1
      //   164: istore_2
      //   165: goto -> 184
      //   168: aload #6
      //   170: iload_1
      //   171: invokeinterface get : (I)Ljava/lang/Object;
      //   176: checkcast com/laiqian/main/module/productcart/am$a
      //   179: astore #5
      //   181: goto -> 120
      //   184: iload_2
      //   185: aload_0
      //   186: getfield beW : Lcom/jakewharton/b/b;
      //   189: invokevirtual getValue : ()Ljava/lang/Object;
      //   192: checkcast java/lang/Integer
      //   195: invokevirtual intValue : ()I
      //   198: if_icmpeq -> 229
      //   201: aload_0
      //   202: getfield beW : Lcom/jakewharton/b/b;
      //   205: iload_2
      //   206: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   209: invokevirtual accept : (Ljava/lang/Object;)V
      //   212: return
      //   213: aload #6
      //   215: iload_1
      //   216: invokeinterface get : (I)Ljava/lang/Object;
      //   221: checkcast com/laiqian/main/module/productcart/am$a
      //   224: astore #5
      //   226: goto -> 56
      //   229: return }
    
    public void eU(int param1Int) {
      if (((Integer)this.beW.getValue()).intValue() != param1Int)
        this.beW.accept(Integer.valueOf(param1Int)); 
    }
    
    public ArrayList<aa> g(Collection<aa> param1Collection) {
      ArrayList arrayList = new ArrayList();
      if (((Boolean)this.beu.bdN.getValue()).booleanValue()) {
        for (aa aa : param1Collection) {
          aa.r(aa.akI());
          arrayList.add(aa);
        } 
      } else {
        arrayList.addAll(param1Collection);
      } 
      return arrayList;
    }
    
    public int getCount() { return this.beO.aoL().size(); }
    
    public void h(Collection<am.a> param1Collection) {
      ArrayList arrayList = new ArrayList(this.beN.aoL());
      for (am.a a1 : param1Collection) {
        if (a1 instanceof am.a.a) {
          a(arrayList, ((am.a.a)a1).bjo);
          continue;
        } 
        arrayList.add(a1);
      } 
      this.beN.r(Collections.unmodifiableList(arrayList));
      eT(this.beN.aoL().size() - 1);
      this.beX.accept(Integer.valueOf(2147483647));
    }
    
    public void i(Collection<am.a> param1Collection) {
      ArrayList arrayList = new ArrayList(this.beN.aoL());
      arrayList.clear();
      for (am.a a1 : param1Collection) {
        if (a1 instanceof am.a.a) {
          a(arrayList, ((am.a.a)a1).bjo);
          continue;
        } 
        arrayList.add(a1);
      } 
      this.beN.r(Collections.unmodifiableList(arrayList));
      eT(this.beN.aoL().size() - 1);
      this.beX.accept(Integer.valueOf(2147483647));
    }
    
    public void o(HashMap<Long, Integer> param1HashMap) { (new b(this.bdZ)).a(b.a.y(param1HashMap.keySet())).g(new ev(this)).g(new eu(this, param1HashMap)).g(new eo(this)).b(this.beN); }
    
    public void p(HashMap<Long, Integer> param1HashMap) { (new b(this.bdZ)).a(b.a.y(param1HashMap.keySet())).g(ep.beq).g(new eq(param1HashMap)).g(new er(this)).b(this.beN); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */