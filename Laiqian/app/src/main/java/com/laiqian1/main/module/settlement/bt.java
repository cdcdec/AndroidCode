package com.laiqian.main.module.settlement;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.au;
import com.laiqian.basic.RootApplication;
import com.laiqian.i.d;
import com.laiqian.models.at;
import com.laiqian.util.av;
import io.reactivex.i;
import io.reactivex.j;
import java.io.IOException;

class bt extends Object implements j<au> {
  bt(ag.a.b paramb, ag.a parama) {}
  
  public void a(i<au> parami) throws Exception {
    Log.i(ag.Ou(), "初始化员工优惠限额");
    String str2 = (new av(RootApplication.zv())).atm();
    at at = new at(RootApplication.zv());
    String str1 = at.iq(str2);
    try {
      au au2 = (au)d.b(str1, au.class);
      au au1 = au2;
      if (au2 == null) {
        au1 = new au(false, true, false, 0.0D);
        at.ao(str2, d.ac(au1));
      } 
      parami.am(au1);
    } catch (IOException parami) {
      a.e(parami);
    } finally {}
    at.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */