package com.laiqian.member.setting;

import android.content.Context;
import android.os.AsyncTask;
import com.laiqian.d.a;
import com.laiqian.ui.a.bc;
import com.laiqian.util.bd;
import com.laiqian.vip.R;

public class aj {
  private n bBX;
  
  private as bCA;
  
  private Context mContext;
  
  private bc mWiFiDialog;
  
  public aj(Context paramContext, as paramas) {
    this.mContext = paramContext;
    this.bCA = paramas;
  }
  
  public void dT(boolean paramBoolean) { (new a(this, paramBoolean)).execute(new Void[0]); }
  
  public class a extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    boolean bBZ = false;
    
    public a(aj this$0, boolean param1Boolean) { this.bBZ = param1Boolean; }
    
    private boolean checkNetwork() {
      if (!bd.bH(aj.b(this.bCB))) {
        if (aj.c(this.bCB) == null) {
          aj.a(this.bCB, new bc(aj.b(this.bCB)));
          aj.c(this.bCB).setCancelable(false);
        } 
        aj.c(this.bCB).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      int i;
      Context context;
      param1Boolean.booleanValue();
      try {
        aj.a(this.bCB).RA();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      as as = aj.a(this.bCB);
      if (param1Boolean.booleanValue()) {
        context = aj.b(this.bCB);
        i = R.string.save_success;
      } else {
        context = aj.b(this.bCB);
        i = R.string.sync_failed;
      } 
      String str = context.getString(i);
      as.showError(str);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (aj.d(this.bCB) != null) {
        if (aj.d(this.bCB).Bx()) {
          a.AZ().f(aj.d(this.bCB).Ru());
          if (!bc.RH().a(aj.d(this.bCB).Ru(), 0))
            return Boolean.valueOf(false); 
        } 
        a.AZ().bU(aj.d(this.bCB).Rt());
        a.AZ().bP(aj.d(this.bCB).Bx());
        a.AZ().bO(aj.d(this.bCB).Rw());
        a.AZ().bN(aj.d(this.bCB).Rv());
      } 
      return this.bBY ? Boolean.valueOf(bc.RH().RK()) : Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      boolean bool;
      aj.a(this.bCB).Rz();
      if (!this.bBZ || checkNetwork()) {
        bool = true;
      } else {
        bool = false;
      } 
      this.bBY = bool;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */