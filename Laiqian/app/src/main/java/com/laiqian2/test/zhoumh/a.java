package com.laiqian.test.zhoumh;

import android.view.View;
import android.widget.AdapterView;

class a implements AdapterView.OnItemSelectedListener {
  a(testDownLoadUpdateActivity paramtestDownLoadUpdateActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    String str = paramAdapterView.getItemAtPosition(paramInt).toString();
    testDownLoadUpdateActivity.a(this.dvD, str);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\test\zhoumh\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */