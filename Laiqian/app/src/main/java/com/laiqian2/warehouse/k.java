package com.laiqian.warehouse;

import android.view.View;
import android.widget.Toast;
import com.laiqian.warehouse.a.a;

class k implements View.OnClickListener {
  k(WarehouseCreate paramWarehouseCreate) {}
  
  public void onClick(View paramView) {
    char c1;
    WarehouseCreate.a(this.dMi, WarehouseCreate.a(this.dMi).getText().toString().trim());
    WarehouseCreate.b(this.dMi, WarehouseCreate.b(this.dMi).getText().toString().trim());
    WarehouseCreate.c(this.dMi, WarehouseCreate.c(this.dMi).getText().toString().trim());
    WarehouseCreate.d(this.dMi, WarehouseCreate.d(this.dMi).getText().toString().trim());
    WarehouseCreate.e(this.dMi, WarehouseCreate.e(this.dMi).getText().toString().trim());
    boolean bool = WarehouseCreate.f(this.dMi).isChecked();
    char c2 = 'Y';
    if (bool) {
      c1 = 'Y';
    } else {
      c1 = 'N';
    } 
    if (!WarehouseCreate.g(this.dMi).isChecked())
      c2 = 'N'; 
    if (WarehouseCreate.h(this.dMi) == null || WarehouseCreate.h(this.dMi).equals("")) {
      Toast.makeText(this.dMi.getApplicationContext(), this.dMi.getString(2131630600), 1000).show();
      return;
    } 
    a a = new a(this.dMi);
    a.am("sName", WarehouseCreate.h(this.dMi));
    a.am("sDescription", WarehouseCreate.i(this.dMi));
    a.am("sNumber", WarehouseCreate.j(this.dMi));
    a.am("sAddress", WarehouseCreate.k(this.dMi));
    a.am("sText", WarehouseCreate.l(this.dMi));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c1);
    stringBuilder.append("");
    a.am("sIsDefaultMoveIn", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(c2);
    stringBuilder.append("");
    a.am("sIsDefaultMoveOut", stringBuilder.toString());
    a.axH();
    this.dMi.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */