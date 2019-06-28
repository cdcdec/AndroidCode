package com.laiqian.dcb.api.client;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.laiqian.dcb.api.a.a;
import com.laiqian.dcb.api.b.d;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.h;
import com.laiqian.dcb.api.b.i;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.client.c.a;
import com.laiqian.util.b;
import com.laiqian.util.logger.h;
import io.netty.a.d;
import io.netty.channel.b.i;
import io.netty.channel.ce;
import io.netty.channel.n;
import io.netty.channel.s;
import io.reactivex.g.a;
import java.util.Date;

@SuppressLint({"NewApi"})
public class ClientService extends Service {
  private static ce aOP;
  
  private static d aOQ;
  
  public static a aOR;
  
  Handler aOS = new c(this);
  
  public static void Du() {
    stringBuilder = new StringBuilder();
    stringBuilder.append("#Stop (ClientService#disConnect) ");
    stringBuilder.append(i.aQc.Eg().format(new Date()));
    h.C(stringBuilder.toString(), i.aQc.Ef());
    if (aOR != null)
      try {
        n n = aOR.DN();
        if (n != null) {
          n.Za();
          n.Zb();
        } 
        aOR = null;
        aOQ = null;
        aOP = null;
        return;
      } catch (Exception stringBuilder) {
        return;
      }  
  }
  
  private d Dv() {
    if (aOQ == null) {
      aOQ = new d();
      if (aOP == null)
        aOP = new i(); 
      ((d)((d)aOQ.a(aOP)).I(io.netty.channel.c.a.b.class)).a(new e(this));
    } 
    return aOQ;
  }
  
  private void Dw() {
    g = new g(this);
    String str = g.oC();
    if (str != null) {
      int i = j.Y(g.Eb());
      try {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("IP: ");
        stringBuilder2.append(str);
        stringBuilder2.append("    Port: ");
        stringBuilder2.append(i);
        stringBuilder2.append("\n开始连接收银机");
        h.bD(stringBuilder2.toString(), b.a.dED.value);
        s s = Dv().M(str, i).aDB();
        s.aDb().YT().ou(10000);
        s.aDb().YW().aDB();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append("||");
        stringBuilder1.append(i);
        d.e("成功连接", stringBuilder1.toString());
        if (aOP != null) {
          aOP.aHj();
          return;
        } 
      } catch (InterruptedException g) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("||");
        stringBuilder.append(i);
        stringBuilder.append(g.toString());
        d.e("连接失败InterruptedException", stringBuilder.toString());
        a.a(getApplicationContext(), 2001, 1005, 0, "");
        stringBuilder = new StringBuilder();
        stringBuilder.append("IP: ");
        stringBuilder.append(str);
        stringBuilder.append("    Port: ");
        stringBuilder.append(i);
        stringBuilder.append("\n");
        stringBuilder.append(g.getMessage());
        h.bD(stringBuilder.toString(), b.a.dED.value);
        if (aOP != null) {
          aOP.aHj();
          return;
        } 
      } catch (Exception g) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("||");
        stringBuilder.append(i);
        stringBuilder.append(g.toString());
        d.e("连接失败", stringBuilder.toString());
        a.a(getApplicationContext(), 2001, 1005, 0, "");
        stringBuilder = new StringBuilder();
        stringBuilder.append("\nIP: ");
        stringBuilder.append(str);
        stringBuilder.append("    Port: ");
        stringBuilder.append(i);
        stringBuilder.append("\n");
        stringBuilder.append(g.getMessage());
        h.bD(stringBuilder.toString(), b.a.dED.value);
        if (aOP != null) {
          aOP.aHj();
          return;
        } 
      } finally {}
    } 
  }
  
  public void Dx() {
    if (aOR == null) {
      aOR = new a(this);
    } else {
      Du();
    } 
    f f = new f(this);
    a.aKh().r(f);
  }
  
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() { Dx(); }
  
  public void onDestroy() {
    Du();
    stopForeground(true);
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt) {
    (new IntentFilter("android.intent.action.USER_PRESENT")).setPriority(2147483647);
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) { return super.onStartCommand(paramIntent, 1, paramInt2); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\ClientService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */