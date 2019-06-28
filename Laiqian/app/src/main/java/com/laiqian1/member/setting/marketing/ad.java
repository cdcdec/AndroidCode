package com.laiqian.member.setting.marketing;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.a.d;
import com.laiqian.util.cl;
import com.laiqian.vip.R;

public class ad extends d implements View.OnClickListener {
  private static final String TAG = "ad";
  
  private EditText bFq;
  
  private TextView bFr;
  
  private a bFs;
  
  private TextView bvd;
  
  private final Context mContext;
  
  static  {
  
  }
  
  public ad(Context paramContext) {
    super(paramContext, R.layout.dialog_send_test, R.style.pos_dialog);
    initView();
    this.mContext = paramContext;
    JZ();
  }
  
  private void JZ() {
    this.mView.findViewById(R.id.tv_send).setOnClickListener(this);
    this.mView.findViewById(R.id.tv_canal).setOnClickListener(this);
  }
  
  private void initView() {
    this.bFq = (EditText)this.mView.findViewById(R.id.ed_phone_number);
    this.bvd = (TextView)this.mView.findViewById(R.id.tv_cancel);
    this.bFr = (TextView)this.mView.findViewById(R.id.tv_send);
  }
  
  public String Sy() { return this.bFq.getText().toString().trim(); }
  
  public void a(a parama) { this.bFs = parama; }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.tv_canal) {
      dismiss();
      return;
    } 
    if (paramView.getId() == R.id.tv_send) {
      if (!cl.sg(this.bFq.getText().toString().trim())) {
        Toast.makeText(this.mContext, R.string.vip_promotion_sms_number_illeagel, 0).show();
        return;
      } 
      if (this.bFs != null)
        this.bFs.onClick(paramView); 
    } 
  }
  
  public void show() { super.show(); }
  
  public static interface a {
    void onClick(View param1View);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */