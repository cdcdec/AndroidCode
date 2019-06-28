package com.laiqian.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.f.a;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.dc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class av {
  private SharedPreferences aPV = null;
  
  private String bKg = "language";
  
  private SharedPreferences dFB = null;
  
  private SharedPreferences dFC = null;
  
  private SharedPreferences dFD = null;
  
  private SharedPreferences dFE = null;
  
  private SharedPreferences dFF = null;
  
  private SharedPreferences dFG = null;
  
  private SharedPreferences dFH = null;
  
  private SharedPreferences dFI = null;
  
  private SharedPreferences dFJ = null;
  
  private SharedPreferences dFK = null;
  
  private SharedPreferences dFL = null;
  
  private SharedPreferences dFM = null;
  
  private Context dFN;
  
  private boolean dFO = true;
  
  private boolean dFP = false;
  
  private String dFQ = "WindowDataProviderStatus";
  
  private SharedPreferences dFR;
  
  private SharedPreferences dFS;
  
  private final String dFT = "/dev/ttyS1";
  
  private final String dFU = "9600";
  
  private final String dFV = RootApplication.zv().getString(R.string.version_title_pos);
  
  private final String dFW;
  
  private final String dFX;
  
  private final String dFY;
  
  private final String dFZ;
  
  private final String dGa;
  
  public av(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dFV);
    stringBuilder.append("\n400-998-1300\nhttp://dn.91laiqian.com");
    this.dFW = stringBuilder.toString();
    this.dFX = "/dev/ttyS3";
    this.dFY = "2400";
    this.dFZ = "/dev/ttyS3";
    this.dGa = "9600";
    if (paramContext == null)
      throw new IllegalArgumentException("context cannot be null"); 
    this.dFN = paramContext;
  }
  
  private SharedPreferences DW() {
    if (this.aPV == null)
      this.aPV = this.dFN.getSharedPreferences("com.laiqian.milestone_preferences", 0); 
    return this.aPV;
  }
  
  private SharedPreferences asX() {
    if (this.dFI == null) {
      Context context = this.dFN;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(atm());
      stringBuilder.append("_pos_user_settings");
      this.dFI = context.getSharedPreferences(stringBuilder.toString(), 0);
    } 
    return this.dFI;
  }
  
  private SharedPreferences asY() {
    if (this.dFF == null) {
      Context context = this.dFN;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Tx());
      stringBuilder.append("_pos_shop_settings");
      this.dFF = context.getSharedPreferences(stringBuilder.toString(), 0);
    } 
    return this.dFF;
  }
  
  private SharedPreferences asZ() {
    if (this.dFJ == null) {
      Context context = this.dFN;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Tx());
      stringBuilder.append("_auth_password_setting");
      this.dFJ = context.getSharedPreferences(stringBuilder.toString(), 0);
    } 
    return this.dFJ;
  }
  
  private SharedPreferences ata() {
    if (this.dFH == null) {
      Context context = this.dFN;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Tx());
      stringBuilder.append("_pos_default_warehouse");
      this.dFH = context.getSharedPreferences(stringBuilder.toString(), 0);
    } 
    return this.dFH;
  }
  
  private SharedPreferences atb() {
    if (this.dFG == null) {
      Context context = this.dFN;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Tx());
      stringBuilder.append("_pos_holding_orders");
      this.dFG = context.getSharedPreferences(stringBuilder.toString(), 0);
    } 
    return this.dFG;
  }
  
  private SharedPreferences atc() {
    if (this.dFE == null)
      this.dFE = this.dFN.getSharedPreferences("_pos_settings", 0); 
    return this.dFE;
  }
  
  private SharedPreferences atd() {
    if (this.dFC == null)
      this.dFC = this.dFN.getSharedPreferences("json", 0); 
    return this.dFC;
  }
  
  private SharedPreferences ate() {
    if (this.dFK == null)
      this.dFK = this.dFN.getSharedPreferences("backup", 0); 
    return this.dFK;
  }
  
  private SharedPreferences atg() {
    if (this.dFL == null)
      this.dFL = this.dFN.getSharedPreferences("upgrade", 0); 
    return this.dFL;
  }
  
  private SharedPreferences ath() {
    if (this.dFM == null)
      this.dFM = this.dFN.getSharedPreferences("feedback", 0); 
    return this.dFM;
  }
  
  public int Bf() { return atf().getInt("FirstCategoryLines", 1); }
  
  public String Bh() {
    String[] arrayOfString = RootApplication.zv().getResources().getStringArray(R.array.pos_mainsetting_product_sort_field);
    return atf().getString("productSort", arrayOfString[0]);
  }
  
  @Deprecated
  public int Bo() {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("alipayCode");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 2);
  }
  
  @Deprecated
  public int Bq() {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("wecharCode");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 7);
  }
  
  public boolean C(String paramString, boolean paramBoolean) { return atd().edit().putBoolean(paramString, paramBoolean).commit(); }
  
  public void D(String paramString, boolean paramBoolean) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shouldCopyDefaultDualScreenImages");
    stringBuilder.append(paramString);
    editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public void E(String paramString, int paramInt) {
    try {
      JSONObject jSONObject = avK();
      if (!TextUtils.isEmpty(jSONObject)) {
        JSONObject jSONObject1 = new JSONObject(jSONObject);
      } else {
        jSONObject = new JSONObject();
      } 
      jSONObject.putOpt(paramString, Integer.valueOf(paramInt));
      atf().edit().putString("userSoftwareTypes", jSONObject.toString()).commit();
      return;
    } catch (JSONException paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  public String Ea() { return atf().getString("user_phone", ""); }
  
  public String FC() {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("alipayAccountBinding");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public String FD() {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("wechatAccountBinding");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public void K(String paramString1, String paramString2, String paramString3) { atf().edit().putString("shoptoken", paramString1).putString("expire_time", paramString2).putString("shoptokenID", paramString3).commit(); }
  
  public boolean N(Boolean paramBoolean) { return atf().edit().putBoolean("nIsAllowChangeGift", paramBoolean.booleanValue()).commit(); }
  
  public void O(Boolean paramBoolean) { DW().edit().putBoolean("tableNumberEditable", paramBoolean.booleanValue()).commit(); }
  
  public boolean P(Boolean paramBoolean) {
    SharedPreferences.Editor editor = asY().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shouldShowBindAliPayTips");
    stringBuilder.append(Tx());
    return editor.putBoolean(stringBuilder.toString(), paramBoolean.booleanValue()).commit();
  }
  
  public boolean Q(Boolean paramBoolean) {
    SharedPreferences.Editor editor = asY().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shouldShowBindWechatPayTips");
    stringBuilder.append(Tx());
    return editor.putBoolean(stringBuilder.toString(), paramBoolean.booleanValue()).commit();
  }
  
  public int QV() {
    SharedPreferences sharedPreferences = asY();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("businessMode");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public String Tx() { return atf().getString("shop_id", "-1"); }
  
  public boolean Wq() {
    boolean bool2 = a.AZ().By();
    boolean bool1 = true;
    if (!bool2) {
      if (QV() == 1)
        return true; 
      bool1 = false;
    } 
    return bool1;
  }
  
  public void a(@NonNull String paramString, @NonNull dc paramdc) {
    try {
      JSONObject jSONObject = paramdc.xy();
      SharedPreferences.Editor editor = atf().edit();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryReprintInfo");
      stringBuilder.append(paramString);
      editor.putString(stringBuilder.toString(), jSONObject.toString()).apply();
      return;
    } catch (JSONException paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  public int aqA() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Refund_ORDER_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public boolean atA() { return ate().getBoolean("BackUpDeleteOldOpen", true); }
  
  public String atB() { return atf().getString("sWindowID", ""); }
  
  public boolean atC() { return atf().getBoolean("bProductDocIsUpdated", true); }
  
  public boolean atD() { return this.dFN.getSharedPreferences("com.laiqian.milestone_preferences", 0).getBoolean("cf_isItemExpandedConf", true); }
  
  public long atE() { return atc().getLong("POS_LastSyncTime", 0L); }
  
  public String atF() { return atc().getString("POS_DEVICE", "/dev/ttyS1"); }
  
  public String atG() { return atc().getString("POS_BAUDRATE", "9600"); }
  
  public boolean atH() { return atc().getBoolean("bGradesWay", false); }
  
  public int atI() { return atc().getInt("nGradesWay", 1); }
  
  public int atJ() { return atc().getInt("setAotoUploadCycle", 1); }
  
  public void atK() { atc().edit().clear().commit(); }
  
  public String atL() { return atc().getString("POS_Lock_Screen_Pwd", "1234"); }
  
  public boolean atM() { return atc().getBoolean("POS_LockScreen_OPEN", false); }
  
  public long atN() { return ata().getLong("POS_DEFAULT_WAREHOUSE_ID", Long.parseLong(Tx())); }
  
  public String atO() { return asX().getString("sUserImprest", "0"); }
  
  public long atP() { return asX().getLong("sUserImprestTime", 0L); }
  
  public long atQ() { return asX().getLong("startBusinessTime", 0L); }
  
  public String atR() { return asZ().getString("sOpenBoxPwd", ""); }
  
  public String atS() { return asZ().getString("sSaleReturnPwd", ""); }
  
  public String atT() { return asZ().getString("sPosSettingPwd", ""); }
  
  public String atU() { return asZ().getString("sPosShiftPwd", ""); }
  
  public String atV() { return asZ().getString("sPosDiscountPwd", ""); }
  
  public String atW() { return asZ().getString("sPosModifyPricePwd", ""); }
  
  public String atX() { return asZ().getString("sPosDeleteDocPwd", ""); }
  
  public String atY() { return DW().getString("sPhysicalInventoryID", null); }
  
  public String atZ() { return atf().getString("des_dir", ""); }
  
  public SharedPreferences atf() {
    if (this.dFB == null)
      this.dFB = this.dFN.getSharedPreferences("settings", 0); 
    return this.dFB;
  }
  
  public boolean ati() { return asX().getBoolean("member_rank_upgrade", false); }
  
  public boolean atj() { return atf().getBoolean("nIsAllowChangeGift", false); }
  
  public String atk() { return atf().getString("company_id", ""); }
  
  public String atl() { return atf().getString("latest_shop_id", "-1"); }
  
  public String atm() { return atf().getString("user_id", "-1"); }
  
  public String atn() { return atf().getString("function_version", "0"); }
  
  public String ato() { return atf().getString("latest_user_id", "-1"); }
  
  public String atp() { return atf().getString("user_role", "-1"); }
  
  public String atq() { return atf().getString("latest_user_phone", ""); }
  
  public String atr() { return atf().getString("user_password", "-1"); }
  
  public String ats() { return atf().getString("latest_user_password", "-1"); }
  
  public String att() { return atf().getString("sLanguage", "zh"); }
  
  public int atu() { return atf().getInt("nDecimalPointSetting", 1); }
  
  public boolean atv() { return DW().getBoolean("auto_update_isEnable", true); }
  
  public boolean atw() { return ate().getBoolean("BackUpAutoOpen", true); }
  
  public int atx() { return ate().getInt("BackUpAutoNums", 150); }
  
  public int aty() { return ate().getInt("BackUpAutoTimeHour", 20); }
  
  public int atz() { return ate().getInt("BackUpAutoTimeMin", 0); }
  
  public boolean auA() { return atg().getBoolean("hasNewPosVersion", false); }
  
  public int auB() { return atf().getInt("ProductTypePosition", 0); }
  
  public int auC() { return atf().getInt("AreaPosition", 0); }
  
  public String auD() { return atg().getString("upgradeHistory", ""); }
  
  public String auE() { return atf().getString("LoginPhones", ""); }
  
  public boolean auF() { return atf().getBoolean("bLogOut", false); }
  
  public boolean auG() { return atf().getBoolean("bAlipay", false); }
  
  public boolean auH() { return atf().getBoolean("bVip", false); }
  
  public boolean auI() { return atf().getBoolean("bWechat", false); }
  
  public boolean auJ() { return atf().getBoolean("bCash", false); }
  
  public boolean auK() { return atf().getBoolean("bMeiTuanCoupons", true); }
  
  public boolean auL() { return atf().getBoolean("bDZDPCoupons", true); }
  
  public boolean auM() { return atf().getBoolean("bDPCoupons", true); }
  
  public String auN() { return atf().getString("userPhoneInitial", ""); }
  
  public String auO() { return atf().getString("openBank", ""); }
  
  public String auP() { return atf().getString("userName", ""); }
  
  public String auQ() { return atf().getString("bankCard", ""); }
  
  public String auR() { return atf().getString("withdraw_amount", "0"); }
  
  public String[] auS() { return new String[] { atf().getString("shopBalance", null), atf().getString("shopMaxWithdraw", null), atf().getString("alipayName", null), atf().getString("alipayAccount", null) }; }
  
  public String[] auT() {
    null = atf().getString("exportMailAddress", null);
    if (null == null)
      return null; 
    String[] arrayOfString = null.split("@");
    if (arrayOfString.length == 2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("@");
      stringBuilder.append(arrayOfString[1]);
      arrayOfString[1] = stringBuilder.toString();
      return arrayOfString;
    } 
    return null;
  }
  
  public String auU() { return atf().getString("sClientId", null); }
  
  public long auV() { return atf().getLong("LastNewsTime", 0L); }
  
  public boolean auW() { return atf().getBoolean("isKoubeiOrderEnabled", true); }
  
  public String auX() { return asX().getString("walletSessionToken", null); }
  
  public long auY() { return asX().getLong("walletSessionTokenTime", 0L); }
  
  public boolean auZ() { return asX().getBoolean("shopCreateType", true); }
  
  public boolean aua() { return atf().getBoolean("user_updated", false); }
  
  public int aub() { return ata().getInt("mainPageIndex", 0); }
  
  public int auc() { return ata().getInt("GoodsSortingTypeIndex", 0); }
  
  public String aud() {
    int i = auc();
    return this.dFN.getResources().getStringArray(R.array.pos_mainsetting_product_sort_field)[i];
  }
  
  public boolean aue() { return atf().getBoolean("bShift", false); }
  
  public long auf() { return atc().getLong("POS_WEIXIN_SEARCH_TIME", 30L); }
  
  public String aug() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_LastTakeOut_WeChat_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public String auh() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Koubei_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public String aui() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_WeChat_Eat_In_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public String auj() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Meituan_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public String auk() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Eleme_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public String aul() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Phone_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public String aum() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_LastTakeOut_Tdd_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getString(stringBuilder.toString(), null);
  }
  
  public int aun() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_WECHAT_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int auo() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_MEITUAN_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int aup() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Refunding_ORDER_MEITUAN_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int auq() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_Eleme_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int aur() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Refunding_ORDER_Eleme_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int aus() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_KOUBEI_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int aut() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_Tdd_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int auu() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_WeChat_Eat_In_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int auv() {
    SharedPreferences sharedPreferences = ata();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Phone_NUM_");
    stringBuilder.append(Tx());
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public boolean auw() { return DW().getBoolean("IsLoginFlag", false); }
  
  public boolean aux() { return DW().getBoolean("PosMemberChargeFlag", false); }
  
  public boolean auy() { return DW().getBoolean("PosMemberAddFlag", false); }
  
  public String auz() { return DW().getString("PosMemberAddCardNumber", null); }
  
  public boolean avA() { return asY().getBoolean("showAliAndWeChatDialog", true); }
  
  public int avB() {
    int i = asY().getInt("businessTimeBegin", -1);
    return (i < 0 || i > 23) ? 9 : i;
  }
  
  public int avC() {
    int i = asY().getInt("businessTimeEnd", -1);
    return (i < 0 || i > 23) ? 20 : i;
  }
  
  public double avD() { return atf().getFloat("memberBonusRatio", -1.0F); }
  
  public double avE() { return atf().getFloat("memberBonusMinAmount", -1.0F); }
  
  public String avF() { return atf().getString("AccountChannelId", "1"); }
  
  public boolean avG() { return atf().getBoolean("showDualscreenMember", false); }
  
  public int avH() { return atf().getInt("ScrollTime", 8); }
  
  public String avI() { return asY().getString("alipayTradeInfo", ""); }
  
  public boolean avJ() { return atf().getBoolean("isBlockCanaryEnabled", false); }
  
  public String avK() { return atf().getString("userSoftwareTypes", ""); }
  
  public int avL() {
    try {
      JSONObject jSONObject = avK();
      if (TextUtils.isEmpty(jSONObject)) {
        jSONObject = new JSONObject();
      } else {
        jSONObject = new JSONObject(jSONObject);
      } 
      return jSONObject.has(Ea()) ? jSONObject.getInt(Ea()) : -1;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return -1;
    } 
  }
  
  public boolean avM() { return "150001".equals(atp()); }
  
  public long avN() { return atf().getLong("RequestTimes", 0L); }
  
  public String avO() { return atf().getString("unpost_consumed_msg", null); }
  
  public String avP() { return atf().getString("lastShiftTime", ""); }
  
  public int avQ() { return asY().getInt("scanOrderNums", 0); }
  
  public boolean avR() { return atf().getBoolean("shouldPosPrintReceipt", true); }
  
  public String avS() { return asY().getString("lastScanbarcode", ""); }
  
  public boolean avT() { return asY().getBoolean("nIsCash", true); }
  
  public long avU() { return asY().getLong("vipChargedocId", 0L); }
  
  public boolean avV() { return asY().getBoolean("AllowOnlineVipNonCreditPay", false); }
  
  public int avW() { return asY().getInt("DiscountClass", 0); }
  
  public String avX() { return asY().getString("BonusAmounts", ""); }
  
  public int avY() { return asY().getInt("VipDeposit", 0); }
  
  public boolean avZ() { return (avs() == 1 && avr() == 1); }
  
  public boolean ava() { return DW().getBoolean("MultiServerDownload", false); }
  
  @Deprecated
  public boolean avb() { return DW().getBoolean("OrderDishesClient", false); }
  
  public boolean avc() { return atf().getBoolean("showShakePhone", true); }
  
  public boolean avd() { return atf().getBoolean("showPasswordHint", true); }
  
  public List<g> ave() throws JSONException {
    ArrayList arrayList = new ArrayList();
    String str = atf().getString("memberRankList", "");
    if (!TextUtils.isEmpty(str)) {
      JSONArray jSONArray = new JSONArray(str);
      byte b;
      for (b = 0; b < jSONArray.length(); b++) {
        JSONObject jSONObject = jSONArray.optJSONObject(b);
        long l = jSONObject.optLong("id");
        int i = jSONObject.optInt("number");
        String str1 = jSONObject.optString("name");
        double d1 = jSONObject.optDouble("discount");
        double d2 = jSONObject.optDouble("start_amount");
        arrayList.add(new g(Long.valueOf(l).longValue(), i, d2, d1, str1));
      } 
    } 
    return arrayList;
  }
  
  public boolean avf() { return DW().getBoolean("tableNumberEditable", true); }
  
  public void avg() { atf().edit().remove("shoptoken").remove("expire_time").remove("shoptokenID").commit(); }
  
  public String avh() { return atf().getString("shoptoken", null); }
  
  public String avi() { return atf().getString("expire_time", null); }
  
  public String avj() { return atf().getString("shoptokenID", ""); }
  
  public long avk() {
    long l = DW().getLong("tableNumberLong", 0L);
    return (l >= 9999L) ? 1L : (l + 1L);
  }
  
  public boolean avl() { return a.AZ().By(); }
  
  public int avm() { return QV(); }
  
  public int avn() { return asY().getInt("alipayMode", 0); }
  
  public int avo() { return asY().getInt("alipayBind", 0); }
  
  public int avp() { return asY().getInt("wechatBind", 0); }
  
  public int avq() { return asY().getInt("wechatMode", 8); }
  
  public int avr() { return asY().getInt("nPaySubMode", 0); }
  
  public int avs() { return asY().getInt("payMode", 0); }
  
  public String avt() { return asY().getString("nWeixinShopID", "0"); }
  
  public String avu() { return atf().getString("patch_version", "0"); }
  
  public int avv() { return atf().getInt("ota_version", 0); }
  
  public String avw() { return atf().getString("ota_version_detail", ""); }
  
  public boolean avx() { return (this.dFN.getResources().getBoolean(R.bool.has_second_product_name) && avy() == 1); }
  
  public int avy() { return asY().getInt("productNameTypeIndex", 0); }
  
  public boolean avz() { return atf().getBoolean("isShowDualscreenProducts", true); }
  
  public long awa() { return atf().getLong("message_received_accumulated_quantity", 0L); }
  
  public boolean awb() { return atf().getBoolean("message_processing", false); }
  
  public boolean awc() { return asY().getBoolean("networkLog", false); }
  
  public boolean awd() { return atf().getBoolean("isFirstStart", true); }
  
  public boolean awe() { return a.zR().Al() ? asY().getBoolean("chuanbeibRefund", true) : ("0".equalsIgnoreCase(asY().getString("chuanbeiRefund", "1")) ? 0 : 1); }
  
  public boolean awf() { return asY().getBoolean("nIsMeituanPhoneNumberError", false); }
  
  public String awg() { return asY().getString("meituanPhoneNumberErrorOrders", "[]"); }
  
  public String awh() { return asY().getString("chuanbeiToken", ""); }
  
  public String awi() { return asY().getString("chuanbeiMerchantId", ""); }
  
  public boolean awj() {
    SharedPreferences sharedPreferences = asY();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shouldShowBindAliPayTips");
    stringBuilder.append(Tx());
    return sharedPreferences.getBoolean(stringBuilder.toString(), TextUtils.isEmpty(FC()));
  }
  
  public boolean awk() {
    SharedPreferences sharedPreferences = asY();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shouldShowBindWechatPayTips");
    stringBuilder.append(Tx());
    return sharedPreferences.getBoolean(stringBuilder.toString(), TextUtils.isEmpty(FD()));
  }
  
  public String awl() { return asY().getString("PosFunctionHint", null); }
  
  public void bZ(long paramLong) { atf().edit().putLong("orderTime", paramLong).apply(); }
  
  public boolean bi(double paramDouble) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    return editor.putString("function_version", stringBuilder.toString()).commit();
  }
  
  public void bj(double paramDouble) { atf().edit().putFloat("memberBonusRatio", (float)paramDouble).apply(); }
  
  public void bk(double paramDouble) { atf().edit().putFloat("memberBonusMinAmount", (float)paramDouble).apply(); }
  
  public boolean bl(String paramString1, String paramString2) {
    if (paramString1 == null || "".equals(paramString1)) {
      null = new StringBuilder();
      null.append(Ea());
      null.append("_");
      null.append(z.pz("yyyy-MM-dd HH:mm:ss"));
      null.append("_");
      null.append(getVersion());
      str = null.toString();
      return ath().edit().putString(str, paramString2).commit();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Ea());
    stringBuilder.append("_");
    stringBuilder.append(str);
    stringBuilder.append("_");
    stringBuilder.append(getVersion());
    String str = stringBuilder.toString();
    return ath().edit().putString(str, paramString2).commit();
  }
  
  public boolean bm(String paramString1, String paramString2) { return atg().edit().putString(paramString1, paramString2).commit(); }
  
  public void bn(String paramString1, String paramString2) { atf().edit().putString("alipayName", paramString1).putString("alipayAccount", paramString2).commit(); }
  
  public void bo(String paramString1, String paramString2) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("WeshopUrl/");
    stringBuilder.append(paramString1);
    editor.putString(stringBuilder.toString(), paramString2).apply();
  }
  
  public int bp(@NonNull String paramString1, @NonNull String paramString2) {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("receiptReprintCount,");
    stringBuilder.append(paramString1);
    stringBuilder.append(",");
    stringBuilder.append(paramString2);
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int bq(@NonNull String paramString1, @NonNull String paramString2) {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tagReprintCount,");
    stringBuilder.append(paramString1);
    stringBuilder.append(",");
    stringBuilder.append(paramString2);
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public int br(@NonNull String paramString1, @NonNull String paramString2) {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("KitchenReprintCount,");
    stringBuilder.append(paramString1);
    stringBuilder.append(",");
    stringBuilder.append(paramString2);
    return sharedPreferences.getInt(stringBuilder.toString(), 0);
  }
  
  public void close() {
    this.dFB = null;
    this.aPV = null;
    this.dFC = null;
    this.dFD = null;
    this.dFE = null;
    this.dFG = null;
    this.dFH = null;
    this.dFI = null;
    this.dFJ = null;
    this.dFK = null;
    this.dFL = null;
    this.dFM = null;
    this.dFF = null;
    this.dFR = null;
    this.dFS = null;
  }
  
  public void dA(long paramLong) { atf().edit().putString("lastShiftTime", String.valueOf(paramLong)).commit(); }
  
  public boolean dB(long paramLong) { return asY().edit().putLong("vipChargedocId", paramLong).commit(); }
  
  public boolean dC(long paramLong) { return atf().edit().putLong("message_received_accumulated_quantity", paramLong).commit(); }
  
  public boolean dD(long paramLong) { return dC(atf().getLong("message_received_accumulated_quantity", 0L) + paramLong); }
  
  public boolean dq(long paramLong) { return ate().edit().putLong("BackUpAutoTime", paramLong).commit(); }
  
  public boolean dr(long paramLong) { return this.dFN.getSharedPreferences("warehouse", 0).edit().putLong("nWarehouseID", paramLong).commit(); }
  
  public boolean ds(long paramLong) { return atc().edit().putLong("POS_LastSyncTime", paramLong).commit(); }
  
  public boolean dt(long paramLong) { return asX().edit().putLong("sUserImprestTime", paramLong).commit(); }
  
  public boolean du(long paramLong) { return asX().edit().putLong("startBusinessTime", paramLong).commit(); }
  
  public boolean dv(long paramLong) { return atc().edit().putLong("POS_WEIXIN_SEARCH_TIME", paramLong).commit(); }
  
  public void dw(long paramLong) { atf().edit().putLong("LastNewsTime", paramLong).apply(); }
  
  public boolean dx(long paramLong) { return asX().edit().putLong("walletSessionTokenTime", paramLong).commit(); }
  
  public void dy(long paramLong) { DW().edit().putLong("tableNumberLong", paramLong).commit(); }
  
  public void dz(long paramLong) { atf().edit().putLong("RequestTimes", paramLong).apply(); }
  
  public void g(@NonNull String paramString1, @NonNull String paramString2, int paramInt) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("receiptReprintCount,");
    stringBuilder.append(paramString1);
    stringBuilder.append(",");
    stringBuilder.append(paramString2);
    editor.putInt(stringBuilder.toString(), paramInt).apply();
  }
  
  public String getVersion() { return atf().getString("apk_version", null); }
  
  public void h(@NonNull String paramString1, @NonNull String paramString2, int paramInt) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tagReprintCount,");
    stringBuilder.append(paramString1);
    stringBuilder.append(",");
    stringBuilder.append(paramString2);
    editor.putInt(stringBuilder.toString(), paramInt).apply();
  }
  
  public void h(String paramString1, String paramString2, String paramString3, String paramString4) { atf().edit().putString("openBank", paramString1).putString("userName", paramString2).putString("bankCard", paramString3).putString("withdraw_amount", paramString4).commit(); }
  
  public boolean h(String paramString, Object paramObject) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
      objectOutputStream.writeObject(paramObject);
      paramObject = atb().edit();
      paramObject.putString(paramString, a.e(byteArrayOutputStream.toByteArray()));
      paramObject.commit();
      objectOutputStream.close();
      return true;
    } catch (IOException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public boolean hA(boolean paramBoolean) { return DW().edit().putBoolean("PosMemberChargeFlag", paramBoolean).commit(); }
  
  public boolean hB(boolean paramBoolean) { return DW().edit().putBoolean("PosMemberAddFlag", paramBoolean).commit(); }
  
  public boolean hC(boolean paramBoolean) { return atg().edit().putBoolean("hasNewPosVersion", paramBoolean).commit(); }
  
  public boolean hD(boolean paramBoolean) { return atf().edit().putBoolean("bLogOut", paramBoolean).commit(); }
  
  public boolean hE(boolean paramBoolean) { return atf().edit().putBoolean("bMeiTuanCoupons", paramBoolean).commit(); }
  
  public boolean hF(boolean paramBoolean) { return atf().edit().putBoolean("bDZDPCoupons", paramBoolean).commit(); }
  
  public boolean hG(boolean paramBoolean) { return atf().edit().putBoolean("bDPCoupons", paramBoolean).commit(); }
  
  public boolean hH(boolean paramBoolean) { return asX().edit().putBoolean("meituan_takeaway_bind", paramBoolean).commit(); }
  
  public boolean hI(boolean paramBoolean) { return asX().edit().putBoolean("meituan_tuangou_bind", paramBoolean).commit(); }
  
  public boolean hJ(boolean paramBoolean) { return asX().edit().putBoolean("shopCreateType", paramBoolean).commit(); }
  
  public boolean hK(boolean paramBoolean) { return DW().edit().putBoolean("MultiServerDownload", paramBoolean).commit(); }
  
  public void hL(boolean paramBoolean) { atf().edit().putBoolean("showShakePhone", paramBoolean).apply(); }
  
  public void hM(boolean paramBoolean) { atf().edit().putBoolean("showPasswordHint", paramBoolean).apply(); }
  
  public boolean hN(boolean paramBoolean) {
    SharedPreferences.Editor editor = asY().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isOnlineMember");
    stringBuilder.append(Tx());
    return editor.putBoolean(stringBuilder.toString(), paramBoolean).commit();
  }
  
  public void hO(boolean paramBoolean) { atf().edit().putBoolean("isShowDualscreenProducts", paramBoolean).apply(); }
  
  public void hP(boolean paramBoolean) { asY().edit().putBoolean("showAliAndWeChatDialog", paramBoolean).commit(); }
  
  public void hQ(boolean paramBoolean) { atf().edit().putBoolean("showDualscreenMember", paramBoolean).apply(); }
  
  public void hR(boolean paramBoolean) { atf().edit().putBoolean("isBlockCanaryEnabled", paramBoolean).apply(); }
  
  public boolean hS(boolean paramBoolean) { return asY().edit().putBoolean("nIsCash", paramBoolean).commit(); }
  
  public void hT(boolean paramBoolean) { asY().edit().putBoolean("AllowOnlineVipNonCreditPay", paramBoolean).apply(); }
  
  public boolean hU(boolean paramBoolean) { return atf().edit().putBoolean("message_processing", paramBoolean).commit(); }
  
  public void hV(boolean paramBoolean) { asY().edit().putBoolean("networkLog", paramBoolean).apply(); }
  
  public void hW(boolean paramBoolean) { atf().edit().putBoolean("isFirstStart", paramBoolean).commit(); }
  
  public boolean hX(boolean paramBoolean) { return asY().edit().putBoolean("nIsMeituanPhoneNumberError", paramBoolean).commit(); }
  
  public boolean hY(boolean paramBoolean) { return asY().edit().putBoolean("chuanbeibRefund", paramBoolean).commit(); }
  
  public boolean hl(boolean paramBoolean) { return DW().edit().putBoolean("auto_update_isEnable", paramBoolean).commit(); }
  
  public boolean hm(boolean paramBoolean) { return ate().edit().putBoolean("BackUpAutoOpen", paramBoolean).commit(); }
  
  public boolean hn(boolean paramBoolean) { return ate().edit().putBoolean("BackUpSuccess", paramBoolean).commit(); }
  
  public boolean ho(boolean paramBoolean) { return ate().edit().putBoolean("BackUpDeleteOldOpen", paramBoolean).commit(); }
  
  public void hp(boolean paramBoolean) { atf().edit().putBoolean("showIntro", paramBoolean).commit(); }
  
  public boolean hq(boolean paramBoolean) { return this.dFN.getSharedPreferences("producttype", 0).edit().putBoolean("bIsProductTypeUpdated", paramBoolean).commit(); }
  
  public boolean hr(boolean paramBoolean) { return this.dFN.getSharedPreferences("product", 0).edit().putBoolean("bIsProductUpdated", paramBoolean).commit(); }
  
  public boolean hs(boolean paramBoolean) {
    SharedPreferences sharedPreferences = this.dFN.getSharedPreferences("taste", 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setTasteUpdate:");
    stringBuilder.append(paramBoolean);
    bb.ao(stringBuilder.toString());
    return sharedPreferences.edit().putBoolean("bTasteUpdate", paramBoolean).commit();
  }
  
  public boolean ht(boolean paramBoolean) { return atf().edit().putBoolean("bProductDocIsUpdated", paramBoolean).commit(); }
  
  public void hu(boolean paramBoolean) { atc().edit().putBoolean("bGradesWay", paramBoolean).commit(); }
  
  public boolean hv(boolean paramBoolean) { return atc().edit().putBoolean("POS_LockScreen_OPEN", paramBoolean).commit(); }
  
  public boolean hw(boolean paramBoolean) { return atc().edit().putBoolean("POS_CustomerDisplay_OPEN", paramBoolean).commit(); }
  
  public boolean hx(boolean paramBoolean) { return atf().edit().putBoolean("bShift", paramBoolean).commit(); }
  
  public boolean hy(boolean paramBoolean) { return atf().edit().putBoolean("bDeleteAllFlag", paramBoolean).commit(); }
  
  public boolean hz(boolean paramBoolean) { return DW().edit().putBoolean("IsLoginFlag", paramBoolean).commit(); }
  
  public void i(@NonNull String paramString1, @NonNull String paramString2, int paramInt) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("KitchenReprintCount,");
    stringBuilder.append(paramString1);
    stringBuilder.append(",");
    stringBuilder.append(paramString2);
    editor.putInt(stringBuilder.toString(), paramInt).apply();
  }
  
  public boolean i(String paramString, Object paramObject) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
      objectOutputStream.writeObject(paramObject);
      paramObject = this.dFN.getSharedPreferences("-1_pos_holding_orders", 0).edit();
      paramObject.putString(paramString, a.e(byteArrayOutputStream.toByteArray()));
      paramObject.commit();
      objectOutputStream.close();
      return true;
    } catch (IOException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public boolean isMultipleShop() { return (QV() == 1); }
  
  public boolean lA(int paramInt) { return ate().edit().putInt("BackUpAutoTimeHour", paramInt).commit(); }
  
  public boolean lB(int paramInt) { return ate().edit().putInt("BackUpAutoTimeMin", paramInt).commit(); }
  
  public boolean lC(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lD(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_WECHAT_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lE(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_MEITUAN_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lF(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Refunding_ORDER_MEITUAN_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lG(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_Eleme_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lH(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Refunding_ORDER_Eleme_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lI(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_KOUBEI_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lJ(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_Tdd_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lK(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Pending_ORDER_WeChat_Eat_In_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lL(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Refund_ORDER_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lM(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_ORDER_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lN(int paramInt) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Untreated_Phone_NUM_");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lO(int paramInt) { return atf().edit().putInt("ProductTypePosition", paramInt).commit(); }
  
  public boolean lP(int paramInt) { return atf().edit().putInt("AreaPosition", paramInt).commit(); }
  
  public boolean lQ(int paramInt) {
    if (paramInt == 1 && a.AZ().Bu())
      a.AZ().bN(false); 
    SharedPreferences.Editor editor = asY().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("businessMode");
    stringBuilder.append(Tx());
    return editor.putInt(stringBuilder.toString(), paramInt).commit();
  }
  
  public boolean lR(int paramInt) { return asY().edit().putInt("alipayMode", paramInt).commit(); }
  
  public boolean lS(int paramInt) { return asY().edit().putInt("alipayBind", paramInt).commit(); }
  
  public boolean lT(int paramInt) { return asY().edit().putInt("wechatBind", paramInt).commit(); }
  
  public boolean lU(int paramInt) { return asY().edit().putInt("wechatMode", paramInt).commit(); }
  
  public boolean lV(int paramInt) { return asY().edit().putInt("payMode", paramInt).commit(); }
  
  public boolean lW(int paramInt) { return asY().edit().putInt("nPaySubMode", paramInt).commit(); }
  
  public void lX(int paramInt) { atf().edit().putInt("ota_version", paramInt).commit(); }
  
  public void lY(int paramInt) { asY().edit().putInt("productNameTypeIndex", paramInt).commit(); }
  
  public void lZ(int paramInt) {
    if (paramInt >= 0) {
      if (paramInt > 23)
        return; 
      asY().edit().putInt("businessTimeBegin", paramInt).commit();
      return;
    } 
  }
  
  public boolean ly(int paramInt) { return ate().edit().putInt("BackUpAutoInterval", paramInt).commit(); }
  
  public boolean lz(int paramInt) { return ate().edit().putInt("BackUpAutoNums", paramInt).commit(); }
  
  public void ma(int paramInt) {
    if (paramInt >= 0) {
      if (paramInt > 23)
        return; 
      asY().edit().putInt("businessTimeEnd", paramInt).commit();
      return;
    } 
  }
  
  public void mb(int paramInt) { atf().edit().putInt("ScrollTime", paramInt).apply(); }
  
  public void mc(int paramInt) { E(Ea(), paramInt); }
  
  public void md(int paramInt) { asY().edit().putInt("scanOrderNums", paramInt).apply(); }
  
  public void me(int paramInt) { asY().edit().putInt("DiscountClass", paramInt).apply(); }
  
  public void mf(int paramInt) { asY().edit().putInt("VipDeposit", paramInt).apply(); }
  
  public boolean qD(String paramString) { return atf().edit().putString("shop_id", paramString).commit(); }
  
  public boolean qE(String paramString) { return atf().edit().putString("company_id", paramString).commit(); }
  
  public boolean qF(String paramString) { return atf().edit().putString("latest_shop_id", paramString).commit(); }
  
  public boolean qG(String paramString) { return atf().edit().putString("user_id", paramString).commit(); }
  
  public boolean qH(String paramString) { return atf().edit().putString("latest_user_id", paramString).commit(); }
  
  public boolean qI(String paramString) { return atf().edit().putString("user_role", paramString).commit(); }
  
  public boolean qJ(String paramString) { return atf().edit().putString("user_phone", paramString).commit(); }
  
  public boolean qK(String paramString) { return atf().edit().putString("latest_user_phone", paramString).commit(); }
  
  public boolean qL(String paramString) { return atf().edit().putString("user_password", paramString).commit(); }
  
  public boolean qM(String paramString) { return atf().edit().putString("latest_user_password", paramString).commit(); }
  
  public boolean qN(String paramString) { return atd().getBoolean(paramString, true); }
  
  public boolean qO(String paramString) { return atf().edit().putString("sWindowID", paramString).commit(); }
  
  public boolean qP(String paramString) { return atf().edit().putString("sOrderNo", paramString).commit(); }
  
  public Object qQ(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial atb : ()Landroid/content/SharedPreferences;
    //   6: aload_1
    //   7: ldc_w ''
    //   10: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: invokestatic decode : (Ljava/lang/String;)[B
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull -> 83
    //   23: aload_1
    //   24: arraylength
    //   25: ifne -> 31
    //   28: goto -> 83
    //   31: new java/io/ByteArrayInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial <init> : ([B)V
    //   39: astore_1
    //   40: new java/io/ObjectInputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial <init> : (Ljava/io/InputStream;)V
    //   48: invokevirtual readObject : ()Ljava/lang/Object;
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: astore_1
    //   57: aload_1
    //   58: invokestatic e : (Ljava/lang/Throwable;)V
    //   61: aload_0
    //   62: monitorexit
    //   63: aconst_null
    //   64: areturn
    //   65: astore_1
    //   66: aload_1
    //   67: invokestatic e : (Ljava/lang/Throwable;)V
    //   70: aload_0
    //   71: monitorexit
    //   72: aconst_null
    //   73: areturn
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic e : (Ljava/lang/Throwable;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: aconst_null
    //   82: areturn
    //   83: aload_0
    //   84: monitorexit
    //   85: aconst_null
    //   86: areturn
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	87	finally
    //   23	28	87	finally
    //   31	40	87	finally
    //   40	52	74	java/io/OptionalDataException
    //   40	52	65	java/lang/ClassNotFoundException
    //   40	52	56	java/io/IOException
    //   40	52	87	finally
    //   57	61	87	finally
    //   66	70	87	finally
    //   75	79	87	finally }
  
  public Object qR(String paramString) {
    byte[] arrayOfByte = a.decode(this.dFN.getSharedPreferences("-1_pos_holding_orders", 0).getString(paramString, ""));
    if (arrayOfByte != null) {
      if (arrayOfByte.length == 0)
        return null; 
      byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
      try {
        return (new ObjectInputStream(byteArrayInputStream)).readObject();
      } catch (OptionalDataException byteArrayInputStream) {
        a.e(byteArrayInputStream);
        return null;
      } catch (ClassNotFoundException byteArrayInputStream) {
        a.e(byteArrayInputStream);
        return null;
      } catch (IOException byteArrayInputStream) {
        a.e(byteArrayInputStream);
        return null;
      } 
    } 
    return null;
  }
  
  public boolean qS(String paramString) { return atb().edit().remove(paramString).commit(); }
  
  public boolean qT(String paramString) { return atc().edit().putString("POS_Lock_Screen_Pwd", paramString).commit(); }
  
  public boolean qU(String paramString) { return asX().edit().putString("sUserImprest", paramString).commit(); }
  
  public boolean qV(String paramString) { return asZ().edit().putString("sOpenBoxPwd", paramString).commit(); }
  
  public boolean qW(String paramString) { return asZ().edit().putString("sSaleReturnPwd", paramString).commit(); }
  
  public boolean qX(String paramString) { return asZ().edit().putString("sPosSettingPwd", paramString).commit(); }
  
  public boolean qY(String paramString) { return asZ().edit().putString("sPosShiftPwd", paramString).commit(); }
  
  public boolean qZ(String paramString) { return asZ().edit().putString("sPosDiscountPwd", paramString).commit(); }
  
  public void rA(String paramString) { atf().edit().putString("ota_version_detail", paramString).commit(); }
  
  @Nullable
  public dc rB(@NonNull String paramString) {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("queryReprintInfo");
    stringBuilder.append(paramString);
    paramString = sharedPreferences.getString(stringBuilder.toString(), null);
    if (paramString != null)
      try {
        return dc.j(new JSONObject(paramString));
      } catch (JSONException paramString) {
        a.e(paramString);
      }  
    return null;
  }
  
  public void rC(String paramString) { atf().edit().putString("AccountChannelId", paramString).apply(); }
  
  public void rD(String paramString) { asY().edit().putString("alipayTradeInfo", paramString).commit(); }
  
  public void rE(String paramString) { atf().edit().putString("unpost_consumed_msg", paramString).commit(); }
  
  public void rF(String paramString) { asY().edit().putString("lastScanbarcode", paramString).apply(); }
  
  public void rG(String paramString) { asY().edit().putString("BonusAmounts", paramString).apply(); }
  
  public boolean rH(String paramString) { return asY().edit().putString("chuanbeiRefund", paramString).commit(); }
  
  public void rI(String paramString) { asY().edit().putString("meituanPhoneNumberErrorOrders", paramString).apply(); }
  
  public boolean rJ(String paramString) { return asY().edit().putString("chuanbeiToken", paramString).commit(); }
  
  public boolean rK(String paramString) { return asY().edit().putString("chuanbeiMerchantId", paramString).commit(); }
  
  public boolean rL(String paramString) { return asY().edit().putString("PosFunctionHint", paramString).commit(); }
  
  public boolean ra(String paramString) { return asZ().edit().putString("sPosModifyPricePwd", paramString).commit(); }
  
  public boolean rb(String paramString) { return asZ().edit().putString("sPosDeleteDocPwd", paramString).commit(); }
  
  public boolean rc(String paramString) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_LastTakeOut_WeChat_NUM_");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean rd(String paramString) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Koubei_NUM_");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean re(String paramString) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_WeChat_Eat_In_NUM_");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean rf(String paramString) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Meituan_NUM_");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean rg(String paramString) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Eleme_NUM_");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean rh(String paramString) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_Last_Phone_NUM_");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean ri(String paramString) {
    SharedPreferences.Editor editor = ata().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("POS_LastTakeOut_Tdd_NUM_");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean rj(String paramString) { return DW().edit().putString("PosMemberAddCardNumber", paramString).commit(); }
  
  public boolean rk(String paramString) { return atg().edit().putString("upgradeHistory", paramString).commit(); }
  
  public String rl(String paramString) { return atg().getString(paramString, "0"); }
  
  public boolean rm(String paramString) { return atg().edit().putString("newVersionInfo", paramString).commit(); }
  
  public boolean rn(String paramString) { return atf().edit().putString("LoginPhones", paramString).commit(); }
  
  public boolean ro(String paramString) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("alipayAccountBinding");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public boolean rp(String paramString) {
    SharedPreferences.Editor editor = atf().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("wechatAccountBinding");
    stringBuilder.append(Tx());
    return editor.putString(stringBuilder.toString(), paramString).commit();
  }
  
  public void rq(String paramString) { atf().edit().putString("userPhoneInitial", paramString).commit(); }
  
  public void rr(String paramString) { atf().edit().putString("exportMailAddress", paramString).commit(); }
  
  public String rs(String paramString) {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("WeshopUrl/");
    stringBuilder.append(paramString);
    return sharedPreferences.getString(stringBuilder.toString(), "");
  }
  
  public boolean rt(String paramString) { return atf().edit().putString("sClientId", paramString).commit(); }
  
  public boolean ru(String paramString) { return asX().edit().putString("walletSessionToken", paramString).commit(); }
  
  public boolean rv(String paramString) { return asX().edit().putString("meituanToken", paramString).commit(); }
  
  public boolean rw(String paramString) {
    SharedPreferences sharedPreferences = atf();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shouldCopyDefaultDualScreenImages");
    stringBuilder.append(paramString);
    return sharedPreferences.getBoolean(stringBuilder.toString(), true);
  }
  
  public void rx(String paramString) { atf().edit().putString("memberRankList", paramString).commit(); }
  
  public boolean ry(String paramString) { return asY().edit().putString("nWeixinShopID", paramString).commit(); }
  
  public void rz(String paramString) { atf().edit().putString("patch_version", paramString).commit(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */