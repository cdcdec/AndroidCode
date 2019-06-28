package com.laiqian.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.FragmentRoot;

public class SettingMallFragment extends FragmentRoot {
  private TextView dmg;
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428028, null);
    view.findViewById(2131298442).findViewById(2131298441).setOnClickListener(new by(getActivity(), com.laiqian.product.Mall.class, ""));
    this.dmg = (TextView)view.findViewById(2131297083);
    return view;
  }
  
  public void onStart() { super.onStart(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingMallFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */