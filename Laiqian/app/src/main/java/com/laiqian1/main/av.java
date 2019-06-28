package com.laiqian.main;

import com.laiqian.product.fa;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.l;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.ax;
import com.laiqian.util.n;

class av extends Object implements aq.a<CharSequence> {
  av(au paramau) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    ProductTypeEntity productTypeEntity = (ProductTypeEntity)((ax)paramaq).getObject();
    if (paramInt == 0) {
      paramCharSequence = ar.c(this.bbO.bbM).VE();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(productTypeEntity.aSW);
      stringBuilder.append("");
      if (paramCharSequence.equals(stringBuilder.toString())) {
        n.eP(2131627645);
        return;
      } 
      fa fa = (fa)ar.d(this.bbO.bbM).get();
      stringBuilder = new StringBuilder();
      stringBuilder.append(productTypeEntity.aSW);
      stringBuilder.append("");
      fa.a(stringBuilder.toString(), productTypeEntity.name, productTypeEntity.cpm, productTypeEntity.cVb, null);
      return;
    } 
    if (paramInt == 1) {
      if (ar.e(this.bbO.bbM).isEmpty() || (ProductTypeEntity)ar.e(this.bbO.bbM).get(false) == null) {
        n.println("商品类型数据集是空白，或者第1个是空白。这里不会进来");
        return;
      } 
      l l = new l(ar.a(this.bbO.bbM));
      boolean bool = l.a(productTypeEntity, l.akR());
      l.close();
      if (bool) {
        ar.e(this.bbO.bbM).remove(productTypeEntity);
        ar.a(this.bbO.bbM, 1);
        ar.a(this.bbO.bbM, productTypeEntity);
        ar.e(this.bbO.bbM).add(0, productTypeEntity);
        ar.f(this.bbO.bbM);
        return;
      } 
      n.a(ar.a(this.bbO.bbM), "商品类型置顶失败");
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */