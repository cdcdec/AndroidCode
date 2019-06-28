package com.laiqian.cashflow.b;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.google.a.a.a.a.a.a;
import com.laiqian.cashflow.a.c;
import com.laiqian.cashflow.a.e;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.as;
import com.laiqian.models.at;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.av;
import java.util.ArrayList;
import java.util.List;

public class c extends as {
  private final String aKc = "52";
  
  public c(Context paramContext) { super(paramContext); }
  
  @NonNull
  public static List<e> AY() {
    ArrayList arrayList = new ArrayList();
    arrayList.add((new e.a(300001L)).bL("Expense").AV());
    arrayList.add((new e.a(300002L)).bL("Income").AV());
    return arrayList;
  }
  
  private static boolean c(String paramString, int paramInt) {
    OnlineSyncRequest.a a = new OnlineSyncRequest.a();
    at at = new at(CrashApplication.zv());
    a.a(at.gZ(paramString), paramInt);
    at.close();
    null = new av(CrashApplication.zv());
    a.iM(null.Ea());
    a.iN(null.atr());
    a.bV(Long.parseLong(null.Tx()));
    null.close();
    f = f.bXQ;
    try {
      f.a(a.Xj());
      return true;
    } catch (Exception f) {
      a.e(f);
      return false;
    } 
  }
  
  public boolean O(long paramLong) {
    am("sIsActive", "N");
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("nShopID=? and _id=? ", new String[] { str, stringBuilder.toString() });
    VS();
    boolean bool = update();
    if (bool) {
      l(this.mContext.getString(2131630196), false);
      return bool;
    } 
    l(this.mContext.getString(2131630195), false);
    return bool;
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong1);
    stringBuilder.append("");
    am("_id", stringBuilder.toString());
    am("sFieldName", paramString);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong2);
    stringBuilder.append("");
    am("sFieldValue", stringBuilder.toString());
    am("nFieldType", "52");
    if (UA()) {
      bool = QL();
      if (bool) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(2131630231));
        stringBuilder.append(" ");
        stringBuilder.append(paramString);
        stringBuilder.append(" ");
        stringBuilder.append(this.mContext.getString(2131630193));
        l(stringBuilder.toString(), false);
      } else {
        l(this.mContext.getString(2131630192), false);
      } 
    } else {
      l(this.mContext.getString(2131630198), false);
      bool = false;
    } 
    UD();
    return bool;
  }
  
  public boolean b(long paramLong1, String paramString, long paramLong2) {
    boolean bool;
    am("sFieldName", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong2);
    stringBuilder.append("");
    am("sFieldValue", stringBuilder.toString());
    if (UB()) {
      String str = VC();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLong1);
      stringBuilder1.append("");
      d("nShopID=? and _id=?", new String[] { str, stringBuilder1.toString() });
      bool = update();
      if (bool) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.mContext.getString(2131630207));
        stringBuilder2.append(" ");
        stringBuilder2.append(paramString);
        stringBuilder2.append(" ");
        stringBuilder2.append(this.mContext.getString(2131630211));
        l(stringBuilder2.toString(), false);
      } else {
        l(this.mContext.getString(2131630210), false);
      } 
    } else {
      l(this.mContext.getString(2131630198), false);
      bool = false;
    } 
    UE();
    return bool;
  }
  
  public List<c> bG(String paramString) {
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName,sFieldValue");
    c("nFieldType=? and sFieldValue =? and nShopID=? and sIsActive=? ", new String[] { "52", paramString, VC(), "Y" });
    ia("_id asc");
    Cursor cursor = VM();
    try {
      while (cursor.moveToNext())
        arrayList.add((new c.a(cursor.getLong(0))).bK(cursor.getString(1)).K(Long.parseLong(cursor.getString(2))).AU()); 
      if (cursor != null) {
        cursor.close();
        return arrayList;
      } 
    } catch (Exception exception) {
      a.e(exception);
      if (cursor != null) {
        cursor.close();
        return arrayList;
      } 
    } finally {}
    return arrayList;
  }
  
  public boolean bN(String paramString) {
    c("nshopID=? and nFieldType=? and sFieldName=?  and sIsActive='Y'", new String[] { VC(), "52", paramString });
    Cursor cursor = VM();
    try {
      if (cursor.moveToFirst()) {
        l(this.mContext.getString(2131630198), false);
        if (cursor != null)
          cursor.close(); 
        return true;
      } 
      if (cursor != null) {
        cursor.close();
        return false;
      } 
    } catch (Exception exception) {
      a.e(exception);
      if (cursor != null) {
        cursor.close();
        return false;
      } 
    } finally {
      ArrayList arrayList;
    } 
    return false;
  }
  
  public boolean c(String paramString, long paramLong) {
    str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    c("nshopID=? and nFieldType=? and sFieldName=? and _id!=? and sIsActive='Y'", new String[] { str, "52", paramString, stringBuilder.toString() });
    Cursor cursor = VM();
    try {
      if (cursor.moveToFirst()) {
        l(this.mContext.getString(2131630198), false);
        if (cursor != null)
          cursor.close(); 
        return true;
      } 
      if (cursor != null) {
        cursor.close();
        return false;
      } 
    } catch (Exception str) {
      a.e(str);
      if (cursor != null) {
        cursor.close();
        return false;
      } 
    } finally {}
    return false;
  }
  
  public void close() { super.close(); }
  
  public static class a implements Runnable {
    private int aJY;
    
    private long id;
    
    public a(long param1Long, int param1Int) {
      this.id = param1Long;
      this.aJY = param1Int;
    }
    
    public void run() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.id);
      stringBuilder.append("");
      c.d(stringBuilder.toString(), this.aJY);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */