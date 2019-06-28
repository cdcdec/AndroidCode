package com.laiqian.print.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.print.model.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class e {
  private long aPs = -1L;
  
  private long aRC = -1L;
  
  private final ArrayList<PrintContent> cGK = new ArrayList();
  
  @NonNull
  private s cGL;
  
  private b cGM;
  
  private a cGN = null;
  
  private String cGO = "";
  
  private long cGP = 0L;
  
  private HashMap<String, String> cGQ = new HashMap();
  
  private long cGR = -1L;
  
  private String mName;
  
  private int mResultCode = -1;
  
  private int mStatus = 0;
  
  private long startTime = -1L;
  
  public e(@NonNull s params) { this(params, (PrintContent)null, new b()); }
  
  public e(@NonNull s params, @Nullable PrintContent paramPrintContent, @NonNull b paramb) {
    if (params == null)
      throw new NullPointerException("printer cannot be null"); 
    this.cGL = params;
    if (paramPrintContent != null)
      this.cGK.add(paramPrintContent); 
    this.cGM = paramb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(params.getIdentifier());
    stringBuilder.append(": ");
    if (paramPrintContent != null) {
      str = paramPrintContent.toString();
    } else {
      str = "null";
    } 
    stringBuilder.append(str);
    this.mName = stringBuilder.toString();
    onCreate();
  }
  
  public e(@NonNull s params, @Nullable Collection<PrintContent> paramCollection, b paramb) {
    this.cGL = params;
    if (paramCollection != null)
      this.cGK.addAll(paramCollection); 
    this.cGM = paramb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(params.getIdentifier());
    stringBuilder.append(": ");
    stringBuilder.append(this.cGK.toString());
    this.mName = stringBuilder.toString();
    onCreate();
  }
  
  public void a(a parama) { this.cGN = parama; }
  
  public s aew() { return this.cGL; }
  
  public void afv() {
    this.aRC = System.currentTimeMillis();
    setStatus(5);
  }
  
  public List<PrintContent> ags() { return Collections.unmodifiableList(this.cGK); }
  
  public b agt() { return this.cGM; }
  
  public boolean agu() { return (this.mStatus == 4 || this.mStatus == 5); }
  
  public void agv() {
    this.cGR = System.currentTimeMillis();
    setStatus(2);
  }
  
  public String agw() { return this.cGO; }
  
  public long agx() { return this.cGP; }
  
  public void cx(long paramLong) { this.cGP = paramLong; }
  
  public int getStatus() { return this.mStatus; }
  
  public void lp(String paramString) { this.cGO = paramString; }
  
  public void onCreate() {
    this.aPs = System.currentTimeMillis();
    setStatus(1);
  }
  
  public void onStart() {
    this.startTime = System.currentTimeMillis();
    setStatus(3);
  }
  
  public void setResultCode(int paramInt) { this.mResultCode = paramInt; }
  
  public void setStatus(int paramInt) {
    this.mStatus = paramInt;
    if (this.cGN != null)
      this.cGN.a(this, paramInt); 
  }
  
  public String toString() { return this.mName; }
  
  public void xx() {
    this.aRC = System.currentTimeMillis();
    setStatus(4);
  }
  
  public static interface a {
    void a(e param1e, int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */