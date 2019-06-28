package com.laiqian.print.type.net;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.google.a.a.a.a.a.a;
import com.laiqian.pos.settings.a;
import com.laiqian.print.model.e;
import com.laiqian.print.model.f;
import com.laiqian.print.model.g;
import com.laiqian.print.model.q;
import com.laiqian.print.model.type.b.c;
import com.laiqian.util.DeviceOwnerReceiver;
import com.laiqian.util.af;
import com.laiqian.util.bd;
import com.orhanobut.logger.d;
import io.reactivex.g.a;
import java.net.InetAddress;

public class l {
  x cLA;
  
  String cLp;
  
  String cLq;
  
  String cLr;
  
  int[] cLs;
  
  int[] cLt;
  
  int[] cLu;
  
  String cLv;
  
  ConnectivityManager cLw;
  
  DevicePolicyManager cLx;
  
  a cLy = null;
  
  WifiConfiguration cLz = null;
  
  Context context;
  
  WifiManager czn;
  
  public l(Context paramContext, String paramString1, String paramString2) { this(paramContext, paramString1, paramString2, x.cLU); }
  
  public l(Context paramContext, String paramString1, String paramString2, x paramx) {
    this.context = paramContext;
    this.cLA = paramx;
    this.cLp = bd.getLocalIp();
    this.cLv = bd.bY(paramContext);
    this.cLq = paramString1;
    this.cLr = paramString2;
    if (!bd.rQ(paramString1) || !bd.rQ(paramString2))
      throw new IllegalArgumentException("wrong format ip address"); 
    this.cLs = bd.mi(this.cLp);
    this.cLt = bd.mi(paramString1);
    this.cLu = bd.mi(paramString2);
    this.czn = (WifiManager)paramContext.getSystemService("wifi");
    this.cLw = (ConnectivityManager)paramContext.getSystemService("connectivity");
    this.cLx = (DevicePolicyManager)paramContext.getSystemService("device_policy");
  }
  
  private boolean aK(String paramString1, String paramString2) {
    int[] arrayOfInt1 = bd.mi(paramString1);
    int[] arrayOfInt2 = bd.mi(paramString2);
    return (arrayOfInt1[2] == arrayOfInt2[2]);
  }
  
  private void ahK() { fV(false); }
  
  private void ahN() {
    ComponentName componentName = DeviceOwnerReceiver.bT(this.context);
    af.a(componentName);
    af.b(componentName);
  }
  
  private void ahO() {
    ComponentName componentName = DeviceOwnerReceiver.bT(this.context);
    af.c(componentName);
    if (ahQ()) {
      this.cLx.clearDeviceOwnerApp(this.context.getPackageName());
      this.cLx.removeActiveAdmin(componentName);
    } 
  }
  
  private boolean ahP() { return (Build.VERSION.SDK_INT >= 23); }
  
  private boolean ahQ() { return this.cLx.isDeviceOwnerApp(this.context.getPackageName()); }
  
  private String ahR() {
    int i = this.cLs[3];
    while (true) {
      if (i == this.cLt[3] || i == this.cLu[3] || i == 1 || i == 255 || i == 0) {
        i = (i + 1) % 255;
        continue;
      } 
      return bd.r(new int[] { this.cLt[0], this.cLt[1], this.cLt[2], i });
    } 
  }
  
  private boolean c(WifiConfiguration paramWifiConfiguration) {
    d.d("changing our ip", new Object[0]);
    if (ahP() && !ahQ())
      try {
        ahN();
      } catch (Exception exception) {
        a.e(exception);
      }  
    try {
      bd.a("STATIC", paramWifiConfiguration);
      String str1 = ahR();
      d.b("generated target ip: %s", new Object[] { str1 });
      bd.a(InetAddress.getByName(str1), 24, paramWifiConfiguration);
      if (this.cLv != null) {
        str1 = this.cLv;
        bd.a(InetAddress.getByName(str1), paramWifiConfiguration);
        bd.a(InetAddress.getByName("8.8.8.8"), null, paramWifiConfiguration);
        (new a(this.czn)).a(paramWifiConfiguration);
        return true;
      } 
    } catch (Exception paramWifiConfiguration) {
      a.e(paramWifiConfiguration);
      return false;
    } 
    String str = "192.168.1.1";
    bd.a(InetAddress.getByName(str), paramWifiConfiguration);
    bd.a(InetAddress.getByName("8.8.8.8"), null, paramWifiConfiguration);
    (new a(this.czn)).a(paramWifiConfiguration);
    return true;
  }
  
  private void fV(boolean paramBoolean) { a.aKh().r(new m(this, paramBoolean)); }
  
  public void a(a parama) { this.cLy = parama; }
  
  public void ahJ() {
    d.b("our ip: %s, old ip: %s, new ip: %s", new Object[] { this.cLp, this.cLq, this.cLr });
    if (!bd.bH(this.context)) {
      if (this.cLy != null)
        this.cLy.hM(3); 
      return;
    } 
    if (!aK(this.cLp, this.cLq)) {
      this.cLz = bd.bZ(this.context);
      if (this.cLz == null) {
        d.b("cannot find current wifi, how?", new Object[0]);
        if (this.cLy != null)
          this.cLy.hM(3); 
      } 
      if (!c(this.cLz)) {
        if (this.cLy != null)
          this.cLy.hM(2); 
        return;
      } 
      fV(true);
      return;
    } 
    ahK();
  }
  
  public boolean ahL() { return b(bd.bZ(this.context)); }
  
  public boolean ahM() { return c(bd.bZ(this.context)); }
  
  public boolean b(WifiConfiguration paramWifiConfiguration) {
    boolean bool;
    if (ahP() && !ahQ())
      try {
        ahN();
      } catch (Exception exception) {
        a.e(exception);
      }  
    try {
      bd.a("DHCP", paramWifiConfiguration);
      (new a(this.czn)).a(paramWifiConfiguration);
      bool = true;
    } catch (Exception paramWifiConfiguration) {
      bool = false;
    } 
    if (ahQ())
      ahO(); 
    return bool;
  }
  
  public static interface a {
    void hM(int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */