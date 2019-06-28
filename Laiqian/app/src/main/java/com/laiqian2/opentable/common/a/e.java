package com.laiqian.opentable.common.a;

import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.Collections;

class e implements t.f {
  e(b paramb, TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, t.f paramf) {}
  
  public void dp(boolean paramBoolean) throws m {
    String str1 = new StringBuilder();
    str1.append("桌号ID+");
    str1.append(this.bMz.getID());
    str1.append("，编号");
    str1.append(this.bMz.Yg().Yl());
    str1.append("订单号");
    str1.append(this.bMz.Yg().xq());
    String str2 = str1.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("结算");
    if (paramBoolean) {
      String str = "成功";
    } else {
      str1 = "失败";
    } 
    stringBuilder.append(str1);
    b.au(str2, stringBuilder.toString());
    if (paramBoolean) {
      if (b.c(this.bMz.Yh(), this.bXu.bXb.coM)) {
        if (this.bMz.Yh().size() == 0) {
          this.bMz.Yc();
        } else {
          this.bMz.setState(2);
          Collections.sort(this.bMz.Yh());
          this.bMz.c((c)this.bMz.Yh().get(0));
          this.bMz.cf(this.bMz.Yg().DP());
        } 
      } else {
        this.bMz.Yc();
      } 
      n.k(this.bMz);
    } 
    this.bYi.dp(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */