package com.laiqian.pos;

import com.laiqian.product.fa;

class bz implements fa.a {
  bz(ProductPictureManagementActivity paramProductPictureManagementActivity) {}
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {
    if (paramBoolean1) {
      ProductPictureManagementActivity.a(this.chz).YQ();
      ProductPictureManagementActivity.b(this.chz).cancel();
      int i = ProductPictureManagementActivity.a(this.chz).jy(paramString1);
      int j = ProductPictureManagementActivity.a(this.chz).YO();
      ProductPictureManagementActivity.a(this.chz, i + j + 1);
    } 
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt, boolean paramBoolean3) {
    if (paramBoolean1) {
      ProductPictureManagementActivity.a(this.chz).YQ();
      paramInt = ProductPictureManagementActivity.a(this.chz).jy(paramString1);
      ProductPictureManagementActivity.b(this.chz, paramInt);
      ProductPictureManagementActivity.b(this.chz).cancel();
      ProductPictureManagementActivity.a(this.chz, paramString2);
      ProductPictureManagementActivity.c(this.chz).YQ();
    } 
  }
  
  public void c(boolean paramBoolean, String paramString1, String paramString2) {
    if (paramBoolean) {
      ProductPictureManagementActivity.a(this.chz).YQ();
      ProductPictureManagementActivity.b(this.chz).cancel();
      ProductPictureManagementActivity.a(this.chz, ProductPictureManagementActivity.a(this.chz).YO());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */