package com.laiqian.ordertool.mealorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.s;
import com.laiqian.util.bd;

public class MealOrderDownloadFragment extends FragmentRoot {
  private ImageView aZa;
  
  private ViewGroup ceb;
  
  private ViewGroup cec;
  
  private CheckBox ced;
  
  private TextView cee;
  
  private TextView cef;
  
  private TextView ceg;
  
  private void Zh() {
    this.aZa.setVisibility(8);
    this.ceg.setVisibility(8);
  }
  
  private void Zi() {
    if (!bd.bH(getActivity()))
      (new bc(getActivity())).show(); 
  }
  
  private void setListeners() {
    this.cec.setOnClickListener(new d(this));
    this.ced.setOnCheckedChangeListener(new e(this));
  }
  
  private void setupViews() {
    this.ceg.setText(getString(2131625691));
    this.cef.setText(2131625686);
    if (a.AZ().Bd()) {
      this.cee.setText(getString(2131625690));
      this.ced.setChecked(true);
      ServerService.aa(getActivity());
    } else {
      this.cee.setText(2131625690);
      this.ced.setChecked(false);
      ServerService.ae(getActivity());
    } 
    this.aZa.setImageResource(2131231716);
    if (!getResources().getBoolean(2131034140))
      Zh(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = LayoutInflater.from(getActivity()).inflate(2131427591, null);
    this.ceb = (ViewGroup)s.z(view, 2131297590);
    this.ced = (CheckBox)s.z(this.ceb, 2131297303);
    this.cee = (TextView)s.z(this.ceb, 2131297314);
    this.cec = (ViewGroup)s.z(view, 2131297578);
    this.cef = (TextView)s.z(this.cec, 2131297314);
    this.ceg = (TextView)s.z(view, 2131298973);
    this.aZa = (ImageView)s.z(view, 2131297399);
    if (getResources().getBoolean(2131034124))
      this.cec.setVisibility(8); 
    setupViews();
    setListeners();
    return view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\mealorder\MealOrderDownloadFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */