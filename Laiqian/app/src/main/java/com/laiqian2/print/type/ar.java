package com.laiqian.print.type;

import android.content.Intent;
import android.view.View;
import com.laiqian.print.printtype.PrintTypeSelectionsActivity;

class ar implements View.OnClickListener {
  ar(PrinterEditActivity paramPrinterEditActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = PrintTypeSelectionsActivity.a(this.cKo.getActivity(), PrinterEditActivity.f(this.cKo).aey());
    this.cKo.startActivityForResult(intent, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */