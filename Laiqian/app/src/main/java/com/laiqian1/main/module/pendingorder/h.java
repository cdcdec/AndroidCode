package com.laiqian.main.module.pendingorder;

import com.laiqian.main.dl;
import com.laiqian.pos.hold.PendingFullOrderDetail;

class h implements a.a {
  private boolean biQ = false;
  
  h(PosActivityPendingOrderFragment paramPosActivityPendingOrderFragment) {}
  
  public void ND() {
    if (this.biQ) {
      PosActivityPendingOrderFragment.a(this.biN).a(dl.ben);
      (PosActivityPendingOrderFragment.a(this.biN)).bea.Mi();
      this.biQ = false;
    } 
  }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean) {
    this.biQ = paramBoolean;
    PosActivityPendingOrderFragment.a(this.biN, paramPendingFullOrderDetail, this.biQ);
  }
  
  public void deleteOrder() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\pendingorder\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */