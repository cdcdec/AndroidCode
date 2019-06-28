package com.laiqian.member.report;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.at;
import com.laiqian.entity.v;
import com.laiqian.models.j;
import com.laiqian.util.by;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class am {
  private static final String TAG = "am";
  
  private String[] aWO = { "370004", "370005", "370007", "370008", "370009", "370010", "370011" };
  
  an bAg;
  
  private int buK = 50;
  
  public at buM;
  
  ak buN;
  
  j buQ;
  
  Context mContext;
  
  static  {
  
  }
  
  public am(Context paramContext, an paraman) {
    this.mContext = paramContext;
    this.bAg = paraman;
    this.buM = new at();
    init();
  }
  
  public String[] Jd() { return this.buM.Jd(); }
  
  public String[] Je() { return this.buM.Je(); }
  
  public String[] PW() { return this.buN.bzR; }
  
  public void PY() {
    this.buM.dH(null);
    this.buM.dG(null);
    this.buM.cY(false);
  }
  
  public String[] PZ() { return this.buN.D(this.buN.bzM); }
  
  public String[] Qa() {
    d.b("getRechangePayTypeNames", new Object[0]);
    return this.buN.E(this.buN.bzN);
  }
  
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
  
  public HashMap<String, String> Ri() { return this.buN.a(this.buM.Jd(), this.buM.Fu(), this.buM.getUserID(), this.buM.Jf(), this.buM.IY(), this.buM.Jc(), this.buM.Jg(), false); }
  
  public double a(boolean paramBoolean, ArrayList<Map<String, String>> paramArrayList, String[] paramArrayOfString) { return this.buN.a(paramBoolean, paramArrayList, paramArrayOfString); }
  
  public String a(boolean paramBoolean, String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.buN.a(paramBoolean, paramArrayOfString, this.buM.Fu(), this.buM.getUserID(), this.buM.Jf(), this.buM.IY(), this.buM.Jc()));
    stringBuilder.append("");
    return by.a(by.sd(stringBuilder.toString()), 9999, this.mContext);
  }
  
  public void cY(boolean paramBoolean) { this.buM.cY(paramBoolean); }
  
  public void closeDB() { this.buQ.close(); }
  
  public void dJ(String paramString) { this.buM.dJ(paramString); }
  
  public HashMap<String, String> dM(boolean paramBoolean) {
    try {
      return this.buN.b(this.buM.Jd(), this.buM.Fu(), this.buM.getUserID(), this.buM.Jf(), this.buM.IY(), this.buM.Jc(), this.buM.Jg(), paramBoolean);
    } catch (Exception exception) {
      a.e(exception);
      return new HashMap();
    } 
  }
  
  public void dd(String paramString) { this.buM.dd(paramString); }
  
  public void f(long[] paramArrayOfLong) { this.buM.g(new String[] { null, (new String[2][0] = String.valueOf(paramArrayOfLong[0])).valueOf(paramArrayOfLong[1]) }); }
  
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
  
  public String fm(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getPayRechargeTypeNameByPosition nPosition=");
    stringBuilder.append(paramInt);
    d.b(stringBuilder.toString(), new Object[0]);
    return this.buN.E(this.buN.bzN)[paramInt];
  }
  
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
  
  public String getUserID() { return this.buM.getUserID(); }
  
  public void h(String[] paramArrayOfString) { this.buM.h(paramArrayOfString); }
  
  public void init() {
    this.buN = ak.aF(this.mContext).Rd();
    this.buN.fM(this.buM.Jf());
    this.buN.fN(this.buM.Jf());
    this.buN.fO(this.buM.Jf());
    this.buN.fP(this.buM.Jf());
    try {
      this.buQ = new j(this.mContext);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  public ArrayList<Map<String, String>> m(String[] paramArrayOfString) { return this.buN.c(paramArrayOfString, this.buM.Fu(), this.buM.getUserID(), this.buM.Jf(), this.buM.IY(), this.buM.Jc()); }
  
  public String n(long paramLong1, long paramLong2) { return this.buN.a(paramLong1, Long.valueOf(paramLong2)); }
  
  public String o(String paramString1, String paramString2, String paramString3) { return this.buN.o(paramString1, paramString2, paramString3); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */