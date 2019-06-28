package com.laiqian.main.module.settlement;

import android.util.Log;
import android.util.Pair;
import com.laiqian.entity.aa;
import com.laiqian.product.dq;
import io.reactivex.c.c;
import java.util.Iterator;
import java.util.List;

class ay extends Object implements c<Boolean, List<aa>, Pair<Double, Double>> {
  ay(ag paramag) {}
  
  public Pair<Double, Double> a(Boolean paramBoolean, List<aa> paramList) throws Exception {
    Iterator iterator = paramList.iterator();
    double d1 = 0.0D;
    double d2;
    for (d2 = d1; iterator.hasNext(); d2 = d3) {
      aa aa = (aa)iterator.next();
      if (paramBoolean.booleanValue()) {
        d3 = aa.j((new dq(this.bnl.mContext)).gp(true));
      } else {
        d3 = 0.0D;
      } 
      double d4 = aa.GJ() + d3;
      double d3 = d2;
      if (aa.Gv())
        d3 = d2 + d4; 
      d1 += d4;
    } 
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("apply 重新计算  288 sumAmountContainTaxOfAddPrice=");
    stringBuilder.append(d1);
    Log.i(str, stringBuilder.toString());
    return new Pair(Double.valueOf(d1), Double.valueOf(d2));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */