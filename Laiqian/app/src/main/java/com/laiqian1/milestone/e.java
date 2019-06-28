package com.laiqian.milestone;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.notification.PushService;
import com.laiqian.report.models.a;
import com.laiqian.util.av;
import com.laiqian.util.bb;

class e extends Handler {
  e(StartScreen paramStartScreen) {}
  
  public void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    Message message;
    TextView textView;
    int j;
    int i;
    double d;
    null = new av(this.bJO);
    switch (paramMessage.what) {
      case 5:
        if (!StartScreen.n(this.bJO, "com.laiqian.notification.PushService"))
          PushService.r(StartScreen.e(this.bJO), 3); 
        if (StartScreen.f(this.bJO))
          StartScreen.n(StartScreen.e(this.bJO), "com.laiqian.callinnotice.CallInNoticeService"); 
        if (StartScreen.g(this.bJO) && !StartScreen.n(StartScreen.e(this.bJO), "com.laiqian.calloutnotice.CallOutService"))
          bb.e("StartScreen", "callOutService start in StartScreen"); 
        this.bJO.finish();
        null = new Intent(this.bJO, com.laiqian.login.view.LoginActivity.class);
        this.bJO.startActivity(null);
        this.bJO.overridePendingTransition(2130772008, 2130772009);
        break;
      case 4:
        null = (String)paramMessage.obj;
        stringBuilder = new StringBuilder();
        stringBuilder.append("4---");
        stringBuilder.append(null);
        b.ct(stringBuilder.toString());
        null = null.split(",");
        d = Math.ceil(Double.parseDouble(null[0]));
        i = Integer.valueOf(null[1]).intValue();
        j = Integer.valueOf(null[2]).intValue();
        textView = StartScreen.d(this.bJO);
        stringBuilder = new StringBuilder();
        stringBuilder.append(Double.valueOf(d));
        stringBuilder.append("%(");
        stringBuilder.append(i);
        stringBuilder.append(" / ");
        stringBuilder.append(j);
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        break;
      case 3:
        StartScreen.d(this.bJO).setText(this.bJO.getString(2131624107));
        StartScreen.d(this.bJO).setVisibility(0);
        break;
      case 2:
        b.ct("<------SUPGRADEDSUCCESSMESSAGE----->");
        StartScreen.d(this.bJO).setText(this.bJO.getString(2131624106));
        StartScreen.d(this.bJO).setVisibility(8);
        if ((new a.a()).ams()) {
          b.ct("升级后第一次启动自动交接班成功");
        } else {
          b.ct("升级后第一次启动自动交接班失败");
        } 
        this.bJO.bJL.obtainMessage(0).sendToTarget();
        break;
      case 1:
        StartScreen.d(this.bJO).setText(this.bJO.getString(2131624105));
        StartScreen.d(this.bJO).setVisibility(0);
        StartScreen.a(this.bJO, 10000);
        break;
      case 0:
        StartScreen.a(this.bJO);
        StartScreen.b(this.bJO);
        if (textView.awd()) {
          StartScreen.c(this.bJO);
          textView.hW(false);
          break;
        } 
        message = this.bJO.bJL.obtainMessage();
        message.what = 5;
        this.bJO.bJL.sendMessageDelayed(message, 1000L);
        break;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */