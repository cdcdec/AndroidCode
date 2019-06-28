package com.laiqian.member.setting.marketing;

import android.text.SpannableStringBuilder;
import android.util.Log;
import android.widget.TextView;
import com.laiqian.vip.R;

class s implements ac.a {
  s(DiscountMarketActivity paramDiscountMarketActivity) {}
  
  public void g(String paramString, int paramInt) {
    SpannableStringBuilder spannableStringBuilder = DiscountMarketActivity.a(this.bED, this.bED.getString(R.string.vip_promotion_defalut_sign), paramString, this.bED.aVs);
    (DiscountMarketActivity.a(this.bED)).bEE.setText(spannableStringBuilder);
    TextView textView = DiscountMarketActivity.a.e(DiscountMarketActivity.a(this.bED));
    String str = this.bED.getString(R.string.vip_promotion_sms_length);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(spannableStringBuilder.toString().length());
    stringBuilder2.append("");
    textView.setText(String.format(str, new Object[] { stringBuilder2.toString() }));
    DiscountMarketActivity.a.d(DiscountMarketActivity.a(this.bED)).setText(DiscountMarketActivity.a(this.bED, paramString));
    DiscountMarketActivity.a.f(DiscountMarketActivity.a(this.bED)).setText(DiscountMarketActivity.b(this.bED, String.valueOf((int)Math.ceil(spannableStringBuilder.toString().length() / 69.0D))).format(this.bED.getString(R.string.vip_promotion_sms_amount), new Object[] { DiscountMarketActivity.e(this.bED) }));
    paramString = DiscountMarketActivity.St();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("onTextChanged -->");
    stringBuilder1.append(spannableStringBuilder.toString());
    Log.i(paramString, stringBuilder1.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */