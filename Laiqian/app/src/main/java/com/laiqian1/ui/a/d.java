package com.laiqian.ui.a;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.util.n;

public abstract class d extends f {
  private a afterShowDialog;
  
  @Deprecated
  protected Context mActivity;
  
  protected View mView;
  
  @Deprecated
  protected TextView tvTitle;
  
  public d(Context paramContext, int paramInt) {
    super(paramContext, R.style.pos_product_dialog);
    this.mActivity = paramContext;
    this.mView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    setContentView(this.mView, new ViewGroup.LayoutParams(-1, -1));
    setCanceledOnTouchOutside(true);
  }
  
  public d(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext, paramInt2);
    this.mActivity = paramContext;
    this.mView = View.inflate(paramContext, paramInt1, null);
    setContentView(this.mView, new ViewGroup.LayoutParams(-1, -1));
    setCanceledOnTouchOutside(true);
  }
  
  public void addRunnableAfterShowDialog(Runnable paramRunnable) {
    if (isShowing()) {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        paramRunnable.run();
        return;
      } 
      RootApplication.runOnUiThread(paramRunnable);
      return;
    } 
    if (this.afterShowDialog == null) {
      this.afterShowDialog = new a(this, paramRunnable, null);
      this.afterShowDialog.start();
      return;
    } 
    a.a(this.afterShowDialog, paramRunnable);
  }
  
  public void dismiss() {
    n.a(this.mActivity, getCurrentFocus());
    super.dismiss();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.tvTitle == null)
      return super.onTouchEvent(paramMotionEvent); 
    try {
      boolean bool = ((Boolean)getWindow().getClass().getMethod("shouldCloseOnTouch", new Class[] { Context.class, MotionEvent.class }).invoke(getWindow(), new Object[] { this.mActivity, paramMotionEvent })).booleanValue();
      if (bool) {
        this.tvTitle.requestFocus();
        n.a(this.mActivity, getCurrentFocus());
      } 
      return bool;
    } catch (Exception exception) {
      a.e(exception);
      return super.onTouchEvent(paramMotionEvent);
    } 
  }
  
  protected void setPositionTop() {
    getWindow().setGravity(48);
    getWindow().setWindowAnimations(R.style.dialog_top);
    (getWindow().getAttributes()).width = -1;
  }
  
  public void show() {
    super.show();
    if (this.afterShowDialog != null)
      a.a(this.afterShowDialog); 
  }
  
  class d {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\ui\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */