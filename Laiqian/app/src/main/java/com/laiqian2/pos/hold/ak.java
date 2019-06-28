package com.laiqian.pos.hold;

import android.text.Editable;
import android.text.TextWatcher;

class ak implements TextWatcher {
  ak(ai paramai) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = (ai.b(this.cpW)).cpZ.getText().toString().trim();
    boolean bool1 = this.cpW.cpJ.equals(str);
    this.cpW.cpJ = str;
    if (this.cpW.cpJ.length() == 0) {
      (ai.b(this.cpW)).cqa.setVisibility(8);
    } else {
      (ai.b(this.cpW)).cqa.setVisibility(0);
    } 
    if (!bool1 || ai.q(this.cpW)) {
      ai.c(this.cpW, false);
      ai.b(this.cpW, 1);
      this.cpW.cpI.clear();
      bool1 = false;
    } else {
      bool1 = ai.d(this.cpW, false);
    } 
    boolean bool2 = this.cpW.aaJ();
    if (bool1 && bool2)
      ai.r(this.cpW); 
    if (this.cpW.cpI.size() != 0) {
      if (ai.s(this.cpW)) {
        ai.a(this.cpW, 0);
        ai.a(this.cpW, null);
      } 
      ai.a(this.cpW, this.cpW.cpI);
    } 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    ai.b(this.cpW, paramCharSequence.toString().trim());
    if (paramInt1 != paramInt2 || paramInt3 > 0) {
      ai.b(this.cpW, true);
      return;
    } 
    ai.b(this.cpW, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */