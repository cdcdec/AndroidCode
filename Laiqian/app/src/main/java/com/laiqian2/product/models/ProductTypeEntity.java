package com.laiqian.product.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.a.g;

@Keep
public class ProductTypeEntity implements Parcelable, g.b, Cloneable {
  public static final Parcelable.Creator<ProductTypeEntity> CREATOR = new k();
  
  public long aSW;
  
  public final String cUM;
  
  public boolean cVb;
  
  public int cVc;
  
  public boolean cVd;
  
  public final boolean cVe;
  
  private boolean cVf;
  
  public boolean cVg;
  
  public boolean cgE;
  
  public final String cpm;
  
  public final String name;
  
  public ProductTypeEntity(long paramLong, String paramString) { this(paramLong, paramString, paramString, false, true, true); }
  
  public ProductTypeEntity(long paramLong, String paramString1, String paramString2, boolean paramBoolean) { this(paramLong, paramString1, paramString2, paramBoolean, false, true); }
  
  private ProductTypeEntity(long paramLong, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    this.aSW = paramLong;
    this.name = paramString1;
    this.cpm = paramString2;
    if (paramString2 != null && paramString2.length() > 0 && !paramString2.equals(paramString1) && RootApplication.getLaiqianPreferenceManager().avx()) {
      this.cUM = paramString2;
    } else {
      this.cUM = paramString1;
    } 
    this.cVb = paramBoolean1;
    this.cVd = true;
    this.cVe = paramBoolean2;
    this.cVf = paramBoolean3;
  }
  
  protected ProductTypeEntity(Parcel paramParcel) {
    this.aSW = paramParcel.readLong();
    this.cUM = paramParcel.readString();
    this.name = paramParcel.readString();
    this.cpm = paramParcel.readString();
    byte b1 = paramParcel.readByte();
    byte b3 = 0;
    if (b1 != 0) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    this.cVb = b2;
    if (paramParcel.readByte() != 0) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    this.cgE = b2;
    this.cVc = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    this.cVd = b2;
    if (paramParcel.readByte() != 0) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    this.cVe = b2;
    if (paramParcel.readByte() != 0) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    this.cVf = b2;
    byte b2 = b3;
    if (paramParcel.readByte() != 0)
      b2 = 1; 
    this.cVg = b2;
  }
  
  public long AR() { return this.aSW; }
  
  public CharSequence AS() { return this.name; }
  
  public CharSequence AT() { return this.name; }
  
  public int describeContents() { return 0; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (ProductTypeEntity)paramObject;
      if (this.aSW != paramObject.aSW)
        return false; 
      if (this.cVb != paramObject.cVb)
        return false; 
      if (this.cgE != paramObject.cgE)
        return false; 
      if (this.cVc != paramObject.cVc)
        return false; 
      if (this.cVd != paramObject.cVd)
        return false; 
      if (this.cVe != paramObject.cVe)
        return false; 
      if (this.cVf != paramObject.cVf)
        return false; 
      if (this.cVg != paramObject.cVg)
        return false; 
      if (this.cUM != null) {
        if (!this.cUM.equals(paramObject.cUM))
          return false; 
      } else if (paramObject.cUM != null) {
        return false;
      } 
      if (this.name != null)
        return this.name.equals(paramObject.name); 
      if (paramObject.name == null)
        if (this.cpm != null) {
          if (this.cpm.equals(paramObject.cpm))
            return true; 
        } else if (paramObject.cpm == null) {
          return true;
        }  
      return false;
    } 
    return false;
  }
  
  public int hashCode() { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeLong(this.aSW);
    paramParcel.writeString(this.cUM);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.cpm);
    paramParcel.writeByte((byte)this.cVb);
    paramParcel.writeByte((byte)this.cgE);
    paramParcel.writeInt(this.cVc);
    paramParcel.writeByte((byte)this.cVd);
    paramParcel.writeByte((byte)this.cVe);
    paramParcel.writeByte((byte)this.cVf);
    paramParcel.writeByte((byte)this.cVg);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\ProductTypeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */