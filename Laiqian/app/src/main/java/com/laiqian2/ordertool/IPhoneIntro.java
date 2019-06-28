package com.laiqian.ordertool;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;

public class IPhoneIntro extends ActivityRoot {
  View.OnClickListener azO = new c(this);
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427377);
    getWindow().setFeatureInt(7, 2131428168);
    WebView webView = (WebView)findViewById(2131297288);
    webView.loadUrl(getResources().getString(2131625403));
    webView.setWebViewClient(new b(this));
    int i = Build.VERSION.SDK_INT;
    TextView textView = (TextView)findViewById(2131299889);
    Button button1 = (Button)findViewById(2131299879);
    Button button2 = (Button)findViewById(2131299880);
    button1.setVisibility(8);
    button2.setVisibility(8);
    textView.setText(2131625686);
    textView.setOnClickListener(this.azO);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\IPhoneIntro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */