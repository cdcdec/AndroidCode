package com.laiqian.warehouse;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.laiqian.milestone.h;

class p implements DialogInterface.OnClickListener {
  p(n paramn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    h h = new h(this.dMm.dMl);
    if (h.aY(Warehouse_details.a(this.dMm.dMl))) {
      Warehouse_details.a(this.dMm.dMl, Warehouse_details.b(this.dMm.dMl).getText().toString().trim());
      Context context = this.dMm.dMl.getApplicationContext();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.dMm.dMl.getString(2131630588));
      stringBuilder.append(Warehouse_details.c(this.dMm.dMl));
      stringBuilder.append(this.dMm.dMl.getString(2131630589));
      Toast.makeText(context, stringBuilder.toString(), 1000).show();
    } else {
      Toast.makeText(this.dMm.dMl.getApplicationContext(), this.dMm.dMl.getString(2131630585), 1000).show();
    } 
    h.close();
    this.dMm.dMl.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */