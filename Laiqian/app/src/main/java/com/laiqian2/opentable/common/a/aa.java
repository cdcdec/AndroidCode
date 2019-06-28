package com.laiqian.opentable.common.a;

import com.laiqian.d.a;
import com.laiqian.main.bb;
import com.laiqian.network.i;
import com.laiqian.opentable.common.a;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.Collections;
import java.util.HashMap;

class aa implements t.a {
  aa(l paraml, HashMap paramHashMap, long paramLong, TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb, t.f paramf) {}
  
  public void d(i parami) throws m {
    String str1;
    String str2 = this.bYS.toString();
    if (parami.bUi) {
      str1 = "结算成功";
    } else {
      str1 = "结算订单失败";
    } 
    b.au(str2, str1);
    if (parami.bUi || parami.bUj != a.bYQ)
      b.f(this.cat, 3004); 
    if (parami.bUi) {
      null = new TableEntity(this.bMz);
      l.a(this.caq).a(null, this.bXu, this.cau);
      c c = b.b(this.bMz.Yh(), this.bMz.Yg().Yl());
      if (c != null) {
        this.bMz.Yh().remove(c);
        if (this.bMz.Yh().size() == 0) {
          this.bMz.Yc();
        } else {
          Collections.sort(this.bMz.Yh());
          this.bMz.c((c)this.bMz.Yh().get(0));
        } 
      } 
      n.k(this.bMz);
    } 
    b.bb(a.AZ().Ca(), 1);
    this.bYi.dp(parami.bUi);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */