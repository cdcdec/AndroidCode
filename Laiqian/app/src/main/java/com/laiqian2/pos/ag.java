package com.laiqian.pos;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.laiqian.d.a;

class ag implements View.OnClickListener {
  ag(PayTypeSelectSpecific paramPayTypeSelectSpecific) {}
  
  public void onClick(View paramView) {
    if (PayTypeSelectSpecific.a(this.cfE)) {
      PayTypeSelectSpecific.a(this.cfE, paramView);
      return;
    } 
    if (PayTypeSelectSpecific.b(this.cfE)) {
      if (PayTypeSelectSpecific.c(this.cfE)) {
        Class clazz;
        boolean bool = "5".equals(String.valueOf(a.AZ().Bp()));
        PayTypeSelectSpecific payTypeSelectSpecific1 = this.cfE;
        PayTypeSelectSpecific payTypeSelectSpecific2 = this.cfE;
        if (bool) {
          clazz = com.laiqian.binding.BindingAlipayHelp.class;
        } else {
          clazz = com.laiqian.binding.BindingAlipaySelectActivity.class;
        } 
        payTypeSelectSpecific1.startActivity(new Intent(payTypeSelectSpecific2, clazz));
        return;
      } 
      this.cfE.startActivity(new Intent(this.cfE, com.laiqian.binding.BindingWechatSelectActivity.class));
      return;
    } 
    Toast.makeText(this.cfE, "非老板账号，无权限！", 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */