package com.laiqian.LockScreen;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.laiqian.util.av;

class j implements TextWatcher {
  j(LockScreenService paramLockScreenService) {}
  
  public void afterTextChanged(Editable paramEditable) {
    av av;
    String str = this.aAp.azW.getText().toString().trim();
    switch (str.length()) {
      default:
        return;
      case 4:
        av = new av(this.aAp);
        this.aAp.azZ.setText("    *         *         *        *");
        if (str.equals(av.atL())) {
          this.aAp.stopSelf();
          Toast.makeText(this.aAp, this.aAp.getString(2131625520), 0).show();
        } else {
          Toast.makeText(this.aAp, this.aAp.getString(2131625519), 0).show();
          this.aAp.azW.setText("");
        } 
        av.close();
        return;
      case 3:
        this.aAp.azZ.setText("    *         *         *         ");
        return;
      case 2:
        this.aAp.azZ.setText("    *         *                   ");
        return;
      case 1:
        this.aAp.azZ.setText("    *                             ");
        return;
      case 0:
        break;
    } 
    this.aAp.azZ.setText("");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */