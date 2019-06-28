package com.laiqian.product;

import com.laiqian.product.models.o;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.g;
import java.util.ArrayList;

class et extends Object implements g.c<o> {
  et(ServiceChargeActivity paramServiceChargeActivity) {}
  
  public void a(aq paramaq, ArrayList<o> paramArrayList) {
    StringBuilder stringBuilder2 = new StringBuilder();
    StringBuilder stringBuilder1 = new StringBuilder();
    if (ServiceChargeActivity.a(this.cTF) != null)
      stringBuilder2.append(ServiceChargeActivity.a(this.cTF)); 
    for (byte b = 0; b < paramArrayList.size(); b++) {
      ServiceChargeActivity serviceChargeActivity = this.cTF;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((o)paramArrayList.get(b)).getId());
      stringBuilder.append("");
      stringBuilder2 = serviceChargeActivity.a(stringBuilder2, stringBuilder.toString());
      stringBuilder1 = this.cTF.a(stringBuilder1, ((o)paramArrayList.get(b)).akZ());
    } 
    ServiceChargeActivity.a(this.cTF, stringBuilder2.toString());
    if (paramArrayList.size() == 0) {
      this.cTF.cTE.cTJ.setText("");
    } else {
      this.cTF.cTE.cTJ.setText(stringBuilder1.toString());
    } 
    ServiceChargeActivity.b(this.cTF).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */