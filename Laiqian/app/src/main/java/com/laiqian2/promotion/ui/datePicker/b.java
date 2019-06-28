package com.laiqian.promotion.ui.datePicker;

import android.text.Editable;
import android.text.TextWatcher;
import com.laiqian.util.n;

class b implements TextWatcher {
  b(a parama) {}
  
  public void afterTextChanged(Editable paramEditable) {
    int i = n.parseInt(paramEditable.toString().trim());
    if (i > 0 && i < 32)
      a.a(this.cXj, i, '1'); 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\datePicker\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */