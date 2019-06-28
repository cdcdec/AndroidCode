package com.laiqian.print.cardreader;

import android.widget.TextView;

class n implements Runnable {
  n(CardReaderEditActivity paramCardReaderEditActivity, boolean paramBoolean) {}
  
  public void run() {
    if (this.cEr) {
      ((TextView)(CardReaderEditActivity.f(this.cEp)).cMe.cAP.getView()).setText(2131628883);
      ((TextView)(CardReaderEditActivity.f(this.cEp)).cMe.cAP.getView()).setActivated(true);
      return;
    } 
    ((TextView)(CardReaderEditActivity.f(this.cEp)).cMe.cAP.getView()).setActivated(false);
    ((TextView)(CardReaderEditActivity.f(this.cEp)).cMe.cAP.getView()).setText(this.cEp.getString(2131628888));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */