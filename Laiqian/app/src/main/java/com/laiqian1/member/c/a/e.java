package com.laiqian.member.c.a;

import android.support.annotation.NonNull;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.cb;
import java.util.HashMap;

public class e {
  @NonNull
  public static HashMap<String, String> a(int paramInt, cb paramcb) {
    String str = RootApplication.getLaiqianPreferenceManager().Tx();
    HashMap hashMap = new HashMap();
    hashMap.put("shop_id", str);
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    hashMap.put("auth_type", "0");
    hashMap.put("version", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().QV());
    stringBuilder.append("");
    hashMap.put("scope", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    hashMap.put("page", stringBuilder.toString());
    hashMap.put("sort", paramcb.Qz());
    hashMap.put("filter", paramcb.Qy());
    hashMap.put("sqlWithDoc", "0");
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    return hashMap;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */