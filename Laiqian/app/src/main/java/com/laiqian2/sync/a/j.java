package com.laiqian.sync.a;

import android.support.annotation.Nullable;
import com.laiqian.message.m;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
  private String aJg;
  
  @Nullable
  private int aPr = 0;
  
  private String aSI;
  
  private String aYR;
  
  private String bGE;
  
  private int bWU;
  
  private String bfo;
  
  private String cVy;
  
  private long doF = 0L;
  
  private long doG = System.currentTimeMillis();
  
  private final ArrayList<String> doH = new ArrayList();
  
  private boolean doI = true;
  
  private boolean doJ = true;
  
  private boolean doK = true;
  
  private String doL;
  
  private String doM;
  
  private String doN;
  
  private String doO;
  
  @Nullable
  private String doP = null;
  
  public void C(Collection<String> paramCollection) { this.doH.addAll(paramCollection); }
  
  public void dk(long paramLong) { this.doF = paramLong; }
  
  public void dl(long paramLong) { this.doG = paramLong; }
  
  public void gS(boolean paramBoolean) { this.doI = paramBoolean; }
  
  public void gT(boolean paramBoolean) { this.doJ = paramBoolean; }
  
  public void gU(boolean paramBoolean) { this.doK = paramBoolean; }
  
  @Nullable
  public String getDeviceId() { return this.doP; }
  
  public int getRequestType() { return this.bWU; }
  
  public void kh(int paramInt) { this.bWU = paramInt; }
  
  public void ki(@Nullable int paramInt) { this.aPr = paramInt; }
  
  public void nT(@Nullable String paramString) { this.doP = paramString; }
  
  public void nU(String paramString) { this.doL = paramString; }
  
  public void nV(String paramString) { this.doM = paramString; }
  
  public void nW(String paramString) { this.aJg = paramString; }
  
  public void nX(String paramString) { this.bfo = paramString; }
  
  public void nY(String paramString) { this.cVy = paramString; }
  
  public void nZ(String paramString) { this.aYR = paramString; }
  
  public void oa(String paramString) { this.aSI = paramString; }
  
  public void ob(String paramString) { this.doN = paramString; }
  
  public void oc(String paramString) { this.bGE = paramString; }
  
  public void od(String paramString) { this.doO = paramString; }
  
  public JSONObject xy() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    if (this.doJ) {
      jSONObject.put(a.bUC, "YES");
    } else {
      jSONObject.put(a.bUC, "NO");
    } 
    if (this.doI)
      jSONObject.put(a.bUI, "TRUE"); 
    jSONObject.put(SyncProgessMessage.bUD, this.bWU);
    jSONObject.put(a.bUH, this.aSI);
    jSONObject.put(a.bUy, this.aYR);
    jSONObject.put(a.bJz, this.doM);
    jSONObject.put(a.bUx, this.doN);
    jSONObject.put(a.bUY, this.cVy);
    String str2 = a.bUZ;
    if (this.doL == null) {
      str1 = "";
    } else {
      str1 = this.doL;
    } 
    jSONObject.put(str2, str1);
    jSONObject.put(a.bVa, this.doF);
    jSONObject.put(a.bVb, this.doG);
    jSONObject.put(a.bUz, this.bfo);
    jSONObject.put(a.bVh, this.bGE);
    jSONObject.put(a.bVe, "");
    jSONObject.put(a.bVd, "");
    jSONObject.put(a.bVf, this.aJg);
    if (this.doK) {
      jSONObject.put(a.bUA, "YES");
    } else {
      jSONObject.put(a.bUA, "NO");
    } 
    String str1 = "";
    if (this.doH.size() > 0)
      str1 = by.a(",", this.doH); 
    jSONObject.put(a.bVc, str1);
    jSONObject.put(a.bVm, this.doO);
    if (this.doP != null)
      jSONObject.put("sDeviceID", this.doP); 
    if (this.aPr == 0)
      this.aPr = m.getDeviceType(); 
    jSONObject.put("nDeviceType", this.aPr);
    return jSONObject;
  }
  
  public static class a {
    private String aJg;
    
    @Nullable
    private int aPr = 0;
    
    private String aSI;
    
    private String aYR;
    
    private String bGE;
    
    private int bWU;
    
    private String bfo;
    
    private String cVy;
    
    private long doF = 0L;
    
    private long doG = System.currentTimeMillis();
    
    private final ArrayList<String> doH = new ArrayList();
    
    private boolean doI = true;
    
    private boolean doJ = true;
    
    private boolean doK = true;
    
    private String doL;
    
    private String doM;
    
    private String doN;
    
    private String doO;
    
    @Nullable
    private String doP = null;
    
    public j apE() {
      j j = new j();
      if (this.bfo == null)
        throw new IllegalStateException("userPhone is required"); 
      j.nX(this.bfo);
      if (this.cVy == null)
        throw new IllegalStateException("userPass is required"); 
      j.nY(this.cVy);
      if (this.bWU == -1)
        throw new IllegalStateException("requestType is required"); 
      j.kh(this.bWU);
      if (this.aYR == null)
        throw new IllegalStateException("userId is required"); 
      j.nZ(this.aYR);
      if (this.aSI == null)
        throw new IllegalStateException("shopId is required"); 
      j.oa(this.aSI);
      if (this.doM == null)
        throw new IllegalStateException("apkVersion is required"); 
      j.nV(this.doM);
      if (this.aJg == null)
        throw new IllegalStateException("channelId is required"); 
      j.nW(this.aJg);
      if (this.bGE == null)
        throw new IllegalStateException("templateId is required"); 
      j.oc(this.bGE);
      if (this.doN == null)
        throw new IllegalStateException("checkFlag is required"); 
      j.ob(this.doN);
      if (this.doO == null)
        throw new IllegalStateException("industryType is required"); 
      j.od(this.doO);
      j.dk(this.doF);
      j.dl(this.doG);
      j.nT(this.doP);
      j.ki(this.aPr);
      j.nU(this.doL);
      j.gT(this.doJ);
      j.gS(this.doI);
      j.gU(this.doK);
      j.C(this.doH);
      return j;
    }
    
    public a gV(boolean param1Boolean) {
      this.doK = param1Boolean;
      return this;
    }
    
    public a kj(int param1Int) {
      this.bWU = param1Int;
      return this;
    }
    
    public a kk(int param1Int) {
      this.aPr = param1Int;
      return this;
    }
    
    public a oe(String param1String) {
      this.bfo = param1String;
      return this;
    }
    
    public a of(String param1String) {
      this.cVy = param1String;
      return this;
    }
    
    public a og(String param1String) {
      this.doL = param1String;
      return this;
    }
    
    public a oh(String param1String) {
      this.aYR = param1String;
      return this;
    }
    
    public a oi(String param1String) {
      this.aSI = param1String;
      return this;
    }
    
    public a oj(String param1String) {
      this.doP = param1String;
      return this;
    }
    
    public a ok(String param1String) {
      this.doM = param1String;
      return this;
    }
    
    public a ol(String param1String) {
      this.aJg = param1String;
      return this;
    }
    
    public a om(String param1String) {
      this.doN = param1String;
      return this;
    }
    
    public a on(String param1String) {
      this.bGE = param1String;
      return this;
    }
    
    public a oo(String param1String) {
      this.doO = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */