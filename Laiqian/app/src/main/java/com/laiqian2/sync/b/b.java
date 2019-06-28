package com.laiqian.sync.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.Pair;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.db.a;
import com.laiqian.db.multidatabase.c.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ab;
import com.laiqian.util.bb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b {
  public static boolean bJR = false;
  
  private String TAG = "dataBaseOperator";
  
  public String bJA = "";
  
  public SQLiteDatabase bJQ = null;
  
  protected a bJS = null;
  
  protected String bJT = "/data/data/com.laiqian.milestone/";
  
  protected String bJU = "laiqian.db";
  
  protected String bJV = "/data/data/com.laiqian.milestone/laiqian.db";
  
  protected long bJW = 200001L;
  
  protected long bJX = 600001L;
  
  protected long bJY = 500000L;
  
  protected double bJZ = -1.0D;
  
  public final long bKC = 150001L;
  
  private StringBuilder bKF = null;
  
  protected String bKa = "laiqian.db";
  
  protected String bKb = "laiqian.sqlite";
  
  protected String bKc = "";
  
  public long bKd = -1L;
  
  public long bKe = -1L;
  
  protected String bKf = "2";
  
  protected String bKg = "language";
  
  protected long bKh = 0L;
  
  protected String bKi = "1";
  
  public String bKj = "";
  
  private long bKk = 0L;
  
  protected String bKl = "0";
  
  protected String bKm = "0";
  
  protected String bKn = "android";
  
  private long bKp = 0L;
  
  protected Context context = null;
  
  static  {
  
  }
  
  public b(Context paramContext) { aK(paramContext); }
  
  private String a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("select * from serverDb.");
    stringBuilder2.append(paramString);
    stringBuilder2.append(" limit(0)");
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder2.toString(), null);
    int i = cursor.getColumnCount();
    for (byte b1 = 0; b1 < i; b1++) {
      stringBuilder1.append(cursor.getColumnName(b1));
      if (b1 < cursor.getColumnCount() - 1) {
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
  
  private StringBuilder a(StringBuilder paramStringBuilder) {
    if (paramStringBuilder == null)
      return new StringBuilder(); 
    paramStringBuilder.setLength(0);
    paramStringBuilder.delete(0, paramStringBuilder.length());
    return paramStringBuilder;
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2, Handler paramHandler, String paramString, boolean paramBoolean) {
    String[][] arrayOfString1;
    null = paramSQLiteDatabase.rawQuery(" select s_table_name,n_table_type from ts_table_profile WHERE s_table_name like 't\\_%' ESCAPE '\\';", null);
    String[][] arrayOfString2 = (String[][])Array.newInstance(String.class, new int[] { null.getCount(), 2 });
    int i;
    for (i = 0; null.moveToNext(); i++) {
      arrayOfString2[i][0] = null.getString(null.getColumnIndex("s_table_name"));
      arrayOfString2[i][1] = null.getString(null.getColumnIndex("n_table_type"));
    } 
    null.close();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ATTACH DATABASE '");
    stringBuilder.append(paramString);
    stringBuilder.append("' AS serverDB");
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
    paramSQLiteDatabase.beginTransaction();
    try {
      String[][] arrayOfString;
      i = arrayOfString2.length;
      boolean bool = true;
      byte b1;
      for (b1 = 0; b1 < i; b1++) {
        if (paramHandler != null) {
          Message message = new Message();
          message.obj = "MergeData";
          message.arg1 = b1 + true;
          message.arg2 = i;
          paramHandler.sendMessage(message);
        } 
        paramString = this.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("updateFromServerByTableNameWithUtilization start: ");
        stringBuilder.append(arrayOfString2[b1][0]);
        Log.d(paramString, stringBuilder.toString());
        bool = a(paramBoolean, arrayOfString2[b1][0], arrayOfString2[b1][1], paramLong1, paramLong2);
        if (!bool) {
          paramSQLiteDatabase.endTransaction();
          paramSQLiteDatabase.execSQL("DETACH DATABASE serverDB");
          arrayOfString = (String[][])null;
          return false;
        } 
        paramString = this.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("updateFromServerByTableNameWithUtilization end: ");
        stringBuilder.append(arrayOfString2[b1][0]);
        Log.d(paramString, stringBuilder.toString());
      } 
      aT(this.bKe);
      if (arrayOfString != null) {
        Message message = new Message();
        message.obj = "MergeData";
        message.arg1 = i;
        message.arg2 = i;
        arrayOfString.sendMessage(message);
      } 
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      paramSQLiteDatabase.execSQL("DETACH DATABASE serverDB");
      arrayOfString1 = (String[][])null;
      return bool;
    } catch (Exception paramHandler) {
      arrayOfString1.endTransaction();
      arrayOfString1.execSQL("DETACH DATABASE serverDB");
      a.e(paramHandler);
      return false;
    } 
  }
  
  private void aR(long paramLong) {
    SQLiteDatabase sQLiteDatabase = this.bJQ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete from t_string  where nFieldType ='15' and nShopID=");
    stringBuilder.append(paramLong);
    sQLiteDatabase.execSQL(stringBuilder.toString());
    sQLiteDatabase = this.bJQ;
    stringBuilder = new StringBuilder();
    stringBuilder.append("delete from serverDB.t_string where nFieldType ='15' and nShopID=");
    stringBuilder.append(paramLong);
    sQLiteDatabase.execSQL(stringBuilder.toString());
  }
  
  public static String bx(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  private Pair<Integer, List<String>> c(boolean paramBoolean, String[] paramArrayOfString) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: iload_1
    //   10: ifeq -> 290
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 'select count,tableName from('
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: astore #5
    //   25: iconst_0
    //   26: istore_3
    //   27: iload_3
    //   28: aload_2
    //   29: arraylength
    //   30: if_icmpge -> 140
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore #6
    //   42: aload #6
    //   44: ldc_w 'select count(*) count,''
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #6
    //   53: aload_2
    //   54: iload_3
    //   55: aaload
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #6
    //   62: ldc_w '' as tableName from '
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #6
    //   71: aload_2
    //   72: iload_3
    //   73: aaload
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #6
    //   80: ldc_w ' where (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1 and  nShopID ='
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #6
    //   89: aload_0
    //   90: getfield bKd : J
    //   93: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #5
    //   99: aload #6
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: iload_3
    //   109: aload_2
    //   110: arraylength
    //   111: iconst_1
    //   112: isub
    //   113: if_icmpeq -> 128
    //   116: aload #5
    //   118: ldc_w ' union '
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: goto -> 767
    //   128: aload #5
    //   130: ldc_w ' ) '
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: goto -> 767
    //   140: aload #5
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: astore_2
    //   146: aload_0
    //   147: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   150: aload_2
    //   151: aconst_null
    //   152: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   155: astore_2
    //   156: iconst_0
    //   157: istore_3
    //   158: aload_2
    //   159: ifnull -> 251
    //   162: aload_2
    //   163: invokeinterface moveToNext : ()Z
    //   168: ifeq -> 251
    //   171: aload_2
    //   172: iconst_0
    //   173: invokeinterface getInt : (I)I
    //   178: istore #4
    //   180: aload_2
    //   181: iconst_1
    //   182: invokeinterface getString : (I)Ljava/lang/String;
    //   187: astore #5
    //   189: new java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial <init> : ()V
    //   196: astore #6
    //   198: aload #6
    //   200: ldc_w '客户端需要上传('
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload #6
    //   209: aload #5
    //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload #6
    //   217: ldc_w '),个数->'
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload #6
    //   226: iload #4
    //   228: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: ldc_w '_Sync'
    //   235: aload #6
    //   237: invokevirtual toString : ()Ljava/lang/String;
    //   240: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   243: iload_3
    //   244: iload #4
    //   246: iadd
    //   247: istore_3
    //   248: goto -> 158
    //   251: aload_2
    //   252: invokeinterface close : ()V
    //   257: iload_3
    //   258: istore #4
    //   260: iload_3
    //   261: ifeq -> 752
    //   264: aload #7
    //   266: getstatic com/laiqian/db/multidatabase/b/a.aOB : Ljava/lang/String;
    //   269: invokeinterface add : (Ljava/lang/Object;)Z
    //   274: pop
    //   275: iload_3
    //   276: istore #4
    //   278: goto -> 752
    //   281: astore #5
    //   283: aconst_null
    //   284: astore_2
    //   285: iconst_0
    //   286: istore_3
    //   287: goto -> 719
    //   290: new java/io/File
    //   293: dup
    //   294: getstatic com/laiqian/db/multidatabase/b/a.aOz : Ljava/lang/String;
    //   297: invokespecial <init> : (Ljava/lang/String;)V
    //   300: new java/util/ArrayList
    //   303: dup
    //   304: invokespecial <init> : ()V
    //   307: invokestatic b : (Ljava/io/File;Ljava/util/List;)Ljava/util/List;
    //   310: invokeinterface iterator : ()Ljava/util/Iterator;
    //   315: astore #8
    //   317: aconst_null
    //   318: astore #6
    //   320: iconst_0
    //   321: istore_3
    //   322: aload #8
    //   324: invokeinterface hasNext : ()Z
    //   329: ifeq -> 708
    //   332: aload #8
    //   334: invokeinterface next : ()Ljava/lang/Object;
    //   339: checkcast java/lang/String
    //   342: astore #9
    //   344: new java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 'select count,tableName from('
    //   351: invokespecial <init> : (Ljava/lang/String;)V
    //   354: astore #5
    //   356: iconst_0
    //   357: istore #4
    //   359: iload #4
    //   361: aload_2
    //   362: arraylength
    //   363: if_icmpge -> 496
    //   366: new java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial <init> : ()V
    //   373: astore #10
    //   375: aload #10
    //   377: ldc_w 'select count(*) count ,''
    //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload #10
    //   386: aload_2
    //   387: iload #4
    //   389: aaload
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #10
    //   396: ldc_w '' as tableName from '
    //   399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload #10
    //   405: aload #9
    //   407: invokestatic cu : (Ljava/lang/String;)Ljava/lang/String;
    //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload #10
    //   416: ldc_w '.'
    //   419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload #10
    //   425: aload_2
    //   426: iload #4
    //   428: aaload
    //   429: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload #10
    //   435: ldc_w ' where (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1 and  nShopID ='
    //   438: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload #10
    //   444: aload_0
    //   445: getfield bKd : J
    //   448: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload #5
    //   454: aload #10
    //   456: invokevirtual toString : ()Ljava/lang/String;
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: iload #4
    //   465: aload_2
    //   466: arraylength
    //   467: iconst_1
    //   468: isub
    //   469: if_icmpeq -> 484
    //   472: aload #5
    //   474: ldc_w ' union '
    //   477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: goto -> 779
    //   484: aload #5
    //   486: ldc_w ' ) '
    //   489: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: goto -> 779
    //   496: aload #5
    //   498: invokevirtual toString : ()Ljava/lang/String;
    //   501: astore #5
    //   503: aload #9
    //   505: invokestatic cx : (Ljava/lang/String;)I
    //   508: aload #9
    //   510: invokestatic cw : (Ljava/lang/String;)I
    //   513: iconst_1
    //   514: isub
    //   515: invokestatic aW : (II)[J
    //   518: astore #10
    //   520: aload #10
    //   522: iconst_0
    //   523: laload
    //   524: invokestatic currentTimeMillis : ()J
    //   527: lcmp
    //   528: ifle -> 534
    //   531: goto -> 322
    //   534: new com/laiqian/db/multidatabase/c/a
    //   537: dup
    //   538: aload #10
    //   540: iconst_0
    //   541: laload
    //   542: aload #10
    //   544: iconst_1
    //   545: laload
    //   546: invokespecial <init> : (JJ)V
    //   549: invokevirtual getDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   552: aload #5
    //   554: iconst_0
    //   555: anewarray java/lang/String
    //   558: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   561: astore #5
    //   563: aload #5
    //   565: ifnull -> 680
    //   568: aload #5
    //   570: invokeinterface moveToNext : ()Z
    //   575: ifeq -> 680
    //   578: aload #5
    //   580: iconst_0
    //   581: invokeinterface getInt : (I)I
    //   586: istore #4
    //   588: aload #5
    //   590: iconst_1
    //   591: invokeinterface getString : (I)Ljava/lang/String;
    //   596: astore #6
    //   598: new java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial <init> : ()V
    //   605: astore #10
    //   607: aload #10
    //   609: ldc_w '客户端需要上传('
    //   612: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload #10
    //   618: aload #9
    //   620: invokestatic cu : (Ljava/lang/String;)Ljava/lang/String;
    //   623: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload #10
    //   629: ldc_w '.'
    //   632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload #10
    //   638: aload #6
    //   640: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload #10
    //   646: ldc_w '),个数->'
    //   649: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload #10
    //   655: iload #4
    //   657: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: ldc_w '_Sync'
    //   664: aload #10
    //   666: invokevirtual toString : ()Ljava/lang/String;
    //   669: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   672: iload_3
    //   673: iload #4
    //   675: iadd
    //   676: istore_3
    //   677: goto -> 563
    //   680: aload #5
    //   682: invokeinterface close : ()V
    //   687: iload_3
    //   688: ifeq -> 701
    //   691: aload #7
    //   693: aload #9
    //   695: invokeinterface add : (Ljava/lang/Object;)Z
    //   700: pop
    //   701: aload #5
    //   703: astore #6
    //   705: goto -> 322
    //   708: iload_3
    //   709: istore #4
    //   711: goto -> 752
    //   714: astore #5
    //   716: aload #6
    //   718: astore_2
    //   719: aload #5
    //   721: invokestatic e : (Ljava/lang/Throwable;)V
    //   724: iload_3
    //   725: istore #4
    //   727: aload_2
    //   728: ifnull -> 752
    //   731: iload_3
    //   732: istore #4
    //   734: aload_2
    //   735: invokeinterface isClosed : ()Z
    //   740: ifne -> 752
    //   743: aload_2
    //   744: invokeinterface close : ()V
    //   749: iload_3
    //   750: istore #4
    //   752: new android/support/v4/util/Pair
    //   755: dup
    //   756: iload #4
    //   758: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   761: aload #7
    //   763: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   766: areturn
    //   767: iload_3
    //   768: iconst_1
    //   769: iadd
    //   770: istore_3
    //   771: goto -> 27
    //   774: astore #5
    //   776: goto -> 719
    //   779: iload #4
    //   781: iconst_1
    //   782: iadd
    //   783: istore #4
    //   785: goto -> 359
    //   788: astore #6
    //   790: aload #5
    //   792: astore_2
    //   793: aload #6
    //   795: astore #5
    //   797: goto -> 719
    // Exception table:
    //   from	to	target	type
    //   13	25	281	java/lang/Exception
    //   27	125	281	java/lang/Exception
    //   128	137	281	java/lang/Exception
    //   140	156	281	java/lang/Exception
    //   162	243	774	java/lang/Exception
    //   251	257	774	java/lang/Exception
    //   264	275	774	java/lang/Exception
    //   290	317	281	java/lang/Exception
    //   322	356	714	java/lang/Exception
    //   359	481	714	java/lang/Exception
    //   484	493	714	java/lang/Exception
    //   496	531	714	java/lang/Exception
    //   534	563	714	java/lang/Exception
    //   568	672	788	java/lang/Exception
    //   680	687	788	java/lang/Exception
    //   691	701	788	java/lang/Exception }
  
  private long gM(String paramString) {
    null = null;
    String str = null;
    l1 = 0L;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select count(*) as nRecord from serverDB.");
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
      cursor = this.bJQ.rawQuery(paramString, null);
    } catch (Exception paramString) {
    
    } finally {
      paramString = str;
      if (paramString != null)
        paramString.close(); 
    } 
    long l2 = l1;
    if (paramString != null) {
      paramString.close();
      l2 = l1;
    } 
    return l2;
  }
  
  private void op(String paramString) { // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: new org/json/JSONObject
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore #5
    //   16: aload_3
    //   17: astore_2
    //   18: new java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore #6
    //   27: aload_3
    //   28: astore_2
    //   29: new java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #7
    //   38: aload_3
    //   39: astore_2
    //   40: aload #7
    //   42: ldc_w ' select sTableServer._id,sTableClient.nUpdateFlag,sTableServer.nUpdateFlag from '
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: astore_2
    //   51: aload #7
    //   53: aload_1
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: astore_2
    //   60: aload #7
    //   62: ldc_w ' as sTableClient inner join '
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: astore_2
    //   71: aload #6
    //   73: aload #7
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: astore_2
    //   84: new java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: astore #7
    //   93: aload_3
    //   94: astore_2
    //   95: aload #7
    //   97: ldc_w 'serverDB.'
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: astore_2
    //   106: aload #7
    //   108: aload_1
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: astore_2
    //   115: aload #7
    //   117: ldc_w ' as sTableServer on(sTableClient._id=sTableServer._id and '
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: astore_2
    //   126: aload #6
    //   128: aload #7
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_3
    //   138: astore_2
    //   139: aload #6
    //   141: ldc_w 'sTableClient.nUpdateFlag<sTableServer.nUpdateFlag) '
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: astore_2
    //   150: aload #6
    //   152: ldc_w 'where sTableClient._id=sTableServer._id and sTableServer.nShopID is not null and sTableServer.nShopID !='''
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_3
    //   160: astore_2
    //   161: aload_0
    //   162: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   165: aload #6
    //   167: invokevirtual toString : ()Ljava/lang/String;
    //   170: aconst_null
    //   171: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   174: astore_1
    //   175: aload_1
    //   176: invokeinterface moveToNext : ()Z
    //   181: ifeq -> 254
    //   184: new java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial <init> : ()V
    //   191: astore_2
    //   192: aload_2
    //   193: aload_1
    //   194: iconst_0
    //   195: invokeinterface getLong : (I)J
    //   200: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_2
    //   205: ldc ''
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #5
    //   213: aload_2
    //   214: invokevirtual toString : ()Ljava/lang/String;
    //   217: ldc_w '%s,%s'
    //   220: iconst_2
    //   221: anewarray java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_1
    //   227: iconst_1
    //   228: invokeinterface getString : (I)Ljava/lang/String;
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload_1
    //   237: iconst_2
    //   238: invokeinterface getString : (I)Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   250: pop
    //   251: goto -> 175
    //   254: aload #5
    //   256: invokevirtual length : ()I
    //   259: ifle -> 315
    //   262: getstatic com/laiqian/util/logger/AliLog$b.dHc : Lcom/laiqian/util/logger/AliLog$b;
    //   265: astore_2
    //   266: getstatic com/laiqian/util/b$a.dEI : Lcom/laiqian/util/b$a;
    //   269: astore_3
    //   270: new java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial <init> : ()V
    //   277: astore #4
    //   279: aload #4
    //   281: ldc_w '本地和服务器商品表合并的商品信息,设备类型:'
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload #4
    //   290: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   293: invokevirtual avL : ()I
    //   296: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_2
    //   301: aload_3
    //   302: aload #4
    //   304: invokevirtual toString : ()Ljava/lang/String;
    //   307: aload #5
    //   309: invokevirtual toString : ()Ljava/lang/String;
    //   312: invokestatic a : (Lcom/laiqian/util/logger/AliLog$b;Lcom/laiqian/util/b$a;Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_1
    //   316: ifnull -> 360
    //   319: aload_1
    //   320: invokeinterface close : ()V
    //   325: return
    //   326: astore_3
    //   327: aload_1
    //   328: astore_2
    //   329: goto -> 361
    //   332: astore_3
    //   333: goto -> 344
    //   336: astore_3
    //   337: goto -> 361
    //   340: astore_3
    //   341: aload #4
    //   343: astore_1
    //   344: aload_1
    //   345: astore_2
    //   346: aload_3
    //   347: invokestatic e : (Ljava/lang/Throwable;)V
    //   350: aload_1
    //   351: ifnull -> 360
    //   354: aload_1
    //   355: invokeinterface close : ()V
    //   360: return
    //   361: aload_2
    //   362: ifnull -> 371
    //   365: aload_2
    //   366: invokeinterface close : ()V
    //   371: aload_3
    //   372: athrow
    // Exception table:
    //   from	to	target	type
    //   7	16	340	java/lang/Exception
    //   7	16	336	finally
    //   18	27	340	java/lang/Exception
    //   18	27	336	finally
    //   29	38	340	java/lang/Exception
    //   29	38	336	finally
    //   40	49	340	java/lang/Exception
    //   40	49	336	finally
    //   51	58	340	java/lang/Exception
    //   51	58	336	finally
    //   60	69	340	java/lang/Exception
    //   60	69	336	finally
    //   71	82	340	java/lang/Exception
    //   71	82	336	finally
    //   84	93	340	java/lang/Exception
    //   84	93	336	finally
    //   95	104	340	java/lang/Exception
    //   95	104	336	finally
    //   106	113	340	java/lang/Exception
    //   106	113	336	finally
    //   115	124	340	java/lang/Exception
    //   115	124	336	finally
    //   126	137	340	java/lang/Exception
    //   126	137	336	finally
    //   139	148	340	java/lang/Exception
    //   139	148	336	finally
    //   150	159	340	java/lang/Exception
    //   150	159	336	finally
    //   161	175	340	java/lang/Exception
    //   161	175	336	finally
    //   175	251	332	java/lang/Exception
    //   175	251	326	finally
    //   254	315	332	java/lang/Exception
    //   254	315	326	finally
    //   346	350	336	finally }
  
  protected void TT() {
    this.bKh = Long.parseLong(this.context.getString(R.string.r_channelID));
    SharedPreferences sharedPreferences = this.context.getSharedPreferences("settings", 0);
    String str1 = sharedPreferences.getString("shop_id", "");
    String str2 = sharedPreferences.getString("user_id", "");
    this.bJA = sharedPreferences.getString(this.bKg, "");
    if (this.bJA.equals(""))
      this.bJA = "en"; 
    if (!str1.equals(""))
      this.bKd = Long.parseLong(str1); 
    if (!str2.equals(""))
      this.bKe = Long.parseLong(str2); 
    this.bKf = this.context.getSharedPreferences("com.laiqian.milestone_preferences", 0).getString("cf_DecimalPointSetting", "2");
  }
  
  public boolean a(long paramLong1, long paramLong2, Handler paramHandler, String paramString) {
    boolean bool1;
    boolean bool2 = a(this.bJQ, paramLong1, paramLong2, paramHandler, paramString, true);
    List list = new ArrayList();
    try {
      List list1 = b.i(paramLong1, paramLong2);
      list = list1;
    } catch (Exception exception) {
      a.e(exception);
    } 
    Iterator iterator = list.iterator();
    while (true) {
      boolean bool = iterator.hasNext();
      bool1 = false;
      if (bool) {
        String str = (String)iterator.next();
        int i = b.cw(str);
        int j = b.cx(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("数据合并--month=");
        stringBuilder.append(i);
        stringBuilder.append("--year=");
        stringBuilder.append(j);
        b.ct(stringBuilder.toString());
        long[] arrayOfLong = b.aW(j, i - 1);
        paramLong1 = arrayOfLong[0];
        paramLong2 = arrayOfLong[1];
        this.bJQ = (new a(true, str)).getDatabase();
        bool1 = a(this.bJQ, paramLong1, paramLong2, paramHandler, paramString, false);
        if (!bool1)
          try {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(getClass().getSimpleName());
            stringBuilder1.append("updateFromServerForAllTablesWithUtilization:");
            stringBuilder1.append(str);
            stringBuilder1.append("合并数据失败");
            throw new Exception(stringBuilder1.toString());
          } catch (Exception paramHandler) {
            a.e(paramHandler);
            return bool1;
          }  
        continue;
      } 
      break;
    } 
    this.bJQ.close();
    if (bool2)
      bool1 = true; 
    return bool1;
  }
  
  public boolean a(boolean paramBoolean, String paramString1, String paramString2, long paramLong1, long paramLong2) { return a(paramBoolean, paramString1, paramString2, this.bKd, paramLong1, paramLong2); }
  
  public boolean a(boolean paramBoolean, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3) { return a(paramBoolean, paramString1, paramString2, false, paramLong1, paramLong2, paramLong3); }
  
  public boolean a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3) {
    if (paramLong1 < 0L && !paramBoolean2)
      return false; 
    long l = gM(paramString1);
    null = new StringBuilder();
    null.append(paramString1);
    null.append("下载表含有总记录数据-->");
    null.append(l);
    bb.e("nAttachTableRecordNum", null.toString());
    if (l == 0L)
      return true; 
    str2 = a(this.bJQ, paramString1);
    op(paramString1);
    str1 = "";
    try {
      StringBuilder stringBuilder3 = new StringBuilder();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("replace into ");
      stringBuilder4.append(paramString1);
      stringBuilder4.append(str2);
      stringBuilder3.append(stringBuilder4.toString());
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append(" select sTableServer.* from ");
      stringBuilder4.append(paramString1);
      stringBuilder4.append(" as sTableClient inner join ");
      stringBuilder3.append(stringBuilder4.toString());
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append("serverDB.");
      stringBuilder4.append(paramString1);
      stringBuilder4.append(" as sTableServer on(sTableClient._id=sTableServer._id and ");
      stringBuilder3.append(stringBuilder4.toString());
      if (paramString1.equalsIgnoreCase("t_stock")) {
        stringBuilder4 = new StringBuilder();
        if (paramBoolean2) {
          str1 = " ";
        } else {
          null = new StringBuilder();
          null.append("sTableClient.nShopID=");
          null.append(paramLong1);
          null.append(" and ");
          str3 = null.toString();
        } 
        stringBuilder4.append(str3);
        stringBuilder4.append(" sTableClient.nShopID=sTableServer.nShopID and sTableClient.nWarehouseID=sTableServer.nWarehouseID and sTableClient.nProductID=sTableServer.nProductID and ");
        String str3 = stringBuilder4.toString();
      } 
      if (paramString1.equalsIgnoreCase("t_string")) {
        aR(paramLong1);
        str1 = "sTableClient.nShopID=sTableServer.nShopID and ifnull(sTableClient.sText,'')=ifnull(sTableServer.sText,'') and ";
      } 
      stringBuilder3.append(str1);
      stringBuilder3.append("sTableClient.nUpdateFlag<sTableServer.nUpdateFlag)");
      stringBuilder3.append("where sTableClient._id=sTableServer._id and sTableServer.nShopID is not null and sTableServer.nShopID !=''");
      Log.i("sUpdateSQl-->", stringBuilder3.toString());
      this.bJQ.execSQL(stringBuilder3.toString());
      if (LQKVersion.zg()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("affected rows: ");
        stringBuilder.append(ab.k(this.bJQ));
        Log.d("sql", stringBuilder.toString());
      } 
      stringBuilder3 = a(stringBuilder3);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("insert into ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(str2);
      stringBuilder3.append(stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" select sTableServer.* from serverDB.");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" as sTableServer left join ");
      stringBuilder1.append(paramString1);
      stringBuilder3.append(stringBuilder1.toString());
      stringBuilder3.append(" as sTableClient on(sTableClient._id=sTableServer._id ");
      String str = "";
      if (paramString1.equalsIgnoreCase("t_stock"))
        str = "and sTableClient.nShopID=sTableServer.nShopID and sTableClient.nWarehouseID=sTableServer.nWarehouseID and sTableClient.nProductID=sTableServer.nProductID"; 
      if (paramString1.equalsIgnoreCase("t_string"))
        str = "and sTableClient.nShopID=sTableServer.nShopID and ifnull(sTableClient.sText,'')=ifnull(sTableServer.sText,'')"; 
      stringBuilder3.append(str);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(") where sTableClient._id is null and sTableServer.nShopID is not null and sTableServer.nShopID !=''");
      if (paramBoolean2) {
        str = "";
      } else {
        null = new StringBuilder();
        null.append(" and sTableServer.nShopID =");
        null.append(paramLong1);
        str = null.toString();
      } 
      stringBuilder2.append(str);
      stringBuilder3.append(stringBuilder2.toString());
      if (!paramBoolean1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" and sTableServer._id>=");
        stringBuilder.append(paramLong2);
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(" and sTableServer._id<");
        stringBuilder.append(paramLong3);
        stringBuilder3.append(stringBuilder.toString());
        b.ct(b.V(paramLong2));
        b.ct(b.V(paramLong3));
      } 
      Log.i("sInsertSQl--》", stringBuilder3.toString());
      this.bJQ.execSQL(stringBuilder3.toString());
      if (LQKVersion.zg()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("affected rows: ");
        stringBuilder.append(ab.k(this.bJQ));
        Log.d("sql", stringBuilder.toString());
      } 
      a(stringBuilder3);
      return true;
    } catch (Exception str2) {
      a.e(str2);
      try {
        null = new StringBuilder();
        null.append("/sdcard/crash/merge_");
        null.append(System.currentTimeMillis());
        null.append(".txt");
        PrintWriter printWriter = new PrintWriter(new File(null.toString()));
        null = new StringBuilder();
        null.append("table: ");
        null.append(paramString1);
        printWriter.println(null.toString());
        printWriter.println(str2.getMessage());
        a.a(str2, printWriter);
        for (Throwable throwable = str2.getCause(); throwable != null; throwable = throwable.getCause())
          a.a(throwable, printWriter); 
        printWriter.flush();
        printWriter.close();
      } catch (Exception str1) {
        a.e(str1);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(" Error");
      bb.e(stringBuilder.toString(), str2.toString());
      return false;
    } 
  }
  
  protected void aK(Context paramContext) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield context : Landroid/content/Context;
    //   7: aload_0
    //   8: invokevirtual TT : ()V
    //   11: new java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc_w '/data/data/'
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: aload_1
    //   29: invokevirtual getPackageName : ()Ljava/lang/String;
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc_w '/'
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: astore_3
    //   49: ldc 'laiqian.db'
    //   51: astore_2
    //   52: aload_0
    //   53: getfield bKj : Ljava/lang/String;
    //   56: ldc ''
    //   58: invokevirtual equals : (Ljava/lang/Object;)Z
    //   61: ifne -> 69
    //   64: aload_0
    //   65: getfield bKj : Ljava/lang/String;
    //   68: astore_2
    //   69: aload_0
    //   70: aload_2
    //   71: putfield bKj : Ljava/lang/String;
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore #4
    //   83: aload #4
    //   85: aload_3
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #4
    //   92: aload_2
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_0
    //   98: aload #4
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: invokevirtual cq : (Ljava/lang/String;)V
    //   106: aload_0
    //   107: aload_1
    //   108: invokestatic Y : (Landroid/content/Context;)Lcom/laiqian/db/a;
    //   111: putfield bJS : Lcom/laiqian/db/a;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield bJS : Lcom/laiqian/db/a;
    //   119: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   122: putfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	128	finally
    //   52	69	128	finally
    //   69	125	128	finally }
  
  public double aT(long paramLong) { // Byte code:
    //   0: dconst_0
    //   1: dstore #5
    //   3: dload #5
    //   5: dstore_3
    //   6: aload_0
    //   7: lload_1
    //   8: invokevirtual aU : (J)Landroid/database/Cursor;
    //   11: astore #11
    //   13: dconst_0
    //   14: dstore #7
    //   16: dload #5
    //   18: dstore_3
    //   19: aload #11
    //   21: invokeinterface moveToNext : ()Z
    //   26: ifeq -> 190
    //   29: dload #5
    //   31: dstore_3
    //   32: aload #11
    //   34: aload #11
    //   36: ldc_w 'nChannelID'
    //   39: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   44: invokeinterface getLong : (I)J
    //   49: lstore #9
    //   51: lload #9
    //   53: ldc2_w 200000
    //   56: lcmp
    //   57: iflt -> 324
    //   60: dload #5
    //   62: dstore_3
    //   63: aload #11
    //   65: aload #11
    //   67: ldc_w 'nChannelID'
    //   70: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   75: invokeinterface isNull : (I)Z
    //   80: ifeq -> 86
    //   83: goto -> 324
    //   86: dload #5
    //   88: dstore_3
    //   89: aload_0
    //   90: lload #9
    //   92: invokevirtual aV : (J)Landroid/database/Cursor;
    //   95: astore #12
    //   97: dload #5
    //   99: dstore_3
    //   100: aload #12
    //   102: invokeinterface getCount : ()I
    //   107: ifle -> 159
    //   110: dload #5
    //   112: dstore_3
    //   113: aload #12
    //   115: invokeinterface moveToFirst : ()Z
    //   120: pop
    //   121: dload #5
    //   123: dstore_3
    //   124: aload #12
    //   126: aload #12
    //   128: ldc_w 'sFieldValue'
    //   131: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   136: invokeinterface getString : (I)Ljava/lang/String;
    //   141: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   144: invokevirtual doubleValue : ()D
    //   147: dstore #7
    //   149: dload #5
    //   151: dstore_3
    //   152: aload #12
    //   154: invokeinterface close : ()V
    //   159: dload #5
    //   161: dstore_3
    //   162: dload #5
    //   164: aload #11
    //   166: aload #11
    //   168: ldc_w 'fChargeAmount'
    //   171: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   176: invokeinterface getDouble : (I)D
    //   181: dload #7
    //   183: dmul
    //   184: dadd
    //   185: dstore #5
    //   187: goto -> 16
    //   190: dload #5
    //   192: dstore_3
    //   193: aload #11
    //   195: invokeinterface close : ()V
    //   200: dload #5
    //   202: dstore_3
    //   203: dload #5
    //   205: ldc2_w 100.0
    //   208: dmul
    //   209: invokestatic round : (D)J
    //   212: l2d
    //   213: dstore #5
    //   215: dload #5
    //   217: dstore_3
    //   218: dload #5
    //   220: ldc2_w 100.0
    //   223: ddiv
    //   224: dstore #5
    //   226: dload #5
    //   228: dstore_3
    //   229: new java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial <init> : ()V
    //   236: astore #11
    //   238: dload #5
    //   240: dstore_3
    //   241: aload #11
    //   243: ldc_w 'update T_USER set fUserAmount='
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: dload #5
    //   252: dstore_3
    //   253: aload #11
    //   255: dload #5
    //   257: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: dload #5
    //   263: dstore_3
    //   264: aload #11
    //   266: ldc_w ' ,nIsUpdated=0  where _id = '
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: dload #5
    //   275: dstore_3
    //   276: aload #11
    //   278: lload_1
    //   279: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: dload #5
    //   285: dstore_3
    //   286: aload #11
    //   288: ldc_w ';'
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: dload #5
    //   297: dstore_3
    //   298: aload #11
    //   300: invokevirtual toString : ()Ljava/lang/String;
    //   303: astore #11
    //   305: dload #5
    //   307: dstore_3
    //   308: aload_0
    //   309: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   312: aload #11
    //   314: invokevirtual execSQL : (Ljava/lang/String;)V
    //   317: dload #5
    //   319: dreturn
    //   320: astore #11
    //   322: dload_3
    //   323: dreturn
    //   324: ldc2_w 200001
    //   327: lstore #9
    //   329: goto -> 86
    // Exception table:
    //   from	to	target	type
    //   6	13	320	java/lang/Exception
    //   19	29	320	java/lang/Exception
    //   32	51	320	java/lang/Exception
    //   63	83	320	java/lang/Exception
    //   89	97	320	java/lang/Exception
    //   100	110	320	java/lang/Exception
    //   113	121	320	java/lang/Exception
    //   124	149	320	java/lang/Exception
    //   152	159	320	java/lang/Exception
    //   162	187	320	java/lang/Exception
    //   193	200	320	java/lang/Exception
    //   203	215	320	java/lang/Exception
    //   218	226	320	java/lang/Exception
    //   229	238	320	java/lang/Exception
    //   241	250	320	java/lang/Exception
    //   253	261	320	java/lang/Exception
    //   264	273	320	java/lang/Exception
    //   276	283	320	java/lang/Exception
    //   286	295	320	java/lang/Exception
    //   298	305	320	java/lang/Exception
    //   308	317	320	java/lang/Exception }
  
  public Cursor aU(long paramLong) {
    try {
      this.bJQ.execSQL("update T_USERCHARGEDOC set nChannelID=200001,nIsUpdated=0  where nChannelID is null or nChannelID<200000;");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select _id,sUserName,nChannelID,fChargeAmount,date(nChargeTime/1000,'unixepoch','localtime') as nChargeTime from T_USERCHARGEDOC where nUserID =");
      stringBuilder.append(paramLong);
      stringBuilder.append(";");
      String str = stringBuilder.toString();
      return this.bJQ.rawQuery(str, null);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public Cursor aV(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from T_STRING where nFieldType = 2 and _id = ");
    stringBuilder.append(paramLong);
    stringBuilder.append(";");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Pair<Boolean, List<String>> b(boolean paramBoolean, String[] paramArrayOfString) {
    boolean bool = false;
    if (paramArrayOfString == null)
      return new Pair(Boolean.valueOf(false), new ArrayList()); 
    Pair pair = c(paramBoolean, paramArrayOfString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("客户端需要上传的数据总个数->");
    stringBuilder.append(pair.first);
    bb.e("_Sync", stringBuilder.toString());
    paramBoolean = bool;
    if (((Integer)pair.first).intValue() > 0)
      paramBoolean = true; 
    return new Pair(Boolean.valueOf(paramBoolean), pair.second);
  }
  
  public void close() {
    if (this.bJS != null)
      this.bJS.close(); 
    SQLiteDatabase.releaseMemory();
  }
  
  protected void cq(String paramString) {
    File file = new File(paramString);
    if (!file.exists())
      try {
        InputStream inputStream;
        file.createNewFile();
        if (bJR) {
          inputStream = this.context.getAssets().open("laiqian.db");
        } else {
          inputStream = this.context.getResources().openRawResource(R.raw.laiqian);
        } 
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
  
  public boolean d(long paramLong1, long paramLong2, String paramString) { return a(paramLong1, paramLong2, null, paramString); }
  
  public boolean gO(String paramString) {
    paramString = paramString.trim();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete from T_USER where sUserPhone='");
    stringBuilder.append(paramString);
    stringBuilder.append("';");
    paramString = stringBuilder.toString();
    this.bJQ.execSQL(paramString);
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */