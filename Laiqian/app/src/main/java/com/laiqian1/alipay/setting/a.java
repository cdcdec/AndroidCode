package com.laiqian.alipay.setting;

import android.content.Context;
import com.laiqian.util.av;

public class a implements c {
  private c aCg;
  
  private boolean aCh;
  
  private boolean aCi;
  
  private boolean aCj;
  
  public boolean aCk;
  
  public boolean aCl;
  
  public boolean aCm;
  
  private boolean aCn;
  
  private boolean aCo;
  
  private boolean aCp;
  
  private boolean aCq;
  
  private boolean aCr;
  
  private boolean aCs;
  
  private Context mContext;
  
  public a(Context paramContext, c paramc) {
    this.mContext = paramContext;
    this.aCg = paramc;
  }
  
  public void bu(boolean paramBoolean) {
    this.aCh = paramBoolean;
    this.aCi = false;
    this.aCj = false;
    this.aCg.bu(paramBoolean);
    this.aCg.bv(false);
    this.aCg.bz(false);
  }
  
  public void bv(boolean paramBoolean) {
    this.aCh = false;
    this.aCi = paramBoolean;
    this.aCj = false;
    this.aCg.bu(false);
    this.aCg.bv(paramBoolean);
    this.aCg.bz(false);
  }
  
  public void bw(boolean paramBoolean) {
    this.aCk = paramBoolean;
    this.aCg.bw(paramBoolean);
  }
  
  public void bx(boolean paramBoolean) {
    this.aCl = paramBoolean;
    this.aCg.bx(paramBoolean);
  }
  
  public void by(boolean paramBoolean) {
    this.aCm = paramBoolean;
    this.aCg.by(paramBoolean);
  }
  
  public void bz(boolean paramBoolean) {
    this.aCh = false;
    this.aCi = false;
    this.aCj = paramBoolean;
    this.aCg.bu(false);
    this.aCg.bv(false);
    this.aCg.bz(paramBoolean);
  }
  
  public void initData() {
    av av = new av(this.mContext);
    this.aCk = av.auK();
    this.aCl = av.auL();
    this.aCm = av.auM();
    this.aCq = av.auK();
    this.aCr = av.auL();
    this.aCs = av.auM();
    this.aCg.bw(av.auK());
    this.aCg.bx(av.auL());
    this.aCg.by(av.auM());
    av.close();
  }
  
  public void save() {
    av av = new av(this.mContext);
    av.hG(this.aCm);
    av.hF(this.aCl);
    av.hE(this.aCk);
    av.close();
  }
  
  public boolean xB() { return (this.aCh != this.aCn) ? true : ((this.aCi != this.aCo) ? true : ((this.aCj != this.aCp) ? true : ((this.aCk != this.aCq) ? true : ((this.aCl != this.aCr) ? true : ((this.aCm != this.aCs)))))); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */