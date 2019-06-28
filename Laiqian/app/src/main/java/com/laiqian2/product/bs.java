package com.laiqian.product;

import android.view.View;

class bs implements View.OnClickListener {
  bs(bq parambq) {}
  
  public void onClick(View paramView) {
    bq.g(this.cQz).requestFocus();
    if (bq.a(this.cQz) == 0L) {
      bq.h(this.cQz).gn(0);
    } else if (bq.a(this.cQz) == 4L) {
      bq.h(this.cQz).gn(1);
    } else if (bq.a(this.cQz) == 3L) {
      bq.h(this.cQz).gn(3);
    } else if (bq.a(this.cQz) == 1L) {
      bq.h(this.cQz).gn(2);
    } 
    bq.h(this.cQz).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */