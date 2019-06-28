package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.models.bf;
import com.laiqian.ui.a.d;
import com.laiqian.util.n;

public class a extends d {
  TextView bDz;
  
  TextView bNf;
  
  EditText cso;
  
  TextView csp;
  
  ViewGroup csq;
  
  ViewGroup csr;
  
  bf css;
  
  a cst = null;
  
  EditText etDiscount;
  
  private Context mContext;
  
  private int mSize;
  
  TextView tvTitle;
  
  public a(Context paramContext, bf parambf, int paramInt) {
    super(paramContext, 2131427532);
    this.mSize = paramInt;
    setPositionTop();
    this.mContext = paramContext;
    this.css = parambf;
    this.tvTitle = (TextView)this.mView.findViewById(2131299802);
    this.cso = (EditText)this.mView.findViewById(2131297028);
    this.etDiscount = (EditText)this.mView.findViewById(2131297029);
    if (paramInt > 0)
      this.etDiscount.setHint(""); 
    if (parambf == null) {
      this.mView.findViewById(2131299801).setVisibility(0);
    } else {
      this.mView.findViewById(2131299801).setVisibility(8);
    } 
    this.csp = (TextView)this.mView.findViewById(2131299511);
    this.bNf = (TextView)this.mView.findViewById(2131299494);
    this.bDz = (TextView)this.mView.findViewById(2131299522);
    this.csq = (ViewGroup)this.mView.findViewById(2131297709);
    this.csr = (ViewGroup)this.mView.findViewById(2131297556);
    if (parambf == null) {
      this.bDz.setVisibility(8);
      this.tvTitle.setText(getContext().getString(2131625050));
    } else {
      this.bDz.setVisibility(0);
      this.tvTitle.setText(getContext().getString(2131625051));
      this.cso.setText(n.ph(String.valueOf(parambf.Wx())));
      EditText editText = this.etDiscount;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(parambf.Wy());
      stringBuilder.append("");
      editText.setText(stringBuilder.toString());
    } 
    n.a(this.cso, 10, 5);
    this.csp.setOnClickListener(new b(this));
    this.bDz.setOnClickListener(new c(this));
    this.bNf.setOnClickListener(new d(this));
    this.csq.setOnClickListener(new e(this));
    this.csr.setOnClickListener(new f(this));
  }
  
  public void a(a parama) { this.cst = parama; }
  
  public bf aaY() { return this.css; }
  
  protected void onStart() {
    super.onStart();
    this.cso.requestFocus();
  }
  
  public static interface a {
    void a(a param1a);
    
    void a(a param1a, double param1Double, String param1String);
    
    void b(a param1a);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */