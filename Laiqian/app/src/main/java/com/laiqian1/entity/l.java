package com.laiqian.entity;

import org.json.JSONObject;

public class l {
  private String aSq;
  
  private String msg;
  
  public static l b(JSONObject paramJSONObject) {
    l l1 = new l();
    l1.aSq = paramJSONObject.optString("msg_id");
    l1.msg = paramJSONObject.optString("msg");
    return l1;
  }
  
  public String Fh() { return this.msg; }
  
  public String Fi() { return this.aSq; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */