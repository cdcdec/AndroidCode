package com.laiqian.takeaway;

import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.ui.a.r;

class h implements al.b {
  h(AbstractPosMainTakeOut paramAbstractPosMainTakeOut) {}
  
  public void aqq() {}
  
  public void b(String paramString1, String paramString2, String paramString3, TakeOrderEntity paramTakeOrderEntity, String paramString4) {
    r r;
    if (("eleme".equals(paramString2) || "meituan".equals(paramString2)) && ("agree".equals(paramString3) || "reject".equals(paramString3) || "wxrefund".equals(paramString3))) {
      r = new r(this.drG, new i(this, paramString1, paramString2, paramString3, paramTakeOrderEntity, paramString4));
      r.setTitle(this.drG.getString(R.string.crash_m_dialog_t));
      r.s(this.drG.getString(R.string.are_you_sure));
      r.oZ(this.drG.getString(R.string.pos_alipay_yes));
      r.t(this.drG.getString(R.string.pos_alipay_no));
      r.show();
      return;
    } 
    AbstractPosMainTakeOut.a(this.drG, r, paramString2, paramString3, paramTakeOrderEntity, paramString4);
  }
  
  public void ku(int paramInt) {
    this.drG.drt = 1;
    AbstractPosMainTakeOut.a(this.drG, "");
    AbstractPosMainTakeOut.a(this.drG, 0.0D);
    if (AbstractPosMainTakeOut.B(this.drG))
      AbstractPosMainTakeOut.C(this.drG).clear(); 
    AbstractPosMainTakeOut.a(this.drG, AbstractPosMainTakeOut.j(this.drG).j(AbstractPosMainTakeOut.f(this.drG), 5, this.drG.drt));
    this.drG.a(null, new int[0]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */