package com.laiqian.main.module.productpool;

import android.text.Editable;
import android.text.TextWatcher;

class q implements TextWatcher {
  q(p paramp) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (p.a(this.bla).getText().length() == 0) {
      if (p.b(this.bla).getVisibility() == 0)
        p.b(this.bla).setVisibility(8); 
    } else if (p.b(this.bla).getVisibility() == 8) {
      p.b(this.bla).setVisibility(0);
    } 
    p.c(this.bla);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    if (paramCharSequence.toString().contains("\n")) {
      p.a(this.bla).setText(p.a(this.bla).getText().toString().trim());
      p.a(this.bla).selectAll();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productpool\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */