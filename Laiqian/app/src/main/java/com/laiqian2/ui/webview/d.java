package com.laiqian.ui.webview;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class d implements DownloadListener {
  d(PosWebViewLinearLayout paramPosWebViewLinearLayout) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    this.dEh.getContext().startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\webview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */