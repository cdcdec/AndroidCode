package com.laiqian.print.cardreader;

import android.widget.Button;
import android.widget.Toast;

class f implements Runnable {
  f(CardReaderEditActivity paramCardReaderEditActivity) {}
  
  public void run() {
    if (CardReaderEditActivity.a(this.cEp).getMode() == 2) {
      ((Button)(CardReaderEditActivity.f(this.cEp)).cMh.dwK.cNc.getView()).setEnabled(true);
    } else {
      ((Button)(CardReaderEditActivity.f(this.cEp)).cMh.dwL.dwN.getView()).setEnabled(true);
    } 
    Toast.makeText(this.cEp, this.cEp.getString(2131624589), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */