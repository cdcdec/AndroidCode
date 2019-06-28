package com.laiqian.pos;

import android.view.View;
import android.widget.AdapterView;

class ca implements AdapterView.OnItemClickListener {
  ca(ProductPictureManagementActivity paramProductPictureManagementActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    ProductPictureManagementActivity.c(this.chz, paramInt - ProductPictureManagementActivity.d(this.chz).getHeaderViewsCount());
    ProductPictureManagementActivity.b(this.chz, ProductPictureManagementActivity.e(this.chz));
    ProductPictureManagementActivity.c(this.chz).YQ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */