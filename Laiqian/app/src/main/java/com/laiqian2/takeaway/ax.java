package com.laiqian.takeaway;

import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.bq;
import com.laiqian.util.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ax implements al.a {
  ax(String paramString) {}
  
  public void jI(String paramString) {
    Log.d("checkLocalOrders数据结果", paramString);
    bc = new bc(RootApplication.zv());
    if (!TextUtils.isEmpty(paramString)) {
      try {
        null = (new JSONObject(paramString)).getString("push_context");
        bc.updateOrders(null, false, false);
        JSONObject jSONObject = new JSONObject((new JSONObject(null)).getJSONObject("all").get(this.drK).toString());
        if (!"[]".equals(jSONObject.optString("pending", "[]").toString())) {
          JSONArray jSONArray = new JSONArray(jSONObject.optString("pending").toString());
        } else {
          bc = null;
        } 
        if (!"[]".equals(jSONObject.optString("refund", "[]").toString())) {
          JSONArray jSONArray = new JSONArray(jSONObject.optString("refund").toString());
        } else {
          jSONObject = null;
        } 
        if ((bc != null && bc.length() > 0) || (jSONObject != null && jSONObject.length() > 0)) {
          Log.d("checkLocalOrders声音提醒", paramString);
          (new bq(RootApplication.zv())).mi(R.raw.sound_new_orders);
          return;
        } 
      } catch (JSONException bc) {
        a.e(bc);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder.append("用户自动接单打印失败1");
        String str = stringBuilder.toString();
        n.a(new String[] { "crash@91laiqian.com" }, str, paramString, null, null);
        return;
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
      stringBuilder.append("用户自动接单打印失败3");
      String str = stringBuilder.toString();
      n.a(new String[] { "crash@91laiqian.com" }, str, paramString, null, null);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */