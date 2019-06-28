package com.laiqian.pos;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;

public class bn extends d {
  private ActivityRoot cgM;
  
  private TextView cgN;
  
  private EditText cgO;
  
  private CheckBox cgP;
  
  private a cgQ;
  
  public bn(ActivityRoot paramActivityRoot, a parama) {
    super(paramActivityRoot, R.layout.pos_product_bussiness_dialog);
    this.cgM = paramActivityRoot;
    this.cgQ = parama;
    setPositionTop();
    this.cgN = (TextView)findViewById(R.id.detail_title);
    this.cgO = (EditText)findViewById(R.id.product_details);
    this.cgP = (CheckBox)findViewById(R.id.cb_show_attributes);
    this.mView.findViewById(R.id.canal).setOnClickListener(new bo(this));
    this.mView.findViewById(R.id.save).setOnClickListener(new bp(this));
  }
  
  private void save() {
    if (this.cgO.getText().toString().trim().length() > 1000) {
      Toast.makeText(this.cgM, R.string.word_out_of, 0).show();
      return;
    } 
    this.cgQ.p(this.cgO.getText().toString().trim(), this.cgP.isChecked());
    cancel();
  }
  
  public void d(String paramString1, String paramString2, boolean paramBoolean) {
    this.cgN.setText(paramString1);
    this.cgO.setText(paramString2);
    this.cgP.setChecked(paramBoolean);
    super.show();
  }
  
  public void show() { super.show(); }
  
  public static interface a {
    void p(String param1String, boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */