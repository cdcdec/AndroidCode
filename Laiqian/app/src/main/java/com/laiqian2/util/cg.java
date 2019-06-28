package com.laiqian.util;

import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class cg<A, B, C, D> extends Object {
  private final C dGI;
  
  private final D dGJ;
  
  private final A first;
  
  private final B second;
  
  public cg(A paramA, B paramB, C paramC, D paramD) {
    this.first = paramA;
    this.second = paramB;
    this.dGI = paramC;
    this.dGJ = paramD;
  }
  
  public final C awA() { return (C)this.dGI; }
  
  public final D awB() { return (D)this.dGJ; }
  
  public final A awy() { return (A)this.first; }
  
  public final B awz() { return (B)this.second; }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject instanceof cg) {
        paramObject = (cg)paramObject;
        if (f.r(this.first, paramObject.first) && f.r(this.second, paramObject.second) && f.r(this.dGI, paramObject.dGI) && f.r(this.dGJ, paramObject.dGJ))
          return true; 
      } 
      return false;
    } 
    return true;
  }
  
  public int hashCode() {
    byte b2;
    byte b1;
    boolean bool;
    Object object = this.first;
    int i = 0;
    if (object != null) {
      bool = object.hashCode();
    } else {
      bool = false;
    } 
    object = this.second;
    if (object != null) {
      b1 = object.hashCode();
    } else {
      b1 = 0;
    } 
    object = this.dGI;
    if (object != null) {
      b2 = object.hashCode();
    } else {
      b2 = 0;
    } 
    object = this.dGJ;
    if (object != null)
      i = object.hashCode(); 
    return ((bool * 31 + b1) * 31 + b2) * 31 + i;
  }
  
  @NotNull
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('(');
    stringBuilder.append(this.first);
    stringBuilder.append(", ");
    stringBuilder.append(this.second);
    stringBuilder.append(", ");
    stringBuilder.append(this.dGI);
    stringBuilder.append(',');
    stringBuilder.append(this.dGJ);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */