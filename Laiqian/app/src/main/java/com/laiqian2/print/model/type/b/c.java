package com.laiqian.print.model.type.b;

import android.support.annotation.NonNull;
import com.laiqian.print.model.s;

public class c extends s {
  @NonNull
  private String cId;
  
  private int cIe;
  
  public c(@NonNull String paramString, int paramInt) {
    super(paramString, 2);
    this.cId = paramString;
    this.cIe = paramInt;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(":");
    stringBuilder.append(paramInt);
    setName(stringBuilder.toString());
  }
  
  public static boolean lu(String paramString) {
    arrayOfString = paramString.split("\\.");
    if (arrayOfString.length != 4)
      return false; 
    try {
      int i = arrayOfString.length;
      byte b = 0;
      while (b < i) {
        long l = Long.parseLong(arrayOfString[b]);
        if (l >= 0L && l <= 255L) {
          b++;
          continue;
        } 
        return false;
      } 
      return true;
    } catch (NumberFormatException arrayOfString) {
      return false;
    } 
  }
  
  public String getAddress() { return this.cId; }
  
  public int getPort() { return this.cIe; }
  
  public void setAddress(String paramString) {
    lq(paramString);
    this.cId = paramString;
  }
  
  public void setPort(int paramInt) { this.cIe = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */