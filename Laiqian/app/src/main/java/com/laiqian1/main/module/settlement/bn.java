package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.basic.RootApplication;
import io.reactivex.i;
import io.reactivex.j;

class bn extends Object implements j<Boolean> {
  bn(ag.a.b paramb, ag.a parama) {}
  
  public void a(i<Boolean> parami) throws Exception {
    Log.i(ag.Ou(), "是否是连锁店铺");
    parami.am(Boolean.valueOf(RootApplication.zv().getLaiqianPreferenceManager().isMultipleShop()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */