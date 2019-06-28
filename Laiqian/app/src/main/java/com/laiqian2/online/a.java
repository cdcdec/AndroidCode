package com.laiqian.online;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.b;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private JSONArray bXH = new JSONArray();
  
  private Context mContext;
  
  public a(Context paramContext) { this.mContext = paramContext; }
  
  public String C(String paramString1, String paramString2, String paramString3) throws RuntimeException {
    null = new av(this.mContext);
    String str1 = null.Ea();
    String str2 = null.atr();
    null.close();
    JSONObject jSONObject = new JSONObject();
    try {
      JSONArray jSONArray = D(paramString1, paramString2, paramString3);
      jSONObject.put("username", str1);
      jSONObject.put("password", str2);
      jSONObject.put("data", jSONArray);
      bb.fU(jSONObject.toString());
      return b.cL(jSONObject.toString());
    } catch (Exception paramString1) {
      a.e(paramString1);
      RuntimeException runtimeException = new RuntimeException();
      runtimeException.initCause(paramString1);
      throw runtimeException;
    } 
  }
  
  public JSONArray D(String paramString1, String paramString2, String paramString3) throws JSONException {
    paramString1 = E(paramString1, paramString2, paramString3);
    this.bXH.put(paramString1);
    return this.bXH;
  }
  
  public String E(String paramString1, String paramString2, String paramString3) throws RuntimeException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("table", paramString1);
    jSONObject.put("fields", paramString2);
    jSONObject.put("value", paramString3);
    return jSONObject.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\online\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */