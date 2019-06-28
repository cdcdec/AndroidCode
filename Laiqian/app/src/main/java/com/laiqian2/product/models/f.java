package com.laiqian.product.models;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.infrastructure.R;
import com.laiqian.models.ar;
import com.laiqian.models.as;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.Collection;

public class f extends as {
  public f(Context paramContext) {
    super(paramContext);
    gk(44);
  }
  
  private boolean aM(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nFieldType = ? and nShopID = ? and sIsActive='Y' and sFieldName = ? ");
    if (paramString1 == null) {
      paramString1 = "";
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" and _id!=");
      stringBuilder1.append(paramString1);
      paramString1 = stringBuilder1.toString();
    } 
    stringBuilder.append(paramString1);
    c(stringBuilder.toString(), new String[] { "44", VC(), paramString2 });
    Cursor cursor = VM();
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  protected boolean UA() {
    if (aM(null, VZ())) {
      hP(this.mContext.getString(R.string.pos_product_exit));
      return false;
    } 
    return true;
  }
  
  protected boolean UB() {
    if (aM(hQ(Vm()), VZ())) {
      hP(this.mContext.getString(R.string.pos_product_exit));
      return false;
    } 
    return true;
  }
  
  protected boolean UD() {
    Vd();
    return true;
  }
  
  protected boolean UE() { return true; }
  
  public ArrayList<c> akz() {
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName,sFieldValue,nSpareField1,sSpareField3");
    c("nFieldType=? and nShopID=? and sIsActive='Y'", new String[] { "44", VC() });
    ia("_id");
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(new c(cursor.getLong(0), cursor.getString(1), false, cursor.getInt(3), cursor.getDouble(2), cursor.getString(4))); 
    cursor.close();
    return arrayList;
  }
  
  public boolean bM(String paramString) {
    d("_id=? and nShopID=?", new String[] { paramString, VC() });
    boolean bool = delete();
    if (bool) {
      UE();
      if (bd.bH(this.mContext))
        (new ar.a(this.mContext, paramString, 3)).start(); 
    } 
    return bool;
  }
  
  public boolean f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    boolean bool;
    am("_id", paramString1);
    am("nFieldType", "44");
    am("sFieldName", paramString2);
    am("sFieldValue", paramString4);
    am("nSpareField1", paramString3);
    am("sSpareField3", paramString5);
    if (UA()) {
      boolean bool1 = QL();
      bool = bool1;
      if (bool1) {
        UD();
        bool = bool1;
        if (bd.bH(this.mContext)) {
          (new ar.a(this.mContext, paramString1, true)).start();
          return bool1;
        } 
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    boolean bool = false;
    d("_id=? and nShopID=?", new String[] { paramString1, VC() });
    am("_id", paramString1);
    am("nFieldType", "44");
    am("sFieldName", paramString2);
    am("sFieldValue", paramString4);
    am("nSpareField1", paramString3);
    am("sSpareField3", paramString5);
    if (UB()) {
      boolean bool1 = update();
      bool = bool1;
      if (bool1) {
        UE();
        bool = bool1;
        if (bd.bH(this.mContext)) {
          (new ar.a(this.mContext, paramString1, 2)).start();
          bool = bool1;
        } 
      } 
    } 
    return bool;
  }
  
  public ArrayList<c> mB(String paramString) {
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName,sFieldValue,nSpareField1,sSpareField3");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nFieldType=? and nShopID=? and sIsActive='Y' and (sSpareField3 like '%");
    stringBuilder.append(paramString);
    stringBuilder.append("%' or sSpareField3='' or sSpareField3 is null )");
    c(stringBuilder.toString(), new String[] { "44", VC() });
    ia("_id");
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(new c(cursor.getLong(0), cursor.getString(1), false, cursor.getInt(3), cursor.getDouble(2), cursor.getString(4))); 
    cursor.close();
    return arrayList;
  }
  
  public ArrayList<c> z(Collection<Long> paramCollection) {
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName,sFieldValue,nSpareField1,sSpareField3");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nFieldType=? and nShopID=? and sIsActive='Y' and _id in (");
    stringBuilder.append(by.a(",", paramCollection));
    stringBuilder.append(") ");
    c(stringBuilder.toString(), new String[] { "44", VC() });
    ia("_id");
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(new c(cursor.getLong(0), cursor.getString(1), false, cursor.getInt(3), cursor.getDouble(2), cursor.getString(4))); 
    cursor.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */