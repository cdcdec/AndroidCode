package com.laiqian.sales;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.db.d;

public class h extends d {
  public h(Context paramContext) { super(paramContext); }
  
  public boolean a(long paramLong, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("update [T_PRODUCTDOC] set [nIsUpdated]=0,[sBPartnerContact]='");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("',[sBPartnerMobile]='");
    stringBuilder2.append(paramString2);
    stringBuilder2.append("',[sText]='");
    stringBuilder2.append(paramString3);
    stringBuilder2.append("'");
    paramString1 = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString1);
    stringBuilder1.append(",nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end where [_id]=");
    stringBuilder1.append(paramLong);
    stringBuilder1.append("  and [T_PRODUCTDOC].[nShopID]=");
    stringBuilder1.append(this.bKd);
    stringBuilder1.append(" ");
    paramString1 = stringBuilder1.toString();
    this.bJQ.execSQL(paramString1);
    return true;
  }
  
  public double aH(long paramLong) {
    double d1;
    null = new StringBuilder();
    null.append("select _id, nStockQty from T_PRODUCT where [_id]=");
    null.append(paramLong);
    null.append(" and nShopID=");
    null.append(this.bKd);
    null.append(" ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d1 = cursor.getDouble(cursor.getColumnIndex("nStockQty"));
    } else {
      d1 = 0.0D;
    } 
    cursor.close();
    return d1;
  }
  
  public double aI(long paramLong) {
    double d1;
    null = new StringBuilder();
    null.append("select * from T_PRODUCT where [_id]=");
    null.append(paramLong);
    null.append(" and nShopID=");
    null.append(this.bKd);
    null.append(" ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d1 = cursor.getDouble(cursor.getColumnIndex("fStockPrice"));
    } else {
      d1 = -1.0D;
    } 
    cursor.close();
    return d1;
  }
  
  public Cursor aJ(long paramLong) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("SELECT *,[T_PRODUCTDOC].[fAmount] as fDocAmount,round(nProductQty,");
    stringBuilder1.append(this.bKf);
    stringBuilder1.append(") as nProductQty,round(fPrice,");
    stringBuilder1.append(this.bKf);
    stringBuilder1.append(") as fPrice,round(fAmount ");
    stringBuilder1.append(this.bKf);
    stringBuilder1.append(") as fAmount, date([T_PRODUCTDOC].[nDateTime]/1000,'unixepoch','localtime') as sDateTime,[T_STRING].[sFieldName] as sTransacType,[T_PRODUCTDOC].[_id] as nDocID,[T_PRODUCTDOC].[sText] as sDocText,[T_WAREHOUSE].[sName] as sWarehouseName ,[T_BPARTNER].[sName] as sBPartner  FROM [T_PRODUCTDOC] INNER JOIN [T_STRING] ON [T_PRODUCTDOC].[nProductTransacType] = [T_STRING].[_id]  and [T_STRING].[sText] like '");
    stringBuilder1.append(this.bJA);
    stringBuilder1.append("' LEFT JOIN [T_BPARTNER] ON [T_PRODUCTDOC].[nbPartnerID] = [T_BPARTNER].[_id] LEFT JOIN [T_WAREHOUSE] ON [T_PRODUCTDOC].[nWarehouseID] = [T_WAREHOUSE].[_id]");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("where [T_PRODUCTDOC].[_id]=");
    stringBuilder2.append(paramLong);
    stringBuilder2.append("  and [T_PRODUCTDOC].[nShopID]=");
    stringBuilder2.append(this.bKd);
    stringBuilder2.append(" ");
    str = stringBuilder2.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Cursor aX(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from T_BPARTNER where [_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" and bIsActive =  'Y' ");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Cursor aZ(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from T_WAREHOUSE where [_id]=");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" and sIsActive =  'Y' ");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery(str, null);
  }
  
  public Cursor gJ(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT [T_PRODUCT].[_id], [T_PRODUCT].[nShopID], [T_PRODUCT].[sProductName],[T_PRODUCT].[sProductDescription], [T_PRODUCT].[nProductType],[T_PRODUCT].[nProductStatus], [T_PRODUCT].[fShowPrice],round([T_PRODUCT].[fBuyPrice], ");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as fBuyPrice,round([T_PRODUCT].[fStockPrice], ");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as fStockPrice,round([T_PRODUCT].[fSalePrice],");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as fSalePrice,[T_PRODUCT].[sBarcode], [T_PRODUCT].[sImage], [T_PRODUCT].[nProductUnit],round([T_PRODUCT].[nStockQty], ");
    stringBuilder.append(this.bKf);
    stringBuilder.append(") as nStockQty,[T_PRODUCT].[nCurrency], [T_PRODUCT].[nUserID],[T_PRODUCT].[sText], [T_PRODUCT].[nUpdateFlag], [T_PRODUCT].[nIsUpdated]from T_PRODUCT where [_id]=");
    stringBuilder.append(paramString);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(this.bKd);
    stringBuilder.append(" ;");
    paramString = stringBuilder.toString();
    return this.bJQ.rawQuery(paramString, null);
  }
  
  public String iB(String paramString) {
    String str = "";
    null = new StringBuilder();
    null.append(paramString);
    null.append("");
    paramString = null.toString();
    Cursor cursor = this.bJQ.rawQuery("select sUserName from T_USER where _id=?", new String[] { paramString });
    paramString = str;
    if (cursor.moveToFirst())
      paramString = cursor.getString(0); 
    cursor.close();
    return paramString;
  }
  
  public String kn(String paramString) {
    String str = "";
    null = new StringBuilder();
    null.append(paramString);
    null.append("");
    paramString = null.toString();
    Cursor cursor = this.bJQ.rawQuery("select sShopName from T_SHOP where _id=?", new String[] { paramString });
    paramString = str;
    if (cursor.moveToFirst())
      paramString = cursor.getString(0); 
    cursor.close();
    return paramString;
  }
  
  public boolean nB(String paramString) {
    if (!paramString.equals("")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bKd);
      stringBuilder.append("");
      String str = stringBuilder.toString();
      Cursor cursor = this.bJQ.rawQuery("select * from T_PRODUCTDOC where nShopID =? and sOrderNo=? and ([T_PRODUCTDOC].[nDeletionFlag] is null or [T_PRODUCTDOC].[nDeletionFlag]<>1);", new String[] { str, paramString });
      if (cursor.getCount() > 0) {
        cursor.close();
        return true;
      } 
      cursor.close();
      return false;
    } 
    return false;
  }
  
  public boolean nC(String paramString) {
    if (!paramString.equals("")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bKd);
      stringBuilder.append("");
      String str = stringBuilder.toString();
      Cursor cursor = this.bJQ.rawQuery("select * from T_PRODUCTDOC where nShopID =? and sRefNo=? and ([T_PRODUCTDOC].[nDeletionFlag] is null or [T_PRODUCTDOC].[nDeletionFlag]<>1);", new String[] { str, paramString });
      if (cursor.getCount() > 0) {
        cursor.close();
        return true;
      } 
    } 
    return false;
  }
  
  public double o(long paramLong1, long paramLong2) {
    double d1;
    null = new StringBuilder();
    null.append("select _id, nQuantity from T_STOCK where nProductID='");
    null.append(paramLong1);
    null.append("' and nWarehouseID = '");
    null.append(paramLong2);
    null.append("' and nShopID='");
    null.append(this.bKd);
    null.append("' ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d1 = cursor.getDouble(cursor.getColumnIndex("nQuantity"));
    } else {
      d1 = aH(paramLong1);
    } 
    cursor.close();
    return d1;
  }
  
  public double p(long paramLong1, long paramLong2) {
    double d1;
    null = new StringBuilder();
    null.append("select * from T_STOCK where nProductID=");
    null.append(paramLong1);
    null.append(" and nWarehouseID = ");
    null.append(paramLong2);
    null.append(" and nShopID=");
    null.append(this.bKd);
    null.append(" ");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      d1 = cursor.getDouble(cursor.getColumnIndex("fStockPrice"));
    } else {
      d1 = aI(paramLong1);
    } 
    cursor.close();
    return d1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sales\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */