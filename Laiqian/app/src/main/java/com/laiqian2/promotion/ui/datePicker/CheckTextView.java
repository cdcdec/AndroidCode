package com.laiqian.promotion.ui.datePicker;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.TextView;

public class CheckTextView extends TextView implements Checkable {
  private boolean mChecked = false;
  
  private a mOnCheckedChangeListener;
  
  public CheckTextView(Context paramContext) { super(paramContext); }
  
  public CheckTextView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public boolean isChecked() { return this.mChecked; }
  
  public boolean performClick() {
    toggle();
    return super.performClick();
  }
  
  public void setChecked(boolean paramBoolean) {
    if (this.mChecked != paramBoolean) {
      setSelected(this.mChecked ^ true);
      this.mChecked = paramBoolean;
      if (this.mOnCheckedChangeListener != null)
        this.mOnCheckedChangeListener.a(this, paramBoolean); 
    } 
  }
  
  public void setOnCheckedChangeListener(a parama) { this.mOnCheckedChangeListener = parama; }
  
  public void toggle() { setChecked(this.mChecked ^ true); }
  
  public static interface a {
    void a(CheckTextView param1CheckTextView, boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\datePicker\CheckTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */