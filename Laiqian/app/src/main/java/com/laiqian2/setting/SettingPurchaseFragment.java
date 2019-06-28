package com.laiqian.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.FragmentRoot;

public class SettingPurchaseFragment extends FragmentRoot {
  private TextView dmT;
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428036, null);
    view.findViewById(2131298454).findViewById(2131298453).setOnClickListener(new by(getActivity(), com.laiqian.purchase.PurchaseActivity.class, null));
    this.dmT = (TextView)view.findViewById(2131297084);
    return view;
  }
  
  public void onStart() { super.onStart(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingPurchaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */