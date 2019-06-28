package com.laiqian.repair;

import org.json.JSONException;
import org.json.JSONObject;

public class e extends d {
  public String[] cXU;
  
  public String[] cXV;
  
  public long cXW;
  
  public int versionCode;
  
  private e(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt2, long paramLong) {
    super(paramInt1, paramString1, paramString2);
    boolean bool = "null".equals(paramString3);
    String str = null;
    if (bool)
      paramString3 = null; 
    paramString1 = paramString5;
    if ("null".equals(paramString5))
      paramString1 = null; 
    paramString2 = paramString7;
    if ("null".equals(paramString7))
      paramString2 = null; 
    paramString5 = paramString9;
    if ("null".equals(paramString9))
      paramString5 = null; 
    paramString7 = paramString11;
    if ("null".equals(paramString11))
      paramString7 = null; 
    this.cXU = new String[] { paramString3, paramString1, paramString2, paramString5, paramString7 };
    paramString1 = paramString4;
    if ("null".equals(paramString4))
      paramString1 = null; 
    paramString2 = paramString6;
    if ("null".equals(paramString6))
      paramString2 = null; 
    paramString3 = paramString8;
    if ("null".equals(paramString8))
      paramString3 = null; 
    if ("null".equals(paramString10))
      paramString10 = str; 
    this.cXV = new String[] { paramString1, paramString2, paramString3, paramString10 };
    this.versionCode = paramInt2;
    this.cXW = paramLong;
  }
  
  public e(JSONObject paramJSONObject) throws JSONException { this(paramJSONObject.getInt("_id"), paramJSONObject.getString("title"), paramJSONObject.getString("content"), paramJSONObject.getString("action1"), paramJSONObject.getString("action1_field"), paramJSONObject.getString("action2"), paramJSONObject.getString("action2_field"), paramJSONObject.getString("action3"), paramJSONObject.getString("action3_field"), paramJSONObject.getString("action4"), paramJSONObject.getString("action4_field"), paramJSONObject.getString("action5"), paramJSONObject.getInt("versionCode"), paramJSONObject.getLong("dataTime")); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */