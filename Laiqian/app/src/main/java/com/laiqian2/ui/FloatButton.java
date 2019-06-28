package com.laiqian.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.c.a.g;

public class FloatButton extends Button {
  float hidePosition;
  
  public boolean isShow = false;
  
  float showPosition;
  
  public FloatButton(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setAttributes();
  }
  
  public void hide() {
    if (getVisibility() == 0) {
      g g = g.a(this, "y", new float[] { this.hidePosition });
      g.dL(500L);
      g.start();
      this.isShow = false;
    } 
  }
  
  public boolean isShow() { return this.isShow; }
  
  public void setAttributes() { postDelayed(new g(this), 100L); }
  
  public void show() {
    if (getVisibility() == 0) {
      g g = g.a(this, "y", new float[] { this.showPosition });
      g.dL(500L);
      g.start();
      this.isShow = true;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\FloatButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */