package com.laiqian.dcb.api.server;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.PowerManager;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.server.c.d;
import com.laiqian.util.logger.a;
import io.netty.a.i;
import io.netty.c.b.a;
import io.netty.c.b.b;
import io.netty.channel.a.a;
import io.netty.channel.a.h;
import io.netty.channel.b.i;
import io.netty.channel.ce;
import io.netty.channel.n;
import io.netty.channel.s;
import io.netty.e.b.aa;
import io.reactivex.g.a;
import java.net.InetSocketAddress;

public class ServerService extends Service {
  public static a aPG;
  
  private a aOV = new a(ServerService.class.getSimpleName());
  
  private ce aPA;
  
  private i aPB = null;
  
  private n aPC;
  
  private ce aPD;
  
  private ce aPE;
  
  private PowerManager.WakeLock aPF;
  
  private i aPx = null;
  
  private n aPy;
  
  private ce aPz;
  
  private void DU() {
    if (aPG == null)
      aPG = new h(aa.epF); 
    if (this.aPz == null)
      this.aPz = new i(); 
    if (this.aPA == null)
      this.aPA = new i(); 
  }
  
  private void DV() {
    if (this.aPD == null)
      this.aPD = new i(); 
    if (this.aPE == null)
      this.aPE = new i(); 
  }
  
  private s a(InetSocketAddress paramInetSocketAddress) {
    try {
      DU();
      this.aPx = new i();
      ((i)this.aPx.a(this.aPz, this.aPA).I(io.netty.channel.c.a.a.class)).b(new d(this));
      s s = this.aPx.a(paramInetSocketAddress).aDC();
      try {
        this.aPy = s.aDb();
        return s;
      } catch (Exception exception) {}
    } catch (Exception paramInetSocketAddress) {
      paramInetSocketAddress = null;
    } 
    close();
    return paramInetSocketAddress;
  }
  
  public static void aa(Context paramContext) { paramContext.startService(new Intent(paramContext, ServerService.class)); }
  
  public static void ae(Context paramContext) { paramContext.stopService(new Intent(paramContext, ServerService.class)); }
  
  private s b(InetSocketAddress paramInetSocketAddress) {
    try {
      DV();
      this.aPB = new i();
      ((i)this.aPB.a(this.aPD, this.aPE).I(io.netty.channel.c.a.a.class)).b(new b(a.ekT)).b(new d(this));
      s s = this.aPB.a(paramInetSocketAddress).aDC();
      try {
        this.aPC = s.aDb();
        return s;
      } catch (Exception exception) {}
    } catch (Exception paramInetSocketAddress) {
      paramInetSocketAddress = null;
    } 
    close();
    return paramInetSocketAddress;
  }
  
  private void close() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield aPy : Lio/netty/channel/n;
    //   6: ifnull -> 24
    //   9: aload_0
    //   10: getfield aPy : Lio/netty/channel/n;
    //   13: invokeinterface Zb : ()Lio/netty/channel/s;
    //   18: pop
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield aPy : Lio/netty/channel/n;
    //   24: getstatic com/laiqian/dcb/api/server/ServerService.aPG : Lio/netty/channel/a/a;
    //   27: ifnull -> 43
    //   30: getstatic com/laiqian/dcb/api/server/ServerService.aPG : Lio/netty/channel/a/a;
    //   33: invokeinterface aET : ()Lio/netty/channel/a/c;
    //   38: pop
    //   39: aconst_null
    //   40: putstatic com/laiqian/dcb/api/server/ServerService.aPG : Lio/netty/channel/a/a;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield aPx : Lio/netty/a/i;
    //   48: aload_0
    //   49: getfield aPz : Lio/netty/channel/ce;
    //   52: ifnull -> 70
    //   55: aload_0
    //   56: getfield aPz : Lio/netty/channel/ce;
    //   59: invokeinterface aHj : ()Lio/netty/e/b/v;
    //   64: pop
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield aPz : Lio/netty/channel/ce;
    //   70: aload_0
    //   71: getfield aPA : Lio/netty/channel/ce;
    //   74: ifnull -> 92
    //   77: aload_0
    //   78: getfield aPA : Lio/netty/channel/ce;
    //   81: invokeinterface aHj : ()Lio/netty/e/b/v;
    //   86: pop
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield aPA : Lio/netty/channel/ce;
    //   92: aload_0
    //   93: getfield aPC : Lio/netty/channel/n;
    //   96: ifnull -> 114
    //   99: aload_0
    //   100: getfield aPC : Lio/netty/channel/n;
    //   103: invokeinterface Zb : ()Lio/netty/channel/s;
    //   108: pop
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield aPC : Lio/netty/channel/n;
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield aPB : Lio/netty/a/i;
    //   119: aload_0
    //   120: getfield aPD : Lio/netty/channel/ce;
    //   123: ifnull -> 141
    //   126: aload_0
    //   127: getfield aPD : Lio/netty/channel/ce;
    //   130: invokeinterface aHj : ()Lio/netty/e/b/v;
    //   135: pop
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield aPD : Lio/netty/channel/ce;
    //   141: aload_0
    //   142: getfield aPE : Lio/netty/channel/ce;
    //   145: ifnull -> 158
    //   148: aload_0
    //   149: getfield aPE : Lio/netty/channel/ce;
    //   152: invokeinterface aHj : ()Lio/netty/e/b/v;
    //   157: pop
    //   158: aload_0
    //   159: aconst_null
    //   160: putfield aPE : Lio/netty/channel/ce;
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	166	finally
    //   24	43	166	finally
    //   43	70	166	finally
    //   70	92	166	finally
    //   92	114	166	finally
    //   114	141	166	finally
    //   141	158	166	finally
    //   158	163	166	finally }
  
  private void el(int paramInt) { a.aKh().r(new b(this, paramInt)); }
  
  private void em(int paramInt) { a.aKh().r(new c(this, paramInt)); }
  
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() {
    g g = new g(this);
    em(j.Y(g.DZ()));
    this.aOV.b("server port: %d", new Object[] { Integer.valueOf(j.Y(g.DZ())) });
    el(j.Z(g.DZ()));
    g.close();
    this.aPF = ((PowerManager)getSystemService("power")).newWakeLock(1, "wakelock");
    this.aPF.acquire();
  }
  
  public void onDestroy() {
    close();
    stopForeground(true);
    this.aPF.release();
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt) {
    (new IntentFilter("android.intent.action.USER_PRESENT")).setPriority(2147483647);
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) { return super.onStartCommand(paramIntent, 1, paramInt2); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\ServerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */