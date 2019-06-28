package com.laiqian.dcb.api.client.a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.client.h;
import io.netty.channel.s;
import io.netty.channel.t;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static String a(Context paramContext, int paramInt, String paramString) {
    JSONObject jSONObject = new JSONObject();
    g g = new g(paramContext);
    try {
      jSONObject.put("phone", g.Ea());
      jSONObject.put("pwd", g.Ec().trim());
      jSONObject.put("method", paramInt);
      jSONObject.put("device", "android");
      jSONObject.put("brand", Build.BRAND);
      jSONObject.put("imei", ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId());
      jSONObject.put("data", paramString);
    } catch (JSONException paramContext) {
      a.e(paramContext);
    } 
    return jSONObject.toString();
  }
  
  public static void a(String paramString, t paramt) {
    paramString = j.cG(paramString);
    if (h.isActive()) {
      s s = (h.DI()).aPd.aM(paramString);
      if (paramt != null)
        s.a(paramt); 
    } 
  }
  
  public static void cz(String paramString) { a(paramString, null); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */