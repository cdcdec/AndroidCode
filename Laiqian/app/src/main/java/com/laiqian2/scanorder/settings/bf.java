package com.laiqian.scanorder.settings;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.n;

class bf implements w.a {
  bf(TableCodeExportFragment paramTableCodeExportFragment) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        TableCodeExportFragment.e(this.djJ);
        return;
      case 0:
        break;
    } 
    FragmentActivity fragmentActivity = this.djJ.getActivity();
    paramInt = 1;
    if (n.a(fragmentActivity, true).size() == 0)
      paramInt = 0; 
    if (paramInt == 0) {
      Toast.makeText(this.djJ.getActivity(), this.djJ.getString(R.string.backup_menu_no_usb), 0).show();
      return;
    } 
    TableCodeExportFragment.d(this.djJ);
    this.djJ.cjN.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */