package com.laiqian.pos.industry.weiorder;

import android.widget.TextView;
import com.laiqian.product.models.o;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.g;
import java.util.ArrayList;

class fz extends Object implements g.c<o> {
  fz(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void a(aq paramaq, ArrayList<o> paramArrayList) {
    StringBuilder stringBuilder2 = new StringBuilder();
    StringBuilder stringBuilder1 = new StringBuilder();
    if (WeshopMarketingFragment.c(this.cwC) != null)
      stringBuilder2.append(WeshopMarketingFragment.c(this.cwC)); 
    for (byte b = 0; b < paramArrayList.size(); b++) {
      WeshopMarketingFragment weshopMarketingFragment = this.cwC;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((o)paramArrayList.get(b)).getId());
      stringBuilder.append("");
      stringBuilder2 = weshopMarketingFragment.a(stringBuilder2, stringBuilder.toString());
      stringBuilder1 = this.cwC.a(stringBuilder1, ((o)paramArrayList.get(b)).akZ());
    } 
    WeshopMarketingFragment.a(this.cwC, stringBuilder2.toString());
    if (paramArrayList.size() == 0) {
      ((TextView)this.cwC.cwv.cwV.getView()).setText("");
    } else {
      ((TextView)this.cwC.cwv.cwV.getView()).setText(stringBuilder1.toString());
    } 
    WeshopMarketingFragment.d(this.cwC).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */