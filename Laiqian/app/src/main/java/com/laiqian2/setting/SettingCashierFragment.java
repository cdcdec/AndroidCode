package com.laiqian.setting;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.concurrent.Executors;

public class SettingCashierFragment extends FragmentRoot {
  private boolean bBoss = true;
  
  private TextView bjG;
  
  private String[] dlO = { "1", "2" };
  
  private aq dlP;
  
  private aq dlQ;
  
  private r dlR;
  
  private String[] dlS = CrashApplication.zv().getResources().getStringArray(2130903077);
  
  private TextView dlT;
  
  private Dialog dlU;
  
  private void ape() {
    if (this.dlU == null) {
      this.dlU = new bb(getActivity());
      this.dlU.setCancelable(false);
    } 
    this.dlU.show();
    (new br(this)).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view1 = paramLayoutInflater.inflate(2131428024, null);
    if ("150001".equals(CrashApplication.getLaiqianPreferenceManager().atp())) {
      view1.findViewById(2131298378).setOnClickListener(new by(getActivity(), com.laiqian.pos.PayTypeSettingActivity.class, null));
    } else {
      view1.findViewById(2131298378).setOnClickListener(bg.bBU);
    } 
    if (a.zR().Ab()) {
      View view = view1.findViewById(2131298318);
      view.setVisibility(0);
      view.setOnClickListener(new by(getActivity(), com.laiqian.pos.settings.OrderTypeSettingActivity.class, null));
    } 
    null = view1.findViewById(2131299170);
    null = null.findViewById(2131299169);
    null.setSelected(a.AZ().Bc());
    null.setOnClickListener(new bh(this, getActivity(), null));
    view1.findViewById(2131296851).setOnClickListener(new m.c(getActivity(), SettingDecimals.class));
    null = view1.findViewById(2131297641);
    null = null.findViewById(2131299947);
    null.setSelected(a.AZ().Cq());
    null.setOnClickListener(new bi(this, getActivity(), null));
    null = view1.findViewById(2131299844);
    TextView textView2 = (TextView)null.findViewById(2131299843);
    null = new StringBuilder();
    null.append(a.AZ().Bf());
    null.append("");
    String str = null.toString();
    int i;
    for (i = 0; i < this.dlO.length; i++) {
      if (str.equals(this.dlO[i])) {
        textView2.setTag(Integer.valueOf(i));
        break;
      } 
    } 
    textView2.setText(str);
    null.setTag(textView2);
    null.setOnClickListener(new bj(this));
    null = view1.findViewById(2131298590);
    View view4 = null.findViewById(2131298584);
    view4.setSelected(a.AZ().BD());
    null.setOnClickListener(new bl(this, getActivity(), view4));
    view1.findViewById(2131296884).setOnClickListener(new by(getActivity(), DiscountSettingActivity.class));
    null = new av(getActivity());
    this.bBoss = "150001".equals(null.atp());
    null.close();
    View view2 = view1.findViewById(2131296884);
    if (this.bBoss) {
      i = 0;
    } else {
      i = 8;
    } 
    view2.setVisibility(i);
    view2 = view1.findViewById(2131298594);
    TextView textView1 = (TextView)view2.findViewById(2131298593);
    i = a.AZ().Bg();
    textView1.setText(getResources().getTextArray(2130903071)[i]);
    textView1.setTag(Integer.valueOf(i));
    view2.setTag(textView1);
    view2.setOnClickListener(new bm(this));
    view2 = view1.findViewById(2131298536);
    View view3 = view2.findViewById(2131298535);
    view3.setSelected(a.AZ().Bm());
    view2.setOnClickListener(new bo(this, getActivity(), view3));
    view2 = view1.findViewById(2131298565);
    if (!a.zR().Ab() && !a.zR().Ad())
      view2.setVisibility(8); 
    this.bjG = (TextView)view2.findViewById(2131298563);
    this.bjG.setText(this.dlS[CrashApplication.getLaiqianPreferenceManager().avy()]);
    view2.setOnClickListener(new bp(this));
    view2 = view1.findViewById(2131296467);
    boolean bool = (new av(getActivity())).avM();
    if (getResources().getBoolean(2131034117) && bool) {
      view2.setOnClickListener(new m.c(getActivity(), SettingBillNumber.class));
    } else {
      view2.setVisibility(8);
    } 
    view2 = view1.findViewById(2131298211);
    view2.setOnClickListener(new m.c(getActivity(), NeglectSmallChangesActivity.class));
    if (!bool) {
      view2.setVisibility(8);
    } else {
      view2.setVisibility(0);
    } 
    this.dlT = (TextView)view1.findViewById(2131297109);
    return view1;
  }
  
  public void onStart() { super.onStart(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingCashierFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */