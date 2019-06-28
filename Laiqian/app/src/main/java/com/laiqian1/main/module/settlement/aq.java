package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import io.reactivex.c.i;

class aq extends Object implements i<Double, aq, Boolean, Boolean> {
  aq(ag paramag) {}
  
  public Boolean a(Double paramDouble, aq paramaq, Boolean paramBoolean) throws Exception {
    boolean bool1;
    boolean bool2 = aq.a(paramaq);
    boolean bool3 = false;
    if (bool2)
      return Boolean.valueOf(false); 
    if (paramaq.aWo > 0.0D && paramaq.aWo >= paramDouble.doubleValue()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    boolean bool4 = a.AZ().Bu();
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 会员余额不足判断  ");
    stringBuilder.append(paramaq.aWo);
    stringBuilder.append("抵扣后金额");
    stringBuilder.append(paramDouble);
    Log.i(str, stringBuilder.toString());
    bool2 = bool3;
    if (paramBoolean.booleanValue()) {
      bool2 = bool3;
      if (!bool4) {
        bool2 = bool3;
        if (!bool1)
          bool2 = true; 
      } 
    } 
    return Boolean.valueOf(bool2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */