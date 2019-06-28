package com.laiqian.entity;

import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.ui.a.g;
import com.squareup.moshi.Json;
import java.util.ArrayList;

public class ac implements g.b {
  @Json(name = "promotionID")
  private long aSW;
  
  @Json(name = "rechargeAmount")
  private double aSc;
  
  @Json(name = "giftAmount")
  private double aSd;
  
  @Json(name = "dateTime")
  private DateSelectEntity aUj;
  
  @Json(name = "peopleType")
  private w aUk;
  
  @Json(name = "fitProductTypeName")
  private String aUl;
  
  @Json(name = "fitProduct")
  private ag aUm;
  
  @Json(name = "fitProductType")
  private ArrayList<ProductTypeEntity> aUn;
  
  @Json(name = "addAmount")
  private double aUo;
  
  @Json(name = "deductAmount")
  private double aUp;
  
  @Json(name = "productBuyNum")
  private double aUq;
  
  @Json(name = "giftProduct")
  private ae aUr;
  
  @Json(name = "giftProductTotalNum")
  private double aUs;
  
  @Json(name = "minBuyAmount")
  private double aUt;
  
  @Json(name = "minBuyNum")
  private double aUu;
  
  @Json(name = "promotionType")
  private int aUv;
  
  @Json(name = "fitProductTypeChanged")
  private boolean aUw = false;
  
  @Json(name = "discount")
  private double discount = 100.0D;
  
  @Json(name = "promotionName")
  private String name;
  
  @Json(name = "state")
  private int state;
  
  private ac(a parama) {
    at(a.a(parama));
    setName(a.b(parama));
    a(a.c(parama));
    a(a.d(parama));
    q(a.e(parama));
    dk(a.f(parama));
    a(a.g(parama));
    p(a.h(parama));
    v(a.i(parama));
    w(a.j(parama));
    C(a.k(parama));
    x(a.l(parama));
    y(a.m(parama));
    a(a.n(parama));
    B(a.o(parama));
    z(a.p(parama));
    A(a.q(parama));
    setState(a.r(parama));
    ew(a.s(parama));
  }
  
  public void A(double paramDouble) { this.aUu = paramDouble; }
  
  public long AR() { return this.aSW; }
  
  public CharSequence AS() { return this.name; }
  
  public CharSequence AT() { return this.name; }
  
  public void B(double paramDouble) { this.aUs = paramDouble; }
  
  public void C(double paramDouble) { this.aSd = paramDouble; }
  
  public double FI() { return this.discount; }
  
  public DateSelectEntity Hc() { return this.aUj; }
  
  public w Hd() { return this.aUk; }
  
  public ArrayList<ProductTypeEntity> He() { return this.aUn; }
  
  public String Hf() { return this.aUl; }
  
  public double Hg() { return this.aUo; }
  
  public double Hh() { return this.aSc; }
  
  public double Hi() { return this.aUp; }
  
  public ae Hj() { return this.aUr; }
  
  public double Hk() { return this.aUt; }
  
  public double Hl() { return this.aUu; }
  
  public int Hm() { return this.aUv; }
  
  public ag Hn() { return this.aUm; }
  
  public double Ho() { return this.aUs; }
  
  public double Hp() { return this.aSd; }
  
  public ac a(ac paramac) {
    a a = (new a()).au(paramac.aSW).dl(paramac.name).b(paramac.aUj).b(paramac.aUk);
    ae ae1 = paramac.aUn;
    ArrayList arrayList = null;
    if (ae1 != null) {
      ae1 = (ArrayList)paramac.aUn.clone();
    } else {
      ae1 = null;
    } 
    a = a.r(ae1).dm(paramac.aUl);
    if (paramac.aUm != null) {
      ag ag1 = paramac.aUm.HD();
    } else {
      ae1 = null;
    } 
    a = a.b(ae1).D(paramac.discount).E(paramac.aUo).G(paramac.aSd).F(paramac.aSc).H(paramac.aUp).I(paramac.aUq);
    ae1 = arrayList;
    if (paramac.aUr != null)
      ae1 = paramac.aUr.Hw(); 
    return a.b(ae1).J(paramac.aUs).K(paramac.aUt).L(paramac.aUu).ex(paramac.state).ey(paramac.aUv).Hq();
  }
  
  public void a(DateSelectEntity paramDateSelectEntity) { this.aUj = paramDateSelectEntity; }
  
  public void a(ae paramae) { this.aUr = paramae; }
  
  public void a(ag paramag) { this.aUm = paramag; }
  
  public void a(w paramw) { this.aUk = paramw; }
  
  public void at(long paramLong) { this.aSW = paramLong; }
  
  public void cX(boolean paramBoolean) { this.aUw = paramBoolean; }
  
  public void dk(String paramString) { this.aUl = paramString; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (ac)paramObject;
      if (this.aSW != paramObject.aSW)
        return false; 
      if (Double.compare(paramObject.discount, this.discount) != 0)
        return false; 
      if (Double.compare(paramObject.aUo, this.aUo) != 0)
        return false; 
      if (Double.compare(paramObject.aSc, this.aSc) != 0)
        return false; 
      if (Double.compare(paramObject.aSd, this.aSd) != 0)
        return false; 
      if (Double.compare(paramObject.aUp, this.aUp) != 0)
        return false; 
      if (Double.compare(paramObject.aUq, this.aUq) != 0)
        return false; 
      if (Double.compare(paramObject.aUs, this.aUs) != 0)
        return false; 
      if (Double.compare(paramObject.aUt, this.aUt) != 0)
        return false; 
      if (Double.compare(paramObject.aUu, this.aUu) != 0)
        return false; 
      if (this.state != paramObject.state)
        return false; 
      if (this.aUv != paramObject.aUv)
        return false; 
      if (this.name != null) {
        if (!this.name.equals(paramObject.name))
          return false; 
      } else if (paramObject.name != null) {
        return false;
      } 
      if (this.aUj != null) {
        if (!this.aUj.equals(paramObject.aUj))
          return false; 
      } else if (paramObject.aUj != null) {
        return false;
      } 
      if (this.aUk != null) {
        if (!this.aUk.equals(paramObject.aUk))
          return false; 
      } else if (paramObject.aUk != null) {
        return false;
      } 
      if (this.aUw)
        return false; 
      if (this.aUm != null) {
        if (!this.aUm.equals(paramObject.aUm))
          return false; 
      } else if (paramObject.aUm != null) {
        return false;
      } 
      return (this.aUr != null) ? this.aUr.equals(paramObject.aUr) : ((paramObject.aUr == null) ? 1 : 0);
    } 
    return false;
  }
  
  public void ew(int paramInt) { this.aUv = paramInt; }
  
  public long getID() { return this.aSW; }
  
  public String getName() { return this.name; }
  
  public int getState() { return this.state; }
  
  public int hashCode() {
    int i1;
    int n;
    int m;
    int k;
    int j;
    int i;
    int i3 = (int)(this.aSW ^ this.aSW >>> 32);
    String str = this.name;
    int i2 = 0;
    if (str != null) {
      i = this.name.hashCode();
    } else {
      i = 0;
    } 
    if (this.aUj != null) {
      j = this.aUj.hashCode();
    } else {
      j = 0;
    } 
    if (this.aUk != null) {
      k = this.aUk.hashCode();
    } else {
      k = 0;
    } 
    if (this.aUn != null) {
      m = this.aUn.hashCode();
    } else {
      m = 0;
    } 
    if (this.aUl != null) {
      n = this.aUl.hashCode();
    } else {
      n = 0;
    } 
    if (this.aUm != null) {
      i1 = this.aUm.hashCode();
    } else {
      i1 = 0;
    } 
    long l = Double.doubleToLongBits(this.discount);
    int i4 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUo);
    int i5 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aSc);
    int i6 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aSd);
    int i7 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUp);
    int i8 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUq);
    int i9 = (int)(l ^ l >>> 32);
    if (this.aUr != null)
      i2 = this.aUr.hashCode(); 
    l = Double.doubleToLongBits(this.aUs);
    int i10 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUt);
    int i11 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUu);
    return (((((((((((((((((i3 * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i2) * 31 + i10) * 31 + i11) * 31 + (int)(l ^ l >>> 32)) * 31 + this.state) * 31 + this.aUv;
  }
  
  public void p(double paramDouble) { this.discount = paramDouble; }
  
  public void q(ArrayList<ProductTypeEntity> paramArrayList) { this.aUn = paramArrayList; }
  
  public void setName(String paramString) { this.name = paramString; }
  
  public void setState(int paramInt) { this.state = paramInt; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PromotionEntity{ID=");
    stringBuilder.append(this.aSW);
    stringBuilder.append(", 优惠活动='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append(", 时间=");
    stringBuilder.append(this.aUj);
    stringBuilder.append(" ,适用人群=");
    String str1 = this.aUk;
    String str2 = null;
    if (str1 != null) {
      String str = this.aUk.toString();
    } else {
      str1 = null;
    } 
    stringBuilder.append(str1);
    stringBuilder.append(", 适用商品id=");
    if (this.aUk != null) {
      String str = this.aUk.toString();
    } else {
      str1 = "无";
    } 
    stringBuilder.append(str1);
    stringBuilder.append(", 适用商品分类id=");
    if (this.aUn != null) {
      str1 = this.aUn.toString();
    } else {
      str1 = "无";
    } 
    stringBuilder.append(str1);
    stringBuilder.append(", 适用商品分类名字='");
    stringBuilder.append(this.aUl);
    stringBuilder.append('\'');
    stringBuilder.append(", 全单折扣=");
    stringBuilder.append(this.discount);
    stringBuilder.append(", 补交金额=");
    stringBuilder.append(this.aUo);
    stringBuilder.append(", 充值金额=");
    stringBuilder.append(this.aSc);
    stringBuilder.append(", 赠送金额=");
    stringBuilder.append(this.aSd);
    stringBuilder.append(", 扣减金额=");
    stringBuilder.append(this.aUp);
    stringBuilder.append(", 商品满足数量=");
    stringBuilder.append(this.aUq);
    stringBuilder.append(", 赠送商品=");
    str1 = str2;
    if (this.aUr != null)
      str1 = this.aUr.toString(); 
    stringBuilder.append(str1);
    stringBuilder.append(", 最低购买金额=");
    stringBuilder.append(this.aUt);
    stringBuilder.append(", 最低购买数量=");
    stringBuilder.append(this.aUu);
    stringBuilder.append(", 状态=");
    stringBuilder.append(this.state);
    stringBuilder.append('}');
    stringBuilder.append("\n");
    return stringBuilder.toString();
  }
  
  public void v(double paramDouble) { this.aUo = paramDouble; }
  
  public void w(double paramDouble) { this.aSc = paramDouble; }
  
  public void x(double paramDouble) { this.aUp = paramDouble; }
  
  public void y(double paramDouble) { this.aUq = paramDouble; }
  
  public void z(double paramDouble) { this.aUt = paramDouble; }
  
  public static final class a {
    private long aSW;
    
    private double aSc;
    
    private double aSd;
    
    private DateSelectEntity aUj;
    
    private w aUk;
    
    private String aUl;
    
    private ag aUm;
    
    private ArrayList<ProductTypeEntity> aUn;
    
    private double aUo;
    
    private double aUp;
    
    private double aUq;
    
    private ae aUr;
    
    private double aUs;
    
    private double aUt;
    
    private double aUu;
    
    private int aUv;
    
    private double discount;
    
    private String name;
    
    private int state;
    
    public a D(double param1Double) {
      this.discount = param1Double;
      return this;
    }
    
    public a E(double param1Double) {
      this.aUo = param1Double;
      return this;
    }
    
    public a F(double param1Double) {
      this.aSc = param1Double;
      return this;
    }
    
    public a G(double param1Double) {
      this.aSd = param1Double;
      return this;
    }
    
    public a H(double param1Double) {
      this.aUp = param1Double;
      return this;
    }
    
    public ac Hq() { return new ac(this, null); }
    
    public a I(double param1Double) {
      this.aUq = param1Double;
      return this;
    }
    
    public a J(double param1Double) {
      this.aUs = param1Double;
      return this;
    }
    
    public a K(double param1Double) {
      this.aUt = param1Double;
      return this;
    }
    
    public a L(double param1Double) {
      this.aUu = param1Double;
      return this;
    }
    
    public a au(long param1Long) {
      this.aSW = param1Long;
      return this;
    }
    
    public a b(DateSelectEntity param1DateSelectEntity) {
      this.aUj = param1DateSelectEntity;
      return this;
    }
    
    public a b(ae param1ae) {
      this.aUr = param1ae;
      return this;
    }
    
    public a b(ag param1ag) {
      this.aUm = param1ag;
      return this;
    }
    
    public a b(w param1w) {
      this.aUk = param1w;
      return this;
    }
    
    public a dl(String param1String) {
      this.name = param1String;
      return this;
    }
    
    public a dm(String param1String) {
      this.aUl = param1String;
      return this;
    }
    
    public a ex(int param1Int) {
      this.state = param1Int;
      return this;
    }
    
    public a ey(int param1Int) {
      this.aUv = param1Int;
      return this;
    }
    
    public a r(ArrayList<ProductTypeEntity> param1ArrayList) {
      this.aUn = param1ArrayList;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */