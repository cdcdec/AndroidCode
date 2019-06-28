package com.laiqian.pos.hold;

import android.content.Context;
import android.media.SoundPool;
import com.laiqian.infrastructure.R;

public class e {
  private static e cnq;
  
  private SoundPool cnr;
  
  private int cns;
  
  private Context context;
  
  private e(Context paramContext) {
    this.context = paramContext;
    init();
  }
  
  public static e aU(Context paramContext) {
    if (cnq == null)
      cnq = new e(paramContext.getApplicationContext()); 
    return cnq;
  }
  
  private void init() {
    this.cnr = new SoundPool(true, 3, false);
    this.cns = this.cnr.load(this.context, R.raw.hold, 1);
  }
  
  public void play() { this.cnr.play(this.cns, 1.0F, 1.0F, 0, 0, 1.0F); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\hold\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */