package com.laiqian.print.cardreader;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.laiqian.print.model.type.usb.a;
import com.laiqian.print.model.type.usb.a.a;
import com.laiqian.print.model.type.usb.b;
import com.laiqian.print.model.type.usb.e;
import com.laiqian.util.bb;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class c {
  private static final ArrayList<Map.Entry<Integer, Integer>> cEk = new ArrayList();
  
  private HashMap<String, a> cEl = new HashMap();
  
  private b cEm;
  
  private Context mContext;
  
  private int mStatus;
  
  static  {
    cEk.add(new AbstractMap.SimpleImmutableEntry(Integer.valueOf(10685), Integer.valueOf(3004)));
    cEk.add(new AbstractMap.SimpleImmutableEntry(Integer.valueOf(1267), Integer.valueOf(1003)));
    cEk.add(new AbstractMap.SimpleImmutableEntry(Integer.valueOf(1267), Integer.valueOf(1842)));
  }
  
  public c(Context paramContext) {
    this.mContext = paramContext;
    setStatus(1);
  }
  
  private HashMap<String, a> aeZ() {
    null = (UsbManager)this.mContext.getSystemService("usb");
    s s = s.aZ(this.mContext);
    null = null.getDeviceList();
    HashMap hashMap = new HashMap();
    for (Map.Entry null : null.entrySet()) {
      null = (UsbDevice)null.getValue();
      AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(Integer.valueOf(null.getVendorId()), Integer.valueOf(null.getProductId()));
      if (cEk.contains(simpleEntry))
        continue; 
      bb.f("tag", String.format("device: %s, %d, %d", new Object[] { null.getDeviceName(), Integer.valueOf(null.getVendorId()), Integer.valueOf(null.getProductId()) }));
      String str = (String)null.getKey();
      a a = s.g(null);
      if (a != null)
        hashMap.put(str, a); 
    } 
    return hashMap;
  }
  
  public void a(b paramb) { this.cEm = paramb; }
  
  public boolean aeN() { return (this.mStatus == 2); }
  
  public b aeY() { return this.cEm; }
  
  protected void afa() {
    setStatus(3);
    b b1 = aeY();
    if (b1 != null)
      b1.aeV(); 
  }
  
  protected void b(a parama) {
    null = e.bf(this.mContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parama.getVendorId());
    stringBuilder.append(",");
    stringBuilder.append(parama.getProductId());
    null = null.lw(stringBuilder.toString());
    if (null != null) {
      if (null instanceof a)
        parama.ii(((a)null).agU()); 
      parama.setName(null.getName());
    } 
    b b1 = aeY();
    if (b1 != null)
      b1.a(parama); 
  }
  
  public void cancel() {}
  
  protected void onStarted() {
    setStatus(2);
    b b1 = aeY();
    if (b1 != null)
      b1.aeX(); 
  }
  
  protected void setStatus(int paramInt) { this.mStatus = paramInt; }
  
  public void start() {
    onStarted();
    synchronized (this.cEl) {
      this.cEl = aeZ();
      Iterator iterator = this.cEl.entrySet().iterator();
      while (iterator.hasNext())
        b((a)((Map.Entry)iterator.next()).getValue()); 
      afa();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */