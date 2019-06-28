package com.laiqian.pos.hardware;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.customerdisplay.a;
import com.laiqian.customerdisplay.a.b;
import com.laiqian.customerdisplay.a.c;
import com.laiqian.customerdisplay.a.d;
import com.laiqian.models.ao;
import com.laiqian.models.at;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class b {
  public static final String ckf;
  
  public static final b ckg;
  
  private a ckh;
  
  private boolean cki = true;
  
  private Context context;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.class.getSimpleName());
    stringBuilder.append(".PERMISSION");
    ckf = stringBuilder.toString();
    ckg = new b(CrashApplication.zv());
  }
  
  private b(Context paramContext) { this.context = paramContext; }
  
  private a aal() { return new a(this.ckh); }
  
  private a d(c paramc) throws IOException {
    d d;
    int i = paramc.getType();
    UsbManager usbManager = null;
    UsbDevice usbDevice = null;
    if (i == 1) {
      d = b.n(new File(paramc.aaq()));
      d.setBaudrate(paramc.getBaudrate());
    } else {
      d = usbManager;
      if (paramc.getType() == 2) {
        d = usbManager;
        if (paramc.aap() != null) {
          usbManager = (UsbManager)this.context.getSystemService("usb");
          Iterator iterator = usbManager.getDeviceList().values().iterator();
          d = usbDevice;
          while (iterator.hasNext()) {
            usbDevice = (UsbDevice)iterator.next();
            if (usbDevice.getVendorId() == ((Integer)(paramc.aap()).first).intValue() && usbDevice.getProductId() == ((Integer)(paramc.aap()).second).intValue())
              d = usbDevice; 
          } 
          if (d == null)
            throw new IOException("no specified device"); 
          d = b.a(usbManager, d);
        } 
      } 
    } 
    if (d == null)
      throw new IOException("cannot create IO device"); 
    return new a(d);
  }
  
  public void a(c paramc, boolean paramBoolean) throws IOException {
    if (this.ckh == null)
      this.ckh = d(aan()); 
    if (this.ckh.isOpened())
      close(); 
    if (paramBoolean)
      aao(); 
    if (this.ckh.CU() instanceof c)
      ((c)this.ckh.CU()).setBaudrate(paramc.getBaudrate()); 
    if (!this.ckh.CV())
      throw new IOException("open failed"); 
    if (this.ckh.CU() instanceof d)
      ((d)this.ckh.CU()).setBaudrate(paramc.getBaudrate()); 
  }
  
  public a aaj() {
    a a1 = aal();
    a1.aaj();
    return a1;
  }
  
  public a aak() {
    a a1 = aal();
    a1.aak();
    return a1;
  }
  
  public a aam() throws SecurityException, IOException {
    c c = aan();
    if (!c.isEnabled())
      throw new IOException("not enabled"); 
    if (this.ckh == null)
      this.ckh = d(c); 
    if (!this.ckh.isOpened())
      a(c, this.cki); 
    return this.ckh;
  }
  
  public c aan() {
    ArrayList arrayList = (new at(this.context)).gl(58);
    if (arrayList.size() > 0) {
      c c = (at.a)arrayList.get(0);
      Long long = (Long)c.b(at.bNF);
      boolean bool = "1".equals((String)c.b(at.bNA));
      long l = ((Long)c.b(at.bNE)).longValue();
      if (long != null && long.longValue() == 2L) {
        null = ((String)c.b(at.bNB)).split(",");
        c = new c(bool, Integer.parseInt(null[0]), Integer.parseInt(null[1]), (int)l);
      } else {
        c = new c(bool, (String)c.b(at.bNz), (int)l);
      } 
      return c;
    } 
    Log.w(b.class.getSimpleName(), "no customer setting found");
    return new c(false, "/dev/ttyS2", 'ॠ');
  }
  
  public void aao() {
    if (this.ckh.CU() instanceof d) {
      d d = (d)this.ckh.CU();
      UsbManager usbManager = (UsbManager)this.context.getSystemService("usb");
      if (!usbManager.hasPermission(d.Dd())) {
        Intent intent = new Intent(ckf);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.context, 1, intent, 134217728);
        usbManager.requestPermission(d.Dd(), pendingIntent);
      } 
    } 
  }
  
  public void b(c paramc) {
    if (paramc.isEnabled())
      try {
        this.ckh = d(paramc);
        a(paramc, true);
        return;
      } catch (Exception paramc) {
        a.e(paramc);
        return;
      }  
    this.ckh = null;
  }
  
  public a c(Number paramNumber) {
    a a1 = aal();
    a1.c(paramNumber);
    return a1;
  }
  
  public boolean c(c paramc) {
    String str;
    boolean bool;
    at at = new at(this.context);
    if (at.gl(58).size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    at.a a1 = new at.a();
    a1.a(at.bNz, paramc.aaq());
    ao.b b1 = at.bNA;
    if (paramc.isEnabled()) {
      str = "1";
    } else {
      str = "0";
    } 
    a1.a(b1, str);
    if (paramc.aap() != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((paramc.aap()).first);
      stringBuilder.append(",");
      stringBuilder.append((paramc.aap()).second);
      String str1 = stringBuilder.toString();
      a1.a(at.bNB, str1);
    } 
    a1.a(at.bNE, Long.valueOf(paramc.getBaudrate()));
    a1.a(at.bNF, Long.valueOf(paramc.getType()));
    a1.a(at.bTt, Long.valueOf(58L));
    return bool ? at.a(a1, 58) : at.b(a1);
  }
  
  public void close() {
    if (this.ckh != null)
      this.ckh.CW(); 
  }
  
  public static class a {
    @Nullable
    private a ckj;
    
    a(@Nullable a param1a) { this.ckj = param1a; }
    
    public a aaj() {
      if (this.ckj != null && this.ckj.isOpened())
        try {
          this.ckj.CZ();
          return this;
        } catch (Exception exception) {
          a.e(exception);
        }  
      return this;
    }
    
    public a aak() {
      if (this.ckj != null && this.ckj.isOpened())
        try {
          this.ckj.CY();
          return this;
        } catch (Exception exception) {
          a.e(exception);
        }  
      return this;
    }
    
    public a c(Number param1Number) {
      if (this.ckj != null && this.ckj.isOpened())
        try {
          this.ckj.b(param1Number);
          return this;
        } catch (Exception param1Number) {
          a.e(param1Number);
        }  
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\hardware\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */