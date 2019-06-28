package com.laiqian.pos.hold;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.setting.by;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.s;
import hugo.weaving.DebugLog;

public class HoldSettingActivity extends FragmentActivityRoot {
  private static final int HOLDER_ORIGINAL_SETTING = 1;
  
  a content;
  
  int current = 0;
  
  Fragment currentFragment = null;
  
  FragmentManager fragmentManager;
  
  private View uiTitleBarHelpLl;
  
  private ImageView uiTitlebarHelpIv;
  
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
    HolderOpenTableSettingFragment holderOpenTableSettingFragment = null;
    if (paramInt == 1) {
      this.current = 1;
      holderOpenTableSettingFragment = new HolderOpenTableSettingFragment();
    } 
    FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
    if (this.currentFragment != null)
      fragmentTransaction.remove(this.currentFragment); 
    fragmentTransaction.add(this.content.bCi.getId(), holderOpenTableSettingFragment);
    fragmentTransaction.commit();
    onFragmentReplaced(paramInt, holderOpenTableSettingFragment);
  }
  
  public void hideTitleSetting() { this.uiTitleBarHelpLl.setVisibility(8); }
  
  @DebugLog
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) { super.onActivityResult(paramInt1, paramInt2, paramIntent); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.content = a.v(this);
    getWindow().setFeatureInt(7, 2131427634);
    setupViews();
    setListeners();
    this.fragmentManager = getSupportFragmentManager();
    replaceFragment(1);
  }
  
  public void setListeners() {
    findViewById(2131299878).setOnClickListener(new f(this));
    this.uiTitlebarHelpIv.setOnClickListener(new by(this, OpenTableSettingActivity.class));
    this.content.cnv.setOnClickListener(new g(this));
  }
  
  public void setupViews() {
    ((TextView)findViewById(2131299889)).setText(getString(2131625692));
    View view = findViewById(2131299879);
    byte b = 8;
    view.setVisibility(8);
    this.uiTitleBarHelpLl = findViewById(2131299883);
    this.uiTitlebarHelpIv = (ImageView)findViewById(2131299882);
    this.uiTitlebarHelpIv.setImageResource(2131231932);
    if (a.zR().Af()) {
      hideTitleSetting();
      return;
    } 
    view = this.uiTitleBarHelpLl;
    if (a.AZ().Bk())
      b = 0; 
    view.setVisibility(b);
  }
  
  public void showTitleSetting() {
    if (!a.zR().Af())
      this.uiTitleBarHelpLl.setVisibility(0); 
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
    
    public static a v(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427633, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\HoldSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */