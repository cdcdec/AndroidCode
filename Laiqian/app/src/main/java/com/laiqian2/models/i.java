package com.laiqian.models;

import android.content.Context;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;

public class i extends ao {
  public i(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public void a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4) { a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, null); }
  
  public void a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5) { a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5, null); }
  
  public void a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) { a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5, null, false, ""); }
  
  public boolean a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean) {
    int j = paramArrayOfString2.length;
    String str5 = "";
    StringBuffer stringBuffer = new StringBuffer();
    str = str5;
    if (paramString5 != null) {
      str = str5;
      if (!"".equals(paramString5)) {
        String str;
        null = new StringBuilder();
        null.append("");
        null.append(" nSpareField2=? and ");
        str = null.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString5);
        stringBuilder1.append(",");
        stringBuffer.append(stringBuilder1.toString());
      } 
    } 
    null = new StringBuilder();
    null.append(str);
    null.append("   nShopID=?  and nChargeType in ( ");
    null = null.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append(",");
    stringBuffer.append(stringBuilder.toString());
    for (j = 0; j < paramArrayOfString2.length; j++) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append("?,");
      null = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramArrayOfString2[j]);
      stringBuilder.append(",");
      stringBuffer.append(stringBuilder.toString());
    } 
    String str3 = null.substring(0, null.length() - 1);
    null = new StringBuilder();
    null.append(str3);
    null.append(") ");
    String str4 = null.toString();
    str3 = str4;
    if (paramString1 != null) {
      str3 = str4;
      if (Long.parseLong(paramString1) > 0L) {
        null = new StringBuilder();
        null.append(str4);
        null.append(" and nUserID=? ");
        str3 = null.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString1);
        stringBuilder1.append(",");
        stringBuffer.append(stringBuilder1.toString());
      } 
    } 
    paramString1 = str3;
    if (paramArrayOfString1 != null) {
      String str;
      null = new StringBuilder();
      null.append(str3);
      null.append(" and (nDateTime between ? and ?) ");
      str = null.toString();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramArrayOfString1[0]);
      stringBuilder1.append(",");
      stringBuffer.append(stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramArrayOfString1[1]);
      stringBuilder1.append(",");
      stringBuffer.append(stringBuilder1.toString());
    } 
    String str1 = str;
    if (paramString2 != null) {
      str1 = str;
      if (!"".equals(paramString2)) {
        str1 = str;
        if (Long.parseLong(paramString2) > 0L) {
          String str;
          null = new StringBuilder();
          null.append(str);
          null.append(" and nBPartnerID=? ");
          str1 = null.toString();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString2);
          stringBuilder1.append(",");
          stringBuffer.append(stringBuilder1.toString());
        } 
      } 
    } 
    str = str1;
    if (paramString4 != null) {
      str = str1;
      if (!"".equals(paramString4)) {
        String str;
        null = new StringBuilder();
        null.append(str1);
        null.append(" and (sBPartnerNumber like ? ");
        str1 = null.toString();
        null = new StringBuilder();
        null.append("%");
        null.append(paramString4);
        null.append("%,");
        stringBuffer.append(null.toString());
        null = new StringBuilder();
        null.append(str1);
        null.append(" or sBPartnerMobile like ? )");
        str = null.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("%");
        stringBuilder1.append(paramString4);
        stringBuilder1.append("%,");
        stringBuffer.append(stringBuilder1.toString());
      } 
    } 
    str1 = str;
    if (paramString6 != null) {
      str1 = str;
      if (!"".equals(paramString6)) {
        String str;
        null = new StringBuilder();
        null.append(str);
        null.append(" and nSpareField3=? ");
        str1 = null.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString6);
        stringBuilder1.append(",");
        stringBuffer.append(stringBuilder1.toString());
      } 
    } 
    null = new StringBuilder();
    null.append(str1);
    null.append(" and (sSpareField1 is null or sSpareField1='') ");
    str1 = null.toString();
    String str2 = str1;
    if (paramBoolean) {
      null = new StringBuilder();
      null.append(str1);
      null.append(" and sText in(  select  sText from t_bpartner_chargedoc group by sText having count(*) = 2 ) ");
      str2 = null.toString();
    } 
    str1 = str2;
    if (paramString3 != null)
      if (paramString3.equals("date")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(" group by date([T_BPARTNER_CHARGEDOC].[nDateTime]/1000,'unixepoch','localtime')");
        String str = stringBuilder1.toString();
      } else if (paramString3.equals("nBPartnerID")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(" group by nBPartnerID ");
        String str = stringBuilder1.toString();
      } else {
        null = new StringBuilder();
        null.append(str2);
        null.append(paramString3);
        str1 = null.toString();
      }  
    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    return c(str1, stringBuffer.toString().split(","));
  }
  
  public boolean a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, String paramString7) {
    int j = paramArrayOfString2.length;
    String str5 = "";
    StringBuffer stringBuffer = new StringBuffer();
    str = str5;
    if (paramString5 != null) {
      str = str5;
      if (!"".equals(paramString5)) {
        String str;
        null = new StringBuilder();
        null.append("");
        null.append(" nSpareField2=? and ");
        str = null.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString5);
        stringBuilder.append(",");
        stringBuffer.append(stringBuilder.toString());
      } 
    } 
    null = new StringBuilder();
    null.append(str);
    null.append("   nShopID=?  and nChargeType in ( ");
    null = null.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(VC());
    stringBuilder2.append(",");
    stringBuffer.append(stringBuilder2.toString());
    for (j = 0; j < paramArrayOfString2.length; j++) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(null);
      stringBuilder2.append("?,");
      null = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramArrayOfString2[j]);
      stringBuilder2.append(",");
      stringBuffer.append(stringBuilder2.toString());
    } 
    String str3 = null.substring(0, null.length() - 1);
    null = new StringBuilder();
    null.append(str3);
    null.append(") ");
    String str4 = null.toString();
    str3 = str4;
    if (paramString1 != null) {
      str3 = str4;
      if (Long.parseLong(paramString1) > 0L) {
        null = new StringBuilder();
        null.append(str4);
        null.append(" and nUserID=? ");
        str3 = null.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString1);
        stringBuilder.append(",");
        stringBuffer.append(stringBuilder.toString());
      } 
    } 
    paramString1 = str3;
    if (paramArrayOfString1 != null) {
      String str;
      null = new StringBuilder();
      null.append(str3);
      null.append(" and (nDateTime between ? and ?) ");
      str = null.toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramArrayOfString1[0]);
      stringBuilder.append(",");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramArrayOfString1[1]);
      stringBuilder.append(",");
      stringBuffer.append(stringBuilder.toString());
    } 
    String str1 = str;
    if (paramString2 != null) {
      str1 = str;
      if (!"".equals(paramString2)) {
        str1 = str;
        if (Long.parseLong(paramString2) > 0L) {
          String str;
          null = new StringBuilder();
          null.append(str);
          null.append(" and nBPartnerID=? ");
          str1 = null.toString();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString2);
          stringBuilder.append(",");
          stringBuffer.append(stringBuilder.toString());
        } 
      } 
    } 
    str = str1;
    if (paramString4 != null) {
      str = str1;
      if (!"".equals(paramString4)) {
        String str;
        null = new StringBuilder();
        null.append(str1);
        null.append(" and (sBPartnerNumber like ? ");
        str1 = null.toString();
        null = new StringBuilder();
        null.append("%");
        null.append(paramString4);
        null.append("%,");
        stringBuffer.append(null.toString());
        null = new StringBuilder();
        null.append(str1);
        null.append(" or sBPartnerMobile like ? )");
        str = null.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%");
        stringBuilder.append(paramString4);
        stringBuilder.append("%,");
        stringBuffer.append(stringBuilder.toString());
      } 
    } 
    str1 = str;
    if (paramString6 != null) {
      str1 = str;
      if (!"".equals(paramString6)) {
        String str;
        null = new StringBuilder();
        null.append(str);
        null.append(" and nSpareField3=? ");
        str1 = null.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString6);
        stringBuilder.append(",");
        stringBuffer.append(stringBuilder.toString());
      } 
    } 
    null = new StringBuilder();
    null.append(str1);
    null.append(" and (sSpareField1 is null or sSpareField1='') ");
    String str2 = null.toString();
    str1 = str2;
    if (!by.isNull(paramString7)) {
      String str;
      null = new StringBuilder();
      null.append(str2);
      null.append(paramString7);
      str1 = null.toString();
    } 
    str2 = str1;
    if (paramBoolean) {
      null = new StringBuilder();
      null.append(str1);
      null.append(" and sText in(  select  sText from t_bpartner_chargedoc group by sText having count(*) = 2 ) ");
      str2 = null.toString();
    } 
    str1 = str2;
    if (paramString3 != null)
      if (paramString3.equals("date")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(" group by date([T_BPARTNER_CHARGEDOC].[nDateTime]/1000,'unixepoch','localtime')");
        String str = stringBuilder.toString();
      } else if (paramString3.equals("nBPartnerID")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(" group by nBPartnerID ");
        String str = stringBuilder.toString();
      } else {
        null = new StringBuilder();
        null.append(str2);
        null.append(paramString3);
        str1 = null.toString();
      }  
    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("sFilter=");
    stringBuilder1.append(str1);
    stringBuilder1.append(" arrFilterParameters=");
    stringBuilder1.append(stringBuffer.toString());
    Log.d("setBPartnerDocFilter", stringBuilder1.toString());
    return c(str1, stringBuffer.toString().split(","));
  }
  
  protected void init() {
    hX("T_BPARTNER_CHARGEDOC");
    hV("_id");
    try {
      ArrayList arrayList = new ArrayList();
      Iterator iterator = j.bNO.iterator();
      while (iterator.hasNext())
        arrayList.add(((ao.b)iterator.next()).getName()); 
      String str = by.a(",", arrayList);
      this.bRX.put("LAIQIAN_FIELD_NAMES", str);
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */