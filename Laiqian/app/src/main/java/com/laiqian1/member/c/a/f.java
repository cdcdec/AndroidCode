package com.laiqian.member.c.a;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.laiqian.member.cb;
import com.laiqian.ordertool.a;
import com.squareup.moshi.ay;
import java.lang.reflect.Type;
import java.util.HashMap;

public class f implements b {
  private Context context;
  
  public f(Context paramContext) { this.context = paramContext; }
  
  public void a(int paramInt1, int paramInt2, cb paramcb, d.a parama) {
    try {
      HashMap hashMap = e.a(paramInt2, paramcb);
      hashMap.put("bPartnerType", "2");
      String str = d.aXE.u(ay.a(java.util.Map.class, new Type[] { String.class, String.class })).ac(hashMap);
      a.cz(a.a(this.context, 3008, str, 1));
      return;
    } catch (Exception paramcb) {
      a.e(paramcb);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\c\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */