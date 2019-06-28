package com.laiqian.crash.model;

import android.content.Context;
import com.laiqian.util.av;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class l {
  public String CQ() { return "/crash/"; }
  
  public String CR() { return ck("yyyy-MM-dd-HH-mm-ss"); }
  
  public String[] CS() { return new String[] { "i@91laiqian.com" }; }
  
  public String U(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(V(paramContext));
    stringBuilder.append("-shop-");
    stringBuilder.append(W(paramContext));
    stringBuilder.append("-time-");
    stringBuilder.append(CR());
    stringBuilder.append("-millis-");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(".log");
    return stringBuilder.toString();
  }
  
  public String V(Context paramContext) { return (new av(paramContext)).Ea(); }
  
  public String W(Context paramContext) { return (new av(paramContext)).Tx(); }
  
  public String X(Context paramContext) {
    m m = new m(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(m.CT());
    stringBuilder.append(CQ());
    return stringBuilder.toString();
  }
  
  public String ck(String paramString) { return (new SimpleDateFormat(paramString)).format(new Date()); }
  
  public long timestamp() { return Calendar.getInstance().getTimeInMillis(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */