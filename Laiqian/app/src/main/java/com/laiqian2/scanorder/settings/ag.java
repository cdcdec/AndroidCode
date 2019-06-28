package com.laiqian.scanorder.settings;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.t;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bm;

public class ag {
  Context context;
  
  r cta;
  
  r ctb;
  
  al djn;
  
  t djo;
  
  t djp;
  
  public ag(Context paramContext, al paramal) {
    this.context = paramContext;
    this.djn = paramal;
  }
  
  private void RY() {
    boolean bool;
    this.djn.p(this.djo.FI());
    this.djn.eZ(this.djo.FG());
    this.djn.fa(this.djo.FH());
    this.djn.r(this.djo.FD(), this.djo.FA());
    this.djn.q(this.djo.FC(), this.djo.Fz());
    al al1 = this.djn;
    if (this.djo.FB() && RootApplication.getLaiqianPreferenceManager().Wq()) {
      bool = true;
    } else {
      bool = false;
    } 
    al1.cE(bool);
  }
  
  public boolean Az() { return (this.djo == null) ? false : (!this.djo.equals(this.djp)); }
  
  public String abe() { return this.djo.FC(); }
  
  public String abf() { return this.djo.FD(); }
  
  public void abg() {
    if (this.cta == null) {
      this.cta = new r(this.context, new ah(this));
      this.cta.t(this.context.getString(R.string.bind_right_now));
      this.cta.s(this.context.getString(R.string.you_are_not_bound_to_alipay));
      this.cta.setTitle(this.context.getString(R.string.account_bind));
    } 
    this.cta.show();
  }
  
  public void abh() {
    if (this.ctb == null) {
      this.ctb = new r(this.context, new ai(this));
      this.ctb.t(this.context.getString(R.string.bind_right_now));
      this.ctb.s(this.context.getString(R.string.you_are_not_bound_to_wechatpay));
      this.ctb.setTitle(this.context.getString(R.string.account_bind));
    } 
    this.ctb.show();
  }
  
  public void cE(boolean paramBoolean) { this.djo.cE(paramBoolean); }
  
  public void eZ(boolean paramBoolean) { this.djo.cI(paramBoolean); }
  
  public void fa(boolean paramBoolean) { this.djo.cJ(paramBoolean); }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(ag this$0) {}
    
    protected void b(Boolean param1Boolean) {
      try {
        this.djq.djn.hideProgress();
        if (param1Boolean.booleanValue()) {
          ag.a(this.djq);
          return;
        } 
        Toast.makeText(this.djq.context, this.djq.context.getString(R.string.weshop_get_payment_settings_failed), 0).show();
        av av = new av(this.djq.context);
        String str = av.Tx();
        av.close();
        this.djq.djp = new t(str);
        this.djq.djo = this.djq.djp.FJ();
        ag.a(this.djq);
        return;
      } catch (Exception param1Boolean) {
        return;
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      bm bm = new bm();
      this.djq.djp = bm.awr();
      if (this.djq.djp == null)
        return Boolean.valueOf(false); 
      this.djq.djo = this.djq.djp.FJ();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { this.djq.djn.Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(ag this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.djq.context)) {
        Toast.makeText(this.djq.context, this.djq.context.getString(R.string.please_check_network), 0).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      try {
        this.djq.djn.RA();
        if (!this.bBY)
          return; 
        if (param1Boolean.booleanValue()) {
          this.djq.djp = this.djq.djo.FJ();
          if (this.djq.context != null) {
            this.djq.djn.showError(this.djq.context.getString(R.string.weshop_save_payment_settings_success));
            return;
          } 
        } else {
          if (this.djq.context != null)
            this.djq.djn.showError(this.djq.context.getString(R.string.weshop_save_payment_settings_failed)); 
          this.djq.djo = this.djq.djp.FJ();
          ag.a(this.djq);
        } 
        return;
      } catch (Exception param1Boolean) {
        return;
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) { return this.bBY ? ((new bm()).a(this.djq.djo) ? Boolean.valueOf(true) : Boolean.valueOf(false)) : Boolean.valueOf(false); }
    
    protected void onPreExecute() {
      this.djq.djn.Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */