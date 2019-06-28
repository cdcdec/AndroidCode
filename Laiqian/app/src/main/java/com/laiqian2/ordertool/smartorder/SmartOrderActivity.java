package com.laiqian.ordertool.smartorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import hugo.weaving.DebugLog;

public class SmartOrderActivity extends AppCompatActivity {
  a ceD;
  
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
    SmartOrderSettingsFragment smartOrderSettingsFragment;
    SmartOrderIntroFragment smartOrderIntroFragment;
    SmartOrderDownloadFragment smartOrderDownloadFragment;
    if (paramInt == this.current)
      return; 
    OneKindOrderIntroFragment oneKindOrderIntroFragment = null;
    this.current = paramInt;
    switch (paramInt) {
      case 6:
        oneKindOrderIntroFragment = new OneKindOrderIntroFragment();
        null = new Bundle();
        null.putInt("instruction_fragment", 6);
        oneKindOrderIntroFragment.setArguments(null);
        break;
      case 5:
        oneKindOrderIntroFragment = new OneKindOrderIntroFragment();
        null = new Bundle();
        null.putInt("instruction_fragment", 5);
        oneKindOrderIntroFragment.setArguments(null);
        break;
      case 4:
        oneKindOrderIntroFragment = new OneKindOrderIntroFragment();
        null = new Bundle();
        null.putInt("instruction_fragment", 4);
        oneKindOrderIntroFragment.setArguments(null);
        break;
      case 3:
        smartOrderSettingsFragment = new SmartOrderSettingsFragment();
        break;
      case 2:
        smartOrderDownloadFragment = new SmartOrderDownloadFragment();
        break;
      case 1:
        smartOrderIntroFragment = new SmartOrderIntroFragment();
        break;
    } 
    FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
    if (this.currentFragment != null)
      fragmentTransaction.remove(this.currentFragment); 
    fragmentTransaction.add(this.ceD.bCi.getId(), smartOrderIntroFragment);
    fragmentTransaction.commit();
    this.currentFragment = smartOrderIntroFragment;
    onFragmentReplaced(paramInt);
  }
  
  private void switchFragmentByIndex(int paramInt, boolean paramBoolean) {
    switch (paramInt) {
      default:
        return;
      case 6:
        this.ceD.ceI.setSelected(paramBoolean);
        return;
      case 5:
        this.ceD.ceH.setSelected(paramBoolean);
        return;
      case 4:
        this.ceD.ceG.setSelected(paramBoolean);
        return;
      case 3:
        this.ceD.ceF.setSelected(paramBoolean);
        return;
      case 2:
        this.ceD.cdZ.setSelected(paramBoolean);
        return;
      case 1:
        break;
    } 
    this.ceD.cea.setSelected(paramBoolean);
  }
  
  @DebugLog
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) { super.onActivityResult(paramInt1, paramInt2, paramIntent); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.ceD = a.s(this);
    if (getResources().getBoolean(2131034124))
      this.ceD.cea.setVisibility(8); 
    this.titleBar = aa.M(this);
    setupViews();
    setListeners();
    this.fragmentManager = getSupportFragmentManager();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new c(this));
    this.ceD.cea.setOnClickListener(new d(this));
    this.ceD.cdZ.setOnClickListener(new e(this));
    this.ceD.ceF.setOnClickListener(new f(this));
    this.ceD.ceG.setOnClickListener(new g(this));
    this.ceD.ceH.setOnClickListener(new h(this));
    this.ceD.ceI.setOnClickListener(new i(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131629729));
    this.titleBar.brj.setVisibility(8);
  }
  
  public static class a {
    public View aQG;
    
    public ViewGroup bCi;
    
    public ViewGroup cdZ;
    
    public ViewGroup ceF;
    
    public ViewGroup ceG;
    
    public ViewGroup ceH;
    
    public ViewGroup ceI;
    
    public ViewGroup cea;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cea = (ViewGroup)s.z(param1View, 2131297591);
      this.cdZ = (ViewGroup)s.z(param1View, 2131297559);
      this.ceF = (ViewGroup)s.z(param1View, 2131297667);
      this.ceG = (ViewGroup)s.z(param1View, 2131297700);
      this.ceH = (ViewGroup)s.z(param1View, 2131297622);
      this.ceI = (ViewGroup)s.z(param1View, 2131297619);
      this.bCi = (ViewGroup)s.z(param1View, 2131297068);
    }
    
    public static a s(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131428129, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\smartorder\SmartOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */