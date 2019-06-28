package com.laiqian.auth;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.ui.a.aq;

class aq extends Object implements aq.a<String> {
  aq(PrivilegeLimitActivity paramPrivilegeLimitActivity) {}
  
  public void a(aq paramaq, int paramInt, String paramString) {
    boolean bool = paramString.equals(this.aEm.getString(2131627449));
    int i = 1;
    if (bool) {
      ((TextView)PrivilegeLimitActivity.h(this.aEm).findViewById(2131299215)).setText(this.aEm.getString(2131627451));
      PrivilegeLimitActivity.h(this.aEm).findViewById(2131298400).setVisibility(8);
      ((EditText)PrivilegeLimitActivity.h(this.aEm).findViewById(2131296928)).setText(PrivilegeLimitActivity.a(this.aEm, 0.0D, (short)0));
      i = 0;
    } else {
      ((TextView)PrivilegeLimitActivity.h(this.aEm).findViewById(2131299215)).setText(this.aEm.getString(2131627450));
      PrivilegeLimitActivity.h(this.aEm).findViewById(2131298400).setVisibility(0);
      ((EditText)PrivilegeLimitActivity.h(this.aEm).findViewById(2131296928)).setText(PrivilegeLimitActivity.a(this.aEm, 100.0D, (short)1));
    } 
    ((Button)PrivilegeLimitActivity.g(this.aEm).findViewById(2131299826)).setText(PrivilegeLimitActivity.a(this.aEm, i));
    PrivilegeLimitActivity.h(this.aEm).findViewById(2131296928).clearFocus();
    this.aEm.aEl.kR(paramInt);
    this.aEm.aEl.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */