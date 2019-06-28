package com.laiqian.main.module.settlement;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.pay.a;
import com.laiqian.main.module.settlement.pay.b;
import com.laiqian.pos.AliPayPreorderDetail;
import com.laiqian.print.dualscreen.o;
import com.laiqian.util.n;
import io.reactivex.c.k;

class aw extends Object implements k<a, AliPayPreorderDetail, c, b, Double, Object> {
  aw(ag paramag) {}
  
  public Object a(a parama, AliPayPreorderDetail paramAliPayPreorderDetail, c paramc, b paramb, Double paramDouble) throws Exception {
    Log.i(ag.Ou(), "扫码框的回调,通知双屏");
    o o = o.afM();
    if (o == null)
      return Boolean.valueOf(true); 
    if (parama.OQ()) {
      if (parama.OP() != null) {
        Bitmap bitmap = parama.OP().OR();
        if (paramc.aTe == 8L || (paramb.OT() != null && (paramb.OT()).aTv == 10009)) {
          if (o != null)
            o.afP().b(new BitmapDrawable(this.bnl.mContext.getResources(), bitmap), n.b(this.bnl.mContext, 2131625101, paramDouble.toString())); 
        } else if ((paramc.aTe == 0L || (paramb.OT() != null && (paramb.OT()).aTv == 10007)) && o != null) {
          o.afP().a(new BitmapDrawable(this.bnl.mContext.getResources(), bitmap), n.b(this.bnl.mContext, 2131625101, paramDouble.toString()));
        } 
      } 
      if (parama.OO() != null && (paramc.aTe == 5L || paramc.aTe == 1L || (paramb.OT() != null && (paramb.OT()).aTx == 5L) || (paramb.OT() != null && (paramb.OT()).aTx == 1L)))
        ag.a(this.bnl, true, o, paramc, paramb.OT()); 
      return Boolean.valueOf(true);
    } 
    if (parama.OM())
      ag.a(this.bnl, false, o, paramc, paramb.OT()); 
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */