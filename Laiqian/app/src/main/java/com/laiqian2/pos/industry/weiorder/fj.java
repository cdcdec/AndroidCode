package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import com.laiqian.entity.av;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;

public class fj {
  r bFM;
  
  fl cwo;
  
  av cwp;
  
  av cwq;
  
  Context mContext;
  
  public fj(Context paramContext) { this.mContext = paramContext; }
  
  private void RY() {
    this.cwo.dK(this.cwp.Ip());
    this.cwo.jR(this.cwp.Jk());
    this.cwo.jS(this.cwp.Jj());
    this.cwo.cc(this.cwp.Cc());
    this.cwo.jT(this.cwp.Jn());
    this.cwo.cZ(this.cwp.Jm());
    this.cwo.dN(this.cwp.Jl());
  }
  
  public boolean Az() { return (this.cwp != null) ? ((this.cwq == null) ? false : (!this.cwp.equals(this.cwq))) : false; }
  
  public void Jx() {
    if (this.bFM == null)
      this.bFM = new bc(this.mContext); 
    this.bFM.show();
  }
  
  public void a(fl paramfl) { this.cwo = paramfl; }
  
  public boolean abU() {
    if (TextUtils.isEmpty(this.cwp.Ip())) {
      Toast.makeText(this.mContext, 2131629656, 0).show();
      return false;
    } 
    if (TextUtils.isEmpty(this.cwp.Jk())) {
      Toast.makeText(this.mContext, 2131629647, 0).show();
      return false;
    } 
    if (TextUtils.isEmpty(this.cwp.Jj())) {
      Toast.makeText(this.mContext, 2131629646, 0).show();
      return false;
    } 
    return true;
  }
  
  public void b(fl paramfl) {
    a(paramfl);
    (new a(this, null)).execute(new Void[0]);
  }
  
  public boolean fs(boolean paramBoolean) {
    this.cwp.cZ(paramBoolean);
    return true;
  }
  
  public boolean jV(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    this.cwp.dK(paramString);
    return true;
  }
  
  public boolean jW(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    this.cwp.dM(paramString);
    return true;
  }
  
  public boolean jX(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    this.cwp.dN(paramString);
    return true;
  }
  
  public boolean jY(String paramString) {
    this.cwp.cc(paramString);
    return true;
  }
  
  public boolean jZ(String paramString) {
    this.cwp.dO(paramString);
    return true;
  }
  
  public boolean ka(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    this.cwp.dL(paramString);
    return true;
  }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(fj this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (!this.cwr.cwo.zP())
        return; 
      try {
        this.cwr.cwo.hideProgress();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        this.cwr.cwo.zO();
        fj.a(this.cwr);
        return;
      } 
      this.cwr.cwo.Sl();
      Toast.makeText(this.cwr.mContext, this.cwr.mContext.getString(2131630541), 0).show();
      this.cwr.cwq = new av();
      this.cwr.cwp = this.cwr.cwq.Jo();
      fj.a(this.cwr);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      fp fp = fp.aX(this.cwr.mContext);
      this.cwr.cwq = fp.abZ();
      if (this.cwr.cwq == null)
        return Boolean.valueOf(false); 
      this.cwr.cwp = this.cwr.cwq.Jo();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { this.cwr.cwo.Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(fj this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.cwr.mContext)) {
        this.cwr.Jx();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (!this.cwr.cwo.zP())
        return; 
      try {
        this.cwr.cwo.RA();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      if (param1Boolean.booleanValue()) {
        this.cwr.cwq = this.cwr.cwp.Jo();
        this.cwr.cwo.showError(this.cwr.mContext.getString(2131630560));
        return;
      } 
      this.cwr.cwo.showError(this.cwr.mContext.getString(2131630559));
      this.cwr.cwp = this.cwr.cwq.Jo();
      fj.a(this.cwr);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        fp fp = fp.aX(this.cwr.mContext);
        this.cwr.cwp.dK(this.cwr.cwp.Ip().trim());
        return (fp.c(this.cwr.cwp) && fp.b(this.cwr.cwp)) ? Boolean.valueOf(true) : Boolean.valueOf(false);
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.cwr.cwo.Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */