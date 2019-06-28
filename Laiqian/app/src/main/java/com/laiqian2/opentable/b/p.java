package com.laiqian.opentable.b;

import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;

class p implements t.i {
  p(b paramb, long paramLong) {}
  
  public void g(TableEntity paramTableEntity) throws m {
    if (paramTableEntity != null)
      if (paramTableEntity.getState() == 0) {
        this.ccI.ci(this.bYd);
      } else {
        throw new m("桌号正在使用中", b.b(this.ccI).getString(R.string.pos_opentable_table_delete));
      }  
    this.ccI.zM();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */