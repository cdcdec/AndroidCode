package com.laiqian.ordertool;

import android.content.Context;
import com.laiqian.dcb.api.b.d;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.dcb.api.server.a;
import com.laiqian.util.am;
import java.io.File;

public class d {
  public d(Context paramContext) {
    d.aPU = true;
    a a = new a();
    a.cC(ServerGet.class.getName());
    a.cr(true);
    am.a(new File(a.DR()), false);
    ServerService.ae(paramContext);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\ordertool\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */