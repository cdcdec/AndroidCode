package com.laiqian.report;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;

class i implements DatePickerDialog.OnDateSetListener {
  i(FilterActivity20150320 paramFilterActivity20150320) {}
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
    if (this.cYY.bLa) {
      this.cYY.bLb = paramInt1;
      this.cYY.bLc = paramInt2;
      this.cYY.bLd = paramInt3;
      this.cYY.calendar.set(this.cYY.bLb, this.cYY.bLc, this.cYY.bLd, 0, 0, 0);
      long l = this.cYY.calendar.getTimeInMillis();
      if (l > FilterActivity20150320.bLk) {
        Toast.makeText(this.cYY, this.cYY.getString(2131627989), 0).show();
        this.cYY.removeDialog(2);
        return;
      } 
      FilterActivity20150320.bLj = l;
      this.cYY.cYw.setText(String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3) }));
      this.cYY.removeDialog(2);
    } else {
      this.cYY.bLe = paramInt1;
      this.cYY.bLf = paramInt2;
      this.cYY.bLg = paramInt3;
      this.cYY.calendar.set(this.cYY.bLe, this.cYY.bLf, this.cYY.bLg, 23, 59, 59);
      long l = this.cYY.calendar.getTimeInMillis();
      if (l < FilterActivity20150320.bLj) {
        Toast.makeText(this.cYY, this.cYY.getString(2131627989), 0).show();
        this.cYY.removeDialog(3);
        return;
      } 
      FilterActivity20150320.bLk = l;
      this.cYY.cYx.setText(String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3) }));
      this.cYY.removeDialog(3);
    } 
    this.cYY.bLo.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */