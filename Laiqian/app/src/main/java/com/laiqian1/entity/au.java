package com.laiqian.entity;

import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class au {
  private final long aTe;
  
  private final int aTv;
  
  private final double aWA;
  
  private final double aWB;
  
  private final long aWS;
  
  @NotNull
  private final String aWT;
  
  private final double aWy;
  
  private final long aWz;
  
  @NotNull
  private final String info;
  
  @NotNull
  private final String orderNo;
  
  private final long startTime;
  
  public au(long paramLong1, @NotNull String paramString1, @NotNull String paramString2, int paramInt, long paramLong2, double paramDouble1, double paramDouble2, double paramDouble3, long paramLong3, long paramLong4, @NotNull String paramString3) {
    this.startTime = paramLong1;
    this.info = paramString1;
    this.orderNo = paramString2;
    this.aTv = paramInt;
    this.aTe = paramLong2;
    this.aWy = paramDouble1;
    this.aWA = paramDouble2;
    this.aWB = paramDouble3;
    this.aWz = paramLong3;
    this.aWS = paramLong4;
    this.aWT = paramString3;
  }
  
  public final long Jh() { return this.aTe; }
  
  public final double Ji() { return this.aWA; }
  
  public boolean equals(Object paramObject) {
    if (this != paramObject) {
      if (paramObject instanceof au) {
        boolean bool;
        paramObject = (au)paramObject;
        if (this.startTime == paramObject.startTime) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool && f.r(this.info, paramObject.info) && f.r(this.orderNo, paramObject.orderNo)) {
          if (this.aTv == paramObject.aTv) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool) {
            if (this.aTe == paramObject.aTe) {
              bool = true;
            } else {
              bool = false;
            } 
            if (bool && Double.compare(this.aWy, paramObject.aWy) == 0 && Double.compare(this.aWA, paramObject.aWA) == 0 && Double.compare(this.aWB, paramObject.aWB) == 0) {
              if (this.aWz == paramObject.aWz) {
                bool = true;
              } else {
                bool = false;
              } 
              if (bool) {
                if (this.aWS == paramObject.aWS) {
                  bool = true;
                } else {
                  bool = false;
                } 
                if (bool && f.r(this.aWT, paramObject.aWT))
                  return true; 
              } 
            } 
          } 
        } 
      } 
      return false;
    } 
    return true;
  }
  
  public final long getStartTime() { return this.startTime; }
  
  public int hashCode() {
    int j;
    int i;
    long l = this.startTime;
    int m = (int)(l ^ l >>> 32);
    String str = this.info;
    int k = 0;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    } 
    str = this.orderNo;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    } 
    int n = this.aTv;
    l = this.aTe;
    int i1 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aWy);
    int i2 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aWA);
    int i3 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aWB);
    int i4 = (int)(l ^ l >>> 32);
    l = this.aWz;
    int i5 = (int)(l ^ l >>> 32);
    l = this.aWS;
    int i6 = (int)(l ^ l >>> 32);
    str = this.aWT;
    if (str != null)
      k = str.hashCode(); 
    return (((((((((m * 31 + i) * 31 + j) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + k;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("VipTempEntity(startTime=");
    stringBuilder.append(this.startTime);
    stringBuilder.append(", info=");
    stringBuilder.append(this.info);
    stringBuilder.append(", orderNo=");
    stringBuilder.append(this.orderNo);
    stringBuilder.append(", payTypeID=");
    stringBuilder.append(this.aTv);
    stringBuilder.append(", specificPayTypeID=");
    stringBuilder.append(this.aTe);
    stringBuilder.append(", newAmount=");
    stringBuilder.append(this.aWy);
    stringBuilder.append(", chargeAmount=");
    stringBuilder.append(this.aWA);
    stringBuilder.append(", chargeGrantAmount=");
    stringBuilder.append(this.aWB);
    stringBuilder.append(", chargeId=");
    stringBuilder.append(this.aWz);
    stringBuilder.append(", vipID=");
    stringBuilder.append(this.aWS);
    stringBuilder.append(", vipCard=");
    stringBuilder.append(this.aWT);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  @NotNull
  public final String xq() { return this.orderNo; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */