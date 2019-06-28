package com.laiqian.wallet;

import android.text.TextUtils;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.f.b;
import com.laiqian.network.i;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.bd;
import com.laiqian.util.bg;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
  public static String N(String paramString1, String paramString2, String paramString3) {
    JSONObject jSONObject = new JSONObject();
    try {
      String str2 = h(true, null);
      jSONObject.put("username", paramString1);
      jSONObject.put("password", paramString2);
      jSONObject.put("amount", paramString3);
      jSONObject.put("token", str2);
      jSONObject.put("language", Locale.getDefault().toString());
      null = bd.u(jSONObject);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.ckS);
      stringBuilder.append("api/wallet/withdraw");
      str1 = bd.c(stringBuilder.toString(), null);
      if ("-1".equals(str1))
        return RootApplication.zv().zv().getString(R.string.pos_wallet_error_network); 
      try {
        JSONObject jSONObject1 = new JSONObject(b.cM(str1));
        return jSONObject1.has("result") ? ("ok".equalsIgnoreCase(jSONObject1.getString("result")) ? null : RootApplication.zv().zv().getString(R.string.pos_wallet_withdrawals_fail)) : jSONObject1.getString("message");
      } catch (Exception str1) {
        a.e(str1);
        return RootApplication.zv().zv().getString(R.string.pos_wallet_error_server);
      } 
    } catch (h paramString1) {
      a.e(paramString1);
      return paramString1.getMessage();
    } catch (Exception paramString1) {
      a.e(paramString1);
      return RootApplication.zv().zv().getString(R.string.pos_wallet_show_error_unknown);
    } 
  }
  
  private static boolean a(String paramString, Pair<Boolean, Integer> paramPair) { return ("1".equals(paramString) && ((Boolean)paramPair.first).booleanValue() && ((Integer)paramPair.second).intValue() == 5); }
  
  public static JSONObject axw() throws h, Exception {
    byte b = 0;
    while (true) {
      if (b < 2)
        try {
          exception = h(true, null);
          String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(RootUrlParameter.ckS);
          stringBuilder.append("api/wallet/account");
          String str1 = stringBuilder.toString();
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("shop_id", str2);
          jSONObject.put("token", exception);
          jSONObject.put("flavor", "");
          if (n.bL(RootApplication.zv())) {
            exception = "zh-CN";
          } else {
            exception = "en";
          } 
          jSONObject.put("language", exception);
          exception = b.cM(bd.rV(bd.b(str1, jSONObject)));
          if (!by.isNull(exception)) {
            JSONObject jSONObject1 = new JSONObject(exception);
            if (!jSONObject1.has("alipay_account_binding") && !jSONObject1.has("wechatpay_account_binding")) {
              RootApplication.getLaiqianPreferenceManager().ru(null);
            } else {
              break;
            } 
          } else {
            return new JSONObject();
          } 
          b++;
          continue;
        } catch (h null) {
          throw exception;
        } catch (Exception exception) {
          if (b > 0)
            throw exception; 
          b++;
          continue;
        }  
      throw new h("获取店铺信息时，执行了两次但还是异常，这里不会进来");
    } 
    return exception;
  }
  
  public static JSONObject axx() throws h, Exception {
    byte b = 0;
    while (b < 2) {
      JSONObject jSONObject;
      String str2;
      try {
        String str3 = h(true, null);
        String str4 = RootApplication.zv().getLaiqianPreferenceManager().Tx();
        str2 = RootUrlParameter.cmq;
        jSONObject = new JSONObject();
        jSONObject.put("shop_id", str4);
        jSONObject.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
        jSONObject.put("password", RootApplication.getLaiqianPreferenceManager().auN());
        jSONObject.put("token", str3);
        jSONObject.put("auth_type", 0);
        jSONObject.put("version", 1.0D);
        jSONObject.put("flavor", "");
        if (n.bL(RootApplication.zv().zv())) {
          str3 = "zh-CN";
          jSONObject.put("language", str3);
          return new JSONObject(b.cM(bd.c(str2, bd.u(jSONObject))));
        } 
      } catch (h h) {
        throw h;
      } catch (Exception exception) {
        if (b)
          throw exception; 
        b++;
        continue;
      } 
      String str1 = "en";
      jSONObject.put("language", str1);
      return new JSONObject(b.cM(bd.c(str2, bd.u(jSONObject))));
    } 
    throw new h("获取店铺信息时，执行了两次但还是异常，这里不会进来");
  }
  
  public static String axy() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckS);
    stringBuilder.append("embed/wallet/help");
    return stringBuilder.toString();
  }
  
  public static boolean axz() {
    try {
      if (a.zR().Ak()) {
        if (!TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awi()) && !TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awh())) {
          a.AZ().dW(1);
          a.AZ().dX(5);
          RootApplication.zv().getLaiqianPreferenceManager().ro(RootApplication.getLaiqianPreferenceManager().awi());
          RootApplication.zv().getLaiqianPreferenceManager().rp(RootApplication.getLaiqianPreferenceManager().awi());
        } else {
          a.AZ().dW(2);
          a.AZ().dX(7);
          RootApplication.zv().getLaiqianPreferenceManager().ro("");
          RootApplication.zv().getLaiqianPreferenceManager().rp("");
        } 
        a.AZ().bQ("3");
        a.AZ().bR("3");
        return true;
      } 
      JSONObject jSONObject = axw();
      String str = jSONObject.optString("alipay_account_binding");
      if (str != null && str.length() > 0 && !"null".equalsIgnoreCase(str)) {
        if (RootApplication.zv().getLaiqianPreferenceManager().FC() == null)
          a.AZ().dW(1); 
        a.AZ().bQ(jSONObject.optString("alipay_channel_id", "5"));
        RootApplication.zv().getLaiqianPreferenceManager().ro(str);
      } 
      str = jSONObject.optString("wechatpay_account_binding");
      if (str != null && str.length() > 0 && !"null".equalsIgnoreCase(str)) {
        if (RootApplication.zv().getLaiqianPreferenceManager().FD() == null)
          a.AZ().dX(5); 
        a.AZ().bR(jSONObject.optString("wechat_pay_channel_id", "5"));
        RootApplication.zv().getLaiqianPreferenceManager().rp(str);
      } 
      return true;
    } catch (Throwable throwable) {
      a.e(throwable);
      return false;
    } 
  }
  
  public static i bG(String paramString1, String paramString2) {
    try {
      String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.ckS);
      stringBuilder.append("pay-bind/channel-select");
      String str1 = stringBuilder.toString();
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("shop_id", str2);
      jSONObject.put("user_name", RootApplication.zv().getLaiqianPreferenceManager().Ea());
      jSONObject.put("password", RootApplication.zv().getLaiqianPreferenceManager().auN());
      jSONObject.put("auth_type", 0);
      jSONObject.put("version", 1.0D);
      jSONObject.put("channel_id", paramString2);
      jSONObject.put("pay_type", paramString1);
      if (n.bL(RootApplication.zv())) {
        paramString1 = "zh-CN";
      } else {
        paramString1 = "en";
      } 
      jSONObject.put("language", paramString1);
      paramString1 = b.cM(bd.d(str1, bd.u(jSONObject)));
      if (!by.isNull(paramString1)) {
        JSONObject jSONObject1 = new JSONObject(paramString1);
        return new i(jSONObject1.optBoolean("result"), jSONObject1.optInt("msg_no"), jSONObject1.optString("info"));
      } 
    } catch (Exception paramString1) {
      a.e(paramString1);
    } 
    return new i(false, false, "");
  }
  
  private static Pair<Boolean, Integer> d(JSONArray paramJSONArray) throws JSONException {
    for (byte b = 0; b < paramJSONArray.length(); b++) {
      JSONObject jSONObject = paramJSONArray.getJSONObject(b);
      int i = jSONObject.optInt("id");
      boolean bool = jSONObject.optBoolean("selected");
      if (bool)
        return new Pair(Boolean.valueOf(bool), Integer.valueOf(i)); 
    } 
    return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
  }
  
  public static String h(boolean paramBoolean, String paramString) throws h {
    if (paramBoolean) {
      paramString = RootApplication.zv().getLaiqianPreferenceManager().auX();
      if (paramString != null) {
        long l = RootApplication.zv().getLaiqianPreferenceManager().auY();
        if (System.currentTimeMillis() < l) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("直接返回了token：");
          stringBuilder.append(paramString);
          n.println(stringBuilder.toString());
          return paramString;
        } 
      } 
      paramString = RootApplication.getLaiqianPreferenceManager().auN();
    } 
    String str = RootApplication.zv().getLaiqianPreferenceManager().Ea();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("user_name", str);
      jSONObject.put("password", paramString);
      jSONObject.put("auth_type", 0);
      jSONObject.put("version", 1.0D);
      jSONObject.put("expired", 2592000);
      jSONObject.put("shop_id", RootApplication.zv().getLaiqianPreferenceManager().Tx());
      if (paramBoolean) {
        paramString = "session";
      } else {
        paramString = "bind";
      } 
      jSONObject.put("type", paramString);
      jSONObject.put("language", Locale.getDefault().toString());
      null = bd.u(jSONObject);
      str1 = bd.c(RootUrlParameter.cmr, null);
      if ("-1".equals(str1))
        throw new h(RootApplication.zv().zv().getString(R.string.pos_wallet_error_network)); 
      try {
        JSONObject jSONObject1 = new JSONObject(b.cM(str1));
        if (!by.isNull(jSONObject1.toString()) && "TRUE".equals(jSONObject1.optString("result"))) {
          String str2 = jSONObject1.optString("message");
          if (!by.isNull(str2)) {
            String str3;
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject2.has("token")) {
              str3 = jSONObject2.getString("token");
              if (!paramBoolean)
                if (str3.equals(RootApplication.zv().getLaiqianPreferenceManager().auX()))
                  return str3;  
              ss(str3);
              return str3;
            } 
            throw new h(str3.getString("message"));
          } 
        } 
        return null;
      } catch (JSONException str1) {
        a.e(str1);
        throw new h(RootApplication.zv().zv().getString(R.string.pos_wallet_error_server));
      } 
    } catch (Exception paramString) {
      a.e(paramString);
      throw new h(RootApplication.zv().zv().getString(R.string.pos_wallet_show_error_unknown));
    } 
  }
  
  public static String i(String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("shop_id", paramString1);
        jSONObject.put("alipay_name", paramString2);
        jSONObject.put("alipay_account", paramString3);
        jSONObject.put("token", paramString4);
        jSONObject.put("language", Locale.getDefault().toString());
        jSONObject.put("flavor", "");
        null = bd.u(jSONObject);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RootUrlParameter.ckS);
        stringBuilder.append("api/wallet/account");
        null = bd.c(stringBuilder.toString(), null);
        if ("-1".equals(null))
          return RootApplication.zv().zv().getString(R.string.pos_wallet_error_network); 
        JSONObject jSONObject1 = new JSONObject(b.cM(null));
        return jSONObject1.has("result") ? ("ok".equalsIgnoreCase(jSONObject1.getString("result")) ? null : RootApplication.zv().zv().getString(R.string.pos_wallet_binding_fail)) : jSONObject1.getString("message");
      } catch (Exception paramString1) {
        a.e(paramString1);
        return RootApplication.zv().zv().getString(R.string.pos_wallet_show_error_unknown);
      } 
    } catch (Exception paramString1) {
      a.e(paramString1);
      return RootApplication.zv().zv().getString(R.string.pos_wallet_error_server);
    } 
  }
  
  public static String ia(boolean paramBoolean) {
    null = new StringBuilder();
    null.append(RootUrlParameter.ckS);
    null.append("embed/wallet/");
    if (paramBoolean) {
      str = "transactions";
    } else {
      str = "withdraw";
    } 
    null.append(str);
    String str = null.toString();
    JSONObject jSONObject = new JSONObject();
    try {
      String str1 = RootApplication.zv().getLaiqianPreferenceManager().Tx();
      String str2 = h(true, null);
      jSONObject.put("shop_id", str1);
      jSONObject.put("user_name", RootApplication.zv().getLaiqianPreferenceManager().Ea());
      jSONObject.put("password", RootApplication.zv().getLaiqianPreferenceManager().auN());
      jSONObject.put("auth_type", 0);
      jSONObject.put("version", 1.0D);
      jSONObject.put("token", str2);
    } catch (Exception exception) {
      a.e(exception);
    } 
    return bd.b(str, jSONObject);
  }
  
  private static void ss(String paramString) {
    RootApplication.zv().getLaiqianPreferenceManager().ru(paramString);
    long l = System.currentTimeMillis();
    RootApplication.zv().getLaiqianPreferenceManager().dx(l + 2592000000L);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("重新获取了token：");
    stringBuilder.append(paramString);
    n.println(stringBuilder.toString());
  }
  
  public static Pair<Boolean, String> st(String paramString) {
    try {
      null = RootApplication.getLaiqianPreferenceManager().Tx();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.ckS);
      stringBuilder.append("pay-bind/get-channel-and-status");
      String str = stringBuilder.toString();
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("shop_id", null);
      jSONObject.put("user_name", RootApplication.zv().getLaiqianPreferenceManager().Ea());
      jSONObject.put("password", RootApplication.zv().getLaiqianPreferenceManager().auN());
      jSONObject.put("auth_type", 0);
      jSONObject.put("version", 1.0D);
      jSONObject.put("pay_type", paramString);
      if (n.bL(RootApplication.zv())) {
        null = "zh-CN";
      } else {
        null = "en";
      } 
      jSONObject.put("language", null);
      null = b.cM(bd.d(str, bd.u(jSONObject)));
      if (by.isNull(null))
        return null; 
      null = new JSONObject(null);
      if (!bg.equals(null.optString("result"), "true"))
        return null; 
      null = null.getJSONObject("info");
      int i = null.getInt("status");
      Pair pair = d(null.getJSONArray("channels"));
      boolean bool = a(paramString, pair);
      if (i == 0)
        return (((Integer)pair.second).intValue() == by.parseInt("5") && bool) ? new Pair(Boolean.valueOf(true), "5") : new Pair(Boolean.valueOf(false), ""); 
      if (((Integer)pair.second).intValue() == by.parseInt("5") && bool) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(pair.second);
        stringBuilder1.append("");
        return new Pair(Boolean.valueOf(true), stringBuilder1.toString());
      } 
      return new Pair(Boolean.valueOf(true), "4");
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */