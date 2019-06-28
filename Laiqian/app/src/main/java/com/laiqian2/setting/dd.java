package com.laiqian.setting;

import android.text.TextUtils;
import android.widget.TextView;
import com.laiqian.models.at;
import com.laiqian.models.bf;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.util.Iterator;
import java.util.List;

class dd implements Runnable {
  dd(WeighSettingActivity paramWeighSettingActivity) {}
  
  public void run() {
    null = (new at(this.dnL)).ir((new av(this.dnL)).Tx());
    String str = new StringBuilder();
    Iterator iterator = null.iterator();
    while (iterator.hasNext()) {
      str.append(n.ph(String.valueOf(((bf)iterator.next()).Wx())));
      str.append(this.dnL.getString(2131625055));
      str.append(";");
    } 
    TextView textView = (TextView)WeighSettingActivity.c(this.dnL).findViewById(2131297313);
    if (TextUtils.isEmpty(str.toString())) {
      str = "";
    } else {
      str = str.substring(0, str.toString().lastIndexOf(";"));
    } 
    textView.setText(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */