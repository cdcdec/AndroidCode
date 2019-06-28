package com.laiqian.print.type.net.a;

import android.content.Context;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import com.laiqian.util.bd;

public class b extends a {
  String abu;
  
  Context context;
  
  public b(Context paramContext, String paramString) {
    super(paramContext.getString(R.string.diagnose_net_printer_ip_title));
    this.abu = paramString;
    this.context = paramContext;
  }
  
  public void run() {
    onStart();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.context.getString(R.string.diagnose_net_printer_ip_1));
    stringBuilder.append(this.abu);
    la(stringBuilder.toString());
    if (!bd.rQ(this.abu)) {
      la(this.context.getString(R.string.diagnose_net_printer_ip_1_failed));
      afv();
      return;
    } 
    la(this.context.getString(R.string.diagnose_state_pass));
    la(this.context.getString(R.string.diagnose_net_printer_ip_2));
    if (!bd.rP(this.abu)) {
      la(this.context.getString(R.string.diagnose_net_printer_ip_2_failed));
      afv();
      return;
    } 
    la(this.context.getString(R.string.diagnose_state_pass));
    afu();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */