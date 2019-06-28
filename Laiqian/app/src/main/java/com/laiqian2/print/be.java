package com.laiqian.print;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import com.laiqian.print.model.d;
import com.laiqian.print.model.g;
import com.laiqian.print.model.q;
import com.laiqian.print.model.s;
import com.laiqian.print.model.type.b.b;
import com.laiqian.print.model.type.b.c;
import com.laiqian.print.model.type.usb.g;
import com.laiqian.print.type.a;
import com.laiqian.print.type.net.l;
import com.laiqian.print.usage.c;
import com.laiqian.print.util.d;
import com.laiqian.print.util.e;
import com.laiqian.util.bd;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class be {
  private static final LinkedHashSet<Long> cDC = new LinkedHashSet();
  
  private g cDD;
  
  private c cDE;
  
  private e cDF;
  
  private f cDG;
  
  d cDH;
  
  b cDI;
  
  d cDJ;
  
  a cDK = null;
  
  private LinkedHashMap<String, q> cDL = new LinkedHashMap();
  
  private ArrayList<c> cDM = new ArrayList();
  
  private ArrayList<ac> cDN = new ArrayList();
  
  private d.a cDO = new bg(this);
  
  boolean cDP = false;
  
  private d.a cDQ = new bi(this);
  
  private g.c cDR = new bj(this);
  
  private int cDS = 0;
  
  private Context mContext;
  
  static  {
    cDC.add(Long.valueOf(d.mg("192.168.1.200")));
  }
  
  public be(Context paramContext, e parame) {
    this.mContext = paramContext;
    this.cDF = parame;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  private ArrayList<c> aeJ() {
    ArrayList arrayList = new ArrayList();
    for (q q : this.cDL.values()) {
      if (q.getType() == 2) {
        c c1 = (c)q.agE();
        if (cDC.contains(Long.valueOf(bd.mg(c1.getAddress()))))
          arrayList.add(c1); 
      } 
    } 
    return arrayList;
  }
  
  private void aeK() {
    this.cDN = this.cDE.afs();
    Iterator iterator = this.cDN.iterator();
    while (iterator.hasNext()) {
      s s = ((ac)iterator.next()).aew();
      s.setConnected(this.cDD.isConnected(s));
    } 
  }
  
  private void aeQ() {
    this.cDL.clear();
    this.cDF.ael();
  }
  
  private void aeS() { this.cDE.ak(this.cDN); }
  
  private void aej() {
    this.cDF.aej();
    this.cDM = aeJ();
    if (this.cDM.size() > 0) {
      c c1 = (c)this.cDM.get(0);
      k(g.cGS.f(c1));
    } 
  }
  
  private boolean d(s params) {
    synchronized (this.cDN) {
      Iterator iterator = this.cDN.iterator();
      while (iterator.hasNext()) {
        s s1 = ((ac)iterator.next()).aew();
        if (params.getIdentifier().equals(s1.getIdentifier()))
          return true; 
      } 
      return false;
    } 
  }
  
  private void hH(int paramInt) {
    aeQ();
    if ((paramInt & true) != 0)
      if (g.cGS.agB()) {
        this.cDH = this.cDD.agy();
        if (this.cDH != null)
          this.cDH.a(this.cDO); 
      } else {
        this.cDF.hx(1);
      }  
    if ((paramInt & 0x2) != 0)
      if (!bd.bH(this.mContext) || !g.cGS.agC()) {
        this.cDF.hx(2);
      } else {
        this.cDI = this.cDD.agz();
        if (this.cDI != null) {
          this.cDI.a(cDC);
          this.cDI.a(this.cDQ);
        } 
      }  
    if ((paramInt & 0x4) != 0 && g.cGS.agD()) {
      if (!BluetoothAdapter.getDefaultAdapter().isEnabled())
        return; 
      this.cDJ = this.cDD.agA();
      if (this.cDJ != null)
        this.cDJ.a(this.cDO); 
    } 
  }
  
  private q kX(String paramString) {
    for (ac ac : this.cDN) {
      if (paramString.equals(ac.aew().getIdentifier()))
        return g.cGS.f(ac.aew()); 
    } 
    return null;
  }
  
  public void a(int paramInt, ac paramac) {
    if (paramac.aew().agF() == 0 && paramac.aex().contains(bl.cEc))
      paramac.aew().ii(2); 
    this.cDN.set(paramInt, paramac);
    aeS();
    this.cDF.ael();
  }
  
  public void aeL() { e.i(new bk(this)); }
  
  public void aeM() {
    this.cDD.a(this.cDR);
    for (ac ac : this.cDN) {
      s s = ac.aew();
      s.setConnected(this.cDD.isConnected(s));
      this.cDD.g(ac.aew());
    } 
  }
  
  public boolean aeN() {
    boolean bool3;
    boolean bool2;
    boolean bool1;
    b b1 = this.cDI;
    boolean bool = false;
    if (b1 != null && this.cDI.aeN()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.cDH != null && this.cDH.aeN()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (this.cDJ != null && this.cDJ.aeN()) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool1 || bool2 || bool3)
      bool = true; 
    return bool;
  }
  
  public void aeO() {
    if (aeN()) {
      stopSearch();
      return;
    } 
    aeP();
  }
  
  public void aeP() {
    hH(65535);
    hG(65535);
  }
  
  public ArrayList<q> aeR() { return new ArrayList(this.cDL.values()); }
  
  public void aeT() {
    if (this.cDD != null)
      this.cDD.a(null); 
  }
  
  public void e(UsbDevice paramUsbDevice) {
    aeK();
    aeL();
    aeM();
  }
  
  public void e(ac paramac) {
    if (paramac.aew().agF() == 0 && paramac.aex().contains(bl.cEc))
      paramac.aew().ii(2); 
    this.cDN.add(paramac);
    this.cDF.a(g.cGS.f(paramac.aew()), paramac.aex());
    aeS();
    this.cDD.a(this.cDR);
    this.cDD.g(paramac.aew());
    this.cDF.ael();
  }
  
  public void f(UsbDevice paramUsbDevice) {
    q q = kX((new g(paramUsbDevice.getVendorId(), paramUsbDevice.getProductId(), paramUsbDevice.getDeviceName())).getIdentifier());
    if (q != null) {
      q.agE().setConnected(false);
      aeL();
    } 
  }
  
  public void hF(int paramInt) {
    if (aeN()) {
      stopSearch();
      return;
    } 
    hG(paramInt);
  }
  
  public void hG(int paramInt) {
    this.cDS = paramInt;
    hH(paramInt);
    if ((paramInt & true) != 0 && this.cDH != null)
      this.cDH.start(); 
    int i = paramInt & 0x2;
    if (i != 0 && this.cDI != null)
      this.cDI.start(); 
    if ((i == 0 || this.cDI == null) && (paramInt & 0x4) != 0 && this.cDJ != null)
      this.cDJ.start(); 
  }
  
  public void hI(int paramInt) {
    this.cDN.remove(paramInt);
    aeS();
    this.cDF.ael();
  }
  
  public void hJ(int paramInt) {
    if (paramInt < this.cDL.size() && paramInt >= 0) {
      this.cDL.remove((q[])this.cDL.values().toArray(new q[0])[paramInt].getIdentifier());
      this.cDF.ael();
    } 
  }
  
  public q hK(int paramInt) { return (paramInt < 0 || paramInt >= this.cDL.size()) ? null : (q[])this.cDL.values().toArray(new q[0])[paramInt]; }
  
  public ac hL(int paramInt) { return (paramInt < 0 || paramInt >= this.cDN.size()) ? null : (ac)this.cDN.get(paramInt); }
  
  public void init() {
    this.cDK = a.bh(this.mContext);
    this.cDG = new f(this.mContext);
    aeK();
    aeL();
    aeM();
  }
  
  public void k(q paramq) {
    if (paramq.getType() != 2)
      return; 
    c c1 = (c)paramq.agE();
    if (this.cDP)
      return; 
    this.cDP = true;
    this.cDF.b(paramq);
    int[] arrayOfInt = bd.mi(bd.getLocalIp());
    LinkedHashSet linkedHashSet = new LinkedHashSet();
    linkedHashSet.addAll(bd.f(201, 254, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]));
    linkedHashSet.addAll(bd.f(2, 199, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]));
    g g1 = new g(linkedHashSet);
    a.aKh().r(new bf(this, g1, c1, paramq));
  }
  
  public void stopSearch() {
    try {
      this.cDH.cancel();
      this.cDI.cancel();
      this.cDJ.cancel();
      return;
    } catch (NullPointerException nullPointerException) {
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */