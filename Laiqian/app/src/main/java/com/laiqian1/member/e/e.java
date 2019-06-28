package com.laiqian.member.e;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.entity.aq;
import com.laiqian.ui.a.d;
import com.laiqian.vip.R;

public class e extends d {
  private EditText byf;
  
  private TextView byi;
  
  private TextView byj;
  
  private TextView byn;
  
  private a byo;
  
  private Context context;
  
  private aq vipEntity;
  
  public e(Context paramContext, aq paramaq, a parama) {
    super(paramContext, R.layout.dialog_verify_password_layout);
    this.context = paramContext;
    this.byo = parama;
    this.vipEntity = paramaq;
    setupViews();
    setListeners();
  }
  
  private void setListeners() {
    this.byi.setOnClickListener(new f(this));
    this.byj.setOnClickListener(new g(this));
    this.byn.setOnClickListener(new h(this));
  }
  
  private void setupViews() {
    this.byi = (TextView)this.mView.findViewById(R.id.canal);
    this.byj = (TextView)this.mView.findViewById(R.id.sure);
    this.byf = (EditText)this.mView.findViewById(R.id.et_vip_password);
    this.byn = (TextView)this.mView.findViewById(R.id.forget);
  }
  
  public void s(aq paramaq) {
    show();
    this.vipEntity = paramaq;
    this.byf.requestFocus();
  }
  
  public static interface a {
    void dj(boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */