package com.laiqian.opentable.common.a;

import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.t;

class d implements t.k {
  d(b paramb, t.k paramk) {}
  
  public void a(boolean paramBoolean, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) {
    String str1 = new StringBuilder();
    str1.append("移桌桌号,开始桌号ID+");
    str1.append(paramTableEntity1.getID());
    str1.append("，编号");
    str1.append(paramInt);
    str1.append(",结束桌号ID+");
    str1.append(paramTableEntity2.getID());
    String str2 = str1.toString();
    if (paramBoolean) {
      String str = "移桌成功";
    } else {
      str1 = "移桌失败";
    } 
    b.au(str2, str1);
    this.bZu.a(paramBoolean, paramTableEntity1, paramTableEntity2, paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */