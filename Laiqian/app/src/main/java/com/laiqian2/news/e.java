package com.laiqian.news;

import android.view.View;

class e implements View.OnClickListener {
  e(NewsActivity paramNewsActivity) {}
  
  public void onClick(View paramView) {
    switch (NewsActivity.a(this.bWC)) {
      default:
        return;
      case 1:
        NewsActivity.h(this.bWC).gr(1);
        return;
      case 0:
        break;
    } 
    NewsActivity.h(this.bWC).gr(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */