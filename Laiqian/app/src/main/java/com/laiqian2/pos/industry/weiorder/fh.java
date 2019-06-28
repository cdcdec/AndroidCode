package com.laiqian.pos.industry.weiorder;

import android.widget.Toast;
import com.laiqian.pos.hardware.q;
import com.laiqian.ui.a.r;
import com.laiqian.util.aq;

class fh implements r.a {
  fh(WeshopInfoFragment paramWeshopInfoFragment) {}
  
  public void xD() {}
  
  public void xE() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(q.cll);
    stringBuilder.append(this.cwf.chv);
    if (aq.qz(stringBuilder.toString())) {
      Toast.makeText(this.cwf.getActivity(), this.cwf.getString(2131630485), 0).show();
      this.cwf.chY = false;
      this.cwf.chZ = "";
      this.cwf.cvS.jZ(this.cwf.chZ);
      WeshopInfoFragment.a(this.cwf, this.cwf.chZ, this.cwf.chY);
      return;
    } 
    Toast.makeText(this.cwf.getActivity(), this.cwf.getString(2131630484), 0).show();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */