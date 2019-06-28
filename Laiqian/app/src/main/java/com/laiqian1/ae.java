package com.laiqian;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.entity.n;
import com.laiqian.payment.R;
import com.laiqian.util.n;
import java.util.Date;

class ae implements View.OnClickListener {
  ae(ab paramab) {}
  
  public void onClick(View paramView) {
    if (this.aBs.aAD != null)
      this.aBs.aAD.stop(); 
    if (this.aBs.aAD != null && this.aBs.aAD.aBL.get()) {
      Toast.makeText(this.aBs.getContext(), R.string.pay_status_pending_result, 1).show();
      return;
    } 
    this.aBs.onlinePayEntity.da(n.a(true, new Date()));
    if (this.aBs.onlinePayEntity.Fp() != null)
      (this.aBs.onlinePayEntity.Fp()).orderNo = this.aBs.onlinePayEntity.xq(); 
    this.aBs.aAP.bk(this.aBs.onlinePayEntity.xq());
    Log.e("onSwitchPayTypeListener", this.aBs.onlinePayEntity.xq());
    int i = paramView.getId();
    int j = R.id.rl_barcode;
    long l = 7L;
    if (i == j) {
      this.aBs.aBj.setTextColor(this.aBs.aAA.getResources().getColor(R.color.pay_blue_color));
      this.aBs.aBl.setTextColor(this.aBs.aAA.getResources().getColor(R.color.label_text_color));
      this.aBs.aBn.setVisibility(8);
      this.aBs.aBm.setTextColor(this.aBs.aAA.getResources().getColor(R.color.label_text_color));
      this.aBs.aBi.setVisibility(8);
      if (this.aBs.onlinePayEntity.Fo() == 0L || this.aBs.onlinePayEntity.Fo() == 2L) {
        this.aBs.onlinePayEntity.ah(1L);
        a.AZ().dW(1);
      } else if (this.aBs.onlinePayEntity.Fo() == 8L || this.aBs.onlinePayEntity.Fo() == 7L) {
        this.aBs.onlinePayEntity.ah(5L);
        a.AZ().dX(5);
      } 
      this.aBs.xo();
      this.aBs.aAD.g(0, this.aBs.aAA.getString(R.string.pay_status_pending));
    } else if (i == R.id.rl_qrcode) {
      this.aBs.aBl.setTextColor(this.aBs.aAA.getResources().getColor(R.color.pay_blue_color));
      this.aBs.aBn.setVisibility(0);
      this.aBs.aBj.setTextColor(this.aBs.aAA.getResources().getColor(R.color.label_text_color));
      this.aBs.aBk.setVisibility(8);
      this.aBs.aBm.setTextColor(this.aBs.aAA.getResources().getColor(R.color.label_text_color));
      this.aBs.aBi.setVisibility(8);
      if (this.aBs.onlinePayEntity.Fo() == 1L || this.aBs.onlinePayEntity.Fo() == 2L) {
        this.aBs.onlinePayEntity.ah(0L);
        a.AZ().dW(0);
      } else if (this.aBs.onlinePayEntity.Fo() == 5L || this.aBs.onlinePayEntity.Fo() == 7L) {
        this.aBs.onlinePayEntity.ah(8L);
        a.AZ().dX(8);
      } 
      this.aBs.xl();
      if (this.aBs.aAD != null)
        this.aBs.aAD.wQ(); 
      this.aBs.aAD.g(0, this.aBs.aAA.getString(R.string.pay_status_pending));
    } else if (i == R.id.rl_account) {
      this.aBs.aBl.setTextColor(this.aBs.aAA.getResources().getColor(R.color.label_text_color));
      this.aBs.aBn.setVisibility(8);
      this.aBs.aBj.setTextColor(this.aBs.aAA.getResources().getColor(R.color.label_text_color));
      this.aBs.aBk.setVisibility(8);
      this.aBs.aBm.setTextColor(this.aBs.aAA.getResources().getColor(R.color.pay_blue_color));
      this.aBs.aBi.setVisibility(0);
      n n = this.aBs.onlinePayEntity;
      if (this.aBs.aAZ)
        l = 2L; 
      n.ah(l);
      this.aBs.xp();
    } 
    this.aBs.aAP.a(this.aBs.onlinePayEntity.Fo(), this.aBs.onlinePayEntity.Fj());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */