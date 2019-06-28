package com.laiqian.opentable.common.a;

import com.laiqian.d.a;
import com.laiqian.network.i;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import java.util.Collections;
import java.util.HashMap;

class y implements t.a {
  y(x paramx, HashMap paramHashMap) {}
  
  public void d(i parami) throws m {
    String str1;
    String str2 = this.bYS.toString();
    if (parami.bUi) {
      str1 = "移桌成功";
    } else {
      str1 = "移桌失败";
    } 
    b.au(str2, str1);
    if (parami.bUi) {
      TableEntity tableEntity1 = new TableEntity(this.cas.bZv);
      TableEntity tableEntity2 = new TableEntity(this.cas.bZw);
      l.a(this.cas.caq).c(tableEntity1, tableEntity2, this.cas.bYU);
      if (this.cas.bYU == -1) {
        for (c c : this.cas.bZv.Yh()) {
          c.ch(this.cas.bZw.getID());
          this.cas.bZw.Yh().add(c);
        } 
        Collections.sort(this.cas.bZw.Yh());
        if (this.cas.bZw.Yh().size() > 0)
          this.cas.bZw.c((c)this.cas.bZw.Yh().get(0)); 
        this.cas.bZw.setState(this.cas.bZv.getState());
        this.cas.bZw.cf(this.cas.bZv.DP());
        this.cas.bZv.Yc();
      } else {
        c c = b.b(this.cas.bZv.Yh(), this.cas.bYU);
        if (c != null) {
          b.c(this.cas.bZv.Yh(), this.cas.bYU);
          c.gx(0);
          c.ch(this.cas.bZw.getID());
          this.cas.bZw.c(c);
          this.cas.bZw.Yh().add(c);
          this.cas.bZw.setState(c.Yn());
          this.cas.bZw.cf(c.DP());
          this.cas.bZw.setState(2);
          this.cas.bZw.Yg().gz(2);
        } 
        if (this.cas.bZv.Yh().size() == 0) {
          this.cas.bZv.Yc();
        } else {
          b.bb(a.AZ().Ca(), 1);
          Collections.sort(this.cas.bZv.Yh());
          this.cas.bZv.c((c)this.cas.bZv.Yh().get(0));
        } 
      } 
      n.k(this.cas.bZv);
      n.k(this.cas.bZw);
    } 
    this.cas.bZu.a(parami.bUi, this.cas.bZv, this.cas.bZw, this.cas.bYU);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */