package com.laiqian.intro.appintro;

import android.support.annotation.NonNull;
import android.view.View;

class b implements View.OnClickListener {
  b(AppIntro paramAppIntro) {}
  
  public void onClick(@NonNull View paramView) {
    if (AppIntro.a(this.aXr))
      AppIntro.c(this.aXr).vibrate(AppIntro.b(this.aXr)); 
    AppIntro.d(this.aXr).setCurrentItem(AppIntro.d(this.aXr).getCurrentItem() + 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */