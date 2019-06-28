package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.entity.v;
import io.reactivex.c.g;
import java.util.ArrayList;
import java.util.List;

class bf extends Object implements g<List<v>> {
  bf(ag.a parama, ag paramag) {}
  
  public void r(List<v> paramList) throws Exception {
    Log.i(ag.Ou(), " 初始化正常的支付方式,并可能改变otherPayType");
    ArrayList arrayList1 = new ArrayList();
    v.a a1 = new v.a(this.bnJ.mContext, ((Boolean)this.bnJ.bnl.bmB.getValue()).booleanValue());
    ArrayList arrayList2 = new ArrayList();
    ag.a.a(this.bnJ, arrayList2, a1.Gb());
    ag.a.a(this.bnJ, arrayList2, a1.Gc());
    ag.a.a(this.bnJ, arrayList2, a1.Ge());
    ag.a.a(this.bnJ, arrayList2, a1.Gf());
    ag.a.a(this.bnJ, arrayList2, a1.Gg());
    ag.a.a(this.bnJ, arrayList2, a1.Gh());
    ag.a.a(this.bnJ, arrayList2, a1.Gi());
    ag.a.a(this.bnJ, arrayList2, a1.Gj());
    if (arrayList2.size() > 7) {
      for (byte b = 0; b < arrayList2.size(); b++) {
        if (b < 7) {
          arrayList1.add(arrayList2.get(b));
        } else {
          paramList.add(arrayList2.get(b));
        } 
      } 
    } else {
      arrayList1.addAll(arrayList2);
    } 
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 初始化正常的支付方式,并可能改变otherPayType normalPayTypeEntities.size=");
    stringBuilder.append(arrayList1.size());
    stringBuilder.append("--other.size=");
    stringBuilder.append(paramList.size());
    Log.i(str, stringBuilder.toString());
    this.bnJ.bnv.r(arrayList1);
    this.bnJ.bnx.r(paramList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */