package com.laiqian.print.cardreader;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import com.laiqian.print.model.type.usb.a.a;

public class o {
  private aj cEs;
  
  private ah cEt;
  
  private ak cEu;
  
  private am cEv;
  
  private a cEw = new p(this);
  
  private Context mContext;
  
  private int qi;
  
  public o(Context paramContext, aj paramaj) {
    this.mContext = paramContext;
    this.cEs = paramaj;
    this.cEu = s.aZ(this.mContext);
    this.cEv = am.ba(this.mContext);
  }
  
  private void afk() {
    boolean bool = this.cEu.d(this.cEt.afr());
    this.cEt.afr().setConnected(bool);
    this.cEs.fx(bool);
  }
  
  public void a(ah paramah) {
    this.qi = 2;
    this.cEt = paramah;
    afh();
  }
  
  public void afh() {
    a a1 = this.cEt.afr();
    ai ai = this.cEt.afl();
    this.cEs.setMode(this.qi);
    this.cEs.setName(a1.getName());
    this.cEs.setType(a1.getType());
    this.cEs.b(ai);
    this.cEs.fx(this.cEu.d(a1));
  }
  
  public void afi() {
    afh();
    String str = this.cEu.f(this.cEt.afr());
    if (str == null) {
      this.cEs.afg();
      return;
    } 
    this.cEs.kY(str);
  }
  
  public void afj() { afk(); }
  
  public ai afl() { return this.cEt.afl(); }
  
  public boolean c(ai paramai) {
    this.cEt.b(paramai);
    this.cEs.b(this.cEt.afl());
    save();
    return true;
  }
  
  public void connect() {
    this.cEu.a(this.cEw);
    this.cEu.e(this.cEt.afr());
  }
  
  public void delete() {
    this.cEv.f(this.cEt);
    this.cEs.exit();
  }
  
  public void e(UsbDevice paramUsbDevice) { afk(); }
  
  public void fy(boolean paramBoolean) { afk(); }
  
  public int getMode() { return this.qi; }
  
  public boolean isConnected() { return this.cEu.d(this.cEt.afr()); }
  
  public void save() { this.cEv.e(this.cEt); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */