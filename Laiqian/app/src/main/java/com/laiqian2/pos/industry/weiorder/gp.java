package com.laiqian.pos.industry.weiorder;

import com.laiqian.util.by;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gp implements Serializable {
  final String aSI;
  
  boolean aSL = true;
  
  boolean aSM = false;
  
  String aSQ = "";
  
  boolean aSS = true;
  
  ArrayList<eh> ctj = new ArrayList();
  
  boolean cxa = true;
  
  double cxb = 0.0D;
  
  double cxc = 0.0D;
  
  double cxd = 0.0D;
  
  int cxe = 20;
  
  String cxf = "";
  
  double discount = 100.0D;
  
  public gp(String paramString) { this.aSI = paramString; }
  
  public static gp f(JSONObject paramJSONObject, String paramString) {
    try {
      gp gp1 = new gp(paramString);
      boolean bool1 = false;
      try {
        JSONArray jSONArray = (new JSONObject(by.sf(paramJSONObject.getString("coupons")))).getJSONArray("Discount");
        for (byte b = 0; b < jSONArray.length(); b++) {
          String[] arrayOfString = ((JSONObject)jSONArray.get(b)).getString("value").split(",");
          String str3 = arrayOfString[0];
          String str4 = arrayOfString[1];
          gp1.ach().add(new eh(Double.parseDouble(str3), Double.parseDouble(str4)));
        } 
      } catch (JSONException jSONException) {}
      gp1.p(paramJSONObject.getDouble("discount"));
      str1 = paramJSONObject.getString("minimum_price");
      String str2 = paramJSONObject.getString("delivery_price");
      gp1.kc(paramJSONObject.optString("deliver_tax"));
      try {
        gp1.az(Double.parseDouble(str1));
        gp1.aD(Double.parseDouble(str2));
      } catch (NumberFormatException str1) {}
      try {
        gp1.hi(Integer.parseInt(paramJSONObject.getString("delivery_time")));
      } catch (Exception str1) {}
      paramJSONObject = new JSONObject(by.sf(paramJSONObject.getString("payment_way")));
      if (paramJSONObject.getInt("WeiXinPay") == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      gp1.cJ(bool);
      if (paramJSONObject.getInt("CashPay") == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      gp1.ft(bool);
      boolean bool = bool1;
      if (paramJSONObject.optInt("VipPay", 0) == 1)
        bool = true; 
      gp1.cE(bool);
      paramJSONObject.getInt("AliPay");
      return gp1;
    } catch (JSONException paramJSONObject) {
      return null;
    } 
  }
  
  public static gp k(JSONObject paramJSONObject) {
    try {
      gp gp1 = new gp(paramJSONObject.getString("shopid"));
      boolean bool1 = false;
      try {
        JSONArray jSONArray = (new JSONObject(by.sf(paramJSONObject.getString("sAmountDiscount")))).getJSONArray("Discount");
        for (byte b = 0; b < jSONArray.length(); b++) {
          String[] arrayOfString = ((JSONObject)jSONArray.get(b)).getString("value").split(",");
          String str5 = arrayOfString[0];
          String str6 = arrayOfString[1];
          gp1.ach().add(new eh(Double.parseDouble(str5), Double.parseDouble(str6)));
        } 
      } catch (JSONException jSONException) {}
      gp1.kc(paramJSONObject.optString("deliver_tax"));
      gp1.p(paramJSONObject.getDouble("fRebates"));
      str1 = paramJSONObject.getString("fMinSellStartAmount");
      String str2 = paramJSONObject.getString("fDishwareAmount");
      String str3 = paramJSONObject.getString("fDeliverAmount");
      if (paramJSONObject.getInt("bIsLqkWechatAccount") == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      String str4 = paramJSONObject.getString("sWechatPayAccount");
      gp1.cD(bool);
      gp1.di(str4);
      try {
        gp1.az(Double.parseDouble(str1));
        gp1.aE(Double.parseDouble(str2));
        gp1.aD(Double.parseDouble(str3));
      } catch (NumberFormatException str1) {}
      paramJSONObject = new JSONObject(by.sf(paramJSONObject.getString("sPayType")));
      if (paramJSONObject.getInt("WeiXinPay") == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      gp1.cJ(bool);
      if (paramJSONObject.getInt("CashPay") == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      gp1.ft(bool);
      boolean bool = bool1;
      if (paramJSONObject.optInt("VipPay", 0) == 1)
        bool = true; 
      gp1.cE(bool);
      return gp1;
    } catch (JSONException paramJSONObject) {
      return null;
    } 
  }
  
  public boolean FA() { return this.aSS; }
  
  public String FD() { return this.aSQ; }
  
  public boolean FH() { return this.aSL; }
  
  public double FI() { return this.discount; }
  
  public void aD(double paramDouble) { this.cxc = paramDouble; }
  
  public void aE(double paramDouble) { this.cxd = paramDouble; }
  
  public ArrayList<eh> ach() { return this.ctj; }
  
  public double aci() { return this.cxc; }
  
  public double acj() { return this.cxd; }
  
  public double ack() { return this.cxb; }
  
  public boolean acl() { return this.cxa; }
  
  public int acm() { return this.cxe; }
  
  public String acn() { return this.cxf; }
  
  public boolean aco() { return this.aSM; }
  
  public gp acp() {
    gp gp1 = new gp(this.aSI);
    gp1.aSL = this.aSL;
    gp1.cxa = this.cxa;
    gp1.cxb = this.cxb;
    gp1.discount = this.discount;
    gp1.cxe = this.cxe;
    gp1.cxc = this.cxc;
    gp1.cxf = this.cxf;
    gp1.cxd = this.cxd;
    gp1.aSQ = this.aSQ;
    gp1.aSS = this.aSS;
    gp1.aSM = this.aSM;
    gp1.ctj = new ArrayList(this.ctj.size());
    for (eh eh : this.ctj)
      gp1.ctj.add(new eh(eh.cvC, eh.discount)); 
    return gp1;
  }
  
  public void af(ArrayList<eh> paramArrayList) { this.ctj = paramArrayList; }
  
  public void az(double paramDouble) { this.cxb = paramDouble; }
  
  public void cD(boolean paramBoolean) { this.aSS = paramBoolean; }
  
  public void cE(boolean paramBoolean) { this.aSM = paramBoolean; }
  
  public void cJ(boolean paramBoolean) { this.aSL = paramBoolean; }
  
  public void di(String paramString) { this.aSQ = paramString; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof gp))
      return false; 
    paramObject = (gp)paramObject;
    return (this.aSL != paramObject.aSL) ? false : ((this.cxa != paramObject.cxa) ? false : ((this.aSM != paramObject.aSM) ? false : ((this.cxb != paramObject.cxb) ? false : ((this.cxc != paramObject.cxc) ? false : ((this.cxe != paramObject.cxe) ? false : ((this.cxd != paramObject.cxd) ? false : (!this.ctj.equals(paramObject.ctj) ? false : ((this.discount != paramObject.discount) ? false : (!(this.aSS != paramObject.aSS))))))))));
  }
  
  public void ft(boolean paramBoolean) { this.cxa = paramBoolean; }
  
  public void hi(int paramInt) { this.cxe = paramInt; }
  
  public void kc(String paramString) { this.cxf = paramString; }
  
  public void p(double paramDouble) { this.discount = paramDouble; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */