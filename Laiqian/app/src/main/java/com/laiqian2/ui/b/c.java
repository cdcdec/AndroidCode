package com.laiqian.ui.b;

import android.os.Vibrator;
import android.text.Editable;
import android.view.View;

class c implements View.OnLongClickListener {
  c(a parama) {}
  
  public boolean onLongClick(View paramView) {
    Editable editable = a.b(this.dDv).getText();
    int i = a.b(this.dDv).getSelectionStart();
    if (editable != null && editable.length() > 0 && i > 0) {
      Vibrator vibrator = (Vibrator)a.c(this.dDv).getSystemService("vibrator");
      vibrator.vibrate(30L);
      editable.delete(0, i);
      vibrator.cancel();
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */