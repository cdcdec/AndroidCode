package com.laiqian.member.setting.sms.b;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.member.setting.sms.j;
import com.laiqian.util.by;
import com.laiqian.vip.R;
import java.util.List;

public class a {
  public TextView bHd;
  
  public TextView bHe;
  
  public TextView bHf;
  
  public TextView bHg;
  
  public ImageView bHh;
  
  private View bHi;
  
  private Context mContext;
  
  private int qL;
  
  public a(View paramView, Context paramContext) {
    this.mContext = paramContext;
    this.bHi = paramView;
    initView();
  }
  
  private void initView() {
    this.bHd = (TextView)this.bHi.findViewById(R.id.tv_discount_msg);
    this.bHe = (TextView)this.bHi.findViewById(R.id.tv_discount);
    this.bHf = (TextView)this.bHi.findViewById(R.id.tv_now_price);
    this.bHg = (TextView)this.bHi.findViewById(R.id.tv_old_price);
    this.bHh = (ImageView)this.bHi.findViewById(R.id.iv_package_description);
  }
  
  public void f(List<j> paramList, int paramInt) {
    this.qL = paramInt;
    j j = (j)paramList.get(paramInt);
    String str2 = this.mContext.getResources().getString(R.string.vip_sms_qty);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(j.quantity);
    stringBuilder.append("");
    str2 = String.format(str2, new Object[] { stringBuilder.toString() });
    stringBuilder = new StringBuilder();
    stringBuilder.append(j.quantity);
    stringBuilder.append("");
    SpannableString spannableString1 = by.b(str2, stringBuilder.toString(), 16, this.mContext.getResources().getColor(R.color.red_color_10500));
    this.bHd.setText(spannableString1);
    String str1 = this.mContext.getResources().getString(R.string.vip_sms_discount);
    stringBuilder = new StringBuilder();
    stringBuilder.append(j.bGI);
    stringBuilder.append("");
    str1 = String.format(str1, new Object[] { stringBuilder.toString() });
    this.bHe.setText(str1);
    str1 = String.format(this.mContext.getResources().getString(R.string.vip_sms_package_price), new Object[] { Integer.valueOf(j.price) });
    this.bHf.setText(str1);
    str1 = this.mContext.getResources().getString(R.string.vip_sms_old_price);
    stringBuilder = new StringBuilder();
    stringBuilder.append(j.bGH);
    stringBuilder.append("");
    str1 = String.format(str1, new Object[] { stringBuilder.toString() });
    SpannableString spannableString2 = new SpannableString(str1);
    spannableString2.setSpan(new StyleSpan(false), 0, str1.length(), 33);
    spannableString2.setSpan(new StrikethroughSpan(), 0, str1.length(), 33);
    spannableString2.setSpan(new AbsoluteSizeSpan(13, true), 0, str1.length(), 33);
    this.bHg.setText(spannableString2);
    if (j.bGJ > 0) {
      this.bHh.setImageResource(j.bGJ);
      return;
    } 
    this.bHh.setVisibility(4);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener) {
    if (paramOnClickListener == null)
      return; 
    this.bHi.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */