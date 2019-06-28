package com.laiqian.member;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Size;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.at;
import com.laiqian.entity.v;
import com.laiqian.member.g.a;
import com.laiqian.member.report.ak;
import com.laiqian.member.setting.bc;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.util.au;
import com.laiqian.util.bb;
import com.laiqian.util.bh;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ap {
  String btU;
  
  private int buK = 50;
  
  ar buL;
  
  private at buM;
  
  private ak buN;
  
  private String[] buO;
  
  private aq buP;
  
  j buQ;
  
  Context mContext;
  
  ap(ar paramar, Context paramContext) {
    this.buL = paramar;
    this.mContext = paramContext;
  }
  
  public String[] Fu() { return this.buM.Fu(); }
  
  public aq I(String paramString1, String paramString2) {
    null = new HashMap();
    null.put("shop_id", paramString2);
    null.put("member_id", this.buM.Jf());
    null.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    null.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    null.put("auth_type", "0");
    null.put("version", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder.append("");
    null.put("scope", stringBuilder.toString());
    String str = bh.a(RootUrlParameter.ckE, RootApplication.zv().getApplicationContext(), null);
    if (!TextUtils.isEmpty(str)) {
      HashMap hashMap = au.qC(str);
      if (hashMap.containsKey("result") && "TRUE".equals(hashMap.get("result"))) {
        hashMap = au.qC((String)hashMap.get("message"));
        aq aq1 = new aq();
        aq1.aWn = (String)hashMap.get("sNumber");
        aq1.aJX = (String)hashMap.get("sField1");
        aq1.aWo = n.u((CharSequence)hashMap.get("fAmount"));
        aq1.aSW = n.parseLong((String)hashMap.get("_id"));
        aq1.name = (String)hashMap.get("sName");
        aq1.aTp = (String)hashMap.get("sContactMobilePhone");
        aq1.aVq = (String)hashMap.get("nDateTime");
        aq1.aWp = n.parseLong((String)hashMap.get("fPoints"));
        aq1.aVw = (String)hashMap.get("nSpareField1");
        aq1.dy((String)hashMap.get("sSpareField1"));
        aq1.aWx = (String)hashMap.get("sBPartnerTypeName");
        aq1.aWw = n.parseLong((String)hashMap.get("nBPartnerType"));
        aq1.aWC = n.parseInt((String)hashMap.get("nShopID"));
        aq1.aWq = (String)hashMap.get("fSpareField3");
        aq1.aWs = (String)hashMap.get("nowTime");
        return aq1;
      } 
      return (hashMap.containsKey("result") && "FALSE".equals(hashMap.get("result"))) ? null : null;
    } 
    return null;
  }
  
  public String[] Je() { return this.buM.Je(); }
  
  public String PT() { return this.buM.Jf(); }
  
  public String[] PU() { return this.buO; }
  
  public aq PV() { return this.buP; }
  
  public String[] PW() { return this.buN.bzR; }
  
  @Size
  public Double[] PX() { return this.buN.fR(this.buM.Jf()); }
  
  public void PY() {
    this.buM.dH(null);
    this.buM.dG(null);
    this.buM.cY(false);
  }
  
  public String[] PZ() { return this.buN.D(this.buN.bzM); }
  
  public String[] Qa() { return this.buN.E(this.buN.bzN); }
  
  public String[] Qb() { return this.buN.F(this.buN.bzO); }
  
  public void Qc() {
    try {
      this.buQ = new j(this.mContext);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  public String Qd() {
    try {
      return this.buQ.a(this.buM);
    } catch (Exception exception) {
      a.e(exception);
      return null;
    } 
  }
  
  public String[] Qe() { return this.buQ.VJ(); }
  
  public double a(boolean paramBoolean, ArrayList<Map<String, String>> paramArrayList, String[] paramArrayOfString) { return this.buN.a(paramBoolean, paramArrayList, paramArrayOfString); }
  
  public void a(long paramLong, String paramString, long[] paramArrayOfLong) {
    this.btU = paramString;
    this.buM = new at();
    this.buM.dI(String.valueOf(paramLong));
    this.buM.g(new String[] { null, (new String[2][0] = String.valueOf(paramArrayOfLong[0])).valueOf(paramArrayOfLong[1]) });
    this.buN = ak.aF(this.mContext).Rd();
    this.buN.fM(this.buM.Jf());
    this.buN.fN(this.buM.Jf());
    this.buN.fO(this.buM.Jf());
    this.buN.fP(this.buM.Jf());
    try {
      this.buQ = new j(this.mContext);
    } catch (Exception paramString) {
      a.e(paramString);
    } 
    this.buO = new String[] { this.mContext.getString(R.string.pos_vip_all_type_tltle), this.mContext.getString(R.string.pos_vip_consume_title), this.mContext.getString(R.string.pos_vip_charge_title), this.mContext.getString(R.string.pos_vip_point_title) };
    if (a.zR().zZ())
      this.buO = new String[] { this.mContext.getString(R.string.pos_vip_all_type_tltle), this.mContext.getString(R.string.pos_vip_consume_title), this.mContext.getString(R.string.pos_vip_charge_title), this.mContext.getString(R.string.vip_initial_balance_lab), this.mContext.getString(R.string.pos_vip_point_title) }; 
    (new a(this, null)).execute(new Void[0]);
  }
  
  public void cY(boolean paramBoolean) { this.buM.cY(paramBoolean); }
  
  public void closeDB() { this.buQ.close(); }
  
  public void dJ(String paramString) { this.buM.dJ(paramString); }
  
  public String fj(int paramInt) { return (paramInt >= this.buN.bzR.length || paramInt < 0) ? "" : this.buN.bzR[paramInt]; }
  
  public void fk(int paramInt) {
    this.buM.dH(String.valueOf(((v)this.buN.bzM.get(paramInt)).aSX));
    if (Integer.parseInt(this.buM.Jb()) == 10013) {
      this.buM.dG(String.valueOf(((v)this.buN.bzM.get(paramInt)).aSW));
      return;
    } 
    this.buM.dG(null);
  }
  
  public String fl(int paramInt) { return this.buN.D(this.buN.bzM)[paramInt]; }
  
  public String fm(int paramInt) { return this.buN.E(this.buN.bzN)[paramInt]; }
  
  public String fn(int paramInt) { return this.buN.F(this.buN.bzO)[paramInt]; }
  
  public void fo(int paramInt) {
    this.buM.dH(String.valueOf(((v)this.buN.bzN.get(paramInt)).aSX));
    if (Integer.parseInt(this.buM.Jb()) == 10013) {
      this.buM.dG(String.valueOf(((v)this.buN.bzN.get(paramInt)).aSW));
      return;
    } 
    this.buM.dG(null);
  }
  
  public void fp(int paramInt) {
    this.buM.dH(String.valueOf(((v)this.buN.bzO.get(paramInt)).aSX));
    if (Integer.parseInt(this.buM.Jb()) == 10013) {
      this.buM.dG(String.valueOf(((v)this.buN.bzO.get(paramInt)).aSW));
      return;
    } 
    this.buM.dG(null);
  }
  
  public String fq(int paramInt) {
    try {
      exception = this.buQ.b(this.buM);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(exception);
    stringBuilder.append(" limit ");
    stringBuilder.append(this.buK * paramInt);
    stringBuilder.append(",");
    stringBuilder.append(this.buK);
    return stringBuilder.toString();
  }
  
  public void h(String[] paramArrayOfString) { this.buM.h(paramArrayOfString); }
  
  public void m(long paramLong1, long paramLong2) {
    c c = c.bp(this.mContext);
    a = new a(this.mContext);
    try {
      PrintContent printContent = a.a(this.buP, paramLong1, paramLong2);
    } catch (Exception a) {
      a.e(a);
      a = null;
    } 
    c.e(a);
  }
  
  public String n(long paramLong1, long paramLong2) { return this.buN.a(paramLong1, Long.valueOf(paramLong2)); }
  
  public String o(String paramString1, String paramString2, String paramString3) { return this.buN.o(paramString1, paramString2, paramString3); }
  
  private class a extends AsyncTask<Void, Void, aq> {
    private a(ap this$0) {}
    
    protected aq f(Void... param1VarArgs) {
      aq aq;
      if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
        l l = new l(this.buR.mContext);
        bb.e("nBPartnerID", ap.a(this.buR).Jf());
        aq = l.hp(ap.a(this.buR).Jf());
        l.close();
      } else {
        aq = this.buR.I(ap.a(this.buR).Jf(), this.buR.btU);
      } 
      bc.RH().v(aq);
      return aq;
    }
    
    protected void m(aq param1aq) {
      if (param1aq != null) {
        ap.a(this.buR, param1aq);
        this.buR.buL.l(param1aq);
        return;
      } 
      this.buR.buL.l(null);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */