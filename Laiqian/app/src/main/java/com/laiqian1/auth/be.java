package com.laiqian.auth;

import android.text.format.Time;
import android.util.Pair;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.an;
import com.laiqian.print.b.c;
import com.laiqian.print.b.g;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.printtype.f;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.print.util.e;
import com.laiqian.report.models.a;
import com.laiqian.util.n;
import com.laiqian.util.p;
import java.util.Collections;
import java.util.List;

class be implements j.f {
  be(bd parambd) {}
  
  private List<PrintContent> a(bb parambb, f paramf, j.i parami) {
    PrintContent.a a = new PrintContent.a();
    g g = new g(a);
    g.setWidth(a.bo(CrashApplication.zv()).aiL().getWidth());
    null = new an(RootApplication.zv());
    g.lk((null.Vu()).aVs);
    null.close();
    g.lk(bd.a(this.aEZ).getString(2131627965));
    g.l('-');
    null = new int[2];
    null[0] = 17;
    null[1] = 15;
    null;
    null = new Time();
    null.set((parambb.yj()).aet);
    String str = bd.a(this.aEZ).getString(2131627400);
    null = null.format(str);
    null.set((parambb.yj()).end);
    null = null.format(str);
    g.n(new int[] { 12, 20 });
    str = bd.a(this.aEZ).getString(2131627972);
    byte b2 = 0;
    g.x(new String[] { str, null });
    g.x(new String[] { bd.a(this.aEZ).getString(2131627973), null });
    g.x(new String[] { bd.a(this.aEZ).getString(2131627976), (parambb.yj()).userName });
    if ((parambb.yj()).aEK == null)
      g.x(new String[] { bd.a(this.aEZ).getString(2131627969), n.a(Double.valueOf((parambb.yj()).aEJ), true, false) }); 
    g.l('-');
    g.lk(parambb.yl().getTitle());
    g.l('-');
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 17;
    arrayOfInt[1] = 15;
    arrayOfInt;
    a(parambb.yl().yw(), a, arrayOfInt);
    g.l('-');
    g.setSize(3);
    g.n(null);
    g.x(new String[] { bd.a(this.aEZ).getString(2131630098), n.a(parambb.yl().yx(), true, false) });
    byte b1;
    for (b1 = 0; b1 < 3; b1++)
      g.ll(""); 
    g.lk(parambb.yk().getTitle());
    g.l('-');
    g.setSize(0);
    g.n(null);
    for (Pair pair : parambb.yk().yr()) {
      g.x(new String[] { (String)pair.first, n.a(pair.second, true, false) });
    } 
    g.l('-');
    g.setSize(3);
    g.n(null);
    g.x(new String[] { bd.a(this.aEZ).getString(2131627431), n.a(Integer.valueOf(parambb.yk().yt()), false, false) });
    g.x(new String[] { bd.a(this.aEZ).getString(2131629389), n.a(Integer.valueOf(parambb.yk().ys()), false, false) });
    g.x(new String[] { bd.a(this.aEZ).getString(2131630099), n.a(Double.valueOf(parambb.yk().yu()), true, false) });
    g.l('-');
    g.x(new String[] { bd.a(this.aEZ).getString(2131630096), n.a(Double.valueOf(parambb.yk().yv()), true, false) });
    if ((parambb.yj()).aEK != null) {
      g.l('-');
      g.ll("");
      g.setSize(0);
      g.n(arrayOfInt);
      g.x(new String[] { bd.a(this.aEZ).getString(2131627969), n.a(Double.valueOf((parambb.yj()).aEJ), true, false) });
      double d1 = (parambb.yj()).aEJ + 0.0D;
      for (a a1 : (parambb.yj()).aEL) {
        g.x(new String[] { a1.Yx, a1.cZl });
        d1 += a1.cZk;
      } 
      double d2 = d1;
      if (!n.bc((parambb.yj()).aEK.doubleValue())) {
        g.x(new String[] { "Total CashFlow", n.a((parambb.yj()).aEK, true, false) });
        d2 = d1 + (parambb.yj()).aEK.doubleValue();
      } 
      g.l('-');
      g.n(null);
      g.x(new String[] { "Cash Total", n.a(Double.valueOf(d2), true, false) });
    } 
    for (b1 = 0; b1 < 3; b1++)
      g.ll(""); 
    g.lk(parambb.ym().getTitle());
    g.l('-');
    List list = parambb.ym().yr();
    g.setSize(0);
    g.n(null);
    for (Pair pair : list) {
      g.x(new String[] { (String)pair.first, n.a(pair.second, true, false) });
    } 
    this.aEZ.a(parambb.yi(), g);
    for (b1 = b2; b1 < 3; b1++)
      a.ln(""); 
    a.ih(parami.getCopies());
    return Collections.singletonList(a.afV());
  }
  
  private List<PrintContent> a(bc parambc, f paramf, j.i parami) {
    int j = p.asB();
    String str1 = n.ls(j);
    int[] arrayOfInt1 = new Time();
    arrayOfInt1.set(parambc.aet);
    null = bd.a(this.aEZ).getString(2131627400);
    String str2 = arrayOfInt1.format(null);
    arrayOfInt1.set(parambc.end);
    String str3 = arrayOfInt1.format(null);
    String str4 = yC();
    byte b = 0;
    String str5 = bd.a(this.aEZ).getString(2131627946);
    String str6 = bd.a(this.aEZ).getString(2131627941);
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 2;
    arrayOfInt2[2] = 2;
    arrayOfInt2;
    int[] arrayOfInt3 = new int[2];
    arrayOfInt3[0] = 0;
    arrayOfInt3[1] = 2;
    arrayOfInt3;
    if (j == 32) {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 14;
      arrayOfInt[1] = 8;
      arrayOfInt[2] = 10;
      arrayOfInt;
    } else if (j == 48) {
      arrayOfInt1 = new int[3];
      arrayOfInt1[0] = 21;
      arrayOfInt1[1] = 12;
      arrayOfInt1[2] = 15;
      arrayOfInt1;
    } else {
      return null;
    } 
    int[] arrayOfInt4 = new int[2];
    arrayOfInt4[0] = 12;
    arrayOfInt4[1] = j - 12;
    PrintContent.a a = new PrintContent.a();
    c c = new c(a);
    an an = new an(bd.a(this.aEZ));
    c.lk((an.Vu()).aVs);
    an.close();
    c.lk(CrashApplication.zv().getString(2131627953));
    a.ln(str1);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627434), str2 }, 0);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627435), str3 }, 0);
    a.ln(str1);
    e.b(a, arrayOfInt1, arrayOfInt2, new String[] { str4, str5, str6 }, 0);
    a.ln(str1);
    for (bc.a a1 : parambc.aEW) {
      e.b(a, arrayOfInt1, arrayOfInt2, new String[] { null, null, (new String[3][1] = (new String[3][0] = a1.name).valueOf(a1.aEX)).valueOf(a1.aEY) }, 0);
    } 
    a.ln(str1);
    while (b < 3) {
      a.ln("");
      b++;
    } 
    a.ih(parami.getCopies());
    return Collections.singletonList(a.afV());
  }
  
  private List<PrintContent> a(bf parambf, f paramf, j.i parami) {
    ReceiptPrintSettings receiptPrintSettings = (ReceiptPrintSettings)paramf;
    PrintContent.a a = new PrintContent.a();
    g g = new g(a);
    g.setWidth(a.bo(CrashApplication.zv()).aiL().getWidth());
    int j = e.jg(g.getWidth());
    double d = j;
    int k = (int)(0.45D * d);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = k;
    arrayOfInt[1] = j - k;
    g.n(arrayOfInt);
    g.lk(bd.a(this.aEZ).getString(2131628201));
    g.l('-');
    String str2 = CrashApplication.zv().getString(2131627400);
    Time time = new Time();
    time.set(parambf.aet);
    String str3 = time.format(str2);
    g.x(new String[] { bd.a(this.aEZ).getString(2131628202), str3 });
    time.set(parambf.end);
    str2 = time.format(str2);
    g.x(new String[] { bd.a(this.aEZ).getString(2131628200), str2 });
    g.l('-');
    k = (int)(d * 0.65D);
    a.a(parambf.aFa, a, new int[] { k, j - k });
    g.l('-');
    g.setSize(3);
    g.n(arrayOfInt);
    String str1 = CrashApplication.zv().getString(2131627431);
    j = 0;
    g.x(new String[] { str1, n.a(Double.valueOf(parambf.aFb), false, false) });
    g.x(new String[] { CrashApplication.zv().getString(2131628409), n.a(Double.valueOf(parambf.aFc), true, false) });
    g.x(new String[] { CrashApplication.zv().getString(2131627796), n.a(Double.valueOf(parambf.aFd), true, false) });
    k = receiptPrintSettings.air();
    while (j < k) {
      a.ln("");
      j++;
    } 
    return Collections.singletonList(a.afV());
  }
  
  private void a(List<a> paramList, PrintContent.a parama, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt) {
    for (a a1 : paramList) {
      String str;
      if (a1.cZq) {
        int i;
        paramList = a1.amq();
        if (paramInt == 0) {
          i = paramInt;
        } else {
          i = paramInt + 1;
        } 
        a(paramList, parama, paramArrayOfInt1, paramArrayOfInt2, i);
        continue;
      } 
      if (a1.cZr) {
        StringBuilder stringBuilder1 = new StringBuilder();
        if (paramInt > 0) {
          str = "  ";
        } else {
          String str1;
          str = "";
        } 
        stringBuilder1.append(str);
        stringBuilder1.append(a1.Yx);
        e.b(parama, paramArrayOfInt1, paramArrayOfInt2, new String[] { stringBuilder1.toString(), n.pm(a1.cZl) }, 0);
        a(a1.amq(), parama, paramArrayOfInt1, paramArrayOfInt2, paramInt + 1);
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      if (paramInt > 0) {
        str = "  ";
      } else {
        str = "";
      } 
      stringBuilder.append(str);
      stringBuilder.append(a1.Yx);
      e.b(parama, paramArrayOfInt1, paramArrayOfInt2, new String[] { stringBuilder.toString(), n.pm(a1.cZl) }, 0);
    } 
  }
  
  private String yC() { return bd.a(this.aEZ).getString(2131627944); }
  
  public List<PrintContent> a(Object paramObject, String paramString, j.i parami, f paramf) {
    if (paramObject.getClass().isAssignableFrom(bc.class))
      return a((bc)paramObject, paramf, parami); 
    if (paramObject.getClass().isAssignableFrom(bf.class))
      return a((bf)paramObject, paramf, parami); 
    if (paramObject.getClass().isAssignableFrom(bb.class))
      return a((bb)paramObject, paramf, parami); 
    throw new RuntimeException("no match");
  }
  
  public void a(List<a> paramList, PrintContent.a parama, int[] paramArrayOfInt) { a(paramList, parama, paramArrayOfInt, new int[] { 0, 2 }, 0); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */