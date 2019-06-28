package com.laiqian.login.view;

import android.view.View;

class a implements View.OnClickListener {
  a(AgreementActivity paramAgreementActivity) {}
  
  public void onClick(View paramView) {
    if (!AgreementActivity.a(this.aYX).isSelected()) {
      AgreementActivity.a(this.aYX).setSelected(true);
      AgreementActivity.b(this.aYX).setSelected(true);
      return;
    } 
    AgreementActivity.a(this.aYX).setSelected(false);
    AgreementActivity.b(this.aYX).setSelected(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */