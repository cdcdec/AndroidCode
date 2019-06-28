package com.laiqian.login.view;

import android.content.Intent;
import android.view.View;

class b implements View.OnClickListener {
  b(AgreementActivity paramAgreementActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.aYX, LoginActivity.class);
    this.aYX.startActivity(intent);
    this.aYX.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */