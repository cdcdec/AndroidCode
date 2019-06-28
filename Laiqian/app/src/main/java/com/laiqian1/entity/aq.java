package com.laiqian.entity;

import android.support.annotation.Keep;
import com.laiqian.basic.RootApplication;
import com.laiqian.resource.R;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Keep
public class aq implements Serializable {
  public static final aq aWG = new aq(0L, "", "", "", 0.0D, 0.0D, false, false);
  
  public String aJX;
  
  public long aSW;
  
  public String aTp;
  
  public String aVq;
  
  public String aVw;
  
  public double aWA;
  
  public double aWB;
  
  public int aWC;
  
  public long aWD;
  
  public double aWE;
  
  public boolean aWF = true;
  
  public as aWH;
  
  public String aWn;
  
  public double aWo;
  
  public long aWp;
  
  public String aWq;
  
  public String aWr;
  
  public String aWs;
  
  public String aWt;
  
  public double aWu;
  
  public double aWv;
  
  public long aWw;
  
  public String aWx;
  
  public double aWy;
  
  public long aWz;
  
  private String birthday;
  
  public double discount;
  
  public String name;
  
  public aq() {}
  
  public aq(long paramLong, String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2) {
    this.aSW = paramLong;
    this.aWn = paramString1;
    this.name = paramString2;
    this.aTp = paramString3;
    this.aWo = paramDouble1;
    this.discount = paramDouble2;
    this.aWp = paramInt1;
    this.aWC = paramInt2;
  }
  
  private aq(a parama) {
    this.aSW = a.a(parama);
    this.aWn = a.b(parama);
    this.name = a.c(parama);
    this.aTp = a.d(parama);
    this.aWo = a.e(parama);
    this.birthday = c.cN(a.f(parama));
    this.aVw = a.g(parama);
    this.aWp = a.h(parama);
    this.aVq = a.i(parama);
    this.aWt = a.j(parama);
    this.discount = a.k(parama);
    this.aWu = a.l(parama);
    this.aWv = a.m(parama);
    this.aWw = a.n(parama);
    this.aWx = a.o(parama);
    this.aWy = parama.aWy;
    this.aWz = a.p(parama);
    this.aWA = a.q(parama);
    this.aWB = a.r(parama);
    this.aWC = a.s(parama);
    this.aJX = a.t(parama);
    this.aWH = a.u(parama);
    this.aWr = parama.aWr;
    this.aWq = a.v(parama);
  }
  
  public static boolean a(aq paramaq) { return (paramaq == null) ? true : ((paramaq.aSW == 0L)); }
  
  public static boolean j(long paramLong1, long paramLong2) { return (paramLong2 == 0L) ? true : ((paramLong1 <= paramLong2)); }
  
  public String IV() {
    String[] arrayOfString = RootApplication.zv().getResources().getStringArray(R.array.list_member_effective_period);
    long l2 = Long.valueOf(this.aVq).longValue();
    long l1 = Long.valueOf(this.aWq).longValue();
    long l3 = l1 - l2;
    if (l1 != 0L && System.currentTimeMillis() > l1)
      return RootApplication.zv().getString(R.string.member_expired); 
    if (l3 == -l2)
      return arrayOfString[0]; 
    l2 = TimeUnit.MILLISECONDS.toDays(l3);
    return (l2 == 364L || l2 == 365L) ? arrayOfString[1] : ((l2 == 182L || l2 == 183L) ? arrayOfString[2] : ((l2 == 29L || l2 == 30L) ? arrayOfString[3] : (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(l1))));
  }
  
  public String av(long paramLong) {
    String[] arrayOfString = RootApplication.zv().getResources().getStringArray(R.array.list_member_effective_period);
    long l2 = Long.valueOf(this.aVq).longValue();
    long l1 = Long.valueOf(this.aWq).longValue();
    long l3 = l1 - l2;
    if (l1 != 0L && paramLong > l1)
      return RootApplication.zv().getString(R.string.member_expired); 
    if (l3 == -l2)
      return arrayOfString[0]; 
    paramLong = TimeUnit.MILLISECONDS.toDays(l3);
    return (paramLong == 364L || paramLong == 365L) ? arrayOfString[1] : ((paramLong == 182L || paramLong == 183L) ? arrayOfString[2] : ((paramLong == 29L || paramLong == 30L) ? arrayOfString[3] : (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(l1))));
  }
  
  public void dy(String paramString) { this.birthday = c.cN(paramString); }
  
  public String getBirthday() { return this.birthday; }
  
  public static class a {
    private String aJX;
    
    private final long aSW;
    
    private String aTp;
    
    private String aVq;
    
    private String aVw;
    
    private double aWA;
    
    private double aWB;
    
    private int aWC;
    
    private as aWH;
    
    private int aWI;
    
    private String aWn;
    
    private double aWo;
    
    private String aWq;
    
    public String aWr;
    
    private String aWt;
    
    private double aWu;
    
    private double aWv;
    
    private long aWw;
    
    private String aWx;
    
    public double aWy;
    
    private long aWz;
    
    private String birthday;
    
    private double discount;
    
    private String name;
    
    public a(long param1Long, String param1String1, String param1String2) {
      this.aSW = param1Long;
      this.aWn = param1String1;
      this.aTp = param1String2;
    }
    
    public aq IW() { return new aq(this, null); }
    
    public a W(double param1Double) {
      this.aWo = param1Double;
      return this;
    }
    
    public a aw(long param1Long) {
      this.aWw = param1Long;
      return this;
    }
    
    public a dA(String param1String) {
      this.birthday = c.cN(param1String);
      return this;
    }
    
    public a dB(String param1String) {
      this.aVw = param1String;
      return this;
    }
    
    public a dC(String param1String) {
      this.aWx = param1String;
      return this;
    }
    
    public a dD(String param1String) {
      this.aWq = param1String;
      return this;
    }
    
    public a dE(String param1String) {
      this.aJX = param1String;
      return this;
    }
    
    public a dF(String param1String) {
      this.aWr = param1String;
      return this;
    }
    
    public a dz(String param1String) {
      this.name = param1String;
      return this;
    }
    
    public a eG(int param1Int) {
      this.aWI = param1Int;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */