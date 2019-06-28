package com.laiqian.scanorder.settings;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.settings.aa;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;

public class ScanOrderSettingActivity extends AppCompatActivity {
  int current = 0;
  
  Fragment currentFragment = null;
  
  View currentView;
  
  a djz;
  
  FragmentManager fragmentManager;
  
  aa titleBar;
  
  private void replaceFragment(int paramInt) { replaceFragment(paramInt, true); }
  
  private void replaceFragment(int paramInt, boolean paramBoolean) {
    FunctionIntroduction functionIntroduction;
    boolean bool;
    if (paramInt == this.current)
      return; 
    null = null;
    switch (paramInt) {
      case 6:
        null = new MenuStyleFragment();
        break;
      case 5:
        null = new ProductManageFragment();
        break;
      case 4:
        null = new ScanOrderMoreSettingFragment();
        break;
      case 3:
        null = new PayAndFeeFragment();
        break;
      case 2:
        null = new TableCodeExportFragment();
        break;
      case 1:
        functionIntroduction = new FunctionIntroduction();
        break;
    } 
    if (functionIntroduction == null) {
      Log.e("error", "create fragment failed?");
      return;
    } 
    FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
    switch (this.current) {
      default:
        bool = false;
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        if (paramBoolean && this.currentFragment instanceof aa && ((aa)this.currentFragment).Az()) {
          showExitingDialog((aa)this.currentFragment, paramInt);
        } else {
          fragmentTransaction.replace(this.djz.bCi.getId(), functionIntroduction);
          bool = true;
        } 
      case 0:
        fragmentTransaction.add(this.djz.bCi.getId(), functionIntroduction);
        bool = true;
    } 
    fragmentTransaction.commit();
    if (bool) {
      this.current = paramInt;
      this.currentFragment = functionIntroduction;
      if (this.currentView != null)
        this.currentView.setSelected(false); 
      switch (paramInt) {
        case 6:
          this.currentView = this.djz.djD;
          this.titleBar.brk.setVisibility(0);
          this.titleBar.brj.setVisibility(8);
          break;
        case 5:
          this.currentView = this.djz.djC;
          this.titleBar.brk.setVisibility(8);
          this.titleBar.brj.setVisibility(8);
          break;
        case 4:
          this.currentView = this.djz.djB;
          this.titleBar.brk.setVisibility(8);
          this.titleBar.brj.setVisibility(8);
          break;
        case 3:
          this.currentView = this.djz.cjA;
          this.titleBar.brk.setVisibility(0);
          this.titleBar.brj.setVisibility(8);
          break;
        case 2:
          this.currentView = this.djz.cjz;
          this.titleBar.brk.setVisibility(8);
          this.titleBar.brj.setVisibility(8);
          break;
        case 1:
          this.currentView = this.djz.cjy;
          this.titleBar.brk.setVisibility(8);
          this.titleBar.brj.setVisibility(8);
          break;
      } 
      this.currentView.setSelected(true);
    } 
  }
  
  private void save() {
    if (this.currentFragment instanceof aa)
      ((aa)this.currentFragment).a(this.titleBar); 
  }
  
  private void showExitingDialog(aa paramaa, int paramInt) {
    r r = new r(this, new ar(this, paramaa, paramInt));
    r.setTitle(getString(R.string.pos_quit_save_hint_dialog_title));
    if (this.currentFragment.getClass() == TableCodeExportFragment.class) {
      r.s(getString(R.string.pos_export_tip2));
      r.t(getString(R.string.pos_pay_print_no_title));
      r.oZ(getString(R.string.pos_pay_print_yes_title));
    } else {
      r.s(getString(R.string.pos_quit_save_hint_dialog_msg));
      r.t(getString(R.string.pos_quit_save_hint_dialog_sure));
      r.oZ(getString(R.string.pos_quit_save_hint_dialog_cancel));
    } 
    r.show();
  }
  
  public void onBackPressed() {
    if (this.current != 0 && this.currentFragment != null && this.currentFragment instanceof aa && ((aa)this.currentFragment).Az()) {
      showExitingDialog((aa)this.currentFragment, -1);
      return;
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.djz = a.J(this);
    this.titleBar = aa.M(this);
    this.fragmentManager = getSupportFragmentManager();
    setupViews();
    setListeners();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new aq(this));
    this.titleBar.brk.setOnClickListener(new as(this));
    this.titleBar.brj.setOnClickListener(new at(this));
    this.djz.cjy.setOnClickListener(new au(this));
    this.djz.cjz.setOnClickListener(new av(this));
    this.djz.djB.setOnClickListener(new aw(this));
    this.djz.cjA.setOnClickListener(new ax(this));
    this.djz.djD.setOnClickListener(new ay(this));
    this.djz.djC.setOnClickListener(new az(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(R.string.pos_scancode_orderdishes));
    this.titleBar.brk.setText(getString(R.string.save));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
  }
  
  public static class a {
    public static final int aCt = R.layout.activity_scan_order_setting;
    
    public View aQG;
    
    public ViewGroup bCi;
    
    public ViewGroup cjA;
    
    public ViewGroup cjy;
    
    public ViewGroup cjz;
    
    public ViewGroup djB;
    
    public ViewGroup djC;
    
    public ViewGroup djD;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cjy = (ViewGroup)s.z(param1View, R.id.function_introduction);
      this.cjz = (ViewGroup)s.z(param1View, R.id.qrcode_setting);
      this.cjA = (ViewGroup)s.z(param1View, R.id.pay_and_sales);
      this.djB = (ViewGroup)s.z(param1View, R.id.more_setting);
      this.djC = (ViewGroup)s.z(param1View, R.id.product_manage);
      this.djD = (ViewGroup)s.z(param1View, R.id.menu_style);
      this.bCi = (ViewGroup)s.z(param1View, R.id.fragment_container);
    }
    
    public static a J(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\ScanOrderSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */