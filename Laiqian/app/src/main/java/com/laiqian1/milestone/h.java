package com.laiqian.milestone;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.d.a;
import com.laiqian.db.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.aq;
import com.laiqian.entity.g;
import com.laiqian.f.c;
import com.laiqian.infrastructure.R;
import com.laiqian.l.a;
import com.laiqian.models.at;
import com.laiqian.util.ab;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import com.zhuge.analysis.b.a;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
  public static boolean bJR = false;
  
  private StringBuilder aNT = null;
  
  private StringBuilder aNU = null;
  
  String aOa = null;
  
  SQLiteStatement aOb = null;
  
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
  
  private Cursor bKA = null;
  
  private String bKB = null;
  
  public final long bKC = 150001L;
  
  final String bKD = "0";
  
  final String bKE = "1";
  
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
  
  private boolean bKo = false;
  
  private long bKp = 0L;
  
  public final int bKq = 0;
  
  public final int bKr = 1;
  
  public final int bKs = 2;
  
  public final int bKt = 3;
  
  private String bKu = null;
  
  int bKv = 0;
  
  final String bKw = "1";
  
  private StringBuilder bKx = null;
  
  private StringBuilder bKy = null;
  
  private StringBuilder bKz = null;
  
  protected Context context = null;
  
  static  {
  
  }
  
  public h(Context paramContext) { aK(paramContext); }
  
  private String a(long paramLong1, long paramLong2, double paramDouble1, double paramDouble2, long paramLong3, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7) {
    if (paramLong1 == 100002L || paramLong1 == 100016L || paramLong1 == 100013L || paramLong1 == 100014L) {
      paramDouble3 = paramDouble5 * paramDouble6;
    } else if (paramLong1 == 100019L || paramLong1 == 100020L) {
      paramDouble3 = paramDouble7;
    } else {
      paramDouble3 = paramDouble5 * paramDouble4;
    } 
    paramDouble4 = paramDouble1 + paramDouble5 * paramLong3;
    if (paramLong3 == -1L) {
      if (paramDouble4 == 0.0D) {
        paramDouble1 = paramDouble2;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("update T_PRODUCT set fStockPrice = ");
        stringBuilder1.append(paramDouble1);
        stringBuilder1.append(",nStockQty=");
        stringBuilder1.append(paramDouble4);
        stringBuilder1.append(" ,nIsUpdated=0 ,nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id = ");
        stringBuilder1.append(paramLong2);
        stringBuilder1.append(" and nShopID = ");
        stringBuilder1.append(this.bKd);
        stringBuilder1.append(";");
        return stringBuilder1.toString();
      } 
      paramDouble1 = (paramDouble2 * paramDouble1 - paramDouble3) / paramDouble4;
    } else {
      if (paramDouble4 == 0.0D) {
        paramDouble1 = paramDouble2;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("update T_PRODUCT set fStockPrice = ");
        stringBuilder1.append(paramDouble1);
        stringBuilder1.append(",nStockQty=");
        stringBuilder1.append(paramDouble4);
        stringBuilder1.append(" ,nIsUpdated=0 ,nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id = ");
        stringBuilder1.append(paramLong2);
        stringBuilder1.append(" and nShopID = ");
        stringBuilder1.append(this.bKd);
        stringBuilder1.append(";");
        return stringBuilder1.toString();
      } 
      paramDouble1 = (paramDouble2 * paramDouble1 + paramDouble3) / paramDouble4;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_PRODUCT set fStockPrice = ");
    stringBuilder.append(paramDouble1);
    stringBuilder.append(",nStockQty=");
    stringBuilder.append(paramDouble4);
    stringBuilder.append(" ,nIsUpdated=0 ,nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id = ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" and nShopID = ");
    stringBuilder.append(this.bKd);
    stringBuilder.append(";");
    return stringBuilder.toString();
  }
  
  private String a(long paramLong1, long paramLong2, long paramLong3, String paramString, double paramDouble1, long paramLong4, long paramLong5, double paramDouble2, double paramDouble3) {
    long l1 = System.currentTimeMillis();
    long l2 = this.bKd;
    null = new StringBuilder();
    null.append("select * from T_STOCK where nWarehouseID =");
    null.append(paramLong2);
    null.append(" and nProductID = ");
    null.append(paramLong3);
    null.append(" and sIsActive = 'Y'  and nShopID = ");
    null.append(this.bKd);
    null.append(";");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.moveToFirst()) {
      double d2 = cursor.getDouble(cursor.getColumnIndex("nQuantity"));
      double d1 = cursor.getDouble(cursor.getColumnIndex("fStockPrice"));
      if (paramLong1 == 100002L || paramLong1 == 100016L || paramLong1 == 100013L || paramLong1 == 100014L) {
        paramDouble2 = paramDouble1 * paramDouble2;
      } else if (paramLong1 == 100019L || paramLong1 == 100020L) {
        paramDouble2 = paramDouble3;
      } else {
        paramDouble2 = paramDouble1 * d1;
      } 
      paramDouble3 = d2 + paramDouble1 * paramLong4;
      if (paramLong4 == -1L) {
        if (paramDouble3 == 0.0D) {
          paramDouble1 = d1;
        } else {
          paramDouble1 = (d1 * d2 - paramDouble2) / paramDouble3;
        } 
      } else if (paramDouble3 == 0.0D) {
        paramDouble1 = d1;
      } else {
        paramDouble1 = (d1 * d2 + paramDouble2) / paramDouble3;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update T_STOCK set nQuantity = ");
      stringBuilder.append(paramDouble3);
      stringBuilder.append(",sProductName = '");
      stringBuilder.append(paramString);
      stringBuilder.append("',fStockPrice=");
      stringBuilder.append(paramDouble1);
      stringBuilder.append(",fStockAmount =");
      stringBuilder.append(paramDouble3 * paramDouble1);
      stringBuilder.append(",nDateTime =");
      stringBuilder.append(l1);
      stringBuilder.append(",nIsUpdated=0 ,nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where nWarehouseID = ");
      stringBuilder.append(paramLong2);
      stringBuilder.append(" and nProductID = ");
      stringBuilder.append(paramLong3);
      stringBuilder.append(" and sIsActive = 'Y'  and nShopID = ");
      stringBuilder.append(this.bKd);
      stringBuilder.append(";");
      paramString = stringBuilder.toString();
    } else {
      if (paramDouble1 < 0.0D)
        paramDouble1 = Math.abs(paramDouble1); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("insert into T_STOCK (_id, nWarehouseID, nProductID, sProductName, nQuantity, nProductUnit, fStockPrice, fStockAmount, nDateTime, sIsActive,nUserID,nShopID,nIsUpdated,nOperationTime,sPlatform ) values (");
      stringBuilder.append(paramLong2 + paramLong3 + l2);
      stringBuilder.append(",");
      stringBuilder.append(paramLong2);
      stringBuilder.append(",");
      stringBuilder.append(paramLong3);
      stringBuilder.append(",'");
      stringBuilder.append(paramString);
      stringBuilder.append("',");
      stringBuilder.append(paramDouble1);
      stringBuilder.append(",");
      stringBuilder.append(paramLong5);
      stringBuilder.append(",");
      stringBuilder.append(paramDouble2);
      stringBuilder.append(",");
      stringBuilder.append(paramDouble1 * paramDouble2);
      stringBuilder.append(",");
      stringBuilder.append(l1);
      stringBuilder.append(",'Y', ");
      stringBuilder.append(this.bKe);
      stringBuilder.append(",");
      stringBuilder.append(this.bKd);
      stringBuilder.append(",'");
      stringBuilder.append(this.bKl);
      stringBuilder.append("',");
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append(",'");
      stringBuilder.append(this.bKn);
      stringBuilder.append("');");
      paramString = stringBuilder.toString();
    } 
    cursor.close();
    return paramString;
  }
  
  private double aI(long paramLong) {
    double d;
    null = new StringBuilder();
    null.append("select * from T_PRODUCT where [_id]=");
    null.append(paramLong);
    null.append(" and nShopID=");
    null.append(this.bKd);
    null.append(" ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d = cursor.getDouble(cursor.getColumnIndex("fStockPrice"));
    } else {
      d = -1.0D;
    } 
    cursor.close();
    return d;
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
  
  private long gM(String paramString) { // Byte code:
    //   0: aconst_null
    //   1: astore #10
    //   3: aconst_null
    //   4: astore #9
    //   6: lconst_0
    //   7: lstore #4
    //   9: aload #9
    //   11: astore #8
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #11
    //   22: aload #9
    //   24: astore #8
    //   26: aload #11
    //   28: ldc_w 'select count(*) as nRecord from serverDB.'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #9
    //   37: astore #8
    //   39: aload #11
    //   41: aload_1
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #9
    //   48: astore #8
    //   50: aload #11
    //   52: invokevirtual toString : ()Ljava/lang/String;
    //   55: astore_1
    //   56: aload #9
    //   58: astore #8
    //   60: aload_0
    //   61: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   64: aload_1
    //   65: aconst_null
    //   66: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore_1
    //   70: lload #4
    //   72: lstore_2
    //   73: aload_1
    //   74: invokeinterface getCount : ()I
    //   79: ifle -> 110
    //   82: lload #4
    //   84: lstore_2
    //   85: aload_1
    //   86: invokeinterface moveToNext : ()Z
    //   91: ifeq -> 110
    //   94: aload_1
    //   95: aload_1
    //   96: ldc_w 'nRecord'
    //   99: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   104: invokeinterface getLong : (I)J
    //   109: lstore_2
    //   110: lload_2
    //   111: lstore #6
    //   113: aload_1
    //   114: ifnull -> 174
    //   117: aload_1
    //   118: invokeinterface close : ()V
    //   123: lload_2
    //   124: lreturn
    //   125: astore #9
    //   127: aload_1
    //   128: astore #8
    //   130: goto -> 177
    //   133: astore #9
    //   135: goto -> 148
    //   138: astore #9
    //   140: goto -> 177
    //   143: astore #9
    //   145: aload #10
    //   147: astore_1
    //   148: aload_1
    //   149: astore #8
    //   151: aload #9
    //   153: invokestatic e : (Ljava/lang/Throwable;)V
    //   156: lload #4
    //   158: lstore #6
    //   160: aload_1
    //   161: ifnull -> 174
    //   164: aload_1
    //   165: invokeinterface close : ()V
    //   170: lload #4
    //   172: lstore #6
    //   174: lload #6
    //   176: lreturn
    //   177: aload #8
    //   179: ifnull -> 189
    //   182: aload #8
    //   184: invokeinterface close : ()V
    //   189: aload #9
    //   191: athrow
    // Exception table:
    //   from	to	target	type
    //   13	22	143	java/lang/Exception
    //   13	22	138	finally
    //   26	35	143	java/lang/Exception
    //   26	35	138	finally
    //   39	46	143	java/lang/Exception
    //   39	46	138	finally
    //   50	56	143	java/lang/Exception
    //   50	56	138	finally
    //   60	70	143	java/lang/Exception
    //   60	70	138	finally
    //   73	82	133	java/lang/Exception
    //   73	82	125	finally
    //   85	110	133	java/lang/Exception
    //   85	110	125	finally
    //   151	156	138	finally }
  
  private int gP(String paramString) { // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore #4
    //   8: iconst_0
    //   9: istore_3
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore #5
    //   19: aload #5
    //   21: ldc_w 'select count(*) from '
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload #5
    //   30: aload_1
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #5
    //   37: ldc_w ' where (nUpdateFlag is null or nUpdateFlag!=1) and nIsUpdated != 1 and  nShopID ='
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload #5
    //   46: aload_0
    //   47: getfield bKd : J
    //   50: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #5
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: astore_1
    //   60: aload_0
    //   61: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   64: aload_1
    //   65: aconst_null
    //   66: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore_1
    //   70: iload_3
    //   71: istore_2
    //   72: aload_1
    //   73: ifnull -> 104
    //   76: iload_3
    //   77: istore_2
    //   78: iload #4
    //   80: istore_3
    //   81: aload_1
    //   82: invokeinterface moveToFirst : ()Z
    //   87: ifeq -> 104
    //   90: iload #4
    //   92: istore_3
    //   93: aload_1
    //   94: iconst_0
    //   95: invokeinterface getInt : (I)I
    //   100: istore_2
    //   101: goto -> 104
    //   104: iload_2
    //   105: istore_3
    //   106: aload_1
    //   107: invokeinterface close : ()V
    //   112: iload_2
    //   113: ireturn
    //   114: astore #5
    //   116: iload_2
    //   117: istore_3
    //   118: aload #6
    //   120: astore_1
    //   121: aload #5
    //   123: invokestatic e : (Ljava/lang/Throwable;)V
    //   126: aload_1
    //   127: ifnull -> 145
    //   130: aload_1
    //   131: invokeinterface isClosed : ()Z
    //   136: ifne -> 145
    //   139: aload_1
    //   140: invokeinterface close : ()V
    //   145: iload_3
    //   146: ireturn
    //   147: astore #5
    //   149: goto -> 121
    // Exception table:
    //   from	to	target	type
    //   10	70	114	java/lang/Exception
    //   81	90	147	java/lang/Exception
    //   93	101	147	java/lang/Exception
    //   106	112	147	java/lang/Exception }
  
  public long Di() {
    long l;
    for (l = System.currentTimeMillis(); l == this.bKp; l += 2L);
    this.bKp = l;
    return l;
  }
  
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
  
  public Cursor TU() { return this.bJQ.rawQuery("select * from T_ORDERNUMBER ;", null); }
  
  public boolean TV() { // Byte code:
    //   0: aload_0
    //   1: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual beginTransaction : ()V
    //   7: new java/util/HashMap
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: pop
    //   15: aconst_null
    //   16: astore #4
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_3
    //   21: astore_1
    //   22: aload #4
    //   24: astore_2
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload_3
    //   35: astore_1
    //   36: aload #4
    //   38: astore_2
    //   39: aload #5
    //   41: ldc_w 'select * from t_product where nProductStatus=600001 and nShopID ='
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: astore_1
    //   50: aload #4
    //   52: astore_2
    //   53: aload #5
    //   55: aload_0
    //   56: getfield bKd : J
    //   59: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: aload #4
    //   67: astore_2
    //   68: aload #5
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: astore #5
    //   75: aload_3
    //   76: astore_1
    //   77: aload #4
    //   79: astore_2
    //   80: aload_0
    //   81: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   84: aload #5
    //   86: aconst_null
    //   87: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore_3
    //   91: aload_3
    //   92: astore_2
    //   93: aload_3
    //   94: astore_1
    //   95: aload_3
    //   96: invokeinterface getCount : ()I
    //   101: putstatic com/laiqian/l/a.dMv : I
    //   104: aload_3
    //   105: ifnull -> 118
    //   108: aload_3
    //   109: astore_2
    //   110: aload_3
    //   111: astore_1
    //   112: aload_3
    //   113: invokeinterface close : ()V
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: astore_1
    //   122: new java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: astore #4
    //   131: aload_3
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: aload #4
    //   137: ldc_w ' select * from t_string where nFieldType=5 and sIsActive='Y' and nShopID ='
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_3
    //   145: astore_2
    //   146: aload_3
    //   147: astore_1
    //   148: aload #4
    //   150: aload_0
    //   151: getfield bKd : J
    //   154: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_3
    //   159: astore_2
    //   160: aload_3
    //   161: astore_1
    //   162: aload #4
    //   164: invokevirtual toString : ()Ljava/lang/String;
    //   167: astore #4
    //   169: aload_3
    //   170: astore_2
    //   171: aload_3
    //   172: astore_1
    //   173: aload_0
    //   174: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   177: aload #4
    //   179: aconst_null
    //   180: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   183: astore_3
    //   184: aload_3
    //   185: astore_1
    //   186: aload_3
    //   187: astore_2
    //   188: aload_3
    //   189: invokeinterface getCount : ()I
    //   194: putstatic com/laiqian/l/a.dMx : I
    //   197: aload_3
    //   198: ifnull -> 211
    //   201: aload_3
    //   202: astore_1
    //   203: aload_3
    //   204: astore_2
    //   205: aload_3
    //   206: invokeinterface close : ()V
    //   211: aload_3
    //   212: astore_1
    //   213: aload_3
    //   214: astore_2
    //   215: new java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial <init> : ()V
    //   222: astore #4
    //   224: aload_3
    //   225: astore_1
    //   226: aload_3
    //   227: astore_2
    //   228: aload #4
    //   230: ldc_w '  select * from t_string where nFieldType=44 and sIsActive='Y' and nShopID ='
    //   233: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_3
    //   238: astore_1
    //   239: aload_3
    //   240: astore_2
    //   241: aload #4
    //   243: aload_0
    //   244: getfield bKd : J
    //   247: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_3
    //   252: astore_1
    //   253: aload_3
    //   254: astore_2
    //   255: aload #4
    //   257: invokevirtual toString : ()Ljava/lang/String;
    //   260: astore #4
    //   262: aload_3
    //   263: astore_1
    //   264: aload_3
    //   265: astore_2
    //   266: aload_0
    //   267: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   270: aload #4
    //   272: aconst_null
    //   273: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   276: astore_3
    //   277: aload_3
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: aload_3
    //   282: invokeinterface getCount : ()I
    //   287: putstatic com/laiqian/l/a.dMz : I
    //   290: aload_3
    //   291: ifnull -> 304
    //   294: aload_3
    //   295: astore_2
    //   296: aload_3
    //   297: astore_1
    //   298: aload_3
    //   299: invokeinterface close : ()V
    //   304: aload_3
    //   305: astore_2
    //   306: aload_3
    //   307: astore_1
    //   308: new java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial <init> : ()V
    //   315: astore #4
    //   317: aload_3
    //   318: astore_2
    //   319: aload_3
    //   320: astore_1
    //   321: aload #4
    //   323: ldc_w '  select * from t_bpartner where  bIsActive='Y' and nShopID ='
    //   326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: astore_2
    //   332: aload_3
    //   333: astore_1
    //   334: aload #4
    //   336: aload_0
    //   337: getfield bKd : J
    //   340: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_3
    //   345: astore_2
    //   346: aload_3
    //   347: astore_1
    //   348: aload #4
    //   350: invokevirtual toString : ()Ljava/lang/String;
    //   353: astore #4
    //   355: aload_3
    //   356: astore_2
    //   357: aload_3
    //   358: astore_1
    //   359: aload_0
    //   360: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   363: aload #4
    //   365: aconst_null
    //   366: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   369: astore_3
    //   370: aload_3
    //   371: astore_1
    //   372: aload_3
    //   373: astore_2
    //   374: aload_3
    //   375: invokeinterface getCount : ()I
    //   380: putstatic com/laiqian/l/a.dMw : I
    //   383: aload_3
    //   384: ifnull -> 397
    //   387: aload_3
    //   388: astore_1
    //   389: aload_3
    //   390: astore_2
    //   391: aload_3
    //   392: invokeinterface close : ()V
    //   397: aload_3
    //   398: astore_1
    //   399: aload_3
    //   400: astore_2
    //   401: new java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial <init> : ()V
    //   408: astore #4
    //   410: aload_3
    //   411: astore_1
    //   412: aload_3
    //   413: astore_2
    //   414: aload #4
    //   416: ldc_w '  select * from t_user where  nUserStatus=180001 and nShopID ='
    //   419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_3
    //   424: astore_1
    //   425: aload_3
    //   426: astore_2
    //   427: aload #4
    //   429: aload_0
    //   430: getfield bKd : J
    //   433: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_3
    //   438: astore_1
    //   439: aload_3
    //   440: astore_2
    //   441: aload #4
    //   443: invokevirtual toString : ()Ljava/lang/String;
    //   446: astore #4
    //   448: aload_3
    //   449: astore_1
    //   450: aload_3
    //   451: astore_2
    //   452: aload_0
    //   453: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   456: aload #4
    //   458: aconst_null
    //   459: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   462: astore_3
    //   463: aload_3
    //   464: astore_1
    //   465: aload_3
    //   466: astore_2
    //   467: aload_3
    //   468: invokeinterface getCount : ()I
    //   473: putstatic com/laiqian/l/a.dMy : I
    //   476: aload_3
    //   477: ifnull -> 490
    //   480: aload_3
    //   481: astore_1
    //   482: aload_3
    //   483: astore_2
    //   484: aload_3
    //   485: invokeinterface close : ()V
    //   490: aload_3
    //   491: astore_1
    //   492: aload_3
    //   493: astore_2
    //   494: aload_0
    //   495: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   498: invokevirtual setTransactionSuccessful : ()V
    //   501: aload_3
    //   502: ifnull -> 511
    //   505: aload_3
    //   506: invokeinterface close : ()V
    //   511: aload_0
    //   512: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   515: invokevirtual isOpen : ()Z
    //   518: ifeq -> 538
    //   521: aload_0
    //   522: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   525: invokevirtual inTransaction : ()Z
    //   528: ifeq -> 538
    //   531: aload_0
    //   532: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   535: invokevirtual endTransaction : ()V
    //   538: iconst_1
    //   539: ireturn
    //   540: astore_3
    //   541: aload_1
    //   542: astore_2
    //   543: aload_3
    //   544: astore_1
    //   545: goto -> 615
    //   548: astore_3
    //   549: goto -> 565
    //   552: astore_3
    //   553: goto -> 565
    //   556: astore_3
    //   557: aload_1
    //   558: astore_2
    //   559: aload_3
    //   560: astore_1
    //   561: goto -> 615
    //   564: astore_3
    //   565: aload_2
    //   566: astore_1
    //   567: aload_3
    //   568: invokestatic e : (Ljava/lang/Throwable;)V
    //   571: aload_2
    //   572: ifnull -> 581
    //   575: aload_2
    //   576: invokeinterface close : ()V
    //   581: aload_0
    //   582: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   585: invokevirtual isOpen : ()Z
    //   588: ifeq -> 608
    //   591: aload_0
    //   592: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   595: invokevirtual inTransaction : ()Z
    //   598: ifeq -> 608
    //   601: aload_0
    //   602: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   605: invokevirtual endTransaction : ()V
    //   608: iconst_0
    //   609: ireturn
    //   610: astore_3
    //   611: aload_1
    //   612: astore_2
    //   613: aload_3
    //   614: astore_1
    //   615: aload_2
    //   616: ifnull -> 625
    //   619: aload_2
    //   620: invokeinterface close : ()V
    //   625: aload_0
    //   626: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   629: invokevirtual isOpen : ()Z
    //   632: ifeq -> 652
    //   635: aload_0
    //   636: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   639: invokevirtual inTransaction : ()Z
    //   642: ifeq -> 652
    //   645: aload_0
    //   646: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   649: invokevirtual endTransaction : ()V
    //   652: aload_1
    //   653: athrow
    // Exception table:
    //   from	to	target	type
    //   25	34	564	java/lang/Exception
    //   25	34	556	finally
    //   39	48	564	java/lang/Exception
    //   39	48	556	finally
    //   53	63	564	java/lang/Exception
    //   53	63	556	finally
    //   68	75	564	java/lang/Exception
    //   68	75	556	finally
    //   80	91	564	java/lang/Exception
    //   80	91	556	finally
    //   95	104	552	java/lang/Exception
    //   95	104	610	finally
    //   112	118	552	java/lang/Exception
    //   112	118	610	finally
    //   122	131	552	java/lang/Exception
    //   122	131	610	finally
    //   135	144	552	java/lang/Exception
    //   135	144	610	finally
    //   148	158	552	java/lang/Exception
    //   148	158	610	finally
    //   162	169	552	java/lang/Exception
    //   162	169	610	finally
    //   173	184	552	java/lang/Exception
    //   173	184	610	finally
    //   188	197	548	java/lang/Exception
    //   188	197	540	finally
    //   205	211	548	java/lang/Exception
    //   205	211	540	finally
    //   215	224	548	java/lang/Exception
    //   215	224	540	finally
    //   228	237	548	java/lang/Exception
    //   228	237	540	finally
    //   241	251	548	java/lang/Exception
    //   241	251	540	finally
    //   255	262	548	java/lang/Exception
    //   255	262	540	finally
    //   266	277	548	java/lang/Exception
    //   266	277	540	finally
    //   281	290	552	java/lang/Exception
    //   281	290	610	finally
    //   298	304	552	java/lang/Exception
    //   298	304	610	finally
    //   308	317	552	java/lang/Exception
    //   308	317	610	finally
    //   321	330	552	java/lang/Exception
    //   321	330	610	finally
    //   334	344	552	java/lang/Exception
    //   334	344	610	finally
    //   348	355	552	java/lang/Exception
    //   348	355	610	finally
    //   359	370	552	java/lang/Exception
    //   359	370	610	finally
    //   374	383	548	java/lang/Exception
    //   374	383	540	finally
    //   391	397	548	java/lang/Exception
    //   391	397	540	finally
    //   401	410	548	java/lang/Exception
    //   401	410	540	finally
    //   414	423	548	java/lang/Exception
    //   414	423	540	finally
    //   427	437	548	java/lang/Exception
    //   427	437	540	finally
    //   441	448	548	java/lang/Exception
    //   441	448	540	finally
    //   452	463	548	java/lang/Exception
    //   452	463	540	finally
    //   467	476	564	java/lang/Exception
    //   467	476	556	finally
    //   484	490	564	java/lang/Exception
    //   484	490	556	finally
    //   494	501	564	java/lang/Exception
    //   494	501	556	finally
    //   567	571	610	finally }
  
  public boolean TW() {
    null = this.bJQ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bKd);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    boolean bool = false;
    Cursor cursor = null.rawQuery("select * from t_shop where _id=?", new String[] { str });
    if (cursor != null) {
      bool = cursor.moveToFirst();
      cursor.close();
    } 
    return bool;
  }
  
  public Cursor TX() {
    SQLiteDatabase sQLiteDatabase = this.bJQ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bKd);
    stringBuilder.append("");
    return sQLiteDatabase.rawQuery("select t_shop._id as _id, t_shop.sShopName as sShopName, t_shop.nShopType as nShopType,  t_shop.sShopDescription as sShopDescription,t_shop.sText as sText,  t_shop.sShopAddress as sShopAddress, t_string.sFieldName as sShopTypeName from t_shop left join t_string on t_shop.nShopType=t_string._id and t_string.nFieldType=16 where t_shop._id=?", new String[] { stringBuilder.toString() });
  }
  
  public Cursor TY() { return this.bJQ.rawQuery("select _id, sFieldName from t_string where nFieldType=16 and nShopID is null ", null); }
  
  public long TZ() {
    null = new StringBuilder();
    null.append("select _id from t_user where nShopID=");
    null.append(this.bKd);
    null.append(" and nUserRole=150001");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      long l = cursor.getLong(cursor.getColumnIndex("_id"));
      cursor.close();
      return l;
    } 
    cursor.close();
    return -1L;
  }
  
  public boolean Ua() {
    try {
      null = this.bJQ;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bKd);
      stringBuilder.append("");
      Cursor cursor = null.rawQuery("select group_concat(_id) as ids from t_role where nShopID=? and sIsActive=? group by nShopID", new String[] { stringBuilder.toString(), "N" });
      if (cursor.moveToFirst()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(cursor.getString(0));
        stringBuilder.append(")");
        String str = stringBuilder.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("ids:");
        stringBuilder1.append(str);
        bb.ao(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("update t_user set nUserRole=150003 where nUserRole in ");
        stringBuilder1.append(str);
        str = stringBuilder1.toString();
        this.bJQ.execSQL(str);
      } 
      cursor.close();
      return true;
    } catch (Exception exception) {
      a.e(exception);
      return false;
    } 
  }
  
  public long[] Y(String paramString1, String paramString2) {
    arrayOfLong = new long[2];
    arrayOfLong[0] = -1L;
    arrayOfLong[1] = -1L;
    arrayOfLong;
    String str = "";
    if (paramString2.length() == 32) {
      str = paramString2;
    } else {
      try {
        String str1 = c.cI(paramString2);
        str = str1;
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        a.e(noSuchAlgorithmException);
      } 
    } 
    cursor2 = this.bJQ.rawQuery("select _id, nShopID, nDeletionFlag from T_USER where ((sUserPhone=? and sUserPassword=?) or (sUserPhone=? and sUserPassword=?)) ", new String[] { paramString1, paramString2, paramString1, str });
    try {
      return arrayOfLong;
    } finally {
      String str1;
      str = null;
      cursor1 = cursor2;
    } 
    if (cursor1 != null)
      cursor1.close(); 
  }
  
  public boolean Z(String paramString1, String paramString2) {
    null = new StringBuilder();
    null.append("SELECT  u._id,u.sUserName,u.sUserPassword,u.nDeletionFlag,r.sRoleName from  T_USER u LEFT JOIN T_ROLE r ON u._id=r.nUserID where u.nDeletionFlag=170002 and r.sRoleName=90025 and r.sIsActive='Y' and u.nShopID = ");
    null.append(paramString1);
    null.append(" and u._id=");
    null.append(paramString2);
    null.append(";");
    null = null.toString();
    Cursor cursor2 = this.bJQ.rawQuery(null, null);
    if (cursor2 != null && cursor2.getCount() > 0) {
      cursor2.close();
      return true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT  u._id,u.sUserName,u.sUserPassword,u.nDeletionFlag from  T_USER u where u.nUserRole=150001  and u.nShopID = ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" and u._id=");
    stringBuilder.append(paramString2);
    stringBuilder.append(";");
    paramString1 = stringBuilder.toString();
    Cursor cursor1 = this.bJQ.rawQuery(paramString1, null);
    if (cursor1 != null && cursor1.getCount() > 0) {
      cursor1.close();
      return true;
    } 
    return false;
  }
  
  public long a(char paramChar1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, char paramChar2, char paramChar3) {
    long l1 = System.currentTimeMillis() + (long)Math.random() * 1000L;
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("insert into T_WAREHOUSE(_id, nShopID,nUserID,sIsActive,sName,sDescription,sNumber,sAddress,sText,sIsDefaultMoveIn,sIsDefaultMoveOut,nDateTime,nIsUpdated,nOperationTime,sPlatform ) VALUES(");
    stringBuilder.append(l1);
    stringBuilder.append(",");
    stringBuilder.append(this.bKd);
    stringBuilder.append(",");
    stringBuilder.append(this.bKe);
    stringBuilder.append(",'");
    stringBuilder.append(paramChar1);
    stringBuilder.append("','");
    stringBuilder.append(paramString1);
    stringBuilder.append("','");
    stringBuilder.append(paramString2);
    stringBuilder.append("','");
    stringBuilder.append(paramString3);
    stringBuilder.append("','");
    stringBuilder.append(paramString4);
    stringBuilder.append("','");
    stringBuilder.append(paramString5);
    stringBuilder.append("','");
    stringBuilder.append(paramChar2);
    stringBuilder.append("','");
    stringBuilder.append(paramChar3);
    stringBuilder.append("',");
    stringBuilder.append(l2);
    stringBuilder.append(",'");
    stringBuilder.append(this.bKl);
    stringBuilder.append("',");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(",'");
    stringBuilder.append(this.bKn);
    stringBuilder.append("');");
    paramString1 = stringBuilder.toString();
    this.bJQ.execSQL(paramString1);
    return l1;
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString);
    stringBuilder1.append(" limit ");
    int i = paramInt2 * paramInt1;
    stringBuilder1.append(i);
    stringBuilder1.append(",");
    stringBuilder1.append(paramInt1);
    String str = stringBuilder1.toString();
    System.out.println(str);
    bb.e("sql", str);
    for (paramInt2 = 0; paramInt2 < paramArrayOfString.length; paramInt2++)
      bb.e("para", paramArrayOfString[paramInt2]); 
    SQLiteDatabase sQLiteDatabase = this.bJQ;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append(" limit ");
    stringBuilder2.append(i);
    stringBuilder2.append(",");
    stringBuilder2.append(paramInt1);
    return sQLiteDatabase.rawQuery(stringBuilder2.toString(), paramArrayOfString);
  }
  
  protected String a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("select * from serverDb.");
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
  
  protected StringBuilder a(StringBuilder paramStringBuilder) {
    if (paramStringBuilder == null)
      return new StringBuilder(); 
    paramStringBuilder.setLength(0);
    paramStringBuilder.delete(0, paramStringBuilder.length());
    return paramStringBuilder;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, char paramChar1, char paramChar2) {
    this.bJQ.beginTransaction();
    if (paramChar1 == 'Y') {
      try {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("update T_WAREHOUSE set sIsDefaultMoveIn = 'N',nIsUpdated=0 where sIsDefaultMoveIn = 'Y' and nShopID = ");
        stringBuilder2.append(this.bKd);
        String str = stringBuilder2.toString();
        this.bJQ.execSQL(str);
        if (paramChar2 == 'Y') {
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("update T_WAREHOUSE set sIsDefaultMoveOut = 'N',nIsUpdated=0 where sIsDefaultMoveOut = 'Y' and nShopID = ");
          stringBuilder3.append(this.bKd);
          String str1 = stringBuilder3.toString();
          this.bJQ.execSQL(str1);
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("update T_WAREHOUSE set sNumber = '");
        stringBuilder1.append(paramString3);
        stringBuilder1.append("',sName = '");
        stringBuilder1.append(paramString1);
        stringBuilder1.append("',sDescription = '");
        stringBuilder1.append(paramString2);
        stringBuilder1.append("',sAddress = '");
        stringBuilder1.append(paramString4);
        stringBuilder1.append("',sText = '");
        stringBuilder1.append(paramString5);
        stringBuilder1.append("',sIsDefaultMoveIn = '");
        stringBuilder1.append(paramChar1);
        stringBuilder1.append("',sIsDefaultMoveOut = '");
        stringBuilder1.append(paramChar2);
        stringBuilder1.append("',nIsUpdated=0 , nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id = ");
        stringBuilder1.append(paramLong);
        paramString1 = stringBuilder1.toString();
        this.bJQ.execSQL(paramString1);
        this.bJQ.setTransactionSuccessful();
      } catch (Exception paramString1) {
        this.bJQ.endTransaction();
        a.e(paramString1);
      } 
      this.bJQ.endTransaction();
      return;
    } 
    if (paramChar2 == 'Y') {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update T_WAREHOUSE set sIsDefaultMoveOut = 'N',nIsUpdated=0 where sIsDefaultMoveOut = 'Y' and nShopID = ");
      stringBuilder1.append(this.bKd);
      String str = stringBuilder1.toString();
      this.bJQ.execSQL(str);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_WAREHOUSE set sNumber = '");
    stringBuilder.append(paramString3);
    stringBuilder.append("',sName = '");
    stringBuilder.append(paramString1);
    stringBuilder.append("',sDescription = '");
    stringBuilder.append(paramString2);
    stringBuilder.append("',sAddress = '");
    stringBuilder.append(paramString4);
    stringBuilder.append("',sText = '");
    stringBuilder.append(paramString5);
    stringBuilder.append("',sIsDefaultMoveIn = '");
    stringBuilder.append(paramChar1);
    stringBuilder.append("',sIsDefaultMoveOut = '");
    stringBuilder.append(paramChar2);
    stringBuilder.append("',nIsUpdated=0 , nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id = ");
    stringBuilder.append(paramLong);
    paramString1 = stringBuilder.toString();
    this.bJQ.execSQL(paramString1);
    this.bJQ.setTransactionSuccessful();
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("insert into  T_ORDERNUMBER   ( _id ,  sBusinessType , nDateTime , sIsActive , sPersonNameShort , nNumber ,nIsUpdated,nOperationTime,sPlatform ) values ( ");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append((long)Math.random() * 1000L);
    stringBuilder.append(",'");
    stringBuilder.append(paramString2);
    stringBuilder.append("' ,");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" ,'");
    stringBuilder.append(paramString3);
    stringBuilder.append("' ,'");
    stringBuilder.append(paramString1);
    stringBuilder.append("' ,");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",'");
    stringBuilder.append(this.bKl);
    stringBuilder.append("',");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(",'");
    stringBuilder.append(this.bKn);
    stringBuilder.append("'  );");
    paramString1 = stringBuilder.toString();
    this.bJQ.execSQL(paramString1);
  }
  
  public boolean a(long paramLong, double paramDouble1, double paramDouble2, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update [T_PRODUCTDOC] set [nIsUpdated]=0,[fAmount]=");
    stringBuilder.append(paramDouble1);
    stringBuilder.append(", [fReceived]=");
    stringBuilder.append(paramDouble2);
    stringBuilder.append(",  [sText]='");
    stringBuilder.append(paramString);
    stringBuilder.append("' ");
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(",nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where [_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append("  and [T_PRODUCTDOC].[nShopID]=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" ");
    paramString = stringBuilder.toString();
    this.bJQ.execSQL(paramString);
    return true;
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete from T_PRODUCTDOC where nDateTime between ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" and ");
    stringBuilder.append(paramLong3);
    stringBuilder.append(";");
    String str = stringBuilder.toString();
    this.bJQ.execSQL(str);
    return true;
  }
  
  public boolean a(long paramLong1, long paramLong2, String paramString) {
    this.bJQ.beginTransaction();
    try {
      boolean bool2 = e(paramLong2, paramString);
      boolean bool1 = bool2;
      if (bool2)
        bool1 = f(paramLong1, paramString); 
      this.bJQ.setTransactionSuccessful();
      this.bJQ.endTransaction();
      return bool1;
    } catch (Exception paramString) {
      this.bJQ.endTransaction();
      a.e(paramString);
      this.bJQ.endTransaction();
      return false;
    } finally {}
    this.bJQ.endTransaction();
    throw paramString;
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("update [T_PRODUCTDOC] set [nIsUpdated]=0,[sBPartnerContact]='");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("',[sBPartnerMobile]='");
    stringBuilder2.append(paramString2);
    stringBuilder2.append("',[sText]='");
    stringBuilder2.append(paramString3);
    stringBuilder2.append("'");
    paramString1 = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString1);
    stringBuilder1.append(",nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where [_id]=");
    stringBuilder1.append(paramLong);
    stringBuilder1.append("  and [T_PRODUCTDOC].[nShopID]=");
    stringBuilder1.append(this.bKd);
    stringBuilder1.append(" ");
    paramString1 = stringBuilder1.toString();
    this.bJQ.execSQL(paramString1);
    return true;
  }
  
  public boolean a(Handler paramHandler, String paramString) { // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield bKo : Z
    //   5: aload_2
    //   6: ldc_w '_'
    //   9: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   12: ifeq -> 44
    //   15: aload_2
    //   16: ldc_w '_encrypted'
    //   19: ldc ''
    //   21: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   24: astore #6
    //   26: aload_0
    //   27: invokestatic Dl : ()Lcom/laiqian/db/multidatabase/d/a;
    //   30: aload #6
    //   32: invokevirtual cr : (Ljava/lang/String;)Ljava/lang/String;
    //   35: aconst_null
    //   36: bipush #16
    //   38: invokestatic openDatabase : (Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   41: putfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   44: aload_0
    //   45: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   48: ldc_w ' select s_table_name,n_table_type from ts_table_profile WHERE s_table_name like 't\_%' ESCAPE '\';'
    //   51: aconst_null
    //   52: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore #7
    //   57: ldc_w java/lang/String
    //   60: iconst_2
    //   61: newarray int
    //   63: dup
    //   64: iconst_0
    //   65: aload #7
    //   67: invokeinterface getCount : ()I
    //   72: iastore
    //   73: dup
    //   74: iconst_1
    //   75: iconst_2
    //   76: iastore
    //   77: invokestatic newInstance : (Ljava/lang/Class;[I)Ljava/lang/Object;
    //   80: checkcast [[Ljava/lang/String;
    //   83: astore #6
    //   85: iconst_0
    //   86: istore_3
    //   87: aload #7
    //   89: invokeinterface moveToNext : ()Z
    //   94: ifeq -> 150
    //   97: aload #6
    //   99: iload_3
    //   100: aaload
    //   101: iconst_0
    //   102: aload #7
    //   104: aload #7
    //   106: ldc_w 's_table_name'
    //   109: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   114: invokeinterface getString : (I)Ljava/lang/String;
    //   119: aastore
    //   120: aload #6
    //   122: iload_3
    //   123: aaload
    //   124: iconst_1
    //   125: aload #7
    //   127: aload #7
    //   129: ldc_w 'n_table_type'
    //   132: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   137: invokeinterface getString : (I)Ljava/lang/String;
    //   142: aastore
    //   143: iload_3
    //   144: iconst_1
    //   145: iadd
    //   146: istore_3
    //   147: goto -> 87
    //   150: aload #7
    //   152: invokeinterface close : ()V
    //   157: aload_0
    //   158: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   161: invokevirtual getAttachedDbs : ()Ljava/util/List;
    //   164: astore #7
    //   166: aload #7
    //   168: ifnull -> 241
    //   171: aload #7
    //   173: invokeinterface iterator : ()Ljava/util/Iterator;
    //   178: astore #7
    //   180: aload #7
    //   182: invokeinterface hasNext : ()Z
    //   187: ifeq -> 241
    //   190: aload #7
    //   192: invokeinterface next : ()Ljava/lang/Object;
    //   197: checkcast android/util/Pair
    //   200: astore #8
    //   202: aload #8
    //   204: getfield first : Ljava/lang/Object;
    //   207: checkcast java/lang/String
    //   210: ldc_w 'serverDB'
    //   213: invokevirtual equals : (Ljava/lang/Object;)Z
    //   216: ifne -> 236
    //   219: aload #8
    //   221: getfield first : Ljava/lang/Object;
    //   224: checkcast java/lang/String
    //   227: ldc_w 'targetDB'
    //   230: invokevirtual equals : (Ljava/lang/Object;)Z
    //   233: ifeq -> 180
    //   236: iconst_1
    //   237: istore_3
    //   238: goto -> 243
    //   241: iconst_0
    //   242: istore_3
    //   243: iload_3
    //   244: ifeq -> 257
    //   247: aload_0
    //   248: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   251: ldc_w 'DETACH DATABASE serverDB'
    //   254: invokevirtual execSQL : (Ljava/lang/String;)V
    //   257: aload_0
    //   258: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   261: astore #7
    //   263: new java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial <init> : ()V
    //   270: astore #8
    //   272: aload #8
    //   274: ldc_w 'ATTACH DATABASE ''
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #8
    //   283: aload_2
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload #8
    //   290: ldc_w '' AS serverDB'
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload #7
    //   299: aload #8
    //   301: invokevirtual toString : ()Ljava/lang/String;
    //   304: invokevirtual execSQL : (Ljava/lang/String;)V
    //   307: aload_0
    //   308: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   311: invokevirtual beginTransaction : ()V
    //   314: aload #6
    //   316: arraylength
    //   317: istore #4
    //   319: iconst_0
    //   320: istore_3
    //   321: iconst_1
    //   322: istore #5
    //   324: iload_3
    //   325: iload #4
    //   327: if_icmpge -> 415
    //   330: aload_1
    //   331: ifnull -> 368
    //   334: new android/os/Message
    //   337: dup
    //   338: invokespecial <init> : ()V
    //   341: astore_2
    //   342: aload_2
    //   343: ldc_w 'MergeData'
    //   346: putfield obj : Ljava/lang/Object;
    //   349: aload_2
    //   350: iload_3
    //   351: iconst_1
    //   352: iadd
    //   353: putfield arg1 : I
    //   356: aload_2
    //   357: iload #4
    //   359: putfield arg2 : I
    //   362: aload_1
    //   363: aload_2
    //   364: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   367: pop
    //   368: aload_0
    //   369: aload #6
    //   371: iload_3
    //   372: aaload
    //   373: iconst_0
    //   374: aaload
    //   375: aload #6
    //   377: iload_3
    //   378: aaload
    //   379: iconst_1
    //   380: aaload
    //   381: invokevirtual aa : (Ljava/lang/String;Ljava/lang/String;)Z
    //   384: istore #5
    //   386: iload #5
    //   388: ifne -> 517
    //   391: aload_0
    //   392: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   395: invokevirtual endTransaction : ()V
    //   398: aload_0
    //   399: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   402: ldc_w 'DETACH DATABASE serverDB'
    //   405: invokevirtual execSQL : (Ljava/lang/String;)V
    //   408: aconst_null
    //   409: checkcast [[Ljava/lang/String;
    //   412: astore_1
    //   413: iconst_0
    //   414: ireturn
    //   415: aload_0
    //   416: aload_0
    //   417: getfield bKe : J
    //   420: invokevirtual aT : (J)D
    //   423: pop2
    //   424: aload_1
    //   425: ifnull -> 461
    //   428: new android/os/Message
    //   431: dup
    //   432: invokespecial <init> : ()V
    //   435: astore_2
    //   436: aload_2
    //   437: ldc_w 'MergeData'
    //   440: putfield obj : Ljava/lang/Object;
    //   443: aload_2
    //   444: iload #4
    //   446: putfield arg1 : I
    //   449: aload_2
    //   450: iload #4
    //   452: putfield arg2 : I
    //   455: aload_1
    //   456: aload_2
    //   457: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   460: pop
    //   461: aload_0
    //   462: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   465: invokevirtual setTransactionSuccessful : ()V
    //   468: aload_0
    //   469: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   472: invokevirtual endTransaction : ()V
    //   475: aload_0
    //   476: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   479: ldc_w 'DETACH DATABASE serverDB'
    //   482: invokevirtual execSQL : (Ljava/lang/String;)V
    //   485: aconst_null
    //   486: checkcast [[Ljava/lang/String;
    //   489: astore_1
    //   490: iload #5
    //   492: ireturn
    //   493: astore_1
    //   494: aload_0
    //   495: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   498: invokevirtual endTransaction : ()V
    //   501: aload_0
    //   502: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   505: ldc_w 'DETACH DATABASE serverDB'
    //   508: invokevirtual execSQL : (Ljava/lang/String;)V
    //   511: aload_1
    //   512: invokestatic e : (Ljava/lang/Throwable;)V
    //   515: iconst_0
    //   516: ireturn
    //   517: iload_3
    //   518: iconst_1
    //   519: iadd
    //   520: istore_3
    //   521: goto -> 324
    // Exception table:
    //   from	to	target	type
    //   314	319	493	java/lang/Exception
    //   334	368	493	java/lang/Exception
    //   368	386	493	java/lang/Exception
    //   391	413	493	java/lang/Exception
    //   415	424	493	java/lang/Exception
    //   428	461	493	java/lang/Exception
    //   461	468	493	java/lang/Exception }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean, long paramLong) {
    if (paramLong < 0L && !paramBoolean)
      return false; 
    long l = gM(paramString1);
    null = new StringBuilder();
    null.append(paramString1);
    null.append("-->");
    null.append(l);
    bb.e("nAttachTableRecordNum", null.toString());
    boolean bool = true;
    if (l == 0L)
      return true; 
    StringBuilder stringBuilder = a(this.bJQ, paramString1);
    str = "";
    try {
      StringBuilder stringBuilder3 = new StringBuilder();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("replace into ");
      stringBuilder4.append(paramString1);
      stringBuilder4.append(stringBuilder);
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
        if (paramBoolean) {
          str = " ";
        } else {
          null = new StringBuilder();
          null.append("sTableClient.nShopID=");
          null.append(paramLong);
          null.append(" and ");
          str1 = null.toString();
        } 
        stringBuilder4.append(str1);
        stringBuilder4.append(" sTableClient.nShopID=sTableServer.nShopID and sTableClient.nWarehouseID=sTableServer.nWarehouseID and sTableClient.nProductID=sTableServer.nProductID and ");
        String str1 = stringBuilder4.toString();
      } 
      if (paramString1.equalsIgnoreCase("t_string")) {
        aR(paramLong);
        str = "sTableClient.nShopID=sTableServer.nShopID and ifnull(sTableClient.sText,'')=ifnull(sTableServer.sText,'') and ";
      } 
      stringBuilder3.append(str);
      if (a.AZ().By()) {
        stringBuilder3.append("ifnull(sTableClient.nUpdateFlag,0) < ifnull(sTableServer.nUpdateFlag,0))");
      } else if ("t_product".equalsIgnoreCase(paramString1) || "t_product_ext1".equalsIgnoreCase(paramString1) || "t_bpartner".equalsIgnoreCase(paramString1)) {
        stringBuilder3.append(" 1=1 )");
      } else {
        stringBuilder3.append("ifnull(sTableClient.nUpdateFlag,0) < ifnull(sTableServer.nUpdateFlag,0))");
      } 
      stringBuilder3.append("where sTableClient._id=sTableServer._id and sTableServer.nShopID is not null and sTableServer.nShopID !=''");
      bb.e("sUpdateSQl", stringBuilder3.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append("islocked-->");
      stringBuilder5.append(this.bJQ.isDbLockedByCurrentThread());
      b.ct(stringBuilder5.toString());
      this.bJQ.execSQL(stringBuilder3.toString());
      stringBuilder3 = a(stringBuilder3);
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append("insert into ");
      stringBuilder5.append(paramString1);
      stringBuilder5.append(stringBuilder);
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" select sTableServer.* from serverDB.");
      stringBuilder5.append(paramString1);
      stringBuilder5.append(" as sTableServer left join ");
      stringBuilder5.append(paramString1);
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder3.append(" as sTableClient on(sTableClient._id=sTableServer._id ");
      str1 = "";
      if (paramString1.equalsIgnoreCase("t_stock"))
        str1 = "and sTableClient.nShopID=sTableServer.nShopID and sTableClient.nWarehouseID=sTableServer.nWarehouseID and sTableClient.nProductID=sTableServer.nProductID"; 
      if (paramString1.equalsIgnoreCase("t_string"))
        str1 = "and sTableClient.nShopID=sTableServer.nShopID and ifnull(sTableClient.sText,'')=ifnull(sTableServer.sText,'')"; 
      stringBuilder3.append(str1);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(") where sTableClient._id is null and sTableServer.nShopID is not null and sTableServer.nShopID !=''");
      if (paramBoolean) {
        str1 = "";
      } else {
        StringBuilder stringBuilder5;
        String str1;
        null = new StringBuilder();
        null.append(" and sTableServer.nShopID =");
        null.append(paramLong);
        str1 = null.toString();
      } 
      stringBuilder2.append(str1);
      stringBuilder3.append(stringBuilder2.toString());
      bb.e("sInsertSQl", stringBuilder3.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("database is locked--->");
      stringBuilder1.append(this.bJQ.isDbLockedByCurrentThread());
      b.ct(stringBuilder1.toString());
      this.bJQ.execSQL(stringBuilder3.toString());
      stringBuilder1 = a(stringBuilder3);
      paramBoolean = bool;
      if ("T_PRODUCT_EXT1".equals(paramString1)) {
        stringBuilder1.setLength(0);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("replace into T_PRODUCT_EXT1(_id,nExtendType,nSpareField3,nUserID,nShopID,nIsUpdated,nOperationTime,sPlatform) select _id,");
        if (LQKVersion.zl()) {
          byte b1 = 1;
          stringBuilder2.append(b1);
          stringBuilder2.append(",nSpareField3,nUserID,nShopID,nIsUpdated,nOperationTime,sPlatform from T_PRODUCT ;\n");
          stringBuilder1.append(stringBuilder2.toString());
          this.bJQ.execSQL(stringBuilder1.toString());
          return true;
        } 
      } else {
        return paramBoolean;
      } 
    } catch (Exception str) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(" Error");
      bb.e(stringBuilder.toString(), str.toString());
      return false;
    } 
    byte b = 2;
    stringBuilder.append(b);
    stringBuilder.append(",nSpareField3,nUserID,nShopID,nIsUpdated,nOperationTime,sPlatform from T_PRODUCT ;\n");
    str.append(stringBuilder.toString());
    this.bJQ.execSQL(str.toString());
    return true;
  }
  
  public boolean a(String paramString1, JSONArray paramJSONArray, String paramString2) {
    this.bJQ.beginTransaction();
    boolean bool = false;
    byte b = 0;
    label77: while (true) {
      try {
        if (b < paramJSONArray.length()) {
          str = "";
          JSONObject jSONObject = new JSONObject(paramJSONArray.getString(b));
          List list = Arrays.asList(ab.f(this.bJQ, paramString2));
          Iterator iterator = jSONObject.keys();
          this.bKF = a(this.bKF);
          while (true) {
            if (iterator.hasNext()) {
              String str2 = (String)iterator.next();
              if (list.contains(str2)) {
                String str3;
                Object object = new StringBuilder();
                object.append(str);
                if (str.length() == 0) {
                  str = "";
                } else {
                  str = ",";
                } 
                object.append(str);
                object.append(str2);
                String str4 = object.toString();
                try {
                  if (str2.equals("nUserID") && !by.isNull(paramString1)) {
                    String str5 = paramString1;
                  } else {
                    object = jSONObject.get(str2);
                  } 
                } catch (JSONException str) {
                  a.e(str);
                  str = str4;
                  continue;
                } 
                if (object == null) {
                  str = "";
                } else {
                  null = new StringBuilder();
                  null.append(object);
                  null.append("");
                  str1 = null.toString();
                } 
                if ("T_PRODUCTDOC".equals(paramString2) && "nProductQty".equals(str2))
                  a.dMu += Integer.parseInt(str1); 
                if ("T_ACCOUNTDOC".equals(paramString2) && "fAccountAmount".equals(str2))
                  a.dMt += Double.parseDouble(str1); 
                if ("T_ACCOUNTDOC".equals(paramString2) && "6".equals(String.valueOf(jSONObject.get("nSpareField1"))) && "1".equals(String.valueOf(jSONObject.get("nSpareField2")))) {
                  a.dMs = "微信外卖(微信支付)";
                } else if ("T_ACCOUNTDOC".equals(paramString2) && "3".equals(String.valueOf(jSONObject.get("nSpareField1"))) && "1".equals(String.valueOf(jSONObject.get("nSpareField2")))) {
                  a.dMs = "微信外卖(货到付款)";
                } else if ("T_ACCOUNTDOC".equals(paramString2) && "4".equals(String.valueOf(jSONObject.get("nSpareField1"))) && "3".equals(String.valueOf(jSONObject.get("nSpareField2")))) {
                  a.dMs = "扫码点菜(支付宝支付)";
                } else if ("T_ACCOUNTDOC".equals(paramString2) && "6".equals(String.valueOf(jSONObject.get("nSpareField1"))) && "2".equals(String.valueOf(jSONObject.get("nSpareField2")))) {
                  a.dMs = "扫码点菜(微信扫码-微信支付)";
                } 
                str2 = str1;
                if (object instanceof String) {
                  null = new StringBuilder();
                  null.append("'");
                  null.append(str1);
                  null.append("'");
                  str3 = null.toString();
                } 
                object = this.bKF;
                StringBuilder stringBuilder1 = new StringBuilder();
                if (this.bKF.length() == 0) {
                  str1 = "";
                } else {
                  str1 = ",";
                } 
                stringBuilder1.append(str1);
                stringBuilder1.append(str3);
                object.append(stringBuilder1.toString());
                str1 = str4;
              } 
              continue;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into ");
            stringBuilder.append(paramString2);
            stringBuilder.append("(");
            stringBuilder.append(str1);
            stringBuilder.append(") values(");
            stringBuilder.append(this.bKF.toString());
            stringBuilder.append(")");
            String str1 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("autoInsertData sql");
            stringBuilder.append(b);
            bb.e(stringBuilder.toString(), str1);
            this.bJQ.execSQL(str1);
            b++;
            continue label77;
          } 
          break;
        } 
        this.bJQ.setTransactionSuccessful();
        bool = true;
      } catch (Exception paramString1) {
        a.e(paramString1);
      } 
      this.bJQ.endTransaction();
      if ("T_ACCOUNTDOC".equals(paramString2)) {
        HashMap hashMap = new HashMap();
        hashMap.put("菜品数量", Integer.valueOf(a.dMu));
        hashMap.put("交易方式", a.dMs);
        hashMap.put("交易金额", Double.valueOf(a.dMt));
        bb.e("Zhuge", hashMap.toString());
        a.aAU().c(this.context, "订单交易", hashMap);
        a.axM();
      } 
      return bool;
    } 
  }
  
  public double aH(long paramLong) {
    double d;
    null = new StringBuilder();
    null.append("select _id, nStockQty from T_PRODUCT where [_id]=");
    null.append(paramLong);
    null.append(" and nShopID=");
    null.append(this.bKd);
    null.append(" ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d = cursor.getDouble(cursor.getColumnIndex("nStockQty"));
    } else {
      d = 0.0D;
    } 
    cursor.close();
    return d;
  }
  
  public Cursor aJ(long paramLong) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("SELECT *,round(nProductQty,");
    stringBuilder1.append(this.bKf);
    stringBuilder1.append(") as nProductQty,round(fPrice,");
    stringBuilder1.append(this.bKf);
    stringBuilder1.append(") as fPrice,round(T_PRODUCTDOC.fAmount, ");
    stringBuilder1.append(this.bKf);
    stringBuilder1.append(") as fAmount, [T_STRING].[sFieldName] as sTransacType,[T_PRODUCTDOC].[_id] as nDocID,[T_PRODUCTDOC].[nDateTime] as sDateTime,[T_PRODUCTDOC].[sText] as sDocText,[T_WAREHOUSE].[sName] as sWarehouseName ,[T_BPARTNER].[sName] as sBPartner,[T_PRODUCTDOC].[nDeletionFlag] as nFlag  FROM [T_PRODUCTDOC] INNER JOIN [T_STRING] ON [T_PRODUCTDOC].[nProductTransacType] = [T_STRING].[_id]  and [T_STRING].[sText] like '");
    stringBuilder1.append(this.bJA);
    stringBuilder1.append("' LEFT JOIN [T_BPARTNER] ON [T_PRODUCTDOC].[nbPartnerID] = [T_BPARTNER].[_id] LEFT JOIN [T_WAREHOUSE] ON [T_PRODUCTDOC].[nWarehouseID] = [T_WAREHOUSE].[_id]");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("where [T_PRODUCTDOC].[_id]=");
    stringBuilder2.append(paramLong);
    stringBuilder2.append("  and [T_PRODUCTDOC].[nShopID]=");
    stringBuilder2.append(this.bKd);
    stringBuilder2.append(" ");
    str = stringBuilder2.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Cursor aK(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT [T_USER].[_id] as _id,[T_USER].[sUserName],[T_USER].[sMail], [T_USER].[nUserStatus],[T_USER].[nDeletionFlag],[T_USER].[nUserRole],[T_USER].[nDateTime], [T_USER].[sUserPhone],  [T_USER].[sUserPassword],[T_USER].[sText],[T_USER].[nShopID] FROM [T_USER]  where  [T_USER].[_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append(";");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
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
    //   48: astore_2
    //   49: ldc 'laiqian.db'
    //   51: astore_1
    //   52: aload_0
    //   53: getfield bKj : Ljava/lang/String;
    //   56: ldc ''
    //   58: invokevirtual equals : (Ljava/lang/Object;)Z
    //   61: ifne -> 69
    //   64: aload_0
    //   65: getfield bKj : Ljava/lang/String;
    //   68: astore_1
    //   69: aload_0
    //   70: aload_1
    //   71: putfield bKj : Ljava/lang/String;
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore_3
    //   82: aload_3
    //   83: aload_2
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: aload_1
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_0
    //   95: aload_3
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: invokevirtual cq : (Ljava/lang/String;)V
    //   102: aload_0
    //   103: getstatic com/laiqian/db/multidatabase/a/b.aOw : Lcom/laiqian/db/multidatabase/a/b;
    //   106: invokevirtual Dk : ()Landroid/database/sqlite/SQLiteDatabase;
    //   109: putfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	115	finally
    //   52	69	115	finally
    //   69	112	115	finally }
  
  public String aL(long paramLong) {
    String str = "";
    null = new StringBuilder();
    null.append("SELECT [T_STRING].[sFieldName] as sUserStatus FROM [T_STRING]  where  [T_STRING].[_id]=");
    null.append(paramLong);
    null.append(";");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      str = cursor.getString(cursor.getColumnIndex("sUserStatus"));
    } 
    cursor.close();
    return str;
  }
  
  public String aM(long paramLong) {
    String str = "";
    null = new StringBuilder();
    null.append("SELECT [T_ROLE].[sRoleName] as sRoleName FROM [T_ROLE]  where  [T_ROLE].[_id]=");
    null.append(paramLong);
    null.append(";");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      str = cursor.getString(cursor.getColumnIndex("sRoleName"));
    } 
    cursor.close();
    return str;
  }
  
  public Cursor aN(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT [T_USER].[_id],[T_USER].[sUserName], [T_USER].[fUserAmount],[T_USER].[nDeletionFlag],[T_USER].[nUserRole] from [T_USER] where  [T_USER].[_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append(";");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Cursor aO(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT [T_USER].[_id] as _id,[T_STRING].[sFieldName] as sUserStatus,  [T_ROLE].[sRoleName] as sUserRole,  [T_ROLE].[_id] as nUserRole,  [T_USER].[nDeletionFlag] as nDeletionFlag,  [T_USER].[sUserPassword] as sUserPassword,  case   when [T_USER].[nDeletionFlag]==170001 then (select sFieldName from T_String where _id=170001 and sText like 'zh') when [T_USER].[nDeletionFlag]==170002 then (select sFieldName from T_String where _id=170002 and sText like 'zh') end 'sDeletionFlag',  [T_USER].[nShopID] as sShopName,  [T_USER].[sUserName] as sUserName,   [T_USER].[sUserPhone] as sUserPhone  FROM [T_USER]  INNER JOIN [T_STRING] ON [T_USER].[nUserStatus] = [T_STRING].[_id] and [T_STRING].[sText] like '");
    stringBuilder.append(this.bJA);
    stringBuilder.append("' INNER JOIN [T_ROLE] ON [T_USER].[nUserRole] = [T_ROLE].[_id]  where [T_USER].[nShopID]=");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and nDeletionFlag != 170003 order by nDeletionFlag desc,[T_USER].[nDateTime] desc ;");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Cursor aP(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * from t_user where nUserStatus=180001 and nDeletionFlag=170002 and nShopID = ");
    stringBuilder.append(paramLong);
    stringBuilder.append(";");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Cursor aQ(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT  u._id,u.sUserName,u.sUserPassword,u.nDeletionFlag,r.sRoleName from  T_USER u LEFT JOIN T_ROLE r ON u._id=r.nUserID where u.nDeletionFlag=170002 and r.sRoleName=90025 and r.sIsActive='Y' and u.nShopID = ");
    stringBuilder.append(paramLong);
    stringBuilder.append(";");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public long[] aS(long paramLong) {
    long[] arrayOfLong = new long[2];
    arrayOfLong[0] = -1L;
    arrayOfLong[1] = -1L;
    arrayOfLong;
    null = new StringBuilder();
    null.append("select min(nDateTime), max(nDateTime) from t_productdoc where nShopID=");
    null.append(paramLong);
    null.append(";");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.moveToFirst()) {
      arrayOfLong[0] = cursor.getLong(0);
      arrayOfLong[1] = cursor.getLong(1);
    } 
    cursor.close();
    return arrayOfLong;
  }
  
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
    //   57: iflt -> 336
    //   60: dload #5
    //   62: dstore_3
    //   63: aload #11
    //   65: aload #11
    //   67: ldc_w 'nChannelID'
    //   70: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   75: invokeinterface isNull : (I)Z
    //   80: ifeq -> 86
    //   83: goto -> 336
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
    //   288: ldc ';'
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: dload #5
    //   296: dstore_3
    //   297: aload #11
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: astore #11
    //   304: dload #5
    //   306: dstore_3
    //   307: aload_0
    //   308: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   311: aload #11
    //   313: invokevirtual execSQL : (Ljava/lang/String;)V
    //   316: dload #5
    //   318: dreturn
    //   319: astore #11
    //   321: goto -> 333
    //   324: astore #11
    //   326: aload #11
    //   328: invokestatic e : (Ljava/lang/Throwable;)V
    //   331: dload_3
    //   332: dreturn
    //   333: aload #11
    //   335: athrow
    //   336: ldc2_w 200001
    //   339: lstore #9
    //   341: goto -> 86
    // Exception table:
    //   from	to	target	type
    //   6	13	324	java/lang/Exception
    //   6	13	319	finally
    //   19	29	324	java/lang/Exception
    //   19	29	319	finally
    //   32	51	324	java/lang/Exception
    //   32	51	319	finally
    //   63	83	324	java/lang/Exception
    //   63	83	319	finally
    //   89	97	324	java/lang/Exception
    //   89	97	319	finally
    //   100	110	324	java/lang/Exception
    //   100	110	319	finally
    //   113	121	324	java/lang/Exception
    //   113	121	319	finally
    //   124	149	324	java/lang/Exception
    //   124	149	319	finally
    //   152	159	324	java/lang/Exception
    //   152	159	319	finally
    //   162	187	324	java/lang/Exception
    //   162	187	319	finally
    //   193	200	324	java/lang/Exception
    //   193	200	319	finally
    //   203	215	324	java/lang/Exception
    //   203	215	319	finally
    //   218	226	324	java/lang/Exception
    //   218	226	319	finally
    //   229	238	324	java/lang/Exception
    //   229	238	319	finally
    //   241	250	324	java/lang/Exception
    //   241	250	319	finally
    //   253	261	324	java/lang/Exception
    //   253	261	319	finally
    //   264	273	324	java/lang/Exception
    //   264	273	319	finally
    //   276	283	324	java/lang/Exception
    //   276	283	319	finally
    //   286	294	324	java/lang/Exception
    //   286	294	319	finally
    //   297	304	324	java/lang/Exception
    //   297	304	319	finally
    //   307	316	324	java/lang/Exception
    //   307	316	319	finally
    //   326	331	319	finally }
  
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
  
  public boolean aW(long paramLong) {
    this.bJQ.beginTransaction();
    try {
      null = new StringBuilder();
      null.append("update T_PRODUCTDOC set nDeletionFlag = 1,nIsUpdated=0 ,nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id = ");
      null.append(paramLong);
      null.append(" ");
      null = null.toString();
      this.bJQ.execSQL(null);
      null = new StringBuilder();
      null.append("select * from T_PRODUCTDOC where _id = ");
      null.append(paramLong);
      exception = null.toString();
      Cursor cursor = this.bJQ.rawQuery(exception, null);
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        cursor.getLong(cursor.getColumnIndex("_id"));
        paramLong = cursor.getLong(cursor.getColumnIndex("nStcokDirection"));
        long l1 = cursor.getLong(cursor.getColumnIndex("nProductTransacType"));
        long l2 = cursor.getLong(cursor.getColumnIndex("nWarehouseID"));
        long l3 = cursor.getLong(cursor.getColumnIndex("nProductID"));
        exception = cursor.getString(cursor.getColumnIndex("sProductName"));
        double d1 = cursor.getDouble(cursor.getColumnIndex("nProductQty")) * -1.0D;
        long l4 = cursor.getLong(cursor.getColumnIndex("nProductUnit"));
        double d2 = cursor.getDouble(cursor.getColumnIndex("fPrice"));
        double d3 = cursor.getDouble(cursor.getColumnIndex("fStockAmount")) * -1.0D;
        double d4 = aH(l3);
        double d5 = aI(l3);
        double d6 = o(l3, l2);
        double d7 = p(l3, l2);
        if (paramLong == 300001L && (d4 + d1 < 0.0D || d6 + d1 < 0.0D)) {
          try {
            this.bJQ.endTransaction();
            return false;
          } catch (Exception null) {}
        } else {
          long l5 = System.currentTimeMillis();
          long l6 = (long)Math.random();
          System.currentTimeMillis();
          null = new StringBuilder();
          null.append(l5 + l6 * 1000L);
          null.append("");
          String str1 = null.toString();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.bKd);
          stringBuilder1.append("");
          String str2 = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(l1);
          stringBuilder2.append("");
          String str3 = stringBuilder2.toString();
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(paramLong);
          stringBuilder3.append("");
          String str4 = stringBuilder3.toString();
          String str5 = cursor.getString(cursor.getColumnIndex("nBPartnerID"));
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append(l3);
          stringBuilder4.append("");
          String str7 = stringBuilder4.toString();
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append(d1);
          stringBuilder5.append("");
          String str8 = stringBuilder5.toString();
          String str9 = cursor.getString(cursor.getColumnIndex("nStockQty"));
          String str10 = cursor.getString(cursor.getColumnIndex("nProductUnit"));
          String str11 = cursor.getString(cursor.getColumnIndex("fPrice"));
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append(cursor.getDouble(cursor.getColumnIndex("fAmount")) * -1.0D);
          stringBuilder6.append("");
          String str12 = stringBuilder6.toString();
          StringBuilder stringBuilder7 = new StringBuilder();
          stringBuilder7.append(cursor.getDouble(cursor.getColumnIndex("fStockAmount")) * -1.0D);
          stringBuilder7.append("");
          String str13 = stringBuilder7.toString();
          StringBuilder stringBuilder8 = new StringBuilder();
          stringBuilder8.append(cursor.getDouble(cursor.getColumnIndex("fReceived")) * -1.0D);
          stringBuilder8.append("");
          String str14 = stringBuilder8.toString();
          String str15 = cursor.getString(cursor.getColumnIndex("nPhysicalInventoryID"));
          StringBuilder stringBuilder9 = new StringBuilder();
          stringBuilder9.append(this.bKe);
          stringBuilder9.append("");
          String str16 = stringBuilder9.toString();
          String str17 = cursor.getString(cursor.getColumnIndex("sText"));
          String str18 = cursor.getString(cursor.getColumnIndex("nDateTime"));
          String str19 = cursor.getString(cursor.getColumnIndex("nDeletionFlag"));
          String str20 = cursor.getString(cursor.getColumnIndex("nUpdateFlag"));
          String str21 = cursor.getString(cursor.getColumnIndex("sBPartnerContact"));
          String str22 = cursor.getString(cursor.getColumnIndex("sBPartnerMobile"));
          String str23 = cursor.getString(cursor.getColumnIndex("nWarehouseID"));
          String str24 = cursor.getString(cursor.getColumnIndex("sOrderNo"));
          String str25 = cursor.getString(cursor.getColumnIndex("sItemNo"));
          String str26 = cursor.getString(cursor.getColumnIndex("fDiscount"));
          String str27 = cursor.getString(cursor.getColumnIndex("sRefNo"));
          String str6 = cursor.getString(cursor.getColumnIndex("sHeaderText"));
          String str28 = this.bKl;
          StringBuilder stringBuilder10 = new StringBuilder();
          stringBuilder10.append(System.currentTimeMillis());
          stringBuilder10.append("");
          String str29 = stringBuilder10.toString();
          String str30 = this.bKn;
          this.bJQ.execSQL("insert into T_PRODUCTDOC(_id,nShopID,nProductTransacType,nStcokDirection,nBPartnerID,nProductID,sProductName,nProductQty,nStockQty,nProductUnit,fPrice,fAmount,fStockAmount,fReceived,nPhysicalInventoryID,nUserID,sText,nDateTime,nDeletionFlag,nUpdateFlag,sBPartnerContact, sBPartnerMobile,nWarehouseID,sOrderNo,sItemNo,fDiscount,sRefNo,sHeaderText,nIsUpdated,nOperationTime,sPlatform ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[] { 
                str1, str2, str3, str4, str5, str7, exception, str8, str9, str10, 
                str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, 
                str21, str22, str23, str24, str25, str26, str27, str6, str28, str29, 
                str30 });
          if (paramLong == 300002L) {
            paramLong = -1L;
          } else {
            paramLong = 1L;
          } 
          try {
            exception = a(l1, l2, l3, exception, d1, paramLong, l4, d2, d3);
            try {
              this.bJQ.execSQL(exception);
              str1 = a(l1, l3, d4, d5, paramLong, d6, d7, d1, d2, d3);
              h1 = this;
              try {
                h1.bJQ.execSQL(str1);
                h1.bJQ.setTransactionSuccessful();
              } catch (Exception h1) {}
            } catch (Exception null) {}
          } catch (Exception null) {}
          this.bJQ.endTransaction();
          return true;
        } 
      } else {
        this.bJQ.endTransaction();
        return true;
      } 
    } catch (Exception exception) {}
    this.bJQ.endTransaction();
    a.e(exception);
    return false;
  }
  
  public Cursor aX(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from T_BPARTNER where [_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" and bIsActive =  'Y' ");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public boolean aY(long paramLong) {
    if (paramLong != this.bKd) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update T_WAREHOUSE set sIsActive = 'N',nIsUpdated=0 , nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id = ");
      stringBuilder.append(paramLong);
      String str = stringBuilder.toString();
      this.bJQ.execSQL(str);
      return true;
    } 
    return false;
  }
  
  public Cursor aZ(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from T_WAREHOUSE where [_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" and sIsActive =  'Y' ");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public boolean aa(String paramString1, String paramString2) { return b(paramString1, paramString2, this.bKd); }
  
  public void ab(String paramString1, String paramString2) { this.bJQ.execSQL("update t_ordernumber set sPersonNameShort=?,nIsUpdated=0 where nBusinessType=? and sIsActive='Y' ;", new String[] { paramString2, paramString1 }); }
  
  public Cursor b(String paramString, String[] paramArrayOfString) {
    Log.i("sql", paramString);
    for (byte b = 0; b < paramArrayOfString.length; b++)
      bb.e("para", paramArrayOfString[b]); 
    return this.bJQ.rawQuery(paramString, paramArrayOfString);
  }
  
  public void b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {
    SQLiteDatabase sQLiteDatabase = this.bJQ;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    sQLiteDatabase.execSQL("update  T_ORDERNUMBER  set sPersonNameShort =?,nIsUpdated=0 ,nDateTime=?,nNumber=?,sIsActive=? where sBusinessType=?", new String[] { paramString1, str, stringBuilder2.toString(), paramString3, paramString2 });
  }
  
  public boolean b(String paramString1, String paramString2, long paramLong) { return a(paramString1, paramString2, false, paramLong); }
  
  public boolean b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
    this.bJQ.beginTransaction();
    try {
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("update t_bpartner set sName='");
      stringBuilder3.append(paramString3);
      stringBuilder3.append("' , sContactMobilePhone='");
      stringBuilder3.append(paramString2);
      stringBuilder3.append("',sSpareField1='");
      stringBuilder3.append(paramString8);
      stringBuilder3.append("',nSpareField5=");
      stringBuilder3.append(paramString4);
      stringBuilder3.append(",sField2='");
      stringBuilder3.append(paramString5);
      stringBuilder3.append("',sAddress='");
      stringBuilder3.append(paramString6);
      stringBuilder3.append("',sField3='");
      stringBuilder3.append(paramString7);
      stringBuilder3.append("', sContactPerson='");
      stringBuilder3.append(paramString3);
      stringBuilder3.append("' , nUpdateFlag=case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0 where _id=");
      stringBuilder3.append(paramString1);
      stringBuilder3.append(" and nShopID =");
      stringBuilder3.append(this.bKd);
      paramString4 = stringBuilder3.toString();
      this.bJQ.execSQL(paramString4);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("update t_bpartner_chargedoc set sBPartnerName='");
      stringBuilder2.append(paramString3);
      stringBuilder2.append("' , nUpdateFlag=case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0, sBPartnerMobile='");
      stringBuilder2.append(paramString2);
      stringBuilder2.append("' where nBPartnerID=");
      stringBuilder2.append(paramString1);
      stringBuilder2.append("  and nShopID =");
      stringBuilder2.append(this.bKd);
      String str = stringBuilder2.toString();
      this.bJQ.execSQL(str);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update t_productdoc set   sBPartnerContact='");
      stringBuilder1.append(paramString3);
      stringBuilder1.append("' ,nUpdateFlag=case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0, sBPartnerMobile='");
      stringBuilder1.append(paramString2);
      stringBuilder1.append("' where nBPartnerID=");
      stringBuilder1.append(paramString1);
      stringBuilder1.append("  and nShopID =");
      stringBuilder1.append(this.bKd);
      paramString1 = stringBuilder1.toString();
      this.bJQ.execSQL(paramString1);
      this.bJQ.setTransactionSuccessful();
      this.bJQ.endTransaction();
      return true;
    } catch (Exception paramString1) {
      a.e(paramString1);
      this.bJQ.endTransaction();
      return false;
    } finally {}
    this.bJQ.endTransaction();
    throw paramString1;
  }
  
  public boolean b(String paramString1, String paramString2, HashMap<String, String> paramHashMap) {
    try {
      Iterator iterator = paramHashMap.keySet().iterator();
      StringBuffer stringBuffer = new StringBuffer();
      ArrayList arrayList = new ArrayList();
      while (iterator.hasNext()) {
        String str1 = (String)iterator.next();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(",");
        stringBuilder1.append(str1);
        stringBuilder1.append("=? ");
        stringBuffer.append(stringBuilder1.toString());
        arrayList.add(paramHashMap.get(str1));
      } 
      arrayList.add(paramString2);
      String[] arrayOfString = (String[])arrayList.toArray(new String[arrayList.size()]);
      String str = stringBuffer.toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update ");
      stringBuilder.append(paramString1);
      stringBuilder.append(" set  nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0 ");
      stringBuilder.append(str);
      stringBuilder.append(" where _id = ?");
      paramString1 = stringBuilder.toString();
      this.bJQ.execSQL(paramString1, arrayOfString);
      return true;
    } catch (Exception paramString1) {
      a.e(paramString1);
      return false;
    } 
  }
  
  public boolean b(String paramString1, String paramString2, boolean paramBoolean) { return a(paramString1, paramString2, paramBoolean, this.bKd); }
  
  public boolean b(String paramString1, JSONArray paramJSONArray, String paramString2) {
    this.bJQ.beginTransaction();
    byte b = 0;
    while (true) {
      boolean bool;
      try {
        if (b < paramJSONArray.length()) {
          JSONObject jSONObject = new JSONObject(paramJSONArray.getString(b));
          List list = Arrays.asList(ab.f(this.bJQ, paramString2));
          Iterator iterator = jSONObject.keys();
          String str1 = "+";
          long l = 0L;
          boolean bool1 = false;
          String str2 = "";
          boolean bool2 = false;
          while (true);
          break;
        } 
        this.bJQ.setTransactionSuccessful();
        bool = true;
      } catch (Exception paramString1) {
        a.e(paramString1);
        bool = false;
      } 
      this.bJQ.endTransaction();
      return bool;
    } 
  }
  
  public String ba(long paramLong) {
    null = new StringBuilder();
    null.append("select * from t_string where ((nShopID is null and sText='");
    null.append(this.bJA);
    null.append("') or nShopID=");
    null.append(this.bKd);
    null.append(") and nFieldType=4 and _id = ");
    null.append(paramLong);
    null.append(" ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    return cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex("sFieldName")) : "";
  }
  
  public Cursor c(long paramLong, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT [T_PRODUCTDOC].[_id],[T_STRING].[sFieldName], [T_PRODUCTDOC].[sProductName],[T_PRODUCTDOC].[nProductQty], [T_PRODUCTDOC].[fAmount], [T_PRODUCTDOC].[fReceived],  [T_PRODUCTDOC].[nDateTime],[T_PRODUCTDOC].[sText] FROM [T_PRODUCTDOC] INNER JOIN [T_STRING] ON [T_PRODUCTDOC].[nProductTransacType] = [T_STRING].[_id] and [T_STRING].[sFieldName]='");
    stringBuilder.append(paramString);
    stringBuilder.append("' ");
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("where [T_PRODUCTDOC].[_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append("  and [T_PRODUCTDOC].[nShopID]=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" and (([T_PRODUCTDOC].[nDeletionFlag]<> 170001 and [T_PRODUCTDOC].[nDeletionFlag]<>1) or ([T_PRODUCTDOC].[nDeletionFlag] is null)) ");
    paramString = stringBuilder.toString();
    return this.bJQ.rawQuery(paramString, null);
  }
  
  public boolean c(String paramString, HashMap<String, String> paramHashMap) {
    try {
      Iterator iterator = paramHashMap.keySet().iterator();
      StringBuffer stringBuffer = new StringBuffer();
      ArrayList arrayList = new ArrayList();
      while (iterator.hasNext()) {
        String str1 = (String)iterator.next();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(",");
        stringBuilder1.append(str1);
        stringBuilder1.append("=? ");
        stringBuffer.append(stringBuilder1.toString());
        arrayList.add(paramHashMap.get(str1));
      } 
      arrayList.add(paramString);
      String[] arrayOfString = (String[])arrayList.toArray(new String[arrayList.size()]);
      paramString = stringBuffer.toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update t_user set  nUpdateFlag= case when nUpdateFlag is null then 100 else nUpdateFlag+100 end,nIsUpdated=0 ");
      stringBuilder.append(paramString);
      stringBuilder.append(" where _id = ?");
      String str = stringBuilder.toString();
      Log.e("updateUser", str);
      paramString = "";
      for (byte b = 0; b < arrayOfString.length; b++) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append(arrayOfString[b]);
        paramString = stringBuilder1.toString();
      } 
      Log.e("updateUser", paramString);
      this.bJQ.execSQL(str, arrayOfString);
      return true;
    } catch (Exception paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public boolean c(JSONObject paramJSONObject, String paramString) {
    JSONArray jSONArray = new JSONArray();
    jSONArray.put(paramJSONObject);
    av av = new av(this.context);
    String str = av.atm();
    av.close();
    return a(str, jSONArray, paramString);
  }
  
  public void close() {
    if (this.aOb != null)
      this.aOb.close(); 
    if (this.bJS != null)
      this.bJS.close(); 
    SQLiteDatabase.releaseMemory();
  }
  
  protected void cq(String paramString) { // Byte code:
    //   0: new java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual exists : ()Z
    //   13: ifne -> 276
    //   16: aconst_null
    //   17: astore #6
    //   19: aconst_null
    //   20: astore #5
    //   22: aconst_null
    //   23: astore #7
    //   25: aload_3
    //   26: invokevirtual createNewFile : ()Z
    //   29: pop
    //   30: getstatic com/laiqian/milestone/h.bJR : Z
    //   33: ifeq -> 52
    //   36: aload_0
    //   37: getfield context : Landroid/content/Context;
    //   40: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   43: ldc 'laiqian.db'
    //   45: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore_3
    //   49: goto -> 66
    //   52: aload_0
    //   53: getfield context : Landroid/content/Context;
    //   56: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   59: getstatic com/laiqian/infrastructure/R$raw.laiqian : I
    //   62: invokevirtual openRawResource : (I)Ljava/io/InputStream;
    //   65: astore_3
    //   66: aload_3
    //   67: astore #4
    //   69: aload #6
    //   71: astore #5
    //   73: new java/io/FileOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: astore_1
    //   82: sipush #8192
    //   85: newarray byte
    //   87: astore #4
    //   89: aload_3
    //   90: aload #4
    //   92: invokevirtual read : ([B)I
    //   95: istore_2
    //   96: iload_2
    //   97: ifle -> 111
    //   100: aload_1
    //   101: aload #4
    //   103: iconst_0
    //   104: iload_2
    //   105: invokevirtual write : ([BII)V
    //   108: goto -> 89
    //   111: ldc_w '从raw复制数据库成功'
    //   114: invokestatic ct : (Ljava/lang/String;)V
    //   117: aload_1
    //   118: ifnull -> 125
    //   121: aload_1
    //   122: invokevirtual close : ()V
    //   125: aload_3
    //   126: ifnull -> 276
    //   129: aload_3
    //   130: invokevirtual close : ()V
    //   133: return
    //   134: astore #4
    //   136: aload_1
    //   137: astore #5
    //   139: aload #4
    //   141: astore_1
    //   142: goto -> 246
    //   145: astore #6
    //   147: goto -> 171
    //   150: astore #6
    //   152: aload #7
    //   154: astore_1
    //   155: goto -> 171
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_3
    //   161: goto -> 246
    //   164: astore #6
    //   166: aconst_null
    //   167: astore_3
    //   168: aload #7
    //   170: astore_1
    //   171: aload_3
    //   172: astore #4
    //   174: aload_1
    //   175: astore #5
    //   177: new com/laiqian/util/logger/d
    //   180: dup
    //   181: ldc com/laiqian/milestone/h
    //   183: invokevirtual getName : ()Ljava/lang/String;
    //   186: ldc_w 'copyDatabaseFileFromAssetToPhoneLocalFolder'
    //   189: ldc '0'
    //   191: ldc_w '复制失败'
    //   194: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   197: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   200: getstatic com/laiqian/util/logger/h$b.dHB : Lcom/laiqian/util/logger/h$b;
    //   203: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   206: aload_3
    //   207: astore #4
    //   209: aload_1
    //   210: astore #5
    //   212: aload #6
    //   214: invokestatic e : (Ljava/lang/Throwable;)V
    //   217: aload_1
    //   218: ifnull -> 228
    //   221: aload_1
    //   222: invokevirtual close : ()V
    //   225: goto -> 228
    //   228: aload_3
    //   229: ifnull -> 276
    //   232: aload_3
    //   233: invokevirtual close : ()V
    //   236: return
    //   237: aload_1
    //   238: invokestatic e : (Ljava/lang/Throwable;)V
    //   241: return
    //   242: astore_1
    //   243: aload #4
    //   245: astore_3
    //   246: aload #5
    //   248: ifnull -> 259
    //   251: aload #5
    //   253: invokevirtual close : ()V
    //   256: goto -> 259
    //   259: aload_3
    //   260: ifnull -> 274
    //   263: aload_3
    //   264: invokevirtual close : ()V
    //   267: goto -> 274
    //   270: aload_3
    //   271: invokestatic e : (Ljava/lang/Throwable;)V
    //   274: aload_1
    //   275: athrow
    //   276: return
    //   277: astore_1
    //   278: goto -> 237
    //   281: astore_3
    //   282: goto -> 270
    // Exception table:
    //   from	to	target	type
    //   25	49	164	java/lang/Exception
    //   25	49	158	finally
    //   52	66	164	java/lang/Exception
    //   52	66	158	finally
    //   73	82	150	java/lang/Exception
    //   73	82	242	finally
    //   82	89	145	java/lang/Exception
    //   82	89	134	finally
    //   89	96	145	java/lang/Exception
    //   89	96	134	finally
    //   100	108	145	java/lang/Exception
    //   100	108	134	finally
    //   111	117	145	java/lang/Exception
    //   111	117	134	finally
    //   121	125	277	java/lang/Exception
    //   129	133	277	java/lang/Exception
    //   177	206	242	finally
    //   212	217	242	finally
    //   221	225	277	java/lang/Exception
    //   232	236	277	java/lang/Exception
    //   251	256	281	java/lang/Exception
    //   263	267	281	java/lang/Exception }
  
  public boolean d(long paramLong, String paramString) {
    null = "";
    try {
      String str = c.cI(paramString);
      null = str;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      a.e(noSuchAlgorithmException);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select _id from T_USER where _id=");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and ((sUserPassword='");
    stringBuilder.append(paramString);
    stringBuilder.append("') or (sUserPassword='");
    stringBuilder.append(null);
    stringBuilder.append("')) and nDeletionFlag<>170001;");
    paramString = stringBuilder.toString();
    cursor = this.bJQ.rawQuery(paramString, null);
    try {
      int i = cursor.getCount();
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  public boolean e(long paramLong, String paramString) {
    try {
      String str = c.cI(paramString);
      paramString = str;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      a.e(noSuchAlgorithmException);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_USER set sUserPassword='");
    stringBuilder.append(paramString);
    stringBuilder.append("',nIsUpdated=0  ,nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id=");
    stringBuilder.append(paramLong);
    stringBuilder.append(";");
    paramString = stringBuilder.toString();
    this.bJQ.execSQL(paramString);
    return true;
  }
  
  public boolean f(long paramLong, String paramString) {
    try {
      String str = c.cI(paramString);
      paramString = str;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      a.e(noSuchAlgorithmException);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_SHOP set sShopPassword='");
    stringBuilder.append(paramString);
    stringBuilder.append("' ,nIsUpdated=0 ,nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where _id=");
    stringBuilder.append(paramLong);
    stringBuilder.append(";");
    paramString = stringBuilder.toString();
    this.bJQ.execSQL(paramString);
    return true;
  }
  
  public boolean fX(int paramInt) {
    this.bJQ.beginTransaction();
    if (paramInt == 0)
      try {
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append("delete from T_BPARTNER where nshopid=");
        stringBuilder7.append(this.bKd);
        String str7 = stringBuilder7.toString();
        StringBuilder stringBuilder9 = new StringBuilder();
        stringBuilder9.append("delete from T_PRODUCT where nshopid=");
        stringBuilder9.append(this.bKd);
        String str9 = stringBuilder9.toString();
        StringBuilder stringBuilder11 = new StringBuilder();
        stringBuilder11.append("delete from T_PROMOTION_ITEM where nshopid=");
        stringBuilder11.append(this.bKd);
        String str11 = stringBuilder11.toString();
        StringBuilder stringBuilder13 = new StringBuilder();
        stringBuilder13.append("delete from T_ROLE where nshopid=");
        stringBuilder13.append(this.bKd);
        String str13 = stringBuilder13.toString();
        StringBuilder stringBuilder15 = new StringBuilder();
        stringBuilder15.append("delete from T_STOCK where nshopid=");
        stringBuilder15.append(this.bKd);
        String str15 = stringBuilder15.toString();
        StringBuilder stringBuilder16 = new StringBuilder();
        stringBuilder16.append("delete from T_TEMPLATE where nshopid=");
        stringBuilder16.append(this.bKd);
        String str16 = stringBuilder16.toString();
        StringBuilder stringBuilder17 = new StringBuilder();
        stringBuilder17.append("delete from T_WAREHOUSE where nshopid=");
        stringBuilder17.append(this.bKd);
        String str17 = stringBuilder17.toString();
        StringBuilder stringBuilder18 = new StringBuilder();
        stringBuilder18.append("delete from T_WAREHOUSE_USER_ACCESS where nshopid=");
        stringBuilder18.append(this.bKd);
        String str18 = stringBuilder18.toString();
        StringBuilder stringBuilder19 = new StringBuilder();
        stringBuilder19.append("delete from T_WINDOW_ACCESS where nshopid=");
        stringBuilder19.append(this.bKd);
        String str19 = stringBuilder19.toString();
        StringBuilder stringBuilder20 = new StringBuilder();
        stringBuilder20.append("delete from T_STRING where nShopID =");
        stringBuilder20.append(this.bKd);
        stringBuilder20.append(" and nFieldType in (5,44,45,53,54)");
        String str20 = stringBuilder20.toString();
        StringBuilder stringBuilder21 = new StringBuilder();
        stringBuilder21.append("delete from T_STRING where length(_id)>=13 and (nShopID is null or nShopID <>");
        stringBuilder21.append(this.bKd);
        stringBuilder21.append(")");
        String str21 = stringBuilder21.toString();
        StringBuilder stringBuilder22 = new StringBuilder();
        stringBuilder22.append("delete from t_order where nshopid=");
        stringBuilder22.append(this.bKd);
        String str22 = stringBuilder22.toString();
        this.bJQ.execSQL(str7);
        this.bJQ.execSQL(str9);
        this.bJQ.execSQL(str11);
        this.bJQ.execSQL(str13);
        this.bJQ.execSQL(str15);
        this.bJQ.execSQL(str16);
        this.bJQ.execSQL(str17);
        this.bJQ.execSQL(str18);
        this.bJQ.execSQL(str19);
        this.bJQ.execSQL(str20);
        this.bJQ.execSQL(str21);
        this.bJQ.execSQL(str22);
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("delete from T_SHIFT where nshopid=");
        stringBuilder6.append(this.bKd);
        String str6 = stringBuilder6.toString();
        StringBuilder stringBuilder8 = new StringBuilder();
        stringBuilder8.append("delete from T_PRODUCTDOC where nshopid=");
        stringBuilder8.append(this.bKd);
        String str8 = stringBuilder8.toString();
        StringBuilder stringBuilder10 = new StringBuilder();
        stringBuilder10.append("delete from T_BPARTNER_CHARGEDOC where nshopid=");
        stringBuilder10.append(this.bKd);
        String str10 = stringBuilder10.toString();
        StringBuilder stringBuilder12 = new StringBuilder();
        stringBuilder12.append("delete from t_accountdoc where nshopid=");
        stringBuilder12.append(this.bKd);
        String str12 = stringBuilder12.toString();
        StringBuilder stringBuilder14 = new StringBuilder();
        stringBuilder14.append("delete from t_BPARTNER_POINTSDOC where nshopid=");
        stringBuilder14.append(this.bKd);
        String str14 = stringBuilder14.toString();
        this.bJQ.execSQL(str6);
        this.bJQ.execSQL(str8);
        this.bJQ.execSQL(str10);
        this.bJQ.execSQL(str12);
        this.bJQ.execSQL(str14);
        this.bJQ.setTransactionSuccessful();
        this.bJQ.endTransaction();
        return true;
      } catch (Exception exception) {
        this.bJQ.endTransaction();
        a.e(exception);
        return false;
      }  
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("delete from T_SHIFT where nshopid=");
    stringBuilder1.append(this.bKd);
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("delete from T_PRODUCTDOC where nshopid=");
    stringBuilder2.append(this.bKd);
    String str2 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("delete from T_BPARTNER_CHARGEDOC where nshopid=");
    stringBuilder3.append(this.bKd);
    String str3 = stringBuilder3.toString();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("delete from t_accountdoc where nshopid=");
    stringBuilder4.append(this.bKd);
    String str4 = stringBuilder4.toString();
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append("delete from t_BPARTNER_POINTSDOC where nshopid=");
    stringBuilder5.append(this.bKd);
    String str5 = stringBuilder5.toString();
    this.bJQ.execSQL(str1);
    this.bJQ.execSQL(str2);
    this.bJQ.execSQL(str3);
    this.bJQ.execSQL(str4);
    this.bJQ.execSQL(str5);
    this.bJQ.setTransactionSuccessful();
    this.bJQ.endTransaction();
    return true;
  }
  
  public Cursor gJ(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT [T_PRODUCT].[_id], [T_PRODUCT].[nShopID], [T_PRODUCT].[sProductName],[T_PRODUCT].[sProductDescription], [T_PRODUCT].[nProductType],[T_PRODUCT].[nProductStatus], [T_PRODUCT].[fShowPrice],round([T_PRODUCT].[fBuyPrice], ");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as fBuyPrice,round([T_PRODUCT].[fStockPrice], ");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as fStockPrice,round([T_PRODUCT].[fSalePrice],");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as fSalePrice,[T_PRODUCT].[sBarcode], [T_PRODUCT].[sImage], [T_PRODUCT].[nProductUnit],round([T_PRODUCT].[nStockQty], ");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as nStockQty,[T_PRODUCT].[nCurrency], [T_PRODUCT].[nUserID],[T_PRODUCT].[sText], [T_PRODUCT].[nUpdateFlag], [T_PRODUCT].[nIsUpdated] from T_PRODUCT where [_id]=");
    stringBuilder.append(paramString);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" ;");
    paramString = stringBuilder.toString();
    return this.bJQ.rawQuery(paramString, null);
  }
  
  public Cursor gK(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT u._id,u.sUserName,u.sUserPassword,u.nDeletionFlag from  T_USER u where u.nUserRole=150001  and u.nShopID = ");
    stringBuilder.append(paramString);
    stringBuilder.append(";");
    paramString = stringBuilder.toString();
    return this.bJQ.rawQuery(paramString, null);
  }
  
  public boolean gL(String paramString) { return a(null, paramString); }
  
  public Cursor gN(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from T_USER where _id = ");
      stringBuilder.append(paramString);
      stringBuilder.append(";");
      paramString = stringBuilder.toString();
      return this.bJQ.rawQuery(paramString, null);
    } catch (Exception paramString) {
      return null;
    } 
  }
  
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
  
  public boolean gQ(String paramString) {
    Cursor cursor = this.bJQ.query("T_ORDERNUMBER", null, null, null, null, null, null);
    if (cursor.moveToFirst())
      do {
        if (paramString.equals(cursor.getString(cursor.getColumnIndex("sBusinessType"))))
          return true; 
      } while (cursor.moveToNext()); 
    return false;
  }
  
  public Cursor gR(String paramString) { return this.bJQ.rawQuery("select * from T_ORDERNUMBER where nBusinessType=?;", new String[] { paramString }); }
  
  public int gS(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select count(*) as count from T_PRODUCTDOC where sRefNo=");
    stringBuilder.append(paramString);
    paramString = stringBuilder.toString();
    Cursor cursor = this.bJQ.rawQuery(paramString, null);
    if (cursor.moveToFirst()) {
      int i = cursor.getInt(cursor.getColumnIndex("count"));
      cursor.close();
      return i;
    } 
    cursor.close();
    return 0;
  }
  
  public String getVersion() {
    null = "";
    cursor = this.bJQ.rawQuery("select sFieldValue from T_STRING where nFieldType=0 and sFieldName='version';", null);
    try {
      if (cursor.moveToFirst())
        null = cursor.getString(0); 
      return null;
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  public double o(long paramLong1, long paramLong2) {
    double d;
    null = new StringBuilder();
    null.append("select _id, nQuantity from T_STOCK where nProductID='");
    null.append(paramLong1);
    null.append("' and nWarehouseID = '");
    null.append(paramLong2);
    null.append("' and nShopID='");
    null.append(this.bKd);
    null.append("' ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d = cursor.getDouble(cursor.getColumnIndex("nQuantity"));
    } else {
      d = aH(paramLong1);
    } 
    cursor.close();
    return d;
  }
  
  public double p(long paramLong1, long paramLong2) {
    double d;
    null = new StringBuilder();
    null.append("select * from T_STOCK where nProductID=");
    null.append(paramLong1);
    null.append(" and nWarehouseID = ");
    null.append(paramLong2);
    null.append(" and nShopID=");
    null.append(this.bKd);
    null.append(" ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d = cursor.getDouble(cursor.getColumnIndex("fStockPrice"));
    } else {
      d = aI(paramLong1);
    } 
    cursor.close();
    return d;
  }
  
  public boolean p(String[] paramArrayOfString) {
    int i = paramArrayOfString.length;
    boolean bool = false;
    byte b;
    for (b = 0; b < i; b++) {
      String str = paramArrayOfString[b];
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("客户端上传时对比表-->");
      stringBuilder1.append(str);
      b.ct(stringBuilder1.toString());
    } 
    int j = paramArrayOfString.length;
    b = 0;
    i = 0;
    while (b < j) {
      String str = paramArrayOfString[b];
      int k = gP(str);
      if (k > 0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("客户端需要上传(");
        stringBuilder1.append(str);
        stringBuilder1.append("),个数->");
        stringBuilder1.append(k);
        bb.e("_Sync", stringBuilder1.toString());
      } 
      i += k;
      b++;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("客户端需要上传的数据总个数->");
    stringBuilder.append(i);
    bb.e("_Sync", stringBuilder.toString());
    if (i > 0)
      bool = true; 
    return bool;
  }
  
  public long q(String[] paramArrayOfString) { // Byte code:
    //   0: aload_0
    //   1: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual beginTransaction : ()V
    //   7: ldc2_w -1
    //   10: lstore #4
    //   12: iconst_0
    //   13: istore_2
    //   14: lload #4
    //   16: lstore #8
    //   18: aload_1
    //   19: arraylength
    //   20: istore_3
    //   21: iload_2
    //   22: iload_3
    //   23: if_icmpge -> 237
    //   26: aconst_null
    //   27: astore #12
    //   29: aconst_null
    //   30: astore #11
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #10
    //   41: aload #10
    //   43: ldc_w 'select MIN(nDateTime)  from '
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #10
    //   52: aload_1
    //   53: iload_2
    //   54: aaload
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #10
    //   61: ldc_w ' where nShopID='
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #10
    //   70: aload_0
    //   71: getfield bKd : J
    //   74: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #10
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: astore #10
    //   85: aload_0
    //   86: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   89: aload #10
    //   91: aconst_null
    //   92: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore #10
    //   97: lload #4
    //   99: lstore #6
    //   101: aload #10
    //   103: invokeinterface moveToFirst : ()Z
    //   108: ifeq -> 162
    //   111: aload #10
    //   113: iconst_0
    //   114: invokeinterface getLong : (I)J
    //   119: lstore #8
    //   121: lload #4
    //   123: lstore #6
    //   125: lload #8
    //   127: lconst_0
    //   128: lcmp
    //   129: ifle -> 162
    //   132: lload #4
    //   134: lconst_0
    //   135: lcmp
    //   136: ifle -> 147
    //   139: lload #8
    //   141: lload #4
    //   143: lcmp
    //   144: iflt -> 158
    //   147: lload #4
    //   149: lstore #6
    //   151: lload #4
    //   153: lconst_0
    //   154: lcmp
    //   155: ifge -> 162
    //   158: lload #8
    //   160: lstore #6
    //   162: lload #6
    //   164: lstore #8
    //   166: aload #10
    //   168: ifnull -> 303
    //   171: lload #6
    //   173: lstore #8
    //   175: aload #10
    //   177: invokeinterface close : ()V
    //   182: lload #6
    //   184: lstore #8
    //   186: goto -> 303
    //   189: aload_1
    //   190: ifnull -> 203
    //   193: lload #4
    //   195: lstore #8
    //   197: aload_1
    //   198: invokeinterface close : ()V
    //   203: lload #4
    //   205: lstore #8
    //   207: aload #10
    //   209: athrow
    //   210: lload #4
    //   212: lstore #8
    //   214: aload #10
    //   216: ifnull -> 303
    //   219: lload #4
    //   221: lstore #8
    //   223: aload #10
    //   225: invokeinterface close : ()V
    //   230: lload #4
    //   232: lstore #8
    //   234: goto -> 303
    //   237: lload #4
    //   239: lstore #8
    //   241: aload_0
    //   242: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   245: invokevirtual setTransactionSuccessful : ()V
    //   248: aload_0
    //   249: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   252: invokevirtual endTransaction : ()V
    //   255: lload #4
    //   257: lreturn
    //   258: astore_1
    //   259: lload #8
    //   261: lstore #4
    //   263: goto -> 248
    //   266: astore #10
    //   268: aload #12
    //   270: astore #10
    //   272: goto -> 210
    //   275: astore #11
    //   277: goto -> 292
    //   280: astore #11
    //   282: aload #10
    //   284: astore_1
    //   285: aload #11
    //   287: astore #10
    //   289: goto -> 189
    //   292: goto -> 210
    //   295: astore #10
    //   297: aload #11
    //   299: astore_1
    //   300: goto -> 189
    //   303: iload_2
    //   304: iconst_1
    //   305: iadd
    //   306: istore_2
    //   307: lload #8
    //   309: lstore #4
    //   311: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   18	21	258	java/lang/Exception
    //   32	97	266	java/lang/Exception
    //   32	97	295	finally
    //   101	121	275	java/lang/Exception
    //   101	121	280	finally
    //   175	182	258	java/lang/Exception
    //   197	203	258	java/lang/Exception
    //   207	210	258	java/lang/Exception
    //   223	230	258	java/lang/Exception
    //   241	248	258	java/lang/Exception }
  
  public long r(String[] paramArrayOfString) { // Byte code:
    //   0: aload_0
    //   1: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual beginTransaction : ()V
    //   7: ldc2_w -1
    //   10: lstore #4
    //   12: iconst_0
    //   13: istore_2
    //   14: lload #4
    //   16: lstore #8
    //   18: aload_1
    //   19: arraylength
    //   20: istore_3
    //   21: iload_2
    //   22: iload_3
    //   23: if_icmpge -> 223
    //   26: aconst_null
    //   27: astore #12
    //   29: aconst_null
    //   30: astore #11
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #10
    //   41: aload #10
    //   43: ldc_w 'select MAX(nDateTime)  from '
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #10
    //   52: aload_1
    //   53: iload_2
    //   54: aaload
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #10
    //   61: ldc_w ' where nShopID='
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #10
    //   70: aload_0
    //   71: getfield bKd : J
    //   74: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #10
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: astore #10
    //   85: aload_0
    //   86: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   89: aload #10
    //   91: aconst_null
    //   92: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore #10
    //   97: lload #4
    //   99: lstore #6
    //   101: aload #10
    //   103: invokeinterface moveToFirst : ()Z
    //   108: ifeq -> 148
    //   111: aload #10
    //   113: iconst_0
    //   114: invokeinterface getLong : (I)J
    //   119: lstore #8
    //   121: lload #4
    //   123: lstore #6
    //   125: lload #8
    //   127: lconst_0
    //   128: lcmp
    //   129: ifle -> 148
    //   132: lload #4
    //   134: lstore #6
    //   136: lload #8
    //   138: lload #4
    //   140: lcmp
    //   141: ifle -> 148
    //   144: lload #8
    //   146: lstore #6
    //   148: lload #6
    //   150: lstore #8
    //   152: aload #10
    //   154: ifnull -> 289
    //   157: lload #6
    //   159: lstore #8
    //   161: aload #10
    //   163: invokeinterface close : ()V
    //   168: lload #6
    //   170: lstore #8
    //   172: goto -> 289
    //   175: aload_1
    //   176: ifnull -> 189
    //   179: lload #4
    //   181: lstore #8
    //   183: aload_1
    //   184: invokeinterface close : ()V
    //   189: lload #4
    //   191: lstore #8
    //   193: aload #10
    //   195: athrow
    //   196: lload #4
    //   198: lstore #8
    //   200: aload #10
    //   202: ifnull -> 289
    //   205: lload #4
    //   207: lstore #8
    //   209: aload #10
    //   211: invokeinterface close : ()V
    //   216: lload #4
    //   218: lstore #8
    //   220: goto -> 289
    //   223: lload #4
    //   225: lstore #8
    //   227: aload_0
    //   228: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   231: invokevirtual setTransactionSuccessful : ()V
    //   234: aload_0
    //   235: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   238: invokevirtual endTransaction : ()V
    //   241: lload #4
    //   243: lreturn
    //   244: astore_1
    //   245: lload #8
    //   247: lstore #4
    //   249: goto -> 234
    //   252: astore #10
    //   254: aload #12
    //   256: astore #10
    //   258: goto -> 196
    //   261: astore #11
    //   263: goto -> 278
    //   266: astore #11
    //   268: aload #10
    //   270: astore_1
    //   271: aload #11
    //   273: astore #10
    //   275: goto -> 175
    //   278: goto -> 196
    //   281: astore #10
    //   283: aload #11
    //   285: astore_1
    //   286: goto -> 175
    //   289: iload_2
    //   290: iconst_1
    //   291: iadd
    //   292: istore_2
    //   293: lload #8
    //   295: lstore #4
    //   297: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   18	21	244	java/lang/Exception
    //   32	97	252	java/lang/Exception
    //   32	97	281	finally
    //   101	121	261	java/lang/Exception
    //   101	121	266	finally
    //   161	168	244	java/lang/Exception
    //   183	189	244	java/lang/Exception
    //   193	196	244	java/lang/Exception
    //   209	216	244	java/lang/Exception
    //   227	234	244	java/lang/Exception }
  
  public void t(String paramString1, String paramString2, String paramString3) { this.bJQ.execSQL("update  T_ORDERNUMBER  set nNumber=? ,nIsUpdated=0 ,nDateTime=? where nBusinessType=?", new String[] { paramString1, paramString3, paramString2 }); }
  
  public void u(String paramString1, String paramString2, String paramString3) { this.bJQ.execSQL("update t_ordernumber set nDateTime=?,nNumber=?,nIsUpdated=0  where nBusinessType=? and sIsActive='Y' ;", new String[] { paramString2, paramString3, paramString1 }); }
  
  public boolean w(aq paramaq) throws Exception {
    at at = new at(this.context);
    g g = at.bH(paramaq.aWw);
    at.close();
    this.bJQ.beginTransaction();
    try {
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("update t_bpartner set sNumber ='");
      stringBuilder3.append(paramaq.aWn);
      stringBuilder3.append("' , nBPartnerType = '");
      stringBuilder3.append(paramaq.aWw);
      stringBuilder3.append("' , sBPartnerTypeName = '");
      stringBuilder3.append(paramaq.aWx);
      stringBuilder3.append("' ,  sName='");
      stringBuilder3.append(paramaq.name);
      stringBuilder3.append("' , sContactMobilePhone='");
      stringBuilder3.append(paramaq.aTp);
      stringBuilder3.append("' , sSpareField1='");
      stringBuilder3.append(paramaq.getBirthday());
      stringBuilder3.append("' , sField1='");
      stringBuilder3.append(paramaq.aJX);
      stringBuilder3.append("' , sContactPerson='");
      stringBuilder3.append(paramaq.name);
      stringBuilder3.append("' , nUpdateFlag=case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0,  nSpareField1=");
      stringBuilder3.append(paramaq.aVw);
      stringBuilder3.append(", fDiscount = ");
      stringBuilder3.append(g.EU());
      stringBuilder3.append(", fPoints = ");
      stringBuilder3.append(paramaq.aWp);
      stringBuilder3.append(", fAmount = ");
      stringBuilder3.append(paramaq.aWy);
      stringBuilder3.append(",fSpareField3 =");
      stringBuilder3.append(paramaq.aWq);
      stringBuilder3.append(" where _id=");
      stringBuilder3.append(paramaq.aSW);
      stringBuilder3.append("  and nShopID =");
      stringBuilder3.append(this.bKd);
      stringBuilder3.append(" and sIsMember='Y' ");
      String str3 = stringBuilder3.toString();
      this.bJQ.execSQL(str3);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("update t_bpartner_chargedoc set sBPartnerNumber ='");
      stringBuilder2.append(paramaq.aWn);
      stringBuilder2.append("' ,  sBPartnerName='");
      stringBuilder2.append(paramaq.name);
      stringBuilder2.append("' , nUpdateFlag=case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0, sBPartnerMobile='");
      stringBuilder2.append(paramaq.aTp);
      stringBuilder2.append("' where nBPartnerID=");
      stringBuilder2.append(paramaq.aSW);
      stringBuilder2.append("  and nShopID =");
      stringBuilder2.append(this.bKd);
      String str2 = stringBuilder2.toString();
      this.bJQ.execSQL(str2);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update t_productdoc set   sBPartnerContact='");
      stringBuilder1.append(paramaq.name);
      stringBuilder1.append("' ,nUpdateFlag=case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0, sBPartnerMobile='");
      stringBuilder1.append(paramaq.aTp);
      stringBuilder1.append("' where nBPartnerID=");
      stringBuilder1.append(paramaq.aSW);
      stringBuilder1.append("  and nShopID =");
      stringBuilder1.append(this.bKd);
      String str1 = stringBuilder1.toString();
      this.bJQ.execSQL(str1);
      this.bJQ.setTransactionSuccessful();
      this.bJQ.endTransaction();
      return true;
    } catch (Exception paramaq) {
      a.e(paramaq);
      this.bJQ.endTransaction();
      return false;
    } finally {}
    this.bJQ.endTransaction();
    throw paramaq;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */