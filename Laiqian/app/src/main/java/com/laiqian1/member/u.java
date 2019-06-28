package com.laiqian.member;

import android.content.Intent;
import android.widget.Toast;
import com.laiqian.vip.R;

class u implements Runnable {
  u(t paramt) {}
  
  public void run() {
    Intent intent = new Intent(this.bty.btx.btq, MemberInfoActivity.class);
    intent.putExtra("id", (MemberChangeActivity.j(this.bty.btx.btq)).aSW);
    intent.putExtra("nBelongShopID", String.valueOf((MemberChangeActivity.j(this.bty.btx.btq)).aWC));
    this.bty.btx.btq.startActivity(intent);
    this.bty.btx.btq.finish();
    Toast.makeText(this.bty.btx.btq, this.bty.btx.btq.getString(R.string.poj_success_update), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\membe\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */