package com.laiqian.pos.industry.weiorder;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.h;

public class WeshopInfoActivity extends ActivityRoot implements fl {
  fj cvS;
  
  a cvT;
  
  aa titleBar;
  
  private void abQ() {
    this.titleBar.tvTitle.setText(getString(2131628255));
    this.titleBar.brj.setText(getString(2131629495));
    this.titleBar.brk.setVisibility(8);
    ((TextView)this.cvT.cvV.cAO.getView()).setText(getString(2131628245));
    ((TextView)this.cvT.cvX.cAO.getView()).setText(getString(2131628239));
    ((TextView)this.cvT.cvW.cAO.getView()).setText(getString(2131628240));
    ((TextView)this.cvT.cvY.getView()).setText(getString(2131630543));
  }
  
  private void abR() { save(); }
  
  private void abi() {
    r r = new r(this, new ex(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void save() {
    if (!this.cvS.jV(((EditText)this.cvT.cvV.dwQ.getView()).getText().toString())) {
      Toast.makeText(this, 2131629656, 0).show();
      return;
    } 
    if (!this.cvS.jW(((EditText)this.cvT.cvX.dwQ.getView()).getText().toString())) {
      Toast.makeText(this, 2131629647, 0).show();
      return;
    } 
    if (!this.cvS.ka(((EditText)this.cvT.cvW.dwQ.getView()).getText().toString())) {
      Toast.makeText(this, 2131629646, 0).show();
      return;
    } 
    if (!this.cvS.abU())
      return; 
    this.cvS.save();
  }
  
  private void setListeners() {
    this.titleBar.brj.setOnClickListener(new ev(this));
    this.titleBar.bri.setOnClickListener(new ew(this));
  }
  
  public void Em() {}
  
  public void RA() {}
  
  public void Rz() {}
  
  public void Sl() {}
  
  public void cZ(boolean paramBoolean) {}
  
  public void cc(String paramString) {}
  
  public void dK(String paramString) { ((EditText)this.cvT.cvV.dwQ.getView()).setText(paramString); }
  
  public void dN(String paramString) {}
  
  public void hideProgress() {}
  
  public void jR(String paramString) { ((EditText)this.cvT.cvX.dwQ.getView()).setText(paramString); }
  
  public void jS(String paramString) { ((EditText)this.cvT.cvW.dwQ.getView()).setText(paramString); }
  
  public void jT(String paramString) {}
  
  public void onBackPressed() {
    if (this.cvS.Az()) {
      abi();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cvT = a.A(this);
    this.titleBar = aa.M(this);
    this.cvS = new fj(this);
    this.cvS.b(this);
    abQ();
    setListeners();
  }
  
  public void showError(String paramString) {}
  
  public void zO() {}
  
  public boolean zP() { return false; }
  
  public static class a extends ab<ViewGroup> {
    public h cvV = new h(2131297677);
    
    public h cvW = new h(2131297534);
    
    public h cvX = new h(2131297500);
    
    public ab<TextView> cvY = new ab(2131299643);
    
    public a(int param1Int) { super(param1Int); }
    
    public static a A(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427450, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */