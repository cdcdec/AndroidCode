package com.laiqian.pos.industry.weiorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.webview.SimplePosWebViewLinearLayout;

public class WechatAuthIntroduction extends FragmentRoot {
  private SimplePosWebViewLinearLayout cjv;
  
  String url = "";
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.url = getArguments().getString("url");
    View view = paramLayoutInflater.inflate(2131427585, paramViewGroup, false);
    this.cjv = (SimplePosWebViewLinearLayout)view.findViewById(2131298991);
    this.cjv.pf(this.url);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.cjv.onDestroy();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WechatAuthIntroduction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */