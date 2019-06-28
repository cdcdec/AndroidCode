package com.laiqian.entity;

import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class a {
  @NotNull
  private final String aRo;
  
  @NotNull
  private final String aRp;
  
  @NotNull
  private final String aRq;
  
  private final boolean aRr;
  
  private final boolean aRs;
  
  public a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean1, boolean paramBoolean2) {
    this.aRo = paramString1;
    this.aRp = paramString2;
    this.aRq = paramString3;
    this.aRr = paramBoolean1;
    this.aRs = paramBoolean2;
  }
  
  @NotNull
  public final String Er() { return this.aRo; }
  
  @NotNull
  public final String Es() { return this.aRp; }
  
  @NotNull
  public final String Et() { return this.aRq; }
  
  public final boolean Eu() { return this.aRs; }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject instanceof a) {
        paramObject = (a)paramObject;
        if (f.r(this.aRo, paramObject.aRo) && f.r(this.aRp, paramObject.aRp) && f.r(this.aRq, paramObject.aRq)) {
          boolean bool;
          if (this.aRr == paramObject.aRr) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool) {
            if (this.aRs == paramObject.aRs) {
              bool = true;
            } else {
              bool = false;
            } 
            if (bool)
              return true; 
          } 
        } 
      } 
      return false;
    } 
    return true;
  }
  
  public int hashCode() { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BindingEntity(paymentFunction=");
    stringBuilder.append(this.aRo);
    stringBuilder.append(", passagewayA=");
    stringBuilder.append(this.aRp);
    stringBuilder.append(", passagewayB=");
    stringBuilder.append(this.aRq);
    stringBuilder.append(", aActivated=");
    stringBuilder.append(this.aRr);
    stringBuilder.append(", bActivated=");
    stringBuilder.append(this.aRs);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */