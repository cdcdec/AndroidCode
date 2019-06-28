package com.laiqian.member.model;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.models.at;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;

public class a extends at {
  Context context;
  
  public a(Context paramContext) {
    super(paramContext);
    this.context = paramContext;
  }
  
  public boolean M(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType=88 and fSpareField1 = ");
    stringBuilder.append(paramString1);
    stringBuilder.append("  and nShopID = ");
    stringBuilder.append(VC());
    stringBuilder.append(" and sIsActive ='Y' and _id!='");
    stringBuilder.append(paramString2);
    stringBuilder.append("'");
    hZ(stringBuilder.toString());
    Cursor cursor = VM();
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public boolean QM() { return aY(0, 100).moveToNext(); }
  
  public Cursor aY(int paramInt1, int paramInt2) {
    hY(" sFieldName,fSpareField1,fSpareField2,_id,fSpareField3 ");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType=88 and nShopID = ");
    stringBuilder.append(VC());
    stringBuilder.append(" and sIsActive ='Y' ");
    hZ(stringBuilder.toString());
    ia(" fSpareField1 asc");
    stringBuilder = new StringBuilder();
    stringBuilder.append(" ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" offset ");
    stringBuilder.append(paramInt1 * paramInt2);
    ib(stringBuilder.toString());
    return VM();
  }
  
  public Cursor ai(double paramDouble) {
    hY(" sFieldName,fSpareField1,fSpareField2,_id,fSpareField3 ");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType=88 and nShopID = ");
    stringBuilder.append(VC());
    stringBuilder.append(" and sIsActive ='Y' and fSpareField1 <= ");
    stringBuilder.append(paramDouble);
    hZ(stringBuilder.toString());
    ia(" fSpareField1 asc");
    return VM();
  }
  
  public boolean c(String paramString1, String paramString2, String paramString3, String paramString4) {
    boolean bool;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("updateMemberRechargeTemplate id=");
    stringBuilder3.append(paramString1);
    d.b(stringBuilder3.toString(), new Object[0]);
    if (!paramString2.equals(paramString4)) {
      bool = M(paramString2, paramString1);
    } else {
      bool = false;
    } 
    if (bool)
      return bool; 
    paramString4 = String.format(this.context.getResources().getString(R.string.recharge_template), new Object[] { paramString2, paramString3 });
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("");
    stringBuilder3.append(paramString4);
    am("sFieldName", stringBuilder3.toString());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString2);
    stringBuilder2.append("");
    am("fSpareField1", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString3);
    stringBuilder2.append("");
    am("fSpareField2", stringBuilder2.toString());
    am("sIsActive", "Y");
    double d = n.u(paramString2);
    d = n.u(paramString3) / d;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(d);
    stringBuilder1.append("");
    am("fSpareField3", stringBuilder1.toString());
    d(" nFieldType=88 and nShopID =?  and sIsActive ='Y' and _id=?", new String[] { VC(), paramString1 });
    update();
    return false;
  }
  
  public void fJ(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("deleteMemberRechargeTemplate id=");
    stringBuilder.append(paramString);
    d.b(stringBuilder.toString(), new Object[0]);
    am("sIsActive", "N");
    d(" nFieldType=88 and sIsActive ='Y' and nShopID =?  and _id=?", new String[] { VC(), paramString });
    update();
  }
  
  public boolean p(String paramString1, String paramString2, String paramString3) {
    boolean bool = M(paramString1, paramString3);
    if (!bool) {
      am("_id", paramString3);
      am("nFieldType", "88");
      paramString3 = String.format(this.context.getResources().getString(R.string.recharge_template), new Object[] { paramString1, paramString2 });
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("");
      stringBuilder3.append(paramString3);
      am("sFieldName", stringBuilder3.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString1);
      stringBuilder2.append("");
      am("fSpareField1", stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString2);
      stringBuilder2.append("");
      am("fSpareField2", stringBuilder2.toString());
      double d = n.u(paramString1);
      d = n.u(paramString2) / d;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d);
      stringBuilder1.append("");
      am("fSpareField3", stringBuilder1.toString());
      am("nShopID", VC());
      am("nUserID", getUserID());
      am("nUpdateFlag", "0");
      am("nIsUpdated", "0");
      am("sIsActive", "Y");
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(System.currentTimeMillis());
      stringBuilder1.append("");
      am("nOperationTime", stringBuilder1.toString());
      am("sPlatform", "android");
      QL();
    } 
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */