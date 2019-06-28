package com.laiqian;

import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.util.by;
import org.json.JSONException;
import org.json.JSONObject;

class j implements Runnable {
  public void run() {
    try {
      JSONObject jSONObject = new JSONObject(this.azy);
      String str = jSONObject.optString("type");
      if ("order".equals(str)) {
        i.a(this.azB, jSONObject, this.azy, this.azz, this.azA);
        return;
      } 
      if ("table".equals(str)) {
        str = jSONObject.getString("sub_type");
        if ("move_table".equals(str)) {
          i.a(this.azB, jSONObject, this.azz, this.azy, this.azA);
          return;
        } 
        if ("update_table".equals(str) && this.azz) {
          long l = by.parseLong(jSONObject.getString("table_id"));
          int k = by.parseInt(jSONObject.getString("table_status"));
          int m = by.parseInt(jSONObject.getString("actual_person"));
          TableEntity tableEntity = n.ce(l);
          int n = jSONObject.optInt("number_id");
          c c = b.b(tableEntity.Yh(), n);
          c.gy(m);
          c.gz(k);
          b.a(tableEntity.Yh(), n, c);
          n.k(tableEntity);
          return;
        } 
      } 
    } catch (JSONException jSONException) {
      a.e(jSONException);
    } catch (m m) {
      a.e(m);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */