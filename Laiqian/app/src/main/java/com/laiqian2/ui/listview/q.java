package com.laiqian.ui.listview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class q extends k {
  public static int NUM_PER_PAGE = 50;
  
  protected String bsx;
  
  private int cv;
  
  protected int dCN;
  
  protected SQLiteDatabase dCO;
  
  private String[] dCQ;
  
  protected Cursor mCursor;
  
  static  {
  
  }
  
  public int asa() { return this.dCN; }
  
  public int asb() { return this.dCN; }
  
  public int getCount() { return this.cv; }
  
  public boolean lj(int paramInt) {
    if (this.cv + paramInt >= this.mCursor.getCount()) {
      this.cv = this.mCursor.getCount();
      if (this.cv < this.dCN) {
        int i = this.cv;
        null = new StringBuilder();
        null.append(this.bsx);
        null.append(" limit ");
        null.append(i + paramInt);
        Cursor cursor = null.toString();
        if (this.dCQ != null) {
          cursor = this.dCO.rawQuery(cursor, this.dCQ);
        } else {
          cursor = this.dCO.rawQuery(cursor, null);
        } 
        this.cv = cursor.getCount();
        changeCursor(cursor);
        this.mCursor = cursor;
        return false;
      } 
      return true;
    } 
    this.cv += paramInt;
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */