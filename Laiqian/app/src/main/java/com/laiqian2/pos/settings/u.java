package com.laiqian.pos.settings;

import android.content.Context;
import android.text.TextUtils;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.models.an;
import com.laiqian.models.at;
import com.laiqian.models.h;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.receipt.model.a;
import java.util.Map;

public class u {
  v czL;
  
  an.c czM;
  
  h.e czN;
  
  h.a czO;
  
  h.c czP;
  
  int czQ;
  
  Context mContext;
  
  public u(Context paramContext) { this.mContext = paramContext; }
  
  private void G(String paramString1, String paramString2, String paramString3) {
    this.czN = (h.e)h.aM(this.mContext).UJ().UM().get(paramString1);
    if (this.czN != null)
      this.czO = (h.a)this.czN.UO().get(paramString2); 
    if (this.czO != null)
      this.czP = (h.c)this.czO.UK().get(paramString3); 
  }
  
  private void adh() {
    this.czM.bSu = this.czN.getName();
    this.czM.bSv = this.czO.getName();
    this.czM.bSw = this.czP.getName();
    this.czL.d(this.czN);
    this.czL.d(this.czO);
    this.czL.b(this.czP);
  }
  
  private boolean kE(String paramString) {
    a a1 = a.bo(this.mContext);
    ReceiptPrintSettings receiptPrintSettings = a1.aiL();
    if (TextUtils.isEmpty(receiptPrintSettings.getTitle())) {
      receiptPrintSettings.setTitle(paramString);
      a1.a(receiptPrintSettings);
      return true;
    } 
    return false;
  }
  
  public void a(v paramv) {
    this.czL = paramv;
    this.czM = (new an(this.mContext)).Vu();
    if (this.czM == null) {
      this.czM = new an.c();
      this.czM.bSo = null;
      this.czM.aVs = "";
      this.czM.bSp = 1;
      this.czM.bSq = "160001";
      this.czM.aWV = "";
      this.czM.bSu = null;
      this.czM.bSv = null;
      this.czM.bSw = null;
      if (a.zR().Ad()) {
        this.czM.aWV = "oversea";
        this.czM.bSu = "oversea";
        this.czM.bSv = "oversea";
        this.czM.bSw = "oversea";
      } 
      this.czQ = 1;
    } else {
      at at = new at(this.mContext);
      boolean bool = at.em(false);
      at.close();
      if (bool) {
        this.czQ = 2;
      } else {
        this.czQ = 1;
      } 
    } 
    if (this.czM.bSp == 0)
      this.czM.bSp = 1; 
    if (this.czM.bSq.equals("0")) {
      if (!this.mContext.getResources().getBoolean(2131034123)) {
        this.czM.bSq = "160007";
      } else {
        this.czM.bSq = "160001";
      } 
    } else if (this.czM.bSq.equals("160005")) {
      this.czM.bSq = "160006";
    } 
    G(this.czM.bSu, this.czM.bSv, this.czM.bSw);
    paramv.dK(this.czM.aVs);
    paramv.hr(this.czM.bSp);
    paramv.kD(this.czM.bSq);
    paramv.d(this.czN);
    paramv.d(this.czO);
    paramv.b(this.czP);
    paramv.jR(this.czM.aWV);
    paramv.hs(this.czQ);
  }
  
  public h.e adi() { return this.czN; }
  
  public h.a adj() { return this.czO; }
  
  public h.c adk() { return this.czP; }
  
  public int adl() { return this.czM.bSp; }
  
  public String adm() { return this.czM.bSq; }
  
  public int adn() { return this.czQ; }
  
  public void b(h.c paramc) {
    this.czP = paramc;
    adh();
  }
  
  public void d(h.a parama) {
    this.czO = parama;
    this.czP = (h.c)((Map.Entry)this.czO.UK().entrySet().iterator().next()).getValue();
    adh();
  }
  
  public void d(h.e parame) {
    this.czN = parame;
    this.czO = parame.UN();
    this.czP = (h.c)((Map.Entry)this.czO.UK().entrySet().iterator().next()).getValue();
    adh();
  }
  
  public void hr(int paramInt) {
    this.czM.bSp = paramInt;
    this.czL.hr(paramInt);
  }
  
  public void hs(int paramInt) {
    this.czQ = paramInt;
    this.czL.hs(paramInt);
  }
  
  public boolean jV(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      this.czM.aVs = paramString;
      return true;
    } 
    return false;
  }
  
  public boolean jW(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      this.czM.aWV = paramString;
      return true;
    } 
    return false;
  }
  
  public void kD(String paramString) {
    this.czM.bSq = paramString;
    this.czL.kD(paramString);
  }
  
  public boolean save() {
    boolean bool1;
    boolean bool3 = (new an(this.mContext)).b(this.czM);
    int i = this.czQ;
    boolean bool2 = false;
    if (i == 2) {
      bool2 = a.zR().Af() ^ true;
      bool1 = a.zR().Af();
    } else {
      bool1 = false;
    } 
    at at = new at(this.mContext);
    at.en(bool1);
    at.close();
    a.AZ().bJ(bool2);
    a.AZ().bK(bool2);
    if (bool3)
      kE(this.czM.aVs); 
    return bool3;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\setting\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */