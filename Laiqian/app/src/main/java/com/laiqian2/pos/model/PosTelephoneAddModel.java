package com.laiqian.pos.model;

import android.support.v4.content.AsyncTaskLoader;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.av;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.Iterator;

public class PosTelephoneAddModel extends l {
  public boolean QL() { return super.QL(); }
  
  public static class OnlineSyncTask extends AsyncTaskLoader<Boolean> {
    private String btA;
    
    private String btz;
    
    public Boolean LN() {
      a = new OnlineSyncRequest.a();
      null = new l(getContext());
      ArrayList arrayList = null.hd(this.btz);
      int i = CrashApplication.getLaiqianPreferenceManager().QV();
      int j = 2;
      if (i == 0) {
        i = 1;
      } else {
        i = 2;
      } 
      a.a(arrayList, i);
      null.close();
      null = arrayList.iterator();
      while (null.hasNext())
        ((l.a)null.next()).a(l.bPh).setValue(Double.valueOf(0.0D)); 
      null = new j(getContext());
      arrayList = null.hd(this.btA);
      i = j;
      if (CrashApplication.getLaiqianPreferenceManager().QV() == 0)
        i = 1; 
      a.a(arrayList, i);
      null.close();
      null = new av(getContext());
      a.iM(null.Ea());
      a.iN(null.atr());
      a.bV(Long.parseLong(null.Tx()));
      null.close();
      f f = f.bXQ;
      try {
        f.a(a.Xj());
        return Boolean.valueOf(true);
      } catch (Exception a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("实时同步失败");
        stringBuilder.append(a.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(a);
        return Boolean.valueOf(false);
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\model\PosTelephoneAddModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */