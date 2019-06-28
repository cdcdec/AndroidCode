package com.laiqian.wallet;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.by;
import com.laiqian.util.n;
import org.json.JSONObject;

class m extends Thread {
  m(WalletSettingFragment paramWalletSettingFragment) {}
  
  public void run() {
    try {
      boolean bool;
      WalletSettingFragment.a(this.dLr, getName());
      jSONObject = k.axx();
      if (WalletSettingFragment.a(this.dLr, this))
        return; 
      String str2 = jSONObject.optString("message");
      try {
        bool = jSONObject.optInt("msg_no");
        try {
          if (by.isNull(str2))
            return; 
          jSONObject = new JSONObject(str2);
          String str3 = n.a(jSONObject.getString("withdraw_amount"), true, true, 2);
          String str4 = n.a(jSONObject.getString("unbilled_amount"), true, true, 2);
          String str5 = n.a(jSONObject.getString("balance"), true, true, 2);
          WalletSettingFragment.a(this.dLr).h(jSONObject.getString("open_bank"), jSONObject.getString("user_name"), jSONObject.getString("bank_card"), str3);
          WalletSettingFragment.b(this.dLr).obtainMessage(1, new String[] { str5, str3, str4 }).sendToTarget();
          return;
        } catch (Throwable jSONObject) {}
      } catch (Throwable jSONObject) {
        bool = false;
      } 
      a.e(jSONObject);
      if (WalletSettingFragment.a(this.dLr, this))
        return; 
      if (bool == -2)
        WalletSettingFragment.c(this.dLr); 
      String str1 = str2;
      if (str2 == null)
        str1 = RootApplication.zv().getString(R.string.pos_wallet_show_error_unknown); 
      WalletSettingFragment.b(this.dLr).obtainMessage(-1, str1).sendToTarget();
      return;
    } catch (h h) {
      a.e(h);
      if (WalletSettingFragment.a(this.dLr, this))
        return; 
      WalletSettingFragment.b(this.dLr).obtainMessage(-1, h.getMessage()).sendToTarget();
      return;
    } catch (Throwable throwable) {
      Object object = null;
      boolean bool = false;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */