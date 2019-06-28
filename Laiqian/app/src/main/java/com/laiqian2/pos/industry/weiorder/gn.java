package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.a.r;

class gn implements r.a {
  gn(gm paramgm) {}
  
  public void xD() { this.cwZ.cwX.cJ(false); }
  
  public void xE() {
    if (RootApplication.getLaiqianPreferenceManager().avM()) {
      this.cwZ.context.startActivity(new Intent(this.cwZ.context, com.laiqian.binding.BindingWechatHelp.class));
      return;
    } 
    Toast.makeText(this.cwZ.context, this.cwZ.context.getString(2131627144), 0).show();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */