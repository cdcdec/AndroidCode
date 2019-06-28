package com.laiqian.member;

import android.content.Intent;
import android.widget.Toast;
import com.laiqian.vip.R;

class s implements Runnable {
  s(r paramr) {}
  
  public void run() {
    MemberChangeActivity.k(this.btv.btu.btt.btq).dismiss();
    Toast.makeText(this.btv.btu.btt.btq, this.btv.btu.btt.btq.getString(R.string.pos_delete_successfully), 0).show();
    Intent intent = new Intent(this.btv.btu.btt.btq, MemberListActivity.class);
    this.btv.btu.btt.btq.startActivity(intent);
    this.btv.btu.btt.btq.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */