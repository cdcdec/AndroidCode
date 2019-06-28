package com.laiqian.print.usage.tag;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.tag.a.a;
import com.laiqian.print.usage.tag.a.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class q {
  private g cDD;
  
  private a cNO;
  
  private a cNP;
  
  private c cNQ;
  
  public String[] cNR;
  
  public String[] cNS;
  
  private Context mContext;
  
  public q(Context paramContext, a parama) {
    this.mContext = paramContext;
    this.cNO = parama;
    this.cNP = a.bq(this.mContext);
    this.cDD = g.cGS;
    this.cNR = new String[] { this.mContext.getString(2131628814), this.mContext.getString(2131628813) };
    if (a.zR().Af()) {
      this.cNS = new String[] { this.mContext.getString(2131628707), this.mContext.getString(2131628804) };
      return;
    } 
    this.cNS = new String[] { this.mContext.getString(2131628707), this.mContext.getString(2131628804), this.mContext.getString(2131628309) };
  }
  
  private void aip() { this.cNO.f((PrintContent)this.cNP.b(this.cNQ).get(0)); }
  
  public boolean Az() {
    c c1 = this.cNP.aiS();
    return this.cNQ.equals(c1) ^ true;
  }
  
  public void Kq() { this.cNP.a(this.cNQ); }
  
  public void afh() {
    this.cNO.setSize(this.cNQ.getWidth(), this.cNQ.getHeight());
    this.cNO.mb(this.cNQ.aiW());
    this.cNO.aD(this.cNQ.aiX());
    this.cNO.f((PrintContent)this.cNP.b(this.cNQ).get(0));
    this.cNO.v(this.cNR[this.cNQ.aiV()], this.cNQ.aiV());
    this.cNO.w(this.cNS[this.cNQ.aja()], this.cNQ.aja());
    this.cNO.gf(this.cNQ.aiT());
    this.cNO.ge(this.cNQ.aiU());
  }
  
  public void ahz() {
    null = new Date(System.currentTimeMillis());
    ArrayList arrayList = new ArrayList();
    null = new HashMap();
    String str1 = this.mContext.getString(2131628158);
    String str2 = this.mContext.getString(2131628157);
    null.put("sProductName", str1);
    null.put("taste", str2);
    null.put("nProductQty", "1");
    null.put("fPrice", "20.05");
    null.put("fAmount", "100");
    null.put("fOriginalPrice", "20");
    null.put("tableNo", Integer.valueOf(123));
    arrayList.add(null);
    b b = new b();
    b.bkf = null;
    b.coJ = "8";
    b.cyP = (b.cyH = Double.valueOf(200.0D)).valueOf(200.0D);
    b.bJf.addAll(arrayList);
    j = new j(this.mContext);
    j.a(new r(this, this.mContext));
    try {
      List list = j.a(b, new String[] { "tag_not_specified" });
      g.cGS.o(list);
      return;
    } catch (Exception j) {
      a.e(j);
      return;
    } 
  }
  
  public boolean bs(int paramInt1, int paramInt2) {
    if (c.bt(paramInt1, paramInt2)) {
      this.cNQ.setSize(paramInt1, paramInt2);
      this.cNO.setSize(paramInt1, paramInt2);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean gg(boolean paramBoolean) {
    this.cNQ.aD(paramBoolean);
    aip();
    return true;
  }
  
  public boolean gh(boolean paramBoolean) {
    this.cNQ.ge(paramBoolean);
    aip();
    return true;
  }
  
  public boolean gi(boolean paramBoolean) {
    this.cNQ.gf(paramBoolean);
    aip();
    return true;
  }
  
  public void init() {
    this.cNQ = this.cNP.aiS();
    afh();
  }
  
  public boolean lS(String paramString) {
    if (c.lT(paramString)) {
      this.cNQ.mb(paramString);
      aip();
      return true;
    } 
    return false;
  }
  
  public void p(int paramInt, String paramString) {
    this.cNQ.ja(paramInt);
    this.cNO.v(paramString, paramInt);
    aip();
  }
  
  public void q(int paramInt, String paramString) {
    this.cNQ.jb(paramInt);
    this.cNO.w(paramString, paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\tag\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */