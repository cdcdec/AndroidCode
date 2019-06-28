package com.laiqian.ordertool.smartorder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.FragmentRoot;

public class SmartOrderIntroFragment extends FragmentRoot {
  a ceM;
  
  private void setupViews() {
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getString(2131629730), new Object[] { getString(2131629731), getString(2131629737), getString(2131629732) }));
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131099898)), 10, 22, 33);
    this.ceM.aNl.setText(spannableStringBuilder.toString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.ceM = new a(this, this);
    setupViews();
    return this.ceM.aQG;
  }
  
  private class a {
    public final int aCt = 2131427611;
    
    public TextView aNl;
    
    public View aQG;
    
    public a(SmartOrderIntroFragment this$0, Object param1Object) {
      if (param1Object instanceof Fragment) {
        this.aQG = LayoutInflater.from(((Fragment)param1Object).getContext()).inflate(2131427611, null);
      } else if (param1Object instanceof Activity) {
        this.aQG = LayoutInflater.from(((Fragment)param1Object).getContext()).inflate(2131427611, null);
        ((Activity)param1Object).setContentView(this.aQG);
      } else {
        throw new IllegalArgumentException();
      } 
      this.aNl = (TextView)this.aQG.findViewById(2131297284);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\smartorder\SmartOrderIntroFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */