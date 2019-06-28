package com.laiqian.opentable.b;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.av;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.t;
import com.laiqian.util.av;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.Collections;

public class q extends av {
  av aIP;
  
  public q(Context paramContext) {
    super(paramContext);
    this.aIP = new av(paramContext);
  }
  
  private boolean cj(long paramLong) {
    Throwable throwable;
    if (!UC())
      return false; 
    object3 = null;
    Object object1 = null;
    try {
    
    } catch (Exception null) {
    
    } finally {
      throwable = null;
      object2 = object1;
    } 
    object1 = object2;
    a.e(throwable);
    if (object2 != null)
      object2.close(); 
    return false;
  }
  
  private boolean v(long paramLong1, long paramLong2) {
    beginTransaction();
    boolean bool = w(paramLong1, paramLong2);
    if (bool)
      setTransactionSuccessful(); 
    endTransaction();
    return bool;
  }
  
  private boolean w(long paramLong1, long paramLong2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong2);
      stringBuilder.append("");
      if (!it(stringBuilder.toString()))
        return false; 
      bL(paramLong1);
      return update();
    } catch (Exception exception) {
      a.e(exception);
      return false;
    } 
  }
  
  public ArrayList<TableEntity> YD() {
    ArrayList arrayList = new ArrayList();
    hY("_id,nWarehouseID,sTableName,nMaxPerson,nStatus,nSpareField1,nSpareField2,nSpareField3,sField1,fSpareField1,nSpareField4");
    ia("_id");
    Cursor cursor = Wu();
    while (cursor.moveToNext()) {
      ArrayList arrayList1 = b.jd(cursor.getString(8));
      int i = cursor.getInt(4);
      String str = cursor.getString(5);
      long l = cursor.getLong(6);
      int j = (int)cursor.getLong(7);
      int k = (int)cursor.getLong(9);
      TableEntity tableEntity = new TableEntity(cursor.getLong(0), cursor.getLong(1), cursor.getString(2), by.parseInt(cursor.getString(3)), i, l);
      if (i > 0 && !TextUtils.isEmpty(str)) {
        if (arrayList1.size() == 0)
          arrayList1.add(new c(false, str, l, j, i, cursor.getLong(0))); 
        c c = (c)arrayList1.get(0);
        TableEntity tableEntity1 = tableEntity;
        tableEntity1.c(c);
        tableEntity1.W(arrayList1);
      } else {
        tableEntity.c(new c());
      } 
      tableEntity.eF(true);
      tableEntity.gw(k);
      arrayList.add(tableEntity);
    } 
    cursor.close();
    return arrayList;
  }
  
  public boolean a(TableEntity paramTableEntity, int paramInt, String paramString) {
    if (paramInt == 1 || paramInt == 3 || paramInt == 4) {
      if (paramInt != 4)
        am("nStatus", String.valueOf(paramTableEntity.getState())); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.Yb());
      stringBuilder.append("");
      am("nSpareField3", stringBuilder.toString());
      am("nSpareField4", String.valueOf(paramTableEntity.Xy()));
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.Yg().Yj());
      stringBuilder.append("");
      am("sSpareField2", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append(",");
      stringBuilder.append(paramTableEntity.Yg().Yj());
      Log.e("更新releatedId", stringBuilder.toString());
    } 
    if (paramInt == 2 || paramInt == 3) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.Yg().xq());
      stringBuilder.append("");
      am("nSpareField1", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.DP());
      stringBuilder.append("");
      am("nSpareField2", stringBuilder.toString());
    } 
    if (paramString != null)
      am("sField1", paramString); 
    return v(paramTableEntity.getID(), paramTableEntity.XY());
  }
  
  public TableEntity ck(long paramLong) {
    TableEntity tableEntity;
    hY("_id,nWarehouseID,sTableName,nMaxPerson,nStatus,nSpareField1,nSpareField2,nSpareField3,sField1,nSpareField4");
    ia("_id");
    Cursor cursor = bM(paramLong);
    Collections.sort(new ArrayList());
    if (cursor.moveToNext()) {
      null = cursor.getString(8);
      int i = cursor.getInt(4);
      String str = cursor.getString(5);
      paramLong = cursor.getLong(6);
      int k = (int)cursor.getLong(7);
      int j = (int)cursor.getLong(9);
      ArrayList arrayList = b.jd(null);
      tableEntity = new TableEntity(cursor.getLong(0), cursor.getLong(1), cursor.getString(2), by.parseInt(cursor.getString(3)), i, paramLong);
      if (i > 0 && !TextUtils.isEmpty(str)) {
        if (arrayList.size() == 0)
          arrayList.add(new c(false, str, paramLong, k, i, cursor.getLong(0))); 
        for (i = 0; i < arrayList.size(); i++)
          ((c)arrayList.get(i)).Ym(); 
        c c = (c)arrayList.get(0);
        TableEntity tableEntity1 = tableEntity;
        tableEntity1.c(c);
        tableEntity1.W(arrayList);
      } else {
        tableEntity.c(new c());
      } 
      tableEntity.eF(true);
      tableEntity.gw(j);
    } else {
      tableEntity = null;
    } 
    cursor.close();
    return tableEntity;
  }
  
  public boolean g(TableEntity paramTableEntity, int paramInt) { return a(paramTableEntity, paramInt, null); }
  
  public boolean g(long... paramVarArgs) {
    beginTransaction();
    boolean bool = true;
    for (byte b = 0; b < paramVarArgs.length; b++) {
      bool = cj(paramVarArgs[b]);
      if (!bool)
        break; 
    } 
    if (bool)
      setTransactionSuccessful(); 
    endTransaction();
    return bool;
  }
  
  public boolean jr(String paramString) {
    try {
      beginTransaction();
      boolean bool = iu(paramString);
      if (!bool) {
        endTransaction();
        return false;
      } 
      setTransactionSuccessful();
      endTransaction();
      return true;
    } catch (Exception paramString) {
      a.e(paramString);
      endTransaction();
      return false;
    } finally {}
    endTransaction();
    throw paramString;
  }
  
  public boolean js(String paramString) {
    hY("count(*)");
    Cursor cursor = iv(paramString);
    cursor.moveToFirst();
    boolean bool = false;
    if (cursor.getInt(0) > 0)
      bool = true; 
    cursor.close();
    return bool;
  }
  
  public boolean p(TableEntity paramTableEntity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.getID());
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.Vz());
    stringBuilder.append("");
    am("sTableName", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.XY());
    stringBuilder.append("");
    am("nWarehouseID", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.XZ());
    stringBuilder.append("");
    am("nMaxPerson", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.XY());
    stringBuilder.append("");
    return jr(stringBuilder.toString());
  }
  
  public boolean q(TableEntity paramTableEntity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.getID());
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    am("sTableName", paramTableEntity.Vz());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.XY());
    stringBuilder.append("");
    am("nWarehouseID", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.XZ());
    stringBuilder.append("");
    am("nMaxPerson", stringBuilder.toString());
    am("nSpareField4", String.valueOf(paramTableEntity.Xy()));
    am("sField1", b.Q(paramTableEntity.Yh()));
    return v(paramTableEntity.getID(), paramTableEntity.XY());
  }
  
  public ArrayList<TableEntity> x(long paramLong1, long paramLong2) {
    ArrayList arrayList = new ArrayList();
    hY("_id,nWarehouseID,sTableName,nMaxPerson,nStatus,nSpareField1,nSpareField2,nSpareField3,sField1,nSpareField4");
    ia("_id");
    Cursor cursor = bN(paramLong1);
    while (cursor.moveToNext()) {
      paramLong1 = cursor.getLong(0);
      ArrayList arrayList1 = b.jd(cursor.getString(8));
      int i = cursor.getInt(4);
      String str = cursor.getString(5);
      long l = cursor.getLong(6);
      int j = (int)cursor.getLong(7);
      int k = (int)cursor.getLong(9);
      TableEntity tableEntity = new TableEntity(paramLong1, cursor.getLong(1), cursor.getString(2), Integer.valueOf(cursor.getString(3)).intValue(), i, cursor.getLong(6));
      if (i > 0 && !TextUtils.isEmpty(str)) {
        if (arrayList1.size() == 0)
          arrayList1.add(new c(false, str, l, j, i, paramLong1)); 
        c c = (c)arrayList1.get(0);
        TableEntity tableEntity1 = tableEntity;
        tableEntity1.c(c);
        tableEntity1.W(arrayList1);
      } 
      tableEntity.gw(k);
      tableEntity.eF(true);
      if (paramLong2 > 0L && paramLong2 == paramLong1)
        tableEntity.eE(true); 
      arrayList.add(tableEntity);
    } 
    cursor.close();
    return arrayList;
  }
  
  public static class a extends Thread {
    private t.f bMK;
    
    private int bTo;
    
    private String ccP;
    
    private Context mContext;
    
    public a(Context param1Context, String param1String, int param1Int, t.f param1f) {
      this.mContext = param1Context;
      this.ccP = param1String;
      this.bTo = param1Int;
      this.bMK = param1f;
    }
    
    public void run() { // Byte code:
      //   0: aload_0
      //   1: invokespecial run : ()V
      //   4: new com/laiqian/online/OnlineSyncRequest$a
      //   7: dup
      //   8: invokespecial <init> : ()V
      //   11: astore_1
      //   12: new com/laiqian/models/av
      //   15: dup
      //   16: aload_0
      //   17: getfield mContext : Landroid/content/Context;
      //   20: invokespecial <init> : (Landroid/content/Context;)V
      //   23: astore_3
      //   24: goto -> 34
      //   27: astore_2
      //   28: aload_2
      //   29: invokestatic e : (Ljava/lang/Throwable;)V
      //   32: aconst_null
      //   33: astore_3
      //   34: aload_1
      //   35: aload_3
      //   36: aload_0
      //   37: getfield ccP : Ljava/lang/String;
      //   40: invokevirtual gZ : (Ljava/lang/String;)Ljava/util/ArrayList;
      //   43: aload_0
      //   44: getfield bTo : I
      //   47: invokevirtual a : (Ljava/util/Collection;I)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   50: pop
      //   51: aload_1
      //   52: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   55: invokevirtual Ea : ()Ljava/lang/String;
      //   58: invokevirtual iM : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   61: pop
      //   62: aload_1
      //   63: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   66: invokevirtual atr : ()Ljava/lang/String;
      //   69: invokevirtual iN : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   72: pop
      //   73: aload_1
      //   74: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   77: invokevirtual Tx : ()Ljava/lang/String;
      //   80: invokestatic parseLong : (Ljava/lang/String;)J
      //   83: invokevirtual bV : (J)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   86: pop
      //   87: getstatic com/laiqian/online/f.bXQ : Lcom/laiqian/online/f;
      //   90: astore_2
      //   91: aload_2
      //   92: aload_1
      //   93: invokevirtual Xj : ()Lcom/laiqian/online/OnlineSyncRequest;
      //   96: invokevirtual b : (Lcom/laiqian/online/OnlineSyncRequest;)Lcom/laiqian/online/h;
      //   99: astore_2
      //   100: aload_2
      //   101: astore_1
      //   102: aload_2
      //   103: getfield bXV : Z
      //   106: ifeq -> 129
      //   109: aload_2
      //   110: astore_1
      //   111: ldc '实时同步成功'
      //   113: invokestatic println : (Ljava/lang/Object;)V
      //   116: aload_2
      //   117: astore_1
      //   118: aload_3
      //   119: aload_0
      //   120: getfield ccP : Ljava/lang/String;
      //   123: invokevirtual ip : (Ljava/lang/String;)V
      //   126: goto -> 172
      //   129: aload_2
      //   130: astore_1
      //   131: new java/lang/StringBuilder
      //   134: dup
      //   135: invokespecial <init> : ()V
      //   138: astore #4
      //   140: aload_2
      //   141: astore_1
      //   142: aload #4
      //   144: ldc '实时同步失败'
      //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: pop
      //   150: aload_2
      //   151: astore_1
      //   152: aload #4
      //   154: aload_2
      //   155: getfield message : Ljava/lang/String;
      //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   161: pop
      //   162: aload_2
      //   163: astore_1
      //   164: aload #4
      //   166: invokevirtual toString : ()Ljava/lang/String;
      //   169: invokestatic println : (Ljava/lang/Object;)V
      //   172: aload_3
      //   173: invokevirtual close : ()V
      //   176: aload_2
      //   177: ifnonnull -> 191
      //   180: aload_0
      //   181: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   184: iconst_0
      //   185: invokeinterface dp : (Z)V
      //   190: return
      //   191: aload_0
      //   192: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   195: aload_2
      //   196: getfield bXV : Z
      //   199: invokeinterface dp : (Z)V
      //   204: return
      //   205: aload_1
      //   206: invokestatic e : (Ljava/lang/Throwable;)V
      //   209: return
      //   210: astore #4
      //   212: goto -> 225
      //   215: astore_2
      //   216: aconst_null
      //   217: astore_1
      //   218: goto -> 310
      //   221: astore #4
      //   223: aconst_null
      //   224: astore_2
      //   225: aload_2
      //   226: astore_1
      //   227: new java/lang/StringBuilder
      //   230: dup
      //   231: invokespecial <init> : ()V
      //   234: astore #5
      //   236: aload_2
      //   237: astore_1
      //   238: aload #5
      //   240: ldc '请求实时同步失败'
      //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   245: pop
      //   246: aload_2
      //   247: astore_1
      //   248: aload #5
      //   250: aload #4
      //   252: invokevirtual getMessage : ()Ljava/lang/String;
      //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   258: pop
      //   259: aload_2
      //   260: astore_1
      //   261: aload #5
      //   263: invokevirtual toString : ()Ljava/lang/String;
      //   266: invokestatic println : (Ljava/lang/Object;)V
      //   269: aload_2
      //   270: astore_1
      //   271: aload #4
      //   273: invokestatic e : (Ljava/lang/Throwable;)V
      //   276: aload_3
      //   277: invokevirtual close : ()V
      //   280: aload_2
      //   281: ifnonnull -> 295
      //   284: aload_0
      //   285: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   288: iconst_0
      //   289: invokeinterface dp : (Z)V
      //   294: return
      //   295: aload_0
      //   296: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   299: aload_2
      //   300: getfield bXV : Z
      //   303: invokeinterface dp : (Z)V
      //   308: return
      //   309: astore_2
      //   310: aload_3
      //   311: invokevirtual close : ()V
      //   314: aload_1
      //   315: ifnonnull -> 331
      //   318: aload_0
      //   319: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   322: iconst_0
      //   323: invokeinterface dp : (Z)V
      //   328: goto -> 351
      //   331: aload_0
      //   332: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   335: aload_1
      //   336: getfield bXV : Z
      //   339: invokeinterface dp : (Z)V
      //   344: goto -> 351
      //   347: aload_1
      //   348: invokestatic e : (Ljava/lang/Throwable;)V
      //   351: aload_2
      //   352: athrow
      //   353: astore_1
      //   354: goto -> 205
      //   357: astore_1
      //   358: goto -> 347
      // Exception table:
      //   from	to	target	type
      //   12	24	27	java/lang/Exception
      //   91	100	221	java/lang/Exception
      //   91	100	215	finally
      //   102	109	210	java/lang/Exception
      //   102	109	309	finally
      //   111	116	210	java/lang/Exception
      //   111	116	309	finally
      //   118	126	210	java/lang/Exception
      //   118	126	309	finally
      //   131	140	210	java/lang/Exception
      //   131	140	309	finally
      //   142	150	210	java/lang/Exception
      //   142	150	309	finally
      //   152	162	210	java/lang/Exception
      //   152	162	309	finally
      //   164	172	210	java/lang/Exception
      //   164	172	309	finally
      //   180	190	353	com/laiqian/opentable/common/m
      //   191	204	353	com/laiqian/opentable/common/m
      //   227	236	309	finally
      //   238	246	309	finally
      //   248	259	309	finally
      //   261	269	309	finally
      //   271	276	309	finally
      //   284	294	353	com/laiqian/opentable/common/m
      //   295	308	353	com/laiqian/opentable/common/m
      //   318	328	357	com/laiqian/opentable/common/m
      //   331	344	357	com/laiqian/opentable/common/m }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */