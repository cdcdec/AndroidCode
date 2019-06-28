package com.laiqian.print.usage.delivery;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.delivery.model.DeliveryPrintSettings;
import com.laiqian.print.usage.delivery.model.a;
import com.laiqian.print.usage.delivery.model.b;
import com.laiqian.print.usage.receipt.a;
import java.util.List;

public class w {
  private g cDD;
  
  private c cDE;
  
  private a cMv;
  
  private b cMw;
  
  private DeliveryPrintSettings cMx;
  
  private Context mContext;
  
  public w(Context paramContext, a parama) {
    this.mContext = paramContext;
    this.cMv = parama;
    this.cMw = b.bl(this.mContext);
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  private void aip() { this.cMv.a((PrintContent)a.bk(this.mContext).b(this.cMx).get(0), this.cMx.getWidth()); }
  
  public boolean Az() {
    DeliveryPrintSettings deliveryPrintSettings = this.cMw.aiz();
    return this.cMx.equals(deliveryPrintSettings) ^ true;
  }
  
  public void Kq() { this.cMw.a(this.cMx); }
  
  public void afh() {
    this.cMv.setWidth(this.cMx.getWidth());
    this.cMv.setCopies(this.cMx.getCopies());
    this.cMv.lQ(this.cMx.getTitle());
    this.cMv.setLogo(this.cMx.aiu());
    this.cMv.iA(this.cMx.aiw());
    this.cMv.lR(this.cMx.aiq());
    this.cMv.ix(this.cMx.air());
    this.cMv.iy(this.cMx.ait());
    this.cMv.iz(this.cMx.ais());
    this.cMv.a((PrintContent)a.bk(this.mContext).b(this.cMx).get(0), this.cMx.getWidth());
    this.cMv.cX(this.cMx.aiy());
  }
  
  public void ahz() {
    j = new j(this.mContext);
    j.a(new x(this, this.mContext));
    try {
      List list = j.a(b.cyT, new String[] { "delivery_not_specified" });
      g.cGS.o(list);
      return;
    } catch (Exception j) {
      a.e(j);
      return;
    } 
  }
  
  public boolean iB(int paramInt) {
    if (DeliveryPrintSettings.iK(paramInt)) {
      this.cMx.iO(paramInt);
      this.cMv.iy(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iC(int paramInt) {
    if (DeliveryPrintSettings.iK(paramInt)) {
      this.cMx.iN(paramInt);
      this.cMv.iz(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iD(int paramInt) {
    if (DeliveryPrintSettings.iL(paramInt)) {
      this.cMx.iM(paramInt);
      this.cMv.ix(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iE(int paramInt) {
    if (DeliveryPrintSettings.iI(paramInt)) {
      this.cMx.setWidth(paramInt);
      this.cMv.setWidth(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iF(int paramInt) {
    if (DeliveryPrintSettings.iJ(paramInt)) {
      this.cMx.setCopies(paramInt);
      if (paramInt <= 1)
        this.cMx.cX(0); 
      this.cMv.setCopies(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iG(int paramInt) {
    this.cMx.cX(paramInt);
    this.cMv.cX(paramInt);
    aip();
    return true;
  }
  
  public void init() {
    this.cMx = this.cMw.aiz();
    afh();
  }
  
  public boolean lS(String paramString) {
    if (DeliveryPrintSettings.lT(paramString)) {
      this.cMx.lU(paramString);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean n(int paramInt, String paramString) {
    this.cMx.iP(paramInt);
    this.cMx.lV(paramString);
    this.cMv.setLogo(paramInt);
    aip();
    return true;
  }
  
  public boolean o(int paramInt, String paramString) {
    this.cMx.iQ(paramInt);
    this.cMx.lW(paramString);
    this.cMv.iA(paramInt);
    aip();
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\delivery\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */