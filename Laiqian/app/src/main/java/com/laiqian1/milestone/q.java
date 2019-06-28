package com.laiqian.milestone;

import android.app.AlertDialog;
import android.view.View;

class q implements View.OnClickListener {
  q(orderdetails paramorderdetails) {}
  
  public void onClick(View paramView) {
    orderdetails.bf(Long.parseLong(this.bLw.getSharedPreferences("settings", 0).getString("user_id", "-1")));
    (new AlertDialog.Builder(this.bLw)).setTitle(this.bLw.getString(2131625963)).setMessage(this.bLw.getString(2131625964)).setPositiveButton(this.bLw.getString(2131625975), new s(this)).setNegativeButton(this.bLw.getString(2131625967), new r(this)).create().show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */