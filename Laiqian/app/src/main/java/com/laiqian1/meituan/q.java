package com.laiqian.meituan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.pos.dn;
import org.json.JSONException;
import org.json.JSONObject;

class q extends BroadcastReceiver {
  q(MeituanActivity paramMeituanActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent.getAction().equals("msg-token"))
      try {
        JSONObject jSONObject = (new JSONObject(paramIntent.getStringExtra("value"))).getJSONObject("token");
        RootApplication.getLaiqianPreferenceManager().rv(jSONObject.optString("appAuthToken"));
        a.AZ().bW(jSONObject.optString("appAuthToken"));
        this.bqa.Eo();
        (new dn(this.bqa)).start();
        this.bqa.startActivity(new Intent(this.bqa, MeituanIntroActivity.class));
        return;
      } catch (JSONException paramContext) {
        a.e(paramContext);
      }  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */