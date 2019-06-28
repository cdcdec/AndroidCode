package com.laiqian.print.type.usb.a;

import com.laiqian.infrastructure.R;
import com.laiqian.print.model.e;

class f implements e.a {
  f(e parame) {}
  
  public void a(e parame, int paramInt) {
    if (parame.agu()) {
      if (parame.getStatus() == 4) {
        e.a(this.cMi, e.a(this.cMi).getString(R.string.diagnose_state_pass));
        e.b(this.cMi);
        return;
      } 
      e e1 = this.cMi;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e.a(this.cMi).getString(R.string.diagnose_usb_printer_transmit_failed));
      stringBuilder.append(parame.agw());
      e.b(e1, stringBuilder.toString());
      e.c(this.cMi);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\usb\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */