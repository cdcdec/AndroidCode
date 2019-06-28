package com.laiqian.main.module.producttype;

import com.laiqian.main.ar;
import com.laiqian.main.dl;
import com.laiqian.product.models.ProductTypeEntity;
import java.util.ArrayList;

class e implements ar.a {
  e(PosActivityProductTypeFragment paramPosActivityProductTypeFragment) {}
  
  public void a(ProductTypeEntity paramProductTypeEntity) {
    if (paramProductTypeEntity != null) {
      this.blp.bfr.c(paramProductTypeEntity);
      return;
    } 
    this.blp.bfr.c(dl.beo);
  }
  
  public void b(ProductTypeEntity paramProductTypeEntity) {
    if (paramProductTypeEntity != null) {
      this.blp.bfr.c(paramProductTypeEntity);
      return;
    } 
    this.blp.bfr.c(dl.beo);
  }
  
  public void t(ArrayList<ProductTypeEntity> paramArrayList) {
    this.blp.bfr.bdH.r(paramArrayList);
    this.blp.bfr.LW();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\producttype\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */