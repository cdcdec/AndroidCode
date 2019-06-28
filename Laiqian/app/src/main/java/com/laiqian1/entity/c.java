package com.laiqian.entity;

import com.laiqian.util.by;
import java.io.Serializable;

public class c extends aq implements Serializable {
  public static final c aRx = new c(0L, "", "", "", 0.0D, 0.0D, false, false);
  
  public String aRu;
  
  public String aRv;
  
  public int aRw;
  
  public boolean aRy;
  
  public String address;
  
  public c() {}
  
  public c(long paramLong, String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2) {
    this.aSW = paramLong;
    this.aWn = paramString1;
    this.name = paramString2;
    this.aTp = paramString3;
    this.aWo = paramDouble1;
    this.discount = paramDouble2;
    this.aWp = paramInt1;
    this.aWC = paramInt2;
  }
  
  public static String cN(String paramString) {
    if (by.isNull(paramString))
      return ""; 
    if (paramString != null && paramString.split("-").length == 2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("1990-");
      stringBuilder.append(paramString);
      return stringBuilder.toString();
    } 
    return paramString;
  }
  
  public static a cO(String paramString) {
    a a = new a();
    String[] arrayOfString = paramString.split("-");
    if (arrayOfString.length > 2) {
      a.year = Integer.parseInt(arrayOfString[0]);
      a.month = Integer.valueOf(arrayOfString[1]).intValue() - 1;
      a.day = Integer.valueOf(arrayOfString[2]).intValue();
      return a;
    } 
    if (arrayOfString.length == 2) {
      a.month = Integer.valueOf(arrayOfString[0]).intValue() - 1;
      a.day = Integer.valueOf(arrayOfString[1]).intValue();
    } 
    return a;
  }
  
  public static class a {
    public int day;
    
    public int month;
    
    public int year;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */