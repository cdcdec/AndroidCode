package com.laiqian.login.c;

import android.content.Context;
import android.os.AsyncTask;
import com.google.a.a.a.a.a.a;
import com.laiqian.message.m;
import com.laiqian.models.bh;
import com.laiqian.pos.industry.a;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.orhanobut.logger.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends AsyncTask<Void, String, String> {
  public String aSI;
  
  public String aYR;
  
  a aYS;
  
  public Context context;
  
  public String password;
  
  public void a(a parama) { this.aYS = parama; }
  
  protected String b(Void... paramVarArgs) {
    HashMap hashMap = new HashMap();
    String str = (new bh(this.context)).iE(this.aYR);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(str);
    hashMap.put("user_name", stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("");
    stringBuilder1.append(this.password);
    hashMap.put("password", stringBuilder1.toString());
    hashMap.put("auth_type", "0");
    hashMap.put("version", "1");
    hashMap.put("shop_id", this.aSI);
    hashMap.put("device_id", m.Tw());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(m.getDeviceType());
    stringBuilder1.append("");
    hashMap.put("device_type", stringBuilder1.toString());
    return bh.a(a.cqr, null, hashMap);
  }
  
  protected void bf(String paramString) {
    super.onPostExecute(paramString);
    boolean bool = by.isNull(paramString);
    byte b = 0;
    int i = b;
    if (!bool) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("数据库是否更新 json=");
      stringBuilder.append(paramString);
      d.b(stringBuilder.toString(), new Object[0]);
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        i = b;
        if ("true".equalsIgnoreCase(jSONObject.optString("result")))
          boolean bool1 = jSONObject.optBoolean("message"); 
      } catch (JSONException paramString) {
        a.e(paramString);
        i = b;
      } 
    } 
    if (this.aYS != null)
      this.aYS.db(i); 
  }
  
  public static interface a {
    void db(boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */