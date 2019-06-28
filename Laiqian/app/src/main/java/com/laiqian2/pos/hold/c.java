package com.laiqian.pos.hold;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.pos.model.a;
import com.laiqian.ui.a.r;

class c implements View.OnClickListener {
  c(a parama) {}
  
  public void onClick(View paramView) {
    str = a.a(this.cnm).getText().toString().trim();
    boolean bool = a.b(this.cnm).isChecked();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(a.c(this.cnm), a.d(this.cnm).getString(2131626473), 0).show();
      return;
    } 
    try {
      r r;
      if (a.e(this.cnm) != null && a.e(this.cnm).equals(str) && a.f(this.cnm) == bool) {
        this.cnm.dismiss();
        return;
      } 
      a a1 = new a(a.g(this.cnm));
      boolean bool1 = a1.ku(str);
      a1.close();
      a.a(this.cnm, a.h(this.cnm).getText().toString().trim());
      if (bool1 && (a.e(this.cnm) == null || !a.e(this.cnm).equals(str) || a.f(this.cnm) == bool)) {
        if (!a.i(this.cnm)) {
          Toast.makeText(a.j(this.cnm), a.k(this.cnm).getString(2131626770), 0).show();
          return;
        } 
        r = new r(this.cnm.getContext(), new d(this, str, bool));
        r.s(this.cnm.getContext().getString(2131625072));
        r.show();
        return;
      } 
      this.cnm.cnl.b(r, bool, a.l(this.cnm));
      this.cnm.dismiss();
      return;
    } catch (NumberFormatException str) {
      a.e(str);
      this.cnm.dismiss();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */