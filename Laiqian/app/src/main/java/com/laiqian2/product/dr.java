package com.laiqian.product;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.laiqian.product.models.o;

class dr implements AdapterView.OnItemClickListener {
  dr(ProductTaxRuleActivity paramProductTaxRuleActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt > 0) {
      o o = (o)ProductTaxRuleActivity.a(this.cSi).getItemAtPosition(paramInt);
      Intent intent = new Intent(this.cSi.getApplication(), ProductTaxRuleEditActivity.class);
      intent.putExtra("taxid", o.getId());
      this.cSi.startActivityForResult(intent, 2);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */