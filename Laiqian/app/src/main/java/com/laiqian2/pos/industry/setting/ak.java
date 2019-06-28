package com.laiqian.pos.industry.setting;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.milestone.h;
import com.laiqian.takeaway.al;
import com.laiqian.util.av;
import com.laiqian.util.by;
import java.util.HashMap;
import org.json.JSONObject;

class ak implements al.a {
  ak(MainSetting paramMainSetting, String paramString, HashMap paramHashMap) {}
  
  public void jI(String paramString) {
    Log.d("数据结果", paramString);
    try {
      if (!by.isNull(paramString)) {
        if ("FALSE".equals((new JSONObject(paramString)).getString("result"))) {
          this.csj.uploadHandler.sendEmptyMessage(0);
          return;
        } 
        h h = new h(this.csj);
        boolean bool = h.c(this.csk, this.csl);
        h.close();
        if (bool) {
          av av = new av(this.csj);
          av.qL((String)this.csl.get("sUserPassword"));
          av.close();
          this.csj.uploadHandler.sendEmptyMessage(1);
          return;
        } 
        this.csj.uploadHandler.sendEmptyMessage(0);
        return;
      } 
      this.csj.uploadHandler.sendEmptyMessage(0);
      return;
    } catch (Exception paramString) {
      a.e(paramString);
      this.csj.uploadHandler.sendEmptyMessage(0);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */