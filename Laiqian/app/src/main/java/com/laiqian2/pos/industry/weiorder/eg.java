package com.laiqian.pos.industry.weiorder;

import android.widget.Toast;

class eg implements Runnable {
  eg(WeshopBindingFragment.b paramb, boolean paramBoolean) {}
  
  public void run() {
    if (this.cvB.cvz.getActivity() == null)
      return; 
    if (this.cuF) {
      Toast.makeText(this.cvB.cvz.getActivity(), this.cvB.cvz.getString(2131626752), 0).show();
      this.cvB.cvz.cjN.dismiss();
      return;
    } 
    Toast.makeText(this.cvB.cvz.getActivity(), this.cvB.cvz.getString(2131626749), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */