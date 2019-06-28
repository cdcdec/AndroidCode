package com.laiqian.ordertool.c;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.b;
import io.netty.channel.n;
import io.reactivex.g.a;
import org.json.JSONException;
import org.json.JSONObject;

public class o {
  public void a(Context paramContext, String paramString, int paramInt, n paramn) {
    paramString = b.decode(paramString);
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      p p = new p(this, paramContext, jSONObject.optLong("fromTime"), jSONObject.optString("searchPhrase"), jSONObject.optInt("curPosition"), jSONObject.optInt("pageLimit"), paramn, paramInt);
      a.aKh().r(p);
      return;
    } catch (JSONException paramContext) {
      a.e(paramContext);
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */