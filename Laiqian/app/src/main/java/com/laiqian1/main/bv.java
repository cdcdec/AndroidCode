package com.laiqian.main;

import com.laiqian.ui.a.r;

class bv implements Runnable {
  bv(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void run() {
    r r = new r(PosActivitySettlementDialog.access$3900(this.bcy), 3, null);
    r.setTitle(PosActivitySettlementDialog.access$4000(this.bcy).getString(2131627480));
    r.s(PosActivitySettlementDialog.access$3900(this.bcy).getString(2131625763));
    r.pa(PosActivitySettlementDialog.access$4100(this.bcy).getString(2131626861));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */