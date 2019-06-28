package com.laiqian.entity;

import java.util.Iterator;
import org.json.JSONObject;

public class m {
  private int status;
  
  private String type;
  
  public static m c(JSONObject paramJSONObject) {
    try {
      Iterator iterator = paramJSONObject.keys();
      m m1 = null;
      while (iterator.hasNext()) {
        m1 = new m();
        m1.type = iterator.next().toString();
        m1.status = paramJSONObject.optInt(m1.type);
      } 
      return m1;
    } catch (Exception paramJSONObject) {
      return null;
    } 
  }
  
  public int getStatus() { return this.status; }
  
  public String getType() { return this.type; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */