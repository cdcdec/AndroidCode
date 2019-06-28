package com.laiqian.milestone;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.ActivityRoot;

public class about_laiqian extends ActivityRoot {
  private static String bJz = "apk_version";
  
  View.OnClickListener aDd = new f(this);
  
  static  {
  
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427355);
    getWindow().setFeatureInt(7, 2131428168);
    ((TextView)findViewById(2131299889)).setText(getString(2131625544));
    TextView textView = (TextView)findViewById(2131296300);
    String str = "1.89";
    try {
      String str1 = (getPackageManager().getPackageInfo(getPackageName(), 0)).versionName;
      str = str1;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      a.e(nameNotFoundException);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("v");
    stringBuilder.append(str);
    textView.setText(stringBuilder.toString());
    ((Button)findViewById(2131299879)).setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\about_laiqian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */