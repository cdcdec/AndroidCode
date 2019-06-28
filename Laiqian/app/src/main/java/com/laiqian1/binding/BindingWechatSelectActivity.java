package com.laiqian.binding;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.a;
import com.laiqian.network.i;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.wallet.R;
import com.laiqian.wallet.i;
import com.laiqian.wallet.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class BindingWechatSelectActivity extends ActivityRoot {
  private final i aJd = new i();
  
  private final int aJe = 30000;
  
  private a aJk;
  
  private Handler handler;
  
  private bb waitingDialog;
  
  private final void zI() {
    ActivityRoot activityRoot = getActivity();
    f.l(activityRoot, "activity");
    this.handler = (Handler)new h(this, activityRoot.getMainLooper());
  }
  
  private final void zK() {
    if (this.aJk != null) {
      a a1 = this.aJk;
      if (a1 == null)
        f.aQI(); 
      if (f.r(a1.getStatus(), AsyncTask.Status.FINISHED) ^ true) {
        a1 = this.aJk;
        if (a1 == null)
          f.aQI(); 
        a1.cancel(true);
      } 
    } 
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.binding_alipay_activity);
    setTitleTextView(R.string.wechat_payment_binding);
    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lv_load_pay_tip);
    f.l(recyclerView, "recyclerView");
    Context context = (Context)this;
    recyclerView.c((RecyclerView.g)new LinearLayoutManager(context));
    a a1 = new a(context, (List)zJ());
    recyclerView.a((RecyclerView.a)a1);
    a1.br(LayoutInflater.from(context).inflate(R.layout.line_view, (ViewGroup)recyclerView, false));
    View view = findViewById(R.id.tv_passageway_a);
    view.setOnClickListener((View.OnClickListener)new i(this));
    f.l(view, "tvPassagewayA");
    view.setActivated(false);
    view = findViewById(R.id.tv_passageway_b);
    view.setOnClickListener((View.OnClickListener)new j(this));
    f.l(view, "tvPassagewayB");
    view.setActivated(true);
    zI();
  }
  
  @NotNull
  public final ArrayList<a> zJ() {
    ArrayList arrayList = new ArrayList();
    String str1 = getString(R.string.payment_function);
    f.l(str1, "getString(R.string.payment_function)");
    String str2 = getString(R.string.aisle_a);
    f.l(str2, "getString(R.string.aisle_a)");
    String str3 = getString(R.string.aisle_b);
    f.l(str3, "getString(R.string.aisle_b)");
    arrayList.add(new a(str1, str2, str3, false, false));
    str1 = getString(R.string.store_qr_code_payment);
    f.l(str1, "getString(R.string.store_qr_code_payment)");
    str2 = getString(R.string.stand_by);
    f.l(str2, "getString(R.string.stand_by)");
    str3 = getString(R.string.stand_by);
    f.l(str3, "getString(R.string.stand_by)");
    arrayList.add(new a(str1, str2, str3, false, false));
    str1 = getString(R.string.store_scan_code_gun_payment);
    f.l(str1, "getString(R.string.store_scan_code_gun_payment)");
    str2 = getString(R.string.stand_by);
    f.l(str2, "getString(R.string.stand_by)");
    str3 = getString(R.string.stand_by);
    f.l(str3, "getString(R.string.stand_by)");
    arrayList.add(new a(str1, str2, str3, false, false));
    str1 = getString(R.string.store_member_recharge_payment);
    f.l(str1, "getString(R.string.store_member_recharge_payment)");
    str2 = getString(R.string.stand_by);
    f.l(str2, "getString(R.string.stand_by)");
    str3 = getString(R.string.stand_by);
    f.l(str3, "getString(R.string.stand_by)");
    arrayList.add(new a(str1, str2, str3, false, false));
    str1 = getString(R.string.wechat_takeaway);
    f.l(str1, "getString(R.string.wechat_takeaway)");
    str2 = getString(R.string.stand_by);
    f.l(str2, "getString(R.string.stand_by)");
    str3 = getString(R.string.not_support);
    f.l(str3, "getString(R.string.not_support)");
    arrayList.add(new a(str1, str2, str3, false, true));
    str1 = getString(R.string.wechat_member_recharge);
    f.l(str1, "getString(R.string.wechat_member_recharge)");
    str2 = getString(R.string.stand_by);
    f.l(str2, "getString(R.string.stand_by)");
    str3 = getString(R.string.not_support);
    f.l(str3, "getString(R.string.not_support)");
    arrayList.add(new a(str1, str2, str3, false, true));
    str1 = getString(R.string.review_pass_time);
    f.l(str1, "getString(R.string.review_pass_time)");
    str2 = getString(R.string.five_working_days);
    f.l(str2, "getString(R.string.five_working_days)");
    str3 = getString(R.string.one_working_day);
    f.l(str3, "getString(R.string.one_working_day)");
    arrayList.add(new a(str1, str2, str3, false, true));
    str1 = getString(R.string.payment_rate);
    f.l(str1, "getString(R.string.payment_rate)");
    str2 = getString(R.string.activity_in_progress);
    f.l(str2, "getString(R.string.activity_in_progress)");
    arrayList.add(new a(str1, "0.6%", str2, false, false));
    return arrayList;
  }
  
  public final void zL() {
    if (isFinishing())
      return; 
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb((Context)getActivity());
      bb bb2 = this.waitingDialog;
      if (bb2 == null)
        f.aQI(); 
      bb2.setCancelable(false);
    } 
    bb bb1 = this.waitingDialog;
    if (bb1 == null)
      f.aQI(); 
    bb1.show();
  }
  
  public final void zM() {
    if (isFinishing())
      return; 
    if (this.waitingDialog != null) {
      bb bb1 = this.waitingDialog;
      if (bb1 == null)
        f.aQI(); 
      bb1.dismiss();
    } 
    this.aJd.XV();
  }
  
  @Metadata
  private final class a extends AsyncTask<Void, Void, i> {
    @NotNull
    private final String aJg;
    
    public a(BindingWechatSelectActivity this$0, @NotNull String param1String) { this.aJg = param1String; }
    
    protected void a(@Nullable i param1i) {
      this.aJl.zM();
      if (param1i != null) {
        a a1;
        if (param1i.bUi) {
          null = a.AZ();
          f.l(null, "LQKConfiguration.getInstance()");
          null.bR("5");
          null = this.aJl.getLaiqianPreferenceManager();
          f.l(null, "laiqianPreferenceManager");
          null.rp((String)null);
          a1 = a.AZ();
          f.l(a1, "LQKConfiguration.getInstance()");
          a1.dX(7);
          RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_paytype"));
          this.aJl.startActivity(new Intent((Context)this.aJl.getActivity(), BindingWechatHelp.class));
          return;
        } 
        if (!by.isNull(a1.message))
          n.o((CharSequence)a1.message); 
      } 
    }
    
    @Nullable
    protected i c(@NotNull Void... param1VarArgs) {
      f.m(param1VarArgs, "params");
      return k.bG("2", this.aJg);
    }
    
    protected void onPreExecute() {
      BindingWechatSelectActivity.a(this.aJl).a(BindingWechatSelectActivity.b(this.aJl), BindingWechatSelectActivity.c(this.aJl));
      this.aJl.zL();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\BindingWechatSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */