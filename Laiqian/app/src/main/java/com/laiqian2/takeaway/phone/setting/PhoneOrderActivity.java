package com.laiqian.takeaway.phone.setting;

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

public class PhoneOrderActivity extends FragmentActivityRoot {
  private static final int TELEPHONE_SETTING = 1;
  
  a content;
  
  int current = 0;
  
  Fragment currentFragment = null;
  
  FragmentManager fragmentManager;
  
  aa titleBar;
  
  private void onFragmentReplaced(int paramInt, Fragment paramFragment) {
    this.current = paramInt;
    this.currentFragment = paramFragment;
    if (this.current != 1)
      return; 
    this.content.cnv.setSelected(true);
  }
  
  private void replaceFragment(int paramInt) { replaceFragment(paramInt, true); }
  
  private void replaceFragment(int paramInt, boolean paramBoolean) {
    if (paramInt == this.current)
      return; 
    PhoneOrderSettingFragment phoneOrderSettingFragment = null;
    if (paramInt == 1) {
      this.current = 1;
      phoneOrderSettingFragment = new PhoneOrderSettingFragment();
    } 
    FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
    if (this.currentFragment != null)
      fragmentTransaction.remove(this.currentFragment); 
    fragmentTransaction.add(this.content.bCi.getId(), phoneOrderSettingFragment);
    fragmentTransaction.commit();
    onFragmentReplaced(paramInt, phoneOrderSettingFragment);
  }
  
  @DebugLog
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) { super.onActivityResult(paramInt1, paramInt2, paramIntent); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.content = a.L(this);
    this.titleBar = aa.M(this);
    setupViews();
    setListeners();
    this.fragmentManager = getSupportFragmentManager();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new n(this));
    this.content.cnv.setOnClickListener(new o(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131628360));
    this.titleBar.brj.setVisibility(8);
  }
  
  public static class a {
    public View aQG;
    
    public ViewGroup bCi;
    
    public ViewGroup cnv;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cnv = (ViewGroup)s.z(param1View, 2131297623);
      this.bCi = (ViewGroup)s.z(param1View, 2131297068);
    }
    
    public static a L(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427805, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\PhoneOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */