package com.laiqian.print.cardreader;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Build;
import com.laiqian.print.model.type.usb.a.a;
import com.laiqian.print.util.e;
import java.util.ArrayList;
import java.util.Iterator;

public class ad {
  private ArrayList<ah> cDN = new ArrayList();
  
  private al cEH;
  
  c cEI = null;
  
  private ArrayList<a> cEJ = new ArrayList();
  
  private b cEK = new ae(this);
  
  private a cEL = new af(this);
  
  private ak cEu;
  
  private am cEv;
  
  private Context mContext;
  
  public ad(Context paramContext, al paramal) {
    this.mContext = paramContext;
    this.cEH = paramal;
    this.cEu = s.aZ(this.mContext);
    this.cEv = am.ba(this.mContext);
  }
  
  private void aeK() {
    this.cDN = this.cEv.afs();
    Iterator iterator = this.cDN.iterator();
    while (iterator.hasNext()) {
      a a1 = ((ah)iterator.next()).afr();
      a1.setConnected(this.cEu.d(a1));
    } 
  }
  
  private void aeQ() {
    this.cEJ.clear();
    this.cEH.ael();
  }
  
  private void aeS() { this.cEv.ai(this.cDN); }
  
  private void afp() {
    aeQ();
    if (Build.VERSION.SDK_INT > 12) {
      this.cEI = this.cEu.afn();
      this.cEI.a(this.cEK);
      return;
    } 
    this.cEH.afo();
  }
  
  private void i(UsbDevice paramUsbDevice) {
    if (paramUsbDevice == null) {
      aeM();
      return;
    } 
    this.cEu = s.aZ(this.mContext);
    a a1 = this.cEu.g(paramUsbDevice);
    if (a1 == null)
      return; 
    if (i(a1)) {
      aeM();
      return;
    } 
    if (!aeN())
      aeP(); 
  }
  
  private boolean i(a parama) {
    Iterator iterator = this.cDN.iterator();
    while (iterator.hasNext()) {
      a a1 = ((ah)iterator.next()).afr();
      if (parama.getIdentifier().equals(a1.getIdentifier()))
        return true; 
    } 
    return false;
  }
  
  private a kZ(String paramString) {
    for (ah ah : this.cDN) {
      if (paramString.equals(ah.afr().getIdentifier()))
        return ah.afr(); 
    } 
    return null;
  }
  
  public void aeL() { e.i(new ag(this)); }
  
  public void aeM() {
    this.cEu.a(this.cEL);
    for (ah ah : this.cDN) {
      a a1 = ah.afr();
      a1.setConnected(this.cEu.d(a1));
      this.cEu.e(ah.afr());
    } 
  }
  
  public boolean aeN() { return (this.cEI != null && this.cEI.aeN()); }
  
  public void aeO() {
    if (aeN()) {
      stopSearch();
      return;
    } 
    aeP();
  }
  
  public void aeP() {
    afp();
    if (this.cEI != null)
      this.cEI.start(); 
  }
  
  public ArrayList<a> afq() { return this.cEJ; }
  
  public void bk(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt1 >= this.cEJ.size())
        return; 
      a a1 = (a)this.cEJ.get(paramInt1);
      ai ai = ai.hU(paramInt2);
      a1.setConnected(this.cEu.d(a1));
      this.cEJ.remove(paramInt1);
      ah ah = new ah(a1, ai);
      this.cDN.add(ah);
      this.cEH.b(ah);
      aeS();
      this.cEu.a(this.cEL);
      this.cEu.e(a1);
      this.cEH.ael();
      return;
    } 
  }
  
  public void e(UsbDevice paramUsbDevice) { i(paramUsbDevice); }
  
  public void f(UsbDevice paramUsbDevice) {
    a a1 = kZ((new a(paramUsbDevice.getDeviceName(), paramUsbDevice.getVendorId(), paramUsbDevice.getProductId())).getIdentifier());
    if (a1 != null) {
      a1.setConnected(false);
      aeL();
    } 
  }
  
  public a hS(int paramInt) { return (paramInt < 0 || paramInt >= this.cEJ.size()) ? null : (a)this.cEJ.get(paramInt); }
  
  public ah hT(int paramInt) { return (paramInt < 0 || paramInt >= this.cDN.size()) ? null : (ah)this.cDN.get(paramInt); }
  
  public void init() {
    aeK();
    aeL();
    aeM();
  }
  
  public void stopSearch() {
    try {
      this.cEI.cancel();
      return;
    } catch (NullPointerException nullPointerException) {
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */