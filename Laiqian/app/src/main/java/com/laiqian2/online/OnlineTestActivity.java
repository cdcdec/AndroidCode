package com.laiqian.online;

import android.app.Activity;
import android.os.Bundle;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bb;

public class OnlineTestActivity extends Activity {
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_online_test);
    String str = (new a(this)).C("", "", "");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("encryped params is: ");
    stringBuilder.append(str);
    bb.fU(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\online\OnlineTestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */