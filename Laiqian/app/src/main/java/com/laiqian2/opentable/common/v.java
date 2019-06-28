package com.laiqian.opentable.common;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.i;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.pos.hardware.RootUrlParameter;
import java.util.ArrayList;
import java.util.Iterator;

public class v {
  private static i V(ArrayList<TableEntity> paramArrayList) {
    Iterator iterator = paramArrayList.iterator();
    while (iterator.hasNext()) {
      if (((TableEntity)iterator.next()).getState() != 0)
        return new i(false, true, RootApplication.zv().getResources().getString(R.string.please_settle_all_the_table_numbers)); 
    } 
    return new i(true, false, "");
  }
  
  public static void a(t.f paramf) { n.a(b.Xu(), RootUrlParameter.cmi, new w(paramf)); }
  
  public static i eB(boolean paramBoolean) {
    if (paramBoolean)
      try {
        for (a null : n.Xo()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(null.getId());
          stringBuilder.append("");
          i i = V(n.jg(stringBuilder.toString()));
          if (!i.bUi)
            return i; 
        } 
        return new i(true, false, "");
      } catch (Exception exception) {
        a.e(exception);
        return new i(false, 2, RootApplication.zv().getResources().getString(R.string.data_anomaly));
      }  
    null = V(b.aO(RootApplication.zv()));
    return !null.bUi ? null : new i(true, false, "");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */