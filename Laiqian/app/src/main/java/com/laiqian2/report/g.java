package com.laiqian.report;

import android.text.format.DateFormat;
import android.view.View;
import java.util.Calendar;

class g implements View.OnClickListener {
  g(FilterActivity20150320 paramFilterActivity20150320) {}
  
  public void onClick(View paramView) {
    FilterActivity20150320.ami();
    this.cYY.calendar = Calendar.getInstance();
    FilterActivity20150320.bLk = System.currentTimeMillis();
    FilterActivity20150320.bLj = FilterActivity20150320.bLk - 2592000000L;
    this.cYY.cYw.setText((String)DateFormat.format(this.cYY.getString(2131627408), FilterActivity20150320.bLj));
    this.cYY.cYx.setText((String)DateFormat.format(this.cYY.getString(2131627408), FilterActivity20150320.bLk));
    this.cYY.cYy.setText("");
    this.cYY.cYR.setText("");
    this.cYY.cYR.clearFocus();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */