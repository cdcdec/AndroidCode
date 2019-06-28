package com.laiqian.member.setting.points;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.laiqian.member.setting.bc;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.vip.R;

public class h {
  private j bFJ;
  
  a bFK;
  
  a bFL;
  
  r bFM;
  
  private Context mContext;
  
  public h(Context paramContext, j paramj) {
    this.mContext = paramContext;
    this.bFJ = paramj;
  }
  
  private void RY() { this.bFJ.b(this.bFL); }
  
  public boolean Az() { return (this.bFL != null) ? ((this.bFK == null) ? false : (!this.bFL.equals(this.bFK))) : false; }
  
  public void Jx() {
    if (this.bFM == null)
      this.bFM = new bc(this.mContext); 
    this.bFM.show();
  }
  
  public void ar(double paramDouble) { this.bFL.ap(paramDouble); }
  
  public void as(double paramDouble) { this.bFL.aq(paramDouble); }
  
  public void dZ(boolean paramBoolean) { this.bFL.dZ(paramBoolean); }
  
  public void ea(boolean paramBoolean) { this.bFL.ea(paramBoolean); }
  
  public void fV(int paramInt) { this.bFL.fV(paramInt); }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(h this$0) {}
    
    protected void b(Boolean param1Boolean) {
      try {
        h.a(this.bFN).hideProgress();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        h.b(this.bFN);
        return;
      } 
      Toast.makeText(h.c(this.bFN), h.c(this.bFN).getString(R.string.save_settings_failed), 0).show();
      this.bFN.bFK = new a();
      this.bFN.bFL = this.bFN.bFK.SF();
      h.b(this.bFN);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      bc bc = bc.RH();
      this.bFN.bFK = bc.RT();
      if (this.bFN.bFK == null)
        return Boolean.valueOf(false); 
      this.bFN.bFL = this.bFN.bFK.SF();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { h.a(this.bFN).Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(h this$0) {}
    
    private boolean SI() {
      if (!bd.bH(h.c(this.bFN))) {
        this.bFN.Jx();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (!h.a(this.bFN).zP())
        return; 
      try {
        h.a(this.bFN).RA();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      if (param1Boolean.booleanValue()) {
        this.bFN.bFK = this.bFN.bFL.SF();
        h.a(this.bFN).showError(h.c(this.bFN).getString(R.string.save_success));
        return;
      } 
      h.a(this.bFN).showError(h.c(this.bFN).getString(R.string.save_settings_failed));
      this.bFN.bFL = this.bFN.bFK.SF();
      h.b(this.bFN);
    }
    
    protected Boolean g(Void... param1VarArgs) { return this.bBY ? (bc.RH().a(this.bFN.bFL) ? Boolean.valueOf(true) : Boolean.valueOf(false)) : Boolean.valueOf(false); }
    
    protected void onPreExecute() {
      h.a(this.bFN).Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */