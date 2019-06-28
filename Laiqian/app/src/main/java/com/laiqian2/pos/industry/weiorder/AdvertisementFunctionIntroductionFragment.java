package com.laiqian.pos.industry.weiorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.help.e;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;
import com.laiqian.ui.webview.SimplePosWebViewLinearLayout;

public class AdvertisementFunctionIntroductionFragment extends FragmentRoot {
  public SimplePosWebViewLinearLayout cjv;
  
  private void setListeners() { this.cjv.pf(e.cnd); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = LayoutInflater.from(getActivity()).inflate(2131427456, null);
    this.cjv = (SimplePosWebViewLinearLayout)s.z(view, 2131298991);
    setListeners();
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.cjv.onDestroy();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\AdvertisementFunctionIntroductionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */