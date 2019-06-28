package com.laiqian.opentable.common;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

class s implements t.f {
  s(r paramr) {}
  
  public void dp(boolean paramBoolean) throws m {
    String str = new StringBuilder();
    str.append("解析完成");
    str.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
    Log.d("openTable", str.toString());
    if (paramBoolean) {
      String str1 = "解析区域桌号完成：";
    } else {
      str = "解析解析区域桌号失败";
    } 
    b.au("解析区域桌号数据", str);
    if (this.bZh.bYi != null) {
      if (this.bZh.bZg) {
        n.XL();
        this.bZh.bYi.dp(true);
        return;
      } 
      this.bZh.bYi.dp(paramBoolean);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */