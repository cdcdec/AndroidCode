package com.laiqian.pos.settings;

import android.widget.Toast;
import com.laiqian.pos.hardware.q;
import com.laiqian.ui.a.r;
import com.laiqian.util.aq;

class ce implements r.a {
  ce(ShopInfoActivity paramShopInfoActivity) {}
  
  public void xD() {}
  
  public void xE() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(q.cll);
    stringBuilder.append(this.cBl.chv);
    if (aq.qz(stringBuilder.toString())) {
      Toast.makeText(this.cBl.getActivity(), this.cBl.getString(2131630485), 0).show();
      this.cBl.chY = false;
      this.cBl.chZ = "";
      this.cBl.cAo.jZ(this.cBl.chZ);
      ShopInfoActivity.a(this.cBl, this.cBl.chZ, this.cBl.chY);
      return;
    } 
    Toast.makeText(this.cBl.getActivity(), this.cBl.getString(2131630484), 0).show();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */