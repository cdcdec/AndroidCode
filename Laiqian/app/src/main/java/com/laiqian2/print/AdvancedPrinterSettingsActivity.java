package com.laiqian.print;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.laiqian.print.model.s;
import com.laiqian.print.model.type.c.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.l;

public class AdvancedPrinterSettingsActivity extends ActivityRoot {
  a cCl;
  
  s cCm;
  
  aa titleBar;
  
  public static Intent a(Context paramContext, s params) {
    Intent intent = new Intent(paramContext, AdvancedPrinterSettingsActivity.class);
    intent.putExtra("printerInfo", params);
    return intent;
  }
  
  private void aed() {
    this.cCm = (s)getIntent().getSerializableExtra("printerInfo");
    ((CheckBox)this.cCl.cCo.dwV.getView()).setChecked(this.cCm.agH());
    if (this.cCm instanceof c) {
      ((CheckBox)this.cCl.cCp.dwV.getView()).setChecked(((c)this.cCm).agT());
      return;
    } 
    ((ViewGroup)this.cCl.cCp.getView()).setVisibility(8);
    ((ViewGroup)this.cCl.cCo.getView()).setBackgroundResource(2130772052);
  }
  
  private void setListeners() {
    ((CheckBox)this.cCl.cCo.dwV.getView()).setOnCheckedChangeListener(new a(this));
    ((CheckBox)this.cCl.cCp.dwV.getView()).setOnCheckedChangeListener(new b(this));
  }
  
  private void setupViews() {
    ((ViewGroup)this.cCl.cCo.getView()).setBackgroundResource(2130772057);
    ((TextView)this.cCl.cCo.cAO.getView()).setText(getString(2131628949));
    ((ViewGroup)this.cCl.cCp.getView()).setBackgroundResource(2130772051);
    ((TextView)this.cCl.cCp.cAO.getView()).setText(2131628952);
    this.titleBar.tvTitle.setText(getString(2131628947));
    this.titleBar.brk.setVisibility(8);
    this.titleBar.brj.setVisibility(8);
  }
  
  public void finish() {
    Intent intent = new Intent();
    intent.putExtra("printerInfo", this.cCm);
    setResult(-1, intent);
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cCl = a.f(getWindow());
    this.titleBar = aa.M(this);
    setupViews();
    aed();
    setListeners();
  }
  
  private static class a {
    public View aQG;
    
    l cCo = new l(2131297698);
    
    l cCp = new l(2131297564);
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cCo.S(param1View.findViewById(this.cCo.getId()));
      this.cCp.S(param1View.findViewById(this.cCp.getId()));
    }
    
    public static a f(Window param1Window) {
      View view = View.inflate(param1Window.getContext(), 2131427357, null);
      param1Window.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\AdvancedPrinterSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */