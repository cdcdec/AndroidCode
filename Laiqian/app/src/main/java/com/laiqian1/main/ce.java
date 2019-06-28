package com.laiqian.main;

import android.os.Handler;
import android.os.Message;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.a.r;
import com.zhuge.analysis.b.a;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

class ce extends Handler {
  ce(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 4) {
      if (i != 987654) {
        switch (i) {
          default:
            return;
          case 2:
            PosActivitySettlementDialog.access$5800(this.bcy, paramMessage);
            if (PosActivitySettlementDialog.access$5100(this.bcy))
              CrashApplication.getLaiqianPreferenceManager().hu(PosActivitySettlementDialog.access$5200(this.bcy)); 
            PosActivitySettlementDialog.access$5300(this.bcy);
            PosActivitySettlementDialog.access$1000(this.bcy).f(PosActivitySettlementDialog.access$5400(this.bcy, PosActivitySettlementDialog.access$4900(this.bcy)), false);
            this.bcy.cancel();
            PosActivitySettlementDialog.access$4902(this.bcy, null);
            return;
          case 1:
            break;
        } 
        if (PosActivitySettlementDialog.access$4900(this.bcy) != null && Objects.equals(String.valueOf(paramMessage.obj), PosActivitySettlementDialog.access$4900(this.bcy))) {
          PosActivitySettlementDialog.access$5800(this.bcy, paramMessage);
          PosActivitySettlementDialog.access$2500(this.bcy, PosActivitySettlementDialog.access$4900(this.bcy));
          return;
        } 
      } else {
        null = new r(PosActivitySettlementDialog.access$5900(this.bcy), 3, null);
        null.setTitle(PosActivitySettlementDialog.access$6000(this.bcy).getString(2131626721));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramMessage.obj);
        stringBuilder.append("");
        null.s(stringBuilder.toString());
        null.pa(PosActivitySettlementDialog.access$6100(this.bcy).getString(2131626714));
        null.show();
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("type", "支付之前");
          jSONObject.put("message", paramMessage.obj);
        } catch (JSONException paramMessage) {
          a.e(paramMessage);
        } 
        a.aAU().a(PosActivitySettlementDialog.access$6200(this.bcy), "扫码支付错误", jSONObject);
        return;
      } 
    } else {
      PosActivitySettlementDialog.access$5000(this.bcy, paramMessage.obj.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */