package com.laiqian.ui.a;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

class aw implements TextView.OnEditorActionListener {
  aw(at paramat) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent != null && paramKeyEvent.getAction() == 1 && paramKeyEvent.getKeyCode() == 66) {
      if (TextUtils.isEmpty(at.a(this.dAH).getText().toString())) {
        Toast.makeText(at.b(this.dAH), "优惠码不能为空", 0).show();
        return true;
      } 
      if (at.c(this.dAH).b(paramTextView, at.a(this.dAH).getText().toString()))
        this.dAH.dismiss(); 
    } 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */