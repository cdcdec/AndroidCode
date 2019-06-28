package com.laiqian.member;

import com.squareup.moshi.Json;

public class cc {
  @Json(name = "shop_id")
  public final String bst;
  
  @Json(name = "user_name")
  public final String bsu;
  
  @Json(name = "auth_type")
  public final String bsv;
  
  @Json(name = "scope")
  public final String bsw;
  
  @Json(name = "filter")
  public final String bwc;
  
  @Json(name = "page")
  public final String bwd;
  
  @Json(name = "sort")
  public final String bwe;
  
  @Json(name = "sqlWithDoc")
  public final String bwf;
  
  @Json(name = "extend_filter_type")
  public String bwg = null;
  
  @Json(name = "password")
  public final String password;
  
  @Json(name = "version")
  public final String version;
  
  public cc(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10) {
    this.bst = paramString1;
    this.bsu = paramString2;
    this.password = paramString3;
    this.bsv = paramString4;
    this.version = paramString5;
    this.bsw = paramString6;
    this.bwd = paramString7;
    this.bwe = paramString8;
    this.bwc = paramString9;
    this.bwf = paramString10;
  }
  
  public cc(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11) {
    this.bst = paramString1;
    this.bsu = paramString2;
    this.password = paramString3;
    this.bsv = paramString4;
    this.version = paramString5;
    this.bsw = paramString6;
    this.bwd = paramString7;
    this.bwe = paramString8;
    this.bwc = paramString9;
    this.bwf = paramString10;
    this.bwg = paramString11;
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
    stringBuilder.append(", page='");
    stringBuilder.append(this.bwd);
    stringBuilder.append('\'');
    stringBuilder.append(", sort='");
    stringBuilder.append(this.bwe);
    stringBuilder.append('\'');
    stringBuilder.append(", filter='");
    stringBuilder.append(this.bwc);
    stringBuilder.append('\'');
    stringBuilder.append(", sqlWithDoc='");
    stringBuilder.append(this.bwf);
    stringBuilder.append('\'');
    stringBuilder.append(", typeFilter='");
    stringBuilder.append(this.bwg);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */