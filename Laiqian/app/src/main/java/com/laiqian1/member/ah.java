package com.laiqian.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.laiqian.util.bb;
import java.util.Map;

class ah implements AdapterView.OnItemClickListener {
  ah(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    long l;
    Intent intent;
    if (paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount() + 1 <= MemberInfoActivity.e(this.buu).getList().size()) {
      if (paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount() < 0)
        return; 
      paramLong = Long.valueOf((String)((Map)MemberInfoActivity.e(this.buu).getList().get(paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount())).get("nDateTime")).longValue();
      l = Long.valueOf((String)((Map)MemberInfoActivity.e(this.buu).getList().get(paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount())).get("_id")).longValue();
      int i = Integer.valueOf((String)((Map)MemberInfoActivity.e(this.buu).getList().get(paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount())).get("nChargeType")).intValue();
      bb.e("nChargeType", Integer.valueOf(i));
      intent = new Intent();
      if (i != 370004 && i != 370007) {
        long l1 = i;
        if (l1 == 370010L) {
          intent.setClass(this.buu, com.laiqian.member.report.MemberChargeDetailRecord.class);
          Bundle bundle1 = new Bundle();
          bundle1.putLong("_id", l);
          Map map1 = (Map)MemberInfoActivity.e(this.buu).getList().get(paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount());
          bundle1.putString("recharge", MemberInfoActivity.a(this.buu).o((String)map1.get("nChargeType"), (String)map1.get("nSpareField2"), (String)map1.get("nSpareField3")));
          bundle1.putString("nBelongShopID", this.buu.btU);
          bundle1.putLong("nDateTime", paramLong);
          bundle1.putDouble("AMOUNT", (MemberInfoActivity.a(this.buu).PV()).aWo);
          bundle1.putLong("VIP_ID", (MemberInfoActivity.a(this.buu).PV()).aSW);
          intent.putExtras(bundle1);
          this.buu.startActivity(intent);
          return;
        } 
        if (i == 370005) {
          intent = new Intent();
          intent.setClassName(this.buu, "com.laiqian.report.ui.TransactionDetails");
          Bundle bundle1 = new Bundle();
          bundle1.putString("orderNo", MemberInfoActivity.a(this.buu).n(paramLong, l));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramLong);
          stringBuilder.append("");
          bundle1.putString("ORDERTIME", stringBuilder.toString());
          intent.putExtras(bundle1);
          this.buu.startActivity(intent);
          return;
        } 
        if (l1 == 370011L) {
          intent.setClass(this.buu, com.laiqian.member.report.VipInitialBalanceDetailActivity.class);
          Bundle bundle1 = new Bundle();
          bundle1.putLong("_id", l);
          bundle1.putLong("nDateTime", paramLong);
          Map map1 = (Map)MemberInfoActivity.e(this.buu).getList().get(paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount());
          bundle1.putString("recharge", MemberInfoActivity.a(this.buu).o((String)map1.get("nChargeType"), (String)map1.get("nSpareField2"), (String)map1.get("nSpareField3")));
          intent.putExtras(bundle1);
          this.buu.startActivity(intent);
          return;
        } 
        if (i == 370009) {
          intent.setClass(this.buu, VipPointDetailActivity.class);
          Bundle bundle1 = new Bundle();
          bundle1.putLong("_id", l);
          bundle1.putLong("nDateTime", paramLong);
          intent.putExtras(bundle1);
          this.buu.startActivity(intent);
          return;
        } 
        return;
      } 
    } else {
      return;
    } 
    intent.setClass(this.buu, com.laiqian.member.report.MemberChargeDetailRecord.class);
    Bundle bundle = new Bundle();
    bundle.putLong("_id", l);
    Map map = (Map)MemberInfoActivity.e(this.buu).getList().get(paramInt - MemberInfoActivity.e(this.buu).getHeaderViewsCount());
    bundle.putString("recharge", MemberInfoActivity.a(this.buu).o((String)map.get("nChargeType"), (String)map.get("nSpareField2"), (String)map.get("nSpareField3")));
    bundle.putString("nBelongShopID", this.buu.btU);
    bundle.putLong("nDateTime", paramLong);
    bundle.putDouble("AMOUNT", (MemberInfoActivity.a(this.buu).PV()).aWo);
    bundle.putLong("VIP_ID", (MemberInfoActivity.a(this.buu).PV()).aSW);
    intent.putExtras(bundle);
    this.buu.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */