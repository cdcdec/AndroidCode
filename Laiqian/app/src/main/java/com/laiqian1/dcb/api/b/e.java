package com.laiqian.dcb.api.b;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.apache.http.conn.util.InetAddressUtils;

public class e {
  public static String cs(boolean paramBoolean) {
    try {
      Iterator iterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (iterator.hasNext()) {
        for (InetAddress inetAddress : Collections.list(((NetworkInterface)iterator.next()).getInetAddresses())) {
          if (!inetAddress.isLoopbackAddress()) {
            String str = inetAddress.getHostAddress().toUpperCase();
            boolean bool = InetAddressUtils.isIPv4Address(str);
            if (paramBoolean) {
              if (bool)
                return str; 
              continue;
            } 
            if (!bool) {
              int i = str.indexOf('%');
              return (i < 0) ? str : str.substring(0, i);
            } 
          } 
        } 
      } 
    } catch (Exception exception) {}
    return "";
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */