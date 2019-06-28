package com.laiqian.print;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.u;
import com.laiqian.print.usage.delivery.model.DeliveryPrintSettings;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.tag.a.c;
import com.laiqian.util.av;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class br implements d {
  private Context context;
  
  public br(Context paramContext) { this.context = paramContext; }
  
  public boolean a(DeliveryPrintSettings paramDeliveryPrintSettings) {
    try {
      exception = new u(this.context);
    } catch (Exception exception) {
      while (true) {
        a.e(exception);
        exception = null;
        try {
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("sTitleSize", paramDeliveryPrintSettings.ait());
          jSONObject.put("nDelay", paramDeliveryPrintSettings.aiy());
          jSONException = jSONObject.toString();
        } catch (JSONException jSONException1) {
          a.e(jSONException);
          jSONException = null;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramDeliveryPrintSettings.getWidth());
        stringBuilder1.append("");
        boolean bool1 = exception.a(59, jSONException, stringBuilder1.toString(), paramDeliveryPrintSettings.getTitle(), paramDeliveryPrintSettings.aiq(), paramDeliveryPrintSettings.air(), paramDeliveryPrintSettings.getCopies(), paramDeliveryPrintSettings.ais(), paramDeliveryPrintSettings.aiu(), paramDeliveryPrintSettings.aiv(), paramDeliveryPrintSettings.aiw(), paramDeliveryPrintSettings.aix());
        exception.close();
        return bool1;
      } 
    } 
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("sTitleSize", paramDeliveryPrintSettings.ait());
      jSONObject.put("nDelay", paramDeliveryPrintSettings.aiy());
      jSONException = jSONObject.toString();
    } catch (JSONException jSONException) {
      a.e(jSONException);
      jSONException = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDeliveryPrintSettings.getWidth());
    stringBuilder.append("");
    boolean bool = exception.a(59, jSONException, stringBuilder.toString(), paramDeliveryPrintSettings.getTitle(), paramDeliveryPrintSettings.aiq(), paramDeliveryPrintSettings.air(), paramDeliveryPrintSettings.getCopies(), paramDeliveryPrintSettings.ais(), paramDeliveryPrintSettings.aiu(), paramDeliveryPrintSettings.aiv(), paramDeliveryPrintSettings.aiw(), paramDeliveryPrintSettings.aix());
    exception.close();
    return bool;
  }
  
  public boolean a(c paramc) {
    u u = new av(this.context);
    u.h("kitchenPrintList", paramc.aiE());
    u.h("KITCHEN_AREA_IGNORE_LIST", paramc.aiF());
    u.close();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("splitProducts", paramc.aiH());
      jSONObject.put("printOrder", paramc.getOrder());
      jSONObject.put("showPrice", paramc.aiD());
    } catch (JSONException null) {
      a.e(u);
    } 
    u = null;
    try {
      u u1 = new u(this.context);
      u = u1;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str = jSONObject.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramc.getWidth());
    stringBuilder.append("");
    boolean bool = u.a(57, str, stringBuilder.toString(), null, null, paramc.air(), paramc.getCopies(), paramc.aiG(), 0, null, 0, null);
    u.close();
    return bool;
  }
  
  public boolean a(c paramc) {
    av = new av(this.context);
    av.h("TagPrintList", paramc.aiZ());
    av.close();
    String str = String.format("%d,%d", new Object[] { Integer.valueOf(paramc.getWidth()), Integer.valueOf(paramc.getHeight()) });
    u u = null;
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("dirVertical", paramc.aiX());
      jSONObject.put("isPrintTag", paramc.aiY());
      jSONObject.put("isPrintWeight", paramc.aiT());
      jSONObject.put("isPrintPrice", paramc.aiU());
      jSONObject.put("printRange", paramc.aja());
      jSONObject.put("printMode", paramc.aiV());
      String str1 = jSONObject.toString();
    } catch (JSONException av) {
      a.e(av);
      av = null;
    } 
    try {
      u u1 = new u(this.context);
      u = u1;
    } catch (Exception exception) {
      a.e(exception);
    } 
    boolean bool = u.a(56, av, str, null, paramc.aiW(), 0, 0);
    u.close();
    return bool;
  }
  
  public c aee() {
    c c = new c();
    Object object1 = new av(this.context);
    object2 = object1.qQ("TagPrintList");
    if (object2 != null)
      c.M((HashMap)object2); 
    object1.close();
    object1 = null;
    try {
      object2 = new u(this.context);
      object1 = object2;
    } catch (Exception object2) {
      a.e(object2);
    } 
    object2 = object1.gf(56);
    if (object2.moveToFirst()) {
      str1 = object2.getString(object2.getColumnIndex("sSpareField1"));
      String str2 = object2.getString(object2.getColumnIndex("sSpareField3"));
      String str3 = object2.getString(object2.getColumnIndex("sFieldValue"));
      if (str1 != null)
        if ("30,40".equals(str1)) {
          c.setSize(30, 40);
        } else if ("60,40".equals(str1)) {
          c.setSize(60, 40);
        }  
      if (str2 != null)
        c.mb(str2); 
      if (!TextUtils.isEmpty(str3))
        try {
          JSONObject jSONObject = new JSONObject(str3);
          if (jSONObject.has("dirVertical"))
            c.aD(jSONObject.getBoolean("dirVertical")); 
          if (jSONObject.has("isPrintTag"))
            c.gj(jSONObject.getBoolean("isPrintTag")); 
          c.gf(jSONObject.optBoolean("isPrintWeight", true));
          c.ge(jSONObject.optBoolean("isPrintPrice", false));
          c.ja(jSONObject.optInt("printMode", 0));
          c.jb(jSONObject.optInt("printRange", 0));
        } catch (JSONException str1) {
          a.e(str1);
        }  
    } 
    if (object2 != null)
      object2.close(); 
    object1.close();
    return c;
  }
  
  public ReceiptPrintSettings aef() {
    ReceiptPrintSettings receiptPrintSettings = new ReceiptPrintSettings();
    try {
      exception = new u(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Cursor cursor = exception.gf(55);
    if (cursor != null)
      try {
        if (cursor.moveToFirst()) {
          str4 = cursor.getString(cursor.getColumnIndex("sSpareField1"));
          str5 = cursor.getString(cursor.getColumnIndex("sSpareField2"));
          String str1 = cursor.getString(cursor.getColumnIndex("sSpareField3"));
          int i = cursor.getInt(cursor.getColumnIndex("nSpareField1"));
          int j = cursor.getInt(cursor.getColumnIndex("nSpareField2"));
          int k = cursor.getInt(cursor.getColumnIndex("nSpareField3"));
          String str2 = cursor.getString(cursor.getColumnIndex("sSpareField4"));
          int m = cursor.getInt(cursor.getColumnIndex("nSpareField4"));
          String str3 = cursor.getString(cursor.getColumnIndex("sSpareField5"));
          int n = cursor.getInt(cursor.getColumnIndex("nSpareField5"));
          String str6 = cursor.getString(cursor.getColumnIndex("sFieldValue"));
          if (str4 != null)
            if ("58".equals(str4)) {
              receiptPrintSettings.setWidth(58);
            } else if ("80".equals(str4)) {
              receiptPrintSettings.setWidth(80);
            }  
          if (str5 != null)
            receiptPrintSettings.setTitle(str5); 
          boolean bool = TextUtils.isEmpty(str6);
          if (!bool)
            try {
              JSONObject jSONObject = new JSONObject(str6);
              str5 = jSONObject.getString("sTitleSize");
              try {
                receiptPrintSettings.iO(Integer.parseInt(str5));
              } catch (Exception str5) {
                a.e(str5);
              } 
              if (jSONObject.has("showUnitPrice"))
                receiptPrintSettings.fX(jSONObject.getBoolean("showUnitPrice")); 
              if (jSONObject.has("showMemberPrice"))
                receiptPrintSettings.gd(jSONObject.getBoolean("showMemberPrice")); 
              if (jSONObject.has("nDelay"))
                receiptPrintSettings.cX(jSONObject.getInt("nDelay")); 
              receiptPrintSettings.iY(jSONObject.optInt("columnType"));
            } catch (JSONException str4) {
              a.e(str4);
            }  
          if (str1 != null)
            receiptPrintSettings.lU(str1); 
          if (ReceiptPrintSettings.iL(i))
            receiptPrintSettings.iM(i); 
          if (ReceiptPrintSettings.iJ(j))
            receiptPrintSettings.setCopies(j); 
          if (ReceiptPrintSettings.iK(k))
            receiptPrintSettings.iN(k); 
          receiptPrintSettings.iP(m);
          if (str2 != null)
            receiptPrintSettings.lV(str2); 
          receiptPrintSettings.iQ(n);
          if (str3 != null)
            receiptPrintSettings.lW(str3); 
        } 
      } finally {
        if (cursor != null)
          cursor.close(); 
      }  
    if (cursor != null)
      cursor.close(); 
    exception.close();
    return receiptPrintSettings;
  }
  
  public c aeg() {
    c c = new c();
    Object object1 = new av(this.context);
    object2 = object1.qQ("kitchenPrintList");
    if (object2 != null)
      c.K((HashMap)object2); 
    object2 = object1.qQ("KITCHEN_AREA_IGNORE_LIST");
    if (object2 != null)
      c.L((HashMap)object2); 
    object1.close();
    object1 = null;
    try {
      object2 = new u(this.context);
      object1 = object2;
    } catch (Exception object2) {
      a.e(object2);
    } 
    object2 = object1.gf(57);
    if (object2 != null && object2.moveToFirst()) {
      str1 = object2.getString(object2.getColumnIndex("sSpareField1"));
      int i = object2.getInt(object2.getColumnIndex("nSpareField1"));
      int j = object2.getInt(object2.getColumnIndex("nSpareField2"));
      String str2 = object2.getString(object2.getColumnIndex("sFieldValue"));
      int k = object2.getInt(object2.getColumnIndex("nSpareField3"));
      if (str1 != null)
        if ("58".equals(str1)) {
          c.setWidth(58);
        } else if ("80".equals(str1)) {
          c.setWidth(80);
        }  
      if (c.iJ(j))
        c.setCopies(j); 
      if (c.iL(i))
        c.iM(i); 
      if (c.iK(k))
        c.iz(k); 
      if (str2 != null)
        try {
          JSONObject jSONObject = new JSONObject(str2);
          if (jSONObject.has("splitProducts"))
            c.fY(jSONObject.getBoolean("splitProducts")); 
          if (jSONObject.has("printOrder"))
            c.setOrder(jSONObject.getInt("printOrder")); 
          if (jSONObject.has("showPrice"))
            c.fZ(jSONObject.getBoolean("showPrice")); 
        } catch (JSONException str1) {
          a.e(str1);
        }  
    } 
    if (object2 != null)
      object2.close(); 
    object1.close();
    return c;
  }
  
  public DeliveryPrintSettings aeh() {
    DeliveryPrintSettings deliveryPrintSettings = new DeliveryPrintSettings();
    try {
      exception = new u(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Cursor cursor = exception.gf(59);
    if (cursor != null && cursor.moveToFirst()) {
      str4 = cursor.getString(cursor.getColumnIndex("sSpareField1"));
      String str5 = cursor.getString(cursor.getColumnIndex("sSpareField2"));
      String str1 = cursor.getString(cursor.getColumnIndex("sSpareField3"));
      int i = cursor.getInt(cursor.getColumnIndex("nSpareField1"));
      int j = cursor.getInt(cursor.getColumnIndex("nSpareField2"));
      int k = cursor.getInt(cursor.getColumnIndex("nSpareField3"));
      String str2 = cursor.getString(cursor.getColumnIndex("sSpareField4"));
      int m = cursor.getInt(cursor.getColumnIndex("nSpareField4"));
      String str3 = cursor.getString(cursor.getColumnIndex("sSpareField5"));
      int n = cursor.getInt(cursor.getColumnIndex("nSpareField5"));
      String str6 = cursor.getString(cursor.getColumnIndex("sFieldValue"));
      if (str4 != null)
        if ("58".equals(str4)) {
          deliveryPrintSettings.setWidth(58);
        } else if ("80".equals(str4)) {
          deliveryPrintSettings.setWidth(80);
        }  
      if (str5 != null)
        deliveryPrintSettings.setTitle(str5); 
      if (!TextUtils.isEmpty(str6))
        try {
          JSONObject jSONObject = new JSONObject(str6);
          str5 = jSONObject.getString("sTitleSize");
          int i1 = 0;
          if (jSONObject.has("nDelay"))
            i1 = jSONObject.getInt("nDelay"); 
          deliveryPrintSettings.iO(Integer.parseInt(str5));
          deliveryPrintSettings.cX(i1);
        } catch (JSONException str4) {} 
      if (str1 != null)
        deliveryPrintSettings.lU(str1); 
      if (DeliveryPrintSettings.iL(i))
        deliveryPrintSettings.iM(i); 
      if (DeliveryPrintSettings.iJ(j))
        deliveryPrintSettings.setCopies(j); 
      if (DeliveryPrintSettings.iK(k))
        deliveryPrintSettings.iN(k); 
      deliveryPrintSettings.iP(m);
      if (str2 != null)
        deliveryPrintSettings.lV(str2); 
      deliveryPrintSettings.iQ(n);
      if (str3 != null)
        deliveryPrintSettings.lW(str3); 
    } 
    if (cursor != null)
      cursor.close(); 
    exception.close();
    return deliveryPrintSettings;
  }
  
  public boolean b(ReceiptPrintSettings paramReceiptPrintSettings) {
    try {
      exception = new u(this.context);
    } catch (Exception exception) {
      while (true) {
        a.e(exception);
        exception = null;
        try {
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("sTitleSize", paramReceiptPrintSettings.ait());
          jSONObject.put("nDelay", paramReceiptPrintSettings.aiy());
          jSONObject.put("showUnitPrice", paramReceiptPrintSettings.aiN());
          jSONObject.put("showMemberPrice", paramReceiptPrintSettings.aiO());
          jSONObject.put("columnType", paramReceiptPrintSettings.aiM());
          jSONException = jSONObject.toString();
        } catch (JSONException jSONException1) {
          a.e(jSONException);
          jSONException = null;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramReceiptPrintSettings.getWidth());
        stringBuilder1.append("");
        boolean bool1 = exception.a(55, jSONException, stringBuilder1.toString(), paramReceiptPrintSettings.getTitle(), paramReceiptPrintSettings.aiq(), paramReceiptPrintSettings.air(), paramReceiptPrintSettings.getCopies(), paramReceiptPrintSettings.ais(), paramReceiptPrintSettings.aiu(), paramReceiptPrintSettings.aiv(), paramReceiptPrintSettings.aiw(), paramReceiptPrintSettings.aix());
        exception.close();
        return bool1;
      } 
    } 
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("sTitleSize", paramReceiptPrintSettings.ait());
      jSONObject.put("nDelay", paramReceiptPrintSettings.aiy());
      jSONObject.put("showUnitPrice", paramReceiptPrintSettings.aiN());
      jSONObject.put("showMemberPrice", paramReceiptPrintSettings.aiO());
      jSONObject.put("columnType", paramReceiptPrintSettings.aiM());
      jSONException = jSONObject.toString();
    } catch (JSONException jSONException) {
      a.e(jSONException);
      jSONException = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramReceiptPrintSettings.getWidth());
    stringBuilder.append("");
    boolean bool = exception.a(55, jSONException, stringBuilder.toString(), paramReceiptPrintSettings.getTitle(), paramReceiptPrintSettings.aiq(), paramReceiptPrintSettings.air(), paramReceiptPrintSettings.getCopies(), paramReceiptPrintSettings.ais(), paramReceiptPrintSettings.aiu(), paramReceiptPrintSettings.aiv(), paramReceiptPrintSettings.aiw(), paramReceiptPrintSettings.aix());
    exception.close();
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */