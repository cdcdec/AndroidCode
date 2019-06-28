package com.laiqian.rx.b;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import io.reactivex.h.a;

final class g implements TextWatcher {
  g(a parama) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = paramEditable.toString();
    if (this.bok != null && !TextUtils.isEmpty(str)) {
      a a1 = this.bok;
      String str1 = str;
      if (str.contains(","))
        str1 = str.replace(",", ""); 
      a1.am(str1);
    } 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\rx\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */