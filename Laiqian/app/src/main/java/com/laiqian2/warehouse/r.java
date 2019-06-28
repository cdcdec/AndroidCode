package com.laiqian.warehouse;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.laiqian.milestone.h;

class r implements View.OnClickListener {
  r(Warehouse_details paramWarehouse_details) {}
  
  public void onClick(View paramView) {
    char c2;
    char c1;
    h h = new h(this.dMl);
    Warehouse_details.a(this.dMl, Warehouse_details.b(this.dMl).getText().toString().trim());
    Warehouse_details.b(this.dMl, Warehouse_details.e(this.dMl).getText().toString().trim());
    Warehouse_details.c(this.dMl, Warehouse_details.f(this.dMl).getText().toString().trim());
    Warehouse_details.d(this.dMl, Warehouse_details.g(this.dMl).getText().toString().trim());
    Warehouse_details.e(this.dMl, Warehouse_details.h(this.dMl).getText().toString().trim());
    if (Warehouse_details.i(this.dMl).isChecked()) {
      c1 = 'Y';
    } else {
      c1 = 'N';
    } 
    if (Warehouse_details.j(this.dMl).isChecked()) {
      c2 = 'Y';
    } else {
      c2 = 'N';
    } 
    byte b2 = 0;
    byte b1 = b2;
    if (Warehouse_details.c(this.dMl) != "") {
      b1 = b2;
      if (!Warehouse_details.c(this.dMl).equals(null)) {
        b1 = b2;
        if (Warehouse_details.c(this.dMl).length() > 0)
          b1 = 1; 
      } 
    } 
    if (Warehouse_details.a(this.dMl) != 0L) {
      if (b1 != 0) {
        h.a(Warehouse_details.a(this.dMl), Warehouse_details.c(this.dMl), Warehouse_details.k(this.dMl), Warehouse_details.l(this.dMl), Warehouse_details.m(this.dMl), Warehouse_details.n(this.dMl), c1, c2);
        Context context = this.dMl.getApplicationContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dMl.getString(2131630606));
        stringBuilder.append(Warehouse_details.c(this.dMl));
        stringBuilder.append(this.dMl.getString(2131630607));
        Toast.makeText(context, stringBuilder.toString(), 1000).show();
        this.dMl.finish();
      } else {
        Toast.makeText(this.dMl.getApplicationContext(), this.dMl.getString(2131630600), 1000).show();
      } 
    } else if (b1 != 0) {
      h.a(Warehouse_details.o(this.dMl), Warehouse_details.c(this.dMl), Warehouse_details.k(this.dMl), Warehouse_details.l(this.dMl), Warehouse_details.m(this.dMl), Warehouse_details.n(this.dMl), c1, c2);
      Context context = this.dMl.getApplicationContext();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.dMl.getString(2131630582));
      stringBuilder.append(Warehouse_details.c(this.dMl));
      stringBuilder.append(this.dMl.getString(2131630583));
      Toast.makeText(context, stringBuilder.toString(), 1000).show();
      this.dMl.finish();
    } else {
      Toast.makeText(this.dMl.getApplicationContext(), this.dMl.getString(2131630600), 1000).show();
    } 
    h.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */