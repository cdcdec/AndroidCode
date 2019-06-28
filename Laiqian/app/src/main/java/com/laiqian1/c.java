package com.laiqian;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.google.zxing.WriterException;
import com.laiqian.payment.R;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.a.d;
import com.laiqian.util.al;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.HashMap;

public class c extends d {
  private LinearLayout azp;
  
  private LinearLayout azq;
  
  private LinearLayout azr;
  
  private ImageView azs;
  
  private Button azt;
  
  private TextView azu;
  
  private Context mContext;
  
  public c(Context paramContext) {
    super(paramContext, R.layout.dialog_alipay_auth);
    this.mContext = paramContext;
    wR();
    setListeners();
    setCancelable(false);
  }
  
  private void setListeners() {
    this.azp.setOnClickListener(new d(this));
    this.azt.setOnClickListener(new e(this));
  }
  
  private void wR() {
    this.azp = (LinearLayout)findViewById(R.id.ll_close);
    this.azq = (LinearLayout)findViewById(R.id.ll_processing);
    this.azr = (LinearLayout)findViewById(R.id.ll_result);
    this.azs = (ImageView)findViewById(R.id.iv_qrcode);
    this.azt = (Button)findViewById(R.id.btn_success);
    this.azu = (TextView)findViewById(R.id.tv_result);
  }
  
  public void show() {
    super.show();
    (new a(this)).execute(new Void[0]);
  }
  
  class a extends AsyncTask<Void, Void, String> {
    a(c this$0) {}
    
    protected String b(Void... param1VarArgs) {
      String str = (new av(c.b(this.azv))).Tx();
      HashMap hashMap = new HashMap();
      hashMap.put("nShopID", str);
      return bh.a(a.cqS, c.b(this.azv), hashMap);
    }
    
    protected void bf(String param1String) {
      c.a(this.azv).setVisibility(8);
      HashMap hashMap = au.qB(param1String);
      if (hashMap != null && hashMap.containsKey("auth_url")) {
        str = String.valueOf(hashMap.get("auth_url"));
        try {
          Bitmap bitmap = al.B(str, 250);
          c.c(this.azv).setImageBitmap(bitmap);
          c.d(this.azv).setText(R.string.alipay_scan_to_auth);
          return;
        } catch (WriterException str) {
          a.e(str);
          c.d(this.azv).setText(R.string.get_auth_url_fail);
          return;
        } 
      } 
      c.d(this.azv).setText(R.string.get_auth_url_fail);
    }
    
    protected void onPreExecute() { c.a(this.azv).setVisibility(0); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */