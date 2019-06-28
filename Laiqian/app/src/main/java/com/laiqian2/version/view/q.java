package com.laiqian.version.view;

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

class q extends Object implements d<h> {
  q(p paramp) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) {
    p.a(this.dKj, false);
    Toast.makeText(this.dKj.dKi, "连接失败", 0).show();
  }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      if (!paramu.aTa()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("request failed: ");
        stringBuilder1.append(paramu.aGo());
        stringBuilder1.append(" ");
        stringBuilder1.append(paramu.message());
        throw new Exception(stringBuilder1.toString());
      } 
      c c = (c)d.b(((h)paramu.aZd()).oV(), c.class);
      if (c != null) {
        if (c.dIz == 0) {
          this.dKj.dJp.mo(c.dIK.dIE);
          this.dKj.dJp.h(c.dIK.dIF, c.dIK.dIH);
          if (!p.a(this.dKj))
            this.dKj.dJp.axc(); 
        } else {
          MyEvaluationActivity myEvaluationActivity = this.dKj.dKi;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("请求失败，代号: ");
          stringBuilder1.append(c.dIz);
          Toast.makeText(myEvaluationActivity, stringBuilder1.toString(), 0).show();
        } 
      } else {
        Log.w("TopicAdapter", "VersionInfoResponse is null");
      } 
    } catch (Exception paramb) {
      a.e(paramb);
    } 
    if (this.dKj.dJp.axe() > 0) {
      this.dKj.dhV.setVisibility(0);
    } else {
      this.dKj.dhV.setVisibility(8);
    } 
    TextView textView = (TextView)this.dKj.dhV.findViewById(R.id.footerText);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("展开");
    stringBuilder.append(this.dKj.dJp.axe());
    stringBuilder.append("条回复");
    textView.setText(stringBuilder.toString());
    p.a(this.dKj, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */