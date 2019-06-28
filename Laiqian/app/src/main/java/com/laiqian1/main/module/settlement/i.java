package com.laiqian.main.module.settlement;

import android.util.Log;
import android.util.Pair;
import com.laiqian.entity.aq;
import com.laiqian.main.b.b;
import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.pay.b;
import com.laiqian.util.n;
import io.reactivex.c.l;
import java.util.List;

class i extends Object implements l<c, Double, Double, List<b>, Boolean, b, Pair<Boolean, Double>> {
  i(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public Pair<Boolean, Double> a(c paramc, Double paramDouble1, Double paramDouble2, List<b> paramList, Boolean paramBoolean, b paramb) throws Exception {
    Double double;
    StringBuilder stringBuilder;
    Log.i("emery dialogFragment", "是否显示第二支付 或 是否显示找零");
    if (paramc.aTv == 10014) {
      double = (Double)(PosActivitySettlementDialogFragment.b(this.blV)).bmK.getValue();
    } else {
      double = Double.valueOf(Double.parseDouble(n.e(paramDouble1)));
    } 
    boolean bool = ((Boolean)(PosActivitySettlementDialogFragment.b(this.blV)).bmP.getValue()).booleanValue();
    aq aq = (aq)(PosActivitySettlementDialogFragment.b(this.blV)).bmC.getValue();
    paramDouble1 = double;
    if (bool) {
      paramDouble1 = double;
      if (!aq.a(aq))
        if (aq.aWo <= 0.0D) {
          paramDouble1 = Double.valueOf(0.0D);
        } else {
          double d1;
          if (double.doubleValue() <= aq.aWo) {
            d1 = double.doubleValue();
          } else {
            d1 = aq.aWo;
          } 
          paramDouble1 = Double.valueOf(d1);
        }  
    } 
    if (paramBoolean.booleanValue()) {
      paramDouble2 = (Double)(PosActivitySettlementDialogFragment.b(this.blV)).bmG.getValue();
    } else {
      paramDouble2 = Double.valueOf(Double.parseDouble(n.e(paramDouble2)));
    } 
    double d = paramDouble1.doubleValue() - paramDouble2.doubleValue();
    if (paramc.aTv == 10001) {
      if (paramDouble1.doubleValue() > paramDouble2.doubleValue()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("- 是否显示找零 382  ");
        stringBuilder.append(paramDouble1);
        stringBuilder.append("===");
        stringBuilder.append(paramDouble2);
        stringBuilder.append("==");
        stringBuilder.append(Math.abs(d));
        Log.i("@emery dialogFragment", stringBuilder.toString());
        PosActivitySettlementDialogFragment.a(this.blV).a(true, Math.abs(d));
        (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnt.accept(Double.valueOf(Math.abs(d)));
      } else {
        PosActivitySettlementDialogFragment.a(this.blV).a(false, paramDouble1.doubleValue());
      } 
    } else {
      b b1;
      if (paramDouble1.doubleValue() < paramDouble2.doubleValue() && stringBuilder.aTv != 10014) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("- 是否显示第二支付 400  ");
        stringBuilder.append(paramDouble1);
        stringBuilder.append("===");
        stringBuilder.append(paramDouble2);
        stringBuilder.append("==");
        stringBuilder.append(Math.abs(d));
        Log.i("@emery dialogFragment", stringBuilder.toString());
        null = paramb.OT();
        if (bool) {
          PosActivitySettlementDialogFragment.a(this.blV).a(paramDouble1.doubleValue(), Math.abs(d), null);
        } else {
          PosActivitySettlementDialogFragment.a(this.blV).a(true, Math.abs(d), null);
        } 
        (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnt.accept(Double.valueOf(Math.abs(d)));
        b1 = new b(null, true);
        (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bns.accept(b1);
      } else if (paramDouble1.doubleValue() > paramDouble2.doubleValue() && (b1.aTv == 10007 || b1.aTv == 10009 || b1.aTv == 10006)) {
        PosActivitySettlementDialogFragment.a(this.blV).a(false, paramDouble2.doubleValue(), (b)paramList.get(0));
        (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnt.accept(Double.valueOf(0.0D));
      } else {
        PosActivitySettlementDialogFragment.a(this.blV).a(false, paramDouble1.doubleValue(), (b)paramList.get(0));
        (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnt.accept(Double.valueOf(0.0D));
      } 
    } 
    return new Pair(Boolean.valueOf(true), Double.valueOf(Math.abs(d)));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */