package com.laiqian.pos;

import android.content.Intent;
import android.view.View;

class cg implements View.OnClickListener {
  cg(ProductPictureManagementActivity.a parama, ProductPictureManagementActivity paramProductPictureManagementActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.chG.chz, com.laiqian.product.ProductList.class);
    intent.putExtra("productIDs", this.chG.chz.ZR());
    this.chG.chz.startActivityForResult(intent, 2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */