package com.laiqian.version;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.laiqian.milestone.h;

public class r extends h {
  private String dJA = "";
  
  public boolean dJx = false;
  
  float dJy = 0.0F;
  
  float dJz = 0.0F;
  
  public r(Context paramContext, String paramString) {
    super(paramContext);
    this.dJA = paramString;
    try {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(paramString, null);
      sQLiteDatabase.close();
      this.dJx = true;
      return;
    } catch (Exception paramContext) {
      this.dJx = false;
      return;
    } 
  }
  
  public boolean load() { return this.dJx ? gL(this.dJA) : 0; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */