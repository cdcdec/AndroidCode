package com.laiqian.scanorder.settings;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.scan_order_module.R;

class bc extends Handler {
  bc(TableCodeExportFragment paramTableCodeExportFragment) {}
  
  public void handleMessage(Message paramMessage) {
    if (Boolean.parseBoolean(String.valueOf(paramMessage.obj))) {
      Toast.makeText(TableCodeExportFragment.h(this.djJ), R.string.pos_export_success, 0).show();
      this.djJ.cjN.dismiss();
    } else {
      Toast.makeText(TableCodeExportFragment.h(this.djJ), R.string.pos_export_fail, 0).show();
    } 
    TableCodeExportFragment.i(this.djJ).setVisibility(8);
    TableCodeExportFragment.j(this.djJ).setVisibility(0);
    TableCodeExportFragment.g(this.djJ).setClickable(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */