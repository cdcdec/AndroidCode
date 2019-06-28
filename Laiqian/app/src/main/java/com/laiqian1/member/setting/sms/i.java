package com.laiqian.member.setting.sms;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.network.k;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import com.laiqian.util.z;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  private static final String TAG = "i";
  
  private int bGG = -1;
  
  private Context mContext;
  
  static  {
  
  }
  
  public i(Context paramContext) { this.mContext = paramContext; }
  
  public String a(Context paramContext, int paramInt1, int paramInt2) {
    av av = new av(paramContext);
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "1");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().QV());
      stringBuilder.append("");
      hashMap.put("scope", stringBuilder.toString());
      hashMap.put("page", String.valueOf(paramInt1));
      hashMap.put("size", String.valueOf(paramInt2));
      String str = bh.a(RootUrlParameter.clI, paramContext, hashMap, 10000);
      if (!TextUtils.isEmpty(str)) {
        String str4 = TAG;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getSMSStatics 短信明细result-->");
        stringBuilder1.append(str);
        Log.i(str4, stringBuilder1.toString());
        return str;
      } 
      return null;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public String a(Context paramContext, b paramb) {
    av av = new av(paramContext);
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "1");
      hashMap.put("templateId", b.a.bGq.getValue());
      hashMap.put("phone", paramb.SL());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().QV());
      stringBuilder.append("");
      hashMap.put("scope", stringBuilder.toString());
      hashMap.put("message", paramb.getMessage().replace("回复T退订", "").replace("短信签名", "萨宝科技"));
      hashMap.put("sSmsType", paramb.SM());
      hashMap.put("sEventType", paramb.SN());
      String str = bh.a(RootUrlParameter.clH, paramContext, hashMap, 10000);
      if (!TextUtils.isEmpty(str)) {
        String str4 = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("sendOrdinaryMessage 发送短信result-->");
        stringBuilder.append(str);
        Log.i(str4, stringBuilder.toString());
        return str;
      } 
      return null;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public String a(Context paramContext, h paramh) {
    av av = new av(paramContext);
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "1");
      hashMap.put("templateId", paramh.bGE);
      hashMap.put("phone", paramh.aTp);
      hashMap.put("chargeAmount", paramh.bGF);
      hashMap.put("balance", paramh.aTt);
      hashMap.put("grantAmount", paramh.bGD);
      hashMap.put("time", z.b(System.currentTimeMillis(), "MM月dd日HH:mm"));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().QV());
      stringBuilder.append("");
      hashMap.put("scope", stringBuilder.toString());
      String str = bh.a(RootUrlParameter.clG, paramContext, hashMap, 10000);
      if (!TextUtils.isEmpty(str)) {
        String str4 = TAG;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("sendMessageBySMS result=");
        stringBuilder1.append(str);
        Log.i(str4, stringBuilder1.toString());
        return str;
      } 
      return null;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public void a(JSONObject paramJSONObject, Context paramContext) {
    try {
      String str1 = RootApplication.getLaiqianPreferenceManager().Tx();
      String str2 = paramJSONObject.get("nShopID").toString();
      int j = paramJSONObject.optInt("nSmsQuantityLeft");
      if (!str1.equals(str2))
        return; 
      Intent intent = new Intent();
      intent.putExtra("SMS_QUANTITY_LEFT", j);
      intent.setAction("SMS_CHARGE_RECEIVER");
      paramContext.sendBroadcast(intent);
      return;
    } catch (JSONException paramJSONObject) {
      a.e(paramJSONObject);
      return;
    } 
  }
  
  public void av(double paramDouble) {
    k = new k();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    hashMap.put("auth_type", "0");
    hashMap.put("version", "1.0");
    hashMap.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
    hashMap.put("code", a.AZ().BQ());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    hashMap.put("amount", stringBuilder.toString());
    try {
      k.a(hashMap, RootUrlParameter.cmy, 0);
      return;
    } catch (Exception k) {
      a.e(k);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */