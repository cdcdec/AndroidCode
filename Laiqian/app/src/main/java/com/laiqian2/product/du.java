package com.laiqian.product;

import com.laiqian.main.d;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.g;
import java.util.ArrayList;

class du extends Object implements g.c<d> {
  du(ProductTaxRuleEditActivity paramProductTaxRuleEditActivity) {}
  
  public void a(aq paramaq, ArrayList<d> paramArrayList) {
    StringBuilder stringBuilder2 = new StringBuilder();
    StringBuilder stringBuilder1 = new StringBuilder();
    for (byte b = 0; b < paramArrayList.size(); b++) {
      ProductTaxRuleEditActivity productTaxRuleEditActivity = this.cSG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((d)paramArrayList.get(b)).getId());
      stringBuilder.append("");
      stringBuilder2 = productTaxRuleEditActivity.a(stringBuilder2, stringBuilder.toString());
      stringBuilder1 = this.cSG.a(stringBuilder1, ((d)paramArrayList.get(b)).KI());
    } 
    ProductTaxRuleEditActivity.a(this.cSG, stringBuilder2.toString());
    if (paramArrayList.size() == ProductTaxRuleEditActivity.a(this.cSG).size() || paramArrayList.size() == 0) {
      ProductTaxRuleEditActivity.a.a(this.cSG.cSx).setText(2131627613);
    } else {
      ProductTaxRuleEditActivity.a.a(this.cSG.cSx).setText(stringBuilder1.toString());
    } 
    ProductTaxRuleEditActivity.b(this.cSG).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */