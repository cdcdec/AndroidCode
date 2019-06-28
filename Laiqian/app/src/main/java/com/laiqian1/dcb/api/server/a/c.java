package com.laiqian.dcb.api.server.a;

import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.b.j;
import io.netty.channel.n;
import io.netty.channel.s;
import io.netty.channel.t;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  public static JSONObject a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("method", paramInt1);
      jSONObject.put("result", paramInt2);
      jSONObject.put("table", paramString1);
      jSONObject.put("data", paramString2);
      jSONObject.put("from", paramString3);
      jSONObject.put("servertime", System.currentTimeMillis());
      return jSONObject;
    } catch (JSONException paramString1) {
      a.e(paramString1);
      return jSONObject;
    } 
  }
  
  public static void a(n paramn, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) { a(paramn, paramInt1, paramInt2, paramString1, paramString2, paramString3, null); }
  
  public static void a(n paramn, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, t paramt) {
    s s = paramn.aM(j.cG(a(paramInt1, paramInt2, paramString1, paramString2, paramString3).toString()));
    if (paramt != null)
      s.a(paramt); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */