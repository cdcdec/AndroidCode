package com.laiqian.member.setting.sms;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.laiqian.member.setting.bc;
import com.laiqian.util.bd;
import com.laiqian.vip.R;

public class t {
  k bES;
  
  private v bGZ;
  
  k bHa;
  
  private Context mContext;
  
  public t(Context paramContext, v paramv) {
    this.mContext = paramContext;
    this.bGZ = paramv;
  }
  
  public boolean Az() { return false; }
  
  public void RY() {
    this.bGZ.ec(this.bHa.bGN);
    this.bGZ.ef(this.bHa.bGM);
    this.bGZ.ee(this.bHa.bGL);
    this.bGZ.ed(this.bHa.bGK);
    this.bGZ.fS(this.bHa.bGd);
  }
  
  public int Su() { return this.bHa.bGd; }
  
  public void ec(boolean paramBoolean) { this.bHa.bGN = paramBoolean; }
  
  public void ed(boolean paramBoolean) { this.bHa.bGK = paramBoolean; }
  
  public void ee(boolean paramBoolean) { this.bHa.bGL = paramBoolean; }
  
  public void ef(boolean paramBoolean) { this.bHa.bGM = paramBoolean; }
  
  public void fS(int paramInt) { this.bHa.bGd = paramInt; }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(t this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (!t.a(this.bHb).zP())
        return; 
      try {
        t.a(this.bHb).hideProgress();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        t.a(this.bHb).zO();
        this.bHb.RY();
        return;
      } 
      t.a(this.bHb).Sl();
      this.bHb.bES = new k();
      this.bHb.bHa = this.bHb.bES.SS();
      this.bHb.RY();
    }
    
    protected Boolean g(Void... param1VarArgs) {
      bc bc = bc.RH();
      this.bHb.bES = bc.RU();
      if (this.bHb.bES == null)
        return Boolean.valueOf(false); 
      this.bHb.bHa = this.bHb.bES.SS();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { t.a(this.bHb).Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(t this$0) {}
    
    private boolean SI() {
      if (!bd.bH(t.b(this.bHb))) {
        Toast.makeText(t.b(this.bHb), t.b(this.bHb).getString(R.string.please_check_network), 0).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (!t.a(this.bHb).zP())
        return; 
      try {
        t.a(this.bHb).RA();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      if (param1Boolean.booleanValue()) {
        this.bHb.bES = this.bHb.bHa.SS();
        t.a(this.bHb).showError(t.b(this.bHb).getString(R.string.save_success));
        return;
      } 
      t.a(this.bHb).showError(t.b(this.bHb).getString(R.string.save_settings_failed));
      this.bHb.bHa = this.bHb.bES.SS();
      this.bHb.RY();
    }
    
    protected Boolean g(Void... param1VarArgs) { return this.bBY ? (bc.RH().a(this.bHb.bHa) ? Boolean.valueOf(true) : Boolean.valueOf(false)) : Boolean.valueOf(false); }
    
    protected void onPreExecute() {
      t.a(this.bHb).Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */