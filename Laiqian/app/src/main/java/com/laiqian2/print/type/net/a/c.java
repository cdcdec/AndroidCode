package com.laiqian.print.type.net.a;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class c extends a {
  String abu;
  
  Context context;
  
  public c(Context paramContext, String paramString) {
    super(paramContext.getString(R.string.diagnose_net_printer_port_title));
    this.context = paramContext;
    this.abu = paramString;
  }
  
  public void run() {
    onStart();
    null = new StringBuilder();
    null.append(this.context.getString(R.string.diagnose_net_printer_port_1));
    null.append(this.abu);
    null.append(":9100");
    la(null.toString());
    socket = new Socket();
    try {
      socket.connect(new InetSocketAddress(this.abu, '⎌'), 1000);
      la(this.context.getString(R.string.diagnose_state_pass));
      la(this.context.getString(R.string.diagnose_net_printer_port_2));
      if (socket.isConnected())
        try {
          OutputStream outputStream = socket.getOutputStream();
          outputStream.write("hello printer\n".getBytes());
          outputStream.flush();
          outputStream.close();
          socket.close();
          la(this.context.getString(R.string.diagnose_state_pass));
        } catch (IOException socket) {
          a.e(socket);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("error ");
          stringBuilder.append(socket.getMessage());
          la(stringBuilder.toString());
          la(this.context.getString(R.string.diagnose_net_printer_port_2_failed));
          afv();
          return;
        }  
      afu();
      return;
    } catch (IOException socket) {
      a.e(socket);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error ");
      stringBuilder.append(socket.getMessage());
      la(stringBuilder.toString());
      la(this.context.getString(R.string.diagnose_net_printer_port_1_failed));
      afv();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */