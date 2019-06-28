package com.laiqian.pos.hardware;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.laiqian.ui.s;

public class CustomerDisplayDebugFragment extends Fragment {
  private a ckb;
  
  private b ckc;
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131427581, null);
    this.ckb = new a(view);
    this.ckc = b.ckg;
    this.ckb.cke.setOnClickListener(new a(this));
    return view;
  }
  
  private static class a {
    public View aQG;
    
    public Button cke;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cke = (Button)s.z(param1View, 2131296544);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\CustomerDisplayDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */