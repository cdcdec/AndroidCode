package com.laiqian.member;

import android.widget.TextView;
import com.laiqian.util.by;

class w implements Runnable {
  w(v paramv, Double[] paramArrayOfDouble) {}
  
  public void run() {
    TextView textView = MemberInfoActivity.b(this.buw.buu);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.buv[0]);
    stringBuilder.append("");
    textView.setText(by.a(by.sd(stringBuilder.toString()), 9999, this.buw.buu));
    textView = MemberInfoActivity.c(this.buw.buu);
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.buv[1]);
    stringBuilder.append("");
    textView.setText(by.a(by.sd(stringBuilder.toString()), 9999, this.buw.buu));
    textView = MemberInfoActivity.d(this.buw.buu);
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.buv[2]);
    stringBuilder.append("");
    textView.setText(by.a(by.sd(stringBuilder.toString()), 9999, this.buw.buu));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */