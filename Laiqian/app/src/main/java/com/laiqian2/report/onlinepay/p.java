package com.laiqian.report.onlinepay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.laiqian.models.bh;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.Map;

class p implements AdapterView.OnItemClickListener {
  p(OnlinePayReportActivity paramOnlinePayReportActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt - OnlinePayReportActivity.b(this.ddj).getHeaderViewsCount() >= 0) {
      int i = OnlinePayReportActivity.b(this.ddj).getHeaderViewsCount();
      boolean bool = true;
      if (paramInt - i + 1 > OnlinePayReportActivity.b(this.ddj).getList().size())
        return; 
      Intent intent = new Intent();
      intent.setClass(this.ddj, OnlinePayReportDetailActivity.class);
      Bundle bundle = new Bundle();
      Map map = (Map)OnlinePayReportActivity.b(this.ddj).getList().get(paramInt - OnlinePayReportActivity.b(this.ddj).getHeaderViewsCount());
      bundle.putString("sOrderNo", (String)map.get("sOrderNo"));
      bundle.putString("sStatusText", OnlinePayReportActivity.f(this.ddj).jO(n.parseInt((String)map.get("nStatus"))));
      bundle.putString("sPayType", OnlinePayReportActivity.f(this.ddj).jN(n.parseInt((String)map.get("nPayType"))));
      bundle.putInt("nStatus", n.parseInt((String)map.get("nStatus")));
      bundle.putLong("nDateTime", n.parseLong((String)map.get("nDateTime")));
      bundle.putString("fAmount", by.a(by.sd((String)map.get("fAmount")), 9999, this.ddj, "2"));
      bh bh = new bh(this.ddj);
      String str = bh.iB((String)map.get("nUserID"));
      bh.close();
      bundle.putString("sUserName", str);
      bundle.putString("showType", String.valueOf(OnlinePayReportActivity.g(this.ddj)));
      if (OnlinePayReportActivity.g(this.ddj) == by.parseInt("1")) {
        if (by.parseInt((String)map.get("nSpareField2")) != 1)
          bool = false; 
        bundle.putBoolean("isReceive", bool);
      } 
      intent.putExtras(bundle);
      this.ddj.startActivity(intent);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */