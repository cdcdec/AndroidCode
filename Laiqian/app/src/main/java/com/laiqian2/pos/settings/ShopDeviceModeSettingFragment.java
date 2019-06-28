package com.laiqian.pos.settings;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.network.o;
import com.laiqian.sync.a.g;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;
import java.util.HashMap;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.b.d;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class ShopDeviceModeSettingFragment extends Fragment {
  public static final a cBe = new a(null);
  
  @NotNull
  private final String TAG = "ShopDeviceModeSettingFragment";
  
  private r bCE;
  
  private r bCF;
  
  private final int cAX;
  
  private final int cAY = 1;
  
  private final int cAZ = 3;
  
  private HashMap cAq;
  
  private final int cBa = 4;
  
  private View cBb;
  
  private View cBc;
  
  private final bk cBd = new bk(this);
  
  private bb mWaitingDialog;
  
  private final void JZ() {
    r r1 = this.bCF;
    if (r1 == null)
      f.ut("mFailedRetryDialog"); 
    r1.a((r.a)new bi(this));
    r1 = this.bCE;
    if (r1 == null)
      f.ut("mOpenOnlineVIPWarningDiaglog"); 
    r1.a((r.a)new bj(this));
  }
  
  private final void RD() {
    this.cBd.obtainMessage(this.cAZ).sendToTarget();
    try {
      g g = new g((Context)getActivity());
      o.WQ().a(new FutureTask((Runnable)new bn(this, g), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  private final void RE() {
    this.bCE = new r((Context)getActivity(), true, null);
    r r2 = this.bCE;
    if (r2 == null)
      f.ut("mOpenOnlineVIPWarningDiaglog"); 
    r2.oZ("取消");
    r2 = this.bCE;
    if (r2 == null)
      f.ut("mOpenOnlineVIPWarningDiaglog"); 
    r2.t((CharSequence)"开启");
    r2 = this.bCE;
    if (r2 == null)
      f.ut("mOpenOnlineVIPWarningDiaglog"); 
    r2.setTitle(getString(2131626722));
    r2 = this.bCE;
    if (r2 == null)
      f.ut("mOpenOnlineVIPWarningDiaglog"); 
    r2.s((CharSequence)n.d((Context)getActivity(), "打开后，会员相关功能都需", "联网", "操作，推荐多收银机使用"));
    this.mWaitingDialog = new bb((Context)getActivity());
    bb bb1 = this.mWaitingDialog;
    if (bb1 == null)
      f.ut("mWaitingDialog"); 
    bb1.setCancelable(false);
    this.bCF = new r((Context)getActivity(), true, null);
    r r1 = this.bCF;
    if (r1 == null)
      f.ut("mFailedRetryDialog"); 
    r1.oZ("取消");
    r1 = this.bCF;
    if (r1 == null)
      f.ut("mFailedRetryDialog"); 
    r1.t((CharSequence)"重试");
    r1 = this.bCF;
    if (r1 == null)
      f.ut("mFailedRetryDialog"); 
    r1.setTitle(getString(2131626722));
    r1 = this.bCF;
    if (r1 == null)
      f.ut("mFailedRetryDialog"); 
    r1.s((CharSequence)"上传数据失败,请检查网络");
    r1 = new r((Context)getActivity(), true, null);
    r1.setTitle(getString(2131626722));
    r1.s((CharSequence)getString(2131625742));
    Button button = r1.arm();
    f.l(button, "pcd.leftButton");
    button.setText((CharSequence)getString(2131626715));
    r1.arn().setText(2131625741);
  }
  
  @NotNull
  public final String adA() { return this.TAG; }
  
  public void ado() {
    if (this.cAq != null)
      this.cAq.clear(); 
  }
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    RE();
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    f.m(paramLayoutInflater, "inflater");
    return paramLayoutInflater.inflate(2131427608, paramViewGroup, false);
  }
  
  public void onViewCreated(@Nullable View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    if (paramView == null)
      f.aQI(); 
    LinearLayout linearLayout2 = (LinearLayout)paramView.findViewById(2131297999);
    LinearLayout linearLayout1 = (LinearLayout)paramView.findViewById(2131297998);
    View view = linearLayout2.findViewById(2131296714);
    f.l(view, "llSingleDevice.findViewB…_shop_mode_single_device)");
    this.cBb = view;
    view = linearLayout1.findViewById(2131296713);
    f.l(view, "llMultiDevices.findViewB…_shop_mode_multi_devices)");
    this.cBc = view;
    JZ();
    a a1 = a.AZ();
    f.l(a1, "LQKConfiguration.getInstance()");
    if (a1.By()) {
      View view1 = this.cBc;
      if (view1 == null)
        f.ut("cbMultiDevices"); 
      view1.setSelected(true);
    } else {
      View view1 = this.cBb;
      if (view1 == null)
        f.ut("cbSingleDevice"); 
      view1.setSelected(true);
    } 
    linearLayout2.setOnClickListener((View.OnClickListener)new bl(this));
    linearLayout1.setOnClickListener((View.OnClickListener)new bm(this));
  }
  
  public final void save() {
    Toast.makeText((Context)getActivity(), 2131629499, 0).show();
    getActivity().finish();
  }
  
  @Metadata
  public static final class a {
    private a() {}
    
    @JvmStatic
    @NotNull
    public final ShopDeviceModeSettingFragment adB() { return new ShopDeviceModeSettingFragment(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ShopDeviceModeSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */