package com.laiqian.entity;

import android.support.annotation.Nullable;
import com.laiqian.basic.LQKVersion;
import com.laiqian.f.b;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import org.json.JSONObject;

public class an {
  public static an aVj;
  
  public final String aVk;
  
  public final String aVl;
  
  public final String aVm;
  
  @Nullable
  public final JSONObject aVn;
  
  public final String host;
  
  public final String password;
  
  public final String protocol;
  
  public int version = 3;
  
  private an() throws Exception {
    null = new StringBuilder();
    null.append(RootUrlParameter.cls);
    null.append("?type=");
    null.append(LQKVersion.zh());
    null.append("&version=");
    null.append(this.version);
    JSONObject jSONObject = new JSONObject(b.cM(bd.rV(null.toString())));
    this.aVk = jSONObject.getString("name");
    this.password = jSONObject.getString("password");
    this.protocol = jSONObject.optString("protocol", "smtp");
    this.host = jSONObject.optString("host", "smtp.exmail.qq.com");
    this.aVl = jSONObject.optString("port", "25");
    this.aVm = jSONObject.optString("auth", "true");
    jSONObject = jSONObject.optJSONObject("other");
    if (jSONObject != null && jSONObject.length() > 0) {
      this.aVn = jSONObject;
    } else {
      this.aVn = null;
    } 
    n.println("重新获取了发送邮箱的账号");
  }
  
  public static an Ii() throws Exception {
    if (aVj == null)
      aVj = new an(); 
    return aVj;
  }
  
  public static void Ij() throws Exception { aVj = null; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SendMailEntity{account='");
    stringBuilder.append(this.aVk);
    stringBuilder.append('\'');
    stringBuilder.append(", password='");
    stringBuilder.append(this.password);
    stringBuilder.append('\'');
    stringBuilder.append(", protocol='");
    stringBuilder.append(this.protocol);
    stringBuilder.append('\'');
    stringBuilder.append(", host='");
    stringBuilder.append(this.host);
    stringBuilder.append('\'');
    stringBuilder.append(", port='");
    stringBuilder.append(this.aVl);
    stringBuilder.append('\'');
    stringBuilder.append(", auth='");
    stringBuilder.append(this.aVm);
    stringBuilder.append('\'');
    stringBuilder.append(", otherParameter=");
    stringBuilder.append(this.aVn);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */