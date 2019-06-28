package com.laiqian.pos.industry.weiorder;

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

public class WeshopFunctionFragment extends FragmentRoot {
  a cvQ;
  
  private void setListeners() {
    ((CheckBox)this.cvQ.cka.dwV.getView()).setOnCheckedChangeListener(new et(this));
    ((ViewGroup)this.cvQ.cka.getView()).setOnClickListener(new eu(this));
  }
  
  private void setupViews() {
    ((TextView)this.cvQ.cka.cAO.getView()).setText(getString(2131624309));
    ((ViewGroup)this.cvQ.cka.getView()).setBackgroundResource(2131231850);
    ((CheckBox)this.cvQ.cka.dwV.getView()).setChecked(a.AZ().Ci());
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    this.cvQ = a.n(this);
    setupViews();
    setListeners();
    return this.cvQ.getView();
  }
  
  public static class a extends ab<ViewGroup> {
    public l cka = new l(2131297728);
    
    public a(int param1Int) { super(param1Int); }
    
    public static a n(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(2131427624, null);
      a a1 = new a(16908290);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopFunctionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */