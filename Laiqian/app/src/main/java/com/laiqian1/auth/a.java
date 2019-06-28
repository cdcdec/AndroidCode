package com.laiqian.auth;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;
import com.laiqian.util.n;

public class a extends d {
  private EditText aCO;
  
  private String aCP;
  
  private String aCQ;
  
  private String aCR;
  
  private a aCS;
  
  private View aCT;
  
  private r aCU;
  
  public a(ActivityRoot paramActivityRoot) {
    super(paramActivityRoot, 2131427845);
    ((TextView)this.mView.findViewById(2131299351)).setText(2131626472);
    this.aCO = (EditText)this.mView.findViewById(2131298198);
    this.mView.findViewById(2131299841).setOnClickListener(new m.b(this.mActivity, this.aCO));
    this.aCT = this.mView.findViewById(2131296858);
    this.mView.findViewById(2131296671).setOnClickListener(new b(this));
    this.mView.findViewById(2131299105).setOnClickListener(new c(this));
    this.aCT.setOnClickListener(new d(this));
  }
  
  private boolean bn(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131626473), 0).show();
      this.aCO.requestFocus();
      return false;
    } 
    if (paramString.equals(this.aCQ))
      return true; 
    cj cj = new cj(this.mActivity);
    boolean bool = cj.by(paramString);
    cj.close();
    if (bool) {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131626474), 0).show();
      n.j(this.aCO);
      return false;
    } 
    return true;
  }
  
  private boolean bo(String paramString) { return (this.aCP == null) ? xH() : bp(paramString); }
  
  private boolean bp(String paramString) { return true; }
  
  private boolean xH() { return true; }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new e(this));
      this.aCU.s(this.mActivity.getString(2131626470));
    } 
    return this.aCU;
  }
  
  public void a(a parama) { this.aCS = parama; }
  
  protected boolean delete() {
    if (this.aCP.equals("NOID"))
      return true; 
    cj cj = new cj(this.mActivity);
    boolean bool = cj.F(Long.parseLong(this.aCP));
    cj.close();
    return bool;
  }
  
  public void k(String paramString1, String paramString2, String paramString3) {
    this.aCP = paramString1;
    this.aCQ = paramString3;
    this.aCO.setText(paramString2);
    if (paramString1 == null) {
      this.tvTitle.setText(2131626599);
      this.aCT.setVisibility(8);
    } else {
      this.tvTitle.setText(2131627644);
      this.aCT.setVisibility(0);
      n.j(this.aCO);
    } 
    show();
    this.aCO.requestFocus();
  }
  
  protected void xI() { xJ().show(); }
  
  public static interface a {
    void a(boolean param1Boolean, String param1String1, String param1String2);
    
    void b(boolean param1Boolean, String param1String1, String param1String2);
    
    void c(boolean param1Boolean, String param1String1, String param1String2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */