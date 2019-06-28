package com.laiqian;

import android.util.Log;
import android.view.View;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.n;
import com.laiqian.payment.R;
import com.laiqian.util.n;
import java.util.Date;

class al implements View.OnClickListener {
  al(ag paramag) {}
  
  public void onClick(View paramView) {
    if (ag.d(this.aBv) != null)
      ag.d(this.aBv).stop(); 
    ag.b(this.aBv).da(n.a(true, new Date()));
    if (ag.b(this.aBv).Fp() != null)
      (ag.b(this.aBv).Fp()).orderNo = ag.b(this.aBv).xq(); 
    ag.a(this.aBv).bk(ag.b(this.aBv).xq());
    Log.e("onSwitchPayTypeListener", ag.b(this.aBv).xq());
    int i = paramView.getId();
    int j = R.id.rl_barcode;
    long l = 7L;
    if (i == j) {
      this.aBv.aBj.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.pay_blue_color));
      if (!a.zR().Ak())
        this.aBv.aBk.setVisibility(0); 
      this.aBv.aBl.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.label_text_color));
      this.aBv.aBn.setVisibility(8);
      this.aBv.aBm.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.label_text_color));
      this.aBv.aBi.setVisibility(8);
      if (ag.b(this.aBv).Fo() == 0L || ag.b(this.aBv).Fo() == 2L) {
        ag.b(this.aBv).ah(1L);
        a.AZ().dW(1);
      } else if (ag.b(this.aBv).Fo() == 8L || ag.b(this.aBv).Fo() == 7L) {
        ag.b(this.aBv).ah(5L);
        a.AZ().dX(5);
      } 
      this.aBv.xo();
      ag.d(this.aBv).g(0, ag.c(this.aBv).getString(R.string.pay_status_pending));
    } else if (i == R.id.rl_qrcode) {
      this.aBv.aBl.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.pay_blue_color));
      this.aBv.aBn.setVisibility(0);
      this.aBv.aBj.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.label_text_color));
      this.aBv.aBk.setVisibility(8);
      this.aBv.aBm.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.label_text_color));
      this.aBv.aBi.setVisibility(8);
      if (ag.b(this.aBv).Fo() == 1L || ag.b(this.aBv).Fo() == 2L) {
        ag.b(this.aBv).ah(0L);
        a.AZ().dW(0);
      } else if (ag.b(this.aBv).Fo() == 5L || ag.b(this.aBv).Fo() == 7L) {
        ag.b(this.aBv).ah(8L);
        a.AZ().dX(8);
      } 
      this.aBv.xl();
      if (ag.d(this.aBv) != null)
        ag.d(this.aBv).wQ(); 
      ag.d(this.aBv).g(0, ag.c(this.aBv).getString(R.string.pay_status_pending));
    } else if (i == R.id.rl_account) {
      this.aBv.aBl.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.label_text_color));
      this.aBv.aBn.setVisibility(8);
      this.aBv.aBj.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.label_text_color));
      this.aBv.aBk.setVisibility(8);
      this.aBv.aBm.setTextColor(ag.c(this.aBv).getResources().getColor(R.color.pay_blue_color));
      this.aBv.aBi.setVisibility(0);
      n n = ag.b(this.aBv);
      if (this.aBv.aAZ)
        l = 2L; 
      n.ah(l);
      this.aBv.xp();
    } 
    ag.a(this.aBv).a(ag.b(this.aBv).Fo(), ag.b(this.aBv).Fj());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */