package com.laiqian.scanorder.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.webview.SimplePosWebViewLinearLayout;

public class FunctionIntroduction extends FragmentRoot {
  private SimplePosWebViewLinearLayout cjv;
  
  String url = RootUrlParameter.clv;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_function_introduction, paramViewGroup, false);
    this.cjv = (SimplePosWebViewLinearLayout)view.findViewById(R.id.show_webview);
    SimplePosWebViewLinearLayout simplePosWebViewLinearLayout = this.cjv;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.url);
    stringBuilder.append(8);
    simplePosWebViewLinearLayout.pf(stringBuilder.toString());
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.cjv.onDestroy();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\FunctionIntroduction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */