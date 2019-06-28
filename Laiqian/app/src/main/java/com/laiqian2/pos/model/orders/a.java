package com.laiqian.pos.model.orders;

import android.support.annotation.Keep;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.product.models.o;
import com.laiqian.product.models.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Keep
public class a {
  private ArrayList<Object> bJf = new ArrayList();
  
  private double bTm = 0.0D;
  
  public PendingFullOrderDetail.a bXb = new PendingFullOrderDetail.a();
  
  public ArrayList<PendingFullOrderDetail.d> cpg = new ArrayList();
  
  private double cyE = 0.0D;
  
  public PendingFullOrderDetail.a WV() { return this.bXb; }
  
  public double acP() { return hn(-1); }
  
  public a acQ() {
    a a1 = new a(this);
    Iterator iterator = this.cpg.iterator();
    double d1 = 0.0D;
    double d2 = 0.0D;
    double d3;
    for (d3 = 0.0D; iterator.hasNext(); d3 = d4) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
      double d7 = d.cpo * d.cpn;
      null = d.aTR.iterator();
      double d5 = 0.0D;
      double d4;
      for (d4 = 0.0D; null.hasNext(); d4 = d9) {
        double d9;
        double d8;
        o o = (o)null.next();
        if (o.alc() == 1) {
          d8 = d5 + o.ala();
          d9 = d4;
        } else {
          d8 = d5;
          d9 = d4;
          if (o.alc() == 0) {
            d9 = d4 + o.ala();
            d8 = d5;
          } 
        } 
        d5 = d8;
      } 
      d5 = d7 / (d5 / 100.0D + 1.0D);
      double d6 = d4 * d5 / 100.0D;
      d4 = d3 + d5;
      for (o o : d.aTR) {
        if (o.alc() == 0) {
          d3 = o.ala() * d4 / 100.0D;
        } else {
          d3 = 0.0D;
        } 
        double d8 = o.ala() * d5 / 100.0D;
        a1.a(o.getId(), o.akZ(), o.ala(), d8, d5, d3);
      } 
      d2 += d6;
      d1 += d7 + d6 - d5;
    } 
    a1.cyF = d1;
    a1.aTG = d2;
    a1.aTF = d3;
    return a1;
  }
  
  public double hn(int paramInt) {
    Iterator iterator = this.cpg.iterator();
    double d = 0.0D;
    while (iterator.hasNext()) {
      PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)iterator.next();
      if ((paramInt != 1 || d1.aTU != 1) && (this.bXb.bZF != 3 || (paramInt != 0 && paramInt != -1) || d1.aTU != 0) && d1.cpo > 0.0D) {
        double d2;
        if (d1.cpt != null) {
          d2 = d1.cpt.doubleValue();
        } else {
          d2 = d1.cpn;
        } 
        d += d2 * d1.cpo;
      } 
    } 
    return d;
  }
  
  public class a {
    public double aTF;
    
    public double aTG;
    
    public double cyF;
    
    public HashMap<Long, p> taxOfSettement;
    
    public a(a this$0) {}
    
    public void a(long param1Long, String param1String, double param1Double1, double param1Double2, double param1Double3, double param1Double4) {
      if (this.taxOfSettement == null)
        this.taxOfSettement = new HashMap(); 
      p p = (p)this.taxOfSettement.get(Long.valueOf(param1Long));
      if (p == null) {
        this.taxOfSettement.put(Long.valueOf(param1Long), new p(param1Long, param1String, param1Double1, param1Double2, param1Double3, param1Double4));
        return;
      } 
      p.a(param1Double2, param1Double3, param1Double4);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\model\orders\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */