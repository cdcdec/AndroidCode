package com.laiqian.member.create;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

class x implements DatePickerDialog.OnDateSetListener {
  x(w paramw) {}
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
    TextView textView = this.bxB.bxz.bvB;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2 + 1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt3);
    textView.setText(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */