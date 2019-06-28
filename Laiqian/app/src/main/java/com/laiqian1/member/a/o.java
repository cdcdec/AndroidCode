package com.laiqian.member.a;

import android.text.TextUtils;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.member.model.PosMemberAddModel;
import com.laiqian.member.model.PosMemberChargeModel;
import com.laiqian.member.setting.bc;
import com.laiqian.member.setting.sms.h;
import com.laiqian.pos.industry.a;
import com.laiqian.product.models.g;
import com.laiqian.promotion.c.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.au;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.HashMap;

public class o extends a {
  public String btw;
  
  public o(ActivityRoot paramActivityRoot1, ActivityRoot paramActivityRoot2) { super(paramActivityRoot1, paramActivityRoot2); }
  
  protected void QE() {
    if (!by.isNull(this.btw))
      Toast.makeText(this.mContext, this.btw, 0).show(); 
  }
  
  protected boolean a(aq paramaq, String paramString1, String paramString2, boolean paramBoolean) {
    if (this.bwz.aWA + this.bwz.aWB == 0.0D)
      return true; 
    if (!bd.bH(getContext())) {
      this.btw = this.mContext.getString(R.string.please_check_network);
      return false;
    } 
    hashMap = new HashMap();
    str1 = new StringBuilder();
    str1.append(paramaq.aWz);
    str1.append("");
    hashMap.put("_id", str1.toString());
    str1 = new StringBuilder();
    str1.append(paramaq.aSW);
    str1.append("");
    hashMap.put("nBPartnerID", str1.toString());
    hashMap.put("sBPartnerNumber", paramaq.aWn);
    hashMap.put("sBPartnerMobile", paramaq.aTp);
    hashMap.put("sBPartnerName", paramaq.name);
    hashMap.put("nChargeType", "370004");
    str1 = new StringBuilder();
    str1.append(this.bwz.aWo);
    str1.append("");
    hashMap.put("fOldAmount", str1.toString());
    str1 = new StringBuilder();
    str1.append(paramaq.aWA + paramaq.aWB);
    str1.append("");
    hashMap.put("fChargeAmount", str1.toString());
    str1 = new StringBuilder();
    str1.append(this.bwz.aWy);
    str1.append("");
    hashMap.put("fNewAmount", str1.toString());
    str1 = new StringBuilder();
    str1.append(System.currentTimeMillis());
    str1.append("");
    hashMap.put("nOperationTime", str1.toString());
    str1 = new StringBuilder();
    str1.append(paramaq.aWA);
    str1.append("");
    hashMap.put("fReceived", str1.toString());
    str1 = new StringBuilder();
    str1.append(System.currentTimeMillis());
    str1.append("");
    hashMap.put("nDateTime", str1.toString());
    hashMap.put("nSpareField2", paramString1);
    if (by.isNull(paramString2)) {
      String str1 = "";
    } else {
      String str1;
      str1 = paramString2;
    } 
    hashMap.put("nSpareField3", str1);
    str2 = new StringBuilder();
    str2.append(RootApplication.getLaiqianPreferenceManager().avs());
    str2.append("");
    hashMap.put("nSpareField4", str2.toString());
    if (paramBoolean) {
      String str1 = "1";
    } else {
      String str2;
      str2 = "0";
    } 
    hashMap.put("sSpareField4", str2);
    hashMap.put("nUserID", RootApplication.getLaiqianPreferenceManager().atm());
    null = new StringBuilder();
    null.append(this.bwz.aWC);
    null.append("");
    hashMap.put("nBelongShopID", null.toString());
    hashMap.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    hashMap.put("auth_type", "0");
    hashMap.put("version", "2");
    null = new StringBuilder();
    null.append(RootApplication.getLaiqianPreferenceManager().avm());
    null.append("");
    hashMap.put("scope", null.toString());
    String str = bh.a(a.cqz, RootApplication.zv().getApplicationContext(), hashMap);
    if (!TextUtils.isEmpty(str)) {
      PosMemberChargeModel posMemberChargeModel = au.qB(str);
      if (posMemberChargeModel.containsKey("result") && "TRUE".equals(String.valueOf(posMemberChargeModel.get("result")))) {
        posMemberChargeModel = null;
        try {
          PosMemberChargeModel posMemberChargeModel1 = new PosMemberChargeModel(this.mContext);
          posMemberChargeModel = posMemberChargeModel1;
        } catch (Exception hashMap) {
          a.e(hashMap);
        } 
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(paramaq.aWz);
        stringBuilder3.append("");
        posMemberChargeModel.am("_id", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(paramaq.aSW);
        stringBuilder3.append("");
        posMemberChargeModel.am("nBPartnerID", stringBuilder3.toString());
        posMemberChargeModel.am("sBPartnerNumber", paramaq.aWn);
        posMemberChargeModel.am("sBPartnerMobile", paramaq.aTp);
        posMemberChargeModel.am("sBPartnerName", paramaq.name);
        posMemberChargeModel.am("nChargeType", "370004");
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(paramaq.aWo);
        stringBuilder3.append("");
        posMemberChargeModel.am("fOldAmount", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(paramaq.aWA + paramaq.aWB);
        stringBuilder3.append("");
        posMemberChargeModel.am("fChargeAmount", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(paramaq.aWy);
        stringBuilder3.append("");
        posMemberChargeModel.am("fNewAmount", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(System.currentTimeMillis());
        stringBuilder3.append("");
        posMemberChargeModel.am("nOperationTime", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(paramaq.aWA);
        stringBuilder3.append("");
        posMemberChargeModel.am("fReceived", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(System.currentTimeMillis());
        stringBuilder3.append("");
        posMemberChargeModel.am("nDateTime", stringBuilder3.toString());
        posMemberChargeModel.am("nSpareField2", paramString1);
        posMemberChargeModel.am("nUserID", RootApplication.getLaiqianPreferenceManager().atm());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramaq.aWC);
        stringBuilder2.append("");
        posMemberChargeModel.am("nWarehouseID", stringBuilder2.toString());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().avs());
        stringBuilder1.append("");
        posMemberChargeModel.am("nSpareField4", stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a.AZ().Be());
        stringBuilder1.append("");
        posMemberChargeModel.am("sSpareField5", stringBuilder1.toString());
        if (!by.isNull(paramString2))
          posMemberChargeModel.am("nSpareField3", paramString2); 
        paramBoolean = posMemberChargeModel.QL();
        posMemberChargeModel.close();
        if (paramBoolean && LQKVersion.zl() && this.bwK != null && this.bwL != null) {
          g g = new g(this.mContext);
          g.b(this.bwL);
          g.close();
          a a1 = new a(this.mContext);
          String str1 = n.a(Double.valueOf(this.bwK.aSg - this.bwL.aUz), true, false, 3);
          a1.aQ(this.bwK.id, str1);
          a1.close();
        } 
        return paramBoolean;
      } 
      if (posMemberChargeModel.containsKey("result") && "FALSE".equals(String.valueOf(posMemberChargeModel.get("result")))) {
        this.btw = String.valueOf(posMemberChargeModel.get("message"));
        return false;
      } 
      this.btw = this.mContext.getString(R.string.save_settings_failed);
      return false;
    } 
    this.btw = this.mContext.getString(R.string.save_settings_failed);
    return false;
  }
  
  protected boolean fE(String paramString) { return true; }
  
  protected void o(aq paramaq) {
    super.o(paramaq);
    if (bd.bH(this.mContext)) {
      h h = new h();
      String str = new StringBuilder();
      str.append(paramaq.aWA);
      str.append("");
      h.bGF = str.toString();
      h.aTp = paramaq.aTp;
      if (paramaq.aWB > 0.0D) {
        str = new StringBuilder();
        str.append(paramaq.aWB);
        str.append("");
        String str1 = str.toString();
      } else {
        str = "0";
      } 
      h.bGD = str;
      if (paramaq.aWB > 0.0D) {
        str = "SMS_12300424";
      } else {
        str = "SMS_12185283";
      } 
      h.bGE = str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramaq.aWo);
      stringBuilder.append("");
      h.aTt = stringBuilder.toString();
      if (bc.RH().fY("isOpenSMSNotice") && bc.RH().fY("isMemberChargeNoticed")) {
        if (!bd.bH(this.mContext)) {
          Toast.makeText(this.mContext, this.mContext.getString(R.string.please_check_network), 1).show();
          return;
        } 
        (new PosMemberAddModel.SendSmsTask(this.mContext, h)).forceLoad();
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */