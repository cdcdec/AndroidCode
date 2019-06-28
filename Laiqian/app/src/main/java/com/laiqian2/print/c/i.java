package com.laiqian.print.c;

import android.widget.Toast;
import com.laiqian.print.model.e;
import com.laiqian.print.model.s;
import com.laiqian.print.model.type.b.c;
import com.laiqian.print.usage.c;

class i implements Runnable {
  i(h paramh, int paramInt, e parame) {}
  
  public void run() {
    if (this.cJd == 4) {
      f.a(this.cJe.cJc).bq(this.cJe.qI, 1);
    } else {
      s s = this.bYk.aew();
      if (s.getType() == 1) {
        f.c(this.cJe.cJc).setText(f.b(this.cJe.cJc).getString(2131625443));
      } else if (s.getType() == 2) {
        if (c.bi(f.b(this.cJe.cJc)).ahX().size() > 1) {
          c c = (c)s;
          Toast toast = f.c(this.cJe.cJc);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(f.b(this.cJe.cJc).getString(2131625439));
          stringBuilder.append(String.format("(IP:%s)", new Object[] { c.getAddress() }));
          toast.setText(stringBuilder.toString());
        } else {
          f.c(this.cJe.cJc).setText(f.b(this.cJe.cJc).getString(2131625439));
        } 
      } else {
        f.c(this.cJe.cJc).setText(f.b(this.cJe.cJc).getString(2131628915));
      } 
      f.c(this.cJe.cJc).show();
      f.a(this.cJe.cJc).bq(this.cJe.qI, 0);
    } 
    f.d(this.cJe.cJc).notifyDataSetChanged();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */