package com.laiqian.member.create;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.laiqian.c.a;
import com.laiqian.entity.aq;
import com.laiqian.o;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class o implements o.a {
  o(VipCreateDialog paramVipCreateDialog, String paramString) {}
  
  public void a(long paramLong, boolean paramBoolean) {
    if (a.zR().At())
      this.bxz.bwG.bys.aTv = PayTypeSpecific.co(paramLong); 
    this.bxz.bwG.aC(paramLong);
    this.bxz.bwG.resetFirstPayTypeItemView(paramLong);
    if (this.bxz.bwG.bys.aTe == 5L || this.bxz.bwG.bys.aTe == 1L)
      VipCreateDialog.a(this.bxz, true); 
  }
  
  public void bk(String paramString) { VipCreateDialog.a(this.bxz, paramString); }
  
  public void bl(String paramString) {
    this.bxz.bxc = new VipCreateDialog.b(this.bxz);
    this.bxz.bxc.execute(new aq[] { this.bxz.QF() });
  }
  
  public void f(int paramInt, String paramString) {
    if (paramInt == 2) {
      this.bxz.bxc = new VipCreateDialog.b(this.bxz);
      this.bxz.bxc.execute(new aq[] { this.bxz.QF() });
    } 
  }
  
  public void o(Bitmap paramBitmap) {
    this.bxz.onlinePayDialog.d(VipCreateDialog.a(this.bxz, paramBitmap));
    if (this.bxz.bwG.bys.aTe == 8L) {
      if (VipCreateDialog.I(this.bxz).afM() != null) {
        VipCreateDialog.I(this.bxz).afM().afP().b(new BitmapDrawable(this.bxz.getContext().getResources(), paramBitmap), n.b(VipCreateDialog.J(this.bxz), R.string.dual_screen_alipay_qrcode_actual_pay, this.bwT));
        return;
      } 
    } else if (this.bxz.bwG.bys.aTe == 0L) {
      if (VipCreateDialog.I(this.bxz).afM() != null)
        VipCreateDialog.I(this.bxz).afM().afP().a(new BitmapDrawable(this.bxz.getContext().getResources(), paramBitmap), n.b(VipCreateDialog.K(this.bxz), R.string.dual_screen_alipay_qrcode_actual_pay, this.bwT)); 
    } 
  }
  
  public String xq() { return VipCreateDialog.L(this.bxz); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */