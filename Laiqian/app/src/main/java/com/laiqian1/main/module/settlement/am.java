package com.laiqian.main.module.settlement;

import android.util.Log;
import io.reactivex.c.g;

class am extends Object implements g<Boolean> {
  am(ag paramag) {}
  
  public void a(Boolean paramBoolean) throws Exception {
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("是否需要显示积分抵扣模块 consumer l288--");
    stringBuilder.append(paramBoolean);
    Log.i(str, stringBuilder.toString());
    this.bnl.bmE.accept(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */