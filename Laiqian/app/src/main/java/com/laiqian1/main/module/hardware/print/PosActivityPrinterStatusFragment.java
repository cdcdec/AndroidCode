package com.laiqian.main.module.hardware.print;

import android.app.Activity;
import android.arch.lifecycle.g;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cantrowitz.rxbroadcast.e;
import com.laiqian.print.ac;
import com.laiqian.print.bm;
import com.laiqian.print.c.d;
import com.laiqian.print.c.f;
import com.laiqian.print.c.l;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.q;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.c;
import com.laiqian.print.util.e;
import com.laiqian.rx.util.LifecycleAwareObserver;
import com.laiqian.ui.s;
import com.laiqian.util.ae;
import com.laiqian.util.ay;
import io.reactivex.android.b.a;
import io.reactivex.h;
import java.util.ArrayList;
import java.util.List;

public class PosActivityPrinterStatusFragment extends Fragment {
  a bfW;
  
  CoordinatorLayout bfX;
  
  Snackbar bfY = null;
  
  TextView bfZ;
  
  d bga;
  
  private ay<f> bgb = new i(this);
  
  List<ac> bgc = new ArrayList();
  
  private f Mr() { return new f(getActivity()); }
  
  private void Ms() {
    this.bga = d.bg(getActivity());
    this.bga.a(new j(this));
    this.bfZ.setOnClickListener(new c(this));
    Mt();
  }
  
  private void Mt() { e.i(new d(this)); }
  
  private void Mu() {
    this.bgc.clear();
    this.bgc.addAll(c.bi(getActivity()).afs());
  }
  
  private void Mv() {
    for (ac ac : this.bgc) {
      e e = g.cGS.f(ac.aew()).a((PrintContent)null);
      e.a(new g(this));
      g.cGS.c(e);
    } 
    Mw();
  }
  
  private void Mw() { // Byte code:
    //   0: aload_0
    //   1: ldc 2131627284
    //   3: invokevirtual getString : (I)Ljava/lang/String;
    //   6: astore #6
    //   8: aload_0
    //   9: ldc 2131626970
    //   11: invokevirtual getString : (I)Ljava/lang/String;
    //   14: astore #7
    //   16: aload_0
    //   17: ldc 2131626877
    //   19: invokevirtual getString : (I)Ljava/lang/String;
    //   22: astore #8
    //   24: aload_0
    //   25: ldc 2131626859
    //   27: invokevirtual getString : (I)Ljava/lang/String;
    //   30: astore #9
    //   32: aload_0
    //   33: invokespecial Mx : ()[Ljava/util/ArrayList;
    //   36: astore #10
    //   38: iconst_4
    //   39: anewarray android/widget/TextView
    //   42: astore #11
    //   44: aload #11
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield bfW : Lcom/laiqian/main/module/hardware/print/PosActivityPrinterStatusFragment$a;
    //   51: getfield bgi : Landroid/widget/TextView;
    //   54: aastore
    //   55: aload #11
    //   57: iconst_1
    //   58: aload_0
    //   59: getfield bfW : Lcom/laiqian/main/module/hardware/print/PosActivityPrinterStatusFragment$a;
    //   62: getfield bgj : Landroid/widget/TextView;
    //   65: aastore
    //   66: aload #11
    //   68: iconst_2
    //   69: aload_0
    //   70: getfield bfW : Lcom/laiqian/main/module/hardware/print/PosActivityPrinterStatusFragment$a;
    //   73: getfield bgk : Landroid/widget/TextView;
    //   76: aastore
    //   77: aload #11
    //   79: iconst_3
    //   80: aload_0
    //   81: getfield bfW : Lcom/laiqian/main/module/hardware/print/PosActivityPrinterStatusFragment$a;
    //   84: getfield bgl : Landroid/widget/TextView;
    //   87: aastore
    //   88: iconst_0
    //   89: istore_3
    //   90: iconst_0
    //   91: istore_2
    //   92: iload_3
    //   93: aload #10
    //   95: arraylength
    //   96: if_icmpge -> 230
    //   99: iload_2
    //   100: istore #4
    //   102: aload #10
    //   104: iload_3
    //   105: aaload
    //   106: invokevirtual isEmpty : ()Z
    //   109: ifne -> 220
    //   112: aload #10
    //   114: iload_3
    //   115: aaload
    //   116: invokevirtual iterator : ()Ljava/util/Iterator;
    //   119: astore #12
    //   121: aload #12
    //   123: invokeinterface hasNext : ()Z
    //   128: ifeq -> 153
    //   131: aload #12
    //   133: invokeinterface next : ()Ljava/lang/Object;
    //   138: checkcast com/laiqian/print/model/q
    //   141: invokevirtual isConnected : ()Z
    //   144: ifne -> 121
    //   147: iconst_0
    //   148: istore #5
    //   150: goto -> 156
    //   153: iconst_1
    //   154: istore #5
    //   156: aload #11
    //   158: iload_2
    //   159: aaload
    //   160: iconst_0
    //   161: invokevirtual setVisibility : (I)V
    //   164: aload #11
    //   166: iload_2
    //   167: aaload
    //   168: iload #5
    //   170: invokevirtual setActivated : (Z)V
    //   173: aload #11
    //   175: iload_2
    //   176: aaload
    //   177: iload #5
    //   179: invokevirtual setSelected : (Z)V
    //   182: aload #11
    //   184: iload_2
    //   185: aaload
    //   186: iconst_4
    //   187: anewarray java/lang/String
    //   190: dup
    //   191: iconst_0
    //   192: aload #6
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload #7
    //   199: aastore
    //   200: dup
    //   201: iconst_2
    //   202: aload #8
    //   204: aastore
    //   205: dup
    //   206: iconst_3
    //   207: aload #9
    //   209: aastore
    //   210: iload_3
    //   211: aaload
    //   212: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   215: iload_2
    //   216: iconst_1
    //   217: iadd
    //   218: istore #4
    //   220: iload_3
    //   221: iconst_1
    //   222: iadd
    //   223: istore_3
    //   224: iload #4
    //   226: istore_2
    //   227: goto -> 92
    //   230: aload_0
    //   231: getfield bfW : Lcom/laiqian/main/module/hardware/print/PosActivityPrinterStatusFragment$a;
    //   234: getfield bgh : Landroid/widget/TextView;
    //   237: invokevirtual getTextSize : ()F
    //   240: fstore_1
    //   241: iload_2
    //   242: ifne -> 259
    //   245: aload_0
    //   246: getfield bfW : Lcom/laiqian/main/module/hardware/print/PosActivityPrinterStatusFragment$a;
    //   249: getfield bgh : Landroid/widget/TextView;
    //   252: iconst_0
    //   253: invokevirtual setVisibility : (I)V
    //   256: goto -> 333
    //   259: aload_0
    //   260: getfield bfW : Lcom/laiqian/main/module/hardware/print/PosActivityPrinterStatusFragment$a;
    //   263: getfield bgh : Landroid/widget/TextView;
    //   266: bipush #8
    //   268: invokevirtual setVisibility : (I)V
    //   271: iload_2
    //   272: tableswitch default -> 300, 2 -> 325, 3 -> 314, 4 -> 303
    //   300: goto -> 333
    //   303: fload_1
    //   304: ldc 10.0
    //   306: fdiv
    //   307: ldc 7.0
    //   309: fmul
    //   310: fstore_1
    //   311: goto -> 333
    //   314: fload_1
    //   315: ldc 10.0
    //   317: fdiv
    //   318: ldc 8.0
    //   320: fmul
    //   321: fstore_1
    //   322: goto -> 333
    //   325: fload_1
    //   326: ldc 10.0
    //   328: fdiv
    //   329: ldc 9.0
    //   331: fmul
    //   332: fstore_1
    //   333: iconst_0
    //   334: istore_3
    //   335: iload_3
    //   336: aload #11
    //   338: arraylength
    //   339: if_icmpge -> 375
    //   342: iload_3
    //   343: iload_2
    //   344: if_icmpge -> 359
    //   347: aload #11
    //   349: iload_3
    //   350: aaload
    //   351: iconst_0
    //   352: fload_1
    //   353: invokevirtual setTextSize : (IF)V
    //   356: goto -> 368
    //   359: aload #11
    //   361: iload_3
    //   362: aaload
    //   363: bipush #8
    //   365: invokevirtual setVisibility : (I)V
    //   368: iload_3
    //   369: iconst_1
    //   370: iadd
    //   371: istore_3
    //   372: goto -> 335
    //   375: return }
  
  private ArrayList<q>[] Mx() {
    ArrayList[] arrayOfArrayList = new ArrayList[4];
    arrayOfArrayList[0] = new ArrayList();
    arrayOfArrayList[1] = new ArrayList();
    arrayOfArrayList[2] = new ArrayList();
    arrayOfArrayList[3] = new ArrayList();
    int i = this.bgc.size();
    for (byte b = 0; b < i; b++) {
      null = (ac)this.bgc.get(b);
      q q = g.cGS.f(null.aew());
      for (bm bm : null.aex()) {
        switch (m.bgg[bm.ordinal()]) {
          default:
            continue;
          case 4:
            arrayOfArrayList[3].add(q);
            continue;
          case 3:
            arrayOfArrayList[2].add(q);
            continue;
          case 2:
            arrayOfArrayList[1].add(q);
            continue;
          case 1:
            break;
        } 
        arrayOfArrayList[0].add(q);
      } 
    } 
    return arrayOfArrayList;
  }
  
  private void a(s params) {
    this.bfY = Snackbar.a(this.bfX, getString(2131628918), 0);
    Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout)this.bfY.getView();
    snackbarLayout.setBackgroundResource(2131099898);
    ViewGroup.LayoutParams layoutParams = snackbarLayout.getLayoutParams();
    if (layoutParams instanceof ViewGroup.MarginLayoutParams)
      ((ViewGroup.MarginLayoutParams)layoutParams).setMargins(0, 0, 0, 0); 
    layoutParams.width = -1;
    layoutParams.height = ae.b(getActivity(), 64.0F);
    snackbarLayout.setLayoutParams(layoutParams);
    TextView textView = (TextView)s.z(snackbarLayout, 2131299026);
    textView.setTextColor(getResources().getColor(2131100027));
    textView.setTextSize(1, 20.0F);
    Button button = (Button)s.z(snackbarLayout, 2131299025);
    button.setTextColor(getResources().getColor(2131100027));
    button.setTextSize(1, 20.0F);
    snackbarLayout.setOnClickListener(new k(this, button));
    if (params.getType() == 2 || params.getType() == 1) {
      this.bfY.a(getString(2131628894), new l(this));
    } else {
      this.bfY.a(null, null);
    } 
    this.bfY.show();
  }
  
  private void setupViews() {
    this.bfW.aQx.setOnClickListener(new e(this));
    g.cGS.a(null);
    Ms();
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.bfW = a.b(paramActivity.getWindow());
    this.bfX = (CoordinatorLayout)paramActivity.findViewById(2131298529);
    this.bfZ = (TextView)paramActivity.findViewById(2131296435);
    setupViews();
    l.ahn().a(new a(this));
    g.cGS.a(new b(this));
  }
  
  public void onDetach() {
    this.bfW = null;
    this.bfX = null;
    l.ahn().a(null);
    super.onDetach();
  }
  
  public void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    e.a(getActivity(), intentFilter).c(LifecycleAwareObserver.a(getLifecycle(), g.a.ON_STOP, new f(this)));
    d.bg(getActivity()).refresh();
    Mu();
    Mv();
  }
  
  static final class a {
    LinearLayout aQx;
    
    TextView bgh;
    
    TextView bgi;
    
    TextView bgj;
    
    TextView bgk;
    
    TextView bgl;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bgh = (TextView)param1View.findViewById(2131298486);
      this.bgi = (TextView)param1View.findViewById(2131298491);
      this.bgj = (TextView)param1View.findViewById(2131298492);
      this.bgk = (TextView)param1View.findViewById(2131298493);
      this.bgl = (TextView)param1View.findViewById(2131298494);
    }
    
    static a b(Window param1Window) { return new a(param1Window.findViewById(2131298485)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\print\PosActivityPrinterStatusFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */