package com.laiqian.main.module.settlement;

import android.graphics.Bitmap;
import android.util.Log;
import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.pay.a;
import com.laiqian.main.module.settlement.pay.b;
import com.laiqian.pos.AliPayPreorderDetail;
import io.reactivex.c.j;

class ck extends Object implements j<a, AliPayPreorderDetail, c, b, Object> {
  ck(PosActivitySettlementDialogSubmitOrderFragment paramPosActivitySettlementDialogSubmitOrderFragment) {}
  
  public Object a(a parama, AliPayPreorderDetail paramAliPayPreorderDetail, c paramc, b paramb) throws Exception {
    Log.i("@emery orderFragment", "扫码框的回调");
    if (parama.OQ()) {
      if (parama.OP() != null) {
        Bitmap bitmap = parama.OP().OR();
        if (!AliPayPreorderDetail.a(paramAliPayPreorderDetail))
          PosActivitySettlementDialogSubmitOrderFragment.k(this.boa).d(this.boa.a(bitmap, paramAliPayPreorderDetail)); 
      } 
      parama.OO();
      if (parama.ON() != null)
        parama.ON().xq(); 
      parama.OL();
    } 
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */