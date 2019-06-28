package com.laiqian.report.ui;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.n;

class au extends Handler {
  au(ReportRoot paramReportRoot) {}
  
  private void aot() {
    if (this.dgN.dgi != null && this.dgN.dgj != null) {
      this.dgN.dgi.setVisibility(0);
      this.dgN.dgj.setVisibility(4);
    } 
  }
  
  public void handleMessage(Message paramMessage) {
    double[] arrayOfDouble;
    int i = paramMessage.what;
    if (i != 10) {
      if (i != 30) {
        if (i != 981) {
          if (i != 1234) {
            switch (i) {
              default:
                this.dgN.f(paramMessage);
                return;
              case 99:
                n.w(this.dgN, 2131627422);
                aot();
                return;
              case 98:
                n.a(this.dgN, "打印时，未llReport_hint知错误");
                aot();
                return;
              case 97:
                break;
            } 
            n.w(this.dgN, 2131627420);
            aot();
            return;
          } 
          this.dgN.bvO.cancel();
          if (paramMessage.obj == null) {
            if (paramMessage.arg1 == 2) {
              n.w(this.dgN, 2131627852);
            } else {
              n.w(this.dgN, 2131627880);
            } 
            if (ReportRoot.b(this.dgN) != null)
              ReportRoot.b(this.dgN).dismiss(); 
            ReportRoot.c(this.dgN).cancel();
            return;
          } 
          if (paramMessage.arg1 == 2) {
            ReportRoot.d(this.dgN).setText(String.valueOf(paramMessage.obj));
            return;
          } 
          ReportRoot reportRoot = this.dgN;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramMessage.obj);
          stringBuilder.append("");
          n.a(reportRoot, stringBuilder.toString());
          return;
        } 
        aot();
        return;
      } 
      arrayOfDouble = (double[])paramMessage.obj;
      this.dgN.b(arrayOfDouble);
      return;
    } 
    ReportRoot.a(this.dgN, arrayOfDouble);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */