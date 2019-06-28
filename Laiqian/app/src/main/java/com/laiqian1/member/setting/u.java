package com.laiqian.member.setting;

import android.content.Context;
import android.os.AsyncTask;
import com.laiqian.d.a;
import com.laiqian.ui.a.bc;
import com.laiqian.util.bd;
import com.laiqian.vip.R;

public class u {
  private v bBW;
  
  private n bBX;
  
  private Context mContext;
  
  private bc mWiFiDialog;
  
  public u(Context paramContext, v paramv, n paramn) {
    this.mContext = paramContext;
    this.bBW = paramv;
    this.bBX = paramn;
  }
  
  public void dT(boolean paramBoolean) { (new a(this, paramBoolean)).execute(new Void[0]); }
  
  public class a extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    boolean bBZ = false;
    
    public a(u this$0, boolean param1Boolean) { this.bBZ = param1Boolean; }
    
    private boolean checkNetwork() {
      if (!bd.bH(u.b(this.bCa))) {
        if (u.c(this.bCa) == null) {
          u.a(this.bCa, new bc(u.b(this.bCa)));
          u.c(this.bCa).setCancelable(false);
        } 
        u.c(this.bCa).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      String str;
      u.a(this.bCa).dQ(param1Boolean.booleanValue());
      try {
        u.a(this.bCa).RA();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      v v = u.a(this.bCa);
      if (param1Boolean.booleanValue()) {
        str = u.b(this.bCa).getString(R.string.save_success);
      } else {
        str = u.b(this.bCa).getString(R.string.sync_failed);
      } 
      v.showError(str);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (u.d(this.bCa) != null) {
        if (u.d(this.bCa).Bx()) {
          a.AZ().f(u.d(this.bCa).Ru());
          bc.RH().a(u.d(this.bCa).Ru(), 0);
        } 
        a.AZ().bU(u.d(this.bCa).Rt());
        a.AZ().bP(u.d(this.bCa).Bx());
        a.AZ().bO(u.d(this.bCa).Rw());
        a.AZ().bN(u.d(this.bCa).Rv());
      } 
      return this.bBY ? Boolean.valueOf(bc.RH().RK()) : Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      boolean bool;
      u.a(this.bCa).Rz();
      if (!this.bBZ || checkNetwork()) {
        bool = true;
      } else {
        bool = false;
      } 
      this.bBY = bool;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\settin\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */