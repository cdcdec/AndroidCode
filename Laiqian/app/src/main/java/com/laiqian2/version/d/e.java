package com.laiqian.version.d;

import android.content.res.Resources;
import com.laiqian.version.c.a;
import com.laiqian.version.view.ReplyActivity;

public class e {
  public String TAG = e.class.getName();
  
  private Resources dJC;
  
  private ReplyActivity dJG;
  
  private String dJb;
  
  private a dJm;
  
  public e(ReplyActivity paramReplyActivity, String paramString) {
    this.dJG = paramReplyActivity;
    this.dJC = this.dJG.axk().getResources();
    this.dJm = new a();
    this.dJb = paramString;
  }
  
  public void sn(String paramString) {
    f f = new f(this);
    this.dJm.a(f, this.dJb, paramString);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */