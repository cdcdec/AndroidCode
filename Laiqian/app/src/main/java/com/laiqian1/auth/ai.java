package com.laiqian.auth;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.a.a.a.a.a.a;

class ai implements TextWatcher {
  ai(PrivilegeLimitActivity paramPrivilegeLimitActivity, EditText paramEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {
    EditText editText = (EditText)PrivilegeLimitActivity.h(this.aEm).findViewById(2131296928);
    str = this.aEn.getText().toString();
    if ("".equals(str))
      return; 
    if (PrivilegeLimitActivity.j(this.aEm) == 1) {
      try {
        double d = Double.parseDouble(str);
        String str1 = PrivilegeLimitActivity.a(this.aEm, Double.valueOf(d).doubleValue(), (short)0);
        Double double = Double.valueOf(Double.parseDouble(str));
        if (double.doubleValue() > 100.0D || double.doubleValue() < 0.0D) {
          editText.setText(PrivilegeLimitActivity.a(this.aEm, 100.0D, (short)1));
          editText.setSelection(3);
          return;
        } 
        if (str1.length() < str.length()) {
          editText.setText(str1);
          editText.setSelection(str1.length());
          return;
        } 
      } catch (Exception str) {
        a.e(str);
        editText.setText(PrivilegeLimitActivity.a(this.aEm, 100.0D, (short)1));
        editText.setSelection(3);
        return;
      } 
    } else {
      try {
        Double double = Double.valueOf(Double.parseDouble(str));
        String str1 = PrivilegeLimitActivity.a(this.aEm, double.doubleValue(), (short)0);
        if (double.doubleValue() < 0.0D) {
          editText.setText(PrivilegeLimitActivity.a(this.aEm, 0.0D, (short)0));
          editText.setSelection(1);
          return;
        } 
        if (str1.length() < str.length()) {
          editText.setText(str1);
          editText.setSelection(str1.length());
          return;
        } 
      } catch (Exception str) {
        a.e(str);
        editText.setText(PrivilegeLimitActivity.a(this.aEm, 0.0D, (short)0));
        editText.setSelection(1);
      } 
    } 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */