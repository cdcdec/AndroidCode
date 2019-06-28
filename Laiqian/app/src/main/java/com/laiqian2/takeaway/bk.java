package com.laiqian.takeaway;

import com.laiqian.print.c.a;
import com.laiqian.print.c.d;
import com.laiqian.print.c.l;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.util.e;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;

class bk implements e.a {
  bk(bc parambc, l paraml) {}
  
  public void a(e parame, int paramInt) {
    if (parame.agu()) {
      if (paramInt == 4) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      if (paramInt == 0) {
        h.awP();
        String str = ((PrintContent)parame.ags().get(0)).lm("log_serial_number");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((PrintContent)parame.ags().get(0)).lm("log_number"));
        stringBuilder.append(" 订单号:");
        stringBuilder.append(((PrintContent)parame.ags().get(0)).lm("log_serial_number"));
        stringBuilder.append(",");
        stringBuilder.append(parame.agw());
        stringBuilder.append(",");
        stringBuilder.append(parame.aew().getTypeName());
        stringBuilder.append(",");
        stringBuilder.append(parame.aew().getName());
        stringBuilder.append("\n");
        stringBuilder.append(((PrintContent)parame.ags().get(0)).lm("log_number"));
        h.a(new d("WeiOrderWebObject", "标签异常", str, stringBuilder.toString()), h.a.dHx, h.b.dHA);
        d.bg(this.dtS.context).c(new a(parame.aew(), parame.ags()));
        e.i(new bl(this));
      } 
    } 
    this.aBb.b(parame);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */