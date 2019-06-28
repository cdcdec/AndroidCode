package com.laiqian.report.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.laiqian.report.models.o;
import com.laiqian.util.n;

class w implements TextWatcher {
  w(OrderDetailsByReturn.a parama, OrderDetailsByReturn paramOrderDetailsByReturn) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (OrderDetailsByReturn.a.a(this.deR) && paramEditable.length() > 0) {
      o.a a1 = (o.a)this.deR.bbT.get(0);
      double d = n.u(paramEditable);
      if (d > a1.bTj) {
        this.deR.deG.setText(String.valueOf(a1.bTj));
        n.j(this.deR.deG);
        return;
      } 
      this.deR.deh.setText(n.pi(a1.aT(d)));
    } 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */