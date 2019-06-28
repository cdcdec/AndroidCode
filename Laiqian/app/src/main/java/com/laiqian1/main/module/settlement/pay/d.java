package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import com.laiqian.main.b.c;
import io.reactivex.c.g;

class d extends Object implements g<c> {
  d(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public void c(c paramc) throws Exception {
    Log.i("@emery payTypeFragment", "其他支付方式的点击事件,显示popupwindow");
    if (PosActivitySettlementDialogPayTypeFragment.b(this.boK).Pa().size() > 1)
      paramc.setOnClickListener(new PosActivitySettlementDialogPayTypeFragment.c(this.boK, PosActivitySettlementDialogPayTypeFragment.b(this.boK).OZ())); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */