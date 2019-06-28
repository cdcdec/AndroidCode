package com.laiqian.auth;

import android.view.View;
import android.widget.TextView;

class j implements a.a {
  j(AuthSetting paramAuthSetting) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {
    AuthSetting.a(this.aDF, new String[] { "NOID", paramString2 }, true);
    AuthSetting.a(this.aDF, paramString2);
    AuthSetting.b(this.aDF, "NOID");
    AuthSetting.o(this.aDF).cancel();
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2) {
    ((TextView)AuthSetting.d(this.aDF).findViewWithTag(AuthSetting.g(this.aDF)).findViewById(2131299315)).setText(paramString2);
    AuthSetting.p(this.aDF).setText(paramString2);
    AuthSetting.a(this.aDF, paramString2);
    AuthSetting.a(this.aDF, 0);
    AuthSetting.a(this.aDF).setVisibility(0);
    AuthSetting.o(this.aDF).cancel();
  }
  
  public void c(boolean paramBoolean, String paramString1, String paramString2) {
    AuthSetting.a(this.aDF, 8);
    AuthSetting.a(this.aDF).setVisibility(8);
    View view = AuthSetting.d(this.aDF).findViewWithTag(AuthSetting.g(this.aDF));
    AuthSetting.d(this.aDF).removeView(view);
    if (AuthSetting.d(this.aDF).getChildCount() == 0 && AuthSetting.d(this.aDF).getVisibility() == 0)
      AuthSetting.d(this.aDF).setVisibility(8); 
    AuthSetting.c(this.aDF).scrollTo(0, 0);
    AuthSetting.b(this.aDF, AuthSetting.h(this.aDF));
    AuthSetting.o(this.aDF).cancel();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */