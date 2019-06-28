package com.laiqian.main;

import com.google.a.a.a.a.a.a;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aa;
import com.laiqian.entity.c;
import com.laiqian.entity.v;
import com.laiqian.entity.x;
import com.laiqian.models.a;
import com.laiqian.models.bh;
import com.laiqian.opentable.m;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.pos.model.f;
import com.laiqian.util.av;
import com.laiqian.util.b;
import com.laiqian.util.by;
import com.laiqian.util.logger.AliLog;
import java.util.ArrayList;

public class fg {
  public static fh.b Ml() {
    fh.b b = new fh.b();
    cj cj = new cj(CrashApplication.zv());
    Boolean[] arrayOfBoolean = cj.yO();
    cj.close();
    b.bbI = arrayOfBoolean[1].booleanValue();
    b.bfl = arrayOfBoolean[2].booleanValue();
    b.bfn = "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp());
    b.bfm = dk(b.bfn);
    b.bfm.cQ(b.bbI);
    return b;
  }
  
  static void Mm() {
    bh bh = new bh(CrashApplication.zv());
    long l = bh.WC();
    bh.close();
    av av = new av(CrashApplication.zv());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l);
    stringBuilder.append("");
    av.qI(stringBuilder.toString());
    av.close();
  }
  
  public static PendingFullOrderDetail a(c paramc, ArrayList<aa> paramArrayList, fh.a parama) {
    a a1 = new a(CrashApplication.zv());
    PendingFullOrderDetail pendingFullOrderDetail2 = PendingFullOrderDetail.d(paramArrayList, 1);
    PendingFullOrderDetail.a a2 = pendingFullOrderDetail2.bXb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    a2.orderNo = stringBuilder.toString();
    pendingFullOrderDetail2.bXb.coO = paramc.aSW;
    pendingFullOrderDetail2.bXb.coQ = paramc.aTp;
    pendingFullOrderDetail2.bXb.coP = paramc.name;
    a2 = pendingFullOrderDetail2.bXb;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramc.aRu);
    stringBuilder.append("'");
    stringBuilder.append(paramc.address);
    stringBuilder.append("'");
    stringBuilder.append(paramc.aRv);
    a2.headerText = stringBuilder.toString();
    PendingFullOrderDetail pendingFullOrderDetail1 = a(parama, pendingFullOrderDetail2);
    pendingFullOrderDetail1.bXb.coS = a1.a("1", "today", pendingFullOrderDetail1.bXb.coE);
    a1.close();
    return pendingFullOrderDetail1;
  }
  
  private static PendingFullOrderDetail a(fh.a parama, PendingFullOrderDetail paramPendingFullOrderDetail) {
    long l;
    paramPendingFullOrderDetail.bXb.aVN = parama.delivery;
    paramPendingFullOrderDetail.bXb.bZF = 1;
    paramPendingFullOrderDetail.bXb.ceX = Double.valueOf(parama.discount);
    if (parama.bfi.aTv == 10013) {
      l = parama.bfi.aTe;
    } else {
      l = parama.bfi.aTv;
    } 
    if (parama.bfh != null) {
      long l1;
      if (parama.bfh.AR() == 10013L) {
        l1 = parama.bfh.aTx;
      } else {
        l1 = parama.bfh.AR();
      } 
      paramPendingFullOrderDetail.bXb.aVS = l;
      paramPendingFullOrderDetail.bXb.bfj = parama.bfj;
      paramPendingFullOrderDetail.bXb.aVU = l1;
      paramPendingFullOrderDetail.bXb.bfk = parama.bfk;
      return paramPendingFullOrderDetail;
    } 
    paramPendingFullOrderDetail.bXb.aVS = l;
    paramPendingFullOrderDetail.bXb.bfj = parama.bfj;
    if (paramPendingFullOrderDetail.bXb.aVS != 10001L) {
      paramPendingFullOrderDetail.bXb.aVU = 10001L;
    } else {
      paramPendingFullOrderDetail.bXb.aVU = 0L;
    } 
    paramPendingFullOrderDetail.bXb.bfk = 0.0D;
    return paramPendingFullOrderDetail;
  }
  
  public static PendingFullOrderDetail a(ArrayList<aa> paramArrayList1, ArrayList<aa> paramArrayList2, PendingFullOrderDetail.a parama, fh.a parama1) {
    boolean bool = true;
    PendingFullOrderDetail pendingFullOrderDetail1 = PendingFullOrderDetail.d(paramArrayList2, 1);
    pendingFullOrderDetail1.bXb = parama;
    pendingFullOrderDetail1.bXb.coJ = null;
    null = PendingFullOrderDetail.d(paramArrayList1, 1);
    a a1 = new a(CrashApplication.zv());
    PendingFullOrderDetail pendingFullOrderDetail2 = a(parama1, a1.ky(pendingFullOrderDetail1.bXb.orderNo));
    PendingFullOrderDetail.c c = a1.a(a1.a(pendingFullOrderDetail1, null));
    if (c.cpg.size() != 0)
      bool = a1.b(c, pendingFullOrderDetail2.bXb); 
    if (bool)
      m.a(CrashApplication.zv(), pendingFullOrderDetail1, c, false); 
    return pendingFullOrderDetail1;
  }
  
  public static String ao(long paramLong) {
    str2 = CrashApplication.zv().getString(2131625386);
    String str1 = str2;
    try {
      a a = new a(RootApplication.zv());
      if (paramLong > 10013L) {
        str1 = str2;
        StringBuilder stringBuilder = new StringBuilder();
        str1 = str2;
        stringBuilder.append(paramLong);
        str1 = str2;
        stringBuilder.append("");
        str1 = str2;
        str2 = a.gY(stringBuilder.toString());
        str1 = str2;
      } else {
        str1 = str2;
        str2 = v.ap(paramLong);
        str1 = str2;
      } 
      str2 = str1;
      str1 = str2;
      a.close();
      return str2;
    } catch (Exception str2) {
      a.e(str2);
      return str1;
    } 
  }
  
  private static x dk(boolean paramBoolean) {
    a a = new a(CrashApplication.zv());
    null = new av(CrashApplication.zv());
    String str1 = null.atm();
    String str2 = null.Tx();
    null.close();
    x x = new x();
    if (paramBoolean) {
      x.cN(true);
      x.cO(true);
      x.cP(true);
    } else {
      x = a.e(str1, str2, false);
    } 
    a.close();
    return x;
  }
  
  public static String eW(String paramString) {
    f f = new f(CrashApplication.zv());
    paramString = f.cw(by.parseLong(paramString));
    f.close();
    return paramString;
  }
  
  public static void eX(String paramString) { b.a(AliLog.b.dHc, b.a.dEH, paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */