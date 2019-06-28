package com.laiqian.print.model;

import android.support.annotation.NonNull;
import java.io.Serializable;

public abstract class s implements Serializable, Cloneable {
  private int cHl = 0;
  
  private boolean cHm = true;
  
  private boolean connected = false;
  
  private int height = 0;
  
  private String mIdentifier;
  
  private String mName;
  
  private final int mType;
  
  private int width = 0;
  
  public s(@NonNull String paramString, int paramInt) {
    this.mIdentifier = paramString;
    this.mName = paramString;
    this.mType = paramInt;
  }
  
  public int agF() { return this.cHl; }
  
  public boolean agH() { return this.cHm; }
  
  public Object clone() throws CloneNotSupportedException { return super.clone(); }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (s)paramObject;
      return (this.mType != paramObject.mType) ? false : ((this.cHl != paramObject.cHl) ? false : ((this.width != paramObject.width) ? false : ((this.height != paramObject.height) ? false : ((this.cHm != paramObject.cHm) ? false : (!this.mIdentifier.equals(paramObject.mIdentifier) ? false : ((this.mName != null) ? this.mName.equals(paramObject.mName) : ((paramObject.mName == null) ? 1 : 0)))))));
    } 
    return false;
  }
  
  public void fP(boolean paramBoolean) { this.cHm = paramBoolean; }
  
  public int getHeight() { return this.height; }
  
  public String getIdentifier() { return this.mIdentifier; }
  
  public String getName() { return this.mName; }
  
  public int getType() { return this.mType; }
  
  public String getTypeName() {
    switch (this.mType) {
      default:
        return "Unknown";
      case 4:
        return "Serial";
      case 3:
        return "Bluetooth";
      case 2:
        return "Net";
      case 1:
        break;
    } 
    return "USB";
  }
  
  public int getWidth() { return this.width; }
  
  public int hashCode() { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public void ii(int paramInt) { this.cHl = paramInt; }
  
  public boolean isConnected() { return this.connected; }
  
  public void lq(String paramString) { this.mIdentifier = paramString; }
  
  public void setConnected(boolean paramBoolean) { this.connected = paramBoolean; }
  
  public void setHeight(int paramInt) { this.height = paramInt; }
  
  public void setName(String paramString) { this.mName = paramString; }
  
  public void setWidth(int paramInt) { this.width = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */