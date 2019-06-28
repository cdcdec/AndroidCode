package com.laiqian.member.setting;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import com.laiqian.vip.R;

public class VipCardsSettingsActivity extends FragmentActivityRoot {
  private static final int EXIT = -1;
  
  private static final int FRAGMENT_MEMBER_INFO = 1;
  
  private static final int FRAGMENT_MEMBER_LEVEL = 4;
  
  private static final int FRAGMENT_MEMBER_RECHARGE = 2;
  
  private static final int FRAGMENT_NONE = 0;
  
  private static final int FRAGMENT_POINTS_SETTING = 3;
  
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
      case 4:
        this.content.bCh.setSelected(true);
        this.content.bCf.setSelected(false);
        this.content.bCg.setSelected(false);
        this.content.bCe.setSelected(false);
        this.titleBar.brk.setVisibility(0);
        return;
      case 3:
        this.content.bCg.setSelected(true);
        this.content.bCh.setSelected(false);
        this.content.bCe.setSelected(false);
        this.content.bCf.setSelected(false);
        this.titleBar.brk.setVisibility(0);
        return;
      case 2:
        this.content.bCe.setSelected(true);
        this.content.bCh.setSelected(false);
        this.content.bCg.setSelected(false);
        this.content.bCf.setSelected(false);
        this.titleBar.brk.setVisibility(0);
        return;
      case 1:
        break;
    } 
    this.content.bCf.setSelected(true);
    this.content.bCg.setSelected(false);
    this.content.bCh.setSelected(false);
    this.content.bCe.setSelected(false);
    this.titleBar.brk.setVisibility(0);
  }
  
  private void replaceFragment(int paramInt) { replaceFragment(paramInt, true); }
  
  private void replaceFragment(int paramInt, boolean paramBoolean) { // Byte code:
    //   0: iload_1
    //   1: aload_0
    //   2: getfield current : I
    //   5: if_icmpne -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore #5
    //   12: iload_1
    //   13: tableswitch default -> 44, 1 -> 75, 2 -> 67, 3 -> 55, 4 -> 47
    //   44: goto -> 80
    //   47: invokestatic RB : ()Lcom/laiqian/member/setting/VipLevelSettingFragment;
    //   50: astore #5
    //   52: goto -> 80
    //   55: new com/laiqian/member/setting/points/VipPointsSettingFragment
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: astore #5
    //   64: goto -> 80
    //   67: invokestatic RF : ()Lcom/laiqian/member/setting/VipRechargeRuleFragment;
    //   70: astore #5
    //   72: goto -> 80
    //   75: invokestatic Ry : ()Lcom/laiqian/member/setting/VipBasicInfoFragment;
    //   78: astore #5
    //   80: aload #5
    //   82: ifnonnull -> 95
    //   85: ldc 'create fragment failed?'
    //   87: iconst_0
    //   88: anewarray java/lang/Object
    //   91: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: return
    //   95: aload_0
    //   96: getfield fragmentManager : Landroid/support/v4/app/FragmentManager;
    //   99: invokevirtual beginTransaction : ()Landroid/support/v4/app/FragmentTransaction;
    //   102: astore #6
    //   104: aload_0
    //   105: getfield current : I
    //   108: istore #4
    //   110: iconst_1
    //   111: istore_3
    //   112: iload #4
    //   114: tableswitch default -> 148, 0 -> 427, 1 -> 362, 2 -> 297, 3 -> 232, 4 -> 167
    //   148: ldc 'Wrong argument: %d'
    //   150: iconst_1
    //   151: anewarray java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: iload_1
    //   157: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -> 448
    //   167: iload_2
    //   168: ifeq -> 211
    //   171: aload_0
    //   172: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   175: instanceof com/laiqian/pos/settings/aa
    //   178: ifeq -> 211
    //   181: aload_0
    //   182: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   185: checkcast com/laiqian/pos/settings/aa
    //   188: invokeinterface Az : ()Z
    //   193: ifeq -> 211
    //   196: aload_0
    //   197: aload_0
    //   198: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   201: checkcast com/laiqian/pos/settings/aa
    //   204: iload_1
    //   205: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   208: goto -> 448
    //   211: aload #6
    //   213: aload_0
    //   214: getfield content : Lcom/laiqian/member/setting/VipCardsSettingsActivity$a;
    //   217: getfield bCi : Landroid/view/ViewGroup;
    //   220: invokevirtual getId : ()I
    //   223: aload #5
    //   225: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   228: pop
    //   229: goto -> 450
    //   232: iload_2
    //   233: ifeq -> 276
    //   236: aload_0
    //   237: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   240: instanceof com/laiqian/pos/settings/aa
    //   243: ifeq -> 276
    //   246: aload_0
    //   247: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   250: checkcast com/laiqian/pos/settings/aa
    //   253: invokeinterface Az : ()Z
    //   258: ifeq -> 276
    //   261: aload_0
    //   262: aload_0
    //   263: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   266: checkcast com/laiqian/pos/settings/aa
    //   269: iload_1
    //   270: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   273: goto -> 448
    //   276: aload #6
    //   278: aload_0
    //   279: getfield content : Lcom/laiqian/member/setting/VipCardsSettingsActivity$a;
    //   282: getfield bCi : Landroid/view/ViewGroup;
    //   285: invokevirtual getId : ()I
    //   288: aload #5
    //   290: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   293: pop
    //   294: goto -> 450
    //   297: iload_2
    //   298: ifeq -> 341
    //   301: aload_0
    //   302: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   305: instanceof com/laiqian/pos/settings/aa
    //   308: ifeq -> 341
    //   311: aload_0
    //   312: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   315: checkcast com/laiqian/pos/settings/aa
    //   318: invokeinterface Az : ()Z
    //   323: ifeq -> 341
    //   326: aload_0
    //   327: aload_0
    //   328: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   331: checkcast com/laiqian/pos/settings/aa
    //   334: iload_1
    //   335: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   338: goto -> 448
    //   341: aload #6
    //   343: aload_0
    //   344: getfield content : Lcom/laiqian/member/setting/VipCardsSettingsActivity$a;
    //   347: getfield bCi : Landroid/view/ViewGroup;
    //   350: invokevirtual getId : ()I
    //   353: aload #5
    //   355: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   358: pop
    //   359: goto -> 450
    //   362: iload_2
    //   363: ifeq -> 406
    //   366: aload_0
    //   367: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   370: instanceof com/laiqian/pos/settings/aa
    //   373: ifeq -> 406
    //   376: aload_0
    //   377: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   380: checkcast com/laiqian/pos/settings/aa
    //   383: invokeinterface Az : ()Z
    //   388: ifeq -> 406
    //   391: aload_0
    //   392: aload_0
    //   393: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   396: checkcast com/laiqian/pos/settings/aa
    //   399: iload_1
    //   400: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   403: goto -> 448
    //   406: aload #6
    //   408: aload_0
    //   409: getfield content : Lcom/laiqian/member/setting/VipCardsSettingsActivity$a;
    //   412: getfield bCi : Landroid/view/ViewGroup;
    //   415: invokevirtual getId : ()I
    //   418: aload #5
    //   420: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   423: pop
    //   424: goto -> 450
    //   427: aload #6
    //   429: aload_0
    //   430: getfield content : Lcom/laiqian/member/setting/VipCardsSettingsActivity$a;
    //   433: getfield bCi : Landroid/view/ViewGroup;
    //   436: invokevirtual getId : ()I
    //   439: aload #5
    //   441: invokevirtual add : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   444: pop
    //   445: goto -> 450
    //   448: iconst_0
    //   449: istore_3
    //   450: aload #6
    //   452: invokevirtual commitAllowingStateLoss : ()I
    //   455: pop
    //   456: iload_3
    //   457: ifeq -> 467
    //   460: aload_0
    //   461: iload_1
    //   462: aload #5
    //   464: invokespecial onFragmentReplaced : (ILandroid/support/v4/app/Fragment;)V
    //   467: return }
  
  private void save() {
    if (this.currentFragment instanceof aa)
      ((aa)this.currentFragment).a(this.titleBar); 
  }
  
  private void showExitingDialog(aa paramaa, int paramInt) {
    r r = new r(this, new ac(this, paramaa, paramInt));
    r.setTitle(getString(R.string.pos_quit_save_hint_dialog_title));
    r.s(getString(R.string.pos_quit_save_hint_dialog_msg));
    r.t(getString(R.string.pos_quit_save_hint_dialog_sure));
    r.oZ(getString(R.string.pos_quit_save_hint_dialog_cancel));
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
    this.content = a.n(this);
    this.titleBar = aa.M(this);
    this.fragmentManager = getSupportFragmentManager();
    setupViews();
    setListeners();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new w(this));
    this.titleBar.brk.setOnClickListener(new x(this));
    this.content.bCe.setOnClickListener(new y(this));
    this.content.bCf.setOnClickListener(new z(this));
    this.content.bCg.setOnClickListener(new aa(this));
    this.content.bCh.setOnClickListener(new ab(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(R.string.pos_member_card_setting));
    this.titleBar.brk.setText(getString(R.string.save));
    Button button = this.titleBar.brj;
    byte b = 8;
    button.setVisibility(8);
    this.titleBar.brk.setVisibility(0);
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      this.titleBar.brk.setVisibility(8); 
    ViewGroup viewGroup = this.content.bCe;
    if (!LQKVersion.zl())
      b = 0; 
    viewGroup.setVisibility(b);
  }
  
  public static class a {
    public static final int aCt = R.layout.activity_vip_cards_setting;
    
    public View aQG;
    
    public ViewGroup bCe;
    
    public ViewGroup bCf;
    
    public ViewGroup bCg;
    
    public ViewGroup bCh;
    
    public ViewGroup bCi;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.bCe = (ViewGroup)s.z(param1View, R.id.layout_vip_recharge);
      this.bCf = (ViewGroup)s.z(param1View, R.id.layout_member_info);
      this.bCg = (ViewGroup)s.z(param1View, R.id.layout_points_setting);
      this.bCh = (ViewGroup)s.z(param1View, R.id.layout_member_level);
      this.bCi = (ViewGroup)s.z(param1View, R.id.fragment_container);
    }
    
    public static a n(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\VipCardsSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */