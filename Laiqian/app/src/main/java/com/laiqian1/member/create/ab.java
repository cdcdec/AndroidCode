package com.laiqian.member.create;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.member.model.PosMemberAddModel;
import com.laiqian.member.setting.bc;
import com.laiqian.member.setting.sms.h;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.product.models.g;
import com.laiqian.promotion.c.a;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.zhuge.analysis.b.a;
import java.util.Date;
import java.util.HashMap;

public class ab extends VipCreateDialog {
  String btA;
  
  String btz;
  
  PosMemberAddModel bxD;
  
  public ab(Context paramContext) { super(paramContext); }
  
  protected boolean J(String paramString1, String paramString2) {
    try {
      this.bxD = new PosMemberAddModel(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
    } 
    return this.bxD.L(paramString1, paramString2);
  }
  
  protected void QG() {
    if (bc.RH().fY("isOpenSMSNotice") && bc.RH().fY("isMemberChargeNoticed"))
      if (!bd.bH(this.mContext)) {
        Toast.makeText(this.mContext, this.mContext.getString(R.string.please_check_network), 0).show();
      } else {
        h h = new h();
        String str = new StringBuilder();
        str.append((QF()).aWA);
        str.append("");
        h.bGF = str.toString();
        h.aTp = (QF()).aTp;
        if ((QF()).aWB > 0.0D) {
          str = new StringBuilder();
          str.append((QF()).aWB);
          str.append("");
          String str1 = str.toString();
        } else {
          str = "0";
        } 
        h.bGD = str;
        if ((QF()).aWB > 0.0D) {
          str = "SMS_12300424";
        } else {
          str = "SMS_12185283";
        } 
        h.bGE = str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((QF()).aWA + (QF()).aWB);
        stringBuilder.append("");
        h.aTt = stringBuilder.toString();
        (new PosMemberAddModel.SendSmsTask(this.mContext, h)).forceLoad();
      }  
    c c = c.bp(this.mContext);
    Double double1;
    Double double2 = (double1 = Double.valueOf((QF()).aWA)).valueOf((QF()).aWB);
    HashMap hashMap = new HashMap();
    hashMap.put("赠送金额", double2);
    hashMap.put("充值金额", double1);
    hashMap.put("充值方式", "现金");
    hashMap.put("会员手机号", (QF()).aTp);
    hashMap.put("充值后余额", Double.valueOf(double1.doubleValue() + double2.doubleValue()));
    a.aAU().c(this.mContext, "会员充值", hashMap);
    if (double1.doubleValue() + double2.doubleValue() > 0.0D) {
      String str3 = this.bwG.byt;
      PrintContent.a a = new PrintContent.a();
      if (this.mContext.getString(R.string.pos_main_pay_payment_cash).equals(str3))
        a.age(); 
      String str1 = a.afV();
      c.bp(getContext());
      c.e(str1);
      if (n.bL(getContext())) {
        String str = by.bv((QF()).name, "*");
      } else {
        str1 = (QF()).name;
      } 
      String str2 = str3;
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
        str2 = str3;
        if (this.mContext.getString(R.string.pos_main_pay_payment_cash).equals(str3))
          str2 = ""; 
      } 
      c.e(c.a(new Date(System.currentTimeMillis()), str1, by.bu((QF()).aTp, "****"), by.bu((QF()).aWn, "****"), Double.valueOf(0.0D), double1, double2, null, str2));
      getContext().sendBroadcast(new Intent("android.intent.money_test.action"));
    } 
    initialData();
    this.mContext.sendBroadcast((new Intent()).setAction("pos_activity_change_data_paytype"));
    dismiss();
  }
  
  protected void QH() {
    String str = this.bxD.Vn();
    if ("-2".equals(str)) {
      this.bwZ.requestFocus();
      this.bwZ.selectAll();
      this.bwZ.performClick();
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_mobile_already_exists), 0).show();
    } 
    if ("-1".equals(str)) {
      this.bxa.requestFocus();
      this.bxa.selectAll();
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_number_already_exists), 0).show();
    } 
  }
  
  protected void QI() {
    String str = this.bxD.Vn();
    if ("-2".equals(str)) {
      this.bwZ.requestFocus();
      this.bwZ.selectAll();
      this.bwZ.performClick();
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_mobile_already_exists), 0).show();
      return;
    } 
    if ("-1".equals(str)) {
      this.bxa.requestFocus();
      this.bxa.selectAll();
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_number_already_exists), 0).show();
      return;
    } 
    Toast.makeText(this.mContext, str, 0).show();
  }
  
  protected void onStop() {
    super.onStop();
    if (this.bxD != null)
      this.bxD.close(); 
  }
  
  protected boolean p(aq paramaq) {
    stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    this.btz = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    this.btA = stringBuilder.toString();
    try {
      this.bxD = new PosMemberAddModel(this.mContext);
    } catch (Exception stringBuilder) {
      a.e(stringBuilder);
    } 
    boolean bool = this.bxD.a(paramaq, this.btz, this.btA, this.bxq, this.bwG.byv, this.bwG.byu);
    if (bool && LQKVersion.zl() && this.bwK != null && this.bwL != null) {
      g g = new g(this.mContext);
      g.b(this.bwL);
      g.close();
      a a = new a(this.mContext);
      String str = n.a(Double.valueOf(this.bwK.aSg - this.bwL.aUz), true, false, 3);
      a.aQ(this.bwK.id, str);
      a.close();
    } 
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */