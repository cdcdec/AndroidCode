package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.infrastructure.R;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.g;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ac extends as {
  private long bRd = 0L;
  
  public ac(Context paramContext) {
    super(paramContext);
    gk(5);
  }
  
  private void Vk() {
    hY("_id");
    null = new StringBuilder();
    null.append(" nFieldType=91 and sIsActive='Y' and nShopID=");
    null.append(VC());
    hZ(null.toString());
    null = VM();
    if (null.moveToNext()) {
      null.close();
      return;
    } 
    null = new StringBuilder();
    null.append(VC());
    null.append("91001");
    String str = null.toString();
    am("_id", str);
    am("sFieldName", this.mContext.getString(R.string.pos_product_hot_product_type));
    am("nFieldType", "91");
    am("nStringID", "1");
    am("sDefaultValue", "2");
    if (QL() && bd.bH(this.mContext))
      (new ar.a(this.mContext, str, true)).start(); 
  }
  
  @Deprecated
  private ArrayList<HashMap<String, String>> c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    ArrayList arrayList = new ArrayList();
    Vk();
    hY("_id,sFieldName,nSpareField1,sSpareField2,nSpareField4,sFieldValue,nFieldType");
    ia(" sDefaultValue desc ");
    if (paramBoolean1) {
      if (paramBoolean3) {
        str1 = " nFieldType in (5,91,92) ";
      } else {
        str1 = " nFieldType=5";
      } 
    } else {
      String str1;
      str1 = " length(nFieldType)=13";
    } 
    null = new StringBuilder();
    null.append(str1);
    null.append(" and sIsActive='Y' and nShopID=");
    null.append(VC());
    String str = null.toString();
    str1 = str;
    if (!paramBoolean2) {
      String str1;
      null = new StringBuilder();
      null.append(str);
      null.append(" and _id!=");
      null.append(VE());
      str1 = null.toString();
    } 
    hZ(str1);
    Cursor cursor = VM();
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      hashMap.put("id", cursor.getString(0));
      hashMap.put("name", cursor.getString(1));
      hashMap.put("name2", cursor.getString(3));
      hashMap.put("isQty", cursor.getString(2));
      if (!paramBoolean1) {
        hashMap.put("notFirst", "true");
      } else {
        hashMap.put("isUpper", cursor.getString(4));
        hashMap.put("productIds", cursor.getString(5));
        hashMap.put("type", cursor.getString(6));
        if (String.valueOf(91L).equals(cursor.getString(6)))
          hashMap.put("hotSaleType", cursor.getString(2)); 
      } 
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
  
  private boolean h(String paramString, long paramLong) {
    if (paramString == null)
      return false; 
    i(paramString, paramLong);
    Cursor cursor = VM();
    if (cursor == null)
      return true; 
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
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
  
  public boolean O(long paramLong) {
    String str;
    bF(paramLong);
    am(this.bSR, this.bSU);
    boolean bool = delete();
    if (bool) {
      str = String.format(this.mContext.getString(R.string.prodcut_type_delete_success), new Object[] { hQ("sFieldName") });
    } else {
      str = this.mContext.getString(R.string.prodcut_type_delete_fail);
    } 
    hP(str);
    return bool;
  }
  
  protected boolean QL() {
    boolean bool;
    if (UA()) {
      bool = Wc();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(R.string.type_ui_titlebar));
      stringBuilder.append(" ");
      stringBuilder.append(VZ());
      stringBuilder.append(" ");
      stringBuilder.append(this.mContext.getString(R.string.ud_createMsg2));
      hP(stringBuilder.toString());
    } else {
      bool = false;
    } 
    UD();
    return bool;
  }
  
  protected boolean UA() {
    if (hM(Wa())) {
      hP(this.mContext.getString(R.string.pos_product_exit));
      return false;
    } 
    return true;
  }
  
  protected boolean UB() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  public ArrayList<Long> Vi() {
    ArrayList arrayList = new ArrayList();
    hY("_id");
    c("nShopID=? and sSpareField1='N'", new String[] { VC() });
    Cursor cursor = VM();
    if (cursor != null) {
      while (cursor.moveToNext())
        arrayList.add(Long.valueOf(cursor.getLong(0))); 
      cursor.close();
    } 
    return arrayList;
  }
  
  @Deprecated
  public ArrayList<HashMap<String, String>> Vj() { return c(false, false, false); }
  
  public ArrayList<ProductTypeEntity> a(boolean paramBoolean, Boolean paramBoolean1) { return a(paramBoolean, paramBoolean1, null); }
  
  public ArrayList<ProductTypeEntity> a(boolean paramBoolean, Boolean paramBoolean1, List<ProductTypeEntity> paramList) {
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
    if (LQKVersion.zl()) {
      ProductTypeEntity productTypeEntity = new ProductTypeEntity(500000L, this.mContext.getResources().getString(R.string.pos_no_type), "", true);
      arrayList.add(productTypeEntity);
      if (paramList != null) {
        Iterator iterator = paramList.iterator();
        while (iterator.hasNext()) {
          if (500000L == ((ProductTypeEntity)iterator.next()).aSW) {
            productTypeEntity.cVg = true;
            break;
          } 
        } 
      } else {
        productTypeEntity.cVg = true;
      } 
    } 
    while (cursor.moveToNext()) {
      long l = cursor.getLong(0);
      String str = cursor.getString(1);
      ProductTypeEntity productTypeEntity = new StringBuilder();
      productTypeEntity.append(l);
      productTypeEntity.append("");
      if (str2.equals(productTypeEntity.toString())) {
        if (paramBoolean1 == null) {
          String str3;
          g g = new g(this.mContext);
          int i = RootApplication.getLaiqianPreferenceManager().avL();
          if (i == 1 || i == 2) {
            av av = new av(this.mContext);
            str3 = av.Bh();
            av.close();
          } else {
            str3 = a.AZ().Bh();
          } 
          if (g.B(l, str3).isEmpty())
            continue; 
          g.close();
        } else if (!paramBoolean1.booleanValue()) {
          continue;
        } 
        ProductTypeEntity productTypeEntity1 = new ProductTypeEntity(l, str);
      } else {
        boolean bool;
        null = cursor.getString(5);
        if (cursor.getInt(2) == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        productTypeEntity = new ProductTypeEntity(l, str, null, bool);
      } 
      productTypeEntity.cVc = cursor.getInt(3);
      productTypeEntity.cgE = paramBoolean;
      productTypeEntity.cVd = "N".equals(cursor.getString(4)) ^ true;
      if (paramList != null) {
        Iterator iterator = paramList.iterator();
        while (iterator.hasNext()) {
          if (l == ((ProductTypeEntity)iterator.next()).aSW) {
            productTypeEntity.cVg = true;
            break;
          } 
        } 
      } else {
        productTypeEntity.cVg = true;
      } 
      arrayList.add(productTypeEntity);
    } 
    cursor.close();
    return arrayList;
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, int paramInt) {
    beginTransaction();
    am("sFieldName", paramString1);
    am("nSpareField1", paramString3);
    am("sSpareField2", paramString2);
    if (paramString4 != null && n.parseLong(paramString4) == 92L) {
      am("nSpareField4", paramString5);
    } else if (paramString4 != null && n.parseLong(paramString4) == 91L) {
      am("nSpareField4", paramString5);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      am("nSpareField1", stringBuilder.toString());
    } else {
      am("nSpareField4", paramString5);
    } 
    boolean bool = bl(paramLong);
    if (bool && paramBoolean) {
      g g = new g(this.mContext);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      paramBoolean = g.w(stringBuilder.toString(), "1".equals(paramString3));
      if (!paramBoolean)
        l(g.Vn(), false); 
      g.close();
    } else {
      paramBoolean = bool;
    } 
    if (paramBoolean)
      setTransactionSuccessful(); 
    endTransaction();
    return paramBoolean;
  }
  
  public boolean bl(long paramLong) {
    String str;
    if (paramLong != 500000L) {
      str = VC();
    } else {
      str = null;
    } 
    q(paramLong, str);
    boolean bool2 = UB();
    boolean bool1 = false;
    if (bool2) {
      String str1;
      if (h(Wa(), paramLong)) {
        hP(this.mContext.getString(R.string.pos_product_exit));
        return false;
      } 
      q(paramLong, str);
      bool1 = update();
      if (bool1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(R.string.type_ui_titlebar));
        stringBuilder.append(" ");
        stringBuilder.append(VZ());
        stringBuilder.append(" ");
        stringBuilder.append(this.mContext.getString(R.string.ud_updateMsg2));
        str1 = stringBuilder.toString();
      } else {
        null = new StringBuilder();
        null.append(this.mContext.getString(R.string.type_ui_titlebar));
        null.append(" ");
        null.append(VZ());
        null.append(" ");
        null.append(this.mContext.getString(R.string.ud_updateMsg3));
        str1 = null.toString();
      } 
      hP(str1);
    } 
    UE();
    return bool1;
  }
  
  public Cursor bs(long paramLong) {
    String str1 = Wb();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    c(str1, new String[] { str2, stringBuilder2.toString() });
    return VM();
  }
  
  public String bt(long paramLong) {
    Cursor cursor = bs(paramLong);
    String str = "";
    if (cursor.moveToFirst())
      str = cursor.getString(cursor.getColumnIndex("sFieldName")); 
    cursor.close();
    return str;
  }
  
  public boolean d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    null = new StringBuilder();
    null.append(System.currentTimeMillis());
    null.append("");
    String str = null.toString();
    am("_id", str);
    am("sFieldName", paramString1);
    if (paramString4 != null && n.parseLong(paramString4) == 92L) {
      am("nSpareField4", paramString5);
      am("nFieldType", "92");
      am("sDefaultValue", "1");
    } else if (paramString4 != null && n.parseLong(paramString4) == 91L) {
      am("nSpareField4", paramString5);
      am("nFieldType", "91");
    } else {
      am("nFieldType", "5");
      am("sFieldValue", str);
    } 
    am("nStringID", "1");
    am("nSpareField1", paramString3);
    am("sSpareField2", paramString2);
    boolean bool = QL();
    if (bool && bd.bH(this.mContext))
      (new ar.a(this.mContext, str, true)).start(); 
    return bool;
  }
  
  @Deprecated
  public ArrayList<HashMap<String, String>> p(boolean paramBoolean1, boolean paramBoolean2) { return c(true, paramBoolean1, paramBoolean2); }
  
  public boolean p(long paramLong, String paramString) {
    am("sFieldValue", paramString);
    return bl(paramLong);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */