package com.laiqian.cashflow.b;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.a.a.a.a.a.a;
import com.laiqian.cashflow.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.x;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.av;

public class a extends x {
  private av aIP;
  
  public a(Context paramContext) {
    super(paramContext);
    this.aIP = new av(paramContext);
  }
  
  private static boolean a(long paramLong, int paramInt) {
    a1 = new OnlineSyncRequest.a();
    x x1 = new x(CrashApplication.zv());
    a1.a(x1.m(Long.valueOf(paramLong)), paramInt);
    null = new av(CrashApplication.zv());
    a1.iM(null.Ea());
    a1.iN(null.atr());
    a1.bV(Long.parseLong(null.Tx()));
    null.close();
    f f = f.bXQ;
    try {
      f.a(a1.Xj());
      x1.close();
      return true;
    } catch (Exception a1) {
      a.e(a1);
      x1.close();
      return false;
    } finally {}
    x1.close();
    throw a1;
  }
  
  public a L(long paramLong) {
    a a3 = null;
    a a2 = null;
    a1 = null;
    try {
      SQLiteDatabase sQLiteDatabase = Vq();
      String str = VC();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      exception = sQLiteDatabase.rawQuery("select t_productdoc._id, t_string.sFieldValue typeID,t_string._id subTypeID, t_string.sFieldName subTypeName,t_productdoc.fAmount,t_productdoc.sText remark,t_productdoc.nDateTime nDateTime from t_productdoc  left join t_string on t_string._id=t_productdoc.nProductID  where t_productdoc.nShopID=? AND t_productdoc._id=?", new String[] { str, stringBuilder.toString() });
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    try {
      if (exception.moveToFirst())
        a1 = (new a.a()).I(exception.getLong(1)).J(exception.getLong(2)).bI(exception.getString(3)).c(exception.getDouble(4)).bJ(exception.getString(5)).AQ(); 
      a2 = a1;
      if (exception != null) {
        exception.close();
        return a1;
      } 
    } catch (Exception a1) {
      a.e(a1);
      if (exception != null) {
        a1 = a3;
        exception.close();
        return a1;
      } 
    } finally {}
    return a2;
  }
  
  public boolean a(long paramLong1, double paramDouble, long paramLong2, long paramLong3, String paramString1, long paramLong4, String paramString2) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong1);
    stringBuilder2.append("");
    d("_id=?", new String[] { stringBuilder2.toString() });
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong2);
    stringBuilder2.append("");
    am("nStcokDirection", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong3);
    stringBuilder2.append("");
    am("nProductID", stringBuilder2.toString());
    am("sProductName", paramString1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramDouble);
    stringBuilder1.append("");
    am("fAmount", stringBuilder1.toString());
    am("sText", paramString2);
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong4);
    stringBuilder1.append("");
    am("nOperationTime", stringBuilder1.toString());
    boolean bool = update();
    if (bool) {
      hP(this.mContext.getString(2131630233));
      return bool;
    } 
    hP(this.mContext.getString(2131630232));
    return bool;
  }
  
  public boolean a(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2, long paramLong4, String paramString3) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong1);
    stringBuilder2.append("");
    am("_id", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong2);
    stringBuilder2.append("");
    am("nStcokDirection", stringBuilder2.toString());
    am("nProductTransacType", "100067");
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong3);
    stringBuilder2.append("");
    am("nProductID", stringBuilder2.toString());
    am("sProductName", paramString2);
    am("fAmount", paramString1);
    am("fReceived", paramString1);
    am("sText", paramString3);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong4);
    stringBuilder1.append("");
    am("nDateTime", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(System.currentTimeMillis());
    stringBuilder1.append("");
    am("sOrderNo", stringBuilder1.toString());
    boolean bool = QL();
    if (bool) {
      hP(this.mContext.getString(2131630213));
      return bool;
    } 
    hP(this.mContext.getString(2131630212));
    return bool;
  }
  
  public boolean bM(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_PRODUCTDOC set nIsUpdated=0,nDeletionFlag = 1,nUpdateFlag= case when nUpdateFlag is null then 10000 else nUpdateFlag+10000 end where _id = '");
    stringBuilder.append(paramString);
    stringBuilder.append("' ");
    paramString = stringBuilder.toString();
    boolean bool = false;
    try {
      Vq().execSQL(paramString);
      bool = true;
    } catch (SQLException paramString) {
      a.e(paramString);
    } catch (Exception paramString) {
      a.e(paramString);
    } 
    if (bool) {
      hP(this.mContext.getString(2131630216));
      return bool;
    } 
    hP(this.mContext.getString(2131630215));
    return bool;
  }
  
  public void close() {
    super.close();
    if (this.aIP != null) {
      this.aIP.close();
      this.aIP = null;
    } 
  }
  
  public static class a implements Runnable {
    private int aJY;
    
    private long id;
    
    public a(long param1Long, int param1Int) {
      this.id = param1Long;
      this.aJY = param1Int;
    }
    
    public void run() { a.b(this.id, this.aJY); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */