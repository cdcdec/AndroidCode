package com.laiqian.util;

import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.squareup.moshi.Json;
import org.json.JSONObject;

public class ag {
  @Json(name = "BUILD_DEVICE")
  public final String aYA;
  
  @Json(name = "BUILD_BOARD")
  public final String aYB;
  
  @Json(name = "BUILD_HARDWARE")
  public final String aYC;
  
  @Json(name = "BUILD_HOST")
  public final String aYD;
  
  @Json(name = "BUILD_ID")
  public final String aYE;
  
  @Json(name = "BUILD_MANUFACTURER")
  public final String aYF;
  
  @Json(name = "BUILD_PRODUCT")
  public final String aYG;
  
  @Json(name = "BUILD_RADIO")
  public final String aYH;
  
  @Json(name = "BUILD_TAGS")
  public final String aYI;
  
  @Json(name = "BUILD_USER")
  public final String aYJ;
  
  @Json(name = "CPU_ID")
  public final String aYK;
  
  @Json(name = "SABAO_SN")
  public final String aYL;
  
  @Json(name = "SABAO_MODEL")
  public final String aYM;
  
  @Json(name = "ACCT_ID")
  public final String aYa;
  
  @Json(name = "POI_ID")
  public final String aYb;
  
  @Json(name = "SN")
  public final String aYc;
  
  @Json(name = "PUSH_TOKEN")
  public final String aYd;
  
  @Json(name = "BRAND")
  public final String aYe;
  
  @Json(name = "CHANNEL")
  public final String aYf;
  
  @Json(name = "APP_VERSION")
  public final String aYg;
  
  @Json(name = "ANDROID_ID")
  public final String aYh;
  
  @Json(name = "DISPLAY")
  @Nullable
  public final String aYi;
  
  @Json(name = "DENSITY_DPI")
  @Nullable
  public final Integer aYj;
  
  @Json(name = "DEVICE_PIXELS")
  @Nullable
  public final String aYk;
  
  @Json(name = "WLAN_MAC")
  @Nullable
  public final String aYl;
  
  @Json(name = "WIFI_IP")
  @Nullable
  public final String aYm;
  
  @Json(name = "BLUETOOTH_MAC")
  @Nullable
  public final String aYn;
  
  @Json(name = "FINGERPRINT")
  @Nullable
  public final String aYo;
  
  @Json(name = "PSEUDO_UNIQUEID")
  @Nullable
  public final String aYp;
  
  @Json(name = "IS_ROOT")
  @Nullable
  public final Boolean aYq;
  
  @Json(name = "DETECTION")
  @Nullable
  public final String aYr;
  
  @Json(name = "STORAGE")
  @Nullable
  public final String aYs;
  
  @Json(name = "PROC_LAST_MODIFIED_TIME")
  @Nullable
  public final String aYt;
  
  @Json(name = "CPU_CORE")
  @Nullable
  public final Integer aYu;
  
  @Json(name = "CPU_STYLE")
  @Nullable
  public final String aYv;
  
  @Json(name = "APP_LIST")
  @Nullable
  public final String aYw;
  
  @Json(name = "E_FILE_EXIST")
  @Nullable
  public final String aYx;
  
  @Json(name = "BUILD_ABI")
  @Nullable
  public final String aYy;
  
  @Json(name = "BUILD_ABI2")
  public final String aYz;
  
  @Json(name = "MODEL")
  public final String atH;
  
  @Json(name = "IMEI")
  @Nullable
  public final String atJ;
  
  @Json(name = "NETWORK")
  @Nullable
  public final String atL;
  
  public ag(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Integer paramInteger1, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Boolean paramBoolean, String paramString19, String paramString20, String paramString21, Integer paramInteger2, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35, String paramString36, String paramString37, String paramString38, String paramString39) {
    this.aYa = paramString1;
    this.aYb = paramString2;
    this.aYc = paramString3;
    this.aYd = paramString4;
    this.atJ = paramString5;
    this.atH = paramString6;
    this.aYe = paramString7;
    this.aYf = paramString8;
    this.aYg = paramString9;
    this.aYh = paramString10;
    this.aYi = paramString11;
    this.aYj = paramInteger1;
    this.aYk = paramString12;
    this.aYl = paramString13;
    this.aYm = paramString14;
    this.atL = paramString15;
    this.aYn = paramString16;
    this.aYo = paramString17;
    this.aYp = paramString18;
    this.aYq = paramBoolean;
    this.aYr = paramString19;
    this.aYs = paramString20;
    this.aYt = paramString21;
    this.aYu = paramInteger2;
    this.aYv = paramString22;
    this.aYw = paramString23;
    this.aYx = paramString24;
    this.aYy = paramString25;
    this.aYz = paramString26;
    this.aYA = paramString27;
    this.aYB = paramString28;
    this.aYC = paramString29;
    this.aYD = paramString30;
    this.aYE = paramString31;
    this.aYF = paramString32;
    this.aYG = paramString33;
    this.aYH = paramString34;
    this.aYI = paramString35;
    this.aYJ = paramString36;
    this.aYK = paramString37;
    this.aYM = paramString39;
    this.aYL = paramString38;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ACCT_ID", this.aYa);
      jSONObject.put("POI_ID", this.aYb);
      jSONObject.put("SN", this.aYc);
      jSONObject.put("PUSH_TOKEN", this.aYd);
      jSONObject.put("IMEI", this.atJ);
      jSONObject.put("MODEL", this.atH);
      jSONObject.put("BRAND", this.aYe);
      jSONObject.put("CHANNEL", this.aYf);
      jSONObject.put("APP_VERSION", this.aYg);
      jSONObject.put("ANDROID_ID", this.aYh);
      jSONObject.put("DISPLAY", this.aYi);
      jSONObject.put("DENSITY_DPI", this.aYj);
      jSONObject.put("DEVICE_PIXELS", this.aYk);
      jSONObject.put("WLAN_MAC", this.aYl);
      jSONObject.put("WIFI_IP", this.aYm);
      jSONObject.put("NETWORK", this.atL);
      jSONObject.put("BLUETOOTH_MAC", this.aYn);
      jSONObject.put("FINGERPRINT", this.aYo);
      jSONObject.put("PSEUDO_UNIQUEID", this.aYp);
      jSONObject.put("IS_ROOT", this.aYq);
      jSONObject.put("DETECTION", this.aYr);
      jSONObject.put("STORAGE", this.aYs);
      jSONObject.put("PROC_LAST_MODIFIED_TIME", this.aYt);
      jSONObject.put("CPU_CORE", this.aYu);
      jSONObject.put("CPU_STYLE", this.aYv);
      jSONObject.put("APP_LIST", this.aYw);
      jSONObject.put("E_FILE_EXIST", this.aYx);
      jSONObject.put("BUILD_ABI", this.aYy);
      jSONObject.put("BUILD_ABI2", this.aYz);
      jSONObject.put("BUILD_DEVICE", this.aYA);
      jSONObject.put("BUILD_BOARD", this.aYB);
      jSONObject.put("BUILD_HARDWARE", this.aYC);
      jSONObject.put("BUILD_HOST", this.aYD);
      jSONObject.put("BUILD_ID", this.aYE);
      jSONObject.put("BUILD_MANUFACTURER", this.aYF);
      jSONObject.put("BUILD_PRODUCT", this.aYG);
      jSONObject.put("BUILD_RADIO", this.aYH);
      jSONObject.put("BUILD_TAGS", this.aYI);
      jSONObject.put("BUILD_USER", this.aYJ);
      jSONObject.put("CPU_ID", this.aYK);
      jSONObject.put("SABAO_SN", this.aYL);
      jSONObject.put("SABAO_MODEL", this.aYM);
    } catch (Exception exception) {
      a.e(exception);
    } 
    return jSONObject.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */