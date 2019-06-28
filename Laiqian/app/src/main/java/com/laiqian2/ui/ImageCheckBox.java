package com.laiqian.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

public class ImageCheckBox extends View implements Checkable {
  private boolean dvZ = false;
  
  private boolean dwa;
  
  private a dwb;
  
  public ImageCheckBox(Context paramContext) { super(paramContext, null); }
  
  public ImageCheckBox(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public void a(a parama) { this.dwb = parama; }
  
  public void hb(boolean paramBoolean) { this.dwa = paramBoolean; }
  
  public boolean isChecked() { return isSelected(); }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) { return (this.dwa == true) ? false : super.onTouchEvent(paramMotionEvent); }
  
  public boolean performClick() {
    toggle();
    return super.performClick();
  }
  
  public void setChecked(boolean paramBoolean) {
    if (isSelected() != paramBoolean) {
      setSelected(paramBoolean);
      if (this.dwb != null && !this.dvZ)
        this.dwb.a(this, paramBoolean); 
    } 
  }
  
  public void toggle() { setChecked(isChecked() ^ true); }
  
  public static interface a {
    void a(ImageCheckBox param1ImageCheckBox, boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\ImageCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */