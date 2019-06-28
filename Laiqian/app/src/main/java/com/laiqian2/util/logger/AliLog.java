package com.laiqian.util.logger;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.a.b.b;
import com.a.b.c;
import com.a.b.e;
import com.laiqian.util.ch;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AliLog {
  public static final String VERSION = ch.awI();
  
  private final String dGW;
  
  private final String dGX;
  
  private final String dGY;
  
  private b dGZ;
  
  private AliLog(String paramString1, String paramString2, String paramString3) {
    this.dGW = paramString1;
    this.dGX = paramString2;
    this.dGY = paramString3;
    this.dGZ = new b("cn-qingdao.log.aliyuncs.com", "fn9HIY3JEfBMpQin", "MLXX3WIuy1clKSfsX9cjQ6B8TG2836", this.dGW);
  }
  
  private String mm(int paramInt) {
    switch (paramInt) {
      default:
        return "Test";
      case 3:
        return "Prod";
      case 2:
        return "Pre";
      case 1:
        return "Test";
      case 0:
        break;
    } 
    return "Dev";
  }
  
  private String mn(int paramInt) {
    switch (paramInt) {
      default:
        return "Debug";
      case 3:
        return "Error";
      case 2:
        return "Waring";
      case 1:
        return "Info";
      case 0:
        break;
    } 
    return "Debug";
  }
  
  public Map<String, String> a(int paramInt1, int paramInt2, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4) {
    HashMap hashMap = new HashMap();
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("_");
    stringBuilder.append(paramString2);
    stringBuilder.append("_");
    stringBuilder.append(date.getTime());
    String str = stringBuilder.toString();
    hashMap.put("version", VERSION);
    hashMap.put("requestID", str);
    hashMap.put("environment", mm(paramInt1));
    hashMap.put("level", mn(paramInt2));
    hashMap.put("shopID", paramString1);
    hashMap.put("userPhone", paramString2);
    hashMap.put("info", paramString3);
    hashMap.put("result", paramString4);
    hashMap.put("time", simpleDateFormat.format(date));
    return hashMap;
  }
  
  @WorkerThread
  public void a(@NonNull String paramString, @NonNull Map<String, String> paramMap) throws Exception {
    e e = new e(paramString, this.dGY);
    if (paramMap != null && paramMap.size() != 0) {
      if (!paramMap.containsKey("version"))
        throw new Exception("未指定版本(version)"); 
      c c = new c();
      for (Map.Entry entry : paramMap.entrySet())
        c.r((String)entry.getKey(), (String)entry.getValue()); 
      e.a(c);
    } 
    this.dGZ.a(e, this.dGX);
  }
  
  class AliLog {}
  
  class AliLog {}
  
  public static class a {
    private String dFx;
    
    private String dHa;
    
    private String dHb;
    
    public a awM() {
      this.dHa = AliLog.b.dHc.dHa;
      this.dHb = AliLog.b.dHc.dHb;
      this.dFx = "android_client";
      return this;
    }
    
    public AliLog awN() throws Exception {
      if (this.dHa == null || this.dHb == null || this.dFx == null)
        throw new Exception("AliLog#Builder 配置不正确"); 
      return new AliLog(this.dHa, this.dHb, this.dFx, null);
    }
    
    public a b(AliLog.b param1b) {
      this.dHa = param1b.dHa;
      this.dHb = param1b.dHb;
      return this;
    }
    
    public a sj(String param1String) {
      this.dFx = param1String;
      return this;
    }
  }
  
  public enum b {
    dHc("android", "android_client"),
    dHd("android", "android_retail_client"),
    dHe("takeaway", "meituan"),
    dHf("takeaway", "test"),
    dHg("takeaway", "eleme"),
    dHh("eleme", "undefine"),
    dHi("online-sabao", "undefine");
    
    String dHa;
    
    String dHb;
    
    b(@NonNull String param1String1, @NonNull String param1String2) {
      this.dHa = param1String1;
      this.dHb = param1String2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\logger\AliLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */