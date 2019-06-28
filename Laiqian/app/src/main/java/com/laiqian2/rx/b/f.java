package com.laiqian.rx.b;

import android.widget.EditText;
import io.reactivex.c.g;

final class f extends Object implements g<CharSequence> {
  f(EditText paramEditText) {}
  
  public void n(CharSequence paramCharSequence) {
    int i = this.dhT.getSelectionStart();
    this.dhT.setText(paramCharSequence);
    this.dhT.setSelection(Math.min(i, paramCharSequence.length()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\rx\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */