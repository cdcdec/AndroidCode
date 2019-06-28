package com.laiqian.member.a;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.member.model.PosMemberAddModel;
import com.laiqian.member.model.PosMemberChargeModel;
import com.laiqian.member.setting.bc;
import com.laiqian.member.setting.sms.h;
import com.laiqian.product.models.g;
import com.laiqian.promotion.c.a;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;

public class n extends a {
  private static final String TAG = "n";
  
  static  {
  
  }
  
  public n(Context paramContext1, Context paramContext2) { super(paramContext1, paramContext2); }
  
  protected void QE() {}
  
  protected boolean a(aq paramaq, String paramString1, String paramString2, boolean paramBoolean) {
    PosMemberChargeModel posMemberChargeModel;
    if (this.bwz.aWA + this.bwz.aWB == 0.0D)
      return true; 
    paramaq = null;
    try {
      PosMemberChargeModel posMemberChargeModel1 = new PosMemberChargeModel(this.mContext);
      posMemberChargeModel = posMemberChargeModel1;
    } catch (Exception exception) {
      a.e(exception);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bwz.aWz);
    stringBuilder.append("");
    posMemberChargeModel.am("_id", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.bwz.aSW);
    stringBuilder.append("");
    posMemberChargeModel.am("nBPartnerID", stringBuilder.toString());
    posMemberChargeModel.am("sBPartnerNumber", this.bwz.aWn);
    posMemberChargeModel.am("sBPartnerMobile", this.bwz.aTp);
    posMemberChargeModel.am("sBPartnerName", this.bwz.name);
    posMemberChargeModel.am("nChargeType", "370004");
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.bwz.aWo);
    stringBuilder.append("");
    posMemberChargeModel.am("fOldAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.bwz.aWA + this.bwz.aWB);
    stringBuilder.append("");
    posMemberChargeModel.am("fChargeAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.bwz.aWy);
    stringBuilder.append("");
    posMemberChargeModel.am("fNewAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    posMemberChargeModel.am("nOperationTime", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.bwz.aWA);
    stringBuilder.append("");
    posMemberChargeModel.am("fReceived", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    posMemberChargeModel.am("nDateTime", stringBuilder.toString());
    posMemberChargeModel.am("nSpareField2", paramString1);
    String str = new StringBuilder();
    str.append(RootApplication.getLaiqianPreferenceManager().avs());
    str.append("");
    posMemberChargeModel.am("nSpareField4", str.toString());
    posMemberChargeModel.am("nUserID", RootApplication.getLaiqianPreferenceManager().atm());
    str = new StringBuilder();
    str.append(a.AZ().Be());
    str.append("");
    posMemberChargeModel.am("sSpareField5", str.toString());
    if (paramBoolean) {
      String str1 = "1";
    } else {
      str = "0";
    } 
    posMemberChargeModel.am("sSpareField4", str);
    if (!by.isNull(paramString2))
      posMemberChargeModel.am("nSpareField3", paramString2); 
    paramBoolean = posMemberChargeModel.QL();
    posMemberChargeModel.close();
    if (paramBoolean && LQKVersion.zl() && this.bwK != null && this.bwL != null) {
      g g = new g(this.mContext);
      g.b(this.bwL);
      g.close();
      a a1 = new a(this.mContext);
      str = n.a(Double.valueOf(this.bwK.aSg - this.bwL.aUz), true, false, 3);
      a1.aQ(this.bwK.id, str);
      a1.close();
    } 
    return paramBoolean;
  }
  
  protected boolean fE(String paramString) {
    try {
      exception = new PosMemberChargeModel(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Cursor cursor = exception.fI(paramString);
    if (cursor.getCount() == 0) {
      n.o(this.mContext.getString(R.string.pos_member_charge_number_not_exist));
      cursor.close();
      exception.close();
      return false;
    } 
    cursor.close();
    exception.close();
    return true;
  }
  
  protected void o(aq paramaq) {
    super.o(paramaq);
    if (bd.bH(this.mContext)) {
      (new PosMemberChargeModel.OnlineSyncTask(this.mContext, String.valueOf(paramaq.aWz))).forceLoad();
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
          n.o(this.mContext.getString(R.string.please_check_network));
          return;
        } 
        (new PosMemberAddModel.SendSmsTask(this.mContext, h)).forceLoad();
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */