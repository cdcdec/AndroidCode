package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.ap;
import com.laiqian.infrastructure.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;

public class bg extends ao {
  public bg(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public long WA() {
    String str;
    System.currentTimeMillis();
    Cursor cursor = null;
    try {
      cursor1 = Vq().rawQuery("SELECT nDateTime FROM T_USER WHERE nUserRole=150001 ;", new String[0]);
      try {
        cursor1.moveToFirst();
        return cursor1.getLong(0);
      } finally {
        str = null;
      } 
    } finally {}
    if (cursor != null)
      cursor.close(); 
    throw str;
  }
  
  public ArrayList<HashMap<String, String>> Wz() {
    ArrayList arrayList = new ArrayList();
    hY("_id,sUserName,sUserPhone");
    c("nShopID=? and nDeletionFlag != ?", new String[] { VC(), "170003" });
    Cursor cursor = VM();
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(cursor.getLong(0));
      stringBuilder.append("");
      hashMap.put("id", stringBuilder.toString());
      hashMap.put("name", cursor.getString(1));
      String str2 = cursor.getString(2);
      String str1 = str2;
      if (str2.length() > 15) {
        null = new StringBuilder();
        null.append(str2.substring(0, 3));
        null.append("****");
        null.append(str2.substring(str2.length() - 4, str2.length()));
        str1 = null.toString();
      } 
      hashMap.put("phone", str1);
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
  
  public ArrayList<ap> c(boolean paramBoolean, String paramString) {
    ArrayList arrayList = new ArrayList();
    hY("_id,sUserName,sUserPhone");
    c("nShopID=? and nDeletionFlag != ?", new String[] { VC(), "170003" });
    Cursor cursor = VM();
    while (cursor.moveToNext()) {
      long l = cursor.getLong(0);
      String str3 = cursor.getString(1);
      String str2 = cursor.getString(2);
      String str1 = str2;
      if (str2.length() > 15) {
        null = new StringBuilder();
        null.append(str2.substring(0, 3));
        null.append("****");
        null.append(str2.substring(str2.length() - 4, str2.length()));
        str1 = null.toString();
      } 
      arrayList.add(new ap(l, str3, str1));
    } 
    cursor.close();
    if (paramBoolean)
      arrayList.add(0, new ap(0L, paramString, paramString)); 
    return arrayList;
  }
  
  public ArrayList<ap> er(boolean paramBoolean) { return c(paramBoolean, this.mContext.getString(R.string.pos_report_transaction_user_all)); }
  
  protected void init() {
    hX("t_user");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sUserName,sUserPhone,sUserPassword,nShopID,nUserRole,fUserAmount,sUserMacAddress,nUserStatus,nChannelID,sChannelName,nAuth,sText,nDateTime,nDeletionFlag,nUpdateFlag,nUserID,sMail, tempUserRole, nChargeTemplate,sIsWebOpen, nIsUpdated,nOperationTime,sPlatform");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */