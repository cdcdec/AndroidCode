package com.laiqian.member.setting.sms;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.google.zxing.WriterException;
import com.laiqian.basic.RootApplication;
import com.laiqian.payment.R;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.d;
import com.laiqian.util.al;
import com.laiqian.util.au;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.util.Date;
import java.util.HashMap;

public class c extends d {
  private TextView aAY;
  
  private ImageView azs;
  
  private ProgressBarCircularIndeterminate bGu;
  
  private TextView bGv;
  
  Handler bGw = new f(this);
  
  private TextView bvd;
  
  private Context mContext;
  
  public c(Context paramContext, String paramString1, String paramString2, String paramString3) {
    super(paramContext, R.layout.qrcode_pay_dialog);
    this.mContext = paramContext;
    initView();
    Q(n.a(Double.valueOf(Double.valueOf(paramString1).doubleValue() - Double.valueOf(paramString3).doubleValue()), false), paramString3);
    Ek();
    R(n.a(Double.valueOf(Double.valueOf(paramString1).doubleValue() - Double.valueOf(paramString3).doubleValue()), false), paramString2);
  }
  
  private void Ek() { this.bvd.setOnClickListener(new e(this)); }
  
  private void Q(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mContext.getString(R.string.dual_screen_alipay_qrcode_actual_pay));
    stringBuilder.append("<font color=\"#df554a\">%1$s</font>");
    stringBuilder.append(this.mContext.getString(R.string.money_unit));
    stringBuilder.append("<font color=\"#df554a\">(");
    stringBuilder.append(this.mContext.getString(R.string.reduce));
    stringBuilder.append("%2$s");
    stringBuilder.append(this.mContext.getString(R.string.money_unit));
    stringBuilder.append(")</font>");
    String str;
    this.bGv.setText(Html.fromHtml((str = stringBuilder.toString()).format(str, new Object[] { paramString1, paramString2 })));
  }
  
  private void gi(String paramString) {
    try {
      Bitmap bitmap = al.B(paramString, 300);
      this.azs.setImageBitmap(bitmap);
      return;
    } catch (WriterException paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  private void initView() {
    this.bGv = (TextView)this.mView.findViewById(R.id.tv_pay_actual);
    this.aAY = (TextView)this.mView.findViewById(R.id.title);
    this.aAY.setText(R.string.alipay_scan_qrcode);
    this.bvd = (TextView)this.mView.findViewById(R.id.tv_cancel);
    this.bGu = (ProgressBarCircularIndeterminate)this.mView.findViewById(R.id.ivPreProgress);
    this.azs = (ImageView)findViewById(R.id.iv_qrcode);
  }
  
  public void R(String paramString1, String paramString2) {
    this.bGu.setVisibility(0);
    this.azs.setVisibility(8);
    a.aKh().r(new d(this, paramString1, paramString2));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */