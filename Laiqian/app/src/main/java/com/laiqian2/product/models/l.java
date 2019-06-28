package com.laiqian.product.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.models.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class l extends as {
  private long bRd = 0L;
  
  public l(Context paramContext) {
    super(paramContext);
    gk(5);
  }
  
  private boolean hM(String paramString) {
    if (paramString == null)
      return false; 
    ik(paramString);
    Cursor cursor = VM();
    if (cursor == null)
      return true; 
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  protected boolean QL() {
    boolean bool;
    if (UA()) {
      bool = Wc();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(2131630139));
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
    if (hM(Wa())) {
      hP(this.mContext.getString(2131627507));
      return false;
    } 
    return true;
  }
  
  protected boolean UB() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  public boolean V(HashMap<Long, Boolean> paramHashMap) {
    if (paramHashMap.isEmpty())
      return true; 
    try {
      beginTransaction();
      Iterator iterator = paramHashMap.keySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          String str = (Long)iterator.next();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append("");
          d("_id=? and nShopID=?", new String[] { stringBuilder.toString(), VC() });
          if (((Boolean)paramHashMap.get(str)).booleanValue()) {
            String str1 = "Y";
          } else {
            str = "N";
          } 
          am("sSpareField1", str);
          boolean bool = update();
          if (!bool) {
            endTransaction();
            return false;
          } 
          continue;
        } 
        setTransactionSuccessful();
        endTransaction();
        return true;
      } 
    } catch (Throwable paramHashMap) {
      a.e(paramHashMap);
      endTransaction();
      return false;
    } finally {}
    endTransaction();
    throw paramHashMap;
  }
  
  public ArrayList<Long> Vi() {
    ArrayList arrayList = new ArrayList();
    hY("_id");
    c("nShopID=? and sSpareField1='N'", new String[] { VC() });
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(Long.valueOf(cursor.getLong(0))); 
    cursor.close();
    return arrayList;
  }
  
  public ArrayList<ProductTypeEntity> a(boolean paramBoolean, Boolean paramBoolean1) {
    String str1;
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName,nSpareField1,sDefaultValue,sSpareField1,sSpareField2");
    ia(" sDefaultValue desc ");
    if (paramBoolean) {
      str1 = " nFieldType=5";
    } else {
      str1 = " length(nFieldType)=13";
    } 
    null = new StringBuilder();
    null.append(str1);
    null.append(" and sIsActive='Y' and nShopID=");
    null.append(VC());
    hZ(null.toString());
    Cursor cursor = VM();
    String str2 = VE();
    while (cursor.moveToNext()) {
      ProductTypeEntity productTypeEntity;
      long l1 = cursor.getLong(0);
      str1 = cursor.getString(1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l1);
      stringBuilder.append("");
      if (str2.equals(stringBuilder.toString())) {
        if (paramBoolean1 == null) {
          g g = new g(this.mContext);
          if (g.B(l1, a.AZ().Bh()).isEmpty())
            continue; 
          g.close();
        } else if (!paramBoolean1.booleanValue()) {
          continue;
        } 
        productTypeEntity = new ProductTypeEntity(l1, str1);
      } else {
        boolean bool;
        String str = cursor.getString(5);
        if (cursor.getInt(2) == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        productTypeEntity = new ProductTypeEntity(l1, productTypeEntity, str, bool);
      } 
      productTypeEntity.cVc = cursor.getInt(3);
      productTypeEntity.cgE = paramBoolean;
      productTypeEntity.cVd = "N".equals(cursor.getString(4)) ^ true;
      arrayList.add(productTypeEntity);
    } 
    cursor.close();
    return arrayList;
  }
  
  public boolean a(ProductTypeEntity paramProductTypeEntity, int paramInt) {
    String str;
    if (++paramInt < 10) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("00");
      stringBuilder1.append(paramInt);
      str = stringBuilder1.toString();
    } else if (paramInt < 100) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("0");
      stringBuilder1.append(paramInt);
      str = stringBuilder1.toString();
    } else {
      null = new StringBuilder();
      null.append(paramInt);
      null.append("");
      str = null.toString();
    } 
    am("sDefaultValue", str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramProductTypeEntity.aSW);
    stringBuilder.append("");
    d("_id=? and nShopID=?", new String[] { stringBuilder.toString(), VC() });
    boolean bool = update();
    if (bool)
      paramProductTypeEntity.cVc = paramInt; 
    return bool;
  }
  
  public int akR() {
    hY(" CAST(max(sDefaultValue) as int) ");
    null = VC();
    int i = 0;
    c("nShopID=? and nFieldType=?  ", new String[] { null, "5" });
    Cursor cursor = VM();
    if (cursor != null) {
      cursor.moveToNext();
      i = cursor.getInt(0);
      cursor.close();
    } 
    return i;
  }
  
  public void akS() {
    String str = VE();
    hY("_id");
    c("_id=? and nShopID=? and sIsActive='Y'", new String[] { str, VC() });
    Cursor cursor = VM();
    if (!cursor.moveToFirst()) {
      am("_id", VE());
      am("nFieldType", "5");
      am("sFieldName", this.mContext.getString(2131627526));
      am("sSpareField1", "Y");
      super.QL();
    } 
    cursor.close();
  }
  
  public ArrayList<HashMap<String, String>> akT() {
    null = new StringBuilder();
    null.append(" nFieldType = 5  and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y' ");
    hZ(null.toString());
    ArrayList arrayList = new ArrayList();
    Cursor cursor = VM();
    if (cursor != null) {
      while (cursor.moveToNext()) {
        HashMap hashMap = new HashMap();
        hashMap.put("_id", cursor.getString(cursor.getColumnIndex("_id")));
        hashMap.put("sDefaultValue", cursor.getString(cursor.getColumnIndex("sDefaultValue")));
        Cursor cursor1 = (new l(this.mContext)).y(cursor.getString(cursor.getColumnIndex("_id")), false);
        if (cursor1.getCount() != 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(cursor.getString(cursor.getColumnIndex("sFieldName")));
          stringBuilder.append("-");
          stringBuilder.append(cursor.getString(cursor.getColumnIndex("sFieldName")));
          hashMap.put("sFieldName", stringBuilder.toString());
        } else {
          hashMap.put("sFieldName", cursor.getString(cursor.getColumnIndex("sFieldName")));
        } 
        arrayList.add(hashMap);
        while (cursor1.moveToNext()) {
          hashMap = new HashMap();
          hashMap.put("_id", cursor1.getString(cursor1.getColumnIndex("_id")));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(cursor.getString(cursor.getColumnIndex("sFieldName")));
          stringBuilder.append("-");
          stringBuilder.append(cursor1.getString(cursor1.getColumnIndex("sFieldName")));
          hashMap.put("sFieldName", stringBuilder.toString());
          hashMap.put("sDefaultValue", cursor1.getString(cursor1.getColumnIndex("sDefaultValue")));
          arrayList.add(hashMap);
        } 
        cursor1.close();
      } 
      cursor.close();
    } 
    return arrayList;
  }
  
  public Cursor y(String paramString, boolean paramBoolean) {
    hY("_id,sFieldName,sDefaultValue,nSpareField1");
    m(paramString, paramBoolean);
    ia(" sDefaultValue desc ");
    return VM();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */