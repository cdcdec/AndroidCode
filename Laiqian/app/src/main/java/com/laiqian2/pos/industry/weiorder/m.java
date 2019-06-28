package com.laiqian.pos.industry.weiorder;

import com.laiqian.notification.PushService;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.av;

class m implements w.a {
  m(l paraml) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (!QRCodeSetting.c(this.csJ.csI).getText().toString().trim().equals(QRCodeSetting.b(this.csJ.csI)[paramInt])) {
      QRCodeSetting.c(this.csJ.csI).setText(QRCodeSetting.b(this.csJ.csI)[paramInt]);
      av av = new av(this.csJ.csI.getActivity());
      av.dv(QRCodeSetting.d(this.csJ.csI)[paramInt]);
      av.close();
      QRCodeSetting.a(this.csJ.csI).gn(paramInt);
      PushService.r(this.csJ.csI.getActivity(), 5);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */