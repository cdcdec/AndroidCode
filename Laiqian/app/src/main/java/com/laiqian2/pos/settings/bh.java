package com.laiqian.pos.settings;

import android.widget.TextView;
import com.laiqian.ui.a.az;
import com.laiqian.util.z;

class bh implements az.a {
  bh(be parambe) {}
  
  public boolean a(TextView paramTextView, int paramInt1, int paramInt2) {
    int k;
    int j;
    int i;
    String str;
    if (paramTextView == this.cAW.cAO.getView()) {
      String str2 = ((TextView)this.cAW.cAP.getView()).getText().toString().substring(0, 2);
      String str1 = ((TextView)this.cAW.cAP.getView()).getText().toString().substring(3, 5);
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
    } else if (str == this.cAW.cAP.getView()) {
      String str2 = ((TextView)this.cAW.cAO.getView()).getText().toString().substring(0, 2);
      String str1 = ((TextView)this.cAW.cAO.getView()).getText().toString().substring(3, 5);
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
      ((TextView)this.cAW.cAR.getView()).setText(this.cAW.getContext().getString(2131630115));
      return false;
    } 
    ((TextView)this.cAW.cAR.getView()).setText(this.cAW.getContext().getString(2131630118));
    return false;
  }
  
  public void b(TextView paramTextView, int paramInt1, int paramInt2) {
    if (paramTextView == this.cAW.cAO.getView() || paramTextView == this.cAW.cAP.getView()) {
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */