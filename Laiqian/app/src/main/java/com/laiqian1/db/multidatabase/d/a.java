package com.laiqian.db.multidatabase.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import hugo.weaving.DebugLog;
import java.io.File;

public class a {
  private static final String TAG = "a";
  
  static  {
  
  }
  
  public static a Dl() { // Byte code:
    //   0: getstatic com/laiqian/db/multidatabase/d/a.aOJ : Lcom/laiqian/db/multidatabase/d/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/laiqian/db/multidatabase/d/a
    //   8: monitorenter
    //   9: getstatic com/laiqian/db/multidatabase/d/a.aOJ : Lcom/laiqian/db/multidatabase/d/a;
    //   12: ifnonnull -> 25
    //   15: new com/laiqian/db/multidatabase/d/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/laiqian/db/multidatabase/d/a.aOJ : Lcom/laiqian/db/multidatabase/d/a;
    //   25: ldc com/laiqian/db/multidatabase/d/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/laiqian/db/multidatabase/d/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/laiqian/db/multidatabase/d/a.aOJ : Lcom/laiqian/db/multidatabase/d/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally }
  
  @DebugLog
  public String cr(String paramString) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("createBranchDatabase-->");
    stringBuilder.append(paramString);
    Log.i(str, stringBuilder.toString());
    boolean bool = b.cs(paramString.substring(0, paramString.lastIndexOf("/")));
    File file = new File(paramString);
    if (!file.exists() && !file.isDirectory() && bool) {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(paramString, null, new c());
      f(sQLiteDatabase);
      sQLiteDatabase.close();
      return paramString;
    } 
    return paramString;
  }
  
  public void f(SQLiteDatabase paramSQLiteDatabase) {
    cursor = null;
    try {
    
    } finally {
      paramSQLiteDatabase = null;
      object2 = null;
    } 
    if (object1 != null)
      object1.close(); 
    if (cursor != null)
      cursor.close(); 
    if (object2 != null) {
      b.ct("detach database 'profile'");
      object2.execSQL(" detach database 'profile' ");
    } 
    throw paramSQLiteDatabase;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */