package com.laiqian.meituan.test;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

class l extends Handler {
  l(h paramh) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    null = this.bsm;
    null.bsh += paramMessage.arg1;
    null = this.bsm;
    null.count++;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bsm.count);
    stringBuilder.append("");
    Log.e("count", stringBuilder.toString());
    if (!TextUtils.isEmpty(String.valueOf(paramMessage.obj)) && !"-1".equals(String.valueOf(paramMessage.obj))) {
      TextView textView = this.bsm.brY;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.bsm.brY.getText().toString());
      stringBuilder1.append(paramMessage.obj);
      textView.setText(stringBuilder1.toString());
    } 
    if (this.bsm.count == this.bsm.bsd) {
      this.bsm.bsi = this.bsm.bsh / this.bsm.bsd;
      TextView textView = this.bsm.bqW;
      stringBuilder = new StringBuilder();
      stringBuilder.append("请求平均时长为:");
      stringBuilder.append(this.bsm.bsi);
      textView.setText(stringBuilder.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\test\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */