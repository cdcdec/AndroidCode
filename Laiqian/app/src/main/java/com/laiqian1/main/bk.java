package com.laiqian.main;

import android.content.Intent;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.util.n;

class bk implements View.OnClickListener {
  bk(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    if (PosActivitySettlementDialog.access$1600(this.bcy).getTag() != null && "onlinePay".equalsIgnoreCase(PosActivitySettlementDialog.access$1600(this.bcy).getTag().toString())) {
      if ("150001".equals(CrashApplication.getLaiqianPreferenceManager().atp())) {
        if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTv == 10007) {
          this.bcy.getContext().startActivity(new Intent(this.bcy.getContext(), com.laiqian.binding.BindingAlipaySelectActivity.class));
          return;
        } 
        if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTv == 10009 && a.zR().At()) {
          n.eP(2131624868);
          return;
        } 
        if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTv == 10009) {
          this.bcy.getContext().startActivity(new Intent(this.bcy.getContext(), com.laiqian.binding.BindingWechatSelectActivity.class));
          return;
        } 
      } else {
        n.eP(2131625522);
      } 
      return;
    } 
    if (((PosActivitySettlementDialog.access$1800(this.bcy) != null && (PosActivitySettlementDialog.access$1800(this.bcy)).aTv == 10001) || (PosActivitySettlementDialog.access$1700(this.bcy)).aTv == 10001) && !RootApplication.getLaiqianPreferenceManager().avT() && RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(2131625902);
      return;
    } 
    if (PosActivitySettlementDialog.access$1900(this.bcy))
      return; 
    if (!PosActivitySettlementDialog.access$2000(this.bcy))
      return; 
    if (PosActivitySettlementDialog.access$2100(this.bcy))
      return; 
    if (PosActivitySettlementDialog.access$2200(this.bcy))
      return; 
    if (PosActivitySettlementDialog.access$2300(this.bcy))
      return; 
    if (PosActivitySettlementDialog.access$2400(this.bcy))
      return; 
    PosActivitySettlementDialog.access$2500(this.bcy, null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */