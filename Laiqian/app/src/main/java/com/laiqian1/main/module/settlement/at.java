package com.laiqian.main.module.settlement;

import android.text.TextUtils;
import android.util.Log;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import io.reactivex.c.c;

class at extends Object implements c<Integer, String, Long> {
  at(ag paramag) {}
  
  public Long a(Integer paramInteger, String paramString) throws Exception {
    long l;
    Log.i(ag.Ou(), "获取挂单桌号 ");
    if (paramInteger.intValue() == 15 && !TextUtils.isEmpty(paramString)) {
      if (!n.px(paramString)) {
        l = Long.parseLong(paramString);
      } else {
        l = RootApplication.zv().getLaiqianPreferenceManager().avk();
      } 
    } else {
      l = RootApplication.zv().getLaiqianPreferenceManager().avk();
    } 
    return Long.valueOf(l);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */