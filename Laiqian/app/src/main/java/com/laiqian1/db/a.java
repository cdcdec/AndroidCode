package com.laiqian.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ba;
import com.laiqian.util.bb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class a extends SQLiteOpenHelper {
  private static Integer aND = Integer.valueOf(0);
  
  private static String aNG;
  
  private SQLiteDatabase aNE = null;
  
  private boolean aNF = false;
  
  private String aNI = "";
  
  ba aNJ = new ba(LQKVersion.zg());
  
  private Context mContext = null;
  
  private a(Context paramContext) {
    super(paramContext, "laiqian.db", null, 1);
    this.mContext = paramContext;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(this.mContext.getPackageName());
    stringBuilder.append("/");
    stringBuilder.append("laiqian.db");
    aNG = stringBuilder.toString();
    cq(aNG);
    bb.e("DatabaseHelper", aNG);
    aND = Integer.valueOf(0);
  }
  
  public static void Dh() { // Byte code:
    //   0: ldc com/laiqian/db/a
    //   2: monitorenter
    //   3: getstatic com/laiqian/db/a.aND : Ljava/lang/Integer;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic com/laiqian/db/a.aNH : Lcom/laiqian/db/a;
    //   12: ifnull -> 28
    //   15: iconst_0
    //   16: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   19: putstatic com/laiqian/db/a.aND : Ljava/lang/Integer;
    //   22: getstatic com/laiqian/db/a.aNH : Lcom/laiqian/db/a;
    //   25: invokevirtual close : ()V
    //   28: aload_0
    //   29: monitorexit
    //   30: ldc com/laiqian/db/a
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_0
    //   40: ldc com/laiqian/db/a
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	39	finally
    //   9	28	34	finally
    //   28	30	34	finally
    //   35	37	34	finally
    //   37	39	39	finally }
  
  public static a Y(Context paramContext) {
    if (aNH == null)
      aNH = new a(paramContext.getApplicationContext()); 
    return aNH;
  }
  
  private void cq(String paramString) {
    File file = new File(paramString);
    if (!file.exists())
      try {
        file.createNewFile();
        InputStream inputStream = this.mContext.getResources().openRawResource(R.raw.laiqian);
        FileOutputStream fileOutputStream = new FileOutputStream(paramString);
        byte[] arrayOfByte = new byte[8192];
        while (true) {
          int i = inputStream.read(arrayOfByte);
          if (i > 0) {
            fileOutputStream.write(arrayOfByte, 0, i);
            continue;
          } 
          break;
        } 
        fileOutputStream.close();
        inputStream.close();
        return;
      } catch (Exception paramString) {
        a.e(paramString);
      }  
  }
  
  public void close() {
    /* monitor enter ThisExpression{ObjectType{com/laiqian/db/a}} */
    /* monitor exit ThisExpression{ObjectType{com/laiqian/db/a}} */
  }
  
  public SQLiteDatabase getWritableDatabase() { return b.aOw.Dk(); }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */