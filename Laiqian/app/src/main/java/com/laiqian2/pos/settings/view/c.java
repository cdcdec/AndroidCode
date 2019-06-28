package com.laiqian.pos.settings.view;

import android.widget.TextView;
import com.laiqian.ui.a.az;
import com.laiqian.util.z;

class c implements az.a {
  c(ShopBusinessHoursView paramShopBusinessHoursView) {}
  
  public boolean a(TextView paramTextView, int paramInt1, int paramInt2) {
    int k;
    int j;
    int i;
    String str;
    if (paramTextView == this.cCk.bEQ) {
      String str2 = this.cCk.cCd.getText().toString().substring(0, 2);
      String str1 = this.cCk.cCd.getText().toString().substring(3, 5);
      str = str2;
      if (str2.indexOf("0") == 0)
        str = str2.substring(1, 2); 
      i = Integer.parseInt(str);
      str = str1;
      if (str1.indexOf("0") == 0)
        str = str1.substring(1, 2); 
      k = Integer.parseInt(str);
      j = paramInt1;
      paramInt1 = k;
      k = paramInt2;
    } else if (str == this.cCk.cCd) {
      String str2 = this.cCk.bEQ.getText().toString().substring(0, 2);
      String str1 = this.cCk.bEQ.getText().toString().substring(3, 5);
      str = str2;
      if (str2.indexOf("0") == 0)
        str = str2.substring(1, 2); 
      j = Integer.parseInt(str);
      str = str1;
      if (str1.indexOf("0") == 0)
        str = str1.substring(1, 2); 
      k = Integer.parseInt(str);
      i = paramInt1;
      paramInt1 = paramInt2;
    } else {
      return false;
    } 
    if (!z.q(j, k, i, paramInt1)) {
      this.cCk.cCf.setText(this.cCk.getContext().getString(2131630115));
      return false;
    } 
    this.cCk.cCf.setText(this.cCk.getContext().getString(2131630118));
    return false;
  }
  
  public void b(TextView paramTextView, int paramInt1, int paramInt2) {
    if (paramTextView == this.cCk.bEQ || paramTextView == this.cCk.cCd) {
      StringBuilder stringBuilder1;
      if (paramInt1 < 10) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(paramInt1);
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt1);
        stringBuilder1.append("");
      } 
      String str2 = stringBuilder1.toString();
      if (paramInt2 < 10) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(paramInt2);
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt2);
        stringBuilder1.append("");
      } 
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append(":");
      stringBuilder2.append(str1);
      paramTextView.setText(stringBuilder2.toString());
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */