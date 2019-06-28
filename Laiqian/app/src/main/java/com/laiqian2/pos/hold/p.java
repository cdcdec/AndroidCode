package com.laiqian.pos.hold;

import com.google.a.a.a.a.a.a;
import com.laiqian.network.i;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.util.by;
import com.laiqian.util.n;
import org.json.JSONException;
import org.json.JSONObject;

class p implements t.a {
  p(OpenTableSettingActivity paramOpenTableSettingActivity, boolean paramBoolean) {}
  
  public void d(i parami) throws m {
    if (parami.bUi && !by.isNull(parami.message)) {
      try {
        if ((new JSONObject(parami.message)).optInt("net_status") == OpenTableSettingActivity.c(this.coe))
          OpenTableSettingActivity.a(this.coe, true, this.cof); 
      } catch (JSONException parami) {
        a.e(parami);
      } 
    } else {
      n.o(this.coe.getString(2131627469));
    } 
    this.coe.zM();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */