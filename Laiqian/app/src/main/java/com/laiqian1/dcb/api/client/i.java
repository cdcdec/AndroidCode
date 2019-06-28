package com.laiqian.dcb.api.client;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.dcb.api.a.a;
import com.laiqian.dcb.api.b.d;
import io.netty.a.d;
import io.netty.channel.ah;
import io.netty.channel.b.i;
import io.netty.channel.m;
import io.netty.channel.s;

final class i implements Runnable {
  i(String paramString, int paramInt) {}
  
  public void run() {
    i1 = new i();
    try {
      d d = new d();
      ((d)((d)((d)((d)((d)((d)((d)d.a(i1)).I(io.netty.channel.c.a.b.class)).a(ah.ebV, Integer.valueOf(30000))).a(ah.ecf, Integer.valueOf(8192))).a(ah.ecg, Integer.valueOf(1024))).a(ah.ecq, Boolean.valueOf(true))).a(ah.ebT, m.ebF)).a(new j(this));
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("IP: ");
      stringBuilder2.append(this.aPe);
      stringBuilder2.append("    Port: ");
      stringBuilder2.append(this.aPf);
      stringBuilder2.append("\n开始连接收银机");
      stringBuilder2.toString();
      s s = d.M(this.aPe, this.aPf).aDB();
      (h.DI()).aPd = s.aDb();
      (h.DI()).aPd.YW().aDB();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.aPe);
      stringBuilder1.append("||");
      stringBuilder1.append(this.aPf);
      d.e("成功连接", stringBuilder1.toString());
      try {
        i1.aHj().aDT();
        return;
      } catch (InterruptedException i1) {
        a.e(i1);
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\nIP: ");
      stringBuilder.append(this.aPe);
      stringBuilder.append("    Port: ");
      stringBuilder.append(this.aPf);
      stringBuilder.append("\n");
      stringBuilder.append(exception.getMessage());
      stringBuilder.toString();
      k.aPi = 0;
      a.a(RootApplication.zv().getApplicationContext(), new int[] { 2001, 2004 }, 1005, 0, "");
      i1.aHj().aDT();
      return;
    } finally {
      String str;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */