package com.laiqian.login.view;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import com.laiqian.ui.ImageCheckBox;

class p implements ImageCheckBox.a {
  p(LoginActivity paramLoginActivity) {}
  
  public void a(ImageCheckBox paramImageCheckBox, boolean paramBoolean) {
    if (paramBoolean) {
      this.aZD.aZg.aZK.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    } else {
      this.aZD.aZg.aZK.setTransformationMethod(PasswordTransformationMethod.getInstance());
    } 
    this.aZD.aZg.aZK.setSelection(this.aZD.aZg.aZK.getText().length());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */