package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.entity.aq;
import io.reactivex.c.k;

class p extends Object implements k<String, Long, Integer, Boolean, aq, Object> {
  p(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public Object a(String paramString, Long paramLong, Integer paramInteger, Boolean paramBoolean, aq paramaq) throws Exception {
    Log.i("emery dialogFragment", "设置牌号 ");
    if (paramInteger.intValue() == 7) {
      PosActivitySettlementDialogFragment.a(this.blV).fd(paramString);
    } else if (paramInteger.intValue() == 15) {
      PosActivitySettlementDialogFragment.a(this.blV).b(paramBoolean.booleanValue(), paramLong.toString());
    } else if (paramInteger.intValue() == 0) {
      PosActivitySettlementDialogFragment.a(this.blV).Oo();
    } else if (paramInteger.intValue() == 5) {
      PosActivitySettlementDialogFragment.a(this.blV).f(paramaq);
    } 
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */