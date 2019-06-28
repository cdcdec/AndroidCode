package com.laiqian.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public interface m {
  public static class a implements CompoundButton.OnCheckedChangeListener {
    private CheckBox bpx;
    
    private Context mContext;
    
    public a(Context param1Context, CheckBox param1CheckBox) {
      this.mContext = param1Context;
      this.bpx = param1CheckBox;
    }
    
    protected void a(CompoundButton param1CompoundButton) {}
    
    protected boolean a(CompoundButton param1CompoundButton, View param1View) { return false; }
    
    public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
      if (!param1CompoundButton.isEnabled())
        return; 
      if (!param1CompoundButton.isPressed())
        return; 
      if (a(param1CompoundButton, this.bpx)) {
        param1CompoundButton.setChecked(param1CompoundButton.isChecked());
        return;
      } 
      a(param1CompoundButton);
    }
  }
  
  public static class b implements View.OnClickListener {
    private View dEV;
    
    private boolean dEW;
    
    private a dEX;
    
    private Context mContext;
    
    public b(Context param1Context, View param1View) { this(param1Context, param1View, true); }
    
    public b(Context param1Context, View param1View, boolean param1Boolean) {
      this.mContext = param1Context;
      this.dEV = param1View;
      this.dEW = param1Boolean;
    }
    
    public void a(a param1a) { this.dEX = param1a; }
    
    protected boolean e(View param1View1, View param1View2) { return false; }
    
    protected void f(View param1View1, View param1View2) {}
    
    protected void hk(boolean param1Boolean) {}
    
    public void onClick(View param1View) {
      hk(this.dEV.isEnabled());
      if (!this.dEV.isEnabled())
        return; 
      if (e(param1View, this.dEV))
        return; 
      if (this.dEV instanceof android.widget.EditText) {
        this.dEV.requestFocus();
        if (this.dEW)
          n.b(this.mContext, this.dEV); 
      } else if (this.dEV instanceof CheckBox) {
        ((CheckBox)this.dEV).toggle();
      } else {
        this.dEV.setSelected(this.dEV.isSelected() ^ true);
      } 
      f(param1View, this.dEV);
      if (this.dEX != null)
        this.dEX.i(param1View, this.dEV.isSelected()); 
    }
    
    public static interface a {
      void i(View param2View, boolean param2Boolean);
    }
  }
  
  public static interface a {
    void i(View param1View, boolean param1Boolean);
  }
  
  public static class c implements View.OnClickListener {
    protected int dEY;
    
    protected Context mActivity;
    
    protected Intent mIntent;
    
    public c(Activity param1Activity, Intent param1Intent) {
      this(param1Activity);
      this.dEY = 0;
      this.mIntent = param1Intent;
    }
    
    public c(Activity param1Activity, Intent param1Intent, int param1Int) {
      this(param1Activity);
      this.dEY = param1Int;
      this.mIntent = param1Intent;
    }
    
    public c(Activity param1Activity, Class<?> param1Class, int param1Int) {
      this(param1Activity);
      this.dEY = param1Int;
      this.mIntent = new Intent(param1Activity, param1Class);
    }
    
    private c(Context param1Context) { this.mActivity = param1Context; }
    
    public c(Context param1Context, Class<?> param1Class) {
      this(param1Context);
      this.dEY = 0;
      this.mIntent = new Intent(param1Context, param1Class);
    }
    
    protected boolean h(Intent param1Intent) { return false; }
    
    protected void i(Intent param1Intent) {}
    
    public final void onClick(View param1View) {
      if (h(this.mIntent))
        return; 
      if (this.dEY == 0) {
        this.mActivity.startActivity(this.mIntent);
      } else {
        ((Activity)this.mActivity).startActivityForResult(this.mIntent, this.dEY);
      } 
      i(this.mIntent);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */