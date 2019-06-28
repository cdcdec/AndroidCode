package com.laiqian.report.onlinepay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.laiqian.entity.q;
import com.laiqian.models.bh;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.Map;

class m implements View.OnClickListener {
  m(l paraml, int paramInt) {}
  
  public void onClick(View paramView) {
    Map map = (Map)(OnlinePayReportActivity.e(this.ddn.ddj)).aIG.get(this.qI);
    int i = n.parseInt((String)map.get("nStatus"));
    boolean bool = true;
    if (i == 1) {
      Intent intent = new Intent();
      intent.setClass(this.ddn.ddj, OnlinePayReportDetailActivity.class);
      Bundle bundle = new Bundle();
      bundle.putString("sOrderNo", (String)map.get("sOrderNo"));
      bundle.putString("sStatusText", OnlinePayReportActivity.f(this.ddn.ddj).jO(n.parseInt((String)map.get("nStatus"))));
      bundle.putString("sPayType", OnlinePayReportActivity.f(this.ddn.ddj).jN(n.parseInt((String)map.get("nPayType"))));
      bundle.putInt("nStatus", n.parseInt((String)map.get("nStatus")));
      bundle.putLong("nDateTime", n.parseLong((String)map.get("nDateTime")));
      bundle.putString("fAmount", by.a(by.sd((String)map.get("fAmount")), 9999, this.ddn.ddj, "2"));
      bh bh = new bh(this.ddn.ddj);
      String str = bh.iB((String)map.get("nUserID"));
      bh.close();
      bundle.putString("sUserName", str);
      bundle.putString("showType", String.valueOf(OnlinePayReportActivity.g(this.ddn.ddj)));
      if (OnlinePayReportActivity.g(this.ddn.ddj) == by.parseInt("1")) {
        if (by.parseInt((String)map.get("nSpareField2")) != 1)
          bool = false; 
        bundle.putBoolean("isReceive", bool);
      } 
      intent.putExtras(bundle);
      this.ddn.ddj.startActivity(intent);
      return;
    } 
    q q = (new q.a()).df((String)map.get("sOrderNo")).dg((String)map.get("fAmount")).ak(n.parseLong((String)map.get("nDateTime"))).aj(n.parseInt((String)map.get("nPayType"))).Fy();
    OnlinePayReportActivity.f(this.ddn.ddj).a(q);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */