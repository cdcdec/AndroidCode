package com.laiqian.main.module.settlement;

import android.graphics.Bitmap;
import android.util.Log;
import com.laiqian.ag;
import com.laiqian.main.module.settlement.pay.a;

class cm implements ag.a {
  cm(PosActivitySettlementDialogSubmitOrderFragment paramPosActivitySettlementDialogSubmitOrderFragment) {}
  
  public void a(long paramLong, boolean paramBoolean) {
    a a1 = new a();
    a1.b(paramLong, paramBoolean);
    this.boa.blQ.bmT.bnG.am(a1);
    Log.i("@emery payTypeFragment", "扫码框回调 onSwitchPayment 643");
  }
  
  public void bk(String paramString) {
    a a1 = new a();
    a1.fg(paramString);
    this.boa.blQ.bmT.bnG.am(a1);
    Log.i("@emery payTypeFragment", "扫码框回调onSwitchOrderNo 659");
  }
  
  public void bl(String paramString) {
    a a1 = new a();
    a1.ff(paramString);
    this.boa.blQ.bmT.bnG.am(a1);
    Log.i("@emery payTypeFragment", "扫码框回调onPaySuccess 668");
    PosActivitySettlementDialogSubmitOrderFragment.b(this.boa, paramString);
    if (this.boa.Oy())
      PosActivitySettlementDialogSubmitOrderFragment.a(this.boa, paramString); 
  }
  
  public void f(int paramInt, String paramString) {
    a a1 = new a();
    a1.fe(paramString);
    this.boa.blQ.bmT.bnG.am(a1);
    Log.i("@emery payTypeFragment", "扫码框回调onPayFailed 676");
  }
  
  public void o(Bitmap paramBitmap) {
    a a1 = new a();
    a1.p(paramBitmap);
    this.boa.blQ.bmT.bnG.am(a1);
    Log.i("@emery payTypeFragment", "扫码框回调onCreateQrcode 651");
  }
  
  public String xq() { return PosActivitySettlementDialogSubmitOrderFragment.l(this.boa); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */