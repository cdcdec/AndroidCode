package com.laiqian.backup;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.util.av;

class p implements AdapterView.OnItemSelectedListener {
  p(BackUpSetting paramBackUpSetting) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    BackUpSetting.a(this.aIb).setText(this.aIb.aHU[paramInt]);
    av av = new av(this.aIb);
    av.ly(BackUpSetting.b(this.aIb)[paramInt]);
    av.close();
    BackUpSetting.c(this.aIb);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */