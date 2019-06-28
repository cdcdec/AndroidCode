package com.laiqian.ui.container;

import android.util.Pair;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.network.k;
import com.laiqian.pos.hardware.RootUrlParameter;
import io.reactivex.i;
import io.reactivex.j;
import java.util.HashMap;
import org.json.JSONObject;

class s extends Object implements j<Pair<Double, Double>> {
  s(q paramq, String paramString) {}
  
  public void a(i<Pair<Double, Double>> parami) throws Exception {
    k k = new k();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    hashMap.put("auth_type", "0");
    hashMap.put("version", "1.0");
    hashMap.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
    hashMap.put("code", this.dxy);
    JSONObject jSONObject = new JSONObject(k.b(hashMap, RootUrlParameter.cmx, 0));
    double d = jSONObject.optDouble("msg_no");
    if (d < 0.0D) {
      parami.am(new Pair(Double.valueOf(d), Double.valueOf(0.0D)));
      return;
    } 
    a.AZ().bX(this.dxy);
    jSONObject = jSONObject.optJSONObject("message");
    parami.am(new Pair(Double.valueOf(jSONObject.optDouble("discount_amount")), Double.valueOf(jSONObject.optDouble("min_amount"))));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */