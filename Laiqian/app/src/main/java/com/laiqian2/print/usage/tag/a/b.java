package com.laiqian.print.usage.tag.a;

import android.content.Context;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;

public class b {
  private static b cOe;
  
  private g cDD;
  
  private c cDE;
  
  private Context mContext;
  
  private b(Context paramContext) {
    this.mContext = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  public static b br(Context paramContext) {
    if (cOe == null)
      cOe = new b(paramContext.getApplicationContext()); 
    return cOe;
  }
  
  public c aiS() { return d.bj(this.mContext).aee(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\tag\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */