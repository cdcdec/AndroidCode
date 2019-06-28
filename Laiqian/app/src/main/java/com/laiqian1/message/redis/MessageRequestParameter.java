package com.laiqian.message.redis;

import android.support.annotation.NonNull;
import com.laiqian.message.m;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageRequestParameter {
  private final String bJb;
  
  private final long bJc;
  
  private final String bJd;
  
  private final int bJe;
  
  private ArrayList<HashMap<String, Object>> bJf = new ArrayList();
  
  @AccountTypes
  private final int type;
  
  private final String userName;
  
  private final String version;
  
  MessageRequestParameter(@NonNull String paramString1, @NonNull String paramString2, long paramLong) {
    this.userName = paramString1;
    this.bJb = paramString2;
    this.type = 0;
    this.bJc = paramLong;
    this.version = "1.0";
    this.bJd = m.Tw();
    this.bJe = m.getDeviceType();
  }
  
  public String IX() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("user_name", this.userName);
    jSONObject.put("password", this.bJb);
    jSONObject.put("auth_type", String.valueOf(this.type));
    jSONObject.put("version", this.version);
    jSONObject.put("shop_id", String.valueOf(this.bJc));
    jSONObject.put("deceive_id", String.valueOf(this.bJd));
    jSONObject.put("deceive_type", String.valueOf(this.bJe));
    new JSONArray();
    for (HashMap hashMap : this.bJf) {
      if (hashMap != null)
        for (Map.Entry entry : hashMap.entrySet())
          jSONObject.put((String)entry.getKey(), entry.getValue());  
    } 
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("json is:");
    stringBuilder.append(jSONObject.toString());
    printStream.println(stringBuilder.toString());
    return jSONObject.toString();
  }
  
  public static @interface AccountTypes {}
  
  public static @interface OperateTypes {}
  
  public static class a {
    private long bJc = -1L;
    
    private ArrayList<HashMap<String, Object>> bJf = new ArrayList();
    
    private String password;
    
    private String userName;
    
    public MessageRequestParameter Tz() {
      if (this.userName == null)
        throw new NullPointerException("missing user name"); 
      if (this.password == null)
        throw new NullPointerException("missing user password"); 
      if (this.bJc == -1L)
        throw new NullPointerException("missing shop id"); 
      if (this.bJf.size() == 0)
        throw new NullPointerException("missing content"); 
      MessageRequestParameter messageRequestParameter;
      (messageRequestParameter = new MessageRequestParameter(this.userName, this.password, this.bJc)).a(messageRequestParameter, this.bJf);
      return messageRequestParameter;
    }
    
    public a aG(long param1Long) {
      this.bJc = param1Long;
      return this;
    }
    
    public a gF(String param1String) {
      this.userName = param1String;
      return this;
    }
    
    public a gG(String param1String) {
      this.password = param1String;
      return this;
    }
    
    public a y(HashMap<String, Object> param1HashMap) {
      this.bJf.add(param1HashMap);
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\redis\MessageRequestParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */