package com.laiqian.member.setting.credit;

import android.content.Context;
import com.laiqian.d.a;
import com.laiqian.util.n;
import com.laiqian.vip.R;

public class d {
  private e bDd;
  
  a bDe;
  
  a bDf;
  
  private Context mContext;
  
  public d(Context paramContext, e parame) {
    this.mContext = paramContext;
    this.bDd = parame;
  }
  
  public boolean Az() { return (this.bDf != null) ? ((this.bDe == null) ? false : (!this.bDf.equals(this.bDe))) : false; }
  
  public void RY() {
    this.bDd.dU(this.bDe.bCX);
    this.bDd.ao(this.bDe.aEt);
  }
  
  public void ao(double paramDouble) { this.bDf.aEt = paramDouble; }
  
  public void dU(boolean paramBoolean) { this.bDf.bCX = paramBoolean; }
  
  public void init() {
    this.bDe = new a();
    this.bDe.aEt = a.AZ().Bv();
    this.bDe.bCX = a.AZ().Bu();
    this.bDf = this.bDe.RW();
    RY();
  }
  
  public void save() {
    a.AZ().bN(this.bDf.bCX);
    a.AZ().e(this.bDf.aEt);
    this.bDe = this.bDf.RW();
    n.eP(R.string.save_success);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\credit\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */