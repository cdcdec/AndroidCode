package com.laiqian.version.b;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.laiqian.infrastructure.R;
import com.laiqian.network.h;
import com.laiqian.version.a.b.c;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class f extends Object implements d<h> {
  f(e parame) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) {
    e.a(this.dJt, false);
    Toast.makeText(d.a(this.dJt.dJs), "连接失败", 0).show();
  }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      if (!paramu.aTa()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("request failed: ");
        stringBuilder.append(paramu.aGo());
        stringBuilder.append(" ");
        stringBuilder.append(paramu.message());
        throw new Exception(stringBuilder.toString());
      } 
      c c = (c)d.b(((h)paramu.aZd()).oV(), c.class);
      if (c != null) {
        if (c.dIz == 0) {
          this.dJt.dJp.mo(c.dIK.dIE);
          this.dJt.dJp.h(c.dIK.dIF, c.dIK.dIH);
          if (!e.a(this.dJt))
            this.dJt.dJp.axc(); 
        } else {
          Context context = d.a(this.dJt.dJs);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("请求失败，代号: ");
          stringBuilder.append(c.dIz);
          Toast.makeText(context, stringBuilder.toString(), 0).show();
        } 
      } else {
        Log.w("TopicAdapter", "VersionInfoResponse is null");
      } 
    } catch (Exception paramb) {
      a.e(paramb);
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("rest: ");
    stringBuilder1.append(this.dJt.dJp.axe());
    Log.e("kkkkk", stringBuilder1.toString());
    if (this.dJt.dJp.axe() > 0) {
      this.dJt.dhV.setVisibility(0);
    } else {
      this.dJt.dhV.setVisibility(8);
    } 
    TextView textView = (TextView)this.dJt.dhV.findViewById(R.id.footerText);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("展开");
    stringBuilder2.append(this.dJt.dJp.axe());
    stringBuilder2.append("条回复");
    textView.setText(stringBuilder2.toString());
    this.dJt.dJs.mp(this.dJt.qI);
    e.a(this.dJt, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */