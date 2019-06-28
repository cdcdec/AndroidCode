package com.laiqian.takeaway;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.aa;
import com.laiqian.entity.ao;
import com.laiqian.entity.ap;
import com.laiqian.entity.aq;
import com.laiqian.entity.v;
import com.laiqian.entity.z;
import com.laiqian.models.f;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.product.models.a;
import com.laiqian.product.models.c;
import com.laiqian.product.models.h;
import com.laiqian.product.models.o;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class am {
  private double aJW;
  
  private Context context;
  
  private a dtn;
  
  public am(Context paramContext) { this.context = paramContext; }
  
  @NonNull
  private TakeOrderEntity a(JSONObject paramJSONObject, ArrayList<aa> paramArrayList) throws JSONException {
    String str9;
    String str7;
    String str6;
    String str5;
    String str4;
    long l4;
    long l3;
    long l2;
    long l1;
    double d2;
    double d1;
    double d3 = paramJSONObject.optDouble("recevied");
    String str2 = System.out;
    str3 = new StringBuilder();
    str3.append("TakeOutDataUti.getOrderEntity. amount is:");
    str3.append(this.aJW);
    str3.append(",recevied is:");
    str3.append(d3);
    str2.println(str3.toString());
    this.aJW += d3;
    try {
      String str = paramJSONObject.optString("discountAmount");
    } catch (Exception null) {
      a.e(str2);
      str3 = "";
    } 
    try {
      str4 = paramJSONObject.optString("dishwareAmount");
    } catch (Exception null) {
      a.e(str2);
      str4 = "";
    } 
    try {
      str6 = paramJSONObject.optString("deliverAmount");
    } catch (Exception null) {
      a.e(str2);
      str6 = "";
    } 
    double d4 = paramJSONObject.optDouble("serviceAmount");
    double d5 = paramJSONObject.optDouble("taxAmount");
    if (paramJSONObject.has("tax")) {
      String str = paramJSONObject.optString("tax");
    } else {
      String str = "";
    } 
    if (d5 > 0.0D) {
      null = new StringBuilder();
      null.append(d5);
      null.append("");
      str2 = null.toString();
    } 
    String str8 = new JSONObject(paramJSONObject.toString());
    String str10 = paramJSONObject.optString("type");
    if (str10.equals("weixin_eat_in") || str10.equals("koubei")) {
      str5 = paramJSONObject.optString("address");
      str7 = paramJSONObject.optString("serialNumber");
      str8.remove("serialNumber");
      str8.remove("address");
      str8.put("serialNumber", str5);
      str8.put("address", str7);
    } 
    aq aq = new aq();
    if (paramJSONObject.has("bpartnerID") && paramJSONObject.optLong("bpartnerID") > 0L) {
      aq.aSW = paramJSONObject.optLong("bpartnerID");
      str5 = paramJSONObject.optString("bpartnerInfo", "");
      if (!TextUtils.isEmpty(str5)) {
        JSONObject jSONObject = new JSONObject(str5);
        aq.aTp = jSONObject.optString("sContactMobilePhone", "");
        aq.aWC = jSONObject.optInt("nShopID", 0);
      } 
    } 
    String str11 = paramJSONObject.optString("shopid");
    String str12 = paramJSONObject.optString("id");
    String str13 = paramJSONObject.optString("number");
    String str14 = paramJSONObject.optString("address");
    String str15 = paramJSONObject.optString("name");
    String str16 = paramJSONObject.optString("mobile");
    String str17 = paramJSONObject.optString("createTime");
    long l5 = by.parseLong(paramJSONObject.optString("timestamp"));
    String str18 = paramJSONObject.optString("timestamp_ms");
    String str19 = paramJSONObject.optString("note");
    String str20 = paramJSONObject.optString("shopName");
    String str21 = paramJSONObject.optString("startDeliveryTime");
    String str22 = paramJSONObject.optString("endDeliveryTime");
    String str23 = paramJSONObject.optString("serialNumber");
    String str24 = paramJSONObject.optString("status");
    String str25 = paramJSONObject.optString("businessType");
    String str26 = paramJSONObject.optString("payStatus");
    double d6 = paramJSONObject.optDouble("amount");
    String str27 = paramJSONObject.optString("paytype");
    double d7 = by.parseDouble(paramJSONObject.optString("rebates"));
    if (paramJSONObject.has("discount")) {
      str5 = paramJSONObject.optString("discount");
    } else {
      str5 = "";
    } 
    String str28 = paramJSONObject.optString("discountMessage");
    if (paramJSONObject.has("discountMessage_en")) {
      str7 = paramJSONObject.optString("discountMessage_en");
    } else {
      str7 = "";
    } 
    double d8 = by.parseDouble(str4);
    double d9 = by.parseDouble(str6);
    int i = paramJSONObject.optInt("bIsLqkAccount");
    String str29 = paramJSONObject.optString("sellout");
    String str30 = str8.toString();
    if (paramJSONObject.has("bIsTakeaway")) {
      l1 = paramJSONObject.optLong("bIsTakeaway");
    } else {
      l1 = 0L;
    } 
    if (paramJSONObject.has("deliverName")) {
      str4 = paramJSONObject.optString("deliverName");
    } else {
      str4 = "";
    } 
    if (paramJSONObject.has("sequenceID")) {
      str6 = paramJSONObject.optString("sequenceID");
    } else {
      str6 = "";
    } 
    if (paramJSONObject.has("rounding")) {
      String str = paramJSONObject.optString("rounding");
    } else {
      str8 = "0";
    } 
    if (paramJSONObject.has("firstPayType")) {
      l2 = paramJSONObject.optLong("firstPayType");
    } else {
      l2 = 0L;
    } 
    if (paramJSONObject.has("firstPayValue")) {
      d1 = paramJSONObject.optDouble("firstPayValue");
    } else {
      d1 = 0.0D;
    } 
    if (paramJSONObject.has("secondPayType")) {
      l3 = paramJSONObject.optLong("secondPayType");
    } else {
      l3 = 0L;
    } 
    if (paramJSONObject.has("secondPayValue")) {
      d2 = paramJSONObject.optDouble("secondPayValue");
    } else {
      d2 = 0.0D;
    } 
    if (paramJSONObject.has("bpartnerID")) {
      l4 = paramJSONObject.optLong("bpartnerID");
    } else {
      l4 = 0L;
    } 
    if (paramJSONObject.has("orderNo")) {
      str9 = paramJSONObject.optString("orderNo");
    } else {
      str9 = "";
    } 
    TakeOrderEntity takeOrderEntity = new TakeOrderEntity(str10, str11, str12, str13, str14, str15, str16, paramArrayList, str17, l5, str18, str19, str20, str21, str22, str23, str24, str25, str26, d6, str27, d3, d7, str5, str3, str28, str7, d8, d9, i, str29, str2, str30, l1, str4, str6, str8, l2, d1, l3, d2, l4, aq, str9);
    if (takeOrderEntity.dv(str10)) {
      takeOrderEntity.billNumber = null;
      if (takeOrderEntity.dw(str10)) {
        takeOrderEntity.number = paramJSONObject.optString("meituanOrder", null);
      } else {
        takeOrderEntity.number = paramJSONObject.optString("elemeOrder", null);
      } 
      try {
        takeOrderEntity.aWc = paramJSONObject.optInt("isBook", 0);
        takeOrderEntity.aWe = paramJSONObject.optInt("pickType", 0);
      } catch (Exception str3) {
        a.e(str3);
      } 
    } 
    int j = 0;
    takeOrderEntity.aVz = paramJSONObject.optDouble("productAmount");
    takeOrderEntity.dishwareBaseAmount = paramJSONObject.optDouble("dishwareBaseAmount");
    takeOrderEntity.deliverBaseAmount = paramJSONObject.optDouble("deliverBaseAmount");
    takeOrderEntity.dishwareTaxName = paramJSONObject.optString("dishwareTaxName");
    takeOrderEntity.deliverTaxName = paramJSONObject.optString("deliverTaxName");
    takeOrderEntity.serviceTaxName = paramJSONObject.optString("serviceTaxName");
    if (takeOrderEntity.dishwareBaseAmount == 0.0D)
      takeOrderEntity.dishwareBaseAmount = takeOrderEntity.IA(); 
    if (takeOrderEntity.deliverBaseAmount == 0.0D)
      takeOrderEntity.deliverBaseAmount = takeOrderEntity.IB(); 
    if (paramJSONObject.has("orderState")) {
      i = paramJSONObject.optInt("orderState");
    } else {
      i = 0;
    } 
    takeOrderEntity.eF(i);
    String str1 = paramJSONObject.optString("taxList");
    if (!TextUtils.isEmpty(str1) && !str1.equals("[]")) {
      JSONArray jSONArray = new JSONArray(str1);
      for (i = j; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.getJSONObject(i);
        takeOrderEntity.a(by.parseLong(jSONObject.optString("taxID")), jSONObject.optString("taxName"), by.parseDouble(jSONObject.optString("taxValue")), by.parseDouble(jSONObject.optString("amountOfTax")), by.parseDouble(jSONObject.optString("amountOfProductlist")), by.parseDouble(jSONObject.optString("spareField1")));
      } 
    } 
    takeOrderEntity.V(by.parseDouble(str2));
    takeOrderEntity.aVC = d4;
    takeOrderEntity.aVD = d5;
    takeOrderEntity.aVE = d3 - d5 - d4;
    return takeOrderEntity;
  }
  
  private ao a(ao paramao, String paramString) throws JSONException {
    if (!TextUtils.isEmpty(paramString) && !paramString.equals("[]")) {
      JSONArray jSONArray = new JSONArray(paramString);
      ArrayList arrayList = new ArrayList();
      for (byte b = 0; b < jSONArray.length(); b++) {
        JSONObject jSONObject = jSONArray.optJSONObject(b);
        arrayList.add(new c(jSONObject.optLong("id"), jSONObject.optString("name"), jSONObject.optInt("quantity"), false, by.parseDouble(jSONObject.optString("price")), null));
        paramao.n(arrayList);
      } 
    } 
    return paramao;
  }
  
  private ArrayList<z> a(f paramf, ArrayList<z> paramArrayList, long paramLong, int paramInt, Double paramDouble) {
    z z;
    if (paramLong > 10013L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      String str = paramf.gY(stringBuilder.toString());
      z = new z('✝', paramDouble.doubleValue(), str, paramLong);
    } else {
      null = v.ap(paramLong);
      z = new z(paramInt, paramDouble.doubleValue(), null, 0L);
    } 
    paramArrayList.add(z);
    return paramArrayList;
  }
  
  private void a(String paramString, al.b paramb, int paramInt) {
    a a1 = new a(this.context);
    a1.kj(paramString);
    a1.close();
    if (paramb != null) {
      if (paramInt == 0) {
        paramb.ku(0);
        return;
      } 
      if (paramInt == 2)
        paramb.aqq(); 
    } 
  }
  
  private ao b(ao paramao, String paramString) throws JSONException {
    if (!TextUtils.isEmpty(paramString) && !paramString.equals("[]")) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      JSONArray jSONArray = new JSONArray(paramString);
      ArrayList arrayList = new ArrayList();
      byte b = 0;
      while (true) {
        str = paramao;
        if (b < jSONArray.length()) {
          JSONObject jSONObject = jSONArray.optJSONObject(b);
          str = jSONObject.optString("sName");
          int i = jSONObject.optInt("nType");
          arrayList.add(new o(Long.valueOf(jSONObject.optString("id")).longValue(), str, by.parseDouble(jSONObject.getString("fValue")), by.parseInt(jSONObject.optString("nType")), false, false));
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          if (i == 1) {
            str = "*";
          } else {
            str = "";
          } 
          stringBuilder1.append(str);
          stringBuilder.append(stringBuilder1.toString());
          if (b != jSONArray.length() - 1)
            stringBuilder.append("/"); 
          b++;
          continue;
        } 
        break;
      } 
      str.o(arrayList);
      if (stringBuilder != null)
        str.dx(stringBuilder.toString()); 
    } 
    return paramao;
  }
  
  public static ArrayList<String> oG(String paramString) { return oH(paramString); }
  
  @NonNull
  private static ArrayList<String> oH(String paramString) {
    ArrayList arrayList = new ArrayList();
    try {
      if (!by.isNull(paramString)) {
        String[] arrayOfString;
        if (paramString.contains("[")) {
          arrayOfString = paramString.replace("[", "").replace("]", "").replace("\"", "").split(",");
          for (byte b = 0; b < arrayOfString.length; b++)
            arrayList.add(arrayOfString[b]); 
        } else {
          arrayList.add(arrayOfString);
          return arrayList;
        } 
      } 
    } catch (Exception paramString) {
      a.e(paramString);
    } 
    return arrayList;
  }
  
  public static ArrayList<String> oI(String paramString) { return oH(paramString); }
  
  @NonNull
  private h t(JSONObject paramJSONObject) throws JSONException {
    String str2;
    if (TextUtils.isEmpty(paramJSONObject.getString("mealset"))) {
      String str3;
      long l1 = by.parseLong(paramJSONObject.getString("productid"));
      String str4 = paramJSONObject.getString("name");
      if (paramJSONObject.has("name2")) {
        str3 = paramJSONObject.getString("name2");
      } else {
        str3 = "";
      } 
      str2 = new h(l1, str4, str3, by.parseDouble(paramJSONObject.getString("price")), by.parseDouble(paramJSONObject.getString("quantity")), paramJSONObject.getInt("status"), by.parseLong(paramJSONObject.getString("producttype")), paramJSONObject.getString("text"), 0.0D, "", false, 0.0D);
      str2.mI(paramJSONObject.optString("cart_name"));
      return str2;
    } 
    long l = by.parseLong(paramJSONObject.getString("productid"));
    null = paramJSONObject.getString("name");
    if (paramJSONObject.has("name2")) {
      str2 = paramJSONObject.getString("name2");
    } else {
      str2 = "";
    } 
    a a1 = new a(l, null, str2, by.parseDouble(paramJSONObject.getString("price")), paramJSONObject.getInt("status"), by.parseLong(paramJSONObject.getString("producttype")), 0.0D, null);
    a1.aO(Double.valueOf(paramJSONObject.getString("quantity")).doubleValue());
    str1 = paramJSONObject.getString("mealsetList").replace("\\\\", "");
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    if (!TextUtils.isEmpty(str1) && !str1.equals("[]")) {
      JSONArray jSONArray = new JSONArray(str1);
      for (byte b = 0; b < jSONArray.length(); b++) {
        null = jSONArray.getJSONObject(b);
        int j = null.optInt("nSelectedQuantity", 0);
        int i = null.optInt("nQuantity", 0);
        if (j >= i && i == 1) {
          boolean bool = true;
        } else {
          boolean bool = false;
        } 
        String str = null.getString("products");
        if (!TextUtils.isEmpty(str) && !str.equals("[]")) {
          JSONArray jSONArray1 = new JSONArray(str);
          boolean bool = false;
          while (true);
        } 
      } 
    } 
    try {
      ((a)a1).a(null, arrayList1, arrayList2);
      return a1;
    } catch (Exception str1) {
      a.e(str1);
      return a1;
    } 
  }
  
  public double AO() { return this.aJW; }
  
  public String a(TakeOrderEntity paramTakeOrderEntity, boolean paramBoolean) {
    String str;
    if (paramBoolean) {
      str = "delivered";
    } else {
      str = "refund";
    } 
    try {
      return (new JSONObject()).put("sStatus", str).put("_id", paramTakeOrderEntity.getId()).put("nShopID", paramTakeOrderEntity.Il()).put("sName", paramTakeOrderEntity.getName()).put("sMobile", paramTakeOrderEntity.Im()).put("sAddress", paramTakeOrderEntity.getAddress()).put("sNote", paramTakeOrderEntity.getNote()).put("nTimestamp", paramTakeOrderEntity.getTimestamp()).put("bIsOurShop", 1).put("sTakeawayType", paramTakeOrderEntity.getType()).put("fRecevied", paramTakeOrderEntity.Iv()).put("sPayType", paramTakeOrderEntity.Iu()).put("sReason", "").toString();
    } catch (JSONException paramTakeOrderEntity) {
      a.e(paramTakeOrderEntity);
      return "";
    } 
  }
  
  @NonNull
  public HashMap<String, String> a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2) {
    HashMap hashMap = new HashMap();
    String str = (new aq(this.context)).c(this.context, paramBoolean1);
    hashMap.put("c", str);
    hashMap.put("id", paramString1);
    hashMap.put("type", paramString2);
    hashMap.put("version", "2");
    hashMap.put("client_type", this.context.getString(R.string.version_name));
    if (oJ(paramString3))
      hashMap.put("reason", paramString4); 
    hashMap.put("language", (this.context.getResources().getConfiguration()).locale.toString());
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("online order buildOrderOperationRequest. c is:");
    stringBuilder.append(str);
    stringBuilder.append(",id is:");
    stringBuilder.append(paramString1);
    stringBuilder.append(",type is:");
    stringBuilder.append(paramString2);
    stringBuilder.append(",client_type is:");
    stringBuilder.append(this.context.getString(R.string.version_name));
    stringBuilder.append(",language is:");
    stringBuilder.append((this.context.getResources().getConfiguration()).locale.toString());
    printStream.println(stringBuilder.toString());
    return hashMap;
  }
  
  @NonNull
  public HashMap<String, String> a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {
    null = new av(this.context);
    String str = null.Tx();
    null.close();
    HashMap hashMap = new HashMap();
    hashMap.put("c", (new aq(this.context)).c(this.context, paramBoolean2));
    hashMap.put("shopid", str);
    hashMap.put("page", "no");
    hashMap.put("language", (this.context.getResources().getConfiguration()).locale.toString());
    hashMap.put("client_type", this.context.getString(R.string.version_name));
    if (paramBoolean1) {
      if (!"null".equals(paramString1))
        hashMap.put("type", paramString1); 
      hashMap.put("status", paramString3);
      hashMap.put("date", paramString2);
    } 
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("online order buildOrderQueryRequest. status is ");
    stringBuilder.append(paramString3);
    stringBuilder.append(", date is:");
    stringBuilder.append(paramString2);
    stringBuilder.append(",type is:");
    stringBuilder.append(paramString1);
    printStream.println(stringBuilder.toString());
    return hashMap;
  }
  
  public void a(TakeOrderEntity paramTakeOrderEntity, boolean paramBoolean, v paramv) {
    int i = g(paramTakeOrderEntity);
    if (i == 0)
      try {
        paramv.a(null, null);
        return;
      } catch (JSONException paramTakeOrderEntity) {
        a.e(paramTakeOrderEntity);
        return;
      }  
    this.dtn.a(paramTakeOrderEntity, i, h(paramTakeOrderEntity), paramBoolean, a(paramTakeOrderEntity, paramBoolean), paramv, paramTakeOrderEntity.Iv(), by.parseLong(paramTakeOrderEntity.getSerialNumber()));
  }
  
  public void a(a parama) { this.dtn = parama; }
  
  public void a(ArrayList<String> paramArrayList, al.b paramb, int paramInt) { a.aKh().r(new an(this, paramArrayList, paramb, paramInt)); }
  
  public ArrayList<String> aE(ArrayList<ap> paramArrayList) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramArrayList.iterator();
    while (iterator.hasNext())
      arrayList.add(((ap)iterator.next()).getName()); 
    return arrayList;
  }
  
  public String aY(String paramString1, String paramString2) {
    if (paramString1.equals("") || (paramString1.equals("COD") && paramString2.equals("weixin")))
      return this.context.getString(R.string.weshop_payment_arrival_pay); 
    if (paramString1.equals("JSAPI"))
      return this.context.getString(R.string.pos_pay_weixin); 
    if (paramString1.equals("KOUBEI"))
      return this.context.getString(R.string.mainmenu_alipay_setting); 
    if (paramString1.equals("COD") && !paramString2.equals("weixin"))
      return this.context.getString(R.string.dialog_pay_money); 
    if (paramString1.equals("ONLINE"))
      return this.context.getString(R.string.print_content_online_pay); 
    paramString2 = paramString1;
    return paramString1.equals("VIP") ? this.context.getString(R.string.print_content_vip_pay) : paramString2;
  }
  
  public int aqA() {
    int i;
    av av = new av(this.context);
    if (aq.bz(this.context) == null) {
      i = 0;
    } else {
      i = 1;
    } 
    if (i == 1) {
      i = av.aqA() + av.aup();
    } else {
      i = av.aup();
    } 
    i += av.aur();
    av.close();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nRefundOrders:");
    stringBuilder.append(i);
    Log.e("nRefundOrders", stringBuilder.toString());
    return i;
  }
  
  public ArrayList<ap> aqB() {
    a a1 = new a(this.context);
    av av = new av(this.context);
    String str = av.Tx();
    av.close();
    ArrayList arrayList = a1.ko(str);
    a1.close();
    return arrayList;
  }
  
  public int aqC() {
    boolean bool1 = (new aq(this.context)).abV().Jq();
    null = aq.bz(this.context);
    int i = 0;
    if (null != null) {
      j = 1;
    } else {
      j = 0;
    } 
    av av = RootApplication.getLaiqianPreferenceManager();
    boolean bool2 = av.auW();
    if (j)
      i = 0 + av.aut() + av.aqA(); 
    int j = i;
    if (bool1)
      j = i + av.aun(); 
    i = j;
    if (bool2)
      i = j + av.aus(); 
    j = av.auu();
    int k = av.auo();
    int m = av.aup();
    int n = av.auv();
    av.close();
    return i + j + k + m + n;
  }
  
  public int aqz() {
    av av = new av(this.context);
    boolean bool1 = (new aq(this.context)).abV().Jq();
    HashMap hashMap = aq.bz(this.context);
    int i = 0;
    if (hashMap == null) {
      j = 0;
    } else {
      j = 1;
    } 
    boolean bool2 = av.auW();
    if (j) {
      i = 0 + av.aut();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("tdd");
      stringBuilder1.append(av.aut());
      bb.e("pending", stringBuilder1.toString());
    } 
    int j = i;
    if (bool1) {
      j = i + av.aun();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("wechat");
      stringBuilder1.append(av.aun());
      bb.e("pending", stringBuilder1.toString());
    } 
    i = j;
    if (bool2) {
      i = j + av.aus();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("koubei");
      stringBuilder1.append(av.aus());
      bb.e("pending", stringBuilder1.toString());
    } 
    j = i;
    if (a.zR().zV()) {
      j = i;
      if (a.AZ().BT()) {
        j = i + av.auv();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("phone");
        stringBuilder1.append(av.auv());
        bb.e("phone", stringBuilder1.toString());
      } 
    } 
    i = av.auu();
    int k = av.auo();
    int m = av.auv();
    int n = av.auq();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("eatin");
    stringBuilder.append(av.auu());
    bb.e("pending", stringBuilder.toString());
    av.close();
    return j + i + k + m + n;
  }
  
  public int g(TakeOrderEntity paramTakeOrderEntity) { return "weixin".equals(paramTakeOrderEntity.getType()) ? -1 : ("weixin_eat_in".equals(paramTakeOrderEntity.getType()) ? -2 : ("koubei".equals(paramTakeOrderEntity.getType()) ? -3 : 0)); }
  
  public ArrayList<z> h(TakeOrderEntity paramTakeOrderEntity) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual Iu : ()Ljava/lang/String;
    //   4: astore #4
    //   6: aload_1
    //   7: invokevirtual getType : ()Ljava/lang/String;
    //   10: astore #5
    //   12: new java/util/ArrayList
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore_3
    //   20: new com/laiqian/models/f
    //   23: dup
    //   24: aload_0
    //   25: getfield context : Landroid/content/Context;
    //   28: invokespecial <init> : (Landroid/content/Context;)V
    //   31: astore_2
    //   32: goto -> 47
    //   35: astore_2
    //   36: goto -> 41
    //   39: astore #6
    //   41: aload_2
    //   42: invokestatic e : (Ljava/lang/Throwable;)V
    //   45: aconst_null
    //   46: astore_2
    //   47: aload #4
    //   49: ldc ''
    //   51: invokevirtual equals : (Ljava/lang/Object;)Z
    //   54: ifne -> 266
    //   57: aload #4
    //   59: ldc_w 'COD'
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifeq -> 82
    //   68: aload #5
    //   70: ldc_w 'weixin'
    //   73: invokevirtual equals : (Ljava/lang/Object;)Z
    //   76: ifeq -> 82
    //   79: goto -> 266
    //   82: aload #4
    //   84: ldc_w 'JSAPI'
    //   87: invokevirtual equals : (Ljava/lang/Object;)Z
    //   90: ifeq -> 124
    //   93: ldc2_w 10009
    //   96: invokestatic ap : (J)Ljava/lang/String;
    //   99: astore #4
    //   101: new com/laiqian/entity/z
    //   104: dup
    //   105: sipush #10009
    //   108: aload_1
    //   109: invokevirtual Iv : ()D
    //   112: aload #4
    //   114: ldc2_w 6
    //   117: invokespecial <init> : (IDLjava/lang/String;J)V
    //   120: astore_1
    //   121: goto -> 294
    //   124: aload #4
    //   126: ldc_w 'KOUBEI'
    //   129: invokevirtual equals : (Ljava/lang/Object;)Z
    //   132: ifeq -> 166
    //   135: ldc2_w 10007
    //   138: invokestatic ap : (J)Ljava/lang/String;
    //   141: astore #4
    //   143: new com/laiqian/entity/z
    //   146: dup
    //   147: sipush #10007
    //   150: aload_1
    //   151: invokevirtual Iv : ()D
    //   154: aload #4
    //   156: ldc2_w 4
    //   159: invokespecial <init> : (IDLjava/lang/String;J)V
    //   162: astore_1
    //   163: goto -> 294
    //   166: aload #4
    //   168: ldc_w 'COD'
    //   171: invokevirtual equals : (Ljava/lang/Object;)Z
    //   174: ifeq -> 219
    //   177: aload #5
    //   179: ldc_w 'weixin'
    //   182: invokevirtual equals : (Ljava/lang/Object;)Z
    //   185: ifne -> 219
    //   188: ldc2_w 10001
    //   191: invokestatic ap : (J)Ljava/lang/String;
    //   194: astore #4
    //   196: new com/laiqian/entity/z
    //   199: dup
    //   200: sipush #10001
    //   203: aload_1
    //   204: invokevirtual Iv : ()D
    //   207: aload #4
    //   209: ldc2_w 3
    //   212: invokespecial <init> : (IDLjava/lang/String;J)V
    //   215: astore_1
    //   216: goto -> 294
    //   219: aload #4
    //   221: ldc_w 'VIP'
    //   224: invokevirtual equals : (Ljava/lang/Object;)Z
    //   227: ifeq -> 261
    //   230: ldc2_w 10006
    //   233: invokestatic ap : (J)Ljava/lang/String;
    //   236: astore #4
    //   238: new com/laiqian/entity/z
    //   241: dup
    //   242: sipush #10006
    //   245: aload_1
    //   246: invokevirtual Iv : ()D
    //   249: aload #4
    //   251: ldc2_w 9
    //   254: invokespecial <init> : (IDLjava/lang/String;J)V
    //   257: astore_1
    //   258: goto -> 294
    //   261: aconst_null
    //   262: astore_1
    //   263: goto -> 294
    //   266: ldc2_w 10001
    //   269: invokestatic ap : (J)Ljava/lang/String;
    //   272: astore #4
    //   274: new com/laiqian/entity/z
    //   277: dup
    //   278: sipush #10001
    //   281: aload_1
    //   282: invokevirtual Iv : ()D
    //   285: aload #4
    //   287: ldc2_w 3
    //   290: invokespecial <init> : (IDLjava/lang/String;J)V
    //   293: astore_1
    //   294: aload_3
    //   295: aload_1
    //   296: invokevirtual add : (Ljava/lang/Object;)Z
    //   299: pop
    //   300: aload_2
    //   301: invokevirtual close : ()V
    //   304: aload_3
    //   305: areturn
    // Exception table:
    //   from	to	target	type
    //   20	32	35	java/lang/Exception }
  
  public void i(TakeOrderEntity paramTakeOrderEntity) { (new bc(this.context)).j(paramTakeOrderEntity); }
  
  public ArrayList<TakeOrderEntity> j(String paramString, int paramInt1, int paramInt2) {
    ArrayList arrayList = new ArrayList();
    try {
      exception = new a(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Iterator iterator = exception.a(paramString, "1", true, paramInt1, paramInt2).iterator();
    while (iterator.hasNext())
      arrayList.add(exception.kB(((PendingFullOrderDetail.a)iterator.next()).orderNo)); 
    return arrayList;
  }
  
  public Map oB(String paramString) {
    try {
      exception = new a(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    return exception.aC("1", paramString);
  }
  
  public ArrayList<String> oC(String paramString) {
    ArrayList arrayList = new ArrayList();
    try {
      a a1 = new a(this.context);
      Iterator iterator = a1.aB("1", paramString).iterator();
      while (iterator.hasNext())
        arrayList.add(((PendingFullOrderDetail.a)iterator.next()).orderNo); 
      a1.close();
      return arrayList;
    } catch (Exception paramString) {
      a.e(paramString);
      return arrayList;
    } 
  }
  
  public ArrayList<TakeOrderEntity> oD(String paramString) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: fail exe a30 = a24\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n"); }
  
  public String[] oE(String paramString) {
    String[] arrayOfString = new String[3];
    if (paramString.equals("pending")) {
      arrayOfString[2] = (arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_pending)).valueOf(R.drawable.dotted_line_green)).valueOf(R.color.green_color_10500);
      return arrayOfString;
    } 
    if (paramString.equals("confirmed")) {
      arrayOfString[2] = (arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_confirmed)).valueOf(R.drawable.dotted_line_green)).valueOf(R.color.green_color_10500);
      return arrayOfString;
    } 
    if (paramString.equals("delivered")) {
      arrayOfString[2] = (arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_delivered)).valueOf(R.drawable.dotted_line_blue)).valueOf(R.color.text_color_text_blue);
      return arrayOfString;
    } 
    if (paramString.equals("refund") || paramString.equals("refused") || paramString.equals("closed")) {
      arrayOfString[2] = (arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_refund)).valueOf(R.drawable.dotted_line_gray)).valueOf(R.color.setting_text_color6);
      return arrayOfString;
    } 
    if (paramString.equals("successed")) {
      arrayOfString[2] = (arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_successed)).valueOf(R.drawable.dotted_line_gray)).valueOf(R.color.setting_text_color6);
      return arrayOfString;
    } 
    if (paramString.equals("refunding")) {
      arrayOfString[2] = (arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_refunding)).valueOf(R.drawable.dotted_line_red)).valueOf(R.color.red_color_1033);
      return arrayOfString;
    } 
    arrayOfString[2] = (arrayOfString[1] = (arrayOfString[0] = "").valueOf(R.drawable.dotted_line_gray)).valueOf(R.color.setting_text_color6);
    return arrayOfString;
  }
  
  public String[] oF(String paramString) {
    String[] arrayOfString = new String[1];
    if (paramString.equals("weixin_eat_in") || paramString.equals("koubei")) {
      arrayOfString[0] = this.context.getString(R.string.takeout_table_number);
      return arrayOfString;
    } 
    arrayOfString[0] = this.context.getString(R.string.takeout_distribution_address);
    return arrayOfString;
  }
  
  public boolean oJ(String paramString) { return paramString.equals("refuse"); }
  
  public boolean oK(String paramString) {
    try {
      return (new JSONObject(paramString)).getString("status").equals("true");
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public boolean oL(String paramString) { return paramString.equals("wxrefund"); }
  
  public boolean oM(String paramString) { return paramString.equals("confirm"); }
  
  public void oN(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (jSONObject.optString("status").equals("true"))
        return; 
      if (!TextUtils.isEmpty(jSONObject.optString("info"))) {
        Toast.makeText(this.context, jSONObject.optString("info"), 0).show();
        return;
      } 
    } catch (JSONException paramString) {
      a.e(paramString);
    } 
  }
  
  public String[] s(String paramString, long paramLong) {
    String[] arrayOfString = new String[2];
    if (paramString.equals("weixin")) {
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_weixing)).valueOf(R.color.green_color_10500);
      return arrayOfString;
    } 
    if (paramString.equals("tao")) {
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_tao)).valueOf(R.color.green_color_10500);
      return arrayOfString;
    } 
    if (paramString.equals("order")) {
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_koubei)).valueOf(R.color.green_color_10500);
      return arrayOfString;
    } 
    if (paramString.equals("meituan")) {
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_meituan)).valueOf(R.color.red_color_1033);
      return arrayOfString;
    } 
    if (paramString.equals("phone_order")) {
      if (paramLong == 0L) {
        arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_phone_d)).valueOf(R.color.text_color_text_blue);
        return arrayOfString;
      } 
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_phone_t)).valueOf(R.color.text_color_text_blue);
      return arrayOfString;
    } 
    if (paramString.equals("weixin_eat_in")) {
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_koubei)).valueOf(R.color.text_color_text_blue);
      return arrayOfString;
    } 
    if (paramString.equals("koubei")) {
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_koubei)).valueOf(R.color.text_color_text_blue);
      return arrayOfString;
    } 
    if (paramString.equals("eleme")) {
      arrayOfString[1] = (arrayOfString[0] = this.context.getString(R.string.takeout_eleme)).valueOf(R.color.green_color_10500);
      return arrayOfString;
    } 
    arrayOfString[1] = (arrayOfString[0] = "未知").valueOf(R.color.green_color_10500);
    return arrayOfString;
  }
  
  static interface a {
    void a(TakeOrderEntity param1TakeOrderEntity, int param1Int, ArrayList<z> param1ArrayList, boolean param1Boolean, String param1String, v param1v, double param1Double, long param1Long);
    
    void a(PendingFullOrderDetail param1PendingFullOrderDetail, int param1Int, ArrayList<z> param1ArrayList, v param1v, double param1Double);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */