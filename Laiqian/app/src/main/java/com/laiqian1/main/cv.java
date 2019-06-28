package com.laiqian.main;

import com.google.a.a.a.a.a.a;
import com.laiqian.meituan.s;
import com.laiqian.util.n;
import java.util.HashMap;
import org.json.JSONObject;

class cv implements Runnable {
  cv(cs paramcs) {}
  
  public void run() {
    try {
      HashMap hashMap = s.fm(cs.e(this.bde).getText().toString().replace(" ", ""));
      JSONObject jSONObject = cs.a(this.bde, hashMap);
      if (jSONObject != null) {
        int i = jSONObject.optInt("count");
        int j = jSONObject.optInt("minConsume");
        String str = jSONObject.optString("couponCode");
        double d1 = jSONObject.optDouble("dealValue");
        double d2 = jSONObject.optDouble("couponBuyPrice");
        if (j > 0 && j == i) {
          cs.a(this.bde, str, j, d1, d2);
        } else {
          String str1 = jSONObject.optString("dealTitle");
          String str2 = jSONObject.optString("couponEndTime");
          long l = n.a(null, str2).normalize(false);
          if (System.currentTimeMillis() >= l + 86400000L) {
            cs.a(this.bde, 2131627328);
            cs.d(this.bde).sendEmptyMessage(21);
            return;
          } 
          cs.d d = new cs.d(this.bde, str1, str, d1, d2, j, i, str2, null);
          cs.d(this.bde).obtainMessage(231, d).sendToTarget();
        } 
      } 
    } catch (Throwable throwable) {
      a.e(throwable);
      cs.a(this.bde, "未知错误");
    } finally {
      bb bb;
    } 
    cs.d(this.bde).sendEmptyMessage(21);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */