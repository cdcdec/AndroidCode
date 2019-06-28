package com.laiqian.setting;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.opentable.common.ah;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.wallet.k;
import java.util.Objects;

public class SettingAlipayFragment extends FragmentRoot {
  private boolean aFB;
  
  private final int aJe = 10000;
  
  private ah bMe = new ah();
  
  private LinearLayout dlp;
  
  private LinearLayout dlq;
  
  private TextView dlr;
  
  a dls;
  
  private Handler handler;
  
  private bb waitingDialog;
  
  private void aoU() {
    if (getResources().getBoolean(2131034125) && getResources().getBoolean(2131034130) && !a.zR().zY() && !a.zR().Ah()) {
      this.dlq.setVisibility(0);
      return;
    } 
    this.dlq.setVisibility(8);
  }
  
  private boolean isFinishing() { return getActivity().isFinishing(); }
  
  private void zI() { this.handler = new ax(this, getActivity().getMainLooper()); }
  
  private void zK() {
    if (this.dls != null && this.dls.getStatus() != AsyncTask.Status.FINISHED)
      this.dls.cancel(true); 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428021, null);
    this.aFB = "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp());
    this.dlp = (LinearLayout)view.findViewById(2131298432);
    this.dlq = (LinearLayout)view.findViewById(2131298430);
    this.dlq.setOnClickListener(new by(getActivity(), com.laiqian.pos.features.AliOrderActivity.class, null));
    String str = getLaiqianPreferenceManager().FC();
    if (this.aFB) {
      if (by.isNull(str)) {
        if (a.zR().At()) {
          this.dlp.setOnClickListener(new au(this));
        } else {
          this.dlp.setOnClickListener(new av(this));
        } 
      } else {
        this.dlp.setOnClickListener(new bf(getActivity(), com.laiqian.pos.AliPayActivity.class, this.aFB));
      } 
    } else {
      this.dlp.setOnClickListener(new aw(this));
    } 
    aoU();
    zI();
    this.dlr = (TextView)view.findViewById(2131297113);
    return view;
  }
  
  public void onStart() { super.onStart(); }
  
  public void zL() {
    if (isFinishing())
      return; 
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(getActivity());
      this.waitingDialog.setCancelable(false);
    } 
    this.waitingDialog.show();
  }
  
  public void zM() {
    if (isFinishing())
      return; 
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
    this.bMe.XV();
  }
  
  private class a extends AsyncTask<Void, Void, Pair<Boolean, String>> {
    private a(SettingAlipayFragment this$0) {}
    
    protected void g(Pair<Boolean, String> param1Pair) {
      this.dlu.zM();
      if (param1Pair != null) {
        if (((Boolean)param1Pair.first).booleanValue()) {
          if (Objects.equals(param1Pair.second, "4")) {
            this.dlu.startActivity(new Intent(this.dlu.getActivity(), com.laiqian.binding.BindingAlipayCodeHelp.class));
            return;
          } 
          this.dlu.startActivity(new Intent(this.dlu.getActivity(), com.laiqian.binding.BindingAlipayHelp.class));
          return;
        } 
        this.dlu.startActivity(new Intent(this.dlu.getActivity(), com.laiqian.binding.BindingAlipaySelectActivity.class));
      } 
    }
    
    protected Pair<Boolean, String> j(Void... param1VarArgs) { return k.st("1"); }
    
    protected void onPreExecute() {
      SettingAlipayFragment.c(this.dlu).a(SettingAlipayFragment.b(this.dlu), 10000);
      this.dlu.zL();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingAlipayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */