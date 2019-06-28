package com.laiqian.pos.features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.l;

public class ScanOrderFunctionSwitchFragment extends FragmentRoot {
  a cjY;
  
  private void setListeners() {
    ((CheckBox)this.cjY.cka.dwV.getView()).setOnCheckedChangeListener(new ab(this));
    ((ViewGroup)this.cjY.cka.getView()).setOnClickListener(new ac(this));
  }
  
  private void setupViews() {
    ((TextView)this.cjY.cka.cAO.getView()).setText(getString(2131624309));
    ((ViewGroup)this.cjY.cka.getView()).setBackgroundResource(2131231850);
    ((CheckBox)this.cjY.cka.dwV.getView()).setChecked(a.AZ().Ch());
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    this.cjY = a.k(this);
    setupViews();
    setListeners();
    return this.cjY.getView();
  }
  
  public static class a extends ab<ViewGroup> {
    public l cka = new l(2131297663);
    
    public a(int param1Int) { super(param1Int); }
    
    public static a k(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(2131427605, null);
      a a1 = new a(16908290);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\ScanOrderFunctionSwitchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */