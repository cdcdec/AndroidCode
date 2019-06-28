package com.laiqian;

import android.app.Activity;
import android.os.Handler;
import android.widget.Button;
import com.laiqian.payment.R;
import com.laiqian.ui.a.d;

public class k extends d {
  private Activity azD;
  
  Button azE;
  
  Button azF;
  
  private Handler handler;
  
  public k(Activity paramActivity, Handler paramHandler) {
    super(paramActivity, R.layout.onlinepay_confirm_dialog);
    this.azD = paramActivity;
    this.handler = paramHandler;
    wR();
    setListeners();
  }
  
  private void setListeners() {
    this.azF.setOnClickListener(new l(this));
    this.azE.setOnClickListener(new m(this));
  }
  
  private void wR() {
    this.azF = (Button)this.mView.findViewById(R.id.btn_cancel);
    this.azE = (Button)this.mView.findViewById(R.id.btn_confirm);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */