package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.ui.a.d;

public class ei extends d {
  TextView bDz;
  
  TextView bNf;
  
  EditText cso;
  
  TextView csp;
  
  ViewGroup csq;
  
  ViewGroup csr;
  
  eh cvD;
  
  a cvE = null;
  
  EditText etDiscount;
  
  TextView tvTitle;
  
  public ei(Context paramContext, eh parameh) {
    super(paramContext, 2131427573);
    setPositionTop();
    this.cvD = parameh;
    this.tvTitle = (TextView)findViewById(2131299802);
    this.cso = (EditText)findViewById(2131297026);
    this.etDiscount = (EditText)findViewById(2131296989);
    this.csp = (TextView)findViewById(2131299511);
    this.bNf = (TextView)findViewById(2131299494);
    this.bDz = (TextView)findViewById(2131299522);
    this.csq = (ViewGroup)findViewById(2131297709);
    this.csr = (ViewGroup)findViewById(2131297556);
    if (parameh == null) {
      this.bDz.setVisibility(8);
      this.tvTitle.setText(getContext().getString(2131624158));
    } else {
      this.bDz.setVisibility(0);
      this.tvTitle.setText(getContext().getString(2131625793));
      EditText editText = this.cso;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(parameh.abM());
      stringBuilder.append("");
      editText.setText(stringBuilder.toString());
      editText = this.etDiscount;
      stringBuilder = new StringBuilder();
      stringBuilder.append(parameh.FI());
      stringBuilder.append("");
      editText.setText(stringBuilder.toString());
    } 
    this.csp.setOnClickListener(new ej(this));
    this.bDz.setOnClickListener(new ek(this));
    this.bNf.setOnClickListener(new el(this));
    this.csq.setOnClickListener(new em(this));
    this.csr.setOnClickListener(new en(this));
  }
  
  public void a(a parama) { this.cvE = parama; }
  
  public eh abN() { return this.cvD; }
  
  protected void onStart() {
    super.onStart();
    this.cso.requestFocus();
  }
  
  public static interface a {
    void a(ei param1ei);
    
    void a(ei param1ei, double param1Double1, double param1Double2);
    
    void b(ei param1ei);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */