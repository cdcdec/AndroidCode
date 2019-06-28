package com.laiqian.pos.settings.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.ui.a.az;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import com.laiqian.util.z;

public class ShopBusinessHoursView extends FrameLayout {
  String Ze = "hh:mm";
  
  TextView bEQ;
  
  az cAN;
  
  public TextView cCd;
  
  public TextView cCe;
  
  public TextView cCf;
  
  public TextView cCg;
  
  public TextView cCh;
  
  public View cCi;
  
  public View cCj;
  
  public ShopBusinessHoursView(@NonNull Context paramContext) { this(paramContext, null); }
  
  public ShopBusinessHoursView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public ShopBusinessHoursView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131427725, this);
    initView();
    initData();
  }
  
  private void initData() {
    this.cCh.setText(getContext().getString(2131628258));
    this.cCg.setText(getContext().getString(2131628236));
    this.cCi.setOnClickListener(new a(this));
    this.cCj.setOnClickListener(new b(this));
    cc(a.AZ().Cc());
  }
  
  private void initView() {
    this.bEQ = (TextView)getRootView().findViewById(2131297314);
    this.cCd = (TextView)getRootView().findViewById(2131297317);
    this.cCe = (TextView)getRootView().findViewById(2131297316);
    this.cCf = (TextView)getRootView().findViewById(2131297318);
    this.cCg = (TextView)getRootView().findViewById(2131297315);
    this.cCh = (TextView)getRootView().findViewById(2131297319);
    this.cCi = getRootView().findViewById(2131297309);
    this.cCj = getRootView().findViewById(2131297310);
  }
  
  public String Cc() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bEQ.getText().toString());
    stringBuilder.append("-");
    stringBuilder.append(this.cCd.getText().toString());
    return stringBuilder.toString();
  }
  
  public void cc(String paramString) {
    if (!by.isNull(paramString)) {
      String str = paramString.substring(0, paramString.indexOf("-"));
      bb.e("lStartTime", Long.valueOf(Long.valueOf(str.substring(0, str.indexOf(":"))).longValue() * 60L * 60L * 1000L + Long.valueOf(str.substring(str.indexOf(":") + 1)).longValue() * 60L * 1000L));
      paramString = paramString.substring(paramString.indexOf("-") + 1);
      bb.e("lEndTime", Long.valueOf(Long.valueOf(paramString.substring(0, paramString.indexOf(":"))).longValue() * 60L * 60L * 1000L + Long.valueOf(paramString.substring(paramString.indexOf(":") + 1)).longValue() * 60L * 1000L));
      this.bEQ.setText(str);
      this.cCd.setText(paramString);
      if (!z.q(by.parseInt(str.substring(0, str.indexOf(":"))), by.parseInt(str.substring(str.indexOf(":") + 1)), by.parseInt(paramString.substring(0, paramString.indexOf(":"))), by.parseInt(paramString.substring(paramString.indexOf(":") + 1)))) {
        this.cCf.setText(getContext().getString(2131630115));
        return;
      } 
      this.cCf.setText(getContext().getString(2131630118));
    } 
  }
  
  void f(TextView paramTextView) {
    c c = new c(this);
    this.cAN = new az(getContext(), paramTextView, this.Ze);
    this.cAN.a(c);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\view\ShopBusinessHoursView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */