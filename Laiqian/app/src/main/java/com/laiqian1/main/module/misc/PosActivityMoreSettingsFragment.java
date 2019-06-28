package com.laiqian.main.module.misc;

import android.app.Activity;
import android.arch.lifecycle.g;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.assistne.icondottextview.IconDotTextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.k.a;
import com.laiqian.l.a;
import com.laiqian.main.dl;
import com.laiqian.main.fh;
import com.laiqian.message.m;
import com.laiqian.pos.ReprintActivity;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.rx.util.LifecycleAwareObserver;
import com.laiqian.ui.a.r;
import com.laiqian.util.ae;
import com.laiqian.util.bd;
import com.laiqian.util.ch;
import com.laiqian.util.m;
import com.laiqian.version.c.a;
import java.io.IOException;
import java.util.List;

public class PosActivityMoreSettingsFragment extends Fragment {
  private dl bfr;
  
  a bgI;
  
  String bgJ = null;
  
  boolean bgK = false;
  
  private PopupWindow bgL;
  
  BroadcastReceiver bgM = new n(this);
  
  public PosActivityMoreSettingsFragment(dl paramdl) { this.bfr = paramdl; }
  
  private void Li() {
    a.y(getActivity(), "开钱箱");
    try {
      getActivity().sendBroadcast(new Intent("android.intent.money_test.action"));
      runtime = Runtime.getRuntime();
      try {
        runtime.exec("echo 0 > /sys/devices/platform/att_test/test");
      } catch (IOException runtime) {
        a.e(runtime);
      } 
      List list = j.cCx.a(new Object(), new String[] { "cash_drawer" });
      g.cGS.o(list);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void Lj() {
    try {
      m.Tv();
    } catch (Exception exception) {
      try {
        a.e(exception);
        Intent intent1 = new Intent();
        intent1.setClass(getActivity(), com.laiqian.pos.PosDownloaderAfterLogin.class);
        intent1.putExtra("SyncIntentExtraName", 1);
        startActivity(intent1);
      } catch (Exception exception) {
        a.e(exception);
      } 
    } 
    Intent intent = new Intent();
    intent.setClass(getActivity(), com.laiqian.pos.PosDownloaderAfterLogin.class);
    intent.putExtra("SyncIntentExtraName", 1);
    startActivity(intent);
  }
  
  private void MO() {
    r r = new r(getActivity(), new o(this));
    r.setTitle(getString(2131625532));
    r.s(getString(2131624850));
    r.arm().setText(getString(2131625529));
    r.arn().setText(getString(2131625538));
    r.show();
  }
  
  private void MP() {
    if (a.zR().Ae() || a.zR().Ag() || a.zR().As() || a.zR().Ah() || a.zR().zY()) {
      String str;
      if (this.bgK && this.bgJ != null) {
        this.bgK = false;
        str = this.bgJ;
      } else {
        null = new StringBuilder();
        null.append("");
        null.append(ch.getVersionCode());
        str = null.toString();
      } 
      a a1 = new a();
      q q = new q(this, str);
      this.bgI.bgR.aZ(false);
      a1.a(q, str);
      return;
    } 
    startActivity(new Intent(getActivity(), com.laiqian.milestone.inputFeedback.class));
  }
  
  @Deprecated
  private void bO(View paramView) {
    WindowManager.LayoutParams layoutParams = getActivity().getWindow().getAttributes();
    layoutParams.alpha = 0.7F;
    getActivity().getWindow().setAttributes(layoutParams);
    if (this.bgL == null) {
      byte b;
      View view1 = View.inflate(getActivity(), 2131427887, null);
      null = (LinearLayout)view1.findViewById(2131297946);
      null.setOnClickListener(new g(this));
      if (!((fh.b)this.bfr.bdK.getValue()).bfl)
        null.setVisibility(8); 
      null = view1.findViewById(2131296680);
      if (getActivity().getResources().getBoolean(2131034118)) {
        null.setOnClickListener(new m.c(getActivity(), com.laiqian.cashflow.CashFlowReport.class));
      } else {
        null.setVisibility(8);
      } 
      ((LinearLayout)view1.findViewById(2131297963)).setOnClickListener(new h(this));
      null = (LinearLayout)view1.findViewById(2131297964);
      if (a.zR().Aa()) {
        b = 0;
      } else {
        b = 8;
      } 
      null.setVisibility(b);
      null.setOnClickListener(new i(this));
      View view2 = view1.findViewById(2131297971);
      view2.setOnLongClickListener(new j(this));
      view2.setOnClickListener(new k(this));
      if (a.zR().Ak() && !RootApplication.getLaiqianPreferenceManager().awe())
        view2.setVisibility(8); 
      ((LinearLayout)view1.findViewById(2131297970)).setOnClickListener(new l(this));
      ((LinearLayout)view1.findViewById(2131297972)).setOnClickListener(new m(this));
      ((LinearLayout)view1.findViewById(2131297969)).setOnClickListener(new c(this));
      view2 = view1.findViewById(2131298440);
      ((LinearLayout)view1.findViewById(2131297973)).setOnClickListener(new d(this, view2));
      this.bgL = new PopupWindow(view1, -2, -2, true);
      this.bgL.setBackgroundDrawable(new ColorDrawable(false));
      this.bgL.setAnimationStyle(2131689689);
    } 
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if (this.bgK && this.bgL != null)
      this.bgL.getContentView().findViewById(2131298440).setVisibility(0); 
    this.bgL.setOnDismissListener(new e(this));
    this.bgL.showAtLocation(paramView, 0, arrayOfInt[0] + paramView.getWidth() + ae.b(getActivity().getApplicationContext(), 1.0F), arrayOfInt[1] + paramView.getHeight() / 3);
  }
  
  private void promptBeforeQuit() {
    r r = new r(getActivity(), new p(this));
    r.setTitle(getString(2131625532));
    r.s(getString(2131628259));
    r.arm().setText(getString(2131625529));
    r.arn().setText(getString(2131625538));
    r.show();
  }
  
  private void setupViews() { this.bgI.bgR.setOnClickListener(new a(this)); }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 111)
      return; 
    if (paramInt2 == -1) {
      this.bfr.bea.Mi();
      this.bfr.Mb();
    } 
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.bgI = new a(paramActivity);
    setupViews();
  }
  
  public void onStart() {
    super.onStart();
    getActivity().registerReceiver(this.bgM, new IntentFilter("customer_service_reply"));
    this.bfr.bel.beJ.a(b.aEo).c(LifecycleAwareObserver.a(getLifecycle(), g.a.ON_STOP, new f(this)));
  }
  
  public void onStop() {
    getActivity().unregisterReceiver(this.bgM);
    super.onStop();
  }
  
  static class a {
    IconDotTextView bgR;
    
    public a(Activity param1Activity) { this.bgR = (IconDotTextView)param1Activity.findViewById(2131298188); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\misc\PosActivityMoreSettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */