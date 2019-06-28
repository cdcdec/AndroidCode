package com.laiqian.print.type;

import android.content.Intent;
import android.view.View;
import com.laiqian.print.model.type.b.c;
import com.laiqian.print.model.type.usb.g;
import com.laiqian.print.type.net.NetPrinterDiagnoseActivity;
import com.laiqian.print.type.usb.UsbPrinterDiagnoseActivity;

class ah implements View.OnClickListener {
  ah(PrinterEditActivity paramPrinterEditActivity) {}
  
  public void onClick(View paramView) {
    switch (PrinterEditActivity.f(this.cKo).aew().getType()) {
      default:
        return;
      case 2:
        NetPrinterDiagnoseActivity.start(this.cKo.getActivity(), ((c)PrinterEditActivity.f(this.cKo).aew()).getAddress());
        return;
      case 1:
        break;
    } 
    g g = (g)PrinterEditActivity.f(this.cKo).aew();
    Intent intent = UsbPrinterDiagnoseActivity.b(this.cKo.getActivity(), g.getVendorId(), g.getProductId());
    this.cKo.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */