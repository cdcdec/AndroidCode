package com.laiqian.member.setting.discount;

import android.support.annotation.RequiresApi;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.model.a;
import com.laiqian.member.model.b;
import com.laiqian.util.e;
import com.laiqian.vip.R;

class j extends e {
  j(c paramc, e.a parama, String paramString1, String paramString2) { super(parama); }
  
  @RequiresApi
  public void a(e parame, String paramString) {
    a a = new a(this.bDF.mContext);
    a.beginTransaction();
    String str = this.bDF.bDx.id;
    if (a.c(this.bDF.bDx.id, this.bDG, this.bDH, c.d(this.bDF))) {
      parame.dEQ = this.bDF.mContext.getString(R.string.recharge_exist);
      parame.lr(parame.dEN);
      a.endTransaction();
      return;
    } 
    b b = new b(this.bDF.mContext);
    b.byc = 2;
    b.id = str;
    boolean bool = b.QN();
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      if (bool) {
        a.setTransactionSuccessful();
        parame.lr(parame.dEM);
      } else {
        parame.dEQ = this.bDF.mContext.getString(R.string.recharge_failure_network);
        parame.lr(parame.dEN);
      } 
    } else {
      a.setTransactionSuccessful();
      parame.lr(parame.dEM);
    } 
    a.endTransaction();
    a.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */