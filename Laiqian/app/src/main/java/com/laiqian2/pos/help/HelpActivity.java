package com.laiqian.pos.help;

import android.os.Bundle;
import android.view.KeyEvent;
import com.laiqian.basic.LQKVersion;
import com.laiqian.c.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.webview.PosWebViewObserveUrlChanged;
import com.laiqian.util.av;

public class HelpActivity extends ActivityRoot {
  private PosWebViewObserveUrlChanged cmN;
  
  private void aav() { (new c(new b(this))).aaw(); }
  
  private void changeTitle(String paramString) {
    if (e.cmU.equals(paramString)) {
      setTitleTextViewHideRightView(getString(2131629600));
      return;
    } 
    if (e.cmW.equals(paramString)) {
      setTitleTextViewHideRightView(getString(2131625450));
      return;
    } 
    if (e.cmX.equals(paramString)) {
      setTitleTextViewHideRightView(getString(2131626455));
      return;
    } 
    if (e.cmY.equals(paramString)) {
      setTitleTextViewHideRightView(getString(2131630510));
      return;
    } 
    if (e.cmZ.equals(paramString)) {
      setTitleTextViewHideRightView(getString(2131623977));
      return;
    } 
    if (e.cna.equals(paramString)) {
      setTitleTextViewHideRightView(getString(2131625760));
      return;
    } 
    setTitleTextViewHideRightView(getString(2131626773));
  }
  
  public boolean beforeCloseActivity() {
    if (this.cmN.canGoBack()) {
      this.cmN.goBack();
      setTitleTextViewHideRightView(getString(2131629600));
      return true;
    } 
    return false;
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427631);
    setTitleTextViewHideRightView(getString(2131629600));
    this.cmN = (PosWebViewObserveUrlChanged)findViewById(2131298991);
    av av = new av(this);
    long l = av.auV();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e.cmU);
    stringBuilder.append("?time=");
    stringBuilder.append(l);
    stringBuilder.append("&product=");
    stringBuilder.append(LQKVersion.zi());
    stringBuilder.append("&shopid=");
    stringBuilder.append(av.Tx());
    stringBuilder.append("&brandid=");
    stringBuilder.append(a.zR().Ao());
    String str = stringBuilder.toString();
    this.cmN.pf(str);
    av.close();
    aav();
    this.cmN.a(new a(this));
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.cmN.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && this.cmN.canGoBack()) {
      this.cmN.goBack();
      setTitleTextViewHideRightView(getString(2131629600));
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\help\HelpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */