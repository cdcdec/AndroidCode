package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.print.model.type.usb.d;

public class u extends as {
  public u(Context paramContext) throws Exception { super(paramContext); }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3) { return a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramInt3, 0, 0, null, 0, null); }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5, int paramInt6, String paramString6) {
    String str2 = VC();
    String str3 = getUserID();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    c(" nFieldType = ? and nShopID = ? ", new String[] { stringBuilder2.toString(), str2 });
    Cursor cursor = VM();
    boolean bool = cursor.moveToFirst();
    cursor.close();
    if (paramString1 != null)
      am("sFieldValue", paramString1); 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append("");
    am("nFieldType", stringBuilder1.toString());
    am("sSpareField1", paramString2);
    am("sSpareField2", paramString3);
    am("sSpareField3", paramString4);
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    am("nSpareField1", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt3);
    stringBuilder1.append("");
    am("nSpareField2", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt4);
    stringBuilder1.append("");
    am("nSpareField3", stringBuilder1.toString());
    if (paramString5 != null)
      am("sSpareField4", paramString5); 
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt5);
    stringBuilder1.append("");
    am("nSpareField4", stringBuilder1.toString());
    if (paramString6 != null)
      am("sSpareField5", paramString6); 
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt6);
    stringBuilder1.append("");
    am("nSpareField5", stringBuilder1.toString());
    if (bool) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt1);
      stringBuilder1.append("");
      d(" nFieldTYpe = ? and nShopID = ? ", new String[] { stringBuilder1.toString(), str2 });
      return update();
    } 
    String str1 = "";
    if (paramInt1 != 61) {
      switch (paramInt1) {
        case 57:
          str1 = "厨房小票";
          break;
        case 56:
          str1 = "标签样式";
          break;
        case 55:
          str1 = "小票样式";
          break;
      } 
    } else {
      str1 = "商超自制条码标签";
    } 
    am("sFieldName", str1);
    am("nShopID", str2);
    am("nUserID", str3);
    am("sIsActive", "Y");
    return QL();
  }
  
  public boolean a(d paramd) {
    boolean bool;
    String str1 = VC();
    String str2 = getUserID();
    String str3 = paramd.getIdentifier();
    Cursor cursor = hy(str3);
    if (cursor != null && cursor.moveToFirst()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (cursor != null)
      cursor.close(); 
    am("nFieldType", "60");
    am("sFieldName", paramd.getName());
    am("sFieldValue", str3);
    if (paramd.getWidth() == 0 && paramd.getHeight() == 0) {
      am("sSpareField1", "58");
    } else if (paramd.getHeight() == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramd.getWidth());
      stringBuilder.append("");
      am("sSpareField1", stringBuilder.toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramd.getWidth());
      stringBuilder.append(",");
      stringBuilder.append(paramd.getHeight());
      am("sSpareField1", stringBuilder.toString());
    } 
    if (bool) {
      d(" nFieldType = ? and sFieldValue = ? and nShopID = ? ", new String[] { "60", str3, str1 });
      return update();
    } 
    am("nShopID", str1);
    am("nUserID", str2);
    am("sIsActive", "Y");
    return QL();
  }
  
  public Cursor gf(int paramInt) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    c(" nFieldType = ? and nShopID = ? ", new String[] { stringBuilder.toString(), str });
    return VM();
  }
  
  public Cursor hy(String paramString) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    c(" sFieldValue = ? and nShopID = ? ", new String[] { stringBuilder.toString(), str });
    return VM();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\model\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */