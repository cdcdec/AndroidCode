package com.laiqian;

import android.os.Message;
import android.view.View;

class l implements View.OnClickListener {
  l(k paramk) {}
  
  public void onClick(View paramView) {
    if (k.a(this.azG) != null && !k.a(this.azG).isFinishing())
      this.azG.dismiss(); 
    Message message = new Message();
    message.what = 3;
    k.b(this.azG).sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */