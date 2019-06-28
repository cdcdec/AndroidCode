package com.laiqian.opentable.pos;

import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.t;
import com.laiqian.opentable.common.u;
import java.util.ArrayList;

class y implements t.j {
  y(j paramj) {}
  
  public void U(ArrayList<TableEntity> paramArrayList) {
    ArrayList<TableEntity> arrayList = paramArrayList;
    if (paramArrayList == null)
      arrayList = new ArrayList<TableEntity>(); 
    j.b(this.cbg).v(arrayList);
    j.c(this.cbg).eD(true);
    this.cbg.zM();
    u.XQ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */