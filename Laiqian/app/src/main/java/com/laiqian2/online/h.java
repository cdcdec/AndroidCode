package com.laiqian.online;

import org.json.JSONException;
import org.json.JSONObject;

public class h {
  public final int bUj;
  
  public final boolean bXV;
  
  public final String message;
  
  public h(boolean paramBoolean, int paramInt, String paramString) {
    this.bXV = paramBoolean;
    this.bUj = paramInt;
    this.message = paramString;
  }
  
  public static h iO(String paramString) throws JSONException {
    JSONObject jSONObject = new JSONObject(paramString);
    return new h(jSONObject.optBoolean("result"), jSONObject.optInt("msg_no"), jSONObject.optString("message"));
  }
  
  class h {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\online\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */