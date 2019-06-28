package com.laiqian.news;

import android.view.View;

class f implements View.OnClickListener {
  f(NewsActivity paramNewsActivity) {}
  
  public void onClick(View paramView) {
    if ((NewsActivity.g(this.bWC).WU()).bXb.aTU < 3) {
      NewsActivity.a(this.bWC, 0);
      return;
    } 
    NewsActivity.h(this.bWC).i(NewsActivity.g(this.bWC).WU());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */