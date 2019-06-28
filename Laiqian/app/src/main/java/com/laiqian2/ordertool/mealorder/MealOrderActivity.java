package com.laiqian.ordertool.mealorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import hugo.weaving.DebugLog;

public class MealOrderActivity extends FragmentActivityRoot {
  private static final int EXIT = -1;
  
  private static final int FRAGMENT_DOWNLOAD = 1;
  
  private static final int FRAGMENT_INTRODUCTION = 2;
  
  private static final int FRAGMENT_NONE = 0;
  
  a content;
  
  int current = 0;
  
  Fragment currentFragment = null;
  
  FragmentManager fragmentManager;
  
  aa titleBar;
  
  private void onFragmentReplaced(int paramInt, Fragment paramFragment) {
    this.current = paramInt;
    this.currentFragment = paramFragment;
    switch (this.current) {
      default:
        return;
      case 2:
        this.content.cdZ.setSelected(false);
        this.content.cea.setSelected(true);
        return;
      case 1:
        break;
    } 
    this.content.cdZ.setSelected(true);
    this.content.cea.setSelected(false);
  }
  
  private void replaceFragment(int paramInt) { replaceFragment(paramInt, true); }
  
  private void replaceFragment(int paramInt, boolean paramBoolean) {
    MealOrderDownloadFragment mealOrderDownloadFragment;
    if (paramInt == this.current)
      return; 
    MealOrderIntroFragment mealOrderIntroFragment = null;
    switch (paramInt) {
      case 2:
        this.current = 2;
        mealOrderIntroFragment = new MealOrderIntroFragment();
        break;
      case 1:
        this.current = 1;
        mealOrderDownloadFragment = new MealOrderDownloadFragment();
        break;
    } 
    FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
    if (this.currentFragment != null)
      fragmentTransaction.remove(this.currentFragment); 
    fragmentTransaction.add(this.content.bCi.getId(), mealOrderDownloadFragment);
    fragmentTransaction.commit();
    onFragmentReplaced(paramInt, mealOrderDownloadFragment);
  }
  
  @DebugLog
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) { super.onActivityResult(paramInt1, paramInt2, paramIntent); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.content = a.r(this);
    if (getResources().getBoolean(2131034124))
      this.content.cea.setVisibility(8); 
    this.titleBar = aa.M(this);
    setupViews();
    setListeners();
    this.fragmentManager = getSupportFragmentManager();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new a(this));
    this.content.cdZ.setOnClickListener(new b(this));
    this.content.cea.setOnClickListener(new c(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131625687));
    this.titleBar.brj.setVisibility(8);
  }
  
  public static class a {
    public View aQG;
    
    public ViewGroup bCi;
    
    public ViewGroup cdZ;
    
    public ViewGroup cea;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cdZ = (ViewGroup)s.z(param1View, 2131297559);
      this.cea = (ViewGroup)s.z(param1View, 2131297591);
      this.bCi = (ViewGroup)s.z(param1View, 2131297068);
    }
    
    public static a r(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427753, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\mealorder\MealOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */