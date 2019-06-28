package com.laiqian.ordertool.c;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.google.gson.k;
import com.google.gson.q;
import com.laiqian.dcb.api.server.a.c;
import com.laiqian.f.b;
import com.laiqian.i.d;
import com.laiqian.models.x;
import com.laiqian.pos.ReprintActivity;
import com.squareup.moshi.ay;
import com.squareup.moshi.t;
import io.netty.channel.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

class p implements Runnable {
  p(o paramo, Context paramContext, long paramLong, String paramString, int paramInt1, int paramInt2, n paramn) {}
  
  public void run() {
    x = new x(context);
    int i = x.n(this.cev, this.cew);
    try {
      Cursor cursor = x.a(this.cev, this.cew, this.cex, this.cey);
    } catch (Exception x) {
      a.e(x);
      x = null;
    } 
    if (x != null) {
      null = ReprintActivity.a(x, context);
      null = new HashMap();
      null = new HashMap();
      for (ReprintActivity.c c : null) {
        if (c.type == 1) {
          null.put(c.orderNo, ReprintActivity.a(c, context));
          continue;
        } 
        if (c.type == 2)
          null.put(c.orderNo, ReprintActivity.b(c, context)); 
      } 
      ParameterizedType parameterizedType = ay.a(java.util.List.class, new Type[] { ReprintActivity.c.class });
      t t = d.aXE.u(parameterizedType);
      k k = (new q()).vE().vF();
      String str3 = t.ac(null);
      String str2 = k.ac(null);
      str1 = k.ac(null);
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reprintOrders", str3);
        jSONObject.put("settleDetails", str2);
        jSONObject.put("pendingDetails", str1);
        jSONObject.put("count", i);
        str1 = b.encode(jSONObject.toString());
        c.a(this.ceq, this.cer, -1, "", str1, "0");
        return;
      } catch (Exception str1) {
        a.e(str1);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */