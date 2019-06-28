package com.laiqian.setting;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;

class ad implements AdapterView.OnItemClickListener {
  ad(OrderNumberLauncherActivity paramOrderNumberLauncherActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    Intent intent = new Intent(this.dkL, SetMakeOrderNumRuleActivity.class);
    Cursor cursor = ((SimpleCursorAdapter)OrderNumberLauncherActivity.b(this.dkL).getAdapter()).getCursor();
    cursor.moveToFirst();
    cursor.move(paramInt);
    Bundle bundle = new Bundle();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(cursor.getLong(cursor.getColumnIndex("nBusinessType")));
    stringBuilder.append("");
    bundle.putString("sBusinessType", stringBuilder.toString());
    intent.putExtras(bundle);
    this.dkL.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */