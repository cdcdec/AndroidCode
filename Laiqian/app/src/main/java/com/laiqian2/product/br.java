package com.laiqian.product;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class br implements w.a {
  br(bq parambq) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      case 3:
        bq.a(this.cQz, 3L);
        break;
      case 2:
        bq.a(this.cQz, 1L);
        break;
      case 1:
        bq.a(this.cQz, 4L);
        break;
      case 0:
        bq.a(this.cQz, 0L);
        break;
    } 
    bq.b(this.cQz).setText(bq.b(this.cQz, bq.a(this.cQz)));
    bq.c(this.cQz).setVisibility(0);
    bq.d(this.cQz).setText(bq.c(this.cQz, bq.a(this.cQz)));
    if (bq.a(this.cQz) == 3L) {
      bq.e(this.cQz).setText("50");
      bq.f(this.cQz).setVisibility(0);
      return;
    } 
    bq.e(this.cQz).setText("0");
    bq.f(this.cQz).setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */