package com.laiqian.auth;

import android.view.View;
import android.widget.TextView;

class o implements View.OnClickListener {
  o(AuthSetting paramAuthSetting) {}
  
  public void onClick(View paramView) {
    AuthSetting.a(this.aDF, 8);
    AuthSetting.a(this.aDF).setVisibility(8);
    paramView = AuthSetting.d(this.aDF).findViewWithTag(AuthSetting.g(this.aDF));
    if ("NOID".equals(AuthSetting.g(this.aDF))) {
      AuthSetting.d(this.aDF).removeView(paramView);
      AuthSetting.c(this.aDF).scrollTo(0, 0);
      AuthSetting.b(this.aDF, AuthSetting.h(this.aDF));
    } else {
      ((TextView)paramView.findViewById(2131299315)).setText((CharSequence)AuthSetting.i(this.aDF).get(AuthSetting.g(this.aDF)));
      AuthSetting.b(this.aDF, paramView);
    } 
    AuthSetting.j(this.aDF).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */