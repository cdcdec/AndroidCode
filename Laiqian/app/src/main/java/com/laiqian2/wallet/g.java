package com.laiqian.wallet;

import android.os.Handler;
import android.os.Message;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

class g extends Handler {
  g(BindingAlipay paramBindingAlipay) {}
  
  public void handleMessage(Message paramMessage) {
    TranslateAnimation translateAnimation;
    switch (paramMessage.what) {
      default:
        return;
      case 2:
        this.dKY.finish();
        return;
      case 1:
        BindingAlipay.n(this.dKY).setVisibility(0);
        translateAnimation = new TranslateAnimation((this.dKY.getResources().getDisplayMetrics()).widthPixels, 0.0F, 0.0F, 0.0F);
        translateAnimation.setDuration(300L);
        BindingAlipay.n(this.dKY).startAnimation(translateAnimation);
        return;
      case -1:
        textView = BindingAlipay.o(this.dKY);
        stringBuilder = new StringBuilder();
        stringBuilder.append(translateAnimation.obj);
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        BindingAlipay.a(this.dKY).setVisibility(8);
        BindingAlipay.b(this.dKY).setText(R.string.pos_wallet_reflect_verification);
        return;
      case -2:
        break;
    } 
    TextView textView = BindingAlipay.p(this.dKY);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(translateAnimation.obj);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    BindingAlipay.i(this.dKY).setVisibility(8);
    BindingAlipay.j(this.dKY).setVisibility(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */