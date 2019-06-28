package com.laiqian.pos;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class dc {
  @Nullable
  public String address;
  
  @Nullable
  public String ciI;
  
  @Nullable
  public String ciJ;
  
  @NonNull
  public static dc j(@NonNull JSONObject paramJSONObject) {
    dc dc1 = new dc();
    dc1.ciI = paramJSONObject.optString("companyName", null);
    dc1.address = paramJSONObject.optString("address", null);
    dc1.ciJ = paramJSONObject.optString("regNo", null);
    return dc1;
  }
  
  @NonNull
  public JSONObject xy() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    if (this.ciI != null)
      jSONObject.put("companyName", this.ciI); 
    if (this.address != null)
      jSONObject.put("address", this.address); 
    if (this.ciJ != null)
      jSONObject.put("regNo", this.ciJ); 
    return jSONObject;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */