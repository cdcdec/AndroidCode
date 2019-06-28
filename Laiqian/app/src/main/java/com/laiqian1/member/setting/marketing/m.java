package com.laiqian.member.setting.marketing;

import android.annotation.TargetApi;
import android.widget.EditText;
import com.laiqian.ui.a.aq;

class m extends Object implements aq.a<CharSequence> {
  m(DiscountMarketActivity paramDiscountMarketActivity) {}
  
  @TargetApi(16)
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    ((EditText)(DiscountMarketActivity.a(this.bED)).bEG.dwQ.getView()).setSelected(false);
    ((EditText)(DiscountMarketActivity.a(this.bED)).bEG.dwQ.getView()).setCursorVisible(false);
    DiscountMarketActivity.a.a(DiscountMarketActivity.a(this.bED)).setText(DiscountMarketActivity.a(this.bED, paramCharSequence.toString()));
    DiscountMarketActivity.b(this.bED, paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */