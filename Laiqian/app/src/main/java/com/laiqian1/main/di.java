package com.laiqian.main;

import android.content.Context;
import android.os.Handler;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aa;
import com.laiqian.entity.q;
import com.laiqian.entity.z;
import com.laiqian.models.x;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.ui.a.r;
import java.util.ArrayList;
import java.util.Iterator;

public class di implements Runnable {
  private bb aSx;
  
  private Context aTg;
  
  private final int bdA = 4;
  
  private final int bdB = 5;
  
  private final int bdC = 6;
  
  private final int bdD = 7;
  
  Handler bdE = new dj(this);
  
  private boolean bdu;
  
  private r bdv;
  
  private a bdw;
  
  private final int bdx = 1;
  
  private final int bdy = 2;
  
  private final int bdz = 3;
  
  PendingFullOrderDetail deletedOrder = null;
  
  public di(Context paramContext, bb parambb, boolean paramBoolean, a parama) {
    this.aTg = paramContext;
    this.aSx = parambb;
    this.bdu = paramBoolean;
    this.bdw = parama;
  }
  
  private boolean LO() {
    x x = new x(CrashApplication.zv());
    ArrayList arrayList = x.gV(this.aSx.orderNo);
    x.close();
    if (arrayList == null || arrayList.isEmpty()) {
      this.bdE.obtainMessage(7, "").sendToTarget();
      return true;
    } 
    return false;
  }
  
  private boolean a(z paramz) { return ((paramz.aTv == 10007 || paramz.aTv == 10009) && (paramz.aTx == 5L || paramz.aTx == 8L || paramz.aTx == 0L || paramz.aTx == 1L)); }
  
  private boolean hasPendingOrder(bb parambb) {
    Iterator iterator = parambb.bbT.iterator();
    while (iterator.hasNext()) {
      if (((aa)iterator.next()).GN())
        return true; 
    } 
    return false;
  }
  
  private boolean isUseChainMember() { return (RootApplication.zv().getLaiqianPreferenceManager().Wq() && this.aSx.vipEntity != null); }
  
  private q j(bb parambb) {
    for (z z : parambb.bbS) {
      if (a(z))
        return (new q.a()).df(this.aSx.orderNo).dg(String.valueOf(z.aJW)).aj(z.aTx).b(parambb).Fy(); 
    } 
    return null;
  }
  
  public void k(bb parambb) {
    aq aq;
    if (this.deletedOrder != null) {
      aq = new aq(this.aTg, parambb, this.deletedOrder);
    } else if (hasPendingOrder(aq) && aq.bbQ != null) {
      a a1 = new a(this.aTg);
      PendingFullOrderDetail pendingFullOrderDetail = a1.ks(aq.bbQ);
      a1.close();
      aq = new aq(this.aTg, aq, pendingFullOrderDetail);
    } else {
      aq = new aq(this.aTg, aq);
    } 
    aq.start();
  }
  
  public void run() { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public void setDeletedPendingOrder(PendingFullOrderDetail paramPendingFullOrderDetail) { this.deletedOrder = paramPendingFullOrderDetail; }
  
  public static interface a {
    void KK();
    
    void KL();
    
    void KM();
    
    void a(bb param1bb, boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */