package com.laiqian.backup;

import android.os.Message;
import com.laiqian.sync.a.m;
import com.laiqian.util.aa;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.l;

class ae implements Runnable {
  ae(BackUpToServer paramBackUpToServer) {}
  
  public void run() {
    long l;
    null = new StringBuilder();
    null.append("BackUpToServer Thread.currentThread()");
    null.append(Thread.currentThread());
    bb.ao(null.toString());
    String str1 = (new av(this.aIz)).atm();
    if (!str1.equals("") && !str1.equals(null)) {
      l = Long.parseLong(str1);
    } else {
      l = -1L;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("/data/data/");
    stringBuilder1.append(this.aIz.getPackageName());
    stringBuilder1.append("/");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str1);
    stringBuilder3.append(".backup");
    String str3 = stringBuilder3.toString();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(str3);
    stringBuilder4.append(".lq");
    String str4 = stringBuilder4.toString();
    ag.b(this.aIz, str3, str4, str2);
    new aa(this.aIz);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(str4);
    boolean bool = aa.g(stringBuilder2.toString(), m.crm, str1, l.dj(l));
    Message message = new Message();
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    message.obj = str1;
    this.aIz.aIy.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */