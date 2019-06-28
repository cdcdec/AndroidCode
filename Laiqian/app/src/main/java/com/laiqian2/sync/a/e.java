package com.laiqian.sync.a;

import android.content.Context;
import android.database.Cursor;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v4.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.dcb.api.b.c;
import com.laiqian.f.c;
import com.laiqian.k.a;
import com.laiqian.models.bh;
import com.laiqian.sync.b.a;
import com.laiqian.sync.b.b;
import com.laiqian.sync.c.a;
import com.laiqian.sync.c.b;
import com.laiqian.sync.c.c;
import com.laiqian.sync.c.d;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.sync.model.h;
import com.laiqian.sync.model.i;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bz;
import com.laiqian.util.l;
import hugo.weaving.DebugLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class e {
  public static int don = 0;
  
  public static boolean doo = false;
  
  public static boolean dop = false;
  
  public static boolean dov = a.dpm;
  
  public String TAG = "CloudDataUtils";
  
  String aDZ = "";
  
  Handler aNO = null;
  
  private i aZq;
  
  private long bKe = -1L;
  
  protected long bLj = -1L;
  
  protected long bLk = -1L;
  
  private String cgt = null;
  
  String[] doq = null;
  
  String dor = "";
  
  public boolean dos = true;
  
  int dou = 0;
  
  private ArrayList<HashMap<String, String>> dow = null;
  
  private SyncProgessMessage dox;
  
  private h doy;
  
  protected Context mContext = null;
  
  public e(Context paramContext) {
    this.mContext = paramContext;
    this.bKe = Long.parseLong((new av(paramContext)).atm());
  }
  
  private boolean aV(String paramString1, String paramString2) { return c.B(paramString1, paramString2); }
  
  protected static String apu() { // Byte code:
    //   0: ldc com/laiqian/sync/a/e
    //   2: monitorenter
    //   3: getstatic com/laiqian/sync/a/e.don : I
    //   6: sipush #1000
    //   9: if_icmple -> 16
    //   12: iconst_0
    //   13: putstatic com/laiqian/sync/a/e.don : I
    //   16: getstatic com/laiqian/sync/a/e.don : I
    //   19: iconst_1
    //   20: iadd
    //   21: putstatic com/laiqian/sync/a/e.don : I
    //   24: new java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: astore_0
    //   32: aload_0
    //   33: ldc 'upload_'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_0
    //   40: getstatic com/laiqian/sync/a/e.don : I
    //   43: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_0
    //   48: ldc '.db'
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_0
    //   55: invokevirtual toString : ()Ljava/lang/String;
    //   58: astore_0
    //   59: ldc com/laiqian/sync/a/e
    //   61: monitorexit
    //   62: aload_0
    //   63: areturn
    //   64: astore_0
    //   65: ldc com/laiqian/sync/a/e
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	64	finally
    //   16	59	64	finally }
  
  private String b(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    Cursor cursor = paramSQLiteDatabase.rawQuery("SELECT s_client_id_list FROM ts_table_profile WHERE s_table_name = ? ", new String[] { paramString });
    cursor.moveToFirst();
    paramString = cursor.getString(0);
    cursor.close();
    return paramString;
  }
  
  private int c(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    Cursor cursor = paramSQLiteDatabase.rawQuery("SELECT n_table_type FROM ts_table_profile WHERE s_table_name = ?", new String[] { paramString });
    cursor.moveToFirst();
    int j = cursor.getInt(0);
    cursor.close();
    return j;
  }
  
  private String[] h(SQLiteDatabase paramSQLiteDatabase) {
    Cursor cursor = paramSQLiteDatabase.rawQuery("SELECT s_foreign_tables FROM ts_table_profile WHERE s_table_name = ?", new String[] { "td_uploading_tables" });
    cursor.moveToFirst();
    String str = cursor.getString(0);
    cursor.close();
    return str.split(",");
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("更改table=");
    stringBuilder.append(paramString1);
    stringBuilder.append("--ids=");
    stringBuilder.append(paramString2);
    stringBuilder.append("上传标记");
    b.ct(stringBuilder.toString());
    if (paramInt == 1) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("UPDATE ");
      stringBuilder.append(paramString1);
      stringBuilder.append(" SET nIsUpdated = 2  WHERE _id IN (");
      stringBuilder.append(paramString2);
      stringBuilder.append(")");
      paramSQLiteDatabase.execSQL(stringBuilder.toString());
      return;
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" SET nIsUpdated = 2  WHERE _id IN (");
    stringBuilder.append(paramString2);
    stringBuilder.append(")");
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {
    if (!paramBoolean) {
      if (paramInt == 1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("UPDATE ");
        stringBuilder2.append(paramString1);
        stringBuilder2.append(" SET nIsUpdated = 1, nUpdateFlag = 1 WHERE _id IN (");
        stringBuilder2.append(paramString2);
        stringBuilder2.append(")");
        paramSQLiteDatabase.execSQL(stringBuilder2.toString());
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 1, nUpdateFlag = CASE WHEN nUpdateFlag is null THEN 1 WHEN nUpdateFlag = 0 THEN 1 WHEN nUpdateFlag >= 1 THEN nUpdateFlag END WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(")");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    if (paramInt == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 1, nUpdateFlag = 1 WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(") AND nIsUpdated = 2");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" SET nIsUpdated = 1, nUpdateFlag = CASE WHEN nUpdateFlag is null THEN 1 WHEN nUpdateFlag = 0 THEN 1 WHEN nUpdateFlag >= 1 THEN nUpdateFlag END WHERE _id IN (");
    stringBuilder.append(paramString2);
    stringBuilder.append(") AND nIsUpdated = 2");
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, File paramFile) { a(paramSQLiteDatabase, paramFile, false); }
  
  @DebugLog
  public void a(SQLiteDatabase paramSQLiteDatabase, File paramFile, boolean paramBoolean) {
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase(paramFile.getAbsolutePath(), null, 16, new DefaultDatabaseErrorHandler());
    paramSQLiteDatabase.beginTransaction();
    try {
      for (String str1 : h(sQLiteDatabase)) {
        String str2 = b(sQLiteDatabase, str1);
        if (LQKVersion.zg())
          bz.g(str1, str2, true); 
        a(paramSQLiteDatabase, c(sQLiteDatabase, str1), str1, str2, paramBoolean);
      } 
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      if (sQLiteDatabase != null) {
        sQLiteDatabase.close();
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
      paramSQLiteDatabase.endTransaction();
      if (sQLiteDatabase != null) {
        sQLiteDatabase.close();
        return;
      } 
    } finally {
      String str;
    } 
  }
  
  public void a(SyncProgessMessage paramSyncProgessMessage) { this.dox = paramSyncProgessMessage; }
  
  public void a(h paramh) {
    av av = new av(this.mContext);
    av.qJ(paramh.Ea());
    av.qL(paramh.getPassword());
    av.qG("-1");
    av.qD("-1");
    av.close();
  }
  
  public void a(i parami) { this.aZq = parami; }
  
  public boolean a(long paramLong1, long paramLong2, Context paramContext, String paramString) {
    b b = new b(paramContext);
    System.currentTimeMillis();
    boolean bool = b.d(paramLong1, paramLong2, paramString);
    if (bool) {
      this.dox.setResult(1);
      this.dox.kn(4001);
    } else {
      this.dox.setResult(0);
      this.dox.kn(6003);
    } 
    b.close();
    return bool;
  }
  
  @DebugLog
  protected boolean a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong) throws Exception {
    int k;
    int j = paramArrayList.size();
    bh bh = new bh(this.mContext);
    SQLiteDatabase sQLiteDatabase = bh.Vq();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("客户端有");
    stringBuilder.append(j);
    stringBuilder.append("个上传文件");
    bb.fU(stringBuilder.toString());
    byte b = 0;
    while (true) {
      k = j - 1;
      if (b < k) {
        String str1 = (String)((HashMap)paramArrayList.get(b)).get("FileName");
        String str3 = (String)((HashMap)paramArrayList.get(b)).get("TableName");
        long l = System.currentTimeMillis();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramLong);
        stringBuilder2.append("-");
        stringBuilder2.append(l);
        stringBuilder2.append(".");
        stringBuilder2.append(m.bVl);
        String str2 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("开始上传第");
        stringBuilder3.append(++b);
        stringBuilder3.append("个上传数据");
        bb.fU(stringBuilder3.toString());
        this.doy.km(13);
        this.doy.setFileName(str2);
        String str4 = this.doy.apL();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(paramLong);
        stringBuilder4.append("");
        this.dos = h(str1, stringBuilder4.toString(), dj(paramLong), str2, str4);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("上传第");
        stringBuilder1.append(b);
        stringBuilder1.append("个数据，结果");
        stringBuilder1.append(this.dos);
        stringBuilder1.append("，用时：");
        stringBuilder1.append(System.currentTimeMillis() - l);
        stringBuilder1.append("毫秒");
        bb.fU(stringBuilder1.toString());
        if (!this.dos) {
          bh.close();
          return false;
        } 
        a(sQLiteDatabase, new File(str1));
        continue;
      } 
      break;
    } 
    if (b == k) {
      bb.fU("客户端处理最后一个上传文件");
      String str3 = (String)((HashMap)paramArrayList.get(b)).get("FileName");
      String str2 = (String)((HashMap)paramArrayList.get(b)).get("TableName");
      long l = System.currentTimeMillis();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLong);
      stringBuilder1.append("-");
      stringBuilder1.append(l);
      stringBuilder1.append(".");
      stringBuilder1.append(m.bVl);
      String str1 = stringBuilder1.toString();
      this.doy.km(15);
      this.doy.setFileName(str1);
      String str4 = this.doy.apL();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramLong);
      stringBuilder2.append("");
      this.dos = h(str3, stringBuilder2.toString(), dj(paramLong), str1, str4);
      if (this.dos)
        a(sQLiteDatabase, new File(str3)); 
      bh.close();
      return this.dos;
    } 
    bh.close();
    return true;
  }
  
  public i apq() {
    a(this.doy);
    str = this.doy.apL();
    try {
      str = this.doy.aX(a.url, str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("login请求地址是: ");
      stringBuilder.append(a.url);
      stringBuilder.append(". 返回的结果字符串是:");
      stringBuilder.append(str);
      bb.fU(stringBuilder.toString());
      return nS(str);
    } catch (Exception str) {
      a.e(str);
      return null;
    } 
  }
  
  public i apr() {
    String str1 = this.doy.apL();
    String str2 = this.doy.aX(a.url, str1);
    i i1 = new i();
    i1.ox(str2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("客户端请求准备下载数据的地址是");
    stringBuilder.append(a.url);
    stringBuilder.append(". 返回结果:");
    stringBuilder.append(i1.toString());
    bb.fU(stringBuilder.toString());
    return i1;
  }
  
  public String aps() { return a.dpH; }
  
  public String apt() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getUserID());
    stringBuilder.append(".download");
    return stringBuilder.toString();
  }
  
  public String apv() { return ".download"; }
  
  public String apw() { return ".lq"; }
  
  public void b(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {
    if (!paramBoolean) {
      if (paramInt == 1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("UPDATE ");
        stringBuilder2.append(paramString1);
        stringBuilder2.append(" SET nIsUpdated = 0,  nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END) WHERE _id IN (");
        stringBuilder2.append(paramString2);
        stringBuilder2.append(")");
        paramSQLiteDatabase.execSQL(stringBuilder2.toString());
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 0,  nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END)  WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(")");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    if (paramInt == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 0,  nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END)  WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(") AND nIsUpdated = 2");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" SET nIsUpdated = 0,  nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END)  WHERE _id IN (");
    stringBuilder.append(paramString2);
    stringBuilder.append(") AND nIsUpdated = 2");
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
  }
  
  public void b(SQLiteDatabase paramSQLiteDatabase, File paramFile) {
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase(paramFile.getAbsolutePath(), null, 16);
    paramSQLiteDatabase.beginTransaction();
    try {
      for (String str1 : h(sQLiteDatabase)) {
        String str2 = b(sQLiteDatabase, str1);
        if (LQKVersion.zg())
          bz.g(str1, str2, true); 
        a(paramSQLiteDatabase, c(sQLiteDatabase, str1), str1, str2);
      } 
      paramSQLiteDatabase.setTransactionSuccessful();
    } catch (Exception exception) {
      a.e(exception);
    } finally {}
    paramSQLiteDatabase.endTransaction();
    sQLiteDatabase.close();
  }
  
  public void b(SQLiteDatabase paramSQLiteDatabase, File paramFile, boolean paramBoolean) {
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(paramFile, null);
    paramSQLiteDatabase.beginTransaction();
    try {
      for (String str1 : h(sQLiteDatabase)) {
        String str2 = b(sQLiteDatabase, str1);
        if (LQKVersion.zg())
          bz.g(str1, str2, true); 
        b(paramSQLiteDatabase, c(sQLiteDatabase, str1), str1, str2, paramBoolean);
      } 
      paramSQLiteDatabase.setTransactionSuccessful();
    } catch (Exception exception) {
      a.e(exception);
    } finally {}
    paramSQLiteDatabase.endTransaction();
    sQLiteDatabase.close();
  }
  
  public void b(h paramh) { this.doy = paramh; }
  
  public boolean b(boolean paramBoolean, List<String> paramList) {
    if (paramBoolean)
      return g(paramBoolean, ""); 
    Iterator iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (!g(paramBoolean, (String)iterator.next()))
        return false; 
    } 
    return true;
  }
  
  protected boolean c(File paramFile, int paramInt) {
    a a = new a(this.doq);
    try {
      this.dow = a.a(this.mContext.getApplicationContext(), paramFile, paramInt);
      this.dox.setProgress(28);
      return true;
    } catch (Exception paramFile) {
      a.e(paramFile);
      this.dox.setResult(0);
      this.dox.kn(2004);
      return false;
    } 
  }
  
  public void close() { this.mContext = null; }
  
  protected String dj(long paramLong) { return l.dj(paramLong); }
  
  protected boolean f(String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      String str = dj(Long.parseLong(paramString2));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append("?");
      stringBuilder.append(a.bUy);
      stringBuilder.append("=");
      stringBuilder.append(paramString2);
      stringBuilder.append("&");
      stringBuilder.append(a.bUx);
      stringBuilder.append("=");
      stringBuilder.append(str);
      stringBuilder.append("&");
      stringBuilder.append(a.bUA);
      stringBuilder.append("=");
      stringBuilder.append(c.E(paramString2, str));
      paramString1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString4);
      stringBuilder.append(a.bVk);
      boolean bool = c.a(paramString1, paramString3, stringBuilder.toString(), paramString2, str, true);
      this.dox.setProgress(78);
      if (bool) {
        Context context = this.mContext;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString3);
        stringBuilder1.append(paramString4);
        stringBuilder1.append(m.bVk);
        String str1 = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramString3);
        stringBuilder2.append(paramString4);
        if ((new b(context, str1, stringBuilder2.toString(), b.aQf)).aQh) {
          bb.e(this.TAG, "download and extraction success");
          return true;
        } 
        this.dox.setResult(0);
        this.dox.kn(6001);
        bb.e(this.TAG, "extraction failed");
        return false;
      } 
      this.dox.setResult(0);
      this.dox.kn(3003);
      bb.e(this.TAG, "download failed");
      return false;
    } catch (Exception paramString1) {
      a.e(paramString1);
      return false;
    } 
  }
  
  public boolean g(boolean paramBoolean, String paramString) {
    if (this.dos) {
      bb.fU("客户端创建上传数据库文件");
      System.currentTimeMillis();
      a.start();
      this.dor = apu();
      if (this.cgt != null && !this.cgt.equals(""))
        this.doq = this.cgt.split(","); 
      this.dou = 0;
      Calendar.getInstance();
      null = new StringBuilder();
      null.append(this.mContext.getFilesDir().getParent());
      null.append(File.separator);
      null.append("laiqian.db");
      String str = null.toString();
      if (paramBoolean)
        paramString = str; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getFilesDir().getParent());
      stringBuilder.append(File.separator);
      stringBuilder.append(this.dor);
      this.dos = aV(paramString, stringBuilder.toString());
      this.dox.setProgress(18);
      if (!this.dos) {
        this.dox.setResult(0);
        this.dox.kn(2001);
        return false;
      } 
    } 
    if (this.dos) {
      bb.fU("客户端分割上传数据库文件");
      System.currentTimeMillis();
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getFilesDir().getParent());
      stringBuilder.append(File.separator);
      stringBuilder.append(this.dor);
      this.dos = c(new File(stringBuilder.toString()), this.dou);
      if (this.dos) {
        bb.fU("客户端上传创建好的数据库文件");
        a.bc("create_file", a.asv());
        a.start();
        try {
          this.dos = a(this.dow, this.bKe);
        } catch (Exception stringBuilder) {
          a.e(stringBuilder);
        } 
        a.bc("upload_file", a.asv());
      } 
    } 
    return this.dos;
  }
  
  public Pair<Boolean, List<String>> gQ(boolean paramBoolean) {
    b b = new b(this.mContext);
    this.doq = this.doy.apJ().split(",");
    Pair pair = b.b(paramBoolean, this.doq);
    b.close();
    return pair;
  }
  
  public void gR(boolean paramBoolean) { this.dos = paramBoolean; }
  
  public String getUserID() {
    av av = new av(this.mContext);
    String str = av.atm();
    av.close();
    return str;
  }
  
  protected boolean h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    boolean bool;
    long l = System.currentTimeMillis();
    try {
      null = new StringBuilder();
      null.append(paramString1);
      null.append(m.bVk);
      String str = null.toString();
      bool = (new b(this.mContext, paramString1, str, b.aQg)).aQh;
      long l1 = System.currentTimeMillis();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("上传前压缩上传文件，文件名为：");
      stringBuilder.append(paramString1);
      stringBuilder.append("，结果为");
      stringBuilder.append(bool);
      stringBuilder.append("，用时：");
      stringBuilder.append(l1 - l);
      stringBuilder.append("毫秒");
      bb.fU(stringBuilder.toString());
      if (bool) {
        File file = new File(str);
        paramString1 = "";
        try {
          stringBuilder = new StringBuilder();
          stringBuilder.append("上传文件到服务器并请求服务器处理的地址是:");
          stringBuilder.append(m.crl);
          bb.fU(stringBuilder.toString());
          paramString2 = d.a(this.mContext, m.crl, paramString2, paramString3, file, paramString4, paramString5);
          this.dox.setProgress(38);
          paramString1 = paramString2;
        } catch (Exception paramString2) {
          this.dox.setResult(0);
          this.dox.kn(3003);
          a.e(paramString2);
          this.dox.setProgress(38);
        } finally {}
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("上传文件到服务器并请求服务器准备下载文件的返回字符串是:");
        stringBuilder1.append(paramString1);
        bb.fU(stringBuilder1.toString());
        i1 = nS(paramString1);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("上传文件到服务器并请求服务器准备下载文件的返回结果是:");
        stringBuilder1.append(i1.toString());
        bb.fU(stringBuilder1.toString());
        if (i1 == null) {
          this.dox.setResult(0);
          this.dox.kn(4002);
          return false;
        } 
        bool = i1.apN().equals("TRUE");
        if (bool) {
          try {
            this.dox.setResult(1);
            this.dox.kn(4001);
            return bool;
          } catch (Exception i1) {}
        } else {
          this.dox.setResult(0);
          this.dox.kn(i1.apI());
          return bool;
        } 
      } else {
        bb.fU("上传文件的压缩失败");
        return false;
      } 
    } catch (Exception paramString1) {
      bool = false;
    } 
    a.e(paramString1);
    return bool;
  }
  
  public void nR(String paramString) { this.cgt = paramString; }
  
  public i nS(String paramString) {
    if (paramString == null || paramString.equals(""))
      return null; 
    this.aZq.ox(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("上传文件到服务器并请求服务器准备下载文件的返回结果是:");
    stringBuilder.append(this.aZq.toString());
    bb.fU(stringBuilder.toString());
    return this.aZq;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */