package com.laiqian.login.a;

import android.os.Handler;
import android.os.Message;
import com.google.a.a.a.a.a.a;
import com.laiqian.network.a;
import com.laiqian.ui.a.r;
import com.laiqian.util.ch;
import io.reactivex.g.a;
import java.io.File;
import java.io.IOException;

class j extends Handler {
  j(b paramb) {}
  
  public void handleMessage(Message paramMessage) {
    b.a(this.aXX);
    if (paramMessage.what == 0) {
      if (ch.F(b.b(this.aXX), b.e(this.aXX))) {
        r r1 = b.c(this.aXX);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("V");
        stringBuilder1.append(b.e(this.aXX));
        stringBuilder1.append(b.b(this.aXX).getString(2131628454));
        stringBuilder1.append("\n");
        stringBuilder1.append(String.valueOf(paramMessage.obj));
        r1.s(stringBuilder1.toString());
        b.c(this.aXX).setTitle(b.b(this.aXX).getString(2131625960));
        b.f(this.aXX);
        return;
      } 
      b.c(this.aXX).setTitle(b.b(this.aXX).getString(2131628441));
      r r = b.c(this.aXX);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("V");
      stringBuilder.append(b.e(this.aXX));
      stringBuilder.append(b.b(this.aXX).getString(2131628454));
      stringBuilder.append("\n");
      stringBuilder.append(String.valueOf(paramMessage.obj));
      r.s(stringBuilder.toString());
      b.g(this.aXX);
      return;
    } 
    if (paramMessage.what == 1) {
      if (ch.G(b.b(this.aXX), b.e(this.aXX))) {
        String str = String.valueOf(paramMessage.obj);
        a.aKh().r(new k(str));
        return;
      } 
      b.h(this.aXX);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */