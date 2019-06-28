package com.laiqian.print.a;

import com.google.a.a.a.a.a.a;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b {
  ExecutorService adJ = Executors.newSingleThreadExecutor();
  
  ArrayList<a> cEW = new ArrayList();
  
  boolean cEX = false;
  
  private a cEY;
  
  private boolean cEZ = false;
  
  int currentIndex = 0;
  
  private void afx() {
    this.currentIndex++;
    if (this.currentIndex < this.cEW.size()) {
      if (this.cEX) {
        hV(this.currentIndex);
        return;
      } 
    } else {
      this.cEX = false;
      xx();
    } 
  }
  
  private void hV(int paramInt) {
    if (paramInt < this.cEW.size())
      this.adJ.submit(new b(this, (a)this.cEW.get(this.currentIndex))); 
  }
  
  private void onStart() {
    if (this.cEY != null)
      this.cEY.onStart(); 
  }
  
  private void onStop() {
    if (this.cEY != null)
      this.cEY.onStop(); 
  }
  
  private void xx() {
    if (this.cEY != null)
      this.cEY.xx(); 
  }
  
  public void a(a parama) { this.cEW.add(parama); }
  
  public void a(a parama) { this.cEY = parama; }
  
  public void fz(boolean paramBoolean) { this.cEZ = paramBoolean; }
  
  public void start() {
    onStart();
    if (this.currentIndex < this.cEW.size()) {
      this.cEX = true;
      hV(this.currentIndex);
      return;
    } 
    this.cEX = false;
    onStop();
  }
  
  public void stop() {
    this.cEX = false;
    this.currentIndex = 0;
    onStop();
  }
  
  public static interface a {
    void onStart();
    
    void onStop();
    
    void xx();
  }
  
  private class b implements Runnable {
    a cFa;
    
    public b(b this$0, a param1a) { this.cFa = param1a; }
    
    public void run() {
      try {
        this.cFa.run();
      } catch (Exception exception) {
        a.e(exception);
        this.cFa.la(exception.getMessage());
        this.cFa.onError();
      } 
      if ((this.cFa.aft()).state == 3 && b.a(this.cFb))
        return; 
      b.b(this.cFb);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */