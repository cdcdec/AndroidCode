package com.laiqian.pos.settings;

import android.os.Handler;
import android.os.Message;
import com.laiqian.models.an;
import org.json.JSONObject;

class ct extends Handler {
  ct(cs paramcs, an paraman, df paramdf) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1) {
      try {
        JSONObject jSONObject = new JSONObject((String)paramMessage.obj);
        int i = paramMessage.arg1;
        this.cBA.cBw = this.cBy.d(jSONObject, String.valueOf(i));
        cs.a(this.cBA, this.cBz);
      } catch (Exception paramMessage) {}
    } else if (paramMessage.what == 2) {
      this.cBA.cBw = this.cBy.Vu();
      cs.a(this.cBA, this.cBz);
    } 
    this.cBA.acr();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */