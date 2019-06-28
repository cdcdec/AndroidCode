package com.laiqian.member.setting;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import com.laiqian.vip.R;

@Deprecated
public class VipSettingsActivity extends FragmentActivityRoot {
  private static final int EXIT = -1;
  
  private static final int FRAGMENT_CREDIT_SETTING = 4;
  
  private static final int FRAGMENT_DISCOUNT = 6;
  
  private static final int FRAGMENT_MARKETING_SETTING = 5;
  
  private static final int FRAGMENT_NONE = 0;
  
  private static final int FRAGMENT_POINTS_SETTING = 2;
  
  private static final int FRAGMENT_SETTING = 1;
  
  private static final int FRAGMENT_SMS_SETTING = 3;
  
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
      case 6:
        this.content.bCP.setSelected(true);
        this.content.bCO.setSelected(false);
        this.content.bCg.setSelected(false);
        this.content.bCQ.setSelected(false);
        this.content.bCR.setSelected(false);
        this.content.bCS.setSelected(false);
        this.titleBar.brk.setVisibility(0);
        return;
      case 5:
        this.content.bCQ.setSelected(false);
        this.content.bCP.setSelected(false);
        this.content.bCg.setSelected(false);
        this.content.bCO.setSelected(false);
        this.content.bCR.setSelected(false);
        this.content.bCS.setSelected(true);
        this.titleBar.brk.setVisibility(8);
        return;
      case 4:
        this.content.bCQ.setSelected(false);
        this.content.bCP.setSelected(false);
        this.content.bCg.setSelected(false);
        this.content.bCO.setSelected(false);
        this.content.bCR.setSelected(true);
        this.content.bCS.setSelected(false);
        this.titleBar.brk.setVisibility(0);
        return;
      case 3:
        this.content.bCQ.setSelected(true);
        this.content.bCP.setSelected(false);
        this.content.bCg.setSelected(false);
        this.content.bCO.setSelected(false);
        this.content.bCR.setSelected(false);
        this.content.bCS.setSelected(false);
        this.titleBar.brk.setVisibility(0);
        return;
      case 2:
        this.content.bCg.setSelected(true);
        this.content.bCP.setSelected(false);
        this.content.bCO.setSelected(false);
        this.content.bCQ.setSelected(false);
        this.content.bCR.setSelected(false);
        this.content.bCS.setSelected(false);
        this.titleBar.brk.setVisibility(0);
        return;
      case 1:
        break;
    } 
    this.content.bCO.setSelected(true);
    this.content.bCg.setSelected(false);
    this.content.bCQ.setSelected(false);
    this.content.bCR.setSelected(false);
    this.content.bCS.setSelected(false);
    this.content.bCP.setSelected(false);
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
    //   13: tableswitch default -> 52, 1 -> 115, 2 -> 103, 3 -> 91, 4 -> 79, 5 -> 67, 6 -> 55
    //   52: goto -> 124
    //   55: new com/laiqian/member/setting/discount/VipDiscountFragment
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: astore #5
    //   64: goto -> 124
    //   67: new com/laiqian/member/setting/marketing/MarketSettingFragment
    //   70: dup
    //   71: invokespecial <init> : ()V
    //   74: astore #5
    //   76: goto -> 124
    //   79: new com/laiqian/member/setting/credit/VipCreditSettingFragment
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore #5
    //   88: goto -> 124
    //   91: new com/laiqian/member/setting/sms/SmsSettingFragment
    //   94: dup
    //   95: invokespecial <init> : ()V
    //   98: astore #5
    //   100: goto -> 124
    //   103: new com/laiqian/member/setting/points/VipPointsSettingFragment
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore #5
    //   112: goto -> 124
    //   115: new com/laiqian/member/setting/discount/VipSettingFragment
    //   118: dup
    //   119: invokespecial <init> : ()V
    //   122: astore #5
    //   124: aload #5
    //   126: ifnonnull -> 139
    //   129: ldc 'create fragment failed?'
    //   131: iconst_0
    //   132: anewarray java/lang/Object
    //   135: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: return
    //   139: aload_0
    //   140: getfield fragmentManager : Landroid/support/v4/app/FragmentManager;
    //   143: invokevirtual beginTransaction : ()Landroid/support/v4/app/FragmentTransaction;
    //   146: astore #6
    //   148: aload_0
    //   149: getfield current : I
    //   152: istore #4
    //   154: iconst_1
    //   155: istore_3
    //   156: iload #4
    //   158: tableswitch default -> 200, 0 -> 609, 1 -> 544, 2 -> 479, 3 -> 414, 4 -> 349, 5 -> 284, 6 -> 219
    //   200: ldc 'Wrong argument: %d'
    //   202: iconst_1
    //   203: anewarray java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: goto -> 630
    //   219: iload_2
    //   220: ifeq -> 263
    //   223: aload_0
    //   224: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   227: instanceof com/laiqian/pos/settings/aa
    //   230: ifeq -> 263
    //   233: aload_0
    //   234: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   237: checkcast com/laiqian/pos/settings/aa
    //   240: invokeinterface Az : ()Z
    //   245: ifeq -> 263
    //   248: aload_0
    //   249: aload_0
    //   250: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   253: checkcast com/laiqian/pos/settings/aa
    //   256: iload_1
    //   257: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   260: goto -> 630
    //   263: aload #6
    //   265: aload_0
    //   266: getfield content : Lcom/laiqian/member/setting/VipSettingsActivity$a;
    //   269: getfield bCi : Landroid/view/ViewGroup;
    //   272: invokevirtual getId : ()I
    //   275: aload #5
    //   277: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   280: pop
    //   281: goto -> 632
    //   284: iload_2
    //   285: ifeq -> 328
    //   288: aload_0
    //   289: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   292: instanceof com/laiqian/pos/settings/aa
    //   295: ifeq -> 328
    //   298: aload_0
    //   299: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   302: checkcast com/laiqian/pos/settings/aa
    //   305: invokeinterface Az : ()Z
    //   310: ifeq -> 328
    //   313: aload_0
    //   314: aload_0
    //   315: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   318: checkcast com/laiqian/pos/settings/aa
    //   321: iload_1
    //   322: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   325: goto -> 630
    //   328: aload #6
    //   330: aload_0
    //   331: getfield content : Lcom/laiqian/member/setting/VipSettingsActivity$a;
    //   334: getfield bCi : Landroid/view/ViewGroup;
    //   337: invokevirtual getId : ()I
    //   340: aload #5
    //   342: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   345: pop
    //   346: goto -> 632
    //   349: iload_2
    //   350: ifeq -> 393
    //   353: aload_0
    //   354: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   357: instanceof com/laiqian/pos/settings/aa
    //   360: ifeq -> 393
    //   363: aload_0
    //   364: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   367: checkcast com/laiqian/pos/settings/aa
    //   370: invokeinterface Az : ()Z
    //   375: ifeq -> 393
    //   378: aload_0
    //   379: aload_0
    //   380: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   383: checkcast com/laiqian/pos/settings/aa
    //   386: iload_1
    //   387: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   390: goto -> 630
    //   393: aload #6
    //   395: aload_0
    //   396: getfield content : Lcom/laiqian/member/setting/VipSettingsActivity$a;
    //   399: getfield bCi : Landroid/view/ViewGroup;
    //   402: invokevirtual getId : ()I
    //   405: aload #5
    //   407: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   410: pop
    //   411: goto -> 632
    //   414: iload_2
    //   415: ifeq -> 458
    //   418: aload_0
    //   419: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   422: instanceof com/laiqian/pos/settings/aa
    //   425: ifeq -> 458
    //   428: aload_0
    //   429: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   432: checkcast com/laiqian/pos/settings/aa
    //   435: invokeinterface Az : ()Z
    //   440: ifeq -> 458
    //   443: aload_0
    //   444: aload_0
    //   445: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   448: checkcast com/laiqian/pos/settings/aa
    //   451: iload_1
    //   452: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   455: goto -> 630
    //   458: aload #6
    //   460: aload_0
    //   461: getfield content : Lcom/laiqian/member/setting/VipSettingsActivity$a;
    //   464: getfield bCi : Landroid/view/ViewGroup;
    //   467: invokevirtual getId : ()I
    //   470: aload #5
    //   472: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   475: pop
    //   476: goto -> 632
    //   479: iload_2
    //   480: ifeq -> 523
    //   483: aload_0
    //   484: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   487: instanceof com/laiqian/pos/settings/aa
    //   490: ifeq -> 523
    //   493: aload_0
    //   494: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   497: checkcast com/laiqian/pos/settings/aa
    //   500: invokeinterface Az : ()Z
    //   505: ifeq -> 523
    //   508: aload_0
    //   509: aload_0
    //   510: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   513: checkcast com/laiqian/pos/settings/aa
    //   516: iload_1
    //   517: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   520: goto -> 630
    //   523: aload #6
    //   525: aload_0
    //   526: getfield content : Lcom/laiqian/member/setting/VipSettingsActivity$a;
    //   529: getfield bCi : Landroid/view/ViewGroup;
    //   532: invokevirtual getId : ()I
    //   535: aload #5
    //   537: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   540: pop
    //   541: goto -> 632
    //   544: iload_2
    //   545: ifeq -> 588
    //   548: aload_0
    //   549: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   552: instanceof com/laiqian/pos/settings/aa
    //   555: ifeq -> 588
    //   558: aload_0
    //   559: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   562: checkcast com/laiqian/pos/settings/aa
    //   565: invokeinterface Az : ()Z
    //   570: ifeq -> 588
    //   573: aload_0
    //   574: aload_0
    //   575: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   578: checkcast com/laiqian/pos/settings/aa
    //   581: iload_1
    //   582: invokespecial showExitingDialog : (Lcom/laiqian/pos/settings/aa;I)V
    //   585: goto -> 630
    //   588: aload #6
    //   590: aload_0
    //   591: getfield content : Lcom/laiqian/member/setting/VipSettingsActivity$a;
    //   594: getfield bCi : Landroid/view/ViewGroup;
    //   597: invokevirtual getId : ()I
    //   600: aload #5
    //   602: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   605: pop
    //   606: goto -> 632
    //   609: aload #6
    //   611: aload_0
    //   612: getfield content : Lcom/laiqian/member/setting/VipSettingsActivity$a;
    //   615: getfield bCi : Landroid/view/ViewGroup;
    //   618: invokevirtual getId : ()I
    //   621: aload #5
    //   623: invokevirtual add : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   626: pop
    //   627: goto -> 632
    //   630: iconst_0
    //   631: istore_3
    //   632: aload #6
    //   634: invokevirtual commitAllowingStateLoss : ()I
    //   637: pop
    //   638: iload_3
    //   639: ifeq -> 649
    //   642: aload_0
    //   643: iload_1
    //   644: aload #5
    //   646: invokespecial onFragmentReplaced : (ILandroid/support/v4/app/Fragment;)V
    //   649: return }
  
  private void save() {
    if (this.currentFragment instanceof aa)
      ((aa)this.currentFragment).a(this.titleBar); 
  }
  
  private void showExitingDialog(aa paramaa, int paramInt) {
    r r = new r(this, new bb(this, paramaa, paramInt));
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
    this.content = a.o(this);
    this.titleBar = aa.M(this);
    this.fragmentManager = getSupportFragmentManager();
    setupViews();
    setListeners();
    replaceFragment(6);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new at(this));
    this.titleBar.brk.setOnClickListener(new au(this));
    this.content.bCO.setOnClickListener(new av(this));
    this.content.bCP.setOnClickListener(new aw(this));
    this.content.bCg.setOnClickListener(new ax(this));
    this.content.bCQ.setOnClickListener(new ay(this));
    this.content.bCR.setOnClickListener(new az(this));
    this.content.bCS.setOnClickListener(new ba(this));
  }
  
  public void setupViews() {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      this.content.bCQ.setVisibility(8); 
    this.titleBar.tvTitle.setText(getString(R.string.pos_main_setting_member_setting_title));
    this.titleBar.brk.setText(getString(R.string.save));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(0);
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      this.titleBar.brk.setVisibility(8); 
  }
  
  public static class a {
    public static final int aCt = R.layout.activity_vip_setting;
    
    public View aQG;
    
    public ViewGroup bCO;
    
    public ViewGroup bCP;
    
    public ViewGroup bCQ;
    
    public ViewGroup bCR;
    
    public ViewGroup bCS;
    
    public ViewGroup bCg;
    
    public ViewGroup bCi;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.bCO = (ViewGroup)s.z(param1View, R.id.layout_setting);
      this.bCP = (ViewGroup)s.z(param1View, R.id.layout_discount);
      this.bCg = (ViewGroup)s.z(param1View, R.id.layout_points_setting);
      this.bCQ = (ViewGroup)s.z(param1View, R.id.layout_sms_setting);
      this.bCR = (ViewGroup)s.z(param1View, R.id.layout_credit_setting);
      this.bCS = (ViewGroup)s.z(param1View, R.id.layout_marketing_setting);
      this.bCi = (ViewGroup)s.z(param1View, R.id.fragment_container);
      if (!a.zR().zT())
        this.bCQ.setVisibility(8); 
      if (!a.zR().zW())
        this.bCR.setVisibility(8); 
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1 || !a.zR().Aq())
        this.bCS.setVisibility(8); 
    }
    
    public static a o(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\VipSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */