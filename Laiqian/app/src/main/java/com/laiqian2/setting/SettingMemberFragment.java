package com.laiqian.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.util.av;

public class SettingMemberFragment extends FragmentRoot {
  private boolean bBoss = true;
  
  private TextView dmh;
  
  private TextView dmi;
  
  private TextView dmj;
  
  private LinearLayout dmk;
  
  private View dml;
  
  private View dmm;
  
  private View dmn;
  
  private String nUserID;
  
  private void aoU() {
    av av = new av(getActivity());
    String str = av.atp();
    if (this.nUserID == null)
      this.nUserID = av.atm(); 
    this.bBoss = "150001".equals(str);
    if (this.bBoss) {
      this.dmk.setVisibility(8);
      this.dml.setVisibility(0);
      return;
    } 
    this.dml.setVisibility(8);
    this.dmm.setVisibility(8);
    this.dmn.setVisibility(8);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view1 = paramLayoutInflater.inflate(2131428030, null);
    View view2 = view1.findViewById(2131298146);
    this.dmm = view2.findViewById(2131297934);
    this.dmm.setOnClickListener(new by(getActivity(), com.laiqian.member.setting.VipCardsSettingsActivity.class, null));
    view2.findViewById(2131297938).setOnClickListener(new by(getActivity(), com.laiqian.member.MemberListActivity.class, null));
    this.dmn = view2.findViewById(2131298001);
    this.dmn.setOnClickListener(new by(getActivity(), com.laiqian.member.setting.VipSmsSettingActivity.class, null));
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      view2.findViewById(2131298001).setVisibility(8); 
    view2.findViewById(2131298171).setOnClickListener(new by(getActivity(), com.laiqian.member.report.VipReportActivity.class, null));
    this.dmk = (LinearLayout)view2.findViewById(2131298943);
    this.dmk.setOnClickListener(new by(getActivity(), com.laiqian.member.setting.VipSettingsActivity.class, null));
    this.dml = view1.findViewById(2131298942);
    aoU();
    this.dmh = (TextView)view1.findViewById(2131297097);
    this.dmi = (TextView)view1.findViewById(2131297098);
    this.dmj = (TextView)view1.findViewById(2131297124);
    return view1;
  }
  
  public void onResume() { super.onResume(); }
  
  public void onStart() { super.onStart(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */