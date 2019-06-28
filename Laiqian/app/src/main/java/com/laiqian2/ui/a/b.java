package com.laiqian.ui.a;

import android.view.View;
import com.laiqian.db.multidatabase.d.b;

class b implements View.OnClickListener {
  b(a parama) {}
  
  public void onClick(View paramView) {
    b.Dq();
    a.a(this.dzh).clearFocus();
    this.dzh.dzd.clearFocus();
    a.b(this.dzh).set(0, this.dzh.dzd.getCurrentMinute().intValue(), this.dzh.dzd.getCurrentHour().intValue(), a.a(this.dzh).getDayOfMonth(), a.a(this.dzh).getMonth(), a.a(this.dzh).getYear());
    long l = a.b(this.dzh).normalize(false);
    String str = a.b(this.dzh).format(a.c(this.dzh));
    if (a.d(this.dzh) != null && a.d(this.dzh).a(a.e(this.dzh), str, l))
      return; 
    a.e(this.dzh).setText(str);
    a.e(this.dzh).setTag(Long.valueOf(l));
    this.dzh.cancel();
    if (a.d(this.dzh) != null)
      a.d(this.dzh).b(a.e(this.dzh), str, l); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */