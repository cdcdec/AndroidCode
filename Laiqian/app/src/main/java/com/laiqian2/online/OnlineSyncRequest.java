package com.laiqian.online;

import android.support.annotation.NonNull;
import com.laiqian.models.ao;
import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OnlineSyncRequest {
  @Json(name = "password")
  private final String bJb;
  
  @Json(name = "shop_id")
  private final long bJc;
  
  @Json(name = "data")
  private ArrayList<b> bJf = new ArrayList();
  
  @Json(name = "auth_type")
  @AccountTypes
  private final int type;
  
  @Json(name = "username")
  public final String userName;
  
  @Json(name = "version")
  public final String version = "1.1";
  
  OnlineSyncRequest(@NonNull String paramString1, @NonNull String paramString2, long paramLong) {
    this.userName = paramString1;
    this.bJb = paramString2;
    this.type = 0;
    this.bJc = paramLong;
  }
  
  public String IX() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("username", this.userName);
    jSONObject.put("password", this.bJb);
    jSONObject.put("auth_type", String.valueOf(this.type));
    jSONObject.put("version", "1.1");
    jSONObject.put("shop_id", String.valueOf(this.bJc));
    JSONArray jSONArray = new JSONArray();
    for (b b : this.bJf) {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("table", b.bXU.Vz());
      JSONObject jSONObject2 = new JSONObject();
      for (ao.c c : b.bXU.VX()) {
        if (c.hasValue())
          jSONObject2.put(c.VY().getName(), c.getValue().toString()); 
      } 
      jSONObject1.put("record", jSONObject2);
      switch (b.type) {
        case 3:
          jSONObject1.put("operate_type", "delete");
          break;
        case 2:
          jSONObject1.put("operate_type", "update");
          break;
        case 1:
          jSONObject1.put("operate_type", "insert");
          break;
      } 
      jSONArray.put(jSONObject1);
    } 
    jSONObject.put("data", jSONArray);
    return jSONObject.toString();
  }
  
  public ArrayList<b> Xi() { return this.bJf; }
  
  class OnlineSyncRequest {}
  
  class OnlineSyncRequest {}
  
  public static class a {
    private long bJc = -1L;
    
    private ArrayList<OnlineSyncRequest.b> bJf = new ArrayList();
    
    private String password;
    
    private String userName;
    
    public OnlineSyncRequest Xj() {
      if (this.userName == null)
        throw new NullPointerException("missing user name"); 
      if (this.password == null)
        throw new NullPointerException("missing user password"); 
      if (this.bJc == -1L)
        throw new NullPointerException("missing shop id"); 
      OnlineSyncRequest onlineSyncRequest;
      (onlineSyncRequest = new OnlineSyncRequest(this.userName, this.password, this.bJc)).c(onlineSyncRequest).addAll(this.bJf);
      return onlineSyncRequest;
    }
    
    public a a(ao.a param1a, @OperateTypes int param1Int) {
      this.bJf.add(new OnlineSyncRequest.b(param1a, param1Int));
      return this;
    }
    
    public a a(Collection<? extends ao.a> param1Collection, @OperateTypes int param1Int) {
      Iterator iterator = param1Collection.iterator();
      while (iterator.hasNext())
        a((ao.a)iterator.next(), param1Int); 
      return this;
    }
    
    public a bV(long param1Long) {
      this.bJc = param1Long;
      return this;
    }
    
    public a iM(String param1String) {
      this.userName = param1String;
      return this;
    }
    
    public a iN(String param1String) {
      this.password = param1String;
      return this;
    }
  }
  
  public static class b {
    ao.a bXU;
    
    @OperateTypes
    int type;
    
    public b(ao.a param1a, @OperateTypes int param1Int) {
      this.bXU = param1a;
      this.type = param1Int;
    }
    
    class b {}
  }
  
  class OnlineSyncRequest {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\online\OnlineSyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */