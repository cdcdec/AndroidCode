package com.laiqian.product;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.product.models.m;

class ek implements AdapterView.OnItemClickListener {
  ek(RawMaterialListActivity paramRawMaterialListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    m m = (m)paramAdapterView.getItemAtPosition(paramInt);
    if (m != null) {
      (RawMaterialListActivity.b(this.cTg)).object = m;
      RawMaterialListActivity.b(this.cTg).show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */