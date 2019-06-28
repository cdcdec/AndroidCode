package com.laiqian.report.ui;

import android.os.Message;
import com.laiqian.util.n;

class bf extends Thread {
  bf(ReportRoot paramReportRoot) {}
  
  public void run() {
    this.dgN.dfY = getName();
    super.run();
    double[] arrayOfDouble = this.dgN.dfV.amw();
    if (getName().equals(this.dgN.dfY)) {
      Message message = new Message();
      message.what = 30;
      message.obj = arrayOfDouble;
      this.dgN.handler.sendMessage(message);
      return;
    } 
    n.println("查询顶部总金额的时候，被覆盖了。");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */