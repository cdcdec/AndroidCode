package com.laiqian.member.f;

import android.view.View;
import com.laiqian.d.a;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;

class c implements View.OnClickListener {
  c(a parama) {}
  
  public void onClick(View paramView) {
    a.b b = (a.b)paramView.getTag();
    int i = b.aTv;
    if (i != 10001) {
      if (i != 10007) {
        if (i != 10009) {
          if (a.f(this.byH).isEmpty()) {
            n.println("没有其他支付。这里不会进来");
            return;
          } 
          if (a.f(this.byH).size() == 1) {
            a.b(this.byH);
            this.byH.byv = "10013";
            this.byH.byt = a.g(this.byH)[1];
            this.byH.byu = a.g(this.byH)[0];
            a.c(this.byH, b.aTv);
            return;
          } 
          a.a(this.byH, paramView);
          return;
        } 
        a.b(this.byH);
        this.byH.byt = a.c(this.byH).getString(R.string.pos_pay_WeChat);
        a a3 = this.byH;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(b.aTv);
        stringBuilder3.append("");
        a3.byv = stringBuilder3.toString();
        a.c(this.byH, b.aTv);
        i = a.AZ().Bq();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("PayTypeEntity.PAYTYPE_WECHAT type=");
        stringBuilder2.append(i);
        d.b(stringBuilder2.toString(), new Object[0]);
        if (this.byH.QP()) {
          if (a.e(this.byH)) {
            this.byH.byu = "370015";
            return;
          } 
          this.byH.byu = "370014";
          a.a(this.byH).dJ(false);
          return;
        } 
        if (i == 7) {
          this.byH.byu = "370014";
          return;
        } 
        this.byH.byu = "370015";
        a.a(this.byH).dJ(false);
        return;
      } 
      a.b(this.byH);
      this.byH.byt = a.c(this.byH).getString(R.string.pos_main_pay_payment_alipay);
      a a2 = this.byH;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(b.aTv);
      stringBuilder1.append("");
      a2.byv = stringBuilder1.toString();
      a.c(this.byH, b.aTv);
      i = a.AZ().Bo();
      if (this.byH.QP()) {
        if (a.d(this.byH)) {
          this.byH.byu = "370013";
          return;
        } 
        this.byH.byu = "370012";
        a.a(this.byH).dJ(false);
        return;
      } 
      if (i == 2) {
        this.byH.byu = "370012";
        return;
      } 
      this.byH.byu = "370013";
      a.a(this.byH).dJ(false);
      return;
    } 
    a.b(this.byH, b.aTv);
    a.b(this.byH);
    this.byH.byt = a.c(this.byH).getString(R.string.pos_main_pay_payment_cash);
    a a1 = this.byH;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.aTv);
    stringBuilder.append("");
    a1.byv = stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */