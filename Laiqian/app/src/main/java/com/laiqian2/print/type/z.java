package com.laiqian.print.type;

import android.view.View;
import com.laiqian.print.model.type.c.c;
import com.laiqian.ui.a.w;
import me.raid.libserialport.serialport.SerialPortFinder;

class z implements View.OnClickListener {
  z(PrinterEditActivity paramPrinterEditActivity, c paramc, PrinterEditActivity.a.c paramc1) {}
  
  public void onClick(View paramView) {
    SerialPortFinder serialPortFinder = new SerialPortFinder();
    String[] arrayOfString1 = serialPortFinder.getAllDevices();
    String[] arrayOfString2 = serialPortFinder.getAllDevicesPath();
    (new w(this.cKo.getActivity(), arrayOfString1, new aa(this, arrayOfString2, arrayOfString1))).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */