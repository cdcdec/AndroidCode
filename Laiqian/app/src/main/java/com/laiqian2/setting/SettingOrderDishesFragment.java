package com.laiqian.setting;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.opentable.common.b;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.util.bd;

public class SettingOrderDishesFragment extends FragmentRoot {
  private TextView dmo;
  
  private TextView dmp;
  
  private TextView dmq;
  
  private TextView dmr;
  
  private LinearLayout dms;
  
  private LinearLayout dmt;
  
  private TextView dmu;
  
  private TextView dmv;
  
  BroadcastReceiver dmw = new bx(this);
  
  private void KZ() {
    intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_order_change");
    try {
      getActivity().registerReceiver(this.dmw, intentFilter);
      return;
    } catch (Exception intentFilter) {
      a.e(intentFilter);
      return;
    } 
  }
  
  private void La() {
    try {
      if (this.dmw != null && isAdded()) {
        getActivity().unregisterReceiver(this.dmw);
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
  
  private void aoU() {
    if (getResources().getBoolean(2131034134) && a.zR().zU())
      this.dms.setVisibility(0); 
  }
  
  private Class apf() { return a.AZ().Bk() ? com.laiqian.ordertool.smartorder.SmartOrderActivity.class : com.laiqian.ordertool.mealorder.MealOrderActivity.class; }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428031, null);
    view.findViewById(2131298117).setOnClickListener(new by(getActivity(), com.laiqian.pos.hold.HoldSettingActivity.class, null));
    this.dms = (LinearLayout)view.findViewById(2131298445);
    this.dms.setOnClickListener(new by(getActivity(), com.laiqian.pos.features.ScanCodeOrderDishesActivity.class, null));
    this.dmt = (LinearLayout)view.findViewById(2131298458);
    this.dmt.setOnClickListener(new bv(this));
    if (a.zR().Ab() || a.zR().Ad())
      this.dms.setVisibility(8); 
    this.dmu = (TextView)view.findViewById(2131298308);
    this.dmv = (TextView)view.findViewById(2131298310);
    aoU();
    KZ();
    this.dmo = (TextView)view.findViewById(2131297105);
    this.dmp = (TextView)view.findViewById(2131297106);
    this.dmq = (TextView)view.findViewById(2131297101);
    this.dmr = (TextView)view.findViewById(2131297120);
    return view;
  }
  
  public void onDestroy() {
    La();
    super.onDestroy();
  }
  
  public void onStart() {
    super.onStart();
    if (a.AZ().Bd() || a.AZ().Bk()) {
      if (a.AZ().Bk()) {
        if (b.XB()) {
          String str;
          this.dmu.setText(getString(2131629729));
          TextView textView = this.dmv;
          if (a.AZ().Bk()) {
            str = "";
          } else {
            str = getString(2131625682);
          } 
          textView.setText(str);
        } else {
          TextView textView = this.dmu;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(getString(2131629729));
          stringBuilder.append(" (");
          stringBuilder.append(getString(2131625681));
          stringBuilder.append(bd.awo());
          stringBuilder.append(")");
          textView.setText(stringBuilder.toString());
        } 
      } else {
        TextView textView = this.dmu;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(2131625687));
        stringBuilder.append(" (");
        stringBuilder.append(getString(2131625681));
        stringBuilder.append(bd.awo());
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
      } 
    } else {
      this.dmu.setText(getString(2131625687));
    } 
    View view = getView().findViewById(2131298309);
    view.setOnClickListener(new by(getActivity(), apf(), null));
    byte b2 = 0;
    view.setVisibility(0);
    boolean bool = a.AZ().Bk();
    LinearLayout linearLayout = this.dmt;
    if (bool) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    linearLayout.setVisibility(b1);
    linearLayout = this.dms;
    byte b1 = b2;
    if (a.AZ().Bk())
      b1 = 8; 
    linearLayout.setVisibility(b1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingOrderDishesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */