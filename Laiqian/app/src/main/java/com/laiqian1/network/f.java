package com.laiqian.network;

import b.ae;
import b.aj;
import b.x;
import com.laiqian.util.logger.h;
import java.io.IOException;

public class f implements x {
  public aj a(x.a parama) throws IOException {
    long l1 = System.currentTimeMillis();
    ae ae = parama.aSt();
    aj aj = parama.b(ae);
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("received ");
    stringBuilder.append(aj);
    stringBuilder.append(" for ");
    stringBuilder.append(ae);
    stringBuilder.append(", took ");
    stringBuilder.append(l2 - l1);
    stringBuilder.append("ms");
    h.bD(stringBuilder.toString(), "network_request");
    return aj;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\network\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */