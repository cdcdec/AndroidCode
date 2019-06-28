package com.laiqian.milestone;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;

class o implements DatePickerDialog.OnDateSetListener {
  o(orderQuery paramorderQuery) {}
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {
    if (orderQuery.g(this.bLq)) {
      orderQuery.a(this.bLq, paramInt1);
      orderQuery.b(this.bLq, paramInt2);
      orderQuery.c(this.bLq, paramInt3);
      orderQuery.k(this.bLq).set(orderQuery.h(this.bLq), orderQuery.i(this.bLq), orderQuery.j(this.bLq), 0, 0, 0);
      long l = orderQuery.k(this.bLq).getTimeInMillis();
      if (l > orderQuery.Ue()) {
        Toast.makeText(this.bLq, this.bLq.getString(2131627989), 0).show();
        return;
      } 
      orderQuery.bb(l);
      orderQuery.l(this.bLq).setText(String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3) }));
    } else {
      orderQuery.d(this.bLq, paramInt1);
      orderQuery.e(this.bLq, paramInt2);
      orderQuery.f(this.bLq, paramInt3);
      orderQuery.k(this.bLq).set(orderQuery.m(this.bLq), orderQuery.n(this.bLq), orderQuery.o(this.bLq), 23, 59, 59);
      long l = orderQuery.k(this.bLq).getTimeInMillis();
      if (l < orderQuery.Ud()) {
        Toast.makeText(this.bLq, this.bLq.getString(2131627989), 0).show();
        return;
      } 
      orderQuery.bc(l);
      orderQuery.p(this.bLq).setText(String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3) }));
    } 
    this.bLq.bLo.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */