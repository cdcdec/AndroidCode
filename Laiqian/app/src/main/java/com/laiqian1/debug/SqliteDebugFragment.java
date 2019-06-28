package com.laiqian.debug;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.db.a;

public class SqliteDebugFragment extends Fragment {
  AsyncSyncDebugFragment.a aQm;
  
  private void Ej() {
    Cursor cursor = a.Y(getActivity()).getReadableDatabase().rawQuery("SELECT * FROM T_PRODUCTDOC", null);
    while (cursor.moveToNext());
  }
  
  private void wR() { this.aQm.aQp.setOnClickListener(new d(this)); }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {
    this.aQm = AsyncSyncDebugFragment.a.a(paramLayoutInflater);
    wR();
    return this.aQm.aQo;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\debug\SqliteDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */