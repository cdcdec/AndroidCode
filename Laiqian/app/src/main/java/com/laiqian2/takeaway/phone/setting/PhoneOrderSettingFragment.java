package com.laiqian.takeaway.phone.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.s;
import com.laiqian.util.bd;
import com.laiqian.util.m;

public class PhoneOrderSettingFragment extends FragmentRoot {
  private CheckBox ced;
  
  private TextView cee;
  
  private ViewGroup dve;
  
  private ViewGroup dvf;
  
  private TextView dvg;
  
  private View dvh;
  
  private void Zi() {
    if (!bd.bH(getActivity()))
      (new bc(getActivity())).show(); 
  }
  
  private void setListeners() {
    this.dvg.setOnClickListener(new m.c(getActivity(), PhoneListActivity.class));
    this.ced.setOnCheckedChangeListener(new p(this));
  }
  
  private void setupViews() {
    this.dvg.setText(2131630020);
    if (a.AZ().BT() && a.zR().zV()) {
      this.cee.setText(getString(2131630030));
      this.ced.setChecked(true);
      this.dvf.setVisibility(0);
      this.dvh.setBackgroundResource(2130772057);
      return;
    } 
    this.cee.setText(2131630030);
    this.ced.setChecked(false);
    this.dvf.setVisibility(8);
    this.dvh.setBackgroundResource(2130772035);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = LayoutInflater.from(getActivity()).inflate(2131427599, null);
    this.dvh = s.z(view, 2131297927);
    this.dve = (ViewGroup)s.z(view, 2131297707);
    this.ced = (CheckBox)s.z(this.dve, 2131297303);
    this.cee = (TextView)s.z(this.dve, 2131297314);
    this.dvf = (ViewGroup)s.z(view, 2131297708);
    this.dvg = (TextView)s.z(this.dvf, 2131297314);
    setupViews();
    setListeners();
    return view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\PhoneOrderSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */