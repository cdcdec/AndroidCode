package com.laiqian.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class r extends SSLSocketFactory {
  private static final String[] bUv = { "TLSv1.2" };
  
  final SSLSocketFactory bUw;
  
  public r(SSLSocketFactory paramSSLSocketFactory) { this.bUw = paramSSLSocketFactory; }
  
  private Socket a(Socket paramSocket) {
    if (paramSocket instanceof SSLSocket)
      ((SSLSocket)paramSocket).setEnabledProtocols(bUv); 
    return paramSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException, UnknownHostException { return a(this.bUw.createSocket(paramString, paramInt)); }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException, UnknownHostException { return a(this.bUw.createSocket(paramString, paramInt1, paramInetAddress, paramInt2)); }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException { return a(this.bUw.createSocket(paramInetAddress, paramInt)); }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException { return a(this.bUw.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2)); }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException { return a(this.bUw.createSocket(paramSocket, paramString, paramInt, paramBoolean)); }
  
  public String[] getDefaultCipherSuites() { return this.bUw.getDefaultCipherSuites(); }
  
  public String[] getSupportedCipherSuites() { return this.bUw.getSupportedCipherSuites(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */