package com.laiqian.util;

import android.content.Context;
import android.media.MediaPlayer;

public class bq {
  private static MediaPlayer dGn;
  
  private Context context;
  
  static  {
  
  }
  
  public bq(Context paramContext) { this.context = paramContext; }
  
  private void close() {
    if (dGn != null) {
      dGn.stop();
      dGn.release();
      dGn = null;
    } 
  }
  
  public void mi(int paramInt) {
    if (dGn != null) {
      dGn.reset();
      dGn.release();
      dGn = null;
    } 
    try {
      dGn = MediaPlayer.create(this.context, paramInt);
      dGn.setOnCompletionListener(new br(this));
      dGn.start();
      return;
    } catch (Exception exception) {
      close();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */