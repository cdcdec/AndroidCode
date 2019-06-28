package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.entity.v;
import com.laiqian.main.b.b;
import io.reactivex.c.c;
import java.util.ArrayList;
import java.util.List;

class bh extends Object implements c<List<v>, List<v>, List<b>> {
  bh(ag.a parama, ag paramag) {}
  
  public List<b> b(List<v> paramList1, List<v> paramList2) throws Exception {
    null = ag.Ou();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("AAA初始化第二支付方式集合AAA normalPayTypeEntities=");
    stringBuilder2.append(paramList1.size());
    stringBuilder2.append("---payTypeOther=");
    stringBuilder2.append(paramList2.size());
    Log.i(null, stringBuilder2.toString());
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    arrayList2.addAll(paramList1);
    arrayList2.addAll(paramList2);
    for (v v : arrayList2) {
      switch (v.aSX) {
        case 10006:
        case 10013:
        case 10014:
          continue;
        default:
          arrayList1.add(ag.a.c(this.bnJ, v));
          continue;
        case 10009:
          arrayList1.add(ag.a.b(this.bnJ, v));
          continue;
        case 10007:
          break;
      } 
      arrayList1.add(ag.a.a(this.bnJ, v));
    } 
    String str = ag.Ou();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("初始化第二支付方式集合 size= ");
    stringBuilder1.append(arrayList1.size());
    Log.i(str, stringBuilder1.toString());
    return arrayList1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */