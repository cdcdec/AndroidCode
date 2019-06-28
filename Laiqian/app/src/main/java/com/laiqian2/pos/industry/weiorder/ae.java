package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.content.Intent;
import com.laiqian.d.a;
import com.laiqian.ui.a.r;

class ae implements r.a {
  ae(ad paramad) {}
  
  public void xD() { this.ctc.csX.eZ(false); }
  
  public void xE() {
    Class clazz;
    boolean bool = "5".equals(String.valueOf(a.AZ().Bp()));
    Context context1 = this.ctc.context;
    Context context2 = this.ctc.context;
    if (bool) {
      clazz = com.laiqian.binding.BindingAlipayHelp.class;
    } else {
      clazz = com.laiqian.binding.BindingAlipayCodeHelp.class;
    } 
    context1.startActivity(new Intent(context2, clazz));
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */