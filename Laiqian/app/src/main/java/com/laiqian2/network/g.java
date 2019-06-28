package com.laiqian.network;

import com.google.a.a.a.a.a.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
  private String acL;
  
  public g(String paramString) { this.acL = paramString; }
  
  public String oV() { return this.acL; }
  
  public String toString() {
    JSONArray jSONArray = new JSONArray();
    try {
      JSONArray jSONArray1 = (new JSONObject(this.acL)).optJSONArray("data");
      for (byte b = 0; b < jSONArray1.length(); b++) {
        JSONObject jSONObject2 = jSONArray1.optJSONObject(b);
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("table", jSONObject2.optString("table"));
        jSONObject1.put("operate_type", jSONObject2.optString("operate_type"));
        jSONObject2 = jSONObject2.optJSONObject("record");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("sProductName", jSONObject2.optString("sProductName"));
        jSONObject3.put("fAmount", jSONObject2.optString("fAmount"));
        jSONObject3.put("sOrderNo", jSONObject2.optString("sOrderNo"));
        jSONObject1.put("record", jSONObject3);
        jSONArray.put(b, jSONObject1);
      } 
    } catch (JSONException jSONException) {
      a.e(jSONException);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LqkNetworkRequest{content='");
    stringBuilder.append(jSONArray.toString());
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */