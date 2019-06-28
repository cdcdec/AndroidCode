package com.laiqian.ui.listview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorTreeAdapter;

public class n extends SimpleCursorTreeAdapter {
  public static int dCI = -1;
  
  public static String dCK = "";
  
  public static String[] dCM;
  
  public static SQLiteDatabase dCO;
  
  private final int NUM_PER_PAGE = 10;
  
  private int cv = 50;
  
  protected String dCJ = "";
  
  protected String[] dCL = null;
  
  protected int dCN = 0;
  
  static  {
  
  }
  
  public n(Cursor paramCursor, Context paramContext, int paramInt1, int paramInt2, String[] paramArrayOfString1, int[] paramArrayOfInt1, String[] paramArrayOfString2, int[] paramArrayOfInt2, SQLiteDatabase paramSQLiteDatabase, String paramString1, String[] paramArrayOfString3, String paramString2, String[] paramArrayOfString4, int paramInt3, int paramInt4) {
    super(paramContext, paramCursor, paramInt1, paramArrayOfString1, paramArrayOfInt1, paramInt2, paramArrayOfString2, paramArrayOfInt2);
    dCI = paramInt4;
    dCO = paramSQLiteDatabase;
    this.dCN = paramInt3;
    this.dCJ = paramString1;
    dCK = paramString2;
    this.dCL = paramArrayOfString3;
    dCM = paramArrayOfString4;
    null = new StringBuilder();
    null.append(this.dCJ);
    null.append(" limit ");
    null.append(10);
    Cursor cursor = paramSQLiteDatabase.rawQuery(null.toString(), this.dCL);
    changeCursor(cursor);
    if (cursor.getCount() <= 10) {
      this.cv = cursor.getCount();
      return;
    } 
    this.cv = 10;
  }
  
  public int asb() { return this.dCN; }
  
  protected Cursor getChildrenCursor(Cursor paramCursor) {
    String str = paramCursor.getString(dCI);
    String[] arrayOfString = dCM;
    byte b = 0;
    if (arrayOfString != null) {
      arrayOfString = new String[dCM.length + 1];
      while (b < dCM.length) {
        arrayOfString[b] = dCM[b];
        b++;
      } 
      arrayOfString[arrayOfString.length - 1] = str;
    } else {
      arrayOfString = new String[1];
      arrayOfString[0] = str;
    } 
    return dCO.rawQuery(dCK, arrayOfString);
  }
  
  public int getCount() { return this.cv; }
  
  public boolean lj(int paramInt) {
    if (this.cv + paramInt >= getGroupCount()) {
      this.cv = getGroupCount();
      if (this.cv < this.dCN) {
        int i = this.cv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dCJ);
        stringBuilder.append(" limit ");
        stringBuilder.append(i + paramInt);
        String str = stringBuilder.toString();
        Cursor cursor = dCO.rawQuery(str, null);
        this.cv = cursor.getCount();
        changeCursor(cursor);
        return false;
      } 
      return true;
    } 
    this.cv += paramInt;
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */