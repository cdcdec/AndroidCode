package com.laiqian.product;

import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.g;
import java.util.ArrayList;

class bx extends Object implements g.c<ProductTypeEntity> {
  bx(bq parambq) {}
  
  public void a(aq paramaq, ArrayList<ProductTypeEntity> paramArrayList) {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    for (byte b = 0; b < paramArrayList.size(); b++) {
      if (b)
        stringBuilder1.append(","); 
      stringBuilder1.append(((ProductTypeEntity)paramArrayList.get(b)).aSW);
      if (b != 0)
        stringBuilder2.append(","); 
      stringBuilder2.append(((ProductTypeEntity)paramArrayList.get(b)).name);
    } 
    bq.a(this.cQz, stringBuilder1.toString());
    if (paramArrayList.size() == bq.n(this.cQz).size() || paramArrayList.size() == 0) {
      bq.o(this.cQz).setText(2131627613);
    } else {
      bq.o(this.cQz).setText(stringBuilder2.toString());
    } 
    bq.k(this.cQz).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */