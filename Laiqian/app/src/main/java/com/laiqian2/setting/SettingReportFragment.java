package com.laiqian.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.auth.cj;
import com.laiqian.c.a;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.util.av;
import com.laiqian.util.m;

public class SettingReportFragment extends FragmentRoot {
  private TextView dmU;
  
  private TextView dmV;
  
  private TextView dmW;
  
  private TextView dmX;
  
  private TextView dmY;
  
  private TextView dmZ;
  
  private TextView dna;
  
  private TextView dnb;
  
  private boolean aph() {
    boolean bool2 = isDetached();
    boolean bool1 = false;
    if (!bool2) {
      if (getActivity() == null)
        return false; 
      null = new av(getActivity());
      String str2 = null.atp();
      String str1 = null.atm();
      if (!"150001".equals(str2)) {
        cj cj = new cj(getActivity());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append("");
        str1 = cj.bz(stringBuilder.toString());
        if (str1 != null) {
          if (!str1.contains("90001"))
            return false; 
        } else {
          return bool1;
        } 
      } 
      return true;
    } 
    return false;
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view1 = paramLayoutInflater.inflate(2131428037, null);
    view1.findViewById(2131296700).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.CashSummaryActivity.class, null));
    view1.findViewById(2131298299).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.OperateReport.class, null));
    view1.findViewById(2131298499).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.ProductReport.class, null));
    view1.findViewById(2131298401).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.PeriodReport.class, null));
    view1.findViewById(2131299284).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.TransactionReport.class, null));
    view1.findViewById(2131298477).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.PriceChangeReportActivity.class, null));
    view1.findViewById(2131298133).setOnClickListener(new by(getActivity(), com.laiqian.member.report.VipConsumptionReportActivity.class, null));
    view1.findViewById(2131298170).setOnClickListener(new by(getActivity(), com.laiqian.member.report.VipRechargeReportActivity.class, null));
    view1.findViewById(2131298173).setOnClickListener(new by(getActivity(), com.laiqian.member.report.VipPointsReportActivity.class, null));
    view1.findViewById(2131298944).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.ShiftReport.class, null));
    view1.findViewById(2131298288).setOnClickListener(new by(getActivity(), com.laiqian.report.onlinepay.OnlinePayReportActivity.class, null));
    View view2 = view1.findViewById(2131296687);
    if (getActivity().getResources().getBoolean(2131034118)) {
      view2.setOnClickListener(new m.c(getActivity(), com.laiqian.cashflow.CashFlowReport.class));
    } else {
      view2.setVisibility(8);
    } 
    view2 = view1.findViewById(2131299183);
    if (getResources().getBoolean(2131034127)) {
      view2.setOnClickListener(new by(getActivity(), com.laiqian.report.ui.TaxReport.class, null));
    } else {
      view2.setVisibility(8);
    } 
    if (!getResources().getBoolean(2131034119))
      view1.findViewById(2131298889).setVisibility(8); 
    if (a.zR().Ab() && aph()) {
      view2 = view1.findViewById(2131297751);
      View view = view1.findViewById(2131296862);
      view2.setVisibility(0);
      view.setVisibility(0);
      view.setOnClickListener(new by(getActivity(), com.laiqian.report.ui.DeliveryReport.class, null));
    } 
    this.dmU = (TextView)view1.findViewById(2131297081);
    this.dmV = (TextView)view1.findViewById(2131297103);
    this.dmW = (TextView)view1.findViewById(2131297116);
    this.dmX = (TextView)view1.findViewById(2131297110);
    this.dmY = (TextView)view1.findViewById(2131297129);
    this.dmZ = (TextView)view1.findViewById(2131297112);
    this.dna = (TextView)view1.findViewById(2131297127);
    this.dnb = (TextView)view1.findViewById(2131297102);
    return view1;
  }
  
  public void onStart() {
    super.onStart();
    this.dmU.setVisibility(8);
    this.dmV.setVisibility(8);
    this.dmW.setVisibility(8);
    this.dmX.setVisibility(8);
    this.dmY.setVisibility(8);
    this.dmZ.setVisibility(8);
    this.dna.setVisibility(8);
    this.dnb.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingReportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */