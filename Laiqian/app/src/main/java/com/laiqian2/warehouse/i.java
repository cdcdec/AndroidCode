package com.laiqian.warehouse;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.laiqian.warehouse.a.a;

class i implements View.OnClickListener {
  i(WarehouseChange paramWarehouseChange) {}
  
  public void onClick(View paramView) {
    char c1;
    WarehouseChange.a(this.dMf, WarehouseChange.b(this.dMf).getText().toString().trim());
    WarehouseChange.b(this.dMf, WarehouseChange.d(this.dMf).getText().toString().trim());
    WarehouseChange.c(this.dMf, WarehouseChange.e(this.dMf).getText().toString().trim());
    WarehouseChange.d(this.dMf, WarehouseChange.f(this.dMf).getText().toString().trim());
    WarehouseChange.e(this.dMf, WarehouseChange.g(this.dMf).getText().toString().trim());
    boolean bool = WarehouseChange.h(this.dMf).isChecked();
    char c2 = 'Y';
    if (bool) {
      c1 = 'Y';
    } else {
      c1 = 'N';
    } 
    if (!WarehouseChange.i(this.dMf).isChecked())
      c2 = 'N'; 
    if (WarehouseChange.c(this.dMf) != "" && WarehouseChange.c(this.dMf) != null && WarehouseChange.c(this.dMf).length() > 0) {
      Toast.makeText(this.dMf.getApplicationContext(), this.dMf.getString(2131630600), 1000).show();
      return;
    } 
    a a = new a(this.dMf);
    a.am("sName", WarehouseChange.c(this.dMf));
    a.am("sDescription", WarehouseChange.j(this.dMf));
    a.am("sNumber", WarehouseChange.k(this.dMf));
    a.am("sAddress", WarehouseChange.l(this.dMf));
    a.am("sText", WarehouseChange.m(this.dMf));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c1);
    stringBuilder.append("");
    a.am("sIsDefaultMoveIn", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(c2);
    stringBuilder.append("");
    a.am("sIsDefaultMoveOut", stringBuilder.toString());
    if (a.dJ(WarehouseChange.a(this.dMf))) {
      Context context = this.dMf.getApplicationContext();
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.dMf.getString(2131630606));
      stringBuilder.append(WarehouseChange.c(this.dMf));
      stringBuilder.append(this.dMf.getString(2131630607));
      Toast.makeText(context, stringBuilder.toString(), 1000).show();
    } 
    this.dMf.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */