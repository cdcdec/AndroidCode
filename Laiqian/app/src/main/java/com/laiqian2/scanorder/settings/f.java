package com.laiqian.scanorder.settings;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.w;
import com.laiqian.util.ar;

public class f extends d {
  EditText aFf;
  
  TextView bDz;
  
  TextView bNf;
  
  w cTc;
  
  TextView csp;
  
  a diE = null;
  
  n diI;
  
  EditText diJ;
  
  TextView diK;
  
  ViewGroup diL;
  
  ViewGroup diM;
  
  TextView tvTitle;
  
  public f(Context paramContext, n paramn) {
    super(paramContext, R.layout.dialog_additional_fees);
    setPositionTop();
    this.diI = paramn;
    this.tvTitle = (TextView)findViewById(R.id.tv_title);
    this.aFf = (EditText)findViewById(R.id.et_name);
    this.diJ = (EditText)findViewById(R.id.et_amount);
    this.diK = (TextView)findViewById(R.id.tv_charge_type);
    this.csp = (TextView)findViewById(R.id.tv_confirm);
    this.bNf = (TextView)findViewById(R.id.tv_cancel);
    this.bDz = (TextView)findViewById(R.id.tv_delete);
    this.diL = (ViewGroup)findViewById(R.id.layout_name);
    this.diM = (ViewGroup)findViewById(R.id.layout_amount);
    if (paramn == null) {
      this.bDz.setVisibility(8);
      this.tvTitle.setText(getContext().getString(R.string.add));
      this.diK.setText(R.string.fixed_amount);
      this.diK.setTag(Integer.valueOf(0));
    } else {
      int i;
      this.bDz.setVisibility(0);
      this.tvTitle.setText(getContext().getString(R.string.modify));
      EditText editText = this.aFf;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramn.getName());
      stringBuilder.append("");
      editText.setText(stringBuilder.toString());
      editText = this.diJ;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramn.AO());
      stringBuilder.append("");
      editText.setText(stringBuilder.toString());
      TextView textView = this.diK;
      if (paramn.getType() == 0) {
        i = R.string.fixed_amount;
      } else {
        i = R.string.charge_by_number;
      } 
      textView.setText(i);
      this.diK.setTag(Integer.valueOf(paramn.getType()));
    } 
    this.diJ.setFilters(ar.bE(10, a.AZ().Be()));
    this.csp.setOnClickListener(new g(this));
    this.bDz.setOnClickListener(new h(this));
    this.bNf.setOnClickListener(new i(this));
    this.diL.setOnClickListener(new j(this));
    this.diM.setOnClickListener(new k(this));
    this.diK.setOnClickListener(new l(this));
  }
  
  public void a(a parama) { this.diE = parama; }
  
  public n aoQ() { return this.diI; }
  
  protected void onStart() {
    super.onStart();
    this.aFf.requestFocus();
  }
  
  public static interface a {
    void a(f param1f);
    
    void a(f param1f, String param1String, double param1Double, int param1Int);
    
    void b(f param1f);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */