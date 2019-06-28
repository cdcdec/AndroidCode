package com.laiqian.main.module.productpool;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.product.models.h;
import com.laiqian.util.n;

class t implements AdapterView.OnItemClickListener {
  t(p paramp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    h h = (h)paramAdapterView.getItemAtPosition(paramInt);
    if (h != null) {
      p.d(this.bla).e(h);
      n.j(p.a(this.bla));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productpool\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */