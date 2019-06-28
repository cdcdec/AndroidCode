package com.laiqian.print.util;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.type.usb.b.d;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

public class d {
  public static ArrayList<a> ajf() {
    ArrayList arrayList = new ArrayList();
    int i = Build.VERSION.SDK_INT;
    byte b = 0;
    if (i >= 23)
      try {
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
        while (true) {
          NetworkInterface networkInterface;
          byte[] arrayOfByte;
          if (enumeration.hasMoreElements()) {
            networkInterface = (NetworkInterface)enumeration.nextElement();
            Enumeration enumeration1 = networkInterface.getInetAddresses();
            Object object = null;
            while (true) {
              arrayOfByte = object;
              if (enumeration1.hasMoreElements()) {
                arrayOfByte = (InetAddress)enumeration1.nextElement();
                if (arrayOfByte instanceof java.net.Inet4Address) {
                  arrayOfByte = arrayOfByte.getAddress();
                  break;
                } 
                continue;
              } 
              break;
            } 
          } else {
            return arrayList;
          } 
          if (arrayOfByte == null)
            continue; 
          arrayList.add(new a(networkInterface.getName(), arrayOfByte, ((InterfaceAddress)networkInterface.getInterfaceAddresses().get(0)).getNetworkPrefixLength(), networkInterface.getHardwareAddress()));
        } 
      } catch (SocketException socketException) {
        a.e(socketException);
        return arrayList;
      }  
    String[] arrayOfString = ajg().split(System.getProperty("line.separator"));
    i = arrayOfString.length;
    while (b < i) {
      arrayList.add(a.mj(arrayOfString[b]));
      b++;
    } 
    return arrayList;
  }
  
  private static String ajg() throws IllegalStateException {
    String str = (new d()).lC("netcfg");
    if (TextUtils.isEmpty(str))
      throw new IllegalStateException("netcfg not available"); 
    return str;
  }
  
  public static a ajh() {
    for (a a : ajf()) {
      if (!a.getAddress().getHostAddress().equals("0.0.0.0") && !a.getAddress().getHostAddress().equals("127.0.0.1"))
        return a; 
    } 
    return null;
  }
  
  public static a aji() {
    for (a a : ajf()) {
      if (!a.getAddress().getHostAddress().equals("0.0.0.0") && !a.getAddress().getHostAddress().equals("127.0.0.1") && (a.getName().startsWith("wlan") || a.getName().startsWith("eth")))
        return a; 
    } 
    return null;
  }
  
  public static String cC(long paramLong) {
    String str = "";
    for (byte b = 3; b > -1; b--) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(paramLong >> b * 8 & 0xFFL);
      stringBuilder.append(".");
      str = stringBuilder.toString();
    } 
    return str.substring(0, str.length() - 1);
  }
  
  public static InetAddress je(int paramInt) {
    byte b1 = (byte)(paramInt & 0xFF);
    byte b2 = (byte)(paramInt >> 8 & 0xFF);
    byte b3 = (byte)(paramInt >> 16 & 0xFF);
    byte b4 = (byte)(paramInt >> 24 & 0xFF);
    try {
      return InetAddress.getByAddress(new byte[] { b1, b2, b3, b4 });
    } catch (UnknownHostException unknownHostException) {
      throw new AssertionError();
    } 
  }
  
  public static long mg(String paramString) {
    String[] arrayOfString = paramString.split("\\.");
    return Long.parseLong(arrayOfString[0]) * 16777216L + Long.parseLong(arrayOfString[1]) * 65536L + Long.parseLong(arrayOfString[2]) * 256L + Long.parseLong(arrayOfString[3]);
  }
  
  public static byte[] mh(String paramString) {
    int[] arrayOfInt = mi(paramString);
    return new byte[] { (byte)arrayOfInt[0], (byte)arrayOfInt[1], (byte)arrayOfInt[2], (byte)arrayOfInt[3] };
  }
  
  public static int[] mi(String paramString) {
    String[] arrayOfString = paramString.split("\\.");
    int[] arrayOfInt = new int[arrayOfString.length];
    for (byte b = 0; b < 4; b++)
      arrayOfInt[b] = Integer.parseInt(arrayOfString[b]); 
    return arrayOfInt;
  }
  
  public static class a {
    private final InetAddress address;
    
    private int cOx;
    
    private byte[] cOy;
    
    private final String name;
    
    public a(@NonNull String param1String, @NonNull byte[] param1ArrayOfByte1, int param1Int, byte[] param1ArrayOfByte2) {
      this.name = param1String;
      try {
        this.address = InetAddress.getByAddress(param1ArrayOfByte1);
        this.cOx = param1Int;
        this.cOy = param1ArrayOfByte2;
        return;
      } catch (UnknownHostException param1String) {
        a.e(param1String);
        throw new NullPointerException("addressInBytes");
      } 
    }
    
    public static a mj(@NonNull String param1String) {
      String[] arrayOfString1 = param1String.split("\\s+");
      int i = arrayOfString1[2].indexOf("/");
      String str1 = arrayOfString1[2].substring(0, i);
      String str2 = arrayOfString1[2].substring(i + 1);
      String[] arrayOfString2 = arrayOfString1[4].split(":");
      return new a(arrayOfString1[0], d.mh(str1), Integer.parseInt(str2), new byte[] { a.jd(Integer.parseInt(arrayOfString2[0], 16)), a.jd(Integer.parseInt(arrayOfString2[1], 16)), a.jd(Integer.parseInt(arrayOfString2[2], 16)), a.jd(Integer.parseInt(arrayOfString2[3], 16)), a.jd(Integer.parseInt(arrayOfString2[4], 16)), a.jd(Integer.parseInt(arrayOfString2[5], 16)) });
    }
    
    @NonNull
    public InetAddress getAddress() { return this.address; }
    
    @NonNull
    public String getName() throws IllegalStateException { return this.name; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */