package com.laiqian.print.cardreader;

class ab implements Runnable {
  ab(CardReaderSearchActivity paramCardReaderSearchActivity, ah paramah) {}
  
  public void run() {
    if (CardReaderSearchActivity.d(this.cEE).getVisibility() != 0)
      CardReaderSearchActivity.d(this.cEE).setVisibility(0); 
    CardReaderSearchActivity.b b = new CardReaderSearchActivity.b(this.cEE, false);
    b.S(CardReaderSearchActivity.c(this.cEE).inflate(2131427693, null));
    b.c(this.cEG);
    CardReaderSearchActivity.b(this.cEE, b.getView());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */