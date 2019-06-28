package com.laiqian.warehouse;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

class f implements View.OnClickListener {
  f(WarehouseChange paramWarehouseChange) {}
  
  public void onClick(View paramView) {
    if (WarehouseChange.a(this.dMf) != 0L) {
      (new AlertDialog.Builder(this.dMf)).setTitle(this.dMf.getString(2131625963)).setMessage(this.dMf.getString(2131625964)).setPositiveButton(this.dMf.getString(2131625975), new h(this)).setNegativeButton(this.dMf.getString(2131625967), new g(this)).create().show();
      return;
    } 
    Toast.makeText(this.dMf.getApplicationContext(), this.dMf.getString(2131630601), 1000).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */