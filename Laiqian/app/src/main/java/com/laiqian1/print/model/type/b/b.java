package com.laiqian.print.model.type.b;

import android.os.AsyncTask;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.a;
import com.laiqian.print.model.g;
import com.laiqian.print.model.q;
import com.laiqian.print.util.d;
import java.util.LinkedHashSet;
import java.util.Set;

public class b extends a {
  public static boolean DEBUG = true;
  
  public static int cHR = 150;
  
  public static int cHS = 1000;
  
  public static int cHT = 60;
  
  public static int cHU = 10;
  
  public static int cHV = 9100;
  
  private LinkedHashSet<Long> cHW;
  
  private AsyncTask cHX;
  
  private g cHj;
  
  static  {
  
  }
  
  public b(g paramg) {
    this.cHj = paramg;
    setStatus(1);
    this.cHW = agS();
  }
  
  private void a(Set<Long> paramSet, long paramLong1, long paramLong2) {
    while (paramLong2 >= paramLong1) {
      paramSet.add(Long.valueOf(paramLong2));
      paramLong2--;
    } 
  }
  
  private LinkedHashSet<Long> agS() {
    LinkedHashSet linkedHashSet = new LinkedHashSet();
    str2 = "192.168.1.1";
    String str4 = "192.168.1.254";
    try {
      exception = d.aji();
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    if (exception == null) {
      a(linkedHashSet, d.mg("192.168.1.1"), d.mg("192.168.1.254"));
      return linkedHashSet;
    } 
    String str5 = exception.getAddress().getHostAddress();
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("current device lan ip ");
      stringBuilder.append(exception.getAddress().getHostAddress());
      Log.i("tag", stringBuilder.toString());
    } 
    String str1 = str2;
    str3 = str4;
    if (!str5.startsWith("127")) {
      try {
        String[] arrayOfString = str5.split("\\.");
        str1 = String.format("%s.%s.%s.%s", new Object[] { arrayOfString[0], arrayOfString[1], arrayOfString[2], "2" });
        try {
          String str = String.format("%s.%s.%s.%s", new Object[] { arrayOfString[0], arrayOfString[1], arrayOfString[2], "254" });
        } catch (Exception str2) {
          String str = str2;
        } 
      } catch (Exception str3) {
        str1 = str2;
      } 
      a.e(str3);
      str3 = str4;
    } 
    long l1 = d.mg(str1);
    long l2 = d.mg(str3);
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("searching from ");
      stringBuilder.append(str1);
      stringBuilder.append(" to ");
      stringBuilder.append(str3);
      Log.i("tag", stringBuilder.toString());
    } 
    a(linkedHashSet, l1, l2);
    return linkedHashSet;
  }
  
  public void a(Set<Long> paramSet) {
    if (paramSet == null)
      return; 
    this.cHW.addAll(paramSet);
  }
  
  public void cancel() {
    if (this.cHX != null) {
      this.cHX.cancel(true);
      onCancelled();
    } 
  }
  
  public void start() {
    onStarted();
    a a1 = new a(this, this.cHW);
    this.cHX = a1;
    a1.execute(new Void[0]);
  }
  
  class b {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\model\type\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */