package com.laiqian.login.view;

import android.text.Editable;
import android.text.TextUtils;
import com.laiqian.ui.r;

class n extends r {
  n(LoginActivity paramLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    this.aZD.Kl();
    if (TextUtils.isEmpty(this.aZD.aZg.aZK.getText().toString().trim())) {
      this.aZD.aZg.aZN.setVisibility(8);
      this.aZD.aZg.aZR.setTextColor(this.aZD.getResources().getColor(2131099936));
      return;
    } 
    if (!TextUtils.isEmpty(this.aZD.aZg.aZI.getText().toString().trim()))
      this.aZD.aZg.aZR.setTextColor(this.aZD.getResources().getColor(2131099938)); 
    this.aZD.aZg.aZN.setVisibility(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */