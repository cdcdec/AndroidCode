package com.laiqian.ui;

import android.os.Handler;
import android.os.Message;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;

class j extends Handler {
  j(MagicTextView paramMagicTextView) {}
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 2:
        MagicTextView.access$600(this.dwj, paramMessage.arg1);
        return;
      case 1:
        break;
    } 
    if (Math.abs(MagicTextView.access$000(this.dwj) * MagicTextView.access$100(this.dwj)) < Math.abs(MagicTextView.access$200(this.dwj)) && MagicTextView.access$300(this.dwj) > 0.0D) {
      MagicTextView.access$402(this.dwj, true);
      MagicTextView magicTextView1 = this.dwj;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(RootApplication.zA());
      stringBuilder1.append(this.dwj.fnum.format(MagicTextView.access$100(this.dwj)));
      magicTextView1.setText(stringBuilder1.toString());
      MagicTextView.access$102(this.dwj, MagicTextView.access$100(this.dwj) + MagicTextView.access$300(this.dwj) * MagicTextView.access$000(this.dwj));
      MagicTextView.access$500(this.dwj).sendEmptyMessageDelayed(1, 40L);
      return;
    } 
    MagicTextView.access$402(this.dwj, false);
    MagicTextView magicTextView = this.dwj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(n.pk(this.dwj.fnum.format(MagicTextView.access$200(this.dwj))));
    magicTextView.setText(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */