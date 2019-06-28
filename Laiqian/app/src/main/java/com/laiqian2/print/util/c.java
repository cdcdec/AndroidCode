package com.laiqian.print.util;

import com.google.a.a.a.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  private Double cOq = null;
  
  private ArrayList<a> cOr = null;
  
  public c(InputStream paramInputStream) {
    try {
      byte[] arrayOfByte = new byte[paramInputStream.available()];
      paramInputStream.read(arrayOfByte);
      iOException = new String(arrayOfByte);
    } catch (IOException iOException) {
      a.e(iOException);
      iOException = null;
    } 
    if (iOException != null) {
      if (iOException.isEmpty())
        return; 
      try {
        JSONObject jSONObject = new JSONObject(iOException);
        if (jSONObject.has("version")) {
          this.cOq = Double.valueOf(jSONObject.getDouble("version"));
        } else {
          this.cOq = null;
        } 
        if (jSONObject.has("printers")) {
          this.cOr = new ArrayList();
          JSONArray jSONArray = jSONObject.getJSONArray("printers");
          int i = jSONArray.length();
          for (byte b = 0; b < i; b++) {
            a a = r(jSONArray.getJSONObject(b));
            if (a != null)
              this.cOr.add(a); 
          } 
        } 
        try {
          paramInputStream.close();
          return;
        } catch (IOException paramInputStream) {
          a.e(paramInputStream);
        } 
      } catch (JSONException iOException) {
        a.e(iOException);
        paramInputStream.close();
        return;
      } finally {}
      return;
    } 
  }
  
  private a r(JSONObject paramJSONObject) {
    a a = new a();
    try {
      if (paramJSONObject.has("type"))
        a.setType(paramJSONObject.getString("type")); 
      if (paramJSONObject.has("vendorId"))
        a.mc(paramJSONObject.getString("vendorId")); 
      if (paramJSONObject.has("productId"))
        a.mf(paramJSONObject.getString("productId")); 
      if (paramJSONObject.has("name"))
        a.setName(paramJSONObject.getString("name")); 
      if (paramJSONObject.has("protocol"))
        a.md(paramJSONObject.getString("protocol")); 
      if (paramJSONObject.has("size"))
        a.me(paramJSONObject.getString("size")); 
      return a;
    } catch (JSONException paramJSONObject) {
      a.e(paramJSONObject);
      return null;
    } 
  }
  
  public Double ajb() { return this.cOq; }
  
  public static class a {
    private String cOs = null;
    
    private String cOt = null;
    
    private String cOu = null;
    
    private String cOv = null;
    
    private String name = null;
    
    private String protocol = null;
    
    private String type = null;
    
    void mc(String param1String) { this.cOs = param1String; }
    
    void md(String param1String) { this.protocol = param1String; }
    
    void me(String param1String) { this.cOv = param1String; }
    
    void mf(String param1String) { this.cOt = param1String; }
    
    void setName(String param1String) { this.name = param1String; }
    
    void setType(String param1String) { this.type = param1String; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */