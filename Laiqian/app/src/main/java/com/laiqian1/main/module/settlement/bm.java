package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.entity.v;
import com.laiqian.models.a;
import io.reactivex.i;
import io.reactivex.j;
import java.util.ArrayList;
import java.util.List;

class bm extends Object implements j<List<v>> {
  bm(ag.a.a parama, ag.a parama1) {}
  
  public void a(i<List<v>> parami) throws Exception {
    Log.i(ag.Ou(), " 其他支付下支付方式赋初值");
    ArrayList arrayList2 = (new a(ag.a.a.a(this.bnL))).o(true, false);
    ArrayList arrayList1 = arrayList2;
    if (arrayList2 == null)
      arrayList1 = new ArrayList(); 
    parami.am(arrayList1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */