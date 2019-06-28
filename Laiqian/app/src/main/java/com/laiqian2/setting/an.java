package com.laiqian.setting;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class an implements TextWatcher {
  an(SetMakeOrderNumRuleActivity paramSetMakeOrderNumRuleActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = SetMakeOrderNumRuleActivity.c(this.dlf).getText().toString().trim();
    TextView textView = SetMakeOrderNumRuleActivity.j(this.dlf);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("-");
    stringBuilder.append(str);
    textView.setText(stringBuilder.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */