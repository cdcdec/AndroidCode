package com.laiqian.pos.industry.setting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.d.a;
import com.laiqian.ui.layout.CheckBoxLayout;
import com.laiqian.util.bb;

public class MemberSettingFragment extends Fragment {
  private CheckBoxLayout csm;
  
  private void es() { this.csm.setChecked(a.AZ().Bu()); }
  
  public void Ek() { this.csm.a(new av(this)); }
  
  public void cC(View paramView) { this.csm = (CheckBoxLayout)paramView.findViewById(2131296732); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131427905, null);
    cC(view);
    Ek();
    return view;
  }
  
  public void onResume() {
    super.onResume();
    bb.e("onResume", "onResume");
    es();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\MemberSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */