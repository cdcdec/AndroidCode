package com.laiqian.scanorder.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.pos.settings.aa;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.m;
import com.laiqian.ui.s;

public class ScanOrderMoreSettingFragment extends FragmentRoot implements aa {
  a djv;
  
  aa titleBar;
  
  private void setListeners() {
    ((ViewGroup)this.djv.djx.getView()).setOnClickListener(new am(this));
    ((CheckBox)this.djv.djx.dwV.getView()).setOnCheckedChangeListener(new an(this));
    ((ViewGroup)this.djv.djy.getView()).setOnClickListener(new ao(this));
    ((CheckBox)this.djv.djy.dwV.getView()).setOnCheckedChangeListener(new ap(this));
  }
  
  private void setupViews() {
    ((TextView)this.djv.djx.cAO.getView()).setText(R.string.pos_pay_message_print);
    ((TextView)this.djv.djy.cAO.getView()).setText(R.string.scanorder_auto_confirm);
    ((ViewGroup)this.djv.djx.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((ViewGroup)this.djv.djy.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((CheckBox)this.djv.djx.dwV.getView()).setChecked(a.AZ().Cl());
    ((CheckBox)this.djv.djy.dwV.getView()).setChecked(a.AZ().Cm());
  }
  
  public boolean Az() { return false; }
  
  public void a(aa paramaa) { this.titleBar = paramaa; }
  
  public void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.djv = a.t(this);
    setupViews();
    setListeners();
    return this.djv.getView();
  }
  
  public void save() {}
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_more_setting;
    
    public ProgressBarCircularIndeterminate aNv;
    
    public ViewGroup bDV;
    
    public m djx = new m(R.id.layout_pay_message_print);
    
    public m djy = new m(R.id.layout_order_auto_confirm);
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.ivProgress);
      this.bDV = (ViewGroup)s.z(param1View, R.id.ll_content);
    }
    
    public static a t(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      if (view == null)
        throw new IllegalStateException("view cannot be null, inflate error"); 
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\ScanOrderMoreSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */