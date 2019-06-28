package com.laiqian.report.ui;

import android.text.TextUtils;
import com.laiqian.entity.z;
import com.laiqian.network.i;
import com.laiqian.report.a.a;
import com.laiqian.report.a.b;
import com.laiqian.report.k;
import com.laiqian.util.n;
import java.util.concurrent.TimeUnit;

class aa implements b.a {
  aa(OrderDetailsByReturn.a parama, z paramz) {}
  
  private void i(i parami) {
    k k = new k(this.deR.deB);
    a a1 = new a(this.deR.deB.productDocEntity.orderNo, this.deT.aTv);
    a1.a(new ab(this, k));
    k.df(TimeUnit.SECONDS.toMillis(10L));
    k.a(a1);
  }
  
  public void g(i parami) {
    if (OrderDetailsByReturn.a.a(this.deR)) {
      OrderDetailsByReturn.a.c(this.deR);
    } else if (!this.deR.deB.productDocEntity.amV()) {
      OrderDetailsByReturn.a.c(this.deR);
    } else {
      this.deR.deB.returnFull(this.deT);
    } 
    this.deR.gD(false);
    n.o(this.deR.deB.getApplication().getString(2131627746));
  }
  
  public void h(i parami) {
    this.deR.deB.dez = false;
    if (!TextUtils.isEmpty(parami.message)) {
      n.o(parami.message);
    } else {
      n.o(this.deR.deB.getApplication().getString(2131627747));
    } 
    if (b.f(parami)) {
      i(parami);
      return;
    } 
    this.deR.gD(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */