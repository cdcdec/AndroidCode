package com.laiqian.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.ab;
import com.laiqian.models.at;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.pos.PayTypeSpecific.AlipayCode;
import com.laiqian.pos.PayTypeSpecific.WechatCode;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static a aKD;
  
  private final JSONObject aKE = new JSONObject();
  
  private final String aKF = "TableNOFunction";
  
  private final String aKG = "AutoMakeBarcodeFunction";
  
  private final String aKH = "SameProductBranchDisplayFunction";
  
  private final String aKI = "BarcodeUploadFunction";
  
  private final String aKJ = "OpenTableSelectConnection";
  
  private final String aKK = "OrderDishesClient";
  
  private final String aKL = "NumberOfDecimals";
  
  private final String aKM = "FirstCategoryLines";
  
  private final String aKN = "GoodsSorting";
  
  private final String aKO = "PendingOrderPrint";
  
  private final String aKP = "PendingOrderTagPrint";
  
  private final String aKQ = "OpenTable";
  
  private final String aKR = "OpenTablePrint";
  
  private final String aKS = "shiftReportPrint";
  
  private final String aKT = "isProductCodeOpen";
  
  private final String aKU = "isMemberAutoUpgrade";
  
  private final String aKV = "isMemberUpgradeRule";
  
  private final String aKW = "isMemberAmountAllowMinus";
  
  private final String aKX = "isMemberDiscountOpen";
  
  private final String aKY = "memberDiscountValue";
  
  private final String aKZ = "multishopMemberLevelsValue";
  
  private final String aLA = "meituanTuangou";
  
  private final String aLB = "meituanTuangouToken";
  
  private final String aLC = "barcodeMark";
  
  private final String aLD = "amountDecimal";
  
  private final String aLE = "weightDecimal";
  
  private final String aLF = "isRounding05";
  
  private final String aLG = "isBillNumberModeClose";
  
  private final JSONObject aLH = new JSONObject();
  
  private final String aLI = "isAllowOwnDiet";
  
  private final String aLJ = "hasRawMaterial";
  
  private final String aLK = "rawMaterialStockWarning";
  
  private final String aLL = "phonePrintSize";
  
  private final String aLM = "businessHours";
  
  private final String aLN = "isOpenSMSNotice";
  
  private final String aLO = "smsDiscountCode";
  
  private final String aLP = "messagePushIndividualCode";
  
  private final String aLQ = "messagePushCompanyCode";
  
  private final String aLR = "isMemberConsumeNoticed";
  
  private final String aLS = "isMemberChargeNoticed";
  
  private final String aLT = "isWeixinVerifyNoticed";
  
  private final String aLU = "SweepCodePaymentTimeOut";
  
  private final String aLV = "ServiceChargeAmount";
  
  private final String aLW = "ServiceChargeTax";
  
  private final String aLX = "ServiceChargeTaxName";
  
  private final String aLY = "ServiceChargeEnable";
  
  private final String aLZ = "PrintTaxName";
  
  private final String aLa = "memberCardName";
  
  private final String aLb = "isMemberrOperationOpen";
  
  private final String aLc = "isMemberPointOpen";
  
  private final String aLd = "pointAccumulativeRule";
  
  private final String aLe = "isMemberPointDeductionOpen";
  
  private final String aLf = "memberPointDeduction";
  
  private final String aLg = "isMemberCardOnlyAllowed";
  
  private final String aLh = "isAutoConfirmMeituan";
  
  private final String aLi = "isAutoConfirmEleme";
  
  private final String aLj = "isAutoConfirmSelforder";
  
  private final String aLk = "isAutoConfirmWeixinTakeawayOrder";
  
  private final String aLl = "isDefaultOrderType";
  
  private final String aLm = "defaultDiscount";
  
  private final String aLn = "alipayCode";
  
  private final String aLo = "alipayChannelID";
  
  private final String aLp = "wechatCode";
  
  private final String aLq = "wechatChannelID";
  
  private final String aLr = "isQueryProductOpen";
  
  private final String aLs = "jsonKeyRetailQueryProduct";
  
  private final String aLt = "isWeighOpen";
  
  private final String aLu = "isPosScaleOpen";
  
  private final String aLv = "isBarcodeScaleOpen";
  
  private final String aLw = "openBarcodeScaleType";
  
  private final String aLx = "formatBarcode";
  
  private final String aLy = "weightUnit";
  
  private final String aLz = "tuangouShopName";
  
  private final String aMa = "OrderTelephoneClient";
  
  private final String aMb = "isSelectGeTui";
  
  private final String aMc = "isSelectRedis";
  
  private final String aMd = "VipCreditLimit";
  
  private final String aMe = "NegativeStockOn";
  
  private final String aMf = "PayMessagePrint";
  
  private final String aMg = "AutoConfirmScanOrder";
  
  private final String aMh = "AdditionalFees";
  
  private final String aMi = "LANServerIP";
  
  private final String aMj = "isScanMode";
  
  private final String aMk = "shoppingGuide";
  
  private final String aMl = "itemNumber";
  
  private final String aMm = "jsonKeyPlu";
  
  private final String aMn = "jsonKeyHotKey";
  
  private final String aMo = "jsonKeyHandScale";
  
  private final String aMp = "jsonKeyShiftReceiptPrint";
  
  private final String aMq = "jsonKeyTransferDiscountSetting";
  
  private final String aMr = "jsonKeyNeglectSmallChangesSwitch";
  
  public final int aMs = -1;
  
  public final int aMt = 0;
  
  public final int aMu = 1;
  
  private final String aMv = "openDaHuaBarcodeScale";
  
  private final String aMw = "openUShengBarcodeScale";
  
  private final String aMx = "scanorderMenuStyle";
  
  private final String aMy = "memberGiftMode";
  
  private final String aMz = "openMiniProgramsSwitch";
  
  private a() { Ba(); }
  
  public static a AZ() {
    if (aKD == null)
      aKD = new a(); 
    return aKD;
  }
  
  private boolean a(at paramat) {
    boolean bool1;
    try {
      byte b2;
      av av = RootApplication.getLaiqianPreferenceManager();
      if (!this.aKE.has("TableNOFunction")) {
        boolean bool;
        JSONObject jSONObject = this.aKE;
        if (av.atI() > 0) {
          bool = true;
        } else {
          bool = false;
        } 
        jSONObject.put("TableNOFunction", bool);
        b2 = 1;
      } else {
        b2 = 0;
      } 
      byte b1 = b2;
      bool1 = b2;
      try {
        if (!this.aKE.has("OrderDishesClient")) {
          bool1 = b2;
          this.aKE.put("OrderDishesClient", av.avb());
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("NumberOfDecimals")) {
          bool1 = b1;
          this.aKE.put("NumberOfDecimals", av.atu());
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("FirstCategoryLines")) {
          bool1 = b2;
          this.aKE.put("FirstCategoryLines", av.Bf());
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("GoodsSorting")) {
          bool1 = b1;
          this.aKE.put("GoodsSorting", av.aud());
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("PendingOrderPrint")) {
          bool1 = b2;
          this.aKE.put("PendingOrderPrint", paramat.em(false));
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("shiftReportPrint")) {
          bool1 = b1;
          this.aKE.put("shiftReportPrint", false);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("isProductCodeOpen")) {
          bool1 = b2;
          this.aKE.put("isProductCodeOpen", paramat.Wn());
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("isMemberAutoUpgrade")) {
          bool1 = b1;
          this.aKE.put("isMemberAutoUpgrade", false);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("isMemberAmountAllowMinus")) {
          bool1 = b2;
          this.aKE.put("isMemberAmountAllowMinus", paramat.Wf());
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("isMemberDiscountOpen")) {
          bool1 = b1;
          this.aKE.put("isMemberDiscountOpen", paramat.p(75, true));
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("isMemberPointDeductionOpen")) {
          bool1 = b2;
          this.aKE.put("isMemberPointDeductionOpen", paramat.Wh());
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("memberPointDeduction")) {
          bool1 = b1;
          this.aKE.put("memberPointDeduction", 100);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("isMemberCardOnlyAllowed")) {
          bool1 = b2;
          this.aKE.put("isMemberCardOnlyAllowed", false);
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("defaultDiscount")) {
          bool1 = b1;
          this.aKE.put("defaultDiscount", 100);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("isOpenSMSNotice")) {
          bool1 = b2;
          this.aKE.put("isOpenSMSNotice", false);
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("isMemberConsumeNoticed")) {
          bool1 = b1;
          this.aKE.put("isMemberConsumeNoticed", false);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("isMemberChargeNoticed")) {
          bool1 = b2;
          this.aKE.put("isMemberChargeNoticed", false);
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("isWeixinVerifyNoticed")) {
          bool1 = b1;
          this.aKE.put("isWeixinVerifyNoticed", false);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("alipayCode")) {
          bool1 = b2;
          this.aKE.put("alipayCode", av.Bo());
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("wechatCode")) {
          bool1 = b1;
          this.aKE.put("wechatCode", av.Bq());
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("weightUnit")) {
          bool1 = b2;
          this.aKE.put("weightUnit", "kg");
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("NegativeStockOn")) {
          bool1 = b1;
          this.aKE.put("NegativeStockOn", true);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("isScanMode")) {
          bool1 = b2;
          this.aKE.put("isScanMode", 1);
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("shoppingGuide")) {
          bool1 = b1;
          this.aKE.put("shoppingGuide", true);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("itemNumber")) {
          bool1 = b2;
          this.aKE.put("itemNumber", 10000);
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("jsonKeyPlu")) {
          bool1 = b1;
          this.aKE.put("jsonKeyPlu", 100);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("jsonKeyHotKey")) {
          bool1 = b2;
          this.aKE.put("jsonKeyHotKey", 1);
          b1 = 1;
        } 
        b2 = b1;
        bool1 = b1;
        if (!this.aKE.has("jsonKeyHandScale")) {
          bool1 = b1;
          this.aKE.put("jsonKeyHandScale", false);
          b2 = 1;
        } 
        b1 = b2;
        bool1 = b2;
        if (!this.aKE.has("jsonKeyShiftReceiptPrint")) {
          bool1 = b2;
          this.aKE.put("jsonKeyShiftReceiptPrint", true);
          b1 = 1;
        } 
        bool1 = b1;
        b2 = b1;
        if (!this.aKE.has("jsonKeyTransferDiscountSetting")) {
          bool1 = b1;
          this.aKE.put("jsonKeyTransferDiscountSetting", false);
          return true;
        } 
      } catch (JSONException paramat) {}
    } catch (JSONException paramat) {
      bool1 = false;
    } 
    a.e(paramat);
    boolean bool2 = bool1;
  }
  
  private void b(at paramat) {
    try {
      this.aLH.put("isAllowOwnDiet", paramat.BN());
      if (!BN()) {
        ab ab = new ab(RootApplication.zv());
        this.aLH.put("hasRawMaterial", ab.Vf());
        a(ab);
        ab.close();
      } else {
        this.aLH.put("hasRawMaterial", false);
        BP();
      } 
      RootApplication.getLaiqianPreferenceManager().hN(paramat.Wq());
      return;
    } catch (Exception paramat) {
      a.e(paramat);
      return;
    } 
  }
  
  private void bP(String paramString) { d("GoodsSorting", paramString); }
  
  private boolean c(at paramat) {
    if (paramat == null) {
      paramat = new at(RootApplication.zv());
      boolean bool = paramat.io(this.aKE.toString());
      paramat.close();
      return bool;
    } 
    return paramat.io(this.aKE.toString());
  }
  
  private boolean d(String paramString, Object paramObject) {
    try {
      this.aKE.put(paramString, paramObject);
      return c(null);
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public double BA() { return this.aKE.optDouble("memberDiscountValue", 100.0D); }
  
  public boolean BB() { return this.aKE.optBoolean("isMemberPointDeductionOpen"); }
  
  public int BC() { return this.aKE.optInt("memberPointDeduction"); }
  
  public boolean BD() { return this.aKE.optBoolean("isQueryProductOpen", false); }
  
  public boolean BE() { return this.aKE.optBoolean("isWeighOpen", false); }
  
  public boolean BF() { return this.aKE.optBoolean("isPosScaleOpen", false); }
  
  public boolean BG() { return this.aKE.optBoolean("isBarcodeScaleOpen", false); }
  
  public String BH() { return this.aKE.optString("tuangouShopName", ""); }
  
  public String BI() { return this.aKE.optString("meituanTuangouToken", ""); }
  
  public boolean BJ() { return this.aKE.optBoolean("meituanTuangou", false); }
  
  public boolean BK() { return this.aKE.optBoolean("isRounding05", false); }
  
  public boolean BL() { return this.aKE.optBoolean("isBillNumberModeClose", false); }
  
  public String BM() { return this.aKE.toString(); }
  
  public boolean BN() { return this.aLH.optBoolean("isAllowOwnDiet", true); }
  
  public boolean BO() { return this.aLH.optBoolean("hasRawMaterial"); }
  
  public void BP() {
    try {
      this.aLH.put("rawMaterialStockWarning", false);
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  public String BQ() { return this.aKE.optString("smsDiscountCode", "0"); }
  
  public long BR() { return this.aKE.optLong("messagePushIndividualCode", -1L); }
  
  public long BS() { return this.aKE.optLong("messagePushCompanyCode", -1L); }
  
  public boolean BT() { return this.aKE.optBoolean("OrderTelephoneClient", true); }
  
  public boolean BU() { return this.aKE.optBoolean("ServiceChargeEnable", true); }
  
  public boolean BV() { return this.aKE.optBoolean("PrintTaxName", true); }
  
  public double BW() { return this.aKE.optDouble("ServiceChargeAmount", 0.0D); }
  
  public String BX() { return this.aKE.optString("ServiceChargeTax", ""); }
  
  public String BY() { return this.aKE.optString("ServiceChargeTaxName", ""); }
  
  public boolean BZ() { return this.aKE.optBoolean("isSelectGeTui", true); }
  
  public void Ba() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield aKE : Lorg/json/JSONObject;
    //   6: invokevirtual keys : ()Ljava/util/Iterator;
    //   9: astore_2
    //   10: aload_2
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 35
    //   19: aload_2
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: pop
    //   26: aload_2
    //   27: invokeinterface remove : ()V
    //   32: goto -> 10
    //   35: new com/laiqian/models/at
    //   38: dup
    //   39: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   42: invokespecial <init> : (Landroid/content/Context;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual Wm : ()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   55: istore_1
    //   56: iload_1
    //   57: ifne -> 156
    //   60: new org/json/JSONObject
    //   63: dup
    //   64: aload_3
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual keys : ()Ljava/util/Iterator;
    //   73: astore #4
    //   75: aload #4
    //   77: invokeinterface hasNext : ()Z
    //   82: ifeq -> 116
    //   85: aload #4
    //   87: invokeinterface next : ()Ljava/lang/Object;
    //   92: checkcast java/lang/String
    //   95: astore #5
    //   97: aload_0
    //   98: getfield aKE : Lorg/json/JSONObject;
    //   101: aload #5
    //   103: aload_3
    //   104: aload #5
    //   106: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   109: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: goto -> 75
    //   116: new java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial <init> : ()V
    //   123: astore_3
    //   124: aload_3
    //   125: ldc_w '取出数据库后的配置：'
    //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_3
    //   133: aload_0
    //   134: getfield aKE : Lorg/json/JSONObject;
    //   137: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: invokestatic println : (Ljava/lang/Object;)V
    //   148: goto -> 156
    //   151: astore_3
    //   152: aload_3
    //   153: invokestatic e : (Ljava/lang/Throwable;)V
    //   156: aload_0
    //   157: aload_2
    //   158: invokespecial a : (Lcom/laiqian/models/at;)Z
    //   161: ifeq -> 202
    //   164: new java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial <init> : ()V
    //   171: astore_3
    //   172: aload_3
    //   173: ldc_w '放入缺少值后的配置：'
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: aload_0
    //   182: getfield aKE : Lorg/json/JSONObject;
    //   185: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_3
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: invokestatic println : (Ljava/lang/Object;)V
    //   196: aload_0
    //   197: aload_2
    //   198: invokespecial c : (Lcom/laiqian/models/at;)Z
    //   201: pop
    //   202: aload_0
    //   203: aload_2
    //   204: invokespecial b : (Lcom/laiqian/models/at;)V
    //   207: aload_2
    //   208: invokevirtual close : ()V
    //   211: aload_0
    //   212: invokevirtual Be : ()I
    //   215: putstatic com/laiqian/basic/RootApplication.aIQ : I
    //   218: aload_0
    //   219: monitorexit
    //   220: return
    //   221: astore_2
    //   222: aload_0
    //   223: monitorexit
    //   224: aload_2
    //   225: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	221	finally
    //   10	32	221	finally
    //   35	56	221	finally
    //   60	75	151	java/lang/Exception
    //   60	75	221	finally
    //   75	113	151	java/lang/Exception
    //   75	113	221	finally
    //   116	148	151	java/lang/Exception
    //   116	148	221	finally
    //   152	156	221	finally
    //   156	202	221	finally
    //   202	218	221	finally }
  
  public boolean Bb() { return this.aKE.optBoolean("shiftReportPrint"); }
  
  public boolean Bc() { return this.aKE.optBoolean("TableNOFunction"); }
  
  public boolean Bd() { return true; }
  
  public int Be() { return a.zR().Ab() ? this.aKE.optInt("NumberOfDecimals", 2) : this.aKE.optInt("NumberOfDecimals", 1); }
  
  public int Bf() { return this.aKE.optInt("FirstCategoryLines", 1); }
  
  public int Bg() {
    String[] arrayOfString = RootApplication.zv().getResources().getStringArray(R.array.pos_mainsetting_product_sort_field);
    String str = Bh();
    for (byte b = 0; b < arrayOfString.length; b++) {
      if (arrayOfString[b].equals(str))
        return b; 
    } 
    return 0;
  }
  
  public String Bh() { return this.aKE.optString("GoodsSorting"); }
  
  public boolean Bi() { return this.aKE.optBoolean("PendingOrderPrint"); }
  
  public boolean Bj() { return this.aKE.optBoolean("PendingOrderTagPrint", true); }
  
  public boolean Bk() { return this.aKE.optBoolean("OpenTable", false); }
  
  public boolean Bl() { return (RootApplication.getLaiqianPreferenceManager().avL() == 0) ? this.aKE.optBoolean("OpenTablePrint", false) : 1; }
  
  public boolean Bm() { return this.aKE.optBoolean("isProductCodeOpen"); }
  
  public double Bn() { return this.aKE.optDouble("defaultDiscount"); }
  
  @AlipayCode
  public int Bo() {
    if (RootApplication.getLaiqianPreferenceManager().FC() != null) {
      int i = this.aKE.optInt("alipayCode", -1);
      for (int j : PayTypeSpecific.AlipayCode.values) {
        if (i == j)
          return j; 
      } 
    } 
    return 2;
  }
  
  public String Bp() { return this.aKE.optString("alipayChannelID", ""); }
  
  @WechatCode
  public int Bq() {
    if (RootApplication.getLaiqianPreferenceManager().FD() != null) {
      int i = this.aKE.optInt("wechatCode", -1);
      for (int j : PayTypeSpecific.WechatCode.values) {
        if (i == j)
          return j; 
      } 
    } 
    return 7;
  }
  
  public String Br() { return this.aKE.optString("wechatChannelID", "5"); }
  
  public boolean Bs() { return this.aKE.optBoolean("isMemberAutoUpgrade"); }
  
  public String Bt() { return this.aKE.optString("isMemberUpgradeRule", ""); }
  
  public boolean Bu() { return this.aKE.optBoolean("isMemberAmountAllowMinus"); }
  
  public double Bv() { return this.aKE.optDouble("VipCreditLimit", -1.0D); }
  
  public boolean Bw() { return this.aKE.optBoolean("isMemberCardOnlyAllowed"); }
  
  public boolean Bx() {
    boolean bool;
    if (LQKVersion.zl() && (a.zR().Ad() || a.zR().Ab())) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool ? false : this.aKE.optBoolean("isMemberDiscountOpen");
  }
  
  public boolean By() {
    if (RootApplication.getLaiqianPreferenceManager().isMultipleShop())
      return false; 
    at at = new at(RootApplication.zv());
    boolean bool = at.Wp();
    at.close();
    return bool;
  }
  
  public List<Long> Bz() throws JSONException {
    ArrayList arrayList = new ArrayList();
    String str = this.aKE.optString("multishopMemberLevelsValue", "");
    if (!TextUtils.isEmpty(str)) {
      JSONArray jSONArray = (new JSONObject(str)).optJSONArray("memberLevels");
      for (byte b = 0; b < jSONArray.length(); b++)
        arrayList.add(Long.valueOf(jSONArray.optLong(b))); 
    } 
    return arrayList;
  }
  
  public boolean CA() { return this.aKE.optBoolean("openMiniProgramsSwitch", false); }
  
  public String CB() { return this.aKE.optString("jsonKeyNeglectSmallChangesSwitch", "{\"neglectSwitch\":\"false\",\"neglectSmallYuan\":\"false\",\"neglectSmallJiao\":\"true\",\"roundSmallYuan\":\"false\",\"roundSmallJiao\":\"false\"}"); }
  
  public boolean CC() {
    str = CB();
    try {
      return (new JSONObject(str)).optBoolean("neglectSwitch", false);
    } catch (JSONException str) {
      a.e(str);
      return false;
    } 
  }
  
  public int Ca() { return this.aKE.optInt("OpenTableSelectConnection", 1); }
  
  public int Cb() { return this.aKE.optInt("phonePrintSize", 1); }
  
  public String Cc() { return this.aKE.optString("businessHours", "00:00-23:59"); }
  
  public boolean Cd() { return this.aKE.optBoolean("isMemberPointOpen", true); }
  
  public Pair<Double, Double> Ce() {
    String[] arrayOfString = this.aKE.optString("pointAccumulativeRule", "1,1").split(",");
    return new Pair(Double.valueOf(Double.parseDouble(arrayOfString[0])), Double.valueOf(Double.parseDouble(arrayOfString[1])));
  }
  
  public boolean Cf() { return this.aKE.optBoolean("isAutoConfirmMeituan"); }
  
  public boolean Cg() { return this.aKE.optBoolean("isAutoConfirmEleme"); }
  
  public boolean Ch() { return this.aKE.optBoolean("isAutoConfirmSelforder"); }
  
  public boolean Ci() { return this.aKE.optBoolean("isAutoConfirmWeixinTakeawayOrder"); }
  
  public boolean Cj() {
    av av = new av(RootApplication.zv());
    null = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", null);
    hashMap.put("password", str2);
    hashMap.put("auth_type", "0");
    hashMap.put("shop_id", str3);
    hashMap.put("version", "1");
    hashMap.put("lqk_config", (null = aKD).AZ().BM());
    str1 = bh.a(RootUrlParameter.clO, RootApplication.zv(), hashMap);
    if (!TextUtils.isEmpty(str1))
      try {
        boolean bool = "true".equals((new JSONObject(str1)).optString("result", "false"));
        return bool;
      } catch (Exception str1) {
        return false;
      }  
    return false;
  }
  
  public String Ck() { return this.aKE.optString("LANServerIP", ""); }
  
  public boolean Cl() { return this.aKE.optBoolean("PayMessagePrint", true); }
  
  public boolean Cm() { return this.aKE.optBoolean("AutoConfirmScanOrder", false); }
  
  public String Cn() { return this.aKE.optString("AdditionalFees", null); }
  
  public long Co() { return this.aKE.optLong("isDefaultOrderType", 86003L); }
  
  public int Cp() { return this.aKE.optInt("attributePriceRule", 0); }
  
  public boolean Cq() { return this.aKE.optBoolean("PRODUCT_MERGE_ENABLED", false); }
  
  public long Cr() { return this.aKE.optLong("SweepCodePaymentTimeOut", 5L); }
  
  public boolean Cs() { return this.aKE.optBoolean("openWeight2Quantity", false); }
  
  public boolean Ct() { return this.aKE.optBoolean("openQueuingMachine", false); }
  
  public boolean Cu() { return this.aKE.optBoolean("isFirstEnterQueuingMachineSetting", true); }
  
  public boolean Cv() { return this.aKE.optBoolean("isOpenTableTimeCalculation", false); }
  
  public boolean Cw() { return this.aKE.optBoolean("isOpenTableTimeCalculationFirstRule", true); }
  
  public String Cx() { return this.aKE.optString("defaultTableCost", "0"); }
  
  public int Cy() { return this.aKE.optInt("scanorderMenuStyle", 0); }
  
  public String Cz() { return this.aKE.optString("memberGiftMode", ""); }
  
  public String P(Context paramContext) { return this.aKE.optString("memberCardName", paramContext.getString(R.string.pos_vip_card)); }
  
  public boolean Q(long paramLong) { return d("isDefaultOrderType", Long.valueOf(paramLong)); }
  
  public boolean Q(Context paramContext) {
    str1 = (new av(paramContext)).Ea();
    null = this.aKE;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{\"");
    stringBuilder.append(str1);
    stringBuilder.append("\":\"true\"}");
    String str2 = null.optString("isFirstChoseAutoWeightingProduct", stringBuilder.toString());
    try {
      return (new JSONObject(str2)).optBoolean(str1);
    } catch (JSONException str1) {
      a.e(str1);
      return true;
    } 
  }
  
  public void R(Context paramContext) {
    if (Q(paramContext)) {
      str = (new av(paramContext)).Ea();
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put(str, false);
        d("isFirstChoseAutoWeightingProduct", jSONObject.toString());
        return;
      } catch (JSONException str) {
        a.e(str);
      } 
    } 
  }
  
  public boolean R(long paramLong) { return d("SweepCodePaymentTimeOut", Long.valueOf(paramLong)); }
  
  public void a(ab paramab) {
    if (paramab == null)
      try {
        paramab = new ab(RootApplication.zv());
        this.aLH.put("rawMaterialStockWarning", paramab.Vg());
        paramab.close();
        return;
      } catch (JSONException paramab) {
        a.e(paramab);
        return;
      }  
    this.aLH.put("rawMaterialStockWarning", paramab.Vg());
  }
  
  public boolean a(Pair<Double, Double> paramPair) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramPair.first);
    stringBuilder.append(",");
    stringBuilder.append(paramPair.second);
    return d("pointAccumulativeRule", stringBuilder.toString());
  }
  
  public void bE(boolean paramBoolean) { d("shiftReportPrint", Boolean.valueOf(paramBoolean)); }
  
  public void bF(boolean paramBoolean) { d("TableNOFunction", Boolean.valueOf(paramBoolean)); }
  
  public void bG(boolean paramBoolean) { d("OrderDishesClient", Boolean.valueOf(paramBoolean)); }
  
  public void bH(boolean paramBoolean) { d("PendingOrderPrint", Boolean.valueOf(paramBoolean)); }
  
  public void bI(boolean paramBoolean) { d("PendingOrderTagPrint", Boolean.valueOf(paramBoolean)); }
  
  public void bJ(boolean paramBoolean) { d("OpenTable", Boolean.valueOf(paramBoolean)); }
  
  public void bK(boolean paramBoolean) { d("OpenTablePrint", Boolean.valueOf(paramBoolean)); }
  
  public void bL(boolean paramBoolean) { d("isProductCodeOpen", Boolean.valueOf(paramBoolean)); }
  
  public void bM(boolean paramBoolean) { d("isMemberAutoUpgrade", Boolean.valueOf(paramBoolean)); }
  
  public boolean bN(boolean paramBoolean) { return d("isMemberAmountAllowMinus", Boolean.valueOf(paramBoolean)); }
  
  public boolean bO(boolean paramBoolean) { return d("isMemberCardOnlyAllowed", Boolean.valueOf(paramBoolean)); }
  
  public boolean bP(boolean paramBoolean) { return d("isMemberDiscountOpen", Boolean.valueOf(paramBoolean)); }
  
  public boolean bQ(String paramString) { return d("alipayChannelID", paramString); }
  
  public boolean bQ(boolean paramBoolean) {
    if (RootApplication.getLaiqianPreferenceManager().isMultipleShop())
      return true; 
    if (paramBoolean) {
      at at1 = new at(RootApplication.zv());
      at1.ep(true);
      at1.close();
    } 
    if (!paramBoolean) {
      at at1 = new at(RootApplication.zv());
      at1.ep(false);
      at1.close();
    } 
    at at = new at(RootApplication.zv());
    paramBoolean = at.eo(paramBoolean);
    at.close();
    return paramBoolean;
  }
  
  public boolean bR(String paramString) { return d("wechatChannelID", paramString); }
  
  public boolean bR(boolean paramBoolean) { return d("isMemberPointDeductionOpen", Boolean.valueOf(paramBoolean)); }
  
  public void bS(String paramString) { d("isMemberUpgradeRule", paramString); }
  
  public boolean bS(boolean paramBoolean) { return d("isQueryProductOpen", Boolean.valueOf(paramBoolean)); }
  
  public boolean bT(String paramString) { return d("multishopMemberLevelsValue", paramString); }
  
  public boolean bT(boolean paramBoolean) { return d("isWeighOpen", Boolean.valueOf(paramBoolean)); }
  
  public void bU(String paramString) { d("memberCardName", paramString); }
  
  public boolean bU(boolean paramBoolean) { return d("isPosScaleOpen", Boolean.valueOf(paramBoolean)); }
  
  public Boolean bV(String paramString) { return Boolean.valueOf(d("tuangouShopName", paramString)); }
  
  public Boolean bV(boolean paramBoolean) { return Boolean.valueOf(d("meituanTuangou", Boolean.valueOf(paramBoolean))); }
  
  public Boolean bW(String paramString) { return Boolean.valueOf(d("meituanTuangouToken", paramString)); }
  
  public boolean bW(boolean paramBoolean) { return d("isRounding05", Boolean.valueOf(paramBoolean)); }
  
  public void bX(String paramString) { d("smsDiscountCode", paramString); }
  
  public boolean bX(boolean paramBoolean) { return d("isBillNumberModeClose", Boolean.valueOf(paramBoolean)); }
  
  public void bY(String paramString) { d("messagePushIndividualCode", paramString); }
  
  public void bY(boolean paramBoolean) { d("OrderTelephoneClient", Boolean.valueOf(paramBoolean)); }
  
  public void bZ(String paramString) { d("messagePushCompanyCode", paramString); }
  
  public void bZ(boolean paramBoolean) { d("ServiceChargeEnable", Boolean.valueOf(paramBoolean)); }
  
  public void ca(String paramString) { d("ServiceChargeTax", paramString); }
  
  public void ca(boolean paramBoolean) { d("PrintTaxName", Boolean.valueOf(paramBoolean)); }
  
  public void cb(String paramString) { d("ServiceChargeTaxName", paramString); }
  
  public void cb(boolean paramBoolean) { d("isSelectGeTui", Boolean.valueOf(paramBoolean)); }
  
  public void cc(String paramString) { d("businessHours", paramString); }
  
  public void cc(boolean paramBoolean) { d("isSelectRedis", Boolean.valueOf(paramBoolean)); }
  
  public boolean cd(String paramString) { return d("AdditionalFees", paramString); }
  
  public boolean cd(boolean paramBoolean) { return d("isMemberPointOpen", Boolean.valueOf(paramBoolean)); }
  
  public boolean ce(String paramString) { return d("LANServerIP", paramString); }
  
  public boolean ce(boolean paramBoolean) { return d("isAutoConfirmMeituan", Boolean.valueOf(paramBoolean)); }
  
  public void cf(String paramString) { d("defaultTableCost", paramString); }
  
  public boolean cf(boolean paramBoolean) { return d("isAutoConfirmEleme", Boolean.valueOf(paramBoolean)); }
  
  public boolean cg(String paramString) { return d("memberGiftMode", paramString); }
  
  public boolean cg(boolean paramBoolean) { return d("isAutoConfirmSelforder", Boolean.valueOf(paramBoolean)); }
  
  public boolean ch(String paramString) { return d("jsonKeyNeglectSmallChangesSwitch", paramString); }
  
  public boolean ch(boolean paramBoolean) { return d("isAutoConfirmWeixinTakeawayOrder", Boolean.valueOf(paramBoolean)); }
  
  public boolean ci(boolean paramBoolean) { return d("PayMessagePrint", Boolean.valueOf(paramBoolean)); }
  
  public boolean cj(boolean paramBoolean) { return d("AutoConfirmScanOrder", Boolean.valueOf(paramBoolean)); }
  
  public void ck(boolean paramBoolean) { d("PRODUCT_MERGE_ENABLED", Boolean.valueOf(paramBoolean)); }
  
  public void cl(boolean paramBoolean) { d("openWeight2Quantity", Boolean.valueOf(paramBoolean)); }
  
  public void cm(boolean paramBoolean) { d("openQueuingMachine", Boolean.valueOf(paramBoolean)); }
  
  public void cn(boolean paramBoolean) { d("isFirstEnterQueuingMachineSetting", Boolean.valueOf(paramBoolean)); }
  
  public void co(boolean paramBoolean) { d("isOpenTableTimeCalculation", Boolean.valueOf(paramBoolean)); }
  
  public void cp(boolean paramBoolean) { d("isOpenTableTimeCalculationFirstRule", Boolean.valueOf(paramBoolean)); }
  
  public void cq(boolean paramBoolean) { d("openMiniProgramsSwitch", Boolean.valueOf(paramBoolean)); }
  
  public void d(double paramDouble) { d("defaultDiscount", Double.valueOf(paramDouble)); }
  
  public void dT(int paramInt) {
    d("NumberOfDecimals", Integer.valueOf(paramInt));
    RootApplication.aIQ = paramInt;
  }
  
  public void dU(int paramInt) { d("FirstCategoryLines", Integer.valueOf(paramInt)); }
  
  public void dV(int paramInt) { bP(RootApplication.zv().getResources().getStringArray(R.array.pos_mainsetting_product_sort_field)[paramInt]); }
  
  public boolean dW(int paramInt) {
    for (int i : PayTypeSpecific.AlipayCode.values) {
      if (paramInt == i)
        return d("alipayCode", Integer.valueOf(i)); 
    } 
    return false;
  }
  
  public boolean dX(int paramInt) {
    for (int i : PayTypeSpecific.WechatCode.values) {
      if (paramInt == i)
        return d("wechatCode", Integer.valueOf(i)); 
    } 
    return false;
  }
  
  public boolean dY(int paramInt) { return d("memberPointDeduction", Integer.valueOf(paramInt)); }
  
  public void dZ(int paramInt) { d("OpenTableSelectConnection", Integer.valueOf(paramInt)); }
  
  public boolean e(double paramDouble) { return d("VipCreditLimit", Double.valueOf(paramDouble)); }
  
  public void ea(int paramInt) { d("phonePrintSize", Integer.valueOf(paramInt)); }
  
  public void eb(int paramInt) { d("attributePriceRule", Integer.valueOf(paramInt)); }
  
  public boolean ec(int paramInt) { return d("scanorderMenuStyle", Integer.valueOf(paramInt)); }
  
  public boolean f(double paramDouble) { return d("memberDiscountValue", Double.valueOf(paramDouble)); }
  
  public void g(double paramDouble) { d("ServiceChargeAmount", Double.valueOf(paramDouble)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */