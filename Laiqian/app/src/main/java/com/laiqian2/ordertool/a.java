package com.laiqian.ordertool;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.client.h;
import com.laiqian.f.b;
import com.laiqian.util.az;
import io.netty.channel.s;
import io.netty.channel.t;
import java.util.UUID;
import org.json.JSONObject;

public class a {
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2) { return a(paramContext, paramInt1, paramString, paramInt2, 0L); }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2, long paramLong) {
    JSONObject jSONObject1 = new JSONObject();
    long l = paramLong;
    if (paramLong == 0L) {
      try {
        l = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message_type", paramInt2);
        jSONObject.put("device_type", RootApplication.getLaiqianPreferenceManager().avL());
        jSONObject.put("create_time", l);
        jSONObject.put("version", 1.0D);
        jSONObject1.put("more_info", jSONObject);
        g g1 = new g(paramContext);
        jSONObject1.put("phone", g1.Ea());
        jSONObject1.put("pwd", g1.Ec());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt1);
        stringBuilder1.append("");
        jSONObject1.put("method", stringBuilder1.toString());
        jSONObject1.put("device", "android-tableorder");
        jSONObject1.put("brand", Build.BRAND);
        jSONObject1.put("imei", aP(paramContext));
        jSONObject1.put("data", b.encode(paramString));
        az.info(jSONObject1.toString());
      } catch (Exception paramContext) {
        a.e(paramContext);
      } 
      return jSONObject1.toString();
    } 
    JSONObject jSONObject2 = new JSONObject();
    jSONObject2.put("message_type", paramInt2);
    jSONObject2.put("device_type", RootApplication.getLaiqianPreferenceManager().avL());
    jSONObject2.put("create_time", l);
    jSONObject2.put("version", 1.0D);
    jSONObject1.put("more_info", jSONObject2);
    g g = new g(paramContext);
    jSONObject1.put("phone", g.Ea());
    jSONObject1.put("pwd", g.Ec());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    jSONObject1.put("method", stringBuilder.toString());
    jSONObject1.put("device", "android-tableorder");
    jSONObject1.put("brand", Build.BRAND);
    jSONObject1.put("imei", aP(paramContext));
    jSONObject1.put("data", b.encode(paramString));
    az.info(jSONObject1.toString());
  }
  
  public static void a(String paramString, t paramt) {
    paramString = j.cG(paramString);
    if (h.isActive()) {
      s s = (h.DI()).aPd.aM(paramString);
      if (paramt != null)
        s.a(paramt); 
    } 
  }
  
  public static String aP(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("");
    stringBuilder1.append(telephonyManager.getDeviceId());
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(telephonyManager.getSimSerialNumber());
    String str2 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    return (new UUID(stringBuilder2.toString().hashCode(), str1.hashCode() << 32 | str2.hashCode())).toString();
  }
  
  public static void cz(String paramString) { a(paramString, null); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */