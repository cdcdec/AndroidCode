package com.laiqian.warehouse;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import com.laiqian.util.av;

class d implements AdapterView.OnItemClickListener {
  d(Warehouse paramWarehouse) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    Cursor cursor = ((SimpleCursorAdapter)Warehouse.b(this.dLN).getAdapter()).getCursor();
    cursor.moveToFirst();
    cursor.move(paramInt);
    av av = new av(this.dLN);
    Warehouse.b(this.dLN, av.atB());
    if (Warehouse.c(this.dLN).equals("1204")) {
      Intent intent = new Intent();
      intent.setClass(this.dLN, Warehouse_details.class);
      Bundle bundle = new Bundle();
      bundle.putLong("warehouseID", cursor.getLong(cursor.getColumnIndex("_id")));
      intent.putExtras(bundle);
      this.dLN.startActivity(intent);
    } else {
      Intent intent = this.dLN.getIntent();
      Bundle bundle = new Bundle();
      bundle.putLong("warehouseID", cursor.getLong(cursor.getColumnIndex("_id")));
      intent.putExtras(bundle);
      av.dr(cursor.getLong(cursor.getColumnIndex("_id")));
      this.dLN.setResult(-1, intent);
      this.dLN.finish();
    } 
    av.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */