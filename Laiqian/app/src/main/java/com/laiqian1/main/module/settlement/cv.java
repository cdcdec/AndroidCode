package com.laiqian.main.module.settlement;

import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.main.PosActivitySettlementDialog;
import com.laiqian.main.b.f;
import com.laiqian.main.bb;
import com.laiqian.main.dl;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.ArrayList;

class cv implements f {
  cv(PosActivitySettlementFragment paramPosActivitySettlementFragment) {}
  
  public void OC() { PosActivitySettlementFragment.b(this.boj).c(aq.aWG); }
  
  public void OD() { PosActivitySettlementFragment.b(this.boj).LV(); }
  
  public boolean OE() {
    if (((PosActivitySettlementDialog)PosActivitySettlementFragment.c(this.boj).get()).getVipEntity() == null) {
      (PosActivitySettlementFragment.b(this.boj)).bem.bez.accept(new Object());
      return true;
    } 
    return false;
  }
  
  public void b(PendingFullOrderDetail paramPendingFullOrderDetail, ArrayList<aa> paramArrayList, long paramLong) { PosActivitySettlementFragment.b(this.boj).a(paramPendingFullOrderDetail, paramArrayList, paramLong); }
  
  public void f(bb parambb, boolean paramBoolean) { (PosActivitySettlementFragment.b(this.boj)).bel.beI.accept(new dl.d(parambb, paramBoolean)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */