package com.laiqian.print.type;

import android.view.View;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;

class ad implements View.OnClickListener {
  ad(PrinterEditActivity paramPrinterEditActivity, s params, PrinterEditActivity.a.c paramc) {}
  
  public void onClick(View paramView) {
    e e = g.cGS.f(this.cHh).a((PrintContent)null);
    e.a(new ae(this));
    g.cGS.c(e);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */