package com.laiqian.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.pos.industry.setting.a;
import com.laiqian.pos.industry.setting.ad;
import com.laiqian.pos.industry.setting.n;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.bc;
import com.laiqian.util.av;
import com.laiqian.util.bd;

public class SettingBackupAndDeleteDataFragment extends FragmentRoot {
  private boolean bBoss = true;
  
  private View dlA;
  
  private View dlB;
  
  private TextView dlv;
  
  private TextView dlw;
  
  private TextView dlx;
  
  private TextView dly;
  
  private View dlz;
  
  private String nUserID;
  
  private void aoU() {
    av av = new av(getActivity());
    String str = av.atp();
    if (this.nUserID == null)
      this.nUserID = av.atm(); 
    this.bBoss = "150001".equals(str);
    this.dlz.setVisibility(0);
    if (this.bBoss && CrashApplication.getLaiqianPreferenceManager().QV() != 1)
      this.dlB.setVisibility(0); 
  }
  
  private void apb() {
    if (!checkNetwork())
      return; 
    (new n(getActivity(), false)).show();
  }
  
  private void apc() {
    if (!checkNetwork())
      return; 
    (new ad(getActivity())).show();
  }
  
  private void apd() {
    if (!checkNetwork())
      return; 
    (new a(getActivity())).show();
  }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(getActivity());
    if (!bd.bH(getActivity()))
      (new bc(getActivity())).show(); 
    return bool;
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    byte b;
    View view1 = paramLayoutInflater.inflate(2131428022, null);
    view1.findViewById(2131298945).setOnClickListener(new by(getActivity(), com.laiqian.sync.view.Sync.class, ""));
    view1.findViewById(2131298174).setOnClickListener(new by(getActivity(), com.laiqian.backup.BackUpSDCard.class, ""));
    view1.findViewById(2131298176).setOnClickListener(new by(getActivity(), com.laiqian.backup.BackUpUsb.class, ""));
    this.dlB = view1.findViewById(2131298450);
    this.dlB.setOnClickListener(new by(getActivity(), DateSettingActivity.class, ""));
    View view2 = view1.findViewById(2131297909);
    view2.setOnClickListener(new ay(this));
    if (a.AZ().By()) {
      b = 8;
    } else {
      b = 0;
    } 
    view2.setVisibility(b);
    this.dlz = view1.findViewById(2131299285);
    this.dlz.setOnClickListener(new az(this));
    this.dlA = view1.findViewById(2131298449);
    this.dlA.setOnClickListener(new ba(this));
    aoU();
    this.dlv = (TextView)view1.findViewById(2131297125);
    this.dlw = (TextView)view1.findViewById(2131297099);
    this.dlx = (TextView)view1.findViewById(2131297100);
    this.dly = (TextView)view1.findViewById(2131297130);
    return view1;
  }
  
  public void onStart() { super.onStart(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingBackupAndDeleteDataFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */