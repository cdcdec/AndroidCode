package com.laiqian.product;

class dg implements fa.a {
  dg(ProductList paramProductList) {}
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {
    if (paramBoolean1) {
      ProductList.a(this.cRN).YQ();
      ProductList.b(this.cRN).cancel();
      int i = ProductList.a(this.cRN).jy(paramString1);
      ProductList.a(this.cRN, i);
    } 
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt, boolean paramBoolean3) {
    if (paramBoolean1) {
      ProductList.a(this.cRN).YQ();
      ProductList.b(this.cRN).cancel();
      ProductList.a(this.cRN, paramString2);
      ProductList.b(this.cRN, paramBoolean2);
      ProductList.c(this.cRN).YQ();
    } 
  }
  
  public void c(boolean paramBoolean, String paramString1, String paramString2) {
    if (paramBoolean) {
      ProductList.a(this.cRN).YQ();
      ProductList.b(this.cRN).cancel();
      ProductList.a(this.cRN, ProductList.a(this.cRN).YO());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */