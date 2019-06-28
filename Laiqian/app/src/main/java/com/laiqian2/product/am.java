package com.laiqian.product;

class am implements ProductAttributeActivity.a.a {
  am(ProductAttributeActivity paramProductAttributeActivity) {}
  
  public void d(ProductAttributeActivity.d.a parama) {
    if (((Integer)parama.cQn.cUp.getValue()).intValue() > 0) {
      parama.cQn.js(0);
      return;
    } 
    parama.cQn.js(1);
  }
  
  public void e(ProductAttributeActivity.d.a parama) { parama.cQn.js(((Integer)parama.cQn.cUp.getValue()).intValue() + 1); }
  
  public void f(ProductAttributeActivity.d.a parama) {
    int i = ((Integer)parama.cQn.cUp.getValue()).intValue();
    if (i > 0)
      parama.cQn.js(i - 1); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */