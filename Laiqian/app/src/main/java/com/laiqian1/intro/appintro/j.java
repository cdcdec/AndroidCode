package com.laiqian.intro.appintro;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

class j extends FragmentPagerAdapter {
  private List<Fragment> aXj;
  
  public j(FragmentManager paramFragmentManager, @NonNull List<Fragment> paramList) {
    super(paramFragmentManager);
    this.aXj = paramList;
  }
  
  public int getCount() { return this.aXj.size(); }
  
  public Fragment getItem(int paramInt) { return (Fragment)this.aXj.get(paramInt); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */