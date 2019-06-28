package com.laiqian.member.c.a;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import com.laiqian.i.d;
import com.laiqian.member.cb;
import com.laiqian.ordertool.b.c;
import com.laiqian.ordertool.b.d;
import com.laiqian.print.util.e;
import com.squareup.moshi.ay;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.json.JSONException;
import org.json.JSONObject;

public class g implements a {
  private c bxF;
  
  private b bxG;
  
  private Timer bxH;
  
  private Context context;
  
  public g(c paramc, Context paramContext) {
    this.bxF = paramc;
    this.context = paramContext;
    if (RootApplication.getLaiqianPreferenceManager().avL() != 0)
      c.aYt().cJ(this); 
    this.bxG = new o(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, cb paramcb) {
    this.bxH = new Timer();
    this.bxH.schedule(new h(this), 12000L);
    this.bxG.a(paramInt1, paramInt2, paramcb, new j(this));
  }
  
  @Subscribe(aYx = ThreadMode.BACKGROUND)
  public void onReturnOrderAreaTableDataEvent(d paramd) {
    if (paramd.Zg() == c.cdT) {
      String str = b.decode(paramd.Zf());
      try {
        ParameterizedType parameterizedType = ay.a(List.class, new Type[] { ay.a(java.util.Map.class, new Type[] { String.class, String.class }) });
        JSONObject jSONObject = new JSONObject(str);
        e.i(new l(this, (List)d.aXE.u(parameterizedType).sR(jSONObject.optString("customer_list")), jSONObject.optInt("page")));
        return;
      } catch (JSONException|java.io.IOException paramd) {
        a.e(paramd);
        return;
      } 
    } 
    paramd.Zg();
    c c1 = c.cdU;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */