package com.laiqian.alipay.a;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public String aBW;
  
  public double aBX;
  
  public String aBY;
  
  public JSONObject xy() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("TC", this.aBX);
      jSONObject.put("OTN", this.aBW);
      jSONObject.put("STAT", this.aBY);
      return jSONObject;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return jSONObject;
    } 
  }
  
  public void xz() {
    JSONArray jSONArray;
    try {
      jSONArray = new JSONArray(RootApplication.getLaiqianPreferenceManager().avI());
    } catch (JSONException null) {
      a.e(null);
      jSONArray = new JSONArray();
    } 
    jSONArray.put(xy());
    RootApplication.getLaiqianPreferenceManager().rD(String.valueOf(jSONArray));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */