package com.laiqian.pos.industry.weiorder.advertisement;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.industry.weiorder.AdvertisementFunctionIntroductionFragment;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;

public class AdvertisementSettingsActivity extends FragmentActivityRoot {
  private static final int FRAGMENT_NONE = 0;
  
  private static final int FUNCTION_INTRODUCTION = 1;
  
  private static final int REGISTERED_SHOP = 2;
  
  a content;
  
  int current = 0;
  
  Fragment currentFragment = null;
  
  FragmentManager fragmentManager;
  
  private int lastSelectedFragment = 1;
  
  aa titleBar;
  
  private void onFragmentReplaced(int paramInt) {
    switchFragmentByIndex(this.lastSelectedFragment, false);
    switchFragmentByIndex(paramInt, true);
    this.lastSelectedFragment = paramInt;
  }
  
  private void replaceFragment(int paramInt) {
    AdvertisementFunctionIntroductionFragment advertisementFunctionIntroductionFragment;
    if (paramInt == this.current)
      return; 
    AdvertisementRegisteredShopFragment advertisementRegisteredShopFragment = null;
    this.current = paramInt;
    switch (paramInt) {
      case 2:
        advertisementRegisteredShopFragment = new AdvertisementRegisteredShopFragment();
        break;
      case 1:
        advertisementFunctionIntroductionFragment = new AdvertisementFunctionIntroductionFragment();
        break;
    } 
    FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
    if (this.currentFragment != null)
      fragmentTransaction.remove(this.currentFragment); 
    fragmentTransaction.add(this.content.bCi.getId(), advertisementFunctionIntroductionFragment);
    fragmentTransaction.commit();
    this.currentFragment = advertisementFunctionIntroductionFragment;
    onFragmentReplaced(paramInt);
  }
  
  private void switchFragmentByIndex(int paramInt, boolean paramBoolean) {
    switch (paramInt) {
      default:
        return;
      case 2:
        this.content.cxR.setSelected(paramBoolean);
        return;
      case 1:
        break;
    } 
    this.content.cjy.setSelected(paramBoolean);
  }
  
  public void onBackPressed() { finish(); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.content = a.D(this);
    this.titleBar = aa.M(this);
    this.titleBar.brj.setVisibility(8);
    this.fragmentManager = getSupportFragmentManager();
    setupViews();
    setListeners();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new r(this));
    this.content.cxR.setOnClickListener(new s(this));
    this.content.cjy.setOnClickListener(new t(this));
  }
  
  public void setupViews() { this.titleBar.tvTitle.setText(getString(2131630069)); }
  
  public static class a {
    public View aQG;
    
    public ViewGroup bCi;
    
    public ViewGroup cjy;
    
    public ViewGroup cxR;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cjy = (ViewGroup)s.z(param1View, 2131297568);
      this.cxR = (ViewGroup)s.z(param1View, 2131297654);
      this.bCi = (ViewGroup)s.z(param1View, 2131297068);
    }
    
    public static a D(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427358, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisement\AdvertisementSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */