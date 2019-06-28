package com.laiqian.intro.appintro;

import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.ImageView;

class g implements ViewPager.OnPageChangeListener {
  g(AppIntro2 paramAppIntro2, ImageView paramImageView, Button paramButton) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {
    if (AppIntro2.e(this.aXv) > 1)
      AppIntro2.f(this.aXv).eI(paramInt); 
    if (paramInt == AppIntro2.e(this.aXv) - 1) {
      this.aXt.setVisibility(8);
      if (AppIntro2.g(this.aXv)) {
        this.aXw.setVisibility(0);
      } else {
        this.aXw.setVisibility(4);
      } 
    } else {
      this.aXw.setVisibility(8);
      this.aXt.setVisibility(0);
    } 
    this.aXt.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */