package com.laiqian.meituan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.pos.industry.a;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import io.reactivex.g.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class am extends BroadcastReceiver {
  am(TuanGouActivity paramTuanGouActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent.getAction().equals("msg-token"))
      try {
        JSONObject jSONObject = new JSONObject(paramIntent.getStringExtra("value"));
        String str = jSONObject.optString("poiName");
        jSONObject = jSONObject.getJSONObject("token");
        RootApplication.getLaiqianPreferenceManager().rv(jSONObject.optString("appAuthToken"));
        a.AZ().bW(jSONObject.optString("appAuthToken"));
        a.AZ().bV(str);
        this.brn.Eo();
        this.brn.bpX.PC();
        a.aKh().r(an.baQ);
        a.aKh().r(new ao(paramContext));
        return;
      } catch (JSONException paramContext) {
        a.e(paramContext);
      }  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */