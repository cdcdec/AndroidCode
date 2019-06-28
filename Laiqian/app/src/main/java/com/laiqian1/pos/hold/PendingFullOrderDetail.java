package com.laiqian.pos.hold;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aa;
import com.laiqian.models.ao;
import com.laiqian.models.t;
import com.laiqian.pos.bm;
import com.laiqian.pos.model.orders.a;
import com.laiqian.product.a.a;
import com.laiqian.product.a.d;
import com.laiqian.product.models.c;
import com.laiqian.product.models.o;
import com.laiqian.util.av;
import com.laiqian.util.k;
import com.laiqian.util.n;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class PendingFullOrderDetail implements Serializable {
  public static PendingFullOrderDetail coB = new PendingFullOrderDetail();
  
  private static Comparator<d> coC = new ad();
  
  private static Comparator<d> coD = new ae();
  
  public a bXb = new a();
  
  public c coA;
  
  @NonNull
  public ArrayList<d> coy = new ArrayList();
  
  @NonNull
  public ArrayList<c> coz = new ArrayList();
  
  public PendingFullOrderDetail() {}
  
  public PendingFullOrderDetail(PendingFullOrderDetail paramPendingFullOrderDetail) {
    this.bXb = new a(paramPendingFullOrderDetail.bXb);
    this.coy.addAll(paramPendingFullOrderDetail.coy);
    this.coz.addAll(paramPendingFullOrderDetail.coz);
  }
  
  public static PendingFullOrderDetail a(ArrayList<aa> paramArrayList, int paramInt, PendingFullOrderDetail paramPendingFullOrderDetail) {
    PendingFullOrderDetail pendingFullOrderDetail = paramPendingFullOrderDetail;
    if (paramPendingFullOrderDetail == null)
      pendingFullOrderDetail = new PendingFullOrderDetail(); 
    pendingFullOrderDetail.bXb.coE = new Date(System.currentTimeMillis());
    av av = new av(RootApplication.zv());
    null = av.Tx();
    String str = av.atm();
    av.close();
    pendingFullOrderDetail.bXb.aEI = Long.valueOf(str).longValue();
    pendingFullOrderDetail.bXb.bJc = Long.valueOf(null).longValue();
    pendingFullOrderDetail.bXb.coH = 100001L;
    pendingFullOrderDetail.bXb.coI = 300002L;
    if (paramInt >= 0)
      pendingFullOrderDetail.bXb.bZF = paramInt; 
    for (aa aa : paramArrayList) {
      d d1 = new d();
      d1.id = aa.aSW;
      d1.bbX = aa.Ly();
      d1.cpl = Long.valueOf(aa.Gr());
      d1.aTO = aa.Gs();
      d1.aTP = aa.Gu();
      d1.cpo = aa.Gw();
      d1.aTZ = aa.Gp();
      String str2 = aa.name;
      ArrayList arrayList = aa.GL();
      String str1 = str2;
      if (arrayList.size() != 0) {
        null = new StringBuilder();
        null.append(str2);
        null.append("[");
        null.append(c.a(null, arrayList).toString());
        null.append("]");
        str1 = null.toString();
      } 
      a a1 = (new d()).a(new d.a()).akm();
      double d = c.a(aa.Gz(), arrayList, a1);
      d1.cpn = aa.Gz();
      d1.cpn += d;
      d1.name = str1;
      d1.cpm = aa.cpm;
      d1.cpq = aa.aJx;
      d1.cpu = aa.akK();
      d1.cpu += d;
      d1.cpx = aa.akM();
      d1.cpz = aa.GS();
      if (aa.Gw() > 0.0D) {
        paramInt = 1;
      } else {
        paramInt = 2;
      } 
      d1.aTU = paramInt;
      if (aa.GP() != null) {
        d1.aTR = new ArrayList(aa.GP());
        d1.aTG = aa.GI();
        d1.aTF = aa.GH();
      } 
      if (d1.cpx == 2L && aa.Go() != null) {
        d1.cpj = aa.Go();
        d1.cpk = aa.GT();
      } 
      pendingFullOrderDetail.coy.add(d1);
    } 
    return pendingFullOrderDetail;
  }
  
  public static boolean a(d paramd1, d paramd2) { return (paramd1 != null) ? ((paramd2 == null) ? false : ((paramd1.name.equals(paramd2.name) && bm.a(paramd1.cpn, paramd2.cpn, 6)))) : false; }
  
  public static ArrayList<b> ad(ArrayList<d> paramArrayList) {
    b b;
    StringBuilder stringBuilder;
    int i;
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramArrayList.iterator();
    int j = 0;
    while (true) {
      b = null;
      stringBuilder = b;
      i = 0;
      while (iterator.hasNext()) {
        d d = (d)iterator.next();
        if (d.cpx == 2L) {
          if (b != null) {
            d d1 = new b(b, stringBuilder, i);
            b b1 = (b)k.a(arrayList, d1, b.awh);
            if (b1 != null) {
              for (i = 0; i < b.a(b1).size(); i++) {
                d1 = (d)b.a(b1).get(i);
                d d2 = (d)stringBuilder.get(i);
                d1.cpo += d2.cpo;
                d1.aTG += d2.aTG;
                d1.aTF += d2.aTF;
              } 
            } else {
              arrayList.add(d1);
            } 
          } 
          b = d.name;
          i = d.aTU;
          stringBuilder = new ArrayList();
          stringBuilder.add(new d(d));
          iterator.remove();
          continue;
        } 
        if (d.cpx == 3L) {
          if (stringBuilder != null) {
            stringBuilder.add(new d(d));
            iterator.remove();
            continue;
          } 
          stringBuilder = new StringBuilder();
          stringBuilder.append("没有套餐Header, 单据状态有误:");
          stringBuilder.append(paramArrayList);
          throw new NullPointerException(stringBuilder.toString());
        } 
        if (b != null) {
          d d1 = new b(b, stringBuilder, i);
          b = (b)k.a(arrayList, d1, b.awh);
          if (b != null) {
            for (i = 0; i < b.a(b).size(); i++) {
              d1 = (d)b.a(b).get(i);
              d d2 = (d)stringBuilder.get(i);
              d1.cpo += d2.cpo;
              d1.aTG += d2.aTG;
              d1.aTF += d2.aTF;
            } 
            continue;
          } 
          arrayList.add(d1);
        } 
      } 
      break;
    } 
    if (b != null) {
      d d;
      b = new b(b, stringBuilder, i);
      b b1 = (b)k.a(arrayList, b, b.awh);
      if (b1 != null) {
        for (i = j; i < b.a(b1).size(); i++) {
          d = (d)b.a(b1).get(i);
          d d1 = (d)stringBuilder.get(i);
          d.cpo += d1.cpo;
          d.aTG += d1.aTG;
          d.aTF += d1.aTF;
        } 
      } else {
        arrayList.add(d);
      } 
    } 
    return arrayList;
  }
  
  public static PendingFullOrderDetail d(ArrayList<aa> paramArrayList, int paramInt) { return a(paramArrayList, paramInt, null); }
  
  public static double m(Collection<d> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    double d;
    for (d = 0.0D; iterator.hasNext(); d += d2 - d2 / (d1 / 100.0D + 1.0D)) {
      null = (d)iterator.next();
      double d2 = null.cpo * null.cpn;
      Iterator iterator1 = null.aTR.iterator();
      double d1 = 0.0D;
      while (iterator1.hasNext()) {
        o o = (o)iterator1.next();
        if (o.alc() == 1) {
          d1 += o.ala();
          continue;
        } 
        if (o.alc() == 0)
          o.ala(); 
      } 
    } 
    return d;
  }
  
  public a aaE() { return hc(0); }
  
  public ArrayList<d> aaF() {
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(this.coy);
    Iterator iterator = this.coz.iterator();
    while (iterator.hasNext())
      arrayList.addAll(((c)iterator.next()).cpg); 
    return arrayList;
  }
  
  public ArrayList<t.a> aaG() {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = (aaE()).cpg.iterator();
    byte b = 1;
    while (iterator.hasNext()) {
      d d = (d)iterator.next();
      t.a a1 = new t.a();
      this.bXb.a(a1);
      if (d.cpx != 3L) {
        d.cs(b);
        b++;
      } else {
        d.cs((b - 1));
      } 
      d.a(a1);
      a1.a(t.bOe).setValue("Y");
      arrayList.add(a1);
    } 
    return arrayList;
  }
  
  public Comparator<d> ha(int paramInt) {
    switch (paramInt) {
      default:
        return coC;
      case 1:
        return coD;
      case 0:
        break;
    } 
    return coC;
  }
  
  public Comparator<b> hb(int paramInt) { return (paramInt != 1) ? b.awh : b.cph; }
  
  public a hc(int paramInt) {
    double d;
    a a1 = new a();
    a1.bXb = new a(this.bXb);
    null = new ArrayList(this.coy);
    null = ad(null);
    Iterator iterator2 = null.iterator();
    while (true) {
      boolean bool = iterator2.hasNext();
      d = 0.0D;
      if (bool) {
        d d1 = (d)iterator2.next();
        d d2 = (d)k.a(a1.cpg, d1, ha(paramInt));
        if (d2 != null) {
          d2.cpo += d1.cpo;
          d2.aTG += d1.aTG;
          d2.aTF += d1.aTF;
          if (bm.a(d2.cpo, 0.0D, 6))
            a1.cpg.remove(d2); 
          continue;
        } 
        a1.cpg.add(new d(d1));
        continue;
      } 
      break;
    } 
    iterator2 = this.coz.iterator();
    while (iterator2.hasNext()) {
      null = new ArrayList(((c)iterator2.next()).cpg);
      null = ad(null);
      for (d d1 : null) {
        d d2 = (d)k.a(a1.cpg, d1, ha(paramInt));
        if (d2 != null) {
          d2.cpo += d1.cpo;
          d2.aTG += d1.aTG;
          d2.aTF += d1.aTF;
          if (Double.compare(d2.cpo, d) == 0)
            a1.cpg.remove(d2); 
          continue;
        } 
        a1.cpg.add(new d(d1));
      } 
      for (b b1 : null) {
        b b2 = (b)k.a(null, b1, hb(paramInt));
        if (b2 != null) {
          byte b;
          for (b = 0; b < b.a(b2).size(); b++) {
            d d1 = (d)b.a(b2).get(b);
            d d2 = (d)b.a(b1).get(b);
            if (!d1.name.equals(d2.name))
              throw new IllegalStateException("套餐商品不对应"); 
            d1.cpo += d2.cpo;
            d1.aTG += d2.aTG;
            d1.aTF += d1.aTF;
          } 
        } else {
          null.add(b1);
        } 
        d = 0.0D;
      } 
    } 
    Iterator iterator1 = null.iterator();
    while (iterator1.hasNext()) {
      b b;
      if (!n.bc(((d)(b = (b)iterator1.next()).a(b).get(0)).cpo))
        a1.cpg.addAll(b.a(b)); 
    } 
    return a1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OrderType {}
  
  public static class a implements Serializable {
    public long aEI;
    
    public int aTU;
    
    public long aVN;
    
    public int aVQ;
    
    public long aVS;
    
    public long aVU;
    
    public long bJc;
    
    public String bTe;
    
    public int bZF;
    
    public int bZM;
    
    public String bZO;
    
    public long bZP;
    
    public String bZc;
    
    public double bfj;
    
    public double bfk;
    
    public int btX;
    
    @Nullable
    public String ceV;
    
    public Double ceX;
    
    public Date coE;
    
    public Date coF;
    
    public long coG;
    
    public long coH;
    
    public long coI;
    
    @Nullable
    public String coJ;
    
    @Nullable
    public String coK = null;
    
    @Nullable
    public String coL;
    
    public int coM;
    
    @Nullable
    public String coN;
    
    public long coO;
    
    public String coP;
    
    public String coQ;
    
    public long coR;
    
    public String coS;
    
    public String coT;
    
    public String coU;
    
    public String coV;
    
    public String coW;
    
    public long coX;
    
    public String coY;
    
    public long coZ;
    
    public double cpa;
    
    public int cpb = -1;
    
    public Double cpc;
    
    public int cpd;
    
    public String cpe;
    
    public String cpf;
    
    public String headerText;
    
    @Nullable
    public String orderNo;
    
    public double pointsDeductionAmount;
    
    public a() {}
    
    public a(a param1a) {
      this.coE = param1a.coE;
      this.coF = param1a.coF;
      this.ceX = param1a.ceX;
      this.aEI = param1a.aEI;
      this.bJc = param1a.bJc;
      this.coG = param1a.coG;
      this.coH = param1a.coH;
      this.coI = param1a.coI;
      this.bZF = param1a.bZF;
      this.coO = param1a.coO;
      this.coJ = param1a.coJ;
      this.coK = param1a.coK;
      this.coL = param1a.coL;
      this.orderNo = param1a.orderNo;
      this.coP = param1a.coP;
      this.coQ = param1a.coQ;
      this.headerText = param1a.headerText;
      this.aVN = param1a.aVN;
      this.coR = param1a.coR;
      this.aVQ = param1a.aVQ;
      this.coN = param1a.coN;
      this.coS = param1a.coS;
      this.coT = param1a.coT;
      this.bZM = param1a.bZM;
      this.coU = param1a.coU;
      this.coV = param1a.coV;
      this.aVS = param1a.aVS;
      this.aVU = param1a.aVU;
      this.bfk = param1a.bfk;
      this.bfj = param1a.bfj;
      this.bZc = param1a.bZc;
      this.bTe = param1a.bTe;
      this.aTU = param1a.aTU;
      this.bZP = param1a.bZP;
      this.btX = param1a.btX;
      this.cpc = param1a.cpc;
      this.cpd = param1a.cpd;
      this.pointsDeductionAmount = param1a.pointsDeductionAmount;
      this.cpa = param1a.cpa;
      this.cpe = param1a.cpe;
      this.cpb = param1a.cpb;
      this.cpf = param1a.cpf;
      this.coM = param1a.coM;
      this.bZO = param1a.bZO;
    }
    
    public void a(t.a param1a) {
      if (this.coE != null)
        param1a.a(t.bNr).setValue(Long.valueOf(this.coE.getTime())); 
      if (this.coF != null)
        param1a.a(t.bNw).setValue(Long.valueOf(this.coF.getTime())); 
      param1a.a(t.bPg).setValue(this.ceX);
      param1a.a(t.bNq).setValue(Long.valueOf(this.aEI));
      param1a.a(t.bNj).setValue(Long.valueOf(this.bJc));
      param1a.a(t.bNy).setValue(Long.valueOf(this.coG));
      param1a.a(t.bPX).setValue(Long.valueOf(this.coH));
      param1a.a(t.bPY).setValue(Long.valueOf(this.coI));
      if (this.coJ != null) {
        Matcher matcher = Pattern.compile("\\d+").matcher(this.coJ);
        if (matcher.find()) {
          long l = Long.parseLong(matcher.group());
          param1a.a(t.bQc).setValue(Long.valueOf(l));
        } 
        param1a.a(t.bND).setValue(this.coJ);
      } 
      param1a.a(t.bNz).setValue(this.coK);
      param1a.a(t.bNp).setValue(this.coL);
      param1a.a(t.bPE).setValue(this.orderNo);
      param1a.a(t.bPV).setValue(Integer.valueOf(this.bZF));
      param1a.a(t.bPF).setValue(Long.valueOf(this.coO));
      param1a.a(t.bPG).setValue(this.coP);
      param1a.a(t.bQe).setValue(this.coQ);
      param1a.a(t.bQj).setValue(this.headerText);
      param1a.a(t.bNH).setValue(Long.valueOf(this.aVN));
      param1a.a(t.bNI).setValue(Long.valueOf(this.coR));
      ao.c c = param1a.a(t.bPH);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.aVQ);
      stringBuilder.append("");
      c.setValue(stringBuilder.toString());
      param1a.a(t.bNA).setValue(this.cpf);
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("firstPayType", this.aVS);
        jSONObject.put("firstPayValue", this.bfj);
        jSONObject.put("secondPayType", this.aVU);
        jSONObject.put("secondPayValue", this.bfk);
        jSONObject.put("pointsDeductionAmount", this.pointsDeductionAmount);
        PrintStream printStream = System.out;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("payValueJson.secondPayType:");
        stringBuilder1.append(this.aVU);
        printStream.println(stringBuilder1.toString());
        printStream = System.out;
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("payValueJson.secondPayValue:");
        stringBuilder1.append(this.bfk);
        printStream.println(stringBuilder1.toString());
        param1a.a(t.bNC).setValue(jSONObject.toString());
        return;
      } catch (JSONException param1a) {
        a.e(param1a);
        return;
      } 
    }
  }
  
  class PendingFullOrderDetail {}
  
  class PendingFullOrderDetail {}
  
  class PendingFullOrderDetail {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\hold\PendingFullOrderDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */