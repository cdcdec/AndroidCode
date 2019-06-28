package com.laiqian.member.setting.marketing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.s;
import com.laiqian.vip.R;

public class MarketSettingFragment extends Fragment implements aa {
  a bEV;
  
  private void Ek() { this.bEV.bEX.setOnClickListener(new w(this)); }
  
  public boolean Az() { return false; }
  
  public void a(aa paramaa) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.bEV = a.f(this);
    Ek();
    return this.bEV.getView();
  }
  
  public void save() {}
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_vip_market_setting;
    
    View bEX;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.bEX = s.z(param1View, R.id.btn_marketting);
    }
    
    public static a f(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\MarketSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */