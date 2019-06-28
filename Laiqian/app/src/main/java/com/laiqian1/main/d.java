package com.laiqian.main;

import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.a.g;
import com.laiqian.util.by;

public class d implements g.b {
  private String bat;
  
  private String bau;
  
  private String bav;
  
  private long id;
  
  private static String al(long paramLong) { return (paramLong == 86001L) ? CrashApplication.zv().getString(2131628360) : ((paramLong == 86002L) ? CrashApplication.zv().getString(2131626527) : ((paramLong == 86003L) ? CrashApplication.zv().getString(2131628308) : ((paramLong == 86004L) ? CrashApplication.zv().getString(2131628057) : ((paramLong == 86005L) ? CrashApplication.zv().getString(2131625572) : "")))); }
  
  public long AR() { return this.id; }
  
  public CharSequence AS() { return this.bav; }
  
  public CharSequence AT() { return this.bav; }
  
  public String KG() { return this.bau; }
  
  public String KH() { return this.bat; }
  
  public String KI() { return this.bav; }
  
  public long getId() { return this.id; }
  
  public static class a {
    private String bat;
    
    private String bau;
    
    private String bav;
    
    private long id;
    
    public d KJ() {
      d d = new d();
      a(d);
      return d;
    }
    
    void a(d param1d) {
      d.a(param1d, this.id);
      d.a(param1d, this.bat);
      d.b(param1d, this.bav);
      d.c(param1d, this.bau);
    }
    
    public a ay(long param1Long) {
      this.id = param1Long;
      return this;
    }
    
    public a eM(String param1String) {
      this.bat = param1String;
      this.bav = d.ax(by.parseLong(param1String));
      return this;
    }
    
    public a eN(String param1String) {
      this.bau = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */