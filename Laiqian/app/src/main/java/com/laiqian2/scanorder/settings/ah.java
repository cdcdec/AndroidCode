package com.laiqian.scanorder.settings;

import android.content.Context;
import android.content.Intent;
import com.laiqian.d.a;
import com.laiqian.ui.a.r;

class ah implements r.a {
  ah(ag paramag) {}
  
  public void xD() { this.djq.djn.eZ(false); }
  
  public void xE() {
    Class clazz;
    boolean bool = "5".equals(String.valueOf(a.AZ().Bp()));
    Context context1 = this.djq.context;
    Context context2 = this.djq.context;
    if (bool) {
      clazz = com.laiqian.binding.BindingAlipayHelp.class;
    } else {
      clazz = com.laiqian.binding.BindingAlipayCodeHelp.class;
    } 
    context1.startActivity(new Intent(context2, clazz));
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */