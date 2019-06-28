package com.laiqian.network;

import android.support.annotation.NonNull;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LqkRequest {
  private final String bJb;
  
  private final long bJc;
  
  private ArrayList<HashMap<String, Object>> bJf = new ArrayList();
  
  @AccountTypes
  private final int type;
  
  private final String userName;
  
  private final String version = "3.0";
  
  LqkRequest(@NonNull String paramString1, @NonNull String paramString2, long paramLong) {
    this.userName = paramString1;
    this.bJb = paramString2;
    this.type = 0;
    this.bJc = paramLong;
  }
  
  public String IX() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("user_name", this.userName);
    jSONObject.put("password", this.bJb);
    jSONObject.put("auth_type", String.valueOf(this.type));
    jSONObject.put("version", "3.0");
    jSONObject.put("shop_id", String.valueOf(this.bJc));
    new JSONArray();
    Iterator iterator = this.bJf.iterator();
    while (iterator.hasNext()) {
      for (Map.Entry entry : ((HashMap)iterator.next()).entrySet())
        jSONObject.put((String)entry.getKey(), entry.getValue()); 
    } 
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("json is:");
    stringBuilder.append(jSONObject.toString());
    printStream.println(stringBuilder.toString());
    return jSONObject.toString();
  }
  
  class LqkRequest {}
  
  class LqkRequest {}
  
  public static class a {
    private long bJc = -1L;
    
    private ArrayList<HashMap<String, Object>> bJf = new ArrayList();
    
    private String password;
    
    private String userName;
    
    public a A(HashMap<String, Object> param1HashMap) {
      this.bJf.add(param1HashMap);
      return this;
    }
    
    public LqkRequest WO() {
      if (this.userName == null)
        throw new NullPointerException("missing user name"); 
      if (this.password == null)
        throw new NullPointerException("missing user password"); 
      if (this.bJc == -1L)
        throw new NullPointerException("missing shop id"); 
      if (this.bJf.size() == 0)
        throw new NullPointerException("missing content"); 
      LqkRequest lqkRequest;
      (lqkRequest = new LqkRequest(this.userName, this.password, this.bJc)).a(lqkRequest, this.bJf);
      return lqkRequest;
    }
    
    public a bU(long param1Long) {
      this.bJc = param1Long;
      return this;
    }
    
    public a iG(String param1String) {
      this.userName = param1String;
      return this;
    }
    
    public a iH(String param1String) {
      this.password = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\LqkRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */