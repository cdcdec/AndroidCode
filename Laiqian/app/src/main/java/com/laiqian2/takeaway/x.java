package com.laiqian.takeaway;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

class x implements DatePickerDialog.OnDateSetListener {
  x(w paramw) {}
  
  private void aqs() {
    al.c c = w.d(this.drS);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(w.a(this.drS));
    stringBuilder.append("/");
    stringBuilder.append(w.b(this.drS) + 1);
    stringBuilder.append("/");
    stringBuilder.append(w.c(this.drS));
    c.oy(stringBuilder.toString());
  }
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
    w.a(this.drS, paramInt1);
    w.b(this.drS, paramInt2);
    w.c(this.drS, paramInt3);
    aqs();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */