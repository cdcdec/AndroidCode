package com.laiqian.pos.industry.weiorder;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.pos.hardware.q;
import com.laiqian.util.aq;

class fg extends Handler {
  fg(WeshopInfoFragment paramWeshopInfoFragment) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 1) {
        Toast.makeText(this.cwf.getActivity(), this.cwf.getString(2131630490), 0).show();
        this.cwf.cvZ.cwl.setVisibility(8);
        this.cwf.cvZ.cwk.setVisibility(8);
        this.cwf.cvZ.cwm.setVisibility(0);
      } else if (this.cwf.cwb != null) {
        this.cwf.cvZ.cwl.setVisibility(8);
        this.cwf.cvZ.cwk.setVisibility(0);
        this.cwf.cvZ.cwm.setVisibility(8);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(q.cll);
        stringBuilder1.append(this.cwf.chv);
        aq.qz(stringBuilder1.toString());
        WeshopInfoFragment weshopInfoFragment = this.cwf;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(q.cll);
        stringBuilder2.append(this.cwf.chv);
        weshopInfoFragment.chZ = stringBuilder2.toString();
        this.cwf.chY = true;
        this.cwf.cvS.jZ(this.cwf.chZ);
        WeshopInfoFragment.a(this.cwf, this.cwf.chZ, this.cwf.chY);
      } else {
        this.cwf.cvZ.cwl.setVisibility(8);
        this.cwf.cvZ.cwk.setVisibility(8);
        this.cwf.cvZ.cwm.setVisibility(0);
      } 
    } else {
      this.cwf.cvS.Jx();
      this.cwf.cvZ.cwl.setVisibility(8);
      this.cwf.cvZ.cwm.setVisibility(0);
      this.cwf.cvZ.cwk.setVisibility(8);
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */