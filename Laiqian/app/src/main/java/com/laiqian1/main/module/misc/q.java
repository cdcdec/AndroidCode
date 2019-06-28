package com.laiqian.main.module.misc;

import android.content.Intent;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.network.h;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class q extends Object implements d<h> {
  q(PosActivityMoreSettingsFragment paramPosActivityMoreSettingsFragment, String paramString) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) { Toast.makeText(this.bgP.getActivity(), 2131628442, 0).show(); }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      if (!paramu.aTa()) {
        Toast.makeText(this.bgP.getActivity(), 2131628459, 0).show();
        return;
      } 
      int i = (new JSONObject(((h)paramu.aZd()).oV())).getInt("msg_no");
      if (i == 0) {
        Intent intent = new Intent(this.bgP.getActivity(), com.laiqian.version.view.MyEvaluationActivity.class);
        intent.putExtra("version_id", this.bgQ);
        this.bgP.startActivity(intent);
        return;
      } 
      if (i == -6) {
        Intent intent = new Intent(this.bgP.getActivity(), com.laiqian.version.view.DoEvaluateActivity.class);
        intent.putExtra("FROM", 2);
        intent.putExtra("version_id", this.bgQ);
        this.bgP.startActivity(intent);
        return;
      } 
      Toast.makeText(this.bgP.getActivity(), 2131628459, 0).show();
      return;
    } catch (JSONException paramb) {
      a.e(paramb);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\misc\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */