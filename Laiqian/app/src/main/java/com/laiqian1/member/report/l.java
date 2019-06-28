package com.laiqian.member.report;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import java.util.Map;

class l implements AdapterView.OnItemClickListener {
  l(VipReportActivity paramVipReportActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    long l1;
    if (paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount() >= 0) {
      if (paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount() + 1 > VipReportActivity.d(this.bzE).getList().size())
        return; 
      paramLong = Long.valueOf((String)((Map)VipReportActivity.d(this.bzE).getList().get(paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount())).get("_id")).longValue();
      l1 = Long.valueOf((String)((Map)VipReportActivity.d(this.bzE).getList().get(paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount())).get("nDateTime")).longValue();
      int i = Integer.valueOf((String)((Map)VipReportActivity.d(this.bzE).getList().get(paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount())).get("nChargeType")).intValue();
      intent = new Intent();
      if (i != 370004 && i != 370007) {
        long l2 = i;
        if (l2 == 370010L) {
          intent.setClass(this.bzE, MemberChargeDetailRecord.class);
          Bundle bundle1 = new Bundle();
          bundle1.putLong("_id", paramLong);
          Map map1 = (Map)VipReportActivity.d(this.bzE).getList().get(paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount());
          bundle1.putString("recharge", VipReportActivity.j(this.bzE).o((String)map1.get("nChargeType"), (String)map1.get("nSpareField2"), (String)map1.get("nSpareField3")));
          bundle1.putString("nBelongShopID", (String)map1.get("nWarehouseID"));
          bundle1.putLong("VIP_ID", n.parseLong((String)map1.get("nBPartnerID")));
          bundle1.putLong("nDateTime", l1);
          intent.putExtras(bundle1);
          this.bzE.startActivity(intent);
          return;
        } 
        if (i == 370005)
          try {
            Map map1 = (Map)VipReportActivity.d(this.bzE).getList().get(paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount());
            if (RootApplication.getLaiqianPreferenceManager().Wq())
              RootApplication.getLaiqianPreferenceManager().dB(paramLong); 
            Intent intent1 = new Intent();
            intent1.setClassName(this.bzE, "com.laiqian.report.ui.TransactionDetails");
            Bundle bundle1 = new Bundle();
            bundle1.putString("orderNo", VipReportActivity.j(this.bzE).n(l1, paramLong));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(l1);
            stringBuilder.append("");
            bundle1.putString("ORDERTIME", stringBuilder.toString());
            intent1.putExtras(bundle1);
            this.bzE.startActivity(intent1);
            return;
          } catch (Exception intent) {
            a.e(intent);
            return;
          }  
        if (l2 == 370011L) {
          intent.setClass(this.bzE, VipInitialBalanceDetailActivity.class);
          Bundle bundle1 = new Bundle();
          bundle1.putLong("_id", paramLong);
          Map map1 = (Map)VipReportActivity.d(this.bzE).getList().get(paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount());
          bundle1.putString("recharge", VipReportActivity.j(this.bzE).o((String)map1.get("nChargeType"), (String)map1.get("nSpareField2"), (String)map1.get("nSpareField3")));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l1);
          stringBuilder.append("");
          bundle1.putString("nDateTime", stringBuilder.toString());
          intent.putExtras(bundle1);
          this.bzE.startActivity(intent);
          return;
        } 
        if (i == 370009) {
          intent.setClass(this.bzE, com.laiqian.member.VipPointDetailActivity.class);
          Bundle bundle1 = new Bundle();
          bundle1.putLong("_id", paramLong);
          bundle1.putLong("nDateTime", l1);
          intent.putExtras(bundle1);
          this.bzE.startActivity(intent);
          return;
        } 
        return;
      } 
    } else {
      return;
    } 
    intent.setClass(this.bzE, MemberChargeDetailRecord.class);
    Bundle bundle = new Bundle();
    bundle.putLong("_id", paramLong);
    Map map = (Map)VipReportActivity.d(this.bzE).getList().get(paramInt - VipReportActivity.d(this.bzE).getHeaderViewsCount());
    bundle.putString("recharge", VipReportActivity.j(this.bzE).o((String)map.get("nChargeType"), (String)map.get("nSpareField2"), (String)map.get("nSpareField3")));
    bundle.putString("nBelongShopID", (String)map.get("nWarehouseID"));
    bundle.putLong("VIP_ID", n.parseLong((String)map.get("nBPartnerID")));
    bundle.putLong("nDateTime", l1);
    intent.putExtras(bundle);
    this.bzE.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */