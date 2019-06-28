package com.laiqian.e.a;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.av;
import com.laiqian.util.bd;

class c implements View.OnClickListener {
  c(a parama) {}
  
  public void onClick(View paramView) {
    String str1 = new StringBuilder();
    str1.append(a.b(this.aNx).getText().toString());
    str1.append(a.a(this.aNx).getText().toString());
    String str2 = str1.toString();
    if (a.b(this.aNx).length() == 0) {
      a.c(this.aNx).setText(2131626667);
      return;
    } 
    if (!bd.bH(a.d(this.aNx))) {
      a.c(this.aNx).setText(2131626516);
      return;
    } 
    this.aNx.De();
    if (a.e(this.aNx) == 0) {
      String str = a.d(this.aNx).getString(2131626656);
    } else {
      str1 = a.d(this.aNx).getString(2131626675);
    } 
    av av = RootApplication.getLaiqianPreferenceManager();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(av.Ea());
    stringBuilder.append("_");
    stringBuilder.append(av.auN());
    stringBuilder.append("_");
    stringBuilder.append(str1);
    stringBuilder.append("_");
    stringBuilder.append(av.Tx());
    str1 = stringBuilder.toString();
    a.f(this.aNx).cp(str1);
    a.f(this.aNx).A(str2, "report@androidcloudpos.cn");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */