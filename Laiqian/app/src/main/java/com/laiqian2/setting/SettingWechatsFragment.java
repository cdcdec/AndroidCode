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
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.entity.av;
import com.laiqian.opentable.common.ah;
import com.laiqian.pos.industry.weiorder.fp;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.util.an;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.wallet.k;

public class SettingWechatsFragment extends FragmentRoot {
  private final int aJe = 10000;
  
  private ah bMe = new ah();
  
  private TextView dnd;
  
  private TextView dns;
  
  private TextView dnt;
  
  a dnu;
  
  private Handler handler;
  
  private bb waitingDialog;
  
  private boolean isFinishing() { return getActivity().isFinishing(); }
  
  private void kg(int paramInt) {
    if (!isDetached()) {
      if (getActivity() == null)
        return; 
      switch (paramInt) {
        default:
          return;
        case 2:
          if (this.dnd != null) {
            this.dnd.setVisibility(8);
            return;
          } 
          return;
        case 1:
          if (this.dnd != null) {
            this.dnd.setVisibility(0);
            this.dnd.setText(getString(2131628257));
            return;
          } 
          return;
        case 0:
          break;
      } 
      if (this.dnd != null) {
        this.dnd.setVisibility(0);
        this.dnd.setText(getString(2131628256));
      } 
      return;
    } 
  }
  
  private void zI() { this.handler = new cr(this, getActivity().getMainLooper()); }
  
  private void zK() {
    if (this.dnu != null && this.dnu.getStatus() != AsyncTask.Status.FINISHED)
      this.dnu.cancel(true); 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428040, null);
    view.findViewById(2131300027).setOnClickListener(new by(getActivity(), com.laiqian.pos.industry.weiorder.WeshopSettingsActivity.class, null));
    view.findViewById(2131298439).setOnClickListener(new by(getActivity(), com.laiqian.pos.industry.weiorder.WeChatWeshopBindingActivity.class, null));
    zI();
    null = new av(getActivity());
    boolean bool = "150001".equals(null.atp());
    null.close();
    String str = getLaiqianPreferenceManager().FD();
    if (bool) {
      if (by.isNull(str)) {
        if (a.zR().At()) {
          view.setOnClickListener(new cn(this));
        } else {
          view.findViewById(2131298461).setOnClickListener(new co(this));
        } 
      } else {
        view.findViewById(2131298461).setOnClickListener(new by(getActivity(), com.laiqian.pos.WeCharPayActivity.class, null));
      } 
    } else {
      view.findViewById(2131298461).setOnClickListener(new cq(this));
    } 
    view.findViewById(2131300029).setOnClickListener(new by(getActivity(), com.laiqian.pos.industry.weiorder.WeChatSettingMemberActivity.class, null));
    view.findViewById(2131300020).setOnClickListener(new by(getActivity(), com.laiqian.takeaway.miniprograms.WechatMiniProgramsActivity.class, null));
    view.findViewById(2131300020).setVisibility(8);
    view.findViewById(2131300022).setVisibility(8);
    this.dnd = (TextView)view.findViewById(2131300028);
    this.dns = (TextView)view.findViewById(2131297114);
    this.dnt = (TextView)view.findViewById(2131297135);
    return view;
  }
  
  public void onStart() {
    super.onStart();
    if (bd.bH(getActivity())) {
      (new b(this, null)).execute(new Void[0]);
    } else {
      this.dnd.setVisibility(8);
    } 
    an.a("100015", new cp(this));
  }
  
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
    private a(SettingWechatsFragment this$0) {}
    
    protected void g(Pair<Boolean, String> param1Pair) {
      this.dnw.zM();
      if (param1Pair != null) {
        if (((Boolean)param1Pair.first).booleanValue()) {
          this.dnw.startActivity(new Intent(this.dnw.getActivity(), com.laiqian.binding.BindingWechatHelp.class));
          return;
        } 
        this.dnw.startActivity(new Intent(this.dnw.getActivity(), com.laiqian.binding.BindingWechatSelectActivity.class));
      } 
    }
    
    protected Pair<Boolean, String> j(Void... param1VarArgs) { return k.st("2"); }
    
    protected void onPreExecute() {
      SettingWechatsFragment.c(this.dnw).a(SettingWechatsFragment.b(this.dnw), 10000);
      this.dnw.zL();
    }
  }
  
  private class b extends AsyncTask<Void, Void, Integer> {
    private b(SettingWechatsFragment this$0) {}
    
    protected Integer e(Void... param1VarArgs) {
      av av = fp.aX(this.dnw.getActivity()).abZ();
      return (av == null) ? Integer.valueOf(2) : (av.Jm() ? Integer.valueOf(1) : Integer.valueOf(0));
    }
    
    protected void e(Integer param1Integer) { SettingWechatsFragment.a(this.dnw, param1Integer.intValue()); }
    
    protected void onPreExecute() {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingWechatsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */