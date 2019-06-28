package com.laiqian.opentable.common;

import android.content.Intent;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.s;
import com.laiqian.i;
import com.laiqian.network.i;
import com.laiqian.util.by;
import org.json.JSONException;

final class k implements t.a {
  k(s params, t.f paramf) {}
  
  public void d(i parami) throws JSONException, m {
    int j = by.parseInt(this.bZb.aPq);
    Object object = i.wU().e(j, this.bZb.aSF);
    if (object != null) {
      if (j != 2002) {
        if (j != 2007) {
          if (j == 3004)
            b.b(parami, (t.f)object, this.bZb); 
        } else {
          b.b(parami, object, this.bZb);
        } 
      } else {
        b.b(parami, (t.e)object, this.bZb);
      } 
    } else {
      b.f(this.bZb.aSF, j);
      RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area"));
    } 
    this.bYP.dp(parami.bUi);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */