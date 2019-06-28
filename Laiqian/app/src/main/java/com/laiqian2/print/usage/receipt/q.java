package com.laiqian.print.usage.receipt;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class q implements w.a {
  q(ReceiptPreviewActivity paramReceiptPreviewActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        ReceiptPreviewActivity.f(this.cNl).iB(2);
        return;
      case 0:
        break;
    } 
    ReceiptPreviewActivity.f(this.cNl).iB(1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\receipt\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */