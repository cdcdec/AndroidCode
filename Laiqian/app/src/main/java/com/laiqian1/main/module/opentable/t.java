package com.laiqian.main.module.opentable;

import android.text.TextUtils;
import android.util.Log;
import com.laiqian.d.a;
import com.laiqian.opentable.common.ag;

class t implements ag.a {
  t(PosActivityOpenTableFragment paramPosActivityOpenTableFragment) {}
  
  public void db(boolean paramBoolean) {
    if (paramBoolean) {
      if (TextUtils.isEmpty(a.AZ().Ck())) {
        Log.d("LanServerIP", "互联网模式或者挂单，清空IP");
        return;
      } 
      Log.d("LanServerIP", "上传IP成功");
      return;
    } 
    Log.d("LanServerIP", "上传IP失败");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */