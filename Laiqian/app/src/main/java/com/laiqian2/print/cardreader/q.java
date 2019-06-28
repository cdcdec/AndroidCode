package com.laiqian.print.cardreader;

import android.view.View;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;

public class q extends d {
  View cEy = findViewById(2131296939);
  
  public q(ActivityRoot paramActivityRoot) {
    super(paramActivityRoot, 2131427560);
    findViewById(2131296783).setOnClickListener(new r(this));
  }
  
  protected void onStart() {
    super.onStart();
    if (this.cEy != null)
      this.cEy.requestFocus(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */