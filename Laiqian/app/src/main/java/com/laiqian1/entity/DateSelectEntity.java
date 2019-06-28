package com.laiqian.entity;

import com.squareup.moshi.Json;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DateSelectEntity {
  @Json(name = "beginTime")
  private long aRA;
  
  @Json(name = "beginTimeString")
  private String aRB;
  
  @Json(name = "endTime")
  private long aRC;
  
  @Json(name = "endTimeString")
  private String aRD;
  
  @Json(name = "expireTime")
  private long aRE;
  
  @Json(name = "expireTimeString")
  private String aRF;
  
  @Json(name = "weekDayStr")
  private StringBuilder aRG;
  
  @Json(name = "monthDayStr")
  private StringBuilder aRH;
  
  @Json(name = "dateType")
  private int aRz;
  
  private DateSelectEntity(a parama) {
    this.aRz = a.a(parama);
    this.aRA = a.b(parama);
    this.aRB = a.c(parama);
    this.aRC = a.d(parama);
    this.aRD = a.e(parama);
    this.aRE = a.f(parama);
    this.aRF = a.g(parama);
    this.aRG = a.h(parama);
    this.aRH = a.i(parama);
  }
  
  public long EA() { return this.aRE; }
  
  public String EB() { return this.aRF; }
  
  public StringBuilder EC() { return this.aRG; }
  
  public StringBuilder ED() { return this.aRH; }
  
  public int Ev() { return this.aRz; }
  
  public long Ew() { return this.aRA; }
  
  public String Ex() { return this.aRB; }
  
  public long Ey() { return this.aRC; }
  
  public String Ez() { return this.aRD; }
  
  public void aa(long paramLong) { this.aRA = paramLong; }
  
  public void ab(long paramLong) { this.aRC = paramLong; }
  
  public void ac(long paramLong) { this.aRE = paramLong; }
  
  public void b(StringBuilder paramStringBuilder) { this.aRH = paramStringBuilder; }
  
  public void cP(String paramString) { this.aRB = paramString; }
  
  public void cQ(String paramString) { this.aRD = paramString; }
  
  public void cR(String paramString) { this.aRF = paramString; }
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface DateType {}
  
  public static final class a {
    private long aRA;
    
    private String aRB;
    
    private long aRC;
    
    private String aRD;
    
    private long aRE;
    
    private String aRF;
    
    private StringBuilder aRG;
    
    private StringBuilder aRH;
    
    private int aRz;
    
    public DateSelectEntity EE() { return new DateSelectEntity(this, null); }
    
    public a ad(long param1Long) {
      this.aRA = param1Long;
      return this;
    }
    
    public a ae(long param1Long) {
      this.aRC = param1Long;
      return this;
    }
    
    public a af(long param1Long) {
      this.aRE = param1Long;
      return this;
    }
    
    public a c(StringBuilder param1StringBuilder) {
      this.aRG = param1StringBuilder;
      return this;
    }
    
    public a cS(String param1String) {
      this.aRB = param1String;
      return this;
    }
    
    public a cT(String param1String) {
      this.aRD = param1String;
      return this;
    }
    
    public a cU(String param1String) {
      this.aRF = param1String;
      return this;
    }
    
    public a d(StringBuilder param1StringBuilder) {
      this.aRH = param1StringBuilder;
      return this;
    }
    
    public a ep(int param1Int) {
      this.aRz = param1Int;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\DateSelectEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */