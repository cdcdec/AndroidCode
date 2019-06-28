package com.laiqian.print.type.net.a;

import android.content.Context;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import com.laiqian.util.bd;

public class e extends a {
  String abu;
  
  Context context;
  
  public e(Context paramContext, String paramString) {
    super(stringBuilder.toString());
    this.context = paramContext;
    this.abu = paramString;
  }
  
  public void run() {
    onStart();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ping ");
    stringBuilder.append(this.abu);
    la(stringBuilder.toString());
    if (bd.F(this.abu, 5)) {
      la(this.context.getString(R.string.diagnose_state_pass));
      afu();
      return;
    } 
    la(this.context.getString(R.string.diagnose_net_printer_ping_1_failed));
    afv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */