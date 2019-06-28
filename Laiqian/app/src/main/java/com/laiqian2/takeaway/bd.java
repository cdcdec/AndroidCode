package com.laiqian.takeaway;

import com.google.a.a.a.a.a.a;
import com.laiqian.models.d;
import com.laiqian.models.x;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.av;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

class bd implements Runnable {
  bd(bc parambc, JSONArray paramJSONArray1, JSONArray paramJSONArray2) {}
  
  public void run() {
    null = bc.a(this.dtS, this.dtQ);
    null = new x(this.dtS.context);
    null.beginTransaction();
    null = new ArrayList();
    null = null.iterator();
    while (null.hasNext())
      null.addAll(null.m((Long)null.next())); 
    null = bc.a(this.dtS, this.dtR);
    d d = new d(this.dtS.context);
    ArrayList arrayList = new ArrayList();
    Iterator iterator = null.iterator();
    while (iterator.hasNext())
      arrayList.addAll(d.m((Long)iterator.next())); 
    d.close();
    null.setTransactionSuccessful();
    null.endTransaction();
    OnlineSyncRequest.a a = new OnlineSyncRequest.a();
    a.a(null, 1);
    a.a(arrayList, 1);
    null = new av(this.dtS.context);
    a.iM(null.Ea());
    a.iN(null.atr());
    a.bV(Long.parseLong(null.Tx()));
    null.close();
    f = f.bXQ;
    try {
      f.a(a.Xj());
      return;
    } catch (Exception f) {
      a.e(f);
      d.a(f, "实时同步失败, 异常", new Object[0]);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */