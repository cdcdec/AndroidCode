package com.laiqian.takeaway.miniprograms;

import android.widget.Toast;
import com.laiqian.takeaway.R;

class m implements Runnable {
  m(WechatMiniProgramsActivity.b paramb, boolean paramBoolean) {}
  
  public void run() {
    if (this.dut.duf.getActivity() == null)
      return; 
    if (this.cuF) {
      Toast.makeText(this.dut.duf.getActivity(), this.dut.duf.getString(R.string.pos_export_success), 0).show();
      this.dut.duf.cjN.dismiss();
      return;
    } 
    Toast.makeText(this.dut.duf.getActivity(), this.dut.duf.getString(R.string.pos_export_fail), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */