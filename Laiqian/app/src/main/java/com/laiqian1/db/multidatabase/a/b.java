package com.laiqian.db.multidatabase.a;

import android.database.sqlite.SQLiteDatabase;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.d.c;

public static enum b {
  aOw("laiqian.db");
  
  private SQLiteDatabase aNE;
  
  private String aOx;
  
  b(String paramString1) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(RootApplication.zv().getPackageName());
    stringBuilder.append("/");
    stringBuilder.append(paramString1);
    this.aOx = stringBuilder.toString();
    this.aNE = SQLiteDatabase.openOrCreateDatabase(this.aOx, null, new c());
    this.aNE.execSQL("PRAGMA synchronous=NORMAL");
  }
  
  public SQLiteDatabase Dk() {
    if (!this.aNE.isOpen()) {
      this.aNE = SQLiteDatabase.openOrCreateDatabase(this.aOx, null, new c());
      this.aNE.execSQL("PRAGMA synchronous=NORMAL");
    } 
    return this.aNE;
  }
  
  public void e(SQLiteDatabase paramSQLiteDatabase) { this.aNE = paramSQLiteDatabase; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */