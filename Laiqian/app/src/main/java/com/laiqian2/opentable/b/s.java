package com.laiqian.opentable.b;

import android.content.Intent;
import android.view.View;
import com.laiqian.ui.a.w;

class s implements View.OnClickListener {
  s(r paramr, Class paramClass) {}
  
  public void onClick(View paramView) {
    if (r.a(this.ccW)) {
      Intent intent = new Intent(r.b(this.ccW), this.aye);
      intent.putExtra("tableID", Long.valueOf(r.c(this.ccW)));
      r.d(this.ccW).startActivity(intent);
      return;
    } 
    r.e(this.ccW).requestFocus();
    if (r.f(this.ccW) != null) {
      r.a(this.ccW, new w(r.g(this.ccW), r.f(this.ccW), new t(this)));
      r.k(this.ccW).gn(r.j(this.ccW));
      r.k(this.ccW).show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */