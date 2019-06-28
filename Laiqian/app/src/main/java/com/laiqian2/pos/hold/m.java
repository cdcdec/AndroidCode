package com.laiqian.pos.hold;

import android.text.TextUtils;
import android.util.Log;
import com.laiqian.d.a;
import com.laiqian.opentable.common.ag;
import com.laiqian.opentable.common.b;

class m implements ag.a {
  m(HolderOpenTableSettingFragment paramHolderOpenTableSettingFragment) {}
  
  public void db(boolean paramBoolean) {
    if (paramBoolean) {
      b.XG();
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */