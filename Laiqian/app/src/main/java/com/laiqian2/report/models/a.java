package com.laiqian.report.models;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.format.Time;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.bb;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.models.al;
import com.laiqian.models.bh;
import com.laiqian.models.o;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.g;
import com.laiqian.print.util.e;
import com.laiqian.util.av;
import com.laiqian.util.l;
import com.laiqian.util.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class a {
  public String Yx;
  
  public int aTb;
  
  public String cZj;
  
  public double cZk;
  
  public String cZl;
  
  public int cZm;
  
  public long cZn;
  
  private ArrayList<a> cZo;
  
  private boolean cZp;
  
  public boolean cZq;
  
  public boolean cZr;
  
  private HashMap<String, Double> cZs = new HashMap();
  
  public a(long paramLong, String paramString, double paramDouble, int paramInt1, int paramInt2) { this(paramLong, null, paramString, paramDouble, paramInt1, paramInt2); }
  
  private a(long paramLong, String paramString1, String paramString2, double paramDouble, int paramInt1, int paramInt2) {
    this.cZn = paramLong;
    this.cZj = paramString1;
    ng(paramString2);
    aG(paramDouble);
    this.aTb = paramInt1;
    this.cZm = paramInt2;
    this.cZo = new ArrayList();
  }
  
  private a(String paramString1, String paramString2, double paramDouble, int paramInt) { this(paramString1, paramString2, paramDouble, 0, paramInt); }
  
  private a(String paramString1, String paramString2, double paramDouble, int paramInt1, int paramInt2) {
    this.cZj = paramString1;
    ng(paramString2);
    aG(paramDouble);
    this.aTb = paramInt1;
    this.cZm = paramInt2;
    this.cZo = new ArrayList();
  }
  
  public static void a(List<a> paramList, PrintContent.a parama, int[] paramArrayOfInt) { a(paramList, parama, paramArrayOfInt, new int[] { 0, 2 }, 0); }
  
  private static void a(List<a> paramList, PrintContent.a parama, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt) {
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
  
  public a a(String paramString1, String paramString2, double paramDouble, int paramInt) {
    a a1 = new a(paramString1, paramString2, paramDouble, paramInt);
    this.cZo.add(a1);
    return a1;
  }
  
  public void aG(double paramDouble) {
    this.cZk = paramDouble;
    this.cZl = n.d(Double.valueOf(paramDouble));
  }
  
  public long amm() { return this.cZn; }
  
  public HashMap<String, Double> amn() { return (this.cZs == null || this.cZs.size() == 0) ? null : this.cZs; }
  
  public boolean amo() { return this.cZp; }
  
  public void amp() { // Byte code:
    //   0: aload_0
    //   1: getfield cZo : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: istore_1
    //   8: iconst_0
    //   9: istore_3
    //   10: iload_1
    //   11: iconst_1
    //   12: if_icmpge -> 51
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: getfield cZo : Ljava/util/ArrayList;
    //   21: invokevirtual size : ()I
    //   24: iconst_1
    //   25: if_icmpne -> 53
    //   28: iload_3
    //   29: istore_2
    //   30: aload_0
    //   31: getfield cZo : Ljava/util/ArrayList;
    //   34: iconst_0
    //   35: invokevirtual get : (I)Ljava/lang/Object;
    //   38: checkcast com/laiqian/report/models/a
    //   41: invokevirtual amq : ()Ljava/util/ArrayList;
    //   44: invokevirtual size : ()I
    //   47: iconst_1
    //   48: if_icmple -> 53
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: iload_2
    //   55: putfield cZp : Z
    //   58: return }
  
  public ArrayList<a> amq() { return this.cZo; }
  
  public void c(String paramString, double paramDouble) {
    double d;
    if (this.cZs.containsKey(paramString)) {
      d = ((Double)this.cZs.get(paramString)).doubleValue();
    } else {
      d = 0.0D;
    } 
    this.cZs.put(paramString, Double.valueOf(d + paramDouble));
  }
  
  public void ng(String paramString) { this.Yx = paramString; }
  
  public static class a {
    @Nullable
    public Double aEK;
    
    public String aRB;
    
    public String aRD;
    
    public String cZA;
    
    public double[] cZB;
    
    public ArrayList<a> cZC;
    
    private List<Pair<String, Double>> cZD;
    
    private List<Pair<String, Double>> cZE;
    
    private double[] cZF;
    
    public ArrayList<a> cZt;
    
    public ArrayList<a> cZu;
    
    public boolean cZv;
    
    public long cZw;
    
    public long cZx;
    
    public long cZy;
    
    public double cZz;
    
    public String userName;
    
    public a() {
      av av = CrashApplication.getLaiqianPreferenceManager();
      b(n.parseLong(av.atm()), av.atP(), System.currentTimeMillis(), av.atO());
    }
    
    public a(long param1Long1, long param1Long2, long param1Long3, String param1String) { b(param1Long1, param1Long2, param1Long3, param1String); }
    
    private void b(long param1Long1, long param1Long2, long param1Long3, String param1String) {
      this.cZw = param1Long1;
      bh bh = new bh(CrashApplication.zv());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1Long1);
      stringBuilder.append("");
      this.userName = bh.iE(stringBuilder.toString());
      bh.close();
      this.cZx = param1Long2;
      this.cZy = param1Long3;
      if (param1Long2 > param1Long3) {
        n.eP(2131629643);
        return;
      } 
      if (!b.h(this.cZx, this.cZy)) {
        n.eP(2131629643);
        return;
      } 
      Time time = new Time();
      time.set(this.cZx);
      this.aRB = time.format(CrashApplication.zv().getString(2131627400));
      time.set(this.cZy);
      this.aRD = time.format(CrashApplication.zv().getString(2131627400));
      this.cZz = n.aU(param1String);
      this.cZA = n.b(null, Double.valueOf(this.cZz), true);
      b b = new b(CrashApplication.zv());
      t t = (new t.a(this.cZx, this.cZy)).dh(param1Long1).jJ(0).jK(0).np("").anl();
      b.a(t);
      h h = new h(CrashApplication.zv());
      h.a(t);
      this.cZF = h.AW();
      this.cZt = b.gz(false);
      this.cZu = b.gz(true);
      this.cZv = b.amx();
      this.cZD = b.amz();
      this.cZE = b.amA();
      this.cZB = b.AW();
      this.cZC = b.amE();
      if (CrashApplication.zv().getResources().getBoolean(2131034118)) {
        this.aEK = Double.valueOf(b.amr());
      } else {
        this.aEK = null;
      } 
      b.close();
      h.close();
    }
    
    private String getString(@StringRes int param1Int) { return CrashApplication.zv().getString(param1Int); }
    
    public HashMap<String, Double> amn() {
      double d3;
      HashMap hashMap = new HashMap();
      if (this.cZu == null)
        return new HashMap(); 
      null = this.cZu.iterator();
      while (true) {
        boolean bool = null.hasNext();
        d3 = 0.0D;
        if (bool) {
          HashMap hashMap1 = ((a)null.next()).amn();
          if (hashMap1 == null)
            continue; 
          for (String str : hashMap1.keySet()) {
            double d;
            if (hashMap.containsKey(str)) {
              d = ((Double)hashMap.get(str)).doubleValue();
            } else {
              d = 0.0D;
            } 
            hashMap.put(str, Double.valueOf(d + ((Double)hashMap1.get(str)).doubleValue()));
          } 
          continue;
        } 
        break;
      } 
      String[] arrayOfString = new String[7];
      byte b2 = 0;
      arrayOfString[0] = "fSaleCashAmount";
      arrayOfString[1] = "fSaleBankAmount";
      arrayOfString[2] = "fSaleMemberAmount";
      arrayOfString[3] = "fSpareField1";
      arrayOfString[4] = "fSpareField2";
      arrayOfString[5] = "fSpareField3";
      arrayOfString[6] = "fSpareField4";
      double d1 = 0.0D;
      byte b1;
      for (b1 = 0; b1 < arrayOfString.length; b1++) {
        if (hashMap.containsKey(arrayOfString[b1])) {
          d1 += ((Double)hashMap.get(arrayOfString[b1])).doubleValue();
        } else {
          hashMap.put(arrayOfString[b1], Double.valueOf(0.0D));
        } 
      } 
      hashMap.put("fSaleAmount", Double.valueOf(d1));
      arrayOfString = new String[3];
      arrayOfString[0] = "fSaleReturnCashAmount";
      arrayOfString[1] = "fSaleReturnBankAmount";
      arrayOfString[2] = "fSaleReturnMemberAmount";
      double d2 = 0.0D;
      for (b1 = b2; b1 < arrayOfString.length; b1++) {
        if (hashMap.containsKey(arrayOfString[b1])) {
          d2 += ((Double)hashMap.get(arrayOfString[b1])).doubleValue();
        } else {
          hashMap.put(arrayOfString[b1], Double.valueOf(0.0D));
        } 
      } 
      hashMap.put("fSaleReturnAmount", Double.valueOf(d2));
      if (hashMap.containsKey("fBPartnerChargeReceived")) {
        d3 = ((Double)hashMap.get("fBPartnerChargeReceived")).doubleValue();
        hashMap.put("fBPartnerChargeReceived", Double.valueOf(d3));
      } else {
        hashMap.put("fBPartnerChargeReceived", Double.valueOf(0.0D));
      } 
      hashMap.put("fImprest", Double.valueOf(this.cZz));
      hashMap.put("fTotalAmount", Double.valueOf(d3 + this.cZz + d1 - d2));
      return hashMap;
    }
    
    public double amr() { return (this.aEK == null) ? 0.0D : this.aEK.doubleValue(); }
    
    public boolean ams() {
      boolean[] arrayOfBoolean = l.bG(CrashApplication.zv());
      boolean bool2 = arrayOfBoolean[0];
      boolean bool1 = true;
      if (bool2) {
        if (!arrayOfBoolean[1])
          return true; 
        al al = new al(CrashApplication.zv());
        if (al.Vy()) {
          null = new StringBuilder();
          null.append(System.currentTimeMillis());
          null.append("");
          al.am("_id", null.toString());
          al.am("nShopID", al.VC());
          null = new StringBuilder();
          null.append(this.cZw);
          null.append("");
          al.am("nUserID", null.toString());
          al.am("sUserName", this.userName);
          null = new StringBuilder();
          null.append(this.cZx);
          null.append("");
          al.am("nShiftBeginTime", null.toString());
          null = new StringBuilder();
          null.append(this.cZy);
          null.append("");
          al.am("nShiftEndTime", null.toString());
          al.am("nWarehouseID", al.VC());
          al.am("nSpareField2", "0");
          HashMap hashMap = amn();
          for (String str : hashMap.keySet())
            al.am(str, n.b(null, hashMap.get(str), true, false)); 
          bool1 = al.UF();
        } 
        al.close();
        if (bool1) {
          av av = new av(RootApplication.zv());
          av.dA(System.currentTimeMillis());
          av.close();
          CrashApplication.getLaiqianPreferenceManager().qU("0");
          CrashApplication.getLaiqianPreferenceManager().dy(0L);
          cj cj = new cj(RootApplication.zv());
          if (cj.yN())
            amt(); 
          cj.close();
          if (a.AZ().Bb()) {
            q q = new q(CrashApplication.zv());
            q.amZ();
            q.close();
            return bool1;
          } 
        } else {
          n.o("交接班失败");
        } 
        return bool1;
      } 
      return true;
    }
    
    public void amt() {
      ArrayList arrayList = new ArrayList();
      try {
        bb.a a1 = new bb.a(this.cZx, this.cZy, this.cZw, this.userName, this.cZz, this.aEK, this.cZC, "", "", "");
        bb.d d = new bb.d(getString(2131629262), this.cZt, true);
        bb bb = new bb(a1, new bb.c(getString(2131629388), this.cZE, (new Double(this.cZB[1])).intValue(), (new Double(this.cZB[0])).intValue(), this.cZF[1]), d, new bb.b(getString(2131625737), this.cZD));
        bb.a((new o()).c(this.cZw, this.cZx, this.cZy));
        arrayList.addAll(j.cCx.a(bb, new String[] { "shift" }));
      } catch (Exception exception) {
        a.e(exception);
      } 
      try {
        RootApplication.zv().sendBroadcast(new Intent("android.intent.money_test.action"));
        runtime = Runtime.getRuntime();
        try {
          runtime.exec("echo 0 > /sys/devices/platform/att_test/test");
        } catch (IOException runtime) {
          a.e(runtime);
        } 
        arrayList.addAll(j.cCx.a(new Object(), new String[] { "cash_drawer" }));
      } catch (Exception exception) {
        a.e(exception);
      } 
      g.cGS.o(arrayList);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */