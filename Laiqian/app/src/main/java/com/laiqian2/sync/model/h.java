package com.laiqian.sync.model;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.b;
import com.laiqian.infrastructure.R;
import com.laiqian.message.m;
import com.laiqian.pos.industry.a;
import com.laiqian.sync.c.a;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.l;
import org.json.JSONObject;

public class h {
  private String TAG = "SyncRequestParams";
  
  private String aDZ;
  
  private String aGA;
  
  @Nullable
  private int aPr = 0;
  
  private String bKa;
  
  private String bLK;
  
  private long bLj = 0L;
  
  private long bLk = System.currentTimeMillis();
  
  private String bLz;
  
  private String cgt;
  
  @Nullable
  private String doP = null;
  
  private int doT;
  
  private boolean dov = true;
  
  private boolean dpe = true;
  
  private String dpf;
  
  private Context mContext;
  
  public h(Context paramContext) { this.mContext = paramContext; }
  
  public String Ea() { return this.bLz; }
  
  public String aX(String paramString1, String paramString2) {
    try {
      return bd.d(paramString1, bd.rN(paramString2));
    } catch (Exception paramString1) {
      a.e(paramString1);
      return "";
    } 
  }
  
  public String apJ() { return this.cgt; }
  
  public boolean apK() { return this.dov; }
  
  public String apL() {
    String[] arrayOfString;
    av av = new av(this.mContext);
    if (this.bLz == null)
      this.bLz = av.Ea(); 
    if (this.bLK == null)
      this.bLK = av.atr(); 
    if (this.aDZ == null)
      this.aDZ = av.atm(); 
    if (this.aGA == null)
      this.aGA = av.Tx(); 
    if (this.aGA == null)
      this.aGA = av.Tx(); 
    if (this.dpf == null)
      this.dpf = av.getVersion(); 
    long l = Long.parseLong(this.aDZ);
    JSONObject jSONObject = new JSONObject();
    try {
      if (this.dov) {
        jSONObject.put(a.bUC, "YES");
      } else {
        jSONObject.put(a.bUC, "NO");
      } 
      if (this.dpe)
        jSONObject.put(a.bUI, "TRUE"); 
      jSONObject.put(SyncProgessMessage.bUD, this.doT);
      jSONObject.put(a.bUH, av.Tx());
      jSONObject.put(a.bUy, this.aDZ);
      jSONObject.put(a.bJz, this.dpf);
      arrayOfString = dj(l);
      jSONObject.put(a.bUx, arrayOfString);
      jSONObject.put(a.bUY, this.bLK);
      String str = a.bUZ;
      if (this.bKa == null) {
        arrayOfString = "";
      } else {
        arrayOfString = this.bKa;
      } 
      jSONObject.put(str, arrayOfString);
      jSONObject.put(a.bVa, this.bLj);
      jSONObject.put(a.bVb, this.bLk);
      jSONObject.put(a.bUz, av.Ea());
      if (this.doT == 163) {
        jSONObject.put(a.bVh, a.cri);
      } else {
        jSONObject.put(a.bVh, a.crg);
      } 
      jSONObject.put(a.bVe, "");
      jSONObject.put(a.bVd, "");
      jSONObject.put(a.bVf, this.mContext.getString(R.string.r_channelID));
      jSONObject.put(a.bUA, a.bVj);
      if (this.cgt == null)
        this.cgt = ""; 
      jSONObject.put(a.bVc, this.cgt);
      jSONObject.put(a.bVm, a.crh);
      if (this.doP != null)
        jSONObject.put("sDeviceID", this.doP); 
      if (this.aPr == 0)
        this.aPr = m.getDeviceType(); 
      jSONObject.put("nDeviceType", this.aPr);
      arrayOfString = b.encode(jSONObject.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("加密前请求参数 jsons = ");
      stringBuilder2.append(jSONObject.toString());
      bb.fU(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("加密后请求参数 sEncrypted = ");
      stringBuilder1.append(arrayOfString);
      bb.fU(stringBuilder1.toString());
      av.close();
      return arrayOfString;
    } catch (Exception null) {
      a.e(arrayOfString);
      av.close();
      return null;
    } finally {}
    av.close();
    throw arrayOfString;
  }
  
  protected String dj(long paramLong) { return l.dj(paramLong); }
  
  public void dk(long paramLong) { this.bLj = paramLong; }
  
  public void dl(long paramLong) { this.bLk = paramLong; }
  
  public void gX(boolean paramBoolean) { this.dov = paramBoolean; }
  
  public String getPassword() { return this.bLK; }
  
  public void init() {
    this.bLz = null;
    this.bLK = null;
    this.doT = 0;
    this.bLj = 0L;
    this.bLk = System.currentTimeMillis();
    this.cgt = "";
    this.dpe = true;
    this.dov = true;
    this.bKa = "";
    this.aDZ = null;
    this.aGA = null;
    this.dpf = null;
  }
  
  public void ki(@Nullable int paramInt) { this.aPr = paramInt; }
  
  public void km(int paramInt) { this.doT = paramInt; }
  
  public void nR(String paramString) { this.cgt = paramString; }
  
  public void nT(String paramString) { this.doP = paramString; }
  
  public void nX(String paramString) { this.bLz = paramString; }
  
  public void setFileName(String paramString) { this.bKa = paramString; }
  
  public void setPassword(String paramString) { this.bLK = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\model\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */