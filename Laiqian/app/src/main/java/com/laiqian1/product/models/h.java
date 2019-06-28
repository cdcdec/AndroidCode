package com.laiqian.product.models;

import android.text.TextUtils;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import java.io.Serializable;

public class h implements Serializable, Cloneable {
  public String Yx;
  
  public long aJx;
  
  public final long aSW;
  
  private String aTy;
  
  public String aWd = "";
  
  public String ago;
  
  private double bTi;
  
  public double bTj;
  
  private long bbX;
  
  public int cUJ;
  
  private String cUK;
  
  private String cUL;
  
  public final String cUM;
  
  public boolean cUN;
  
  public String cUO;
  
  private String cUP;
  
  private String cUQ;
  
  private int cUR;
  
  private int cUS;
  
  public int cUT;
  
  private boolean cUU;
  
  private String cUV;
  
  private String cUW;
  
  private int cUX;
  
  private boolean cUY = true;
  
  private boolean cUZ;
  
  public final String cpm;
  
  private double cpn;
  
  private double cpu;
  
  public String cpw;
  
  public long cpz;
  
  public final String name;
  
  public int status;
  
  public h(long paramLong1, String paramString1, String paramString2, double paramDouble1, double paramDouble2, int paramInt, long paramLong2, String paramString3, double paramDouble3, String paramString4, double paramDouble4) { this(paramLong1, paramString1, paramString2, paramDouble1, paramDouble2, paramInt, paramLong2, paramString3, paramDouble3, paramString4, 0, paramDouble4); }
  
  public h(long paramLong1, String paramString1, String paramString2, double paramDouble1, double paramDouble2, int paramInt1, long paramLong2, String paramString3, double paramDouble3, String paramString4, int paramInt2, double paramDouble4) {
    this.aSW = paramLong1;
    this.name = paramString1;
    this.cpm = paramString2;
    this.cpw = paramString4;
    if (paramString2 != null && paramString2.length() > 0 && RootApplication.getLaiqianPreferenceManager().avx()) {
      this.cUM = paramString2;
    } else {
      this.cUM = paramString1;
    } 
    aM(paramDouble1);
    aN(paramDouble4);
    aO(paramDouble2);
    setStatus(paramInt1);
    this.aJx = paramLong2;
    this.ago = paramString3;
    aP(paramDouble3);
    jw(paramInt2);
  }
  
  public h(long paramLong1, String paramString1, String paramString2, int paramInt, long paramLong2) { this(paramLong1, stringBuilder.toString(), paramString2, 0.0D, 0.0D, paramInt, paramLong2, "", 0.0D, "", 3, 0.0D); }
  
  private h(a parama) {
    this.name = a.a(parama);
    this.aSW = a.b(parama);
    this.cpn = a.c(parama);
    this.cUK = a.d(parama);
    this.bTi = a.e(parama);
    this.cUL = a.f(parama);
    this.cUM = a.g(parama);
    this.cpm = a.h(parama);
    this.status = a.i(parama);
    this.cUN = a.j(parama);
    this.bTj = a.k(parama);
    this.cUO = a.l(parama);
    this.aJx = a.m(parama);
    this.Yx = parama.Yx;
    this.ago = a.n(parama);
    this.cpw = a.o(parama);
    this.cpu = a.p(parama);
    this.cUP = a.q(parama);
    this.cUR = a.r(parama);
    this.cUT = a.s(parama);
    this.cUS = parama.cUS;
    this.cUZ = parama.cUZ;
    this.cUU = a.t(parama);
    this.cUV = a.u(parama);
    this.cUW = a.v(parama);
    this.cUX = a.w(parama);
    this.aTy = a.x(parama);
    this.cUY = a.y(parama);
  }
  
  public h(h paramh) {
    this(paramh.aSW, paramh.name, paramh.cpm, paramh.akI(), paramh.bTj, paramh.status, paramh.aJx, paramh.ago, paramh.akK(), paramh.cpw, paramh.cUR, paramh.bTi);
    this.cUJ = paramh.cUJ;
    this.bbX = paramh.bbX;
    if (!TextUtils.isEmpty(paramh.akC()))
      this.aWd = paramh.akC(); 
  }
  
  public long AL() { return this.aJx; }
  
  public long GS() { return this.cpz; }
  
  protected h GY() throws CloneNotSupportedException { return (h)super.clone(); }
  
  public long Ly() { return this.bbX; }
  
  public void aM(double paramDouble) {
    this.cpn = paramDouble;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(n.b(null, Double.valueOf(paramDouble), true, true));
    this.cUK = stringBuilder.toString();
  }
  
  public void aN(double paramDouble) {
    this.bTi = paramDouble;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(n.b(null, Double.valueOf(paramDouble), true, true));
    this.cUL = stringBuilder.toString();
  }
  
  public void aO(double paramDouble) {
    String str;
    this.bTj = paramDouble;
    if (LQKVersion.zj() == 1) {
      str = n.a(Double.valueOf(paramDouble), false, false, 3);
    } else {
      str = n.b(null, Double.valueOf(paramDouble), false, false);
    } 
    this.cUO = str;
  }
  
  public void aP(double paramDouble) {
    this.cpu = paramDouble;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(n.b(null, Double.valueOf(paramDouble), true, true));
    this.cUP = stringBuilder.toString();
  }
  
  public String akC() { return this.aWd; }
  
  public String akD() { return this.cUO; }
  
  public int akE() { return this.cUR; }
  
  public double akF() { return this.bTj; }
  
  public String akG() { return this.cpm; }
  
  public double akH() { return this.bTi; }
  
  public double akI() { return this.cpn; }
  
  public String akJ() { return this.cUK; }
  
  public double akK() { return this.cpu; }
  
  public void akL() {
    if (this.cUN) {
      this.cUN = false;
      this.status = 600002;
      return;
    } 
    this.cUN = true;
    this.status = 600001;
  }
  
  public int akM() { return this.cUR; }
  
  public boolean akN() { return (this.cUR == 2); }
  
  public boolean akO() { return (this.cUR == 3); }
  
  public boolean akP() { return this.cUZ; }
  
  public void as(long paramLong) { this.cpz = paramLong; }
  
  public void az(long paramLong) { this.bbX = paramLong; }
  
  public boolean equals(Object paramObject) {
    if (LQKVersion.zj() == 1) {
      if (paramObject instanceof h) {
        paramObject = (h)paramObject;
        return (this.name == null && this.cpw == null) ? ((paramObject.name == null && paramObject.cpw == null)) : ((this.name == null) ? ((paramObject.name != null) ? false : this.cpw.equals(paramObject.cpw)) : ((this.cpw == null) ? ((paramObject.cpw != null) ? false : this.name.equals(paramObject.name)) : ((this.name.equals(paramObject.name) && this.cpw.equals(paramObject.cpw)))));
      } 
      return false;
    } 
    return super.equals(paramObject);
  }
  
  public long getID() { return this.aSW; }
  
  public String getName() { return this.name; }
  
  public void gs(boolean paramBoolean) { this.cUZ = paramBoolean; }
  
  public void ju(int paramInt) { this.cUT = paramInt; }
  
  public void jv(int paramInt) { this.cUR = paramInt; }
  
  protected void jw(int paramInt) { this.cUR = paramInt; }
  
  public void mI(String paramString) { this.aWd = paramString; }
  
  public void setStatus(int paramInt) {
    boolean bool;
    this.status = paramInt;
    if (paramInt == 600001) {
      bool = true;
    } else {
      bool = false;
    } 
    this.cUN = bool;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ProductEntity{numberDecimal=");
    stringBuilder.append(this.cUJ);
    stringBuilder.append(", itemId=");
    stringBuilder.append(this.cpz);
    stringBuilder.append(", ID=");
    stringBuilder.append(this.aSW);
    stringBuilder.append(", price=");
    stringBuilder.append(this.cpn);
    stringBuilder.append(", priceString='");
    stringBuilder.append(this.cUK);
    stringBuilder.append('\'');
    stringBuilder.append(", stockPrice=");
    stringBuilder.append(this.bTi);
    stringBuilder.append(", stockPriceString='");
    stringBuilder.append(this.cUL);
    stringBuilder.append('\'');
    stringBuilder.append(", nameOfListShow='");
    stringBuilder.append(this.cUM);
    stringBuilder.append('\'');
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append(", name2='");
    stringBuilder.append(this.cpm);
    stringBuilder.append('\'');
    stringBuilder.append(", status=");
    stringBuilder.append(this.status);
    stringBuilder.append(", isNormal=");
    stringBuilder.append(this.cUN);
    stringBuilder.append(", quantity=");
    stringBuilder.append(this.bTj);
    stringBuilder.append(", quantityString='");
    stringBuilder.append(this.cUO);
    stringBuilder.append('\'');
    stringBuilder.append(", typeID=");
    stringBuilder.append(this.aJx);
    stringBuilder.append(", typeName='");
    stringBuilder.append(this.Yx);
    stringBuilder.append('\'');
    stringBuilder.append(", code='");
    stringBuilder.append(this.ago);
    stringBuilder.append('\'');
    stringBuilder.append(", barcode='");
    stringBuilder.append(this.cpw);
    stringBuilder.append('\'');
    stringBuilder.append(", memberPrice=");
    stringBuilder.append(this.cpu);
    stringBuilder.append(", memberPriceString='");
    stringBuilder.append(this.cUP);
    stringBuilder.append('\'');
    stringBuilder.append(", sTaste='");
    stringBuilder.append(this.cUQ);
    stringBuilder.append('\'');
    stringBuilder.append(", nCategory=");
    stringBuilder.append(this.cUR);
    stringBuilder.append(", nSpareField3=");
    stringBuilder.append(this.cUS);
    stringBuilder.append(", priceType=");
    stringBuilder.append(this.cUT);
    stringBuilder.append(", cartName='");
    stringBuilder.append(this.aWd);
    stringBuilder.append('\'');
    stringBuilder.append(", barcodeScaleOpen=");
    stringBuilder.append(this.cUU);
    stringBuilder.append(", BarcodeScaleHotkey='");
    stringBuilder.append(this.cUV);
    stringBuilder.append('\'');
    stringBuilder.append(", BarcodeScalePlu='");
    stringBuilder.append(this.cUW);
    stringBuilder.append('\'');
    stringBuilder.append(", weightFlag=");
    stringBuilder.append(this.cUZ);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  class h {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\product\models\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */