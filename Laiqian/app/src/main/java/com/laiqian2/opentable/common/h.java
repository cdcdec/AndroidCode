package com.laiqian.opentable.common;

import com.laiqian.d.a;
import com.laiqian.network.i;
import com.laiqian.opentable.common.entity.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class h implements t.a {
  h(g paramg, HashMap paramHashMap, ArrayList paramArrayList) {}
  
  public void d(i parami) throws m {
    String str1;
    String str2 = this.bYS.toString();
    if (parami.bUi) {
      str1 = "清空成功";
    } else {
      str1 = "清空桌号失败";
    } 
    b.au(str2, str1);
    if (parami.bUi && this.bZa.bYW) {
      if (this.bZa.bYX != null)
        this.bZa.bYX.invoke(); 
      if (this.bZa.bYU == -1) {
        this.bZa.bMz.Yc();
      } else if (b.c(this.bZa.bMz.Yh(), this.bZa.bYU)) {
        if (this.bZa.bMz.Yh().size() == 0) {
          this.bZa.bMz.Yc();
        } else {
          b.bb(a.AZ().Ca(), 1);
          Collections.sort(this.bZa.bMz.Yh());
          this.bZa.bMz.c((c)this.bZa.bMz.Yh().get(0));
        } 
      } 
      n.k(this.bZa.bMz);
    } 
    if (this.bZa.bYY != null)
      this.bZa.bYY.a(this.bYZ, this.bZa.bMz, parami.bUi); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */