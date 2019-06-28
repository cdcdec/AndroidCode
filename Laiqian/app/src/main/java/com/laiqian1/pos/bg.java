package com.laiqian.pos;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.laiqian.util.ar;
import com.laiqian.util.l;

public class bg extends aw {
  Button cfW = null;
  
  double cgA = 0.0D;
  
  private double cgB;
  
  EditText cgz = null;
  
  public bg(Context paramContext, int paramInt) { super(paramContext, paramInt); }
  
  protected void ct(View paramView) {
    super.ct(paramView);
    this.cgz = (EditText)this.oR.findViewById(2131296956);
    this.cgz.setTag("etPosDiscountAmount");
    this.cgz.setFilters(ar.lw(8));
    this.cfT = (Button)this.oR.findViewById(2131296570);
    this.cfW = (Button)this.oR.findViewById(2131296590);
  }
  
  protected void initialData() { this.cgB = 0.0D; }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      this.cfT.performClick();
      return false;
    } 
    switch (paramInt) {
      default:
        return false;
      case 67:
        this.cfV.performClick();
        return false;
      case 66:
        break;
    } 
    this.cfW.performClick();
    return false;
  }
  
  protected void onStart() {
    super.onStart();
    this.cgz.setText("0");
    this.cgz.requestFocus();
    this.cgz.selectAll();
  }
  
  protected void onStop() { super.onStop(); }
  
  protected void xU() {
    super.xU();
    f(this.cgz);
    l.a(getWindow(), this.cgz);
    this.cfW.setOnClickListener(new bh(this));
    this.cfT.setOnClickListener(new bi(this));
    eP(true);
    this.cgz.setOnKeyListener(new bj(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */