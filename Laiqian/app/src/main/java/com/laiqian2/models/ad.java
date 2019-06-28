package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.ae;
import com.laiqian.entity.ag;
import com.laiqian.entity.al;
import com.laiqian.infrastructure.R;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class ad extends ao {
  public ad(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public boolean bA(long paramLong) {
    am("sIsActive", "Y");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("nPromotionID=? and nShopID=? and nDeletionFlag<>1", new String[] { stringBuilder.toString(), VC() });
    return super.update();
  }
  
  public ArrayList<ProductTypeEntity> bu(long paramLong) {
    hY("nProductID");
    null = new StringBuilder();
    null.append(paramLong);
    null.append("");
    c(" nPromotionID=? and nShopID=? and nItemType=1 and nDeletionFlag<>1", new String[] { null.toString(), VC() });
    Cursor cursor = VM();
    ArrayList arrayList = new ArrayList();
    if (cursor != null) {
      for (byte b = 0; cursor.moveToNext() && (b || cursor.getLong(0) != -1L); b++)
        arrayList.add(new ProductTypeEntity(cursor.getLong(0), "", "", true)); 
      cursor.close();
      return arrayList;
    } 
    return new ArrayList();
  }
  
  public ag bv(long paramLong) {
    hY("nProductID,fDiscountPrice,fDiscount,nProductDiscountType");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    c(" nPromotionID=? and nShopID=? and nItemType=2 and nDeletionFlag<>1", new String[] { stringBuilder.toString(), VC() });
    Cursor cursor = VM();
    if (cursor != null) {
      String str;
      double d3;
      long[] arrayOfLong = new long[cursor.getCount()];
      double d1 = 0.0D;
      double d2 = 0.0D;
      byte b = 0;
      int i = 0;
      while (true) {
        if (cursor.moveToNext()) {
          double d = d1;
          int j = i;
          if (!b) {
            d1 = cursor.getDouble(1);
            double d4 = cursor.getDouble(2);
            i = cursor.getInt(3);
            d = d4;
            j = i;
            d2 = d1;
            if (cursor.getLong(0) == -1L) {
              arrayOfLong = new long[0];
              b = 1;
              d2 = d1;
              break;
            } 
          } 
          arrayOfLong[b] = cursor.getLong(0);
          b++;
          d1 = d;
          i = j;
          continue;
        } 
        b = 0;
        d3 = d1;
        break;
      } 
      cursor.close();
      if (b != 0) {
        str = this.mContext.getString(R.string.pos_people_type_not_limit);
      } else {
        str = String.format(this.mContext.getString(R.string.pos_promotion_selected_n_product), new Object[] { Integer.valueOf(arrayOfLong.length) });
      } 
      return (new ag.a()).S(d3).eC(i).T(d2).dq(str).d(arrayOfLong).HE();
    } 
    return null;
  }
  
  public ae bw(long paramLong) {
    hY("nProductID,fProductGiftQty,fProductBuyQty,nProductUseType");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    c(" nPromotionID=? and nShopID=? and nItemType=2 and nDeletionFlag<>1", new String[] { stringBuilder.toString(), VC() });
    Cursor cursor = VM();
    if (cursor != null) {
      String str;
      long[] arrayOfLong = new long[cursor.getCount()];
      double d1 = 0.0D;
      double d2 = d1;
      byte b = 0;
      int i = 0;
      while (true) {
        if (cursor.moveToNext()) {
          cursor.getDouble(1);
          d1 = cursor.getDouble(1);
          d2 = cursor.getDouble(2);
          i = cursor.getInt(3);
          if (!b && cursor.getLong(0) == -1L) {
            arrayOfLong = new long[0];
            b = 1;
            break;
          } 
          arrayOfLong[b] = cursor.getLong(0);
          b++;
          continue;
        } 
        b = 0;
        break;
      } 
      cursor.close();
      if (b != 0) {
        str = this.mContext.getString(R.string.pos_people_type_not_limit);
      } else {
        str = String.format(this.mContext.getString(R.string.pos_promotion_selected_n_product), new Object[] { Integer.valueOf(arrayOfLong.length) });
      } 
      return (arrayOfLong.length == 0) ? null : (new ae.a()).b(arrayOfLong).eA(i).P(d1).do(str).O(d2).Hx();
    } 
    return null;
  }
  
  public ArrayList<al> bx(long paramLong) {
    hY("pp.nProductID,pp.fProductGiftQty,p.sProductName,p.sSpareField5,P.nStockQty,P.fSalePrice");
    null = new StringBuilder();
    null.append(paramLong);
    null.append("");
    c(" pp.nPromotionID=? and pp.nShopID=? and pp.nItemType=2 and pp.nDeletionFlag<>1", new String[] { null.toString(), VC() });
    hX("t_promotion_product as pp left join t_product as p on p._id=pp.nProductID and( p.nProductStatus=600001 or p.nProductStatus=600002)  ");
    Cursor cursor = VM();
    if (cursor != null) {
      ArrayList arrayList = new ArrayList();
      while (cursor.moveToNext()) {
        double d = cursor.getDouble(1);
        h h = (new h.a(cursor.getLong(0), cursor.getString(2), cursor.getString(3))).aQ(cursor.getDouble(5)).aR(cursor.getDouble(4)).akQ();
        arrayList.add((new al.a()).U(d).a(h).Ih());
      } 
      cursor.close();
      return arrayList;
    } 
    return null;
  }
  
  public boolean by(long paramLong) {
    am("nDeletionFlag", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("nPromotionID=? and nShopID=? and nDeletionFlag<>1", new String[] { stringBuilder.toString(), VC() });
    return super.update();
  }
  
  public boolean bz(long paramLong) {
    am("sIsActive", "N");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("nPromotionID=? and nShopID=? and nDeletionFlag<>1", new String[] { stringBuilder.toString(), VC() });
    return super.update();
  }
  
  public boolean c(List<Long> paramList, String paramString) {
    try {
      beginTransaction();
      for (Long long : paramList) {
        am("nDeletionFlag", "1");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append("");
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(long);
        stringBuilder2.append("");
        d("nPromotionID=? and nProductID =? and nShopID=?", new String[] { str, stringBuilder2.toString(), VC() });
        super.update();
      } 
      setTransactionSuccessful();
      endTransaction();
      return true;
    } catch (Exception paramList) {
      a.e(paramList);
      endTransaction();
      return false;
    } finally {}
    endTransaction();
    throw paramList;
  }
  
  public boolean f(ArrayList<ProductTypeEntity> paramArrayList, String paramString) {
    try {
      beginTransaction();
      for (ProductTypeEntity productTypeEntity : paramArrayList) {
        am("nDeletionFlag", "1");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append("");
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(productTypeEntity.AR());
        stringBuilder2.append("");
        d("nPromotionID=? and nProductID =? and nShopID=?", new String[] { str, stringBuilder2.toString(), VC() });
        super.update();
      } 
      setTransactionSuccessful();
      endTransaction();
      return true;
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      endTransaction();
      return false;
    } finally {}
    endTransaction();
    throw paramArrayList;
  }
  
  public boolean hN(String paramString) {
    am("nDeletionFlag", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    d("nPromotionID=? and nProductID =? and nShopID=?", new String[] { stringBuilder.toString(), "-1", VC() });
    return super.update();
  }
  
  protected void init() {
    hX("t_promotion_product");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nShopID,nStartTime,nPromotionID,nProductID,nProductUseTypefProductGiftQtyfProductBuyQtyfProductPromotionTotalQtyfDiscountPricefDiscountnProductDiscountTypenUserIDsTextnItemTypesIsActivenDeletionFlagnUpdateFlagnIsUpdatednOperationTime,sPlatform,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected boolean update() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    am("nOperationTime", stringBuilder.toString());
    return super.update();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */