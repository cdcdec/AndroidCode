package com.laiqian.print.printtype;

import android.view.View;

class n implements View.OnClickListener {
  n(PrintTypeSelectionsActivity paramPrintTypeSelectionsActivity, j paramj, PrintTypeSelectionsActivity.b paramb) {}
  
  public void onClick(View paramView) {
    if (this.cJv.cCC > 0)
      PrintTypeSelectionsActivity.a(this.cJu, this.cJw, new j(this.cJv.cJr, this.cJv.cCC - 1)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\printtype\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */