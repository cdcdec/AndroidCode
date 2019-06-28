package com.laiqian.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.bb;
import io.reactivex.g.a;

public class b {
  private final int aNK = 500;
  
  private final String aNL = "splited_db";
  
  private final int aNM = 300;
  
  private int aNN = 0;
  
  private Handler aNO = null;
  
  String aNP = null;
  
  String aNQ = null;
  
  String aNR = null;
  
  String aNS = null;
  
  StringBuilder aNT;
  
  StringBuilder aNU;
  
  String aNV = null;
  
  String aNW = null;
  
  String aNX = null;
  
  String aNY = null;
  
  private SQLiteDatabase aNZ = null;
  
  private String aOa = null;
  
  SQLiteStatement aOb = null;
  
  private SQLiteDatabase aOc = null;
  
  private String aOd = null;
  
  SQLiteStatement aOe = null;
  
  private String a(Cursor paramCursor, String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      if (this.aNX != null && paramString.equals(this.aNX))
        return this.aNY; 
    } else if (this.aNV != null && paramString.equals(this.aNV)) {
      return this.aNW;
    } 
    this.aNT = a(this.aNT);
    this.aNT.append("insert into ");
    this.aNT.append(paramString);
    this.aNT.append(" (");
    this.aNU = a(this.aNU);
    this.aNU.append(" values ( ");
    int i = paramCursor.getColumnCount();
    byte b1;
    for (b1 = 0; b1 < i; b1++) {
      this.aNT.append(paramCursor.getColumnName(b1));
      this.aNU.append("?");
      if (b1 < paramCursor.getColumnCount() - 1) {
        this.aNT.append(",");
        this.aNU.append(",");
      } else {
        this.aNT.append(")");
        this.aNU.append(");");
      } 
    } 
    this.aNT.append(this.aNU);
    if (paramBoolean) {
      this.aNX = paramString;
      this.aNY = this.aNT.toString();
      return this.aNY;
    } 
    this.aNV = paramString;
    this.aNW = this.aNT.toString();
    return this.aNW;
  }
  
  private StringBuilder a(StringBuilder paramStringBuilder) {
    if (paramStringBuilder == null)
      return new StringBuilder(); 
    paramStringBuilder.setLength(0);
    paramStringBuilder.delete(0, paramStringBuilder.length());
    return paramStringBuilder;
  }
  
  private SQLiteStatement b(SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      if (paramSQLiteDatabase != this.aOc || this.aOd == null || !this.aOd.equals(paramString)) {
        if (this.aOe != null)
          this.aOe.close(); 
        this.aOc = paramSQLiteDatabase;
        this.aOd = paramString;
        this.aOe = paramSQLiteDatabase.compileStatement(this.aOd);
      } 
      return this.aOe;
    } 
    if (paramSQLiteDatabase != this.aNZ || this.aOa == null || !this.aOa.equals(paramString)) {
      if (this.aOb != null)
        this.aOb.close(); 
      this.aNZ = paramSQLiteDatabase;
      this.aOa = paramString;
      this.aOb = paramSQLiteDatabase.compileStatement(this.aOa);
    } 
    return this.aOb;
  }
  
  public void Z(Context paramContext) {
    c c = new c(this, paramContext);
    a.aKh().r(c);
  }
  
  public String a(SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean) { // Byte code:
    //   0: iload_3
    //   1: ifeq -> 27
    //   4: aload_0
    //   5: getfield aNR : Ljava/lang/String;
    //   8: ifnull -> 50
    //   11: aload_2
    //   12: aload_0
    //   13: getfield aNR : Ljava/lang/String;
    //   16: invokevirtual equals : (Ljava/lang/Object;)Z
    //   19: ifeq -> 50
    //   22: aload_0
    //   23: getfield aNS : Ljava/lang/String;
    //   26: areturn
    //   27: aload_0
    //   28: getfield aNP : Ljava/lang/String;
    //   31: ifnull -> 50
    //   34: aload_2
    //   35: aload_0
    //   36: getfield aNP : Ljava/lang/String;
    //   39: invokevirtual equals : (Ljava/lang/Object;)Z
    //   42: ifeq -> 50
    //   45: aload_0
    //   46: getfield aNQ : Ljava/lang/String;
    //   49: areturn
    //   50: aconst_null
    //   51: astore #5
    //   53: aconst_null
    //   54: astore #4
    //   56: new java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore #6
    //   65: aload #6
    //   67: ldc 'SELECT sql FROM sqlite_master WHERE type='table' AND name=''
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #6
    //   75: aload_2
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #6
    //   82: ldc '''
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: aload #6
    //   91: invokevirtual toString : ()Ljava/lang/String;
    //   94: aconst_null
    //   95: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   98: astore_1
    //   99: aload #5
    //   101: astore #4
    //   103: aload_1
    //   104: ifnull -> 218
    //   107: aload #5
    //   109: astore #4
    //   111: aload_1
    //   112: invokeinterface moveToFirst : ()Z
    //   117: ifeq -> 218
    //   120: aload_1
    //   121: aload_1
    //   122: ldc 'sql'
    //   124: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   129: invokeinterface getString : (I)Ljava/lang/String;
    //   134: astore #5
    //   136: aload_1
    //   137: invokeinterface close : ()V
    //   142: goto -> 214
    //   145: astore #6
    //   147: aload_1
    //   148: astore #4
    //   150: aload #5
    //   152: astore_1
    //   153: aload #6
    //   155: astore #5
    //   157: goto -> 178
    //   160: astore #5
    //   162: aconst_null
    //   163: astore #6
    //   165: aload_1
    //   166: astore #4
    //   168: aload #6
    //   170: astore_1
    //   171: goto -> 178
    //   174: astore #5
    //   176: aconst_null
    //   177: astore_1
    //   178: aload #5
    //   180: invokestatic e : (Ljava/lang/Throwable;)V
    //   183: aload_1
    //   184: astore #5
    //   186: aload #4
    //   188: ifnull -> 214
    //   191: aload_1
    //   192: astore #5
    //   194: aload #4
    //   196: invokeinterface isClosed : ()Z
    //   201: ifne -> 214
    //   204: aload #4
    //   206: invokeinterface close : ()V
    //   211: aload_1
    //   212: astore #5
    //   214: aload #5
    //   216: astore #4
    //   218: iload_3
    //   219: ifeq -> 238
    //   222: aload_0
    //   223: aload_2
    //   224: putfield aNR : Ljava/lang/String;
    //   227: aload_0
    //   228: aload #4
    //   230: putfield aNS : Ljava/lang/String;
    //   233: aload_0
    //   234: getfield aNS : Ljava/lang/String;
    //   237: areturn
    //   238: aload_0
    //   239: aload_2
    //   240: putfield aNP : Ljava/lang/String;
    //   243: aload_0
    //   244: aload #4
    //   246: putfield aNQ : Ljava/lang/String;
    //   249: aload_0
    //   250: getfield aNQ : Ljava/lang/String;
    //   253: areturn
    // Exception table:
    //   from	to	target	type
    //   56	99	174	java/lang/Exception
    //   111	136	160	java/lang/Exception
    //   136	142	145	java/lang/Exception }
  
  public boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from ");
      stringBuilder.append(paramString3);
      String str3 = stringBuilder.toString();
      String str2 = str3;
      if (!paramBoolean) {
        str2 = str3;
        if (!paramString4.equals("all")) {
          null = new StringBuilder();
          null.append(str3);
          null.append(" limit ");
          null.append(paramString4);
          null.append(", ");
          null.append(500);
          str2 = null.toString();
        } 
      } 
      Cursor cursor = paramSQLiteDatabase.rawQuery(str2, null);
      str1 = a(paramSQLiteDatabase, paramString3, paramBoolean);
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString1);
        stringBuilder1.append(paramString2);
        SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(stringBuilder1.toString(), null);
        sQLiteDatabase.execSQL(str1);
        sQLiteDatabase.beginTransaction();
        str1 = a(cursor, paramString3, paramBoolean);
        boolean bool = true;
        try {
          this.aOb = b(sQLiteDatabase, str1, paramBoolean);
          boolean bool1 = true;
          while (true) {
            if (cursor.moveToNext()) {
              boolean bool3 = true;
              while (true);
            } else {
              this.aOb.close();
              this.aOb = null;
              cursor.close();
              sQLiteDatabase.setTransactionSuccessful();
              sQLiteDatabase.endTransaction();
              paramBoolean = bool;
              if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                return true;
              } 
              break;
            } 
            boolean bool2 = true;
            while (true);
          } 
        } catch (Exception str1) {
          a.e(str1);
          bb.f("copyDataToNewDb", str1.toString());
          sQLiteDatabase.endTransaction();
          if (sQLiteDatabase != null)
            sQLiteDatabase.close(); 
          paramBoolean = false;
        } finally {}
      } catch (Exception str1) {}
      cursor.close();
      return false;
    } catch (SQLException paramSQLiteDatabase) {
      a.e(paramSQLiteDatabase);
      return false;
    } 
  }
  
  public boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, boolean paramBoolean) {
    try {
      Cursor cursor = paramSQLiteDatabase.rawQuery("select * from T_PRODUCT where nProductStatus=600001 or nProductStatus=600002", null);
      str = a(paramSQLiteDatabase, "T_PRODUCT", paramBoolean);
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString1);
        stringBuilder.append(paramString2);
        SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(stringBuilder.toString(), null);
        sQLiteDatabase.execSQL(str);
        sQLiteDatabase.beginTransaction();
        str = a(cursor, "T_PRODUCT", paramBoolean);
        boolean bool = true;
        try {
          this.aOb = b(sQLiteDatabase, str, paramBoolean);
          boolean bool1 = true;
          while (true) {
            if (cursor.moveToNext()) {
              boolean bool3 = true;
              while (true);
            } else {
              this.aOb.close();
              this.aOb = null;
              cursor.close();
              sQLiteDatabase.setTransactionSuccessful();
              sQLiteDatabase.endTransaction();
              paramBoolean = bool;
              if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                return true;
              } 
              break;
            } 
            boolean bool2 = true;
            while (true);
          } 
        } catch (Exception str) {
          a.e(str);
          bb.f("copyDataToNewDb", str.toString());
          sQLiteDatabase.endTransaction();
          if (sQLiteDatabase != null)
            sQLiteDatabase.close(); 
          paramBoolean = false;
        } finally {}
      } catch (Exception str) {}
      cursor.close();
      return false;
    } catch (SQLException paramSQLiteDatabase) {
      a.e(paramSQLiteDatabase);
      return false;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */