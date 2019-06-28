package com.laiqian.sync.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.a;
import com.laiqian.message.m;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.bz;
import com.orhanobut.logger.d;
import hugo.weaving.DebugLog;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class a {
  private static final String TAG = "a";
  
  private final int aNK = 3000;
  
  private final int aNM = 1000;
  
  private int aNN = 0;
  
  private Handler aNO = null;
  
  String aNP = null;
  
  String aNQ = null;
  
  String aNR = null;
  
  String aNS = null;
  
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
  
  private String[] doQ = null;
  
  static  {
  
  }
  
  public a() {}
  
  public a(String[] paramArrayOfString) { this.doQ = paramArrayOfString; }
  
  private int a(@NonNull SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT count(*) FROM ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" WHERE nShopID = ? and (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1");
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder.toString(), new String[] { paramString2 });
    cursor.moveToFirst();
    int i = cursor.getInt(0);
    cursor.close();
    return i;
  }
  
  private HashMap<String, String> a(File paramFile, SQLiteDatabase paramSQLiteDatabase, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(paramFile, null);
    sQLiteDatabase.execSQL("PRAGMA auto_vacuum=1");
    a(paramSQLiteDatabase, sQLiteDatabase, paramString1, false);
    a(paramSQLiteDatabase, sQLiteDatabase, "ts_table_profile", true);
    d(paramSQLiteDatabase, paramFile.getAbsolutePath());
    try {
      paramSQLiteDatabase.beginTransaction();
      a(paramSQLiteDatabase, paramString1, paramString2, paramInt1, paramInt2);
      e(paramSQLiteDatabase, paramString1);
      paramSQLiteDatabase.setTransactionSuccessful();
    } catch (Exception exception) {
      a.e(exception);
    } finally {}
    paramSQLiteDatabase.endTransaction();
    i(paramSQLiteDatabase);
    try {
      sQLiteDatabase.beginTransaction();
      a(sQLiteDatabase, paramString1, paramString2, paramInt3);
      sQLiteDatabase.setTransactionSuccessful();
    } catch (Exception paramSQLiteDatabase) {
      a.e(paramSQLiteDatabase);
    } finally {}
    sQLiteDatabase.endTransaction();
    d.b(paramString1, new Object[0]);
    sQLiteDatabase.close();
    HashMap hashMap = new HashMap();
    hashMap.put("FileName", paramFile.getAbsolutePath());
    hashMap.put("TableName", paramString1);
    return hashMap;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    paramSQLiteDatabase.execSQL("UPDATE ts_table_profile SET n_download_records_limit = ? WHERE s_table_name = ?", new String[] { stringBuilder.toString(), paramString.toLowerCase() });
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, @NonNull String paramString1, String paramString2, int paramInt) {
    paramSQLiteDatabase.execSQL("UPDATE ts_table_profile SET s_foreign_tables = ? where s_table_name = 'td_uploading_tables'", new String[] { paramString1.toLowerCase() });
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("UPDATE ts_table_profile SET s_client_id_list = (select group_concat(_id) from ");
    stringBuilder2.append(paramString1);
    stringBuilder2.append(" where nShopID = ");
    stringBuilder2.append(paramString2);
    stringBuilder2.append(" and (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1 order by _id asc), s_client_nupdateflag_list = (select group_concat(IFNULL(nUpdateFlag, 0)) from ");
    stringBuilder2.append(paramString1);
    stringBuilder2.append(" where nShopID = ");
    stringBuilder2.append(paramString2);
    stringBuilder2.append(" and (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1 order by _id asc) where s_table_name = ?");
    paramSQLiteDatabase.execSQL(stringBuilder2.toString(), new String[] { paramString1.toLowerCase() });
    if (LQKVersion.zg()) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("select group_concat(_id) from ");
      stringBuilder2.append(paramString1);
      stringBuilder2.append(" where nShopID = ");
      stringBuilder2.append(paramString2);
      stringBuilder2.append(" and (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1 order by _id asc");
      Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder2.toString(), null);
      while (cursor.moveToNext())
        bz.g(paramString1, cursor.getString(0), false); 
      cursor.close();
    } 
    int i = paramInt;
    if (paramInt <= 0)
      i = 0; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("UPDATE ts_table_profile SET n_download_records_limit = ");
    stringBuilder1.append(i);
    stringBuilder1.append(" WHERE n_download_records_limit > 0");
    paramSQLiteDatabase.execSQL(stringBuilder1.toString());
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, int paramInt1, int paramInt2) { paramSQLiteDatabase.execSQL(String.format("INSERT INTO %s.%s SELECT * FROM main.%s WHERE nShopID = %s and (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1 LIMIT %d,%d", new Object[] { "SPLIT_DB", paramString1, paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })); }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, Collection<String> paramCollection) { paramSQLiteDatabase.execSQL("UPDATE ts_table_profile SET s_foreign_tables = ? WHERE s_table_name = 'td_uploading_tables'", new String[] { by.a(",", paramCollection) }); }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, Collection<String> paramCollection, String paramString) throws SQLiteException {
    bool = paramSQLiteDatabase.inTransaction();
    if (bool)
      paramSQLiteDatabase.beginTransaction(); 
    try {
      Iterator iterator = paramCollection.iterator();
      while (iterator.hasNext()) {
        String str;
        paramSQLiteDatabase.execSQL((str = (String)iterator.next()).format("UPDATE %s.ts_table_profile SET s_client_id_list=(SELECT group_concat(_id) FROM  (SELECT _id FROM main.%s WHERE nShopID = ? ORDER BY _id ASC)),s_client_nupdateflag_list=(SELECT group_concat(IFNULL(nUpdateFlag, 0)) FROM (SELECT nUpdateFlag FROM main.%s WHERE nShopID=? ORDER BY _id ASC)) WHERE s_table_name = ?", new Object[] { "SPLIT_DB", str, str }), new String[] { paramString, paramString, str });
      } 
      if (bool)
        paramSQLiteDatabase.setTransactionSuccessful(); 
      return;
    } finally {
      if (bool)
        paramSQLiteDatabase.endTransaction(); 
    } 
  }
  
  private ArrayList<String> b(SQLiteDatabase paramSQLiteDatabase, Collection<String> paramCollection) {
    ArrayList arrayList = new ArrayList();
    Cursor cursor = paramSQLiteDatabase.rawQuery("SELECT s_table_name FROM ts_table_profile WHERE s_table_name != 'td_uploading_tables' ", null);
    if (cursor != null) {
      while (cursor.moveToNext()) {
        String str = cursor.getString(0);
        if (paramCollection.contains(str))
          arrayList.add(str); 
      } 
      cursor.close();
    } 
    return arrayList;
  }
  
  public static String bw(Context paramContext) { // Byte code:
    //   0: new com/laiqian/sync/b/b
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Landroid/content/Context;)V
    //   8: astore #5
    //   10: aconst_null
    //   11: astore_3
    //   12: aconst_null
    //   13: astore #4
    //   15: aconst_null
    //   16: astore_0
    //   17: aload #5
    //   19: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   22: ldc_w 'select s_foreign_tables from ts_table_profile where s_table_name='td_uploading_tables';'
    //   25: aconst_null
    //   26: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_1
    //   33: invokeinterface moveToNext : ()Z
    //   38: ifeq -> 51
    //   41: aload_1
    //   42: astore_2
    //   43: aload_1
    //   44: iconst_0
    //   45: invokeinterface getString : (I)Ljava/lang/String;
    //   50: astore_0
    //   51: aload_0
    //   52: astore_2
    //   53: aload_1
    //   54: ifnull -> 105
    //   57: aload_1
    //   58: invokeinterface close : ()V
    //   63: aload_0
    //   64: astore_2
    //   65: goto -> 105
    //   68: astore_2
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: astore_1
    //   73: goto -> 85
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_2
    //   79: goto -> 113
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: astore_2
    //   87: aload_1
    //   88: invokestatic e : (Ljava/lang/Throwable;)V
    //   91: aload #4
    //   93: astore_2
    //   94: aload_0
    //   95: ifnull -> 105
    //   98: aload_0
    //   99: astore_1
    //   100: aload_3
    //   101: astore_0
    //   102: goto -> 57
    //   105: aload #5
    //   107: invokevirtual close : ()V
    //   110: aload_2
    //   111: areturn
    //   112: astore_0
    //   113: aload_2
    //   114: ifnull -> 123
    //   117: aload_2
    //   118: invokeinterface close : ()V
    //   123: aload_0
    //   124: athrow
    // Exception table:
    //   from	to	target	type
    //   17	30	82	java/lang/Exception
    //   17	30	76	finally
    //   32	41	68	java/lang/Exception
    //   32	41	112	finally
    //   43	51	68	java/lang/Exception
    //   43	51	112	finally
    //   87	91	112	finally }
  
  private void d(SQLiteDatabase paramSQLiteDatabase, String paramString) { paramSQLiteDatabase.execSQL("ATTACH ? AS ?", new String[] { paramString, "SPLIT_DB" }); }
  
  private void e(SQLiteDatabase paramSQLiteDatabase, @Nullable String paramString) {
    if (paramString != null) {
      paramSQLiteDatabase.execSQL((paramString = paramString.toLowerCase()).format("INSERT INTO %s.%s SELECT * FROM main.%s where s_table_name = ? or s_table_name = ?", new Object[] { "SPLIT_DB", "ts_table_profile", "ts_table_profile" }), new String[] { "td_uploading_tables", paramString });
      return;
    } 
    paramSQLiteDatabase.execSQL(String.format("INSERT INTO %s.%s SELECT * FROM main.%s", new Object[] { "SPLIT_DB", "ts_table_profile", "ts_table_profile" }), new String[0]);
  }
  
  private void i(SQLiteDatabase paramSQLiteDatabase) { paramSQLiteDatabase.execSQL("DETACH ?", new String[] { "SPLIT_DB" }); }
  
  private String kl(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("splited_db_");
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
    stringBuilder.append(this.aNN);
    stringBuilder.append("_");
    stringBuilder.append(paramInt);
    stringBuilder.append("_");
    stringBuilder.append(m.Tw());
    stringBuilder.append("_");
    stringBuilder.append(System.nanoTime());
    return stringBuilder.toString();
  }
  
  private void n(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.aNO != null) {
      Message message = new Message();
      int i = 97;
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramInt3 + 1);
        stringBuilder.append("");
        double d = Double.parseDouble(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramInt4 + 1);
        stringBuilder.append("");
        d = (new BigDecimal(d / Double.parseDouble(stringBuilder.toString()))).setScale(2, 4).doubleValue();
        i = (int)(d * 100.0D);
      } catch (Exception exception) {
        a.e(exception);
      } 
      message.what = i;
      message.obj = "split";
      message.arg1 = paramInt3 + 1;
      message.arg2 = paramInt4 + 1;
      Bundle bundle = new Bundle();
      bundle.putInt("nDb", paramInt1 + 1);
      bundle.putInt("nTotleDb", paramInt2);
      message.setData(bundle);
      this.aNO.sendMessage(message);
    } 
  }
  
  private ArrayList<HashMap<String, String>> v(Context paramContext, String paramString) {
    ArrayList arrayList = new ArrayList();
    HashMap hashMap = new HashMap();
    hashMap.put("FileName", paramString);
    hashMap.put("TableName", bw(paramContext));
    arrayList.add(hashMap);
    return arrayList;
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
    //   67: ldc_w 'SELECT sql FROM sqlite_master WHERE type='table' AND name=''
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #6
    //   76: aload_2
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload #6
    //   83: ldc_w '''
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: aload #6
    //   93: invokevirtual toString : ()Ljava/lang/String;
    //   96: aconst_null
    //   97: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore_1
    //   101: aload #5
    //   103: astore #4
    //   105: aload_1
    //   106: ifnull -> 221
    //   109: aload #5
    //   111: astore #4
    //   113: aload_1
    //   114: invokeinterface moveToFirst : ()Z
    //   119: ifeq -> 221
    //   122: aload_1
    //   123: aload_1
    //   124: ldc_w 'sql'
    //   127: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   132: invokeinterface getString : (I)Ljava/lang/String;
    //   137: astore #5
    //   139: aload_1
    //   140: invokeinterface close : ()V
    //   145: goto -> 217
    //   148: astore #6
    //   150: aload_1
    //   151: astore #4
    //   153: aload #5
    //   155: astore_1
    //   156: aload #6
    //   158: astore #5
    //   160: goto -> 181
    //   163: astore #5
    //   165: aconst_null
    //   166: astore #6
    //   168: aload_1
    //   169: astore #4
    //   171: aload #6
    //   173: astore_1
    //   174: goto -> 181
    //   177: astore #5
    //   179: aconst_null
    //   180: astore_1
    //   181: aload #5
    //   183: invokestatic e : (Ljava/lang/Throwable;)V
    //   186: aload_1
    //   187: astore #5
    //   189: aload #4
    //   191: ifnull -> 217
    //   194: aload_1
    //   195: astore #5
    //   197: aload #4
    //   199: invokeinterface isClosed : ()Z
    //   204: ifne -> 217
    //   207: aload #4
    //   209: invokeinterface close : ()V
    //   214: aload_1
    //   215: astore #5
    //   217: aload #5
    //   219: astore #4
    //   221: iload_3
    //   222: ifeq -> 241
    //   225: aload_0
    //   226: aload_2
    //   227: putfield aNR : Ljava/lang/String;
    //   230: aload_0
    //   231: aload #4
    //   233: putfield aNS : Ljava/lang/String;
    //   236: aload_0
    //   237: getfield aNS : Ljava/lang/String;
    //   240: areturn
    //   241: aload_0
    //   242: aload_2
    //   243: putfield aNP : Ljava/lang/String;
    //   246: aload_0
    //   247: aload #4
    //   249: putfield aNQ : Ljava/lang/String;
    //   252: aload_0
    //   253: getfield aNQ : Ljava/lang/String;
    //   256: areturn
    // Exception table:
    //   from	to	target	type
    //   56	101	177	java/lang/Exception
    //   113	139	163	java/lang/Exception
    //   139	145	148	java/lang/Exception }
  
  public ArrayList<HashMap<String, String>> a(Context paramContext, File paramFile, int paramInt) {
    try {
      return b(paramContext, paramFile, paramInt);
    } catch (Exception exception) {
      d.a(exception, "split error", new Object[0]);
      return v(paramContext, paramFile.getName());
    } 
  }
  
  public boolean a(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2, String paramString, boolean paramBoolean) {
    String str = a(paramSQLiteDatabase1, paramString, paramBoolean);
    if (str == null)
      throw new NullPointerException("cannot build sql"); 
    paramSQLiteDatabase2.execSQL(str);
    return true;
  }
  
  @DebugLog
  public File b(Context paramContext, Collection<String> paramCollection) {
    File file = new File(paramContext.getFilesDir().getParentFile(), kl(256));
    SQLiteDatabase sQLiteDatabase1 = a.Y(paramContext).getWritableDatabase();
    av av = new av(paramContext);
    String str = av.Tx();
    av.close();
    SQLiteDatabase sQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(file, null);
    sQLiteDatabase2.execSQL("PRAGMA auto_vacuum=1");
    a(sQLiteDatabase1, sQLiteDatabase2, "ts_table_profile", true);
    paramCollection = b(sQLiteDatabase1, paramCollection);
    d(sQLiteDatabase1, file.getAbsolutePath());
    e(sQLiteDatabase1, null);
    a(sQLiteDatabase1, paramCollection, str);
    i(sQLiteDatabase1);
    a(sQLiteDatabase2, Collections.EMPTY_LIST);
    a(sQLiteDatabase2, "T_PRODUCT", 0);
    sQLiteDatabase2.close();
    a.Y(paramContext).close();
    return file;
  }
  
  @DebugLog
  public ArrayList<HashMap<String, String>> b(Context paramContext, @NonNull File paramFile, int paramInt) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual exists : ()Z
    //   4: ifne -> 18
    //   7: new java/lang/IllegalStateException
    //   10: dup
    //   11: ldc_w 'database not exist or cannot be read'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: athrow
    //   18: new com/laiqian/util/av
    //   21: dup
    //   22: aload_1
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual Tx : ()Ljava/lang/String;
    //   31: astore #17
    //   33: aload_1
    //   34: invokevirtual close : ()V
    //   37: new java/util/ArrayList
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #16
    //   46: aload_2
    //   47: invokevirtual getParentFile : ()Ljava/io/File;
    //   50: astore #15
    //   52: aload_0
    //   53: aload_0
    //   54: getfield aNN : I
    //   57: iconst_1
    //   58: iadd
    //   59: putfield aNN : I
    //   62: aload_2
    //   63: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   66: aconst_null
    //   67: bipush #16
    //   69: invokestatic openDatabase : (Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   72: astore_1
    //   73: aload_1
    //   74: astore #12
    //   76: aload_1
    //   77: astore #13
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual j : (Landroid/database/sqlite/SQLiteDatabase;)[Ljava/lang/String;
    //   84: astore #14
    //   86: aload_1
    //   87: astore #12
    //   89: aload_1
    //   90: astore #13
    //   92: aload_0
    //   93: getfield doQ : [Ljava/lang/String;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull -> 116
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: getfield doQ : [Ljava/lang/String;
    //   107: astore #14
    //   109: goto -> 116
    //   112: astore_2
    //   113: goto -> 434
    //   116: iconst_0
    //   117: istore #7
    //   119: iconst_0
    //   120: istore #6
    //   122: aload #15
    //   124: astore_2
    //   125: aload_1
    //   126: astore #12
    //   128: aload_1
    //   129: astore #13
    //   131: aload #14
    //   133: arraylength
    //   134: istore #8
    //   136: iload #6
    //   138: iload #8
    //   140: if_icmpge -> 400
    //   143: aload_1
    //   144: astore #13
    //   146: aload #14
    //   148: iload #6
    //   150: aaload
    //   151: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   154: astore #15
    //   156: aload_1
    //   157: astore #13
    //   159: aload_0
    //   160: aload_1
    //   161: aload #15
    //   163: aload #17
    //   165: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)I
    //   168: istore #8
    //   170: iload #8
    //   172: ifle -> 364
    //   175: aload_1
    //   176: astore #13
    //   178: iload #8
    //   180: i2d
    //   181: ldc2_w 3000.0
    //   184: ddiv
    //   185: invokestatic ceil : (D)D
    //   188: dstore #4
    //   190: dload #4
    //   192: d2i
    //   193: istore #8
    //   195: iload #7
    //   197: istore #10
    //   199: iconst_0
    //   200: istore #9
    //   202: aload_2
    //   203: astore #12
    //   205: iload #6
    //   207: istore #7
    //   209: iload #10
    //   211: istore #6
    //   213: iload #9
    //   215: iload #8
    //   217: if_icmpge -> 354
    //   220: aload_1
    //   221: astore #13
    //   223: new java/io/File
    //   226: dup
    //   227: aload #12
    //   229: aload_0
    //   230: iload #6
    //   232: invokespecial kl : (I)Ljava/lang/String;
    //   235: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   238: astore #18
    //   240: aload_1
    //   241: astore #13
    //   243: aload #18
    //   245: invokevirtual exists : ()Z
    //   248: istore #11
    //   250: iload #11
    //   252: ifeq -> 270
    //   255: aload_1
    //   256: astore_2
    //   257: aload #18
    //   259: invokevirtual delete : ()Z
    //   262: pop
    //   263: goto -> 270
    //   266: astore_2
    //   267: goto -> 324
    //   270: aload #16
    //   272: aload_0
    //   273: aload #18
    //   275: aload_1
    //   276: aload #15
    //   278: iload #9
    //   280: sipush #3000
    //   283: imul
    //   284: sipush #3000
    //   287: iload_3
    //   288: aload #17
    //   290: invokespecial a : (Ljava/io/File;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;IIILjava/lang/String;)Ljava/util/HashMap;
    //   293: invokevirtual add : (Ljava/lang/Object;)Z
    //   296: pop
    //   297: aload_0
    //   298: iload #7
    //   300: aload #14
    //   302: arraylength
    //   303: iload #9
    //   305: iload #8
    //   307: invokespecial n : (IIII)V
    //   310: iload #6
    //   312: iconst_1
    //   313: iadd
    //   314: istore #6
    //   316: goto -> 328
    //   319: astore_2
    //   320: goto -> 324
    //   323: astore_2
    //   324: aload_2
    //   325: invokestatic e : (Ljava/lang/Throwable;)V
    //   328: iload #9
    //   330: iconst_1
    //   331: iadd
    //   332: istore #9
    //   334: goto -> 213
    //   337: astore_2
    //   338: aload_1
    //   339: astore #12
    //   341: aload_2
    //   342: astore_1
    //   343: aload #12
    //   345: astore_2
    //   346: goto -> 459
    //   349: astore #12
    //   351: goto -> 437
    //   354: aload #12
    //   356: astore_2
    //   357: iload #7
    //   359: istore #8
    //   361: goto -> 372
    //   364: iload #6
    //   366: istore #8
    //   368: iload #7
    //   370: istore #6
    //   372: iload #8
    //   374: iconst_1
    //   375: iadd
    //   376: istore #8
    //   378: iload #6
    //   380: istore #7
    //   382: iload #8
    //   384: istore #6
    //   386: goto -> 125
    //   389: astore_1
    //   390: aload #13
    //   392: astore_2
    //   393: goto -> 428
    //   396: astore_2
    //   397: goto -> 434
    //   400: aload_1
    //   401: ifnull -> 452
    //   404: aload_1
    //   405: invokevirtual close : ()V
    //   408: aload #16
    //   410: areturn
    //   411: astore_1
    //   412: aload #12
    //   414: astore_2
    //   415: goto -> 428
    //   418: astore_2
    //   419: aload #13
    //   421: astore_1
    //   422: goto -> 434
    //   425: astore_1
    //   426: aconst_null
    //   427: astore_2
    //   428: goto -> 459
    //   431: astore_2
    //   432: aconst_null
    //   433: astore_1
    //   434: aload_2
    //   435: astore #12
    //   437: aload_1
    //   438: astore_2
    //   439: aload #12
    //   441: invokestatic e : (Ljava/lang/Throwable;)V
    //   444: aload_1
    //   445: ifnull -> 452
    //   448: aload_1
    //   449: invokevirtual close : ()V
    //   452: aload #16
    //   454: areturn
    //   455: astore_1
    //   456: goto -> 428
    //   459: aload_2
    //   460: ifnull -> 467
    //   463: aload_2
    //   464: invokevirtual close : ()V
    //   467: aload_1
    //   468: athrow
    // Exception table:
    //   from	to	target	type
    //   62	73	431	java/lang/Exception
    //   62	73	425	finally
    //   79	86	418	java/lang/Exception
    //   79	86	411	finally
    //   92	97	418	java/lang/Exception
    //   92	97	411	finally
    //   103	109	112	java/lang/Exception
    //   103	109	455	finally
    //   131	136	418	java/lang/Exception
    //   131	136	411	finally
    //   146	156	396	java/lang/Exception
    //   146	156	389	finally
    //   159	170	396	java/lang/Exception
    //   159	170	389	finally
    //   178	190	396	java/lang/Exception
    //   178	190	389	finally
    //   223	240	323	java/lang/Exception
    //   223	240	389	finally
    //   243	250	323	java/lang/Exception
    //   243	250	389	finally
    //   257	263	266	java/lang/Exception
    //   257	263	455	finally
    //   270	310	319	java/lang/Exception
    //   270	310	337	finally
    //   324	328	349	java/lang/Exception
    //   324	328	337	finally
    //   439	444	455	finally }
  
  public final String[] j(SQLiteDatabase paramSQLiteDatabase) {
    String[] arrayOfString;
    SQLiteDatabase sQLiteDatabase = null;
    Cursor cursor = paramSQLiteDatabase.rawQuery("select * from ts_table_profile WHERE s_table_name = 'td_uploading_tables' ;", null);
    paramSQLiteDatabase = sQLiteDatabase;
    if (cursor.moveToFirst())
      arrayOfString = cursor.getString(cursor.getColumnIndex("s_foreign_tables")).split(","); 
    cursor.close();
    return arrayOfString;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */