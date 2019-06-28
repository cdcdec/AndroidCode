package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONException;

public class bh extends ao {
  public static final Collection<ao.b> bNO;
  
  public static final ao.b<Long> bNX;
  
  public static final ao.b<Long> bNY;
  
  public static final ao.b<String> bNp;
  
  public static final ao.b<Long> bNr;
  
  public static final ao.b<Long> bNs;
  
  public static final ao.b<Long> bNu;
  
  public static final ao.b<Long> bNv;
  
  public static final ao.b<Long> bNw;
  
  public static final ao.b<String> bNx = (bNw = (bNv = (bUg = (bUf = (bUe = (bUd = (bOc = (bNu = (bNs = (bNr = (bNp = (bUc = (bUb = (bUa = (bTZ = (bTY = (bTX = (bTW = (bNY = (bTV = (bTU = (bTT = (bNX = ao.b.ig("_id")).ie("sUserName")).ie("sUserPhone")).ie("sUserPassword")).ig("nShopID")).ig("nUserRole")).if("fUserAmount")).ie("sUserMacAddress")).ig("nUserStatus")).ig("nChannelID")).ie("sChannelName")).ig("nAuth")).ie("sText")).ig("nDateTime")).ig("nDeletionFlag")).ig("nUpdateFlag")).ig("nUserID")).ie("sMail")).ig("tempUserRole")).ig("nChargeTemplate")).ie("sIsWebOpen")).ig("nIsUpdated")).ig("nOperationTime")).ie("sPlatform");
  
  public static final ao.b<Long> bOc;
  
  public static final ao.b<String> bTT;
  
  public static final ao.b<String> bTU;
  
  public static final ao.b<String> bTV;
  
  public static final ao.b<Long> bTW;
  
  public static final ao.b<Double> bTX;
  
  public static final ao.b<String> bTY;
  
  public static final ao.b<Long> bTZ;
  
  public static final ao.b<Long> bUa;
  
  public static final ao.b<String> bUb;
  
  public static final ao.b<Long> bUc;
  
  public static final ao.b<String> bUd;
  
  public static final ao.b<Long> bUe;
  
  public static final ao.b<Long> bUf;
  
  public static final ao.b<String> bUg;
  
  static  {
    ArrayList arrayList = new ArrayList();
    arrayList.add(bNX);
    arrayList.add(bTT);
    arrayList.add(bTU);
    arrayList.add(bTV);
    arrayList.add(bNY);
    arrayList.add(bTW);
    arrayList.add(bTX);
    arrayList.add(bTY);
    arrayList.add(bTZ);
    arrayList.add(bUa);
    arrayList.add(bUb);
    arrayList.add(bUc);
    arrayList.add(bNp);
    arrayList.add(bNr);
    arrayList.add(bNs);
    arrayList.add(bNu);
    arrayList.add(bOc);
    arrayList.add(bUd);
    arrayList.add(bUe);
    arrayList.add(bUf);
    arrayList.add(bUg);
    arrayList.add(bNv);
    arrayList.add(bNw);
    arrayList.add(bNx);
    bNO = Collections.unmodifiableCollection(arrayList);
  }
  
  public bh() throws Exception { this(null); }
  
  public bh(Context paramContext) { super(paramContext); }
  
  public Cursor B(String paramString1, String paramString2, String paramString3) { return Vq().rawQuery("SELECT * FROM T_USER WHERE sUserPhone = ? and (sUserPassword = ? or sUserPassword = ?)", new String[] { paramString1, paramString2, paramString3 }); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public String WB() {
    c("nShopID = ? and nUserRole = ?", new String[] { VC(), "150001" });
    Cursor cursor = VM();
    cursor.moveToFirst();
    String str = cursor.getString(cursor.getColumnIndex(bTV.getName()));
    cursor.close();
    return str;
  }
  
  public long WC() {
    c("nShopID=? and _id= ? ", new String[] { VC(), getUserID() });
    Cursor cursor = VM();
    long l1 = ah.bRW;
    long l2 = l1;
    if (cursor != null) {
      if (cursor.moveToFirst())
        l1 = cursor.getLong(cursor.getColumnIndex("nUserRole")); 
      cursor.close();
      l2 = l1;
    } 
    return l2;
  }
  
  public String WD() { return iE(getUserID()); }
  
  public String WE() {
    String str;
    hY("sUserPhone");
    c("nShopID=? and nUserRole= 150001 ", new String[] { VC() });
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      str = cursor.getString(0);
    } else {
      str = null;
    } 
    cursor.close();
    return str;
  }
  
  public boolean ap(String paramString1, String paramString2) {
    d(" sUserPhone = ? ", new String[] { paramString1 });
    am("sUserPhone", paramString2);
    am("nDeletionFlag", "170003");
    return update();
  }
  
  public Cursor iA(String paramString) {
    c("nShopID=? and _id= ? ", new String[] { VC(), paramString });
    return VM();
  }
  
  public String iB(String paramString) {
    c("nShopID=? and _id= ? ", new String[] { VC(), paramString });
    Cursor cursor = VM();
    paramString = "";
    if (cursor.moveToFirst())
      paramString = cursor.getString(cursor.getColumnIndex("sUserName")); 
    cursor.close();
    return paramString;
  }
  
  public String iC(String paramString) {
    c("nShopID=? and sUserPhone= ? ", new String[] { VC(), paramString });
    Cursor cursor = VM();
    paramString = "";
    if (cursor.moveToFirst())
      paramString = cursor.getString(cursor.getColumnIndex("sUserName")); 
    cursor.close();
    return paramString;
  }
  
  public String iD(String paramString) {
    c("nShopID=? and _id= ? ", new String[] { VC(), paramString });
    Cursor cursor = VM();
    paramString = "";
    if (cursor.moveToFirst())
      paramString = cursor.getString(cursor.getColumnIndex("sUserPhone")); 
    cursor.close();
    return paramString;
  }
  
  public String iE(String paramString) {
    c("nShopID=? and _id= ? ", new String[] { VC(), paramString });
    hY("sUserName,sUserPhone");
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      String str = cursor.getString(0);
      if (str != null) {
        paramString = str;
        if (str.length() == 0) {
          paramString = cursor.getString(1);
          cursor.close();
          return paramString;
        } 
        cursor.close();
        return paramString;
      } 
    } else {
      paramString = null;
      cursor.close();
      return paramString;
    } 
    paramString = cursor.getString(1);
    cursor.close();
    return paramString;
  }
  
  protected void init() throws Exception {
    hX("t_user");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sUserName,sUserPhone,sUserPassword,nShopID,nUserRole,fUserAmount,sUserMacAddress,nUserStatus,nChannelID,sChannelName,nAuth,sText,nDateTime,nDeletionFlag,nUpdateFlag,nUserID,sMail,tempUserRole,nChargeTemplate,sIsWebOpen,nIsUpdated,nOperationTime,sPlatform");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */