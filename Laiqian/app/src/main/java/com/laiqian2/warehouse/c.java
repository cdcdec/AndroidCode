package com.laiqian.warehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

class c implements View.OnClickListener {
  c(Warehouse paramWarehouse) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    intent.setClass(this.dLN, Warehouse_details.class);
    Bundle bundle = new Bundle();
    bundle.putLong("warehouseID", 0L);
    intent.putExtras(bundle);
    this.dLN.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */