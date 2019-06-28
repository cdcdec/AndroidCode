package com.laiqian.takeaway;

import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class ar implements al.a {
  ar(aq paramaq, String paramString) {}
  
  public void jI(String paramString) {
    Log.d("数据结果", paramString);
    am am = new am(aq.a(this.dtJ));
    bc bc = new bc(aq.a(this.dtJ));
    if (!TextUtils.isEmpty(paramString)) {
      byte b = 0;
      try {
        bc.updateOrders((new JSONObject(paramString)).getString("push_context"), false, false);
      } catch (JSONException jSONException) {
        a.e(jSONException);
        a.aKh().r(new as(paramString));
      } 
      RootApplication.zv().zC().c(3L, TimeUnit.SECONDS);
      ArrayList arrayList = am.oD(paramString);
      am.a(new av(this));
      if (arrayList == null || arrayList.size() == 0) {
        a.aKh().r(new at(paramString));
        return;
      } 
      while (b < arrayList.size()) {
        if (this.drK == "weixin" || this.drK == "koubei" || this.drK == "weixin_eat_in")
          am.a((TakeOrderEntity)arrayList.get(b), true, new aw(this)); 
        bc.j((TakeOrderEntity)arrayList.get(b));
        b++;
      } 
    } else {
      a.aKh().r(new au(paramString));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */