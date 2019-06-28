package com.laiqian.wifi;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;
import com.laiqian.util.r;

public class WifiDebugFragment extends FragmentRoot {
  public static boolean dMo = true;
  
  a dMp;
  
  static  {
  
  }
  
  private void axL() { this.dMp.aQG.postDelayed(new a(this), 300L); }
  
  public void onAttach(Activity paramActivity) { super.onAttach(paramActivity); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.dMp = a.u(paramLayoutInflater);
    NetworkInfo networkInfo = ((ConnectivityManager)r.E(getActivity(), "connectivity")).getActiveNetworkInfo();
    this.dMp.cLn.setText(networkInfo.toString());
    axL();
    return this.dMp.aQG;
  }
  
  public void onDetach() {
    dMo = true;
    super.onDetach();
  }
  
  public static class a {
    public View aQG;
    
    public TextView cLn;
    
    public TextView dMr;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cLn = (TextView)s.z(param1View, 2131299556);
      this.dMr = (TextView)s.z(param1View, 2131299696);
    }
    
    public static a u(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427628, null)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wifi\WifiDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */