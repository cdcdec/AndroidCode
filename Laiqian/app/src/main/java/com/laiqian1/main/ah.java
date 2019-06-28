package com.laiqian.main;

import android.content.Intent;
import com.laiqian.entity.j;
import com.laiqian.ui.a.r;

class ah implements r.a {
  ah(PosActivity paramPosActivity, j paramj) {}
  
  public void xD() {}
  
  public void xE() {
    Intent intent = new Intent(this.baU, com.laiqian.ui.webview.SimpleWebViewActivity.class);
    intent.putExtra("url", this.baY.getUrl());
    intent.putExtra("title", this.baY.Fa());
    this.baU.getActivity().startActivity(intent);
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */