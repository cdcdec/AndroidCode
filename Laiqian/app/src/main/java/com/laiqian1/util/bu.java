package com.laiqian.util;

import android.support.annotation.Nullable;
import com.laiqian.basic.LQKVersion;
import com.laiqian.util.logger.a;
import java.util.ArrayList;

public class bu {
  public static final bu dGr;
  
  @Nullable
  private a aOV = null;
  
  private ArrayList<Long> dGs = new ArrayList();
  
  private long startTime = 0L;
  
  static  {
    a a1;
    if (LQKVersion.zg()) {
      a1 = new a(bu.class.getSimpleName());
    } else {
      a1 = null;
    } 
    dGr = new bu(a1);
  }
  
  public bu() { this(null); }
  
  public bu(@Nullable a parama) { this.aOV = parama; }
  
  private void awt() {
    this.startTime = 0L;
    this.dGs.clear();
  }
  
  private long awu() { return (this.startTime == 0L) ? 0L : (System.currentTimeMillis() - this.startTime); }
  
  public void rY(@Nullable String paramString) {
    this.startTime = System.currentTimeMillis();
    if (this.aOV != null) {
      a a1 = this.aOV;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start. ");
      String str = paramString;
      if (paramString == null)
        str = ""; 
      stringBuilder.append(str);
      a1.d(stringBuilder.toString(), new Object[0]);
    } 
  }
  
  public long rZ(String paramString) {
    long l = awu();
    if (this.aOV != null) {
      a a1 = this.aOV;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stop, time is %d. ");
      String str = paramString;
      if (paramString == null)
        str = ""; 
      stringBuilder.append(str);
      a1.d(stringBuilder.toString(), new Object[] { Long.valueOf(l) });
    } 
    awt();
    return l;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */