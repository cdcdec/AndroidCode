package com.laiqian.login.view;

import android.view.View;

class k implements View.OnClickListener {
  k(j paramj) {}
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    this.aZG.aZD.aZg.aZI.setText((CharSequence)this.aZG.getItem(i));
    this.aZG.aZD.aZg.aZK.requestFocus();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */