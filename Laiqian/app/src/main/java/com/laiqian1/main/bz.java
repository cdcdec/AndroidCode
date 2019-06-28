package com.laiqian.main;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.o;
import com.laiqian.pos.AliPayPreorderDetail;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.util.n;

class bz implements o.a {
  bz(PosActivitySettlementDialog paramPosActivitySettlementDialog, boolean paramBoolean) {}
  
  public void a(long paramLong, boolean paramBoolean) {
    if (this.bcC) {
      this.bcy.resetSecondPayTypeItemView(paramLong);
    } else {
      this.bcy.resetFirstPayTypeItemView(paramLong);
    } 
    if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTe == 5L || (PosActivitySettlementDialog.access$1700(this.bcy)).aTe == 1L || (PosActivitySettlementDialog.access$1800(this.bcy) != null && (PosActivitySettlementDialog.access$1800(this.bcy)).aTx == 5L) || (PosActivitySettlementDialog.access$1800(this.bcy) != null && (PosActivitySettlementDialog.access$1800(this.bcy)).aTx == 1L))
      PosActivitySettlementDialog.access$4400(this.bcy, true); 
    if (a.zR().At()) {
      TextView textView = new TextView(this.bcy.getContext());
      textView.setText(PayTypeSpecific.cn(paramLong));
      (PosActivitySettlementDialog.access$1700(this.bcy)).aKu = textView;
    } 
  }
  
  public void bk(String paramString) { PosActivitySettlementDialog.access$4902(this.bcy, paramString); }
  
  public void bl(String paramString) {
    if (paramString.equals(PosActivitySettlementDialog.access$4900(this.bcy))) {
      PosActivitySettlementDialog.access$2500(this.bcy, paramString);
      return;
    } 
    PosActivitySettlementDialog.access$5000(this.bcy, paramString);
  }
  
  public void f(int paramInt, String paramString) {
    if (paramInt == 2) {
      if (PosActivitySettlementDialog.access$5100(this.bcy))
        CrashApplication.getLaiqianPreferenceManager().hu(PosActivitySettlementDialog.access$5200(this.bcy)); 
      PosActivitySettlementDialog.access$5300(this.bcy);
      PosActivitySettlementDialog.access$1000(this.bcy).f(PosActivitySettlementDialog.access$5400(this.bcy, PosActivitySettlementDialog.access$4900(this.bcy)), false);
      this.bcy.cancel();
      PosActivitySettlementDialog.access$4902(this.bcy, null);
    } 
  }
  
  public void o(Bitmap paramBitmap) {
    AliPayPreorderDetail aliPayPreorderDetail;
    if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTe == 8L || (PosActivitySettlementDialog.access$1800(this.bcy) != null && (PosActivitySettlementDialog.access$1800(this.bcy)).aTv == 10009)) {
      AliPayPreorderDetail aliPayPreorderDetail1 = PosActivitySettlementDialog.access$4500(this.bcy, 2, this.bcy.onlinePayEntity.Fl());
      aliPayPreorderDetail = aliPayPreorderDetail1;
      if (PosActivitySettlementDialog.access$4600(this.bcy) != null) {
        PosActivitySettlementDialog.access$4600(this.bcy).afP().b(new BitmapDrawable(this.bcy.getContext().getResources(), paramBitmap), n.b(PosActivitySettlementDialog.access$4700(this.bcy), 2131625101, this.bcy.onlinePayEntity.Fl()));
        aliPayPreorderDetail = aliPayPreorderDetail1;
      } 
    } else if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTe == 0L || (PosActivitySettlementDialog.access$1800(this.bcy) != null && (PosActivitySettlementDialog.access$1800(this.bcy)).aTv == 10007)) {
      AliPayPreorderDetail aliPayPreorderDetail1 = PosActivitySettlementDialog.access$4500(this.bcy, 1, this.bcy.onlinePayEntity.Fl());
      aliPayPreorderDetail = aliPayPreorderDetail1;
      if (PosActivitySettlementDialog.access$4600(this.bcy) != null) {
        PosActivitySettlementDialog.access$4600(this.bcy).afP().a(new BitmapDrawable(this.bcy.getContext().getResources(), paramBitmap), n.b(PosActivitySettlementDialog.access$4800(this.bcy), 2131625101, this.bcy.onlinePayEntity.Fl()));
        aliPayPreorderDetail = aliPayPreorderDetail1;
      } 
    } else {
      aliPayPreorderDetail = null;
    } 
    if (aliPayPreorderDetail != null)
      this.bcy.onlinePayDialog.d(PosActivitySettlementDialog.access$700(this.bcy).a(paramBitmap, aliPayPreorderDetail)); 
  }
  
  public String xq() { return PosActivitySettlementDialog.access$4900(this.bcy); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */