package com.laiqian.takeaway.phone.setting;

import android.content.Intent;
import android.widget.Toast;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.l;
import com.laiqian.takeaway.phone.a;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.util.n;

class f implements r.a {
  f(e parame) {}
  
  public void xD() {}
  
  public void xE() {
    if (CrashApplication.getLaiqianPreferenceManager().Wq() && !bd.bH(this.duQ.duO)) {
      n.o(this.duQ.duO.getString(2131626280));
      return;
    } 
    l l = new l(this.duQ.duO);
    boolean bool = l.bm((PhoneChangeActivity.e(this.duQ.duO)).aSW);
    l.close();
    if (bool) {
      PhoneChangeActivity.a(this.duQ.duO, true);
      a a1 = new a(this.duQ.duO);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((PhoneChangeActivity.e(this.duQ.duO)).aSW);
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append((PhoneChangeActivity.e(this.duQ.duO)).aSW);
      stringBuilder2.append("");
      a1.aZ(str, stringBuilder2.toString());
      this.duQ.duO.sendBroadcast((new Intent()).setAction("pos_activity_change_data_paytype"));
      this.duQ.duO.sendBroadcast((new Intent()).setAction("pos_activity_change_data_vip"));
      Toast.makeText(this.duQ.duO, this.duQ.duO.getString(2131626672), 0).show();
      Intent intent = new Intent(this.duQ.duO, PhoneListActivity.class);
      this.duQ.duO.startActivity(intent);
      this.duQ.duO.finish();
      return;
    } 
    Toast.makeText(this.duQ.duO, this.duQ.duO.getString(2131626669), 0).show();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */