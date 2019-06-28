package com.laiqian.backup;

import android.os.Message;
import android.view.View;
import com.laiqian.util.p;
import io.reactivex.g.a;

class n implements View.OnClickListener {
  n(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void onClick(View paramView) {
    if (p.py(this.aHq.aGK) < 1024.0D) {
      o o = new o(this);
      a.aKh().r(o);
      return;
    } 
    Message message = new Message();
    message.what = 1;
    this.aHq.aHo.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */