package com.laiqian.main.module.settlement;

import android.app.Dialog;
import android.widget.EditText;
import android.widget.TextView;
import io.reactivex.c.g;

final class b extends Object implements g<String> {
  b(Dialog paramDialog, EditText paramEditText, TextView paramTextView) {}
  
  public void eJ(String paramString) throws Exception {
    if (this.blJ != null && this.blJ.getCurrentFocus() == this.blK && paramString != null && this.blL != null)
      this.blL.setText(paramString); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */