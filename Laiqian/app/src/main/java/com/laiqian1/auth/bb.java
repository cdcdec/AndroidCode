package com.laiqian.auth;

import android.util.Pair;
import com.laiqian.basic.RootApplication;
import com.laiqian.report.models.a;
import java.util.Iterator;
import java.util.List;

public class bb {
  private final a aED;
  
  private final c aEE;
  
  private final d aEF;
  
  private final b aEG;
  
  private double[] aEH;
  
  public bb(a parama, c paramc, d paramd, b paramb) {
    this.aED = parama;
    this.aEE = paramc;
    this.aEF = paramd;
    this.aEG = paramb;
  }
  
  public void a(double[] paramArrayOfDouble) { this.aEH = paramArrayOfDouble; }
  
  public double[] yi() { return this.aEH; }
  
  public a yj() { return this.aED; }
  
  public c yk() { return this.aEE; }
  
  public d yl() { return this.aEF; }
  
  public b ym() { return this.aEG; }
  
  public static class a {
    public final long aEI;
    
    public final double aEJ;
    
    public final Double aEK;
    
    public final List<a> aEL;
    
    private final String aEM;
    
    private final String aEN;
    
    private final String aEO;
    
    private boolean aEP;
    
    public final long aet;
    
    public final long end;
    
    public final String userName;
    
    public a(long param1Long1, long param1Long2, long param1Long3, String param1String1, double param1Double, Double param1Double1, List<a> param1List, String param1String2, String param1String3, String param1String4) {
      this.aet = param1Long1;
      this.end = param1Long2;
      this.aEI = param1Long3;
      this.userName = param1String1;
      this.aEJ = param1Double;
      this.aEK = param1Double1;
      this.aEL = param1List;
      this.aEM = param1String2;
      this.aEN = param1String3;
      this.aEO = param1String4;
    }
    
    public String yn() {
      int i = Integer.parseInt(this.aEM);
      return (i == 1) ? RootApplication.zv().getString(2131630376) : ((i == 2) ? RootApplication.zv().getString(2131625898) : RootApplication.zv().getString(2131628072));
    }
    
    public String yo() {
      int i = Integer.parseInt(this.aEN);
      if (i == 1) {
        this.aEP = false;
        return RootApplication.zv().getString(2131624863);
      } 
      if (i == 2) {
        this.aEP = true;
        return RootApplication.zv().getString(2131624776);
      } 
      this.aEP = false;
      return RootApplication.zv().getString(2131628072);
    }
    
    public boolean yp() { return this.aEP; }
    
    public String yq() {
      int i = Integer.parseInt(this.aEO);
      if (i != 15) {
        switch (i) {
          default:
            switch (i) {
              default:
                return RootApplication.zv().getString(2131628072);
              case 8:
                return RootApplication.zv().getString(2131625100);
              case 7:
                return RootApplication.zv().getString(2131626882);
              case 6:
                return RootApplication.zv().getString(2131628780);
              case 5:
                break;
            } 
            return RootApplication.zv().getString(2131628360);
          case 2:
          case 3:
            return RootApplication.zv().getString(2131627171);
          case 1:
            return RootApplication.zv().getString(2131629985);
          case 0:
            break;
        } 
        return RootApplication.zv().getString(2131628058);
      } 
      return RootApplication.zv().getString(2131626780);
    }
  }
  
  public static class b {
    private final List<Pair<String, Double>> aEQ;
    
    private final String title;
    
    public b(String param1String, List<Pair<String, Double>> param1List) {
      this.title = param1String;
      this.aEQ = param1List;
    }
    
    public String getTitle() { return this.title; }
    
    public List<Pair<String, Double>> yr() { return this.aEQ; }
  }
  
  public static class c {
    private final List<Pair<String, Double>> aEQ;
    
    private final int aER;
    
    private final int aES;
    
    private final double aET;
    
    private final String title;
    
    public c(String param1String, List<Pair<String, Double>> param1List, int param1Int1, int param1Int2, double param1Double) {
      this.title = param1String;
      this.aEQ = param1List;
      this.aER = param1Int1;
      this.aES = param1Int2;
      this.aET = param1Double;
    }
    
    public String getTitle() { return this.title; }
    
    public List<Pair<String, Double>> yr() { return this.aEQ; }
    
    public int ys() { return this.aER; }
    
    public int yt() { return this.aES; }
    
    public double yu() {
      Iterator iterator = this.aEQ.iterator();
      double d;
      for (d = 0.0D; iterator.hasNext(); d += ((Double)((Pair)iterator.next()).second).doubleValue());
      return d;
    }
    
    public double yv() { return this.aET; }
  }
  
  public static class d {
    private final List<a> aEU;
    
    private final boolean aEV;
    
    private final String title;
    
    public d(String param1String, List<a> param1List, boolean param1Boolean) {
      this.title = param1String;
      this.aEV = param1Boolean;
      if (param1Boolean) {
        Iterator iterator = param1List.iterator();
        while (iterator.hasNext()) {
          if (((a)iterator.next()).cZn == 10006L)
            iterator.remove(); 
        } 
      } 
      this.aEU = param1List;
    }
    
    public String getTitle() { return this.title; }
    
    public List<a> yw() { return this.aEU; }
    
    public Double yx() {
      Double double = Double.valueOf(0.0D);
      for (a a : this.aEU)
        double = Double.valueOf(double.doubleValue() + a.cZk); 
      return double;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */