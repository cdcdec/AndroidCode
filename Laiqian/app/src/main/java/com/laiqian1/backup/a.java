package com.laiqian.backup;

import android.view.View;
import android.widget.AdapterView;
import java.util.HashMap;

class a implements AdapterView.OnItemSelectedListener {
  a(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    this.aHq.aGT = paramInt;
    this.aHq.aGK = (String)((HashMap)this.aHq.aGI.get(paramInt)).get("path");
    if (BackUpRootActivity.aGD != null)
      BackUpRootActivity.aGD.clear(); 
    BackUpRootActivity.a(this.aHq);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */