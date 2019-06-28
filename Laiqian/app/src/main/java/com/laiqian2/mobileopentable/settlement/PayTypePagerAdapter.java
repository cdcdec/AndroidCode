package com.laiqian.mobileopentable.settlement;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

public class PayTypePagerAdapter extends PagerAdapter {
  public List<View> bNb;
  
  public void destroyItem(View paramView, int paramInt, Object paramObject) { ((ViewPager)paramView).removeView((View)this.bNb.get(paramInt)); }
  
  public void finishUpdate(View paramView) {}
  
  public int getCount() { return this.bNb.size(); }
  
  public Object instantiateItem(View paramView, int paramInt) {
    ((ViewPager)paramView).addView((View)this.bNb.get(paramInt), 0);
    return this.bNb.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject) { return (paramView == paramObject); }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState() { return null; }
  
  public void startUpdate(View paramView) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\settlement\PayTypePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */