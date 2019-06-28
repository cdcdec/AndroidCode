package com.laiqian.wallet;

import com.google.a.a.a.a.a.a;
import com.laiqian.util.by;
import org.json.JSONObject;

class p extends Thread {
  p(Withdrawals paramWithdrawals) {}
  
  public void run() {
    try {
      JSONObject jSONObject = Withdrawals.bl(by.parseDouble(Withdrawals.b(this.dLH).getText().toString().trim()));
      if ("TRUE".equals(jSONObject.optString("result"))) {
        jSONObject = new JSONObject(jSONObject.optString("message"));
        String str1 = jSONObject.optString("return_code");
        String str2 = jSONObject.optString("result_code");
        if ("SUCCESS".equals(str1) && "SUCCESS".equals(str2)) {
          Withdrawals.h(this.dLH).obtainMessage(1).sendToTarget();
          return;
        } 
        Withdrawals.h(this.dLH).obtainMessage(-1, jSONObject.optString("err_code_des")).sendToTarget();
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */