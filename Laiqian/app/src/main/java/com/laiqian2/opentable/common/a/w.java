package com.laiqian.opentable.common.a;

import com.laiqian.network.i;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import java.util.HashMap;

class w implements t.a {
  w(l paraml, HashMap paramHashMap, TableEntity paramTableEntity, t.f paramf) {}
  
  public void d(i parami) throws m {
    String str1;
    String str2 = this.bYS.toString();
    if (parami.bUi) {
      str1 = "编辑人数成功";
    } else {
      str1 = "编辑人数失败";
    } 
    b.au(str2, str1);
    if (parami.bUi) {
      b.a(this.bMz.Yh(), this.bMz.Yg().Yl(), this.bMz.Yg());
      n.k(this.bMz);
    } 
    this.bYi.dp(parami.bUi);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */