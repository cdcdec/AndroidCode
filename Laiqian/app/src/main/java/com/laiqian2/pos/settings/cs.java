package com.laiqian.pos.settings;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.laiqian.c.a;
import com.laiqian.models.an;
import com.laiqian.models.h;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import java.util.Map;

public class cs {
  r bFM;
  
  an.c cBw;
  
  df cBx;
  
  ab cuO = null;
  
  h.e czN;
  
  h.a czO;
  
  h.c czP;
  
  Handler handler;
  
  Context mContext;
  
  public cs(Context paramContext) { this.mContext = paramContext; }
  
  private void adh() {
    this.cBw.bSu = this.czN.getName();
    this.cBw.bSv = this.czO.getName();
    this.cBw.bSw = this.czP.getName();
    this.cBx.d(this.czN);
    this.cBx.d(this.czO);
    this.cBx.b(this.czP);
  }
  
  private void c(df paramdf) {
    if (this.cBw != null) {
      paramdf.dK(this.cBw.aVs);
      paramdf.hr(this.cBw.bSp);
      paramdf.kH(this.cBw.bSq);
      this.czN = (h.e)h.aM(this.mContext).UJ().UM().get(this.cBw.bSu);
      if (this.czN != null)
        this.czO = (h.a)this.czN.UO().get(this.cBw.bSv); 
      if (this.czO != null)
        this.czP = (h.c)this.czO.UK().get(this.cBw.bSw); 
      paramdf.d(this.czN);
      paramdf.d(this.czO);
      paramdf.b(this.czP);
      paramdf.jR(this.cBw.aWV);
      paramdf.kI(this.cBw.aWU);
      if (this.cBw != null && this.cBw.bSs != null)
        paramdf.kK(this.cBw.bSs); 
      if (this.cBw != null && this.cBw.bSt != null)
        paramdf.kL(this.cBw.bSt); 
      if (this.cBw != null && this.cBw.bSr != null)
        paramdf.kJ(this.cBw.bSr); 
      if (this.cBw != null && this.cBw.aWY != null)
        paramdf.jT(this.cBw.aWY); 
    } 
  }
  
  public boolean Az() {
    an.c c1 = (new an(this.mContext)).Vu();
    return this.cBw.equals(c1) ^ true;
  }
  
  public void Jx() {
    if (this.bFM == null)
      this.bFM = new bc(this.mContext); 
    this.bFM.show();
  }
  
  public void a(an paraman, df paramdf) {
    this.handler = new ct(this, paraman, paramdf);
    (new cn(this.mContext)).c(this.handler);
    acq();
  }
  
  public void a(df paramdf) { this.cBx = paramdf; }
  
  public boolean abU() {
    if (TextUtils.isEmpty(this.cBw.aVs)) {
      Toast.makeText(this.mContext, 2131629656, 0).show();
      return false;
    } 
    if (this.cBw.bSp == 0) {
      Toast.makeText(this.mContext, 2131629660, 0).show();
      return false;
    } 
    if (by.isNull(this.cBw.bSq)) {
      Toast.makeText(this.mContext, 2131629651, 0).show();
      return false;
    } 
    if (!a.zR().Ad()) {
      if (TextUtils.isEmpty(this.cBw.bSu)) {
        Toast.makeText(this.mContext, 2131629658, 0).show();
        return false;
      } 
      if (TextUtils.isEmpty(this.cBw.bSv)) {
        Toast.makeText(this.mContext, 2131629645, 0).show();
        return false;
      } 
      if (TextUtils.isEmpty(this.cBw.bSw)) {
        Toast.makeText(this.mContext, 2131629649, 0).show();
        return false;
      } 
      if (TextUtils.isEmpty(this.cBw.aWV)) {
        Toast.makeText(this.mContext, 2131629647, 0).show();
        return false;
      } 
    } 
    return true;
  }
  
  void acq() {
    if (this.cuO != null) {
      if (!this.cuO.isShowing()) {
        this.cuO.show();
        return;
      } 
    } else {
      this.cuO = new ab(this.mContext);
      this.cuO.setCanceledOnTouchOutside(false);
      this.cuO.show();
    } 
  }
  
  void acr() {
    if (this.cuO != null && this.cuO.isShowing())
      this.cuO.dismiss(); 
  }
  
  public df adF() { return this.cBx; }
  
  public h.e adi() { return this.czN; }
  
  public h.a adj() { return this.czO; }
  
  public void b(df paramdf) {
    a(paramdf);
    an an = new an(this.mContext);
    if (!this.mContext.getResources().getBoolean(2131034123)) {
      if (bd.bH(this.mContext)) {
        a(an, paramdf);
        return;
      } 
      this.cBw = an.Vu();
      c(paramdf);
      return;
    } 
    this.cBw = an.Vu();
    c(paramdf);
  }
  
  public boolean c(h.c paramc) {
    if (paramc == null)
      return false; 
    this.czP = paramc;
    adh();
    return true;
  }
  
  public boolean e(h.a parama) {
    if (parama == null)
      return false; 
    this.czO = parama;
    this.czP = (h.c)((Map.Entry)this.czO.UK().entrySet().iterator().next()).getValue();
    adh();
    return true;
  }
  
  public boolean e(h.e parame) {
    if (parame == null)
      return false; 
    this.czN = parame;
    this.czO = parame.UN();
    this.czP = (h.c)((Map.Entry)this.czO.UK().entrySet().iterator().next()).getValue();
    adh();
    return true;
  }
  
  public boolean hu(int paramInt) {
    if (!an.d.gh(paramInt))
      return false; 
    this.cBw.bSp = paramInt;
    adF().hr(paramInt);
    return true;
  }
  
  public boolean hv(int paramInt) {
    an.c c1 = this.cBw;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    c1.bSq = stringBuilder.toString();
    df df1 = adF();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    df1.kH(stringBuilder.toString());
    return true;
  }
  
  public boolean jV(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    this.cBw.aVs = paramString;
    return true;
  }
  
  public boolean jW(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    this.cBw.aWV = paramString;
    return true;
  }
  
  public boolean jY(String paramString) {
    this.cBw.aWX = paramString;
    return true;
  }
  
  public boolean jZ(String paramString) {
    this.cBw.aWY = paramString;
    return true;
  }
  
  public boolean kM(String paramString) {
    this.cBw.bSq = paramString;
    adF().kH(paramString);
    return true;
  }
  
  public boolean kN(String paramString) {
    this.cBw.aWU = paramString;
    return true;
  }
  
  public boolean kO(String paramString) {
    this.cBw.bSr = paramString;
    return true;
  }
  
  public boolean kP(String paramString) {
    this.cBw.bSs = paramString;
    return true;
  }
  
  public boolean kQ(String paramString) {
    this.cBw.bSt = paramString;
    return true;
  }
  
  public boolean save() {
    an an = new an(this.mContext);
    this.cBw.aVs = this.cBw.aVs.trim();
    return an.b(this.cBw);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */