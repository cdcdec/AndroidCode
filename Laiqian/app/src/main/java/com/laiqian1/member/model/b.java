package com.laiqian.member.model;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.av;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.orhanobut.logger.d;

public class b {
  public int byc;
  
  Context context;
  
  public String id;
  
  public b(Context paramContext) { this.context = paramContext; }
  
  public boolean QN() {
    a = new OnlineSyncRequest.a();
    null = new a(this.context);
    a.a(null.gZ(this.id), this.byc);
    null.close();
    null = new av(this.context);
    a.iM(null.Ea());
    a.iN(null.atr());
    a.bV(Long.parseLong(null.Tx()));
    null.close();
    f f = f.bXQ;
    try {
      return (f.b(a.Xj())).bXV;
    } catch (Exception a) {
      h.awP().a(new d(b.class.getSimpleName(), "onlineSync", "请求实时同步失败--", a.getMessage()), h.a.dHw, h.b.dHD);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("请求实时同步失败");
      stringBuilder.append(a.getMessage());
      d.b(stringBuilder.toString(), new Object[0]);
      a.e(a);
      return false;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */