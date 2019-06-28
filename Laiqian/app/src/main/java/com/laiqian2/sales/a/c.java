package com.laiqian.sales.a;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.models.x;
import com.laiqian.util.av;

public class c extends x {
  public c(Context paramContext) throws Exception { super(paramContext); }
  
  public int aS(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select count(distinct T_PRODUCTDOC.sOrderNo) from T_PRODUCTDOC LEFT JOIN T_BPARTNER ON T_PRODUCTDOC.nBPartnerID = T_BPARTNER._id where  nProductTransacType = ");
    stringBuilder.append(paramString2);
    stringBuilder.append(" and T_PRODUCTDOC.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and ([T_PRODUCTDOC].[nDeletionFlag] is null or [T_PRODUCTDOC].[nDeletionFlag]<>1)  and not (trim(T_PRODUCTDOC.sOrderNo)='' or T_PRODUCTDOC.sOrderNo is null) and (T_BPARTNER.sName like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%'  or T_PRODUCTDOC.sOrderNo like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%'  or T_PRODUCTDOC.sProductName like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%')  order by T_PRODUCTDOC.nDateTime desc ");
    paramString1 = stringBuilder.toString();
    try {
      Cursor cursor = Vq().rawQuery(paramString1, null);
    } catch (Exception paramString1) {
      a.e(paramString1);
      paramString1 = null;
    } 
    boolean bool = paramString1.moveToFirst();
    int i = 0;
    if (bool)
      i = paramString1.getInt(0); 
    paramString1.close();
    return i;
  }
  
  public String aT(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select T_PRODUCTDOC._id as _id,T_BPARTNER.sName as sBPartnerName, date([T_PRODUCTDOC].[nDateTime]/1000,'unixepoch','localtime') as sDateTime,  sum([T_PRODUCTDOC].[fAmount]) as fAmount, [T_PRODUCTDOC].[sOrderNo] as sOrderNo from T_PRODUCTDOC LEFT JOIN T_BPARTNER ON T_PRODUCTDOC.nBPartnerID = T_BPARTNER._id  where  nProductTransacType = ");
    stringBuilder.append(paramString2);
    stringBuilder.append(" and T_PRODUCTDOC.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and ([T_PRODUCTDOC].[nDeletionFlag] is null or [T_PRODUCTDOC].[nDeletionFlag]<>1)  and not (trim(T_PRODUCTDOC.sOrderNo)='' or T_PRODUCTDOC.sOrderNo is null) and (T_BPARTNER.sName like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%'  or T_PRODUCTDOC.sOrderNo like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%'  or T_PRODUCTDOC.sProductName like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%')  group by sOrderNo  order by T_PRODUCTDOC.nDateTime desc ");
    return stringBuilder.toString();
  }
  
  public Cursor aU(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select T_PRODUCTDOC._id as _id,T_BPARTNER.sName as sBPartnerName, date([T_PRODUCTDOC].[nDateTime]/1000,'unixepoch','localtime') as sDateTime,  sum([T_PRODUCTDOC].[fAmount]) as fAmount, [T_PRODUCTDOC].[sOrderNo] as sOrderNo from T_PRODUCTDOC LEFT JOIN T_BPARTNER ON T_PRODUCTDOC.nBPartnerID = T_BPARTNER._id where  nProductTransacType = ");
    stringBuilder.append(paramString2);
    stringBuilder.append(" and T_PRODUCTDOC.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and ([T_PRODUCTDOC].[nDeletionFlag] is null or [T_PRODUCTDOC].[nDeletionFlag]<>1)  and not (trim(T_PRODUCTDOC.sOrderNo)='' or T_PRODUCTDOC.sOrderNo is null) and (T_BPARTNER.sName like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%'  or T_PRODUCTDOC.sOrderNo like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%'  or T_PRODUCTDOC.sProductName like '%");
    stringBuilder.append(paramString1);
    stringBuilder.append("%')  group by sOrderNo  order by T_PRODUCTDOC.nDateTime desc limit 1 ");
    paramString1 = stringBuilder.toString();
    try {
      Cursor cursor = Vq().rawQuery(paramString1, null);
    } catch (Exception paramString1) {
      a.e(paramString1);
      paramString1 = null;
    } 
    paramString1.getCount();
    return paramString1;
  }
  
  public String nD(String paramString) {
    new av(this.mContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select _id,sProductName,round(nProductQty,");
    stringBuilder.append(RootApplication.aIQ);
    stringBuilder.append(") as nProductQty,round(fPrice,");
    stringBuilder.append(RootApplication.aIQ);
    stringBuilder.append(") as fPrice,round(fAmount, ");
    stringBuilder.append(RootApplication.aIQ);
    stringBuilder.append(") as fAmount from T_PRODUCTDOC where  T_PRODUCTDOC.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and nProductTransacType=? and sProductName like ?  and sOrderNo = ? and ([T_PRODUCTDOC].[nDeletionFlag] is null or [T_PRODUCTDOC].[nDeletionFlag]<>1) order by T_PRODUCTDOC.nDateTime desc ");
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sales\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */