package com.laiqian.pos.features;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.c.a;
import com.laiqian.pos.hardware.q;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.webview.SimplePosWebViewLinearLayout;

public class FunctionIntroduction extends FragmentRoot {
  private SimplePosWebViewLinearLayout cjv;
  
  String url = q.clv;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131427585, paramViewGroup, false);
    this.cjv = (SimplePosWebViewLinearLayout)view.findViewById(2131298991);
    if (a.zR().Ah()) {
      SimplePosWebViewLinearLayout simplePosWebViewLinearLayout1 = this.cjv;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.url);
      stringBuilder1.append(3);
      stringBuilder1.append("&type=KeShan");
      simplePosWebViewLinearLayout1.pf(stringBuilder1.toString());
      return view;
    } 
    if (a.zR().As()) {
      SimplePosWebViewLinearLayout simplePosWebViewLinearLayout1 = this.cjv;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.url);
      stringBuilder1.append(3);
      stringBuilder1.append("&type=linnuo");
      simplePosWebViewLinearLayout1.pf(stringBuilder1.toString());
      return view;
    } 
    if (a.zR().Ad()) {
      SimplePosWebViewLinearLayout simplePosWebViewLinearLayout1 = this.cjv;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.url);
      stringBuilder1.append(1);
      stringBuilder1.append("&type=CashCow");
      simplePosWebViewLinearLayout1.pf(stringBuilder1.toString());
      return view;
    } 
    SimplePosWebViewLinearLayout simplePosWebViewLinearLayout = this.cjv;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.url);
    stringBuilder.append(11);
    simplePosWebViewLinearLayout.pf(stringBuilder.toString());
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.cjv.onDestroy();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\FunctionIntroduction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */