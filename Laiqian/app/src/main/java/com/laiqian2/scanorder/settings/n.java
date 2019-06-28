package com.laiqian.scanorder.settings;

import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
  private double aJW;
  
  private String name;
  
  private int type;
  
  public n(int paramInt, String paramString, double paramDouble) {
    this.type = paramInt;
    this.name = paramString;
    this.aJW = paramDouble;
  }
  
  @NonNull
  public static n s(@NonNull JSONObject paramJSONObject) { return new n(paramJSONObject.optInt("type", 0), paramJSONObject.optString("name", null), paramJSONObject.optDouble("amount", 0.0D)); }
  
  public double AO() { return this.aJW; }
  
  public void aG(double paramDouble) { this.aJW = paramDouble; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof n))
      return false; 
    paramObject = (n)paramObject;
    return !(this.name != paramObject.name);
  }
  
  public String getName() { return this.name; }
  
  public int getType() { return this.type; }
  
  public void setName(String paramString) { this.name = paramString; }
  
  public void setType(int paramInt) { this.type = paramInt; }
  
  @NonNull
  public JSONObject xy() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    if (this.name != null)
      jSONObject.put("name", this.name); 
    jSONObject.put("amount", this.aJW);
    jSONObject.put("type", this.type);
    return jSONObject;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */