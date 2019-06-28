package com.laiqian.pos.settings;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.ui.a.az;
import com.laiqian.ui.container.ab;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import com.laiqian.util.z;

public class be extends ab<ViewGroup> {
  String Ze = "hh:mm";
  
  az cAN;
  
  public ab<TextView> cAO = new ab(2131297314);
  
  public ab<TextView> cAP = new ab(2131297317);
  
  public ab<TextView> cAQ = new ab(2131297316);
  
  public ab<TextView> cAR = new ab(2131297318);
  
  public ab<TextView> cAS = new ab(2131297319);
  
  public ab<TextView> cAT = new ab(2131297315);
  
  public ab<View> cAU = new ab(2131297309);
  
  public ab<View> cAV = new ab(2131297310);
  
  public be(int paramInt) { super(paramInt); }
  
  public String Cc() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(((TextView)this.cAO.getView()).getText().toString());
    stringBuilder.append("-");
    stringBuilder.append(((TextView)this.cAP.getView()).getText().toString());
    return stringBuilder.toString();
  }
  
  public void S(View paramView) {
    super.S(paramView);
    ((TextView)this.cAT.getView()).setText(getContext().getString(2131628236));
    ((TextView)this.cAS.getView()).setText(getContext().getString(2131628258));
    this.cAU.getView().setOnClickListener(new bf(this));
    this.cAV.getView().setOnClickListener(new bg(this));
    cc(a.AZ().Cc());
  }
  
  public void cc(String paramString) {
    if (!by.isNull(paramString)) {
      String str = paramString.substring(0, paramString.indexOf("-"));
      bb.e("lStartTime", Long.valueOf(Long.valueOf(str.substring(0, str.indexOf(":"))).longValue() * 60L * 60L * 1000L + Long.valueOf(str.substring(str.indexOf(":") + 1)).longValue() * 60L * 1000L));
      paramString = paramString.substring(paramString.indexOf("-") + 1);
      bb.e("lEndTime", Long.valueOf(Long.valueOf(paramString.substring(0, paramString.indexOf(":"))).longValue() * 60L * 60L * 1000L + Long.valueOf(paramString.substring(paramString.indexOf(":") + 1)).longValue() * 60L * 1000L));
      ((TextView)this.cAO.getView()).setText(str);
      ((TextView)this.cAP.getView()).setText(paramString);
      if (!z.q(by.parseInt(str.substring(0, str.indexOf(":"))), by.parseInt(str.substring(str.indexOf(":") + 1)), by.parseInt(paramString.substring(0, paramString.indexOf(":"))), by.parseInt(paramString.substring(paramString.indexOf(":") + 1)))) {
        ((TextView)this.cAR.getView()).setText(getContext().getString(2131630115));
        return;
      } 
      ((TextView)this.cAR.getView()).setText(getContext().getString(2131630118));
    } 
  }
  
  void f(TextView paramTextView) {
    bh bh = new bh(this);
    this.cAN = new az(getContext(), paramTextView, this.Ze);
    this.cAN.a(bh);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */