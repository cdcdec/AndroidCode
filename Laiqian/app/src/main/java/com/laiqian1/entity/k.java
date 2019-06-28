package com.laiqian.entity;

import android.support.annotation.RequiresApi;
import android.util.Log;
import com.laiqian.d.a;
import com.laiqian.util.n;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
  public static k aSk = new k(false, false, true, false, false);
  
  public boolean aSl;
  
  public boolean aSm;
  
  public boolean aSn;
  
  public boolean aSo;
  
  public boolean aSp;
  
  public k() {}
  
  public k(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
    this.aSl = paramBoolean1;
    this.aSm = paramBoolean2;
    this.aSn = paramBoolean3;
    this.aSo = paramBoolean4;
    this.aSp = paramBoolean5;
  }
  
  public static k Fb() throws JSONException {
    k k1 = new k();
    JSONObject jSONObject = new JSONObject(a.AZ().CB());
    k1.cv(jSONObject.optBoolean("neglectSwitch", false));
    k1.cw(jSONObject.optBoolean("neglectSmallYuan", false));
    k1.cx(jSONObject.optBoolean("neglectSmallJiao", true));
    k1.cy(jSONObject.optBoolean("roundSmallYuan", false));
    k1.cz(jSONObject.optBoolean("roundSmallJiao", false));
    return k1;
  }
  
  public static double a(Double paramDouble, int paramInt) {
    String str1;
    if (Double.isNaN(paramDouble.doubleValue()) || paramDouble == null) {
      str1 = new StringBuilder();
      str1.append("parseAmount =");
      str1.append(paramDouble);
      Log.i("emery", str1.toString());
      return 0.0D;
    } 
    String str2 = paramDouble.toString();
    if (paramInt == 0) {
      str1 = str2;
      if (str2.contains("."))
        str1 = str2.substring(0, str2.lastIndexOf(".")); 
    } else {
      String[] arrayOfString;
      if (paramInt == 1) {
        str1 = str2;
        if (str2.contains(".")) {
          arrayOfString = str2.split("\\.");
          str1 = str2;
          if (arrayOfString != null) {
            str1 = str2;
            if (arrayOfString[1].length() > 1) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(arrayOfString[0]);
              stringBuilder.append(".");
              stringBuilder.append(arrayOfString[1].substring(0, 1));
              String str = stringBuilder.toString();
            } 
          } 
        } 
      } else {
        if (paramInt == 2)
          return n.f(arrayOfString.doubleValue(), 0); 
        str1 = str2;
        if (paramInt == 3)
          return n.f(arrayOfString.doubleValue(), 1); 
      } 
    } 
    return Double.parseDouble(str1);
  }
  
  public static boolean a(k paramk) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramk.aSl);
    stringBuilder.append("");
    jSONObject.put("neglectSwitch", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramk.aSm);
    stringBuilder.append("");
    jSONObject.put("neglectSmallYuan", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramk.aSn);
    stringBuilder.append("");
    jSONObject.put("neglectSmallJiao", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramk.aSo);
    stringBuilder.append("");
    jSONObject.put("roundSmallYuan", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramk.aSp);
    stringBuilder.append("");
    jSONObject.put("roundSmallJiao", stringBuilder.toString());
    return a.AZ().ch(jSONObject.toString());
  }
  
  public boolean Fc() { return this.aSm; }
  
  public boolean Fd() { return this.aSn; }
  
  public boolean Fe() { return this.aSo; }
  
  public boolean Ff() { return this.aSp; }
  
  protected k Fg() throws JSONException { return new k(this.aSl, this.aSm, this.aSn, this.aSo, this.aSp); }
  
  public void cv(boolean paramBoolean) { this.aSl = paramBoolean; }
  
  public void cw(boolean paramBoolean) { this.aSm = paramBoolean; }
  
  public void cx(boolean paramBoolean) { this.aSn = paramBoolean; }
  
  public void cy(boolean paramBoolean) { this.aSo = paramBoolean; }
  
  public void cz(boolean paramBoolean) { this.aSp = paramBoolean; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof k))
      return false; 
    paramObject = (k)paramObject;
    return (this.aSl == paramObject.aSl && this.aSm == paramObject.aSm && this.aSn == paramObject.aSn && this.aSo == paramObject.aSo && this.aSp == paramObject.aSp);
  }
  
  @RequiresApi
  public int hashCode() { return Objects.hash(new Object[] { Boolean.valueOf(this.aSl), Boolean.valueOf(this.aSm), Boolean.valueOf(this.aSn), Boolean.valueOf(this.aSo), Boolean.valueOf(this.aSp) }); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */