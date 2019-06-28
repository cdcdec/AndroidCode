package com.laiqian.member;

import android.widget.Toast;
import com.laiqian.pos.s;
import com.laiqian.vip.R;

class bw implements s.a {
  bw(bs parambs, String paramString) {}
  
  public void Qo() {
    this.bvW.bvO.cancel();
    Toast.makeText(bs.b(this.bvW), bs.b(this.bvW).getString(R.string.pos_download_transaction_data_failure), 1).show();
  }
  
  public void fr(int paramInt) {}
  
  public void onSuccess() { bs.a(this.bvW, this.bvX); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */