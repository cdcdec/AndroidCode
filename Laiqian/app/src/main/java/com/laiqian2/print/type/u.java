package com.laiqian.print.type;

import android.content.Intent;
import android.view.View;
import com.laiqian.print.bm;
import com.laiqian.print.usage.e;

class u implements View.OnClickListener {
  u(PrinterEditActivity paramPrinterEditActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = KitchenPrintRangeActivity.a(this.cKo.getActivity(), ((e.d)PrinterEditActivity.f(this.cKo).a(bm.cEg)).aep());
    this.cKo.startActivityForResult(intent, 3);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */