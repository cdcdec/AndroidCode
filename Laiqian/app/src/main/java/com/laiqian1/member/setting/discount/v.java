package com.laiqian.member.setting.discount;

import android.content.Context;
import android.os.AsyncTask;
import com.laiqian.d.a;
import com.laiqian.member.setting.as;
import com.laiqian.member.setting.bc;
import com.laiqian.member.setting.n;
import com.laiqian.ui.a.bc;
import com.laiqian.util.bd;
import com.laiqian.vip.R;

public class v {
  private n bBX;
  
  private as bCA;
  
  private Context mContext;
  
  private bc mWiFiDialog;
  
  public v(Context paramContext, as paramas) {
    this.mContext = paramContext;
    this.bCA = paramas;
  }
  
  public void dT(boolean paramBoolean) { (new a(this, paramBoolean)).execute(new Void[0]); }
  
  public class a extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    boolean bBZ = false;
    
    public a(v this$0, boolean param1Boolean) { this.bBZ = param1Boolean; }
    
    private boolean checkNetwork() {
      if (!bd.bH(v.b(this.bDW))) {
        if (v.c(this.bDW) == null) {
          v.a(this.bDW, new bc(v.b(this.bDW)));
          v.c(this.bDW).setCancelable(false);
        } 
        v.c(this.bDW).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      String str;
      param1Boolean.booleanValue();
      try {
        v.a(this.bDW).RA();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      as as = v.a(this.bDW);
      if (param1Boolean.booleanValue()) {
        str = v.b(this.bDW).getString(R.string.save_success);
      } else {
        str = v.b(this.bDW).getString(R.string.sync_failed);
      } 
      as.showError(str);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (v.d(this.bDW) != null) {
        if (v.d(this.bDW).Bx()) {
          a.AZ().f(v.d(this.bDW).Ru());
          if (!bc.RH().a(v.d(this.bDW).Ru(), 0))
            return Boolean.valueOf(false); 
        } 
        a.AZ().bU(v.d(this.bDW).Rt());
        a.AZ().bP(v.d(this.bDW).Bx());
        a.AZ().bO(v.d(this.bDW).Rw());
        a.AZ().bN(v.d(this.bDW).Rv());
      } 
      return this.bBY ? Boolean.valueOf(bc.RH().RK()) : Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      boolean bool;
      v.a(this.bDW).Rz();
      if (!this.bBZ || checkNetwork()) {
        bool = true;
      } else {
        bool = false;
      } 
      this.bBY = bool;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */