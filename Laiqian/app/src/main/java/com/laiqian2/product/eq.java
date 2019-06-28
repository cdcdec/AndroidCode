package com.laiqian.product;

import android.view.View;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Iterator;

class eq implements View.OnClickListener {
  eq(eo parameo) {}
  
  public void onClick(View paramView) {
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    eo.a(this.cTz).aks();
    for (byte b = 0; b < eo.b(this.cTz).length; b++) {
      null = eo.b(this.cTz)[b];
      int i = eo.c(this.cTz)[b];
      if (null.size() != i) {
        n.eP(2131627543);
        return;
      } 
      Iterator iterator = null.iterator();
      while (iterator.hasNext()) {
        eo.a a = (eo.a)((View)iterator.next()).getTag();
        arrayList1.add(Long.valueOf(a.cTA));
        arrayList2.add(a.bjG.getText().toString());
      } 
    } 
    eo.a(this.cTz).a(null, arrayList1, arrayList2);
    eo.a(this.cTz).akt();
    eo.d(this.cTz).a(eo.a(this.cTz));
    this.cTz.cancel();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */