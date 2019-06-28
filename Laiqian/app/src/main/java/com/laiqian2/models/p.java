package com.laiqian.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.NonNull;
import com.laiqian.entity.s;
import com.laiqian.ordertool.a;
import java.util.ArrayList;
import java.util.List;

public class p extends r {
  public p(Context paramContext) { super(paramContext); }
  
  private long a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, String paramString4, long paramLong8) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #24
    //   9: new com/laiqian/models/r$a
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #25
    //   18: aload #25
    //   20: getstatic com/laiqian/models/p.bPu : Lcom/laiqian/models/ao$b;
    //   23: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   26: lload #21
    //   28: invokestatic valueOf : (J)Ljava/lang/Long;
    //   31: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   34: pop
    //   35: aload #25
    //   37: getstatic com/laiqian/models/p.bNi : Lcom/laiqian/models/ao$b;
    //   40: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   43: lload_1
    //   44: invokestatic valueOf : (J)Ljava/lang/Long;
    //   47: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload #25
    //   53: getstatic com/laiqian/models/p.bPn : Lcom/laiqian/models/ao$b;
    //   56: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   59: lload_3
    //   60: invokestatic valueOf : (J)Ljava/lang/Long;
    //   63: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload #25
    //   69: getstatic com/laiqian/models/p.bPo : Lcom/laiqian/models/ao$b;
    //   72: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   75: aload #5
    //   77: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload #25
    //   83: getstatic com/laiqian/models/p.bPp : Lcom/laiqian/models/ao$b;
    //   86: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   89: aload #6
    //   91: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload #25
    //   97: getstatic com/laiqian/models/p.bPq : Lcom/laiqian/models/ao$b;
    //   100: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   103: aload #7
    //   105: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload #25
    //   111: getstatic com/laiqian/models/p.bPr : Lcom/laiqian/models/ao$b;
    //   114: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   117: iload #8
    //   119: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   122: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload #25
    //   128: getstatic com/laiqian/models/p.bPs : Lcom/laiqian/models/ao$b;
    //   131: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   134: lload #9
    //   136: invokestatic valueOf : (J)Ljava/lang/Long;
    //   139: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload #25
    //   145: getstatic com/laiqian/models/p.bPt : Lcom/laiqian/models/ao$b;
    //   148: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   151: iload #11
    //   153: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   156: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: aload #25
    //   162: getstatic com/laiqian/models/p.bNY : Lcom/laiqian/models/ao$b;
    //   165: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   168: lload #12
    //   170: invokestatic valueOf : (J)Ljava/lang/Long;
    //   173: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload #25
    //   179: getstatic com/laiqian/models/p.bOc : Lcom/laiqian/models/ao$b;
    //   182: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   185: lload #14
    //   187: invokestatic valueOf : (J)Ljava/lang/Long;
    //   190: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: aload #25
    //   196: getstatic com/laiqian/models/p.bNr : Lcom/laiqian/models/ao$b;
    //   199: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   202: lload #16
    //   204: invokestatic valueOf : (J)Ljava/lang/Long;
    //   207: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   210: pop
    //   211: aload #25
    //   213: getstatic com/laiqian/models/p.bNw : Lcom/laiqian/models/ao$b;
    //   216: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   219: lload #18
    //   221: invokestatic valueOf : (J)Ljava/lang/Long;
    //   224: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: aload #25
    //   230: getstatic com/laiqian/models/p.bNx : Lcom/laiqian/models/ao$b;
    //   233: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
    //   236: aload #20
    //   238: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   241: pop
    //   242: aload #24
    //   244: aload #25
    //   246: invokevirtual add : (Ljava/lang/Object;)Z
    //   249: pop
    //   250: aload_0
    //   251: aload #24
    //   253: invokevirtual M : (Ljava/util/ArrayList;)Z
    //   256: istore #23
    //   258: iload #23
    //   260: ifeq -> 265
    //   263: lload_1
    //   264: lreturn
    //   265: lconst_0
    //   266: lreturn
    //   267: astore #5
    //   269: aload #5
    //   271: invokestatic e : (Ljava/lang/Throwable;)V
    //   274: lconst_0
    //   275: lreturn
    // Exception table:
    //   from	to	target	type
    //   250	258	267	java/lang/Exception }
  
  public List<String> Va() {
    System.currentTimeMillis();
    return new ArrayList();
  }
  
  public boolean Vb() {
    ContentValues contentValues = new ContentValues();
    contentValues.put("sIsActive", "N");
    contentValues.put("nIsUpdated", Integer.valueOf(0));
    return (aNE.update(Vz(), contentValues, " nShopID = ?", new String[] { VC() }) == 1);
  }
  
  public long a(long paramLong1, String paramString, int paramInt, long paramLong2) {
    long l1 = Long.parseLong(VD());
    long l2 = Long.parseLong(getUserID());
    long l3 = Long.parseLong(VC());
    return a(paramLong1, paramLong1, a.aP(this.mContext), paramString, Build.BRAND, paramInt, l1, 0, l3, l2, paramLong1, paramLong1, "android", paramLong2);
  }
  
  public s bn(long paramLong) {
    null = new StringBuilder();
    null.append(System.currentTimeMillis() - 86400000L);
    null.append("");
    String str1 = null.toString();
    null = new StringBuilder();
    null.append("select * from ");
    null.append(Vz());
    null.append(" where nSpareFiled1 = ? and sIsActive='Y' and  nOperationTime > ?");
    null = null.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    String str2 = stringBuilder.toString();
    Cursor cursor = aNE.rawQuery(null, new String[] { str2, str1 });
    if (cursor.moveToFirst()) {
      paramLong = cursor.getLong(cursor.getColumnIndex("_id"));
      str1 = cursor.getString(cursor.getColumnIndex("sMessage"));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(cursor.getLong(cursor.getColumnIndex("nMessageType")));
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      s s = new s(paramLong, cursor.getLong(cursor.getColumnIndex("nSpareFiled1")), str1, str);
    } else {
      str1 = null;
    } 
    cursor.close();
    return str1;
  }
  
  public Cursor ht(@NonNull String paramString) {
    SQLiteDatabase sQLiteDatabase = aNE;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from ");
    stringBuilder.append(Vz());
    stringBuilder.append(" where _id = ? AND nShopID = ?");
    return sQLiteDatabase.rawQuery(stringBuilder.toString(), new String[] { paramString, VC() });
  }
  
  public boolean hu(@NonNull String paramString) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("sIsActive", "N");
    contentValues.put("nIsUpdated", Integer.valueOf(0));
    return (aNE.update(Vz(), contentValues, " _id = ? AND nShopID = ?", new String[] { paramString, VC() }) == 1);
  }
  
  public boolean hv(@NonNull String paramString) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("sIsActive", "N");
    contentValues.put("nIsUpdated", Integer.valueOf(0));
    return (aNE.update(Vz(), contentValues, " nOrderID = ? AND nShopID = ?", new String[] { paramString, VC() }) == 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */