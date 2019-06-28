package com.laiqian.pos.industry.weiorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.hardware.q;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import com.orhanobut.logger.d;
import hugo.weaving.DebugLog;

public class WeshopIntroductionActivity extends FragmentActivityRoot {
  private static final int EXIT = -1;
  
  private static final int FRAGMENT_FUNCTION = 1;
  
  private static final int FRAGMENT_NONE = 0;
  
  private static final int FRAGMENT_SETTING = 2;
  
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
        this.content.cwt.setSelected(false);
        this.content.bCO.setSelected(true);
        return;
      case 1:
        break;
    } 
    this.content.cwt.setSelected(true);
    this.content.bCO.setSelected(false);
  }
  
  private void replaceFragment(int paramInt) { replaceFragment(paramInt, true); }
  
  private void replaceFragment(int paramInt, boolean paramBoolean) {
    Bundle bundle;
    if (paramInt == this.current)
      return; 
    WechatAuthIntroduction wechatAuthIntroduction = null;
    new Bundle();
    switch (paramInt) {
      case 2:
        wechatAuthIntroduction = new WechatAuthIntroduction();
        bundle = new Bundle();
        bundle.putString("url", q.clS);
        wechatAuthIntroduction.setArguments(bundle);
        break;
      case 1:
        wechatAuthIntroduction = new WechatAuthIntroduction();
        bundle = new Bundle();
        bundle.putString("url", q.clS);
        wechatAuthIntroduction.setArguments(bundle);
        break;
    } 
    if (wechatAuthIntroduction == null) {
      d.c("create fragment failed?", new Object[0]);
      return;
    } 
    FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
    int i = this.current;
    boolean bool = true;
    switch (i) {
      default:
        d.c("Wrong argument: %d", new Object[] { Integer.valueOf(paramInt) });
        bool = false;
        break;
      case 1:
      case 2:
        fragmentTransaction.replace(this.content.bCi.getId(), wechatAuthIntroduction);
        break;
      case 0:
        fragmentTransaction.add(this.content.bCi.getId(), wechatAuthIntroduction);
        break;
    } 
    fragmentTransaction.commit();
    if (bool)
      onFragmentReplaced(paramInt, wechatAuthIntroduction); 
  }
  
  @DebugLog
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) { super.onActivityResult(paramInt1, paramInt2, paramIntent); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.content = a.B(this);
    this.titleBar = aa.M(this);
    this.fragmentManager = getSupportFragmentManager();
    setupViews();
    setListeners();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new fm(this));
    this.content.cwt.setOnClickListener(new fn(this));
    this.content.bCO.setOnClickListener(new fo(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131630545));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
  }
  
  public static class a {
    public View aQG;
    
    public ViewGroup bCO;
    
    public ViewGroup bCi;
    
    public ViewGroup cwt;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cwt = (ViewGroup)s.z(param1View, 2131297567);
      this.bCO = (ViewGroup)s.z(param1View, 2131297666);
      this.bCi = (ViewGroup)s.z(param1View, 2131297068);
    }
    
    public static a B(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427451, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopIntroductionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */