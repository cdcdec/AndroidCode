package com.laiqian.takeaway.a;

import com.laiqian.print.c.a;
import com.laiqian.print.c.d;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;

class c implements e.a {
  c(b paramb, e parame) {}
  
  public void a(e parame, int paramInt) {
    if (paramInt == 5) {
      if (this.bYk.ags().size() > 0) {
        h.awP();
        String str = ((PrintContent)this.bYk.ags().get(0)).lm("log_serial_number");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((PrintContent)this.bYk.ags().get(0)).lm("log_number"));
        stringBuilder.append(" 订单号:");
        stringBuilder.append(((PrintContent)this.bYk.ags().get(0)).lm("log_serial_number"));
        stringBuilder.append(",");
        stringBuilder.append(parame.agw());
        stringBuilder.append(",");
        stringBuilder.append(parame.aew().getTypeName());
        stringBuilder.append(",");
        stringBuilder.append(parame.aew().getName());
        stringBuilder.append("\n");
        stringBuilder.append(((PrintContent)this.bYk.ags().get(0)).lm("log_number"));
        h.a(new d("ReceiptPrintTakeawayManager", "前台小票异常", str, stringBuilder.toString()), h.a.dHx, h.b.dHA);
        d.bg(b.a(this.dvl)).c(new a(this.bYk.aew(), this.bYk.ags()));
        return;
      } 
      h.awP().a(new d("ReceiptPrintTakeawayManager", "前台小票异常", ((PrintContent)this.bYk.ags().get(0)).lm("log_number"), "打印内容是空"), h.a.dHx, h.b.dHA);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */