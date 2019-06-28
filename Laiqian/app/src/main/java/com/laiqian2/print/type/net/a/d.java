package com.laiqian.print.type.net.a;

import android.content.Context;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import com.laiqian.util.bd;

public class d extends a {
  Context context;
  
  public d(Context paramContext) {
    super(paramContext.getString(R.string.diagnose_net_printer_gateway_title));
    this.context = paramContext;
  }
  
  public void run() {
    onStart();
    String str = bd.bY(this.context);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.context.getString(R.string.diagnose_net_printer_gateway_1));
    stringBuilder.append(str);
    la(stringBuilder.toString());
    if (bd.F(str, 5)) {
      la(this.context.getString(R.string.diagnose_state_pass));
      afu();
      return;
    } 
    la(this.context.getString(R.string.diagnose_net_printer_gateway_1_failed));
    afv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */