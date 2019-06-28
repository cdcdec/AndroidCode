package com.laiqian.opentable.common;

import android.util.Log;
import com.laiqian.network.i;
import com.laiqian.opentable.common.b.a;
import java.text.SimpleDateFormat;
import java.util.Date;

final class r implements t.a {
  r(t.f paramf, boolean paramBoolean) {}
  
  public void d(i parami) throws m {
    if (parami.bUi) {
      String str1 = new StringBuilder();
      str1.append("下载完成");
      str1.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
      Log.d("openTable", str1.toString());
      String str2 = parami.message;
      if (parami.bUi) {
        String str = "下载区域桌号完成：";
      } else {
        str1 = "下载区域桌号失败";
      } 
      b.au(str2, str1);
      (new a(new s(this))).execute(new String[] { parami.message });
      return;
    } 
    if (this.bZg) {
      this.bYi.dp(true);
      return;
    } 
    this.bYi.dp(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */