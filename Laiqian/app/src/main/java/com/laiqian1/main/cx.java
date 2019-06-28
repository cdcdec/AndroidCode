package com.laiqian.main;

import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;

class cx extends Handler {
  cx(cs paramcs) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1) {
      cs.d d;
      if (i != 11) {
        if (i != 21) {
          if (i != 99) {
            if (i != 231)
              return; 
            cs.m(this.bde).setText((d = (cs.d)paramMessage.obj).c(d));
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(cs.d.b(d));
            stringBuilder3.append("");
            String str2 = stringBuilder3.toString();
            String str3 = cs.n(this.bde).getString(2131627350, new Object[] { str2 });
            i = str3.indexOf(str2);
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(new ForegroundColorSpan(cs.o(this.bde).getResources().getColor(2131099874)), i, str2.length() + i, 33);
            cs.p(this.bde).setText(spannableString);
            int j = (int)(cs.q(this.bde) / cs.d.d(d));
            if (j < cs.d.a(d)) {
              i = cs.d.a(d);
            } else {
              i = j;
              if (j > cs.d.b(d))
                i = cs.d.b(d); 
            } 
            cs.c(this.bde).setText(String.valueOf(i));
            cs.r(this.bde).setText(cs.d.f(d));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(RootApplication.zA());
            stringBuilder2.append(n.a(Double.valueOf(cs.d.d(d)), true, true));
            String str1;
            cs.s(this.bde).setText((str1 = stringBuilder2.toString()).valueOf(cs.s(this.bde).getTag()));
            cs.s(this.bde).append(str1);
            cs.t(this.bde).setText(String.valueOf(cs.t(this.bde).getTag()));
            cs.t(this.bde).append(cs.d.g(d));
            cs.b(this.bde).setTag(d);
            cs.b(this.bde).setVisibility(0);
            cs.u(this.bde).setVisibility(8);
            cs.v(this.bde).setVisibility(8);
            return;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(d.obj);
          stringBuilder1.append("");
          n.o(stringBuilder1.toString());
          return;
        } 
        cs.l(this.bde).cancel();
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d.obj);
      stringBuilder.append("");
      n.o(stringBuilder.toString());
      cs.j(this.bde);
      cs.k(this.bde).LD();
      if (cs.i(this.bde).isEmpty()) {
        this.bde.cancel();
        return;
      } 
    } else {
      cs.j(this.bde);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */