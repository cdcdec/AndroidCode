package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import java.util.ArrayList;

public class ap {
  Context context;
  
  ar ctt;
  
  gp ctu;
  
  k ctv;
  
  gp ctw;
  
  k ctx;
  
  public ap(Context paramContext, ar paramar) {
    this.context = paramContext;
    this.ctt = paramar;
  }
  
  private void RY() {
    this.ctt.az(this.ctu.ack());
    this.ctt.af(this.ctu.ach());
    this.ctt.aA(this.ctu.FI());
    this.ctt.aB(this.ctv.FI());
  }
  
  public boolean Az() { return !(this.ctv.equals(this.ctx) && this.ctu.equals(this.ctw)); }
  
  public void aA(double paramDouble) { this.ctu.p(paramDouble); }
  
  public void aB(double paramDouble) { this.ctv.p(paramDouble); }
  
  public void af(ArrayList<eh> paramArrayList) {
    this.ctu.af(paramArrayList);
    this.ctw.af(paramArrayList);
  }
  
  public void az(double paramDouble) { this.ctu.az(paramDouble); }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(ap this$0) {}
    
    protected void b(Boolean param1Boolean) {
      try {
        this.cty.ctt.hideProgress();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        ap.a(this.cty);
        return;
      } 
      Toast.makeText(this.cty.context, this.cty.context.getString(2131630541), 0).show();
      av av = new av(this.cty.context);
      String str = av.Tx();
      av.close();
      this.cty.ctw = new gp(str);
      this.cty.ctx = new k(str);
      this.cty.ctu = this.cty.ctw.acp();
      this.cty.ctv = this.cty.ctx.abb();
      ap.a(this.cty);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      fp fp = fp.aX(this.cty.context);
      this.cty.ctw = fp.abX();
      this.cty.ctx = fp.aca();
      if (this.cty.ctw == null || this.cty.ctx == null)
        return Boolean.valueOf(false); 
      this.cty.ctu = this.cty.ctw.acp();
      this.cty.ctv = this.cty.ctx.abb();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { this.cty.ctt.Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(ap this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.cty.context)) {
        Toast.makeText(this.cty.context, this.cty.context.getString(2131626280), 0).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      try {
        this.cty.ctt.hideProgress();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      if (param1Boolean.booleanValue()) {
        this.cty.ctw = this.cty.ctu.acp();
        this.cty.ctx = this.cty.ctv.abb();
        this.cty.ctt.exit();
        return;
      } 
      this.cty.ctt.showError(this.cty.context.getString(2131630559));
      this.cty.ctu = this.cty.ctw.acp();
      this.cty.ctv = this.cty.ctx.abb();
      ap.a(this.cty);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        fp fp = fp.aX(this.cty.context);
        boolean bool1 = fp.a(this.cty.ctu);
        boolean bool2 = fp.a(this.cty.ctv);
        return (bool1 && bool2) ? Boolean.valueOf(true) : Boolean.valueOf(false);
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.cty.ctt.Em();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */