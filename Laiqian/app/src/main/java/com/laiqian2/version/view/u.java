package com.laiqian.version.view;

import android.util.Log;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.laiqian.network.h;
import com.laiqian.version.a.c.c;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class u extends Object implements d<h> {
  u(t paramt) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) { t.a(this.dKC, false); }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      if (!paramu.aTa()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("request failed: ");
        stringBuilder.append(paramu.aGo());
        stringBuilder.append(" ");
        stringBuilder.append(paramu.message());
        throw new Exception(stringBuilder.toString());
      } 
      c c = (c)d.b(((h)paramu.aZd()).oV(), c.class);
      if (c != null) {
        if (c.dIz == 0) {
          this.dKC.dKz.mo(c.dIN.dIL);
          this.dKC.dKz.i(c.dIN.dIM, c.dIN.dIH);
          if (!t.a(this.dKC))
            this.dKC.dKB.runOnUiThread(new v(this)); 
        } else {
          UpgradeAndEvaluationActivity upgradeAndEvaluationActivity = this.dKC.dKB;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("请求失败，代号: ");
          stringBuilder.append(c.dIz);
          Toast.makeText(upgradeAndEvaluationActivity, stringBuilder.toString(), 0).show();
        } 
      } else {
        Log.w(UpgradeAndEvaluationActivity.TAG, "VersionInfoResponse is null");
      } 
    } catch (Exception paramb) {
      a.e(paramb);
    } 
    if (this.dKC.dKz.axe() > 0) {
      this.dKC.dKA.setVisibility(0);
    } else {
      this.dKC.dKA.setVisibility(8);
    } 
    t.a(this.dKC, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\vie\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */