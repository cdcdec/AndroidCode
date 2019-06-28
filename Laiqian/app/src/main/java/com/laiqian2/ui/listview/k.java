package com.laiqian.ui.listview;

import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

public class k extends SimpleCursorAdapter {
  private int cv;
  
  protected Cursor mCursor;
  
  public int asa() { return this.mCursor.getCount(); }
  
  public int getCount() { return this.cv; }
  
  public boolean lj(int paramInt) {
    if (this.cv + paramInt >= this.mCursor.getCount()) {
      this.cv = this.mCursor.getCount();
      return true;
    } 
    this.cv += paramInt;
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */