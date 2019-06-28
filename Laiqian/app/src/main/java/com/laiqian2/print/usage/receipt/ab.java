package com.laiqian.print.usage.receipt;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.models.at;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.receipt.model.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ab {
  private g cDD;
  
  private c cDE;
  
  private a cMv;
  
  private a cNm;
  
  private ReceiptPrintSettings cNn;
  
  public String[] cNo = null;
  
  public boolean cNp = false;
  
  private Context mContext;
  
  public ab(Context paramContext, a parama) {
    this.mContext = paramContext;
    this.cMv = parama;
    this.cNm = a.bo(this.mContext);
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
    this.cNo = new String[] { this.mContext.getString(2131629502), this.mContext.getString(2131629532) };
    aiJ();
  }
  
  private void aiJ() {
    at at = new at(this.mContext);
    this.cNp = at.Wt();
    at.close();
  }
  
  private void aip() {
    PrintContent printContent = this.cNm.a(this.cNn, aiK());
    if (printContent.size() > 0) {
      PrintContent printContent1 = (PrintContent)printContent.get(0);
    } else {
      printContent = new PrintContent();
    } 
    this.cMv.a(printContent, this.cNn.getWidth());
  }
  
  public boolean Az() {
    ReceiptPrintSettings receiptPrintSettings = this.cNm.aiL();
    return this.cNn.equals(receiptPrintSettings) ^ true;
  }
  
  public void Kq() { this.cNm.a(this.cNn); }
  
  public void afh() {
    this.cMv.setWidth(this.cNn.getWidth());
    this.cMv.setCopies(this.cNn.getCopies());
    this.cMv.lQ(this.cNn.getTitle());
    this.cMv.setLogo(this.cNn.aiu());
    this.cMv.iA(this.cNn.aiw());
    this.cMv.lR(this.cNn.aiq());
    this.cMv.ix(this.cNn.air());
    this.cMv.iy(this.cNn.ait());
    this.cMv.iz(this.cNn.ais());
    this.cMv.fX(this.cNn.aiN());
    PrintContent printContent = this.cNm.a(this.cNn, aiK());
    if (printContent.size() > 0) {
      PrintContent printContent1 = (PrintContent)printContent.get(0);
    } else {
      printContent = new PrintContent();
    } 
    this.cMv.a(printContent, this.cNn.getWidth());
    this.cMv.cX(this.cNn.aiy());
    this.cMv.m(this.cNn.aiM(), this.cNo[this.cNn.aiM()]);
  }
  
  public void ahz() {
    j = new j(this.mContext);
    j.a(new ac(this, this.mContext));
    try {
      List list = j.a(b.cyT, new String[] { "settle_receipt" });
      g.cGS.o(list);
      return;
    } catch (Exception j) {
      a.e(j);
      return;
    } 
  }
  
  public b aiK() {
    b b = new b();
    Date date = new Date(System.currentTimeMillis());
    ArrayList arrayList = new ArrayList();
    HashMap hashMap1 = new HashMap();
    String str2 = RootApplication.zv().getString(2131628158);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str2);
    stringBuilder1.append("1");
    hashMap1.put("sProductName", stringBuilder1.toString());
    String str1 = "5";
    int i = this.cNn.aiM();
    int j = this.cNn.cNJ;
    double d1 = 60.0D;
    double d2 = 200.0D;
    if (i == j) {
      str1 = "1.5";
      d2 = 60.0D;
    } else {
      d1 = 200.0D;
    } 
    hashMap1.put("nProductQty", str1);
    hashMap1.put("fPrice", "20.05");
    hashMap1.put("fAmount", "100");
    hashMap1.put("fOriginalPrice", "20");
    HashMap hashMap2 = new HashMap();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append("2");
    hashMap2.put("sProductName", stringBuilder2.toString());
    hashMap2.put("nProductQty", str1);
    hashMap2.put("fPrice", "20.05");
    hashMap2.put("fAmount", "100");
    hashMap2.put("fOriginalPrice", "20");
    arrayList.add(hashMap1);
    arrayList.add(hashMap2);
    b.bkf = date;
    b.coJ = "8";
    b.cyJ = "10086";
    b.cyO = (b.cyP = (b.cyI = (b.cyH = Double.valueOf(d1)).valueOf(0.0D)).valueOf(d2)).valueOf(d2);
    b.bJf.addAll(arrayList);
    b.ceV = "137001";
    return b;
  }
  
  public boolean gc(boolean paramBoolean) {
    this.cNn.fX(paramBoolean);
    this.cMv.fX(paramBoolean);
    aip();
    return true;
  }
  
  public boolean iB(int paramInt) {
    if (ReceiptPrintSettings.iK(paramInt)) {
      this.cNn.iO(paramInt);
      this.cMv.iy(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iC(int paramInt) {
    if (ReceiptPrintSettings.iK(paramInt)) {
      this.cNn.iN(paramInt);
      this.cMv.iz(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iD(int paramInt) {
    if (ReceiptPrintSettings.iL(paramInt)) {
      this.cNn.iM(paramInt);
      this.cMv.ix(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iE(int paramInt) {
    if (ReceiptPrintSettings.iI(paramInt)) {
      this.cNn.setWidth(paramInt);
      this.cMv.setWidth(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iF(int paramInt) {
    if (ReceiptPrintSettings.iJ(paramInt)) {
      this.cNn.setCopies(paramInt);
      if (paramInt <= 1)
        this.cNn.cX(0); 
      this.cMv.setCopies(paramInt);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean iG(int paramInt) {
    this.cNn.cX(paramInt);
    this.cMv.cX(paramInt);
    aip();
    return true;
  }
  
  public void iY(int paramInt) {
    this.cNn.iY(paramInt);
    this.cMv.m(paramInt, this.cNo[paramInt]);
    aip();
  }
  
  public void init() {
    this.cNn = this.cNm.aiL();
    afh();
  }
  
  public boolean lS(String paramString) {
    if (ReceiptPrintSettings.lT(paramString)) {
      this.cNn.lU(paramString);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean lY(String paramString) {
    if (ReceiptPrintSettings.ma(paramString)) {
      this.cNn.setTitle(paramString);
      aip();
      return true;
    } 
    return false;
  }
  
  public boolean n(int paramInt, String paramString) {
    this.cNn.iP(paramInt);
    this.cNn.lV(paramString);
    this.cMv.setLogo(paramInt);
    aip();
    return true;
  }
  
  public boolean o(int paramInt, String paramString) {
    this.cNn.iQ(paramInt);
    this.cNn.lW(paramString);
    this.cMv.iA(paramInt);
    aip();
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\receipt\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */