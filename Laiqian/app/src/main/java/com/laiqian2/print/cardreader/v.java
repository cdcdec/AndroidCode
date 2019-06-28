package com.laiqian.print.cardreader;

import android.view.View;

class v implements View.OnClickListener {
  v(CardReaderSearchActivity paramCardReaderSearchActivity) {}
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag(2131297320)).intValue();
    if (i == 0) {
      CardReaderSearchActivity.b(this.cEE);
      return;
    } 
    CardReaderSearchActivity.c(this.cEE, i - 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */