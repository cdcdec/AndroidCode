package com.laiqian.backup;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.laiqian.util.av;

class r implements AdapterView.OnItemSelectedListener {
  r(BackUpSetting paramBackUpSetting) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    TextView textView = BackUpSetting.e(this.aIb);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BackUpSetting.d(this.aIb)[paramInt]);
    stringBuilder.append(this.aIb.aHV);
    textView.setText(stringBuilder.toString());
    av av = new av(this.aIb);
    av.lz(Integer.parseInt(BackUpSetting.d(this.aIb)[paramInt]));
    av.close();
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */