package com.laiqian.warehouse;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

class n implements View.OnClickListener {
  n(Warehouse_details paramWarehouse_details) {}
  
  public void onClick(View paramView) {
    if (Warehouse_details.a(this.dMl) != 0L) {
      (new AlertDialog.Builder(this.dMl)).setTitle(this.dMl.getString(2131625963)).setMessage(this.dMl.getString(2131625964)).setPositiveButton(this.dMl.getString(2131625975), new p(this)).setNegativeButton(this.dMl.getString(2131625967), new o(this)).create().show();
      return;
    } 
    Toast.makeText(this.dMl.getApplicationContext(), this.dMl.getString(2131630601), 1000).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */