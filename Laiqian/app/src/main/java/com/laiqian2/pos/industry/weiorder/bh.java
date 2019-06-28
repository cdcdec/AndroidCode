package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.os.AsyncTask;
import com.laiqian.entity.aw;
import com.laiqian.util.av;
import com.laiqian.util.bd;

public class bh {
  Context context;
  
  bj ctG;
  
  aw ctH;
  
  gp ctu;
  
  k ctv;
  
  gp ctw;
  
  k ctx;
  
  public bh(Context paramContext, bj parambj) {
    this.context = paramContext;
    this.ctG = parambj;
  }
  
  private void abn() {
    if (this.ctH.Jr() == 1) {
      if (!this.ctu.FH() && !this.ctu.acl()) {
        this.ctG.abj();
        return;
      } 
    } else if (this.ctH.Jr() == 2 && !this.ctu.acl()) {
      this.ctG.abk();
    } 
  }
  
  private void abo() {
    if (!this.ctv.FH()) {
      this.ctG.abm();
      return;
    } 
    if (!this.ctv.FG())
      this.ctG.abl(); 
  }
  
  private void fh(boolean paramBoolean) { this.ctG.fb(paramBoolean); }
  
  private void fj(boolean paramBoolean) { this.ctG.fc(paramBoolean); }
  
  public boolean Az() { return (!this.ctu.equals(this.ctw) || !this.ctv.equals(this.ctx)); }
  
  public void RY() {
    if (this.ctH != null && this.ctH.Jr() == 2) {
      this.ctG.ff(false);
    } else {
      this.ctG.ff(true);
    } 
    if (!this.ctv.aaZ()) {
      this.ctG.fg(false);
    } else {
      this.ctG.fg(true);
    } 
    this.ctG.fb(this.ctu.FH());
    this.ctG.fc(this.ctu.acl());
    this.ctG.fd(this.ctv.FG());
    this.ctG.fe(this.ctv.FH());
  }
  
  public void fb(boolean paramBoolean) {
    this.ctu.cJ(paramBoolean);
    fh(paramBoolean);
    abn();
  }
  
  public void fd(boolean paramBoolean) {
    this.ctv.cI(paramBoolean);
    this.ctG.fd(paramBoolean);
    abo();
  }
  
  public void fe(boolean paramBoolean) {
    this.ctv.cJ(paramBoolean);
    this.ctG.fe(paramBoolean);
    abo();
  }
  
  public void fi(boolean paramBoolean) {
    this.ctu.ft(paramBoolean);
    fj(paramBoolean);
    abn();
  }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(bh this$0) {}
    
    protected void b(Boolean param1Boolean) {
      try {
        this.ctI.ctG.hideProgress();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        this.ctI.RY();
        return;
      } 
      this.ctI.ctG.showError(this.ctI.context.getString(2131630541));
      av av = new av(this.ctI.context);
      String str = av.Tx();
      av.close();
      this.ctI.ctw = new gp(str);
      this.ctI.ctu = this.ctI.ctw.acp();
      this.ctI.ctx = new k(str);
      this.ctI.ctv = this.ctI.ctx.abb();
      this.ctI.RY();
    }
    
    protected Boolean g(Void... param1VarArgs) {
      fp fp = fp.aX(this.ctI.context);
      this.ctI.ctw = fp.abX();
      this.ctI.ctx = fp.aca();
      this.ctI.ctH = fp.abV();
      if (this.ctI.ctw == null || this.ctI.ctx == null)
        return Boolean.valueOf(false); 
      this.ctI.ctu = this.ctI.ctw.acp();
      this.ctI.ctv = this.ctI.ctx.abb();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { this.ctI.ctG.Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(bh this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.ctI.context)) {
        this.ctI.ctG.showError(this.ctI.context.getString(2131626280));
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      try {
        this.ctI.ctG.hideProgress();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      if (param1Boolean.booleanValue()) {
        this.ctI.ctw = this.ctI.ctu.acp();
        this.ctI.ctx = this.ctI.ctv.abb();
        this.ctI.ctG.showError(this.ctI.context.getString(2131630560));
        return;
      } 
      this.ctI.ctG.showError(this.ctI.context.getString(2131630559));
      this.ctI.ctu = this.ctI.ctw.acp();
      this.ctI.ctv = this.ctI.ctx.abb();
      this.ctI.RY();
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        fp fp = fp.aX(this.ctI.context);
        boolean bool1 = fp.a(this.ctI.ctu);
        boolean bool2 = fp.a(this.ctI.ctv);
        return (bool1 && bool2) ? Boolean.valueOf(true) : Boolean.valueOf(false);
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.ctI.ctG.Em();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */