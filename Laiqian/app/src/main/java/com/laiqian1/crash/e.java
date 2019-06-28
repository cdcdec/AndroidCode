package com.laiqian.crash;

import android.app.ProgressDialog;
import com.laiqian.crash.model.n;
import com.laiqian.ui.a.r;
import com.laiqian.util.z;
import java.util.HashMap;

class e implements r.a {
  e(d paramd) {}
  
  public void xD() {}
  
  public void xE() {
    ProgressDialog progressDialog = new ProgressDialog(CrashList.a.a(this.aMJ.aMI));
    progressDialog.setTitle(CrashList.a.a(this.aMJ.aMI).getResources().getString(2131624886));
    progressDialog.setMessage(CrashList.a.a(this.aMJ.aMI).getResources().getString(2131624885));
    progressDialog.show();
    f f = new f(this);
    (new n(CrashList.a.a(this.aMJ.aMI), f, (String)((HashMap)CrashList.a.b(this.aMJ.aMI).get(this.aMJ.qI)).get("e_savepath"), z.pA((String)((HashMap)CrashList.a.b(this.aMJ.aMI).get(this.aMJ.qI)).get("e_crashtime")))).start();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */