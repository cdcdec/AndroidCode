package com.laiqian.print.printtype;

import android.support.annotation.NonNull;
import com.squareup.moshi.Json;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class j implements Serializable {
  @Json(name = "copies")
  public final int cCC;
  
  @Json(name = "print_type")
  public final String cJr;
  
  public j(a parama) {
    this.cJr = a.a(parama);
    this.cCC = a.b(parama);
  }
  
  public j(@NonNull String paramString, int paramInt) {
    this.cJr = paramString;
    this.cCC = paramInt;
  }
  
  public static j o(JSONObject paramJSONObject) throws JSONException { return (new a()).lF(paramJSONObject.getString("print_type")).iq(paramJSONObject.getInt("copies")).aho(); }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (j)paramObject;
      return (this.cCC != paramObject.cCC) ? false : (!!this.cJr.equals(paramObject.cJr));
    } 
    return false;
  }
  
  public int hashCode() { return this.cJr.hashCode() * 31 + this.cCC; }
  
  public JSONObject xy() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("print_type", this.cJr);
    jSONObject.put("copies", this.cCC);
    return jSONObject;
  }
  
  public static class a {
    private int cCC;
    
    private String type;
    
    public j aho() {
      if (this.type == null)
        throw new NullPointerException("type cannot be null"); 
      return new j(this);
    }
    
    public a iq(int param1Int) {
      this.cCC = param1Int;
      return this;
    }
    
    public a lF(String param1String) {
      this.type = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\printtype\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */