package com.laiqian.login.a;

import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.util.by;

class g extends Handler {
  g(b paramb) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1)
      return; 
    b.a(this.aXX);
    b.c(this.aXX).setTitle(b.b(this.aXX).getString(2131628299));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.b(this.aXX).getString(2131628300));
    stringBuilder.append(CrashApplication.getLaiqianPreferenceManager().avw());
    SpannableString spannableString = by.b(stringBuilder.toString(), b.b(this.aXX).getString(2131628300), 20, b.b(this.aXX).getResources().getColor(2131099898));
    b.c(this.aXX).s(spannableString);
    b.d(this.aXX);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */