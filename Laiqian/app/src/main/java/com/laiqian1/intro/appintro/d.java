package com.laiqian.intro.appintro;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

class d implements ViewPager.OnPageChangeListener {
  d(AppIntro paramAppIntro, TextView paramTextView1, ImageView paramImageView, TextView paramTextView2) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {
    if (AppIntro.e(this.aXr) > 1)
      AppIntro.f(this.aXr).eI(paramInt); 
    if (paramInt == AppIntro.e(this.aXr) - 1) {
      this.aXs.setVisibility(4);
      this.aXt.setVisibility(8);
      if (AppIntro.g(this.aXr)) {
        this.aXu.setVisibility(0);
      } else {
        this.aXu.setVisibility(4);
      } 
    } else {
      this.aXs.setVisibility(0);
      this.aXu.setVisibility(8);
      this.aXt.setVisibility(0);
    } 
    if (!AppIntro.h(this.aXr))
      this.aXs.setVisibility(4); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */