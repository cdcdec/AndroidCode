package com.laiqian.promotion.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.promotion.R;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.util.bo;

public class SettingPromotionFragment extends FragmentRoot {
  private void cC(View paramView) { paramView.findViewById(R.id.promotion).setOnClickListener(new bo(getActivity(), PromotionListActivity.class, "100058")); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_setting_promotion, null);
    cC(view);
    return view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\SettingPromotionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */