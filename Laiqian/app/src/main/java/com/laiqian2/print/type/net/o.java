package com.laiqian.print.type.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.widget.Toast;
import com.laiqian.print.g;
import com.laiqian.print.model.g;
import com.laiqian.print.model.type.b.c;
import com.laiqian.print.util.d;
import com.laiqian.util.bd;
import com.laiqian.util.bp;
import io.reactivex.g.a;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class o {
  v cLE;
  
  bp<x> cLF = new bp(Arrays.asList(new x[] { x.cLU, x.cLV }, ), false);
  
  ConnectivityManager cLw;
  
  Context context;
  
  WifiManager czn;
  
  public o(Context paramContext, v paramv) {
    if (paramv == null)
      throw new NullPointerException("view cannot be null"); 
    this.context = paramContext;
    this.cLE = paramv;
    this.czn = (WifiManager)paramContext.getSystemService("wifi");
    this.cLw = (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  public String a(x paramx) {
    StringBuilder stringBuilder;
    switch (u.cLK[paramx.ordinal()]) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("unknown brand");
        stringBuilder.append(paramx);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 2:
        return this.context.getString(2131628874);
      case 1:
        break;
    } 
    return this.context.getString(2131628709);
  }
  
  public void aL(String paramString1, String paramString2) {
    if (bd.rQ(paramString2)) {
      if (!bd.rR(paramString2)) {
        this.cLE.lJ(this.context.getString(2131624760));
        return;
      } 
      l l = new l(this.context, paramString1, paramString2, (x)this.cLF.aws());
      l.a(new s(this));
      if (!bd.rP(paramString1)) {
        if (this.cLw.getActiveNetworkInfo().getType() == 9) {
          this.cLE.lJ(this.context.getString(2131628711));
          return;
        } 
        Toast.makeText(this.context, this.context.getString(2131624758), 0).show();
      } 
      this.cLE.ahE();
      l.ahJ();
      return;
    } 
    this.cLE.lJ(this.context.getString(2131624760));
  }
  
  public bp<x> ahS() { return this.cLF; }
  
  public void ahT() {
    d.a a = d.ajh();
    if (a == null)
      return; 
    int[] arrayOfInt = bd.mi(a.getAddress().getHostAddress());
    LinkedHashSet linkedHashSet = new LinkedHashSet();
    linkedHashSet.addAll(bd.f(240, 254, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]));
    linkedHashSet.addAll(bd.f(123, 199, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]));
    linkedHashSet.addAll(bd.f(2, 99, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]));
    linkedHashSet.addAll(bd.f(100, 122, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]));
    linkedHashSet.addAll(bd.f(201, 239, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]));
    g g = new g(linkedHashSet);
    a.aKh().r(new p(this, g));
    this.cLE.ahG();
  }
  
  public void init() {
    this.cLE.lK("192.168.1.200");
    this.cLE.lM(a((x)this.cLF.aws()));
  }
  
  public void it(int paramInt) {
    this.cLF.li(paramInt);
    this.cLE.lM(a((x)this.cLF.aws()));
  }
  
  public void lN(String paramString) {
    if (!bd.rP(paramString)) {
      if (this.cLw.getActiveNetworkInfo().getType() == 9) {
        this.cLE.lJ(this.context.getString(2131628711));
        return;
      } 
      Toast.makeText(this.context, this.context.getString(2131624758), 0).show();
      l l = new l(this.context, paramString, "192.168.1.2", (x)this.cLF.aws());
      l.ahM();
      c = new c(paramString, '⎌');
      g g1 = g.cGS;
      g1.a(new q(this, l));
      this.cLE.ahE();
      g1.g(c);
      return;
    } 
    c c = new c(c, '⎌');
    g g = g.cGS;
    g.a(new r(this));
    this.cLE.ahE();
    g.g(c);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */