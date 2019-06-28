package com.laiqian.pos.hold;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.ui.a.d;
import com.laiqian.util.m;

public class a extends d {
  private boolean aTZ;
  
  private EditText cne;
  
  private String cnf = null;
  
  private View cng;
  
  private EditText cnh;
  
  private String cni;
  
  private boolean cnj;
  
  View.OnClickListener cnk;
  
  a cnl;
  
  private CheckBox pack_check;
  
  private View pack_l;
  
  public a(Context paramContext) {
    super(paramContext, 2131427866);
    byte b = 0;
    this.cnj = false;
    this.cnk = new c(this);
    this.tvTitle = (TextView)this.mView.findViewById(2131299242);
    this.cne = (EditText)this.mView.findViewById(2131298241);
    View view = this.mView.findViewById(2131299105);
    this.mView.findViewById(2131296671).setOnClickListener(new b(this));
    view.setOnClickListener(this.cnk);
    this.pack_l = findViewById(2131298339);
    view = this.pack_l;
    if (a.zR().zU())
      b = 8; 
    view.setVisibility(b);
    this.pack_check = (CheckBox)this.pack_l.findViewById(2131298337);
    this.pack_l.setOnClickListener(new m.b(this.mActivity, this.pack_check));
    this.cng = findViewById(2131299839);
    if (!a.zR().Ab())
      aax(); 
    this.cnh = (EditText)this.cng.findViewById(2131297000);
  }
  
  public void a(a parama) { this.cnl = parama; }
  
  public void aax() { this.cng.setVisibility(8); }
  
  public void cR(boolean paramBoolean) { this.aTZ = paramBoolean; }
  
  public void eR(boolean paramBoolean) { this.cnj = paramBoolean; }
  
  public void jE(String paramString) { this.cnf = paramString; }
  
  protected void onStart() {
    super.onStart();
    if (this.cnf == null) {
      this.cne.setText("");
    } else {
      this.cne.setText(String.valueOf(this.cnf));
    } 
    this.pack_check.setChecked(this.aTZ);
    this.cne.requestFocus();
    this.cne.selectAll();
  }
  
  public static interface a {
    void b(String param1String1, boolean param1Boolean, String param1String2);
    
    void onCancel();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */