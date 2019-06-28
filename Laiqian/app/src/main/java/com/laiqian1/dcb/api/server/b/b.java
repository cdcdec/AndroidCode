package com.laiqian.dcb.api.server.b;

import io.netty.channel.as;
import io.netty.channel.at;
import io.netty.e.b.ae;
import io.netty.e.b.v;
import java.io.PrintStream;

class b implements at {
  b(a parama) {}
  
  public void a(as paramas) {
    PrintStream printStream = System.err;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramas.aDb());
    stringBuilder.append(" Transfer complete.");
    printStream.println(stringBuilder.toString());
  }
  
  public void a(as paramas, long paramLong1, long paramLong2) {
    if (paramLong2 < 0L) {
      PrintStream printStream1 = System.err;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramas.aDb());
      stringBuilder1.append(" Transfer progress: ");
      stringBuilder1.append(paramLong1);
      printStream1.println(stringBuilder1.toString());
      return;
    } 
    PrintStream printStream = System.err;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramas.aDb());
    stringBuilder.append(" Transfer progress: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" / ");
    stringBuilder.append(paramLong2);
    printStream.println(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */