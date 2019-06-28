package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import io.reactivex.c.c;

class ai extends Object implements c<TableEntity, Integer, String> {
  ai(ag paramag) {}
  
  public String a(TableEntity paramTableEntity, Integer paramInteger) throws Exception {
    Log.i(ag.Ou(), "获取桌号名称 ");
    String str = "";
    if (paramInteger.intValue() == 7) {
      b.a a = b.a(this.bnl.mContext, null, Long.valueOf(paramTableEntity.getID()), true, paramTableEntity.Yg().Ym());
      if (paramTableEntity != null && paramTableEntity.Yg().Yl() != 0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a.bZc);
        stringBuilder1.append("-");
        stringBuilder1.append(a.bTe);
        stringBuilder1.append(".");
        stringBuilder1.append(this.bnl.mContext.getString(2131626009));
        stringBuilder1.append(paramTableEntity.Yg().Yl());
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.bZc);
      stringBuilder.append("-");
      stringBuilder.append(a.bTe);
      str = stringBuilder.toString();
    } 
    return str;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */