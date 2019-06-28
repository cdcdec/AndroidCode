package com.laiqian.auth;

import android.view.View;
import android.widget.Toast;

class q implements View.OnClickListener {
  q(AuthSetting paramAuthSetting) {}
  
  public void onClick(View paramView) {
    boolean bool;
    String str = (String)paramView.getTag();
    Boolean[] arrayOfBoolean = new Boolean[AuthSetting.l(this.aDF).length];
    for (byte b = 0; b < AuthSetting.l(this.aDF).length; b++)
      arrayOfBoolean[b] = Boolean.valueOf(AuthSetting.l(this.aDF)[b].isChecked()); 
    if ("NOID".equals(str)) {
      bool = AuthSetting.a(this.aDF, arrayOfBoolean);
    } else {
      bool = AuthSetting.a(this.aDF, arrayOfBoolean, str);
    } 
    if (bool) {
      Toast.makeText(this.aDF, this.aDF.getString(2131629874), 0).show();
      AuthSetting.a(this.aDF, 8);
      AuthSetting.a(this.aDF).setVisibility(AuthSetting.m(this.aDF));
      return;
    } 
    Toast.makeText(this.aDF, this.aDF.getString(2131626476), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */