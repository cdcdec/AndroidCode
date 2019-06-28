package com.laiqian.takeaway;

import android.view.View;
import android.widget.Toast;
import com.laiqian.ui.a.r;

class ah implements View.OnClickListener {
  ah(y paramy, int paramInt, String paramString) {}
  
  public void onClick(View paramView) {
    if (!y.a(this.dsf).Gk()) {
      Toast.makeText(y.b(this.dsf), R.string.pos_no_permission, 0).show();
      return;
    } 
    r r = new r(y.b(this.dsf), new ai(this));
    r.s(y.b(this.dsf).getString(R.string.pos_phone_order_reject));
    r.setTitle(y.b(this.dsf).getString(R.string.new_pos_confirm_title));
    r.arm().setText(y.b(this.dsf).getString(R.string.lqj_cancel));
    r.arn().setText(y.b(this.dsf).getString(R.string.lqj_ok));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */