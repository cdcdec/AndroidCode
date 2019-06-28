package com.laiqian.member.setting.marketing;

import android.widget.TextView;
import com.laiqian.ui.a.aq;

class a extends Object implements aq.a<CharSequence> {
  a(DiscountMarketActivity paramDiscountMarketActivity) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    paramaq.kR(paramInt);
    DiscountMarketActivity.a(this.bED, paramInt);
    ((TextView)(DiscountMarketActivity.a(this.bED)).bEH.dwP.getView()).setText(paramCharSequence);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */