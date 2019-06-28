package com.laiqian.product;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.product.models.n;

class ei implements AdapterView.OnItemClickListener {
  ei(RawMaterialListActivity paramRawMaterialListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    n n = (n)paramAdapterView.getItemAtPosition(paramInt);
    RawMaterialListActivity.a(this.cTg, n);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */