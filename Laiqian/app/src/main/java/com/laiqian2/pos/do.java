package com.laiqian.pos;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.d;

public class do extends d {
  private TextView byi;
  
  private TextView byj;
  
  private EditText cja;
  
  private a cjb;
  
  private Context context;
  
  public do(Context paramContext, a parama) {
    super(paramContext, R.layout.dialog_verify_boss_password_layout);
    this.context = paramContext;
    this.cjb = parama;
    setupViews();
    setListeners();
  }
  
  private void setListeners() {
    this.byi.setOnClickListener(new dp(this));
    this.byj.setOnClickListener(new dq(this));
  }
  
  private void setupViews() {
    this.cja = (EditText)findViewById(R.id.et_password);
    this.byi = (TextView)this.mView.findViewById(R.id.canal);
    this.byj = (TextView)this.mView.findViewById(R.id.sure);
  }
  
  public void show() {
    super.show();
    this.cja.requestFocus();
  }
  
  public static interface a {
    void dj(boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */