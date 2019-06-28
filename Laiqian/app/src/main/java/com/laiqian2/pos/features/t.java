package com.laiqian.pos.features;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.n;

class t implements w.a {
  t(ScanOrderExportFragment paramScanOrderExportFragment, int paramInt1, int paramInt2) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        ScanOrderExportFragment.c(this.cjQ, this.cjR, this.cjS);
        return;
      case 0:
        break;
    } 
    FragmentActivity fragmentActivity = this.cjQ.getActivity();
    paramInt = 1;
    if (n.a(fragmentActivity, true).size() == 0)
      paramInt = 0; 
    if (paramInt == 0) {
      Toast.makeText(this.cjQ.getActivity(), this.cjQ.getString(2131624384), 0).show();
      return;
    } 
    ScanOrderExportFragment.b(this.cjQ, this.cjR, this.cjS);
    this.cjQ.cjN.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */