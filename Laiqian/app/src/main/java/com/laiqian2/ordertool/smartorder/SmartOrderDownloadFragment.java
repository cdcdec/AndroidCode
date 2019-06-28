package com.laiqian.ordertool.smartorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.laiqian.ui.FragmentRoot;

public class SmartOrderDownloadFragment extends FragmentRoot {
  a ceJ;
  
  private void setupViews() { this.ceJ.ceL.setOnClickListener(new j(this)); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.ceJ = new a(this, this);
    setupViews();
    return this.ceJ.aQG;
  }
  
  private class a {
    public final int aCt = 2131427610;
    
    public View aQG;
    
    public Button ceL;
    
    public a(SmartOrderDownloadFragment this$0, Object param1Object) {
      this.aQG = LayoutInflater.from(((Fragment)param1Object).getContext()).inflate(2131427610, null);
      this.ceL = (Button)this.aQG.findViewById(2131296898);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\smartorder\SmartOrderDownloadFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */