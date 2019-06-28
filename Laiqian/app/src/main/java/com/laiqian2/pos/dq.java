package com.laiqian.pos;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import com.laiqian.infrastructure.R;
import com.laiqian.models.bh;
import com.laiqian.util.n;
import java.security.NoSuchAlgorithmException;

class dq implements View.OnClickListener {
  dq(do paramdo) {}
  
  public void onClick(View paramView) {
    try {
      bh bh = new bh(do.a(this.cjc));
    } catch (Exception paramView) {
      a.e(paramView);
      paramView = null;
    } 
    String str = paramView.WB();
    paramView.close();
    try {
      if (str.equals(c.cI(do.b(this.cjc).getText().toString().trim()))) {
        do.c(this.cjc).dj(true);
        this.cjc.dismiss();
        return;
      } 
      do.c(this.cjc).dj(false);
      do.b(this.cjc).requestFocus();
      do.b(this.cjc).selectAll();
      n.eP(R.string.password_error);
      return;
    } catch (NoSuchAlgorithmException paramView) {
      do.c(this.cjc).dj(false);
      do.b(this.cjc).requestFocus();
      do.b(this.cjc).selectAll();
      n.eP(R.string.password_error);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */