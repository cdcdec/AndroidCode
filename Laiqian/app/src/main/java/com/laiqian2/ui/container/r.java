package com.laiqian.ui.container;

import android.text.Html;
import android.util.Pair;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import io.reactivex.c.g;

class r extends Object implements g<Pair<Double, Double>> {
  r(q paramq) {}
  
  public void b(Pair<Double, Double> paramPair) throws Exception {
    if (((Double)paramPair.first).doubleValue() < 0.0D) {
      if (((Double)paramPair.first).doubleValue() == -1.0D) {
        Toast.makeText(LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu), LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu).getString(R.string.account_verify_failed), 0).show();
        return;
      } 
      if (((Double)paramPair.first).doubleValue() == -2.0D) {
        Toast.makeText(LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu), LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu).getString(R.string.code_error_try_again), 0).show();
        return;
      } 
      if (((Double)paramPair.first).doubleValue() == -3.0D)
        Toast.makeText(LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu), LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu).getString(R.string.coupon_time_used_up), 0).show(); 
      return;
    } 
    LayoutLeftTextRightLabelWithAddButton.a(this.dxx.dxw.dxu).setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<font color=\"#df554a\">%1$s");
    stringBuilder.append(LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu).getString(R.string.money_unit));
    stringBuilder.append("</font>");
    stringBuilder.append(LayoutLeftTextRightLabelWithAddButton.b(this.dxx.dxw.dxu).getString(R.string.coupon));
    String str;
    LayoutLeftTextRightLabelWithAddButton.a(this.dxx.dxw.dxu, Html.fromHtml((str = stringBuilder.toString()).format(str, new Object[] { paramPair.first })));
    this.dxx.dxv.dismiss();
    if (LayoutLeftTextRightLabelWithAddButton.c(this.dxx.dxw.dxu) != null)
      LayoutLeftTextRightLabelWithAddButton.c(this.dxx.dxw.dxu).d(paramPair); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */