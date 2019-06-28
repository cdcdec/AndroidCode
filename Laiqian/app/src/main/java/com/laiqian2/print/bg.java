package com.laiqian.print;

import android.text.TextUtils;
import com.laiqian.print.model.d;
import com.laiqian.print.model.q;
import com.laiqian.print.model.type.b.c;
import com.laiqian.print.model.type.usb.d;
import com.laiqian.print.usage.g;
import com.laiqian.util.bd;

class bg implements d.a {
  bg(be parambe) {}
  
  public void aeV() {
    if (this.cDX.aeN())
      return; 
    be.d(this.cDX);
  }
  
  public void aeW() {
    if (this.cDX.aeN())
      return; 
    be.c(this.cDX).aek();
  }
  
  public void aeX() { be.c(this.cDX).aei(); }
  
  public void l(q paramq) {
    if (!be.a(this.cDX, paramq.agE())) {
      if (this.cDX.cDK != null && paramq.agF() == 0) {
        d d = this.cDX.cDK.lG(paramq.getIdentifier());
        if (d != null) {
          paramq.agE().setName(d.getName());
          if (d.getWidth() != 0)
            paramq.agE().setWidth(d.getWidth()); 
          if (d.getHeight() != 0)
            paramq.agE().setHeight(d.getHeight()); 
        } 
      } 
      if (paramq.getType() != 3 || TextUtils.isEmpty(paramq.agE().getName()))
        paramq.agE().setName(be.a(this.cDX).p(paramq.agE())); 
      ac ac = null;
      if (paramq.agF() == 1) {
        ac = new ac(paramq.agE(), g.aic());
      } else if (paramq.agF() == 2) {
        ac = new ac(paramq.agE(), g.aie());
      } 
      if (ac != null) {
        this.cDX.e(ac);
        return;
      } 
      if ((q)be.b(this.cDX).put(paramq.getIdentifier(), paramq) == null) {
        if (paramq.getType() == 2 && be.aeU().contains(Long.valueOf(bd.mg(((c)paramq.agE()).getAddress())))) {
          be.c(this.cDX).e(paramq);
          return;
        } 
        be.c(this.cDX).a(paramq);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */