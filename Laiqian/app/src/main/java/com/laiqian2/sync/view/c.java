package com.laiqian.sync.view;

import android.widget.SeekBar;

class c implements SeekBar.OnSeekBarChangeListener {
  c(SealData paramSealData) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) { SealData.b(this.dpZ, paramInt); }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */