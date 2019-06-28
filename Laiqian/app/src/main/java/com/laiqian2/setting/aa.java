package com.laiqian.setting;

import android.text.Editable;
import android.text.TextWatcher;

class aa implements TextWatcher {
  aa(OrderNoInput paramOrderNoInput) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = OrderNoInput.b(this.dkD).getText().toString().trim();
    if (OrderNoInput.a(this.dkD).equals("100001") || OrderNoInput.a(this.dkD).equals("100015") || OrderNoInput.a(this.dkD).equals("100002") || OrderNoInput.a(this.dkD).equals("100016") || OrderNoInput.a(this.dkD).equals("100021") || OrderNoInput.a(this.dkD).equals("100023")) {
      if (this.dkD.nB(str)) {
        OrderNoInput.d(this.dkD).setVisibility(0);
        OrderNoInput.d(this.dkD).setText(2131629462);
        return;
      } 
      OrderNoInput.d(this.dkD).setVisibility(8);
      return;
    } 
    if (OrderNoInput.a(this.dkD).equals("100017") || OrderNoInput.a(this.dkD).equals("100018")) {
      if (this.dkD.nC(str)) {
        OrderNoInput.d(this.dkD).setVisibility(0);
        OrderNoInput.d(this.dkD).setText(2131629462);
        return;
      } 
      OrderNoInput.d(this.dkD).setVisibility(8);
      return;
    } 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */