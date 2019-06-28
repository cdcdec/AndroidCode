package com.laiqian.member;

import com.squareup.moshi.Json;

public class ca {
  @Json(name = "shop_id")
  public final String bst;
  
  @Json(name = "user_name")
  public final String bsu;
  
  @Json(name = "auth_type")
  public final String bsv;
  
  @Json(name = "scope")
  public final String bsw;
  
  @Json(name = "sql")
  public final String bsx;
  
  @Json(name = "paras")
  public final String[] bsy;
  
  @Json(name = "password")
  public final String password;
  
  @Json(name = "version")
  public final String version;
  
  public ca(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String[] paramArrayOfString) {
    this.bst = paramString1;
    this.bsu = paramString2;
    this.password = paramString3;
    this.bsv = paramString4;
    this.version = paramString5;
    this.bsw = paramString6;
    this.bsx = paramString7;
    this.bsy = paramArrayOfString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("VipItemRequest{shop_id='");
    stringBuilder.append(this.bst);
    stringBuilder.append('\'');
    stringBuilder.append(", user_name='");
    stringBuilder.append(this.bsu);
    stringBuilder.append('\'');
    stringBuilder.append(", password='");
    stringBuilder.append(this.password);
    stringBuilder.append('\'');
    stringBuilder.append(", auth_type='");
    stringBuilder.append(this.bsv);
    stringBuilder.append('\'');
    stringBuilder.append(", version='");
    stringBuilder.append(this.version);
    stringBuilder.append('\'');
    stringBuilder.append(", scope='");
    stringBuilder.append(this.bsw);
    stringBuilder.append('\'');
    stringBuilder.append(", sql='");
    stringBuilder.append(this.bsx);
    stringBuilder.append('\'');
    stringBuilder.append(", paras='");
    stringBuilder.append(this.bsy);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */