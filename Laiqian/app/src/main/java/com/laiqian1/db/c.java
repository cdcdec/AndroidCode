package com.laiqian.db;

import android.content.Context;
import com.laiqian.util.bb;
import java.io.File;

class c implements Runnable {
  c(b paramb, Context paramContext) {}
  
  public void run() {
    null = new StringBuilder();
    null.append("/data/data/");
    null.append(this.aOf.getPackageName());
    null.append("/");
    File[] arrayOfFile = (new File(null.toString())).listFiles();
    for (byte b1 = 0; b1 < arrayOfFile.length; b1++) {
      if (arrayOfFile[b1].isFile()) {
        String str = arrayOfFile[b1].getName();
        if (str.indexOf("download") >= 0) {
          arrayOfFile[b1].delete();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("deleted: ");
          stringBuilder.append(str);
          bb.f("laiqiankuai_network", stringBuilder.toString());
        } 
        if (str.indexOf("upload") >= 0) {
          arrayOfFile[b1].delete();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("deleted: ");
          stringBuilder.append(str);
          bb.e("laiqiankuai_network", stringBuilder.toString());
        } 
        if (str.indexOf(".lq") >= 0) {
          arrayOfFile[b1].delete();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("deleted: ");
          stringBuilder.append(str);
          bb.e("laiqiankuai_network", stringBuilder.toString());
        } 
        if (str.indexOf(".zip") >= 0) {
          arrayOfFile[b1].delete();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("deleted: ");
          stringBuilder.append(str);
          bb.e("laiqiankuai_network", stringBuilder.toString());
        } 
        if (str.indexOf("splited") >= 0) {
          arrayOfFile[b1].delete();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("deleted: ");
          stringBuilder.append(str);
          bb.e("laiqiankuai_network", stringBuilder.toString());
        } 
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */