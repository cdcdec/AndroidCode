package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.bd;

public class ad {
  Context context;
  
  ag csX;
  
  k csY;
  
  k csZ;
  
  r cta;
  
  r ctb;
  
  public ad(Context paramContext, ag paramag) {
    this.context = paramContext;
    this.csX = paramag;
  }
  
  private void RY() {
    this.csX.p(this.csY.FI());
    this.csX.eZ(this.csY.FG());
    this.csX.cF(this.csY.FE());
    this.csX.fa(this.csY.FH());
    this.csX.cG(this.csY.FF());
    this.csX.r(this.csY.FD(), this.csY.FA());
    this.csX.q(this.csY.FC(), this.csY.Fz());
    this.csX.cE(this.csY.aba());
  }
  
  public boolean Az() { return (this.csY == null) ? false : (!this.csY.equals(this.csZ)); }
  
  public String abe() { return this.csY.FC(); }
  
  public String abf() { return this.csY.FD(); }
  
  public void abg() {
    if (this.cta == null) {
      this.cta = new r(this.context, new ae(this));
      this.cta.t(this.context.getString(2131624429));
      this.cta.s(this.context.getString(2131630681));
      this.cta.setTitle(this.context.getString(2131624145));
    } 
    this.cta.show();
  }
  
  public void abh() {
    if (this.ctb == null) {
      this.ctb = new r(this.context, new af(this));
      this.ctb.t(this.context.getString(2131624429));
      this.ctb.s(this.context.getString(2131630682));
      this.ctb.setTitle(this.context.getString(2131624145));
    } 
    this.ctb.show();
  }
  
  public void cF(boolean paramBoolean) { this.csY.cF(paramBoolean); }
  
  public void cG(boolean paramBoolean) { this.csY.cG(paramBoolean); }
  
  public void eY(boolean paramBoolean) { this.csY.eY(paramBoolean); }
  
  public void eZ(boolean paramBoolean) { this.csY.cI(paramBoolean); }
  
  public void fa(boolean paramBoolean) { this.csY.cJ(paramBoolean); }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  public void p(double paramDouble) { this.csY.p(paramDouble); }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(ad this$0) {}
    
    protected void b(Boolean param1Boolean) {
      try {
        this.ctc.csX.hideProgress();
        if (param1Boolean.booleanValue()) {
          ad.a(this.ctc);
          return;
        } 
        Toast.makeText(this.ctc.context, this.ctc.context.getString(2131630541), 0).show();
        av av = new av(this.ctc.context);
        String str = av.Tx();
        av.close();
        this.ctc.csZ = new k(str);
        this.ctc.csY = this.ctc.csZ.abb();
        ad.a(this.ctc);
        return;
      } catch (Exception param1Boolean) {
        return;
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      fp fp = fp.aX(this.ctc.context);
      this.ctc.csZ = fp.aca();
      if (this.ctc.csZ == null)
        return Boolean.valueOf(false); 
      this.ctc.csY = this.ctc.csZ.abb();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { this.ctc.csX.Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(ad this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.ctc.context)) {
        Toast.makeText(this.ctc.context, this.ctc.context.getString(2131626280), 0).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      try {
        this.ctc.csX.RA();
        if (!this.bBY)
          return; 
        if (param1Boolean.booleanValue()) {
          this.ctc.csZ = this.ctc.csY.abb();
          if (this.ctc.context != null) {
            this.ctc.csX.showError(this.ctc.context.getString(2131630560));
            return;
          } 
        } else {
          if (this.ctc.context != null)
            this.ctc.csX.showError(this.ctc.context.getString(2131630559)); 
          this.ctc.csY = this.ctc.csZ.abb();
          ad.a(this.ctc);
        } 
        return;
      } catch (Exception param1Boolean) {
        return;
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) { return this.bBY ? (fp.aX(this.ctc.context).a(this.ctc.csY) ? Boolean.valueOf(true) : Boolean.valueOf(false)) : Boolean.valueOf(false); }
    
    protected void onPreExecute() {
      this.ctc.csX.Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */