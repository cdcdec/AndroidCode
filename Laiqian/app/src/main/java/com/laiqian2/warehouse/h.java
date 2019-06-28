package com.laiqian.warehouse;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.laiqian.warehouse.a.a;

class h implements DialogInterface.OnClickListener {
  h(f paramf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    if ((new a(this.dMg.dMf)).dK(WarehouseChange.a(this.dMg.dMf))) {
      WarehouseChange.a(this.dMg.dMf, WarehouseChange.b(this.dMg.dMf).getText().toString().trim());
      Context context = this.dMg.dMf.getApplicationContext();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.dMg.dMf.getString(2131630588));
      stringBuilder.append(WarehouseChange.c(this.dMg.dMf));
      stringBuilder.append(this.dMg.dMf.getString(2131630589));
      Toast.makeText(context, stringBuilder.toString(), 1000).show();
    } else {
      Toast.makeText(this.dMg.dMf.getApplicationContext(), this.dMg.dMf.getString(2131630585), 1000).show();
    } 
    this.dMg.dMf.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */