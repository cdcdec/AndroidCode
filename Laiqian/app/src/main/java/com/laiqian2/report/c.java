package com.laiqian.report;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;

class c implements DatePickerDialog.OnDateSetListener {
  c(FilterActivity paramFilterActivity) {}
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
    if (this.cYP.bLa) {
      this.cYP.bLb = paramInt1;
      this.cYP.bLc = paramInt2;
      this.cYP.bLd = paramInt3;
      this.cYP.calendar.set(this.cYP.bLb, this.cYP.bLc, this.cYP.bLd, 0, 0, 0);
      long l = this.cYP.calendar.getTimeInMillis();
      if (l > this.cYP.bLk) {
        Toast.makeText(this.cYP, this.cYP.getString(2131627989), 0).show();
        return;
      } 
      this.cYP.bLj = l;
      this.cYP.cYw.setText(String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3) }));
    } else {
      this.cYP.bLe = paramInt1;
      this.cYP.bLf = paramInt2;
      this.cYP.bLg = paramInt3;
      this.cYP.calendar.set(this.cYP.bLe, this.cYP.bLf, this.cYP.bLg, 23, 59, 59);
      long l = this.cYP.calendar.getTimeInMillis();
      if (l < this.cYP.bLj) {
        Toast.makeText(this.cYP, this.cYP.getString(2131627989), 0).show();
        return;
      } 
      this.cYP.bLk = l;
      this.cYP.cYx.setText(String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3) }));
    } 
    this.cYP.bLo.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */