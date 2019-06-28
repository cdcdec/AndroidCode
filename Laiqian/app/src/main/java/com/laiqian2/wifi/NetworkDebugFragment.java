package com.laiqian.wifi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;
import com.laiqian.util.bd;

public class NetworkDebugFragment extends FragmentRoot {
  a dMn;
  
  private void init() {
    StringBuilder stringBuilder = new StringBuilder();
    for (bd.a a1 : bd.ajf()) {
      stringBuilder.append(a1.getName());
      stringBuilder.append(": ");
      stringBuilder.append(a1.getAddress());
      stringBuilder.append(System.lineSeparator());
    } 
    this.dMn.bJv.setText(stringBuilder);
  }
  
  private void setListeners() {}
  
  private void setupViews() {}
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.dMn = new a(View.inflate(getActivity(), 2131427596, null));
    setupViews();
    setListeners();
    init();
    return this.dMn.aQG;
  }
  
  public static class a {
    public View aQG;
    
    public TextView bJv;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.bJv = (TextView)s.z(param1View, 2131299291);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wifi\NetworkDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */