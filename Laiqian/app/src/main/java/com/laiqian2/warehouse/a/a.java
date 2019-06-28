package com.laiqian.warehouse.a;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.bi;

public class a extends bi {
  public a(Context paramContext) { super(paramContext); }
  
  public boolean axH() {
    boolean bool;
    if (UA()) {
      bool = QL();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(R.string.ud_Msg1));
      stringBuilder.append(" ");
      stringBuilder.append(WH());
      stringBuilder.append(" ");
      stringBuilder.append(this.mContext.getString(R.string.ud_createMsg2));
      hP(stringBuilder.toString());
    } else {
      bool = false;
    } 
    UD();
    return bool;
  }
  
  public boolean axI() { return !axJ() ? WJ() : 1; }
  
  public boolean axJ() {
    WG();
    Cursor cursor = VM();
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public String axK() {
    hY("MAX(sNumber) as sMaxNumber ");
    c(WF(), new String[] { VC() });
    Cursor cursor = VM();
    String str = "";
    if (cursor.moveToFirst())
      str = cursor.getString(cursor.getColumnIndex("sMaxNumber")); 
    return str;
  }
  
  public Cursor bH(String paramString1, String paramString2) {
    aq(paramString1, paramString2);
    return VM();
  }
  
  public Cursor dH(long paramLong) {
    bS(paramLong);
    return VM();
  }
  
  public String dI(long paramLong) {
    Cursor cursor = dH(paramLong);
    String str = "";
    if (cursor.moveToFirst())
      str = cursor.getString(cursor.getColumnIndex("sName")); 
    cursor.close();
    return str;
  }
  
  public boolean dJ(long paramLong) {
    try {
      beginTransaction();
      if (!UB()) {
        endTransaction();
        return false;
      } 
      bT(paramLong);
      update();
      if (!UE()) {
        endTransaction();
        return false;
      } 
      setTransactionSuccessful();
      endTransaction();
      return true;
    } catch (Exception exception) {
      endTransaction();
      a.e(exception);
      return false;
    } 
  }
  
  public boolean dK(long paramLong) {
    bT(paramLong);
    am(this.bSR, this.bSU);
    return dJ(paramLong);
  }
  
  public Cursor sw(String paramString) {
    iF(paramString);
    return VM();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */