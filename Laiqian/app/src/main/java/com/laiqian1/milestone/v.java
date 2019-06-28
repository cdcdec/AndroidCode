package com.laiqian.milestone;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import com.laiqian.util.av;

class v implements AdapterView.OnItemClickListener {
  v(userDisplay paramuserDisplay) {}
  
  private void Uj() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    Cursor cursor = ((SimpleCursorAdapter)userDisplay.a(this.bLF).getAdapter()).getCursor();
    cursor.moveToFirst();
    cursor.move(paramInt);
    userDisplay.bb(cursor.getLong(cursor.getColumnIndex("_id")));
    userDisplay.gT(this.bLF.getSharedPreferences("settings", 0).getString("sWindowID", "1203"));
    if (userDisplay.Ui().equals("1250")) {
      Intent intent = new Intent();
      intent.setClass(this.bLF, com.laiqian.report.FilterActivity.class);
      Bundle bundle = new Bundle();
      bundle.putLong("nUserID", userDisplay.Ud());
      intent.putExtras(bundle);
      this.bLF.setResult(-1, intent);
      this.bLF.finish();
      return;
    } 
    av av = new av(this.bLF);
    if (av.atp().equals("150001")) {
      Uj();
      return;
    } 
    String str = av.atm();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(userDisplay.Ud());
    stringBuilder.append("");
    if (str.equals(stringBuilder.toString())) {
      Uj();
      return;
    } 
    Toast.makeText(this.bLF.getApplicationContext(), this.bLF.getString(2131624276), 2000).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */