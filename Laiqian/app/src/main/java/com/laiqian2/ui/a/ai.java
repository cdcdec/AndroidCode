package com.laiqian.ui.a;

import android.view.KeyEvent;
import android.widget.TextView;

class ai implements TextView.OnEditorActionListener {
  ai(af paramaf) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent != null && paramKeyEvent.getAction() == 1 && paramKeyEvent.getKeyCode() == 66)
      af.a(this.dAo); 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */