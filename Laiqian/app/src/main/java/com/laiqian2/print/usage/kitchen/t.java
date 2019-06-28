package com.laiqian.print.usage.kitchen;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.kitchen.a.a;
import com.laiqian.print.usage.kitchen.a.c;
import java.util.List;

public class t {
  private g cDD;
  
  private c cDE;
  
  private a cMO;
  
  private a cMP;
  
  private c czS;
  
  private Context mContext;
  
  public t(Context paramContext, a parama) {
    this.mContext = paramContext;
    this.cMO = parama;
    this.cMP = a.bm(this.mContext);
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  private void aip() { this.cMO.e(this.cMP.b(this.czS), this.czS.getWidth()); }
  
  public boolean Az() {
    c c1 = this.cMP.aiC();
    return this.czS.equals(c1) ^ true;
  }
  
  public void Kq() { this.cMP.a(this.czS); }
  
  public void afh() {
    this.cMO.setWidth(this.czS.getWidth());
    this.cMO.setCopies(this.czS.getCopies());
    this.cMO.iR(this.czS.air());
    this.cMO.iz(this.czS.aiG());
    this.cMO.fY(this.czS.aiH());
    this.cMO.fZ(this.czS.aiD());
    this.cMO.iS(this.czS.getOrder());
    this.cMO.e(this.cMP.b(this.czS), this.czS.getWidth());
  }
  
  public void ahz() {
    j = new j(this.mContext);
    j.a(new u(this, this.mContext));
    try {
      List list = j.a(b.cyT, new String[] { "kitchen_port", "kitchen_total" });
      g.cGS.o(list);
      return;
    } catch (Exception j) {
      a.e(j);
      return;
    } 
  }
  
  public boolean ga(boolean paramBoolean) {
    this.czS.fY(paramBoolean);
    this.cMO.fY(paramBoolean);
    aip();
    return true;
  }
  
  public boolean gb(boolean paramBoolean) {
    this.czS.fZ(paramBoolean);
    this.cMO.fZ(paramBoolean);
    aip();
    return true;
  }
  
  public boolean iC(int paramInt) {
    if (c.iK(paramInt)) {
      this.czS.iz(paramInt);
      this.cMO.iz(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iE(int paramInt) {
    if (c.iI(paramInt)) {
      this.czS.setWidth(paramInt);
      this.cMO.setWidth(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iF(int paramInt) {
    if (c.iJ(paramInt)) {
      this.czS.setCopies(paramInt);
      this.cMO.setCopies(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iT(int paramInt) {
    if (c.iL(paramInt)) {
      this.czS.iM(paramInt);
      this.cMO.iR(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iU(int paramInt) {
    if (c.iV(paramInt)) {
      this.czS.setOrder(paramInt);
      this.cMO.iS(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public void init() {
    this.czS = this.cMP.aiC();
    afh();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\kitchen\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */