package com.laiqian.member.d;

import com.laiqian.util.e;
import com.laiqian.vip.R;
import java.io.File;

class g extends e {
  g(a parama, e.a parama1, String paramString1, String paramString2) { super(parama1, paramString1); }
  
  public void a(e parame, String paramString) {
    this.bxV.bxS.bAd = this.bxV.userName;
    this.bxV.bxS.bAe = this.bxV.bxT;
    this.bxV.bxS.a(this.bxV.aIG, this.bxV.bqs[0], this.bxV.bqs[1]);
    File file = new File(this.bxV.bxS.Tf());
    if (file.exists()) {
      if (this.bxX.contains("mail") || this.bxX.indexOf("@") > 0) {
        paramString = this.bxV.context.getString(R.string.pos_report_export_mail_send_suc);
        this.bxV.b(this.bxX, this.bxV.bxS.AX(), new String[] { this.bxV.bxS.Tf() });
      } else {
        paramString = this.bxV.context.getString(R.string.pos_report_export_u_suc);
        this.bxV.b(this.bxX, file);
      } 
      parame.dEQ = paramString;
      parame.lr(parame.dEM);
      return;
    } 
    if (this.bxX.contains("mail")) {
      paramString = this.bxV.context.getString(R.string.pos_report_export_mail_send_fail);
    } else {
      paramString = this.bxV.context.getString(R.string.pos_report_export_u_fail);
    } 
    parame.dEQ = paramString;
    parame.lr(parame.dEN);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */