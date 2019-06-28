package com.laiqian.member.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.laiqian.c.a;
import com.laiqian.o;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class h implements o.a {
  h(a parama, String paramString) {}
  
  public void a(long paramLong, boolean paramBoolean) {
    if (a.zR().At())
      this.bwR.bwG.bys.aTv = PayTypeSpecific.co(paramLong); 
    this.bwR.bwG.aC(paramLong);
    this.bwR.bwG.resetFirstPayTypeItemView(paramLong);
    if (this.bwR.bwG.bys.aTe == 5L || this.bwR.bwG.bys.aTe == 1L)
      a.b(this.bwR, true); 
  }
  
  public void bk(String paramString) { a.a(this.bwR, paramString); }
  
  public void bl(String paramString) {
    if (a.g(this.bwR))
      this.bwR.QD(); 
  }
  
  public void f(int paramInt, String paramString) {
    if (paramInt == 2 && a.g(this.bwR))
      this.bwR.dI(true); 
  }
  
  public void o(Bitmap paramBitmap) {
    if (this.bwR.bwG.bys.aTe == 8L) {
      if (a.d(this.bwR).afM() != null)
        a.d(this.bwR).afM().afP().b(new BitmapDrawable(this.bwR.getContext().getResources(), paramBitmap), n.b(a.e(this.bwR), R.string.dual_screen_alipay_qrcode_actual_pay, this.bwT)); 
    } else if (this.bwR.bwG.bys.aTe == 0L) {
      if (a.d(this.bwR).afM() != null)
        a.d(this.bwR).afM().afP().a(new BitmapDrawable(this.bwR.getContext().getResources(), paramBitmap), n.b(a.f(this.bwR), R.string.dual_screen_alipay_qrcode_actual_pay, this.bwT)); 
    } 
    this.bwR.onlinePayDialog.d(a.a(this.bwR, paramBitmap));
  }
  
  public String xq() { return a.h(this.bwR); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */