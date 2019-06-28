package com.laiqian.opentable;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.main.bb;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.takeaway.v;
import com.laiqian.util.by;
import org.json.JSONException;

class f implements v {
  f(c paramc, c.a parama, TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail) {}
  
  public void a(String paramString, bb parambb) throws JSONException {
    try {
      if (this.bYg != null) {
        boolean bool = by.isNull(paramString) ^ true;
        if (bool) {
          a a1 = new a(RootApplication.zv());
          a1.kj(paramString);
          a1.close();
        } 
        this.bYg.ew(bool);
        this.bYg.a(this.bMz, this.bXu);
        return;
      } 
    } catch (Exception paramString) {
      a.e(paramString);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */