package com.laiqian.version;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.backup.ag;
import com.laiqian.db.a;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.db.multidatabase.d.c;
import com.laiqian.milestone.StartScreen;
import com.laiqian.milestone.h;
import com.laiqian.pos.bl;
import com.laiqian.util.an;
import com.laiqian.util.bb;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class s extends h {
  private boolean aIx = true;
  
  public boolean dJO = false;
  
  private String dJP = "backup-";
  
  float dJQ = 0.0F;
  
  float dJR = 0.0F;
  
  public s(Context paramContext) {
    super(paramContext);
    bb.e("laiqian_upgrade_version", "upgrade method start.");
    this.context = paramContext;
    co(paramContext);
  }
  
  private void P(Map<String, List<String>> paramMap) {
    for (String str : b.b(new File(a.aOz), new ArrayList())) {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase(str, null, 16, new c());
      for (Map.Entry entry : paramMap.entrySet()) {
        for (String str1 : (List)entry.getValue()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("alter table ");
          stringBuilder.append((String)entry.getKey());
          stringBuilder.append(" add ");
          stringBuilder.append(str1);
          str1 = stringBuilder.toString();
          stringBuilder = new StringBuilder();
          stringBuilder.append(getClass().getSimpleName());
          stringBuilder.append("branchDbPath-->");
          stringBuilder.append(str);
          stringBuilder.append("--addNewFields2BranchDbs--");
          stringBuilder.append((String)entry.getKey());
          stringBuilder.append("--addField-->");
          stringBuilder.append(str1);
          b.ct(stringBuilder.toString());
          sQLiteDatabase.execSQL(str1);
        } 
      } 
      sQLiteDatabase.close();
    } 
  }
  
  private HashMap<String, List<String>> a(SQLiteDatabase paramSQLiteDatabase, Map<String, List<String>> paramMap) {
    hashMap = new HashMap();
    cursor = paramSQLiteDatabase.rawQuery("select name,sql from sqlite_master where type='table' and tbl_name like '%DOC%' or tbl_name='ts_table_profile'", null);
    label33: while (true) {
      try {
        if (cursor.moveToNext()) {
          String str = cursor.getString(0);
          null = cursor.getString(1);
          null = new StringBuilder();
          null.append("sql---->");
          null.append(null);
          b.ct(null.toString());
          null = null.substring(null.indexOf("(", 0) + 1, null.lastIndexOf(")"));
          null = new StringBuilder();
          null.append(getClass().getSimpleName());
          null.append("--getEntireFieldFromSql()-tablename=");
          null.append(str);
          null.append("-sql_field-->");
          null.append(null);
          b.ct(null.toString());
          String[] arrayOfString = null.split(",");
          for (Map.Entry entry : paramMap.entrySet()) {
            if (str.equalsIgnoreCase((String)entry.getKey())) {
              ArrayList arrayList = new ArrayList();
              Iterator iterator = ((List)entry.getValue()).iterator();
              while (true) {
                if (iterator.hasNext()) {
                  String str1 = (String)iterator.next();
                  int i = arrayOfString.length;
                  for (byte b = 0; b < i; b++) {
                    String str2 = arrayOfString[b];
                    if (str2.contains(str1))
                      arrayList.add(str2); 
                  } 
                  continue;
                } 
                if (!arrayList.isEmpty()) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(str);
                  stringBuilder.append("--新增完整的字段-->");
                  stringBuilder.append(arrayList.toString());
                  b.ct(stringBuilder.toString());
                  hashMap.put(str, arrayList);
                  continue label33;
                } 
                continue label33;
              } 
            } 
          } 
          continue;
        } 
        return hashMap;
      } finally {
        if (cursor != null)
          cursor.close(); 
      } 
    } 
  }
  
  private boolean a(String[][] paramArrayOfString) {
    bb.e("laiqian_upgrade_version", paramArrayOfString.toString());
    byte b = -1;
    boolean bool = true;
    while (true) {
      byte b1 = b + 1;
      if (b < paramArrayOfString.length - 1 && bool) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index-->");
        stringBuilder.append(b1);
        stringBuilder.append("--length-->");
        stringBuilder.append(paramArrayOfString.length);
        b.ct(stringBuilder.toString());
        bb.e("laiqian_upgrade_version", "sDeleteTrialAccountRecord start");
        bool = b(paramArrayOfString[b1][0], paramArrayOfString[b1][1], true);
        bb.e("laiqian_upgrade_version", "updateFromServerByTableNameWithUtilization end");
        if (this.aIx) {
          String str = "success";
          if (!bool)
            str = "failed"; 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramArrayOfString[b1][0]);
          stringBuilder1.append(" upgradeResult ");
          stringBuilder1.append(str);
          bb.e("laiqian_upgrade_version", stringBuilder1.toString());
        } 
        b = b1;
        continue;
      } 
      break;
    } 
    paramArrayOfString = (String[][])null;
    return bool;
  }
  
  private boolean axj() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dJQ);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    this.bJQ.execSQL("update t_string set sFieldValue=? where _id=0 and nFieldType=0;", new String[] { str });
    return true;
  }
  
  private static <T> List<T> b(T[] paramArrayOfT1, T[] paramArrayOfT2) {
    paramArrayOfT1 = (T[])Arrays.asList(paramArrayOfT1);
    ArrayList arrayList = new ArrayList();
    int i = paramArrayOfT2.length;
    for (byte b = 0; b < i; b++) {
      T t = paramArrayOfT2[b];
      if (!paramArrayOfT1.contains(t))
        arrayList.add(t); 
    } 
    return arrayList;
  }
  
  private List<String> b(String[] paramArrayOfString1, String[] paramArrayOfString2) { return b(paramArrayOfString1, paramArrayOfString2); }
  
  private HashMap<String, List<String>> c(HashMap<String, String[]> paramHashMap1, HashMap<String, String[]> paramHashMap2) {
    null = paramHashMap1.entrySet();
    Set set = paramHashMap2.entrySet();
    paramHashMap2 = new HashMap<String, String[]>();
    for (Map.Entry entry : null) {
      String str = (String)entry.getKey();
      for (Map.Entry entry1 : set) {
        String str1 = (String)entry1.getKey();
        if (str.equalsIgnoreCase(str1))
          paramHashMap2.put(str1, b((String[])entry.getValue(), (String[])entry1.getValue())); 
      } 
    } 
    return paramHashMap2;
  }
  
  private void co(Context paramContext) {
    this.dJQ = Float.parseFloat(StartScreen.aJ(paramContext));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("fNewVersion value is ");
    stringBuilder1.append(this.dJQ);
    bb.e("laiqian_upgrade_version", stringBuilder1.toString());
    String str = getVersion();
    if (str.isEmpty() || str == null) {
      this.dJO = false;
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("oldVersion value is ");
    stringBuilder2.append(str);
    bb.e("laiqian_upgrade_version", stringBuilder2.toString());
    this.dJR = Float.parseFloat(str);
    if (this.dJR > 10000.0F)
      this.dJR /= 10000.0F; 
    if (this.dJQ > this.dJR)
      this.dJO = true; 
  }
  
  private String[][] so(String paramString) { // Byte code:
    //   0: aconst_null
    //   1: checkcast [[Ljava/lang/String;
    //   4: astore #6
    //   6: aload_1
    //   7: aconst_null
    //   8: invokestatic openOrCreateDatabase : (Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore_1
    //   12: aload_1
    //   13: ldc_w ' select * from ts_table_profile WHERE s_table_name like 't\_%' ESCAPE '\';'
    //   16: aconst_null
    //   17: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore #5
    //   22: new java/util/ArrayList
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore #8
    //   31: new java/util/ArrayList
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #9
    //   40: aload #5
    //   42: invokeinterface moveToFirst : ()Z
    //   47: istore #4
    //   49: iload #4
    //   51: ifeq -> 112
    //   54: aload #8
    //   56: aload #5
    //   58: aload #5
    //   60: ldc_w 's_table_name'
    //   63: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   68: invokeinterface getString : (I)Ljava/lang/String;
    //   73: invokevirtual add : (Ljava/lang/Object;)Z
    //   76: pop
    //   77: aload #9
    //   79: aload #5
    //   81: aload #5
    //   83: ldc_w 'n_table_type'
    //   86: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   91: invokeinterface getString : (I)Ljava/lang/String;
    //   96: invokevirtual add : (Ljava/lang/Object;)Z
    //   99: pop
    //   100: aload #5
    //   102: invokeinterface moveToNext : ()Z
    //   107: istore #4
    //   109: goto -> 49
    //   112: aload #5
    //   114: invokeinterface close : ()V
    //   119: aload_0
    //   120: getfield dJR : F
    //   123: f2d
    //   124: ldc2_w 10.3
    //   127: dcmpg
    //   128: ifge -> 218
    //   131: iconst_3
    //   132: anewarray java/lang/String
    //   135: astore #5
    //   137: aload #5
    //   139: iconst_0
    //   140: ldc_w 't_shift'
    //   143: aastore
    //   144: aload #5
    //   146: iconst_1
    //   147: ldc_w 't_food_table'
    //   150: aastore
    //   151: aload #5
    //   153: iconst_2
    //   154: ldc_w 't_bpartner_pointsdoc'
    //   157: aastore
    //   158: aload #5
    //   160: arraylength
    //   161: istore_3
    //   162: iconst_0
    //   163: istore_2
    //   164: iload_2
    //   165: iload_3
    //   166: if_icmpge -> 218
    //   169: aload #5
    //   171: iload_2
    //   172: aaload
    //   173: astore #7
    //   175: aload #8
    //   177: aload #7
    //   179: invokevirtual contains : (Ljava/lang/Object;)Z
    //   182: ifeq -> 188
    //   185: goto -> 335
    //   188: aload_0
    //   189: aload_1
    //   190: aload #7
    //   192: invokevirtual g : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   195: ifeq -> 335
    //   198: aload #8
    //   200: aload #7
    //   202: invokevirtual add : (Ljava/lang/Object;)Z
    //   205: pop
    //   206: aload #9
    //   208: ldc_w '0'
    //   211: invokevirtual add : (Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -> 335
    //   218: aload #8
    //   220: invokevirtual size : ()I
    //   223: istore_3
    //   224: ldc java/lang/String
    //   226: iconst_2
    //   227: newarray int
    //   229: dup
    //   230: iconst_0
    //   231: iload_3
    //   232: iastore
    //   233: dup
    //   234: iconst_1
    //   235: iconst_2
    //   236: iastore
    //   237: invokestatic newInstance : (Ljava/lang/Class;[I)Ljava/lang/Object;
    //   240: checkcast [[Ljava/lang/String;
    //   243: astore #7
    //   245: iconst_0
    //   246: istore_2
    //   247: aload #7
    //   249: astore #6
    //   251: aload_1
    //   252: astore #5
    //   254: iload_2
    //   255: iload_3
    //   256: if_icmpge -> 301
    //   259: aload #7
    //   261: iload_2
    //   262: aaload
    //   263: iconst_0
    //   264: aload #8
    //   266: iload_2
    //   267: invokevirtual get : (I)Ljava/lang/Object;
    //   270: checkcast java/lang/String
    //   273: aastore
    //   274: aload #7
    //   276: iload_2
    //   277: aaload
    //   278: iconst_1
    //   279: aload #9
    //   281: iload_2
    //   282: invokevirtual get : (I)Ljava/lang/Object;
    //   285: checkcast java/lang/String
    //   288: aastore
    //   289: iload_2
    //   290: iconst_1
    //   291: iadd
    //   292: istore_2
    //   293: goto -> 247
    //   296: aconst_null
    //   297: astore_1
    //   298: aload_1
    //   299: astore #5
    //   301: aload #5
    //   303: ifnull -> 311
    //   306: aload #5
    //   308: invokevirtual close : ()V
    //   311: aload #6
    //   313: areturn
    //   314: astore_1
    //   315: goto -> 296
    //   318: astore #5
    //   320: goto -> 298
    //   323: astore #5
    //   325: aload #7
    //   327: astore #6
    //   329: aload_1
    //   330: astore #5
    //   332: goto -> 301
    //   335: iload_2
    //   336: iconst_1
    //   337: iadd
    //   338: istore_2
    //   339: goto -> 164
    // Exception table:
    //   from	to	target	type
    //   6	12	314	java/lang/Exception
    //   12	49	318	java/lang/Exception
    //   54	109	318	java/lang/Exception
    //   112	137	318	java/lang/Exception
    //   158	162	318	java/lang/Exception
    //   175	185	318	java/lang/Exception
    //   188	215	318	java/lang/Exception
    //   218	245	318	java/lang/Exception
    //   259	289	323	java/lang/Exception }
  
  public void axh() {
    if (this.dJR < 11.8D)
      try {
        bl bl = new bl(this.context);
        bl.ZP();
        bl.close();
        return;
      } catch (Exception exception) {
        a.e(exception);
      }  
  }
  
  public boolean axi() {
    Log.i("laiqian_upgrade_version", "开始升级upgradeToNewVersion start");
    boolean bool2 = this.dJO;
    boolean bool = false;
    boolean bool1 = bool;
    if (bool2) {
      bb.e("laiqian_upgrade_version", "bUpgrade is true");
      a.Dh();
      Log.i("laiqian_upgrade_version", "DatabaseHelper.releaseAllInstances()");
      bool1 = ag.za();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("isSDCardAvailable");
      stringBuilder2.append(bool1);
      Log.i("laiqian_upgrade_version", stringBuilder2.toString());
      if (bool1) {
        bool1 = ag.b(this.context, false);
        bb.e("laiqian_upgrade_version", "备份laiqiandb到SD卡BackUpToSDCard");
        if (this.aIx && bool1)
          Log.i("laiqian_upgrade_version", "success on backup laiqian.db to SDCARD laiqian folder"); 
      } 
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("/data/data/");
      stringBuilder2.append(this.context.getPackageName());
      stringBuilder2.append("/");
      stringBuilder2.append(this.bJU);
      File file = new File(stringBuilder2.toString());
      null = new SimpleDateFormat("yy-MM-dd.HH-mm-ss");
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("/data/data/");
      stringBuilder3.append(this.context.getPackageName());
      stringBuilder3.append("/");
      stringBuilder3.append(this.dJP);
      stringBuilder3.append(null.format(new Date()));
      String str = stringBuilder3.toString();
      bool1 = file.renameTo(new File(str));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("将旧有的laiqian.db改名--fOldFile.renameTo(fOldBackupFile);");
      stringBuilder1.append(bool1);
      bb.e("laiqian_upgrade_version", stringBuilder1.toString());
      if (bool1) {
        SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(str, null, new c());
        b.aOw.e(sQLiteDatabase);
        bool1 = sp(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadFromOldDb---->");
        stringBuilder.append(bool1);
        bb.e("laiqian_upgrade_version", stringBuilder.toString());
      } else {
        bool1 = bool;
        if (this.aIx) {
          bb.e("laiqian_upgrade_version", "failed on rename old file");
          bool1 = bool;
        } 
      } 
    } 
    if (bool1)
      an.asT(); 
    return bool1;
  }
  
  public boolean g(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * FROM sqlite_master WHERE type='table' AND name='");
    stringBuilder.append(paramString.toUpperCase());
    stringBuilder.append("'");
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder.toString(), null);
    if (cursor.getCount() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    cursor.close();
    return bool;
  }
  
  protected String h(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("select * from ");
    stringBuilder2.append(paramString);
    stringBuilder2.append(" limit(0)");
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder2.toString(), null);
    int i = cursor.getColumnCount();
    for (byte b = 0; b < i; b++) {
      stringBuilder1.append(cursor.getColumnName(b));
      if (b < cursor.getColumnCount() - 1) {
        stringBuilder1.append(",");
      } else {
        stringBuilder1.append(")");
      } 
    } 
    cursor.close();
    String str = stringBuilder1.toString();
    a(stringBuilder1);
    return str;
  }
  
  public HashMap<String, String[]> o(SQLiteDatabase paramSQLiteDatabase) {
    hashMap = new HashMap();
    cursor = paramSQLiteDatabase.rawQuery("select name,sql from sqlite_master where type='table' and tbl_name like '%DOC%' or tbl_name='ts_table_profile'", null);
    try {
      while (cursor.moveToNext()) {
        String str = cursor.getString(0);
        if (str != null) {
          String str1 = h(paramSQLiteDatabase, str);
          str1 = str1.substring(str1.indexOf("(", 0) + 1, str1.lastIndexOf(")"));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(getClass().getSimpleName());
          stringBuilder.append("--getDbFiled()---");
          stringBuilder.append(str);
          stringBuilder.append("-tableFiled--");
          stringBuilder.append(str1);
          b.ct(stringBuilder.toString());
          hashMap.put(str, str1.split(","));
        } 
      } 
      return hashMap;
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  public boolean sp(String paramString) {
    boolean bool;
    String[][] arrayOfString = so(paramString);
    boolean bool1 = false;
    if (arrayOfString == null)
      return false; 
    if (this.dJR < 13.508D)
      b.Dp(); 
    null = new StringBuilder();
    null.append(getClass().getSimpleName());
    null.append("------获取原来从库表的字段-----");
    b.ct(null.toString());
    HashMap hashMap1 = o(b.aOw.Dk());
    aK(this.context);
    this.bJQ = SQLiteDatabase.openOrCreateDatabase(a.aOB, null, new c());
    b.aOw.e(this.bJQ);
    b.Do();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(getClass().getSimpleName());
    stringBuilder2.append("------获取现在新的从库表的字段-----");
    b.ct(stringBuilder2.toString());
    HashMap hashMap2 = o(this.bJQ);
    hashMap1 = a(this.bJQ, c(hashMap1, hashMap2));
    if (hashMap1.size() != 0)
      P(hashMap1); 
    SQLiteDatabase sQLiteDatabase = this.bJQ;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("ATTACH DATABASE '");
    stringBuilder1.append(paramString);
    stringBuilder1.append("' AS serverDB");
    sQLiteDatabase.execSQL(stringBuilder1.toString());
    try {
      boolean bool2 = a(arrayOfString);
      bool = bool2;
      if (bool2) {
        aT(this.bKe);
        bool = axj();
      } 
    } catch (Exception paramString) {
      bb.e("laiqian_upgrade_version", paramString.toString());
      bool = bool1;
    } 
    this.bJQ.execSQL("DETACH DATABASE serverDB");
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */