package com.laiqian.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.m;
import com.laiqian.util.n;
import io.reactivex.g.a;

public class WalletSettingFragment extends FragmentRoot {
  public static WalletSettingFragment dLd;
  
  private av aIP;
  
  private String cmQ;
  
  private String dLe;
  
  private View dLf;
  
  private TextView dLg;
  
  private TextView dLh;
  
  private View dLi;
  
  private TextView dLj;
  
  private TextView dLk;
  
  private View dLl;
  
  private TextView dLm;
  
  private View dLn;
  
  private final int dLo = 1;
  
  private final int dLp = -1;
  
  private Handler handler = new n(this);
  
  private View view;
  
  private boolean a(Thread paramThread) { return (paramThread.getName() != this.dLe || !isAdded()); }
  
  private void axB() { a.aKh().r(new l(this)); }
  
  public void axA() {
    this.dLl.setVisibility(0);
    (new m(this)).start();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是onCreateView：");
    stringBuilder.append(getActivity());
    n.println(stringBuilder.toString());
    if (this.view == null) {
      dLd = this;
      this.view = paramLayoutInflater.inflate(R.layout.pos_wallet_main, null);
      this.dLf = this.view.findViewById(R.id.interest_rate_l);
      this.dLg = (TextView)this.dLf.findViewById(R.id.interest_rate);
      this.dLh = (TextView)this.view.findViewById(R.id.balance);
      this.dLi = this.view.findViewById(R.id.interest_amount_l);
      this.dLj = (TextView)this.dLi.findViewById(R.id.interest_amount);
      this.dLk = (TextView)this.view.findViewById(R.id.last_interest);
      this.dLl = this.view.findViewById(R.id.loading);
      this.dLm = (TextView)this.view.findViewById(R.id.fail_text);
      this.dLn = this.view.findViewById(R.id.income_l);
      this.view.findViewById(R.id.detailed_l).setOnClickListener(new m.c(getActivity(), (new Intent(getActivity(), WalletRecord.class)).putExtra("isTransaction", true)));
      View view1 = this.view.findViewById(R.id.reflect_l);
      view1.setOnClickListener(new m.c(getActivity(), Withdrawals.class));
      ((TextView)view1.findViewById(R.id.reflect_hint)).setText(by.b(getString(R.string.pos_wallet_reflect_hint, new Object[] { "1%" }), "1%", 18, getResources().getColor(R.color.pos_text_brown)));
      this.view.findViewById(R.id.alipay_l).setOnClickListener(new m.c(getActivity(), com.laiqian.alipay.setting.AlipaySettingActivity.class));
      this.view.findViewById(R.id.help_l).setOnClickListener(new m.c(getActivity(), WalletHelp.class));
      this.aIP = new av(getActivity().getApplicationContext());
      this.cmQ = this.aIP.Tx();
      n.C(getActivity(), RootUrlParameter.ckS);
    } else {
      ViewGroup viewGroup = (ViewGroup)this.view.getParent();
      if (viewGroup != null)
        viewGroup.removeView(this.view); 
    } 
    if (bd.bH(getActivity())) {
      axA();
    } else {
      this.handler.obtainMessage(-1, getActivity().getString(R.string.pos_wallet_show_network_not_smooth)).sendToTarget();
    } 
    return this.view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\WalletSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */