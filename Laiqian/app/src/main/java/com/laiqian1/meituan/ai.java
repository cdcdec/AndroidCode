package com.laiqian.meituan;

import org.json.JSONObject;

public class ai {
  public int aQZ;
  
  public int bpU = -1;
  
  public String brg;
  
  public int brh;
  
  public String name;
  
  public ai f(JSONObject paramJSONObject) {
    ai ai1 = new ai();
    ai1.brg = paramJSONObject.optString("ePoiId");
    ai1.name = paramJSONObject.optString("name");
    ai1.aQZ = paramJSONObject.optInt("isOpen");
    ai1.brh = paramJSONObject.optInt("isOnline");
    return ai1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */