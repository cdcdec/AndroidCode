package com.laiqian.db.multidatabase.d;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class c implements DatabaseErrorHandler {
  @TargetApi(16)
  private void cy(String paramString) {
    if (!paramString.equalsIgnoreCase(":memory:")) {
      if (paramString.trim().length() == 0)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getClass().getSimpleName());
      stringBuilder.append("----deleting the database file: ");
      stringBuilder.append(paramString);
      b.ct(stringBuilder.toString());
      try {
        SQLiteDatabase.deleteDatabase(new File(paramString));
        return;
      } catch (Exception paramString) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("----delete failed: ");
        stringBuilder.append(paramString.getMessage());
        b.ct(stringBuilder.toString());
        return;
      } 
    } 
  }
  
  private boolean o(File paramFile) {
    byte[] arrayOfByte = new byte[16];
    arrayOfByte[0] = 83;
    arrayOfByte[1] = 81;
    arrayOfByte[2] = 76;
    arrayOfByte[3] = 105;
    arrayOfByte[4] = 116;
    arrayOfByte[5] = 101;
    arrayOfByte[6] = 32;
    arrayOfByte[7] = 102;
    arrayOfByte[8] = 111;
    arrayOfByte[9] = 114;
    arrayOfByte[10] = 109;
    arrayOfByte[11] = 97;
    arrayOfByte[12] = 116;
    arrayOfByte[13] = 32;
    arrayOfByte[14] = 51;
    arrayOfByte[15] = 0;
    arrayOfByte;
    int i = arrayOfByte.length;
    try {
      int j = (int)paramFile.length();
      byte[] arrayOfByte1 = new byte[j];
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      fileInputStream.read(arrayOfByte1);
      fileInputStream.close();
      if (Arrays.equals(arrayOfByte, Arrays.copyOfRange(arrayOfByte1, 0, i))) {
        System.out.println("这个数据库文件没有问题");
        return false;
      } 
      System.out.println("这个数据库文件有问题,需要处理");
      FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
      fileOutputStream.write(arrayOfByte);
      fileOutputStream.write(arrayOfByte1, i, j - i);
      fileOutputStream.close();
      System.out.println("修复数据库文件成功了");
      return true;
    } catch (Exception paramFile) {
      a.e(paramFile);
      System.out.println("修复数据库文件失败了");
      return false;
    } 
  }
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase) {
    Iterator iterator;
    null = new File(paramSQLiteDatabase.getPath());
    if (o(null))
      return; 
    n.d(null, new File(RootApplication.zv().getFilesDir(), "laiqian.db"));
    null = new StringBuilder();
    null.append(getClass().getSimpleName());
    null.append("--Corruption reported by sqlite on database: ");
    null.append(paramSQLiteDatabase.getPath());
    b.ct(null.toString());
    if (!paramSQLiteDatabase.isOpen()) {
      cy(paramSQLiteDatabase.getPath());
      return;
    } 
    null = null;
    object = null;
    try {
      list2 = paramSQLiteDatabase.getAttachedDbs();
    } catch (SQLiteException object) {
    
    } finally {
      if (object != null) {
        iterator = object.iterator();
        while (iterator.hasNext())
          cy((String)((Pair)iterator.next()).second); 
      } else {
        cy(iterator.getPath());
      } 
    } 
    object = SYNTHETIC_LOCAL_VARIABLE_2;
    try {
      iterator.close();
    } catch (SQLiteException object) {}
    if (SYNTHETIC_LOCAL_VARIABLE_2 != null) {
      iterator = SYNTHETIC_LOCAL_VARIABLE_2.iterator();
      while (iterator.hasNext())
        cy((String)((Pair)iterator.next()).second); 
    } else {
      cy(iterator.getPath());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */