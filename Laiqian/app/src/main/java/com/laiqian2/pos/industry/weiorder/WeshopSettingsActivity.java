package com.laiqian.pos.industry.weiorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import hugo.weaving.DebugLog;

public class WeshopSettingsActivity extends FragmentActivityRoot {
  private static final int EXIT = -1;
  
  private static final int FRAGMENT_BINDING = 3;
  
  private static final int FRAGMENT_FUNCTION = 4;
  
  private static final int FRAGMENT_MARKETING = 2;
  
  private static final int FRAGMENT_NONE = 0;
  
  private static final int FRAGMENT_SHOP_INFO = 1;
  
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
        this.titleBar.brj.setVisibility(8);
        this.content.cxl.setSelected(false);
        this.content.cxm.setSelected(false);
        this.content.cuh.setSelected(false);
        this.content.cwt.setSelected(true);
        return;
      case 3:
        this.titleBar.brj.setVisibility(8);
        this.content.cxl.setSelected(false);
        this.content.cxm.setSelected(false);
        this.content.cuh.setSelected(true);
        this.content.cwt.setSelected(false);
        return;
      case 2:
        this.titleBar.brj.setVisibility(8);
        this.content.cxl.setSelected(true);
        this.content.cxm.setSelected(false);
        this.content.cuh.setSelected(false);
        this.content.cwt.setSelected(false);
        return;
      case 1:
        break;
    } 
    this.titleBar.brj.setVisibility(8);
    this.content.cxl.setSelected(false);
    this.content.cxm.setSelected(true);
    this.content.cuh.setSelected(false);
    this.content.cwt.setSelected(false);
  }
  
  private void onHelpClick() { int i = this.current; }
  
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
    //   13: tableswitch default -> 44, 1 -> 83, 2 -> 71, 3 -> 59, 4 -> 47
    //   44: goto -> 92
    //   47: new com/laiqian/pos/industry/weiorder/WeshopFunctionFragment
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #5
    //   56: goto -> 92
    //   59: new com/laiqian/pos/industry/weiorder/WeshopBindingFragment
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore #5
    //   68: goto -> 92
    //   71: new com/laiqian/pos/industry/weiorder/WeshopMarketingFragment
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore #5
    //   80: goto -> 92
    //   83: new com/laiqian/pos/industry/weiorder/WeshopInfoFragment
    //   86: dup
    //   87: invokespecial <init> : ()V
    //   90: astore #5
    //   92: aload #5
    //   94: ifnonnull -> 107
    //   97: ldc 'create fragment failed?'
    //   99: iconst_0
    //   100: anewarray java/lang/Object
    //   103: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: return
    //   107: aload_0
    //   108: getfield fragmentManager : Landroid/support/v4/app/FragmentManager;
    //   111: invokevirtual beginTransaction : ()Landroid/support/v4/app/FragmentTransaction;
    //   114: astore #6
    //   116: aload_0
    //   117: getfield current : I
    //   120: istore #4
    //   122: iconst_1
    //   123: istore_3
    //   124: iload #4
    //   126: tableswitch default -> 160, 0 -> 384, 1 -> 200, 2 -> 200, 3 -> 179, 4 -> 200
    //   160: ldc 'Wrong argument: %d'
    //   162: iconst_1
    //   163: anewarray java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: iload_1
    //   169: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   172: aastore
    //   173: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: goto -> 405
    //   179: aload #6
    //   181: aload_0
    //   182: getfield content : Lcom/laiqian/pos/industry/weiorder/WeshopSettingsActivity$a;
    //   185: getfield bCi : Landroid/view/ViewGroup;
    //   188: invokevirtual getId : ()I
    //   191: aload #5
    //   193: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   196: pop
    //   197: goto -> 407
    //   200: iload_2
    //   201: ifeq -> 363
    //   204: aload_0
    //   205: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   208: instanceof com/laiqian/pos/industry/weiorder/g
    //   211: ifeq -> 363
    //   214: aload_0
    //   215: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   218: checkcast com/laiqian/pos/industry/weiorder/g
    //   221: invokeinterface Az : ()Z
    //   226: ifeq -> 363
    //   229: new java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial <init> : ()V
    //   236: astore #7
    //   238: aload #7
    //   240: ldc 'checkChanges='
    //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload #7
    //   248: iload_2
    //   249: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: ldc 'change'
    //   255: aload #7
    //   257: invokevirtual toString : ()Ljava/lang/String;
    //   260: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   263: new java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial <init> : ()V
    //   270: astore #7
    //   272: aload #7
    //   274: ldc 'isChanged='
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload #7
    //   282: aload_0
    //   283: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   286: checkcast com/laiqian/pos/industry/weiorder/g
    //   289: invokeinterface Az : ()Z
    //   294: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: ldc 'change'
    //   300: aload #7
    //   302: invokevirtual toString : ()Ljava/lang/String;
    //   305: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   308: new java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial <init> : ()V
    //   315: astore #7
    //   317: aload #7
    //   319: ldc 'currentFragment='
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload #7
    //   327: aload_0
    //   328: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   331: invokevirtual toString : ()Ljava/lang/String;
    //   334: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: ldc 'change'
    //   340: aload #7
    //   342: invokevirtual toString : ()Ljava/lang/String;
    //   345: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   348: aload_0
    //   349: aload_0
    //   350: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   353: checkcast com/laiqian/pos/industry/weiorder/g
    //   356: iload_1
    //   357: invokespecial showExitingDialog : (Lcom/laiqian/pos/industry/weiorder/g;I)V
    //   360: goto -> 405
    //   363: aload #6
    //   365: aload_0
    //   366: getfield content : Lcom/laiqian/pos/industry/weiorder/WeshopSettingsActivity$a;
    //   369: getfield bCi : Landroid/view/ViewGroup;
    //   372: invokevirtual getId : ()I
    //   375: aload #5
    //   377: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   380: pop
    //   381: goto -> 407
    //   384: aload #6
    //   386: aload_0
    //   387: getfield content : Lcom/laiqian/pos/industry/weiorder/WeshopSettingsActivity$a;
    //   390: getfield bCi : Landroid/view/ViewGroup;
    //   393: invokevirtual getId : ()I
    //   396: aload #5
    //   398: invokevirtual add : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   401: pop
    //   402: goto -> 407
    //   405: iconst_0
    //   406: istore_3
    //   407: aload #6
    //   409: invokevirtual commit : ()I
    //   412: pop
    //   413: iload_3
    //   414: ifeq -> 424
    //   417: aload_0
    //   418: iload_1
    //   419: aload #5
    //   421: invokespecial onFragmentReplaced : (ILandroid/support/v4/app/Fragment;)V
    //   424: return }
  
  private void save() {
    if (this.currentFragment instanceof g)
      ((g)this.currentFragment).a(this.titleBar); 
  }
  
  private void showExitingDialog(g paramg, int paramInt) {
    r r = new r(this, new hb(this, paramg, paramInt));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  @DebugLog
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.currentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed() {
    if (this.current != 0 && this.currentFragment != null && this.currentFragment instanceof g && ((g)this.currentFragment).Az()) {
      showExitingDialog((g)this.currentFragment, -1);
      return;
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.content = a.C(this);
    this.titleBar = aa.M(this);
    this.fragmentManager = getSupportFragmentManager();
    setupViews();
    setListeners();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new gu(this));
    this.titleBar.brk.setOnClickListener(new gv(this));
    this.titleBar.brj.setOnClickListener(new gw(this));
    this.content.cxl.setOnClickListener(new gx(this));
    this.content.cwt.setOnClickListener(new gy(this));
    this.content.cxm.setOnClickListener(new gz(this));
    this.content.cuh.setOnClickListener(new ha(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131630510));
    this.titleBar.brk.setText(getString(2131629495));
    this.titleBar.brj.setText(getString(2131630084));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(0);
  }
  
  public static class a {
    public View aQG;
    
    public ViewGroup bCi;
    
    public ViewGroup cuh;
    
    public ViewGroup cwt;
    
    public ViewGroup cxl;
    
    public ViewGroup cxm;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cxl = (ViewGroup)s.z(param1View, 2131297588);
      this.cxm = (ViewGroup)s.z(param1View, 2131297673);
      this.cuh = (ViewGroup)s.z(param1View, 2131298439);
      this.cwt = (ViewGroup)s.z(param1View, 2131297569);
      this.bCi = (ViewGroup)s.z(param1View, 2131297068);
    }
    
    public static a C(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427452, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */