package com.laiqian.product.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.main.d;
import com.laiqian.models.ar;
import com.laiqian.models.as;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import java.util.ArrayList;

public class b extends as {
  public b(Context paramContext) {
    super(paramContext);
    gk(5);
  }
  
  private ArrayList<d> akw() {
    ArrayList arrayList = new ArrayList();
    d.a a = new d.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append(87001L);
    arrayList.add(a.ay(by.parseLong(stringBuilder.toString())).eM("86001").eN("").KJ());
    a = new d.a();
    stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append(87002L);
    arrayList.add(a.ay(by.parseLong(stringBuilder.toString())).eM("86004").eN("").KJ());
    a = new d.a();
    stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append(87003L);
    arrayList.add(a.ay(by.parseLong(stringBuilder.toString())).eM("86003").eN("").KJ());
    a = new d.a();
    stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append(87004L);
    arrayList.add(a.ay(by.parseLong(stringBuilder.toString())).eM("86002").eN("").KJ());
    a = new d.a();
    stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append(87005L);
    arrayList.add(a.ay(by.parseLong(stringBuilder.toString())).eM("86005").eN("").KJ());
    return arrayList;
  }
  
  private void ar(ArrayList<d> paramArrayList) {
    try {
      beginTransaction();
      boolean bool = false;
      for (d d : paramArrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.getId());
        stringBuilder.append("");
        bool = H(stringBuilder.toString(), d.KH(), d.KG());
      } 
      if (bool)
        setTransactionSuccessful(); 
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
    } finally {}
    endTransaction();
  }
  
  private boolean h(String paramString, long paramLong) {
    if (paramString == null)
      return false; 
    if (paramLong > 0L) {
      l(paramString, paramLong);
    } else {
      il(paramString);
    } 
    Cursor cursor = VM();
    if (cursor == null)
      return true; 
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public boolean H(String paramString1, String paramString2, String paramString3) {
    am("_id", paramString1);
    am("sFieldName", paramString2);
    am("sFieldValue", paramString3);
    am("nFieldType", "87");
    am("nStringID", "1");
    boolean bool = QL();
    if (bool && bd.bH(this.mContext))
      (new ar.a(this.mContext, paramString1, true)).start(); 
    return bool;
  }
  
  protected boolean QL() {
    boolean bool;
    if (UA()) {
      bool = Wc();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(2131627214));
      stringBuilder.append(" ");
      stringBuilder.append(VZ());
      stringBuilder.append(" ");
      stringBuilder.append(this.mContext.getString(2131630144));
      hP(stringBuilder.toString());
    } else {
      bool = false;
    } 
    UD();
    return bool;
  }
  
  protected boolean UA() {
    if (h(Wa(), -1L)) {
      hP(this.mContext.getString(2131627507));
      return false;
    } 
    return true;
  }
  
  protected boolean UB() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  public ArrayList<d> akv() {
    ArrayList arrayList2 = new ArrayList();
    hY("_id,sFieldName,sFieldValue");
    ia(" sDefaultValue desc ");
    null = new StringBuilder();
    null.append(" nFieldType=87 and sIsActive='Y' and nShopID=");
    null.append(VC());
    hZ(null.toString());
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList2.add((new d.a()).ay(by.parseLong(cursor.getString(0))).eM(cursor.getString(1)).eN(cursor.getString(2)).KJ()); 
    ArrayList arrayList1 = arrayList2;
    if (arrayList2.size() == 0) {
      arrayList1 = akw();
      ar(arrayList1);
    } 
    cursor.close();
    return arrayList1;
  }
  
  public boolean bl(long paramLong) {
    bE(paramLong);
    boolean bool2 = UB();
    boolean bool1 = false;
    if (bool2) {
      String str;
      if (h(Wa(), paramLong)) {
        hP(this.mContext.getString(2131627507));
        return false;
      } 
      bE(paramLong);
      bool1 = update();
      if (bool1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(2131627214));
        stringBuilder.append(" ");
        stringBuilder.append(VZ());
        stringBuilder.append(" ");
        stringBuilder.append(this.mContext.getString(2131630154));
        str = stringBuilder.toString();
      } else {
        null = new StringBuilder();
        null.append(this.mContext.getString(2131627214));
        null.append(" ");
        null.append(VZ());
        null.append(" ");
        null.append(this.mContext.getString(2131630155));
        str = null.toString();
      } 
      hP(str);
    } 
    UE();
    return bool1;
  }
  
  public String mA(String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    hY("_id");
    ia(" sDefaultValue desc ");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(" nFieldType=87 and sIsActive='Y' and nShopID=");
    stringBuilder2.append(VC());
    stringBuilder2.append(" and sFieldValue like '%");
    stringBuilder2.append(paramString);
    stringBuilder2.append("%'");
    hZ(stringBuilder2.toString());
    Cursor cursor = VM();
    while (cursor.moveToNext()) {
      if (!by.isNull(stringBuilder1.toString()))
        stringBuilder1.append(","); 
      stringBuilder1.append(by.parseLong(cursor.getString(0)));
    } 
    cursor.close();
    return stringBuilder1.toString();
  }
  
  public boolean x(long paramLong, String paramString) {
    am("sFieldValue", paramString);
    return bl(paramLong);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */