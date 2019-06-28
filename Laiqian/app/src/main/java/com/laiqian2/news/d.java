package com.laiqian.news;

class d implements Runnable {
  d(NewsActivity paramNewsActivity) {}
  
  public void run() {
    if (NewsActivity.g(this.bWC).getItemCount() > 0)
      NewsActivity.g(this.bWC).c(0, Integer.valueOf(1)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */