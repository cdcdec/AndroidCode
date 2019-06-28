package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.auth.au;
import com.laiqian.entity.aq;
import com.laiqian.main.cr;
import com.laiqian.main.module.settlement.pay.v;
import io.reactivex.c.k;

class bv extends Object implements k<au, aq, Double, Double, Double, v> {
  bv(ag.a.b paramb, ag.a parama) {}
  
  public v a(au paramau, aq paramaq, Double paramDouble1, Double paramDouble2, Double paramDouble3) throws Exception {
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("判断员工优惠是否超过权限 actualReceivedAmount=");
    stringBuilder.append(paramDouble2);
    stringBuilder.append("-discount=");
    stringBuilder.append(paramDouble1);
    Log.i(str, stringBuilder.toString());
    return cr.a(ag.a.b.a(this.bnV), paramau, paramaq, paramDouble1.toString(), paramDouble2.toString(), paramDouble3.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */