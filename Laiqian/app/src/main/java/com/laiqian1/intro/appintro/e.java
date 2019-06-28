package com.laiqian.intro.appintro;

import android.support.annotation.NonNull;
import android.view.View;

class e implements View.OnClickListener {
  e(AppIntro2 paramAppIntro2) {}
  
  public void onClick(@NonNull View paramView) {
    if (AppIntro2.a(this.aXv))
      AppIntro2.c(this.aXv).vibrate(AppIntro2.b(this.aXv)); 
    AppIntro2.d(this.aXv).setCurrentItem(AppIntro2.d(this.aXv).getCurrentItem() + 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */