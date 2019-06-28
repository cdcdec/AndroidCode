package com.laiqian.pos.features;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.industry.weiorder.g;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;

public class ScanCodeOrderDishesActivity extends FragmentActivityRoot {
  private static final int EXIT = -1;
  
  private static final int FRAGMENT_FUNCTION_INTRODUCTION = 1;
  
  private static final int FRAGMENT_FUNCTION_SWITCH = 4;
  
  private static final int FRAGMENT_NONE = 0;
  
  private static final int FRAGMENT_PAY_AND_SELES = 3;
  
  private static final int FRAGMENT_QRCODE_SETTING = 2;
  
  a content;
  
  int current = 0;
  
  Fragment currentFragment = null;
  
  View currentView;
  
  FragmentManager fragmentManager;
  
  aa titleBar;
  
  private void replaceFragment(int paramInt) { replaceFragment(paramInt, true); }
  
  private void replaceFragment(int paramInt, boolean paramBoolean) { // Byte code:
    //   0: iload_1
    //   1: aload_0
    //   2: getfield current : I
    //   5: if_icmpne -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore #4
    //   12: iload_1
    //   13: tableswitch default -> 44, 1 -> 83, 2 -> 71, 3 -> 59, 4 -> 47
    //   44: goto -> 92
    //   47: new com/laiqian/pos/features/ScanOrderFunctionSwitchFragment
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #4
    //   56: goto -> 92
    //   59: new com/laiqian/pos/industry/weiorder/QrorderMarketingFragment
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore #4
    //   68: goto -> 92
    //   71: new com/laiqian/pos/features/ScanOrderExportFragment
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore #4
    //   80: goto -> 92
    //   83: new com/laiqian/pos/features/FunctionIntroduction
    //   86: dup
    //   87: invokespecial <init> : ()V
    //   90: astore #4
    //   92: aload #4
    //   94: ifnonnull -> 107
    //   97: ldc 'create fragment failed?'
    //   99: iconst_0
    //   100: anewarray java/lang/Object
    //   103: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: return
    //   107: aload_0
    //   108: getfield fragmentManager : Landroid/support/v4/app/FragmentManager;
    //   111: invokevirtual beginTransaction : ()Landroid/support/v4/app/FragmentTransaction;
    //   114: astore #5
    //   116: aload_0
    //   117: getfield current : I
    //   120: tableswitch default -> 156, 0 -> 240, 1 -> 175, 2 -> 175, 3 -> 175, 4 -> 175
    //   156: ldc 'Wrong argument: %d'
    //   158: iconst_1
    //   159: anewarray java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: iload_1
    //   165: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: goto -> 263
    //   175: iload_2
    //   176: ifeq -> 219
    //   179: aload_0
    //   180: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   183: instanceof com/laiqian/pos/industry/weiorder/g
    //   186: ifeq -> 219
    //   189: aload_0
    //   190: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   193: checkcast com/laiqian/pos/industry/weiorder/g
    //   196: invokeinterface Az : ()Z
    //   201: ifeq -> 219
    //   204: aload_0
    //   205: aload_0
    //   206: getfield currentFragment : Landroid/support/v4/app/Fragment;
    //   209: checkcast com/laiqian/pos/industry/weiorder/g
    //   212: iload_1
    //   213: invokespecial showExitingDialog : (Lcom/laiqian/pos/industry/weiorder/g;I)V
    //   216: goto -> 263
    //   219: aload #5
    //   221: aload_0
    //   222: getfield content : Lcom/laiqian/pos/features/ScanCodeOrderDishesActivity$a;
    //   225: getfield bCi : Landroid/view/ViewGroup;
    //   228: invokevirtual getId : ()I
    //   231: aload #4
    //   233: invokevirtual replace : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   236: pop
    //   237: goto -> 258
    //   240: aload #5
    //   242: aload_0
    //   243: getfield content : Lcom/laiqian/pos/features/ScanCodeOrderDishesActivity$a;
    //   246: getfield bCi : Landroid/view/ViewGroup;
    //   249: invokevirtual getId : ()I
    //   252: aload #4
    //   254: invokevirtual add : (ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   257: pop
    //   258: iconst_1
    //   259: istore_3
    //   260: goto -> 265
    //   263: iconst_0
    //   264: istore_3
    //   265: aload #5
    //   267: invokevirtual commit : ()I
    //   270: pop
    //   271: iload_3
    //   272: ifeq -> 490
    //   275: aload_0
    //   276: iload_1
    //   277: putfield current : I
    //   280: aload_0
    //   281: aload #4
    //   283: putfield currentFragment : Landroid/support/v4/app/Fragment;
    //   286: aload_0
    //   287: getfield currentView : Landroid/view/View;
    //   290: ifnull -> 301
    //   293: aload_0
    //   294: getfield currentView : Landroid/view/View;
    //   297: iconst_0
    //   298: invokevirtual setSelected : (Z)V
    //   301: iload_1
    //   302: tableswitch default -> 332, 1 -> 447, 2 -> 410, 3 -> 373, 4 -> 335
    //   332: goto -> 482
    //   335: aload_0
    //   336: aload_0
    //   337: getfield content : Lcom/laiqian/pos/features/ScanCodeOrderDishesActivity$a;
    //   340: getfield cjB : Landroid/view/ViewGroup;
    //   343: putfield currentView : Landroid/view/View;
    //   346: aload_0
    //   347: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   350: getfield brk : Landroid/widget/Button;
    //   353: bipush #8
    //   355: invokevirtual setVisibility : (I)V
    //   358: aload_0
    //   359: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   362: getfield brj : Landroid/widget/Button;
    //   365: bipush #8
    //   367: invokevirtual setVisibility : (I)V
    //   370: goto -> 482
    //   373: aload_0
    //   374: aload_0
    //   375: getfield content : Lcom/laiqian/pos/features/ScanCodeOrderDishesActivity$a;
    //   378: getfield cjA : Landroid/view/ViewGroup;
    //   381: putfield currentView : Landroid/view/View;
    //   384: aload_0
    //   385: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   388: getfield brk : Landroid/widget/Button;
    //   391: iconst_0
    //   392: invokevirtual setVisibility : (I)V
    //   395: aload_0
    //   396: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   399: getfield brj : Landroid/widget/Button;
    //   402: bipush #8
    //   404: invokevirtual setVisibility : (I)V
    //   407: goto -> 482
    //   410: aload_0
    //   411: aload_0
    //   412: getfield content : Lcom/laiqian/pos/features/ScanCodeOrderDishesActivity$a;
    //   415: getfield cjz : Landroid/view/ViewGroup;
    //   418: putfield currentView : Landroid/view/View;
    //   421: aload_0
    //   422: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   425: getfield brk : Landroid/widget/Button;
    //   428: bipush #8
    //   430: invokevirtual setVisibility : (I)V
    //   433: aload_0
    //   434: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   437: getfield brj : Landroid/widget/Button;
    //   440: iconst_0
    //   441: invokevirtual setVisibility : (I)V
    //   444: goto -> 482
    //   447: aload_0
    //   448: aload_0
    //   449: getfield content : Lcom/laiqian/pos/features/ScanCodeOrderDishesActivity$a;
    //   452: getfield cjy : Landroid/view/ViewGroup;
    //   455: putfield currentView : Landroid/view/View;
    //   458: aload_0
    //   459: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   462: getfield brk : Landroid/widget/Button;
    //   465: bipush #8
    //   467: invokevirtual setVisibility : (I)V
    //   470: aload_0
    //   471: getfield titleBar : Lcom/laiqian/ui/container/aa;
    //   474: getfield brj : Landroid/widget/Button;
    //   477: bipush #8
    //   479: invokevirtual setVisibility : (I)V
    //   482: aload_0
    //   483: getfield currentView : Landroid/view/View;
    //   486: iconst_1
    //   487: invokevirtual setSelected : (Z)V
    //   490: return }
  
  private void save() {
    if (this.currentFragment instanceof g)
      ((g)this.currentFragment).a(this.titleBar); 
  }
  
  private void showExitingDialog(g paramg, int paramInt) {
    r r = new r(this, new n(this, paramg, paramInt));
    r.setTitle(getString(2131627735));
    if (this.currentFragment.getClass() == ScanOrderExportFragment.class) {
      r.s(getString(2131626757));
      r.t(getString(2131627282));
      r.oZ(getString(2131627285));
    } else {
      r.s(getString(2131627733));
      r.t(getString(2131627734));
      r.oZ(getString(2131627732));
    } 
    r.show();
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
    this.content = a.u(this);
    this.titleBar = aa.M(this);
    this.fragmentManager = getSupportFragmentManager();
    setupViews();
    setListeners();
    replaceFragment(1);
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new g(this));
    this.titleBar.brk.setOnClickListener(new h(this));
    this.titleBar.brj.setOnClickListener(new i(this));
    this.content.cjy.setOnClickListener(new j(this));
    this.content.cjz.setOnClickListener(new k(this));
    this.content.cjB.setOnClickListener(new l(this));
    this.content.cjA.setOnClickListener(new m(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131627171));
    this.titleBar.brk.setText(getString(2131629495));
    this.titleBar.brj.setText(getString(2131630084));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
  }
  
  public static class a {
    public View aQG;
    
    public ViewGroup bCi;
    
    public ViewGroup cjA;
    
    public ViewGroup cjB;
    
    public ViewGroup cjy;
    
    public ViewGroup cjz;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cjy = (ViewGroup)s.z(param1View, 2131297137);
      this.cjz = (ViewGroup)s.z(param1View, 2131298640);
      this.cjA = (ViewGroup)s.z(param1View, 2131298357);
      this.cjB = (ViewGroup)s.z(param1View, 2131297569);
      this.bCi = (ViewGroup)s.z(param1View, 2131297068);
    }
    
    public static a u(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427414, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\ScanCodeOrderDishesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */